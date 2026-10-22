package com.bytedance.apm6.hub.config;

import android.text.TextUtils;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.SlardarHandler;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfig;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService;
import com.bytedance.apm6.foundation.safety.CustomExceptionHelper;
import com.bytedance.apm6.hub.config.internal.ConfigConstants;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.apm6.util.log.Logger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SlardarHandlerConfigManager implements SlardarHandlerConfigService {
    public static final int DEFAULT_LOG_MAX_SAVE_DAYS = 5;
    public static final int DEFAULT_MAX_DB_SIZE_MB = 80;
    String BASE_KEY_ONCE_MAX_SIZE_KB;
    String BASE_KEY_REPORT_INTERVAL;
    String COMPRESS_TYPE;
    String LOG_MAX_SIZE_MB;
    String LOG_RESERVE_DAYS;
    String SETTING_GENERAL_API_REPORT;
    String SETTING_GENERAL_API_REPORT_ENCRYPT;
    String SETTING_GENERAL_API_REPORT_HOSTS;
    String SETTING_GENERAL_ENABLE_REPORT_INTERNAL_EXCEPTION;
    private volatile SlardarHandlerConfig config;
    private JSONObject outsideConfig;

    public SlardarHandlerConfigManager() {
        this.SETTING_GENERAL_API_REPORT = "report_setting";
        this.SETTING_GENERAL_API_REPORT_ENCRYPT = "enable_encrypt";
        this.SETTING_GENERAL_API_REPORT_HOSTS = "hosts";
        this.BASE_KEY_ONCE_MAX_SIZE_KB = "apm6_once_max_size_kb";
        this.BASE_KEY_REPORT_INTERVAL = "apm6_uploading_interval";
        this.SETTING_GENERAL_ENABLE_REPORT_INTERNAL_EXCEPTION = "enable_report_internal_exception";
        this.LOG_RESERVE_DAYS = "log_reserve_days";
        this.LOG_MAX_SIZE_MB = "log_max_size_mb";
        this.COMPRESS_TYPE = "compress_type";
        initConfig();
    }

    public SlardarHandlerConfigManager(JSONObject r10) {
        this.SETTING_GENERAL_API_REPORT = "report_setting";
        this.SETTING_GENERAL_API_REPORT_ENCRYPT = "enable_encrypt";
        this.SETTING_GENERAL_API_REPORT_HOSTS = "hosts";
        this.BASE_KEY_ONCE_MAX_SIZE_KB = "apm6_once_max_size_kb";
        this.BASE_KEY_REPORT_INTERVAL = "apm6_uploading_interval";
        this.SETTING_GENERAL_ENABLE_REPORT_INTERNAL_EXCEPTION = "enable_report_internal_exception";
        this.LOG_RESERVE_DAYS = "log_reserve_days";
        this.LOG_MAX_SIZE_MB = "log_max_size_mb";
        this.COMPRESS_TYPE = "compress_type";
        this.outsideConfig = r10;
        initConfig();
    }

    static /* synthetic */ void access$000(SlardarHandlerConfigManager r10, JSONObject r11, boolean r12) {
        r10.parseConfig(r11, r12);
    }

    private void initConfig() {
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new AnonymousClass1(this));
    }

    private void parseConfig(JSONObject r14, boolean r15) {
        if (r14 != null) goto L4;
        return;
    L4:
        JSONObject r16 = JsonUtils.optJSONObject(r14, SlardarSettingsConstants.SETTING_GENERAL, SlardarSettingsConstants.SETTING_GENERAL_API, this.SETTING_GENERAL_API_REPORT);
        if (r16 != null) goto L7;
        return;
    L7:
        List<String> r10 = parseReportHost(r16.optJSONArray(this.SETTING_GENERAL_API_REPORT_HOSTS));
        ArrayList r11 = new ArrayList();
        String r12 = null;
        if (ListUtils.isEmpty(r10) == true) goto L17;
        Iterator<String> r13 = r10.iterator();
        String r17 = null;
    L11:
        if (r13.hasNext() == false) goto L18;
        String r18 = r13.next();
        r11.add(ReportConsts.HTTPS + r18 + "/monitor/collect/batch/");
        if (r12 != null) goto L15;
        r12 = ReportConsts.HTTPS + r18 + "/monitor/collect/c/exception";
    L15:
        if (r17 != null) goto L11;
        r17 = ReportConsts.HTTPS + r18 + ReportConsts.TRACING_PATH;
    L18:
        boolean r19 = true;
        boolean r20 = r16.optBoolean(this.SETTING_GENERAL_API_REPORT_ENCRYPT, true);
        long r21 = r16.optLong(this.BASE_KEY_ONCE_MAX_SIZE_KB, -1) * 1024;
        long r22 = r16.optLong(this.BASE_KEY_REPORT_INTERVAL, -1) * 1000;
        if (JsonUtils.optInt(r14, SlardarSettingsConstants.SETTING_GENERAL, this.SETTING_GENERAL_ENABLE_REPORT_INTERNAL_EXCEPTION) == 1) goto L22;
        r19 = false;
    L22:
        SlardarHandlerConfig r23 = new SlardarHandlerConfig();
        r23.setReportUrlList(r11);
        r23.setExceptionUrl(r12);
        r23.setTraceReportUrl(r17);
        r23.setOnceReportMaxSizeBytes(r21);
        r23.setEncrypt(r20);
        r23.setReportInterval(r22);
        r23.setUploadInternalException(r19);
        JSONObject r24 = this.outsideConfig;
        if (r24 == null) goto L25;
        r23.setMaxSizeMBToday(r24.optInt("max_size_mb_today", -1));
    L25:
        r23.setCompressType(r16.optInt(this.COMPRESS_TYPE, 2));
        JSONObject r110 = r14.optJSONObject(SlardarSettingsConstants.SETTING_GENERAL);
        if (r110 == null) goto L30;
        JSONObject r111 = r110.optJSONObject(SlardarSettingsConstants.SETTING_GENERAL_CLEANUP);
        if (r111 == null) goto L30;
        r23.setMaxSizeMB(r111.optInt(this.LOG_MAX_SIZE_MB, 80));
        r23.setKeepDays(r111.optInt(this.LOG_RESERVE_DAYS, 5));
    L30:
        this.config = r23;
        if (ApmBaseContext.isDebugMode() == false) goto L33;
        Logger.d(ConfigConstants.LOG_TAG, "received reportSetting=" + r16);
        Logger.d(ConfigConstants.LOG_TAG, "parsed SlardarHandlerConfig=" + this.config);
    L33:
        CustomExceptionHelper.setEnableReport(r19);
        CustomExceptionHelper.setExceptionUrl(r12);
        SlardarHandler.getInstance().setSlardarHandlerConfig(getConfig());
        return;
    L17:
        r17 = null;
        goto L18
    }

    private static List<String> parseReportHost(JSONArray r10) {
        if (r10 == null) goto L21;
    L15:
        e = e;
        String r11 = "parse setting host malformedurl exception";
    L19:
        Logger.e(Constants.TAG_SETTING, r11, e);
    L17:
        e = e;
        r11 = "parse setting host json exception";
        goto L19
    L5:
        if (r10.length() <= 0) goto L21;
        ArrayList r12 = new ArrayList(2);     // Catch: MalformedURLException -> L15 JSONException -> L17
        int r13 = r10.length();     // Catch: MalformedURLException -> L15 JSONException -> L17
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L14;
        String r15 = new URL(r10.getString(r14)).getHost();     // Catch: MalformedURLException -> L15 JSONException -> L17
        if (TextUtils.isEmpty(r15) == true) goto L13;
        if (r15.indexOf(46) <= 0) goto L13;
        r12.add(r15);     // Catch: MalformedURLException -> L15 JSONException -> L17
    L13:
        r14 = r14 + 1;
        goto L7
    L14:
        return r12;
    L21:
        return Collections.emptyList();
    }

    @Override // com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService
    public SlardarHandlerConfig getConfig() {
        return this.config;
    }

    @Override // com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService
    public void setOutsideConfig(JSONObject r10) {
        this.outsideConfig = r10;
    }
}
