package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.anya.BaseMVIDataStore;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.dsl.h;
import com.bytedance.android.anya.dsl.i;
import com.bytedance.android.anya.l0;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.z1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftDialogStateDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.GiftListSortDataStore;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.u;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopBannerContainerViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftTopViewState;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ShowBannerData;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.l;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.u1;
import com.bytedance.android.livesdk.gift.platform.core.utils.s;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import py.o;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftMVIBannerViewModel extends com.bytedance.android.anya.f<GiftTopViewState, GiftTopBannerContainerViewState, GiftAction> implements l<GiftTopBannerContainerViewState, GiftAction> {
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a A;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f B;
    public final Set<BaseMVIDataStore<?>> u;
    public final GiftDialogStateDataStore v;
    public final GiftExtraRepo w;
    public final k x;
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
        return new GiftTopBannerContainerViewState();
    }

    public final void d(h<GiftTopViewState, GiftAction> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        GiftMVIBannerViewModel$bindToParent$1 r0 = GiftMVIBannerViewModel$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new i(this, r0, GiftAction.class));
    }

    public final void J0(com.bytedance.android.anya.internal.e r4, MVIState r5) {
        final GiftTopBannerContainerViewState r6 = (GiftTopBannerContainerViewState) r5;
        Intrinsics.checkNotNullParameter(r4, "$this$reduce");
        Intrinsics.checkNotNullParameter(r6, "state");
        r4.e(this.w.R(), new GiftMVIBannerViewModel$reduce$1(this, r6));
        r4.d(this.v.o(), this.v.y(), new GiftMVIBannerViewModel$reduce$2(this, r6));
    }

    public static final void e1(GiftMVIBannerViewModel r16, l0 r17, GiftTopBannerContainerViewState r18, h1 r19) {
        r16.getClass();
        if (v.e() == false) goto L140;
        if (r19 == null) goto L141;
        g0 r2 = r16.w.q(r19.getId());
        g0 r3 = r16.w.q(r19.getId());
        if (r3 == null) goto L10;
        String r4 = r3.getBannerGiftInfo();
    L11:
        LinkedHashMap r5 = new LinkedHashMap();
        if (r2 == null) goto L20;
        IGiftMarketingInfo r7 = r2.getGiftMarketingInfo();
        if (r7 == null) goto L20;
        int r8 = u.a;
        if (u.d(r7) != true) goto L20;
        if (r16.A.j() == true) goto L20;
        IGiftMarketingInfo r6 = r2.getGiftMarketingInfo();
    L21:
        if (r6 == null) goto L30;
        List<Long> r9 = r6.getRelatedGiftIds();
        if (r9 == null) goto L30;
        Iterator<T> r10 = r9.iterator();
    L26:
        if (r10.hasNext() == false) goto L30;
        h1 r11 = r16.z.findGiftById(((Number) r10.next()).longValue());
        if (r11 == null) goto L26;
        r5.put(Long.valueOf(r11.getId()), r11);
    L30:
        List<String> r13 = com.bytedance.android.livesdk.gift.platform.core.h.o();
        r16.y.getClass();
        if (CollectionsKt.contains(r13, null) == true) goto L34;
    L39:
        boolean r14 = false;
    L40:
        if (r14 == false) goto L44;
        z1 r15 = r16.y.k();
        if (r15 == null) goto L44;
        IGiftMarketingInfo r20 = r15.getGiftMarketingInfo();
    L45:
        if (r4 != null) goto L47;
    L50:
        boolean r21 = true;
    L51:
        if (r21 == true) goto L132;
        r0<GiftTopBannerContainerViewState, ShowBannerData> r23 = r18.getShowBanner();
        String r24 = r19.getBannerScheme();
        g0 r110 = r16.w.q(r19.getId());
        IRoom r111 = r16.x.getRoom();
        IBaseUser r112 = r16.x.getUser();
        Pair[] r113 = new Pair[11];
        String r114 = String.valueOf(r111.getId());
        String r115 = BuildConfig.FLAVOR;
        if (r114 != null) goto L55;
        r114 = BuildConfig.FLAVOR;
    L55:
        r113[0] = TuplesKt.to("room_id", r114);
        String r25 = r112.getIdString();
        if (r25 != null) goto L58;
        r25 = BuildConfig.FLAVOR;
    L58:
        r113[1] = TuplesKt.to("user_id", r25);
        Intrinsics.checkNotNullParameter(r112, "$this$secUidExt");
        String r116 = r112.getCastSecUid();
        if (r116 != null) goto L62;
        r116 = BuildConfig.FLAVOR;
    L62:
        r113[2] = TuplesKt.to("sec_user_id", r116);
        String r117 = r111.getAnchorId();
        if (r117 != null) goto L65;
        r117 = BuildConfig.FLAVOR;
    L65:
        r113[3] = TuplesKt.to("anchor_id", r117);
        IBaseUser r118 = r111.getOwner();
        if (r118 == null) goto L70;
        Intrinsics.checkNotNullParameter(r118, "$this$secUidExt");
        String r26 = r118.getCastSecUid();
        if (r26 == null) goto L70;
    L71:
        r113[4] = TuplesKt.to("sec_anchor_id", r26);
        String r27 = String.valueOf(r19.getId());
        if (r27 != null) goto L74;
        r27 = BuildConfig.FLAVOR;
    L74:
        r113[5] = TuplesKt.to("gift_id", r27);
        String r28 = String.valueOf(r19.getReqExtraType());
        if (r28 == null) goto L78;
        r115 = r28;
    L78:
        r113[6] = TuplesKt.to("req_extra_type", r115);
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r29 = s.c();
        String r119 = "0";
        if (r29 == null) goto L84;
        IBaseUser r30 = r29.a;
        if (r30 == null) goto L84;
        String r31 = r30.getIdString();
        if (r31 == null) goto L84;
    L85:
        r113[7] = TuplesKt.to("to_user_id", r31);
        o r33 = r16.B.a.getOwnRoom();
        if (r33 == null) goto L99;
        List r34 = r33.getRoomIdStrList();
        if (r34 == null) goto L99;
        if (r34.size() <= 0) goto L92;
        boolean r120 = true;
    L93:
        if (r120 == true) goto L96;
        r34 = null;
    L96:
        if (r34 == null) goto L99;
        String r35 = (String) ListProtector.get(r34, 0);
        if (r35 == null) goto L99;
    L100:
        r113[8] = TuplesKt.to("to_room_id", r35);
        r113[9] = TuplesKt.to("enable_rev_container", String.valueOf(((Number) com.bytedance.android.livesdk.gift.platform.business.dialog.topview.f.b.getValue(null, com.bytedance.android.livesdk.gift.platform.business.dialog.topview.f.a[0])).intValue()));
        r113[10] = TuplesKt.to("source", "gift_bubble_banner");
        Map r36 = MapsKt.mapOf(r113);
        GiftListSortDataStore r37 = r16.y;
        if (r37.n(r19.getId()) == false) goto L103;
        r37.o();
    L103:
        int r38 = r16.v.w();
        ReceiverType r121 = r16.B.b;
        r16.y.getClass();
        LinkedHashMap r0 = new LinkedHashMap();
        if (r110 == null) goto L108;
        String r122 = r110.getBannerGiftInfo();
        if (r122 == null) goto L108;
        r0.put("banner_info", r122);
    L108:
        LinkedHashMap r123 = new LinkedHashMap();
        r123.put("page_type", String.valueOf(r38));
        r123.put("banner_ui_type", "1");
        r123.put("receiver_type", String.valueOf(r121.getValue()));
        if (v.e() == false) goto L111;
        r119 = "1";
    L111:
        r123.put("panel_new_architecture", r119);
        r123.put("default_location_gift", GsonProtectorUtils.toJson(GsonHelper.get(), r19).toString());
        if (r36 == null) goto L114;
        r123.putAll(r36);
    L114:
        String r1 = (String) r123.put("related_gift_map", GsonProtectorUtils.toJson(GsonHelper.get(), r5));
        if (r6 == null) goto L122;
        JsonElement r124 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r6);
        if ((r124 instanceof JsonObject) == true) goto L119;
        r124 = null;
    L119:
        JsonObject r125 = (JsonObject) r124;
        if (r125 == null) goto L122;
        String r39 = (String) r123.put("gift_marketing_info", UtilsKt.i(r125).toString());
    L122:
        if (r20 == null) goto L129;
        JsonElement r126 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), r20);
        if ((r126 instanceof JsonObject) == true) goto L126;
        r126 = null;
    L126:
        JsonObject r127 = (JsonObject) r126;
        if (r127 == null) goto L129;
        String r40 = (String) r123.put("scene_marketing_info", UtilsKt.i(r127).toString());
    L129:
        if (r24 != null) goto L131;
        r24 = (String) com.bytedance.android.livesdk.gift.platform.business.b.Z.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[50]);
    L131:
        String r41 = d7.a.a(r24, r123);
        Intrinsics.checkNotNullParameter(r41, "url");
        ShowBannerData r43 = new ShowBannerData(true, r0, UriProtector.parse("sslocal://webcast_lynxview?hybrid_type=lynx&enable_canvas=1&enable_canvas_optmize=1").buildUpon().appendQueryParameter("url", r41).build());
        r17.getClass();
        l0.h(r23, r43);
        return;
    L92:
        r120 = false;
    L99:
        r35 = String.valueOf(com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r16.B.a));
    L84:
        r31 = "0";
    L70:
        r26 = BuildConfig.FLAVOR;
        goto L71
    L132:
        r0<GiftTopBannerContainerViewState, ShowBannerData> r44 = r18.getShowBanner();
        ShowBannerData r45 = new ShowBannerData(false, null, null, 7, null);
        r17.getClass();
        l0.h(r44, r45);
        return;
    L47:
        if (r4.length() == 0) goto L50;
        r21 = false;
    L44:
        r20 = null;
        goto L45
    L34:
        if (r16.y.n(r19.getId()) == false) goto L39;
        if (r16.y.o() == false) goto L39;
        r14 = true;
    L20:
        r6 = null;
        goto L21
    L10:
        r4 = null;
        goto L11
    L141:
        return;
    }

    public GiftMVIBannerViewModel(LocateGiftInfo r2, u1 r3, GiftDialogStateDataStore r4, GiftExtraRepo r5, k r6, GiftListSortDataStore r7, e1 r8, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.a r9, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r10) {
        Intrinsics.checkNotNullParameter(r2, "locateGiftInfo");
        Intrinsics.checkNotNullParameter(r3, "logService");
        Intrinsics.checkNotNullParameter(r4, "giftDialogStateDataStore");
        Intrinsics.checkNotNullParameter(r5, "giftExtraRepo");
        Intrinsics.checkNotNullParameter(r6, "roomDataService");
        Intrinsics.checkNotNullParameter(r7, "listSortDataStore");
        Intrinsics.checkNotNullParameter(r8, "listService");
        Intrinsics.checkNotNullParameter(r9, "allMicService");
        Intrinsics.checkNotNullParameter(r10, "receiverService");
        this.v = r4;
        this.w = r5;
        this.x = r6;
        this.y = r7;
        this.z = r8;
        this.A = r9;
        this.B = r10;
        this.u = SetsKt.setOf(new BaseMVIDataStore[]{r4, r5});
    }
}
