package com.ss.bduploader;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.boringssl.so.a;
import com.ss.bduploader.logupload.VideoEventEngineUploader;
import com.ss.bduploader.net.BDUploadThreadPool;
import com.ss.bduploader.util.BDUrlDispatchInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class BDUploadUtil {
    public static String DiskResumeConfigDir = "DiskResumeConfigDir";
    public static String RetryStatesInfoDir = "RetryStatesInfoDir";
    public static String SpeedTestcontextDir = "SpeedTestcontextDir";
    private static final int UPDATE_PEROID = 300000;
    public static VideoEventEngineUploader eventEngineUploader = null;
    public static Boolean mEnableDisaptch = null;
    public static Boolean mEnableNativeLog = null;
    private static volatile boolean mIsLibraryLoaded = false;
    private static volatile boolean mIsXQuicLoaded = false;
    private static final ReentrantLock mLock = null;
    private static volatile BDLibraryLoaderProxy mProxy;
    private static volatile String mServerIP;
    private static volatile long mServerIPTime;
    public static String sdkConfigDir;
    public static BDUrlDispatchInterface urlDispatch;

    static {
        mLock = new ReentrantLock();
        eventEngineUploader = null;
        urlDispatch = null;
        mEnableDisaptch = false;
        mEnableNativeLog = false;
    }

    public BDUploadUtil() {
    }

    static /* synthetic */ String access$002(String r0) {
        mServerIP = r0;
        return r0;
    }

    static /* synthetic */ long access$102(long r0) {
        mServerIPTime = r0;
        return r0;
    }

    public static int createDir(String r4) {
        File r0 = new File(r4);
        if (r0.exists() == false) goto L7;
        Log.v("ttmn", r4 + " has already exists");
        return 1;
    L7:
        if (r4.endsWith(File.separator) == true) goto L10;
        r4 = r4 + File.separator;
    L10:
        if (r0.mkdirs() == false) goto L13;
        Log.d("ttmn", r4 + "create success");
        return 1;
    L13:
        Log.e("ttmn", r4 + " failed");
        return -1;
    }

    public static synchronized String getDNSServerIP() {
        monitor-enter(BDUploadUtil.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if ((SystemClock.elapsedRealtime() - mServerIPTime) < 300000) goto L7;
        BDUploadThreadPool.addExecuteTask($$Lambda$BDUploadUtil$4pkf13Szpl7y2veI8YEW6u5PXZA.INSTANCE);     // Catch: Throwable -> L10
    L7:
        String r1 = mServerIP;     // Catch: Throwable -> L10
        monitor-exit(BDUploadUtil.class);
        return r1;
    }

    public static synchronized boolean initInternal(StringBuffer r4) {
        monitor-enter(BDUploadUtil.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (loadLibrary() == true) goto L9;
        Log.e("ttmn", String.format("proxy library load fail", new Object[0]));     // Catch: Throwable -> L21
        monitor-exit(BDUploadUtil.class);
        return false;
    L9:
        Log.d("ttmn", "use defaullt loadLibrary()");     // Catch: Throwable -> L21
        if (mProxy == null) goto L12;
        boolean r1 = true;
    L14:
        if (systemLoadInit(r1, r4) == 1) goto L18;
        Log.e("ttmn", String.format("library has not been loaded", new Object[0]));     // Catch: Throwable -> L21
        monitor-exit(BDUploadUtil.class);
        return false;
    L18:
        Log.d("ttmn", "init()");     // Catch: Throwable -> L21
        monitor-exit(BDUploadUtil.class);
        return true;
    L12:
        r1 = false;
        goto L14
    }

    public static Map<String, String> jsonToHashMap(JSONObject r4) {
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r4.keys();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r2 = String.valueOf(r1.next());
        r0.put(r2, r4.optString(r2));
        goto L4
    L6:
        return r0;
    }

    static /* synthetic */ void lambda$getDNSServerIP$0() {
        InetAddress r0 = InetAddress.getByName("whoami.akamai.net");     // Catch: UnknownHostException -> L6
        if (r0 == null) goto L9;
        mServerIP = r0.getHostAddress();     // Catch: UnknownHostException -> L6
        mServerIPTime = SystemClock.elapsedRealtime();     // Catch: UnknownHostException -> L6
        return;
    L9:
        return;
    }

    private static boolean loadLibrary() {
        boolean r1 = true;
        if (mProxy != null) goto L6;
        return true;
    L6:
        if (mProxy == null) goto L27;
        if (mIsLibraryLoaded == true) goto L27;
        boolean r0 = a.a();
        boolean r2 = mProxy.loadLibrary("ttopenssl");
        if (r0 == true) goto L14;
        if (r2 == true) goto L14;
        boolean r3 = false;
    L15:
        mProxy.loadLibrary("vcn");
        mProxy.loadLibrary("vcnverify");
        boolean r4 = mProxy.loadLibrary("xquic");
        boolean r5 = mProxy.loadLibrary("xquicclient");
        boolean r6 = mProxy.loadLibrary("bdvideouploader");
        if (r4 == false) goto L19;
        if (r5 == false) goto L19;
        boolean r7 = true;
    L20:
        mIsXQuicLoaded = r7;
        if (r3 == false) goto L24;
        if (r6 == false) goto L24;
    L25:
        mIsLibraryLoaded = r1;
    L24:
        r1 = false;
    L19:
        r7 = false;
    L14:
        r3 = true;
    L27:
        return mIsLibraryLoaded;
    }

    private static boolean loadVcn() {
        if (com.ss.mediakit.vcnlib.a.a() == true) goto L6;
        Log.e("ttmn", "Can't load vcn");
    L6:
        if (com.ss.mediakit.vcnlib.a.b() == true) goto L10;
        Log.e("ttmn", "Can't load vcn verify");
        return true;
    L10:
        return true;
    }

    public static JSONObject mapToJSON(Map<String, Object> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L17;
        return null;
    L17:
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L14
        Iterator r3 = r8.keySet().iterator();     // Catch: Exception -> L14
    L7:
        if (r3.hasNext() == false) goto L13;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        Object r5 = r8.get(r4);     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r4) == true) goto L7;
        r2.put(r4, r5);     // Catch: Exception -> L14
        goto L7
    L13:
        return r2;
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String mapToString(Map<String, Object> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L15;
        return null;
    L15:
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L14
        Iterator r3 = r8.keySet().iterator();     // Catch: Exception -> L14
    L7:
        if (r3.hasNext() == false) goto L12;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        Object r5 = r8.get(r4);     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r4) == true) goto L7;
        r2.put(r4, r5);     // Catch: Exception -> L14
        goto L7
    L12:
        return r2.toString();
    L14:
        return null;
    }

    public static void setDispatchImp(BDUrlDispatchInterface r2) {
        urlDispatch = (BDUrlDispatchInterface) ZeusTransformUtils.wrapperContextForParams(r2, BDUrlDispatchInterface.class, "com.obric.memorydata.plugin");
    }

    public static void setEnableDispatch(Boolean r0) {
        mEnableDisaptch = r0;
    }

    public static void setEnableNativeLog(Boolean r0) {
        mEnableNativeLog = r0;
    }

    public static void setLoadProxy(BDLibraryLoaderProxy r2) {
        BDLibraryLoaderProxy r3 = (BDLibraryLoaderProxy) ZeusTransformUtils.wrapperContextForParams(r2, BDLibraryLoaderProxy.class, "com.obric.memorydata.plugin");
        ReentrantLock r0 = mLock;
        r0.lock();
        if (r3 != null) goto L11;
    L9:
        r0.unlock();
        return;
    L11:
        mProxy = r3;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        mLock.unlock();
        throw th;
    }

    public static void setSDKConfigDir(String r1) {
        String r0 = sdkConfigDir;
        if (r0 != null) goto L5;
    L7:
        sdkConfigDir = r1;
        return;
    L5:
        if (r0.length() <= 0) goto L7;
    }

    public static void setVideoEventUpload(VideoEventEngineUploader r2) {
        eventEngineUploader = (VideoEventEngineUploader) ZeusTransformUtils.wrapperContextForParams(r2, VideoEventEngineUploader.class, "com.obric.memorydata.plugin");
    }

    private static int systemLoadInit(boolean r5, StringBuffer r6) {
        if (mIsLibraryLoaded == false) goto L6;
        Log.d("ttmn", "had load success");
        return 1;
    L6:
        mIsLibraryLoaded = r5;
        Log.d("ttmn", "mIsLibraryLoaded:" + mIsLibraryLoaded);
        if (mIsLibraryLoaded == true) goto L36;
        if (a.a() == true) goto L12;
        Log.e("ttmn", "load boringssl fail!");
    L12:
        if (com.ss.mediakit.vcnlib.a.a() == true) goto L15;
        Log.e("ttmn", "Can't load vcn");
    L15:
        if (com.ss.mediakit.vcnlib.a.b() == true) goto L17;
        Log.e("ttmn", "Can't load vcn verify");
    L17:
        boolean r7 = false;
        System.loadLibrary("xquic");     // Catch: Throwable -> L20 UnsatisfiedLinkError -> L22
        System.loadLibrary("xquicclient");     // Catch: Throwable -> L20 UnsatisfiedLinkError -> L22
        r7 = true;
    L25:
        mIsXQuicLoaded = r7;
        if (mIsXQuicLoaded == true) goto L40;
        Log.e("ttmn", "Can't load xquic client");
    L40:
        System.loadLibrary("bdvideouploader");     // Catch: Throwable -> L30 UnsatisfiedLinkError -> L32
        mIsLibraryLoaded = true;     // Catch: Throwable -> L30 UnsatisfiedLinkError -> L32
    L32:
        e = move-exception;
        Log.e("ttmn", "Can't load bdvideoUploader library: " + e.toString());
        String r8 = e.toString();
    L34:
        r6.append(r8);
    L30:
        th = move-exception;
        Log.e("ttmn", "other exception when loading bdvideoUploader library: " + th.toString());
        r8 = th.toString();
        goto L34
    L22:
        e = e;
        StringBuilder r3 = new StringBuilder();
        String r4 = "Can't load xquic library: ";
    L24:
        Log.e("ttmn", r3.append(r4).append(e).toString());
    L20:
        e = th;
        r3 = new StringBuilder();
        r4 = "other exception when loading xquic library: ";
    L36:
        if (mIsLibraryLoaded == true) goto L39;
        return -1;
    L39:
        return 1;
    }

    public static synchronized void updateDNSServerIP() {
        monitor-enter(BDUploadUtil.class);
    L12:
        th = move-exception;
        throw th;
    L6:
        if ((SystemClock.elapsedRealtime() - mServerIPTime) >= 300000) goto L9;
        monitor-exit(BDUploadUtil.class);
        return;
    L9:
        new Thread(new AnonymousClass1()).start();     // Catch: Throwable -> L12
        monitor-exit(BDUploadUtil.class);
    }

    public static synchronized boolean xquicAvalilable() {
        monitor-enter(BDUploadUtil.class);
        boolean r1 = mIsXQuicLoaded;     // Catch: Throwable -> L7
        monitor-exit(BDUploadUtil.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
