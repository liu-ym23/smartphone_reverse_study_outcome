package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.business.sendGift.GiftTransaction;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.ugc.effectmanager.common.utils.JsonExtKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r3 implements com.bytedance.android.scope.o, tc6.a {
    public final Map<String, com.bytedance.android.livesdk.gift.platform.core.model.t> a;
    public final List<com.bytedance.android.livesdk.gift.platform.core.model.t> b;
    public final boolean c;
    public b d;
    public a e;
    public int f;
    public final i12.e g;
    public final DataCenter h;
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.i0 i;
    public final yz0.k j;
    public final GiftReceiverRepoService k;

    public interface a {
        void a();
    }

    public interface b {
        void a();
    }

    public static final class c<T, R> implements Function {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r2) {
            ExtraResponse r3 = (ExtraResponse) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return (com.bytedance.android.livesdk.gift.model.p2) r3.data;
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
        Long r0 = null;
        this.d = null;
        this.e = null;
        if (this.c == false) goto L15;
        IRoom r1 = com.bytedance.android.livesdk.gift.platform.core.utils.x.a();
        if (r1 == null) goto L16;
        long r2 = r1.getRoomId();
        IRoom r4 = this.j.getRoom();
        if (r4 != null) goto L9;
    L10:
        Pair[] r3 = new Pair[2];
        r3[0] = TuplesKt.to("last_room", String.valueOf(r1.getRoomId()));
        IRoom r5 = this.j.getRoom();
        if (r5 == null) goto L13;
        r0 = Long.valueOf(r5.getRoomId());
    L13:
        r3[1] = TuplesKt.to("cur_room", String.valueOf(r0.longValue()));
        Map r6 = MapsKt.mutableMapOf(r3);
        String r7 = com.bytedance.android.livesdk.gift.platform.core.utils.h.a;
        Intrinsics.checkNotNullParameter(r6, "paramMap");
        mz0.n r8 = new mz0.n();
        Map r9 = r8.a;
        Intrinsics.checkNotNullParameter(r9, "map");
        Intrinsics.checkNotNullParameter(r6, "map");
        r9.putAll(r6);
        mz0.m r10 = new mz0.m();
        r10.b(LogCommon.ROOM);
        com.bytedance.android.livesdk.revenue.log.i r11 = vh6.c.b(kr2.a.class).ud();
        Intrinsics.checkNotNullParameter(r11, "pageSourceLog");
        List r13 = r10.a;
        ArrayList r14 = (ArrayList) r13;
        r14.add(r11.a);
        List r15 = r8.b;
        ArrayList r16 = (ArrayList) r15;
        r16.addAll(r10.a);
        cy0.e.a.getClass();
        cy0.j r17 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r18 = com.bytedance.android.scope.m.b(r17).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r18);
        ((f80.a) r18).w3("livesdk_live_room_status_error", r8.a, r8.b);
        return;
    L9:
        if (r2 != r4.getRoomId()) goto L10;
        return;
    L16:
        return;
    }

    public final String ta() {
        StringBuilder r0 = new StringBuilder();
        r0.append(String.valueOf(hashCode()));
        int r1 = this.f;
        this.f = r1 + 1;
        r0.append(r1);
        return r0.toString();
    }

    public static void g(GiftTransaction r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$insertDefaultInterceptor");
        List<com.bytedance.android.livesdk.gift.platform.core.model.s> r0 = r2.g;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new x02.i());
        r1.add(new x02.g());
        r1.add(new x02.j());
        r1.add(new x02.t());
        List<com.bytedance.android.livesdk.gift.platform.core.model.s> r3 = r2.h;
        ArrayList r4 = (ArrayList) r3;
        r4.add(new x02.c());
        r4.add(new x02.s());
        r4.add(new x02.u());
        r4.add(new x02.e());
        r4.add(new x02.b());
        r4.add(new x02.a());
        r4.add(new x02.n());
        r4.add(new x02.h());
        List<com.bytedance.android.livesdk.gift.platform.core.model.s> r5 = r2.i;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new x02.l());
        r6.add(new x02.f());
        r6.add(new x02.m());
        r6.add(new x02.k());
        r2.l();
    }

    public final void c(GiftTransaction r2) {
        if (this.e == null) goto L5;
    L9:
        ((ArrayList) this.b).add(r2);
        r2.h(new t3(this, r2));
        return;
    L5:
        if (((ArrayList) this.b).isEmpty() == false) goto L9;
        b r0 = this.d;
        if (r0 == null) goto L9;
        r0.a();
        goto L9
    }

    public final GiftTransaction d(com.bytedance.android.livesdk.gift.platform.core.model.b0 r9) {
        boolean r1 = true;
        if (this.c == false) goto L10;
        com.bytedance.android.livesdk.gift.platform.core.model.b0 r10 = a(r9, this.j.getRoom());
        IRoom r3 = this.j.getRoom();
        DataCenter r4 = this.h;
        if (com.bytedance.android.scope.m.e.a(this.g, i12.d.class) != null) goto L8;
        r1 = false;
    L8:
        GiftTransaction r0 = new GiftTransaction(r10, r3, r4, r1);
        g(r0);
        c(r0);
        return r0;
    L10:
        IRoom r2 = com.bytedance.android.livesdk.gift.platform.core.utils.x.a();
        if (r2 == null) goto L18;
        com.bytedance.android.livesdk.gift.platform.core.model.b0 r11 = a(r9, r2);
        DataCenter r5 = this.h;
        if (com.bytedance.android.scope.m.e.a(this.g, i12.d.class) != null) goto L16;
        r1 = false;
    L16:
        GiftTransaction r6 = new GiftTransaction(r11, r2, r5, r1);
        g(r6);
        c(r6);
        return r6;
    L18:
        IRoom r7 = this.j.getRoom();
        DataCenter r8 = this.h;
        if (com.bytedance.android.scope.m.e.a(this.g, i12.d.class) != null) goto L22;
        r1 = false;
    L22:
        GiftTransaction r13 = new GiftTransaction(r9, r7, r8, r1);
        r13.finish();
        return r13;
    }

    public final int f(ReceiverType r3) {
        Intrinsics.checkNotNullParameter(r3, "receiverType");
        if (com.bytedance.android.livesdk.gift.platform.core.utils.x.d() == false) goto L7;
        return 16;
    L7:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.x.c() == false) goto L11;
        return 32;
    L11:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.x.b() == false) goto L15;
        return 64;
    L15:
        if (this.k.h(8) == false) goto L18;
        return 128;
    L18:
        switch(s3.a[r3.ordinal()]) {
            case 1: goto L29;
            case 2: goto L27;
            case 3: goto L27;
            case 4: goto L24;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L26;
            default: goto L20;
        };
    L21:
        return 4;
    L22:
        return 1024;
    L26:
        return 1;
    L27:
        return 2;
    L29:
        return 128;
    L20:
        throw new NoWhenBranchMatchedException();
    L24:
        if (this.k.h(2) == false) goto L26;
        goto L26
    }

    public final void tk(String r2) {
        Intrinsics.checkNotNullParameter(r2, "token");
        com.bytedance.android.livesdk.gift.platform.core.model.t r3 = (com.bytedance.android.livesdk.gift.platform.core.model.t) ((HashMap) this.a).get(r2);
        if (r3 == null) goto L6;
        r3.finish();
        return;
    }

    public final com.bytedance.android.livesdk.gift.platform.core.model.b0 a(com.bytedance.android.livesdk.gift.platform.core.model.b0 r25, IRoom r26) {
        n01.a r3 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), n01.a.class);
        r25.getClass();
        JSONObject r0 = (JSONObject) this.h.get("data_gift_send_extra", new JSONObject());
        if (r0 == null) goto L6;
        JSONObject r1 = r0.optJSONObject("extra");
        if (r1 == null) goto L6;
    L7:
        JSONObject r4 = (JSONObject) this.h.get("data_gift_send_extra", new JSONObject());
        if (r4 == null) goto L11;
        JSONObject r5 = r4.optJSONObject("extra_for_track");
        if (r5 == null) goto L11;
    L12:
        String r6 = r25.k;
        JsonElement r7 = new JsonObject();
        if (r6 == null) goto L23;
        if (r6.length() <= 0) goto L17;
        boolean r11 = true;
    L18:
        if (r11 != true) goto L23;
        r7 = (JsonObject) GsonHelper.get().fromJson(r6, JsonObject.class);     // Catch: Exception -> L21
    L21:
        jy0.b.c("GiftExtraBuilder", "GiftExtraBuilder input is not jsonString", null, 4);
        goto L23
    L17:
        r11 = false;
    L23:
        if (r1.length() <= 0) goto L32;
        if (r1.length() <= 0) goto L32;
        Iterator<String> r8 = r1.keys();
    L29:
        if (r8.hasNext() == false) goto L32;
        String r13 = r8.next();
        r7.addProperty(r13, r1.get(r13).toString());
    L32:
        if (r3 == null) goto L34;
        long r14 = r3.getCameraId();
    L36:
        if (r14 <= 0) goto L45;
        if (r3 == null) goto L39;
        Long r2 = Long.valueOf(r3.getCameraId());
    L40:
        if (r2 == null) goto L45;
        if (r2.longValue() <= 0) goto L45;
        JsonObject r9 = new JsonObject();
        r9.addProperty("camera_id", r2);
        r7.addProperty("vs", r9.toString());
        goto L45
    L39:
        r2 = null;
    L45:
        String r10 = r7.toString();
        int r15 = com.bytedance.android.live.revenue.common.g0.a;
        DataCenter r16 = this.h;
        if (r16 != null) goto L221;
        JSONObject r17 = new JSONObject();
    L48:
        JSONObject r18 = r17;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L67
        Object r20 = Result.constructor-impl(new JSONObject(r10));     // Catch: Throwable -> L67
    L70:
        if (Result.isFailure-impl(r20) == false) goto L72;
        r20 = null;
    L72:
        JSONObject r21 = (JSONObject) r20;
        if (r21 != null) goto L75;
        r21 = new JSONObject();
    L75:
        if (r18 == null) goto L77;
        r21.put("enter_attr", r18.toString());
    L77:
        String r23 = r21.toString();
        if (r25.v == true) goto L113;
        dq2.v r24 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).Ag();
        if (r24 == null) goto L113;
        String r27 = r25.g();
        yz0.k r110 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r110 == null) goto L86;
        IRoom r111 = r110.getRoom();
        if (r111 == null) goto L86;
        String r112 = r111.getAnchorId();
    L88:
        if (Intrinsics.areEqual(r27, r112) == true) goto L113;
        if (r25.g().length() != 0) goto L92;
        boolean r28 = true;
    L93:
        if (r28 == true) goto L113;
        if (r24.d() == false) goto L113;
        JSONObject r29 = new JSONObject();
        Long r113 = StringsKt.toLongOrNull(r25.g());
        if (r113 == null) goto L100;
        long r114 = r113.longValue();
    L101:
        r29.put("team_id", r24.c(r114));
        Object r30 = Result.constructor-impl(new JSONObject(r23));     // Catch: Throwable -> L104
    L107:
        if (Result.isFailure-impl(r30) == false) goto L109;
        r30 = null;
    L109:
        JSONObject r31 = (JSONObject) r30;
        if (r31 != null) goto L112;
        r31 = new JSONObject();
    L112:
        r31.put("linkmic_teamfight", r29.toString());
        r23 = r31.toString();
    L104:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L107
    L100:
        r114 = 0;
        goto L101
    L92:
        r28 = false;
    L86:
        r112 = null;
    L113:
        Long r34 = r25.D;
        Long r35 = r25.e;
        int r115 = r25.J;
        String r116 = r25.E;
        Long r117 = r25.d0;
        IBaseUser r36 = r25.d;
        if (r36 == null) goto L138;
        GiftReceiverRepoService r118 = this.k;
        Intrinsics.checkNotNullParameter(r36, "$this$secUidExt");
        if (GiftReceiverRepoService.g(r118, r36.getCastSecUid(), null, 2) == null) goto L118;
        boolean r37 = true;
    L119:
        if (r37 == false) goto L138;
        List<IBaseUser> r38 = r25.w;
        if (r38 == null) goto L123;
        int r39 = r38.size();
    L125:
        if (r25.v == true) goto L133;
        if (r39 > 0) goto L133;
        IBaseUser r40 = r25.d;
        Intrinsics.checkNotNull(r40);
        Long r41 = Long.valueOf(r40.getLiveRoomId());
        IBaseUser r43 = r25.d;
        Intrinsics.checkNotNull(r43);
        String r44 = r43.getIdString();
        Long r45 = r25.D;
        if (r45 == null) goto L131;
        long r119 = r45.longValue();
    L132:
        Long r46 = Long.valueOf(r119);
        jy0.b.d("NewVideoLinkAnchor", "sendGiftList change allMic=false " + r25.r + ' ' + r25.v + ' ' + r41 + ' ' + r46 + ' ' + r44 + ' ');
        Long r120 = r41;
        r116 = r44;
        Long r210 = r46;
        r115 = 1;
    L139:
        ReceiverType r47 = r25.u;
        if (r47 != null) goto L188;
        IBaseUser r48 = r25.d;
        if (r48 != null) goto L144;
        r48 = r26.getOwner();
    L144:
        if (r48 != null) goto L146;
    L187:
        r47 = ReceiverType.Anchor;
        goto L188
    L146:
        if (Intrinsics.areEqual(r48.getIdString(), this.j.getRoom().getAnchorId()) == true) goto L187;
        String r49 = r48.getIdString();
        i12.d r50 = i12.m.e2.a();
        if (r50 == null) goto L151;
        Object r51 = com.bytedance.android.scope.m.e.d(r50, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f.class);
    L152:
        com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f r53 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.f) r51;
        if (r53 == null) goto L157;
        IBaseUser r54 = r53.a;
        if (r54 == null) goto L157;
        String r55 = r54.getIdString();
    L159:
        if (Intrinsics.areEqual(r49, r55) == false) goto L162;
        r47 = this.i.a();
        goto L188
    L162:
        if (this.k.h(8) == false) goto L172;
        String r56 = r48.getIdString();
        IBaseUser r57 = this.j.getRoom().getOwner();
        if (r57 == null) goto L166;
        String r58 = r57.getIdString();
    L168:
        if (Intrinsics.areEqual(r56, r58) == false) goto L170;
        r47 = ReceiverType.Anchor;
        goto L188
    L170:
        r47 = ReceiverType.GroupLive;
        goto L188
    L166:
        r58 = null;
        goto L168
    L172:
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == false) goto L175;
        r47 = ReceiverType.Anchor;
        goto L188
    L175:
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.l(r48) == false) goto L178;
        r47 = ReceiverType.Anchor;
        goto L188
    L178:
        if (this.k.K(r48, 4) == false) goto L181;
        r47 = ReceiverType.OtherAnchor;
        goto L188
    L181:
        if (this.k.K(r48, 2) == false) goto L184;
        r47 = ReceiverType.Guest;
        goto L188
    L184:
        if (this.k.K(r48, 1024) == false) goto L186;
        r47 = ReceiverType.Audience;
        goto L188
    L186:
        r47 = ReceiverType.Audience;
    L157:
        r55 = null;
        goto L159
    L151:
        r51 = null;
    L188:
        ReceiverType r59 = r47;
        if (r3 != null) goto L191;
    L202:
        i12.d r60 = i12.m.e2.a();
        if (r60 == null) goto L205;
        Object r121 = com.bytedance.android.scope.m.e.d(r60, GiftPanelTraceService.class);
    L206:
        GiftPanelTraceService r61 = (GiftPanelTraceService) r121;
        if (r61 == null) goto L209;
        r61.d("toEpisodeId: from VSLive room");
    L209:
        IEpisodeExtraInfo r63 = r26.getEpisodeExtra();
        if (r63 == null) goto L213;
        long r122 = r63.getId();
    L212:
        long r211 = r122;
    L214:
        if (r115 == 0) goto L216;
        int r123 = r115;
    L218:
        return com.bytedance.android.livesdk.gift.platform.core.model.b0.b(r25, 0, r41, 0, r23, null, r59, r120, r116, r26, r211, r123, JsonExtKt.toMap(r5), r210, -805831177, 4194280);
    L216:
        r123 = f(r59);
    L213:
        r211 = 0;
        goto L214
    L205:
        r121 = null;
        goto L206
    L191:
        if (r3.Fm() != true) goto L202;
        i12.d r124 = i12.m.e2.a();
        if (r124 == null) goto L195;
        Object r125 = com.bytedance.android.scope.m.e.d(r124, GiftPanelTraceService.class);
    L196:
        GiftPanelTraceService r126 = (GiftPanelTraceService) r125;
        if (r126 == null) goto L199;
        r126.d("toEpisodeId: from VSVideo");
    L199:
        Episode r64 = r3.jf();
        if (r64 == null) goto L213;
        r122 = r64.getRoomIdExt();
        goto L212
    L195:
        r125 = null;
        goto L196
    L131:
        r119 = r26.getRoomId();
    L133:
        Long r65 = r25.D;
        if (r65 == null) goto L136;
        long r212 = r65.longValue();
    L137:
        r35 = Long.valueOf(r212);
        jy0.b.d("NewVideoLinkAnchor", "sendGiftList change allMic=true " + r25.r + ' ' + r25.v + ' ' + r39 + ' ' + r35);
        goto L138
    L136:
        r212 = r26.getRoomId();
        goto L137
    L123:
        r39 = 0;
        goto L125
    L118:
        r37 = false;
    L138:
        r120 = r34;
        r41 = r35;
        r210 = r117;
    L67:
        th = move-exception;
        Result.Companion r66 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L70
    L221:
        Result.Companion r67 = Result.Companion;     // Catch: Throwable -> L59
        HashMap r68 = (HashMap) r16.get("data_room_business_extra", null);     // Catch: Exception -> L52 Throwable -> L59
    L54:
        if (r68 == null) goto L56;
        String r69 = (String) r68.get("send_gift");     // Catch: Throwable -> L59
    L57:
        Object r70 = Result.constructor-impl(new JSONObject(r69));     // Catch: Throwable -> L59
    L62:
        if (Result.isFailure-impl(r70) == false) goto L64;
        r70 = null;
    L64:
        r17 = (JSONObject) r70;
        goto L48
    L56:
        r69 = null;
        goto L57
    L52:
        e = move-exception;
        ALogger.e("RevRoomParamsUtils", e);     // Catch: Throwable -> L59
        r68 = null;
    L59:
        th = move-exception;
        Result.Companion r71 = Result.Companion;
        r70 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L62
    L34:
        r14 = 0;
    L11:
        r5 = new JSONObject();
    L6:
        r1 = new JSONObject();
        goto L7
    }

    public final Observable<com.bytedance.android.livesdk.gift.model.p2> q7(String r66, hd6.c r67, int r68) {
        Intrinsics.checkNotNullParameter(r67, "params");
        com.bytedance.android.livesdk.gift.platform.core.model.t r3 = (com.bytedance.android.livesdk.gift.platform.core.model.t) ((HashMap) this.a).get(r66);
        String r4 = BuildConfig.FLAVOR;
        if (r3 == null) goto L25;
        int r6 = r67.a;
        IBaseUser r7 = r67.j;
        if (r7 == null) goto L8;
        String r8 = r7.getIdString();
        if (r8 == null) goto L8;
    L9:
        if (r8 != null) goto L11;
        r8 = BuildConfig.FLAVOR;
    L11:
        long r9 = CastLongProtector.parseLong(r67.a());
        if (r3.i().b == r6) goto L14;
    L18:
        boolean r10 = false;
    L19:
        if (r10 == true) goto L22;
        r3 = null;
    L22:
        if (r3 == null) goto L25;
    L63:
        r3.d(r68);
        return r3.getObservable().map(c.a);
    L14:
        if (Intrinsics.areEqual(r3.i().g(), r8) == false) goto L18;
        if (r3.i().e() != r9) goto L18;
        r10 = true;
    L8:
        r8 = null;
    L25:
        int r5 = r67.a;
        IBaseUser r11 = r67.j;
        if (r11 == null) goto L29;
        String r13 = r11.getIdString();
        if (r13 == null) goto L29;
    L30:
        if (r13 == null) goto L33;
        r4 = r13;
    L33:
        long r14 = CastLongProtector.parseLong(r67.a());
        int r15 = r67.c;
        List r16 = r67.d;
        String r17 = r67.f;
        long r18 = r67.e;
        SendGiftSource r19 = r67.g;
        int r2 = r67.h;
        long r110 = r5;
        if (r19 != null) goto L36;
        SendGiftSource r20 = SendGiftSource.GiftDialog;
    L37:
        GiftReceiverRepoService r21 = (GiftReceiverRepoService) com.bytedance.android.scope.m.e.d(this.g, GiftReceiverRepoService.class);
        if (r21 == null) goto L49;
        List<IBaseUser> r23 = r21.k().a;
        if (r23 == null) goto L49;
        Iterator<T> r24 = r23.iterator();
    L43:
        if (r24.hasNext() == false) goto L47;
        Object r25 = r24.next();
        if (Intrinsics.areEqual(((IBaseUser) r25).getIdString(), r4) == false) goto L43;
    L48:
        IBaseUser r111 = (IBaseUser) r25;
    L50:
        Long r112 = Long.valueOf(r14);
        if (r2 != 0) goto L54;
        r2 = f(ReceiverType.Anchor);
    L54:
        int r43 = r2;
        if (r16 == null) goto L59;
        List r26 = CollectionsKt.toList(r16);
        if (r26 == null) goto L59;
        ArrayList r27 = new ArrayList(r26);
    L60:
        r3 = d(new com.bytedance.android.livesdk.gift.platform.core.model.b0(r110, r20, r111, r112, 0, 0, "gift_tab", null, null, null, r15, null, r27, false, null, 0, false, null, 0, null, false, null, false, 0, null, null, null, null, null, null, null, null, r43, r18, r17, null, false, null, null, null, null, null, null, false, null, null, null, null, 0, null, null, -5200, 8388563));
        ((HashMap) this.a).put(r3.toString(), r3);
        if (r66 == null) goto L63;
        ((HashMap) this.a).put(r66, r3);
    L59:
        r27 = null;
        goto L60
    L47:
        r25 = null;
    L49:
        r111 = null;
        goto L50
    L36:
        r20 = r19;
    L29:
        r13 = null;
        goto L30
    }

    public r3(i12.e r2, DataCenter r3, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.i0 r4, yz0.k r5, GiftReceiverRepoService r6) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "receiverService");
        Intrinsics.checkNotNullParameter(r5, "roomDataService");
        Intrinsics.checkNotNullParameter(r6, "giftReceiverRepoService");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.k = r6;
        this.a = new HashMap();
        this.b = new ArrayList();
        this.c = ((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.e0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[55])).booleanValue();
        this.f = 1;
    }
}
