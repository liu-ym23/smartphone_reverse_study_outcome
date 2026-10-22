package com.bytedance.crash.upload;

import android.content.Context;
import android.os.FileObserver;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
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
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes2.dex */
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
        File r0 = FileSystemUtils.createDirectory(new File(Global.getRootDirectory(), "network_disaster"));
        File r1 = new File(r0, "networkStatef");
        this.mFile = r1;
        this.mNetStateMap = new ConcurrentHashMap();
        this.mbQuotaPathError = false;
        this.mbUpdatingFile = false;
        final String r2 = r1.getAbsolutePath();     // Catch: Throwable -> L5
        final int r3 = 1032;
        this.mFileObserver = new AnonymousClass1(this, r2, r3);     // Catch: Throwable -> L5
    L7:
        this.mFileLock = new File(r0, "disasterLock");
        return;
    L5:
        th = move-exception;
        NpthLog.e(th);
        goto L7
    }

    static /* synthetic */ boolean access$000(NetworkDisasterManager r0) {
        return r0.mbUpdatingFile;
    }

    static /* synthetic */ boolean access$002(NetworkDisasterManager r0, boolean r1) {
        r0.mbUpdatingFile = r1;
        return r1;
    }

    static /* synthetic */ void access$100(NetworkDisasterManager r0) {
        r0.syncNetworkStateByObserver();
    }

    static /* synthetic */ void access$200(NetworkDisasterManager r0) {
        r0.checkNetworkRestore();
    }

    private void adjustUpdateTime(long r5) {
        monitor-enter(this);
        Iterator<Map.Entry<String, NetState>> r0 = this.mNetStateMap.entrySet().iterator();     // Catch: Throwable -> L12
    L5:
        if (r0.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r1 == null) goto L5;
        ((NetState) ZeusTransformUtils.preCheckCast(r1.getValue(), NetState.class, "com.obric.memorydata.plugin")).setUpdateTime(r5);     // Catch: Throwable -> L12
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

    public static boolean checkDropData(String r1, String r2) {
        NetworkDisasterManager r0 = get();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.checkDropDataInner(r1, r2);
    }

    private boolean checkDropDataInner(String r3, String r4) {
        if (hasDisasterItem() == true) goto L5;
        return false;
    L5:
        if (disableNetDisaster == true) goto L24;
    L16:
        th = move-exception;
        NpthLog.e(th);
        return false;
    L8:
        if (TextUtils.isEmpty(r3) == false) goto L10;
        r3 = MonitorManager.getAppMonitor().getAppId();     // Catch: Throwable -> L16
    L10:
        int r2 = getNetworkState(getNetKeyId(r3, r4));     // Catch: Throwable -> L16
        if (r2 == 4) goto L23;
        if (r2 == 5) goto L23;
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
        HashMap r0 = new HashMap();     // Catch: Throwable -> L25
        Iterator<Map.Entry<String, NetState>> r1 = this.mNetStateMap.entrySet().iterator();     // Catch: Throwable -> L25
    L9:
        if (r1.hasNext() == false) goto L19;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r2 == null) goto L9;
        NetState r3 = (NetState) ZeusTransformUtils.preCheckCast(r2.getValue(), NetState.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r3 == null) goto L9;
        if (getRetreatTimeout(r3) > 0) goto L9;
        r0.put(r3.getAid(), r3.getPath());     // Catch: Throwable -> L25
        goto L9
    L19:
        Iterator r4 = r0.entrySet().iterator();     // Catch: Throwable -> L25
    L20:
        if (r4.hasNext() == false) goto L40;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        syncNetworkStateByNet((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r5.getValue(), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L25
        goto L20
    L40:
        return;
    }

    public static long checkPermission(String r1, URL r2) {
        NetworkDisasterManager r0 = get();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.checkPermissionInner(r1, r2);
    }

    private long checkPermissionInner(String r5, URL r6) {
        long r1 = 0;
        if (hasDisasterItem() == true) goto L5;
    L24:
        return r1;
    L5:
        if (disableNetDisaster == true) goto L24;
        NpthLog.i("Disaster:checkPermission url=" + r6);
    L21:
        th = move-exception;
        NpthLog.e(th);
    L23:
        NpthLog.i("Disaster:checkPermission return timeout=" + r1);
        goto L24
    L9:
        if (TextUtils.isEmpty(r5) == false) goto L12;
        r5 = getQueryParams(r6, "aid");     // Catch: Throwable -> L21
    L12:
        if (TextUtils.isEmpty(r5) == false) goto L15;
        NpthLog.i("Disaster:checkPermission aid==null");     // Catch: Throwable -> L21
        return -1;
    L15:
        NetState r7 = (NetState) ZeusTransformUtils.preCheckCast(this.mNetStateMap.get(getNetKeyId(r5, r6.getPath())), NetState.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r7 != null) goto L19;
        NpthLog.i("Disaster:checkPermission normal");     // Catch: Throwable -> L21
        return 0;
    L19:
        r1 = getRetreatTimeout(r7);     // Catch: Throwable -> L21
        goto L23
    }

    private void clearCacheLog(String r6) {
        NpthLog.i("disaster: clearCacheLog");
        int r1 = 0;
    L3:
        boolean r2 = true;
        r1 = r1 + 1;
        int r3 = lockFile();     // Catch: Throwable -> L14
        if (r3 <= 0) goto L7;
        NpthLog.i("disaster: got flock");     // Catch: Throwable -> L14
        deleteCrashLog(r6);     // Catch: Throwable -> L14
        unlockFile(r3);     // Catch: Throwable -> L14
        goto L9
    L7:
        NpthLog.i("disaster: did not got flock, sleep 500ms and retry");     // Catch: Throwable -> L14
        Thread.sleep(50);     // Catch: Throwable -> L14
    L10:
        if (r2 == false) goto L13;
        if (r1 < 10) goto L3;
        return;
    L13:
        return;
    L9:
        r2 = false;
        goto L10
    }

    public static void deleteCrashLog(String r2) {
    L19:
        th = move-exception;
        NpthLog.e(th);
        return;
    L3:
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        NpthLog.w("deleteCrashLog:" + r2);     // Catch: Throwable -> L19
        if (new URL(NetConfig.getJavaCrashUploadUrl()).getPath().equals(r2) == false) goto L10;
        dropCrashLog(CrashType.JAVA);     // Catch: Throwable -> L19
        CrashType r3 = CrashType.ANR;     // Catch: Throwable -> L19
    L8:
        dropCrashLog(r3);     // Catch: Throwable -> L19
        return;
    L10:
        if (new URL(NetConfig.getLaunchCrashUploadUrl()).getPath().equals(r2) == false) goto L16;
        ResourceMonitor.deleteCrashLog();     // Catch: Throwable -> L19
        File r4 = LogPathConfig.getCoreDumpPath();     // Catch: Throwable -> L19
        if (r4 == null) goto L14;
        FileUtils.deleteFile(r4);     // Catch: Throwable -> L19
    L14:
        r3 = CrashType.LAUNCH;     // Catch: Throwable -> L19
        goto L8
    L16:
        if (new URL(NetConfig.getNativeCrashUploadUrl()).getPath().equals(r2) == false) goto L25;
        r3 = CrashType.NATIVE;     // Catch: Throwable -> L19
        goto L8
    }

    public static void dropCrashLog(CrashType r5) {
        if (r5 != CrashType.JAVA) goto L14;
        List<File> r6 = listFiles(JavaCrashSummary.FILE_NAME);
        if (r6 == null) goto L30;
        ArrayList r0 = new ArrayList();
        Iterator<File> r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L12;
        File r3 = (File) ZeusTransformUtils.preCheckCast(r7.next(), File.class, "com.obric.memorydata.plugin");
        if (new File(r3, Constants.LAUNCH_TAG).exists() == true) goto L8;
        r0.add(r3);
    L12:
        r6 = r0;
    L30:
        if (r6 != null) goto L32;
        return;
    L32:
        if (r6.size() <= 0) goto L58;
        Iterator<File> r8 = r6.iterator();
    L36:
        if (r8.hasNext() == false) goto L59;
        File r1 = (File) ZeusTransformUtils.preCheckCast(r8.next(), File.class, "com.obric.memorydata.plugin");
        if (r1.isFile() == true) goto L36;
        FileUtils.deleteFile(r1);
        goto L36
    L59:
        return;
    L58:
        return;
    L14:
        if (r5 != CrashType.LAUNCH) goto L24;
        r6 = listFiles(JavaCrashSummary.FILE_NAME);
        if (r6 == null) goto L30;
        r0 = new ArrayList();
        Iterator<File> r9 = r6.iterator();
    L19:
        if (r9.hasNext() == false) goto L12;
        File r4 = (File) ZeusTransformUtils.preCheckCast(r9.next(), File.class, "com.obric.memorydata.plugin");
        if (new File(r4, Constants.LAUNCH_TAG).exists() == false) goto L19;
        r0.add(r4);
        goto L19
    L24:
        if (r5 != CrashType.NATIVE) goto L28;
        String r10 = NativeCrashSummary.FILE_NAME;
    L26:
        r6 = listFiles(r10);
        goto L30
    L28:
        if (r5 != CrashType.ANR) goto L41;
        r10 = AnrSummary.FILE_NAME;
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

    public static String getNetKeyId(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L7:
        return "";
    L5:
        if (TextUtils.isEmpty(r2) == true) goto L7;
        return r1 + "_" + r2;
    }

    private int getNetworkState(String r3) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r3) == true) goto L6;
        NetState r4 = (NetState) ZeusTransformUtils.preCheckCast(this.mNetStateMap.get(r3), NetState.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (r4 == null) goto L11;
        int r5 = r4.getStrategy();     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return r5;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L16
        return 0;
    L6:
        monitor-exit(this);     // Catch: Throwable -> L16
        return -1;
    }

    private static String getQueryParams(URL r9, String r10) {
        String r3 = "";
        String r11 = r9.getQuery();     // Catch: Throwable -> L23
        if (r11 != null) goto L6;
    L25:
        return r3;
    L6:
        if (r11.contains("&") == false) goto L25;
        if (r11.contains("=") == false) goto L25;
        String[] r12 = r11.split("&");     // Catch: Throwable -> L23
        int r2 = r12.length;     // Catch: Throwable -> L23
        int r5 = 0;
    L10:
        if (r5 >= r2) goto L25;
        String[] r6 = r12[r5].split("=");     // Catch: Throwable -> L23
        if (r6 == null) goto L22;
        if (r6.length < 2) goto L22;
    L20:
        e = move-exception;
        NpthLog.e(e);     // Catch: Throwable -> L23
        goto L22
    L17:
        if (URLDecoder.decode(r6[0], RpcUtils.CHARSET_UTF8).equals(r10) == false) goto L22;
        r3 = URLDecoder.decode(r6[1], RpcUtils.CHARSET_UTF8);     // Catch: UnsupportedEncodingException -> L20 Throwable -> L23
        NpthLog.i("getQueryParams value = " + r3);     // Catch: UnsupportedEncodingException -> L20 Throwable -> L23
    L22:
        r5 = r5 + 1;
    L23:
        th = move-exception;
        NpthLog.e(th);
        goto L25
    }

    private long getRetreatTime(NetState r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        int r2 = r5.getStrategy();
        if (r2 != 1) goto L9;
        return r5.getDelayTime();
    L9:
        if (r2 == 3) goto L15;
        if (r2 == 4) goto L15;
        if (r2 == 5) goto L15;
        return 0;
    L15:
        return longBackOff(r5.getRetreatCount());
    }

    private long getRetreatTimeout(NetState r9) {
        long r0 = System.currentTimeMillis();
        long r2 = r9.getUpdateTime();
        long r4 = getRetreatTime(r9);
        if (r4 != 0) goto L6;
        return 0;
    L6:
        if (r0 >= r2) goto L8;
        adjustUpdateTime(r0);
        syncNetworkStateToFile();
        r2 = r0;
    L8:
        long r1 = r0 - r2;
        if (r1 < r4) goto L11;
        return 0;
    L11:
        return r4 - r1;
    }

    private boolean hasDisasterItem() {
        if (this.mNetStateMap.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void init() {
        NetworkDisasterManager r0 = get();
        if (r0 == null) goto L9;
        r0.syncNetworkStateFromFile();
        if (r0.hasDisasterItem() == false) goto L7;
        r0.checkDisableDisaster();
        r0.postCheckNetworkRestore();
    L7:
        r0.startObserver();
        return;
    }

    private static List<File> listFiles(final String r7) {
        File r0 = CrashManager.getRootDirectory();
        if (r0 != null) goto L5;
        return null;
    L5:
        File[] r1 = r0.listFiles();
        if (r1 != null) goto L8;
        return null;
    L8:
        ArrayList r2 = new ArrayList();
        int r3 = r1.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L14;
        File r5 = r1[r4];
        if (r5.listFiles(new AnonymousClass3(r7)) == null) goto L12;
        r2.add(r5);
        r4 = r4 + 1;
        goto L9
    L12:
        return null;
    L14:
        return r2;
    }

    private int lockFile() {
        this.mFileLock.createNewFile();     // Catch: Throwable -> L4
        return NativeBridge.fLock(this.mFileLock.getAbsolutePath());
    L4:
        return -1;
    }

    private long longBackOff(int r1) {
        if (r1 > 0) goto L5;
        r1 = 0;
    L5:
        if (r1 <= 6) goto L9;
        return MAX_RETREAT_TIME;
    L9:
        return ((r1 * 5) * 60) * 1000;
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
        if (App.isMainProcess((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L6;
        NpthLog.i("disaster:not main process");
        return;
    L6:
        DefaultWorkThread.post(new AnonymousClass2(this));
    }

    private String readFromFile() {
        NpthLog.i("disaster: readFromFile");
        String r1 = "";
        int r2 = 0;
    L3:
        boolean r3 = true;
        r2 = r2 + 1;
        int r4 = lockFile();     // Catch: Throwable -> L14
        if (r4 <= 0) goto L7;
        NpthLog.i("disaster: read got flock");     // Catch: Throwable -> L14
        r1 = FileUtils.readFile(this.mFile);     // Catch: Throwable -> L14
        unlockFile(r4);     // Catch: Throwable -> L14
        NpthLog.i("disaster: read unlock flock");     // Catch: Throwable -> L14
        goto L9
    L7:
        NpthLog.i("disaster:read did not got flock, sleep 500ms and retry");     // Catch: Throwable -> L14
        Thread.sleep(50);     // Catch: Throwable -> L14
    L10:
        if (r3 == false) goto L13;
        if (r2 < 10) goto L3;
    L13:
        return r1;
    L9:
        r3 = false;
        goto L10
    }

    private static void reportEvent(String r4, String r5, boolean r6, int r7) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r5) == false) goto L8;
        return;
    L8:
        if (r4.equals("2010") == true) goto L23;
        String r1 = getNetKeyId(r4, r5);     // Catch: Throwable -> L18
        String r0 = App.getCurProcessName((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(Global.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L18
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L18
        JSONUtils.put(r2, "path", r1);     // Catch: Throwable -> L18
        if (r6 == false) goto L15;
        String r3 = "exit";
    L14:
        JSONUtils.put(r2, "state", r3);     // Catch: Throwable -> L18
        JSONUtils.put(r2, "strategy", String.valueOf(r7));     // Catch: Throwable -> L18
        JSONUtils.put(r2, "pname", r0);     // Catch: Throwable -> L18
        NpthLog.i("disaster:reportEvent aid=" + r4 + " path=" + r5 + " isRestore" + r6 + " strategy=" + r7);     // Catch: Throwable -> L18
        return;
    L15:
        r3 = "enter";
        goto L14
    L23:
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

    private void restoreNetworkState(String r2) {
        monitor-enter(this);
        if (this.mNetStateMap.containsKey(r2) == false) goto L14;
        this.mNetStateMap.remove(r2);     // Catch: Throwable -> L11
        notifyDisasterState();     // Catch: Throwable -> L11
        syncNetworkStateToFile();     // Catch: Throwable -> L11
    L14:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void setDisableNetDisaster(boolean r0) {
        disableNetDisaster = r0;
    }

    private void setStrategy(String r6, String r7, int r8, long r9, int r11) {
        String r0 = getNetKeyId(r6, r7);
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return;
    L5:
        monitor-enter(this);
        if (r8 == 0) goto L9;
        NetState r2 = (NetState) ZeusTransformUtils.preCheckCast(this.mNetStateMap.get(r0), NetState.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r2 != null) goto L14;
        reportEvent(r6, r7, false, r8);     // Catch: Throwable -> L23
        r2 = new NetState(r6, r7);     // Catch: Throwable -> L23
    L14:
        r2.setStrategy(r8);     // Catch: Throwable -> L23
        r2.setAlogStrategy(r11);     // Catch: Throwable -> L23
        if (r8 != 1) goto L18;
        r2.setDelayTime(r9);     // Catch: Throwable -> L23
    L18:
        if (r8 != 5) goto L20;
        clearCacheLog(r7);     // Catch: Throwable -> L23
    L20:
        r2.setUpdateTime(System.currentTimeMillis());     // Catch: Throwable -> L23
        this.mNetStateMap.put(r0, r2);     // Catch: Throwable -> L23
        notifyDisasterState();     // Catch: Throwable -> L23
        syncNetworkStateToFile();     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);     // Catch: Throwable -> L23
        return;
    L9:
        if (this.mNetStateMap.containsKey(r0) == false) goto L21;
        restoreNetworkState(r0);     // Catch: Throwable -> L23
        reportEvent(r6, r7, true, -1);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    private void startObserver() {
        FileSystemUtils.createNewFile(this.mFile);
        FileObserver r1 = this.mFileObserver;
        if (r1 == null) goto L6;
        r1.startWatching();
        return;
    }

    private void syncNetworkStateByNet(String r4, String r5) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L13:
        NpthLog.w("Disaster:syncNetworkStateByNet aid or path is null");
        return;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L13;
        NpthLog.i("Disaster:syncNetworkStateByNet path=" + r5);
        Response r0 = syncNetworkStateByNetInner(r4, r5);
        NpthLog.i("Disaster:syncNetworkStateByNet rsp=" + r0.toString());
        updateNetworkStateInner(r4, r5, r0);
        if (this.mbQuotaPathError == false) goto L10;
    L11:
        this.mbQuotaPathError = false;
        restoreAllNetworkState();
        NpthLog.i("disaster:syncNetworkStateByNet, quota path error");
        return;
    L10:
        if (r0.errorCode() != 0) goto L11;
    }

    private Response syncNetworkStateByNetInner(String r3, String r4) {
        String r2 = NetConfig.getQuotaStateUrl();
        JSONObject r0 = new JSONObject();
        r0.put("aid", Integer.valueOf(r3));     // Catch: JSONException -> L5
        r0.put("os", LocationInfoConst.SYSTEM);     // Catch: JSONException -> L5
        r0.put("path", r4);     // Catch: JSONException -> L5
        return CrashUploader.getQuotaState(r2, r0.toString());
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
        JSONArray r1 = new JSONArray(readFromFile());     // Catch: Throwable -> L13
        NpthLog.i("Disaster:syncNetworkStateFromFile mJsonArray=" + r1.toString());     // Catch: Throwable -> L13
        int r0 = 0;
    L9:
        if (r0 >= r1.length()) goto L18;
        JSONObject r2 = r1.getJSONObject(r0);     // Catch: Throwable -> L13
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.keys().next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        this.mNetStateMap.put(r3, new NetState(r2.getJSONObject(r3)));     // Catch: Throwable -> L13
        notifyDisasterState();     // Catch: Throwable -> L13
        r0 = r0 + 1;     // Catch: Throwable -> L13
        goto L9
    }

    private void syncNetworkStateToFile() {
        ConcurrentHashMap<String, NetState> r0 = this.mNetStateMap;
        monitor-enter(r0);
        JSONArray r1 = new JSONArray();     // Catch: Throwable -> L22
        Iterator<Map.Entry<String, NetState>> r3 = this.mNetStateMap.entrySet().iterator();     // Catch: Throwable -> L19
    L8:
        if (r3.hasNext() == false) goto L14;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r4 == null) goto L8;
        r1.put(((NetState) ZeusTransformUtils.preCheckCast(r4.getValue(), NetState.class, "com.obric.memorydata.plugin")).toJson());     // Catch: Throwable -> L19
        goto L8
    L14:
        if (r1.length() > 0) goto L17;
        this.mNetStateMap.clear();     // Catch: Throwable -> L19
        notifyDisasterState();     // Catch: Throwable -> L19
        writeToFile(null);     // Catch: Throwable -> L19
        String r2 = "Disaster:syncNetworkStateToFile delete strategy file";
    L16:
        NpthLog.i(r2);     // Catch: Throwable -> L19
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L17:
        writeToFile(r1);     // Catch: Throwable -> L19
        r2 = "Disaster:syncNetworkStateToFile mJsonArray=" + r1.toString();     // Catch: Throwable -> L19
    L19:
        this.mNetStateMap.clear();     // Catch: Throwable -> L22
        notifyDisasterState();     // Catch: Throwable -> L22
        writeToFile(null);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    private void unlockFile(int r1) {
        if (r1 <= 0) goto L5;
        NativeBridge.unFlock(r1);
        return;
    }

    public static int updateNetworkState(URL r4, Response r5) {
        NetworkDisasterManager r0 = get();
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (disableNetDisaster == false) goto L9;
        return 0;
    L9:
        if (r4 == null) goto L19;
        if (r5 == null) goto L19;
        NpthLog.w("Disaster:updateNetworkState url=" + r4);
        String r2 = getQueryParams(r4, "aid");     // Catch: Throwable -> L18
        String r6 = r4.getPath();     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r2) == false) goto L16;
        return -1;
    L16:
        return r0.updateNetworkStateInner(r2, r6, r5);
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
        String r0 = getNetKeyId(r18, r19);     // Catch: Throwable -> L71
        if (TextUtils.isEmpty(r18) == true) goto L68;
        if (TextUtils.isEmpty(r19) == true) goto L68;
        int r9 = 0;
        if (r19.equals(new URL(NetConfig.getApmConfigUrl()).getPath()) == false) goto L16;
        return 0;
    L16:
        NpthLog.w("Disaster:updateNetworkStateInner keyId:" + r0 + " rsp:" + r20.toString());     // Catch: Throwable -> L71
        int r1 = getNetworkState(r0);     // Catch: Throwable -> L71
        int r2 = r20.serverErrorCode();     // Catch: Throwable -> L71
        JSONObject r3 = r20.getServerJson();     // Catch: Throwable -> L71
        long r4 = 0;
        boolean r10 = r19.equals(new URL(NetConfig.getQuotaStateUrl()).getPath());     // Catch: Throwable -> L71
        int r13 = 3;
        if (r2 != 200) goto L54;
        if (r3 != null) goto L21;
        setStrategy(r18, r19, 0, 0, 0);     // Catch: Throwable -> L71
        return 0;
    L21:
        String r5 = r3.optString("message");     // Catch: Throwable -> L71
        String r6 = r3.optString(KEY_REDIRECT);     // Catch: Throwable -> L71
        r4 = r3.optLong(KEY_DELAY);     // Catch: Throwable -> L71
        String r7 = r3.optString(KEY_ALOG_QUOTA);     // Catch: Throwable -> L71
        String r8 = r3.optString(KEY_QUOTA_STATE);     // Catch: Throwable -> L71
        if (r10 == true) goto L28;
        if (TextUtils.isEmpty(r8) == true) goto L28;
        r5 = r8;
    L28:
        if (TextUtils.isEmpty(r5) == false) goto L30;
    L44:
        int r11 = 0;
    L45:
        TextUtils.isEmpty(r6);     // Catch: Throwable -> L71
        if (TextUtils.isEmpty(r7) == false) goto L48;
        int r12 = 0;
        r9 = 0;
    L52:
        r13 = r11;
        r9 = r12;
    L60:
        if (r13 != (-2)) goto L64;
        if (r10 == false) goto L63;
        NpthLog.w("Disaster:quota path error!!!");     // Catch: Throwable -> L71
        this.mbQuotaPathError = true;     // Catch: Throwable -> L71
    L63:
        return r1;
    L64:
        setStrategy(r18, r19, r13, r4, r9);     // Catch: Throwable -> L71
        if (r9 == 0) goto L67;
        setStrategy(r18, new URL(NetConfig.getAlogUploadUrl()).getPath(), r9, r4, r9);     // Catch: Throwable -> L71
    L67:
        return r13;
    L48:
        if (MSG_LONG_ESCAPE.equals(r7) == false) goto L50;
        r12 = 1;
        r9 = 3;
        goto L52
    L50:
        r12 = 1;
        goto L52
    L30:
        if ("success".equals(r5) == true) goto L44;
        if (MSG_LONG_ESCAPE.equals(r5) == false) goto L36;
        r11 = 3;
        goto L45
    L36:
        if (MSG_IGNORE_DATA.equals(r5) == false) goto L39;
    L37:
        r11 = -2;
        goto L45
    L39:
        if (MSG_DROP_DATA.equals(r5) == false) goto L42;
        r11 = 4;
        goto L45
    L42:
        if (MSG_DROP_ALL_DATA.equals(r5) == false) goto L37;
        r11 = 5;
        goto L45
    L54:
        if (500 <= r2) goto L56;
    L58:
        r13 = -2;
    L59:
        r9 = 0;
        goto L60
    L56:
        if (r2 > 600) goto L58;
    L68:
        return -1;
    }

    private void writeToFile(JSONArray r8) {
        NpthLog.i("disaster: writeToFile");
        boolean r2 = true;
        int r3 = 0;
    L3:
        if (r2 == false) goto L20;
        if (r3 >= 20) goto L20;
        r3 = r3 + 1;
        int r4 = lockFile();     // Catch: Throwable -> L22
        if (r4 == (-1)) goto L9;
        NpthLog.i("disaster:write got flock");     // Catch: Throwable -> L22
        this.mbUpdatingFile = true;     // Catch: Throwable -> L22
        FileUtils.safeWriteFile(this.mFile, r8, false);     // Catch: Throwable -> L22
        unlockFile(r4);     // Catch: Throwable -> L22
        NpthLog.i("disaster:write unlock flock");     // Catch: Throwable -> L22
        boolean r5 = true;
        int r6 = 0;
    L12:
        if (this.mbUpdatingFile == false) goto L14;
        NpthLog.i("disaster:waiting 20ms");     // Catch: Throwable -> L22
        Thread.sleep(20);     // Catch: Throwable -> L22
        r6 = r6 + 1;     // Catch: Throwable -> L22
    L16:
        if (r5 == false) goto L19;
        if (r6 < 50) goto L12;
    L14:
        NpthLog.i("disaster: breakout");     // Catch: Throwable -> L22
        r5 = false;
        goto L16
    L9:
        NpthLog.i("disaster:write did not got flock, sleep 50ms and retry");     // Catch: Throwable -> L22
        Thread.sleep(50);     // Catch: Throwable -> L22
        r2 = true;
    L19:
        r2 = false;
    L20:
        this.mbUpdatingFile = false;
    }
}
