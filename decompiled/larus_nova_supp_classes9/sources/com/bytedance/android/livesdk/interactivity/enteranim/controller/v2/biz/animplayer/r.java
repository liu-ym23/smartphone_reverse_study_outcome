package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profit.dress.api.OpenAssetPlayErrorType;
import com.bytedance.android.live.profit.privilege.model.ProfitCheckType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.RevenueUtils;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.bdlocation.BuildConfig;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r implements com.bytedance.android.live.profit.player.l {
    public final /* synthetic */ s a;

    public final void onLoad() {
    }

    public final void onStop() {
        s r0 = this.a;
        OpenAssetVideoPlayer r1 = r0.a;
        k32.c r2 = r0.b;
        long r3 = r0.c;
        a r4 = r0.d;
        ((zt0.f) r1.d.getValue()).b(r2.u, r3);
        com.bytedance.android.live.profit.player.d r5 = yt0.c.h();
        if (r5 == null) goto L8;
        com.bytedance.android.live.profit.player.p r6 = r5.f1();
        if (r6 == null) goto L8;
        r6.b(r2.x, r2.y);
    L8:
        if ((!Intrinsics.areEqual(r2.a, jc1.k.n(IMiddlewareUserService.class).user().n())) == true) goto L34;
        com.bytedance.android.live.profit.dress.u r7 = yt0.c.a().getDressData(r2.u, 23, "OpenAsset: playAnim");
        LinkedHashMap r8 = new LinkedHashMap();
        if (r7 == null) goto L18;
        a5 r9 = r7.d;
        if (r9 == null) goto L18;
        String r10 = r9.getDefaultPattern();
        if (r10 != null) goto L17;
        r10 = BuildConfig.FLAVOR;
    L17:
        r8.put("script", sb2.a.h(r9, r10, false).toString());
    L18:
        if (r7 == null) goto L20;
        r8.put("asset_id", Long.valueOf(r7.a));
    L20:
        py.k r11 = r2.x.getAvatarThumbKt();
        if (r11 == null) goto L27;
        List r13 = r11.getUrls();
        if (r13 == null) goto L27;
        String r14 = (String) CollectionsKt.getOrNull(r13, 0);
        if (r14 == null) goto L27;
        r8.put("user_avatar_url", r14);
    L27:
        py.f r15 = r2.x.getBorder();
        if (r15 == null) goto L32;
        String r16 = r15.getDressId();
        if (r16 == null) goto L32;
        r8.put("avatar_border_dress_id", r16);
    L32:
        r8.put("dress_id", r2.u);
        boolean r17 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.privilege.c.class).B1(ProfitCheckType.DRESS_OPEN_EFFECT, r8, null);
    L34:
        if (r2.t.getAndSet(true) == true) goto L37;
        r2.z.onEnd();
        ((v72.c.a) r4).a();
    L37:
        this.a.a.getClass();
        jc1.k.n(IPerformanceManager.class).onModuleStop("open_asset");
    }

    public final void onStart() {
        com.bytedance.android.live.profit.player.d r0 = yt0.c.h();
        if (r0 == null) goto L7;
        com.bytedance.android.live.profit.player.p r1 = r0.f1();
        if (r1 == null) goto L7;
        k32.c r2 = this.a.b;
        r1.c(r2.x, r2.y);
    L7:
        s r3 = this.a;
        OpenAssetVideoPlayer r4 = r3.a;
        String r5 = r3.b.u;
        long r6 = r3.i.a;
        r4.getClass();
        jc1.k.n(IPerformanceManager.class).onModuleStart("open_asset", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("assert_id", r5), TuplesKt.to("dress_id", String.valueOf(r6))}));
        ((v72.c.a) this.a.d).b();
    }

    public r(s r1) {
        this.a = r1;
    }

    public final void a(Throwable r9) {
        s r0 = this.a;
        OpenAssetVideoPlayer r1 = r0.a;
        k32.c r2 = r0.b;
        long r3 = r0.c;
        OpenAssetPlayErrorType r5 = OpenAssetPlayErrorType.PlayError;
        if (r9 == null) goto L6;
        String r10 = r9.getMessage();
        if (r10 == null) goto L6;
    L7:
        r1.d(r2, r3, r5, r10, this.a.d);
        return;
    L6:
        r10 = "onErrorEnd";
        goto L7
    }

    public final com.bytedance.android.live.profit.player.k b(int r3, int r4) {
        int r0 = (s1.w() - this.a.f.a) - ((int) s1.I(11.0f));
        RevenueUtils.i.getClass();
        return RevenueUtils.b.b(r3, r4, r0);
    }
}
