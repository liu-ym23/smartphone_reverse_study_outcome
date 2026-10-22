package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopCollectionViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowCollectionData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVICollectionContainerView extends BaseGiftMVIViewChildNode<GiftTopViewState, GiftTopCollectionViewState, GiftAction> {
    public zy0.b m;
    public final Lazy n;

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return 2131567539;
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
        GiftMVICollectionContainerView$bindToParent$1 r0 = GiftMVICollectionContainerView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public GiftMVICollectionContainerView(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        super(r2, r3);
        this.n = LazyKt.lazy(new GiftMVICollectionContainerView$rootView$2(this));
    }

    public final void b(com.bytedance.android.anya.k r8, MVIState r9) {
        GiftTopCollectionViewState r10 = (GiftTopCollectionViewState) r9;
        Intrinsics.checkNotNullParameter(r8, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r10, "state");
        r0<GiftTopCollectionViewState, ShowCollectionData> r11 = r10.getShowCollection();
        Object r0 = r8.c.a(r11);
        if (r0 == null) goto L6;
        r8.b.a.invoke(r11);
        final ShowCollectionData r1 = (ShowCollectionData) r0;
        GiftPanelBizBoostUtils.E.getClass();
        UtilityKotlinExtentionsKt.s(0, false, ((Boolean) GiftPanelBizBoostUtils.B.getValue()).booleanValue(), new GiftMVICollectionContainerView$handleDiff$$inlined$select$lambda$1(r1, this), 3);
        return;
    }
}
