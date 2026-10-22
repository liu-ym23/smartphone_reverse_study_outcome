package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcastgame.api.model.SupportLiveMode;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.chatroom.model.w2;
import com.bytedance.android.livesdk.chatroom.model.x;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.ea0;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.message.model.TempStateAreaReachMessage;
import com.bytedance.android.livesdk.room.placeholder.behavior.m;
import com.bytedance.android.livesdk.room.placeholder.behavior.n;
import com.bytedance.android.livesdk.room.placeholder.behavior.o;
import com.bytedance.android.livesdk.room.placeholder.behavior.p;
import com.bytedance.android.livesdk.utils.d2;
import com.bytedance.android.livesdk.utils.e2;
import com.bytedance.android.livesdk.utils.v5;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import gd0.v;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tR\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/TempAreaDynamicLoader;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/loader/AbsDynamicLoader;", "Lvlc/l;", "Landroid/content/Context;", "r", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TempAreaDynamicLoader extends AbsDynamicLoader implements l {
    public static final /* synthetic */ int t = 0;
    public boolean h;
    public o i;
    public final ArrayList<ExtendedToolbarButton.c> j;
    public final ArrayList<ExtendedToolbarButton.c> k;
    public final ArrayList<ExtendedToolbarButton> l;
    public vlc.d m;
    public CompositeDisposable n;
    public boolean o;
    public final String p;
    public final x3 q;
    public final Context r;
    public final Function1<String, Unit> s;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ TempAreaDynamicLoader a;
        public final /* synthetic */ String b;

        public b(TempAreaDynamicLoader r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r33) {
            com.bytedance.android.live.network.response.e r0 = (com.bytedance.android.live.network.response.e) r33;
            Intrinsics.checkNotNullParameter(r0, "resp");
            x r1 = (x) ((ExtraResponse) r0).data;
            if (r1 == null) goto L165;
            Intrinsics.checkNotNullParameter(r1, "$this$toLocalCollectModel");
            Boolean r3 = r1.disable;
            boolean r4 = true;
            if (r3 == null) goto L7;
            boolean r5 = r3.booleanValue();
        L8:
            ImageModel r6 = r1.icon;
            if (r6 == null) goto L16;
            List r7 = r6.getUrls();
            if (r7 == null) goto L16;
            String r8 = (String) ListProtector.get(r7, 0);
            if (r8 == null) goto L16;
            String r9 = r8;
        L17:
            String r10 = r1.title;
            if (r10 != null) goto L20;
            String r11 = "";
        L21:
            String r12 = r1.entranceSchema;
            if (r12 != null) goto L24;
            r12 = "";
        L24:
            List r2 = r1.items;
            int r13 = 10;
            if (r2 == null) goto L68;
            List r14 = r2;
            ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
            Iterator<T> r16 = r14.iterator();
        L28:
            if (r16.hasNext() == false) goto L67;
            x.a r17 = (x.a) r16.next();
            Intrinsics.checkNotNullParameter(r17, "$this$toLocalModel");
            String r18 = r17.appId;
            if (r18 != null) goto L32;
            String r19 = "";
        L33:
            String r110 = r17.name;
            if (r110 != null) goto L36;
            String r111 = "";
        L37:
            ImageModel r112 = r17.iconUrl;
            if (r112 == null) goto L45;
            List r113 = r112.getUrls();
            if (r113 == null) goto L45;
            String r114 = (String) ListProtector.get(r113, 0);
            if (r114 == null) goto L45;
            String r115 = r114;
        L46:
            String r116 = r17.version;
            if (r116 != null) goto L49;
            String r117 = "";
        L50:
            String r118 = r17.config;
            if (r118 != null) goto L53;
            String r119 = "";
        L54:
            String r120 = r17.desc;
            if (r120 != null) goto L57;
            String r20 = "";
        L58:
            Boolean r121 = r17.disabled;
            if (r121 == null) goto L61;
            boolean r21 = !r121.booleanValue();
        L62:
            String r122 = r17.gameCategory;
            if (r122 != null) goto L65;
            String r22 = "";
        L66:
            r15.add(new w2(r19, r111, r115, r117, r119, r20, r21, r22));
            goto L28
        L65:
            r22 = r122;
            goto L66
        L61:
            r21 = false;
            goto L62
        L57:
            r20 = r120;
            goto L58
        L53:
            r119 = r118;
            goto L54
        L49:
            r117 = r116;
        L45:
            r115 = "";
            goto L46
        L36:
            r111 = r110;
            goto L37
        L32:
            r19 = r18;
            goto L33
        L67:
            ArrayList r23 = r15;
        L69:
            Intrinsics.checkNotNullParameter(r9, "icon");
            Intrinsics.checkNotNullParameter(r11, LiveEndPageData.TAG_TITLE);
            Intrinsics.checkNotNullParameter(r12, "entranceSchema");
            if (r5 == false) goto L72;
        L84:
            long r24 = TempStateAreaReachMessage.ELEM_TYPE.OPEN_GAME.getType();
            if (r23 == null) goto L165;
            ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
            Iterator<T> r26 = r23.iterator();
            int r27 = 0;
        L88:
            if (r26.hasNext() == false) goto L157;
            T r28 = r26.next();
            int r29 = r27 + 1;
            if (r27 >= 0) goto L92;
            CollectionsKt.throwIndexOverflow();
        L92:
            w2 r30 = (w2) r28;
            Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L148
            JsonObject r124 = new JsonParser().parse(r30.e).getAsJsonObject();     // Catch: Throwable -> L148
            long r210 = r124.get("game_id").getAsLong();     // Catch: Throwable -> L148
            String r211 = r124.get("schema").getAsString();     // Catch: Throwable -> L148
            int r212 = r124.get("game_type").getAsInt();     // Catch: Throwable -> L148
            Long r125 = (Long) this.a.a.get("data_anchor_current_game_id", -1L);     // Catch: Throwable -> L148
            if (r125 != null) goto L97;
        L99:
            boolean r213 = false;
        L100:
            JsonArray r126 = r124.get("support_live_scene").getAsJsonArray();     // Catch: Throwable -> L148
            if (r126 == null) goto L108;
            List r127 = CollectionsKt.toList(r126);     // Catch: Throwable -> L148
            if (r127 == null) goto L108;
            List r128 = r127;     // Catch: Throwable -> L148
            ArrayList r129 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r128, r13));     // Catch: Throwable -> L148
            Iterator<T> r130 = r128.iterator();     // Catch: Throwable -> L148
        L106:
            if (r130.hasNext() == false) goto L109;
            r129.add(Integer.valueOf(((JsonElement) r130.next()).getAsInt()));     // Catch: Throwable -> L148
        L109:
            ALogger.i(this.a.p, String.valueOf(r129));     // Catch: Throwable -> L148
            if (r129 != null) goto L112;
        L115:
            boolean r131 = true;
        L116:
            if (r131 == false) goto L118;
        L143:
            r25 = r25;
            Iterator<T> r214 = r26;
            long r215 = r24;
            int r31 = r29;
            ExtendedToolbarButton.c r32 = null;
        L144:
            Object r34 = Result.constructor-impl(r32);     // Catch: Throwable -> L146
        L153:
            Throwable r35 = Result.exceptionOrNull-impl(r34);
            if (r35 == null) goto L156;
            ALogger.e(this.a.p, "parse collect item config error", r35);
        L156:
            ArrayList r36 = r25;
            r36.add(Result.box-impl(r34));
            r25 = r36;
            r26 = r214;
            r24 = r215;
            r27 = r31;
            r13 = 10;
            goto L88
        L118:
            if (TempAreaDynamicLoader.f(this.a, r129) == false) goto L143;
            TempAreaDynamicLoader r132 = this.a;     // Catch: Throwable -> L148
            String r133 = r30.c;     // Catch: Throwable -> L148
            String r134 = r30.b;     // Catch: Throwable -> L148
            String r135 = r30.a;     // Catch: Throwable -> L148
            boolean r136 = Intrinsics.areEqual(this.b, r135);     // Catch: Throwable -> L148
            r132.getClass();     // Catch: Throwable -> L148
            r32 = TempAreaDynamicLoader.j(r133, r134, "", r135, r24, r210, r136);     // Catch: Throwable -> L148
            if (TextUtils.isEmpty(r30.h) == true) goto L123;
            String r137 = r30.h;     // Catch: Throwable -> L148
        L124:
            r32.o = r137;     // Catch: Throwable -> L148
            TempAreaDynamicLoader r138 = this.a;     // Catch: Throwable -> L148
            if (r138.d == false) goto L127;
            c0 r139 = y3.f(r138.a);     // Catch: Throwable -> L148
        L128:
            c0 r140 = r139;
            DataCenter r141 = this.a.a;     // Catch: Throwable -> L148
            String r142 = r30.d;     // Catch: Throwable -> L148
            String r37 = r30.a;     // Catch: Throwable -> L148
            r214 = r26;
            r215 = r24;
            r25 = r25;
            r31 = r29;
            n r143 = new n(r141, r210, r142, r37, r211, r30.b, r212, r137, r30.g, r27, r213, Intrinsics.areEqual(this.b, r37), r30.c);     // Catch: Throwable -> L146
            if (r30.g == true) goto L138;
            if (r213 == true) goto L138;
            r140.l(r32, "该玩法需要主播发起，您可以去其他直播间或换其他玩法");     // Catch: Throwable -> L146
        L138:
            r140.p(r32, r143);     // Catch: Throwable -> L146
        L146:
            th = th;
        L152:
            Result.Companion r38 = Result.Companion;
            r34 = Result.constructor-impl(ResultKt.createFailure(th));
        L139:
            th = th;
            r25 = r25;
        L151:
            r31 = r29;
        L141:
            th = th;
        L150:
            r215 = r24;
            goto L151
        L127:
            r139 = y3.i(r138.a);     // Catch: Throwable -> L148
            goto L128
        L123:
            r137 = null;
            goto L124
        L112:
            if (r129.isEmpty() == true) goto L115;
            r131 = false;
        L108:
            r129 = null;
            goto L109
        L97:
            if (r125.longValue() != r210) goto L99;
            r213 = true;
        L148:
            th = th;
            r214 = r26;
            goto L150
        L157:
            ArrayList r39 = r25;
            ArrayList r40 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r39, 10));
            Iterator r41 = r39.iterator();
        L159:
            if (r41.hasNext() == false) goto L186;
            Object r42 = ((Result) r41.next()).unbox-impl();
            if (Result.isFailure-impl(r42) == false) goto L163;
            r42 = null;
        L163:
            r40.add((ExtendedToolbarButton.c) r42);
            goto L159
        L186:
            return CollectionsKt.filterNotNull(r40);
        L72:
            if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r12) == false) goto L84;
            TempAreaDynamicLoader r43 = this.a;
            int r44 = TempAreaDynamicLoader.t;
            r43.getClass();
            ArrayList r45 = new ArrayList();
            ExtendedToolbarButton.c r46 = TempAreaDynamicLoader.j(r9, r11, "", "", TempStateAreaReachMessage.ELEM_TYPE.PROFIT_OPEN_GAME_ENTRANCE.getType(), 8848, true);
            if (r43.d == false) goto L76;
            c0 r47 = y3.f(r43.a);
        L77:
            Context r48 = r43.r;
            if (r23 != null) goto L80;
        L82:
            r4 = false;
        L83:
            r47.p(r46, new m(r48, r46, r12, r4));
            r45.add(r46);
            return r45;
        L80:
            if ((!r23.isEmpty()) != true) goto L82;
        L76:
            r47 = y3.i(r43.a);
            goto L77
        L68:
            r23 = null;
            goto L69
        L20:
            r11 = r10;
        L16:
            r9 = "";
            goto L17
        L7:
            r5 = true;
        L165:
            return null;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ TempAreaDynamicLoader a;
        public final /* synthetic */ String b;

        public c(TempAreaDynamicLoader r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            List r5 = (List) r4;
            if (r5 == null) goto L5;
            this.a.k.addAll(r5);
            this.a.s.invoke("collect list fetch success");
        L5:
            String r6 = this.b;
            if (r6 != null) goto L8;
        L13:
            this.a.o = false;
            return;
        L8:
            if (r6.length() <= 0) goto L10;
            boolean r7 = true;
        L11:
            if (r7 != true) goto L13;
            this.a.a.put("cmd_toolbar_click_update_red_dot", "");
            goto L13
        L10:
            r7 = false;
            goto L11
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ TempAreaDynamicLoader a;

        public d(TempAreaDynamicLoader r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            String r0 = this.a.p;
            ALogger.e(r0, "fetch collect list error", (Throwable) r3);
            this.a.o = false;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final List<a2> c() {
        ArrayList r0 = new ArrayList();
        r0.addAll(this.l);
        ArrayList<ExtendedToolbarButton.c> r1 = this.j;
        ArrayList r2 = new ArrayList();
        Iterator<ExtendedToolbarButton.c> r3 = r1.iterator();
    L3:
        boolean r4 = false;
        if (r3.hasNext() == false) goto L10;
        ExtendedToolbarButton.c r5 = r3.next();
        if (r5.n == TempStateAreaReachMessage.ELEM_TYPE.OPEN_GAME.getType()) goto L8;
        r4 = true;
    L8:
        if (r4 == false) goto L3;
        r2.add(r5);
        goto L3
    L10:
        ArrayList r6 = new ArrayList();
        Iterator r7 = r2.iterator();
    L12:
        if (r7.hasNext() == false) goto L22;
        Object r8 = r7.next();
        if (((ExtendedToolbarButton.c) r8).n != TempStateAreaReachMessage.ELEM_TYPE.PREDICTOR.getType()) goto L16;
        boolean r9 = true;
    L17:
        if (r9 == false) goto L19;
        boolean r10 = yx1.a.b(this.g);
    L20:
        if (r10 == false) goto L12;
        r6.add(r8);
        goto L12
    L19:
        r10 = true;
        goto L20
    L16:
        r9 = false;
        goto L17
    L22:
        r0.addAll(r6);
        e2.c(r0, this.q);
        Intrinsics.checkNotNullParameter(r0, "$this$sortBySpecificRule");
        Collections.sort(r0, d2.a);
        if (com.bytedance.android.livesdk.config.setting.o.a() == true) goto L25;
    L27:
        List<ExtendedToolbarButton.c> r11 = this.k;
    L28:
        r0.addAll(r11);
        ArrayList r12 = new ArrayList();
        if (r0.size() <= 16) goto L31;
        r12.addAll(r0.subList(0, (int) 16));
    L32:
        return r12;
    L31:
        r12.addAll(r0);
        goto L32
    L25:
        if (this.k.size() <= 5) goto L27;
        r11 = this.k.subList(0, 5);
        goto L28
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void d() {
        this.k.clear();
        Room r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        if (g() == false) goto L10;
        long r1 = r0.id;
        this.h = true;
        com.bytedance.android.livesdk.service.l.d().getClass();
        Disposable r2 = ((RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class)).fetchTempStateAreaData(r1).compose(RxUtil.rxSchedulerHelper()).map(new h(this)).subscribe(new i(this), new j(this));
        CompositeDisposable r3 = this.n;
        if (r3 == null) goto L10;
        r3.add(r2);
    L10:
        h();
    }

    public final boolean g() {
        if (tb1.c.c == false) goto L6;
        return false;
    L6:
        if (this.c == false) goto L8;
    L14:
        return false;
    L8:
        if (this.g == null) goto L14;
        if (this.h == true) goto L14;
        return ea0.a.getValue().booleanValue();
    }

    public final void h() {
        if (this.d == true) goto L5;
        return;
    L5:
        if (this.o == true) goto L40;
        this.o = true;
        String r0 = v5.b().getString("live_collect_game_and_should_show_hot_dot", "");
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m r5 = null;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L12;
        com.bytedance.live.datacontext.j r2 = r1.getCompactTbLoader();
        if (r2 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m r3 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) r2.getValue();
    L14:
        if ((r3 instanceof com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) == false) goto L17;
        r5 = r3;
    L17:
        int r4 = 0;
        if (r5 == null) goto L20;
        boolean r6 = r5.isComponentShowing(6);
    L21:
        if (r6 == false) goto L38;
        su0.a r7 = yt0.c.g();
        if (r7 == null) goto L25;
        r4 = r7.pf();
    L25:
        com.bytedance.android.livesdk.service.l.d().getClass();
        RoomRetrofitApi r8 = (RoomRetrofitApi) com.bytedance.android.live.network.c.b().e(RoomRetrofitApi.class);
        Room r9 = this.g;
        if (r9 == null) goto L28;
        long r10 = r9.id;
    L29:
        if (r9 == null) goto L32;
        String r11 = r9.getOwnerUserIdString();
        if (r11 == null) goto L32;
    L33:
        Disposable r12 = RxUtilKt.h(r8.fetchProfitCollectList(r10, r11, 1, r4).map(new b(this, r0))).subscribe(new c(this, r0), new d(this));
        CompositeDisposable r13 = this.n;
        if (r13 == null) goto L39;
        r13.add(r12);
        return;
    L39:
        return;
    L32:
        r11 = "-1";
        goto L33
    L28:
        r10 = -1;
        goto L29
    L38:
        return;
    L20:
        r6 = false;
    L12:
        r3 = null;
        goto L14
    }

    public final o i() {
        if (this.i != null) goto L5;
        this.i = new o();
    L5:
        o r0 = this.i;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onLoad() {
        this.n = new CompositeDisposable();
        vlc.d r0 = (vlc.d) this.a.get("data_message_manager", null);
        this.m = r0;
        if (r0 == null) goto L5;
        r0.addMessageListener(MessageType.TEMP_STATE_AREA_MESSAGE.getIntType(), this);
    L5:
        com.bytedance.android.livesdk.service.l.d().f().c(this.l, this.d);
        this.a.observe("show_toolbar_red_dot_by_collect_game", this);
        Iterator<ExtendedToolbarButton> r1 = this.l.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().d = 1;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.c
    public final void onUnLoad() {
        super.onUnLoad();
        i().b();
        CompositeDisposable r0 = this.n;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.o = false;
        this.a.removeObserver(this);
        vlc.d r1 = this.m;
        if (r1 == null) goto L9;
        r1.removeMessageListener(this);
        return;
    }

    public final Context getContext() {
        return this.r;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader
    public final void e(KVData r6) {
        String r0 = null;
        if (r6 == null) goto L5;
        String r1 = r6.getKey();
    L7:
        if (StringsKt.equals$default(r1, "show_toolbar_red_dot_by_collect_game", false, 2, null) == false) goto L13;
        SharedPreferences.Editor r2 = v5.a();
        if (r6 == null) goto L11;
        r0 = (String) r6.getData();
    L11:
        r2.putString("live_collect_game_and_should_show_hot_dot", r0).apply();
        h();
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsDynamicLoader, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.AbsMiddlewareDynamicLoader
    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        e((KVData) r1);
    }

    public final void onMessage(tlc.d r19) {
        if ((r19 instanceof TempStateAreaReachMessage) == true) goto L5;
        return;
    L5:
        if (r19.getIntType() != MessageType.TEMP_STATE_AREA_MESSAGE.getIntType()) goto L93;
        TempStateAreaReachMessage r1 = (TempStateAreaReachMessage) r19;
        if (r1.H() != null) goto L10;
        return;
    L10:
        if (g() == false) goto L95;
        long r2 = r1.getStatus();
        ExtendedToolbarButton.c r6 = null;
        if (r2 != TempStateAreaReachMessage.Status.ADD.getValue()) goto L47;
        ExtendedToolbarButton.c r3 = j(r1.H().b(), r1.H().c(), r1.H().a(), String.valueOf(r1.getItemId()), r1.G(), r1.E(), false);
        DataCenter r8 = this.a;
        long r9 = r1.G();
        Context r11 = this.r;
        boolean r12 = this.d;
        long r13 = r1.getItemId();
        long r15 = r1.E();
        String r17 = r1.H().c();
        r1.H().getClass();
        i().a(r3, new p(r8, r9, r11, r12, r13, r15, r17));
        Iterator<ExtendedToolbarButton.c> r4 = this.j.iterator();
    L16:
        if (r4.hasNext() == false) goto L26;
        ExtendedToolbarButton.c r5 = r4.next();
        if (Intrinsics.areEqual(r5.s, r3.s) == false) goto L16;
        if (r5.m != r3.m) goto L16;
        if (r5.n != r3.n) goto L16;
        if (Intrinsics.areEqual(r5.l, r3.l) == false) goto L16;
        boolean r7 = true;
    L27:
        if (r7 == true) goto L96;
        Iterator<ExtendedToolbarButton.c> r10 = this.j.iterator();
    L31:
        if (r10.hasNext() == false) goto L42;
        ExtendedToolbarButton.c r14 = r10.next();
        ExtendedToolbarButton.c r16 = r14;
        if (r16.n == r3.n) goto L35;
    L39:
        boolean r18 = false;
    L40:
        if (r18 == false) goto L31;
        r6 = r14;
        goto L42
    L35:
        if (r16.m != r3.m) goto L39;
        if ((!Intrinsics.areEqual(r16.s, r3.s)) == false) goto L39;
        r18 = true;
    L42:
        ExtendedToolbarButton.c r20 = r6;
        if (r20 == null) goto L45;
        this.j.remove(r20);
    L45:
        ListProtector.add(this.j, 0, r3);
    L69:
        this.s.invoke("temp area message");
        return;
    L96:
        return;
    L26:
        r7 = false;
        goto L27
    L47:
        if (r2 != TempStateAreaReachMessage.Status.DELETE.getValue()) goto L59;
        Iterator<ExtendedToolbarButton.c> r21 = this.j.iterator();
    L50:
        if (r21.hasNext() == false) goto L54;
        ExtendedToolbarButton.c r22 = r21.next();
        if (Intrinsics.areEqual(r22.s, String.valueOf(r1.getItemId())) == false) goto L50;
        r6 = r22;
    L54:
        ExtendedToolbarButton.c r23 = r6;
        if (r23 == null) goto L57;
        this.j.remove(r23);
    L57:
        i().c(r1.getItemId());
        goto L69
    L59:
        if (r2 != TempStateAreaReachMessage.Status.UPDATE.getValue()) goto L69;
        Iterator<ExtendedToolbarButton.c> r24 = this.j.iterator();
    L62:
        if (r24.hasNext() == false) goto L66;
        ExtendedToolbarButton.c r25 = r24.next();
        if (Intrinsics.areEqual(r25.s, String.valueOf(r1.getItemId())) == false) goto L62;
        r6 = r25;
    L66:
        ExtendedToolbarButton.c r26 = r6;
        if (r26 == null) goto L69;
        ArrayList r27 = new ArrayList();
        r27.add(r1.H().b());
        Intrinsics.checkNotNullParameter(r27, "<set-?>");
        r26.p = r27;
        String r28 = r1.H().c();
        Intrinsics.checkNotNullParameter(r28, "<set-?>");
        r26.q = r28;
        String r29 = r1.H().a();
        Intrinsics.checkNotNullParameter(r29, "<set-?>");
        r26.l = r29;
        goto L69
    L95:
        return;
    }

    public static final boolean f(TempAreaDynamicLoader r8, List r9) {
        LiveMode r0 = (LiveMode) r8.a.get("data_live_mode", LiveMode.VIDEO);
        int r1 = 4;
        if (r0 == null) goto L12;
        int r2 = g.a[r0.ordinal()];
        if (r2 == 1) goto L17;
        if (r2 == 2) goto L16;
        if (r2 == 3) goto L15;
        if (r2 != 4) goto L11;
        int r3 = SupportLiveMode.SCREEN_RECORD.getValue();
    L18:
        Integer r10 = (Integer) r8.a.get("data_link_state", 0);
        if (v.a(r10.intValue(), 4) == false) goto L22;
        r1 = 1;
    L43:
        return com.bytedance.android.live.broadcastgame.api.interactgame.j.b(r9, r1, r3);
    L22:
        if (v.a(r10.intValue(), 2) == false) goto L27;
        if (k.n(IInteractService.class).getInteractAudienceService().P() == true) goto L43;
    L27:
        if (v.a(r10.intValue(), 16) == false) goto L30;
        r1 = 3;
        goto L43
    L30:
        if (v.a(r10.intValue(), 32) == false) goto L33;
        r1 = 8;
        goto L43
    L33:
        if (v.a(r10.intValue(), 64) == false) goto L36;
        r1 = 7;
        goto L43
    L36:
        if (v.a(r10.intValue(), 8) == false) goto L38;
        r1 = k.n(IInteractService.class).getCurrentScene();
        goto L43
    L38:
        int r11 = k.n(IInteractService.class).getCurrentScene();
        if (r11 != 4) goto L41;
        r1 = 0;
        goto L43
    L41:
        r1 = r11;
        goto L43
    L11:
        if (r2 != 5) goto L12;
        r3 = SupportLiveMode.MEDIA.getValue();
        goto L18
    L15:
        r3 = SupportLiveMode.AUDIO.getValue();
        goto L18
    L16:
        r3 = SupportLiveMode.OBS.getValue();
        goto L18
    L17:
        r3 = SupportLiveMode.VIDEO.getValue();
    L12:
        r3 = SupportLiveMode.UNKNOWN.getValue();
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TempAreaDynamicLoader(e r2, x3 r3, Context r4, Function1<? super String, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "env");
        Intrinsics.checkNotNullParameter(r3, "mToolbarManager");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "update");
        super(r2);
        this.q = r3;
        this.r = r4;
        this.s = r5;
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.p = "TempAreaDynamicLoader";
    }

    public static ExtendedToolbarButton.c j(String r1, String r2, String r3, String r4, long r5, long r7, boolean r9) {
        ArrayList r0 = new ArrayList();
        r0.add(r1);
        ExtendedToolbarButton.c r6 = new ExtendedToolbarButton.c(r0, r2, r9, r4);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r6.l = r3;
        r6.a = r5;
        r6.n = r5;
        r6.m = r7;
        r6.i = 2131252414;
        return r6;
    }
}
