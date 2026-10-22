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
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.z1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftListSortDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.u;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopBuffContainerViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowBuffCardData;
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
public final class GiftMVIBuffCardContainerViewModel extends com.bytedance.android.anya.f<GiftTopViewState, GiftTopBuffContainerViewState, GiftAction> implements l<GiftTopBuffContainerViewState, GiftAction> {
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a A;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f B;
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
        return new GiftTopBuffContainerViewState();
    }

    public final void d(h<GiftTopViewState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIBuffCardContainerViewModel$bindToParent$1 r0 = GiftMVIBuffCardContainerViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new i(this, r0, GiftAction.class));
    }

    public final void J0(com.bytedance.android.anya.internal.e r4, MVIState r5) {
        final GiftTopBuffContainerViewState r6 = (GiftTopBuffContainerViewState) r5;
        Intrinsics.checkNotNullParameter(r4, "$this$reduce");
        Intrinsics.checkNotNullParameter(r6, "state");
        if (nz1.a.h().c() == false) goto L7;
        r4.e(this.x.R(), new GiftMVIBuffCardContainerViewModel$reduce$1(this, r6));
        r4.d(this.w.o(), this.w.y(), new GiftMVIBuffCardContainerViewModel$reduce$2(this, r6));
        return;
    }

    public static final void e1(GiftMVIBuffCardContainerViewModel r23, l0 r24, GiftTopBuffContainerViewState r25, h1 r26, int r27) {
        if (r26 != null) goto L5;
        r23.getClass();
        return;
    L5:
        g0 r2 = r23.x.q(r26.getId());
        JsonObject r3 = null;
        if (r2 == null) goto L8;
        List<l1> r4 = r2.getGiftBuffInfos();
    L9:
        boolean r5 = true;
        if (r2 == null) goto L18;
        IGiftMarketingInfo r6 = r2.getGiftMarketingInfo();
        if (r6 == null) goto L18;
        int r7 = u.a;
        if (u.d(r6) != true) goto L18;
        if (r23.A.j() == true) goto L18;
        IGiftMarketingInfo r8 = r2.getGiftMarketingInfo();
    L20:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b.a(r26.getBannerScheme()) == false) goto L28;
        if (r2 == null) goto L23;
        String r9 = r2.getBannerGiftInfo();
    L25:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b.a(r9) == false) goto L28;
        if (r2 == null) goto L28;
        String r10 = r2.getBannerGiftInfo();
    L29:
        LinkedHashMap r11 = new LinkedHashMap();
        if (r8 == null) goto L39;
        List<Long> r13 = r8.getRelatedGiftIds();
        if (r13 == null) goto L39;
        Iterator<T> r14 = r13.iterator();
    L35:
        if (r14.hasNext() == false) goto L39;
        h1 r15 = r23.z.findGiftById(((Number) r14.next()).longValue());
        if (r15 == null) goto L35;
        r11.put(Long.valueOf(r15.getId()), r15);
    L39:
        List<String> r16 = com.bytedance.android.livesdk.gift.platform.core.h.o();
        r23.y.getClass();
        if (CollectionsKt.contains(r16, null) == true) goto L43;
    L48:
        boolean r17 = false;
    L49:
        if (r17 == false) goto L53;
        z1 r18 = r23.y.k();
        if (r18 == null) goto L53;
        IGiftMarketingInfo r19 = r18.getGiftMarketingInfo();
    L54:
        List<l1> r110 = r4;
        if (r110 != null) goto L57;
    L60:
        if (r5 == true) goto L84;
        r0<GiftTopBuffContainerViewState, ShowBuffCardData> r20 = r25.getShowCard();
        int r21 = r23.v.getBuffLevel();
        String r111 = r23.v.getJumpSchema();
        GiftListSortDataStore r112 = r23.y;
        if (r112.n(r26.getId()) == false) goto L64;
        r112.o();
    L64:
        ReceiverType r113 = r23.B.b;
        r23.y.getClass();
        Intrinsics.checkNotNullParameter(r111, "defaultJumpSchema");
        Intrinsics.checkNotNullParameter(r26, "gift");
        Intrinsics.checkNotNullParameter(r4, "buffInfo");
        Intrinsics.checkNotNullParameter(r113, "receiverType");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("default_buff_level", String.valueOf(r21));
        r0.put("default_jump_schema", r111);
        r0.put("default_location_gift", GsonProtectorUtils.toJson(GsonHelper.get(), r26).toString());
        r0.put("gift_buff_infos", GsonProtectorUtils.toJson(GsonHelper.get(), r4).toString());
        r0.put("page_type", String.valueOf(r27));
        if (r10 == null) goto L67;
        r0.put("banner_info", r10);
    L67:
        r0.put("panel_new_architecture", Integer.valueOf(v.e() ? 1 : 0));
        if (r8 == null) goto L75;
        JsonElement r1 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r8);
        if ((r1 instanceof JsonObject) == true) goto L72;
        r1 = null;
    L72:
        JsonObject r28 = (JsonObject) r1;
        if (r28 == null) goto L75;
        r0.put("gift_marketing_info", UtilsKt.i(r28));
    L75:
        if (r19 == null) goto L83;
        JsonObject r29 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r19);
        if ((r29 instanceof JsonObject) == false) goto L80;
        r3 = r29;
    L80:
        JsonObject r30 = r3;
        if (r30 == null) goto L83;
        r0.put("scene_marketing_info", UtilsKt.i(r30));
    L83:
        r0.put("related_gift_map", GsonProtectorUtils.toJson(GsonHelper.get(), r11));
        r0.put("receiver_type", Integer.valueOf(r113.getValue()));
        ShowBuffCardData r114 = new ShowBuffCardData(true, r0, 0, null, null, null, 0, null, null, null, 1020, null);
        r24.getClass();
        l0.h(r20, r114);
        return;
    L84:
        r0<GiftTopBuffContainerViewState, ShowBuffCardData> r31 = r25.getShowCard();
        ShowBuffCardData r115 = new ShowBuffCardData(false, null, 0, null, null, null, 0, null, null, null, 1020, null);
        r24.getClass();
        l0.h(r31, r115);
        return;
    L57:
        if (r110.isEmpty() == true) goto L60;
        r5 = false;
    L53:
        r19 = null;
        goto L54
    L43:
        if (r23.y.n(r26.getId()) == false) goto L48;
        if (r23.y.o() == false) goto L48;
        r17 = true;
        goto L49
    L23:
        r9 = null;
    L28:
        r10 = null;
    L18:
        r8 = null;
        goto L20
    L8:
        r4 = null;
        goto L9
    }

    public GiftMVIBuffCardContainerViewModel(LocateGiftInfo r2, u1 r3, GiftDialogStateDataStore r4, GiftExtraRepo r5, GiftListSortDataStore r6, e1 r7, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r8, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r9) {
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
        this.A = r8;
        this.B = r9;
        this.u = SetsKt.setOf(new BaseMVIDataStore[]{r4, r5});
    }
}
