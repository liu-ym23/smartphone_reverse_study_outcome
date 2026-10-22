package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.dsl.h;
import com.bytedance.android.anya.dsl.i;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.t;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftMVICarnivalDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickActivityBtn;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.DialogResume;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftMVICarnivalViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshGiftExtra;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.l;
import com.bytedance.android.livesdk.message.model.q6;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVICarnivalTopViewModel extends com.bytedance.android.anya.f<GiftTopViewState, GiftMVICarnivalViewState, GiftAction> implements l<GiftMVICarnivalViewState, GiftAction> {
    public final Set<BaseMVIDataStore<?>> u;
    public final GiftMVICarnivalDataStore v;
    public final GiftDialogStateDataStore w;
    public final GiftExtraRepo x;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Set<BaseMVIDataStore<?>> I() {
        return this.u;
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new GiftMVICarnivalViewState();
    }

    public final void d(h<GiftTopViewState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVICarnivalTopViewModel$bindToParent$1 r0 = GiftMVICarnivalTopViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new i(this, r0, GiftAction.class));
    }

    public final void J0(com.bytedance.android.anya.internal.e r5, MVIState r6) {
        final GiftMVICarnivalViewState r7 = (GiftMVICarnivalViewState) r6;
        Intrinsics.checkNotNullParameter(r5, "$this$reduce");
        Intrinsics.checkNotNullParameter(r7, "state");
        r5.e(this.x.R(), new GiftMVICarnivalTopViewModel$reduce$1(this));
        GiftMVICarnivalDataStore r0 = this.v;
        r5.e((t) r0.f.getValue(r0, GiftMVICarnivalDataStore.l[0]), new GiftMVICarnivalTopViewModel$reduce$2(this, r7));
        r5.d(this.w.s(), this.w.y(), new GiftMVICarnivalTopViewModel$reduce$3(this, r7));
        GiftDialogStateDataStore r1 = this.w;
        r5.e((t) r1.g.getValue(r1, GiftDialogStateDataStore.I[2]), new GiftMVICarnivalTopViewModel$reduce$4(this, r7));
    }

    public GiftMVICarnivalTopViewModel(GiftMVICarnivalDataStore r3, GiftDialogStateDataStore r4, GiftExtraRepo r5) {
        Intrinsics.checkNotNullParameter(r3, "giftMVICarnivalDataStore");
        Intrinsics.checkNotNullParameter(r4, "giftDialogStateDataStore");
        Intrinsics.checkNotNullParameter(r5, "giftExtraRepo");
        this.v = r3;
        this.w = r4;
        this.x = r5;
        this.u = SetsKt.setOf(new BaseMVIDataStore[]{r3, r4, r5});
    }

    public static final Map e1(GiftMVICarnivalTopViewModel r3, String r4, String r5) {
        r3.getClass();
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("time_stamp", Long.valueOf(System.currentTimeMillis()));
        if (r4 == null) goto L5;
        r0.put("progress_data", r4);
    L5:
        if (r5 == null) goto L7;
        r0.put("activity_value", r5);
    L7:
        r0.put("panel_new_architecture", Integer.valueOf(v.e() ? 1 : 0));
        Gson r6 = GsonHelper.get();
        q6 r7 = r3.v.k.Y9();
        JsonObject r8 = null;
        if (r7 == null) goto L10;
        IBaseUser r9 = r7.getCurrentAnchor();
    L11:
        JsonObject r10 = GsonProtectorUtils.toJsonTree(r6, r9);
        if ((r10 instanceof JsonObject) == false) goto L15;
        r8 = r10;
    L15:
        r0.put("to_user", r8);
        return r0;
    L10:
        r9 = null;
        goto L11
    }

    public final void y0(l0 r2, MVIState r3, p r4) {
        GiftAction r5 = (GiftAction) r4;
        Intrinsics.checkNotNullParameter(r2, "$this$reduce");
        Intrinsics.checkNotNullParameter((GiftMVICarnivalViewState) r3, "state");
        Intrinsics.checkNotNullParameter(r5, "action");
        if ((r5 instanceof ClickActivityBtn) == false) goto L9;
        if ((!Intrinsics.areEqual(((ClickActivityBtn) r5).getCurrentTabName(), this.v.g)) == true) goto L18;
        this.v.k.w5().onNext(Unit.INSTANCE);
        return;
    L18:
        return;
    L9:
        if ((r5 instanceof RefreshGiftExtra) == false) goto L12;
        this.w.F(((RefreshGiftExtra) r5).getGiftIds());
        return;
    L12:
        if ((r5 instanceof DialogResume) == false) goto L17;
        this.v.n();
        return;
    }
}
