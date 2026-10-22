package com.bytedance.apm6.hub.config;

import android.text.TextUtils;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.SlardarHandler;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfig;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.foundation.safety.CustomExceptionHelper;
import com.bytedance.apm6.hub.config.internal.ConfigConstants;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.apm6.util.log.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    public SlardarHandlerConfigManager(JSONObject r2) {
        this.SETTING_GENERAL_API_REPORT = "report_setting";
        this.SETTING_GENERAL_API_REPORT_ENCRYPT = "enable_encrypt";
        this.SETTING_GENERAL_API_REPORT_HOSTS = "hosts";
        this.BASE_KEY_ONCE_MAX_SIZE_KB = "apm6_once_max_size_kb";
        this.BASE_KEY_REPORT_INTERVAL = "apm6_uploading_interval";
        this.SETTING_GENERAL_ENABLE_REPORT_INTERNAL_EXCEPTION = "enable_report_internal_exception";
        this.LOG_RESERVE_DAYS = "log_reserve_days";
        this.LOG_MAX_SIZE_MB = "log_max_size_mb";
        this.COMPRESS_TYPE = "compress_type";
        this.outsideConfig = r2;
        initConfig();
    }

    static /* synthetic */ void access$000(SlardarHandlerConfigManager r0, JSONObject r1, boolean r2) {
        r0.parseConfig(r1, r2);
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
        List<String> r1 = parseReportHost(r16.optJSONArray(this.SETTING_GENERAL_API_REPORT_HOSTS));
        ArrayList r2 = new ArrayList();
        String r4 = null;
        if (ListUtils.isEmpty(r1) == true) goto L17;
        Iterator<String> r3 = r1.iterator();
        String r5 = null;
    L11:
        if (r3.hasNext() == false) goto L18;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        r2.add(ReportConsts.HTTPS + r6 + "/monitor/collect/batch/");
        if (r4 != null) goto L15;
        r4 = ReportConsts.HTTPS + r6 + "/monitor/collect/c/exception";
    L15:
        if (r5 != null) goto L11;
        r5 = ReportConsts.HTTPS + r6 + ReportConsts.TRACING_PATH;
    L18:
        boolean r7 = true;
        boolean r8 = r16.optBoolean(this.SETTING_GENERAL_API_REPORT_ENCRYPT, true);
        long r9 = r16.optLong(this.BASE_KEY_ONCE_MAX_SIZE_KB, -1) * 1024;
        long r10 = r16.optLong(this.BASE_KEY_REPORT_INTERVAL, -1) * 1000;
        if (JsonUtils.optInt(r14, SlardarSettingsConstants.SETTING_GENERAL, this.SETTING_GENERAL_ENABLE_REPORT_INTERNAL_EXCEPTION) == 1) goto L22;
        r7 = false;
    L22:
        SlardarHandlerConfig r11 = new SlardarHandlerConfig();
        r11.setReportUrlList(r2);
        r11.setExceptionUrl(r4);
        r11.setTraceReportUrl(r5);
        r11.setOnceReportMaxSizeBytes(r9);
        r11.setEncrypt(r8);
        r11.setReportInterval(r10);
        r11.setUploadInternalException(r7);
        JSONObject r12 = this.outsideConfig;
        if (r12 == null) goto L25;
        r11.setMaxSizeMBToday(r12.optInt("max_size_mb_today", -1));
    L25:
        r11.setCompressType(r16.optInt(this.COMPRESS_TYPE, 2));
        JSONObject r17 = r14.optJSONObject(SlardarSettingsConstants.SETTING_GENERAL);
        if (r17 == null) goto L30;
        JSONObject r18 = r17.optJSONObject(SlardarSettingsConstants.SETTING_GENERAL_CLEANUP);
        if (r18 == null) goto L30;
        r11.setMaxSizeMB(r18.optInt(this.LOG_MAX_SIZE_MB, 80));
        r11.setKeepDays(r18.optInt(this.LOG_RESERVE_DAYS, 5));
    L30:
        this.config = r11;
        if (ApmContext.isDebugMode() == false) goto L33;
        Logger.d(ConfigConstants.LOG_TAG, "received reportSetting=" + r16);
        Logger.d(ConfigConstants.LOG_TAG, "parsed SlardarHandlerConfig=" + this.config);
    L33:
        CustomExceptionHelper.setEnableReport(r7);
        CustomExceptionHelper.setExceptionUrl(r4);
        SlardarHandler.getInstance().setSlardarHandlerConfig(getConfig());
        return;
    L17:
        r5 = null;
        goto L18
    }

    private static List<String> parseReportHost(JSONArray r6) {
        if (r6 == null) goto L21;
    L15:
        e = e;
        String r1 = "parse setting host malformedurl exception";
    L19:
        Logger.e(Constants.TAG_SETTING, r1, e);
    L17:
        e = e;
        r1 = "parse setting host json exception";
        goto L19
    L5:
        if (r6.length() <= 0) goto L21;
        ArrayList r2 = new ArrayList(2);     // Catch: MalformedURLException -> L15 JSONException -> L17
        int r3 = r6.length();     // Catch: MalformedURLException -> L15 JSONException -> L17
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L14;
        String r5 = new URL(r6.getString(r4)).getHost();     // Catch: MalformedURLException -> L15 JSONException -> L17
        if (TextUtils.isEmpty(r5) == true) goto L13;
        if (r5.indexOf(46) <= 0) goto L13;
        r2.add(r5);     // Catch: MalformedURLException -> L15 JSONException -> L17
    L13:
        r4 = r4 + 1;
        goto L7
    L14:
        return r2;
    L21:
        return Collections.emptyList();
    }

    @Override // com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService
    public SlardarHandlerConfig getConfig() {
        return this.config;
    }

    @Override // com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService
    public void setOutsideConfig(JSONObject r1) {
        this.outsideConfig = r1;
    }
}
