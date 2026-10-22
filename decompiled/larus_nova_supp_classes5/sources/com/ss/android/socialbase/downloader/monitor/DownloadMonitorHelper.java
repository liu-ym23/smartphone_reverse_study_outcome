package com.ss.android.socialbase.downloader.monitor;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.AbsDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadCdnListener;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IMonitorConfig;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.model.DownloadCdnStats;
import com.ss.android.socialbase.downloader.model.DownloadDBInitInfo;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.DownloadThreadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTimingInfo;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDefaultDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadMonitorHelper {
    private static final String DEFAULT_MONITOR_SCENE = "default";

    public DownloadMonitorHelper() {
    }

    public static void monitorSqliteMalformed() {
        IDownloadMonitorListener r0 = DownloadComponentManager.getDownloadMonitorListener();
        if (r0 != null) goto L10;
        return;
    L10:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L7
        r1.put("info_type", "sqlite_malformed");     // Catch: Throwable -> L7
        r1.put("is_malformed", 1);     // Catch: Throwable -> L7
        r0.monitorEvent("download_other_info", r1, null, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public static /* synthetic */ JSONObject access$100(DownloadMonitorInfo r0) {
        return parseMonitorJson(r0);
    }

    public static void monitorDownloadDB(DownloadDBInitInfo r5) {
        IDownloadMonitorListener r0 = DownloadComponentManager.getDownloadMonitorListener();
        if (r0 != null) goto L10;
        return;
    L10:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L7
        r1.put("db_init_duration", r5.initDuration);     // Catch: Throwable -> L7
        r1.put("db_init_disk_cache_count", r5.diskCacheCount);     // Catch: Throwable -> L7
        r1.put("db_init_memory_cache_count", r5.memoryCacheCount);     // Catch: Throwable -> L7
        r1.put("db_init_cpu_duration", r5.initCpuDuration);     // Catch: Throwable -> L7
        r0.monitorEvent("download_db", r1, null, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public static void monitorDownloadDiskCache(JSONObject r3) {
        IDownloadMonitorListener r0 = DownloadComponentManager.getDownloadMonitorListener();
        if (r0 != null) goto L10;
        return;
    L10:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L7
        r1.put("disk_data", r3.toString());     // Catch: Throwable -> L7
        r0.monitorEvent("download_disk_cache", r1, null, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public static void monitorDownloadOtherError(Throwable r4) {
        IDownloadMonitorListener r0 = DownloadComponentManager.getDownloadMonitorListener();
        if (r0 != null) goto L10;
        return;
    L10:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L7
        r1.put("error_code", 1091);     // Catch: Throwable -> L7
        r1.put("error_msg", r4.toString());     // Catch: Throwable -> L7
        r1.put("download_status", -1);     // Catch: Throwable -> L7
        r1.put("error_stack", Log.getStackTraceString(r4));     // Catch: Throwable -> L7
        r0.monitorEvent("download_failed", r1, null, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public static void monitorLru(boolean r4) {
        IDownloadMonitorListener r0 = DownloadComponentManager.getDownloadMonitorListener();
        if (r0 != null) goto L14;
        return;
    L14:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L11
        r1.put("info_type", "lru_cache");     // Catch: Throwable -> L11
        if (r4 == false) goto L8;
        int r5 = 1;
    L9:
        r1.put("enable_lru", r5);     // Catch: Throwable -> L11
        r0.monitorEvent("download_other_info", r1, null, null);     // Catch: Throwable -> L11
        return;
    L8:
        r5 = 0;
    L11:
        th = move-exception;
        th.printStackTrace();
    }

    private static JSONObject parseMonitorJson(DownloadMonitorInfo r10) {
        JSONObject r1 = null;
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L129
        IMonitorConfig r3 = DownloadComponentManager.getMonitorConfig();     // Catch: JSONException -> L127
        int r4 = 0;
        String r5 = "";
        if (r3 == null) goto L8;
        String r6 = r3.getDeviceId();     // Catch: JSONException -> L127
        String r7 = DownloadUtils.parseDevicePostfix(r6);     // Catch: JSONException -> L127
        String r8 = r3.getAppId();     // Catch: JSONException -> L127
        int r9 = r3.getUpdateVersion();     // Catch: JSONException -> L127
    L9:
        r2.put("event_page", r10.eventPage);     // Catch: JSONException -> L127
        r2.put("app_id", r8);     // Catch: JSONException -> L127
        r2.put(EffectConfiguration.KEY_DEVICE_ID, r6);     // Catch: JSONException -> L127
        r2.put("device_id_postfix", r7);     // Catch: JSONException -> L127
        r2.put("update_version", r9);     // Catch: JSONException -> L127
        r2.put("download_status", r10.monitorStatus);     // Catch: JSONException -> L127
        r2.put("setting_tag", DownloadSetting.obtain(r10.id).optString("setting_tag"));     // Catch: JSONException -> L127
        r2.put("download_id", r10.id);     // Catch: JSONException -> L127
        r2.put(DBDefinition.NAME, r10.name);     // Catch: JSONException -> L127
        r2.put("url", r10.url);     // Catch: JSONException -> L127
        r2.put("save_path", r10.savePath);     // Catch: JSONException -> L127
        r2.put("download_time", r10.downloadTime);     // Catch: JSONException -> L127
        r2.put("cur_bytes", r10.curBytes);     // Catch: JSONException -> L127
        r2.put("background_download_bytes", r10.backCurBytes);     // Catch: JSONException -> L127
        r2.put("total_bytes", r10.totalBytes);     // Catch: JSONException -> L127
        r2.put("network_quality", r10.networkQuality);     // Catch: JSONException -> L127
        int r11 = 1;
        if (r10.onlyWifi == false) goto L12;
        int r12 = 1;
    L13:
        r2.put("only_wifi", r12);     // Catch: JSONException -> L127
        if (r10.needHttpsToHttpRetry == false) goto L16;
        int r13 = 1;
    L17:
        r2.put("need_https_degrade", r13);     // Catch: JSONException -> L127
        if (r10.httpsToHttpRetryUsed == false) goto L20;
        int r14 = 1;
    L21:
        r2.put("https_degrade_retry_used", r14);     // Catch: JSONException -> L127
        String r15 = r10.md5;     // Catch: JSONException -> L127
        if (r15 != null) goto L24;
        r15 = "";
    L24:
        r2.put(DBDefinition.MD5, r15);     // Catch: JSONException -> L127
        if (r10.force == false) goto L27;
        int r16 = 1;
    L28:
        r2.put("is_force", r16);     // Catch: JSONException -> L127
        r2.put("retry_count", r10.retryCount);     // Catch: JSONException -> L127
        if (r10.needDefaultHttpServiceBackUp == false) goto L31;
        int r17 = 1;
    L32:
        r2.put("default_http_service_backup", r17);     // Catch: JSONException -> L127
        r2.put("download_byte_error_retry_status", r10.byteInvalidRetryStatus.ordinal());     // Catch: JSONException -> L127
        r2.put("forbidden_handler_status", r10.asyncHandleStatus.ordinal());     // Catch: JSONException -> L127
        if (r10.needIndependentProcess == false) goto L35;
        int r18 = 1;
    L36:
        r2.put("need_independent_process", r18);     // Catch: JSONException -> L127
        String r19 = r10.extra;     // Catch: JSONException -> L127
        if (r19 != null) goto L40;
        r19 = "";
    L40:
        r2.put(DBDefinition.EXTRA, r19);     // Catch: JSONException -> L127
        if (r10.addListenerToSameTask == false) goto L43;
        int r20 = 1;
    L44:
        r2.put("add_listener_to_same_task", r20);     // Catch: JSONException -> L127
        List r21 = r10.backUpUrls;     // Catch: JSONException -> L127
        if (r21 == null) goto L47;
        int r22 = r21.size();     // Catch: JSONException -> L127
    L48:
        r2.put("backup_url_count", r22);     // Catch: JSONException -> L127
        List r23 = r10.backUpUrls;     // Catch: JSONException -> L127
        if (r23 == null) goto L51;
        String r24 = r23.toString();     // Catch: JSONException -> L127
    L52:
        r2.put("backup_url", r24);     // Catch: JSONException -> L127
        if (r10.backUpUrls == null) goto L55;
        int r25 = r10.curBackUpUrlIndex;     // Catch: JSONException -> L127
    L56:
        r2.put("cur_backup_url_index", r25);     // Catch: JSONException -> L127
        List r26 = r10.forbiddenBackupUrls;     // Catch: JSONException -> L127
        if (r26 == null) goto L59;
        String r27 = r26.toString();     // Catch: JSONException -> L127
    L60:
        r2.put("forbidden_urls", r27);     // Catch: JSONException -> L127
        r2.put("network_retry_count", r10.curNetworkRetryCount);     // Catch: JSONException -> L127
        r2.put("cache_exists_in_downloading", r10.isCacheExistsInDownloading);     // Catch: JSONException -> L127
        r2.put("content_type", r10.mimeType);     // Catch: JSONException -> L127
        r2.put("content_encoding", r10.contentEncoding);     // Catch: JSONException -> L127
        if (r10.fastDownload == false) goto L63;
        int r28 = 1;
    L64:
        r2.put("fast_download", r28);     // Catch: JSONException -> L127
        String r29 = r10.requestLog;     // Catch: JSONException -> L127
        if (r29 != null) goto L67;
        r29 = "";
    L67:
        r2.put("request_log", r29);     // Catch: JSONException -> L127
        String r30 = r10.httpRequestHeader;     // Catch: JSONException -> L127
        if (r30 != null) goto L70;
        r30 = "";
    L70:
        r2.put("request_header", r30);     // Catch: JSONException -> L127
        String r31 = r10.httpResponseHeader;     // Catch: JSONException -> L127
        if (r31 != null) goto L73;
        r31 = "";
    L73:
        r2.put("response_header", r31);     // Catch: JSONException -> L127
        r2.put("enqueue_type", r10.enqueueType);     // Catch: JSONException -> L127
        r2.put("sleep_time", r10.sleepTime);     // Catch: JSONException -> L127
        String r0 = DownloadUtils.getCurProcessName(DownloadComponentManager.getAppContext());     // Catch: JSONException -> L127
        if (r0 != null) goto L76;
        r0 = "";
    L76:
        r2.put("process_name", r0);     // Catch: JSONException -> L127
        String r32 = r10.callStack;     // Catch: JSONException -> L127
        if (r32 != null) goto L79;
        r32 = "";
    L79:
        r2.put("call_stack", r32);     // Catch: JSONException -> L127
        JSONObject r33 = r10.pcdnStats;     // Catch: JSONException -> L127
        if (r33 == null) goto L82;
        r2.put("pcdn_log", r33);     // Catch: JSONException -> L127
    L82:
        DownloadTimingInfo r34 = r10.downloadTimingInfo;     // Catch: JSONException -> L127
        if (r34 == null) goto L85;
        r2.put("origin_timing_info", r34.obtainOriginStats());     // Catch: JSONException -> L127
        r2.put("timing_info", r10.downloadTimingInfo.obtainDurationStats());     // Catch: JSONException -> L127
    L85:
        DownloadThreadInfo r35 = r10.downloadThreadInfo;     // Catch: JSONException -> L127
        if (r35 == null) goto L88;
        r2.put("thread_info", r35.obtainStats());     // Catch: JSONException -> L127
    L88:
        int r36 = r10.monitorStatus;     // Catch: JSONException -> L127
        if (r36 != (-3)) goto L91;
    L95:
        r2.put("all_connect_time", r10.allConnectTime);     // Catch: JSONException -> L127
        r2.put("first_speed_time", r10.firstSpeedTime);     // Catch: JSONException -> L127
        r2.put("real_download_time", r10.realDownloadTime);     // Catch: JSONException -> L127
        r2.put("background_download_time", r10.realBackDownloadTime);     // Catch: JSONException -> L127
        if (r10.backUpUrlUsed == true) goto L99;
        r11 = 0;
    L99:
        r2.put("backup_url_used", r11);     // Catch: JSONException -> L127
        r2.put("cur_retry_time", r10.curRetryTime);     // Catch: JSONException -> L127
        r2.put("cur_retry_time_in_total", r10.curRetryTimeInTotal);     // Catch: JSONException -> L127
        r2.put("md5_time", r10.md5Time);     // Catch: JSONException -> L127
        r2.put("device_available_space", ((DownloadUtils.getAvailableSpaceBytes(r10.savePath) / DownloadConstants.KB) / DownloadConstants.KB) / 100);     // Catch: Throwable -> L102
    L134:
    L117:
        th = move-exception;
        th.printStackTrace();     // Catch: JSONException -> L127
    L119:
        BaseException r37 = r10.exception;     // Catch: JSONException -> L127
        if (r37 == null) goto L122;
        r4 = r37.getErrorCode();     // Catch: JSONException -> L127
    L122:
        r2.put("error_code", r4);     // Catch: JSONException -> L127
        BaseException r110 = r10.exception;     // Catch: JSONException -> L127
        if (r110 == null) goto L125;
        r5 = r110.getErrorMessage();     // Catch: JSONException -> L127
    L125:
        r2.put("error_msg", r5);     // Catch: JSONException -> L127
        return r2;
    L105:
        if (TextUtils.isEmpty(r10.url) == true) goto L114;
        Uri r38 = UriProtector.parse(r10.url);     // Catch: Throwable -> L117
        String r39 = r38.getHost();     // Catch: Throwable -> L117
        String r40 = r38.getPath();     // Catch: Throwable -> L117
        String r41 = r38.getLastPathSegment();     // Catch: Throwable -> L117
        if (TextUtils.isEmpty(r40) == false) goto L109;
    L115:
        r2.put("url_host", r39);     // Catch: Throwable -> L117
        r2.put("url_path", r40);     // Catch: Throwable -> L117
        r2.put("url_last_path_segment", r41);     // Catch: Throwable -> L117
    L109:
        if (TextUtils.isEmpty(r41) == true) goto L115;
        r40 = r40.substring(0, r40.length() - r41.length());     // Catch: Throwable -> L112
    L112:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L117
        goto L115
    L114:
        r41 = "";
        r39 = r41;
        r40 = r39;
        goto L115
    L102:
        th = move-exception;
        th.printStackTrace();     // Catch: JSONException -> L127
        goto L134
    L91:
        if (r36 == (-4)) goto L95;
        if (r36 == (-1)) goto L95;
        if (r36 != (-2)) goto L134;
    L63:
        r28 = 0;
        goto L64
    L59:
        r27 = "";
        goto L60
    L55:
        r25 = -1;
        goto L56
    L51:
        r24 = "";
        goto L52
    L47:
        r22 = 0;
        goto L48
    L43:
        r20 = 0;
        goto L44
    L35:
        r18 = 0;
        goto L36
    L31:
        r17 = 0;
        goto L32
    L27:
        r16 = 0;
        goto L28
    L20:
        r14 = 0;
        goto L21
    L16:
        r13 = 0;
        goto L17
    L12:
        r12 = 0;
        goto L13
    L8:
        r6 = "";
        r7 = r6;
        r8 = r7;
        r9 = 0;
    L127:
        e = e;
        r1 = r2;
    L130:
        monitorDownloadOtherError(e);
        e.printStackTrace();
        return r1;
    L129:
        e = e;
        goto L130
    }

    public static /* synthetic */ void access$200(DownloadMonitorInfo r0, JSONObject r1) throws JSONException {
        putMonitorJsonStatus(r0, r1);
    }

    private static boolean isMonitorStatus(int[] r3, int r4) {
        if (r3 != null) goto L5;
    L14:
        return false;
    L5:
        if (r3.length <= 0) goto L14;
        int r1 = 0;
    L8:
        if (r1 >= r3.length) goto L14;
        if (r4 == r3[r1]) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        return true;
    }

    public static void monitorDBOptAnr(Throwable r4, int r5) {
        IDownloadMonitorListener r0 = DownloadComponentManager.getDownloadMonitorListener();
        if (r0 != null) goto L23;
        return;
    L23:
        StackTraceElement[] r6 = r4.getStackTrace();     // Catch: Throwable -> L20
        if (r6 != null) goto L8;
        return;
    L8:
        if (r6.length <= 0) goto L26;
        StringBuffer r1 = new StringBuffer();     // Catch: Throwable -> L20
        if (r5 < r6.length) goto L14;
        r5 = r6.length;     // Catch: Throwable -> L20
    L14:
        int r2 = 0;
    L15:
        if (r2 >= r5) goto L17;
        r1.append(r6[r2]);     // Catch: Throwable -> L20
        r2 = r2 + 1;     // Catch: Throwable -> L20
        goto L15
    L17:
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L20
        r7.put("info_type", "db_opt_anr");     // Catch: Throwable -> L20
        r7.put("db_opt_error_stack", r1.toString());     // Catch: Throwable -> L20
        r0.monitorEvent("download_other_info", r7, null, null);     // Catch: Throwable -> L20
        return;
    L26:
        return;
    L20:
        th = move-exception;
        th.printStackTrace();
    }

    public static void monitorSegmentsError(DownloadInfo r4, List<Segment> r5) {
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L6
        r1.put(DBDefinition.SEGMENT_TABLE_NAME, Segment.toString(r5));     // Catch: Throwable -> L6
        r1.put("cur_bytes", r4.getCurBytes());     // Catch: Throwable -> L6
        r1.put("total_bytes", r4.getTotalBytes());     // Catch: Throwable -> L6
        InnerEventListener r6 = DownloadComponentManager.getEventListener();     // Catch: Throwable -> L6
        if (r6 == null) goto L11;
        r6.onEvent(r4.getId(), "segments_error", r1);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    private static void putMonitorJsonStatus(DownloadMonitorInfo r5, JSONObject r6) throws JSONException {
        int r0 = r5.monitorStatus;
        if (r0 != (-5)) goto L5;
        String r7 = "download_uncomplete";
    L26:
        r6.put("status", r7);
        return;
    L5:
        if (r0 != (-4)) goto L7;
        r7 = "download_cancel";
        goto L26
    L7:
        if (r0 != (-3)) goto L9;
        double r1 = r5.downloadSpeed;
        if (r1 < 0.0d) goto L23;
        r6.put("download_speed", r1);
    L23:
        r6.put("throttle_net_speed", r5.throttleNetSpeed);
        r7 = "download_success";
        goto L26
    L9:
        if (r0 == (-2)) goto L19;
        if (r0 != 0) goto L12;
        r7 = "download_create";
        goto L26
    L12:
        if (r0 != 2) goto L14;
        r7 = "download_start";
        goto L26
    L14:
        if (r0 == 6) goto L16;
        r7 = "";
        goto L26
    L16:
        r7 = "download_first_start";
        goto L26
    L19:
        r7 = "download_pause";
        goto L26
    }

    public static void monitorDownloadApp(DownloadInfo r5, String r6, int r7) {
        IDownloadMonitorListener r0 = DownloadComponentManager.getDownloadMonitorListener();
        if (r0 != null) goto L10;
        return;
    L10:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L7
        r1.put("event_page", r5.getMonitorScene());     // Catch: Throwable -> L7
        r1.put("url", r5.getUrl());     // Catch: Throwable -> L7
        r1.put("total_bytes", r5.getTotalBytes());     // Catch: Throwable -> L7
        r1.put("cur_bytes", r5.getCurBytes());     // Catch: Throwable -> L7
        r1.put("save_path", r5.getSavePath());     // Catch: Throwable -> L7
        r1.put("install_status", r6);     // Catch: Throwable -> L7
        r1.put("install_result_code", r7);     // Catch: Throwable -> L7
        r0.monitorEvent("download_install_app", r1, null, null);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public static void monitorSend(DownloadTask r4, BaseException r5, int r6) {
        if (r4 != null) goto L27;
        return;
    L27:
        DownloadInfo r0 = r4.getDownloadInfo();     // Catch: Throwable -> L24
        if (r0 != null) goto L7;
        return;
    L7:
        AbsDownloadMonitorDepend r1 = r4.getMonitorDepend();     // Catch: Throwable -> L24
        boolean r2 = DownloadStatus.isMonitorStatus(r6);     // Catch: Throwable -> L24
        if (r2 == true) goto L15;
        r2 = isMonitorStatus(r0.getExtraMonitorStatus(), r6);     // Catch: Throwable -> L24
        if (r2 == true) goto L15;
        if (r1 == null) goto L15;
        if ((r1 instanceof AbsDownloadMonitorDepend) == false) goto L15;
        r2 = isMonitorStatus(r1.getAdditionalMonitorStatus(), r6);     // Catch: Throwable -> L24
    L15:
        if (r2 == false) goto L31;
        IDownloadDepend r3 = r4.getDepend();     // Catch: Throwable -> L20
        if (r3 == null) goto L22;
        r3.monitorLogSend(r0, r5, r6);     // Catch: Throwable -> L20
    L22:
        monitorSendWithTaskMonitor(r1, r0, r5, r6);     // Catch: Throwable -> L24
        monitorSendWithGlobalSdkMonitor(DownloadComponentManager.getDownloadMonitorListener(), r4, r0, r5, r6);     // Catch: Throwable -> L24
        return;
    L20:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L24
        goto L22
    L31:
        return;
    L24:
        th = move-exception;
        monitorDownloadOtherError(th);
        th.printStackTrace();
    }

    public static void monitorDownloadCDN(String r4, IDownloadHttpConnection r5, Throwable r6, IDownloadCdnListener r7) {
        if (r7 == null) goto L44;
        if (r4 == null) goto L46;
        DownloadCdnStats r0 = new DownloadCdnStats();
        boolean r1 = false;
        boolean r2 = true;
        if (r5 != null) goto L8;
    L18:
        if (r6 != null) goto L20;
        r2 = r1;
    L33:
        if (r2 == false) goto L45;
        r0.host = UriProtector.parse(r4).getHost();     // Catch: Throwable -> L37
    L35:
        r7.onCollectStats(r0);
        return;
    L45:
        return;
    L20:
        if (r0.responseCode > 0) goto L42;
        r0.responseCode = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getTTNetHandler().getResponseCode(r6);
    L42:
        DownloadHelper.parseException(r6, "monitor_cdn");     // Catch: BaseException -> L24 DownloadTTNetException -> L26
    L31:
        r0.errorMsg = r6.toString();
        goto L33
    L24:
        e = move-exception;
        r0.errorCode = e.getErrorCode();
    L26:
        e = move-exception;
        if (r0.ip != null) goto L30;
        r0.ip = e.getRemoteIp();
    L30:
        r0.errorCode = e.getErrorCode();
        goto L31
    L8:
        if ((r5 instanceof AbsDownloadHttpConnection) == false) goto L18;
        AbsDownloadHttpConnection r8 = (AbsDownloadHttpConnection) r5;
    L15:
        th = move-exception;
        th.printStackTrace();
    L17:
        r1 = true;
        goto L18
    L11:
        if (r8.isOkhttp() == true) goto L13;
        r1 = true;
    L13:
        r0.isTTNet = r1;     // Catch: Throwable -> L15
        r0.responseCode = r8.getResponseCode();     // Catch: Throwable -> L15
        r0.ip = r8.getHostIp();     // Catch: Throwable -> L15
        r0.cacheHit = DownloadHelper.isCdnCacheHit(r8.getResponseHeaders());     // Catch: Throwable -> L15
        goto L17
    L46:
        return;
    }

    public static void monitorSendWithTaskMonitor(IDownloadMonitorDepend r2, DownloadInfo r3, BaseException r4, int r5) {
        if (r2 != null) goto L4;
        return;
    L4:
        String r0 = r2.getEventPage();
        if (TextUtils.isEmpty(r0) == false) goto L7;
        r0 = DEFAULT_MONITOR_SCENE;
    L7:
        DownloadComponentManager.submitCPUTask(new 1(translateDownloadMonitorInfo(r0, r3, null, r4, r5), r2));
    }

    public static void monitorSendWithGlobalSdkMonitor(IDownloadMonitorListener r1, DownloadTask r2, DownloadInfo r3, BaseException r4, int r5) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r3.isNeedSDKMonitor() == false) goto L9;
        DownloadComponentManager.submitCPUTask(new 2(translateDownloadMonitorInfo(r3.getMonitorScene(), r3, r2, r4, r5), r1));
        return;
    }

    private static DownloadMonitorInfo translateDownloadMonitorInfo(String r3, DownloadInfo r4, DownloadTask r5, BaseException r6, int r7) {
        DownloadMonitorInfo r0 = new DownloadMonitorInfo(null);
        r0.monitorStatus = r7;
        r0.exception = r6;
        r0.eventPage = r3;
        if (r4 == null) goto L15;
        r0.id = r4.getId();
        r0.name = r4.getName();
        r0.url = r4.getUrl();
        r0.savePath = r4.getSavePath();
        r0.downloadTime = r4.getDownloadTime();
        r0.curBytes = r4.getCurBytes();
        r0.backCurBytes = r4.getBackCurBytes();
        r0.totalBytes = r4.getTotalBytes();
        r0.networkQuality = r4.getNetworkQuality();
        r0.onlyWifi = r4.isOnlyWifi();
        r0.needHttpsToHttpRetry = r4.isNeedHttpsToHttpRetry();
        r0.httpsToHttpRetryUsed = r4.isHttpsToHttpRetryUsed();
        r0.md5 = r4.getMd5();
        r0.force = r4.isForce();
        r0.retryCount = r4.getRetryCount();
        r0.needDefaultHttpServiceBackUp = r4.isNeedDefaultHttpServiceBackUp();
        r0.byteInvalidRetryStatus = r4.getByteInvalidRetryStatus();
        r0.asyncHandleStatus = r4.getAsyncHandleStatus();
        r0.needIndependentProcess = r4.isNeedIndependentProcess();
        r0.extra = r4.getExtra();
        r0.addListenerToSameTask = r4.isAddListenerToSameTask();
        r0.backUpUrls = r4.getBackUpUrls();
        r0.curBackUpUrlIndex = r4.getCurBackUpUrlIndex();
        r0.forbiddenBackupUrls = r4.getForbiddenBackupUrls();
        r0.curNetworkRetryCount = r4.getCurNetworkRetryCount();
        r0.isCacheExistsInDownloading = r4.isCacheExistsInDownloading();
        r0.mimeType = r4.getMimeType();
        r0.contentEncoding = r4.getContentEncoding();
        r0.fastDownload = r4.isFastDownload();
        r0.pcdnStats = r4.getPcdnStats();
        r0.throttleNetSpeed = r4.getThrottleNetSpeed();
        r0.httpRequestHeader = r4.getHttpRequestHeader();
        r0.httpResponseHeader = r4.getHttpResponseHeader();
        r0.requestLog = r4.getRequestLog();
        r0.enqueueType = r4.getEnqueueType().ordinal();
        r0.sleepTime = r4.getTaskSleepTime();
        r0.callStack = r4.getCallStack();
        if (r7 != (-3)) goto L7;
    L12:
        r0.allConnectTime = r4.getAllConnectTime();
        r0.firstSpeedTime = r4.getFirstSpeedTime();
        r0.realDownloadTime = r4.getRealDownloadTime();
        r0.realBackDownloadTime = r4.getRealBackDownloadTime();
        r0.backUpUrlUsed = r4.isBackUpUrlUsed();
        r0.curRetryTime = r4.getCurRetryTime();
        r0.curRetryTimeInTotal = r4.getCurRetryTimeInTotal();
        r0.md5Time = r4.getMd5Time();
    L13:
        if (r7 != (-3)) goto L15;
        r0.downloadSpeed = r4.getDownloadSpeed();
        goto L15
    L7:
        if (r7 == (-4)) goto L12;
        if (r7 == (-1)) goto L12;
        if (r7 != (-2)) goto L13;
    L15:
        if (r5 == null) goto L17;
        r0.downloadTimingInfo = r5.getTimingInfo().copy();
        r0.downloadThreadInfo = r5.getThreadInfo().copy();
    L17:
        return r0;
    }

    public static void monitorDownloadConnect(IDownloadHeadHttpConnection r13, String r14, String r15, long r16, String r18, int r19, IOException r20, DownloadInfo r21) {
        if (r21 != null) goto L5;
        return;
    L5:
        DownloadSetting r4 = DownloadSetting.obtain(r21.getId());
        int r6 = r4.optInt("monitor_download_connect", 0);
        if (r6 > 0) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r14) == false) goto L11;
        return;
    L11:
        int r8 = -1;
        if (r13 != null) goto L76;
    L21:
        String r1 = null;
    L23:
        if (r8 < 200) goto L26;
        if (r8 >= 400) goto L26;
    L41:
        String r0 = null;
    L42:
        Uri r2 = UriProtector.parse(r14);     // Catch: Throwable -> L66
        String r9 = r2.getHost();     // Catch: Throwable -> L66
        String r10 = r2.getPath();     // Catch: Throwable -> L66
        String r3 = r2.getLastPathSegment();     // Catch: Throwable -> L66
        if (TextUtils.isEmpty(r10) == false) goto L45;
    L47:
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L66
        r5.put("setting_tag", r4.optString("setting_tag"));     // Catch: JSONException -> L53 Throwable -> L66
        r5.put("url_host", r9);     // Catch: JSONException -> L53 Throwable -> L66
        r5.putOpt("host_ip", r15);     // Catch: JSONException -> L53 Throwable -> L66
        r5.putOpt("host_real_ip", r1);     // Catch: JSONException -> L53 Throwable -> L66
        r5.put("url_path", r10);     // Catch: JSONException -> L53 Throwable -> L66
        r5.put("url_last_path_segment", r3);     // Catch: JSONException -> L53 Throwable -> L66
        r5.put("net_lib", r19);     // Catch: JSONException -> L53 Throwable -> L66
        r5.put("connect_type", r18);     // Catch: JSONException -> L53 Throwable -> L66
        r5.put("status_code", r8);     // Catch: JSONException -> L53 Throwable -> L66
        if (r0 == null) goto L51;
        r5.put("error_msg", DownloadHelper.getFixLengthString(r0, r4.optInt("exception_msg_length", 500)));     // Catch: JSONException -> L53 Throwable -> L66
    L51:
        r5.put("connect_time", r16);     // Catch: JSONException -> L53 Throwable -> L66
        r5.put("pkg_name", r21.getPackageName());     // Catch: JSONException -> L53 Throwable -> L66
        r5.put(DBDefinition.NAME, r21.getTitle());     // Catch: JSONException -> L53 Throwable -> L66
    L56:
        if (r6 == 1) goto L58;
        if (r6 == 3) goto L58;
    L62:
        if (r6 == 2) goto L64;
        if (r6 == 3) goto L64;
        return;
    L64:
        DownloadComponentManager.getEventListener().onEvent(r21.getId(), "download_connect", r5);     // Catch: Throwable -> L66
        return;
    L58:
        IDownloadMonitorListener r7 = DownloadComponentManager.getDownloadMonitorListener();     // Catch: Throwable -> L66
        if (r7 == null) goto L62;
        r7.monitorEvent("download_connect", r5, null, null);     // Catch: Throwable -> L66
    L53:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L66
        goto L56
    L45:
        if (TextUtils.isEmpty(r3) == true) goto L47;
        r10 = r10.substring(0, r10.length() - r3.length());     // Catch: Throwable -> L69
    L26:
        if (r21.getCurRetryTime() == 0) goto L31;
        int r11 = r21.getHttpStatusCode();     // Catch: Throwable -> L66
        if (r11 < 200) goto L30;
        if (r11 < 400) goto L31;
        return;
    L30:
        return;
    L31:
        if (r20 == null) goto L41;
        if (DownloadUtils.isNetworkConnected(DownloadComponentManager.getAppContext()) == false) goto L35;
    L78:
        DownloadHelper.parseException(r20, "");     // Catch: BaseException -> L39 Throwable -> L66
    L39:
        e = move-exception;
        r8 = e.getErrorCode();     // Catch: Throwable -> L66
        r0 = e.getErrorMessage();     // Catch: Throwable -> L66
        goto L42
    L35:
        if (DownloadSetting.getGlobalSettings().optBoolean("disable_check_no_network") == true) goto L78;
        r8 = 1049;
        goto L41
    L76:
        r8 = r13.getResponseCode();     // Catch: Throwable -> L15
    L19:
        if ((r13 instanceof AbsDownloadHttpConnection) == false) goto L21;
        r1 = ((AbsDownloadHttpConnection) r13).getHostIp();     // Catch: Throwable -> L66
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        th.printStackTrace();
    }

    public static void monitorSegmentIO(DownloadSetting r23, DownloadInfo r24, String r25, String r26, String r27, boolean r28, IDownloadHttpConnection r29, BaseException r30, long r31, long r33) {
        monitorIO("segment_io", r23.optInt("monitor_segment_io"), r23, r24, r25, r26, r27, r29, r28, false, r30, r31, r33, false, -1, -1, -1, null);
    }

    public static void monitorDownloadIO(DownloadSetting r23, DownloadInfo r24, String r25, IDownloadHttpConnection r26, boolean r27, boolean r28, BaseException r29, long r30, long r32, boolean r34, long r35, long r37, long r39, JSONObject r41) {
        monitorIO("download_io", r23.optInt("monitor_download_io"), r23, r24, r25, null, null, r26, r27, r28, r29, r30, r32, r34, r35, r37, r39, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v3 */
    private static void monitorIO(String r19, int r20, DownloadSetting r21, DownloadInfo r22, String r23, String r24, String r25, IDownloadHttpConnection r26, boolean r27, boolean r28, BaseException r29, long r30, long r32, boolean r34, long r35, long r37, long r39, JSONObject r41) {
        if (r20 > 0) goto L5;
        return;
    L5:
        if (r32 <= 0) goto L80;
        Uri r7 = UriProtector.parse(r23);     // Catch: Throwable -> L71
        String r8 = r7.getHost();     // Catch: Throwable -> L71
        String r9 = r7.getPath();     // Catch: Throwable -> L71
        String r10 = r7.getLastPathSegment();     // Catch: Throwable -> L71
        if (TextUtils.isEmpty(r9) == false) goto L10;
    L14:
        if (r27 == false) goto L17;
        int r14 = 1;
    L16:
        String r15 = null;
    L28:
        ?? r11 = new JSONObject();     // Catch: Throwable -> L71
        String r16 = "";
        ?? r17 = -1;
        if (r26 != null) goto L31;
        String r3 = "";
        int r12 = -1;
        ?? r13 = -1;
    L49:
        double r0 = r30 / 1048576.0d;     // Catch: Throwable -> L71
        double r4 = r32;
        double r1 = r4 / TimeUnit.SECONDS.toNanos(1);     // Catch: Throwable -> L71
        r11.put("setting_tag", r21.optString("setting_tag"));     // Catch: Throwable -> L71
        r11.put("url_host", r8);     // Catch: Throwable -> L71
        r11.putOpt("host_ip", r24);     // Catch: Throwable -> L71
        r11.putOpt("host_real_ip", r25);     // Catch: Throwable -> L71
        r11.put("url_path", r9);     // Catch: Throwable -> L71
        r11.put("url_last_path_segment", r10);     // Catch: Throwable -> L71
        r11.put("net_lib", r12);     // Catch: Throwable -> L71
        r11.put("hit_cdn_cache", r13);     // Catch: Throwable -> L71
        r11.put("status_code", r14);     // Catch: Throwable -> L71
        r11.put("request_log", r3);     // Catch: Throwable -> L71
        if (r15 == null) goto L52;
        r11.put("error_msg", DownloadHelper.getFixLengthString(r15, r21.optInt("exception_msg_length", 500)));     // Catch: Throwable -> L71
    L52:
        r11.put("download_sec", r1);     // Catch: Throwable -> L71
        r11.put("download_mb", r0);     // Catch: Throwable -> L71
        if (r1 <= 0.0d) goto L55;
        r11.put("download_speed", r0 / r1);     // Catch: Throwable -> L71
    L55:
        if (r34 == false) goto L57;
        r11.put("rw_read_time", r35 / r4);     // Catch: Throwable -> L71
        r11.put("rw_write_time", r37 / r4);     // Catch: Throwable -> L71
        r11.put("rw_sync_time", r39 / r4);     // Catch: Throwable -> L71
    L57:
        r11.put("pkg_name", r22.getPackageName());     // Catch: Throwable -> L71
        r11.put(DBDefinition.NAME, r22.getTitle());     // Catch: Throwable -> L71
        if (r20 == 1) goto L62;
        if (r20 == 3) goto L62;
        int r2 = 2;
        String r5 = r19;
    L67:
        if (r20 == r2) goto L69;
        if (r20 == 3) goto L69;
        return;
    L69:
        DownloadComponentManager.getEventListener().onEvent(r22.getId(), r5, r11);     // Catch: Throwable -> L71
        return;
    L62:
        IDownloadMonitorListener r6 = DownloadComponentManager.getDownloadMonitorListener();     // Catch: Throwable -> L71
        if (r6 == null) goto L65;
        r5 = r19;
        r6.monitorEvent(r5, r11, null, null);     // Catch: Throwable -> L71
    L66:
        r2 = 2;
        goto L67
    L65:
        r5 = r19;
        goto L66
    L31:
        if ((r26 instanceof IDefaultDownloadHttpConnection) == false) goto L33;
        r12 = 0;
    L34:
        String r18 = r26.getResponseHeaderField(DownloadHelper.X_CACHE);     // Catch: Throwable -> L71
        if (TextUtils.isEmpty(r18) == true) goto L38;
        r17 = r18.toLowerCase().contains("hit");     // Catch: Throwable -> L71
    L38:
        if (r21.optInt("monitor_sla", 1) != 1) goto L45;
        if (r27 == true) goto L45;
        if (r28 == true) goto L45;
        if ((r26 instanceof AbsDownloadHttpConnection) == false) goto L45;
        ((AbsDownloadHttpConnection) r26).monitorNetworkInfo(r11, true);     // Catch: Throwable -> L71
    L45:
        if ((r26 instanceof AbsDownloadHttpConnection) == false) goto L47;
        r16 = ((AbsDownloadHttpConnection) r26).getRequestLog();     // Catch: Throwable -> L71
    L47:
        r3 = r16;
        r13 = r17;
        goto L49
    L33:
        r12 = 1;
        goto L34
    L17:
        if (r28 == false) goto L19;
        r14 = 2;
        goto L16
    L19:
        if (r29 != null) goto L21;
        r14 = 0;
        goto L16
    L21:
        if (DownloadUtils.isNetworkConnected(DownloadComponentManager.getAppContext()) == false) goto L23;
    L25:
        r14 = r29.getErrorCode();     // Catch: Throwable -> L71
    L26:
        r15 = r29.getErrorMessage();     // Catch: Throwable -> L71
        goto L28
    L23:
        if (DownloadSetting.getGlobalSettings().optBoolean("disable_check_no_network") == true) goto L25;
        r14 = 1049;
        goto L26
    L10:
        if (TextUtils.isEmpty(r10) == true) goto L14;
        r9 = r9.substring(0, r9.length() - r10.length());     // Catch: Throwable -> L13
    L71:
        th = move-exception;
        th.printStackTrace();
        return;
    }
}
