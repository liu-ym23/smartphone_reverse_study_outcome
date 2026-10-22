package gv0;

import com.bytedance.android.live.profit.taskcenter.i;
import com.bytedance.android.live.profit.taskcenter.panel.trace.LiveTaskPanelTraceMonitor;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements ev0.a {
    public static final c a = null;

    public c() {
    }

    static {
        a = new c();
    }

    @Override // ev0.a
    public final void a(fv0.a r7) {
        Intrinsics.checkNotNullParameter(r7, "frequencyParams");
        String r8 = r7.d;
        com.bytedance.tools.kcp.spongepreference.runtime.a r0 = i.c;
        KProperty[] r1 = i.a;
        String r3 = (String) ((HashMap) r0.getValue(null, r1[1])).get(r8);
        if (r3 == null) goto L5;
        int r4 = CastIntegerProtector.parseInt(r3);
    L6:
        HashMap r5 = (HashMap) r0.getValue(null, r1[1]);
        r5.put(r8, String.valueOf(r4 + 1));
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r0.setValue(null, r1[1], r5);
        return;
    L5:
        r4 = 0;
        goto L6
    }

    @Override // ev0.a
    public final boolean b(fv0.a r8) {
        Intrinsics.checkNotNullParameter(r8, "frequencyParams");
        int r0 = r8.c;
        String r9 = r8.d;
        String r1 = (String) ((HashMap) i.c.getValue(null, i.a[1])).get(r9);
        if (r1 == null) goto L5;
        int r2 = CastIntegerProtector.parseInt(r1);
    L7:
        if (by0.b.a(r9) == false) goto L12;
        if (r0 <= 0) goto L12;
        if (r2 <= r0) goto L12;
        boolean r4 = false;
    L13:
        Map r10 = MapsKt.mapOf(new Pair[]{TuplesKt.to("lifetime_limit", String.valueOf(r0)), TuplesKt.to("activityId", r9), TuplesKt.to("show_count_sp", String.valueOf(r2)), TuplesKt.to("result", Boolean.valueOf(r4))});
        int r3 = LiveTaskPanelTraceMonitor.a;
        LiveTaskPanelTraceMonitor.a(LiveTaskPanelTraceMonitor.EventName.TTLIVE_TASK_PANEL_MANAGE.getEventName(), LiveTaskPanelTraceMonitor.Step.CHECK_FREQUENCY_LIFETIME.getStep(), r10);
        return true;
    L12:
        r4 = true;
        goto L13
    L5:
        r2 = 0;
        goto L7
    }
}
