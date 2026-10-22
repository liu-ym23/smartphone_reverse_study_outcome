package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.dsl.h;
import com.bytedance.android.anya.dsl.i;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.r0;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.p;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopCollectionViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowCollectionData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.l;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVICollectionViewModel extends com.bytedance.android.anya.f<GiftTopViewState, GiftTopCollectionViewState, GiftAction> implements l<GiftTopCollectionViewState, GiftAction> {
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
        return new GiftTopCollectionViewState();
    }

    public final void d(h<GiftTopViewState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVICollectionViewModel$bindToParent$1 r0 = GiftMVICollectionViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new i(this, r0, GiftAction.class));
    }

    public final void J0(com.bytedance.android.anya.internal.e r4, MVIState r5) {
        final GiftTopCollectionViewState r6 = (GiftTopCollectionViewState) r5;
        Intrinsics.checkNotNullParameter(r4, "$this$reduce");
        Intrinsics.checkNotNullParameter(r6, "state");
        r4.e(this.w.R(), new GiftMVICollectionViewModel$reduce$1(this, r6));
        r4.d(this.v.o(), this.v.y(), new GiftMVICollectionViewModel$reduce$2(this, r6));
    }

    public GiftMVICollectionViewModel(LocateGiftInfo r2, u1 r3, GiftDialogStateDataStore r4, GiftExtraRepo r5) {
        Intrinsics.checkNotNullParameter(r2, "locateGiftInfo");
        Intrinsics.checkNotNullParameter(r3, "logService");
        Intrinsics.checkNotNullParameter(r4, "giftDialogStateDataStore");
        Intrinsics.checkNotNullParameter(r5, "giftExtraRepo");
        this.v = r4;
        this.w = r5;
        this.u = SetsKt.setOf(new BaseMVIDataStore[]{r4, r5});
    }

    public static final void e1(GiftMVICollectionViewModel r4, l0 r5, GiftTopCollectionViewState r6, h1 r7) {
        String r0 = null;
        if (r7 == null) goto L5;
        r4.getClass();
        List<h0> r1 = r7.getGiftGroupList();
    L6:
        GiftExtraRepo r8 = r4.w;
        if (r7 == null) goto L9;
        long r2 = r7.getId();
    L10:
        g0 r9 = r8.q(r2);
        if (r9 == null) goto L13;
        List<l1> r3 = r9.getGiftBuffInfos();
    L14:
        if (r9 == null) goto L16;
        p r10 = r9.getDiyGiftToolbarInfo();
    L17:
        if (r9 == null) goto L20;
        r0 = r9.getBannerGiftInfo();
    L20:
        if (r7 == null) goto L47;
        List<l1> r11 = r3;
        if (r11 != null) goto L24;
    L27:
        boolean r13 = true;
    L28:
        if (r13 == false) goto L46;
        if (r10 != null) goto L46;
        if (r0 != null) goto L32;
    L35:
        boolean r14 = true;
    L36:
        if (r14 == false) goto L46;
        List<h0> r15 = r1;
        if (r15 != null) goto L40;
    L43:
        boolean r16 = true;
    L44:
        if (r16 == false) goto L46;
    L40:
        if (r15.isEmpty() == true) goto L43;
        r16 = false;
        goto L44
    L32:
        if (r0.length() == 0) goto L35;
        r14 = false;
    L46:
        r0<GiftTopCollectionViewState, ShowCollectionData> r17 = r6.getShowCollection();
        ShowCollectionData r18 = new ShowCollectionData(false);
        r5.getClass();
        l0.h(r17, r18);
        return;
    L24:
        if (r11.isEmpty() == true) goto L27;
        r13 = false;
    L47:
        r0<GiftTopCollectionViewState, ShowCollectionData> r19 = r6.getShowCollection();
        ShowCollectionData r20 = new ShowCollectionData(true);
        r5.getClass();
        l0.h(r19, r20);
        return;
    L16:
        r10 = null;
        goto L17
    L13:
        r3 = null;
        goto L14
    L9:
        r2 = 0;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
