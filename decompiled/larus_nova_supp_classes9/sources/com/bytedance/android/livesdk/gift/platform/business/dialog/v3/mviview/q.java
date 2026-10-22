package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.LoadFailCode;
import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.ShareViewCard;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftPanelMonitorService;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class q implements com.bytedance.android.live.revenue.platform.hybrid.api.shareview.f {
    public final /* synthetic */ GiftMVIDynamicPanel a;
    public final /* synthetic */ ShareViewCard b;
    public final /* synthetic */ Map c;

    public final void c() {
    }

    public final void onFallback() {
    }

    public final void a() {
        jy0.b.d("GiftMVIDynamicPanel", "share view loaded");
        i12.d r0 = i12.m.e2.a();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, GiftPanelMonitorService.class);
    L6:
        GiftPanelMonitorService r2 = (GiftPanelMonitorService) r1;
        if (r2 == null) goto L10;
        GiftMVIDynamicPanel r3 = this.a;
        r2.g(r3.n, r3.o, r3.p);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    public final void e(com.bytedance.android.live.revenue.platform.hybrid.api.shareview.c r2) {
        Intrinsics.checkNotNullParameter(r2, "sharer");
        Intrinsics.checkNotNullParameter(r2, "sharer");
    }

    public final void b(String r2, LoadFailCode r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "code");
        jy0.b.d("GiftMVIDynamicPanel", "load failed: ".concat(r2));
        UtilityKotlinExtentionsKt.q(this.b.a);
        this.b.c();
        GiftMVIDynamicPanel r4 = this.a;
        r4.q = null;
        r4.t(this.c);
    }

    public q(GiftMVIDynamicPanel r1, ShareViewCard r2, Map r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
