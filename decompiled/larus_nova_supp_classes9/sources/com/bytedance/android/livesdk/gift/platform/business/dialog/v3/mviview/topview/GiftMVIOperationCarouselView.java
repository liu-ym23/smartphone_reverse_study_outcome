package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.topview;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopCarouselViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowCarouselData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIOperationCarouselView extends BaseGiftMVIViewChildNode<GiftTopViewState, GiftTopCarouselViewState, GiftAction> {
    public final Lazy m;

    @Override // com.bytedance.android.livesdk.gift.framework.base.BaseGiftMVIViewChildNode
    public final int s() {
        return 2131567536;
    }

    public final void i() {
        ((ViewGroup) this.m.getValue()).removeAllViews();
    }

    public final void a(com.bytedance.android.anya.dsl.f<GiftTopViewState> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIOperationCarouselView$bindToParent$1 r0 = GiftMVIOperationCarouselView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public GiftMVIOperationCarouselView(Context r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        super(r2, r3);
        this.m = LazyKt.lazy(new GiftMVIOperationCarouselView$rootView$2(this));
    }

    public final void b(com.bytedance.android.anya.k r2, MVIState r3) {
        GiftTopCarouselViewState r4 = (GiftTopCarouselViewState) r3;
        Intrinsics.checkNotNullParameter(r2, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r4, "state");
        r0<GiftTopCarouselViewState, ShowCarouselData> r5 = r4.getShowData();
        Object r0 = r2.c.a(r5);
        if (r0 == null) goto L6;
        r2.b.a.invoke(r5);
        ShowCarouselData r1 = (ShowCarouselData) r0;
        return;
    }
}
