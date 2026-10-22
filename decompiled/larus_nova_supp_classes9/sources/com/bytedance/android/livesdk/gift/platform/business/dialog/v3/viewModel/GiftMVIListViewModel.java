package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.l0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftListViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.scope.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIListViewModel extends com.bytedance.android.livesdk.gift.framework.base.b<GiftPanelState, GiftListViewState, GiftAction> implements o {
    public final void onStart() {
    }

    public final void onStop() {
    }

    public GiftMVIListViewModel(GiftMVIVerticalListViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "verticalView");
        super(CollectionsKt.listOf(r2));
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new GiftListViewState();
    }

    public final void d(com.bytedance.android.anya.dsl.h<GiftPanelState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIListViewModel$bindToParent$1 r0 = GiftMVIListViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, GiftAction.class));
    }
}
