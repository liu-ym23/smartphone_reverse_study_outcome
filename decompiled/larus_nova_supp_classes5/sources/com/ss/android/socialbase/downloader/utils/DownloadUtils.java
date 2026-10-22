package com.ss.android.socialbase.downloader.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.md5.TTMd5;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.effectmanager.common.EffectRequest;
import el9.a;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import kotlin.KotlinVersion;
import kotlin.UByte;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadUtils {
    public static final int CHUNKED_CONTENT_LENGTH = -1;
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_RANGE = "Content-Range";
    public static final int DEFAULT_MIN_TIME_INTERVAL = 1000;
    public static volatile boolean ENABLE_APP_DOWNLOADER = false;
    public static final String HEADER_TAG_DOWNLOAD_CACHE = "download-tc21-1-15";
    private static final char[] HEX_CHARS = null;
    public static final int MULTI_PROCESS_DB_MODE = 2;
    public static final int MULTI_PROCESS_NORMAL_DB = 4;
    public static final int MULTI_PROCESS_NO_DB_MODE = 1;
    public static final int MULTI_PROCESS_NO_DB_MODE_RESUME_SUPPORTED = 3;
    private static final String TAG = null;
    private static ConnectivityManager connectivityManager;
    private static volatile boolean enableLruCache;
    private static String sCurProcessName;
    private static volatile boolean sEnableDownloadSettingInit;
    private static volatile AtomicInteger sMultiProcessMode;
    private static volatile int sPid;
    private static int sPluginDegradeTimeout;
    private static int sPluginThreadPoolSize;

    public DownloadUtils() {
    }

    public static /* synthetic */ Class access$000(String r0, boolean r1, ClassLoader r2) throws ClassNotFoundException {
        return Class.forName(r0, r1, r2);
    }

    public static boolean isChunkedTask(long r3) {
        if (r3 != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isMd5Valid(int r1) {
        if (r1 != 0) goto L4;
    L7:
        return true;
    L4:
        if (r1 == 2) goto L7;
        return false;
    }

    static {
        TAG = "DownloadUtils";
        ENABLE_APP_DOWNLOADER = true;
        HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        sCurProcessName = null;
        sMultiProcessMode = new AtomicInteger(-1);
        enableLruCache = false;
        sPid = -1;
        sEnableDownloadSettingInit = true;
    }

    private static String getCurProcessNameByActivityThread() {
        String r1 = null;
        Method r2 = INVOKESTATIC_com_ss_android_socialbase_downloader_utils_DownloadUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L14
        r2.setAccessible(true);     // Catch: Throwable -> L14
        Object r3 = r2.invoke(null, new Object[0]);     // Catch: Throwable -> L14
        if ((r3 instanceof String) == false) goto L21;
        String r4 = (String) r3;     // Catch: Throwable -> L14
    L12:
        th = th;
        r1 = r4;
    L15:
        th.printStackTrace();
        return r1;
    L7:
        if (Logger.debug() == false) goto L22;
        if (TextUtils.isEmpty(r4) == true) goto L22;
        Logger.globalDebug(TAG, "getCurProcessNameByActivityThread", "ProcessName: " + r4);     // Catch: Throwable -> L12
    L22:
        return r4;
    L21:
        return null;
    L14:
        th = th;
        goto L15
    }

    private static String getCurProcessNameByApplication() {
        if (Build.VERSION.SDK_INT < 28) goto L16;
        String r1 = Application.getProcessName();     // Catch: Exception -> L10
        if (Logger.debug() == true) goto L7;
    L9:
        return r1;
    L7:
        if (TextUtils.isEmpty(r1) == true) goto L9;
        Logger.globalDebug(TAG, "getCurProcessNameByApplication", "ProcessName: " + r1);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    L16:
        return null;
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader r4 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L14
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L17
    L5:
        int r5 = r4.read();     // Catch: Throwable -> L17
        if (r5 <= 0) goto L9;
        r0.append((char) r5);     // Catch: Throwable -> L17
        goto L5
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.globalDebug(TAG, "getCurProcessNameFromProc", "ProcessName: " + r0.toString());     // Catch: Throwable -> L17
    L11:
        String r1 = r0.toString();     // Catch: Throwable -> L17
        safeClose(new Closeable[]{r4});
        return r1;
    L15:
        safeClose(new Closeable[]{r4});
        return null;
    L14:
        r4 = null;
        goto L15
    }

    public static int getPid() {
        if (sPid != (-1)) goto L6;
        sPid = Process.myPid();
    L6:
        return sPid;
    }

    public static boolean isMultiProcessDBMode() {
        if (sMultiProcessMode.get() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isMultiProcessNoDBMode() {
        if (sMultiProcessMode.get() != 1) goto L5;
        return true;
    L5:
        if (isMultiProcessNoDBModeResumeSupported() == true) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean isMultiProcessNoDBModeResumeSupported() {
        if (sMultiProcessMode.get() != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isMultiProcessNormalDBMode() {
        if (sMultiProcessMode.get() != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isNoWifiAndInNet() {
        Context r0 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (isWifi(r0) == true) goto L9;
        if (isNetworkConnected(r0) == false) goto L9;
        return true;
    }

    public static boolean optimizeMultiProcess() {
        sMultiProcessMode.compareAndSet(-1, 0);
        if (sMultiProcessMode.get() <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static String getDownloadPath() {
        return DownloadDirUtils.getDownloadPath();
    }

    public static boolean isMainThread() {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static int getPluginDegradeTimeout() {
        return sPluginDegradeTimeout;
    }

    public static int getPluginThreadPoolSize() {
        return sPluginThreadPoolSize;
    }

    public static boolean isEnableDownloadSettingInit() {
        return sEnableDownloadSettingInit;
    }

    public static boolean isEnableLruCache() {
        return enableLruCache;
    }

    public static boolean cacheExpired(DownloadInfo r1) {
        return cacheExpiredWithHttp(r1, false);
    }

    public static void clearAntiHijackDir(DownloadInfo r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        DownloadSetting r0 = DownloadSetting.obtain(r3.getId());
        JSONObject r1 = r0.optJSONObject("download_dir");
        if (r1 == null) goto L24;
        String r2 = r1.optString("ins_desc");
        if (TextUtils.isEmpty(r2) == true) goto L9;
        deleteFile(r3.getSavePath(), r2);
    L9:
        String r4 = r3.getTitle();
        if (TextUtils.isEmpty(r4) == false) goto L12;
        r4 = r3.getName();
    L12:
        String r5 = getRedirectSavePath(r4, r0);
        String r6 = r3.getSavePath();
        if (TextUtils.isEmpty(r5) == false) goto L15;
        return;
    L15:
        if (TextUtils.isEmpty(r6) == true) goto L30;
        File r7 = new PolarisFileWrapper(r5);
        File r8 = new PolarisFileWrapper(r6);
    L17:
        if (r7 == null) goto L31;
        if (r8 == null) goto L32;
        if (r8.isDirectory() == false) goto L33;
        if (TextUtils.equals(r7.getName(), r8.getName()) == false) goto L34;
        deleteDirIfEmpty(r8.getPath());
        r7 = r7.getParentFile();
        r8 = r8.getParentFile();
        goto L17
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    }

    public static void deleteAllDownloadFiles(DownloadInfo r1) {
        deleteAllDownloadFiles(r1, true);
    }

    private static boolean deleteDirIfEmpty(String r4) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "deleteDirIfEmpty", "Thread:" + ThreadMethodProxy.currentThread());
    L6:
        if (DownloadFileUtils.getTypeByUri(r4) == 1) goto L8;
    L21:
        return false;
    L8:
        if (DownloadDirUtils.isSavePathSecurity(r4) == false) goto L21;
        if (TextUtils.isEmpty(r4) == true) goto L21;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r4);
        if (r0.isDirectory() == false) goto L21;
        if (r0.delete() == false) goto L17;
        return true;
    L17:
        if (Logger.debug() == false) goto L19;
        Logger.globalDebug(TAG, "deleteDirIfEmpty", "Delete Failed");
    L19:
        return false;
    }

    public static void ensureDirExists(String r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        ensureDirExists(new PolarisFileWrapper(r1));
    }

    public static long getAvailableSpaceBytes(String r2) throws BaseException {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            boolean r0 = com.ss.android.socialbase.downloader.file.DownloadFileUtils.isMediaUri(r2)     // Catch: java.lang.Throwable -> L21 java.lang.IllegalArgumentException -> L2a
            if (r0 == 0) goto L17
            com.bytedance.security.android.aopcheck.PolarisFileWrapper r0 = new com.bytedance.security.android.aopcheck.PolarisFileWrapper     // Catch: java.lang.Throwable -> L21 java.lang.IllegalArgumentException -> L2a
            android.net.Uri r2 = com.bytedance.mt.protector.impl.UriProtector.parse(r2)     // Catch: java.lang.Throwable -> L21 java.lang.IllegalArgumentException -> L2a
            java.lang.String r2 = com.ss.android.socialbase.downloader.file.DownloadFileUtils.getFilePathFromUri(r2)     // Catch: java.lang.Throwable -> L21 java.lang.IllegalArgumentException -> L2a
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L21 java.lang.IllegalArgumentException -> L2a
            java.lang.String r2 = r0.getParent()     // Catch: java.lang.Throwable -> L21 java.lang.IllegalArgumentException -> L2a
        L17:
            android.os.StatFs r0 = new android.os.StatFs     // Catch: java.lang.Throwable -> L21 java.lang.IllegalArgumentException -> L2a
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L21 java.lang.IllegalArgumentException -> L2a
            long r0 = r0.getAvailableBytes()     // Catch: java.lang.Throwable -> L21 java.lang.IllegalArgumentException -> L2a
            return r0
        L21:
            r2 = move-exception
            com.ss.android.socialbase.downloader.exception.BaseException r0 = new com.ss.android.socialbase.downloader.exception.BaseException
            r1 = 1052(0x41c, float:1.474E-42)
            r0.<init>(r1, r2)
            throw r0
        L2a:
            r2 = move-exception
            com.ss.android.socialbase.downloader.exception.BaseException r0 = new com.ss.android.socialbase.downloader.exception.BaseException
            r1 = 1050(0x41a, float:1.471E-42)
            r0.<init>(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.utils.DownloadUtils.getAvailableSpaceBytes(java.lang.String):long");
    }

    public static ConnectivityManager getConnectivityManager(Context r1) {
        ConnectivityManager r0 = connectivityManager;
        if (r0 != null) goto L6;
        ConnectivityManager r2 = (ConnectivityManager) r1.getSystemService("connectivity");
        connectivityManager = r2;
        return r2;
    L6:
        return r0;
    }

    public static long getContentLength(IDownloadHeadHttpConnection r4) {
        if (r4 != null) goto L5;
        return -1;
    L5:
        String r2 = getRespHeadFieldIgnoreCase(r4, CONTENT_LENGTH);
        if (TextUtils.isEmpty(r2) == true) goto L13;
        return CastLongProtector.parseLong(r2);
    L14:
        return -1;
    L13:
        return parseContentLengthFromContentRange(r4);
    }

    public static String getCurProcessName(Context r2) {
        String r0 = sCurProcessName;
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        String r1 = getCurProcessNameByApplication();
        sCurProcessName = r1;
        if (TextUtils.isEmpty(r1) == false) goto L8;
        String r3 = getCurProcessNameByActivityThread();
        sCurProcessName = r3;
        if (TextUtils.isEmpty(r3) == false) goto L12;
        String r4 = getCurProcessNameFromProc();
        sCurProcessName = r4;
        if (TextUtils.isEmpty(r4) == false) goto L16;
        String r5 = getCurProcessNameByActivityManager(r2);
        sCurProcessName = r5;
        return r5;
    L16:
        return sCurProcessName;
    L12:
        return sCurProcessName;
    L8:
        return sCurProcessName;
    }

    private static String getCurProcessNameByActivityManager(Context r5) {
        if (r5 != null) goto L20;
        return null;
    L20:
        int r1 = Process.myPid();     // Catch: Exception -> L17
        ActivityManager r6 = (ActivityManager) r5.getSystemService("activity");     // Catch: Exception -> L17
        if (r6 == null) goto L19;
        Iterator<ActivityManager.RunningAppProcessInfo> r7 = r6.getRunningAppProcesses().iterator();     // Catch: Exception -> L17
    L9:
        if (r7.hasNext() == false) goto L19;
        ActivityManager.RunningAppProcessInfo r2 = r7.next();     // Catch: Exception -> L17
        if (r2.pid != r1) goto L9;
        if (Logger.debug() == false) goto L15;
        Logger.globalDebug(TAG, "getCurProcessNameByActivityManager", "ProcessName: " + r2.processName);     // Catch: Exception -> L17
    L15:
        return r2.processName;
    L19:
        return null;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public static String getEncodedStr(String r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L13;
        char r4 = r6.charAt(r3);
        if (r4 > 31) goto L7;
    L10:
        r0.append(String.format("\\u%04x", new Object[]{Integer.valueOf(r4)}));
    L11:
        r3 = r3 + 1;
        goto L3
    L7:
        if (r4 >= 127) goto L10;
        r0.append(r4);
        goto L11
    L13:
        return r0.toString();
    }

    public static String getLoggerTag(String r0) {
        return Logger.downloaderTag(r0);
    }

    public static String getMd5StatusMsg(int r2) {
        String r0 = "ttmd5 check code = " + r2 + ", ";
        if (r2 == 99) goto L14;
        switch(r2) {
            case 0: goto L21;
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            default: goto L22;
        };
    L22:
        return r0;
    L15:
        return r0 + "get file md5 error";
    L16:
        return r0 + "file not exist";
    L17:
        return r0 + "ttmd5 tag parser error";
    L18:
        return r0 + "ttmd5 version not support";
    L19:
        return r0 + "md5 empty";
    L20:
        return r0 + "md5 not match";
    L21:
        return r0 + "md5 match";
    L14:
        return r0 + "unknown error";
    }

    public static int getNetworkType(Context r2) {
        if (r2 != null) goto L21;
        return 0;
    L21:
        ConnectivityManager r3 = getConnectivityManager(r2);     // Catch: Exception -> L20
        if (r3 != null) goto L8;
        return 0;
    L8:
        NetworkInfo r4 = r3.getActiveNetworkInfo();     // Catch: Exception -> L20
        if (r4 == null) goto L19;
        if (r4.isAvailable() == false) goto L19;
        if (1 != r4.getType()) goto L17;
        return 1;
    L17:
        return 2;
    L19:
        return 0;
    }

    public static long getReportableSpaceMB(long r2) {
        long r0 = 50;
        return ((r2 / DownloadConstants.MB) / r0) * r0;
    }

    public static String getTempFileName(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return null;
    L7:
        return String.format("%s.tp", new Object[]{r2});
    }

    public static String getThrowableMsg(Throwable r0) {
        if (r0 != null) goto L10;
        return "";
    L10:
        return r0.toString();
    L7:
        th = move-exception;
        th.printStackTrace();
        return "throwable getMsg error";
    }

    public static boolean hasDownloadCacheHeader(List<HttpHeader> r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.size() == 0) goto L36;
        Iterator<HttpHeader> r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L37;
        HttpHeader r1 = r5.next();
        if (r1 == null) goto L9;
        if (TextUtils.isEmpty(r1.getName()) == true) goto L9;
        if (TextUtils.isEmpty(r1.getValue()) == true) goto L9;
        if (HEADER_TAG_DOWNLOAD_CACHE.equals(r1.getName()) == false) goto L9;
        if (HEADER_TAG_DOWNLOAD_CACHE.equals(r1.getValue()) == false) goto L9;
        return true;
    L37:
        return false;
    L36:
        return false;
    }

    public static String hexToString(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return null;
    L6:
        int r0 = r5.length() / 2;
        byte[] r1 = new byte[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L19;
        int r3 = r2 * 2;
        r1[r2] = (byte) (CastIntegerProtector.parseInt(r5.substring(r3, r3 + 2), 16) & KotlinVersion.MAX_COMPONENT_VALUE);     // Catch: Exception -> L11
    L13:
        r2 = r2 + 1;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    L19:
        return new String(r1, "utf-8");
    L16:
        e = move-exception;
        e.printStackTrace();
        return r5;
    }

    public static boolean isFileDownloaded(DownloadInfo r2) {
        return isFileDownloaded(r2, r2.isForce(), r2.getMd5());
    }

    public static boolean isInsufficientSpaceError(Throwable r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if ((r5 instanceof BaseException) == false) goto L31;
        BaseException r6 = (BaseException) r5;
        int r1 = r6.getErrorCode();
        if (r1 != 1006) goto L11;
        return true;
    L11:
        if (r1 != 1023) goto L13;
    L22:
        boolean r2 = true;
    L23:
        if (r2 == false) goto L40;
        String r7 = r6.getMessage();
        if (TextUtils.isEmpty(r7) == false) goto L27;
        return false;
    L27:
        if (r7.contains("ENOSPC") == false) goto L39;
        return true;
    L39:
        return false;
    L40:
        return false;
    L13:
        if (r1 == 1039) goto L22;
        if (r1 == 1040) goto L22;
        if (r1 == 1054) goto L22;
        if (r1 == 1064) goto L22;
        r2 = false;
        goto L23
    L31:
        if ((r5 instanceof IOException) == false) goto L41;
        String r8 = getThrowableMsg(r5);
        if (TextUtils.isEmpty(r8) == false) goto L35;
        return false;
    L35:
        if (r8.contains("ENOSPC") == false) goto L43;
        return true;
    L43:
        return false;
    L41:
        return false;
    }

    public static boolean isNetworkConnected(Context r1) {
        NetworkInfo r2 = getConnectivityManager(r1).getActiveNetworkInfo();     // Catch: Exception -> L8
        if (r2 != null) goto L6;
        return false;
    L6:
        return r2.isConnected();
    L8:
        return false;
    }

    public static boolean isNetworkError(Throwable r3) {
        if (r3 != null) goto L5;
    L60:
        return false;
    L5:
        if ((r3 instanceof BaseException) == false) goto L60;
        int r4 = ((BaseException) r3).getErrorCode();
        if (r4 < 2000) goto L13;
        if (r4 >= 3000) goto L13;
        return true;
    L13:
        if (r4 != 1075) goto L15;
    L59:
        return true;
    L15:
        if (r4 == 1078) goto L59;
        if (r4 == 1079) goto L59;
        if (r4 == 1055) goto L59;
        if (r4 == 1023) goto L59;
        if (r4 == 1041) goto L59;
        if (r4 == 1022) goto L59;
        if (r4 == 1048) goto L59;
        if (r4 == 1056) goto L59;
        if (r4 == 1057) goto L59;
        if (r4 == 1058) goto L59;
        if (r4 == 1059) goto L59;
        if (r4 == 1060) goto L59;
        if (r4 == 1061) goto L59;
        if (r4 == 1067) goto L59;
        if (r4 == 1049) goto L59;
        if (r4 == 1047) goto L59;
        if (r4 == 1051) goto L59;
        if (r4 == 1004) goto L59;
        if (r4 == 1011) goto L59;
        if (r4 == 1002) goto L59;
        if (r4 == 1013) goto L59;
        return false;
    }

    public static boolean isProcessNameSame(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return true;
    L5:
        String r0 = getCurProcessName(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext());
        if (r0 != null) goto L8;
        return false;
    L8:
        if (r0.equals(r2) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isResponseCode304Error(Throwable r1) {
        if (((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getTTNetHandler().getResponseCode(r1) != 304) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isWifi(Context r2) {
        NetworkInfo r3 = getConnectivityManager(r2).getActiveNetworkInfo();     // Catch: Exception -> L13
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.isAvailable() == false) goto L17;
        if (1 != r3.getType()) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L19:
        return false;
    }

    public static List<String> jsonStringTolist(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L19;
        return null;
    L19:
        JSONArray r0 = new JSONArray(r5);     // Catch: Exception -> L16
        if (r0.length() > 0) goto L8;
        return null;
    L8:
        ArrayList r6 = new ArrayList();     // Catch: Exception -> L16
        int r2 = 0;
    L10:
        if (r2 >= r0.length()) goto L15;
        String r3 = r0.optString(r2);     // Catch: Exception -> L16
        if (TextUtils.isEmpty(r3) == true) goto L14;
        r6.add(r3);     // Catch: Exception -> L16
    L14:
        r2 = r2 + 1;
        goto L10
    L15:
        return r6;
    L16:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String listToJsonString(List<String> r4) {
        if (r4 != null) goto L5;
    L17:
        return "";
    L5:
        if (r4.isEmpty() == true) goto L17;
        JSONArray r1 = new JSONArray();     // Catch: Exception -> L15
        Iterator<String> r5 = r4.iterator();     // Catch: Exception -> L15
    L9:
        if (r5.hasNext() == false) goto L13;
        String r2 = r5.next();     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r2) == true) goto L9;
        r1.put(r2);     // Catch: Exception -> L15
        goto L9
    L13:
        return r1.toString();
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static String md5Hex(String r3) {
        if (r3 != null) goto L11;
    L9:
        return null;
    L11:
        if (r3.length() == 0) goto L9;
        MessageDigest r1 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L10
        r1.update(r3.getBytes(EffectRequest.DEFAULT_PARAMS_ENCODING));     // Catch: Exception -> L10
        return toHexString(r1.digest());
    }

    public static long parseContentLengthFromContentRange(IDownloadHeadHttpConnection r5) {
        if (r5 != null) goto L5;
        return -1;
    L5:
        String r6 = getRespHeadFieldIgnoreCase(r5, CONTENT_RANGE);
        if (TextUtils.isEmpty(r6) == false) goto L16;
        return -1;
    L16:
        Matcher r7 = PatternProtector.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(r6);     // Catch: Exception -> L13
        if (r7.find() == false) goto L15;
        return (CastLongProtector.parseLong(r7.group(2)) - CastLongProtector.parseLong(r7.group(1))) + 1;
    L15:
        return -1;
    L13:
        e = move-exception;
        Logger.globalError(TAG, "parseContentLengthFromContentRange", "Exception:" + e);
        goto L15
    }

    public static String parseDevicePostfix(String r4) {
    L8:
        e = move-exception;
        e.printStackTrace();
        return "";
    L3:
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return "";
    L5:
        if (TextUtils.isDigitsOnly(r4) == false) goto L15;
        return String.valueOf(CastLongProtector.valueOf(r4).longValue() % 100);
    L15:
        return "";
    }

    public static String parseTTNetIp(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return "";
    L5:
        int r0 = r2.lastIndexOf(":");
        if (r0 > 0) goto L9;
        return "";
    L9:
        return r2.substring(0, r0);
    }

    public static void safeClose(Cursor... r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L14;
        Cursor r2 = r3[r1];
        if (r2 == null) goto L13;
        r2.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
    L13:
        r1 = r1 + 1;
        goto L5
    }

    public static void setEnableDownloadSettingInit(boolean r0) {
        sEnableDownloadSettingInit = r0;
    }

    public static void setEnableLruCache(boolean r0) {
        enableLruCache = r0;
    }

    public static void setPluginDegradeTimeout(int r0) {
        sPluginDegradeTimeout = r0;
    }

    public static void setPluginThreadPoolSize(int r0) {
        sPluginThreadPoolSize = r0;
    }

    public static String toHexString(byte[] r2) {
        if (r2 == null) goto L6;
        return toHexString(r2, 0, r2.length);
    L6:
        throw new NullPointerException("bytes is null");
    }

    private static void ensureDirExists(File r1) {
        if (r1.exists() == true) goto L6;
        r1.mkdirs();
        return;
    }

    public static void safeClose(Closeable... r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        int r0 = r3.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L14;
        Closeable r2 = r3[r1];
        if (r2 == null) goto L13;
        r2.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
    L13:
        r1 = r1 + 1;
        goto L5
    }

    public static boolean cacheExpiredWithHttp(DownloadInfo r9, boolean r10) {
        boolean r3 = false;
        if (r9.isDeleteCacheIfCheckFailed() == true) goto L10;
        if (TextUtils.isEmpty(r9.getLastModified()) == false) goto L10;
        if (Logger.debugScene(r9) == false) goto L18;
        Logger.taskDebug(TAG, r9, "cacheExpiredWithHttp", "Modify is empty, so just return cache");
    L18:
        if (Logger.debugScene(r9) == false) goto L20;
        Logger.taskDebug(TAG, r9, "cacheExpiredWithHttp", "Name=" + r9.getName() + " expired=" + r3);
    L20:
        return r3;
    L10:
        if (Logger.debugScene(r9) == false) goto L13;
        Logger.taskDebug(TAG, r9, "cacheExpiredWithHttp", "Curt=" + System.currentTimeMillis() + " expired=" + r9.getCacheExpiredTime());
    L13:
        if (System.currentTimeMillis() <= r9.getCacheExpiredTime()) goto L15;
    L14:
        r3 = true;
        goto L18
    L15:
        if (r10 == false) goto L18;
        goto L14
    }

    public static boolean checkFileLength(DownloadInfo r5, DownloadFile r6) {
        if (r5.getTotalBytes() > 0) goto L5;
        return true;
    L5:
        if (r6.length() >= r5.getTotalBytes()) goto L10;
        return false;
    L10:
        return true;
    }

    public static int checkMd5Status(DownloadFile r2, String r3) {
        if (r2.isTypeFile() == true) goto L5;
        return TTMd5.checkMd5(r3, r2.getFile(), new DownloadFileRandomAccess(r2.obtainInputStream()));
    L8:
        th = move-exception;
        th.printStackTrace();
        return 5;
    L5:
        return TTMd5.checkMd5(r3, r2.getFile());
    }

    public static boolean checkMd5Valid(DownloadFile r0, String r1) {
        return isMd5Valid(checkMd5Status(r0, r1));
    }

    public static void deleteAllDownloadFiles(DownloadInfo r2, boolean r3) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.isForce() == true) goto L7;
    L9:
        if (r3 == true) goto L26;
    L11:
        deleteFile(r2.getTempPath(), r2.getTempName());     // Catch: Throwable -> L23
        if (r2.isSavePathRedirected() == false) goto L14;
        clearAntiHijackDir(r2);     // Catch: Throwable -> L23
    L14:
        if (r3 == false) goto L28;
        String r4 = md5Hex(r2.getUrl());     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r4) == false) goto L18;
        return;
    L18:
        if (TextUtils.isEmpty(r2.getSavePath()) == false) goto L20;
        return;
    L20:
        if (r2.getSavePath().contains(r4) == false) goto L31;
        deleteDirIfEmpty(r2.getSavePath());     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        th.printStackTrace();
        return;
    L31:
        return;
    L28:
        return;
    L26:
        deleteFile(r2.getSavePath(), r2.getName());     // Catch: Throwable -> L23
        goto L11
    L7:
        if (DownloadDirUtils.isSavePathSecurity(r2.getSavePath()) == true) goto L9;
        r3 = false;
        goto L9
    }

    public static void deleteFile(String r3, String r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L14;
        DownloadFile r0 = new DownloadFile(r3, r4, false, true);
        if (r0.exists() == true) goto L9;
        return;
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.globalDebug(TAG, "deleteFile", "Path: " + r0.getAbsolutePath());
    L11:
        r0.delete();
        return;
    }

    public static String generateDistinctDirectory(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == true) goto L10;
        String r3 = md5Hex(r2);
        if (TextUtils.isEmpty(r3) == false) goto L7;
        return r1;
    L7:
        if (r1.contains(r3) == false) goto L9;
        return r1;
    L9:
        return new PolarisFileWrapper(r1, r3).getAbsolutePath();
    L10:
        return r1;
    }

    public static boolean getBoolean(Object r0, boolean r1) {
        return ((Boolean) r0).booleanValue();
    L4:
        return r1;
    }

    public static String getErrorMsgWithTagPrefix(Throwable r1, String r2) {
        if (r2 != null) goto L6;
        return getThrowableMsg(r1);
    L6:
        return r2 + "-" + getThrowableMsg(r1);
    }

    public static int getInt(Object r0, int r1) {
        return ((Integer) r0).intValue();
    L4:
        return r1;
    }

    public static String getRedirectSavePath(String r2, DownloadSetting r3) {
        if (r3 == null) goto L22;
        JSONObject r4 = r3.optJSONObject("download_dir");
        if (r4 == null) goto L22;
        String r5 = r4.optString("dir_name");
        if (TextUtils.isEmpty(r5) == true) goto L11;
        if (r5.startsWith("/") == false) goto L11;
        r5 = r5.substring(1);
    L11:
        if (TextUtils.isEmpty(r5) == false) goto L13;
        return r5;
    L13:
        if (r5.contains("%s") == true) goto L24;
        String r6 = r5 + r2;
    L15:
        r5 = r6;
    L20:
        if (r5.length() > 255) goto L28;
        return r5;
    L28:
        return r5.substring(r5.length() - KotlinVersion.MAX_COMPONENT_VALUE);
    L24:
        r6 = String.format(r5, new Object[]{r2});     // Catch: Throwable -> L18
    L22:
        return "";
    }

    public static String getRespHeadFieldIgnoreCase(IDownloadHeadHttpConnection r2, String r3) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r3) == true) goto L16;
        String r0 = r2.getResponseHeaderField(r3);
        if (TextUtils.isEmpty(r0) == false) goto L10;
        r0 = r2.getResponseHeaderField(r3.toLowerCase());
    L10:
        if (TextUtils.isEmpty(r0) == true) goto L12;
        return r0;
    L12:
        return r2.getResponseHeaderField(r3.toUpperCase());
    L16:
        return null;
    }

    public static String getString(Object r0, String r1) {
        return (String) r0;
    L4:
        return r1;
    }

    public static String getTargetFilePath(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L14:
        return null;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L14;
        if (DownloadFileUtils.isMediaUri(r2) == false) goto L13;
        if (DownloadFileUtils.checkUriInsert(r2) == true) goto L13;
        return null;
    L13:
        return new DownloadFile(r2, r3).getPath();
    }

    public static String getTempFileSavePath(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == false) goto L9;
        if (TextUtils.isEmpty(r2) == false) goto L9;
        return null;
    L9:
        if (TextUtils.isEmpty(r2) == false) goto L11;
        return r1;
    L11:
        return r2;
    }

    public static boolean isFileExist(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L14:
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L14;
        if (DownloadFileUtils.isMediaUri(r2) == false) goto L13;
        if (DownloadFileUtils.checkUriInsert(r2) == true) goto L13;
        return false;
    L13:
        return new DownloadFile(r2, r3).exists();
    }

    public static boolean isWaitWifiAndInNet(BaseException r0, DownloadInfo r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if (r1.isOnlyWifi() == false) goto L8;
        if (isNetworkConnected(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext()) == false) goto L8;
        return true;
    }

    public static String readStreamToString(InputStream r6, int r7) {
        StringBuilder r0 = new StringBuilder();
        if (r6 == null) goto L26;
        if (r7 <= 0) goto L26;
        BufferedReader r3 = null;
        BufferedReader r4 = new BufferedReader(new InputStreamReader(r6));     // Catch: Throwable -> L18
    L30:
        String r5 = r4.readLine();     // Catch: Throwable -> L16
        if (r5 == null) goto L15;
        r0.append(r5);     // Catch: Throwable -> L16
        if (r0.length() <= r7) goto L30;
        String r8 = r0.substring(0, r7);     // Catch: Throwable -> L16
        safeClose(new Closeable[]{r4});
        safeClose(new Closeable[]{r6});
        return r8;
    L15:
        safeClose(new Closeable[]{r4});
        safeClose(new Closeable[]{r6});
    L22:
        return r0.toString();
    L16:
        th = th;
        r3 = r4;
    L28:
        th.printStackTrace();     // Catch: Throwable -> L23
        safeClose(new Closeable[]{r3});
        safeClose(new Closeable[]{r6});
    L23:
        th = move-exception;
        safeClose(new Closeable[]{r3});
        safeClose(new Closeable[]{r6});
        throw th;
    L18:
        th = th;
    L26:
        safeClose(new Closeable[]{r6});
        return r0.toString();
    }

    private static void securityDeleteFile(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L16;
        DownloadFile r0 = new DownloadFile(r2, r3, true, true);
        if (r0.exists() == true) goto L10;
        return;
    L10:
        if (Logger.debug() == false) goto L12;
        Logger.globalDebug(TAG, "deleteFile", "Path: " + r0.getAbsolutePath());
    L12:
        r0.delete();
        return;
    }

    public static int checkMd5Status(File r0, String r1) {
        return TTMd5.checkMd5(r1, r0);
    }

    public static boolean checkMd5Valid(File r0, String r1) {
        return isMd5Valid(TTMd5.checkMd5(r1, r0));
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_socialbase_downloader_utils_DownloadUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r2, boolean r3, ClassLoader r4) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r5 = access$000(r2, r3, r4);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r2);     // Catch: Throwable -> L8
    L7:
        return r5;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r2);
    L12:
        throw th;
    L34:
        Class r6 = access$000(r2, r3, r4);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r2);     // Catch: Throwable -> L17
    L16:
        return r6;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r2);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r2);
    }

    public static int checkMd5Status(String r1, String r2, String r3) {
        return checkMd5Status(new DownloadFile(r1, r2), r3);
    }

    public static boolean checkMd5Valid(String r1, String r2, String r3) {
        return isMd5Valid(checkMd5Status(new DownloadFile(r1, r2), r3));
    }

    public static void clearDownloadFile(String r2, String r3, String r4) {
        String r0 = String.format("%s.tp", new Object[]{r4});
        securityDeleteFile(r2, r4);
        if (r3 == null) goto L6;
        r2 = r3;
    L6:
        securityDeleteFile(r2, r0);
    }

    public static String getTempFilePath(String r2, String r3, String r4) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        if (TextUtils.isEmpty(r3) == false) goto L7;
    L8:
        return null;
    L7:
        if (TextUtils.isEmpty(r4) == true) goto L8;
        if (TextUtils.isEmpty(r3) == true) goto L12;
        String r5 = getTargetFilePath(r3, r4);
    L14:
        if (TextUtils.isEmpty(r5) == false) goto L17;
        return null;
    L17:
        return String.format("%s.tp", new Object[]{r5});
    L12:
        r5 = getTargetFilePath(r2, r4);
        goto L14
    }

    public static boolean isDownloadSuccessAndFileNotExist(int r1, String r2, String r3) {
        if (r1 == (-3)) goto L5;
        return false;
    L5:
        if (isFileExist(r2, r3) == true) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean isFileDownloaded(DownloadInfo r3, boolean r4, String r5) {
        if (r4 == false) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r3.getSavePath()) == true) goto L19;
        if (TextUtils.isEmpty(r3.getName()) == true) goto L19;
        DownloadFile r6 = new DownloadFile(r3.getSavePath(), r3.getName());     // Catch: OutOfMemoryError -> L17
        if (DownloadFileUtils.existsAndNotEmpty(r6) == false) goto L19;
        if (checkFileLength(r3, r6) == false) goto L19;
        if (checkMd5Valid(r6, r5) == false) goto L19;
        return true;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public static void setMultiProcessMode(int r0, String r1, boolean r2) {
        if (r2 == false) goto L9;
        if (TextUtils.isEmpty(r1) == true) goto L9;
        if (r1.endsWith(":downloader") == false) goto L9;
        return;
    L9:
        if (sMultiProcessMode.compareAndSet(-1, r0) == true) goto L11;
        return;
    L11:
        if (isMultiProcessNormalDBMode() == false) goto L15;
        enableLruCache = true;
        return;
    }

    public static String toHexString(byte[] r9, int r10, int r11) {
        if (r9 == null) goto L14;
        if (r10 < 0) goto L12;
        if ((r10 + r11) > r9.length) goto L12;
        int r0 = r11 * 2;
        char[] r1 = new char[r0];
        int r3 = 0;
        int r4 = 0;
    L7:
        if (r3 >= r11) goto L10;
        int r5 = r9[r3 + r10] & UByte.MAX_VALUE;
        int r6 = r4 + 1;
        char[] r7 = HEX_CHARS;
        r1[r4] = r7[r5 >> 4];
        r4 = r6 + 1;
        r1[r6] = r7[r5 & 15];
        r3 = r3 + 1;
        goto L7
    L10:
        return new String(r1, 0, r0);
    L12:
        throw new IndexOutOfBoundsException();
    L14:
        throw new NullPointerException("bytes is null");
    }

    public static boolean isFileDownloaded(String r1, String r2, boolean r3) {
        return isFileDownloaded(r1, r2, null, r3);
    }

    public static boolean isFileDownloaded(String r1, String r2, String r3, boolean r4) {
        if (r4 == false) goto L5;
    L17:
        return false;
    L5:
        if (TextUtils.isEmpty(r1) == true) goto L17;
        if (TextUtils.isEmpty(r2) == true) goto L17;
        DownloadFile r5 = new DownloadFile(r1, r2);     // Catch: OutOfMemoryError -> L15
        if (DownloadFileUtils.existsAndNotEmpty(r5) == false) goto L17;
        if (checkMd5Valid(r5, r3) == false) goto L17;
        return true;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }
}
