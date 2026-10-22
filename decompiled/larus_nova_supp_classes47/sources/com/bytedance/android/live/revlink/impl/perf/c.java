package com.bytedance.android.live.revlink.impl.perf;

import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.live.revlink.api.service.IDegradeTask;
import com.bytedance.android.live.revlink.impl.utils.z;
import com.bytedance.android.livesdk.revenue.service.feature.IRevFeatureService;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.datacontext.i;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements Runnable {
    public final /* synthetic */ LinkPerfManager a;

    public c(LinkPerfManager r1) {
        this.a = r1;
    }

    public final void a() {
        LinkPerfManager r0 = this.a;
        b r2 = r0.i;
        int r3 = r0.h;
        int r1 = LinkPerfManager.j(r0, r3);
        int r6 = 1;
        if (r2.g.size() >= r1) goto L6;
        boolean r4 = false;
    L17:
        if (r4 == false) goto L142;
        int r5 = z.a;
        LinkPerfManager r7 = this.a;
        int r8 = r7.h;
        b r9 = r7.i;
        Intrinsics.checkNotNullParameter(r9, Constants.Keys.DATA);
        com.bytedance.android.live.revlink.impl.settings.live.b r10 = com.bytedance.android.live.revlink.impl.settings.live.b.p;
        if (r10.b().getEnable() == false) goto L51;
        long r12 = r9.d;
        com.bytedance.android.livesdk.revenue.service.room.c r13 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r13 == null) goto L33;
        com.bytedance.android.livesdk.revenue.room.a r14 = r13.getRoomContext();
        if (r14 == null) goto L33;
        i r15 = r14.isAnchor();
        if (r15 == null) goto L33;
        if (((Boolean) r15.getValue()).booleanValue() != true) goto L33;
        long r18 = r10.b().C3();
        if (r18 >= 1) goto L38;
    L36:
        r18 = 1;
    L38:
        if ((r12 % r18) != 0) goto L50;
        LinkedHashMap r16 = new LinkedHashMap();
        Pair<Double, Long> r17 = r9.a(r8);
        if (r17 == null) goto L42;
        Double r19 = (Double) r17.getFirst();
    L43:
        r16.put("stream_fps_avg", String.valueOf(r19));
        r16.put("monitor_scene", String.valueOf(r8));
        z.b(r16);
        z.a(r16);
        z.c();
        z.d("livesdk_rd_con_perf_monitor", r16);
        if (r8 != 2) goto L50;
        if (r19 == null) goto L47;
        vh6.c.b(IRevFeatureService.class).nb("revlink_fore_fps_avg", Double.valueOf(r19.doubleValue()), IRevFeatureService.RevFeatureType.DYNAMIC_MONITOR);
    L47:
        IPerformanceManager r20 = k.f(IPerformanceManager.class);
        if (r20 == null) goto L50;
        vh6.c.b(IRevFeatureService.class).nb("revlink_fore_ui_stall_rate", Double.valueOf(Float.valueOf(r20.getUIStallRate()).floatValue()), IRevFeatureService.RevFeatureType.DYNAMIC_MONITOR);
        goto L50
    L42:
        r19 = null;
    L50:
        r9.d++;
    L33:
        r18 = r10.b().W5();
        if (r18 < 1) goto L36;
    L51:
        LinkPerfManager r22 = this.a;
        int r23 = r22.h;
        if (r23 != 1) goto L143;
        a r24 = r22.j;
        b r25 = r22.i;
        r24.getClass();
        Intrinsics.checkNotNullParameter(r25, Constants.Keys.DATA);
        if (r24.g == true) goto L56;
    L58:
        Pair<Double, Long> r26 = r25.a(r23);
        if (r26 == null) goto L145;
        Double r27 = (Double) r26.getFirst();
        if (r27 == null) goto L146;
        boolean r28 = a.l(r27.doubleValue(), true);
        if (r24.f == false) goto L72;
        boolean r110 = a.j();
        if (r28 == true) goto L69;
        if (r110 == true) goto L69;
        r24.a = -1;
        long r111 = 0;
    L79:
        if (r24.a > r111) goto L81;
    L83:
        boolean r29 = false;
    L84:
        if (r29 == true) goto L86;
    L92:
        if (r28 == false) goto L94;
        return;
    L94:
        if (r24.c == true) goto L96;
        return;
    L96:
        if (r24.b >= 0) goto L99;
        r24.b = System.currentTimeMillis();
    L99:
        if (r24.b > 0) goto L101;
    L103:
        r6 = 0;
    L104:
        if (r6 == 0) goto L150;
        r24.c = false;
        r24.a = -1;
        r24.e = -1;
        long r30 = System.currentTimeMillis();
        long r32 = r24.d;
        if (1 <= r32) goto L109;
    L111:
        ConcurrentHashMap<Integer, IDegradeTask> r33 = r24.h;
        if (r33 == null) goto L123;
        Iterator<Map.Entry<Integer, IDegradeTask>> r34 = r33.entrySet().iterator();
    L115:
        if (r34.hasNext() == false) goto L123;
        Map.Entry<Integer, IDegradeTask> r35 = r34.next();
        IDegradeTask r36 = r35.getValue();     // Catch: Exception -> L121
        if (r36 == null) goto L115;
        r36.onRecover();     // Catch: Exception -> L121
    L121:
        e = move-exception;
        jy0.b.c("LinkDegradeManager", "trigger recover error：type = " + r35.getKey().intValue() + "; message = " + e.getMessage(), null, 4);
    L123:
        int r37 = z.a;
        long r38 = r24.e;
        Intrinsics.checkNotNullParameter(r25, Constants.Keys.DATA);
        if (com.bytedance.android.live.revlink.impl.settings.live.b.p.b().getEnable() == false) goto L151;
        LinkedHashMap r39 = new LinkedHashMap();
        Pair<Double, Long> r40 = r25.a(r23);
        if (r40 == null) goto L129;
        Double r112 = (Double) r40.getFirst();
    L130:
        r39.put("stream_fps_avg", String.valueOf(r112));
        r39.put("monitor_scene", String.valueOf(r23));
        r39.put("degrade_duration", String.valueOf(r38));
        z.b(r39);
        z.a(r39);
        z.c();
        z.d("livesdk_rd_con_perf_monitor_recover_trigger", r39);
        return;
    L129:
        r112 = null;
        goto L130
    L151:
        return;
    L109:
        if (r30 <= r32) goto L111;
        r24.e = r30 - r32;
        r24.d = -1;
        goto L111
    L150:
        return;
    L101:
        if ((System.currentTimeMillis() - r24.b) < a.k(2)) goto L103;
    L86:
        if (r24.c == true) goto L92;
        r24.m();
        if (r28 == true) goto L91;
        r6 = 2;
    L91:
        z.e(r23, r25, r6, "timer_check");
        return;
    L81:
        if ((System.currentTimeMillis() - r24.a) < a.k(1)) goto L83;
        r29 = true;
    L69:
        r111 = 0;
        if (r24.a > 0) goto L79;
        r24.a = System.currentTimeMillis();
        goto L79
    L72:
        r111 = 0;
        if (r28 == true) goto L75;
        r24.a = -1;
        goto L79
    L75:
        if (r24.a > 0) goto L79;
        r24.a = System.currentTimeMillis();
        goto L79
    L146:
        return;
    L145:
        return;
    L56:
        if (r24.c == true) goto L58;
        r24.f("force");
        return;
    L143:
        return;
    L142:
        return;
    L6:
        if (r2.g.size() <= r1) goto L9;
        r2.g.remove();
        goto L6
    L9:
        if ((!r2.g.isEmpty()) == false) goto L15;
        Iterator<Double> r42 = r2.g.iterator();
        double r43 = 0.0d;
    L12:
        if (r42.hasNext() == false) goto L14;
        r43 = r43 + r42.next().doubleValue();
        goto L12
    L14:
        double r44 = r43 / ((double) r2.g.size());
    L16:
        r2.f.put(Integer.valueOf(r3), new Pair(Double.valueOf(r44), Long.valueOf(System.currentTimeMillis())));
        r4 = true;
        goto L17
    L15:
        r44 = 15.0d;
        goto L16
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
