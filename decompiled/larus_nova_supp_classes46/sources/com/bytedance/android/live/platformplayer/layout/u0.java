package com.bytedance.android.live.platformplayer.layout;

import android.content.res.Configuration;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.a6;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.platformplayer.test.IPlayerTest;
import com.bytedance.android.livesdk.chatroom.ui.InteractPlayViewManager;
import com.bytedance.android.livesdk.chatroom.ui.d8;
import com.bytedance.android.livesdk.chatroom.ui.l6;
import com.bytedance.android.livesdk.chatroom.ui.q6;
import com.bytedance.android.livesdk.chatroom.ui.v9;
import com.bytedance.android.livesdk.chatroom.utils.a2;
import com.bytedance.android.livesdk.config.gn0;
import com.bytedance.android.livesdk.config.pt0;
import com.bytedance.android.livesdk.config.yh0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.ParseSeiData;
import com.bytedance.android.livesdkapi.model.PlayerExtraRenderInfo;
import com.bytedance.android.livesdkapi.model.StreamColorMonitorConfig;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u0<T> implements Observer {
    public final /* synthetic */ LivePlayerWidget a;
    public final /* synthetic */ IRoomEventHub b;

    public u0(LivePlayerWidget r1, IRoomEventHub r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r26) {
        String r9 = (String) r26;
        LivePlayerWidget r0 = this.a;
        if (((Widget) r0).isViewValid == false) goto L367;
        l6 r1 = r0.u;
        r1.getClass();
        if (r9 != null) goto L8;
    L18:
        l6 r2 = this.a.u;
        r2.getClass();
        if (((Boolean) a6.a.getValue()).booleanValue() == false) goto L26;
        if (r9 == null) goto L26;
        if (StringsKt.contains$default(r9, "key_timor_in_cast", false, 2, null) != true) goto L26;
        r2.b = true;
        r2.c.invoke();
    L26:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L31;
        this.a.getClass();
        IPlayerTest r3 = (IPlayerTest) LivePlayerWidget.jr(IPlayerTest.class);
        if (r3 == null) goto L31;
        r3.consumeSei(r9);
    L31:
        if (StringsKt.contains$default(r9, "\\\"ver\\\":6", false, 2, null) == false) goto L55;
        Room r4 = this.a.bs();
        if (r4 == null) goto L35;
        LiveMode r5 = r4.getStreamType();
    L37:
        if (r5 == LiveMode.SCREEN_RECORD) goto L43;
        if (r4 == null) goto L40;
        LiveMode r6 = r4.getStreamType();
    L42:
        if (r6 != LiveMode.THIRD_PARTY) goto L55;
    L40:
        r6 = null;
    L43:
        PlayerExtraRenderInfo r7 = new PlayerExtraRenderInfo(0, 1, null);
        r7.setInitLinkMicSeiInfo(r9);
        ILivePlayerClient r8 = this.a.dr();
        if (r8 == null) goto L55;
        ILivePlayerExtraRenderController r10 = r8.extraRenderController(1);
        if (r10 == null) goto L55;
        if (r10.isEnable() == true) goto L55;
        ILivePlayerClient r11 = this.a.dr();
        if (r11 == null) goto L55;
        ILivePlayerExtraRenderController r12 = r11.extraRenderController(1);
        if (r12 == null) goto L55;
        r12.enable(r7);
        goto L55
    L35:
        r5 = null;
    L55:
        if (((Boolean) this.a.N.getValue()).booleanValue() == false) goto L59;
        LiveSeiUtil.i.getClass();
        JSONObject r13 = LiveSeiUtil.c(r9);
    L57:
        JSONObject r14 = r13;
        if ((System.currentTimeMillis() - this.a.O) <= 5000) goto L85;
        if (StringsKt.contains$default(r9, "cae_category", false, 2, null) == false) goto L85;
        int r15 = r14.optInt("cae_category", -1);
        if (r15 == (-1)) goto L85;
        this.a.O = System.currentTimeMillis();
        IFeatureService r16 = jc1.k.f(IFeatureService.class);
        if (r16 == null) goto L85;
        z90.a r17 = r16.getFeatureManager();
        if (r17 == null) goto L85;
        r17.i("cae_category", Integer.valueOf(r15), FeatureType.MONITOR);
    L85:
        if (this.a.tr() == true) goto L87;
    L360:
        if (this.a.L1 == false) goto L92;
        JSONObject r18 = r14;
    L93:
        r18.optLong("ts", System.currentTimeMillis());     // Catch: JSONException -> L95
        goto L96
    L92:
        r18 = new JSONObject(r9);     // Catch: JSONException -> L95
    L96:
        LivePlayerWidget r19 = this.a;
        Configuration r20 = r19.z;
        if (r20 == null) goto L99;
        Integer r21 = Integer.valueOf(r20.orientation);
    L100:
        boolean r22 = r19.Rq(r21);
        this.a.M.getClass();
        boolean r23 = com.bytedance.android.livesdk.chatroom.utils.i1.a(r9);
        if (r23 == false) goto L120;
        this.a.L = r9;
        if (((Boolean) yh0.a.getValue()).booleanValue() == true) goto L120;
        boolean r24 = this.a.Ir(r22);
        if (r24 == false) goto L107;
    L114:
        boolean r25 = this.a.Hr(r22);
        if (r25 == false) goto L117;
    L119:
        boolean r27 = r25;
        boolean r28 = r24;
    L122:
        if (this.a.L1 == false) goto L124;
        LiveSeiUtil.i.getClass();
        Pair r29 = LiveSeiUtil.a(r9, r14);
        rc0.q r30 = new rc0.q((String) r29.getFirst(), (JSONObject) r29.getSecond());
    L126:
        if (this.a.tr() == false) goto L156;
        LiveSeiUtil.i.getClass();
        Pair r31 = LiveSeiUtil.a(r9, null);
        String r110 = (String) r31.getFirst();
        JSONObject r32 = (JSONObject) r31.getSecond();
        if (r32 == null) goto L147;
        LivePlayerWidget r111 = this.a;
        if (r32.optString("show_player").equals("true") != true) goto L132;
        boolean r112 = true;
    L133:
        r111.gV(r112);
    L138:
        e = move-exception;
        ALogger.e("LivePlayer", "LivePlayerWidget#onSeiAppData parse hide_audio_bg error", e);
    L140:
        Integer r33 = null;
    L141:
        LivePlayerWidget r34 = this.a;
        DataCenter r113 = ((Widget) r34).dataCenter;
        if (r113 == null) goto L156;
        r113.put("data_show_player", Boolean.valueOf(r34.H1));
        if (r33 == null) goto L156;
        ((Widget) this.a).dataCenter.put("data_hide_audio_bg", Integer.valueOf(r33.intValue()));
        goto L156
    L135:
        if (r32.has("hide_audio_bg") == false) goto L140;
        r33 = Integer.valueOf(r32.optInt("hide_audio_bg", 0));     // Catch: Exception -> L138
        goto L141
    L132:
        r112 = false;
        goto L133
    L147:
        if (TextUtils.equals(r14.optString("source"), "TTLiveSDK_Android") == false) goto L149;
    L154:
        this.a.gV(false);
        goto L156
    L149:
        if (TextUtils.equals(r14.optString("source"), "TTLiveSDK_IOS") == true) goto L154;
        if (LiveSeiUtil.d(r14.optString("source")) == true) goto L154;
        if (TextUtils.equals(r14.optString("source"), "TTLiveSDK_Windows") == true) goto L154;
    L156:
        if (((Boolean) yh0.a.getValue()).booleanValue() == false) goto L168;
        LiveSeiUtil.i.getClass();
        if (LiveSeiUtil.f(r9, false) == false) goto L246;
        if (r9 == null) goto L161;
        boolean r35 = StringsKt.contains$default(r9, "ui_layout", false, 2, null);
    L162:
        LivePlayerWidget r36 = this.a;
        if (r36.g2 == true) goto L167;
        if (r35 == false) goto L246;
        if (((Boolean) r36.m.getValue()).booleanValue() == false) goto L246;
    L167:
        LivePlayerWidget.ms(this.a, "seiUpdate", 0, 0, r9, null, 22);
        goto L246
    L161:
        r35 = false;
    L246:
        wn1.b r37 = this.a.U2.o().l;
        if (r37.a() == true) goto L250;
    L313:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r38 = com.bytedance.android.livesdk.interactivity.api.q.b();
        if (r38 == null) goto L318;
        com.bytedance.live.datacontext.n r39 = r38.getAppData();
        if (r39 == null) goto L318;
        r39.setValue(r9);
    L318:
        LivePlayerWidget r40 = this.a;
        if (r40.l == false) goto L324;
        DataCenter r41 = ((Widget) r40).dataCenter;
        if (r41 == null) goto L323;
        r41.put("data_first_frame_sei", r9);
    L323:
        boolean r42 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(kc0.j.class).updateFirstFrameSei(r9);
        this.a.l = false;
    L324:
        q6 r43 = this.a.b;
        if (r43 == null) goto L331;
        q6 r44 = r43;
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L329;
    L329:
        r44.g.d(r9);
    L331:
        if (StringsKt.contains$default(r9, "app_data", false, 2, null) == false) goto L333;
        this.b.getLastKeyFrameSei().setValue(r9);
    L333:
        LivePlayerWidget r45 = this.a;
        if (r45.a != null) goto L337;
        return;
    L337:
        if (r45.zr() == false) goto L344;
        if (((Boolean) gn0.a.getValue()).booleanValue() == true) goto L344;
        v9 r46 = this.a.n;
        if (r46 == null) goto L344;
        r46.onSeiUpdate(0, r9, false);
    L344:
        if (((Boolean) ((ge1.a) tc0.c.h()).b).booleanValue() == false) goto L349;
        Integer r47 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r47 == null) goto L349;
        r47.intValue();
    L349:
        gs0.d r48 = this.a.a;
        if (r48 == null) goto L366;
        r48.onSei(r9);
        return;
    L366:
        return;
    L250:
        if (r37.f == false) goto L256;
        if (r9 == null) goto L256;
        if (r9.contains("video_color_hist") == true) goto L256;
    L261:
        JSONObject r49 = null;
    L262:
        if (r49 == null) goto L313;
        double r114 = r49.optDouble("brightness", -1.0d);
        double r115 = r49.optDouble("saturation", -1.0d);
        double r210 = r49.optDouble("constract", -1.0d);
        if (r114 < 0.0d) goto L313;
        if (r114 > 255.0d) goto L313;
        if (r115 < 0.0d) goto L313;
        if (r115 > 100.0d) goto L313;
        if (r210 < 0.0d) goto L313;
        if (r210 > 100.0d) goto L313;
        if (r37.c == true) goto L281;
        r37.a = new wn1.a(r114, r115, r210, System.currentTimeMillis());
        goto L313
    L281:
        if (r37.b.isEmpty() == false) goto L283;
        r37.b.add(new wn1.a(r114, r115, r210, System.currentTimeMillis()));
        goto L313
    L283:
        ArrayList r50 = r37.b;
        wn1.a r51 = (wn1.a) ListProtector.get(r50, r50.size() - 1);
        if (r51 == null) goto L313;
        double r52 = Math.abs(r51.a - r114);
        pt0 r53 = pt0.a;
        float r54 = ((StreamColorMonitorConfig) r53.getValue()).mBrightnessThreshold;
        if (r54 > 0.0f) goto L290;
        r54 = 20.0f;
    L290:
        if (r52 < r54) goto L292;
        boolean r55 = true;
    L293:
        double r116 = Math.abs(r51.b - r115);
        float r56 = ((StreamColorMonitorConfig) r53.getValue()).mSaturationThreshold;
        if (r56 > 0.0f) goto L298;
        r56 = 10.0f;
    L298:
        if (r116 < r56) goto L300;
        boolean r57 = true;
    L301:
        double r117 = Math.abs(r51.c - r210);
        float r58 = ((StreamColorMonitorConfig) r53.getValue()).mContrastThreshold;
        if (r58 > 0.0f) goto L306;
        r58 = 8.0f;
    L306:
        if (r117 < r58) goto L308;
        boolean r118 = true;
    L309:
        if (r55 == true) goto L312;
        if (r57 == true) goto L312;
        if (r118 == false) goto L313;
    L312:
        r37.b.add(new wn1.a(r114, r115, r210, System.currentTimeMillis()));
        goto L313
    L308:
        r118 = false;
        goto L309
    L300:
        r57 = false;
        goto L301
    L292:
        r55 = false;
    L256:
        if (TextUtils.isEmpty(r9) == true) goto L261;
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L259
        r49 = LiveSeiUtil.c(r9).optJSONObject("video_color_hist");     // Catch: Exception -> L259
    L259:
        e = move-exception;
        e.printStackTrace();
        goto L261
    L168:
        InteractPlayViewManager r59 = this.a.t;
        if (r59 == null) goto L174;
        if (r30 == null) goto L172;
        JSONObject r60 = r30.b;
    L173:
        ParseSeiData r61 = r59.getParseSeiDataBySei(r9, r14, r60);
    L175:
        if (r61 == null) goto L177;
        int r62 = r61.getSeiVersion();
    L178:
        a2.b = r62;
        if (r61 == null) goto L181;
        int r63 = r61.getSeiUiLayout();
    L182:
        a2.c = r63;
        if (r61 == null) goto L186;
        JSONObject r65 = r61.getCanvas();
        if (r65 == null) goto L186;
    L187:
        Intrinsics.checkNotNullParameter(r65, "<set-?>");
        a2.d = r65;
        if (this.a.t != null) goto L190;
    L192:
        boolean r66 = false;
    L194:
        if (this.a.t == null) goto L203;
        int r67 = a2.g();
        int r119 = a2.f();
        int r120 = InteractPlayViewManager.B;
        if (r67 == 3) goto L198;
    L200:
        boolean r68 = false;
    L201:
        if (r68 != true) goto L203;
        boolean r69 = true;
    L205:
        if (this.a.t == null) goto L214;
        int r121 = a2.g();
        int r122 = a2.f();
        int r123 = InteractPlayViewManager.B;
        if (r121 == 3) goto L209;
    L211:
        boolean r70 = false;
    L212:
        if (r70 != true) goto L214;
        boolean r71 = true;
    L216:
        if (a2.g() >= 8) goto L222;
        if (r66 == true) goto L222;
        if (r69 == true) goto L221;
        if (r71 == true) goto L221;
    L236:
        if (r28 == false) goto L238;
        LivePlayerWidget r72 = this.a;
        LivePlayerWidget.Wq(r72, r22, r9, r72.g2, "onSeiUpdate");
        goto L246
    L238:
        if (r27 == false) goto L242;
        if (r23 == false) goto L242;
        LivePlayerWidget r73 = this.a;
        r73.Tq(r22, r9, r73.g2, "onSeiUpdate", r30);
    L242:
        if (this.a.U2.getStreamType() == LiveMode.THIRD_PARTY) goto L244;
    L245:
        LivePlayerWidget r74 = this.a;
        d8 r75 = r74.s;
        AbsLivePlayerView r76 = r74.R8();
        LivePlayerWidget r77 = this.a;
        r75.a(r9, r76, r77.U2, r77.z);
        goto L246
    L244:
        if (PadConfigUtils.c() == false) goto L246;
    L221:
        if (this.a.H1 == false) goto L236;
    L222:
        AbsLivePlayerView r78 = this.a.R8();
        if ((r78 instanceof LivePlayerView) == true) goto L225;
        r78 = null;
    L225:
        LivePlayerView r79 = (LivePlayerView) r78;
        if (r79 == null) goto L236;
        LivePlayerWidget r80 = this.a;
        InteractPlayViewManager r81 = r80.t;
        if (r81 == null) goto L236;
        DataCenter r82 = ((Widget) r80).dataCenter;
        if (r82 == null) goto L232;
        IRoom r83 = com.bytedance.android.live.core.utils.a0.n(r82);
    L233:
        r81.i(r9, r79, r83, this.a.T);
        LivePlayerWidget r84 = this.a;
        if (r84.T == false) goto L236;
        r84.T = false;
        goto L236
    L232:
        r83 = null;
        goto L233
    L209:
        if (r122 != 28) goto L211;
        r70 = true;
    L214:
        r71 = false;
        goto L216
    L198:
        if (r119 != 27) goto L200;
        r68 = true;
    L203:
        r69 = false;
        goto L205
    L190:
        if (InteractPlayViewManager.f(a2.g(), a2.f()) != true) goto L192;
        r66 = true;
    L186:
        r65 = new JSONObject();
        goto L187
    L181:
        r63 = 0;
        goto L182
    L177:
        r62 = 0;
        goto L178
    L172:
        r60 = null;
        goto L173
    L174:
        r61 = null;
        goto L175
    L124:
        r30 = null;
        goto L126
    L117:
        if (this.a.br().c() == false) goto L119;
        this.a.Or();
        this.a.M30(s1.y(), "onMultiHandleReset");
        goto L119
    L107:
        if (this.a.cr().c() == false) goto L114;
        this.a.Pr();
        if (this.a.zr() == false) goto L113;
        v9 r85 = this.a.n;
        if (r85 == null) goto L113;
        r85.onSeiUpdate(0, r9, false);
    L113:
        this.a.M30(s1.y(), "onPkHandleReset");
    L120:
        r28 = false;
        r27 = false;
        goto L122
    L99:
        r21 = null;
        goto L100
    L87:
        if (this.a.H1 == true) goto L360;
    L59:
        if (this.a.L1 == false) goto L72;
        LiveSeiUtil.i.getClass();
        if (LiveSeiUtil.e(r9) == false) goto L72;
        Result.Companion r86 = Result.Companion;     // Catch: Throwable -> L64
        Object r87 = Result.constructor-impl(new JSONObject(r9));     // Catch: Throwable -> L64
    L67:
        if (Result.isFailure-impl(r87) == false) goto L69;
        r87 = null;
    L69:
        r13 = (JSONObject) r87;
        if (r13 != null) goto L57;
        r13 = new JSONObject();
    L64:
        th = move-exception;
        Result.Companion r88 = Result.Companion;
        r87 = Result.constructor-impl(ResultKt.createFailure(th));
    L72:
        r13 = new JSONObject();
        goto L57
    L8:
        if (StringsKt.contains$default(r9, "key_game_in_cast", false, 2, null) != true) goto L18;
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L17
        boolean r89 = JSONObjectProtectorUtils.getBoolean(LiveSeiUtil.c(JSONObjectProtectorUtils.getString(LiveSeiUtil.c(r9), "key_game_in_cast")), "key_game_in_cast");     // Catch: Throwable -> L353
        if (r1.a == r89) goto L15;
        r1.a = r89;     // Catch: Throwable -> L353
        boolean r90 = com.bytedance.android.live.broadcastgame.api.interactgame.b.a;     // Catch: Throwable -> L353
        com.bytedance.android.live.broadcastgame.api.interactgame.b.a = r89;     // Catch: Throwable -> L353
        r1.c.invoke();     // Catch: Throwable -> L353
    L15:
        Unit r91 = Unit.INSTANCE;     // Catch: Exception -> L17
        goto L18
    }
}
