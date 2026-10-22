package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopBannerContainerViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowBannerData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIBannerContainerView extends BaseGiftMVIViewChildNode<GiftTopViewState, GiftTopBannerContainerViewState, GiftAction> {
    public zy0.b m;
    public final Lazy n;

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return 2131567535;
    }

    public final void i() {
        ((ViewGroup) this.n.getValue()).removeAllViews();
        zy0.b r0 = this.m;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftTopViewState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIBannerContainerView$bindToParent$1 r0 = GiftMVIBannerContainerView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public GiftMVIBannerContainerView(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        super(r2, r3);
        this.n = LazyKt.lazy(new GiftMVIBannerContainerView$rootView$2(this));
    }

    public final void b(com.bytedance.android.anya.k r4, MVIState r5) {
        GiftTopBannerContainerViewState r6 = (GiftTopBannerContainerViewState) r5;
        Intrinsics.checkNotNullParameter(r4, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r6, "state");
        r0<GiftTopBannerContainerViewState, ShowBannerData> r7 = r6.getShowBanner();
        Object r0 = r4.c.a(r7);
        if (r0 == null) goto L21;
        r4.b.a.invoke(r7);
        ShowBannerData r1 = (ShowBannerData) r0;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v.e() == true) goto L8;
        return;
    L8:
        if (r1.getCanShow() == true) goto L10;
        return;
    L10:
        if (this.m == null) goto L12;
        return;
    L12:
        if (com.bytedance.android.live.revenue.common.b0.a().a() == false) goto L14;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r8 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).q8(getContext(), r1.getSchemaUrl(), null);
    L15:
        this.m = r8;
        if (r8 == null) goto L24;
        ((ViewGroup) this.n.getValue()).addView(r8.c());
        xy0.a r9 = r8.g();
        if (r9 == null) goto L25;
        r9.load(null, r1.getRenderParams());
        return;
    L25:
        return;
    L24:
        return;
    L14:
        r8 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).J8(getContext(), r1.getSchemaUrl(), null);
        goto L15
    }
}
