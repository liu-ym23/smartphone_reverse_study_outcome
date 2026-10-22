package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import com.bytedance.android.annie.param.GsonMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.dsl.i;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.t;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.gift.configmodel.v1;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.k3;
import com.bytedance.android.livesdk.gift.model.l3;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datalayer.GiftMVISeriesUseCase;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftListSortDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.d0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopSeriesViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RefreshGiftExtra;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.l;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetsUtils;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.GiftListRepository;
import com.bytedance.android.livesdk.gift.platform.core.giftlist.h;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVISeriesViewModel extends com.bytedance.android.anya.f<GiftTopViewState, GiftTopSeriesViewState, GiftAction> implements l<GiftTopSeriesViewState, GiftAction> {
    public final GiftListRepository A;
    public final h B;
    public final GiftListSortDataStore C;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f D;
    public final v1 u;
    public final Set<BaseMVIDataStore<?>> v;
    public final GiftMVISeriesUseCase w;
    public final GiftExtraRepo x;
    public final u1 y;
    public final GiftDialogStateDataStore z;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Set<BaseMVIDataStore<?>> I() {
        return this.v;
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new GiftTopSeriesViewState();
    }

    public final void d(com.bytedance.android.anya.dsl.h<GiftTopViewState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVISeriesViewModel$bindToParent$1 r0 = GiftMVISeriesViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new i(this, r0, GiftAction.class));
    }

    public final void J0(com.bytedance.android.anya.internal.e r7, MVIState r8) {
        final GiftTopSeriesViewState r9 = (GiftTopSeriesViewState) r8;
        Intrinsics.checkNotNullParameter(r7, "$this$reduce");
        Intrinsics.checkNotNullParameter(r9, "state");
        r7.e(this.x.R(), new GiftMVISeriesViewModel$reduce$1(this));
        t<GiftDialogStateDataStore, h1> r0 = this.z.o();
        t<GiftDialogStateDataStore, Integer> r1 = this.z.y();
        GiftMVISeriesUseCase r2 = this.w;
        r7.c(r0, r1, (t) r2.e.getValue(r2, GiftMVISeriesUseCase.h[0]), new GiftMVISeriesViewModel$reduce$2(this, r9));
    }

    public final void y0(l0 r2, MVIState r3, p r4) {
        GiftAction r5 = (GiftAction) r4;
        Intrinsics.checkNotNullParameter(r2, "$this$reduce");
        Intrinsics.checkNotNullParameter((GiftTopSeriesViewState) r3, "state");
        Intrinsics.checkNotNullParameter(r5, "action");
        if ((r5 instanceof RefreshGiftExtra) == false) goto L6;
        this.z.F(((RefreshGiftExtra) r5).getGiftIds());
        return;
    }

    public static final boolean h1(GiftMVISeriesViewModel r3, long r4, Map r6, List r7) {
        r3.getClass();
        if (r4 > 0) goto L5;
    L22:
        return false;
    L5:
        if (r7.isEmpty() == true) goto L22;
        if (r6.isEmpty() == true) goto L22;
        boolean r5 = AssetsUtils.b;
        boolean r8 = AssetsUtils.b(com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.h());
        Iterator r9 = r7.iterator();
    L11:
        if (r9.hasNext() == false) goto L21;
        Long r10 = Long.valueOf(((k3) r9.next()).getGiftId());
        h1 r11 = (h1) ((LinkedHashMap) r6).get(r10);
        if (r11 == null) goto L22;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.i(r11.getPrimaryEffectId()) == true) goto L11;
        if (r3.u.getEnable() == true) goto L11;
        if (r8 == true) goto L11;
    L21:
        return true;
    }

    public static final Map e1(GiftMVISeriesViewModel r7, h1 r8, Map r9, l3 r10, boolean r11, int r13) {
        r7.getClass();
        LinkedHashMap r0 = new LinkedHashMap();
        LinkedHashMap r1 = new LinkedHashMap();
        long r2 = r8.getId();
        g0 r4 = r7.x.q(r2);
        r1.put("select_gift_id", Long.valueOf(r2));
        JsonElement r14 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r9);
        GsonMap r6 = null;
        if ((r14 instanceof JsonObject) == true) goto L5;
        r14 = null;
    L5:
        JsonObject r15 = (JsonObject) r14;
        if (r15 == null) goto L8;
        GsonMap r16 = UtilsKt.i(r15);
    L9:
        r1.put("gift_map", r16);
        JsonElement r17 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r10);
        if ((r17 instanceof JsonObject) == true) goto L12;
        r17 = null;
    L12:
        JsonObject r18 = (JsonObject) r17;
        if (r18 == null) goto L15;
        r6 = UtilsKt.i(r18);
    L15:
        r1.put("series_gift_info", r6);
        r1.put("is_first_render", Boolean.valueOf(r11));
        r1.put("page_type", Integer.valueOf(r13));
        r0.put("panel_new_architecture", Integer.valueOf(v.e() ? 1 : 0));
        r0.put("dynamic_card_type", 1);
        r0.put("dynamic_card_info", r1);
        r0.put("default_location_gift", GsonProtectorUtils.toJson(GsonHelper.get(), r8).toString());
        if (r4 == null) goto L20;
        String r19 = r4.getBannerGiftInfo();
        if (r19 == null) goto L20;
        r0.put("banner_info", r19);
    L20:
        GiftListSortDataStore r20 = r7.C;
        if (r20.n(r2) == false) goto L23;
        r20.o();
    L23:
        return r0;
    L8:
        r16 = null;
        goto L9
    }

    public GiftMVISeriesViewModel(GiftMVISeriesUseCase r2, GiftExtraRepo r3, d0 r4, u1 r5, GiftDialogStateDataStore r6, GiftListRepository r7, h r8, GiftListSortDataStore r9, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r10) {
        Intrinsics.checkNotNullParameter(r2, "seriesUseCase");
        Intrinsics.checkNotNullParameter(r3, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r4, "giftPanelListTempRepo");
        Intrinsics.checkNotNullParameter(r5, "giftPanelLogService");
        Intrinsics.checkNotNullParameter(r6, "giftDialogStateDataStore");
        Intrinsics.checkNotNullParameter(r7, "giftListRepository");
        Intrinsics.checkNotNullParameter(r8, "giftListPanelRepository");
        Intrinsics.checkNotNullParameter(r9, "listSortDataStore");
        Intrinsics.checkNotNullParameter(r10, "receiverService");
        this.w = r2;
        this.x = r3;
        this.y = r5;
        this.z = r6;
        this.A = r7;
        this.B = r8;
        this.C = r9;
        this.D = r10;
        this.u = com.bytedance.android.livesdk.gift.platform.business.i.m();
        this.v = SetsKt.setOf(new BaseMVIDataStore[]{r2, r6, r3});
    }
}
