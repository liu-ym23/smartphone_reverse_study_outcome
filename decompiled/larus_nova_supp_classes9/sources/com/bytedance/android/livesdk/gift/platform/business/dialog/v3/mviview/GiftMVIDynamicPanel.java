package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.ShareViewCard;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.GiftPreloadManager;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.GiftPreloadResType;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftDynamicPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIDynamicPanel extends BaseGiftMVIViewChildNode<GiftPanelState, GiftDynamicPanelState, GiftAction> {
    public zy0.b m;
    public long n;
    public long o;
    public long p;
    public ShareViewCard q;
    public final Lazy r;

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return 2131566122;
    }

    public final void i() {
        ((ViewGroup) this.r.getValue()).removeAllViews();
        zy0.b r0 = this.m;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        ShareViewCard r1 = this.q;
        if (r1 == null) goto L9;
        r1.c();
        return;
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftPanelState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIDynamicPanel$bindToParent$1 r0 = GiftMVIDynamicPanel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final void t(Map<String, ? extends Object> r7) {
        String r0 = com.bytedance.android.livesdk.gift.platform.core.h.k().a();
        if (com.bytedance.android.livesdk.gift.platform.core.h.k().c() == false) goto L9;
        HashMap<GiftPreloadResType, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.k<?>> r1 = GiftPreloadManager.a;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.a r2 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p000new.a) GiftPreloadManager.a(com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.new.f.a.c);
        vy0.c r3 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class);
        Context r4 = getContext();
        Uri r5 = UriProtector.parse(r0);
        if (r2 == null) goto L7;
        Object r6 = r2.a;
    L8:
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r8 = r3.Ui(r4, r5, r6, new GiftMVIDynamicPanel$renderAnnieCard$hybridCard$1(this));
    L10:
        this.m = r8;
        if (r8 == null) goto L15;
        ((ViewGroup) this.r.getValue()).addView(r8.c());
        this.o = System.currentTimeMillis();
        xy0.a r9 = r8.g();
        if (r9 == null) goto L15;
        r9.load(null, r7);
    L15:
        zy0.b r10 = this.m;
        if (r10 == null) goto L21;
        xy0.a r11 = r10.g();
        if (r11 == null) goto L22;
        r11.registerMethod("revenue.requestStickerEffectStatus", p.a);
        return;
    L22:
        return;
    L21:
        return;
    L7:
        r6 = null;
        goto L8
    L9:
        r8 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).J8(getContext(), UriProtector.parse(r0), null);
        goto L10
    }

    public GiftMVIDynamicPanel(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        super(r2, r3);
        this.r = LazyKt.lazy(new GiftMVIDynamicPanel$rootView$2(this));
    }

    public final void b(com.bytedance.android.anya.k r8, MVIState r9) {
        GiftDynamicPanelState r10 = (GiftDynamicPanelState) r9;
        Intrinsics.checkNotNullParameter(r8, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r10, "state");
        com.bytedance.android.anya.r0<GiftDynamicPanelState, Map<String, Object>> r11 = r10.getShowParams();
        Object r0 = r8.c.a(r11);
        if (r0 == null) goto L8;
        r8.b.a.invoke(r11);
        final Map r1 = (Map) r0;
        if ((!r1.isEmpty()) == false) goto L9;
        UtilityKotlinExtentionsKt.s(0, com.bytedance.android.livesdk.gift.platform.core.h.k().f(), com.bytedance.android.livesdk.gift.platform.core.h.k().d(), new GiftMVIDynamicPanel$handleDiff$$inlined$select$lambda$1(r1, this), 1);
        return;
    L9:
        return;
    }
}
