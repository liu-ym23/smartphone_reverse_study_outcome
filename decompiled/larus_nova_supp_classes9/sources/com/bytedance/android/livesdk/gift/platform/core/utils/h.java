package com.bytedance.android.livesdk.gift.platform.core.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.annie.param.GsonMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.revenue.model.extension.IMainRoom;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.model.GiftMsgBoard;
import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.k0;
import com.bytedance.android.livesdk.gift.model.k3;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.o0;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.model.u3;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.model.w3;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.GiftPanelBizBoostUtils;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.GiftExtraRepo;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GroupLiveReceiverService;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.tray2.GiftTrayMessageManager;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdk.gift.platform.core.model.GiftInsertStatus;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.model.SeriesSendType;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.PropListService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.SendGiftRelationService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.e1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.f1;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.j2;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.k2;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.sort.GiftStickerSortService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.t1;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.log.LogCommonInstance;
import com.bytedance.android.livesdk.revenue.service.broadcast.IRevBroadcastService;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdk.utils.x1;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.IGroupLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h {
    public static String a;
    public static final int[] b = null;

    public h() {
    }

    @JvmStatic
    public static final void l() {
        Map r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("position", "live"), TuplesKt.to("position_page", "live_gift"), TuplesKt.to("resource_scene", "logo")});
        mz0.n r1 = new mz0.n();
        Map r2 = r1.a;
        Intrinsics.checkNotNullParameter(r2, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r2.putAll(r0);
        mz0.m r3 = new mz0.m();
        r3.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r4 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r4, "pageSourceLog");
        ((ArrayList) r3.a).add(r4.a);
        ((ArrayList) r1.b).addAll(r3.a);
        cy0.e.a.getClass();
        cy0.j r5 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r6 = com.bytedance.android.scope.m.b(r5).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r6);
        ((f80.a) r6).w3("noLivePrefixactivity_ad_click", r1.a, r1.b);
    }

    @JvmStatic
    public static final void m() {
        Map r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("position", "live"), TuplesKt.to("position_page", "live_gift"), TuplesKt.to("resource_scene", "logo")});
        mz0.n r1 = new mz0.n();
        Map r2 = r1.a;
        Intrinsics.checkNotNullParameter(r2, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r2.putAll(r0);
        mz0.m r3 = new mz0.m();
        r3.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r4 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r4, "pageSourceLog");
        ((ArrayList) r3.a).add(r4.a);
        ((ArrayList) r1.b).addAll(r3.a);
        cy0.e.a.getClass();
        cy0.j r5 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r6 = com.bytedance.android.scope.m.b(r5).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r6);
        ((f80.a) r6).w3("noLivePrefixactivity_ad_show", r1.a, r1.b);
    }

    static {
        a = "icon";
        b = new int[]{0, 1, 5, 2, 6, 3, 7, 4, 8};
    }

    @JvmStatic
    public static final String e() {
        String r0 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getConnectionType();
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r0;
    }

    public static yz0.k g() {
        return com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
    }

    public static boolean k() {
        GiftPanelBizBoostUtils.E.getClass();
        if (((Boolean) GiftPanelBizBoostUtils.o.getValue()).booleanValue() == false) goto L5;
        return false;
    L5:
        rq2.b r0 = vh6.c.b(rq2.b.class);
        if (r0.isEnable() == false) goto L8;
        r0.r3();
    L8:
        return false;
    }

    public static void y() {
        Intrinsics.checkNotNullParameter("click_icon", "source");
        Intrinsics.checkNotNullParameter("cache", "type");
        Map r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("cache_miss_count", String.valueOf(1)), TuplesKt.to("source", "click_icon"), TuplesKt.to("type", "cache")});
        GiftContext r1 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r1 == null) goto L5;
        r0.put("panel_open_times", String.valueOf(r1.getPanelOpenTimes()));
        r0.put("stay_room_duration", String.valueOf((System.currentTimeMillis() - r1.getEnterRoomTime()) / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)));
    L5:
        mz0.n r2 = new mz0.n();
        Map r3 = r2.a;
        Intrinsics.checkNotNullParameter(r3, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r3.putAll(r0);
        mz0.m r4 = new mz0.m();
        r4.b(LogCommon.ROOM);
        ((ArrayList) r2.b).addAll(r4.a);
        cy0.e.a.getClass();
        cy0.j r5 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r6 = com.bytedance.android.scope.m.b(r5).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r6);
        ((f80.a) r6).w3("livesdk_gift_icon_load_monitor", r2.a, r2.b);
    }

    @JvmStatic
    public static final void X() {
        if (u.p() == false) goto L10;
        com.bytedance.android.live.revenue.core.a r0 = com.bytedance.android.live.revenue.core.util.k.a();
        if (r0 == null) goto L11;
        n01.a r1 = com.bytedance.android.live.revenue.core.util.f.c(r0, n01.a.class);
        if (r1 == null) goto L12;
        r1.E0().sendLog("dou_coin_click", new LinkedHashMap());
        return;
    L12:
        return;
    L11:
        return;
    }

    @JvmStatic
    public static final void Y() {
        if (u.p() == false) goto L10;
        com.bytedance.android.live.revenue.core.a r0 = com.bytedance.android.live.revenue.core.util.k.a();
        if (r0 == null) goto L11;
        n01.a r1 = com.bytedance.android.live.revenue.core.util.f.c(r0, n01.a.class);
        if (r1 == null) goto L12;
        r1.E0().sendLog("send_gift_icon_show", new LinkedHashMap());
        return;
    L12:
        return;
    L11:
        return;
    }

    public static double e0() {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        Long r1 = null;
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.gift.platform.core.i> r2 = r0.getLastEventTimeStamp();
        if (r2 == null) goto L7;
        com.bytedance.android.livesdk.gift.platform.core.i r3 = (com.bytedance.android.livesdk.gift.platform.core.i) r2.getValue();
    L8:
        boolean r4 = false;
        if (r3 == null) goto L18;
        Long r6 = Long.valueOf(r3.b);
        if (r6.longValue() == 0) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == true) goto L17;
        r6 = null;
    L17:
        if (r6 == null) goto L18;
    L23:
        r1 = r6;
    L24:
        if (r1 == null) goto L26;
        long r5 = r1.longValue();
    L27:
        long r13 = System.currentTimeMillis();
        if (r3 == null) goto L35;
        com.bytedance.android.livesdk.gift.platform.core.i r8 = com.bytedance.android.livesdk.gift.platform.core.i.a(r3, r13, 0, 0, 0, 29);
        GiftContext r9 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r9 == null) goto L35;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.gift.platform.core.i> r10 = r9.getLastEventTimeStamp();
        if (r10 == null) goto L35;
        r10.setValue(r8);
    L35:
        return ((r13 - r5) * 1.0d) / ((double) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
    L26:
        r5 = System.currentTimeMillis();
        goto L27
    L13:
        r7 = false;
    L18:
        if (r3 == null) goto L24;
        r6 = Long.valueOf(r3.a);
        if (r6.longValue() == 0) goto L22;
        r4 = true;
    L22:
        if (r4 == false) goto L24;
    L7:
        r3 = null;
        goto L8
    }

    @JvmStatic
    public static final void F(Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "param");
        mz0.n r0 = new mz0.n();
        Map r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r3, "map");
        r1.putAll(r3);
        mz0.m r4 = new mz0.m();
        r4.b(LogCommon.LIVE_SHARE_LOG);
        r4.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r2 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r2, "pageSourceLog");
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(r2.a);
        List r7 = r0.b;
        ArrayList r8 = (ArrayList) r7;
        r8.addAll(r4.a);
        cy0.e.a.getClass();
        cy0.j r9 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r10 = com.bytedance.android.scope.m.b(r9).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r10);
        ((f80.a) r10).w3("livesdk_gift_quick_download_result", r0.a, r0.b);
    }

    public static String a0(HashMap r6) {
        Intrinsics.checkNotNullParameter(r6, "giftInfo");
        Iterator r7 = r6.entrySet().iterator();
        if (r7.hasNext() == true) goto L6;
        return "{}";
    L6:
        StringBuilder r0 = new StringBuilder("{");
    L7:
        Map.Entry r1 = (Map.Entry) r7.next();
        long r2 = ((Number) r1.getKey()).longValue();
        long r4 = ((Number) r1.getValue()).longValue();
        r0.append('\"');
        r0.append(r2);
        r0.append("\":");
        r0.append(r4);
        if (r7.hasNext() == false) goto L9;
        r0.append(", ");
        goto L7
    L9:
        r0.append('}');
        return r0.toString();
    }

    public static int d(Integer r0) {
        if (r0 != null) goto L12;
        GiftContext r1 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r1 == null) goto L10;
        com.bytedance.live.datacontext.n<Integer> r2 = r1.getCurrentSelectedGiftPosition();
        if (r2 == null) goto L10;
        Integer r3 = (Integer) r2.getValue();
        if (r3 == null) goto L10;
        int r4 = r3.intValue();
    L11:
        r0 = Integer.valueOf(r4 + 1);
    L10:
        r4 = 0;
    L12:
        int r5 = ((r0.intValue() - 1) % 4) + 1;
        k();
        return r5;
    }

    public static int h(Integer r1) {
        if (r1 != null) goto L13;
        GiftContext r2 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r2 == null) goto L10;
        com.bytedance.live.datacontext.n<Integer> r3 = r2.getCurrentSelectedGiftPosition();
        if (r3 == null) goto L10;
        Integer r4 = (Integer) r3.getValue();
        if (r4 == null) goto L10;
        int r5 = r4.intValue();
    L11:
        r1 = Integer.valueOf(r5 + 1);
    L10:
        r5 = 0;
    L13:
        if (t.b() == false) goto L15;
        int r6 = (r1.intValue() - 1) / 4;
    L17:
        return r6 + 1;
    L15:
        r6 = ((r1.intValue() - 1) % 8) / 4;
        goto L17
    }

    public static String i(List r3) {
        String r0 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString();
        yz0.k r1 = g();
        if (r1 == null) goto L9;
        if (r1.isAnchor() != true) goto L9;
        return "anchor";
    L9:
        if (((ArrayList) r3).contains(r0) == false) goto L12;
        return "guest";
    L12:
        return "user";
    }

    public static void j(Map r4) {
        com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a r0 = com.bytedance.android.live.revenue.core.util.f.a(mz0.c.class).W2(LogCommon.PAGE_SOURCE_LOG);
        if (r0 != null) goto L5;
        return;
    L5:
        r4.put("action_type", com.bytedance.android.livesdk.gift.platform.business.sendGift.e.b("action_type", r0));
        r4.put("enter_method", com.bytedance.android.livesdk.gift.platform.business.sendGift.e.b("enter_method", r0));
        if (TextUtils.isEmpty(com.bytedance.android.livesdk.gift.platform.business.sendGift.e.b("enter_from_ad_type", r0)) == true) goto L8;
        String r1 = com.bytedance.android.livesdk.gift.platform.business.sendGift.e.b("enter_from_ad_type", r0);
    L9:
        r4.put("enter_from_merge", r1);
        return;
    L8:
        r1 = com.bytedance.android.livesdk.gift.platform.business.sendGift.e.b("enter_from_merge", r0);
        goto L9
    }

    @JvmStatic
    public static final void p(Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "paramMap");
        mz0.n r0 = new mz0.n();
        Map r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r3, "map");
        r1.putAll(r3);
        mz0.m r4 = new mz0.m();
        r4.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r2 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r2, "pageSourceLog");
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(r2.a);
        List r7 = r0.b;
        ArrayList r8 = (ArrayList) r7;
        r8.addAll(r4.a);
        cy0.e.a.getClass();
        cy0.j r9 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r10 = com.bytedance.android.scope.m.b(r9).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r10);
        ((f80.a) r10).w3("livesdk_live_clear_gift_memory_cache", r0.a, r0.b);
    }

    @JvmStatic
    public static final Map<String, String> J(IBaseUser r6, NormalGiftMessage r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r7 == null) goto L5;
        o7 r1 = r7.r();
    L6:
        if (r6 == null) goto L8;
        r0.put("anchor_id", r6.getIdString());
    L8:
        String r8 = "1";
        if (r1 == null) goto L18;
        GiftContext r2 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r2 == null) goto L13;
        ((com.bytedance.android.livesdk.gift.platform.business.tray2.k) r2.getMessageDispatcher().getValue()).getClass();
        r0.put("gift_id", String.valueOf(com.bytedance.android.livesdk.gift.platform.business.tray2.k.b(r1).getId()));
    L13:
        long r3 = r7.getTotalMoney();
        r0.put("gift_cnt", String.valueOf(r7.getTotalCount()));
        r0.put("gift_price", String.valueOf(r3));
        if (r1.isLocal() == false) goto L16;
        String r9 = "1";
    L17:
        r0.put("own_send", r9);
        goto L18
    L16:
        r9 = "2";
    L18:
        yz0.k r10 = g();
        if (r10 == null) goto L24;
        String r11 = r10.getRoom().getRequestId();
        if (r11 != null) goto L23;
        r11 = BuildConfig.FLAVOR;
    L23:
        r0.put("request_id", r11);
    L24:
        yz0.k r13 = g();
        if (r13 == null) goto L27;
        boolean r14 = r13.isAnchor();
    L28:
        if (r14 == true) goto L31;
        r8 = "0";
    L31:
        r0.put("is_anchor", r8);
        return r0;
    L27:
        r14 = false;
        goto L28
    L5:
        r1 = null;
        goto L6
    }

    @JvmStatic
    public static final void L(long r4, boolean r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        yz0.k r1 = g();
        if (r1 == null) goto L5;
        IRoom r2 = r1.getRoom();
    L6:
        if (r2 == null) goto L11;
        String r3 = r2.getAnchorId();
        if (r3 != null) goto L10;
        r3 = BuildConfig.FLAVOR;
    L10:
        r0.put("anchor_id", r3);
        r0.put("room_id", String.valueOf(r2.getId()));
    L11:
        b0(r6, r0, r4);
        r0.put("user_id", com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId());
        mz0.n r5 = new mz0.n();
        Map r7 = r5.a;
        Intrinsics.checkNotNullParameter(r7, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r7.putAll(r0);
        mz0.m r8 = new mz0.m();
        r8.b(LogCommon.LIVE_SHARE_LOG);
        r8.b(LogCommon.ROOM);
        r8.b(LogCommon.RECOMMEND_SOURCE_LOG);
        com.bytedance.android.livesdk.revenue.log.i r9 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r9, "pageSourceLog");
        List r10 = r8.a;
        ArrayList r11 = (ArrayList) r10;
        r11.add(r9.a);
        List r13 = r5.b;
        ArrayList r14 = (ArrayList) r13;
        r14.addAll(r8.a);
        cy0.e.a.getClass();
        cy0.j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r16);
        ((f80.a) r16).w3("livesdk_gift_combo_click", r5.a, r5.b);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @JvmStatic
    public static final void M(Map<String, String> r2, EffectMessage r3) {
        Intrinsics.checkNotNullParameter(r2, "metrics");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(r2);
        a(r0, r3);
        mz0.n r4 = new mz0.n();
        Map r5 = r4.a;
        Intrinsics.checkNotNullParameter(r5, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r5.putAll(r0);
        mz0.m r6 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r1 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r1, "pageSourceLog");
        List r7 = r6.a;
        ArrayList r8 = (ArrayList) r7;
        r8.add(r1.a);
        r6.b(LogCommon.ROOM);
        List r9 = r4.b;
        ArrayList r10 = (ArrayList) r9;
        r10.addAll(r6.a);
        cy0.e.a.getClass();
        cy0.j r11 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r13 = com.bytedance.android.scope.m.b(r11).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r13);
        ((f80.a) r13).w3("livesdk_rd_lynx_effect_play_metrics", r4.a, r4.b);
    }

    @JvmStatic
    public static final void W(long r5, int r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("gift_id", String.valueOf(r5));
        GiftContext r6 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r6 == null) goto L8;
        com.bytedance.live.datacontext.m<String> r8 = r6.getGiftListResultLogId();
        if (r8 == null) goto L8;
        String r9 = (String) r8.getValue();
        if (r9 == null) goto L8;
    L9:
        r0.put("gift_dialog_request_id", r9);
        r0.put("tab_location", String.valueOf(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.h() + 1));
        int r10 = r7 + 1;
        int r1 = r10 % 8;
        if (r1 != 0) goto L12;
        int r2 = 0;
    L13:
        r0.put("page_location", String.valueOf((r10 / 8) + r2));
        int[] r11 = b;
        if (r2 != 0) goto L16;
        r1 = 8;
    L16:
        r0.put("gift_location", String.valueOf(r11[r1]));
        r0.put("gift_row_location", String.valueOf((r7 / 4) + 1));
        r0.put("gift_column_location", String.valueOf((r7 % 4) + 1));
        r0.put("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f()));
        mz0.n r13 = new mz0.n();
        Map r14 = r13.a;
        Intrinsics.checkNotNullParameter(r14, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r14.putAll(r0);
        mz0.m r15 = new mz0.m();
        r15.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r16 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r16, "pageSourceLog");
        List r3 = r15.a;
        ArrayList r4 = (ArrayList) r3;
        r4.add(r16.a);
        List r17 = r13.b;
        ArrayList r18 = (ArrayList) r17;
        r18.addAll(r15.a);
        cy0.e.a.getClass();
        cy0.j r19 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r20 = com.bytedance.android.scope.m.b(r19).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r20);
        ((f80.a) r20).w3("livesdk_giftgroup_show", r13.a, r13.b);
        return;
    L12:
        r2 = 1;
    L8:
        r9 = BuildConfig.FLAVOR;
        goto L9
    }

    public static void a(Map r3, EffectMessage r4) {
        r3.put("consume_level", String.valueOf(ay1.b.u()));
        r3.put("audience_cnt", String.valueOf(com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getCurrentAudienceCount()));
        if (r4 == null) goto L28;
        r3.put("gift_id", String.valueOf(r4.l));
        r3.put("effect_id", String.valueOf(r4.b));
        r3.put("gift_type", String.valueOf(r4.u));
        r3.put("gift_effect_type", String.valueOf(r4.f));
        h1 r0 = r4.C;
        String r1 = null;
        if (r0 == null) goto L7;
        Integer r2 = Integer.valueOf(r0.getDiamondCount());
    L8:
        r3.put("money_per_unit", String.valueOf(r2));
        String r5 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString();
        IBaseUser r6 = r4.i;
        if (r6 == null) goto L11;
        String r7 = r6.getIdString();
    L13:
        if (Intrinsics.areEqual(r5, r7) == false) goto L15;
        String r8 = "0";
    L27:
        r3.put("gift_role", r8);
        goto L28
    L15:
        IBaseUser r9 = r4.h;
        if (r9 == null) goto L19;
        r1 = r9.getIdString();
    L19:
        if (Intrinsics.areEqual(r1, r5) == true) goto L26;
        List<String> r10 = r4.A;
        if (r10 != null) goto L23;
    L25:
        r8 = "2";
        goto L27
    L23:
        if (r10.contains(r5) != true) goto L25;
    L26:
        r8 = "1";
        goto L27
    L11:
        r7 = null;
        goto L13
    L7:
        r2 = null;
    L28:
        com.bytedance.android.livesdk.revenue.service.performance.c r11 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.performance.c.class);
        r3.put("cpu_rate", String.valueOf(r11.getCpuRate()));
        r3.put("gpu_used", String.valueOf(r11.getGpuUsed()));
        r3.put("temperature", String.valueOf(r11.getTemperature()));
        r3.put("ui_fps", String.valueOf(r11.getFps()));
        r3.put("ui_stall_rate", String.valueOf(r11.F3()));
        r3.put("battery_current", String.valueOf(r11.ql()));
    }

    @JvmStatic
    public static final void d0(String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "map");
        mz0.n r1 = new mz0.n();
        Map r2 = r1.a;
        Intrinsics.checkNotNullParameter(r2, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r2.putAll(r4);
        mz0.m r5 = new mz0.m();
        r5.b(LogCommon.PAGE_SOURCE_LOG);
        r5.b(LogCommon.ROOM);
        List r0 = r1.b;
        ArrayList r6 = (ArrayList) r0;
        r6.addAll(r5.a);
        cy0.e.a.getClass();
        cy0.j r7 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r8 = com.bytedance.android.scope.m.b(r7).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r8);
        ((f80.a) r8).w3(r3, r1.a, r1.b);
    }

    @JvmStatic
    public static final void o(float r2, boolean r3) {
        Pair[] r0 = {TuplesKt.to("device_score", String.valueOf(r2))};
        LinkedHashMap r4 = new LinkedHashMap();
        MapsKt.putAll(r4, r0);
        if (r3 == false) goto L5;
        r4.put("isAnchor", "1");
    L6:
        mz0.n r5 = new mz0.n();
        Map r1 = r5.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r1.putAll(r4);
        mz0.m r6 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r7 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r7, "pageSourceLog");
        ((ArrayList) r6.a).add(r7.a);
        r6.b(LogCommon.ROOM);
        ((ArrayList) r5.b).addAll(r6.a);
        cy0.e.a.getClass();
        cy0.j r8 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r9 = com.bytedance.android.scope.m.b(r8).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r9);
        ((f80.a) r9).w3("livesdk_big_effect_skip_rd", r5.a, r5.b);
        return;
    L5:
        r4.put("isAnchor", "0");
        goto L6
    }

    @JvmStatic
    public static final void r(long r2, boolean r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("gift_id", String.valueOf(r2));
        if (r4 == false) goto L5;
        String r3 = "open";
    L6:
        r0.put("click_type", r3);
        if (g02.a.e() == false) goto L9;
        String r5 = "1";
    L10:
        r0.put("is_anchor", r5);
        mz0.n r6 = new mz0.n();
        Map r7 = r6.a;
        Intrinsics.checkNotNullParameter(r7, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r7.putAll(r0);
        mz0.m r8 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r9 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r9, "pageSourceLog");
        List r1 = r8.a;
        ArrayList r10 = (ArrayList) r1;
        r10.add(r9.a);
        r8.b(LogCommon.ROOM);
        List r11 = r6.b;
        ArrayList r13 = (ArrayList) r11;
        r13.addAll(r8.a);
        cy0.e.a.getClass();
        cy0.j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r15);
        ((f80.a) r15).w3("livesdk_gift_voice_setting_switch_click", r6.a, r6.b);
        return;
    L9:
        r5 = "0";
        goto L10
    L5:
        r3 = "close";
        goto L6
    }

    @JvmStatic
    public static final void s(long r2, boolean r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("gift_id", String.valueOf(r2));
        if (r4 == false) goto L5;
        String r3 = "open";
    L6:
        r0.put("switch_status", r3);
        if (g02.a.e() == false) goto L9;
        String r5 = "1";
    L10:
        r0.put("is_anchor", r5);
        mz0.n r6 = new mz0.n();
        Map r7 = r6.a;
        Intrinsics.checkNotNullParameter(r7, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r7.putAll(r0);
        mz0.m r8 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r9 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r9, "pageSourceLog");
        List r1 = r8.a;
        ArrayList r10 = (ArrayList) r1;
        r10.add(r9.a);
        r8.b(LogCommon.ROOM);
        List r11 = r6.b;
        ArrayList r13 = (ArrayList) r11;
        r13.addAll(r8.a);
        cy0.e.a.getClass();
        cy0.j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r15);
        ((f80.a) r15).w3("livesdk_gift_voice_setting_switch_show", r6.a, r6.b);
        return;
    L9:
        r5 = "0";
        goto L10
    L5:
        r3 = "close";
        goto L6
    }

    public static void B(long r4, String r6, DataCenter r7) {
        Intrinsics.checkNotNullParameter(r6, "giftPopupType");
        gq2.b r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).Qc();
        if (r7 == null) goto L7;
        r0.b();
        Integer r8 = (Integer) r7.get("data_link_state", 0);
        if (r8 == null) goto L7;
        int r9 = r8.intValue();
    L8:
        Map r5 = com.bytedance.revenue.platform.api.core.d.a(new Pair[]{TuplesKt.to("gift_id", String.valueOf(r4)), TuplesKt.to("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f())), TuplesKt.to("tab_location", String.valueOf(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.h() + 1)), TuplesKt.to("gift_row_location", String.valueOf(h(null))), TuplesKt.to("gift_column_location", String.valueOf(d(null))), TuplesKt.to("gift_popup_type", r6), TuplesKt.to("send_gift_scene", vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(r9).toString())});
        mz0.n r10 = new mz0.n();
        Map r11 = r10.a;
        Intrinsics.checkNotNullParameter(r11, "map");
        Intrinsics.checkNotNullParameter(r5, "map");
        r11.putAll(r5);
        mz0.m r13 = new mz0.m();
        r13.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r14 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r14, "pageSourceLog");
        ((ArrayList) r13.a).add(r14.a);
        ((ArrayList) r10.b).addAll(r13.a);
        cy0.e.a.getClass();
        cy0.j r15 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r16 = com.bytedance.android.scope.m.b(r15).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r16);
        ((f80.a) r16).w3("livesdk_gift_long_click", r10.a, r10.b);
        return;
    L7:
        r0.b();
        r9 = 0;
        goto L8
    }

    public static void C(long r4, int r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "clickType");
        mz0.n r0 = new mz0.n();
        Map r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        String r5 = String.valueOf(r4);
        Intrinsics.checkNotNullParameter("gift_id", "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        r1.put("gift_id", r5);
        if (r6 != 1) goto L5;
        String r8 = "sound";
    L12:
        Intrinsics.checkNotNullParameter("mode_type", "key");
        Intrinsics.checkNotNullParameter(r8, "value");
        r1.put("mode_type", r8);
        Intrinsics.checkNotNullParameter("click_type", "key");
        Intrinsics.checkNotNullParameter(r7, "value");
        r1.put("click_type", r7);
        mz0.m r9 = new mz0.m();
        r9.b(LogCommon.LIVE_SHARE_LOG);
        r9.b(LogCommon.ROOM);
        r9.b(LogCommon.PAGE_SOURCE_LOG);
        List r10 = r0.b;
        ArrayList r11 = (ArrayList) r10;
        r11.addAll(r9.a);
        cy0.e.a.getClass();
        cy0.j r13 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r14 = com.bytedance.android.scope.m.b(r13).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r14);
        ((f80.a) r14).w3("livesdk_gift_mode_button_click", r0.a, r0.b);
        return;
    L5:
        if (r6 != 2) goto L7;
        r8 = "vibration";
        goto L12
    L7:
        if (r6 == 3) goto L9;
        r8 = BuildConfig.FLAVOR;
        goto L12
    L9:
        r8 = "dual_mode";
        goto L12
    }

    @JvmStatic
    public static final void Q(int r2, long r3, int r5) {
        Pair[] r0 = new Pair[4];
        r0[0] = TuplesKt.to("intercept_code", String.valueOf(r2));
        r0[1] = TuplesKt.to("gift_id", String.valueOf(r3));
        r0[2] = TuplesKt.to("remote_code", String.valueOf(r5));
        String r4 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId();
        if (r4 != null) goto L5;
        r4 = "UNKNOWN";
    L5:
        r0[3] = TuplesKt.to("rev_user_id", r4);
        Map r6 = com.bytedance.revenue.platform.api.core.d.a(r0);
        mz0.n r7 = new mz0.n();
        Map r8 = r7.a;
        Intrinsics.checkNotNullParameter(r8, "map");
        Intrinsics.checkNotNullParameter(r6, "map");
        r8.putAll(r6);
        mz0.m r9 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r10 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r10, "pageSourceLog");
        List r11 = r9.a;
        ArrayList r13 = (ArrayList) r11;
        r13.add(r10.a);
        r9.b(LogCommon.ROOM);
        List r14 = r7.b;
        ArrayList r15 = (ArrayList) r14;
        r15.addAll(r9.a);
        cy0.e.a.getClass();
        cy0.j r16 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r16).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r17);
        ((f80.a) r17).w3("livesdk_gift_send_intercept", r7.a, r7.b);
    }

    public static void b0(boolean r4, Map r5, long r6) {
        if (r4 == false) goto L5;
        r5.put("is_prop", "2");
        r5.put("gift_id", String.valueOf(r6));
        return;
    L5:
        r5.put("is_prop", "1");
        i12.e r7 = i12.o.b();
        l2 r1 = null;
        if (r7 == null) goto L8;
        Object r8 = com.bytedance.android.scope.m.e.d(r7, PropListService.class);
    L9:
        PropListService r9 = (PropListService) r8;
        if (r9 == null) goto L12;
        r1 = r9.f(Long.valueOf(r6));
    L12:
        if (r1 == null) goto L17;
        h1 r10 = r1.getGift();
        if (r10 == null) goto L17;
        String r11 = String.valueOf(r10.getId());
        if (r11 == null) goto L17;
    L18:
        r5.put("gift_id", r11);
        r5.put("prop_id", String.valueOf(r6));
        return;
    L17:
        r11 = "0";
        goto L18
    L8:
        r8 = null;
        goto L9
    }

    @JvmStatic
    public static final void z(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "desc");
        HashMap r1 = new HashMap();
        if (TextUtils.isEmpty(r3) == true) goto L6;
        r1.put("desc", r3);
    L6:
        if (TextUtils.isEmpty(r4) == true) goto L9;
        r1.put("gift_id", r4);
    L9:
        if (TextUtils.isEmpty(r5) == true) goto L11;
        r1.put("msg_id", r5);
    L11:
        jy0.b.d("ttlive_gift", r1.toString());
    }

    public static void A(int r3, int r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "checkType");
        Map r7 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("page_size", String.valueOf(r3)), TuplesKt.to("gift_count", String.valueOf(r4)), TuplesKt.to("request_source", String.valueOf(r5)), TuplesKt.to("check_type", r6)});
        GiftContext r8 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r8 == null) goto L5;
        r7.put("panel_open_times", String.valueOf(r8.getPanelOpenTimes()));
        r7.put("stay_room_duration", String.valueOf((System.currentTimeMillis() - r8.getEnterRoomTime()) / ((long) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)));
    L5:
        jy0.b.c("ttlive_gift_list", "gift list empty: " + r7, null, 4);
        mz0.n r9 = new mz0.n();
        Map r10 = r9.a;
        Intrinsics.checkNotNullParameter(r10, "map");
        Intrinsics.checkNotNullParameter(r7, "map");
        r10.putAll(r7);
        mz0.m r11 = new mz0.m();
        r11.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r13 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r13, "pageSourceLog");
        ((ArrayList) r11.a).add(r13.a);
        ((ArrayList) r9.b).addAll(r11.a);
        cy0.e.a.getClass();
        cy0.j r14 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r15);
        ((f80.a) r15).w3("livesdk_gift_list_empty", r9.a, r9.b);
    }

    public static int c(long r0, int r2, boolean r3, boolean r4) {
        if (r3 == false) goto L5;
        return 1;
    L5:
        if (r4 == false) goto L8;
        return 3;
    L8:
        w1 r5 = ((com.bytedance.android.livesdk.gift.platform.core.giftlist.i) com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.platform.core.giftlist.i.class)).U(r2);
        if (r5 == null) goto L16;
        Map<Integer, Long> r6 = r5.getForceInsertMap();
        if (r6 != null) goto L13;
        return 0;
    L13:
        if (r6.get(Integer.valueOf((int) r0)) == null) goto L19;
        return 2;
    L19:
        return 0;
    L16:
        return 0;
    }

    public static String f(long r6, long r8, long r10, long r13) {
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.E0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[81])).booleanValue() == false) goto L19;
        if (r8 > 1) goto L19;
        if (r13 <= 1) goto L19;
        if (r10 != 1) goto L14;
        if (r6 != 1) goto L14;
        return "single_gift";
    L14:
        if (r10 <= r13) goto L17;
        return "bunchrunning_gift";
    L17:
        return "bunching_gift";
    L19:
        if (r6 == 1) goto L32;
        if (r10 <= 1) goto L27;
        if (r8 <= 1) goto L27;
        return "bunchrunning_gift";
    L27:
        if (r8 > 1) goto L35;
        if (r10 <= 1) goto L32;
        return "running_gift";
    L35:
        return "bunching_gift";
    L32:
        return "single_gift";
    }

    @JvmStatic
    public static final void t(String r2, long r3, int r5, Throwable r6) {
        Intrinsics.checkNotNullParameter(r2, "giftIds");
        Pair[] r0 = new Pair[4];
        r0[0] = TuplesKt.to("gift_ids", r2);
        if (r6 != null) goto L5;
        String r4 = "0";
    L6:
        r0[1] = TuplesKt.to("error_code", r4);
        r0[2] = TuplesKt.to("room_id", String.valueOf(r3));
        r0[3] = TuplesKt.to("fetch_from", String.valueOf(r5));
        LinkedHashMap r7 = new LinkedHashMap();
        MapsKt.putAll(r7, r0);
        mz0.n r8 = new mz0.n();
        Map r9 = r8.a;
        Intrinsics.checkNotNullParameter(r9, "map");
        Intrinsics.checkNotNullParameter(r7, "map");
        r9.putAll(r7);
        mz0.m r10 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r11 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r11, "pageSourceLog");
        List r13 = r10.a;
        ArrayList r14 = (ArrayList) r13;
        r14.add(r11.a);
        r10.b(LogCommon.ROOM);
        List r15 = r8.b;
        ArrayList r16 = (ArrayList) r15;
        r16.addAll(r10.a);
        cy0.e.a.getClass();
        cy0.j r17 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r18 = com.bytedance.android.scope.m.b(r17).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r18);
        ((f80.a) r18).w3("livesdk_fetch_gift_detail", r8.a, r8.b);
        return;
    L5:
        r4 = "1";
        goto L6
    }

    public static void b(int r5, int r6, com.bytedance.android.livesdk.gift.platform.core.model.k r7, int r8, Map r9) {
        Intrinsics.checkNotNullParameter(r9, "logMap");
        if (r7 == null) goto L5;
        int r3 = r7.b;
        int r10 = r7.a;
        if (r5 != r3) goto L25;
        if (r10 != r6) goto L12;
        r9.put("default", "1");
    L13:
        int r11 = h(Integer.valueOf(r10));
        int r13 = h(Integer.valueOf(r6));
        int r14 = h(Integer.valueOf(r8));
        if (r13 != r11) goto L17;
        r9.put("first_screen", "1");
        return;
    L17:
        if ((r13 - r11) != 1) goto L19;
        r9.put("first_screen", "1");
        return;
    L19:
        if (r14 <= 0) goto L24;
        if (r11 != r14) goto L24;
        if ((r11 - r13) != 1) goto L24;
        r9.put("first_screen", "1");
        return;
    L24:
        r9.put("first_screen", "0");
        return;
    L12:
        r9.put("default", "0");
        goto L13
    L25:
        r9.put("default", "0");
        r9.put("first_screen", "0");
        return;
    L5:
        if (h(Integer.valueOf(r6)) >= 3) goto L7;
        r9.put("first_screen", "1");
        return;
    L7:
        r9.put("first_screen", "0");
    }

    @JvmStatic
    public static final void n(Long r4, int r5, Integer r6, String r7, String r8) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r4 == null) goto L6;
        String r9 = String.valueOf(r4.longValue());
        if (r9 == null) goto L6;
    L7:
        r0.put("gift_id", r9);
        r0.put("gift_cnt", String.valueOf(r5));
        if (r6 == null) goto L11;
        String r10 = String.valueOf(r6.intValue());
        if (r10 == null) goto L11;
    L12:
        r0.put("scene", r10);
        if (r7 != null) goto L15;
        r7 = BuildConfig.FLAVOR;
    L15:
        r0.put("together_time", r7);
        if (r8 != null) goto L18;
        r8 = BuildConfig.FLAVOR;
    L18:
        r0.put("show_time", r8);
        mz0.n r11 = new mz0.n();
        Map r13 = r11.a;
        Intrinsics.checkNotNullParameter(r13, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r13.putAll(r0);
        mz0.m r14 = new mz0.m();
        r14.b(LogCommon.ROOM);
        r14.b(LogCommon.PAGE_SOURCE_LOG);
        List r15 = r11.b;
        ArrayList r16 = (ArrayList) r15;
        r16.addAll(r14.a);
        cy0.e.a.getClass();
        cy0.j r17 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r18 = com.bytedance.android.scope.m.b(r17).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r18);
        ((f80.a) r18).w3("continue_send_gift_feedback_click", r11.a, r11.b);
        return;
    L11:
        r10 = "1";
    L6:
        r9 = BuildConfig.FLAVOR;
        goto L7
    }

    @JvmStatic
    public static final void q(Long r4, int r5, String r6, Integer r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "showTime");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r4 == null) goto L6;
        String r9 = String.valueOf(r4.longValue());
        if (r9 == null) goto L6;
    L7:
        r0.put("gift_id", r9);
        r0.put("gift_cnt", String.valueOf(r5));
        r0.put("show_time", r6);
        if (r7 == null) goto L11;
        String r10 = String.valueOf(r7.intValue());
        if (r10 == null) goto L11;
    L12:
        r0.put("scene", r10);
        if (r8 != null) goto L15;
        r8 = BuildConfig.FLAVOR;
    L15:
        r0.put("together_time", r8);
        mz0.n r11 = new mz0.n();
        Map r13 = r11.a;
        Intrinsics.checkNotNullParameter(r13, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r13.putAll(r0);
        mz0.m r14 = new mz0.m();
        r14.b(LogCommon.ROOM);
        r14.b(LogCommon.PAGE_SOURCE_LOG);
        List r15 = r11.b;
        ArrayList r16 = (ArrayList) r15;
        r16.addAll(r14.a);
        cy0.e.a.getClass();
        cy0.j r17 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r18 = com.bytedance.android.scope.m.b(r17).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r18);
        ((f80.a) r18).w3("continue_send_gift_feedback_show", r11.a, r11.b);
        return;
    L11:
        r10 = "1";
    L6:
        r9 = BuildConfig.FLAVOR;
        goto L7
    }

    @JvmStatic
    public static final void x(String r2, String r3, String r4, String r5, String r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (TextUtils.isEmpty(r2) == true) goto L6;
        r0.put("desc", r2);
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L9;
        r0.put("gift_id", r3);
    L9:
        if (TextUtils.isEmpty(r4) == true) goto L12;
        r0.put("msg_id", r4);
    L12:
        if (TextUtils.isEmpty(r5) == true) goto L15;
        r0.put("asset_id", r5);
    L15:
        if (TextUtils.isEmpty(r6) == true) goto L17;
        r0.put("log_id", r6);
    L17:
        jy0.b.c("ttlive_gift", r0.toString(), null, 4);
    }

    public static void D(int r5, IntRange r6, int r7, long r8, int r10, String r11) {
        Intrinsics.checkNotNullParameter(r6, "rowLocation");
        Intrinsics.checkNotNullParameter(r11, "vsSeasonID");
        Pair[] r0 = new Pair[7];
        r0[0] = TuplesKt.to("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r5));
        r0[1] = TuplesKt.to("tab_location", String.valueOf(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.h() + 1));
        r0[2] = TuplesKt.to("start_row_location", String.valueOf(r6.getFirst()));
        r0[3] = TuplesKt.to("end_row_location", String.valueOf(r6.getLast()));
        r0[4] = TuplesKt.to("scroll_rows", String.valueOf((r6.getLast() - r6.getFirst()) + 1));
        r0[5] = TuplesKt.to("scroll_gift_num", String.valueOf(r7));
        long r1 = 10000;
        if (0 <= r8) goto L6;
    L8:
        String r9 = "0";
    L9:
        r0[6] = TuplesKt.to("scroll_duration", r9);
        LinkedHashMap r13 = new LinkedHashMap();
        MapsKt.putAll(r13, r0);
        if (com.bytedance.android.livesdk.gift.util.b.b() == null) goto L19;
        GiftContext r14 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r14 == null) goto L17;
        com.bytedance.live.datacontext.m<String> r15 = r14.getGiftListResultLogId();
        if (r15 == null) goto L17;
        String r16 = (String) r15.getValue();
        if (r16 == null) goto L17;
    L18:
        r13.put("gift_dialog_request_id", r16);
    L17:
        r16 = BuildConfig.FLAVOR;
    L19:
        r13.put("is_vs", String.valueOf(r10));
        r13.put("vs_season_id", r11);
        if ((com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.d() instanceof pz1.a) == false) goto L22;
        String r17 = "gift_id";
    L23:
        AbsPanel<?> r18 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.d();
        if (r18 == null) goto L26;
        Long r19 = Long.valueOf(r18.c());
    L27:
        r13.put(r17, String.valueOf(r19));
        if (r5 != 5) goto L30;
        String r20 = "1";
    L31:
        r13.put("is_prop", r20);
        mz0.n r21 = new mz0.n();
        Map r23 = r21.a;
        Intrinsics.checkNotNullParameter(r23, "map");
        Intrinsics.checkNotNullParameter(r13, "map");
        r23.putAll(r13);
        mz0.m r24 = new mz0.m();
        r24.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r25 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r25, "pageSourceLog");
        ((ArrayList) r24.a).add(r25.a);
        ((ArrayList) r21.b).addAll(r24.a);
        cy0.e.a.getClass();
        cy0.j r26 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r27 = com.bytedance.android.scope.m.b(r26).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r27);
        ((f80.a) r27).w3("livesdk_gift_panel_scroll", r21.a, r21.b);
        return;
    L30:
        r20 = "2";
        goto L31
    L26:
        r19 = null;
        goto L27
    L22:
        r17 = "prop_id";
        goto L23
    L6:
        if (r1 < r8) goto L8;
        r9 = String.valueOf(r8);
        goto L9
    }

    @JvmStatic
    public static final void I(IBaseUser r17, o7 r18, String r19, long r20, long r23, NormalGiftMessage r24) {
        Intrinsics.checkNotNullParameter(r19, "clickFrom");
        LinkedHashMap r2 = new LinkedHashMap();
        if (r17 == null) goto L5;
        r2.put("anchor_id", r17.getIdString());
    L5:
        String r3 = BuildConfig.FLAVOR;
        boolean r4 = true;
        int r5 = 0;
        String r6 = "2";
        if (r18 == null) goto L26;
        if (r18.getTrayInfo() == null) goto L18;
        o0 r1 = r18.getTrayInfo();
        if (r1 == null) goto L12;
        Long r7 = Long.valueOf(r1.getTrayLevel());
    L13:
        r2.put("tray_level", String.valueOf(r7));
        o0 r8 = r18.getTrayInfo();
        if (r8 == null) goto L16;
        Integer r9 = Integer.valueOf(r8.getTrayType());
    L17:
        r2.put("tray_type", String.valueOf(r9));
        goto L18
    L16:
        r9 = null;
        goto L17
    L12:
        r7 = null;
    L18:
        GiftContext r10 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r10 == null) goto L21;
        ((com.bytedance.android.livesdk.gift.platform.business.tray2.k) r10.getMessageDispatcher().getValue()).getClass();
        r2.put("gift_id", String.valueOf(com.bytedance.android.livesdk.gift.platform.business.tray2.k.b(r18).getId()));
    L21:
        r2.put("gift_cnt", String.valueOf(r23));
        r2.put("gift_price", String.valueOf(r20));
        if (r18.isLocal() == false) goto L24;
        r6 = "1";
    L24:
        r2.put("own_send", r6);
    L44:
        yz0.k r11 = g();
        if (r11 == null) goto L51;
        String r13 = r11.getRoom().getRequestId();
        if (r13 == null) goto L50;
        r3 = r13;
    L50:
        r2.put("request_id", r3);
    L51:
        r2.put("version", "new");
        r2.put("click_from", r19);
        if (r18 == null) goto L56;
        h1 r14 = r18.getGift();
        if (r14 == null) goto L56;
        int r15 = r14.getMysteryShopStatus();
    L57:
        if (r15 == 0) goto L59;
        boolean r16 = true;
    L60:
        if (r16 == false) goto L62;
        r2.put("mission_info", "mystery_shop");
    L62:
        yz0.k r21 = g();
        if (r21 == null) goto L65;
        boolean r25 = r21.isAnchor();
    L66:
        if (r25 == false) goto L68;
        Object r26 = "1";
    L69:
        r2.put("is_anchor", r26);
        if (r18 == null) goto L72;
        o0 r110 = r18.getTrayInfo();
    L73:
        if (r110 == null) goto L81;
        w3 r27 = r110.getTrayPreEffect();
        if (r27 == null) goto L81;
        py.k r28 = r27.getPreEffectImg();
        if (r28 == null) goto L81;
        if (r28.isValid() != true) goto L81;
        boolean r29 = true;
    L82:
        if (r110 == null) goto L90;
        u3 r30 = r110.getTrayPostEffect();
        if (r30 == null) goto L90;
        py.k r31 = r30.getPostEffectImg();
        if (r31 == null) goto L90;
        if (r31.isValid() != true) goto L90;
    L91:
        if (r29 == false) goto L93;
        Object r33 = r13;
    L94:
        r2.put("is_pre_effect", r33);
        if (r29 == false) goto L102;
        if (r110 == null) goto L100;
        w3 r34 = r110.getTrayPreEffect();
        if (r34 == null) goto L100;
        int r35 = r34.getPreEffectSource();
    L101:
        r2.put("pre_effect_type", String.valueOf(r35));
    L100:
        r35 = 0;
    L102:
        if (r4 == false) goto L104;
        Object r111 = r13;
    L105:
        r2.put("is_post_effect", r111);
        if (r4 == false) goto L113;
        if (r110 == null) goto L111;
        u3 r36 = r110.getTrayPostEffect();
        if (r36 == null) goto L111;
        r5 = r36.getPostEffectSource();
    L111:
        r2.put("post_effect_type", String.valueOf(r5));
    L113:
        if (Intrinsics.areEqual(r19, "gift") == false) goto L115;
        String r0 = com.bytedance.android.livesdk.gift.model.e.FETCH_FROM_GIFT_PANEL;
    L116:
        r2.put("transfer_page_type", r0);
        mz0.n r37 = new mz0.n();
        Map r38 = r37.a;
        Intrinsics.checkNotNullParameter(r38, "map");
        Intrinsics.checkNotNullParameter(r2, "map");
        r38.putAll(r2);
        mz0.m r39 = new mz0.m();
        r39.b(LogCommon.LIVE_SHARE_LOG);
        r39.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r40 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r40, "pageSourceLog");
        List r41 = r39.a;
        ArrayList r43 = (ArrayList) r41;
        r43.add(r40.a);
        List r44 = r37.b;
        ArrayList r45 = (ArrayList) r44;
        r45.addAll(r39.a);
        cy0.e.a.getClass();
        cy0.j r46 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r47 = com.bytedance.android.scope.m.b(r46).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r47);
        ((f80.a) r47).w3("livesdk_gift_tray_click", r37.a, r37.b);
        return;
    L115:
        r0 = "profile_card";
        goto L116
    L104:
        r111 = "0";
        goto L105
    L93:
        r33 = "0";
    L90:
        r4 = false;
    L81:
        r29 = false;
        goto L82
    L72:
        r110 = null;
        goto L73
    L68:
        r26 = "0";
        goto L69
    L65:
        r25 = false;
        goto L66
    L59:
        r16 = false;
    L56:
        r15 = 0;
        goto L57
    L26:
        if ((r24 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.l) == false) goto L44;
        com.bytedance.android.livesdk.gift.platform.business.tray.l r48 = (com.bytedance.android.livesdk.gift.platform.business.tray.l) r24;
        r2.put("tray_type", r48.y());
        if (r48.A() == false) goto L31;
        String r112 = r48.V;
    L37:
        r2.put("content", r112);
        r2.put("gift_id", String.valueOf(r48.b));
        r2.put("gift_cnt", String.valueOf(r48.Y));
        Long r49 = r48.k0;
        if (r49 == null) goto L41;
        String r50 = String.valueOf(r49.longValue());
        if (r50 == null) goto L41;
    L42:
        r2.put("gift_price", r50);
        r2.put("own_send", "2");
    L41:
        r50 = "0";
        goto L42
    L31:
        if ((r48.R & 2) != 2) goto L33;
        boolean r113 = true;
    L34:
        if (r113 == false) goto L36;
        r112 = r48.W;
        goto L37
    L36:
        r112 = BuildConfig.FLAVOR;
        goto L37
    L33:
        r113 = false;
        goto L34
    }

    @JvmStatic
    public static final void K(o7 r16, long r17, long r19, long r21, NormalGiftMessage r23, boolean r24) {
        LinkedHashMap r1 = new LinkedHashMap();
        boolean r2 = true;
        String r10 = "0";
        if (r16 == null) goto L73;
        String r11 = null;
        if (r16.getTrayInfo() == null) goto L15;
        o0 r0 = r16.getTrayInfo();
        if (r0 == null) goto L9;
        Long r3 = Long.valueOf(r0.getTrayLevel());
    L10:
        r1.put("tray_level", String.valueOf(r3));
        o0 r4 = r16.getTrayInfo();
        if (r4 == null) goto L13;
        Integer r5 = Integer.valueOf(r4.getTrayType());
    L14:
        r1.put("tray_type", String.valueOf(r5));
        goto L15
    L13:
        r5 = null;
        goto L14
    L9:
        r3 = null;
    L15:
        GiftContext r6 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r6 == null) goto L18;
        ((com.bytedance.android.livesdk.gift.platform.business.tray2.k) r6.getMessageDispatcher().getValue()).getClass();
        r1.put("gift_id", String.valueOf(com.bytedance.android.livesdk.gift.platform.business.tray2.k.b(r16).getId()));
    L18:
        r1.put("gift_cnt", String.valueOf(r19));
        r1.put("gift_price", String.valueOf(r17));
        if (r16.isLocal() == false) goto L21;
        Object r7 = "1";
    L22:
        r1.put("own_send", r7);
        long r8 = com.bytedance.live.kmp.util.e.b();
        long r13 = r16.getSendGiftTime();
        r1.put("all_duration", String.valueOf(r8 - r13));
        ConcurrentHashMap<String, Map<String, Long>> r9 = v12.e.a;
        long r14 = v12.e.e(r16.getTraceId(), "open_dialog");
        if (r14 <= 0) goto L25;
        r1.put("presend_duration", String.valueOf(r13 - r14));
    L26:
        r1.put("dequeue_duration", String.valueOf(System.currentTimeMillis() - r21));
        String r15 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString();
        if (r15 != null) goto L29;
    L32:
        boolean r18 = true;
    L33:
        if (r18 == true) goto L92;
        if (r16.getFromUser() == null) goto L46;
        IBaseUser r20 = r16.getFromUser();
        if (r20 == null) goto L39;
        String r25 = r20.getIdString();
    L41:
        if (Intrinsics.areEqual(r15, r25) == false) goto L46;
        r1.put("gift_role", "0");
        long r26 = v12.e.e(r16.getTraceId(), "send_success");
        if (r26 <= 0) goto L45;
        r1.put("send_api_duration", String.valueOf(r26 - r13));
        goto L92
    L45:
        r1.put("send_api_duration", "0");
        goto L92
    L39:
        r25 = null;
    L46:
        IBaseUser r27 = r16.getToUser();
        if (r27 == null) goto L49;
        String r28 = r27.getIdString();
    L51:
        if (Intrinsics.areEqual(r15, r28) == false) goto L53;
    L71:
        r1.put("gift_role", "1");
        r1.put("send_api_duration", "0");
        goto L92
    L53:
        if (r16.getToUserIdStrings().contains(r15) == true) goto L71;
        yz0.k r29 = g();
        if (r29 != null) goto L58;
    L69:
        r1.put("gift_role", "2");
    L70:
        r1.put("send_api_duration", "0");
        goto L92
    L58:
        if (r29.isAnchor() != true) goto L69;
        IBaseUser r30 = r16.getToUser();
        if (r30 == null) goto L62;
        r11 = r30.getIdString();
    L62:
        if (r11 != null) goto L64;
    L67:
        if (r2 == false) goto L69;
        r1.put("gift_role", "1");
        goto L70
    L64:
        if (r11.length() == 0) goto L67;
        r2 = false;
        goto L67
    L49:
        r28 = null;
    L92:
        if (r24 == false) goto L94;
        r1.put("show_type", "combo");
    L95:
        GiftTrayMessageManager r31 = GiftTrayMessageManager.r;
        r1.put("gift_message_size", String.valueOf(GiftTrayMessageManager.a.a().f()));
        mz0.n r33 = new mz0.n();
        Map r34 = r33.a;
        Intrinsics.checkNotNullParameter(r34, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r34.putAll(r1);
        mz0.m r35 = new mz0.m();
        r35.b(LogCommon.LIVE_SHARE_LOG);
        r35.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r36 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r36, "pageSourceLog");
        ((ArrayList) r35.a).add(r36.a);
        ((ArrayList) r33.b).addAll(r35.a);
        cy0.e.a.getClass();
        cy0.j r37 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r38 = com.bytedance.android.scope.m.b(r37).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r38);
        ((f80.a) r38).w3("livesdk_gift_tray_show", r33.a, r33.b);
        return;
    L94:
        r1.put("show_type", "default");
        goto L95
    L29:
        if (r15.length() == 0) goto L32;
        r18 = false;
        goto L33
    L25:
        r1.put("presend_duration", "0");
        goto L26
    L21:
        r7 = "2";
        goto L22
    L73:
        if ((r23 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.l) == false) goto L92;
        com.bytedance.android.livesdk.gift.platform.business.tray.l r39 = (com.bytedance.android.livesdk.gift.platform.business.tray.l) r23;
        r1.put("tray_type", r39.y());
        if (r39.A() == false) goto L78;
        String r40 = r39.V;
    L84:
        r1.put("content", r40);
        r1.put("gift_id", String.valueOf(r39.b));
        r1.put("gift_cnt", String.valueOf(r39.Y));
        Long r41 = r39.k0;
        if (r41 == null) goto L90;
        String r43 = String.valueOf(r41.longValue());
        if (r43 == null) goto L90;
        r10 = r43;
    L90:
        r1.put("gift_price", r10);
        r1.put("own_send", "2");
        goto L92
    L78:
        if ((r39.R & 2) == 2) goto L81;
        r2 = false;
    L81:
        if (r2 == false) goto L83;
        r40 = r39.W;
        goto L84
    L83:
        r40 = BuildConfig.FLAVOR;
        goto L84
    }

    @JvmStatic
    public static final void R(String r5, com.bytedance.android.livesdk.gift.platform.core.model.b0 r6, int r7, String r8, String r9, int r10) {
        Intrinsics.checkNotNullParameter(r5, "transactionId");
        Intrinsics.checkNotNullParameter(r6, "giftParams");
        Intrinsics.checkNotNullParameter(r9, "isProp");
        Pair[] r0 = new Pair[15];
        boolean r1 = false;
        r0[0] = TuplesKt.to("traceId", r5);
        r0[1] = TuplesKt.to("room_id", String.valueOf(r6.d()));
        r0[2] = TuplesKt.to("gift_id", String.valueOf(r6.b));
        r0[3] = TuplesKt.to("count", String.valueOf(r7));
        r0[4] = TuplesKt.to("buff_level", String.valueOf(r6.l));
        r0[5] = TuplesKt.to("send_type", String.valueOf(r6.f));
        r0[6] = TuplesKt.to("send_scene", String.valueOf(r6.J));
        r0[7] = TuplesKt.to("to_room_id", String.valueOf(r6.e()));
        r0[8] = TuplesKt.to("is_prop", r9);
        r0[9] = TuplesKt.to("group_cnt", String.valueOf(r6.q));
        r0[10] = TuplesKt.to("quick_code", String.valueOf(r10));
        String r11 = "0";
        if (r6.V == false) goto L5;
        String r13 = "1";
    L6:
        r0[11] = TuplesKt.to("is_search_result", r13);
        r0[12] = TuplesKt.to("search_word", r6.W);
        r0[13] = TuplesKt.to("gift_panel_search_id", r6.X);
        String r14 = r6.R;
        if (r14 == null) goto L10;
        r11 = r14;
    L10:
        r0[14] = TuplesKt.to("cluster_name", r11);
        LinkedHashMap r15 = new LinkedHashMap();
        MapsKt.putAll(r15, r0);
        com.bytedance.android.livesdk.gift.platform.core.model.k r16 = r6.Q;
        if (r16 == null) goto L13;
        int r17 = r16.a;
    L14:
        if (r16 == null) goto L16;
        int r18 = r16.b;
    L17:
        r15.put("gift_tab_from", String.valueOf(r18));
        r15.put("gift_position", String.valueOf(r17));
        GiftContext r19 = com.bytedance.android.livesdk.gift.util.b.b();
        Object r20 = null;
        if (r19 == null) goto L22;
        com.bytedance.live.datacontext.n<Bundle> r21 = r19.getGiftLogExtra();
        if (r21 == null) goto L22;
        Bundle r23 = (Bundle) r21.getValue();
    L23:
        String r110 = r6.h;
        if (r110.length() != 0) goto L26;
        boolean r2 = true;
    L28:
        if (r2 == false) goto L34;
        if (r23 == null) goto L32;
        r110 = r23.getString("gift_source");
        if (r110 != null) goto L34;
    L32:
        r110 = BuildConfig.FLAVOR;
    L34:
        if (r110.length() != 0) goto L36;
        r1 = true;
    L36:
        if (r1 == false) goto L38;
        r110 = "gift_tab";
    L38:
        r15.put("gift_source", r110);
        if (r23 == null) goto L45;
        String r24 = r23.getString("gift_show_from");
        if (r24 == null) goto L45;
        if (Intrinsics.areEqual(r24, "bottom_tab") == false) goto L46;
        r24 = "icon";
    L46:
        r15.put("gift_show_from", r24);
        r15.put("send_gift_scene", vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(x12.b.a()));
        i12.e r25 = i12.o.b();
        if (r25 == null) goto L49;
        r20 = com.bytedance.android.scope.m.e.d(r25, SendGiftRelationService.class);
    L49:
        SendGiftRelationService r26 = (SendGiftRelationService) r20;
        if (r26 == null) goto L52;
        r15.put("send_gift_relation", String.valueOf(r26.a(r6.g())));
    L52:
        r15.put("consume_level", String.valueOf(ay1.b.u()));
        r15.put("to_open_id", r6.g());
        if (r8 != null) goto L55;
        r8 = BuildConfig.FLAVOR;
    L55:
        r15.put("to_user_ids", r8);
        r15.put("device_volume", String.valueOf(u.g()));
        r15.put("audience_cnt", String.valueOf(com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getCurrentAudienceCount()));
        GiftContext r27 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r27 == null) goto L67;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.gift.platform.core.d> r28 = r27.getCurrentGiftEffect();
        if (r28 == null) goto L67;
        com.bytedance.android.livesdk.gift.platform.core.d r29 = (com.bytedance.android.livesdk.gift.platform.core.d) r28.getValue();
        if (r29 == null) goto L67;
        r15.put("effect_type", r29.getType().toString());
        h2 r30 = r29.b;
        if (r30 == null) goto L65;
        String r31 = String.valueOf(r30.getId());
        if (r31 == null) goto L65;
    L66:
        r15.put("effect_gift_id", r31);
    L65:
        r31 = "-1";
    L67:
        mz0.n r33 = new mz0.n();
        Map r34 = r33.a;
        Intrinsics.checkNotNullParameter(r34, "map");
        Intrinsics.checkNotNullParameter(r15, "map");
        r34.putAll(r15);
        mz0.m r35 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r36 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r36, "pageSourceLog");
        ((ArrayList) r35.a).add(r36.a);
        r35.b(LogCommon.ROOM);
        ((ArrayList) r33.b).addAll(r35.a);
        cy0.e.a.getClass();
        cy0.j r37 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r38 = com.bytedance.android.scope.m.b(r37).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r38);
        ((f80.a) r38).w3("livesdk_send_gift_request", r33.a, r33.b);
        return;
    L45:
        r24 = BuildConfig.FLAVOR;
        goto L46
    L26:
        r2 = false;
    L22:
        r23 = null;
        goto L23
    L16:
        r18 = 0;
        goto L17
    L13:
        r17 = -1;
        goto L14
    L5:
        r13 = "0";
        goto L6
    }

    @JvmStatic
    public static final void V(int r3, int r4, String r5, DataCenter r6, String r7, IRoom r8) {
        Intrinsics.checkNotNullParameter(r5, "showType");
        Intrinsics.checkNotNullParameter(r7, "toUserId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("gift_tab_from", String.valueOf(r3));
        r0.put("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r3));
        r0.put("tab_show_type", r5);
        gq2.b r9 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).Qc();
        int r1 = 0;
        if (r6 == null) goto L7;
        r9.b();
        Integer r10 = (Integer) r6.get("data_link_state", 0);
        if (r10 == null) goto L7;
        r1 = r10.intValue();
    L7:
        r0.put("send_gift_scene", vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(r1));
        Integer r11 = null;
        if (r8 == null) goto L10;
        String r13 = r8.getAnchorId();
    L12:
        if (r7.equals(r13) == true) goto L14;
        String r14 = "guest";
    L15:
        r0.put("to_user_type", r14);
        r0.put("connection_type", e());
        r0.put("anchor_cnt", com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getLinkAnchorCount());
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f() == 5) goto L18;
    L20:
        String r15 = "0";
    L21:
        r0.put("is_prop_show", r15);
        GiftContext r16 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r16 == null) goto L28;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.gift.platform.core.f0> r17 = r16.getRowLocation();
        if (r17 == null) goto L28;
        com.bytedance.android.livesdk.gift.platform.core.f0 r18 = (com.bytedance.android.livesdk.gift.platform.core.f0) r17.getValue();
        if (r18 == null) goto L28;
        Integer r19 = Integer.valueOf(r18.a);
    L29:
        r0.put("start_row_location", String.valueOf(r19));
        GiftContext r20 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r20 == null) goto L36;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.gift.platform.core.f0> r21 = r20.getRowLocation();
        if (r21 == null) goto L36;
        com.bytedance.android.livesdk.gift.platform.core.f0 r23 = (com.bytedance.android.livesdk.gift.platform.core.f0) r21.getValue();
        if (r23 == null) goto L36;
        r11 = Integer.valueOf(r23.b);
    L36:
        r0.put("end_row_location", String.valueOf(r11));
        if (r3 != r4) goto L39;
        String r24 = "stay";
    L40:
        r0.put("click_type", r24);
        if (com.bytedance.android.livesdk.gift.util.b.b() == null) goto L50;
        GiftContext r25 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r25 == null) goto L48;
        com.bytedance.live.datacontext.m<String> r26 = r25.getGiftListResultLogId();
        if (r26 == null) goto L48;
        String r27 = (String) r26.getValue();
        if (r27 == null) goto L48;
    L49:
        r0.put("gift_dialog_request_id", r27);
    L48:
        r27 = BuildConfig.FLAVOR;
    L50:
        Object r28 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getRevLinkControlService().q();
        if (r28 != null) goto L53;
        r28 = new LinkedHashMap();
    L53:
        r0.putAll(r28);
        mz0.n r29 = new mz0.n();
        Map r30 = r29.a;
        Intrinsics.checkNotNullParameter(r30, "map");
        Intrinsics.checkNotNullParameter(r0, "map");
        r30.putAll(r0);
        mz0.m r31 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r33 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r33, "pageSourceLog");
        ((ArrayList) r31.a).add(r33.a);
        r31.b(LogCommon.ROOM);
        ((ArrayList) r29.b).addAll(r31.a);
        cy0.e.a.getClass();
        cy0.j r34 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r35 = com.bytedance.android.scope.m.b(r34).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r35);
        ((f80.a) r35).w3("livesdk_gift_tab_click", r29.a, r29.b);
        return;
    L39:
        r24 = "change";
    L28:
        r19 = null;
        goto L29
    L18:
        if ((!com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.c().isEmpty()) == false) goto L20;
        r15 = "1";
        goto L21
    L14:
        r14 = "anchor";
        goto L15
    L10:
        r13 = null;
        goto L12
    }

    @JvmStatic
    public static final void u(long r2, int r4, String r5, int r6, int r7, long r8) {
        Intrinsics.checkNotNullParameter(r5, "baseVersion");
        Pair[] r0 = {TuplesKt.to("asset_id", String.valueOf(r2)), TuplesKt.to("assets_size", String.valueOf(r7)), TuplesKt.to("base_count", String.valueOf(r4)), TuplesKt.to("update_count", String.valueOf(r6)), TuplesKt.to("base_version", r5)};
        LinkedHashMap r3 = new LinkedHashMap();
        MapsKt.putAll(r3, r0);
        long r9 = 0;
        if (r8 <= 0) goto L5;
        r3.put("last_batch_fetch_time_stamp", String.valueOf(System.currentTimeMillis() - r8));
    L6:
        yz0.k r10 = g();
        if (r10 == null) goto L9;
        r9 = r10.Hl();
    L9:
        r3.put("enter_time", String.valueOf(System.currentTimeMillis() - r9));
        mz0.n r11 = new mz0.n();
        Map r13 = r11.a;
        Intrinsics.checkNotNullParameter(r13, "map");
        Intrinsics.checkNotNullParameter(r3, "map");
        r13.putAll(r3);
        mz0.m r14 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r15 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r15, "pageSourceLog");
        ((ArrayList) r14.a).add(r15.a);
        r14.b(LogCommon.ROOM);
        ((ArrayList) r11.b).addAll(r14.a);
        cy0.e.a.getClass();
        cy0.j r16 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r17 = com.bytedance.android.scope.m.b(r16).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r17);
        ((f80.a) r17).w3("livesdk_find_asset_fail", r11.a, r11.b);
        return;
    L5:
        r3.put("last_batch_fetch_time_stamp", "-1");
        goto L6
    }

    @JvmStatic
    public static final void G(long r25, boolean r27, boolean r28, AbsPanel.GiftPanelIconSource r29, String r30, List r31, IBaseUser r33) {
        Intrinsics.checkNotNullParameter(r29, "iconSource");
        Intrinsics.checkNotNullParameter(r33, "toUser");
        String r3 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString();
        GiftContext r5 = com.bytedance.android.livesdk.gift.util.b.b();
        int r6 = 0;
        if (r5 == null) goto L9;
        com.bytedance.live.datacontext.n<Integer> r7 = r5.getCurrentSelectedGiftPosition();
        if (r7 == null) goto L9;
        Integer r8 = (Integer) r7.getValue();
        if (r8 == null) goto L9;
        int r9 = r8.intValue();
    L11:
        if (t.b() == false) goto L13;
        int r10 = r9 / 4;
    L14:
        int r11 = r10 + 1;
        int r13 = (r9 % 4) + 1;
        k();
        int r14 = r9 + 1;
        int r15 = r14 % 8;
        if (r15 != 0) goto L17;
        int r16 = 0;
    L18:
        Pair[] r17 = new Pair[11];
        r17[0] = TuplesKt.to("user_id", r3.toString());
        r17[1] = TuplesKt.to("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f()));
        r17[2] = TuplesKt.to("tab_location", String.valueOf(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.h() + 1));
        r17[3] = TuplesKt.to("page_location", String.valueOf((r14 / 8) + r16));
        int[] r18 = b;
        if (r16 != 0) goto L21;
        r15 = 8;
    L21:
        r17[4] = TuplesKt.to("gift_location", String.valueOf(r18[r15]));
        GiftContext r19 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r19 == null) goto L27;
        com.bytedance.live.datacontext.m<String> r20 = r19.getGiftListResultLogId();
        if (r20 == null) goto L27;
        String r21 = (String) r20.getValue();
        if (r21 == null) goto L27;
    L28:
        r17[5] = TuplesKt.to("gift_dialog_request_id", r21);
        r17[6] = TuplesKt.to("gift_row_location", String.valueOf(r11));
        r17[7] = TuplesKt.to("gift_column_location", String.valueOf(r13));
        r17[8] = TuplesKt.to("order_type", tz1.a.b());
        r17[9] = TuplesKt.to("click_entrance", "gift_tab");
        String r23 = "0";
        r17[10] = TuplesKt.to("customize", "0");
        LinkedHashMap r4 = new LinkedHashMap();
        MapsKt.putAll(r4, r17);
        if (tz1.a.d(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f()) == false) goto L31;
        r4.put("order_type", tz1.a.b());
    L31:
        if (r28 == false) goto L66;
        StringCompanionObject r24 = StringCompanionObject.INSTANCE;
        Object[] r26 = new Object[1];
        GiftContext r34 = com.bytedance.android.livesdk.gift.util.b.b();
        Long r110 = null;
        if (r34 == null) goto L37;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.gift.platform.core.i> r35 = r34.getLastEventTimeStamp();
        if (r35 == null) goto L37;
        com.bytedance.android.livesdk.gift.platform.core.i r111 = (com.bytedance.android.livesdk.gift.platform.core.i) r35.getValue();
    L39:
        if (r111 == null) goto L48;
        Long r36 = Long.valueOf(r111.c);
        if (r36.longValue() == 0) goto L43;
        boolean r112 = true;
    L44:
        if (r112 == true) goto L47;
        r36 = null;
    L47:
        if (r36 == null) goto L48;
    L54:
        r110 = r36;
    L55:
        if (r110 == null) goto L57;
        long r113 = r110.longValue();
    L58:
        long r210 = r113;
        long r211 = System.currentTimeMillis();
        if (r111 == null) goto L65;
        com.bytedance.android.livesdk.gift.platform.core.i r37 = com.bytedance.android.livesdk.gift.platform.core.i.a(r111, 0, r211, 0, 0, 27);
        GiftContext r114 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r114 == null) goto L65;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.gift.platform.core.i> r115 = r114.getLastEventTimeStamp();
        if (r115 == null) goto L65;
        r115.setValue(r37);
    L65:
        r26[0] = Double.valueOf(((r211 - r210) * 1.0d) / ((double) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW));
        r4.put("gift_click_time", String.format("%.1f", Arrays.copyOf(r26, 1)));
        goto L66
    L57:
        r113 = System.currentTimeMillis();
        goto L58
    L43:
        r112 = false;
    L48:
        if (r111 == null) goto L55;
        r36 = Long.valueOf(r111.a);
        if (r36.longValue() == 0) goto L52;
        boolean r116 = true;
    L53:
        if (r116 == false) goto L55;
    L52:
        r116 = false;
    L37:
        r111 = null;
    L66:
        b0(r27, r4, r25);
        r4.put("to_user_status", i.c(r33.getIdString()));
        r4.put("connection_type", e());
        if (r29 != AbsPanel.GiftPanelIconSource.DIY_CARD) goto L69;
        String r2 = "1";
    L70:
        r4.put("operation_icon", r2);
        String r38 = "null";
        if (r30 != null) goto L73;
        String r39 = "null";
    L74:
        r4.put("card_name", r39);
        List r40 = i.b(r31);
        if (r40 == null) goto L80;
        String r41 = r40.toString();
        if (r41 == null) goto L80;
        r38 = r41;
    L80:
        r4.put(com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS, r38);
        yz0.k r43 = g();
        if (r43 == null) goto L90;
        IBaseUser r44 = r43.getUser();
        if (r44 == null) goto L90;
        py.d r45 = r44.getUserHonor();
        if (r45 == null) goto L90;
        String r46 = String.valueOf(r45.getLevel());
        if (r46 == null) goto L90;
        r23 = r46;
    L90:
        r4.put("privilege_level", r23);
        h1 r0 = ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).findGiftById(r25);
        if (r0 == null) goto L93;
        r6 = r0.getGiftSource();
    L93:
        r4.put("gift_creation_source", String.valueOf(r6));
        mz0.n r1 = new mz0.n();
        Map r47 = r1.a;
        Intrinsics.checkNotNullParameter(r47, "map");
        Intrinsics.checkNotNullParameter(r4, "map");
        r47.putAll(r4);
        mz0.m r48 = new mz0.m();
        r48.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r49 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r49, "pageSourceLog");
        ((ArrayList) r48.a).add(r49.a);
        ((ArrayList) r1.b).addAll(r48.a);
        cy0.e.a.getClass();
        cy0.j r50 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r51 = com.bytedance.android.scope.m.b(r50).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r51);
        ((f80.a) r51).w3("livesdk_gift_double_click", r1.a, r1.b);
        return;
    L73:
        r39 = r30;
        goto L74
    L69:
        r2 = "0";
    L27:
        r21 = BuildConfig.FLAVOR;
        goto L28
    L17:
        r16 = 1;
        goto L18
    L13:
        r10 = (r9 % 8) / 4;
    L9:
        r9 = 0;
        goto L11
    }

    @JvmStatic
    public static final void H(long r17, boolean r19, int r20, int r21, boolean r23, long r24, long r25) {
        if (r17 > 0) goto L5;
        return;
    L5:
        String r3 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString();
        int r4 = r21 + 1;
        int r5 = r4 % 8;
        int r6 = 0;
        if (r5 != 0) goto L8;
        int r8 = 0;
    L10:
        if (t.b() == false) goto L12;
        int r9 = r21 / 4;
    L13:
        int r10 = r9 + 1;
        int r11 = (r21 % 4) + 1;
        k();
        String r13 = ay1.b.l().get(String.valueOf(r17));
        int r14 = x12.b.a();
        Pair[] r15 = new Pair[13];
        r15[0] = TuplesKt.to("user_id", r3.toString());
        r15[1] = TuplesKt.to("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r20));
        List<w1> r7 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.k();
        int r16 = ((ArrayList) r7).size();
    L14:
        if (r6 >= r16) goto L19;
        if (((w1) ListProtector.get(r7, r6)).getPageType() == r20) goto L20;
        r6 = r6 + 1;
    L20:
        r15[2] = TuplesKt.to("tab_location", String.valueOf(r6 + 1));
        r15[3] = TuplesKt.to("page_location", String.valueOf((r4 / 8) + r8));
        int[] r18 = b;
        if (r8 != 0) goto L23;
        r5 = 8;
    L23:
        r15[4] = TuplesKt.to("gift_location", String.valueOf(r18[r5]));
        GiftContext r26 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r26 == null) goto L29;
        com.bytedance.live.datacontext.m<String> r27 = r26.getGiftListResultLogId();
        if (r27 == null) goto L29;
        String r28 = (String) r27.getValue();
        if (r28 == null) goto L29;
    L30:
        r15[5] = TuplesKt.to("gift_dialog_request_id", r28);
        if (r23 == false) goto L33;
        String r29 = "light_sweep";
    L34:
        r15[6] = TuplesKt.to("show_mode", r29);
        r15[7] = TuplesKt.to("gift_row_location", String.valueOf(r10));
        r15[8] = TuplesKt.to("gift_column_location", String.valueOf(r11));
        r15[9] = TuplesKt.to("show_gift_scene", vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(r14));
        r15[10] = TuplesKt.to("appear_time", String.valueOf(r24));
        r15[11] = TuplesKt.to("disappear_time", String.valueOf(r25));
        r15[12] = TuplesKt.to("time_interval", String.valueOf(r25 - r24));
        LinkedHashMap r2 = new LinkedHashMap();
        MapsKt.putAll(r2, r15);
        Map<Integer, Integer> r30 = tz1.a.a;
        if (tz1.a.d(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f()) == false) goto L37;
        r2.put("order_type", tz1.a.b());
    L37:
        GiftManagerKt.z.getClass();
        Map r31 = GiftManagerKt.o();
        if (r31 != null) goto L40;
    L43:
        boolean r33 = true;
    L44:
        if (r33 == true) goto L49;
        Map r34 = GiftManagerKt.o();
        if (r34 == null) goto L49;
        r2.putAll(r34);
    L49:
        if (((com.bytedance.android.livesdk.gift.platform.business.config.n) com.bytedance.android.livesdk.gift.util.b.a().d(com.bytedance.android.livesdk.gift.platform.business.config.n.class)).f() == 0) goto L51;
        String r35 = "scroll";
    L52:
        r2.put("gift_show_type", r35);
        if (r13 == null) goto L55;
        r2.put("light_sweep_cnt", r13);
    L55:
        b0(r19, r2, r17);
        r2.put("connection_type", e());
        mz0.n r0 = new mz0.n();
        Map r1 = r0.a;
        Intrinsics.checkNotNullParameter(r1, "map");
        Intrinsics.checkNotNullParameter(r2, "map");
        r1.putAll(r2);
        mz0.m r36 = new mz0.m();
        r36.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r37 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r37, "pageSourceLog");
        List r38 = r36.a;
        ArrayList r39 = (ArrayList) r38;
        r39.add(r37.a);
        List r40 = r0.b;
        ArrayList r41 = (ArrayList) r40;
        r41.addAll(r36.a);
        cy0.e.a.getClass();
        cy0.j r43 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r44 = com.bytedance.android.scope.m.b(r43).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r44);
        ((f80.a) r44).w3("livesdk_distinct_gift_show_for_strategy", r0.a, r0.b);
        return;
    L51:
        r35 = "slide";
        goto L52
    L40:
        if (r31.isEmpty() == true) goto L43;
        r33 = false;
        goto L44
    L33:
        r29 = "normal";
    L29:
        r28 = BuildConfig.FLAVOR;
        goto L30
    L19:
        r6 = 0;
        goto L20
    L12:
        r9 = (r21 % 8) / 4;
        goto L13
    L8:
        r8 = 1;
        goto L10
    }

    @JvmStatic
    public static final void T(String r3, long r4, String r6, long r7, long r9, Throwable r11, boolean r13) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r6, "giftIds");
        Pair[] r1 = new Pair[7];
        r1[0] = TuplesKt.to("request_source", r3);
        r1[1] = TuplesKt.to("giftIds", r6);
        r1[2] = TuplesKt.to("duration", String.valueOf(r4));
        if (r11 != null) goto L5;
        String r5 = "0";
    L6:
        r1[3] = TuplesKt.to("error_code", r5);
        r1[4] = TuplesKt.to("to_room", String.valueOf(r7));
        r1[5] = TuplesKt.to("from_room", String.valueOf(r9));
        r1[6] = TuplesKt.to("use_uplink", String.valueOf(r13));
        LinkedHashMap r8 = new LinkedHashMap();
        MapsKt.putAll(r8, r1);
        mz0.n r10 = new mz0.n();
        Map r14 = r10.a;
        Intrinsics.checkNotNullParameter(r14, "map");
        Intrinsics.checkNotNullParameter(r8, "map");
        r14.putAll(r8);
        mz0.m r15 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r16 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r16, "pageSourceLog");
        List r17 = r15.a;
        ArrayList r18 = (ArrayList) r17;
        r18.add(r16.a);
        r15.b(LogCommon.ROOM);
        List r19 = r10.b;
        ArrayList r20 = (ArrayList) r19;
        r20.addAll(r15.a);
        cy0.e.a.getClass();
        cy0.j r21 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r23 = com.bytedance.android.scope.m.b(r21).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r23);
        ((f80.a) r23).w3("livesdk_fetch_gift_extra", r10.a, r10.b);
        return;
    L5:
        r5 = "1";
        goto L6
    }

    @JvmStatic
    public static final void N(IRoom r16, int r17, int r18, String r19, int r20, int r21, int r23, int r24) {
        Intrinsics.checkNotNullParameter(r19, "giftSeen");
        Intrinsics.checkNotNullParameter("click", "switchFrom");
        LinkedHashMap r3 = new LinkedHashMap();
        String r5 = BuildConfig.FLAVOR;
        if (r16 == null) goto L8;
        String r6 = r16.getAnchorId();
        if (r6 != null) goto L7;
        r6 = BuildConfig.FLAVOR;
    L7:
        r3.put("anchor_id", r6);
        r3.put("room_id", String.valueOf(r16.getId()));
    L8:
        r3.put("switch_from", "click");
        r3.put("page", String.valueOf(r17));
        r3.put("pageType", String.valueOf(r20));
        r3.put("gift_seen", r19);
        r3.put("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r20));
        r3.put("from_tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r21));
        if (r20 != r21) goto L11;
        String r0 = "0";
    L12:
        r3.put("is_tab_switch", r0);
        boolean r1 = true;
        r3.put("tab_location", String.valueOf(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.h() + 1));
        r3.put("from_page", String.valueOf(r18 + 1));
        GiftContext r2 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r2 == null) goto L20;
        com.bytedance.live.datacontext.m<String> r4 = r2.getGiftListResultLogId();
        if (r4 == null) goto L20;
        String r7 = (String) r4.getValue();
        if (r7 == null) goto L20;
        r5 = r7;
    L20:
        r3.put("gift_dialog_request_id", r5);
        GiftContext r8 = com.bytedance.android.livesdk.gift.util.b.b();
        Long r9 = null;
        if (r8 == null) goto L25;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.gift.platform.core.i> r10 = r8.getLastEventTimeStamp();
        if (r10 == null) goto L25;
        com.bytedance.android.livesdk.gift.platform.core.i r11 = (com.bytedance.android.livesdk.gift.platform.core.i) r10.getValue();
    L27:
        if (r11 == null) goto L36;
        Long r13 = Long.valueOf(r11.e);
        if (r13.longValue() == 0) goto L31;
        boolean r14 = true;
    L32:
        if (r14 == true) goto L35;
        r13 = null;
    L35:
        if (r13 == null) goto L36;
    L42:
        r9 = r13;
    L43:
        if (r9 == null) goto L45;
        long r15 = r9.longValue();
    L46:
        long r110 = System.currentTimeMillis();
        if (r11 == null) goto L53;
        com.bytedance.android.livesdk.gift.platform.core.i r25 = com.bytedance.android.livesdk.gift.platform.core.i.a(r11, 0, 0, 0, r110, 15);
        GiftContext r26 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r26 == null) goto L53;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.gift.platform.core.i> r27 = r26.getLastEventTimeStamp();
        if (r27 == null) goto L53;
        r27.setValue(r25);
    L53:
        r3.put("switch_time", String.valueOf(((r110 - r15) * 1.0d) / ((double) IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW)));
        r3.put("switch_rows", String.valueOf(r23));
        r3.put("switch_gift_num", String.valueOf(r24));
        Object r28 = com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getRevLinkControlService().q();
        if (r28 != null) goto L56;
        r28 = new LinkedHashMap();
    L56:
        r3.putAll(r28);
        mz0.n r29 = new mz0.n();
        Map r30 = r29.a;
        Intrinsics.checkNotNullParameter(r30, "map");
        Intrinsics.checkNotNullParameter(r3, "map");
        r30.putAll(r3);
        mz0.m r31 = new mz0.m();
        r31.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r33 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r33, "pageSourceLog");
        ((ArrayList) r31.a).add(r33.a);
        ((ArrayList) r29.b).addAll(r31.a);
        cy0.e.a.getClass();
        cy0.j r34 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r35 = com.bytedance.android.scope.m.b(r34).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r35);
        ((f80.a) r35).w3("livesdk_gift_pages_show", r29.a, r29.b);
        return;
    L45:
        r15 = System.currentTimeMillis();
        goto L46
    L31:
        r14 = false;
    L36:
        if (r11 == null) goto L43;
        r13 = Long.valueOf(r11.a);
        if (r13.longValue() != 0) goto L41;
        r1 = false;
    L41:
        if (r1 == false) goto L43;
    L25:
        r11 = null;
        goto L27
    L11:
        r0 = "1";
        goto L12
    }

    @JvmStatic
    public static final void v(Object r18, int r19, int r20, DataCenter r21, IBaseUser r23, AbsPanel.GiftPanelIconSource r24, String r25, List<Integer> r26) {
        Object r0 = r18;
        Intrinsics.checkNotNullParameter(r24, "iconSource");
        boolean r3 = true;
        int r4 = r20 + 1;
        if (r0 == null) goto L114;
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("show_type", "call");
        IRoom r7 = null;
        if ((r0 instanceof h1) == true) goto L7;
        Object r6 = null;
    L8:
        h1 r8 = (h1) r6;
        String r9 = "0";
        String r10 = BuildConfig.FLAVOR;
        if (r8 == null) goto L31;
        r5.put("gift_id", String.valueOf(r8.getId()));
        r5.put("money", String.valueOf(r8.getDiamondCount()));
        py.k r14 = r8.getLeftLogo();
        if (r14 == null) goto L14;
        String r15 = r14.getUri();
        if (r15 == null) goto L14;
    L15:
        r5.put("corner_mark", r15);
        GiftMsgBoard r16 = r8.getGiftMsgBoard();
        if (r16 != null) goto L18;
    L20:
        k0 r11 = r8.getGiftPreviewInfo();
        if (r11 != null) goto L23;
    L25:
        boolean r13 = false;
    L26:
        if (r13 == false) goto L28;
        Object r17 = "1";
    L29:
        r5.put("gift_unlock_status", r17);
        goto L31
    L28:
        r17 = "0";
        goto L29
    L23:
        if (r11.getLockStatus() != k0.UNLOCKED) goto L25;
        r13 = true;
        goto L26
    L18:
        if (r16.forMsgBoard != true) goto L20;
        r5.put("is_message", "1");
    L14:
        r15 = BuildConfig.FLAVOR;
    L31:
        if ((r0 instanceof l2) == true) goto L33;
        r0 = null;
    L33:
        l2 r1 = (l2) r0;
        if (r1 == null) goto L38;
        r5.put("prop_id", String.valueOf(r1.getId()));
        r5.put("gift_id", String.valueOf(r1.getGift().getId()));
        r5.put("money", String.valueOf(r1.getDiamond()));
        if (r1.getPropType() != 5) goto L38;
        r5.put("recharge_vou_type", "cashback_coupon");
    L38:
        r5.put("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r19));
        GiftContext r2 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r2 == null) goto L46;
        com.bytedance.live.datacontext.m<String> r27 = r2.getGiftListResultLogId();
        if (r27 == null) goto L46;
        String r28 = (String) r27.getValue();
        if (r28 == null) goto L46;
        r10 = r28;
    L46:
        r5.put("gift_dialog_request_id", r10);
        r5.put("gift_tab_from", String.valueOf(r19));
        r5.put("tab_location", String.valueOf(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.h() + 1));
        int r29 = r4 % 8;
        if (r29 != 0) goto L49;
        int r30 = 0;
    L50:
        r5.put("page_location", String.valueOf((r4 / 8) + r30));
        int[] r31 = b;
        if (r30 != 0) goto L53;
        r29 = 8;
    L53:
        r5.put("gift_location", String.valueOf(r31[r29]));
        gq2.b r33 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).Qc();
        if (r21 == null) goto L58;
        r33.b();
        Integer r34 = (Integer) r21.get("data_link_state", 0);
        if (r34 == null) goto L58;
        int r35 = r34.intValue();
    L59:
        r5.put("send_gift_scene", vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(r35));
        if (r21 == null) goto L62;
        r7 = (IRoom) r21.get("data_room", vh7.f.c(IRoom.class));
    L62:
        if (r23 == null) goto L67;
        if (r7 == null) goto L67;
        if ((!Intrinsics.areEqual(r23.getIdString(), r7.getAnchorId())) == false) goto L67;
        String r36 = "guest";
    L68:
        r5.put("to_user_type", r36);
        if (r23 == null) goto L71;
        String r37 = i.c(r23.getIdString());
    L72:
        r5.put("to_user_status", r37);
        r5.put("connection_type", e());
        r5.put("anchor_cnt", com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getLinkAnchorCount());
        StringCompanionObject r38 = StringCompanionObject.INSTANCE;
        r5.put("gift_click_time", String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(e0())}, 1)));
        if (r24 != AbsPanel.GiftPanelIconSource.DIY_CARD) goto L75;
        r9 = "1";
    L75:
        r5.put("operation_icon", r9);
        String r39 = "null";
        if (r25 != null) goto L78;
        String r40 = "null";
    L79:
        r5.put("card_name", r40);
        if (r26 != null) goto L82;
    L85:
        boolean r41 = true;
    L86:
        if (r41 == true) goto L89;
        r39 = r26.toString();
    L89:
        r5.put(com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS, r39);
        vh6.c.b(kr2.a.class).appendCastSDKLogCommonParams(r5);
        r5.put("is_screencasting", m2.b(ay1.b.p()));
        if (u.n() == false) goto L98;
        com.bytedance.android.live.revenue.core.a r43 = com.bytedance.android.live.revenue.core.util.k.a();
        if (r43 == null) goto L115;
        n01.a r44 = com.bytedance.android.live.revenue.core.util.f.c(r43, n01.a.class);
        if (r44 == null) goto L116;
        es2.a r45 = r44.E0();
        if (r45 == null) goto L117;
        r45.sendLog("gift_preview", r5);
        return;
    L117:
        return;
    L116:
        return;
    L115:
        return;
    L98:
        GiftManagerKt.z.getClass();
        Map r46 = GiftManagerKt.o();
        if (r46 != null) goto L101;
    L104:
        if (r3 == true) goto L109;
        Map r47 = GiftManagerKt.o();
        if (r47 == null) goto L109;
        r5.putAll(r47);
    L109:
        if (((com.bytedance.android.livesdk.gift.platform.business.config.n) com.bytedance.android.livesdk.gift.util.b.a().d(com.bytedance.android.livesdk.gift.platform.business.config.n.class)).f() == 0) goto L111;
        String r48 = "scroll";
    L112:
        r5.put("gift_show_type", r48);
        mz0.n r49 = new mz0.n();
        Map r50 = r49.a;
        Intrinsics.checkNotNullParameter(r50, "map");
        Intrinsics.checkNotNullParameter(r5, "map");
        r50.putAll(r5);
        mz0.m r51 = new mz0.m();
        r51.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r53 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r53, "pageSourceLog");
        ((ArrayList) r51.a).add(r53.a);
        ((ArrayList) r49.b).addAll(r51.a);
        cy0.e.a.getClass();
        cy0.j r54 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r55 = com.bytedance.android.scope.m.b(r54).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r55);
        ((f80.a) r55).w3("livesdk_gift_preview", r49.a, r49.b);
        return;
    L111:
        r48 = "slide";
        goto L112
    L101:
        if (r46.isEmpty() == true) goto L104;
        r3 = false;
        goto L104
    L82:
        if (r26.isEmpty() == true) goto L85;
        r41 = false;
        goto L86
    L78:
        r40 = r25;
        goto L79
    L71:
        r37 = String.valueOf(2);
    L67:
        r36 = "anchor";
    L58:
        r35 = 0;
        goto L59
    L49:
        r30 = 1;
        goto L50
    L7:
        r6 = r0;
        goto L8
    }

    @JvmStatic
    public static final void E(IRoom r21, Object r23, int r24, DataCenter r25, IBaseUser r26, boolean r27, AbsPanel.GiftPanelIconSource r28, String r29, List<Integer> r210) {
        Object r0 = r23;
        Intrinsics.checkNotNullParameter(r28, "iconSource");
        if (r0 != null) goto L5;
        return;
    L5:
        if (t.b() == false) goto L7;
        int r3 = r24 / 4;
    L8:
        boolean r4 = true;
        k();
        Pair[] r6 = {TuplesKt.to("show_type", "click"), TuplesKt.to("gift_row_location", String.valueOf(r3 + 1)), TuplesKt.to("gift_column_location", String.valueOf((r24 % 4) + 1))};
        LinkedHashMap r5 = new LinkedHashMap();
        MapsKt.putAll(r5, r6);
        String r7 = BuildConfig.FLAVOR;
        if (r21 == null) goto L14;
        String r8 = r21.getAnchorId();
        if (r8 != null) goto L13;
        r8 = BuildConfig.FLAVOR;
    L13:
        r5.put("anchor_id", r8);
        r5.put("room_id", String.valueOf(r21.getId()));
    L14:
        r5.put("gift_tab_from", String.valueOf(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f()));
        r5.put("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f()));
        int r9 = r24 + 1;
        if ((r0 instanceof h1) == true) goto L17;
        Object r10 = null;
    L18:
        h1 r11 = (h1) r10;
        String r13 = "0";
        if (r11 == null) goto L40;
        String r15 = String.valueOf(r11.getId());
        r5.put("gift_id", r15);
        r5.put("money", String.valueOf(r11.getDiamondCount()));
        py.k r14 = r11.getLeftLogo();
        if (r14 == null) goto L24;
        String r16 = r14.getUri();
        if (r16 == null) goto L24;
    L25:
        r5.put("corner_mark", r16);
        GiftMsgBoard r17 = r11.getGiftMsgBoard();
        if (r17 != null) goto L28;
    L30:
        k0 r18 = r11.getGiftPreviewInfo();
        if (r18 != null) goto L33;
    L35:
        boolean r19 = false;
    L36:
        if (r19 == false) goto L38;
        Object r20 = "1";
    L39:
        r5.put("gift_unlock_status", r20);
        r5.put("gift_creation_source", String.valueOf(r11.getGiftSource()));
        r5.put("gift_type", String.valueOf(r11.getType()));
    L42:
        if ((r0 instanceof l2) == true) goto L44;
        r0 = null;
    L44:
        l2 r1 = (l2) r0;
        if (r1 == null) goto L49;
        r15 = String.valueOf(r1.getId());
        r5.put("prop_id", r15);
        r5.put("gift_id", String.valueOf(r1.getGift().getId()));
        r5.put("money", String.valueOf(r1.getDiamond()));
        if (r1.getPropType() != 5) goto L49;
        r5.put("recharge_vou_type", "cashback_coupon");
    L49:
        GiftContext r2 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r2 == null) goto L57;
        com.bytedance.live.datacontext.m<String> r30 = r2.getGiftListResultLogId();
        if (r30 == null) goto L57;
        String r31 = (String) r30.getValue();
        if (r31 == null) goto L57;
        r7 = r31;
    L57:
        r5.put("gift_dialog_request_id", r7);
        r5.put("tab_location", String.valueOf(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.h() + 1));
        int r33 = r9 % 8;
        if (r33 != 0) goto L60;
        int r34 = 0;
    L61:
        r5.put("page_location", String.valueOf((r9 / 8) + r34));
        int[] r35 = b;
        if (r34 != 0) goto L64;
        r33 = 8;
    L64:
        r5.put("gift_location", String.valueOf(r35[r33]));
        gq2.b r36 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).Qc();
        if (r25 == null) goto L69;
        r36.b();
        Integer r37 = (Integer) r25.get("data_link_state", 0);
        if (r37 == null) goto L69;
        int r38 = r37.intValue();
    L70:
        r5.put("send_gift_scene", vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(r38));
        if (r26 == null) goto L76;
        if (r21 == null) goto L76;
        if ((!Intrinsics.areEqual(r26.getIdString(), r21.getAnchorId())) == false) goto L76;
        String r39 = "guest";
    L77:
        r5.put("to_user_type", r39);
        r5.put("connection_type", e());
        StringCompanionObject r40 = StringCompanionObject.INSTANCE;
        r5.put("gift_click_time", String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(e0())}, 1)));
        r5.put("anchor_cnt", com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getLinkAnchorCount());
        Map<Integer, Integer> r41 = tz1.a.a;
        if (tz1.a.d(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f()) == false) goto L80;
        r5.put("order_type", tz1.a.b());
    L80:
        if (r27 == false) goto L82;
        String r43 = "dynamic";
    L83:
        r5.put("preview_mode", r43);
        String r44 = ay1.b.l().get(r15);
        if (r44 == null) goto L86;
        r5.put("light_sweep_cnt", r44);
    L86:
        if (r26 == null) goto L88;
        String r45 = i.c(r26.getIdString());
    L89:
        r5.put("to_user_status", r45);
        r5.put("connection_type", e());
        if (r28 != AbsPanel.GiftPanelIconSource.DIY_CARD) goto L92;
        r13 = "1";
    L92:
        r5.put("operation_icon", r13);
        String r46 = "null";
        if (r29 != null) goto L95;
        String r47 = "null";
    L96:
        r5.put("card_name", r47);
        if (r210 != null) goto L99;
    L102:
        boolean r48 = true;
    L103:
        if (r48 == true) goto L106;
        r46 = r210.toString();
    L106:
        r5.put(com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS, r46);
        vh6.c.b(kr2.a.class).appendCastSDKLogCommonParams(r5);
        r5.put("is_screencasting", m2.b(ay1.b.p()));
        if (u.n() == false) goto L115;
        com.bytedance.android.live.revenue.core.a r49 = com.bytedance.android.live.revenue.core.util.k.a();
        if (r49 == null) goto L132;
        n01.a r50 = com.bytedance.android.live.revenue.core.util.f.c(r49, n01.a.class);
        if (r50 == null) goto L133;
        es2.a r51 = r50.E0();
        if (r51 == null) goto L134;
        r51.sendLog("gift_preview", r5);
        return;
    L134:
        return;
    L133:
        return;
    L132:
        return;
    L115:
        GiftManagerKt.z.getClass();
        Map r53 = GiftManagerKt.o();
        if (r53 != null) goto L118;
    L121:
        if (r4 == true) goto L126;
        Map r54 = GiftManagerKt.o();
        if (r54 == null) goto L126;
        r5.putAll(r54);
    L126:
        if (((com.bytedance.android.livesdk.gift.platform.business.config.n) com.bytedance.android.livesdk.gift.util.b.a().d(com.bytedance.android.livesdk.gift.platform.business.config.n.class)).f() == 0) goto L128;
        String r55 = "scroll";
    L129:
        r5.put("gift_show_type", r55);
        mz0.n r56 = new mz0.n();
        Map r57 = r56.a;
        Intrinsics.checkNotNullParameter(r57, "map");
        Intrinsics.checkNotNullParameter(r5, "map");
        r57.putAll(r5);
        mz0.m r58 = new mz0.m();
        r58.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r59 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r59, "pageSourceLog");
        ((ArrayList) r58.a).add(r59.a);
        ((ArrayList) r56.b).addAll(r58.a);
        cy0.e.a.getClass();
        cy0.j r60 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r61 = com.bytedance.android.scope.m.b(r60).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r61);
        ((f80.a) r61).w3("livesdk_gift_preview", r56.a, r56.b);
        return;
    L128:
        r55 = "slide";
        goto L129
    L118:
        if (r53.isEmpty() == true) goto L121;
        r4 = false;
        goto L121
    L99:
        if (r210.isEmpty() == true) goto L102;
        r48 = false;
        goto L103
    L95:
        r47 = r29;
        goto L96
    L88:
        r45 = String.valueOf(2);
        goto L89
    L82:
        r43 = "static";
    L76:
        r39 = "anchor";
    L69:
        r38 = 0;
        goto L70
    L60:
        r34 = 1;
        goto L61
    L38:
        r20 = "0";
        goto L39
    L33:
        if (r18.getLockStatus() != k0.UNLOCKED) goto L35;
        r19 = true;
        goto L36
    L28:
        if (r17.forMsgBoard != true) goto L30;
        r5.put("is_message", "1");
    L24:
        r16 = BuildConfig.FLAVOR;
        goto L25
    L40:
        r15 = BuildConfig.FLAVOR;
        goto L42
    L17:
        r10 = r0;
        goto L18
    L7:
        r3 = (r24 % 8) / 4;
        goto L8
    }

    @JvmStatic
    public static final void U(int r3, long r4, long r6, long r8, int r10, int r11, Map<String, String> r13, Long r14, int r15) {
        Pair[] r0 = {TuplesKt.to("source", String.valueOf(r3)), TuplesKt.to("api_duration", String.valueOf(r6 - r4)), TuplesKt.to("schedule_duration", String.valueOf(r8 - r6)), TuplesKt.to("handle_resp_duration", String.valueOf(System.currentTimeMillis() - r8)), TuplesKt.to("sync_duration", String.valueOf(System.currentTimeMillis() - r4)), TuplesKt.to("req_times", String.valueOf(r10))};
        LinkedHashMap r5 = new LinkedHashMap();
        MapsKt.putAll(r5, r0);
        if (r11 == 0) goto L5;
        r5.put("template", String.valueOf(r11));
    L14:
        if (r13 != null) goto L16;
    L18:
        String r7 = BuildConfig.FLAVOR;
        Object r16 = r14;
        if (r14 != null) goto L21;
        r16 = BuildConfig.FLAVOR;
    L21:
        r5.put("fetch_strategy", r16.toString());
        r5.put("fetch_action", String.valueOf(r15));
        SendGiftRelationService r9 = (SendGiftRelationService) com.bytedance.android.live.revenue.core.util.f.a(SendGiftRelationService.class);
        yz0.k r17 = g();
        if (r17 == null) goto L29;
        IRoom r18 = r17.getRoom();
        if (r18 == null) goto L29;
        String r19 = r18.getAnchorId();
        if (r19 == null) goto L29;
        r7 = r19;
    L29:
        r5.put("send_gift_relation", String.valueOf(r9.a(r7)));
        yz0.k r20 = g();
        if (r20 == null) goto L32;
        long r21 = r20.Hl();
    L33:
        r5.put("enter_time", String.valueOf(r4 - r21));
        mz0.n r23 = new mz0.n();
        Map r24 = r23.a;
        Intrinsics.checkNotNullParameter(r24, "map");
        Intrinsics.checkNotNullParameter(r5, "map");
        r24.putAll(r5);
        mz0.m r25 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r26 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r26, "pageSourceLog");
        ((ArrayList) r25.a).add(r26.a);
        r25.b(LogCommon.ROOM);
        ((ArrayList) r23.b).addAll(r25.a);
        cy0.e.a.getClass();
        cy0.j r27 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r28 = com.bytedance.android.scope.m.b(r27).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r28);
        ((f80.a) r28).w3("livesdk_fetch_gift_list", r23.a, r23.b);
        return;
    L32:
        r21 = 0;
        goto L33
    L16:
        if ((!r13.isEmpty()) == false) goto L18;
        r5.putAll(r13);
        goto L18
    L5:
        if (w12.b.d == false) goto L10;
        if (com.bytedance.android.livesdk.gift.platform.business.i.h().w0() == false) goto L10;
        r5.put("template", "2");
    L10:
        if (w12.b.d == false) goto L12;
        r5.put("template", "3");
        goto L14
    L12:
        r5.put("template", "4");
        goto L14
    }

    @JvmStatic
    public static final void O(String r13, com.bytedance.android.livesdk.gift.platform.core.model.b0 r14, int r15, String r16, String r17, int r18, long r19, long r20, Integer r23, Integer r24) {
        Intrinsics.checkNotNullParameter(r13, "transactionId");
        Intrinsics.checkNotNullParameter(r14, "giftParams");
        Intrinsics.checkNotNullParameter(r16, "isProp");
        Intrinsics.checkNotNullParameter(r17, "status");
        long r5 = com.bytedance.live.kmp.util.e.b();
        Pair[] r7 = new Pair[17];
        boolean r8 = false;
        r7[0] = TuplesKt.to("traceId", r13);
        r7[1] = TuplesKt.to("room_id", String.valueOf(r14.d()));
        r7[2] = TuplesKt.to("gift_id", String.valueOf(r14.b));
        r7[3] = TuplesKt.to("count", String.valueOf(r15));
        r7[4] = TuplesKt.to("buff_level", String.valueOf(r14.l));
        r7[5] = TuplesKt.to("send_type", String.valueOf(r14.f));
        r7[6] = TuplesKt.to("send_scene", String.valueOf(r14.J));
        r7[7] = TuplesKt.to("to_room_id", String.valueOf(r14.e()));
        r7[8] = TuplesKt.to("group_cnt", String.valueOf(r14.a0));
        r7[9] = TuplesKt.to("is_prop", r16);
        r7[10] = TuplesKt.to("status", r17);
        r7[11] = TuplesKt.to("error_code", String.valueOf(r18));
        r7[12] = TuplesKt.to("api_duration", String.valueOf(r20 - r19));
        r7[13] = TuplesKt.to("handle_resp_duration", String.valueOf(r5 - r20));
        r7[14] = TuplesKt.to("total_duration", String.valueOf(r5 - r19));
        if (r23 == null) goto L5;
        int r0 = r23.intValue();
    L6:
        r7[15] = TuplesKt.to("gift_type", String.valueOf(r0));
        if (r24 == null) goto L9;
        int r1 = r24.intValue();
    L10:
        r7[16] = TuplesKt.to("asset_size", String.valueOf(r1));
        LinkedHashMap r2 = new LinkedHashMap();
        MapsKt.putAll(r2, r7);
        GiftContext r3 = com.bytedance.android.livesdk.gift.util.b.b();
        Map<Long, Long> r4 = null;
        if (r3 == null) goto L15;
        com.bytedance.live.datacontext.n<Bundle> r6 = r3.getGiftLogExtra();
        if (r6 == null) goto L15;
        Bundle r9 = (Bundle) r6.getValue();
    L16:
        String r10 = r14.h;
        if (r10.length() != 0) goto L19;
        boolean r11 = true;
    L20:
        String r21 = BuildConfig.FLAVOR;
        if (r11 == false) goto L27;
        if (r9 == null) goto L25;
        r10 = r9.getString("gift_source");
        if (r10 != null) goto L27;
    L25:
        r10 = BuildConfig.FLAVOR;
    L27:
        if (r10.length() != 0) goto L29;
        r8 = true;
    L29:
        if (r8 == false) goto L31;
        r10 = "gift_tab";
    L31:
        r2.put("gift_source", r10);
        if (r9 == null) goto L39;
        String r25 = r9.getString("gift_show_from");
        if (r25 == null) goto L39;
        if (Intrinsics.areEqual(r25, "bottom_tab") == false) goto L38;
        r25 = "icon";
    L38:
        r21 = r25;
    L39:
        r2.put("gift_show_from", r21);
        r2.put("send_gift_scene", vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(x12.b.a()));
        i12.e r26 = i12.o.b();
        if (r26 == null) goto L42;
        Object r27 = com.bytedance.android.scope.m.e.d(r26, SendGiftRelationService.class);
    L43:
        SendGiftRelationService r28 = (SendGiftRelationService) r27;
        if (r28 == null) goto L46;
        r2.put("send_gift_relation", String.valueOf(r28.a(r14.g())));
    L46:
        com.bytedance.android.livesdk.gift.platform.core.model.k r29 = r14.Q;
        int r30 = -1;
        if (r29 == null) goto L49;
        int r31 = r29.a;
    L50:
        r2.put("gift_position", String.valueOf(r31));
        com.bytedance.android.livesdk.gift.platform.core.model.k r33 = r14.Q;
        if (r33 == null) goto L53;
        r30 = r33.b;
    L53:
        r2.put("gift_page", String.valueOf(r30));
        i12.e r34 = i12.o.b();
        if (r34 == null) goto L56;
        Object r35 = com.bytedance.android.scope.m.e.d(r34, com.bytedance.android.livesdk.gift.platform.core.scope.service.f0.class);
    L57:
        com.bytedance.android.livesdk.gift.platform.core.scope.service.f0 r36 = (com.bytedance.android.livesdk.gift.platform.core.scope.service.f0) r35;
        if (r36 == null) goto L61;
        r4 = r36.d;
    L61:
        if (r4 != null) goto L63;
        r2.put("predict_result", "-1");
    L71:
        r2.put("consume_level", String.valueOf(ay1.b.u()));
        mz0.n r37 = new mz0.n();
        Map r38 = r37.a;
        Intrinsics.checkNotNullParameter(r38, "map");
        Intrinsics.checkNotNullParameter(r2, "map");
        r38.putAll(r2);
        mz0.m r39 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r40 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r40, "pageSourceLog");
        ((ArrayList) r39.a).add(r40.a);
        r39.b(LogCommon.ROOM);
        ((ArrayList) r37.b).addAll(r39.a);
        cy0.e.a.getClass();
        cy0.j r41 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r43 = com.bytedance.android.scope.m.b(r41).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r43);
        ((f80.a) r43).w3("livesdk_finish_gift_request", r37.a, r37.b);
        return;
    L63:
        if (r4.containsKey(Long.valueOf(r14.b)) == false) goto L69;
        r2.put("predict_result", "1");
        long r44 = System.currentTimeMillis();
        Long r45 = r4.get(Long.valueOf(r14.b));
        if (r45 == null) goto L67;
        long r46 = r45.longValue();
    L68:
        r2.put("predict_duration", String.valueOf(r44 - r46));
        goto L71
    L67:
        r46 = 0;
        goto L68
    L69:
        r2.put("predict_result", "0");
        goto L71
    L56:
        r35 = null;
        goto L57
    L49:
        r31 = -1;
        goto L50
    L42:
        r27 = null;
        goto L43
    L19:
        r11 = false;
    L15:
        r9 = null;
        goto L16
    L9:
        r1 = 0;
        goto L10
    L5:
        r0 = 0;
        goto L6
    }

    @JvmStatic
    public static final void Z(long r16, boolean r18, int r19, boolean r20, AbsPanel.GiftPanelIconSource r21, String r23, List<? extends e3> r24, boolean r25, IBaseUser r26, boolean r27) {
        Intrinsics.checkNotNullParameter(r21, "iconSource");
        Intrinsics.checkNotNullParameter(r26, "toUser");
        if (r16 > 0) goto L5;
        return;
    L5:
        String r4 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getIdString();
        int r6 = r19 + 1;
        int r7 = r6 % 8;
        boolean r8 = false;
        if (r7 != 0) goto L8;
        int r10 = 0;
    L10:
        if (t.b() == false) goto L12;
        int r11 = r19 / 4;
    L13:
        int r13 = r11 + 1;
        int r14 = (r19 % 4) + 1;
        k();
        String r15 = ay1.b.l().get(String.valueOf(r16));
        int r17 = x12.b.a();
        Pair[] r110 = new Pair[10];
        r110[0] = TuplesKt.to("user_id", r4.toString());
        r110[1] = TuplesKt.to("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f()));
        r110[2] = TuplesKt.to("tab_location", String.valueOf(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.h() + 1));
        r110[3] = TuplesKt.to("page_location", String.valueOf((r6 / 8) + r10));
        int[] r9 = b;
        if (r10 != 0) goto L16;
        r7 = 8;
    L16:
        r110[4] = TuplesKt.to("gift_location", String.valueOf(r9[r7]));
        GiftContext r28 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r28 == null) goto L22;
        com.bytedance.live.datacontext.m<String> r29 = r28.getGiftListResultLogId();
        if (r29 == null) goto L22;
        String r30 = (String) r29.getValue();
        if (r30 == null) goto L22;
    L23:
        r110[5] = TuplesKt.to("gift_dialog_request_id", r30);
        if (r20 == false) goto L26;
        String r31 = "light_sweep";
    L27:
        r110[6] = TuplesKt.to("show_mode", r31);
        r110[7] = TuplesKt.to("gift_row_location", String.valueOf(r13));
        r110[8] = TuplesKt.to("gift_column_location", String.valueOf(r14));
        r110[9] = TuplesKt.to("show_gift_scene", vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(r17));
        LinkedHashMap r5 = new LinkedHashMap();
        MapsKt.putAll(r5, r110);
        GiftContext r33 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r33 == null) goto L32;
        com.bytedance.live.datacontext.n<Bundle> r34 = r33.getGiftLogExtra();
        if (r34 == null) goto L32;
        Bundle r35 = (Bundle) r34.getValue();
    L33:
        HashMap r36 = vh6.c.b(er2.b.class).Z6();
        if (r36 == null) goto L41;
        Iterator r37 = r36.entrySet().iterator();
    L37:
        if (r37.hasNext() == false) goto L41;
        Map.Entry r38 = (Map.Entry) r37.next();
        if (r5.containsKey(r38.getKey()) == true) goto L37;
        r5.put(r38.getKey(), r38.getValue());
    L41:
        String r39 = "0";
        if (r18 == false) goto L47;
        if (r25 == false) goto L45;
        Object r111 = "1";
    L46:
        r5.put("gift_unlock_status", r111);
        goto L47
    L45:
        r111 = "0";
    L47:
        if (r35 == null) goto L70;
        Iterator<String> r112 = r35.keySet().iterator();
    L50:
        if (r112.hasNext() == false) goto L70;
        String r113 = r112.next();
        Object r114 = r35.get(r113);
        if ((r114 instanceof Boolean) == true) goto L69;
        if ((r114 instanceof Byte) == true) goto L69;
        if ((r114 instanceof Character) == true) goto L69;
        if ((r114 instanceof Double) == true) goto L69;
        if ((r114 instanceof Float) == true) goto L69;
        if ((r114 instanceof Integer) == true) goto L69;
        if ((r114 instanceof Long) == true) goto L69;
        if ((r114 instanceof Short) == true) goto L69;
        if ((r114 instanceof String) == false) goto L50;
    L69:
        r5.put(r113, r114.toString());
    L70:
        Map<Integer, Integer> r40 = tz1.a.a;
        if (tz1.a.d(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f()) == false) goto L73;
        r5.put("order_type", tz1.a.b());
    L73:
        GiftManagerKt.z.getClass();
        Map r41 = GiftManagerKt.o();
        if (r41 != null) goto L76;
    L77:
        r8 = true;
    L78:
        if (r8 == true) goto L83;
        Map r43 = GiftManagerKt.o();
        if (r43 == null) goto L83;
        r5.putAll(r43);
    L83:
        if (((com.bytedance.android.livesdk.gift.platform.business.config.n) com.bytedance.android.livesdk.gift.util.b.a().d(com.bytedance.android.livesdk.gift.platform.business.config.n.class)).f() == 0) goto L85;
        String r44 = "scroll";
    L86:
        r5.put("gift_show_type", r44);
        if (r15 == null) goto L89;
        r5.put("light_sweep_cnt", r15);
    L89:
        b0(r18, r5, r16);
        if (r18 == false) goto L102;
        h2 r0 = GiftManagerKt.l(r16);
        if (r0 == null) goto L102;
        GiftMsgBoard r1 = l0.b(r0);
        if (r1 == null) goto L99;
        if (r1.forMsgBoard != true) goto L99;
        r5.put("is_message", "1");
    L99:
        if (l0.e(r0) == false) goto L101;
        r5.put("free_display", "1");
        goto L102
    L101:
        r5.put("free_display", "0");
    L102:
        r5.put("connection_type", e());
        r5.put("to_user_status", i.c(r26.getIdString()));
        if (r21 != AbsPanel.GiftPanelIconSource.DIY_CARD) goto L105;
        r39 = "1";
    L105:
        r5.put("operation_icon", r39);
        String r2 = "null";
        if (r23 != null) goto L108;
        String r3 = "null";
    L109:
        r5.put("card_name", r3);
        List r45 = i.b(r24);
        if (r45 == null) goto L115;
        String r46 = r45.toString();
        if (r46 == null) goto L115;
        r2 = r46;
    L115:
        r5.put(com.bytedance.android.livesdk.gift.model.n.KEY_PLUGINS, r2);
        if (r27 == false) goto L118;
        r5.put("business_type", "2");
    L118:
        mz0.n r47 = new mz0.n();
        Map r48 = r47.a;
        Intrinsics.checkNotNullParameter(r48, "map");
        Intrinsics.checkNotNullParameter(r5, "map");
        r48.putAll(r5);
        mz0.m r49 = new mz0.m();
        r49.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r50 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r50, "pageSourceLog");
        List r51 = r49.a;
        ArrayList r53 = (ArrayList) r51;
        r53.add(r50.a);
        List r54 = r47.b;
        ArrayList r55 = (ArrayList) r54;
        r55.addAll(r49.a);
        cy0.e.a.getClass();
        cy0.j r56 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r57 = com.bytedance.android.scope.m.b(r56).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r57);
        ((f80.a) r57).w3("livesdk_distinct_gift_show", r47.a, r47.b);
        return;
    L108:
        r3 = r23;
        goto L109
    L85:
        r44 = "slide";
        goto L86
    L76:
        if (r41.isEmpty() == false) goto L78;
    L32:
        r35 = null;
        goto L33
    L26:
        r31 = "normal";
    L22:
        r30 = BuildConfig.FLAVOR;
        goto L23
    L12:
        r11 = (r19 % 8) / 4;
        goto L13
    L8:
        r10 = 1;
        goto L10
    }

    @JvmStatic
    public static final void w(Context r17, DataCenter r18, IRoom r19, JSONObject r20, String r21, Integer r23, String r24, boolean r25, long r26, IBaseUser r27) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r27, "toUser");
        JSONObject r0 = new JSONObject();
        r0.put("live_source", r20.opt("live_source"));     // Catch: Exception -> L13
        if (r19 == null) goto L6;
        String r7 = r19.getRequestId();     // Catch: Exception -> L13
    L7:
        r0.put("request_id", r7);     // Catch: Exception -> L13
        yz0.k r8 = g();     // Catch: Exception -> L13
        if (r8 == null) goto L10;
        String r9 = r8.getLogPb();     // Catch: Exception -> L13
    L11:
        r0.put("log_pb", r9);     // Catch: Exception -> L13
    L15:
        LinkedHashMap r1 = new LinkedHashMap();
        GiftContext r5 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r5 == null) goto L20;
        com.bytedance.live.datacontext.n<Bundle> r6 = r5.getGiftLogExtra();
        if (r6 == null) goto L20;
        Bundle r10 = (Bundle) r6.getValue();
    L21:
        if (r10 == null) goto L45;
        Iterator<String> r11 = r10.keySet().iterator();
    L24:
        if (r11.hasNext() == false) goto L45;
        String r13 = r11.next();
        Object r14 = r10.get(r13);
        if ((r14 instanceof Boolean) == true) goto L43;
        if ((r14 instanceof Byte) == true) goto L43;
        if ((r14 instanceof Character) == true) goto L43;
        if ((r14 instanceof Double) == true) goto L43;
        if ((r14 instanceof Float) == true) goto L43;
        if ((r14 instanceof Integer) == true) goto L43;
        if ((r14 instanceof Long) == true) goto L43;
        if ((r14 instanceof Short) == true) goto L43;
        if ((r14 instanceof String) == false) goto L24;
    L43:
        r1.put(r13, r14.toString());
    L45:
        if (r18 == null) goto L47;
        Boolean r15 = (Boolean) r18.get("data_is_portrait", Boolean.TRUE);
    L48:
        Boolean r16 = Boolean.TRUE;
        String r28 = "0";
        if (Intrinsics.areEqual(r15, r16) == false) goto L51;
        Object r29 = "0";
    L52:
        r1.put("room_orientation", r29);
        String r30 = BuildConfig.FLAVOR;
        if (r21 != null) goto L55;
        String r110 = BuildConfig.FLAVOR;
    L56:
        r1.put("to_user_id", r110);
        if (r19 == null) goto L59;
        String r111 = r19.getAnchorId();
    L61:
        if (Intrinsics.areEqual(r21, r111) == false) goto L63;
        String r112 = "anchor";
    L64:
        r1.put("to_user_type", r112);
        gq2.b r113 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).Qc();
        if (r18 == null) goto L69;
        r113.b();
        Integer r114 = (Integer) r18.get("data_link_state", 0);
        if (r114 == null) goto L69;
        int r115 = r114.intValue();
    L70:
        com.bytedance.android.livesdk.revenue.service.interact.d r116 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        com.bytedance.android.livesdk.revenue.service.microom.a r117 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.microom.a.class);
        r1.put("send_gift_scene", r116.changeMode2String(r115));
        if (r1.containsKey("gift_show_from") == true) goto L73;
        r1.put("gift_show_from", "icon");
    L73:
        String r118 = (String) r1.get("gift_show_from");
        if (r118 != null) goto L76;
        r118 = "icon";
    L76:
        a = r118;
        if (r117.isMicRoom(r19) == false) goto L94;
        if (r21 != null) goto L80;
        String r119 = BuildConfig.FLAVOR;
    L82:
        if (r116.isMicRoomHost(r119) == false) goto L94;
        if (r18 == null) goto L85;
        Boolean r120 = (Boolean) r18.get("data_is_anchor", Boolean.FALSE);
    L87:
        if (Intrinsics.areEqual(r120, r16) == false) goto L90;
        String r31 = "carousel_anchor_c_carousel_host";
    L93:
        r1.put("carousel_action_type", r31);
        goto L94
    L90:
        if (r117.isLoyalAudience() == false) goto L92;
        r31 = "loyal_audience_c_carousel_host";
        goto L93
    L92:
        r31 = "carousel_audience_c_carousel_host";
        goto L93
    L85:
        r120 = null;
        goto L87
    L80:
        r119 = r21;
    L94:
        if (r23 == null) goto L96;
        r23.intValue();
        r1.put("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r23.intValue()));
    L96:
        r1.put("tab_location", String.valueOf(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.h() + 1));
        GiftContext r33 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r33 == null) goto L101;
        com.bytedance.live.datacontext.n<Integer> r34 = r33.getCurrentSelectedGiftPosition();
        if (r34 == null) goto L101;
        Integer r35 = (Integer) r34.getValue();
    L102:
        if (r35 != null) goto L104;
        r35 = 0;
    L104:
        Integer r36 = Integer.valueOf(r35.intValue() + 1);
        int r121 = 8;
        if ((r36.intValue() % 8) != 0) goto L107;
        int r122 = 0;
    L108:
        r1.put("page_location", String.valueOf((r36.intValue() / 8) + r122));
        int[] r123 = b;
        if (r122 == 0) goto L112;
        r121 = r36.intValue() % 8;
    L112:
        r1.put("gift_location", String.valueOf(r123[r121]));
        GiftContext r124 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r124 == null) goto L120;
        com.bytedance.live.datacontext.n<Bundle> r125 = r124.getGiftLogExtra();
        if (r125 == null) goto L120;
        Bundle r126 = (Bundle) r125.getValue();
        if (r126 == null) goto L120;
        String r127 = r126.getString("gift_show_from");
        if (r127 == null) goto L120;
    L122:
        if (TextUtils.isEmpty(r127) == false) goto L124;
        r1.put("gift_show_from", a);
    L134:
        r1.put("gift_dialog_request_id", r24);
        r1.put("connection_type", e());
        r1.put("anchor_cnt", com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getLinkAnchorCount());
        if (r25 == false) goto L137;
        r28 = "1";
    L137:
        r1.put("is_prop_show", r28);
        GiftContext r37 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r37 == null) goto L144;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.gift.platform.core.f0> r38 = r37.getRowLocation();
        if (r38 == null) goto L144;
        com.bytedance.android.livesdk.gift.platform.core.f0 r39 = (com.bytedance.android.livesdk.gift.platform.core.f0) r38.getValue();
        if (r39 == null) goto L144;
        Integer r40 = Integer.valueOf(r39.a);
    L145:
        r1.put("start_row_location", String.valueOf(r40));
        GiftContext r41 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r41 == null) goto L152;
        com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.gift.platform.core.f0> r43 = r41.getRowLocation();
        if (r43 == null) goto L152;
        com.bytedance.android.livesdk.gift.platform.core.f0 r44 = (com.bytedance.android.livesdk.gift.platform.core.f0) r43.getValue();
        if (r44 == null) goto L152;
        Integer r45 = Integer.valueOf(r44.b);
    L153:
        r1.put("end_row_location", String.valueOf(r45));
        r1.put("gift_show_scene", i.a(r18));
        r1.put("to_user_status", i.c(r27.getIdString()));
        HashMap r4 = vh6.c.b(er2.b.class).Z6();
        if (r4 == null) goto L162;
        Iterator r46 = r4.entrySet().iterator();
    L157:
        if (r46.hasNext() == false) goto L162;
        Map.Entry r47 = (Map.Entry) r46.next();
        if (r1.containsKey(r47.getKey()) == true) goto L157;
        r1.put(r47.getKey(), r47.getValue());
    L162:
        if (u.n() == false) goto L178;
        if (r18 == null) goto L165;
        Boolean r48 = (Boolean) r18.get("data_is_portrait", Boolean.TRUE);
    L167:
        if (Intrinsics.areEqual(r48, Boolean.TRUE) == true) goto L169;
    L173:
        r1.put("gift_id", String.valueOf(r26));
        com.bytedance.android.live.revenue.core.a r49 = com.bytedance.android.live.revenue.core.util.k.a();
        if (r49 == null) goto L190;
        n01.a r50 = com.bytedance.android.live.revenue.core.util.f.c(r49, n01.a.class);
        if (r50 == null) goto L190;
        r50.E0().sendLog("gift_show", r1);
        r50.E0().sendLog("send_gift_icon_click", new LinkedHashMap());
    L190:
        int r2 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f();
        int r51 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.f();
        if (r21 == null) goto L194;
        r30 = r21;
    L194:
        V(r2, r51, "call", r18, r30, r19);
        return;
    L169:
        if ((r36.intValue() % 4) != 0) goto L171;
        int r128 = 0;
    L172:
        r1.put("page_location", String.valueOf((r36.intValue() / 4) + r128));
        r1.put("gift_location", String.valueOf(r36.intValue()));
        goto L173
    L171:
        r128 = 1;
        goto L172
    L165:
        r48 = null;
        goto L167
    L178:
        GiftManagerKt.z.getClass();
        Map r53 = GiftManagerKt.o();
        if (r53 != null) goto L181;
    L184:
        boolean r129 = true;
    L185:
        if (r129 == true) goto L189;
        Map r54 = GiftManagerKt.o();
        if (r54 == null) goto L189;
        r1.putAll(r54);
    L189:
        vh6.c.b(kr2.a.class).appendCastSDKLogCommonParams(r1);
        r1.put("is_screencasting", m2.b(ay1.b.p()));
        mz0.n r55 = new mz0.n();
        Map r56 = r55.a;
        Intrinsics.checkNotNullParameter(r56, "map");
        Intrinsics.checkNotNullParameter(r1, "map");
        r56.putAll(r1);
        mz0.m r3 = new mz0.m();
        r3.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r57 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r57, "pageSourceLog");
        Intrinsics.checkNotNullParameter("live_interact", "belong");
        r57.a("live_interact");
        Intrinsics.checkNotNullParameter("live_detail", "page");
        r57.c("live_detail");
        List r58 = r3.a;
        ArrayList r59 = (ArrayList) r58;
        r59.add(r57.a);
        List r60 = r55.b;
        ArrayList r61 = (ArrayList) r60;
        r61.addAll(r3.a);
        cy0.e.a.getClass();
        cy0.j r63 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r64 = com.bytedance.android.scope.m.b(r63).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r64);
        ((f80.a) r64).w3("gift_show", r55.a, r55.b);
        goto L190
    L181:
        if (r53.isEmpty() == true) goto L184;
        r129 = false;
    L152:
        r45 = null;
    L144:
        r40 = null;
        goto L145
    L124:
        if (Intrinsics.areEqual("hourly", r127) == false) goto L126;
    L132:
        r1.put("gift_show_from", "hour_rank");
        goto L134
    L126:
        if (Intrinsics.areEqual("regional", r127) == true) goto L132;
        if (Intrinsics.areEqual("bottom_tab", r127) == false) goto L131;
        r1.put("gift_show_from", "icon");
        goto L134
    L131:
        r1.put("gift_show_from", r127);
    L120:
        r127 = BuildConfig.FLAVOR;
        goto L122
    L107:
        r122 = 1;
    L101:
        r35 = null;
    L69:
        r113.b();
        r115 = 0;
        goto L70
    L63:
        r112 = "guest";
        goto L64
    L59:
        r111 = null;
        goto L61
    L55:
        r110 = r21;
        goto L56
    L51:
        r29 = "1";
        goto L52
    L47:
        r15 = null;
    L20:
        r10 = null;
        goto L21
    L10:
        r9 = null;
        goto L11
    L6:
        r7 = null;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public static void S(int r14, long r15, long r17, int r19, int r20, int r21, int r23, String r24, com.bytedance.android.livesdk.gift.platform.business.effect.assets.d r25, String r26, int r27, String r28, int r29, String r210, long r30, int r33) {
        int r5 = 0;
        if ((r33 & 1024) == 0) goto L5;
        int r4 = 0;
    L7:
        if ((r33 & 2048) == 0) goto L9;
        String r6 = "0";
    L11:
        if ((r33 & 4096) == 0) goto L13;
        int r7 = 0;
    L14:
        long r8 = 0;
        if ((r33 & 16384) == 0) goto L17;
        long r10 = 0;
    L18:
        Intrinsics.checkNotNullParameter(r24, "traceFlag");
        Intrinsics.checkNotNullParameter(r26, "supportAsset265");
        Intrinsics.checkNotNullParameter(r6, "baseVersion");
        Pair[] r3 = new Pair[19];
        r3[0] = TuplesKt.to("source", String.valueOf(r14));
        r3[1] = TuplesKt.to("assets_size", String.valueOf(r21));
        r3[2] = TuplesKt.to("handle_resp_duration", String.valueOf(System.currentTimeMillis() - r17));
        r3[3] = TuplesKt.to("sync_duration", String.valueOf(System.currentTimeMillis() - r15));
        r3[4] = TuplesKt.to("template", String.valueOf(r19));
        r3[5] = TuplesKt.to("is_full", String.valueOf(r20));
        r3[6] = TuplesKt.to("special_rq", String.valueOf(r23));
        r3[7] = TuplesKt.to("trace", r24);
        if (r25 == null) goto L21;
        int r0 = r25.a;
    L22:
        r3[8] = TuplesKt.to("type_yes", String.valueOf(r0));
        if (r25 == null) goto L25;
        int r1 = r25.b;
    L26:
        r3[9] = TuplesKt.to("type_no", String.valueOf(r1));
        if (r25 == null) goto L29;
        int r2 = r25.c;
    L30:
        r3[10] = TuplesKt.to("type_lazy", String.valueOf(r2));
        if (r25 == null) goto L33;
        int r9 = r25.d;
    L34:
        r3[11] = TuplesKt.to("type_reco", String.valueOf(r9));
        if (r25 == null) goto L37;
        r5 = r25.e;
    L37:
        r3[12] = TuplesKt.to("type_unknown", String.valueOf(r5));
        r3[13] = TuplesKt.to("support_265", r26);
        r3[14] = TuplesKt.to("base_count", String.valueOf(r4));
        r3[15] = TuplesKt.to("update_count", String.valueOf(r7));
        r3[16] = TuplesKt.to("base_version", r6);
        if (r210 != null) goto L40;
        String r11 = BuildConfig.FLAVOR;
    L41:
        r3[17] = TuplesKt.to("assetlog_id", r11);
        if (r10 <= 0) goto L44;
        String r13 = String.valueOf(r10);
    L45:
        r3[18] = TuplesKt.to("enter_leave_Room_interval", r13);
        LinkedHashMap r16 = new LinkedHashMap();
        MapsKt.putAll(r16, r3);
        yz0.k r18 = g();
        if (r18 == null) goto L48;
        r8 = r18.Hl();
    L48:
        r16.put("enter_time", String.valueOf(r15 - r8));
        mz0.n r31 = new mz0.n();
        Map r34 = r31.a;
        Intrinsics.checkNotNullParameter(r34, "map");
        Intrinsics.checkNotNullParameter(r16, "map");
        r34.putAll(r16);
        mz0.m r35 = new mz0.m();
        com.bytedance.android.livesdk.revenue.log.i r36 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r36, "pageSourceLog");
        ((ArrayList) r35.a).add(r36.a);
        r35.b(LogCommon.ROOM);
        ((ArrayList) r31.b).addAll(r35.a);
        cy0.e.a.getClass();
        cy0.j r37 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r38 = com.bytedance.android.scope.m.b(r37).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r38);
        ((f80.a) r38).w3("livesdk_fetch_gift_assets_list", r31.a, r31.b);
        return;
    L44:
        r13 = "-1";
        goto L45
    L40:
        r11 = r210;
        goto L41
    L33:
        r9 = 0;
        goto L34
    L29:
        r2 = 0;
        goto L30
    L25:
        r1 = 0;
        goto L26
    L21:
        r0 = 0;
        goto L22
    L17:
        r10 = r30;
        goto L18
    L13:
        r7 = r29;
        goto L14
    L9:
        r6 = r28;
        goto L11
    L5:
        r4 = r27;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Map c0(com.bytedance.android.livesdk.gift.platform.core.model.b0 r41, String r43, IRoom r44, String r45, DataCenter r46, long r47, long r48, long r50, int r53, boolean r54, int r55, long r56, int r57, k3 r58, SeriesSendType r59, String r60, String r61, String r63, String r64, com.bytedance.android.livesdk.gift.platform.core.model.a r65, int r66) {
        String r6 = com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).getCurrentUserId();
        com.bytedance.android.livesdk.gift.platform.core.model.k r7 = r41.Q;
        if (r7 == null) goto L5;
        int r16 = r7.a;
    L6:
        GiftContext r8 = com.bytedance.android.livesdk.gift.util.b.b();
        int r17 = 0;
        if (r8 == null) goto L13;
        com.bytedance.live.datacontext.n<Integer> r9 = r8.getCurrentSelectedGiftPosition();
        if (r9 == null) goto L13;
        Integer r10 = (Integer) r9.getValue();
        if (r10 == null) goto L13;
        int r11 = r10.intValue();
    L14:
        int r13 = r11 + 1;
        if ((r16 % 8) != 0) goto L17;
        int r18 = 0;
    L18:
        yz0.k r19 = g();
        if (r19 == null) goto L21;
        boolean r110 = r19.isAnchor();
    L22:
        int r14 = x12.b.a();
        if (r46 == null) goto L27;
        Boolean r0 = (Boolean) r46.get("data_is_portrait", Boolean.TRUE);
        if (r0 == null) goto L27;
        boolean r23 = r0.booleanValue();
    L28:
        Pair[] r1 = new Pair[18];
        r1[0] = TuplesKt.to("user_id", r6.toString());
        r1[1] = TuplesKt.to("page_location", String.valueOf((r16 / 8) + r18));
        int[] r15 = b;
        if (r18 != 0) goto L31;
        int r20 = 8;
    L32:
        r1[2] = TuplesKt.to("gift_location", String.valueOf(r15[r20]));
        GiftContext r21 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r21 == null) goto L40;
        com.bytedance.live.datacontext.m<String> r24 = r21.getGiftListResultLogId();
        if (r24 == null) goto L40;
        String r25 = (String) r24.getValue();
        if (r25 == null) goto L40;
    L41:
        r1[3] = TuplesKt.to("gift_dialog_request_id", r25);
        r1[4] = TuplesKt.to("send_gift_scene", vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(r14));
        r1[5] = TuplesKt.to("connection_type", e());
        r1[6] = TuplesKt.to("anchor_cnt", com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getLinkAnchorCount());
        long r26 = r48 * r47;
        r1[7] = TuplesKt.to("gift_cnt", String.valueOf(((long) r57) * r26));
        r1[8] = TuplesKt.to("group_cnt", String.valueOf(r48));
        r1[9] = TuplesKt.to("combo_cnt", String.valueOf(r47));
        yz0.k r27 = g();
        if (r27 == null) goto L44;
        Long r28 = Long.valueOf(r27.getDesireId());
    L45:
        r1[10] = TuplesKt.to("wish_id", String.valueOf(r28));
        com.bytedance.android.livesdk.gift.platform.core.model.k r29 = r41.P;
        if (r29 == null) goto L48;
        int r30 = r29.a;
    L49:
        r1[11] = TuplesKt.to("default_pos", String.valueOf(r30));
        com.bytedance.android.livesdk.gift.platform.core.model.k r31 = r41.Q;
        if (r31 == null) goto L52;
        int r33 = r31.a;
    L53:
        r1[12] = TuplesKt.to("gift_position", String.valueOf(r33));
        com.bytedance.android.livesdk.gift.platform.core.model.n r34 = r41.C;
        if (r34 == null) goto L56;
        int r35 = r34.c;
    L57:
        r1[13] = TuplesKt.to("scroll_count", String.valueOf(r35));
        if (r64 != null) goto L60;
        String r36 = BuildConfig.FLAVOR;
    L61:
        r1[14] = TuplesKt.to("gift_panel_session_id", r36);
        String r210 = "1";
        if (r41.V == false) goto L64;
        Object r37 = "1";
    L65:
        r1[15] = TuplesKt.to("is_search_result", r37);
        r1[16] = TuplesKt.to("search_word", r41.W);
        r1[17] = TuplesKt.to("gift_panel_search_id", r41.X);
        LinkedHashMap r38 = new LinkedHashMap();
        MapsKt.putAll(r38, r1);
        GiftContext r2 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r2 == null) goto L70;
        com.bytedance.live.datacontext.n<Bundle> r3 = r2.getGiftLogExtra();
        if (r3 == null) goto L70;
        Bundle r4 = (Bundle) r3.getValue();
    L71:
        if (r4 == null) goto L95;
        Iterator<String> r39 = r4.keySet().iterator();
    L74:
        if (r39.hasNext() == false) goto L95;
        String r40 = r39.next();
        Iterator<String> r67 = r39;
        Object r49 = r4.get(r40);
        Bundle r310 = r4;
        if ((r49 instanceof Boolean) == false) goto L78;
    L93:
        r38.put(r40, r49.toString());
    L94:
        r39 = r67;
        r4 = r310;
        goto L74
    L78:
        if ((r49 instanceof Byte) == true) goto L93;
        if ((r49 instanceof Character) == true) goto L93;
        if ((r49 instanceof Double) == true) goto L93;
        if ((r49 instanceof Float) == true) goto L93;
        if ((r49 instanceof Integer) == true) goto L93;
        if ((r49 instanceof Long) == true) goto L93;
        if ((r49 instanceof Short) == true) goto L93;
        if ((r49 instanceof String) == false) goto L94;
    L95:
        String r5 = r41.S;
        if (r5 == null) goto L98;
        r38.put("show_strategy", r5);
        Unit r51 = Unit.INSTANCE;
    L98:
        if (r16 < 0) goto L100;
        r38.put("gift_column_location", String.valueOf(d(Integer.valueOf(r16))));
        r38.put("gift_row_location", String.valueOf(h(Integer.valueOf(r16))));
    L100:
        if (r61 == null) goto L102;
        r38.put("cluster_name", r61);
        Unit r68 = Unit.INSTANCE;
    L102:
        com.bytedance.android.livesdk.gift.platform.core.model.k r69 = r41.Q;
        if (r69 == null) goto L105;
        Integer r70 = Integer.valueOf(r69.b);
    L106:
        if (r70 == null) goto L108;
        int r71 = r70.intValue();
    L109:
        com.bytedance.android.livesdk.gift.platform.core.model.k r73 = r41.Q;
        if (r73 == null) goto L114;
        b(r71, r73.a, r41.P, r73.c, r38);
        Unit r74 = Unit.INSTANCE;
    L114:
        if (r70 == null) goto L137;
        r38.put("tab_name", ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).F5(r70.intValue()));
        if (u.r() == false) goto L126;
        int r75 = r70.intValue();
        List<w1> r76 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.k();
        int r111 = ((ArrayList) r76).size();
        int r112 = 0;
    L118:
        if (r112 >= r111) goto L123;
        List<w1> r610 = r76;
        if (((w1) ListProtector.get(r76, r112)).getPageType() == r75) goto L121;
        r112 = r112 + 1;
        r76 = r610;
        goto L118
    L121:
        int r77 = 1;
    L124:
        String r78 = String.valueOf(r112 + r77);
    L136:
        r38.put("tab_location", r78);
    L139:
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).Sl() == false) goto L141;
        Object r79 = "1";
    L142:
        r38.put("is_link", r79);
        if (r41.v == true) goto L154;
        r38.put("to_user_id", r43);
        String r80 = r41.g();
        if (r44 == null) goto L147;
        String r81 = r44.getAnchorId();
    L149:
        if ((!Intrinsics.areEqual(r80, r81)) == false) goto L151;
        String r83 = "guest";
    L152:
        r38.put("to_user_type", r83);
        r38.put("to_user_status", i.c(r41.g()));
        goto L154
    L151:
        r83 = "anchor";
        goto L152
    L147:
        r81 = null;
    L154:
        if (r41.c == SendGiftSource.GiftDialog) goto L156;
    L158:
        i12.e r84 = i12.o.b();
        if (r84 == null) goto L161;
        Object r85 = com.bytedance.android.scope.m.e.d(r84, GroupLiveReceiverService.class);
    L162:
        GroupLiveReceiverService r86 = (GroupLiveReceiverService) r85;
        if (r86 == null) goto L166;
        r86.a(r38, r43, null);
        Unit r87 = Unit.INSTANCE;
    L166:
        if (TextUtils.isEmpty(r41.h) == true) goto L168;
        String r88 = r41.h;
    L177:
        if (TextUtils.isEmpty(r88) == true) goto L179;
        r38.put("gift_source", String.valueOf(r88));
    L180:
        if (r63 == null) goto L189;
        if (r63.length() <= 0) goto L184;
        boolean r89 = true;
    L186:
        if (r89 != true) goto L189;
        String r90 = r63;
    L198:
        r38.put("gift_feed_str", r90);
        if (r41.r == false) goto L232;
        h2 r91 = GiftManagerKt.l(r50);
        if (r91 != null) goto L203;
        return r38;
    L203:
        r38.put("money", String.valueOf((((long) r91.getDiamondCount()) * r48) * r47));
        r38.put("money_per_unit", String.valueOf(r91.getDiamondCount()));
        r38.put("income", String.valueOf((((long) r91.getDiamondCount()) * r48) * r47));
        r38.put("prop_id", String.valueOf(r41.b));
        i12.e r93 = i12.o.b();
        if (r93 == null) goto L206;
        Object r94 = com.bytedance.android.scope.m.e.d(r93, PropListService.class);
    L207:
        PropListService r95 = (PropListService) r94;
        if (r95 == null) goto L210;
        l2 r96 = r95.f(Long.valueOf(r41.b));
    L211:
        if (r96 == null) goto L216;
        h1 r97 = r96.getGift();
        if (r97 == null) goto L216;
        String r98 = String.valueOf(r97.getId());
        if (r98 == null) goto L216;
    L217:
        r38.put("gift_id", r98);
        r38.put("prop_type", f(r26, r48, r47, r66));
        Intrinsics.checkNotNullParameter(r91, "$this$giftSource");
        if ((r91 instanceof h1) == true) goto L220;
        r91 = null;
    L220:
        h1 r99 = (h1) r91;
        if (r99 == null) goto L223;
        Integer r211 = Integer.valueOf(r99.getGiftSource());
    L224:
        if (r211 == null) goto L226;
        r17 = r211.intValue();
    L226:
        r38.put("gift_creation_source", String.valueOf(r17));
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L229
        r100.put(String.valueOf(r41.b), String.valueOf(r26));     // Catch: Exception -> L229
        r38.put("prop_info", r100.toString());     // Catch: Exception -> L229
    L545:
        return r38;
    L229:
        e = move-exception;
        e.printStackTrace();
        goto L545
    L223:
        r211 = null;
    L216:
        r98 = "0";
        goto L217
    L210:
        r96 = null;
        goto L211
    L206:
        r94 = null;
        goto L207
    L232:
        if (r58 == null) goto L234;
        long r101 = r58.getGiftId();
    L235:
        h2 r102 = GiftManagerKt.l(r101);
        if (r102 != null) goto L238;
        return r38;
    L238:
        r38.put("gift_id", String.valueOf(r101));
        int r113 = r71;
        LinkedHashMap r114 = r38;
        r114.put("gift_type", f(r26, r48, r47, r66));
        if (r41.v == false) goto L241;
        int r103 = r57;
    L243:
        if (r53 != 0) goto L245;
        String r104 = String.valueOf(((((long) r102.getDiamondCount()) * r48) * r47) * ((long) r103));
    L268:
        Intrinsics.checkNotNullParameter(r102, "$this$giftSource");
        boolean r105 = r102 instanceof h1;
        if (r105 == true) goto L271;
        h2 r106 = null;
    L272:
        h1 r107 = (h1) r106;
        if (r107 == null) goto L275;
        Integer r108 = Integer.valueOf(r107.getGiftSource());
    L276:
        if (r108 == null) goto L278;
        int r109 = r108.intValue();
    L279:
        r114.put("gift_creation_source", String.valueOf(r109));
        r114.put("money", r104);
        r114.put("money_per_unit", String.valueOf(r102.getDiamondCount()));
        r114.put("gift_real_type", String.valueOf(r102.getType()));
        com.bytedance.android.livesdk.gift.platform.core.model.k r115 = r41.Q;
        if (r115 == null) goto L290;
        i12.e r116 = i12.o.b();
        if (r116 == null) goto L284;
        Object r117 = com.bytedance.android.scope.m.e.d(r116, f1.class);
    L285:
        f1 r118 = (f1) r117;
        if (r118 == null) goto L288;
        boolean r119 = r118.f(r50);
    L289:
        r114.put("is_group_plugin_gift", String.valueOf(c(r115.d, r115.b, r115.e, r119)));
        Unit r120 = Unit.INSTANCE;
    L291:
        Intrinsics.checkNotNullParameter(r102, "$this$selectedDynamicEffect");
        if (r105 == true) goto L294;
        h2 r121 = null;
    L295:
        h1 r122 = (h1) r121;
        if (r122 == null) goto L298;
        Long r123 = Long.valueOf(r122.getSelectedDynamicEffect());
    L299:
        if (r123 != null) goto L302;
    L303:
        r114.put("icon_effect_type", "rare");
    L519:
        JSONObject r124 = new JSONObject();     // Catch: Exception -> L306
        r124.put(String.valueOf(r41.b), String.valueOf(r26 * ((long) r103)));     // Catch: Exception -> L306
        r114.put("gift_info", r124.toString());     // Catch: Exception -> L306
    L308:
        StringBuilder r125 = new StringBuilder();
        if ((r44 instanceof Room) == true) goto L311;
        IRoom r126 = null;
    L312:
        Room r127 = (Room) r126;
        if (r127 == null) goto L315;
        Integer r128 = Integer.valueOf(r127.orientation);
    L316:
        r125.append(String.valueOf(r128));
        r125.append(BuildConfig.FLAVOR);
        r114.put("orientation", r125.toString());
        if (com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).b().getLevel() <= 0) goto L319;
        int r129 = 1;
    L320:
        r114.put("is_first_consume", String.valueOf(r129));
        r114.put("growth_deepevent", String.valueOf(1));
        r114.put("room_orientation", String.valueOf(!r23));
        if (r44 == null) goto L323;
        LiveMode r130 = r44.getStreamType();
    L324:
        int r131 = com.bytedance.android.live.core.utils.h1.a;
        r114.put("live_type", i1.a(r130));
        if (TextUtils.isEmpty(r41.i) == true) goto L327;
        r114.put("request_page", r41.i);
    L328:
        yz0.k r132 = g();
        if (r132 == null) goto L331;
        long r133 = r132.getLiveDurationStartTime();
    L333:
        if (r133 <= 0) goto L337;
        long r134 = SystemClock.elapsedRealtime() - r133;
        if (r134 <= 0) goto L337;
        r114.put("staytime", String.valueOf(r134));
    L337:
        i12.e r135 = i12.o.b();
        if (r135 == null) goto L340;
        Object r136 = com.bytedance.android.scope.m.e.d(r135, GiftReceiverRepoService.class);
    L341:
        GiftReceiverRepoService r137 = (GiftReceiverRepoService) r136;
        if (r137 == null) goto L347;
        if (r137.h(8) != true) goto L347;
        int r138 = 1;
    L348:
        r114.put("is_in_official", String.valueOf(r138));
        r114.put("gift_tab_from", String.valueOf(r113));
        com.bytedance.android.livesdk.revenue.service.microom.a r139 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.microom.a.class);
        if (r139.isMicRoom(r44) == true) goto L351;
    L359:
        GiftContext r140 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r140 == null) goto L364;
        Bundle r141 = (Bundle) r140.getGiftLogExtra().getValue();
        if (r141 == null) goto L364;
        String r142 = r141.getString("gift_show_from");
    L366:
        if (TextUtils.isEmpty(r142) == false) goto L368;
        r114.put("gift_show_from", a);
    L379:
        String r143 = "none";
        if (r41.c != SendGiftSource.FastGift) goto L382;
        r114.put("gift_show_from", "none");
    L382:
        py.k r144 = r102.getLeftLogo();
        if (r144 == null) goto L386;
        String r145 = r144.getUri();
        if (r145 == null) goto L386;
    L387:
        r114.put("corner_mark", r145);
        if (((Boolean) ay1.b.a0.getValue(null, ay1.b.a[64])).booleanValue() == false) goto L390;
        Object r146 = "1";
    L391:
        r114.put("is_screen_clear", r146);
        r3.m(r114, jc1.a.b());
        r114.put("connection_type", e());
        r114.put("anchor_cnt", com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getLinkAnchorCount());
        if (com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).getMultiAnchorService().n(r44) == false) goto L394;
        Object r147 = "1";
    L395:
        r114.put("if_connection_value_show", r147);
        if (vh6.c.b(IRevBroadcastService.class).isPlayingGame() == false) goto L398;
        Object r148 = "1";
    L399:
        r114.put("is_gaming", r148);
        if (u.p() == false) goto L411;
        if (r45 != null) goto L403;
        String r149 = "fans_club_panel";
    L404:
        r114.put("vs_gift_page", r149);
        if (r23 == 0) goto L411;
        if ((r16 % 4) == 0) goto L410;
        r17 = 1;
    L410:
        r114.put("page_location", String.valueOf((r16 / 4) + r17));
        r114.put("gift_location", String.valueOf(r16));
        goto L411
    L403:
        r149 = r45;
    L411:
        HashMap r150 = vh6.c.b(er2.b.class).Z6();
        if (r150 == null) goto L419;
        Iterator r151 = r150.entrySet().iterator();
    L415:
        if (r151.hasNext() == false) goto L419;
        Map.Entry r152 = (Map.Entry) r151.next();
        if (r114.containsKey(r152.getKey()) == true) goto L415;
        r114.put(r152.getKey(), r152.getValue());
    L419:
        dq2.v r153 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).Ag();
        if (r153 == null) goto L424;
        String r154 = r153.b();
        if (r154 == null) goto L424;
        r114.put("grouppk_stage", r154);
        Unit r155 = Unit.INSTANCE;
    L424:
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).M0(r114);
        com.bytedance.android.live.profit.vote.e r156 = yt0.c.m();
        if (r156 == null) goto L427;
        r156.Ca(r114, r41.b, r43);
        Unit r157 = Unit.INSTANCE;
    L427:
        if (r53 <= 0) goto L429;
        r210 = "2";
    L430:
        String r158 = r210;
    L432:
        r114.put("customize", r158);
        r114.put("price", String.valueOf(r55));
        r114.put("customize_price", String.valueOf(r56));
        List<IBaseUser> r159 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.e();
        ArrayList r160 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r159, 10));
        Iterator<T> r161 = r159.iterator();
    L434:
        if (r161.hasNext() == false) goto L436;
        r160.add(((IBaseUser) r161.next()).getIdString());
        goto L434
    L436:
        r114.put("user_type", i(r160));
        if (r41.v == false) goto L443;
        List<IBaseUser> r162 = r41.w;
        if (r162 == null) goto L441;
        Integer r163 = Integer.valueOf(r162.size());
    L442:
        r114.put("full_seats_cnt", String.valueOf(r163));
        goto L443
    L441:
        r163 = null;
    L443:
        Map<String, Object> r164 = r41.L;
        if (r164 == null) goto L450;
        Iterator<Map.Entry<String, Object>> r165 = r164.entrySet().iterator();
    L447:
        if (r165.hasNext() == false) goto L449;
        Map.Entry<String, Object> r166 = r165.next();
        r114.put(r166.getKey(), r166.getValue().toString());
        goto L447
    L449:
        Unit r167 = Unit.INSTANCE;
    L450:
        SeriesSendType r168 = SeriesSendType.SINGLE;
        if (r59 != r168) goto L454;
        r143 = "single";
    L456:
        r114.put("series_type", r143);
        if (r59 == r168) goto L461;
        if (r59 == SeriesSendType.ALL) goto L461;
    L464:
        if (r65 == null) goto L467;
        String r169 = r65.a;
        if (r169 == null) goto L467;
    L468:
        r114.put("strategy_slice_id", r169);
        if (r65 == null) goto L472;
        String r170 = r65.b;
        if (r170 == null) goto L472;
    L473:
        r114.put("strategy_scene", r170);
        if (r65 == null) goto L477;
        String r171 = r65.c;
        if (r171 == null) goto L477;
    L478:
        r114.put("strategy_insert_status", r171);
        if (r65 == null) goto L482;
        String r172 = r65.d;
        if (r172 == null) goto L482;
    L483:
        r114.put("room_live_scene", r172);
        if (r65 == null) goto L487;
        String r173 = r65.e;
        if (r173 == null) goto L487;
    L488:
        r114.put("strategy_sticker_content", r173);
        i12.e r174 = i12.o.b();
        if (r174 == null) goto L491;
        Object r175 = com.bytedance.android.scope.m.e.d(r174, GiftStickerSortService.class);
    L492:
        GiftStickerSortService r176 = (GiftStickerSortService) r175;
        if (r176 == null) goto L496;
        String r177 = r176.d;
        if (r177 == null) goto L496;
    L497:
        r114.put("actual_sticker_content", r177);
        if (r65 == null) goto L502;
        Map<String, String> r178 = r65.f;
        if (r178 == null) goto L502;
        r114.putAll(r178);
        Unit r179 = Unit.INSTANCE;
    L502:
        if (r65 == null) goto L515;
        JSONObject r180 = r65.g;
        if (r180 == null) goto L515;
        Intrinsics.checkNotNullParameter(r114, "targetMap");
        Iterator<String> r181 = r180.keys();
    L507:
        if (r181.hasNext() == false) goto L514;
        String r182 = r181.next();
        String r183 = r180.optString(r182, BuildConfig.FLAVOR);
        if (r183 == null) goto L513;
        r114.put(r182, r183);     // Catch: NullPointerException -> L512
        goto L507
    L513:
        r114.put(r182, BuildConfig.FLAVOR);
        goto L507
    L514:
        Unit r184 = Unit.INSTANCE;
    L515:
        Map<String, String> r185 = r41.G;
        if (r185 == null) goto L546;
        r114.putAll(r185);
        Unit r186 = Unit.INSTANCE;
        return r114;
    L546:
        return r114;
    L496:
        r177 = BuildConfig.FLAVOR;
        goto L497
    L491:
        r175 = null;
    L487:
        r173 = BuildConfig.FLAVOR;
    L482:
        r172 = BuildConfig.FLAVOR;
    L477:
        r171 = GiftInsertStatus.NOT_STRATEGY;
    L472:
        r170 = BuildConfig.FLAVOR;
    L467:
        r169 = BuildConfig.FLAVOR;
    L461:
        if (r60 == null) goto L464;
        r114.put("series_name", r60);
        Unit r187 = Unit.INSTANCE;
        goto L464
    L454:
        if (r59 != SeriesSendType.ALL) goto L456;
        r143 = "all";
        goto L456
    L429:
        if (r54 == true) goto L430;
        r158 = "0";
        goto L432
    L398:
        r148 = "0";
        goto L399
    L394:
        r147 = "0";
        goto L395
    L390:
        r146 = "0";
    L386:
        r145 = BuildConfig.FLAVOR;
        goto L387
    L368:
        if (Intrinsics.areEqual("hourly", r142) == false) goto L370;
    L377:
        r114.put("gift_show_from", "hour_rank");
        goto L379
    L370:
        if (Intrinsics.areEqual("regional", r142) == true) goto L377;
        if (Intrinsics.areEqual("bottom_tab", r142) == false) goto L375;
        r114.put("gift_show_from", "icon");
        goto L379
    L375:
        if (r142 == null) goto L379;
        r114.put("gift_show_from", r142);
        Unit r188 = Unit.INSTANCE;
    L364:
        r142 = null;
        goto L366
    L351:
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).isMicRoomHost(r41.g()) == false) goto L359;
        if (r110 == false) goto L355;
        String r189 = "carousel_anchor_c_carousel_host";
    L358:
        r114.put("carousel_action_type", r189);
        r114.put("to_user_type", "carousel_host");
        goto L359
    L355:
        if (r139.isLoyalAudience() == false) goto L357;
        r189 = "loyal_audience_c_carousel_host";
        goto L358
    L357:
        r189 = "carousel_audience_c_carousel_host";
    L347:
        r138 = 0;
        goto L348
    L340:
        r136 = null;
        goto L341
    L331:
        r133 = 0;
        goto L333
    L327:
        r114.put("request_page", "normal");
        goto L328
    L323:
        r130 = null;
        goto L324
    L319:
        r129 = 0;
        goto L320
    L315:
        r128 = null;
        goto L316
    L311:
        r126 = r44;
    L306:
        e = move-exception;
        e.printStackTrace();
        goto L308
    L302:
        if (r123.longValue() == 0) goto L519;
    L298:
        r123 = null;
        goto L299
    L294:
        r121 = r102;
        goto L295
    L288:
        r119 = false;
        goto L289
    L284:
        r117 = null;
        goto L285
    L290:
        r114 = r114;
        goto L291
    L278:
        r109 = 0;
        goto L279
    L275:
        r108 = null;
        goto L276
    L271:
        r106 = r102;
        goto L272
    L245:
        if (r54 == false) goto L247;
        r104 = String.valueOf((((((long) r55) + r56) * r48) * r47) * ((long) r103));
        goto L268
    L247:
        i12.e r190 = i12.o.b();
        if (r190 == null) goto L250;
        Object r191 = com.bytedance.android.scope.m.e.d(r190, GiftExtraRepo.class);
    L251:
        GiftExtraRepo r192 = (GiftExtraRepo) r191;
        if (r192 == null) goto L266;
        i12.e r193 = i12.o.b();
        if (r193 == null) goto L256;
        Object r194 = com.bytedance.android.scope.m.e.d(r193, GiftExtraRepo.class);
    L257:
        GiftExtraRepo r195 = (GiftExtraRepo) r194;
        if (r195 == null) goto L262;
        Long r196 = r195.s(r41.b);
        if (r196 == null) goto L262;
        long r197 = r196.longValue();
    L263:
        l1 r198 = r192.o(r53, r197);
        if (r198 == null) goto L266;
        int r199 = (int) r198.getBuffDiamondCount();
    L267:
        r104 = String.valueOf(((((long) r199) * r48) * r47) * ((long) r103));
    L262:
        r197 = 0;
        goto L263
    L256:
        r194 = null;
    L266:
        r199 = r102.getDiamondCount();
        goto L267
    L250:
        r191 = null;
        goto L251
    L241:
        r103 = 1;
        goto L243
    L234:
        r101 = r41.b;
        goto L235
    L184:
        r89 = false;
    L189:
        i12.e r200 = i12.o.b();
        if (r200 == null) goto L192;
        Object r201 = com.bytedance.android.scope.m.e.d(r200, f1.class);
    L193:
        f1 r202 = (f1) r201;
        if (r202 == null) goto L197;
        r90 = r202.a(r71, r50);
        if (r90 != null) goto L198;
    L197:
        r90 = BuildConfig.FLAVOR;
        goto L198
    L192:
        r201 = null;
        goto L193
    L179:
        r38.put("gift_source", "gift_tab");
        goto L180
    L168:
        GiftContext r203 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r203 == null) goto L175;
        com.bytedance.live.datacontext.n<Bundle> r204 = r203.getGiftLogExtra();
        if (r204 == null) goto L175;
        Bundle r205 = (Bundle) r204.getValue();
        if (r205 == null) goto L175;
        r88 = r205.getString("gift_source");
    L175:
        r88 = null;
        goto L177
    L161:
        r85 = null;
        goto L162
    L156:
        if (tz1.a.d(r71) == false) goto L158;
        r38.put("order_type", tz1.a.b());
        goto L158
    L141:
        r79 = "0";
        goto L142
    L123:
        r77 = 1;
        r112 = 0;
        goto L124
    L126:
        if (TextUtils.isEmpty((CharSequence) r38.get("tab_name")) == true) goto L135;
        LinkedHashMap r206 = (LinkedHashMap) ((e1) com.bytedance.android.live.revenue.core.util.f.a(e1.class)).c;
        Iterator r1100 = r206.keySet().iterator();
    L130:
        if (r1100.hasNext() == false) goto L135;
        int r1101 = ((Number) r1100.next()).intValue();
        Iterator r611 = r1100;
        if (Intrinsics.areEqual((Integer) r206.get(Integer.valueOf(r1101)), r70) == true) goto L133;
        r1100 = r611;
        goto L130
    L133:
        r78 = String.valueOf(r1101 + 1);
    L135:
        r78 = BuildConfig.FLAVOR;
        goto L136
    L137:
        r38.put("tab_name", BuildConfig.FLAVOR);
        r38.put("tab_location", BuildConfig.FLAVOR);
        goto L139
    L108:
        r71 = 0;
        goto L109
    L105:
        r70 = null;
    L70:
        r4 = null;
        goto L71
    L64:
        r37 = "0";
        goto L65
    L60:
        r36 = r64;
        goto L61
    L56:
        r35 = -1;
        goto L57
    L52:
        r33 = -1;
        goto L53
    L48:
        r30 = -1;
        goto L49
    L44:
        r28 = null;
    L40:
        r25 = BuildConfig.FLAVOR;
        goto L41
    L31:
        r20 = r13 % 8;
    L27:
        r23 = 1;
        goto L28
    L21:
        r110 = false;
        goto L22
    L17:
        r18 = 1;
    L13:
        r11 = 0;
        goto L14
    L5:
        r16 = -1;
        goto L6
    }

    public static void P(com.bytedance.android.livesdk.gift.platform.core.model.b0 r37, String r38, IRoom r39, long r40, long r43, p2 r44, String r45, Map r46, DataCenter r47, int r48, boolean r49, int r50, long r51, boolean r53, k3 r54, SeriesSendType r55, String r56, String r57, boolean r58, String r59, String r60, com.bytedance.android.livesdk.gift.platform.core.model.a r61, Map r63, int r64, int r65) {
        if ((r65 & 1024) == 0) goto L5;
        int r7 = 0;
    L7:
        if ((r65 & 2048) == 0) goto L9;
        boolean r16 = false;
    L11:
        if ((r65 & 4096) == 0) goto L13;
        int r17 = 0;
    L14:
        long r26 = 0;
        if ((r65 & 8192) == 0) goto L17;
        long r28 = 0;
    L19:
        if ((r65 & 16384) == 0) goto L21;
        boolean r30 = false;
    L23:
        if ((32768 & r65) == 0) goto L25;
        k3 r18 = null;
    L27:
        if ((65536 & r65) == 0) goto L29;
        SeriesSendType r4 = SeriesSendType.NONE;
    L31:
        if ((131072 & r65) == 0) goto L33;
        String r20 = null;
    L35:
        if ((262144 & r65) == 0) goto L37;
        String r21 = null;
    L39:
        if ((1048576 & r65) == 0) goto L41;
        String r23 = null;
    L43:
        if ((2097152 & r65) == 0) goto L45;
        String r24 = null;
    L47:
        if ((r65 & 16777216) == 0) goto L49;
        int r25 = 1;
    L50:
        Intrinsics.checkNotNullParameter(r37, "giftParamsNew");
        Intrinsics.checkNotNullParameter(r38, "receiverId");
        Intrinsics.checkNotNullParameter(r44, "iSendGiftResult");
        Intrinsics.checkNotNullParameter(r46, "map");
        Intrinsics.checkNotNullParameter(r4, "seriesSendType");
        Map r5 = MapsKt.toMutableMap(r46);
        long r31 = r44.getGiftId();
        if (r37.v == false) goto L53;
        int r19 = r44.getMultiSendSuccessCount();
    L54:
        int r410 = r7;
        r5.putAll(c0(r37, r38, r39, r45, r47, r40, r43, r31, r410, r16, r17, r28, r19, r18, r4, r20, r21, r23, r24, r61, r25));
        boolean r3 = r37.r;
        String r6 = BuildConfig.FLAVOR;
        if (r3 == true) goto L426;
        h2 r8 = GiftManagerKt.l(r37.b);
        String r9 = "1";
        if (r8 == null) goto L70;
        GiftMsgBoard r10 = l0.b(r8);
        if (r10 == null) goto L68;
        String r510 = "live_detail";
        if (r10.forMsgBoard != true) goto L67;
        r5.put("is_message", "1");
        String r411 = "bottom_tab";
        r5.put("message_text", new JSONObject(r37.k).optString("msg_board_content", BuildConfig.FLAVOR));     // Catch: Exception -> L482
    L69:
        Unit r11 = Unit.INSTANCE;
    L71:
        if (r8 == null) goto L79;
        Intrinsics.checkNotNullParameter(r8, "$this$bizType");
        if ((r8 instanceof h1) == true) goto L75;
        h2 r13 = null;
    L76:
        h1 r14 = (h1) r13;
        if (r14 == null) goto L79;
        Integer r15 = Integer.valueOf(r14.getBizType());
    L81:
        if (r15 != null) goto L84;
    L86:
        Object r27 = "0";
    L87:
        r5.put("business_type", r27);
        r5.put("connection_type", e());
        r5.put("consume_type", "direct");
        yz0.k r29 = g();
        if (r29 == null) goto L93;
        String r33 = r29.Ln();
        if (r33 == null) goto L93;
        r6 = r33;
    L93:
        r5.put("resp_from", r6);
        if (r44.getSendTogetherInfo() == null) goto L96;
        String r34 = "together";
    L97:
        r5.put("effect_play_type", r34);
        vh6.c.b(kr2.a.class).appendCastSDKLogCommonParams(r5);
        r5.put("is_screencasting", m2.b(ay1.b.p()));
        if (u.n() == false) goto L121;
        com.bytedance.android.live.revenue.core.a r35 = com.bytedance.android.live.revenue.core.util.k.a();
        if (r35 == null) goto L106;
        n01.a r36 = com.bytedance.android.live.revenue.core.util.f.c(r35, n01.a.class);
        if (r36 == null) goto L106;
        es2.a r41 = r36.E0();
        if (r41 == null) goto L106;
        long r66 = r40;
        long r110 = r43;
        r41.a(r5, new Object[]{m.f(r44, r110, r66)});
        Unit r0 = Unit.INSTANCE;
    L107:
        h2 r1 = GiftManagerKt.l(r37.b);
        if (r1 == null) goto L504;
        long r2 = r66 * r110;
        long r67 = ((long) r1.getDiamondCount()) * r2;
        int r68 = com.bytedance.android.livesdk.utils.e1.a;
        String r69 = String.valueOf(r2);
        String r70 = String.valueOf(r67);
        Intrinsics.checkNotNullParameter(r69, "giftCount");
        Intrinsics.checkNotNullParameter(r70, "money");
        if (r47 != null) goto L113;
    L120:
        Unit r71 = Unit.INSTANCE;
        return;
    L113:
        if (((Boolean) r47.get("enter_from_dou_plus", Boolean.FALSE)).booleanValue() == false) goto L120;
        Map r73 = c1.e(r47);
        r73.put("event_type", "vs_video_native_action");
        r73.remove("refer");
        JSONObject r74 = com.bytedance.android.livesdk.utils.e1.a(r47);
        if (r74 == null) goto L120;
        ILiveDouPlusService r75 = jc1.k.f(ILiveDouPlusService.class);
        if (r75 == null) goto L120;
        r74.put("gift_cnt", r69);
        r74.put("money", r70);
        Unit r76 = Unit.INSTANCE;
        r73.put("ad_extra_data", String.valueOf(r74));
        r75.logEvent(true, "vs_ad", "live_gift", r73);
        goto L120
    L504:
        return;
    L106:
        r66 = r40;
        r110 = r43;
        goto L107
    L121:
        GiftManagerKt.z.getClass();
        Map r111 = GiftManagerKt.o();
        if (r111 != null) goto L124;
    L127:
        boolean r112 = true;
    L128:
        if (r112 == true) goto L133;
        Map r113 = GiftManagerKt.o();
        if (r113 == null) goto L133;
        r5.putAll(r113);
        Unit r114 = Unit.INSTANCE;
    L133:
        if (((com.bytedance.android.livesdk.gift.platform.business.config.n) com.bytedance.android.livesdk.gift.util.b.a().d(com.bytedance.android.livesdk.gift.platform.business.config.n.class)).f() == 0) goto L135;
        String r77 = "scroll";
    L136:
        r5.put("gift_show_type", r77);
        if (r8 == null) goto L141;
        String r115 = "live_interact";
        if (l0.e(r8) != true) goto L142;
        r5.put("free_display", "1");
    L143:
        GiftContext r78 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r78 == null) goto L150;
        Bundle r79 = (Bundle) r78.getGiftLogExtra().getValue();
        if (r79 == null) goto L150;
        String r116 = "contribution_list";
        if (TextUtils.equals(r79.getString("event_module"), "contribution_list") == false) goto L150;
    L151:
        r5.put("is_vr_machine", vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class).getVrMachineLogStr(r47));
        List<IBaseUser> r80 = r37.w;
        if (r80 == null) goto L154;
        int r81 = r80.size();
    L156:
        if (r81 <= 1) goto L158;
    L161:
        boolean r83 = true;
    L162:
        com.bytedance.android.livesdk.revenue.service.interact.d r117 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        if (r8 == null) goto L165;
        long r118 = r8.getId();
    L166:
        r117.I0(r38, r118, r83, r5);
        if (r30 == true) goto L170;
        r9 = "0";
    L170:
        r5.put("combo_upgrade", r9);
        if (r37.v == false) goto L173;
        int r84 = r44.getMultiSendSuccessCount();
    L174:
        String r85 = r116;
        long r119 = r43 * r40;
        r5.put("combo_upgrade_detail", GsonProtectorUtils.toJson(GsonHelper.get(), com.bytedance.revenue.platform.api.core.d.a(new Pair[]{TuplesKt.to(String.valueOf(r37.b), String.valueOf(((long) r84) * r119))})));
        if (r47 == null) goto L188;
        JsonObject r86 = (JsonObject) r47.get("data_multi_fight_profit_egg", new JsonObject());
        if (r86 == null) goto L188;
        JsonElement r87 = r86.get("log");
        if (r87 == null) goto L188;
        JsonObject r88 = r87.getAsJsonObject();
        if (r88 == null) goto L188;
        GsonMap r89 = UtilsKt.i(r88);
        LinkedHashMap r90 = new LinkedHashMap(MapsKt.mapCapacity(r89.size()));
        Iterator r91 = r89.b().iterator();
    L184:
        if (r91.hasNext() == false) goto L186;
        Map.Entry r93 = (Map.Entry) r91.next();
        r90.put(r93.getKey(), String.valueOf(r93.getValue()));
        goto L184
    L186:
        r5.putAll(r90);
        Unit r94 = Unit.INSTANCE;
    L188:
        if (r39 == null) goto L196;
        IMainRoom r95 = r39.castToOrNull(IMainRoom.class);
        if (r95 == null) goto L196;
        com.bytedance.android.live.revenue.model.extension.main.c r96 = r95.getMainOthers();
        if (r96 == null) goto L196;
        IGroupLiveData r97 = r96.getGroupLiveData();
        if (r97 == null) goto L196;
        boolean r98 = r97.isCurrentGroupLive();
    L197:
        if (r98 == false) goto L239;
        i12.d r99 = i12.m.e2.a();
        if (r99 == null) goto L201;
        Object r100 = com.bytedance.android.scope.m.e.d(r99, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f.class);
    L202:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r101 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f) r100;
        if (r101 == null) goto L210;
        Map<String, String> r102 = r101.c;
        if (r102 == null) goto L210;
        String r103 = (String) ((LinkedHashMap) r102).get("group_live_to_user_st");
        if (r103 == null) goto L210;
        r5.put("group_live_to_user_st", r103);
        Unit r104 = Unit.INSTANCE;
    L214:
        GiftContext r105 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r105 == null) goto L221;
        com.bytedance.live.datacontext.n<Bundle> r106 = r105.getGiftLogExtra();
        if (r106 == null) goto L221;
        Bundle r107 = (Bundle) r106.getValue();
        if (r107 == null) goto L221;
        String r108 = r107.getString("gift_show_from");
    L223:
        if (TextUtils.equals("jsb", r108) == false) goto L225;
    L238:
        r5.put("group_live_to_user_st", "path");
        goto L239
    L225:
        if (TextUtils.equals("profile_card", r108) == true) goto L238;
        if (TextUtils.equals("emoji_panel", r108) == true) goto L238;
        if (r37.c != SendGiftSource.GiftDialog) goto L238;
        String r109 = r37.g();
        if (r39 == null) goto L234;
        String r120 = r39.getAnchorId();
    L236:
        if (TextUtils.equals(r109, r120) == false) goto L239;
        r5.put("group_live_to_user_st", "to_room_owner");
        goto L239
    L234:
        r120 = null;
    L221:
        r108 = null;
    L210:
        if (r63 == null) goto L214;
        String r121 = (String) r63.get("group_live_to_user_st");
        if (r121 == null) goto L214;
        r5.put("group_live_to_user_st", r121);
        Unit r122 = Unit.INSTANCE;
        goto L214
    L201:
        r100 = null;
    L239:
        i12.e r123 = i12.o.b();
        if (r123 == null) goto L242;
        Object r124 = com.bytedance.android.scope.m.e.d(r123, f1.class);
    L243:
        f1 r125 = (f1) r124;
        if (r125 == null) goto L248;
        String r126 = r125.c(r37.b);
        if (r126 == null) goto L248;
        r5.put("buff_strategy", r126);
        Unit r127 = Unit.INSTANCE;
    L248:
        com.bytedance.android.live.profit.fansclub.o r128 = yt0.c.c();
        if (r128 == null) goto L259;
        com.bytedance.live.datacontext.m r129 = r128.getProfile();
        if (r129 == null) goto L259;
        com.bytedance.android.live.profit.fansclub.g r130 = (com.bytedance.android.live.profit.fansclub.g) r129.getValue();
        if (r130 == null) goto L259;
        com.bytedance.android.live.profit.fansclub.b r131 = r130.a;
        if (r131 == null) goto L259;
        com.bytedance.android.live.profit.fansclub.m r132 = r131.e;
        if (r132 == null) goto L259;
        r5.put("star_status", r132.a());
        r5.put("star_expire_date", String.valueOf(r132.d));
        Unit r133 = Unit.INSTANCE;
    L259:
        Map<String, String> r134 = r37.b0;
        if (r134 == null) goto L266;
        Iterator<Map.Entry<String, String>> r135 = r134.entrySet().iterator();
    L263:
        if (r135.hasNext() == false) goto L265;
        Map.Entry<String, String> r136 = r135.next();
        r5.put(r136.getKey(), r136.getValue());
        goto L263
    L265:
        Unit r137 = Unit.INSTANCE;
    L266:
        String r138 = "guest";
        if (r37.v == false) goto L284;
        List<IBaseUser> r139 = r37.w;
        if (r139 == null) goto L283;
        ArrayList r140 = new ArrayList();
        ArrayList r141 = new ArrayList();
        Iterator r142 = r139.iterator();
    L272:
        if (r142.hasNext() == false) goto L282;
        IBaseUser r143 = (IBaseUser) r142.next();
        Iterator r412 = r142;
        r140.add(r143.getIdString());
        i12.e r144 = i12.o.b();
        if (r144 == null) goto L276;
        Object r145 = com.bytedance.android.scope.m.e.d(r144, GroupLiveReceiverService.class);
    L277:
        GroupLiveReceiverService r146 = (GroupLiveReceiverService) r145;
        if (r146 == null) goto L280;
        String r147 = r146.h((IRoomBase) r39, r143.getIdString());
    L281:
        r141.add(r147);
        r142 = r412;
        r138 = r138;
        r8 = r8;
        goto L272
    L280:
        r147 = r138;
        goto L281
    L276:
        r145 = null;
        goto L277
    L282:
        h2 r511 = r8;
        r5.put("to_user_id", GsonProtectorUtils.toJson(GsonHelper.get(), r140));
        r5.put("to_user_type", GsonProtectorUtils.toJson(GsonHelper.get(), r141));
        Unit r148 = Unit.INSTANCE;
    L293:
        mz0.n r149 = new mz0.n();
        Map r150 = r149.a;
        Intrinsics.checkNotNullParameter(r150, "map");
        Intrinsics.checkNotNullParameter(r5, "map");
        r150.putAll(r5);
        mz0.m r151 = new mz0.m();
        r151.b(LogCommon.LIVE_SHARE_LOG);
        com.bytedance.android.livesdk.revenue.log.i r152 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r152, "pageSourceLog");
        yz0.k r153 = g();
        if (r153 != null) goto L296;
    L298:
        String r154 = r510;
    L299:
        Intrinsics.checkNotNullParameter(r154, "page");
        r152.c(r154);
        Intrinsics.checkNotNullParameter(r85, "module");
        r152.b(r85);
        String r155 = r115;
        Intrinsics.checkNotNullParameter(r155, "belong");
        r152.a(r155);
        Intrinsics.checkNotNullParameter("other", "type");
        r152.d("other");
        ((ArrayList) r151.a).add(r152.a);
        r151.b(LogCommon.ROOM);
        r151.d(m.f(r44, r43, r40));
        r151.a(GiftLogUtils$logSendGiftInTransaction$13$2$2.INSTANCE);
        r151.b(LogCommon.RECOMMEND_SOURCE_LOG);
        r151.c(LogCommonInstance.LIVE_AD_LOG);
        ((ArrayList) r149.b).addAll(r151.a);
        cy0.e.a.getClass();
        cy0.j r156 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r157 = com.bytedance.android.scope.m.b(r156).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r157);
        ((f80.a) r157).w3("livesdk_send_gift", r149.a, r149.b);
        if (g() == null) goto L340;
        if (r47 == null) goto L339;
        IRoom r158 = r37.H;
        if (r158 == null) goto L339;
        h2 r159 = GiftManagerKt.l(r37.b);
        if (r159 == null) goto L339;
        if (r158.getOwner() == null) goto L339;
        if (c1.b(r47) == false) goto L315;
    L317:
        JSONObject r160 = new JSONObject();
        r160.put("amount", String.valueOf(r119 * ((long) r159.getDiamondCount())));     // Catch: JSONException -> L320
        r160.put("anchor_id", r158.getAnchorId());     // Catch: JSONException -> L320
        r160.put("room_id", String.valueOf(r158.getId()));     // Catch: JSONException -> L320
    L323:
        if (c1.b(r47) == false) goto L326;
        Map r161 = c1.e(r47);
    L330:
        if (c1.b(r47) == false) goto L332;
    L333:
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class).Bb().getClass();
        Intrinsics.checkNotNullParameter(r160, "adExtra");
        k1.f(r160);
    L334:
        LinkedHashMap r162 = new LinkedHashMap();
        Iterator<String> r163 = r160.keys();
    L336:
        if (r163.hasNext() == false) goto L338;
        String r164 = r163.next();
        r162.put(r164, JSONObjectProtectorUtils.getString(r160, r164));
        goto L336
    L338:
        int r165 = x1.a;
        yq2.a r166 = vh6.c.b(yq2.a.class);
        kr2.b r167 = vh6.c.b(kr2.a.class).Lb();
        r167.a(r162);
        r167.b(r161);
        Unit r168 = Unit.INSTANCE;
        r166.Th("live_gift", r167.a.a);
        goto L339
    L332:
        if (c1.c(r47) == false) goto L334;
    L326:
        if (c1.c(r47) == false) goto L328;
        r161 = c1.f(r47);
        goto L330
    L328:
        r161 = x1.a(r47);
    L320:
        e = move-exception;
        e.printStackTrace();
        goto L323
    L315:
        if (c1.c(r47) == true) goto L317;
        int r169 = x1.a;
    L339:
        Unit r170 = Unit.INSTANCE;
    L340:
        if (r58 == false) goto L506;
        String r171 = (String) r5.get("gift_cnt");
        if (r171 == null) goto L344;
        long r172 = CastLongProtector.parseLong(r171);
    L345:
        String r173 = (String) r5.get("gift_row_location");
        if (r173 == null) goto L348;
        int r174 = CastIntegerProtector.parseInt(r173);
    L350:
        if (r410 != 0) goto L355;
        if (r511 == null) goto L353;
        int r175 = r511.getDiamondCount();
    L354:
        long r176 = (((long) r175) + r28) * r172;
        long r177 = r37.b;
    L378:
        i12.e r178 = i12.o.b();
        if (r178 == null) goto L381;
        Object r179 = com.bytedance.android.scope.m.e.d(r178, t1.class);
    L382:
        t1 r180 = (t1) r179;
        if (r180 == null) goto L507;
        com.bytedance.android.livesdk.gift.platform.core.model.k r181 = r37.Q;
        if (r181 == null) goto L387;
        int r182 = r181.b;
    L389:
        if (1 <= r174) goto L392;
    L394:
        boolean r183 = false;
    L395:
        if (r410 == 0) goto L397;
        boolean r184 = true;
    L399:
        if (nz1.a.m().a() == true) goto L402;
        return;
    L402:
        if (r182 != 1) goto L404;
    L406:
        Map<Integer, Map<Long, k2>> r185 = r180.b;
        Integer r186 = Integer.valueOf(r182);
        LinkedHashMap r187 = (LinkedHashMap) r185;
        Object r188 = r187.get(r186);
        if (r188 != null) goto L409;
        r188 = new LinkedHashMap();
        r187.put(r186, r188);
    L409:
        Map r189 = (Map) r188;
        Long r190 = Long.valueOf(r177);
        Object r191 = r189.get(r190);
        if (r191 != null) goto L412;
        int r192 = 0;
        r191 = new k2(0);
        r189.put(r190, r191);
    L413:
        k2 r193 = (k2) r191;
        j2 r194 = r193.b;
        if (r194 != null) goto L416;
        r194 = new j2(r192);
    L416:
        if (r184 == true) goto L418;
        r194.a++;
        r194.b += r172;
    L418:
        r194.c += r176;
        Unit r195 = Unit.INSTANCE;
        r193.b = r194;
        if (r183 == false) goto L508;
        j2 r196 = r193.a;
        if (r196 != null) goto L423;
        r196 = new j2(0);
    L423:
        if (r184 == true) goto L425;
        r196.a++;
        r196.b += r172;
    L425:
        r196.c += r176;
        r193.a = r196;
        return;
    L508:
        return;
    L412:
        r192 = 0;
        goto L413
    L404:
        if (r182 == 15) goto L406;
        return;
    L397:
        r184 = false;
        goto L399
    L392:
        if (2 < r174) goto L394;
        r183 = true;
        goto L395
    L387:
        r182 = 0;
        goto L389
    L507:
        return;
    L381:
        r179 = null;
        goto L382
    L353:
        r175 = 0;
        goto L354
    L355:
        i12.e r197 = i12.o.b();
        if (r197 == null) goto L358;
        Object r198 = com.bytedance.android.scope.m.e.d(r197, GiftExtraRepo.class);
    L359:
        GiftExtraRepo r199 = (GiftExtraRepo) r198;
        if (r199 == null) goto L376;
        Long r200 = r199.s(r37.b);
        if (r200 == null) goto L364;
        long r201 = r200.longValue();
    L365:
        l1 r202 = r199.o(r410, r201);
        if (r202 == null) goto L369;
        int r203 = (int) r202.getBuffDiamondCount();
    L368:
        Integer r204 = Integer.valueOf(r203);
    L372:
        if (r204 == null) goto L374;
        int r205 = r204.intValue();
    L375:
        long r210 = ((long) r205) * r172;
        Unit r206 = Unit.INSTANCE;
        long r310 = r201;
        r176 = r210;
        r26 = r310;
    L377:
        r177 = r26;
        goto L378
    L374:
        r205 = 0;
        goto L375
    L369:
        if (r511 == null) goto L371;
        r203 = r511.getDiamondCount();
        goto L368
    L371:
        r204 = null;
        goto L372
    L364:
        r201 = r37.b;
        goto L365
    L376:
        r176 = 0;
        goto L377
    L358:
        r198 = null;
        goto L359
    L348:
        r174 = -1;
        goto L350
    L344:
        r172 = 0;
        goto L345
    L506:
        return;
    L296:
        if (r153.isAnchor() != true) goto L298;
        r154 = "live_take_detail";
        goto L299
    L283:
        r511 = r8;
        goto L293
    L284:
        r511 = r8;
        String r207 = r37.g();
        r5.put("to_user_id", r207);
        i12.e r208 = i12.o.b();
        if (r208 == null) goto L287;
        Object r209 = com.bytedance.android.scope.m.e.d(r208, GroupLiveReceiverService.class);
    L288:
        GroupLiveReceiverService r211 = (GroupLiveReceiverService) r209;
        if (r211 == null) goto L291;
        String r212 = r211.h((IRoomBase) r39, r207);
    L292:
        r5.put("to_user_type", r212);
        goto L293
    L291:
        r212 = "guest";
        goto L292
    L287:
        r209 = null;
        goto L288
    L242:
        r124 = null;
    L196:
        r98 = false;
        goto L197
    L173:
        r84 = 1;
        goto L174
    L165:
        r118 = 0;
        goto L166
    L158:
        if (r37.v == true) goto L161;
        r83 = false;
        goto L162
    L154:
        r81 = 0;
    L150:
        r116 = r411;
    L142:
        r5.put("free_display", "0");
        goto L143
    L141:
        r115 = "live_interact";
        goto L142
    L135:
        r77 = "slide";
        goto L136
    L124:
        if (r111.isEmpty() == true) goto L127;
        r112 = false;
        goto L128
    L96:
        r34 = "independent";
        goto L97
    L84:
        if (r15.intValue() != 1) goto L86;
        r27 = "1";
        goto L87
    L75:
        r13 = r8;
    L79:
        r15 = null;
    L67:
        r411 = "bottom_tab";
        goto L69
    L68:
        r411 = "bottom_tab";
        r510 = "live_detail";
        goto L69
    L70:
        r411 = "bottom_tab";
        r510 = "live_detail";
        goto L71
    L426:
        mz0.n r213 = new mz0.n();
        Map r214 = r213.a;
        Intrinsics.checkNotNullParameter(r214, "map");
        Intrinsics.checkNotNullParameter(r5, "map");
        r214.putAll(r5);
        mz0.m r215 = new mz0.m();
        r215.b(LogCommon.LIVE_SHARE_LOG);
        com.bytedance.android.livesdk.revenue.log.i r216 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r216, "pageSourceLog");
        yz0.k r217 = g();
        if (r217 != null) goto L429;
    L431:
        String r218 = "live_detail";
    L432:
        Intrinsics.checkNotNullParameter(r218, "page");
        r216.c(r218);
        Intrinsics.checkNotNullParameter("bottom_tab", "module");
        r216.b("bottom_tab");
        Intrinsics.checkNotNullParameter("live_interact", "belong");
        r216.a("live_interact");
        Intrinsics.checkNotNullParameter("other", "type");
        r216.d("other");
        ((ArrayList) r215.a).add(r216.a);
        r215.b(LogCommon.ROOM);
        r215.d(m.f(r44, r43, r40));
        r215.a(GiftLogUtils$logSendGiftInTransaction$17$2$2.INSTANCE);
        r215.c(LogCommonInstance.LIVE_AD_LOG);
        ((ArrayList) r213.b).addAll(r215.a);
        cy0.e.a.getClass();
        cy0.j r219 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r220 = com.bytedance.android.scope.m.b(r219).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r220);
        ((f80.a) r220).w3("livesdk_send_prop", r213.a, r213.b);
        if (r47 != null) goto L436;
        return;
    L436:
        if (c1.b(r47) == false) goto L463;
        if (r39 == null) goto L439;
        IBaseUser r221 = r39.getOwner();
    L440:
        if (r221 == null) goto L463;
        LinkedHashMap r222 = new LinkedHashMap();
        IBaseUser r223 = r39.getOwner();     // Catch: Exception -> L458
        if (r223 == null) goto L446;
        String r224 = r223.getIdString();     // Catch: Exception -> L458
        if (r224 == null) goto L446;
    L447:
        Object r225 = "anchor_id";
        r222.put(r225, r224);     // Catch: Exception -> L456
        String r226 = String.valueOf(Long.valueOf(r39.getId()).longValue());     // Catch: Exception -> L456
        if (r226 != null) goto L451;
        r226 = BuildConfig.FLAVOR;
    L451:
        Object r227 = "room_id";
        r222.put(r227, r226);     // Catch: Exception -> L454
        String r228 = null;
    L462:
        j(r222);
        yq2.a r229 = vh6.c.b(yq2.a.class);
        kr2.b r230 = vh6.c.b(kr2.a.class).Lb();
        r230.a(r222);
        r230.b(c1.e(r47));
        Unit r231 = Unit.INSTANCE;
        r229.Th("sendprop", r230.a.a);
    L465:
        if (c1.c(r47) == false) goto L510;
        if (r39 == null) goto L468;
        String r232 = r39.getOwner();
    L469:
        if (r232 == null) goto L511;
        LinkedHashMap r233 = new LinkedHashMap();
        IBaseUser r234 = r39.getOwner();     // Catch: Exception -> L478
        if (r234 == null) goto L475;
        String r235 = r234.getIdString();     // Catch: Exception -> L478
        if (r235 == null) goto L475;
    L476:
        r233.put(r225, r235);     // Catch: Exception -> L478
        r233.put(r227, r39.getIdStr());     // Catch: Exception -> L478
    L480:
        j(r233);
        yq2.a r236 = vh6.c.b(yq2.a.class);
        kr2.b r237 = vh6.c.b(kr2.a.class).Lb();
        r237.a(r233);
        r237.b(c1.f(r47));
        Unit r238 = Unit.INSTANCE;
        r236.Th("sendprop", r237.a.a);
        return;
    L475:
        r235 = BuildConfig.FLAVOR;
    L478:
        e = move-exception;
        jy0.b.c("GiftLogUtil", r228, e, 2);
        goto L480
    L511:
        return;
    L468:
        r232 = r228;
        goto L469
    L510:
        return;
    L454:
        e = e;
    L461:
        r228 = null;
        jy0.b.c("GiftLogUtil", null, e, 2);
    L456:
        e = e;
    L460:
        r227 = "room_id";
    L446:
        r224 = BuildConfig.FLAVOR;
    L458:
        e = e;
        r225 = "anchor_id";
        goto L460
    L439:
        r221 = null;
    L463:
        r225 = "anchor_id";
        r227 = "room_id";
        r228 = null;
        goto L465
    L429:
        if (r217.isAnchor() != true) goto L431;
        r218 = "live_take_detail";
        goto L432
    L53:
        r19 = 1;
        goto L54
    L49:
        r25 = r64;
        goto L50
    L45:
        r24 = r60;
        goto L47
    L41:
        r23 = r59;
        goto L43
    L37:
        r21 = r57;
        goto L39
    L33:
        r20 = r56;
        goto L35
    L29:
        r4 = r55;
        goto L31
    L25:
        r18 = r54;
        goto L27
    L21:
        r30 = r53;
        goto L23
    L17:
        r28 = r51;
        goto L19
    L13:
        r17 = r50;
        goto L14
    L9:
        r16 = r49;
        goto L11
    L5:
        r7 = r48;
        goto L7
    }
}
