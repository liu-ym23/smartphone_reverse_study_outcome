package com.bytedance.crash.upload;

import android.os.FileObserver;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.anr.AnrSummary;
import com.bytedance.crash.config.LogPathConfig;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.crash.CustomJavaHandler;
import com.bytedance.crash.crash.JavaCrashHandler;
import com.bytedance.crash.crash.JavaCrashSummary;
import com.bytedance.crash.crash.NativeCrashSummary;
import com.bytedance.crash.dart.DartCrash;
import com.bytedance.crash.event.EnsureDeliverer;
import com.bytedance.crash.game.GameCrash;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.resource.ResourceMonitor;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NetworkDisasterManager {
    static final String KEY_ALOG_QUOTA = "Alog_quota";
    static final String KEY_DELAY = "delay";
    static final String KEY_MESSAGE = "message";
    static final String KEY_QUOTA_STATE = "quota_status";
    static final String KEY_REDIRECT = "redirect";
    static final long MAX_RETREAT_TIME = 1800000;
    static final String MSG_DROP_ALL_DATA = "drop all data";
    static final String MSG_DROP_DATA = "drop data";
    static final String MSG_IGNORE_DATA = "ignore data";
    static final String MSG_LONG_ESCAPE = "long escape";
    static final String MSG_SUCCESS = "success";
    static final int TS_DELAY = 1;
    static final int TS_LONG_ESCAPE = 3;
    static final int TS_LONG_ESCAPE_DROP = 4;
    static final int TS_LONG_ESCAPE_DROP_ALL = 5;
    static final int TS_NORMAL = 0;
    static final int TS_NO_UPDATE = -2;
    static final int TS_UNKNOWN_ERROR = -1;
    private static boolean disableNetDisaster = false;
    private static NetworkDisasterManager obj;
    private final File mFile;
    private File mFileLock;
    private FileObserver mFileObserver;
    private final ConcurrentHashMap<String, NetState> mNetStateMap;
    private boolean mbQuotaPathError;
    private volatile boolean mbUpdatingFile;

    static {
    }

    private NetworkDisasterManager() {
        NpthLog.i("Disaster:init");
        File r10 = FileSystemUtils.createDirectory(new File(Global.getRootDirectory(), "network_disaster"));
        File r11 = new File(r10, "networkStatef");
        this.mFile = r11;
        this.mNetStateMap = new ConcurrentHashMap();
        this.mbQuotaPathError = false;
        this.mbUpdatingFile = false;
        final String r12 = r11.getAbsolutePath();     // Catch: Throwable -> L5
        final int r13 = 1032;
        this.mFileObserver = new AnonymousClass1(this, r12, r13);     // Catch: Throwable -> L5
    L7:
        this.mFileLock = new File(r10, "disasterLock");
        return;
    L5:
        th = move-exception;
        NpthLog.e(th);
        goto L7
    }

    static /* synthetic */ boolean access$000(NetworkDisasterManager r10) {
        return r10.mbUpdatingFile;
    }

    static /* synthetic */ boolean access$002(NetworkDisasterManager r10, boolean r11) {
        r10.mbUpdatingFile = r11;
        return r11;
    }

    static /* synthetic */ void access$100(NetworkDisasterManager r10) {
        r10.syncNetworkStateByObserver();
    }

    static /* synthetic */ void access$200(NetworkDisasterManager r10) {
        r10.checkNetworkRestore();
    }

    private void adjustUpdateTime(long r10) {
        monitor-enter(this);
        Iterator<Map.Entry<String, NetState>> r11 = this.mNetStateMap.entrySet().iterator();     // Catch: Throwable -> L12
    L5:
        if (r11.hasNext() == false) goto L10;
        Map.Entry<String, NetState> r12 = r11.next();     // Catch: Throwable -> L12
        if (r12 == null) goto L5;
        r12.getValue().setUpdateTime(r10);     // Catch: Throwable -> L12
        goto L5
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void checkDisableDisaster() {
        if (disableNetDisaster == false) goto L6;
        NpthLog.i("Disaster:disable network disaster!!!");
        restoreAllNetworkState();
        return;
    }

    public static boolean checkDropData(String r10, String r11) {
        NetworkDisasterManager r12 = get();
        if (r12 != null) goto L7;
        return false;
    L7:
        return r12.checkDropDataInner(r10, r11);
    }

    private boolean checkDropDataInner(String r10, String r11) {
        if (hasDisasterItem() == true) goto L5;
        return false;
    L5:
        if (disableNetDisaster == true) goto L24;
    L16:
        th = move-exception;
        NpthLog.e(th);
        return false;
    L8:
        if (TextUtils.isEmpty(r10) == false) goto L10;
        r10 = MonitorManager.getAppMonitor().getAppId();     // Catch: Throwable -> L16
    L10:
        int r12 = getNetworkState(getNetKeyId(r10, r11));     // Catch: Throwable -> L16
        if (r12 == 4) goto L23;
        if (r12 == 5) goto L23;
        return false;
    L23:
        return true;
    L24:
        return false;
    }

    private void checkNetworkRestore() {
        NpthLog.i("disaster:checkNetworkRestore");
        if (this.mNetStateMap.size() > 0) goto L6;
        return;
    L6:
        HashMap r10 = new HashMap();     // Catch: Throwable -> L24
        Iterator<Map.Entry<String, NetState>> r11 = this.mNetStateMap.entrySet().iterator();     // Catch: Throwable -> L24
    L8:
        if (r11.hasNext() == false) goto L18;
        Map.Entry<String, NetState> r12 = r11.next();     // Catch: Throwable -> L24
        if (r12 == null) goto L8;
        NetState r13 = r12.getValue();     // Catch: Throwable -> L24
        if (r13 == null) goto L8;
        if (getRetreatTimeout(r13) > 0) goto L8;
        r10.put(r13.getAid(), r13.getPath());     // Catch: Throwable -> L24
        goto L8
    L18:
        Iterator r14 = r10.entrySet().iterator();     // Catch: Throwable -> L24
    L19:
        if (r14.hasNext() == false) goto L39;
        Map.Entry r15 = (Map.Entry) r14.next();     // Catch: Throwable -> L24
        syncNetworkStateByNet((String) r15.getKey(), (String) r15.getValue());     // Catch: Throwable -> L24
        goto L19
    L39:
        return;
    }

    public static long checkPermission(String r10, URL r11) {
        NetworkDisasterManager r12 = get();
        if (r12 != null) goto L7;
        return 0;
    L7:
        return r12.checkPermissionInner(r10, r11);
    }

    private long checkPermissionInner(String r10, URL r11) {
        long r12 = 0;
        if (hasDisasterItem() == true) goto L5;
    L24:
        return r12;
    L5:
        if (disableNetDisaster == true) goto L24;
        NpthLog.i("Disaster:checkPermission url=" + r11);
    L21:
        th = move-exception;
        NpthLog.e(th);
    L23:
        NpthLog.i("Disaster:checkPermission return timeout=" + r12);
        goto L24
    L9:
        if (TextUtils.isEmpty(r10) == false) goto L12;
        r10 = getQueryParams(r11, "aid");     // Catch: Throwable -> L21
    L12:
        if (TextUtils.isEmpty(r10) == false) goto L15;
        NpthLog.i("Disaster:checkPermission aid==null");     // Catch: Throwable -> L21
        return -1;
    L15:
        NetState r13 = this.mNetStateMap.get(getNetKeyId(r10, r11.getPath()));     // Catch: Throwable -> L21
        if (r13 != null) goto L19;
        NpthLog.i("Disaster:checkPermission normal");     // Catch: Throwable -> L21
        return 0;
    L19:
        r12 = getRetreatTimeout(r13);     // Catch: Throwable -> L21
        goto L23
    }

    private void clearCacheLog(String r10) {
        NpthLog.i("disaster: clearCacheLog");
        int r11 = 0;
    L3:
        boolean r12 = true;
        r11 = r11 + 1;
        int r13 = lockFile();     // Catch: Throwable -> L14
        if (r13 <= 0) goto L7;
        NpthLog.i("disaster: got flock");     // Catch: Throwable -> L14
        deleteCrashLog(r10);     // Catch: Throwable -> L14
        unlockFile(r13);     // Catch: Throwable -> L14
        goto L9
    L7:
        NpthLog.i("disaster: did not got flock, sleep 500ms and retry");     // Catch: Throwable -> L14
        Thread.sleep(50);     // Catch: Throwable -> L14
    L10:
        if (r12 == false) goto L13;
        if (r11 < 10) goto L3;
        return;
    L13:
        return;
    L9:
        r12 = false;
        goto L10
    }

    public static void deleteCrashLog(String r10) {
    L19:
        th = move-exception;
        NpthLog.e(th);
        return;
    L3:
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        NpthLog.w("deleteCrashLog:" + r10);     // Catch: Throwable -> L19
        if (new URL(NetConfig.getJavaCrashUploadUrl()).getPath().equals(r10) == false) goto L10;
        dropCrashLog(CrashType.JAVA);     // Catch: Throwable -> L19
        CrashType r11 = CrashType.ANR;     // Catch: Throwable -> L19
    L8:
        dropCrashLog(r11);     // Catch: Throwable -> L19
        return;
    L10:
        if (new URL(NetConfig.getLaunchCrashUploadUrl()).getPath().equals(r10) == false) goto L16;
        ResourceMonitor.deleteCrashLog();     // Catch: Throwable -> L19
        File r12 = LogPathConfig.getCoreDumpPath();     // Catch: Throwable -> L19
        if (r12 == null) goto L14;
        FileUtils.deleteFile(r12);     // Catch: Throwable -> L19
    L14:
        r11 = CrashType.LAUNCH;     // Catch: Throwable -> L19
        goto L8
    L16:
        if (new URL(NetConfig.getNativeCrashUploadUrl()).getPath().equals(r10) == false) goto L25;
        r11 = CrashType.NATIVE;     // Catch: Throwable -> L19
        goto L8
    }

    public static void dropCrashLog(CrashType r10) {
        if (r10 != CrashType.JAVA) goto L14;
        List<File> r11 = listFiles(JavaCrashSummary.FILE_NAME);
        if (r11 == null) goto L30;
        ArrayList r12 = new ArrayList();
        Iterator<File> r13 = r11.iterator();
    L8:
        if (r13.hasNext() == false) goto L12;
        File r14 = r13.next();
        if (new File(r14, Constants.LAUNCH_TAG).exists() == true) goto L8;
        r12.add(r14);
    L12:
        r11 = r12;
    L30:
        if (r11 != null) goto L32;
        return;
    L32:
        if (r11.size() <= 0) goto L58;
        Iterator<File> r15 = r11.iterator();
    L36:
        if (r15.hasNext() == false) goto L59;
        File r16 = r15.next();
        if (r16.isFile() == true) goto L36;
        FileUtils.deleteFile(r16);
        goto L36
    L59:
        return;
    L58:
        return;
    L14:
        if (r10 != CrashType.LAUNCH) goto L24;
        r11 = listFiles(JavaCrashSummary.FILE_NAME);
        if (r11 == null) goto L30;
        r12 = new ArrayList();
        Iterator<File> r17 = r11.iterator();
    L19:
        if (r17.hasNext() == false) goto L12;
        File r18 = r17.next();
        if (new File(r18, Constants.LAUNCH_TAG).exists() == false) goto L19;
        r12.add(r18);
        goto L19
    L24:
        if (r10 != CrashType.NATIVE) goto L28;
        String r19 = NativeCrashSummary.FILE_NAME;
    L26:
        r11 = listFiles(r19);
        goto L30
    L28:
        if (r10 != CrashType.ANR) goto L41;
        r19 = AnrSummary.FILE_NAME;
        goto L26
    }

    private static NetworkDisasterManager get() {
        monitor-enter(NetworkDisasterManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (obj != null) goto L7;
        obj = new NetworkDisasterManager();     // Catch: Throwable -> L10
    L7:
        monitor-exit(NetworkDisasterManager.class);     // Catch: Throwable -> L10
        return obj;
    }

    public static String getNetKeyId(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L7:
        return "";
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L7;
        return r10 + "_" + r11;
    }

    private int getNetworkState(String r10) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L6;
        NetState r11 = this.mNetStateMap.get(r10);     // Catch: Throwable -> L16
        if (r11 == null) goto L11;
        int r12 = r11.getStrategy();     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return r12;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L16
        return 0;
    L6:
        monitor-exit(this);     // Catch: Throwable -> L16
        return -1;
    }

    private static String getQueryParams(URL r10, String r11) {
        String r12 = "";
        String r13 = r10.getQuery();     // Catch: Throwable -> L23
        if (r13 != null) goto L6;
    L25:
        return r12;
    L6:
        if (r13.contains("&") == false) goto L25;
        if (r13.contains("=") == false) goto L25;
        String[] r14 = r13.split("&");     // Catch: Throwable -> L23
        int r15 = r14.length;     // Catch: Throwable -> L23
        int r16 = 0;
    L10:
        if (r16 >= r15) goto L25;
        String[] r17 = r14[r16].split("=");     // Catch: Throwable -> L23
        if (r17 == null) goto L22;
        if (r17.length < 2) goto L22;
    L20:
        e = move-exception;
        NpthLog.e(e);     // Catch: Throwable -> L23
        goto L22
    L17:
        if (URLDecoder.decode(r17[0], "UTF-8").equals(r11) == false) goto L22;
        r12 = URLDecoder.decode(r17[1], "UTF-8");     // Catch: UnsupportedEncodingException -> L20 Throwable -> L23
        NpthLog.i("getQueryParams value = " + r12);     // Catch: UnsupportedEncodingException -> L20 Throwable -> L23
    L22:
        r16 = r16 + 1;
    L23:
        th = move-exception;
        NpthLog.e(th);
        goto L25
    }

    private long getRetreatTime(NetState r10) {
        if (r10 != null) goto L5;
        return 0;
    L5:
        int r11 = r10.getStrategy();
        if (r11 != 1) goto L9;
        return r10.getDelayTime();
    L9:
        if (r11 == 3) goto L15;
        if (r11 == 4) goto L15;
        if (r11 == 5) goto L15;
        return 0;
    L15:
        return longBackOff(r10.getRetreatCount());
    }

    private long getRetreatTimeout(NetState r10) {
        long r11 = System.currentTimeMillis();
        long r12 = r10.getUpdateTime();
        long r13 = getRetreatTime(r10);
        if (r13 != 0) goto L6;
        return 0;
    L6:
        if (r11 >= r12) goto L8;
        adjustUpdateTime(r11);
        syncNetworkStateToFile();
        r12 = r11;
    L8:
        long r14 = r11 - r12;
        if (r14 < r13) goto L11;
        return 0;
    L11:
        return r13 - r14;
    }

    private boolean hasDisasterItem() {
        if (this.mNetStateMap.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void init() {
        NetworkDisasterManager r10 = get();
        if (r10 == null) goto L9;
        r10.syncNetworkStateFromFile();
        if (r10.hasDisasterItem() == false) goto L7;
        r10.checkDisableDisaster();
        r10.postCheckNetworkRestore();
    L7:
        r10.startObserver();
        return;
    }

    private static List<File> listFiles(final String r10) {
        File r11 = CrashManager.getRootDirectory();
        if (r11 != null) goto L5;
        return null;
    L5:
        File[] r12 = r11.listFiles();
        if (r12 != null) goto L8;
        return null;
    L8:
        ArrayList r13 = new ArrayList();
        int r14 = r12.length;
        int r15 = 0;
    L9:
        if (r15 >= r14) goto L14;
        File r16 = r12[r15];
        if (r16.listFiles(new AnonymousClass3(r10)) == null) goto L12;
        r13.add(r16);
        r15 = r15 + 1;
        goto L9
    L12:
        return null;
    L14:
        return r13;
    }

    private int lockFile() {
        this.mFileLock.createNewFile();     // Catch: Throwable -> L4
        return NativeBridge.fLock(this.mFileLock.getAbsolutePath());
    L4:
        return -1;
    }

    private long longBackOff(int r10) {
        if (r10 > 0) goto L5;
        r10 = 0;
    L5:
        if (r10 <= 6) goto L9;
        return MAX_RETREAT_TIME;
    L9:
        return ((r10 * 5) * 60) * 1000;
    }

    private void notifyDisasterState() {
        if (checkDropData(null, NetConfig.PATH_JAVA_CRASH) == false) goto L5;
        AnrManager.setDropData(true);
        JavaCrashHandler.setDropData(true);
        CustomJavaHandler.setDropData(true);
        GameCrash.setDropData(true);
        DartCrash.setDropData(true);
    L6:
        EnsureDeliverer.setDropData(checkDropData(null, "/monitor/collect/c/exception"));
        NativeBridge.setDropDataState(checkDropData(null, NetConfig.PATH_NATIVE_CRASH) ? 1 : 0);
        return;
    L5:
        AnrManager.setDropData(false);
        CustomJavaHandler.setDropData(false);
        GameCrash.setDropData(false);
        DartCrash.setDropData(false);
        JavaCrashHandler.setDropData(false);
        goto L6
    }

    private void postCheckNetworkRestore() {
        if (App.isMainProcess(Global.getContext()) == true) goto L6;
        NpthLog.i("disaster:not main process");
        return;
    L6:
        DefaultWorkThread.post(new AnonymousClass2(this));
    }

    private String readFromFile() {
        NpthLog.i("disaster: readFromFile");
        String r10 = "";
        int r11 = 0;
    L3:
        boolean r12 = true;
        r11 = r11 + 1;
        int r13 = lockFile();     // Catch: Throwable -> L14
        if (r13 <= 0) goto L7;
        NpthLog.i("disaster: read got flock");     // Catch: Throwable -> L14
        r10 = FileUtils.readFile(this.mFile);     // Catch: Throwable -> L14
        unlockFile(r13);     // Catch: Throwable -> L14
        NpthLog.i("disaster: read unlock flock");     // Catch: Throwable -> L14
        goto L9
    L7:
        NpthLog.i("disaster:read did not got flock, sleep 500ms and retry");     // Catch: Throwable -> L14
        Thread.sleep(50);     // Catch: Throwable -> L14
    L10:
        if (r12 == false) goto L13;
        if (r11 < 10) goto L3;
    L13:
        return r10;
    L9:
        r12 = false;
        goto L10
    }

    private static void reportEvent(String r10, String r11, boolean r12, int r13) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r11) == false) goto L7;
        return;
    L7:
        if (r10.equals("2010") == true) goto L22;
        String r14 = getNetKeyId(r10, r11);     // Catch: Throwable -> L17
        String r15 = App.getCurProcessName(Global.getContext());     // Catch: Throwable -> L17
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L17
        JSONUtils.put(r16, "path", r14);     // Catch: Throwable -> L17
        if (r12 == false) goto L14;
        String r17 = "exit";
    L13:
        JSONUtils.put(r16, "state", r17);     // Catch: Throwable -> L17
        JSONUtils.put(r16, "strategy", String.valueOf(r13));     // Catch: Throwable -> L17
        JSONUtils.put(r16, "pname", r15);     // Catch: Throwable -> L17
        NpthLog.i("disaster:reportEvent aid=" + r10 + " path=" + r11 + " isRestore" + r12 + " strategy=" + r13);     // Catch: Throwable -> L17
        return;
    L14:
        r17 = "enter";
        goto L13
    L22:
        return;
    }

    private void restoreAllNetworkState() {
        monitor-enter(this);     // Catch: Throwable -> L12
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
        goto L17
    L4:
        if (this.mNetStateMap.size() <= 0) goto L6;
        this.mNetStateMap.clear();     // Catch: Throwable -> L8
        notifyDisasterState();     // Catch: Throwable -> L8
        syncNetworkStateToFile();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        goto L17
    L11:
        return;
    }

    private void restoreNetworkState(String r10) {
        monitor-enter(this);
        if (this.mNetStateMap.containsKey(r10) == false) goto L14;
        this.mNetStateMap.remove(r10);     // Catch: Throwable -> L11
        notifyDisasterState();     // Catch: Throwable -> L11
        syncNetworkStateToFile();     // Catch: Throwable -> L11
    L14:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void setDisableNetDisaster(boolean r10) {
        disableNetDisaster = r10;
    }

    private void setStrategy(String r10, String r11, int r12, long r13, int r14) {
        String r15 = getNetKeyId(r10, r11);
        if (TextUtils.isEmpty(r15) == false) goto L5;
        return;
    L5:
        monitor-enter(this);
        if (r12 == 0) goto L9;
        NetState r16 = this.mNetStateMap.get(r15);     // Catch: Throwable -> L23
        if (r16 != null) goto L14;
        reportEvent(r10, r11, false, r12);     // Catch: Throwable -> L23
        r16 = new NetState(r10, r11);     // Catch: Throwable -> L23
    L14:
        r16.setStrategy(r12);     // Catch: Throwable -> L23
        r16.setAlogStrategy(r14);     // Catch: Throwable -> L23
        if (r12 != 1) goto L18;
        r16.setDelayTime(r13);     // Catch: Throwable -> L23
    L18:
        if (r12 != 5) goto L20;
        clearCacheLog(r11);     // Catch: Throwable -> L23
    L20:
        r16.setUpdateTime(System.currentTimeMillis());     // Catch: Throwable -> L23
        this.mNetStateMap.put(r15, r16);     // Catch: Throwable -> L23
        notifyDisasterState();     // Catch: Throwable -> L23
        syncNetworkStateToFile();     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);     // Catch: Throwable -> L23
        return;
    L9:
        if (this.mNetStateMap.containsKey(r15) == false) goto L21;
        restoreNetworkState(r15);     // Catch: Throwable -> L23
        reportEvent(r10, r11, true, -1);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    private void startObserver() {
        FileSystemUtils.createNewFile(this.mFile);
        FileObserver r10 = this.mFileObserver;
        if (r10 == null) goto L6;
        r10.startWatching();
        return;
    }

    private void syncNetworkStateByNet(String r10, String r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L13:
        NpthLog.w("Disaster:syncNetworkStateByNet aid or path is null");
        return;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L13;
        NpthLog.i("Disaster:syncNetworkStateByNet path=" + r11);
        Response r12 = syncNetworkStateByNetInner(r10, r11);
        NpthLog.i("Disaster:syncNetworkStateByNet rsp=" + r12.toString());
        updateNetworkStateInner(r10, r11, r12);
        if (this.mbQuotaPathError == false) goto L10;
    L11:
        this.mbQuotaPathError = false;
        restoreAllNetworkState();
        NpthLog.i("disaster:syncNetworkStateByNet, quota path error");
        return;
    L10:
        if (r12.errorCode() != 0) goto L11;
    }

    private Response syncNetworkStateByNetInner(String r10, String r11) {
        String r12 = NetConfig.getQuotaStateUrl();
        JSONObject r13 = new JSONObject();
        r13.put("aid", Integer.valueOf(r10));     // Catch: JSONException -> L5
        r13.put("os", "Android");     // Catch: JSONException -> L5
        r13.put("path", r11);     // Catch: JSONException -> L5
        return CrashUploader.getQuotaState(r12, r13.toString());
    L5:
        e = move-exception;
        NpthLog.e(e);
        return new Response(Constants.UPLOAD_HTTP_ERROR);
    }

    private void syncNetworkStateByObserver() {
        syncNetworkStateFromFile();
    }

    private void syncNetworkStateFromFile() {
    L13:
        th = move-exception;
        this.mNetStateMap.clear();
        notifyDisasterState();
        writeToFile(null);
        NpthLog.e(th);
        return;
    L3:
        if (this.mFile.exists() == true) goto L5;
    L11:
        this.mNetStateMap.clear();     // Catch: Throwable -> L13
        notifyDisasterState();     // Catch: Throwable -> L13
        return;
    L5:
        if (this.mFile.length() == 0) goto L11;
        JSONArray r10 = new JSONArray(readFromFile());     // Catch: Throwable -> L13
        NpthLog.i("Disaster:syncNetworkStateFromFile mJsonArray=" + r10.toString());     // Catch: Throwable -> L13
        int r11 = 0;
    L9:
        if (r11 >= r10.length()) goto L18;
        JSONObject r12 = r10.getJSONObject(r11);     // Catch: Throwable -> L13
        String r13 = r12.keys().next();     // Catch: Throwable -> L13
        this.mNetStateMap.put(r13, new NetState(r12.getJSONObject(r13)));     // Catch: Throwable -> L13
        notifyDisasterState();     // Catch: Throwable -> L13
        r11 = r11 + 1;     // Catch: Throwable -> L13
        goto L9
    }

    private void syncNetworkStateToFile() {
        ConcurrentHashMap<String, NetState> r10 = this.mNetStateMap;
        monitor-enter(r10);
        JSONArray r11 = new JSONArray();     // Catch: Throwable -> L22
        Iterator<Map.Entry<String, NetState>> r12 = this.mNetStateMap.entrySet().iterator();     // Catch: Throwable -> L19
    L8:
        if (r12.hasNext() == false) goto L14;
        Map.Entry<String, NetState> r13 = r12.next();     // Catch: Throwable -> L19
        if (r13 == null) goto L8;
        r11.put(r13.getValue().toJson());     // Catch: Throwable -> L19
        goto L8
    L14:
        if (r11.length() > 0) goto L17;
        this.mNetStateMap.clear();     // Catch: Throwable -> L19
        notifyDisasterState();     // Catch: Throwable -> L19
        writeToFile(null);     // Catch: Throwable -> L19
        String r14 = "Disaster:syncNetworkStateToFile delete strategy file";
    L16:
        NpthLog.i(r14);     // Catch: Throwable -> L19
    L20:
        monitor-exit(r10);     // Catch: Throwable -> L22
        return;
    L17:
        writeToFile(r11);     // Catch: Throwable -> L19
        r14 = "Disaster:syncNetworkStateToFile mJsonArray=" + r11.toString();     // Catch: Throwable -> L19
    L19:
        this.mNetStateMap.clear();     // Catch: Throwable -> L22
        notifyDisasterState();     // Catch: Throwable -> L22
        writeToFile(null);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    private void unlockFile(int r10) {
        if (r10 <= 0) goto L5;
        NativeBridge.unFlock(r10);
        return;
    }

    public static int updateNetworkState(URL r10, Response r11) {
        NetworkDisasterManager r12 = get();
        if (r12 != null) goto L6;
        return 0;
    L6:
        if (disableNetDisaster == false) goto L9;
        return 0;
    L9:
        if (r10 == null) goto L19;
        if (r11 == null) goto L19;
        NpthLog.w("Disaster:updateNetworkState url=" + r10);
        String r13 = getQueryParams(r10, "aid");     // Catch: Throwable -> L18
        String r14 = r10.getPath();     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r13) == false) goto L16;
        return -1;
    L16:
        return r12.updateNetworkStateInner(r13, r14, r11);
    L18:
        return -1;
    L19:
        NpthLog.w("Disaster:updateNetworkState param is invalid");
        return -1;
    }

    private int updateNetworkStateInner(String r18, String r19, Response r20) {
        if (TextUtils.isEmpty(r18) == false) goto L5;
    L69:
        NpthLog.w("Disaster:updateNetworkStateInner param is invalid");
        return -1;
    L5:
        if (TextUtils.isEmpty(r19) == true) goto L69;
        if (r20 == null) goto L69;
        String r10 = getNetKeyId(r18, r19);     // Catch: Throwable -> L71
        if (TextUtils.isEmpty(r18) == true) goto L68;
        if (TextUtils.isEmpty(r19) == true) goto L68;
        int r11 = 0;
        if (r19.equals(new URL(NetConfig.getApmConfigUrl()).getPath()) == false) goto L16;
        return 0;
    L16:
        NpthLog.w("Disaster:updateNetworkStateInner keyId:" + r10 + " rsp:" + r20.toString());     // Catch: Throwable -> L71
        int r12 = getNetworkState(r10);     // Catch: Throwable -> L71
        int r13 = r20.serverErrorCode();     // Catch: Throwable -> L71
        JSONObject r14 = r20.getServerJson();     // Catch: Throwable -> L71
        long r15 = 0;
        boolean r16 = r19.equals(new URL(NetConfig.getQuotaStateUrl()).getPath());     // Catch: Throwable -> L71
        int r17 = 3;
        if (r13 != 200) goto L54;
        if (r14 != null) goto L21;
        setStrategy(r18, r19, 0, 0, 0);     // Catch: Throwable -> L71
        return 0;
    L21:
        String r21 = r14.optString("message");     // Catch: Throwable -> L71
        String r22 = r14.optString(KEY_REDIRECT);     // Catch: Throwable -> L71
        r15 = r14.optLong(KEY_DELAY);     // Catch: Throwable -> L71
        String r23 = r14.optString(KEY_ALOG_QUOTA);     // Catch: Throwable -> L71
        String r24 = r14.optString(KEY_QUOTA_STATE);     // Catch: Throwable -> L71
        if (r16 == true) goto L28;
        if (TextUtils.isEmpty(r24) == true) goto L28;
        r21 = r24;
    L28:
        if (TextUtils.isEmpty(r21) == false) goto L30;
    L44:
        int r25 = 0;
    L45:
        TextUtils.isEmpty(r22);     // Catch: Throwable -> L71
        if (TextUtils.isEmpty(r23) == false) goto L48;
        int r26 = 0;
        r11 = 0;
    L52:
        r17 = r25;
        r11 = r26;
    L60:
        if (r17 != (-2)) goto L64;
        if (r16 == false) goto L63;
        NpthLog.w("Disaster:quota path error!!!");     // Catch: Throwable -> L71
        this.mbQuotaPathError = true;     // Catch: Throwable -> L71
    L63:
        return r12;
    L64:
        setStrategy(r18, r19, r17, r15, r11);     // Catch: Throwable -> L71
        if (r11 == 0) goto L67;
        setStrategy(r18, new URL(NetConfig.getAlogUploadUrl()).getPath(), r11, r15, r11);     // Catch: Throwable -> L71
    L67:
        return r17;
    L48:
        if (MSG_LONG_ESCAPE.equals(r23) == false) goto L50;
        r26 = 1;
        r11 = 3;
        goto L52
    L50:
        r26 = 1;
        goto L52
    L30:
        if ("success".equals(r21) == true) goto L44;
        if (MSG_LONG_ESCAPE.equals(r21) == false) goto L36;
        r25 = 3;
        goto L45
    L36:
        if (MSG_IGNORE_DATA.equals(r21) == false) goto L39;
    L37:
        r25 = -2;
        goto L45
    L39:
        if (MSG_DROP_DATA.equals(r21) == false) goto L42;
        r25 = 4;
        goto L45
    L42:
        if (MSG_DROP_ALL_DATA.equals(r21) == false) goto L37;
        r25 = 5;
        goto L45
    L54:
        if (500 <= r13) goto L56;
    L58:
        r17 = -2;
    L59:
        r11 = 0;
        goto L60
    L56:
        if (r13 > 600) goto L58;
    L68:
        return -1;
    }

    private void writeToFile(JSONArray r10) {
        NpthLog.i("disaster: writeToFile");
        boolean r11 = true;
        int r12 = 0;
    L3:
        if (r11 == false) goto L20;
        if (r12 >= 20) goto L20;
        r12 = r12 + 1;
        int r13 = lockFile();     // Catch: Throwable -> L22
        if (r13 == (-1)) goto L9;
        NpthLog.i("disaster:write got flock");     // Catch: Throwable -> L22
        this.mbUpdatingFile = true;     // Catch: Throwable -> L22
        FileUtils.safeWriteFile(this.mFile, r10, false);     // Catch: Throwable -> L22
        unlockFile(r13);     // Catch: Throwable -> L22
        NpthLog.i("disaster:write unlock flock");     // Catch: Throwable -> L22
        boolean r14 = true;
        int r15 = 0;
    L12:
        if (this.mbUpdatingFile == false) goto L14;
        NpthLog.i("disaster:waiting 20ms");     // Catch: Throwable -> L22
        Thread.sleep(20);     // Catch: Throwable -> L22
        r15 = r15 + 1;     // Catch: Throwable -> L22
    L16:
        if (r14 == false) goto L19;
        if (r15 < 50) goto L12;
    L14:
        NpthLog.i("disaster: breakout");     // Catch: Throwable -> L22
        r14 = false;
        goto L16
    L9:
        NpthLog.i("disaster:write did not got flock, sleep 50ms and retry");     // Catch: Throwable -> L22
        Thread.sleep(50);     // Catch: Throwable -> L22
        r11 = true;
    L19:
        r11 = false;
    L20:
        this.mbUpdatingFile = false;
    }
}
