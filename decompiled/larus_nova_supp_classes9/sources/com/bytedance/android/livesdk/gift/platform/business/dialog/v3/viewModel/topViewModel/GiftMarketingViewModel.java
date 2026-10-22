package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.dsl.h;
import com.bytedance.android.anya.dsl.i;
import com.bytedance.android.anya.l0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datalayer.GiftMVIMarketingUseCase;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftListSortDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopMarketingViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.l;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMarketingViewModel extends com.bytedance.android.anya.f<GiftTopViewState, GiftTopMarketingViewState, GiftAction> implements l<GiftTopMarketingViewState, GiftAction> {
    public final e1 A;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f B;
    public final Set<BaseMVIDataStore<?>> u;
    public final GiftMVIMarketingUseCase v;
    public final GiftDialogStateDataStore w;
    public final GiftExtraRepo x;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.f y;
    public final GiftListSortDataStore z;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Set<BaseMVIDataStore<?>> I() {
        return this.u;
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new GiftTopMarketingViewState();
    }

    public final void d(h<GiftTopViewState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMarketingViewModel$bindToParent$1 r0 = GiftMarketingViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new i(this, r0, GiftAction.class));
    }

    public final void J0(com.bytedance.android.anya.internal.e r5, MVIState r6) {
        final GiftTopMarketingViewState r7 = (GiftTopMarketingViewState) r6;
        Intrinsics.checkNotNullParameter(r5, "$this$reduce");
        Intrinsics.checkNotNullParameter(r7, "state");
        r5.c(this.w.o(), this.v.k(), this.w.y(), new GiftMarketingViewModel$reduce$1(this, r7));
    }

    public GiftMarketingViewModel(GiftMVIMarketingUseCase r2, GiftDialogStateDataStore r3, GiftExtraRepo r4, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.f r5, GiftListSortDataStore r6, e1 r7, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r8) {
        Intrinsics.checkNotNullParameter(r2, "giftMarketingUseCase");
        Intrinsics.checkNotNullParameter(r3, "giftDialogStateDataStore");
        Intrinsics.checkNotNullParameter(r4, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r5, "giftDiyDataStore");
        Intrinsics.checkNotNullParameter(r6, "listSortDataStore");
        Intrinsics.checkNotNullParameter(r7, "listService");
        Intrinsics.checkNotNullParameter(r8, "receiverService");
        this.v = r2;
        this.w = r3;
        this.x = r4;
        this.y = r5;
        this.z = r6;
        this.A = r7;
        this.B = r8;
        this.u = SetsKt.setOf(new BaseMVIDataStore[]{r2, r3});
    }
}
