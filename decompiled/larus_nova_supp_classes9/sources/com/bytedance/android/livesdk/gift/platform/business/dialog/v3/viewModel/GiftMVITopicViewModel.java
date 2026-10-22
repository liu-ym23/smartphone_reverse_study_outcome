package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftTopicDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ChangeReceiver;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftPanelState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopicState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.StartScrollGiftRecycler;
import com.bytedance.android.scope.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVITopicViewModel extends com.bytedance.android.anya.f<GiftPanelState, GiftTopicState, GiftAction> implements o {
    public final Set<BaseMVIDataStore<?>> u;
    public final GiftTopicDataStore v;
    public final GiftDialogStateDataStore w;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Set<BaseMVIDataStore<?>> I() {
        return this.u;
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new GiftTopicState();
    }

    public final void d(com.bytedance.android.anya.dsl.h<GiftPanelState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVITopicViewModel$bindToParent$1 r0 = GiftMVITopicViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.i(this, r0, GiftAction.class));
    }

    public GiftMVITopicViewModel(GiftTopicDataStore r3, GiftDialogStateDataStore r4) {
        Intrinsics.checkNotNullParameter(r3, "dataStore");
        Intrinsics.checkNotNullParameter(r4, "dialogStateDataStore");
        this.v = r3;
        this.w = r4;
        this.u = SetsKt.setOf(new BaseMVIDataStore[]{r3, r4});
    }

    public final void J0(com.bytedance.android.anya.internal.e r3, MVIState r4) {
        final GiftTopicState r5 = (GiftTopicState) r4;
        Intrinsics.checkNotNullParameter(r3, "$this$reduce");
        Intrinsics.checkNotNullParameter(r5, "state");
        if (v.g() == false) goto L6;
        r3.e(this.v.F(), new GiftMVITopicViewModel$reduce$1(this, r5));
        r3.e(this.v.L(), new GiftMVITopicViewModel$reduce$2(this));
        r3.e(this.w.y(), new GiftMVITopicViewModel$reduce$3(this));
        return;
    }

    public final void y0(l0 r3, MVIState r4, p r5) {
        GiftAction r6 = (GiftAction) r5;
        Intrinsics.checkNotNullParameter(r3, "$this$reduce");
        Intrinsics.checkNotNullParameter((GiftTopicState) r4, "state");
        Intrinsics.checkNotNullParameter(r6, "action");
        boolean r7 = true;
        if ((r6 instanceof StartScrollGiftRecycler) == false) goto L11;
        StartScrollGiftRecycler r8 = (StartScrollGiftRecycler) r6;
        if (r8.getY() <= 0) goto L8;
        this.v.q(false);
    L8:
        if (r8.getY() >= 0) goto L25;
        this.v.q(true);
        return;
    L25:
        return;
    L11:
        if ((r6 instanceof ChangeReceiver) == false) goto L27;
        ChangeReceiver r9 = (ChangeReceiver) r6;
        if ((!Intrinsics.areEqual(r9.getPreUser().getIdString(), r9.getUser().getIdString())) == false) goto L28;
        String r10 = r9.getPreUser().getIdString();
        if (r10 != null) goto L17;
    L20:
        if (r7 == false) goto L22;
        return;
    L22:
        if (v.g() == false) goto L30;
        this.v.b0();
        return;
    L30:
        return;
    L17:
        if (r10.length() == 0) goto L20;
        r7 = false;
        goto L20
    L28:
        return;
    }
}
