package zo0;

import com.bytedance.android.live.openplatform.impl.base.perf.OpenPlatformPerformanceReportService;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements f.b<f> {
    public final /* synthetic */ OpenPlatformPerformanceReportService a;

    @Override // zo0.f.b
    public final void onFailure() {
    }

    public d(OpenPlatformPerformanceReportService r1) {
        this.a = r1;
    }

    @Override // zo0.f.b
    public final void a(f r10) {
        Intrinsics.checkNotNullParameter(r10, "timeline");
        long r2 = r10.d("finish", "start");
        long r0 = r10.d("view_created", "start");
        com.bytedance.android.livesdk.log.g r4 = u.l();
        Pair[] r5 = new Pair[5];
        r5[0] = TuplesKt.to("_param_for_special", "micro_app");
        if (this.a.getOpenPlatformContext().isInLive() == false) goto L5;
        String r6 = "in_live";
    L6:
        r5[1] = TuplesKt.to("live_status", r6);
        Intrinsics.checkNotNullParameter(r10, "$this$getClickSource");
        int r7 = f.d;
        r5[2] = TuplesKt.to("click_source", r10.i(""));
        r5[3] = TuplesKt.to("duration", String.valueOf(r2));
        r5[4] = TuplesKt.to("ui_init_duration", String.valueOf(r0));
        r4.e("mp_entrance_shelf_page_fp_cost", MapsKt.mutableMapOf(r5), new Object[]{Room.class});
        return;
    L5:
        r6 = "before_live";
        goto L6
    }
}
