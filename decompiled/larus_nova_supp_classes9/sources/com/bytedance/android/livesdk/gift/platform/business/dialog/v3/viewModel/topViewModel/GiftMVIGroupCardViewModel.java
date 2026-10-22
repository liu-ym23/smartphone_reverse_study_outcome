package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.dsl.h;
import com.bytedance.android.anya.dsl.i;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.r0;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.model.h0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopGroupContainerViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowGroupData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.l;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIGroupCardViewModel extends com.bytedance.android.anya.f<GiftTopViewState, GiftTopGroupContainerViewState, GiftAction> implements l<GiftTopGroupContainerViewState, GiftAction> {
    public final Set<BaseMVIDataStore<?>> u;
    public final GiftDialogStateDataStore v;
    public final GiftExtraRepo w;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Set<BaseMVIDataStore<?>> I() {
        return this.u;
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new GiftTopGroupContainerViewState();
    }

    public final void d(h<GiftTopViewState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIGroupCardViewModel$bindToParent$1 r0 = GiftMVIGroupCardViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new i(this, r0, GiftAction.class));
    }

    public final void J0(com.bytedance.android.anya.internal.e r4, MVIState r5) {
        final GiftTopGroupContainerViewState r6 = (GiftTopGroupContainerViewState) r5;
        Intrinsics.checkNotNullParameter(r4, "$this$reduce");
        Intrinsics.checkNotNullParameter(r6, "state");
        r4.e(this.w.R(), new GiftMVIGroupCardViewModel$reduce$1(this, r6));
        r4.d(this.v.o(), this.v.y(), new GiftMVIGroupCardViewModel$reduce$2(this, r6));
    }

    public GiftMVIGroupCardViewModel(LocateGiftInfo r2, u1 r3, GiftDialogStateDataStore r4, GiftExtraRepo r5) {
        Intrinsics.checkNotNullParameter(r2, "locateGiftInfo");
        Intrinsics.checkNotNullParameter(r3, "logService");
        Intrinsics.checkNotNullParameter(r4, "giftDialogStateDataStore");
        Intrinsics.checkNotNullParameter(r5, "giftExtraRepo");
        this.v = r4;
        this.w = r5;
        this.u = SetsKt.setOf(new BaseMVIDataStore[]{r4, r5});
    }

    public static final void e1(GiftMVIGroupCardViewModel r7, l0 r8, GiftTopGroupContainerViewState r9, h1 r10) {
        r7.getClass();
        if (r10 == null) goto L17;
        List<h0> r11 = r10.getGiftGroupList();
        List<h0> r0 = r11;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L14;
        r0<GiftTopGroupContainerViewState, ShowGroupData> r13 = r9.getShowData();
        ShowGroupData r2 = new ShowGroupData(true, r11, r10.getId());
        r8.getClass();
        l0.h(r13, r2);
        return;
    L14:
        r0<GiftTopGroupContainerViewState, ShowGroupData> r14 = r9.getShowData();
        ShowGroupData r15 = new ShowGroupData(false, null, 0, 6, null);
        r8.getClass();
        l0.h(r14, r15);
        return;
    L8:
        if (r0.isEmpty() == true) goto L11;
        r1 = false;
        goto L12
    }
}
