package g5;

import com.bytedance.lynx.service.monitor.LynxMonitorService;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends t4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f17058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17059c;
    public final long d;
    public Map e;

    public e() {
        super("performance");
        this.d = System.currentTimeMillis();
    }

    @Override // sj.g
    public final void m(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "jsonObj");
        Object r10 = null;
        qo.a.m(r5, null);
        Double r11 = Double.valueOf(0.0d);
        qo.a.j(r11, "fp", r5);
        qo.a.j(r11, "fmp", r5);
        qo.a.j(r11, "tti", r5);
        qo.a.j(r11, "Layout", r5);
        qo.a.j(r11, "render_page", r5);
        qo.a.j(r11, "Diff_root_create", r5);
        qo.a.j(r11, "Diff_same_root", r5);
        qo.a.j(r11, "tasm_binary_decode", r5);
        qo.a.j(r11, "tasm_end_decode_finish_load_template", r5);
        qo.a.j(r11, "tasm_finish_load_template", r5);
        qo.a.e(this.f17059c, "state", r5);
        qo.a.k("report_ts", this.d, r5);
        JSONObject r12 = new JSONObject();
        Map r13 = this.e;
        if (r13 == null) goto L5;
        Object r14 = r13.get(LynxMonitorService.KEY_METRICS);
    L6:
        if (r14 == null) goto L12;
        Map r15 = this.e;
        if (r15 == null) goto L10;
        Object r16 = r15.get(LynxMonitorService.KEY_METRICS);
    L11:
        qo.a.j(qo.a.c(String.valueOf(r16)), LynxMonitorService.KEY_METRICS, r12);
        goto L12
    L10:
        r16 = null;
    L12:
        Map r17 = this.e;
        if (r17 == null) goto L15;
        Object r18 = r17.get(LynxMonitorService.KEY_SETUP_TIMING);
    L16:
        if (r18 == null) goto L22;
        Map r19 = this.e;
        if (r19 == null) goto L20;
        Object r20 = r19.get(LynxMonitorService.KEY_SETUP_TIMING);
    L21:
        qo.a.j(qo.a.c(String.valueOf(r20)), LynxMonitorService.KEY_SETUP_TIMING, r12);
        goto L22
    L20:
        r20 = null;
    L22:
        Map r21 = this.e;
        if (r21 == null) goto L25;
        Object r22 = r21.get(LynxMonitorService.KEY_UPDATE_TIMING);
    L26:
        if (r22 == null) goto L32;
        Map r23 = this.e;
        if (r23 == null) goto L30;
        Object r24 = r23.get(LynxMonitorService.KEY_UPDATE_TIMING);
    L31:
        qo.a.j(qo.a.c(String.valueOf(r24)), LynxMonitorService.KEY_UPDATE_TIMING, r12);
        goto L32
    L30:
        r24 = null;
    L32:
        Map r25 = this.e;
        if (r25 == null) goto L35;
        Object r26 = r25.get(LynxMonitorService.KEY_EXTRA_TIMING);
    L36:
        if (r26 == null) goto L42;
        Map r27 = this.e;
        if (r27 == null) goto L40;
        Object r28 = r27.get(LynxMonitorService.KEY_EXTRA_TIMING);
    L41:
        qo.a.j(qo.a.c(String.valueOf(r28)), LynxMonitorService.KEY_EXTRA_TIMING, r12);
        goto L42
    L40:
        r28 = null;
    L42:
        Map r29 = this.e;
        if (r29 == null) goto L45;
        Object r30 = r29.get("thread_strategy");
    L46:
        if (r30 == null) goto L52;
        Map r31 = this.e;
        if (r31 == null) goto L50;
        Object r32 = r31.get("thread_strategy");
    L51:
        qo.a.j(r32, "thread_strategy", r12);
        goto L52
    L50:
        r32 = null;
    L52:
        Map r33 = this.e;
        if (r33 == null) goto L55;
        Object r34 = r33.get("url");
    L57:
        if (String.valueOf(r34).length() <= 0) goto L62;
        Map r35 = this.e;
        if (r35 == null) goto L61;
        r10 = r35.get("url");
    L61:
        qo.a.j(r10, "url", r12);
    L62:
        qo.a.m(r5, r12);
        c r36 = this.f17058b;
        if (r36 == null) goto L66;
        r36.m(r5);
        return;
    L66:
        return;
    L55:
        r34 = null;
        goto L57
    L45:
        r30 = null;
        goto L46
    L35:
        r26 = null;
        goto L36
    L25:
        r22 = null;
        goto L26
    L15:
        r18 = null;
        goto L16
    L5:
        r14 = null;
        goto L6
    }
}
