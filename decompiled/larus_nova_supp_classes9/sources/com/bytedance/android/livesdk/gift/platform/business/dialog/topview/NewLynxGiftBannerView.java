package com.bytedance.android.livesdk.gift.platform.business.dialog.topview;

import android.content.Context;
import android.view.View;
import com.bytedance.android.annie.param.GsonMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.BaseHybridComponentContainer;
import com.bytedance.android.livesdk.gift.model.e0;
import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.p1;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.model.y1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.v;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.core.utils.s;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.monitor.EventModule;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import cy0.j;
import i12.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import mz0.n;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class NewLynxGiftBannerView extends a {
    public long g;
    public zy0.b h;

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a, com.bytedance.android.livesdk.gift.platform.business.dialog.topview.d
    public final void c() {
        v02.b.a(0, false, new NewLynxGiftBannerView$release$1(this), 7);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a
    public final void d() {
        int r0 = com.bytedance.android.livesdk.gift.util.g.a;
        h1 r1 = this.c;
        if (r1 == null) goto L5;
        String r2 = r1.getBannerScheme();
    L6:
        h1 r3 = this.c;
        if (r3 == null) goto L9;
        Long r4 = Long.valueOf(r3.getId());
    L10:
        Map r5 = MapsKt.mapOf(new Pair[]{TuplesKt.to("uri", String.valueOf(r2)), TuplesKt.to("gift_id", String.valueOf(r4))});
        JSONObject r6 = new JSONObject();
        if (r5 != null) goto L13;
    L26:
        Intrinsics.checkNotNullParameter("ttlive_lynx_gift_banner_click", "eventName");
        Intrinsics.checkNotNullParameter(r6, "extras");
        JSONObject r7 = new JSONObject();
        JSONObject r8 = new JSONObject();
        JSONObject r9 = new JSONObject();
        Intrinsics.checkNotNullParameter(r9, "extra");
        Intrinsics.checkNotNullParameter(r8, "metric");
        EventModule r10 = EventModule.GIFT;
        Intrinsics.checkNotNullParameter(r10, "eventModule");
        String r11 = r10.getValue();
        r8.put("status", String.valueOf(0));
        Intrinsics.checkNotNullParameter(r9, "map");
        Iterator<String> r13 = r6.keys();
    L28:
        if (r13.hasNext() == false) goto L30;
        String r14 = r13.next();
        Object r15 = r6.get(r14);
        Intrinsics.checkNotNullParameter(r14, "key");
        Intrinsics.checkNotNullParameter(r15, "value");
        r9.put(r14, r15);
        goto L28
    L30:
        cy0.e.a.getClass();
        j r16 = cy0.e.a.a;
        m.e.getClass();
        Object r17 = m.b(r16).b(n97.a.class);
        Intrinsics.checkNotNull(r17);
        ((com.bytedance.live.kmp.core.c) r17).g("ttlive_lynx_gift_banner_click", r11, "bussiness_api_call", r7, r8, r9);
        jy0.b.a("ttlive_gift_lynx_banner", "ttlive_lynx_gift_banner_click " + r5);
        n r18 = new n();
        Map r19 = r18.a;
        Intrinsics.checkNotNullParameter(r19, "map");
        Intrinsics.checkNotNullParameter(r5, "map");
        r19.putAll(r5);
        mz0.m r20 = new mz0.m();
        r20.b(LogCommon.ROOM);
        r20.b(LogCommon.PAGE_SOURCE_LOG);
        ((ArrayList) r18.b).addAll(r20.a);
        Object r21 = m.b(r16).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r21);
        ((f80.a) r21).w3("livesdk_lynx_gift_banner_click", r18.a, r18.b);
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.h(0, 7));
        return;
    L13:
        if (r5.isEmpty() == true) goto L26;
        Iterator r23 = r5.entrySet().iterator();
    L17:
        if (r23.hasNext() == false) goto L26;
        Map.Entry r24 = (Map.Entry) r23.next();
        String r25 = (String) r24.getKey();
        String r26 = (String) r24.getValue();
        Intrinsics.checkNotNullParameter(r6, "$this$safePut");
        Intrinsics.checkNotNullParameter(r25, "key");
        Intrinsics.checkNotNullParameter(r26, "value");
        r6.put(r25, r26);     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        String r27 = e.getMessage();
        if (r27 != null) goto L25;
        r27 = BuildConfig.FLAVOR;
    L25:
        jy0.b.c("BindBoxTracing", r27, null, 4);
        goto L17
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a
    public final void e(long r5) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L25
        i12.e r1 = o.b();     // Catch: Throwable -> L25
        Unit r2 = null;
        if (r1 == null) goto L5;
        Object r3 = m.e.d(r1, GiftExtraRepo.class);     // Catch: Throwable -> L25
    L6:
        GiftExtraRepo r4 = (GiftExtraRepo) r3;     // Catch: Throwable -> L25
        if (r4 == null) goto L10;
        g0 r6 = r4.q(r5);     // Catch: Throwable -> L25
    L30:
        Object r7 = Result.constructor-impl(GsonHelper.get().toJson(r6));     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r7) == false) goto L18;
        r7 = "{}";
    L18:
        String r8 = (String) r7;     // Catch: Throwable -> L25
        zy0.b r9 = this.h;     // Catch: Throwable -> L25
        if (r9 == null) goto L23;
        xy0.a r10 = r9.g();     // Catch: Throwable -> L25
        if (r10 == null) goto L23;
        r10.sendJsEvent("H5_updateBannerView", r8);     // Catch: Throwable -> L25
        r2 = Unit.INSTANCE;     // Catch: Throwable -> L25
    L23:
        Result.constructor-impl(r2);     // Catch: Throwable -> L25
        return;
    L13:
        th = move-exception;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L25
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L25
        goto L16
    L10:
        r6 = null;
        goto L30
    L5:
        r3 = null;
    L25:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a
    public final void f(p2 r6) {
        Intrinsics.checkNotNullParameter(r6, "result");
        List<y1> r7 = r6.getGifts();
        g0 r0 = null;
        if (r7 == null) goto L9;
        Sequence r8 = CollectionsKt.asSequence(r7);
        if (r8 == null) goto L9;
        Sequence r9 = SequencesKt.mapNotNull(r8, NewLynxGiftBannerView$onGiftSendSucceed$gift$1.INSTANCE);
        if (r9 == null) goto L9;
        y1 r10 = (y1) SequencesKt.firstOrNull(r9);
    L10:
        if (r10 == null) goto L20;
        Pair[] r2 = new Pair[3];
        r2[0] = TuplesKt.to("gift_banner", r10.getGiftBanner());
        r2[1] = TuplesKt.to("gift_id", Long.valueOf(r10.getGiftId()));
        p1 r11 = r10.getGiftExtra();
        if (r11 == null) goto L14;
        r0 = r11.getDecoded();
    L14:
        r2[2] = TuplesKt.to("gift_extra", r0);
        Map r13 = MapsKt.mutableMapOf(r2);
        zy0.b r1 = this.h;
        if (r1 == null) goto L21;
        xy0.a r3 = r1.g();
        if (r3 == null) goto L22;
        r3.sendJsEvent("H5_giftBannerStatusChange", GsonProtectorUtils.toJson(GsonHelper.get(), r13).toString());
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L9:
        r10 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.topview.a
    public final void g(e0 r13) {
        if (v.e() == false) goto L5;
        return;
    L5:
        h1 r14 = this.c;
        if (r14 == null) goto L10;
        long r0 = r14.getId();
        long r2 = this.g;
        if (r0 != r2) goto L10;
        e(r2);
        return;
    L10:
        h1 r15 = this.c;
        if (r15 == null) goto L18;
        JsonElement r16 = GsonProtectorUtils.toJsonTree(GsonHelper.getDefault(), k.n(IGiftService.class).findGiftExtraInfo(r15.getId()));
        if ((r16 instanceof JsonObject) == true) goto L15;
        r16 = null;
    L15:
        JsonObject r17 = (JsonObject) r16;
        if (r17 == null) goto L18;
        GsonMap r18 = UtilsKt.i(r17);
    L19:
        v02.b.a(0, false, new NewLynxGiftBannerView$release$1(this), 7);
        h1 r1 = this.c;
        if (r1 == null) goto L123;
        String r3 = r1.getBannerScheme();
        if (r3 == null) goto L124;
        com.bytedance.android.live.revenue.core.a r4 = com.bytedance.android.live.revenue.core.util.k.a();
        if (r4 == null) goto L28;
        yz0.k r5 = com.bytedance.android.live.revenue.core.util.f.c(r4, yz0.k.class);
        if (r5 == null) goto L28;
        IRoom r6 = r5.getRoom();
    L29:
        IBaseUser r7 = (IBaseUser) this.f.get("data_user_in_room", null);
        Pair[] r8 = new Pair[11];
        String r9 = BuildConfig.FLAVOR;
        if (r6 == null) goto L33;
        String r10 = String.valueOf(r6.getId());
        if (r10 == null) goto L33;
    L34:
        r8[0] = TuplesKt.to("room_id", r10);
        if (r7 == null) goto L38;
        String r11 = r7.getIdString();
        if (r11 == null) goto L38;
    L39:
        boolean r19 = true;
        r8[1] = TuplesKt.to("user_id", r11);
        if (r7 == null) goto L44;
        Intrinsics.checkNotNullParameter(r7, "$this$secUidExt");
        String r20 = r7.getCastSecUid();
        if (r20 == null) goto L44;
    L45:
        r8[2] = TuplesKt.to("sec_user_id", r20);
        if (r6 == null) goto L49;
        String r21 = r6.getAnchorId();
        if (r21 == null) goto L49;
    L50:
        r8[3] = TuplesKt.to("anchor_id", r21);
        if (r6 == null) goto L57;
        IBaseUser r23 = r6.getOwner();
        if (r23 == null) goto L57;
        Intrinsics.checkNotNullParameter(r23, "$this$secUidExt");
        String r24 = r23.getCastSecUid();
        if (r24 == null) goto L57;
    L58:
        r8[4] = TuplesKt.to("sec_anchor_id", r24);
        h1 r25 = this.c;
        if (r25 == null) goto L62;
        String r26 = String.valueOf(r25.getId());
        if (r26 == null) goto L62;
    L63:
        r8[5] = TuplesKt.to("gift_id", r26);
        h1 r27 = this.c;
        if (r27 == null) goto L67;
        String r28 = String.valueOf(r27.getReqExtraType());
        if (r28 == null) goto L67;
    L68:
        r8[6] = TuplesKt.to("req_extra_type", r28);
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r29 = s.c();
        if (r29 == null) goto L74;
        IBaseUser r30 = r29.a;
        if (r30 == null) goto L74;
        String r31 = r30.getIdString();
        if (r31 == null) goto L74;
    L75:
        r8[7] = TuplesKt.to("to_user_id", r31);
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r33 = s.c();
        if (r33 == null) goto L79;
        IBaseUser r34 = r33.a;
        if (r34 == null) goto L79;
    L87:
        if (r34 == null) goto L91;
        py.o r35 = r34.getOwnRoom();
        if (r35 == null) goto L91;
        List r36 = r35.getRoomIdStrList();
    L92:
        if (r36 == null) goto L109;
        py.o r37 = r34.getOwnRoom();
        if (r37 == null) goto L113;
        List r38 = r37.getRoomIdStrList();
        if (r38 == null) goto L113;
        if (r38.size() > 0) goto L101;
        r19 = false;
    L101:
        if (r19 == true) goto L104;
        r38 = null;
    L104:
        if (r38 == null) goto L113;
        String r39 = (String) ListProtector.get(r38, 0);
        if (r39 == null) goto L113;
        r9 = r39;
    L113:
        r8[8] = TuplesKt.to("to_room_id", r9);
        r8[9] = TuplesKt.to("enable_rev_container", String.valueOf(((Number) f.b.getValue(null, f.a[0])).intValue()));
        r8[10] = TuplesKt.to("source", "gift_bubble_banner");
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r40 = com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class).J8(getContext(), x6.a.d(d7.a.a(r3, MapsKt.mapOf(r8))), new NewLynxGiftBannerView$updateBanner$$inlined$let$lambda$1(this, r18));
        this.h = r40;
        if (r40 == null) goto L125;
        h1 r41 = this.c;
        if (r41 == null) goto L118;
        this.g = r41.getId();
    L118:
        this.a.addView((View) ((BaseHybridComponentContainer) r40).d);
        com.bytedance.android.live.revenue.platform.hybrid.impl.component.b r43 = r40.g();
        if (r43 == null) goto L126;
        r43.load(null, r18);
        return;
    L126:
        return;
    L125:
        return;
    L109:
        if (r34 == null) goto L111;
        Long r44 = Long.valueOf(com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(r34));
    L112:
        r9 = String.valueOf(r44);
        goto L113
    L111:
        r44 = null;
    L91:
        r36 = null;
    L79:
        com.bytedance.android.live.revenue.core.a r45 = com.bytedance.android.live.revenue.core.util.k.a();
        if (r45 == null) goto L86;
        yz0.k r46 = com.bytedance.android.live.revenue.core.util.f.c(r45, yz0.k.class);
        if (r46 == null) goto L86;
        IRoom r47 = r46.getRoom();
        if (r47 == null) goto L86;
        r34 = r47.getOwner();
    L86:
        r34 = null;
    L74:
        r31 = "0";
    L67:
        r28 = BuildConfig.FLAVOR;
    L62:
        r26 = BuildConfig.FLAVOR;
    L57:
        r24 = BuildConfig.FLAVOR;
    L49:
        r21 = BuildConfig.FLAVOR;
    L44:
        r20 = BuildConfig.FLAVOR;
    L38:
        r11 = BuildConfig.FLAVOR;
    L33:
        r10 = BuildConfig.FLAVOR;
    L28:
        r6 = null;
        goto L29
    L124:
        return;
    L123:
        return;
    L18:
        r18 = null;
        goto L19
    }

    public NewLynxGiftBannerView(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(r2, r3, 2131566137);
    }
}
