package l8;

import android.view.View;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.monitor.common.timing.PerformanceTiming;
import com.bytedance.android.annie.ng.g;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import o8.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Runnable {
    public final /* synthetic */ PerformanceTiming a;
    public final /* synthetic */ String b;

    public a(PerformanceTiming r1, String r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void a() {
        PerformanceTiming r10 = this.a;
        String r11 = this.b;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L39
        r10.preParseData();     // Catch: Throwable -> L39
        WeakReference<View> r13 = r10.getViewRef();     // Catch: Throwable -> L39
        if (r13 == null) goto L6;
        View r14 = r13.get();     // Catch: Throwable -> L39
    L7:
        View r15 = r14;
        JSONObject r16 = r10.wrapCategory();     // Catch: Throwable -> L39
        if (JSONObjectProtectorUtils.getString(r16, "template_res_type").equals("unknown") == true) goto L37;
        JSONObject r17 = r10.wrapMetrics();     // Catch: Throwable -> L39
        int r18 = x8.a.a;     // Catch: Throwable -> L39
        x8.a.d("PerformanceTimingHelper", "timing category: " + r16 + ", metric: " + r17, false);     // Catch: Throwable -> L39
        String r0 = "88888";
        if (r15 == null) goto L22;
        i8.a r19 = i8.a.a;     // Catch: Throwable -> L39
        String r20 = r10.getPageUrl();     // Catch: Throwable -> L39
        JSONObject r110 = new JSONObject();     // Catch: Throwable -> L39
        com.bytedance.android.annie.ng.a r111 = g.c.get(r11);     // Catch: Throwable -> L39
        if (r111 == null) goto L21;
        f r112 = r111.b;     // Catch: Throwable -> L39
        if (r112 == null) goto L21;
        String r113 = r112.a;     // Catch: Throwable -> L39
        if (r113 == null) goto L21;
        r0 = r113;
    L21:
        r110.put("virtual_aid", r0);     // Catch: Throwable -> L39
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L39
        r19.a(r15, "annie_performance_timing_v1", r20, r16, r17, r110, 1);     // Catch: Throwable -> L39
        char r114 = 0;
    L31:
        String r21 = r10.getPageUrl();     // Catch: Throwable -> L39
        String r22 = "";
        if (r21 != null) goto L45;
        r21 = "";
    L45:
        r22 = new JSONObject(r10.getPerfTimingMap()).toString();     // Catch: Exception -> L42 Throwable -> L39
    L36:
        x9.b r23 = (x9.b) Annie.getService(x9.b.class, r11);     // Catch: Throwable -> L39
        Pair[] r24 = new Pair[4];     // Catch: Throwable -> L39
        r24[r114] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_URL, r21);     // Catch: Throwable -> L39
        r24[1] = TuplesKt.to("container_info", r16.toString());     // Catch: Throwable -> L39
        r24[2] = TuplesKt.to("container_metric", r17.toString());     // Catch: Throwable -> L39
        r24[3] = TuplesKt.to("container_timing", r22);     // Catch: Throwable -> L39
        r23.logV3("livesdk_live_container_timing", MapsKt.mapOf(r24));     // Catch: Throwable -> L39
        goto L37
    L22:
        i8.a r25 = i8.a.a;     // Catch: Throwable -> L39
        String r26 = r10.getPageUrl();     // Catch: Throwable -> L39
        JSONObject r115 = new JSONObject();     // Catch: Throwable -> L39
        com.bytedance.android.annie.ng.a r116 = g.c.get(r11);     // Catch: Throwable -> L39
        if (r116 == null) goto L30;
        f r117 = r116.b;     // Catch: Throwable -> L39
        if (r117 == null) goto L30;
        String r118 = r117.a;     // Catch: Throwable -> L39
        if (r118 == null) goto L30;
        r0 = r118;
    L30:
        r115.put("virtual_aid", r0);     // Catch: Throwable -> L39
        Unit r27 = Unit.INSTANCE;     // Catch: Throwable -> L39
        r114 = 0;
        j9.b.a.a(r25, r15, "annie_performance_timing_v1", r26, r16, r17, null, r115, 1, 256);     // Catch: Throwable -> L39
    L37:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L39
        return;
    L6:
        r14 = null;
    L39:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
