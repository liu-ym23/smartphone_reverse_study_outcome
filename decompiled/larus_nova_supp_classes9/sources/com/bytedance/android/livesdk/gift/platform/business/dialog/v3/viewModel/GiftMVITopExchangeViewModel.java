package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopExchangeAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopExchangeViewState;
import com.bytedance.android.scope.o;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVITopExchangeViewModel extends com.bytedance.android.anya.f<GiftPanelState, GiftTopExchangeViewState, GiftAction> implements o {
    public final void onStart() {
    }

    public final void onStop() {
    }

    public GiftMVITopExchangeViewModel() {
        new CompositeDisposable();
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new GiftTopExchangeViewState();
    }

    public final void d(com.bytedance.android.anya.dsl.h<GiftPanelState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVITopExchangeViewModel$bindToParent$1 r0 = GiftMVITopExchangeViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, GiftAction.class));
    }

    public final void y0(l0 r3, MVIState r4, p r5) {
        GiftTopExchangeViewState r6 = (GiftTopExchangeViewState) r4;
        GiftAction r7 = (GiftAction) r5;
        Intrinsics.checkNotNullParameter(r3, "$this$reduce");
        Intrinsics.checkNotNullParameter(r6, "state");
        Intrinsics.checkNotNullParameter(r7, "action");
        if ((r7 instanceof GiftTopExchangeAction) == false) goto L6;
        r0<GiftTopExchangeViewState, Boolean> r0 = r6.getHideCashExchange();
        GiftTopExchangeAction r8 = (GiftTopExchangeAction) r7;
        Boolean r1 = Boolean.valueOf(r8.getHideCashExchange());
        r3.getClass();
        l0.h(r0, r1);
        l0.h(r6.getHideCombineExchange(), Boolean.valueOf(r8.getHideCombineExchange()));
        l0.h(r6.getGiftPanelType(), Integer.valueOf(r8.getGiftPanelType()));
        return;
    }
}
