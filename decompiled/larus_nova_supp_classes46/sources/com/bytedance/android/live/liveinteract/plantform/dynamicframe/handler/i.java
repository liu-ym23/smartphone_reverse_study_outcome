package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.annie.param.GsonMap;
import com.bytedance.android.annie.param.UtilsKt;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.b1;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.DynamicEffectType;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.PlayModeUpdateType;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.TrackerUpdateType;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.revenue.adventure.model.AdventureUpdateType;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.voicechat.interactacting.InteractActingContext;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i extends lh0.b {
    public final LinkedHashMap<String, com.bytedance.android.live.liveinteract.plantform.dynamicframe.e> d;
    public final LinkedHashMap<String, ih0.g> e;
    public final JsonObject f;
    public py.t g;
    public final ViewGroup h;
    public final ih0.b i;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ i a;

        public a(i r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            py.t r10 = ((IBaseUser) r9).getUserAttr();
            int r0 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.g.a;
            py.t r1 = this.a.g;
            List r2 = null;
            if (r1 == null) goto L5;
            Boolean r3 = Boolean.valueOf(r1.isAdmin());
        L6:
            if (r10 == null) goto L8;
            Boolean r4 = Boolean.valueOf(r10.isAdmin());
        L9:
            boolean r5 = Intrinsics.areEqual(r3, r4);
            boolean r6 = true;
            if ((!r5) == true) goto L36;
            if (r1 == null) goto L13;
            List r7 = r1.getAdminPrivileges();
        L14:
            if (r10 == null) goto L16;
            r2 = r10.getAdminPrivileges();
        L16:
            if (r7 != null) goto L19;
            if (r2 != null) goto L19;
        L31:
            boolean r8 = true;
        L33:
            if (r8 == false) goto L36;
            boolean r11 = false;
        L37:
            if (r11 == false) goto L53;
            i r12 = this.a;
            r12.g = r10;
            ih0.b r13 = r12.i;
            JsonObject r14 = new JsonObject();
            r14.addProperty("user_attr", GsonProtectorUtils.toJson(GsonHelper.get(), r10));
            Unit r15 = Unit.INSTANCE;
            r13.Dk("root", "current_user_attr_changed", r14, false);
            HamletAvatarContext r16 = HamletAvatarContext.Companion.getContext();
            if (r16 == null) goto L54;
            com.bytedance.live.datacontext.j<gd0.g> r17 = r16.getHamletAvatarService();
            if (r17 == null) goto L55;
            gd0.g r18 = (gd0.g) r17.getValue();
            if (r18 == null) goto L56;
            if (r10 != null) goto L46;
        L48:
            r6 = false;
        L49:
            r18.zi(r6);
            return;
        L46:
            if (r10.isAdmin() != true) goto L48;
        L56:
            return;
        L55:
            return;
        L54:
            return;
        L53:
            return;
        L19:
            if (r7 == null) goto L32;
            if (r2 == null) goto L32;
            if (r7.size() != r2.size()) goto L32;
            List r19 = CollectionsKt.sorted(r7);
            List r20 = CollectionsKt.sorted(r2);
            int r21 = r19.size();
            int r22 = 0;
        L26:
            if (r22 >= r21) goto L31;
            if (((Number) ListProtector.get(r19, r22)).intValue() != ((Number) ListProtector.get(r20, r22)).intValue()) goto L32;
            r22 = r22 + 1;
        L32:
            r8 = false;
            goto L33
        L13:
            r7 = null;
        L36:
            r11 = true;
            goto L37
        L8:
            r4 = null;
            goto L9
        L5:
            r3 = null;
            goto L6
        }
    }

    @Override // lh0.b
    public final void c() {
        com.bytedance.android.livesdk.user.e r0 = jc1.k.n(IMiddlewareUserService.class).user();
        if (r0 == null) goto L12;
        Observable r1 = r0.p();
        if (r1 == null) goto L13;
        Observable r2 = r1.observeOn(AndroidSchedulers.mainThread());
        if (r2 == null) goto L14;
        Disposable r3 = r2.subscribe(new a(this));
        if (r3 == null) goto L15;
        RxUtilKt.c(r3, this.a);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // lh0.b
    public final void d() {
        super.d();
        Iterator<com.bytedance.android.live.liveinteract.plantform.dynamicframe.e> r0 = this.d.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().f("root_widget_destory");
        goto L4
    L6:
        this.d.clear();
    }

    public final void g(ih0.f r26, ih0.h r27) {
        Intrinsics.checkNotNullParameter(r26, "updateStatus");
        Intrinsics.checkNotNullParameter(r27, "updateCallback");
        JsonObject r5 = r26.d;
        if (r5 != null) goto L5;
        return;
    L5:
        b().isLiveTypeAudio();
        String r6 = r26.c;
        long r17 = 0;
        switch(h.a[r26.getType().ordinal()]) {
            case 1: goto L254;
            case 2: goto L234;
            case 3: goto L231;
            case 4: goto L231;
            case 5: goto L223;
            case 6: goto L220;
            case 7: goto L188;
            case 8: goto L73;
            case 9: goto L64;
            case 10: goto L63;
            case 11: goto L334;
            default: goto L330;
        };
    L63:
        int r0 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.z.a;
        Context r1 = getContext();
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r27, "updateCallback");
        ALogger.i("PermissionUtils", "checkPermission");
        OperateType r3 = OperateType.APPLY;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.y r4 = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.y((com.bytedance.android.live.liveinteract.jsbridge.method.j) r27);
        ArrayList r7 = new ArrayList();
        r7.add(qh0.g.a(r3, 2));
        r7.add(new qh0.f.g(r1, r3, 2));
        r7.add(new qh0.f.c(r1, r3, 2));
        r7.add(new qh0.f.a(r1));
        r7.add(new qh0.f.d(r1, r3, 2, true));
        r7.add(new qh0.f.C0257f(r1, r3, 2, true));
        r7.add(new qh0.f.e(r1, r3));
        qh0.f.a(r7).a(r4);
        boolean r11 = true;
    L331:
        if (r11 == true) goto L345;
        a(r27, null);
        return;
    L345:
        return;
    L64:
        String r2 = r5.get("info").getAsString();
        if (r2 != null) goto L67;
        String r9 = "";
    L68:
        JsonElement r8 = r5.get("time");
        if (r8 == null) goto L71;
        r17 = r8.getAsLong();
    L71:
        ALogger.i("MultiLinkDynamicWidget-Time", r9 + "; jsb use time:" + (System.currentTimeMillis() - r17));
        goto L330
    L67:
        r9 = r2;
        goto L68
    L188:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.e r10 = this.d.get(r6);
        if (r10 == null) goto L330;
        Intrinsics.checkNotNullParameter(r5, "updateExtraInfo");
        if (r10.c != null) goto L193;
        r10.c = new kh0.h(r10.i, r10);
    L193:
        kh0.h r12 = r10.c;
        if (r12 == null) goto L330;
        Intrinsics.checkNotNullParameter(r5, "updateExtraInfo");
        DynamicEffectType r13 = DynamicEffectType.values()[r5.get("type").getAsInt()];
        ALogger.i("MultiLinkDynamicWidget", "updateEffect effectType: " + r13);
        JsonElement r14 = r5.get("panel_id");
        if (r14 == null) goto L199;
        String r15 = r14.getAsString();
        if (r15 == null) goto L199;
    L201:
        if (r15.length() != 0) goto L203;
        boolean r16 = true;
    L204:
        if (r16 == false) goto L206;
        ALogger.e("MultiLinkDynamicWidget", "updateEffect but panelId is empty");
    L206:
        int r18 = kh0.g.a[r13.ordinal()];
        if (r18 != 2) goto L209;
        kh0.a r19 = r12.a(r15);
        JsonElement r20 = r5.get("effect_name");
        if (r20 == null) goto L218;
        String r21 = r20.getAsString();
        if (r21 == null) goto L218;
        String r22 = r21;
    L219:
        r19.c(r22);
    L218:
        r22 = "";
        goto L219
    L209:
        if (r18 != 3) goto L330;
        r12.a(r15).b();
        goto L330
    L203:
        r16 = false;
    L199:
        r15 = "";
        goto L201
    L220:
        ALogger.i("MultiLinkDynamicWidget", "common_set_data bizid: " + r6 + ", cacheBizData=" + r26.d);
        JsonObject r23 = r26.d;
        if (r23 == null) goto L330;
        this.f.add(r6 + '_' + r23.get("key").getAsString(), r23.get("data"));
        goto L330
    L223:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.e r24 = this.d.get(r6);
        if (r24 == null) goto L228;
        Intrinsics.checkNotNullParameter(r26, "updateStatus");
        ALogger.i("MultiLinkDynamicWidget", "bizid: " + r24.g + ", cacheBizData=" + r26.d);
        JsonObject r25 = r26.d;
        if (r25 == null) goto L228;
        r24.a.add(r25.get("key").getAsString(), r25.get("data"));
    L228:
        ih0.g r28 = this.e.get(r6);
        if (r28 == null) goto L330;
        r28.a(r26.d);
        goto L330
    L231:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.e r29 = this.d.get(r6);
        if (r29 == null) goto L330;
        r29.h(r26);
        goto L330
    L234:
        JsonElement r30 = r5.get("biz_id");
        if (r30 == null) goto L237;
        String r31 = r30.getAsString();
    L238:
        if (r31 != null) goto L240;
    L252:
        ALogger.e("MultiLinkDynamicWidget", "Unload Biz but bizId is empty");
        e(r27, "");
        return;
    L240:
        if (r31.length() != 0) goto L242;
        boolean r110 = true;
    L243:
        if (r110 == true) goto L252;
        boolean r32 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.g(r31, r26.getType()) == true) goto L249;
        e(r27, "");
        return;
    L249:
        ALogger.i("MultiLinkDynamicWidget", "removeBizController, bidId: ".concat(r31));
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.e r33 = this.d.remove(r31);
        if (r33 == null) goto L330;
        r33.f("jsb");
        goto L330
    L242:
        r110 = false;
        goto L243
    L237:
        r31 = null;
        goto L238
    L254:
        JsonElement r34 = r5.get("biz_id");
        if (r34 == null) goto L257;
        String r35 = r34.getAsString();
    L258:
        JsonElement r36 = r5.get("source");
        if (r36 == null) goto L261;
        String r210 = r36.getAsString();
    L262:
        if (r35 != null) goto L264;
    L328:
        ALogger.e("MultiLinkDynamicWidget", "Load Biz but bizId is empty");
        e(r27, "");
        return;
    L264:
        if (r35.length() != 0) goto L266;
        boolean r111 = true;
    L267:
        if (r111 == true) goto L328;
        boolean r37 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.a;
        if (com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.r.g(r35, r26.getType()) == true) goto L274;
        ALogger.e("MultiLinkDynamicWidget", "updateStatus type=" + r26.getType() + " fromBizId=" + r35 + " not support dynamic return");
        e(r27, "");
        return;
    L274:
        if (this.d.get(r35) == null) goto L276;
    L326:
        a(r27, null);
        return;
    L276:
        if (getContext() == null) goto L326;
        if (Intrinsics.areEqual(r35, "radio") == false) goto L281;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.e r38 = new b1(getContext(), this.i, this.h, r35, b(), com.bytedance.android.live.core.utils.a0.d(this.c, false), r210, this.c);
    L282:
        this.d.put(r35, r38);
        int r39 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.s.a;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.s.b(r38.g);
        if (r38.i == true) goto L330;
        if (Intrinsics.areEqual(r38.j, "fetch") == false) goto L287;
    L288:
        String r40 = r38.g;
        int r41 = r40.hashCode();
        if (r41 == (-1165274194)) goto L297;
        if (r41 == 208941212) goto L294;
    L299:
        Integer r42 = null;
    L300:
        boolean r43 = Intrinsics.areEqual(r38.j, "enter_room");
        if (r42 == null) goto L330;
        int r44 = r42.intValue();
        com.bytedance.android.livesdk.chatroom.u r45 = com.bytedance.android.live.liveinteract.api.utils.m.h(r38.k, null, 2);
        if (r45 == null) goto L307;
        com.bytedance.live.datacontext.n r46 = r45.x();
        if (r46 == null) goto L307;
        Object r47 = r46.getValue();
    L309:
        if ((r47 instanceof MultiSceneEnterRoomStatisticsUtils) == true) goto L311;
        r47 = null;
    L311:
        MultiSceneEnterRoomStatisticsUtils r48 = (MultiSceneEnterRoomStatisticsUtils) r47;
        if (r48 == null) goto L314;
        r48.k(r44, r43);
    L314:
        com.bytedance.android.livesdk.chatroom.u r49 = com.bytedance.android.live.liveinteract.api.utils.m.h(r38.k, null, 2);
        if (r49 == null) goto L319;
        com.bytedance.live.datacontext.n r50 = r49.x();
        if (r50 == null) goto L319;
        Object r51 = r50.getValue();
    L321:
        if ((r51 instanceof MultiSceneEnterRoomStatisticsUtils) == true) goto L323;
        r51 = null;
    L323:
        MultiSceneEnterRoomStatisticsUtils r52 = (MultiSceneEnterRoomStatisticsUtils) r51;
        if (r52 == null) goto L330;
        r52.l(r44, r43);
    L319:
        r51 = null;
    L307:
        r47 = null;
        goto L309
    L294:
        if (r40.equals("room_battle") == false) goto L299;
        r42 = 16;
        goto L300
    L297:
        if (r40.equals("team_fight") == false) goto L299;
        r42 = 7;
        goto L300
    L287:
        if (Intrinsics.areEqual(r38.j, "enter_room") == false) goto L330;
    L281:
        r38 = new com.bytedance.android.live.liveinteract.plantform.dynamicframe.e(getContext(), this.i, this.h, r35, b(), com.bytedance.android.live.core.utils.a0.d(this.c, false), r210, this.c);
        goto L282
    L266:
        r111 = false;
        goto L267
    L261:
        r210 = null;
        goto L262
    L257:
        r35 = null;
    L330:
        r11 = false;
        goto L331
    L334:
        String r53 = r5.get("type").getAsString();     // Catch: Exception -> L30
        Locale r54 = Locale.ROOT;     // Catch: Exception -> L30
        if (r53 == null) goto L29;
        TrackerUpdateType r55 = TrackerUpdateType.valueOf(r53.toUpperCase(r54));     // Catch: Exception -> L30
        JsonElement r56 = r5.get("extra");     // Catch: Exception -> L30
        if (r56 != null) goto L14;
    L27:
        nh0.r r57 = new nh0.r(r55, null, null);     // Catch: Exception -> L30
    L32:
        ALogger.i("MultiLinkDynamicWidget", "UPDATE_TRACKER trackerExtraObject=" + r57);
        if (r57 == null) goto L35;
        TrackerUpdateType r58 = r57.getType();
    L37:
        if (r58 != TrackerUpdateType.ADD) goto L51;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.t r59 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.t.c;
        Map<String, Map<String, String>> r60 = r57.b;
        r59.getClass();
        if (r60 == null) goto L330;
        Iterator<Map.Entry<String, Map<String, String>>> r61 = r60.entrySet().iterator();
    L43:
        if (r61.hasNext() == false) goto L330;
        Map.Entry<String, Map<String, String>> r62 = r61.next();
        String r63 = r62.getKey();
        Map<String, String> r65 = r62.getValue();
        Map<String, Map<String, String>> r66 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.t.b;
        Map r67 = (Map) ((LinkedHashMap) r66).get(r63);
        if (r67 != null) goto L46;
        r66.put(r63, r65);
        goto L43
    L46:
        Iterator<Map.Entry<String, String>> r68 = r65.entrySet().iterator();
    L48:
        if (r68.hasNext() == false) goto L43;
        Map.Entry<String, String> r69 = r68.next();
        r67.put(r69.getKey(), r69.getValue());
        goto L48
    L51:
        if (r57 == null) goto L53;
        TrackerUpdateType r70 = r57.getType();
    L55:
        if (r70 != TrackerUpdateType.REMOVE) goto L330;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.t r71 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.t.c;
        List<String> r72 = r57.c;
        r71.getClass();
        if (r72 == null) goto L330;
        Iterator<T> r73 = r72.iterator();
    L61:
        if (r73.hasNext() == false) goto L330;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.t.b.remove((String) r73.next());
        goto L61
    L53:
        r70 = null;
        goto L55
    L35:
        r58 = null;
        goto L37
    L14:
        if (r55 != TrackerUpdateType.ADD) goto L17;
        Map r74 = (Map) new Gson().fromJson(r56, new com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.e().getType());     // Catch: Exception -> L30
        ALogger.i("MultiLinkDynamicWidget", "parseToTrackerExtraObject add: " + r74);     // Catch: Exception -> L30
        r57 = new nh0.r(r55, r74, null);     // Catch: Exception -> L30
        goto L32
    L17:
        if (r55 != TrackerUpdateType.REMOVE) goto L27;
        JsonObject r75 = r56.getAsJsonObject();     // Catch: Exception -> L30
        ArrayList r76 = new ArrayList();     // Catch: Exception -> L30
        JsonElement r77 = r75.get("events");     // Catch: Exception -> L30
        if (r77 == null) goto L26;
        JsonArray r78 = r77.getAsJsonArray();     // Catch: Exception -> L30
        if (r78 == null) goto L26;
        Iterator r79 = r78.iterator();     // Catch: Exception -> L30
    L24:
        if (r79.hasNext() == false) goto L26;
        r76.add(((JsonElement) r79.next()).toString());     // Catch: Exception -> L30
    L26:
        ALogger.e("MultiLinkDynamicWidget", "parseToTrackerExtraObject remove: " + r76);     // Catch: Exception -> L30
        r57 = new nh0.r(r55, null, r76);     // Catch: Exception -> L30
        goto L32
    L29:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L30
    L30:
        e = move-exception;
        ALogger.e("MultiLinkDynamicWidget", "parseToTrackerExtraObject: " + r5, e);
        r57 = null;
        goto L32
    L73:
        if (this.d.get(r6) == null) goto L330;
        Intrinsics.checkNotNullParameter(r5, "updateExtraInfo");
        PlayModeUpdateType r80 = PlayModeUpdateType.values()[r5.get("type").getAsInt()];
        ALogger.i("MultiLinkDynamicWidget", "updatePlayMode playmodeType: " + r80);
        JsonObject r81 = r5.get("data").getAsJsonObject();
        if (r81 != null) goto L77;
        ALogger.e("MultiLinkDynamicWidget", "updatePlayMode but extraData is empty");
        goto L330
    L77:
        int r82 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.f.f[r80.ordinal()];
        if (r82 != 1) goto L80;
        int r83 = r81.get("play_mode").getAsInt();
        JsonElement r112 = r81.get("play_mode_log_str");
        if (r112 == null) goto L141;
        String r113 = r112.getAsString();
    L143:
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(r113) == false) goto L145;
        Map<Integer, String> r114 = com.bytedance.android.live.liveinteract.utils.x.a;
        Integer r84 = Integer.valueOf(r83);
        Intrinsics.checkNotNull(r113);
        r114.put(r84, r113);
    L145:
        com.bytedance.live.datacontext.j r85 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r85 == null) goto L151;
        LivePlayModeLogContext r86 = (LivePlayModeLogContext) r85.getValue();
        if (r86 == null) goto L151;
        r86.addPlayMode(r83);
    L151:
        if (Intrinsics.areEqual(o3.f().isAnchor(), Boolean.TRUE) == true) goto L153;
    L178:
        jh0.c r87 = jh0.b.a;
        ALogger.i("DynamicBizExtController", "addPlayMode, " + r83);
        jh0.c r88 = jh0.b.a;
        if (r88 == null) goto L330;
        if (gh0.a.d() == true) goto L330;
        ALogger.i("DynamicBizLogHelper", "addPlayMode, " + r83);
        if (r88.a.containsKey(Integer.valueOf(r83)) == true) goto L330;
        r88.a.put(Integer.valueOf(r83), Long.valueOf(System.currentTimeMillis()));
        ALogger.i("DynamicBizLogHelper", "logAudiencePlaymodeRoomWatch, playModes: " + ((LinkedHashMap) r88.a).keySet());
        HashMap r89 = new HashMap();
        r89.put("play_mode", u0.k(r83));
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r90 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.c1(r89);
        zi0.d.b(r89, false);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_audience_playmode_room_watch", r89, new Object[]{IRoom.class, am2.x.class});
        if (hd0.c.f().h() == false) goto L330;
        r88.b(Integer.valueOf(r83));
        goto L330
    L153:
        if (r83 != 42) goto L173;
        JsonElement r115 = r81.get("extra").getAsJsonObject().get("interactperform_background_id");
        if (r115 == null) goto L157;
        long r116 = r115.getAsLong();
    L158:
        JsonElement r117 = r81.get("extra").getAsJsonObject().get("interactperform_gift_id");
        if (r117 == null) goto L161;
        long r118 = r117.getAsLong();
    L162:
        JsonElement r91 = r81.get("extra").getAsJsonObject().get("interactperform_theme_head_image_id");
        if (r91 == null) goto L165;
        r17 = r91.getAsLong();
    L165:
        LinkedHashMap r92 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r92);
        TalkRoomLogUtils.B0(r92, null, null, 6);
        r92.put("play_mode", u0.b());
        InteractActingContext r119 = InteractActingContext.Companion.getContext();
        if (r119 == null) goto L171;
        com.bytedance.live.datacontext.m<String> r120 = r119.getOpenSource();
        if (r120 == null) goto L171;
        String r121 = (String) r120.getValue();
        if (r121 == null) goto L171;
    L172:
        r92.put("source", r121);
        r92.put("interactperform_background_id", String.valueOf(r116));
        r92.put("interactperform_gift_id", String.valueOf(r118));
        r92.put("interactperform_theme_head_image_id", String.valueOf(r17));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_playmode_open_success", r92, new Object[]{IRoom.class});
    L171:
        r121 = "";
        goto L172
    L161:
        r118 = 0;
        goto L162
    L157:
        r116 = 0;
        goto L158
    L173:
        GsonMap r93 = UtilsKt.i(r81.get("extra").getAsJsonObject());
        LinkedHashMap r94 = new LinkedHashMap();
        com.bytedance.android.live.liveinteract.api.utils.i.a(r94);
        Iterator r95 = r93.b().iterator();
    L175:
        if (r95.hasNext() == false) goto L177;
        Map.Entry r96 = (Map.Entry) r95.next();
        r94.put(r96.getKey(), String.valueOf(r96.getValue()));
        goto L175
    L177:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_playmode_open_success", r94, new Object[]{IRoom.class});
        goto L178
    L141:
        r113 = null;
        goto L143
    L80:
        if (r82 != 2) goto L330;
        int r97 = r81.get("play_mode").getAsInt();
        if (Intrinsics.areEqual(o3.f().isAnchor(), Boolean.TRUE) == true) goto L85;
    L122:
        com.bytedance.live.datacontext.j r98 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r98 == null) goto L127;
        LivePlayModeLogContext r99 = (LivePlayModeLogContext) r98.getValue();
        if (r99 == null) goto L127;
        r99.removePlayMode(r97);
    L127:
        jh0.c r100 = jh0.b.a;
        ALogger.i("DynamicBizExtController", "removePlayMode, " + r97);
        jh0.c r101 = jh0.b.a;
        if (r101 == null) goto L330;
        if (gh0.a.d() == true) goto L330;
        ALogger.i("DynamicBizLogHelper", "removePlayMode, " + r97);
        if (r101.a.containsKey(Integer.valueOf(r97)) == false) goto L330;
        r101.a(Integer.valueOf(r97));
        if (hd0.c.f().h() == false) goto L137;
        r101.c(Integer.valueOf(r97));
    L137:
        r101.a.remove(Integer.valueOf(r97));
        goto L330
    L85:
        if (r97 != 42) goto L117;
        JsonElement r122 = r81.get("extra").getAsJsonObject().get("interactperform_background_id");
        if (r122 == null) goto L89;
        long r123 = r122.getAsLong();
    L90:
        JsonElement r124 = r81.get("extra").getAsJsonObject().get("interactperform_gift_id");
        if (r124 == null) goto L93;
        long r211 = r124.getAsLong();
    L94:
        JsonElement r102 = r81.get("extra").getAsJsonObject().get("interactperform_theme_head_image_id");
        if (r102 == null) goto L97;
        long r212 = r102.getAsLong();
    L98:
        LinkedHashMap r103 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r103);
        TalkRoomLogUtils.B0(r103, null, null, 6);
        r103.put("play_mode", u0.b());
        InteractActingContext.a r104 = InteractActingContext.Companion;
        InteractActingContext r125 = r104.getContext();
        if (r125 == null) goto L104;
        com.bytedance.live.datacontext.m<String> r126 = r125.getOpenSource();
        if (r126 == null) goto L104;
        String r127 = (String) r126.getValue();
        if (r127 == null) goto L104;
    L105:
        r103.put("source", r127);
        r103.put("interactperform_background_id", String.valueOf(r123));
        r103.put("interactperform_gift_id", String.valueOf(r211));
        r103.put("interactperform_theme_head_image_id", String.valueOf(r212));
        InteractActingContext r105 = r104.getContext();
        if (r105 == null) goto L112;
        com.bytedance.live.datacontext.m<Long> r106 = r105.getStartTime();
        if (r106 == null) goto L112;
        Long r107 = (Long) r106.getValue();
        if (r107 == null) goto L112;
        long r108 = r107.longValue();
    L114:
        if (r108 == 0) goto L116;
        r103.put("duration", String.valueOf((System.currentTimeMillis() - r108) / ((long) 1000)));
    L116:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_playmode_over", r103, new Object[]{IRoom.class});
    L112:
        r108 = 0;
    L104:
        r127 = "";
        goto L105
    L97:
        r212 = 0;
        goto L98
    L93:
        r211 = 0;
        goto L94
    L89:
        r123 = 0;
        goto L90
    L117:
        GsonMap r109 = UtilsKt.i(r81.get("extra").getAsJsonObject());
        LinkedHashMap r128 = new LinkedHashMap();
        com.bytedance.android.live.liveinteract.api.utils.i.a(r128);
        Iterator r129 = r109.b().iterator();
    L119:
        if (r129.hasNext() == false) goto L121;
        Map.Entry r130 = (Map.Entry) r129.next();
        r128.put(r130.getKey(), String.valueOf(r130.getValue()));
        goto L119
    L121:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_playmode_over", r128, new Object[]{IRoom.class});
        goto L122
    }

    public i(Context r2, DataCenter r3, ViewGroup r4, ih0.b r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "mLinkRootView");
        Intrinsics.checkNotNullParameter(r5, "service");
        super(r2, r3);
        this.h = r4;
        this.i = r5;
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.f = new JsonObject();
    }

    public final void f(String r10, DynamicUpdateType r11, ih0.f r12, DataCenter r13) {
        Intrinsics.checkNotNullParameter(r10, "fromBizId");
        Intrinsics.checkNotNullParameter(r11, "type");
        Intrinsics.checkNotNullParameter(r12, "updateStatus");
        if (this.d.get(r10) == null) goto L64;
        Intrinsics.checkNotNullParameter(r11, "type");
        Intrinsics.checkNotNullParameter(r12, "updateStatus");
        jh0.c r14 = jh0.b.a;
        Intrinsics.checkNotNullParameter(r11, "type");
        Intrinsics.checkNotNullParameter(r12, "updateStatus");
        int r15 = jh0.a.a[r11.ordinal()];
        if (r15 == 1) goto L12;
        if (r15 != 2) goto L75;
        ALogger.i("DynamicBizExtController", "bizExtUpdate " + r12.d);
        if (r13 == null) goto L65;
        r13.put("data_multi_fight_profit_egg", r12.d);
        return;
    L65:
        return;
    L75:
        return;
    L12:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getAdventureService() == null) goto L67;
        JsonObject r16 = r12.d;
        ALogger.i("AdventureOutService", "effectChange, effectChange: " + r16);
        if (r16 == null) goto L76;
        String r17 = r16.get("type").getAsString();
        Locale r18 = Locale.ROOT;
        if (r17 == null) goto L63;
        AdventureUpdateType r19 = AdventureUpdateType.valueOf(r17.toUpperCase(r18));
        JsonObject r110 = r16.getAsJsonObject("extra");
        int r111 = ai0.a.a[r19.ordinal()];
        String r112 = null;
        if (r111 != 1) goto L21;
        sh0.i0 r113 = sh0.j0.a(null);
        if (r113 == null) goto L73;
        r113.d0(sh0.s.b, null);
        return;
    L73:
        return;
    L21:
        if (r111 != 2) goto L23;
        if (r110 == null) goto L41;
        JsonElement r114 = r110.get("rtc_ext_info");
        if (r114 == null) goto L41;
        String r115 = r114.getAsString();
    L42:
        if (r110 == null) goto L46;
        JsonElement r116 = r110.get("source");
        if (r116 == null) goto L46;
        String r117 = r116.getAsString();
    L47:
        if (r110 == null) goto L51;
        JsonElement r118 = r110.get("call_user_type");
        if (r118 == null) goto L51;
        r112 = r118.getAsString();
    L51:
        if (r115 == null) goto L70;
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r119 = com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.a;
        Intrinsics.checkNotNullParameter(r115, "rtcExtInfo");
        ALogger.i("AdventureLinkService", "joinRtcRoom, rtcExtInfo: " + r115 + ", source: " + r117 + ", callUserType: " + r112);
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.g = r115;
        String r120 = ei0.a.a;
        if (r112 != null) goto L55;
        r112 = "unknown";
    L55:
        Intrinsics.checkNotNullParameter(r115, "rtcExtInfo");
        Intrinsics.checkNotNullParameter(r112, "callUserType");
        ei0.a.a = r112;
        JSONObject r121 = new JSONObject();
        r121.put("adventure_call_rtc_ext_info", r115);
        r121.put("adventure_call_user_type", ei0.a.a);
        r121.put("code", "native");
        int r122 = rd0.a.a;
        rd0.a.b(MultiTraceData$TraceBusiness.MultiRevenue, MultiTraceData$TraceEvent.AdventureCall, "adventure_call_start_join_rtc_room", 0, null, r121, 88);
        StringCompanionObject r123 = StringCompanionObject.INSTANCE;
        ALogger.d("AdventureFullLinkMonitor", String.format("startJoinRtcRoom, extra: %s", Arrays.copyOf(new Object[]{r121}, 1)));
        if (com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.f == false) goto L58;
        ALogger.i("AdventureLinkService", "joinRtcRoom return, cause: hasStartedJoinRtcRoom");
        return;
    L58:
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.f = true;
        f2.g();
        MainThreadPostUtils.b(new com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.f(new com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.d(r115)));
        return;
    L70:
        return;
    L46:
        r117 = null;
    L41:
        r115 = null;
        goto L42
    L23:
        if (r111 != 3) goto L25;
        if (r110 == null) goto L36;
        JsonElement r124 = r110.get("source");
        if (r124 == null) goto L36;
        r112 = r124.getAsString();
    L36:
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r125 = com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.a;
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.b(r112);
        return;
    L25:
        if (r111 != 4) goto L77;
        if (r110 == null) goto L31;
        JsonElement r126 = r110.get("source");
        if (r126 == null) goto L31;
        r112 = r126.getAsString();
    L31:
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g.l.a(r112);
        return;
    L77:
        return;
    L63:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L76:
        return;
    L67:
        return;
    }
}
