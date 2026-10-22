package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.dsl.h;
import com.bytedance.android.anya.dsl.i;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.p;
import com.bytedance.android.livesdk.gift.model.z1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftListSortDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.u;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopDIYContainerViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowDIYCardData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.l;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIDIYCardContainerViewModel extends com.bytedance.android.anya.f<GiftTopViewState, GiftTopDIYContainerViewState, GiftAction> implements l<GiftTopDIYContainerViewState, GiftAction> {
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f A;
    public final Set<BaseMVIDataStore<?>> u;
    public final LocateGiftInfo v;
    public final GiftDialogStateDataStore w;
    public final GiftExtraRepo x;
    public final GiftListSortDataStore y;
    public final e1 z;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Set<BaseMVIDataStore<?>> I() {
        return this.u;
    }

    public final MVIState F(l0 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$createState");
        return new GiftTopDIYContainerViewState();
    }

    public final void d(h<GiftTopViewState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIDIYCardContainerViewModel$bindToParent$1 r0 = GiftMVIDIYCardContainerViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new i(this, r0, GiftAction.class));
    }

    public final void J0(com.bytedance.android.anya.internal.e r4, MVIState r5) {
        final GiftTopDIYContainerViewState r6 = (GiftTopDIYContainerViewState) r5;
        Intrinsics.checkNotNullParameter(r4, "$this$reduce");
        Intrinsics.checkNotNullParameter(r6, "state");
        if (nz1.a.h().d() == false) goto L7;
        r4.e(this.x.R(), new GiftMVIDIYCardContainerViewModel$reduce$1(this, r6));
        r4.d(this.w.o(), this.w.y(), new GiftMVIDIYCardContainerViewModel$reduce$2(this, r6));
        return;
    }

    public static final void e1(GiftMVIDIYCardContainerViewModel r18, l0 r19, GiftTopDIYContainerViewState r20, h1 r21) {
        if (r21 != null) goto L5;
        r18.getClass();
        return;
    L5:
        g0 r2 = r18.x.q(r21.getId());
        JsonObject r3 = null;
        if (r2 == null) goto L8;
        p r4 = r2.getDiyGiftToolbarInfo();
    L10:
        if (r2 == null) goto L16;
        IGiftMarketingInfo r6 = r2.getGiftMarketingInfo();
        if (r6 == null) goto L16;
        int r7 = u.a;
        if (u.d(r6) != true) goto L16;
        IGiftMarketingInfo r8 = r2.getGiftMarketingInfo();
    L18:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b.a(r21.getBannerScheme()) == false) goto L26;
        if (r2 == null) goto L21;
        String r9 = r2.getBannerGiftInfo();
    L23:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b.a(r9) == false) goto L26;
        if (r2 == null) goto L26;
        String r5 = r2.getBannerGiftInfo();
    L27:
        LinkedHashMap r10 = new LinkedHashMap();
        if (r8 == null) goto L37;
        List<Long> r11 = r8.getRelatedGiftIds();
        if (r11 == null) goto L37;
        Iterator<T> r13 = r11.iterator();
    L33:
        if (r13.hasNext() == false) goto L37;
        h1 r14 = r18.z.findGiftById(((Number) r13.next()).longValue());
        if (r14 == null) goto L33;
        r10.put(Long.valueOf(r14.getId()), r14);
    L37:
        List<String> r15 = com.bytedance.android.livesdk.gift.platform.core.h.o();
        r18.y.getClass();
        if (CollectionsKt.contains(r15, null) == true) goto L41;
    L46:
        boolean r16 = false;
    L47:
        if (r16 == false) goto L51;
        z1 r17 = r18.y.k();
        if (r17 == null) goto L51;
        IGiftMarketingInfo r23 = r17.getGiftMarketingInfo();
    L52:
        if (r4 == null) goto L81;
        r0<GiftTopDIYContainerViewState, ShowDIYCardData> r24 = r20.getShowCard();
        String r110 = r18.v.getCardName();
        String r111 = r18.v.getJumpSchema();
        int r112 = r18.w.w();
        Object r113 = (ArrayList) ay1.b.b().get(String.valueOf(r21.getId()));
        if (r113 != null) goto L57;
        r113 = CollectionsKt.emptyList();
    L57:
        GiftListSortDataStore r114 = r18.y;
        IGiftMarketingInfo r115 = r8;
        if (r114.n(r21.getId()) == false) goto L60;
        r114.o();
    L60:
        ReceiverType r25 = r18.A.b;
        r18.y.getClass();
        Intrinsics.checkNotNullParameter(r110, "defaultCardName");
        Intrinsics.checkNotNullParameter(r111, "defaultJumpSchema");
        Intrinsics.checkNotNullParameter(r21, "gift");
        Intrinsics.checkNotNullParameter(r4, "diyGiftToolbarInfo");
        Intrinsics.checkNotNullParameter(r113, "cacheCards");
        Intrinsics.checkNotNullParameter(r25, "receiverType");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("default_card_name", r110.toString());
        r0.put("cache_cards", GsonProtectorUtils.toJson(GsonHelper.get(), r113).toString());
        r0.put("default_jump_schema", r111);
        r0.put("default_location_gift", GsonProtectorUtils.toJson(GsonHelper.get(), r21).toString());
        r0.put("diy_card_info", GsonProtectorUtils.toJson(GsonHelper.get(), r4).toString());
        r0.put("page_type", String.valueOf(r112));
        r0.put("related_gift_map", GsonProtectorUtils.toJson(GsonHelper.get(), r10));
        if (r5 == null) goto L63;
        r0.put("banner_info", r5);
    L63:
        r0.put("panel_new_architecture", Integer.valueOf(v.e() ? 1 : 0));
        if (r115 == null) goto L71;
        JsonElement r1 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r115);
        if ((r1 instanceof JsonObject) == true) goto L68;
        r1 = null;
    L68:
        JsonObject r26 = (JsonObject) r1;
        if (r26 == null) goto L71;
        r0.put("gift_marketing_info", UtilsKt.i(r26));
    L71:
        r0.put("receiver_type", Integer.valueOf(r25.getValue()));
        if (r23 == null) goto L80;
        JsonObject r27 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r23);
        if ((r27 instanceof JsonObject) == false) goto L77;
        r3 = r27;
    L77:
        JsonObject r28 = r3;
        if (r28 == null) goto L80;
        r0.put("scene_marketing_info", UtilsKt.i(r28));
    L80:
        ShowDIYCardData r116 = new ShowDIYCardData(true, r0);
        r19.getClass();
        l0.h(r24, r116);
        return;
    L81:
        r0<GiftTopDIYContainerViewState, ShowDIYCardData> r29 = r20.getShowCard();
        ShowDIYCardData r30 = new ShowDIYCardData(false, null, 3, null);
        r19.getClass();
        l0.h(r29, r30);
        return;
    L51:
        r23 = null;
        goto L52
    L41:
        if (r18.y.n(r21.getId()) == false) goto L46;
        if (r18.y.o() == false) goto L46;
        r16 = true;
        goto L47
    L21:
        r9 = null;
    L26:
        r5 = null;
    L16:
        r8 = null;
        goto L18
    L8:
        r4 = null;
        goto L10
    }

    public GiftMVIDIYCardContainerViewModel(LocateGiftInfo r2, u1 r3, GiftDialogStateDataStore r4, GiftExtraRepo r5, GiftListSortDataStore r6, e1 r7, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r8, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r9) {
        Intrinsics.checkNotNullParameter(r2, "locateGiftInfo");
        Intrinsics.checkNotNullParameter(r3, "logService");
        Intrinsics.checkNotNullParameter(r4, "giftDialogStateDataStore");
        Intrinsics.checkNotNullParameter(r5, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r6, "listSortDataStore");
        Intrinsics.checkNotNullParameter(r7, "listService");
        Intrinsics.checkNotNullParameter(r8, "allMicService");
        Intrinsics.checkNotNullParameter(r9, "receiverService");
        this.v = r2;
        this.w = r4;
        this.x = r5;
        this.y = r6;
        this.z = r7;
        this.A = r9;
        this.u = SetsKt.setOf(new BaseMVIDataStore[]{r4, r5});
    }
}
