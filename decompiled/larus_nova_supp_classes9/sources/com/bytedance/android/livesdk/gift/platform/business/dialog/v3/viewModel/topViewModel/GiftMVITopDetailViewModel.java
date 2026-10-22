package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.dsl.h;
import com.bytedance.android.anya.dsl.i;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.r0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopDetailState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.LynxTouchViewVisibleChange;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVITopDetailViewModel extends com.bytedance.android.anya.f<GiftTopViewState, GiftTopDetailState, GiftAction> implements l<GiftTopDetailState, GiftAction> {
    public final void onStart() {
    }

    public final void onStop() {
    }

    public GiftMVITopDetailViewModel() {
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new GiftTopDetailState();
    }

    public final void d(h<GiftTopViewState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVITopDetailViewModel$bindToParent$1 r0 = GiftMVITopDetailViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new i(this, r0, GiftAction.class));
    }

    public final void y0(l0 r2, MVIState r3, p r4) {
        GiftTopDetailState r5 = (GiftTopDetailState) r3;
        GiftAction r6 = (GiftAction) r4;
        Intrinsics.checkNotNullParameter(r2, "$this$reduce");
        Intrinsics.checkNotNullParameter(r5, "state");
        Intrinsics.checkNotNullParameter(r6, "action");
        if ((r6 instanceof LynxTouchViewVisibleChange) == false) goto L6;
        r0<GiftTopDetailState, Boolean> r7 = r5.getNeedShowTopDetail();
        Boolean r8 = Boolean.valueOf(((LynxTouchViewVisibleChange) r6).getTopDetailVisible());
        r2.getClass();
        l0.h(r7, r8);
        return;
    }
}
