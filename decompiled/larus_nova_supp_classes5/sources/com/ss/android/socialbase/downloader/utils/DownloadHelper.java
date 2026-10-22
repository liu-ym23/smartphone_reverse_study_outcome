package com.ss.android.socialbase.downloader.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadInnerConstants;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadThreadCheckListener;
import com.ss.android.socialbase.downloader.depend.ITempFileSaveCompleteCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadHttpException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.model.RandomAccessOutputStream;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.internal.http2.StreamResetException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadHelper {
    public static final String ACCEPT_ENCODING = "Accept-Encoding";
    public static final String ACCEPT_RANGES = "Accept-Ranges";
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_TYPE = "Content-Type";
    private static final String DEFAULT_SECURITY_VALUE = "StaticResource/file/Downloader";
    public static final String ETAG = "Etag";
    private static final long FILE_COPY_BUFFER_SIZE = 31457280;
    public static final String GZIP = "gzip";
    public static final String IDENTITY = "identity";
    public static final String IF_MATCH = "If-Match";
    public static final String IF_MODIFIED_SINCE = "if-modified-since";
    public static final String IF_NONE_MATCH = "If-None-Match";
    public static final String LAST_MODIFIED = "last-modified";
    public static final String LAST_MODIFIED_CASE = "Last-Modified";
    private static final long ONE_KB = 1024;
    private static final long ONE_MB = 1048576;
    private static final String SECURITY_ARGUS_KEY = "x-security-argus";
    private static final String TAG = null;
    public static final String TRANSFER_ENCODING = "Transfer-Encoding";
    public static final String TTNET_PROTO_TYPE = "x-ttnet-http-proto-type";
    public static final String VALUE_CHUNKED = "chunked";
    public static final String X_CACHE = "X-Cache";
    public static final String X_CONTENT_LENGTH = "X-Content-Length";
    private static volatile boolean mSleepDownloadingTask;
    private static volatile String sAid;
    private static volatile String sChannel;
    private static volatile String sFullSecurityValue;
    private static Boolean sIsDownloaderProcess;
    private static Boolean sIsMainProcess;
    private static volatile SparseArray<List<ITempFileSaveCompleteCallback>> saveTempFileListeners;
    private static volatile SparseArray<Boolean> saveTempFileStatusMap;

    public DownloadHelper() {
    }

    public static int convertToBytes(double r2) {
        return (int) ((r2 * 1000.0d) / 8.0d);
    }

    public static boolean isResponseDataFromBegin(int r1) {
        if (r1 != 200) goto L5;
    L9:
        return true;
    L5:
        if (r1 == 201) goto L9;
        if (r1 == 0) goto L9;
        return false;
    }

    static {
        TAG = "DownloadHelper";
        saveTempFileStatusMap = new SparseArray();
        saveTempFileListeners = new SparseArray();
        mSleepDownloadingTask = false;
    }

    private static String getSecurityValue() {
        if (sFullSecurityValue == null) goto L7;
        return sFullSecurityValue;
    L7:
        if (TextUtils.isEmpty(sAid) == false) goto L9;
        return DEFAULT_SECURITY_VALUE;
    L9:
        if (TextUtils.isEmpty(sChannel) == true) goto L14;
        sFullSecurityValue = "StaticResource/file/Downloader aid/" + sAid + "/" + sChannel + "/Android";
        return sFullSecurityValue;
    L14:
        return DEFAULT_SECURITY_VALUE;
    }

    public static boolean isDownloaderProcess() {
        Boolean r0 = sIsDownloaderProcess;
        if (r0 == null) goto L7;
        return r0.booleanValue();
    L7:
        if (DownloadComponentManager.getAppContext() != null) goto L10;
        return false;
    L10:
        String r1 = DownloadUtils.getCurProcessName(DownloadComponentManager.getAppContext());
        if (r1 != null) goto L13;
    L15:
        sIsDownloaderProcess = Boolean.FALSE;
    L17:
        return sIsDownloaderProcess.booleanValue();
    L13:
        if (r1.equals(DownloadComponentManager.getAppContext().getPackageName() + ":downloader") == false) goto L15;
        sIsDownloaderProcess = Boolean.TRUE;
        goto L17
    }

    public static boolean isMainProcess() {
        Boolean r0 = sIsMainProcess;
        if (r0 == null) goto L7;
        return r0.booleanValue();
    L7:
        if (DownloadSetting.obtainGlobal().optInt("force_independent_process") <= 0) goto L11;
        Boolean r1 = Boolean.FALSE;
        sIsMainProcess = r1;
        return r1.booleanValue();
    L11:
        if (DownloadSetting.obtainGlobal().optInt("force_main_process") <= 0) goto L14;
        Boolean r2 = Boolean.TRUE;
        sIsMainProcess = r2;
        return r2.booleanValue();
    L14:
        boolean r3 = true;
        if (DownloadComponentManager.getAppContext() != null) goto L17;
        return true;
    L17:
        String r4 = DownloadUtils.getCurProcessName(DownloadComponentManager.getAppContext());
        if (r4 != null) goto L20;
    L22:
        if (r4 != null) goto L24;
    L26:
        r3 = false;
    L27:
        sIsMainProcess = Boolean.valueOf(r3);
    L29:
        return sIsMainProcess.booleanValue();
    L24:
        if (r4.equals(DownloadComponentManager.getAppContext().getPackageName()) == false) goto L26;
    L20:
        if (r4.contains(":") == false) goto L22;
        sIsMainProcess = Boolean.FALSE;
        goto L29
    }

    public static Map<String, SceneLruLimitInfo> getDbInitSceneLruLimitMap() {
        Set<String> r0 = parseJSONArrayToSet(DownloadSetting.obtainGlobal().optJSONArray("lru_db_init_monitor_scene_limit_list"));
        if (r0 != null) goto L5;
    L30:
        return null;
    L5:
        if (r0.isEmpty() == true) goto L30;
        HashMap r2 = new HashMap();
        Iterator<String> r1 = r0.iterator();     // Catch: Throwable -> L24
    L10:
        if (r1.hasNext() == false) goto L27;
        String[] r3 = r1.next().split(":");     // Catch: Throwable -> L24
        if (r3 == null) goto L10;
        if (r3.length <= 0) goto L10;
        String r5 = r3[0];     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r5) == true) goto L10;
        int r4 = CastIntegerProtector.parseInt(r3[1]);     // Catch: Throwable -> L24
        if (r4 <= 0) goto L10;
        r2.put(r5, new SceneLruLimitInfo(0, r4));     // Catch: Throwable -> L24
    L27:
        if (r2.isEmpty() == false) goto L29;
        return null;
    L29:
        return r2;
    L24:
        th = move-exception;
        Logger.globalError(TAG, "getDbInitSceneLruLimitSet", "Error" + th);
        goto L27
    }

    public static Set<String> getDbInitSceneSet() {
        return parseJSONArrayToSet(DownloadSetting.obtainGlobal().optJSONArray("db_init_monitor_scene_list"));
    }

    public static Set<String> getSkipDbInitExpectMimeTypeSet() {
        return parseJSONArrayToSet(DownloadSetting.obtainGlobal().optJSONArray("skip_db_init_expect_mime_type"));
    }

    public static Set<String> getSkipDbInitSceneSet() {
        return parseJSONArrayToSet(DownloadSetting.obtainGlobal().optJSONArray("skip_db_init_monitor_scene_list"));
    }

    public static boolean needNotifyDownloaderProcess() {
        if (isDownloaderProcess() == false) goto L5;
    L9:
        return false;
    L5:
        if (DownloadComponentManager.isDownloadInMultiProcess() == false) goto L9;
        if (DownloadProxy.get(true).isServiceAlive() == false) goto L9;
        return true;
    }

    public static void updateCacheSetting() {
        String[] r1 = {"lru_download_info_cache_enable", "optimize_download_cache"};     // Catch: Throwable -> L26
        int r4 = 0;
        SharedPreferences r2 = DownloadComponentManager.getAppContext().getSharedPreferences(DownloadConstants.SP_DOWNLOAD_SETTING_CACHE, 0);     // Catch: Throwable -> L26
        JSONObject r3 = DownloadSetting.getGlobalSettings();     // Catch: Throwable -> L26
        if (r3.optInt("enable_setting_cache") > 0) goto L14;
    L5:
        if (r4 >= 2) goto L11;
        if (r2.contains(r1[r4]) == true) goto L8;
        r4 = r4 + 1;     // Catch: Throwable -> L26
        goto L5
    L8:
        r2.edit().clear().apply();     // Catch: Throwable -> L26
    L11:
        if (Logger.debug() == false) goto L35;
        Logger.globalDebug(TAG, "updateCacheSetting", "Disable cache setting");     // Catch: Throwable -> L26
        return;
    L35:
        return;
    L14:
        SharedPreferences.Editor r5 = r2.edit();     // Catch: Throwable -> L26
        int r7 = 0;
        boolean r8 = false;
    L15:
        if (r7 >= 2) goto L23;
        String r9 = r1[r7];     // Catch: Throwable -> L26
        int r10 = r3.optInt(r9, 0);     // Catch: Throwable -> L26
        if (r2.getInt(r9, 0) == r10) goto L22;
        r5.putInt(r9, r10);     // Catch: Throwable -> L26
        if (Logger.debug() == false) goto L21;
        Logger.globalDebug(TAG, "updateCacheSetting", "Key:" + r9 + " Value:" + r10);     // Catch: Throwable -> L26
    L21:
        r8 = true;
    L22:
        r7 = r7 + 1;     // Catch: Throwable -> L26
        goto L15
    L23:
        if (r8 == false) goto L36;
        r5.apply();     // Catch: Throwable -> L26
        return;
    L36:
        return;
    L26:
        th = move-exception;
        Logger.globalError(TAG, "updateCacheSetting", "Error:" + th);
    }

    public static void checkWorkerThread(String r3) {
        if (Logger.debug() == true) goto L5;
        return;
    L5:
        if (DownloadUtils.isMainThread() == false) goto L11;
        Logger.globalError(TAG, "checkWorkerThread", "This method:" + r3 + " cannot be executed on the main thread");
        IDownloadThreadCheckListener r0 = DownloadComponentManager.getDownloadThreadCheckListener();
        if (r0 == null) goto L12;
        r0.onError(r3);
        return;
    L12:
        return;
    }

    public static ListenerType convertListenerType(int r3) {
        ListenerType r0 = ListenerType.MAIN;
        ListenerType r1 = ListenerType.SUB;
        if (r3 == r1.ordinal()) goto L8;
        r1 = ListenerType.NOTIFICATION;
        if (r3 == r1.ordinal()) goto L8;
        return r0;
    L8:
        return r1;
    }

    public static void deleteDir(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        PolarisFileWrapper r0 = new PolarisFileWrapper(r5);
        if (r0.exists() == true) goto L8;
        return;
    L8:
        if (r0.isDirectory() == false) goto L31;
        File[] r6 = r0.listFiles();
        if (r6 != null) goto L13;
    L24:
        r0.delete();
        return;
    L13:
        if (r6.length == 0) goto L24;
        int r1 = r6.length;
        int r2 = 0;
    L15:
        if (r2 >= r1) goto L24;
        File r3 = r6[r2];
        if (r3.isFile() == false) goto L20;
        r3.delete();
    L23:
        r2 = r2 + 1;
        goto L15
    L20:
        if (r3.isDirectory() == false) goto L23;
        deleteDir(r3.getAbsolutePath());
        return;
    }

    public static int getCacheSettingInt(String r5) {
        int r2 = 0;
        r2 = DownloadComponentManager.getAppContext().getSharedPreferences(DownloadConstants.SP_DOWNLOAD_SETTING_CACHE, 0).getInt(r5, 0);     // Catch: Throwable -> L7
        if (Logger.debug() == false) goto L9;
        Logger.globalDebug(TAG, "getCacheSettingInt", "Key:" + r5 + " Value:" + r2);     // Catch: Throwable -> L7
    L9:
        return r2;
    L7:
        th = move-exception;
        Logger.globalError(TAG, "getCacheSettingInt", "Error:" + th);
        goto L9
    }

    public static long getCurByte(DownloadInfo r6) {
        if (r6 != null) goto L5;
        return 0;
    L5:
        boolean r2 = r6.isFileDataValid();
        if (Logger.debugScene(r6) == false) goto L8;
        Logger.taskDebug(TAG, r6, "getCurByte", "ResumeAvailable:" + r2);
    L8:
        if (r2 == true) goto L10;
        return 0;
    L10:
        return r6.getCurBytes();
    }

    public static long getFirstOffset(DownloadInfo r2) {
        if (r2 != null) goto L6;
        return -1;
    L6:
        return r2.getCurBytes();
    }

    public static boolean isCdnCacheHit(List<Pair<String, String>> r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        Iterator<Pair<String, String>> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L14;
        Pair<String, String> r1 = r4.next();
        if (TextUtils.isEmpty((CharSequence) r1.second) == true) goto L7;
        if (((String) r1.second).toLowerCase().contains("hit") == false) goto L7;
        return true;
    L14:
        return false;
    }

    public static boolean isChunkedTask(IDownloadHeadHttpConnection r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (VALUE_CHUNKED.equals(r5.getResponseHeaderField(TRANSFER_ENCODING)) == false) goto L8;
    L9:
        return true;
    L8:
        if (DownloadUtils.getContentLength(r5) == (-1)) goto L9;
        return false;
    }

    public static boolean isConnectionException(Throwable r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        String r3 = DownloadUtils.getThrowableMsg(r2);
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (r3.contains("Exception in connect") == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isForbiddenException(Throwable r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        String r1 = DownloadUtils.getThrowableMsg(r4);
        if ((r4 instanceof DownloadHttpException) == false) goto L15;
        if (((DownloadHttpException) r4).getHttpStatusCode() != 403) goto L10;
    L13:
        return true;
    L10:
        if (TextUtils.isEmpty(r1) == true) goto L15;
        if (r1.contains("403") == true) goto L13;
    L15:
        if (TextUtils.isEmpty(r1) == false) goto L17;
        return false;
    L17:
        if (r1.contains("Forbidden") == false) goto L21;
        return true;
    L21:
        return false;
    }

    public static boolean isHttpDataDirtyError(BaseException r2) {
        if (r2 != null) goto L4;
    L12:
        return false;
    L4:
        if (r2.getErrorCode() != 1051) goto L6;
    L11:
        return true;
    L6:
        if (r2.getErrorCode() == 1027) goto L11;
        if (r2.getErrorCode() == 1026) goto L11;
        if (r2.getErrorCode() != 1044) goto L12;
        goto L11
    }

    public static boolean isHttpsError(BaseException r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.getErrorCode() != 1011) goto L8;
    L11:
        return true;
    L8:
        if (r3.getCause() != null) goto L10;
        return false;
    L10:
        if ((r3.getCause() instanceof SSLHandshakeException) == true) goto L11;
        return false;
    }

    public static boolean isInterceptError(Throwable r1) {
        if (r1 != null) goto L4;
    L8:
        return false;
    L4:
        if ((r1 instanceof BaseException) == false) goto L8;
        if (((BaseException) r1).getErrorCode() != 1083) goto L8;
        return true;
    }

    public static boolean isNetNotAvailableException(Throwable r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        String r3 = DownloadUtils.getThrowableMsg(r2);
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (r3.contains("network not available") == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isResponseCode412Error(Throwable r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (DownloadComponentManager.getTTNetHandler().getResponseCode(r4) != 412) goto L8;
        return true;
    L8:
        String r5 = DownloadUtils.getThrowableMsg(r4);
        if (TextUtils.isEmpty(r5) == false) goto L11;
        return false;
    L11:
        if (r5.contains("Precondition Failed") == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static boolean isResponseCode416Error(Throwable r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (DownloadComponentManager.getTTNetHandler().getResponseCode(r4) != 416) goto L8;
        return true;
    L8:
        String r5 = DownloadUtils.getThrowableMsg(r4);
        if (TextUtils.isEmpty(r5) == false) goto L11;
        return false;
    L11:
        if (r5.contains("Requested Range Not Satisfiable") == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static boolean isResponseCodeError(BaseException r2) {
        if ((r2 instanceof DownloadHttpException) == false) goto L9;
        DownloadHttpException r3 = (DownloadHttpException) r2;
        if (r3.getHttpStatusCode() != 412) goto L7;
    L8:
        return true;
    L7:
        if (r3.getHttpStatusCode() == 416) goto L8;
    L9:
        return false;
    }

    public static boolean isTimeOutException(Throwable r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        String r1 = DownloadUtils.getThrowableMsg(r2);
        if ((r2 instanceof SocketTimeoutException) == false) goto L8;
    L13:
        return true;
    L8:
        if (TextUtils.isEmpty(r1) == false) goto L10;
        return false;
    L10:
        if (r1.contains("time out") == true) goto L13;
        if (r1.contains("Time-out") == true) goto L13;
        return false;
    }

    public static HashMap<String, Integer> jsonObjectToHashMap(JSONObject r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        HashMap<String, Integer> r1 = new HashMap();
        Iterator<String> r2 = r5.keys();
    L7:
        if (r2.hasNext() == false) goto L12;
        String r3 = r2.next();
        if (r3 == null) goto L7;
        r1.put(r3, Integer.valueOf(r5.optInt(r3, 0)));
        goto L7
    L12:
        if (r1.isEmpty() == false) goto L15;
        return null;
    L15:
        return r1;
    }

    public static Map<Integer, DownloadInfo> listConvertToMap(List<DownloadInfo> r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        HashMap r0 = new HashMap();
        Iterator<DownloadInfo> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        DownloadInfo r1 = r4.next();
        if (r1.getId() == 0) goto L7;
        r0.put(Integer.valueOf(r1.getId()), r1);
        goto L7
    L11:
        return r0;
    }

    public static long parseContentRangeOfInstanceLength(String r5) {
        if (r5 != null) goto L5;
        return -1;
    L5:
        String[] r6 = r5.split("/");
        if (r6.length >= 2) goto L13;
    L12:
        return -1;
    L13:
        return CastLongProtector.parseLong(r6[1]);
    L10:
        e = move-exception;
        Logger.globalError(TAG, "parseContentRangeOfInstanceLength", "Exception:" + e);
        goto L12
    }

    public static DownloadInfo parseDownloadInfo(Cursor r8) {
        if (r8 == null) goto L4;
        DownloadInfo.RawBuilder r0 = new DownloadInfo.RawBuilder();
        int r1 = r8.getColumnIndex(DBDefinition.ID);     // Catch: Exception -> L174
        if (r1 == (-1)) goto L9;
        r0.id = r8.getInt(r1);     // Catch: Exception -> L174
    L9:
        int r2 = r8.getColumnIndex(DBDefinition.NAME);     // Catch: Exception -> L174
        if (r2 == (-1)) goto L12;
        r0.name(r8.getString(r2));     // Catch: Exception -> L174
    L12:
        int r3 = r8.getColumnIndex(DBDefinition.TITLE);     // Catch: Exception -> L174
        if (r3 == (-1)) goto L15;
        r0.title(r8.getString(r3));     // Catch: Exception -> L174
    L15:
        int r4 = r8.getColumnIndex("url");     // Catch: Exception -> L174
        if (r4 == (-1)) goto L18;
        r0.url(r8.getString(r4));     // Catch: Exception -> L174
    L18:
        int r5 = r8.getColumnIndex(DBDefinition.SAVE_PATH);     // Catch: Exception -> L174
        if (r5 == (-1)) goto L21;
        r0.savePath(r8.getString(r5));     // Catch: Exception -> L174
    L21:
        int r6 = r8.getColumnIndex(DBDefinition.TEMP_PATH);     // Catch: Exception -> L174
        if (r6 == (-1)) goto L24;
        r0.tempPath(r8.getString(r6));     // Catch: Exception -> L174
    L24:
        int r7 = r8.getColumnIndex(DBDefinition.CHUNK_COUNT);     // Catch: Exception -> L174
        if (r7 == (-1)) goto L27;
        r0.chunkCount = r8.getInt(r7);     // Catch: Exception -> L174
    L27:
        int r9 = r8.getColumnIndex("status");     // Catch: Exception -> L174
        boolean r10 = false;
        if (r9 == (-1)) goto L30;
        r0.status = r8.getInt(r9);     // Catch: Exception -> L174
    L31:
        int r11 = r8.getColumnIndex(DBDefinition.CUR_BYTES);     // Catch: Exception -> L174
        if (r11 == (-1)) goto L34;
        r0.curBytes = r8.getLong(r11);     // Catch: Exception -> L174
    L35:
        int r12 = r8.getColumnIndex(DBDefinition.BACK_CUR_BYTES);     // Catch: Exception -> L174
        if (r12 == (-1)) goto L38;
        r0.backCurBytes = r8.getLong(r12);     // Catch: Exception -> L174
    L39:
        int r13 = r8.getColumnIndex(DBDefinition.TOTAL_BYTES);     // Catch: Exception -> L174
        if (r13 == (-1)) goto L42;
        r0.totalBytes = r8.getLong(r13);     // Catch: Exception -> L174
    L42:
        int r14 = r8.getColumnIndex(DBDefinition.ETAG);     // Catch: Exception -> L174
        if (r14 == (-1)) goto L45;
        r0.etag = r8.getString(r14);     // Catch: Exception -> L174
    L45:
        int r15 = r8.getColumnIndex(DBDefinition.ONLY_WIFI);     // Catch: Exception -> L174
        if (r15 != (-1)) goto L48;
    L52:
        int r16 = r8.getColumnIndex(DBDefinition.FORCE);     // Catch: Exception -> L174
        if (r16 != (-1)) goto L55;
    L59:
        int r17 = r8.getColumnIndex(DBDefinition.RETRY_COUNT);     // Catch: Exception -> L174
        if (r17 == (-1)) goto L62;
        r0.retryCount(r8.getInt(r17));     // Catch: Exception -> L174
    L62:
        int r18 = r8.getColumnIndex(DBDefinition.EXTRA);     // Catch: Exception -> L174
        if (r18 == (-1)) goto L65;
        r0.extra(r8.getString(r18));     // Catch: Exception -> L174
    L65:
        int r19 = r8.getColumnIndex(DBDefinition.MIME_TYPE);     // Catch: Exception -> L174
        if (r19 == (-1)) goto L68;
        r0.mimeType(r8.getString(r19));     // Catch: Exception -> L174
    L68:
        int r20 = r8.getColumnIndex(DBDefinition.NOTIFICATION_ENABLE);     // Catch: Exception -> L174
        if (r20 != (-1)) goto L71;
    L75:
        int r21 = r8.getColumnIndex(DBDefinition.NOTIFICATION_VISIBILITY);     // Catch: Exception -> L174
        if (r21 == (-1)) goto L78;
        r0.notificationVisibility = r8.getInt(r21);     // Catch: Exception -> L174
    L78:
        int r22 = r8.getColumnIndex(DBDefinition.FIRST_DOWNLOAD);     // Catch: Exception -> L174
        if (r22 != (-1)) goto L81;
    L85:
        int r23 = r8.getColumnIndex(DBDefinition.FIRST_SUCCESS);     // Catch: Exception -> L174
        if (r23 != (-1)) goto L88;
    L92:
        int r24 = r8.getColumnIndex(DBDefinition.NEED_HTTPS_TO_HTTP_RETRY);     // Catch: Exception -> L174
        if (r24 != (-1)) goto L95;
    L99:
        int r25 = r8.getColumnIndex(DBDefinition.DOWNLOAD_TIME);     // Catch: Exception -> L174
        if (r25 == (-1)) goto L102;
        r0.downloadTime = r8.getLong(r25);     // Catch: Exception -> L174
    L102:
        int r26 = r8.getColumnIndex(DBDefinition.PACKAGE_NAME);     // Catch: Exception -> L174
        if (r26 == (-1)) goto L105;
        r0.packageName(r8.getString(r26));     // Catch: Exception -> L174
    L105:
        int r27 = r8.getColumnIndex(DBDefinition.MD5);     // Catch: Exception -> L174
        if (r27 == (-1)) goto L108;
        r0.md5(r8.getString(r27));     // Catch: Exception -> L174
    L108:
        int r28 = r8.getColumnIndex(DBDefinition.CUR_RETRY_TIME);     // Catch: Exception -> L174
        if (r28 == (-1)) goto L111;
        r0.curRetryTime = r8.getInt(r28);     // Catch: Exception -> L174
    L111:
        int r29 = r8.getColumnIndex(DBDefinition.DEFAULT_HTTP_SERVICE_BACKUP);     // Catch: Exception -> L174
        if (r29 != (-1)) goto L114;
    L118:
        int r30 = r8.getColumnIndex(DBDefinition.BACKUP_URLS_STR);     // Catch: Exception -> L174
        if (r30 == (-1)) goto L121;
        r0.backUpUrlsStr = r8.getString(r30);     // Catch: Exception -> L174
    L121:
        int r31 = r8.getColumnIndex(DBDefinition.BACKUP_URL_RETRY_COUNT);     // Catch: Exception -> L174
        if (r31 == (-1)) goto L124;
        r0.backUpUrlRetryCount(r8.getInt(r31));     // Catch: Exception -> L174
    L124:
        int r32 = r8.getColumnIndex(DBDefinition.REAL_DOWNLOAD_TIME);     // Catch: Exception -> L174
        if (r32 == (-1)) goto L127;
        r0.realDownloadTime = r8.getLong(r32);     // Catch: Exception -> L174
    L127:
        int r33 = r8.getColumnIndex(DBDefinition.REAL_BACK_DOWNLOAD_TIME);     // Catch: Exception -> L174
        if (r33 == (-1)) goto L130;
        r0.realBackDownloadTime = r8.getLong(r33);     // Catch: Exception -> L174
    L130:
        int r34 = r8.getColumnIndex(DBDefinition.INDEPENDENT_PROCESS);     // Catch: Exception -> L174
        if (r34 != (-1)) goto L133;
    L137:
        int r35 = r8.getColumnIndex(DBDefinition.AUXILIARY_JSONOBJECT_STRING);     // Catch: Exception -> L174
        if (r35 == (-1)) goto L140;
        r0.dbJsonDataString = r8.getString(r35);     // Catch: Exception -> L174
    L140:
        int r36 = r8.getColumnIndex(DBDefinition.ICON_URL);     // Catch: Exception -> L174
        if (r36 == (-1)) goto L143;
        r0.iconUrl(r8.getString(r36));     // Catch: Exception -> L174
    L143:
        int r37 = r8.getColumnIndex(DBDefinition.APP_VERSION_CODE);     // Catch: Exception -> L174
        if (r37 == (-1)) goto L146;
        r0.appVersionCode(r8.getInt(r37));     // Catch: Exception -> L174
    L146:
        int r38 = r8.getColumnIndex(DBDefinition.DOWNLOAD_START_TIMESTAMP);     // Catch: Exception -> L174
        if (r38 == (-1)) goto L149;
        r0.downloadStartTimeStamp = r8.getLong(r38);     // Catch: Exception -> L174
    L149:
        int r39 = r8.getColumnIndex(DBDefinition.DOWNLOAD_FINISH_TIMESTAMP);     // Catch: Exception -> L174
        if (r39 == (-1)) goto L152;
        r0.downloadFinishTimeStamp = r8.getLong(r39);     // Catch: Exception -> L174
    L152:
        int r40 = r8.getColumnIndex(DBDefinition.INSTALLED_TIMESTAMP);     // Catch: Exception -> L174
        if (r40 == (-1)) goto L155;
        r0.installedTimeStamp = r8.getLong(r40);     // Catch: Exception -> L174
    L155:
        int r41 = r8.getColumnIndex(DBDefinition.CACHE_LIFE_TIME_MAX);     // Catch: Exception -> L174
        if (r41 == (-1)) goto L158;
        r0.cacheLifeTimeMax(r8.getLong(r41));     // Catch: Exception -> L174
    L158:
        int r42 = r8.getColumnIndex(DBDefinition.HAS_DO_INSTALLATION);     // Catch: Exception -> L174
        if (r42 != (-1)) goto L161;
    L164:
        int r43 = r8.getColumnIndex(DBDefinition.PCDN_URLS_STR);     // Catch: Exception -> L174
        if (r43 == (-1)) goto L167;
        r0.pcdnUrlsStr = r8.getString(r43);     // Catch: Exception -> L174
    L167:
        int r44 = r8.getColumnIndex(DBDefinition.CDN_URLS_STR);     // Catch: Exception -> L174
        if (r44 == (-1)) goto L170;
        r0.cdnUrlsStr = r8.getString(r44);     // Catch: Exception -> L174
    L170:
        int r45 = r8.getColumnIndex(DBDefinition.MONITOR_SCENE);     // Catch: Exception -> L174
        if (r45 == (-1)) goto L177;
        r0.monitorScene(r8.getString(r45));     // Catch: Exception -> L174
    L177:
        return r0.build();
    L161:
        if (r8.getInt(r42) != 1) goto L163;
        r10 = true;
    L163:
        r0.hasDoInstallation = r10;     // Catch: Exception -> L174
        goto L164
    L133:
        if (r8.getInt(r34) != 1) goto L135;
        boolean r46 = true;
    L136:
        r0.needIndependentProcess(r46);     // Catch: Exception -> L174
        goto L137
    L135:
        r46 = false;
        goto L136
    L114:
        if (r8.getInt(r29) != 1) goto L116;
        boolean r47 = true;
    L117:
        r0.needDefaultHttpServiceBackUp(r47);     // Catch: Exception -> L174
        goto L118
    L116:
        r47 = false;
        goto L117
    L95:
        if (r8.getInt(r24) != 1) goto L97;
        boolean r48 = true;
    L98:
        r0.needHttpsToHttpRetry(r48);     // Catch: Exception -> L174
        goto L99
    L97:
        r48 = false;
        goto L98
    L88:
        if (r8.getInt(r23) != 1) goto L90;
        boolean r49 = true;
    L91:
        r0.isFirstSuccess = r49;     // Catch: Exception -> L174
        goto L92
    L90:
        r49 = false;
        goto L91
    L81:
        if (r8.getInt(r22) != 1) goto L83;
        boolean r50 = true;
    L84:
        r0.isFirstDownload = r50;     // Catch: Exception -> L174
        goto L85
    L83:
        r50 = false;
        goto L84
    L71:
        if (r8.getInt(r20) == 0) goto L73;
        boolean r51 = true;
    L74:
        r0.showNotification(r51);     // Catch: Exception -> L174
        goto L75
    L73:
        r51 = false;
        goto L74
    L55:
        if (r8.getInt(r16) == 0) goto L57;
        boolean r52 = true;
    L58:
        r0.force(r52);     // Catch: Exception -> L174
        goto L59
    L57:
        r52 = false;
        goto L58
    L48:
        if (r8.getInt(r15) == 0) goto L50;
        boolean r53 = true;
    L51:
        r0.onlyWifi(r53);     // Catch: Exception -> L174
        goto L52
    L50:
        r53 = false;
        goto L51
    L38:
        r0.backCurBytes = 0;     // Catch: Exception -> L174
        goto L39
    L34:
        r0.curBytes = 0;     // Catch: Exception -> L174
        goto L35
    L30:
        r0.status = 0;     // Catch: Exception -> L174
    L174:
        e = move-exception;
        e.printStackTrace();
        goto L177
    L4:
        return new DownloadInfo();
    }

    private static Set<String> parseJSONArrayToSet(JSONArray r3) {
        if (r3 != null) goto L4;
        return null;
    L4:
        if (r3.length() <= 0) goto L19;
        HashSet r0 = new HashSet();
        int r1 = 0;
    L16:
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        return r0;
    L8:
        if (r1 >= r3.length()) goto L13;
        r0.add(JSONArrayProtectorUtils.getString(r3, r1));     // Catch: JSONException -> L11
        r1 = r1 + 1;
        goto L16
    L19:
        return null;
    }

    public static long parserMaxAge(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L13;
        return 0;
    L13:
        Matcher r4 = PatternProtector.compile("max-age=([0-9]+)").matcher(r3);     // Catch: Throwable -> L10
        if (r4.find() == false) goto L15;
        return CastLongProtector.parseLong(r4.group(1));
    L15:
        return 0;
    L10:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public static List<Integer> setConvertToList(Set<Integer> r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator<Integer> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r0.add(r3.next());
        goto L7
    L9:
        return r0;
    }

    public static void setSleepDownloadingTask(boolean r2) {
        mSleepDownloadingTask = r2;
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "setSleepDownloadingTask", "SleepDownloadingTask:" + mSleepDownloadingTask);
        return;
    }

    public static <K> HashMap<Integer, K> sparseArrayToHashMap(SparseArray<K> r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        HashMap<Integer, K> r0 = new HashMap();
        int r1 = r5.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        int r3 = r5.keyAt(r2);
        K r4 = r5.valueAt(r2);
        r0.put(Integer.valueOf(r3), r4);
        r2 = r2 + 1;
        goto L6
    L8:
        return r0;
    }

    public static ContentValues toContentValues(DownloadInfo r4) {
        ContentValues r0 = new ContentValues();
        r0.put(DBDefinition.ID, Integer.valueOf(r4.getRawId()));
        r0.put("url", r4.getUrl());
        r0.put(DBDefinition.SAVE_PATH, r4.getSavePath());
        r0.put(DBDefinition.TEMP_PATH, r4.getRawTempPath());
        r0.put(DBDefinition.NAME, r4.getName());
        r0.put(DBDefinition.CHUNK_COUNT, Integer.valueOf(r4.getChunkCount()));
        r0.put("status", Integer.valueOf(r4.getStatus()));
        r0.put(DBDefinition.CUR_BYTES, Long.valueOf(r4.getCurBytes()));
        r0.put(DBDefinition.BACK_CUR_BYTES, Long.valueOf(r4.getBackCurBytes()));
        r0.put(DBDefinition.TOTAL_BYTES, Long.valueOf(r4.getTotalBytes()));
        r0.put(DBDefinition.ETAG, r4.geteTag());
        r0.put(DBDefinition.ONLY_WIFI, Integer.valueOf(r4.isOnlyWifi() ? 1 : 0));
        r0.put(DBDefinition.FORCE, Integer.valueOf(r4.isForce() ? 1 : 0));
        r0.put(DBDefinition.RETRY_COUNT, Integer.valueOf(r4.getRetryCount()));
        r0.put(DBDefinition.EXTRA, r4.getExtra());
        r0.put(DBDefinition.MIME_TYPE, r4.getMimeType());
        r0.put(DBDefinition.TITLE, r4.getRawTitle());
        r0.put(DBDefinition.NOTIFICATION_ENABLE, Integer.valueOf(r4.isShowNotification() ? 1 : 0));
        r0.put(DBDefinition.NOTIFICATION_VISIBILITY, Integer.valueOf(r4.getNotificationVisibility()));
        r0.put(DBDefinition.FIRST_DOWNLOAD, Integer.valueOf(r4.getIsFirstDownload() ? 1 : 0));
        r0.put(DBDefinition.FIRST_SUCCESS, Integer.valueOf(r4.isFirstSuccess() ? 1 : 0));
        r0.put(DBDefinition.NEED_HTTPS_TO_HTTP_RETRY, Integer.valueOf(r4.isNeedHttpsToHttpRetry() ? 1 : 0));
        r0.put(DBDefinition.DOWNLOAD_TIME, Long.valueOf(r4.getDownloadTime()));
        r0.put(DBDefinition.PACKAGE_NAME, r4.getPackageName());
        r0.put(DBDefinition.MD5, r4.getMd5());
        r0.put(DBDefinition.CUR_RETRY_TIME, Integer.valueOf(r4.getCurRetryTime()));
        r0.put(DBDefinition.DEFAULT_HTTP_SERVICE_BACKUP, Integer.valueOf(r4.isNeedDefaultHttpServiceBackUp() ? 1 : 0));
        r0.put(DBDefinition.CHUNK_RUNNABLE_REUSE, 0);
        r0.put(DBDefinition.CHUNK_DOWNGRADE_RETRY, 0);
        r0.put(DBDefinition.BACKUP_URLS_STR, r4.getBackUpUrlsStr());
        r0.put(DBDefinition.BACKUP_URL_RETRY_COUNT, Integer.valueOf(r4.getBackUpUrlRetryCount()));
        r0.put(DBDefinition.REAL_DOWNLOAD_TIME, Long.valueOf(r4.getRawRealDownloadTime()));
        r0.put(DBDefinition.REAL_BACK_DOWNLOAD_TIME, Long.valueOf(r4.getRawRealBackDownloadTime()));
        r0.put(DBDefinition.INDEPENDENT_PROCESS, Integer.valueOf(r4.isNeedIndependentProcess() ? 1 : 0));
        r0.put(DBDefinition.AUXILIARY_JSONOBJECT_STRING, r4.getDBJsonDataString());
        r0.put(DBDefinition.ICON_URL, r4.getIconUrl());
        r0.put(DBDefinition.APP_VERSION_CODE, Integer.valueOf(r4.getAppVersionCode()));
        r0.put(DBDefinition.TASK_ID, null);
        r0.put(DBDefinition.DOWNLOAD_START_TIMESTAMP, Long.valueOf(r4.getDownloadStartTimeStamp()));
        r0.put(DBDefinition.DOWNLOAD_FINISH_TIMESTAMP, Long.valueOf(r4.getDownloadFinishTimeStamp()));
        r0.put(DBDefinition.INSTALLED_TIMESTAMP, Long.valueOf(r4.getInstalledTimeStamp()));
        r0.put(DBDefinition.HAS_DO_INSTALLATION, Integer.valueOf(r4.isHasDoInstallation() ? 1 : 0));
        r0.put(DBDefinition.CACHE_LIFE_TIME_MAX, Long.valueOf(r4.getCacheLifeTimeMax()));
        r0.put(DBDefinition.PCDN_URLS_STR, r4.getPcdnUrlsStr());
        r0.put(DBDefinition.CDN_URLS_STR, r4.getCdnUrlsStr());
        r0.put(DBDefinition.MONITOR_SCENE, r4.getMonitorScene());
        return r0;
    }

    public static void trySleepDownloadingTask(DownloadInfo r6) {
        if (mSleepDownloadingTask == false) goto L38;
        if (r6 != null) goto L6;
        return;
    L6:
        if (r6.getTaskSleepTime() > 0) goto L40;
        int r1 = DownloadSetting.obtainGlobal().optInt("downloading_task_anr_sleep_time_s");     // Catch: Throwable -> L29
        if (r1 > 0) goto L11;
        return;
    L11:
        JSONArray r2 = DownloadSetting.obtainGlobal().optJSONArray("downloading_task_anr_sleep_prohibit_scene_list");     // Catch: Throwable -> L29
        if (r2 != null) goto L14;
    L24:
        r6.setTaskSleepTime(r1);     // Catch: Throwable -> L29
        if (Logger.debugScene(r6.getMonitorScene()) == false) goto L27;
        Logger.taskDebug(TAG, r6.getId(), "trySleepDownloadingTask", "Sleep:" + r1);     // Catch: Throwable -> L29
    L27:
        Thread.sleep(r1 * 1000);     // Catch: Throwable -> L29
        return;
    L14:
        if (r2.length() <= 0) goto L24;
        int r3 = 0;
    L17:
        if (r3 >= r2.length()) goto L24;
        String r4 = r2.optString(r3);     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r4) == true) goto L23;
        if (r4.equalsIgnoreCase(r6.getMonitorScene()) == false) goto L23;
        return;
    L23:
        r3 = r3 + 1;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Logger.taskError(TAG, r6.getId(), "trySleepDownloadingTask", "Error:" + th);
        return;
    L40:
        return;
    }

    public static boolean canAcceptPartial(int r3, String r4) {
        if (r3 < 400) goto L6;
        return false;
    L6:
        if (r3 == 206) goto L10;
        if (r3 == 1) goto L10;
        if ("bytes".equals(r4) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean checkPermission(Context r2, String r3) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return false;
    L8:
        if (r2.checkCallingOrSelfPermission(r3) != 0) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean copyFile(File r1, File r2) throws BaseException {
        return copyFile(r1, r2, true);
    }

    public static <K, V> void copyMap(Map<K, V> r2, Map<K, V> r3) {
        if (r2 == null) goto L11;
        if (r3 == null) goto L17;
        Iterator<Map.Entry<K, V>> r4 = r2.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L18;
        Map.Entry<K, V> r0 = r4.next();
        if (r0.getKey() == null) goto L7;
        r3.put(r0.getKey(), r0.getValue());
        goto L7
    L18:
        return;
    L17:
        return;
    }

    public static String getFixLengthString(String r1, int r2) {
        if (r2 != 0) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return r1;
    L8:
        if (r1.length() > r2) goto L11;
        return r1;
    L11:
        return r1.substring(0, r2);
    }

    public static DownloadTTNetException getTTNetException(Throwable r2, String r3) {
        DownloadTTNetException r0 = DownloadComponentManager.getTTNetHandler().translateTTNetException(r2, null);
        if (r0 != null) goto L5;
        r0 = DownloadComponentManager.getTTNetHandler().translateTTNetException(r2.getCause(), null);
    L5:
        if (r0 == null) goto L8;
        String r4 = DownloadUtils.getErrorMsgWithTagPrefix(r0, r3);
        return new DownloadTTNetException(r0.getErrorCode(), r4).setRequestLog(r0.getRequestLog()).setRemoteIp(r0.getRemoteIp());
    L8:
        return null;
    }

    public static void injectRemoteIp(IDownloadHttpConnection r1, BaseException r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if ((r1 instanceof AbsDownloadHttpConnection) == false) goto L15;
        if (r2 != null) goto L7;
        return;
    L7:
        if ((r2 instanceof DownloadTTNetException) == false) goto L17;
        String r3 = ((AbsDownloadHttpConnection) r1).getHostIp();
        if (TextUtils.isEmpty(r3) == true) goto L12;
        ((DownloadTTNetException) r2).setRemoteIp(r3);
    L12:
        ((DownloadTTNetException) r2).parseRemoteIp();
        return;
    L17:
        return;
    }

    public static <K, V> void mapConvertToList(Map<K, V> r2, List<V> r3) {
        if (r2 == null) goto L11;
        if (r3 == null) goto L17;
        Iterator<Map.Entry<K, V>> r4 = r2.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L18;
        Map.Entry<K, V> r0 = r4.next();
        if (r0.getKey() == null) goto L7;
        r3.add(r0.getValue());
        goto L7
    L18:
        return;
    L17:
        return;
    }

    public static boolean moveFile(DownloadFile r6, DownloadFile r7) throws BaseException {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "moveFile", "DownloadFile Src:" + r6.getPath() + " Dest:" + r7.getPath());
    L6:
        if (DownloadFileUtils.isScopedStorage() == true) goto L8;
    L12:
        boolean r1 = r6.renameTo(r7);
    L13:
        if (r1 == true) goto L22;
        r1 = copyFile(r6, r7, true);
    L20:
        th = move-exception;
        th.printStackTrace();
        goto L22
    L16:
        if (Logger.debug() == false) goto L18;
        Logger.globalDebug(TAG, "moveFile", "Copy DownloadFile Src:" + r6.getPath() + " Dest:" + r7.getPath());     // Catch: Throwable -> L20
    L18:
        r6.delete();     // Catch: Throwable -> L20
    L22:
        return r1;
    L8:
        if (DownloadFileUtils.isFilePathInExternalPublicDir(r6.getAbsolutePath()) == true) goto L12;
        if (DownloadFileUtils.isFilePathInExternalPublicDir(r7.getAbsolutePath()) == false) goto L12;
        r1 = false;
        goto L13
    }

    public static void parseException(Throwable r3, String r4) throws BaseException {
        if (TextUtils.isEmpty(r4) == true) goto L5;
        String r0 = r4;
    L7:
        if ((r3 instanceof BaseException) == false) goto L9;
        BaseException r5 = (BaseException) r3;
        r5.setErrorMsg(r0 + "-" + r5.getErrorMessage());
        throw r5;
    L9:
        if ((r3 instanceof SSLHandshakeException) == true) goto L41;
        if (isTimeOutException(r3) == true) goto L39;
        if (isResponseCode412Error(r3) == true) goto L37;
        if (isResponseCode416Error(r3) == true) goto L35;
        if (isForbiddenException(r3) == true) goto L33;
        if (isNetNotAvailableException(r3) == true) goto L31;
        if (isConnectionException(r3) == true) goto L29;
        if ((r3 instanceof IOException) == false) goto L27;
        parseTTNetException(r3, r4);
        parseIOException((IOException) r3, r4);
        return;
    L27:
        throw new BaseException(1000, DownloadUtils.getErrorMsgWithTagPrefix(r3, r0));
    L29:
        throw new BaseException(1041, DownloadUtils.getErrorMsgWithTagPrefix(r3, r0));
    L31:
        throw new BaseException(1049, DownloadUtils.getErrorMsgWithTagPrefix(r3, r0));
    L33:
        throw new BaseException(1047, DownloadUtils.getErrorMsgWithTagPrefix(r3, r0));
    L35:
        throw new DownloadHttpException(1004, DownloadConstants.HTTP_REQUESTED_RANGE_NOT_SATISFIABLE, DownloadUtils.getErrorMsgWithTagPrefix(r3, r0));
    L37:
        throw new DownloadHttpException(1004, DownloadConstants.HTTP_PRECON_FAILED, DownloadUtils.getErrorMsgWithTagPrefix(r3, r0));
    L39:
        throw new BaseException(1048, DownloadUtils.getErrorMsgWithTagPrefix(r3, r0));
    L41:
        throw new BaseException(1011, DownloadUtils.getErrorMsgWithTagPrefix(r3, r0));
    L5:
        r0 = "";
        goto L7
    }

    public static void parseIOException(IOException r1, String r2) throws BaseException {
        if (r2 != null) goto L4;
        r2 = "";
    L4:
        String r3 = DownloadUtils.getErrorMsgWithTagPrefix(r1, r2);
        if ((r1 instanceof ConnectException) == true) goto L73;
        if ((r1 instanceof UnknownHostException) == true) goto L71;
        if ((r1 instanceof NoRouteToHostException) == true) goto L69;
        if ((r1 instanceof UnknownServiceException) == true) goto L67;
        if ((r1 instanceof PortUnreachableException) == true) goto L65;
        if ((r1 instanceof SocketTimeoutException) == true) goto L63;
        if ((r1 instanceof SocketException) == true) goto L61;
        if ((r1 instanceof HttpRetryException) == true) goto L59;
        if ((r1 instanceof ProtocolException) == true) goto L57;
        if ((r1 instanceof MalformedURLException) == true) goto L55;
        if ((r1 instanceof FileNotFoundException) == true) goto L53;
        if ((r1 instanceof InterruptedIOException) == true) goto L51;
        if ((r1 instanceof UnsupportedEncodingException) == true) goto L49;
        if ((r1 instanceof EOFException) == true) goto L47;
        if ((r1 instanceof StreamResetException) == true) goto L45;
        if ((r1 instanceof SSLException) == true) goto L43;
        if (DownloadUtils.isInsufficientSpaceError(r1) == false) goto L41;
        throw new BaseException(1006, r3);
    L41:
        throw new BaseException(1023, r3);
    L43:
        throw new BaseException(1011, r3);
    L45:
        throw new BaseException(1067, r3);
    L47:
        throw new BaseException(1066, r3);
    L49:
        throw new BaseException(1065, r3);
    L51:
        throw new BaseException(1064, r3);
    L53:
        throw new BaseException(1063, r3);
    L55:
        throw new BaseException(1062, r3);
    L57:
        throw new BaseException(1061, r3);
    L59:
        throw new BaseException(1060, r3);
    L61:
        throw new BaseException(1059, r3);
    L63:
        throw new BaseException(1048, r3);
    L65:
        throw new BaseException(1058, r3);
    L67:
        throw new BaseException(1057, r3);
    L69:
        throw new BaseException(1056, r3);
    L71:
        throw new BaseException(1055, r3);
    L73:
        throw new BaseException(1041, r3);
    }

    private static void parseTTNetException(Throwable r0, String r1) throws DownloadTTNetException {
        DownloadTTNetException r2 = getTTNetException(r0, r1);
        if (r2 != null) goto L5;
        return;
    L5:
        throw r2;
    }

    public static void removeHeaderKey(List<HttpHeader> r2, String r3) {
        if (r2 == null) goto L24;
        if (r3 == null) goto L25;
        Iterator<HttpHeader> r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L26;
        HttpHeader r0 = r4.next();
        if (r0 == null) goto L7;
        if (TextUtils.isEmpty(r0.getName()) == true) goto L7;
        if (r0.getName().contains(r3) == false) goto L7;
        r4.remove();
        return;
    L26:
        return;
    L25:
        return;
    }

    public static void setAppInfo(String r1, String r2) {
        if (TextUtils.isEmpty(r1) == true) goto L6;
        sAid = r1;
    L6:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        sChannel = r2;
        return;
    }

    public static <K> void sparseArrayPutAll(SparseArray<K> r2, Map<Integer, K> r3) {
        if (r3 == null) goto L11;
        if (r2 == null) goto L17;
        Iterator<Map.Entry<Integer, K>> r4 = r3.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L18;
        Map.Entry<Integer, K> r0 = r4.next();
        if (r0.getKey() == null) goto L7;
        r2.put(r0.getKey().intValue(), r0.getValue());
        goto L7
    L18:
        return;
    L17:
        return;
    }

    public static void addTTNetParam(DownloadSetting r5, List<HttpHeader> r6, DownloadInfo r7) {
        long r0 = r7.getThrottleNetSpeed();
        if (r0 <= 0) goto L5;
        r6.add(new HttpHeader(DownloadConstants.EXTRA_THROTTLE_NET_SPEED, String.valueOf(r0)));
    L5:
        long r1 = r7.getTtnetProtectTimeout();
        if (r1 <= 300) goto L9;
        r6.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_PROTECT_TIMEOUT, String.valueOf(r1)));
    L9:
        if (r7.isAddTTNetCommonParam() == false) goto L12;
        r6.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_TTNET_COMMON_PARAMS, "true"));
    L12:
        if (r7.isTTNetByPassProxy() == false) goto L15;
        r6.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_TTNET_BYPASS_PROXY, "true"));
    L15:
        if (r5.optInt("enable_download_network_tag", 0) <= 0) goto L17;
        r6.add(new HttpHeader(DownloadInnerConstants.TTNET_BIZ_ID_HEADER_NAME, "dl"));
        r6.add(new HttpHeader(DownloadInnerConstants.TTNET_BIZ_VERSION_HEADER_NAME, "1.3.8.111-rc.0"));
    L17:
        int r2 = r5.optInt("ttnet_proto_type", 0);
        if (r2 <= 0) goto L21;
        r6.add(new HttpHeader(TTNET_PROTO_TYPE, String.valueOf(r2)));
    L21:
        if (r5.optInt("fix_vulnerability_csrf", 1) <= 0) goto L24;
        r6.add(new HttpHeader(SECURITY_ARGUS_KEY, getSecurityValue()));
    L24:
        if (r7.getConcurrentConnCount() > 1) goto L26;
        return;
    L26:
        if (r7.getConcurrentConnCount() > 8) goto L30;
        r6.add(new HttpHeader(DownloadConstants.EXTRA_TTNET_CONCURRENT_CONN_COUNT, String.valueOf(r7.getConcurrentConnCount())));
        return;
    }

    public static boolean copyFile(DownloadFile r6, DownloadFile r7, boolean r8) throws BaseException {
        if (r6 == null) goto L42;
        if (r7 == null) goto L42;
    L40:
        e = move-exception;
        throw e;
    L37:
        th = move-exception;
        parseException(th, "CopyFile");
        return false;
    L6:
        if (r6.exists() == false) goto L42;
        if (r6.isDirectory() == true) goto L42;
        if (r6.getAbsolutePath().equals(r7.getAbsolutePath()) == true) goto L42;
        if (r7.isTypeFile() == false) goto L25;
        File r2 = r7.getParentFile();     // Catch: Throwable -> L37 BaseException -> L40
        if (r2 == null) goto L25;
        if (r2.mkdirs() == true) goto L25;
        if (r2.isDirectory() == true) goto L25;
        throw new BaseException(1053, "Destination '" + r2 + "' directory cannot be created");     // Catch: Throwable -> L37 BaseException -> L40
    L25:
        if (Logger.debug() == false) goto L28;
        Logger.globalDebug(TAG, "copyFile", "SrcFile:" + r6.getPath() + " DestFile:" + r7.getPath());     // Catch: Throwable -> L37 BaseException -> L40
    L28:
        if (r7.exists() == true) goto L30;
    L34:
        doCopyFile(r6, r7, r8);     // Catch: Throwable -> L37 BaseException -> L40
        return true;
    L30:
        if (r7.canWrite() == true) goto L34;
        throw new IOException("Destination '" + r7.getAbsolutePath() + "' exists but is read-only");     // Catch: Throwable -> L37 BaseException -> L40
    L42:
        return false;
    }

    public static void copyFileFromExistFileWithSameName(DownloadInfo r5, String r6, String r7) throws BaseException {
        if (r5 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r7) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r6) == false) goto L8;
        return;
    L8:
        if (r7.equals(r5.getName()) == true) goto L28;
        DownloadFile r8 = new DownloadFile(r5.getSavePath(), r7);
        DownloadFile r0 = new DownloadFile(r5.getSavePath(), r5.getName());
        if (Logger.debugScene(r5) == false) goto L14;
        Logger.taskDebug(TAG, r5, "copyFileFromExistFileWithSameName", "ExistFile:" + r8.getPath() + " targetFile:" + r0.getPath());
    L14:
        if (r0.exists() == false) goto L21;
        if (r0.canWrite() == true) goto L21;
        throw new BaseException(1001, "targetPath file exists but read-only");
    L21:
        if ((!copyFile(r8, r0, true)) == true) goto L24;
        return;
    L24:
        throw new BaseException(1001, String.format("Can't copy the exist file(%s/%s) to the target file(%s/%s)", new Object[]{r5.getSavePath(), r7, r5.getSavePath(), r5.getName()}));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void copyFileToExternal(Context r6, String r7, Uri r8) {
        ContentResolver r9 = r6.getContentResolver();
        PolarisFileInputStreamWrapper r2 = null;
        PolarisFileInputStreamWrapper r3 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r7));     // Catch: Throwable -> L17 IOException -> L19
        if (r8 != null) goto L31;
    L10:
        if (r2 == null) goto L16;
        byte[] r10 = new byte[DownloadComponentManager.getWriteBufferSize()];     // Catch: Throwable -> L6 IOException -> L8
    L12:
        int r11 = r3.read(r10);     // Catch: Throwable -> L6 IOException -> L8
        if (r11 == (-1)) goto L16;
        r2.write(r10, 0, r11);     // Catch: Throwable -> L6 IOException -> L8
        goto L12
    L8:
        e = e;
        PolarisFileInputStreamWrapper r12 = r2;
        r2 = r3;
    L27:
        Logger.globalError(TAG, "copyFileToExternal", "Error:" + e);     // Catch: Throwable -> L24
        DownloadUtils.safeClose(new Closeable[]{r2});
        DownloadUtils.safeClose(new Closeable[]{r12});
        return;
    L24:
        th = th;
    L25:
        DownloadUtils.safeClose(new Closeable[]{r2});
        DownloadUtils.safeClose(new Closeable[]{r12});
        throw th;
    L6:
        th = th;
        r12 = r2;
        r2 = r3;
    L16:
        DownloadUtils.safeClose(new Closeable[]{r3});
        DownloadUtils.safeClose(new Closeable[]{r2});
        return;
    L31:
        r2 = ContentResolverWrapper.openOutputStream(r9, r8);     // Catch: Throwable -> L6 IOException -> L8
        goto L10
    L19:
        e = e;
        r12 = null;
    L17:
        th = th;
        r12 = null;
        goto L25
    }

    private static void doCopyFile(DownloadFile r17, DownloadFile r18, boolean r19) throws IOException {
        if (r18.exists() == false) goto L10;
        if (r18.isDirectory() == false) goto L10;
        throw new IOException("Destination '" + r18 + "' exists but is a directory");
    L10:
        if (DownloadFileUtils.isExternalDownloadEnabled() == false) goto L16;
        if (r18.getFileType() <= 1) goto L16;
        copyFileToExternal(DownloadComponentManager.getAppContext(), r17.getPath(), UriProtector.parse(r18.getRealPath()));
        return;
    L16:
        if (Build.VERSION.SDK_INT >= 29) goto L18;
    L25:
        FileInputStream r1 = r17.obtainInputStream();
        FileChannel r8 = r1.getChannel();     // Catch: Throwable -> L88
        FileOutputStream r9 = r18.obtainOutputStream();     // Catch: Throwable -> L76
        FileChannel r10 = r9.getChannel();     // Catch: Throwable -> L64
        long r11 = r8.size();     // Catch: Throwable -> L52
        long r15 = 0;
    L31:
        if (r15 >= r11) goto L41;
        long r2 = r11 - r15;     // Catch: Throwable -> L52
        if (r2 <= FILE_COPY_BUFFER_SIZE) goto L35;
        long r6 = 31457280;
    L36:
        long r3 = r10.transferFrom(r8, r15, r6);     // Catch: Throwable -> L52
    L38:
        if (r3 == 0) goto L41;
        r15 = r15 + r3;
        goto L31
    L35:
        r6 = r2;
    L41:
        if (r10 == null) goto L43;
        r10.close();     // Catch: Throwable -> L64
    L43:
        r9.close();     // Catch: Throwable -> L76
        r8.close();     // Catch: Throwable -> L88
        r1.close();
        long r4 = r17.length();
        long r5 = r18.length();
        if (r4 != r5) goto L51;
        if (r19 == false) goto L122;
        r18.setLastModified(r17.lastModified());
        return;
    L122:
        return;
    L51:
        throw new IOException("Failed to copy full contents from '" + r17 + "' to '" + r18 + "' Expected length: " + r4 + " Actual: " + r5);
    L52:
        th = move-exception;
        throw th;     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        if (r10 == null) goto L123;
        r10.close();     // Catch: Throwable -> L60
    L124:
        throw th;     // Catch: Throwable -> L64
    L60:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L64
        throw th;     // Catch: Throwable -> L64
    L123:
        throw th;     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        throw th;     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        if (r9 == null) goto L125;
        r9.close();     // Catch: Throwable -> L72
    L126:
        throw th;     // Catch: Throwable -> L76
    L72:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L76
        throw th;     // Catch: Throwable -> L76
    L125:
        throw th;     // Catch: Throwable -> L76
    L76:
        th = move-exception;
        throw th;     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        if (r8 == null) goto L127;
        r8.close();     // Catch: Throwable -> L84
    L128:
        throw th;     // Catch: Throwable -> L88
    L84:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L88
        throw th;     // Catch: Throwable -> L88
    L127:
        throw th;     // Catch: Throwable -> L88
    L88:
        th = move-exception;
        throw th;     // Catch: Throwable -> L91
    L91:
        th = move-exception;
        if (r1 == null) goto L129;
        r1.close();     // Catch: Throwable -> L96
        throw th;
    L96:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L129:
        throw th;
    L18:
        if (DownloadFileUtils.isFilePathInExternalPublicDir(r18.getPath()) == false) goto L25;
        Uri r7 = DownloadFileUtils.getUriFromFilePath(r18.getPath());
        if (r7 == null) goto L24;
        copyFileToExternal(DownloadComponentManager.getAppContext(), r17.getPath(), r7);
        return;
    L24:
        throw new IOException("Destination " + r18 + "exists but contentUri is null");
    }

    private static void handleTempSaveCallback(int r3, boolean r4, BaseException r5) {
        SparseArray<Boolean> r0 = saveTempFileStatusMap;
        monitor-enter(r0);
        List<ITempFileSaveCompleteCallback> r1 = saveTempFileListeners.get(r3);     // Catch: Throwable -> L20
        if (r1 == null) goto L15;
        Iterator<ITempFileSaveCompleteCallback> r2 = r1.iterator();     // Catch: Throwable -> L20
    L8:
        if (r2.hasNext() == false) goto L15;
        ITempFileSaveCompleteCallback r6 = r2.next();     // Catch: Throwable -> L20
        if (r6 == null) goto L8;
        if (r4 == true) goto L12;
        r6.onFailed(r5);     // Catch: Throwable -> L20
        goto L8
    L12:
        r6.onSuccess();     // Catch: Throwable -> L20
    L15:
        if (Logger.debug() == false) goto L17;
        Logger.taskDebug(TAG, r3, "handleTempSaveCallback", "Run");     // Catch: Throwable -> L20
    L17:
        saveTempFileStatusMap.remove(r3);     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public static void saveFileAsTargetName(DownloadInfo r20, IDownloadMonitorDepend r21, ITempFileSaveCompleteCallback r22) {
        if (Logger.debugScene(r20) == false) goto L111;
        Logger.taskDebug(TAG, r20, "saveFileAsTargetName", "TargetName: " + r20.getTargetFilePath());
    L111:
        SparseArray<Boolean> r7 = saveTempFileStatusMap;     // Catch: Throwable -> L101
        monitor-enter(r7);     // Catch: Throwable -> L101
        Boolean r8 = saveTempFileStatusMap.get(r20.getId());     // Catch: Throwable -> L98
        Boolean r9 = Boolean.TRUE;     // Catch: Throwable -> L98
        if (r8 != r9) goto L11;
        boolean r10 = true;
    L12:
        if (r10 == false) goto L24;
        if (Logger.debugScene(r20) == false) goto L16;
        Logger.taskDebug(TAG, r20, "saveFileAsTargetName", "Has another same task is saving temp file");     // Catch: Throwable -> L98
    L16:
        if (r22 == null) goto L21;
        List<ITempFileSaveCompleteCallback> r0 = saveTempFileListeners.get(r20.getId());     // Catch: Throwable -> L98
        if (r0 != null) goto L20;
        r0 = new ArrayList();     // Catch: Throwable -> L98
        saveTempFileListeners.put(r20.getId(), r0);     // Catch: Throwable -> L98
    L20:
        r0.add(r22);     // Catch: Throwable -> L98
        r22.onSameTaskSave();     // Catch: Throwable -> L98
    L21:
        monitor-exit(r7);     // Catch: Throwable -> L98
        return;
    L24:
        if (Logger.debugScene(r20) == false) goto L26;
        Logger.taskDebug(TAG, r20, "saveFileAsTargetName", "SaveTempFileStatusMap put id:" + r20.getId());     // Catch: Throwable -> L98
    L26:
        saveTempFileStatusMap.put(r20.getId(), r9);     // Catch: Throwable -> L98
        monitor-exit(r7);     // Catch: Throwable -> L98
        DownloadFile r4 = new DownloadFile(r20.getTempPath(), r20.getTempName());     // Catch: Throwable -> L101
        DownloadFile r11 = new DownloadFile(r20.getSavePath(), r20.getName());     // Catch: Throwable -> L101
        if (r20.isForce() == true) goto L65;
        if (DownloadFileUtils.existsAndNotEmpty(r11) == false) goto L65;
        if (DownloadUtils.checkFileLength(r20, r11) == false) goto L65;
        if (Logger.debugScene(r20) == false) goto L37;
        Logger.taskDebug(TAG, r20, "saveFileAsTargetName", "TargetFile exist");     // Catch: Throwable -> L101
    L37:
        long r16 = SystemClock.uptimeMillis();     // Catch: Throwable -> L101
        int r5 = DownloadUtils.checkMd5Status(r11, r20.getMd5());     // Catch: Throwable -> L101
        r20.setMd5Time(SystemClock.uptimeMillis() - r16);     // Catch: Throwable -> L101
        if (DownloadUtils.isMd5Valid(r5) == false) goto L48;
        if (Logger.debugScene(r20) == false) goto L42;
        Logger.taskDebug(TAG, r20, "saveFileAsTargetName", "TempFile not exist , targetFile exists and md5 check valid");     // Catch: Throwable -> L101
    L42:
        r20.setTTMd5CheckStatus(r5);     // Catch: Throwable -> L101
        if (r22 == null) goto L45;
        r22.onSuccess();     // Catch: Throwable -> L101
    L45:
        handleTempSaveCallback(r20.getId(), true, null);     // Catch: Throwable -> L101
    L46:
        boolean r12 = false;
    L63:
        boolean r1 = r12;
    L72:
        if (r1 == false) goto L112;
        int r2 = DownloadSetting.obtain(r20.getId()).optInt("download_finish_check_ttmd5", 2);     // Catch: BaseException -> L86 Throwable -> L101
        if (r2 <= 0) goto L85;
        long r13 = SystemClock.uptimeMillis();     // Catch: BaseException -> L86 Throwable -> L101
        int r3 = DownloadUtils.checkMd5Status(r4, r20.getMd5());     // Catch: BaseException -> L86 Throwable -> L101
        r20.setMd5Time(SystemClock.uptimeMillis() - r13);     // Catch: BaseException -> L86 Throwable -> L101
        r20.setTTMd5CheckStatus(r3);     // Catch: BaseException -> L86 Throwable -> L101
        if (r2 < 2) goto L85;
        if (DownloadUtils.isMd5Valid(r3) == true) goto L85;
        BaseException r6 = new BaseException(1034, DownloadUtils.getMd5StatusMsg(r3));     // Catch: BaseException -> L86 Throwable -> L101
        if (r22 == null) goto L82;
        r22.onFailed(r6);     // Catch: BaseException -> L86 Throwable -> L101
    L82:
        handleTempSaveCallback(r20.getId(), false, r6);     // Catch: BaseException -> L86 Throwable -> L101
        DownloadUtils.deleteAllDownloadFiles(r20, DownloadDirUtils.isSavePathSecurity(r20.getSavePath()));     // Catch: BaseException -> L86 Throwable -> L101
        return;
    L85:
        boolean r14 = !moveFile(r4, r11);
        BaseException r15 = null;
    L88:
        if (r14 == false) goto L94;
        if (r15 != null) goto L91;
        r15 = new BaseException(1038, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s)", new Object[]{r20.getTempPath(), r20.getTempName(), r20.getSavePath(), r20.getName()}));     // Catch: Throwable -> L101
    L91:
        if (r22 == null) goto L93;
        r22.onFailed(r15);     // Catch: Throwable -> L101
    L93:
        handleTempSaveCallback(r20.getId(), false, r15);     // Catch: Throwable -> L101
        return;
    L94:
        if (r22 == null) goto L96;
        r22.onSuccess();     // Catch: Throwable -> L101
    L96:
        handleTempSaveCallback(r20.getId(), true, null);     // Catch: Throwable -> L101
        return;
    L86:
        e = move-exception;
        r15 = e;
        r14 = true;
        goto L88
    L112:
        return;
    L48:
        if (r4.exists() == true) goto L53;
        BaseException r17 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist and target file is exist but md5 verify invalid :%s", new Object[]{r20.getTempPath(), r20.getTempName(), r20.getSavePath(), r20.getName(), DownloadUtils.getMd5StatusMsg(r5)}));     // Catch: Throwable -> L101
        if (r22 == null) goto L52;
        r22.onFailed(r17);     // Catch: Throwable -> L101
    L52:
        handleTempSaveCallback(r20.getId(), false, r17);     // Catch: Throwable -> L101
        r12 = false;
    L55:
        if (r11.delete() == true) goto L63;
        if (r12 == true) goto L59;
        if (r21 == null) goto L63;
        DownloadMonitorHelper.monitorSendWithTaskMonitor(r21, r20, new BaseException(1038, "tempFile is not exist and target file is exist but md5 verify invalid, delete target file failed"), r20.getStatus());     // Catch: Throwable -> L101
        goto L63
    L59:
        BaseException r18 = new BaseException(1037, "delete targetPath file existed with md5 check invalid status:" + DownloadUtils.getMd5StatusMsg(r5));     // Catch: Throwable -> L101
        if (r22 == null) goto L62;
        r22.onFailed(r18);     // Catch: Throwable -> L101
    L62:
        handleTempSaveCallback(r20.getId(), false, r18);     // Catch: Throwable -> L101
        goto L46
    L53:
        r12 = true;
    L65:
        if (r4.exists() == true) goto L71;
        BaseException r19 = new BaseException(1005, String.format("Can't save the temp downloaded file(%s/%s) to the target file(%s/%s) because tempFile is not exist", new Object[]{r20.getTempPath(), r20.getTempName(), r20.getSavePath(), r20.getName()}));     // Catch: Throwable -> L101
        if (r22 == null) goto L69;
        r22.onFailed(r19);     // Catch: Throwable -> L101
    L69:
        handleTempSaveCallback(r20.getId(), false, r19);     // Catch: Throwable -> L101
        r1 = false;
        goto L72
    L71:
        r1 = true;
        goto L72
    L11:
        r10 = false;
    L98:
        th = move-exception;
        throw th;     // Catch: Throwable -> L101
    L101:
        th = move-exception;
        BaseException r23 = new BaseException(1038, DownloadUtils.getErrorMsgWithTagPrefix(th, "saveFileAsTargetName") + " " + Log.getStackTraceString(th));
        if (Logger.debugScene(r20) == false) goto L105;
        Logger.taskDebug(TAG, r20, "saveFileAsTargetName", "Error: " + r23);
    L105:
        if (r22 == null) goto L107;
        r22.onFailed(r23);
    L107:
        handleTempSaveCallback(r20.getId(), false, r23);
    }

    public static boolean copyFile(File r1, File r2, boolean r3) throws BaseException {
        return copyFile(new DownloadFile(r1), new DownloadFile(r2), r3);
    }

    public static List<HttpHeader> addRangeHeader(List<HttpHeader> r5, String r6, long r7, long r9) {
        ArrayList r0 = new ArrayList();
        if (r5 == null) goto L19;
        if (r5.size() <= 0) goto L19;
        Iterator<HttpHeader> r8 = r5.iterator();
    L8:
        if (r8.hasNext() == false) goto L19;
        HttpHeader r2 = r8.next();
        if (r2 == null) goto L8;
        if (ACCEPT_ENCODING.equalsIgnoreCase(r2.getName()) == false) goto L17;
        if (GZIP.equalsIgnoreCase(r2.getValue()) == true) goto L8;
    L17:
        r0.add(r2);
    L19:
        if (TextUtils.isEmpty(r6) == true) goto L21;
        r0.add(new HttpHeader(IF_MATCH, r6));
    L21:
        r0.add(new HttpHeader(ACCEPT_ENCODING, IDENTITY));
        if (r9 > 0) goto L24;
        String r10 = String.format(Locale.US, "bytes=%d-", new Object[]{Long.valueOf(r7)});
    L25:
        r0.add(new HttpHeader("Range", r10));
        if (Logger.debug() == false) goto L28;
        Logger.globalDebug(TAG, "addRangeHeader", "CurrentOffset:" + r7 + " EndOffset:" + r9 + ", range = " + r10);
    L28:
        return r0;
    L24:
        r10 = String.format(Locale.US, "bytes=%d-%d", new Object[]{Long.valueOf(r7), Long.valueOf(r9)});
        goto L25
    }

    public static RandomAccessOutputStream createOutputStream(DownloadInfo r8, String r9, String r10, int r11, boolean r12) throws BaseException {
        if (TextUtils.isEmpty(r9) == true) goto L60;
        if (TextUtils.isEmpty(r10) == true) goto L60;
        PolarisFileWrapper r2 = new PolarisFileWrapper(r9, r10);
        boolean r4 = false;
        if (r2.exists() == false) goto L14;
        if (r2.isDirectory() == false) goto L14;
        throw new BaseException(1035, new IOException(String.format("path is :%s, path is directory:%B:", new Object[]{r9, Boolean.valueOf(r2.isDirectory())})));
    L14:
        if (r2.exists() == true) goto L58;
        PolarisFileWrapper r13 = new PolarisFileWrapper(r9);     // Catch: IOException -> L54
        if (r13.exists() == false) goto L20;
        if (r13.isDirectory() == false) goto L20;
    L45:
        r2.createNewFile();     // Catch: IOException -> L54
    L20:
        if (r13.exists() == false) goto L22;
        r13.delete();     // Catch: IOException -> L54
        if (r13.mkdirs() == true) goto L53;
        if (r13.exists() == true) goto L53;
        throw new BaseException(1031, "download savePath is not directory:path=" + r9);     // Catch: IOException -> L54
    L53:
        throw new BaseException(1031, "download savePath is not directory:" + r9);     // Catch: IOException -> L54
    L22:
        if (r13.mkdirs() == true) goto L45;
        if (r13.exists() == true) goto L45;
        if (DownloadSetting.obtain(r8).optInt("opt_mkdir_failed", 0) != 1) goto L44;
        int r0 = 0;
    L29:
        if (r4 == true) goto L36;
        int r3 = r0 + 1;
        if (r0 >= 3) goto L36;
        Thread.sleep(10);     // Catch: InterruptedException -> L35 IOException -> L54
        r4 = r13.mkdirs();     // Catch: IOException -> L54
        r0 = r3;
    L36:
        if (r4 == true) goto L45;
        if (DownloadUtils.getAvailableSpaceBytes(r8.getSavePath()) >= DownloadConstants.MK_DIR_MIN_SPACE) goto L42;
        throw new BaseException(1006, "download savePath directory can not created:" + r9);     // Catch: IOException -> L54
    L42:
        throw new BaseException(1030, "download savePath directory can not created:" + r9);     // Catch: IOException -> L54
    L44:
        throw new BaseException(1030, "download savePath directory can not created:" + r9);     // Catch: IOException -> L54
    L54:
        e = move-exception;
        throw new BaseException(1036, e);
    L58:
        return new RandomAccessOutputStream(r2, r11, r12);
    L60:
        throw new BaseException(1021, new IOException("path must be not empty"));
    }

    public static boolean hitSkipDbInitScene(Set<String> r2, Set<String> r3, Set<String> r4, String r5, String r6) {
        if (r2 != null) goto L5;
    L9:
        if (r3 != null) goto L11;
    L16:
        return false;
    L11:
        if (r3.contains(r5) == true) goto L16;
        if (r4 != null) goto L14;
        return true;
    L14:
        if (r4.contains(r6) == true) goto L16;
        return true;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L9;
        if (r2.contains(r6) == false) goto L9;
        return true;
    }
}
