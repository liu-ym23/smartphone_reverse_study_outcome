package com.bytedance.apm6.hub.config;

import com.bytedance.apm.config.e;
import com.bytedance.apm.config.f;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.perf.base.BasePerfConfigParser;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FluencyConfigManager implements f {
    private static final long DEFAULT_BLOCK_THRESHOLD = 2500;
    private static final long DEFAULT_DROP_THRESHOLD = 1000;
    private static final long DEFAULT_SERIOUS_BLOCK_THRESHOLD = 4000;
    private static final String PERF_ATRACE_TAG = "atrace_tag";
    private static final String PERF_ENABLE_UPLOAD = "enable_upload";
    private static final String PERF_KEY_SMOOTH = "smooth";
    private static final String PERF_SMOOTH_BLOCK_DUMP_STACK = "block_dump_stack_enable";
    private static final String PERF_SMOOTH_BLOCK_ENABLE_UPLOAD = "block_enable_upload";
    private static final String PERF_SMOOTH_BLOCK_MONITOR_MODE = "block_monitor_mode";
    private static final String PERF_SMOOTH_BLOCK_THRESHOLD = "block_threshold";
    private static final String PERF_SMOOTH_DROP_BLOCK_THRESHOLD_MS = "drop_threshold";
    private static final String PERF_SMOOTH_DROP_ENABLE_UPLOAD = "drop_enable_upload";
    private static final String PERF_SMOOTH_DROP_SLOW_METHOD_SWITCH = "drop_slow_method_switch";
    private static final String PERF_SMOOTH_ENABLE_GFX_MONITOR = "enable_gfx_monitor";
    private static final String PERF_SMOOTH_SCENE_ENABLE_UPLOAD = "scene_enable_upload";
    private static final String PERF_SMOOTH_SERIOUS_BLOCK_ENABLE_UPLOAD = "serious_block_enable_upload";
    private static final String PERF_SMOOTH_SERIOUS_BLOCK_THRESHOLD = "serious_block_threshold";
    private static final String PERF_SMOOTH_SLOW_METHOD_ENABLE_UPLOAD = "slow_method_enable_upload";
    private static final String PERF_SMOOTH_STACK_SAMPLING = "enable_stack_sampling";
    private static final String PERF_TRACE_ENABLE = "enable_trace";
    private e config;

    public FluencyConfigManager() {
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new AnonymousClass1(this));
    }

    static /* synthetic */ void access$000(FluencyConfigManager r0, JSONObject r1, boolean r2) {
        r0.parseConfig(r1, r2);
    }

    private void parseConfig(JSONObject r5, boolean r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        JSONObject r7 = BasePerfConfigParser.parseData(r5, PERF_KEY_SMOOTH);
        if (r7 != null) goto L7;
        return;
    L7:
        this.config = new e();
        boolean r0 = false;
        if (r7.optInt(PERF_SMOOTH_STACK_SAMPLING, 0) != 1) goto L10;
        boolean r8 = true;
    L11:
        this.config.a(r8);
        if (r7.optInt(PERF_TRACE_ENABLE, 0) != 1) goto L14;
        boolean r9 = true;
    L15:
        this.config.b(r9);
        this.config.a(r7.optLong(PERF_ATRACE_TAG, 0));
        if (r7.optInt(PERF_SMOOTH_BLOCK_DUMP_STACK, 1) != 1) goto L18;
        boolean r10 = true;
    L19:
        this.config.c(r10);
        if (r7.optInt(PERF_SMOOTH_ENABLE_GFX_MONITOR, 0) != 1) goto L22;
        boolean r11 = true;
    L23:
        this.config.d(r11);
        this.config.a(r7.optInt(PERF_SMOOTH_BLOCK_MONITOR_MODE, 1001));
        if (r7.optInt(PERF_SMOOTH_SERIOUS_BLOCK_ENABLE_UPLOAD, 1) != 1) goto L26;
        boolean r12 = true;
    L27:
        this.config.e(r12);
        this.config.b(r7.optLong(PERF_SMOOTH_SERIOUS_BLOCK_THRESHOLD, 4000));
        if (r7.optInt(PERF_SMOOTH_SLOW_METHOD_ENABLE_UPLOAD, 1) != 1) goto L30;
        boolean r13 = true;
    L31:
        this.config.f(r13);
        if (r7.optInt(PERF_SMOOTH_DROP_ENABLE_UPLOAD, 1) != 1) goto L34;
        boolean r14 = true;
    L35:
        this.config.g(r14);
        if (r7.optInt("enable_upload", 0) != 1) goto L38;
        boolean r15 = true;
    L39:
        this.config.h(r15);
        this.config.c(r7.optLong(PERF_SMOOTH_BLOCK_THRESHOLD, 2500));
        this.config.d(r7.optLong(PERF_SMOOTH_DROP_BLOCK_THRESHOLD_MS, 1000));
        if (r7.optInt(PERF_SMOOTH_BLOCK_ENABLE_UPLOAD, 0) != 1) goto L42;
        r0 = true;
    L42:
        this.config.i(r0);
        this.config.j(r7.optBoolean(PERF_SMOOTH_DROP_SLOW_METHOD_SWITCH, true));
        this.config.a(r7.optJSONObject(PERF_SMOOTH_SCENE_ENABLE_UPLOAD));
        com.bytedance.apm.e.a().a(getConfig());
        return;
    L38:
        r15 = false;
        goto L39
    L34:
        r14 = false;
        goto L35
    L30:
        r13 = false;
        goto L31
    L26:
        r12 = false;
        goto L27
    L22:
        r11 = false;
        goto L23
    L18:
        r10 = false;
        goto L19
    L14:
        r9 = false;
        goto L15
    L10:
        r8 = false;
        goto L11
    }

    public e getConfig() {
        return this.config;
    }
}
