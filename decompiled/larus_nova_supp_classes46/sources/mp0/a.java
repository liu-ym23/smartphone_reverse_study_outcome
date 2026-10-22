package mp0;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.openplatform.impl.base.perf.OpenPlatformPerformanceReportService;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.scope.o;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zo0.f;
import zo0.g;
import zo0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements o {
    public boolean a;
    public boolean b;
    public boolean c;
    public final lp0.a d;

    public final void onStart() {
    }

    public final void onStop() {
        c(this, "cancel", null, null, 14);
    }

    public a(lp0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.d = r2;
        this.b = true;
        this.c = true;
    }

    public final void f(boolean r15) {
        if (r15 == true) goto L5;
    L9:
        if (r15 == false) goto L11;
        return;
    L11:
        if (this.c == false) goto L19;
        this.c = false;
        OpenPlatformPerformanceReportService r5 = (OpenPlatformPerformanceReportService) lp0.b.b(this.d, OpenPlatformPerformanceReportService.class);
        if (r5 == null) goto L20;
        HashMap<String, f> r16 = g.a;
        f r17 = h.b(PerformanceScene.CHOOSE_PAGE_LYNX);
        r17.b();
        r5.f("promotion_task", r17.i(""), r17.d("view_created", "start"), r17.d("list_request_data_end", "list_request_data_begin"), f.e(r17));
        return;
    L20:
        return;
    L19:
        return;
    L5:
        if (this.b == false) goto L9;
        this.b = false;
        OpenPlatformPerformanceReportService r6 = (OpenPlatformPerformanceReportService) lp0.b.b(this.d, OpenPlatformPerformanceReportService.class);
        if (r6 == null) goto L16;
        HashMap<String, f> r18 = g.a;
        f r19 = h.b(PerformanceScene.CHOOSE_PAGE_LIST);
        r19.b();
        r6.f("miniapp", r19.i(""), r19.d("view_created", "start"), r19.d("list_request_data_end", "list_request_data_begin"), f.e(r19));
        return;
    }

    public static Map a(String r4, String r5, boolean r6, String r7, Integer r8) {
        Pair[] r0 = new Pair[9];
        boolean r1 = false;
        r0[0] = TuplesKt.to("mp_id", r4);
        r0[1] = TuplesKt.to("_param_for_special", "micro_app");
        r0[2] = TuplesKt.to("scene", "023009");
        r0[3] = TuplesKt.to("launch_from", "live");
        r0[4] = TuplesKt.to("location", PbRequest.SwitchType.PREVIEW);
        r0[5] = TuplesKt.to("enter_position", r5);
        r0[6] = TuplesKt.to("entrance_form", "solid_entrance");
        r0[7] = TuplesKt.to("enter_from_merge", "live_take_page");
        if (r6 == false) goto L5;
        String r9 = "in_live";
    L6:
        r0[8] = TuplesKt.to("live_status", r9);
        Map r10 = MapsKt.mutableMapOf(r0);
        if (r7 != null) goto L9;
    L10:
        r1 = true;
    L11:
        if (r1 == true) goto L13;
        r10.put("recommend_reason", r7);
    L13:
        if (r8 == null) goto L15;
        r8.intValue();
        r10.put("bind_mp_order", String.valueOf(r8.intValue()));
    L15:
        return r10;
    L9:
        if (StringsKt.isBlank(r7) == false) goto L11;
    L5:
        r9 = "before_live";
        goto L6
    }

    public static void c(a r2, String r3, String r4, String r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = "";
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = "";
    L8:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "stage");
        Intrinsics.checkNotNullParameter(r4, "stageDesc");
        Intrinsics.checkNotNullParameter(r5, "pageType");
        if (Intrinsics.areEqual(r3, "success") == true) goto L15;
        if (Intrinsics.areEqual(r3, "fail") == true) goto L15;
        if (Intrinsics.areEqual(r3, "cancel") == true) goto L15;
    L18:
        int r7 = no0.a.a;
        no0.a.b("native", r3, r4, null, r5);
        return;
    L15:
        if (r2.a == true) goto L20;
        r2.a = true;
        goto L18
    }

    public static void d(String r1, String r2, boolean r3, String r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r1, "mpId");
        Intrinsics.checkNotNullParameter(r2, "enterPosition");
        u.l().e("mp_show", a(r1, r2, r3, r4, r5), new Object[0]);
    }
}
