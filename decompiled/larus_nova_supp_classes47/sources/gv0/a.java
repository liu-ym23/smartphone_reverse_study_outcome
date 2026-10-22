package gv0;

import android.text.TextUtils;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profit.taskcenter.i;
import com.bytedance.android.live.profit.taskcenter.panel.trace.LiveTaskPanelTraceMonitor;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import l01.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements ev0.a {
    public static final a a = null;

    public a() {
    }

    static {
        a = new a();
    }

    public static HashMap c() {
        return (HashMap) i.b.getValue(null, i.a[0]);
    }

    @Override // ev0.a
    public final void a(fv0.a r8) {
        Intrinsics.checkNotNullParameter(r8, "frequencyParams");
        String r9 = r8.a;
        if (by0.b.a(r9) == true) goto L6;
        r9 = null;
    L6:
        if (r9 == null) goto L16;
        String r10 = r9 + ((d) f.a(d.class)).getCurrentUserId();
        String r0 = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT).format(new Date());
        String r2 = r10 + "-lastShowDate";
        String r3 = (String) c().get(r2);
        String r12 = r10 + "-showCount";
        String r4 = (String) c().get(r12);
        if (r4 == null) goto L10;
        int r5 = CastIntegerProtector.parseInt(r4);
    L12:
        if (TextUtils.equals(r0, r3) == false) goto L14;
        HashMap r1 = c();
        r1.put(r12, String.valueOf(r5 + 1));
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        i.b.setValue(null, i.a[0], r1);
        return;
    L14:
        HashMap r6 = c();
        r6.put(r2, r0);
        r6.put(r12, DataType.TRUE);
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        i.b.setValue(null, i.a[0], r6);
        return;
    L10:
        r5 = 0;
        goto L12
    }

    @Override // ev0.a
    public final boolean b(fv0.a r12) {
        Intrinsics.checkNotNullParameter(r12, "frequencyParams");
        int r0 = r12.b;
        String r13 = r12.a;
        String r1 = r13 + ((d) f.a(d.class)).getCurrentUserId();
        String r2 = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT).format(new Date());
        String r3 = (String) c().get(r1 + "-lastShowDate");
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        String r4 = (String) c().get(r1 + "-showCount");
        if (r4 == null) goto L8;
        int r5 = CastIntegerProtector.parseInt(r4);
    L10:
        if (by0.b.a(r13) == false) goto L17;
        if (r0 <= 0) goto L17;
        if (TextUtils.equals(r2, r3) == false) goto L17;
        if (r5 <= r0) goto L17;
        boolean r6 = false;
    L18:
        Map r14 = MapsKt.mapOf(new Pair[]{TuplesKt.to("daily_limit", String.valueOf(r0)), TuplesKt.to("scene", r13), TuplesKt.to("key", r1), TuplesKt.to("current_date", r2), TuplesKt.to("last_data_sp", r3), TuplesKt.to("show_count_sp", String.valueOf(r5)), TuplesKt.to("result", Boolean.valueOf(r6))});
        int r7 = LiveTaskPanelTraceMonitor.a;
        LiveTaskPanelTraceMonitor.a(LiveTaskPanelTraceMonitor.EventName.TTLIVE_TASK_PANEL_MANAGE.getEventName(), LiveTaskPanelTraceMonitor.Step.CHECK_FREQUENCY_DAILY.getStep(), r14);
        return r6;
    L17:
        r6 = true;
        goto L18
    L8:
        r5 = 0;
        goto L10
    }
}
