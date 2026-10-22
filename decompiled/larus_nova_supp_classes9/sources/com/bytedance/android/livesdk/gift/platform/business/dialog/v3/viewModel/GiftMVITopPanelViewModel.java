package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.t;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.w;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopPanelViewState;
import com.bytedance.android.scope.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVITopPanelViewModel extends com.bytedance.android.anya.f<GiftPanelState, GiftTopPanelViewState, GiftAction> implements o {
    public final Set<BaseMVIDataStore<?>> u;
    public final w v;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Set<BaseMVIDataStore<?>> I() {
        return this.u;
    }

    public GiftMVITopPanelViewModel(w r2) {
        Intrinsics.checkNotNullParameter(r2, "giftTopPanelDataStore");
        this.v = r2;
        this.u = SetsKt.setOf(r2);
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new GiftTopPanelViewState();
    }

    public final void d(com.bytedance.android.anya.dsl.h<GiftPanelState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVITopPanelViewModel$bindToParent$1 r0 = GiftMVITopPanelViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, GiftAction.class));
    }

    public final void J0(com.bytedance.android.anya.internal.e r5, MVIState r6) {
        final GiftTopPanelViewState r7 = (GiftTopPanelViewState) r6;
        Intrinsics.checkNotNullParameter(r5, "$this$reduce");
        Intrinsics.checkNotNullParameter(r7, "state");
        if (v.e() == false) goto L6;
        w r0 = this.v;
        r5.e((t) r0.e.getValue(r0, w.i[0]), new GiftMVITopPanelViewModel$reduce$1(r7));
        return;
    }
}
