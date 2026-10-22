package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.dsl.h;
import com.bytedance.android.anya.dsl.i;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.r0;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.p;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopCarouselViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowCarouselData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.l;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVICarouselViewModel extends com.bytedance.android.anya.f<GiftTopViewState, GiftTopCarouselViewState, GiftAction> implements l<GiftTopCarouselViewState, GiftAction> {
    public final Set<BaseMVIDataStore<?>> u;
    public final GiftDialogStateDataStore v;
    public final GiftExtraRepo w;

    public final void onStop() {
    }

    public final void onStart() {
        if (v.e() == false) goto L6;
        ay1.b.h();
        ay1.b.b();
        ay1.b.g();
        ay1.b.f();
        ay1.b.c();
        ay1.b.d();
        return;
    }

    public final Set<BaseMVIDataStore<?>> I() {
        return this.u;
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new GiftTopCarouselViewState();
    }

    public final void d(h<GiftTopViewState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVICarouselViewModel$bindToParent$1 r0 = GiftMVICarouselViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new i(this, r0, GiftAction.class));
    }

    public final void J0(com.bytedance.android.anya.internal.e r4, MVIState r5) {
        final GiftTopCarouselViewState r6 = (GiftTopCarouselViewState) r5;
        Intrinsics.checkNotNullParameter(r4, "$this$reduce");
        Intrinsics.checkNotNullParameter(r6, "state");
        r4.e(this.w.R(), new GiftMVICarouselViewModel$reduce$1(this, r6));
        r4.d(this.v.o(), this.v.y(), new GiftMVICarouselViewModel$reduce$2(this, r6));
    }

    public GiftMVICarouselViewModel(LocateGiftInfo r2, u1 r3, GiftDialogStateDataStore r4, GiftExtraRepo r5) {
        Intrinsics.checkNotNullParameter(r2, "locateGiftInfo");
        Intrinsics.checkNotNullParameter(r3, "logService");
        Intrinsics.checkNotNullParameter(r4, "giftDialogStateDataStore");
        Intrinsics.checkNotNullParameter(r5, "giftExtraRepo");
        this.v = r4;
        this.w = r5;
        this.u = SetsKt.setOf(new BaseMVIDataStore[]{r4, r5});
    }

    public static final void e1(GiftMVICarouselViewModel r3, l0 r4, GiftTopCarouselViewState r5, h1 r6) {
        if (r6 != null) goto L4;
        r3.getClass();
        return;
    L4:
        g0 r7 = r3.w.q(r6.getId());
        if ((!r6.getGiftGroupList().isEmpty()) == false) goto L16;
        if (r7 == null) goto L11;
        List<l1> r8 = r7.getGiftBuffInfos();
        if (r8 == null) goto L11;
        if (r8.isEmpty() == true) goto L11;
    L15:
        boolean r9 = true;
    L17:
        if (r9 == false) goto L19;
        r0<GiftTopCarouselViewState, ShowCarouselData> r10 = r5.getShowData();
        ShowCarouselData r11 = new ShowCarouselData(true, r7);
        r4.getClass();
        l0.h(r10, r11);
        return;
    L19:
        r0<GiftTopCarouselViewState, ShowCarouselData> r13 = r5.getShowData();
        ShowCarouselData r14 = new ShowCarouselData(false, null, 2, null);
        r4.getClass();
        l0.h(r13, r14);
        return;
    L11:
        if (r7 == null) goto L13;
        p r15 = r7.getDiyGiftToolbarInfo();
    L14:
        if (r15 == null) goto L16;
    L13:
        r15 = null;
    L16:
        r9 = false;
        goto L17
    }
}
