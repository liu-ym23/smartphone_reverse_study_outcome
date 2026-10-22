package com.bytedance.apm6.hub.config;

import androidx.annotation.Nullable;
import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.cpu.collect.CpuCollectManager;
import com.bytedance.apm6.cpu.config.CpuConfig;
import com.bytedance.apm6.cpu.config.CpuConfigService;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.cpu.exception.CpuExceptionManager;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.perf.base.BasePerfConfigParser;
import com.bytedance.apm6.util.log.Logger;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CpuOnlineConfigManager implements CpuConfigService {
    private static final String BASE_CPU_KEY = "cpu";
    private static final String KEY_BACK_COLLECT_INTERVAL = "back_collect_interval";
    private static final String KEY_BACK_THREAD_COLLECT_INTERVAL = "back_thread_collect_interval";
    private static final String KEY_COLLECT_ALL_PROCESS = "exception_collect_all_process";
    private static final String KEY_ENABLE_ALL_PROCESS = "enable_collect_all_process";
    private static final String KEY_ENABLE_UPLOAD = "enable_upload";
    private static final String KEY_EXCEPTION_BACK_MAX_SPEED_SCENE = "exception_back_max_speed_scene";
    private static final String KEY_EXCEPTION_FORE_MAX_SPEED_SCENE = "exception_fore_max_speed_scene";
    private static final String KEY_EXCEPTION_NATIVE_THREAD_ENABLED = "exception_native_thread_enabled";
    private static final String KEY_EXCEPTION_SWITCH = "exception_switch";
    private static final String KEY_EXCEPTION_THREAD_MAX_USAGE = "exception_thread_max_usage";
    private static final String KEY_EXCEPTION_THREAD_MAX_USAGE_MAP = "exception_thread_max_usage_map";
    private static final String KEY_EXCEPTION_THREAD_STACK_ENABLED = "exception_thread_stack_enabled";
    private static final String KEY_FRONT_COLLECT_INTERVAL = "front_collect_interval";
    private static final String KEY_FRONT_THREAD_COLLECT_INTERVAL = "front_thread_collect_interval";
    private static final String KEY_MAIN_THREAD_COLLECT_ENABLED = "main_thread_collect_enabled";
    private static final String KEY_MONITOR_INTERVAL = "monitor_interval";
    private static final String KEY_PROCESS_BACK_MAX_SPEED = "exception_process_back_max_speed";
    private static final String KEY_PROCESS_DETECT_INTERVAL = "process_detect_interval";
    private static final String KEY_PROCESS_FORE_MAX_SPEED = "exception_process_fore_max_speed";
    private static final String KEY_THREAD_DETECT_INTERVAL = "thread_detect_interval";
    private CpuConfig mConfig;
    private CpuExceptionConfig mExceptionConfig;

    public CpuOnlineConfigManager() {
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new AnonymousClass1(this));
    }

    static /* synthetic */ void access$000(CpuOnlineConfigManager r10, JSONObject r11, boolean r12) {
        r10.parseConfig(r11, r12);
    }

    private void parseConfig(JSONObject r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        JSONObject r12 = BasePerfConfigParser.parseData(r10, BASE_CPU_KEY);
        if (r12 == null) goto L79;
        this.mConfig = new CpuConfig();
        boolean r13 = true;
        if (r12.optInt("enable_upload", 0) != 1) goto L9;
        boolean r14 = true;
    L10:
        this.mConfig.setEnableUpload(r14);
        if (r12.optInt(KEY_ENABLE_ALL_PROCESS, 0) != 1) goto L13;
        boolean r15 = true;
    L14:
        this.mConfig.setCollectAllProcess(r15);
        long r16 = r12.optLong(KEY_FRONT_COLLECT_INTERVAL, 0);
        if (r16 <= 0) goto L17;
        this.mConfig.setFrontCollectInterval(r16);
    L17:
        long r17 = r12.optLong(KEY_BACK_COLLECT_INTERVAL, 0);
        if (r17 <= 0) goto L20;
        this.mConfig.setBackCollectInterval(r17);
    L20:
        long r18 = r12.optLong("monitor_interval", 0);
        if (r18 <= 0) goto L23;
        this.mConfig.setMonitorInterval(r18);
    L23:
        long r19 = r12.optLong(KEY_FRONT_THREAD_COLLECT_INTERVAL, 0);
        if (r19 <= 0) goto L26;
        this.mConfig.setFrontThreadCollectInterval(r19);
    L26:
        long r20 = r12.optLong(KEY_BACK_THREAD_COLLECT_INTERVAL, 0);
        if (r20 <= 0) goto L29;
        this.mConfig.setBackThreadCollectInterval(r20);
    L29:
        this.mExceptionConfig = new CpuExceptionConfig();
        if (r12.optInt(KEY_EXCEPTION_SWITCH, 0) != 1) goto L32;
        boolean r110 = true;
    L33:
        this.mExceptionConfig.setOpen(r110);
        double r21 = r12.optDouble(KEY_PROCESS_BACK_MAX_SPEED, 0.0d);
        if (r21 <= 0.0d) goto L36;
        this.mExceptionConfig.setMaxProcessBackCpuSpeed(r21);
    L36:
        double r22 = r12.optDouble(KEY_PROCESS_FORE_MAX_SPEED, 0.0d);
        if (r22 <= 0.0d) goto L40;
        this.mExceptionConfig.setMaxProcessForeCpuSpeed(r22);
    L40:
        if (r12.optInt(KEY_MAIN_THREAD_COLLECT_ENABLED, 0) != 1) goto L42;
        boolean r111 = true;
    L43:
        this.mExceptionConfig.setCollectMainThread(r111);
        if (r12.optInt(KEY_COLLECT_ALL_PROCESS, 0) != 1) goto L46;
        boolean r112 = true;
    L47:
        this.mExceptionConfig.setCollectAllProcess(r112);
        if (r12.optInt(KEY_EXCEPTION_THREAD_STACK_ENABLED, 1) == 1) goto L51;
        r13 = false;
    L51:
        this.mExceptionConfig.setCollectThreadStack(r13);
        double r23 = r12.optDouble(KEY_EXCEPTION_THREAD_MAX_USAGE, 0.0d);
        if (r23 <= 0.0d) goto L54;
        this.mExceptionConfig.setMaxThreadCpuRate(r23);
    L54:
        JSONObject r113 = r12.optJSONObject(KEY_EXCEPTION_THREAD_MAX_USAGE_MAP);
        HashMap r24 = new HashMap();
        if (r113 == null) goto L62;
        Iterator<String> r25 = r113.keys();
    L58:
        if (r25.hasNext() == false) goto L62;
        String r26 = r25.next();
        double r27 = r113.optDouble(r26, 0.0d);
        if (r27 <= 0.0d) goto L58;
        r24.put(r26, Double.valueOf(r27));
    L62:
        this.mExceptionConfig.setMaxThreadCpuRateMap(r24);
        this.mExceptionConfig.setProcessDetectInterval(r12.optInt(KEY_PROCESS_DETECT_INTERVAL, 30));
        this.mExceptionConfig.setThreadDetectInterval(r12.optInt(KEY_THREAD_DETECT_INTERVAL, 30));
        JSONObject r114 = r12.optJSONObject(KEY_EXCEPTION_FORE_MAX_SPEED_SCENE);
        HashMap r28 = new HashMap();
        if (r114 == null) goto L70;
        Iterator<String> r29 = r114.keys();
    L66:
        if (r29.hasNext() == false) goto L70;
        String r30 = r29.next();
        double r31 = r114.optDouble(r30, 0.0d);
        if (r31 <= 0.0d) goto L66;
        r28.put(r30, Double.valueOf(r31));
    L70:
        this.mExceptionConfig.setForeSceneMaxSpeedMap(r28);
        JSONObject r115 = r12.optJSONObject(KEY_EXCEPTION_BACK_MAX_SPEED_SCENE);
        HashMap r32 = new HashMap();
        if (r115 == null) goto L78;
        Iterator<String> r33 = r115.keys();
    L74:
        if (r33.hasNext() == false) goto L78;
        String r34 = r33.next();
        double r35 = r115.optDouble(r34, 0.0d);
        if (r35 <= 0.0d) goto L74;
        r32.put(r34, Double.valueOf(r35));
    L78:
        this.mExceptionConfig.setBackSceneMaxSpeedMap(r32);
        this.mExceptionConfig.setCollectNativeThread(r12.optBoolean(KEY_EXCEPTION_NATIVE_THREAD_ENABLED, false));
        goto L79
    L46:
        r112 = false;
        goto L47
    L42:
        r111 = false;
        goto L43
    L32:
        r110 = false;
        goto L33
    L13:
        r15 = false;
        goto L14
    L9:
        r14 = false;
    L79:
        Logger.d(Constants.TAG, getConfig() + " " + getExceptionConfig());
        CpuCollectManager.getInstance().updateConfig(getConfig());
        CpuExceptionManager.getInstance().updateConfig(getExceptionConfig());
    }

    @Override // com.bytedance.apm6.cpu.config.CpuConfigService
    @Nullable
    public CpuConfig getConfig() {
        return this.mConfig;
    }

    @Override // com.bytedance.apm6.cpu.config.CpuConfigService
    public CpuExceptionConfig getExceptionConfig() {
        return this.mExceptionConfig;
    }
}
