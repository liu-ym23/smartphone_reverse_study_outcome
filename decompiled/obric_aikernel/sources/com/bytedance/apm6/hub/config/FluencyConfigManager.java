package com.bytedance.apm6.hub.config;

import com.bytedance.apm.h;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.perf.base.BasePerfConfigParser;
import org.json.JSONObject;
import u.e;
import u.f;

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

    static /* synthetic */ void access$000(FluencyConfigManager r10, JSONObject r11, boolean r12) {
        r10.parseConfig(r11, r12);
    }

    private void parseConfig(JSONObject r10, boolean r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        JSONObject r12 = BasePerfConfigParser.parseData(r10, PERF_KEY_SMOOTH);
        if (r12 != null) goto L7;
        return;
    L7:
        this.config = new e();
        boolean r13 = false;
        if (r12.optInt(PERF_SMOOTH_STACK_SAMPLING, 0) != 1) goto L10;
        boolean r14 = true;
    L11:
        this.config.s(r14);
        if (r12.optInt(PERF_TRACE_ENABLE, 0) != 1) goto L14;
        boolean r15 = true;
    L15:
        this.config.t(r15);
        this.config.k(r12.optLong(PERF_ATRACE_TAG, 0));
        if (r12.optInt(PERF_SMOOTH_BLOCK_DUMP_STACK, 1) != 1) goto L18;
        boolean r16 = true;
    L19:
        this.config.l(r16);
        if (r12.optInt(PERF_SMOOTH_ENABLE_GFX_MONITOR, 0) != 1) goto L22;
        boolean r17 = true;
    L23:
        this.config.r(r17);
        this.config.n(r12.optInt(PERF_SMOOTH_BLOCK_MONITOR_MODE, 1001));
        if (r12.optInt(PERF_SMOOTH_SERIOUS_BLOCK_ENABLE_UPLOAD, 1) != 1) goto L26;
        boolean r18 = true;
    L27:
        this.config.v(r18);
        this.config.w(r12.optLong(PERF_SMOOTH_SERIOUS_BLOCK_THRESHOLD, DEFAULT_SERIOUS_BLOCK_THRESHOLD));
        if (r12.optInt(PERF_SMOOTH_SLOW_METHOD_ENABLE_UPLOAD, 1) != 1) goto L30;
        boolean r19 = true;
    L31:
        this.config.y(r19);
        if (r12.optInt(PERF_SMOOTH_DROP_ENABLE_UPLOAD, 1) != 1) goto L34;
        boolean r20 = true;
    L35:
        this.config.p(r20);
        if (r12.optInt("enable_upload", 0) != 1) goto L38;
        boolean r21 = true;
    L39:
        this.config.u(r21);
        this.config.o(r12.optLong(PERF_SMOOTH_BLOCK_THRESHOLD, DEFAULT_BLOCK_THRESHOLD));
        this.config.x(r12.optLong(PERF_SMOOTH_DROP_BLOCK_THRESHOLD_MS, 1000));
        if (r12.optInt(PERF_SMOOTH_BLOCK_ENABLE_UPLOAD, 0) != 1) goto L42;
        r13 = true;
    L42:
        this.config.m(r13);
        this.config.q(r12.optBoolean(PERF_SMOOTH_DROP_SLOW_METHOD_SWITCH, true));
        this.config.j(r12.optJSONObject(PERF_SMOOTH_SCENE_ENABLE_UPLOAD));
        h.a().c(getConfig());
        return;
    L38:
        r21 = false;
        goto L39
    L34:
        r20 = false;
        goto L35
    L30:
        r19 = false;
        goto L31
    L26:
        r18 = false;
        goto L27
    L22:
        r17 = false;
        goto L23
    L18:
        r16 = false;
        goto L19
    L14:
        r15 = false;
        goto L15
    L10:
        r14 = false;
        goto L11
    }

    public e getConfig() {
        return this.config;
    }
}
