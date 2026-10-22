package com.bytedance.android.live.anchormodelink.handlers;

import android.content.Context;
import com.bytedance.android.live.anchormodelink.impl.AnchorModeLinkDynamicWidget;
import com.bytedance.android.live.anchormodelink.livelink.LiveLinkWrapper;
import com.bytedance.android.live.anchormodelink.livelink.LiveLinkWrapper$IMultiLinkBizAVClientLiveStreamListener$2;
import com.bytedance.android.live.anchormodelink.model.DynamicCenterGetType;
import com.bytedance.android.live.anchormodelink.model.DynamicCenterUpdateType;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.utils.l;
import com.bytedance.android.live.livelink.platformapi.avclient.video.AndroidVideoStreamApi;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtraKt;
import com.bytedance.android.livesdkapi.interact.data.LinkConstantKt;
import com.bytedance.android.livesdkapi.interact.data.LinkConstantKt_live_model_apiKt;
import com.bytedance.kmp.live.livelink.api.multilink.monitor.LinkMonitor;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.live.livelink.kmp.api.base.config.Character;
import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import com.bytedance.live.livelink.kmp.api.base.config.StreamType;
import com.bytedance.live.livelink.kmp.api.base.rtc.Env;
import com.bytedance.live.livelink.kmp.api.base.video.ViewType;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import iy.h;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ny.j;
import ny.k;
import ny.m;
import ny.n;
import ny.o;
import ny.p;
import ny.q;
import ny.r;
import ny.s;
import ny.t;
import vm2.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements iy.e {
    public LiveLinkWrapper a;
    public my.a b;
    public final h c;

    public final void f() {
        LiveLinkWrapper r0 = this.a;
        if (r0 == null) goto L12;
        Intrinsics.checkNotNullParameter("Jsb invoke", "reason");
        LinkMonitor.a(r0.a, "stopVideoCapture", "[reason] Jsb invoke", null, null, true, 56);
        ec6.a r1 = r0.d();
        if (r1 == null) goto L13;
        sk0.c r2 = r1.r();
        if (r2 == null) goto L14;
        com.bytedance.android.live.livelink.platformapi.avclient.video.a r3 = r2.d;
        if (r3 == null) goto L15;
        r3.e("Jsb invoke");
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // iy.e
    public final void onStart() {
        my.a r0 = new my.a();
        this.b = r0;
        this.a = new LiveLinkWrapper(this.c, r0);
    }

    @Override // iy.e
    public final void onStop() {
        LiveLinkWrapper r0 = this.a;
        if (r0 == null) goto L6;
        r0.k("LiveLinkWrapper onDestroy");
        r0.j.dispose();
        LinkMonitor.a(r0.a, "detach", null, null, null, false, 92);
        LinkMonitor.b();
        return;
    }

    public g(AnchorModeLinkDynamicWidget.f r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        this.c = r2;
    }

    @Override // iy.e
    public final JsonObject C(my.b r3) {
        Intrinsics.checkNotNullParameter(r3, "getStatusData");
        DynamicCenterGetType r4 = r3.getType();
        if (f.b[r4.ordinal()] == 1) goto L6;
        return null;
    L6:
        Integer r5 = this.c.O0();
        if (r5 == null) goto L9;
        int r6 = r5.intValue();
    L10:
        JsonObject r0 = new JsonObject();
        r0.addProperty("ui_layout", Integer.valueOf(r6));
        return r0;
    L9:
        r6 = 0;
        goto L10
    }

    @Override // iy.e
    public final boolean a(DynamicCenterUpdateType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        if (r2 != DynamicCenterUpdateType.liveLinkCall) goto L5;
    L12:
        return true;
    L5:
        if (r2 == DynamicCenterUpdateType.sendSEI) goto L12;
        if (r2 == DynamicCenterUpdateType.linkmicBeautyPanel) goto L12;
        if (r2 == DynamicCenterUpdateType.closeVideoChorus) goto L12;
        return false;
    }

    @Override // iy.e
    public final boolean c(DynamicCenterGetType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        if (r2 != DynamicCenterGetType.liveLink) goto L5;
    L8:
        return true;
    L5:
        if (r2 == DynamicCenterGetType.linkmic) goto L8;
        return false;
    }

    public final void d(my.c r5) {
        int r0 = j.b;
        JsonObject r6 = r5.b;
        j r1 = new j();
        if (r6 == null) goto L7;
        JsonElement r2 = r6.get("method");
        if (r2 == null) goto L7;
        r2.getAsString();
    L7:
        if (r6 != null) goto L9;
    L25:
        k r7 = r1.a;
        if (r7 != null) goto L28;
        return;
    L28:
        LiveLinkWrapper r3 = this.a;
        if (r3 == null) goto L44;
        boolean r4 = r7.a;
        String r8 = r7.b;
        if (r8 != null) goto L33;
        r8 = "";
    L33:
        ei6.a r9 = r3.d;
        if (r9 == null) goto L40;
        xi6.c r11 = r9.t();
        if (r11 == null) goto L40;
        com.bytedance.live.livelink.kmp.impl.core.video.c r12 = r11.d();
        if (r12 == null) goto L40;
        r12.k(r4, "");
    L40:
        l r13 = r3.u.r4();
        if (r13 == null) goto L45;
        r13.uo(r4, r8);
        return;
    L45:
        return;
    L44:
        return;
    L9:
        if (r6.has("params") != true) goto L25;
        JsonElement r14 = r6.get("params");
        String r15 = null;
        if (r14 == null) goto L13;
        JsonObject r16 = r14.getAsJsonObject();
    L14:
        k r17 = new k();
        if (r16 == null) goto L24;
        JsonElement r18 = r16.get("mute");
        if (r18 == null) goto L19;
        boolean r19 = r18.getAsBoolean();
    L20:
        r17.a = r19;
        JsonElement r21 = r16.get("reason");
        if (r21 == null) goto L23;
        r15 = r21.getAsString();
    L23:
        r17.b = r15;
        goto L24
    L19:
        r19 = false;
    L24:
        r1.a = r17;
        goto L25
    L13:
        r16 = null;
        goto L14
    }

    public final void e(my.c r31) {
        int r0 = p.b;
        JsonObject r1 = r31.b;
        p r2 = new p();
        if (r1 == null) goto L8;
        JsonElement r3 = r1.get("method");
        if (r3 == null) goto L8;
        r3.getAsString();
    L8:
        if (r1 != null) goto L10;
    L177:
        o r4 = r2.a;
        if (r4 != null) goto L180;
        return;
    L180:
        my.a r5 = this.b;
        if (r5 == null) goto L183;
        r5.a = r4.g;
    L183:
        if (r5 == null) goto L185;
        r5.b = r4.i;
    L185:
        if (r5 == null) goto L187;
        r5.c = r4.j;
    L187:
        LiveLinkWrapper r6 = this.a;
        if (r6 == null) goto L366;
        LinkMonitor.a(r6.a, "setupLiveLinkService", "[setupLiveLinkParams] " + r4, null, null, true, 56);
        fi6.a r7 = new fi6.a();
        Context r8 = r6.u.getContext();
        String r9 = "";
        if (r8 == null) goto L266;
        boolean r11 = r6.u.v4();
        Intrinsics.checkNotNullParameter(r8, "context");
        r7.u = r8;
        String r12 = r4.c;
        if (r12 != null) goto L195;
        r12 = "";
    L195:
        Intrinsics.checkNotNullParameter(r12, "info");
        r7.v = r12;
        r7.e = r4.t;
        r7.S = 5;
        Intrinsics.checkNotNullParameter("douyin_live", "key");
        r7.w = "douyin_live";
        KmpEnv r13 = KmpEnv.a;
        String r14 = vh6.c.b(wh6.a.class).getChannel();
        if (r14 != null) goto L198;
        r14 = "";
    L198:
        Intrinsics.checkNotNullParameter(r14, "channel");
        r7.y = r14;
        r7.c(String.valueOf(vh6.c.b(wh6.a.class).getAppId()));
        r7.e(vh6.c.b(wh6.a.class).getVersionCode());
        r7.d(String.valueOf(vh6.c.b(wh6.a.class).getUpdateVersionCode()));
        if (vh6.c.b(wh6.a.class).isBoe() == false) goto L202;
        r7.l(Env.ENV_BOE);
    L202:
        if (i.d() == false) goto L204;
        r7.l(Env.ENV_TEST);
    L204:
        if (r11 == false) goto L212;
        MixStreamType r15 = MixStreamType.SERVER_MIX;
        r7.j(r15);
        if (vm2.e.e() == false) goto L212;
        boolean r16 = vm2.e.c();
        r7.W = false;
        if (r16 == false) goto L210;
        r15 = MixStreamType.RTC_CLIENT_MIX;
    L210:
        r7.j(r15);
    L212:
        if (vm2.e.n() == false) goto L214;
        r7.j = 1;
    L214:
        r7.k(r6.u.d());
        if (r6.u.C4() == false) goto L219;
        r7.Z = true;
        l r17 = r6.u.r4();
        if (r17 == null) goto L222;
        r17.I3(true);
    L222:
        InteractMode r18 = InteractMode.PK;
        int r19 = r4.b;
        InteractMode.Companion.getClass();
        InteractMode[] r21 = InteractMode.values();
        int r110 = r21.length;
        int r111 = 0;
    L223:
        if (r111 >= r110) goto L231;
        InteractMode r112 = r21[r111];
        if (r112.getValue() != r19) goto L227;
        boolean r113 = true;
    L228:
        if (r113 == true) goto L232;
        r111 = r111 + 1;
    L232:
        if (r112 != null) goto L234;
        r112 = InteractMode.VIDEO_TALK;
    L234:
        IRoomBase r22 = r6.u.getRoom();
        if ((r22 instanceof IRoom) == true) goto L237;
        r22 = null;
    L237:
        IRoom r23 = (IRoom) r22;
        if (r23 == null) goto L242;
        IBaseStreamUrl r24 = IRoomKt_androidKt.getStreamUrlKt(r23);
        if (r24 == null) goto L242;
        String r25 = r24.getRtmpPushUrl();
    L243:
        r7.f = r6;
        r7.e = r25;
        r7.f(LinkConstantKt.Companion.getSTREAM_BACKGROUND());
        r7.i(r112);
        ViewType r26 = ViewType.TEXTURE_VIEW;
        Intrinsics.checkNotNullParameter(r26, "viewType");
        r7.E = r26;
        r7.N = LinkConstantKt_live_model_apiKt.getVOLUME_CALLBACK_INTERVAL();
        if (r4.k == false) goto L246;
        Character r27 = Character.ANCHOR;
    L247:
        r7.g(r27);
        r7.n(StreamType.VIDEO);
        IRoomBase r28 = r6.u.getRoom();
        if ((r28 instanceof IRoom) == true) goto L250;
        r28 = null;
    L250:
        IRoom r29 = (IRoom) r28;
        if (r29 == null) goto L255;
        IStreamUrlExtra r32 = IRoomKtKt.getStreamUrlExtraSafely(r29);
        if (r32 == null) goto L255;
        int r33 = IStreamUrlExtraKt.anchorInteractProfile(r32);
    L256:
        if (r33 <= 0) goto L258;
        qi6.g r34 = qi6.g.k;
    L259:
        r7.o(r34);
        r7.Q = (int) vm2.e.l();
        r7.R = vm2.e.q();
        Boolean r35 = r4.q;
        if (r35 == null) goto L262;
        r7.h0 = r35.booleanValue();
    L262:
        Boolean r36 = r4.r;
        if (r36 == null) goto L266;
        r7.i0 = r36.booleanValue();
        goto L266
    L258:
        r34 = qi6.g.j;
    L255:
        r33 = 0;
        goto L256
    L246:
        r27 = Character.GUEST;
    L242:
        r25 = null;
        goto L243
    L227:
        r113 = false;
        goto L228
    L231:
        r112 = null;
        goto L232
    L219:
        l r37 = r6.u.r4();
        if (r37 == null) goto L222;
        r37.I3(false);
    L266:
        if (r6.u.v4() == true) goto L316;
        if (r6.f().a == false) goto L270;
    L314:
        LinkMonitor.a(r6.a, "startInitLiveClient", "ignore init, live client " + r6.f(), null, null, false, 120);
        goto L316
    L270:
        if (r6.f().b == true) goto L314;
        LinkMonitor.a(r6.a, "startInitLiveClient", "[source] Lynx JSB", null, null, false, 120);
        yb6.g r38 = new yb6.g();
        String r39 = r4.d;
        if (r39 == null) goto L276;
        r9 = r39;
    L276:
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r38.a = r9;
        com.bytedance.android.live.anchormodelink.livelink.c r41 = new com.bytedance.android.live.anchormodelink.livelink.c(r6, r4);
        KmpEnv r114 = KmpEnv.a;
        if (v.a() == true) goto L279;
    L281:
        ec6.a r115 = r6.d();
        if (r115 != null) goto L284;
    L289:
        r6.f().b = true;
        i97.a r116 = i97.a.a;
        long r117 = System.currentTimeMillis();
    L302:
        th = move-exception;
        LinkMonitor.a(r6.a, "live client init failed", String.valueOf(th), null, null, false, 120);     // Catch: Throwable -> L311
        r41.lf(LiveLinkWrapper.e(r117), th);     // Catch: Throwable -> L311
    L309:
        r6.f().b = false;
    L311:
        th = move-exception;
        r6.f().b = false;
        throw th;
    L292:
        if ((!StringsKt.isBlank(r38.a)) == false) goto L294;
        r6.c = r41.O2(r38.a);     // Catch: Throwable -> L302
        LinkMonitor.a(r6.a, "create guestAVClientFactory", "factory " + r6.c + ", params " + r38 + ", source Lynx JSB", null, null, false, 120);     // Catch: Throwable -> L302
    L295:
        ec6.a r42 = r6.d();     // Catch: Throwable -> L302
        if (r42 == null) goto L306;
        r6.f().a = true;     // Catch: Throwable -> L302
        if (r6.u.v4() == true) goto L304;
        sk0.c r43 = r6.c();     // Catch: Throwable -> L302
        if (r43 == null) goto L304;
        r43.a((LiveLinkWrapper$IMultiLinkBizAVClientLiveStreamListener$2.a) r6.p.getValue());     // Catch: Throwable -> L302
    L304:
        LinkMonitor.a(r6.a, "live client init success duration " + LiveLinkWrapper.e(r117), null, null, null, false, 92);     // Catch: Throwable -> L302
        r41.u4(LiveLinkWrapper.e(r117), r42);     // Catch: Throwable -> L302
        if (Unit.INSTANCE != null) goto L309;
    L306:
        r41.lf(LiveLinkWrapper.e(r117), new Exception("live client create fail, source Lynx JSB"));     // Catch: Throwable -> L302
        Unit r44 = Unit.INSTANCE;     // Catch: Throwable -> L302
        goto L309
    L294:
        LinkMonitor.a(r6.a, "illegal init params", r38 + ", source Lynx JSB", null, null, false, 120);     // Catch: Throwable -> L302
        r41.lf(LiveLinkWrapper.e(r117), new Exception("illegal live client init params " + r38 + ", source Lynx JSB"));     // Catch: Throwable -> L302
        goto L295
    L284:
        if (r6.f().a == true) goto L287;
        r115 = null;
    L287:
        if (r115 == null) goto L289;
        LinkMonitor.a(r6.a, "live client already init !, source Lynx JSB", null, null, null, false, 124);
        r41.u4(0, r115);
        goto L316
    L279:
        if (i.h().e4() == false) goto L281;
        LinkMonitor.a(r6.a, "mock live client init failed in local test, source Lynx JSB", null, null, null, false, 124);
        r41.lf(0, new Exception("mock live client init failed, source Lynx JSB"));
    L316:
        if (r6.g().a == false) goto L318;
    L358:
        LinkMonitor.a(r6.a, "startInitRtcClient", "ignore init rtc client " + r6.g(), null, null, false, 120);
        return;
    L318:
        if (r6.g().b == true) goto L358;
        LinkMonitor.a(r6.a, "startInitRtcClient", "[source] Lynx JSB", null, null, false, 120);
        if (r6.d() != null) goto L324;
        LinkMonitor.a(r6.a, "live client is null when init rtc client", null, null, null, false, 124);
        return;
    L324:
        if (r7.getContext() == null) goto L334;
        String r45 = r7.v;
        if (r45 != null) goto L328;
    L331:
        boolean r118 = true;
    L332:
        if (r118 == true) goto L334;
        boolean r46 = true;
    L335:
        if (r46 == true) goto L337;
        LinkMonitor.a(r6.a, "rtc init failed config is invalid", null, null, null, false, 124);
        return;
    L337:
        r6.g().b = true;
        i97.a r47 = i97.a.a;
        long r48 = System.currentTimeMillis();
        ec6.a r49 = r6.d();
        if (r49 == null) goto L340;
        ei6.a r51 = r49.q(r7);
    L341:
        r6.d = r51;
        if (r51 == null) goto L369;
        r6.g().a = true;
        LinkMonitor.a(r6.a, "enableRtcMetaDataSign", null, null, null, false, 124);
        ec6.a r52 = r6.d();
        if (r52 == null) goto L352;
        sk0.c r53 = r52.r();
        if (r53 == null) goto L352;
        AndroidVideoStreamApi r54 = r53.e;
        if (r54 == null) goto L352;
        AndroidVideoStreamApi.a r55 = r54.b;
        if (r55 == null) goto L352;
        r55.a();
    L352:
        ei6.a r56 = r6.d;
        if (r56 == null) goto L357;
        gi6.e r57 = r56.getEventManager();
        if (r57 == null) goto L357;
        r57.b(r6.h());
    L357:
        LinkMonitor.a(r6.a, "rtc client init success", "duration " + LiveLinkWrapper.e(r48), null, null, false, 88);
        return;
    L369:
        return;
    L340:
        r51 = null;
        goto L341
    L328:
        if (StringsKt.isBlank(r45) == true) goto L331;
        r118 = false;
    L334:
        r46 = false;
        goto L335
    L366:
        return;
    L10:
        if (r1.has("params") != true) goto L177;
        JsonElement r58 = r1.get("params");
        if (r58 == null) goto L14;
        JsonObject r59 = r58.getAsJsonObject();
    L15:
        o r61 = new o();
        if (r59 != null) goto L18;
    L24:
        if (r59 != null) goto L26;
    L32:
        if (r59 != null) goto L34;
    L40:
        if (r59 != null) goto L42;
    L48:
        if (r59 != null) goto L50;
    L56:
        if (r59 != null) goto L58;
    L64:
        if (r59 != null) goto L66;
    L72:
        if (r59 != null) goto L74;
    L80:
        if (r59 != null) goto L82;
    L88:
        if (r59 != null) goto L90;
    L96:
        if (r59 != null) goto L98;
    L104:
        if (r59 != null) goto L106;
    L112:
        if (r59 != null) goto L114;
    L120:
        if (r59 != null) goto L122;
    L128:
        if (r59 != null) goto L130;
    L136:
        if (r59 != null) goto L138;
    L144:
        if (r59 != null) goto L146;
    L152:
        if (r59 != null) goto L154;
    L160:
        if (r59 != null) goto L162;
    L168:
        if (r59 != null) goto L170;
    L176:
        r2.a = r61;
        goto L177
    L170:
        if (r59.has("publishUrl") != true) goto L176;
        JsonElement r62 = r59.get("publishUrl");
        if (r62 == null) goto L174;
        String r63 = r62.getAsString();
    L175:
        r61.t = r63;
        goto L176
    L174:
        r63 = null;
        goto L175
    L162:
        if (r59.has("useBackupStream") != true) goto L168;
        JsonElement r64 = r59.get("useBackupStream");
        if (r64 == null) goto L166;
        boolean r65 = r64.getAsBoolean();
    L167:
        r61.s = r65;
        goto L168
    L166:
        r65 = false;
        goto L167
    L154:
        if (r59.has("autoPublishVideoStream") != true) goto L160;
        JsonElement r66 = r59.get("autoPublishVideoStream");
        if (r66 == null) goto L158;
        Boolean r67 = Boolean.valueOf(r66.getAsBoolean());
    L159:
        r61.r = r67;
        goto L160
    L158:
        r67 = null;
        goto L159
    L146:
        if (r59.has("autoPublishAudioStream") != true) goto L152;
        JsonElement r68 = r59.get("autoPublishAudioStream");
        if (r68 == null) goto L150;
        Boolean r69 = Boolean.valueOf(r68.getAsBoolean());
    L151:
        r61.q = r69;
        goto L152
    L150:
        r69 = null;
        goto L151
    L138:
        if (r59.has("rtcVideoCaptureDefaultClose") != true) goto L144;
        JsonElement r71 = r59.get("rtcVideoCaptureDefaultClose");
        if (r71 == null) goto L142;
        boolean r72 = r71.getAsBoolean();
    L143:
        r61.p = r72;
        goto L144
    L142:
        r72 = false;
        goto L143
    L130:
        if (r59.has("rtcAudioCaptureDefaultClose") != true) goto L136;
        JsonElement r73 = r59.get("rtcAudioCaptureDefaultClose");
        if (r73 == null) goto L134;
        boolean r74 = r73.getAsBoolean();
    L135:
        r61.o = r74;
        goto L136
    L134:
        r74 = false;
        goto L135
    L122:
        if (r59.has("isStartInteractUnpublish") != true) goto L128;
        JsonElement r75 = r59.get("isStartInteractUnpublish");
        if (r75 == null) goto L126;
        boolean r76 = r75.getAsBoolean();
    L127:
        r61.n = r76;
        goto L128
    L126:
        r76 = false;
        goto L127
    L114:
        if (r59.has("invisibleWhenJoinRTC") != true) goto L120;
        JsonElement r77 = r59.get("invisibleWhenJoinRTC");
        if (r77 == null) goto L118;
        boolean r78 = r77.getAsBoolean();
    L119:
        r61.m = r78;
        goto L120
    L118:
        r78 = false;
        goto L119
    L106:
        if (r59.has("enableAudioCaptureInBackground") != true) goto L112;
        JsonElement r79 = r59.get("enableAudioCaptureInBackground");
        if (r79 == null) goto L110;
        boolean r81 = r79.getAsBoolean();
    L111:
        r61.l = r81;
        goto L112
    L110:
        r81 = false;
        goto L111
    L98:
        if (r59.has("isAnchor") != true) goto L104;
        JsonElement r82 = r59.get("isAnchor");
        if (r82 == null) goto L102;
        boolean r83 = r82.getAsBoolean();
    L103:
        r61.k = r83;
        goto L104
    L102:
        r83 = false;
        goto L103
    L90:
        if (r59.has("linkerSessionID") != true) goto L96;
        JsonElement r84 = r59.get("linkerSessionID");
        if (r84 == null) goto L94;
        String r85 = r84.getAsString();
    L95:
        r61.j = r85;
        goto L96
    L94:
        r85 = null;
        goto L95
    L82:
        if (r59.has("anchorLinkmicID") != true) goto L88;
        JsonElement r86 = r59.get("anchorLinkmicID");
        if (r86 == null) goto L86;
        String r87 = r86.getAsString();
    L87:
        r61.i = r87;
        goto L88
    L86:
        r87 = null;
        goto L87
    L74:
        if (r59.has("anchorUserID") != true) goto L80;
        JsonElement r88 = r59.get("anchorUserID");
        if (r88 == null) goto L78;
        String r89 = r88.getAsString();
    L79:
        r61.h = r89;
        goto L80
    L78:
        r89 = null;
        goto L79
    L66:
        if (r59.has("myLinkmicID") != true) goto L72;
        JsonElement r91 = r59.get("myLinkmicID");
        if (r91 == null) goto L70;
        String r92 = r91.getAsString();
    L71:
        r61.g = r92;
        goto L72
    L70:
        r92 = null;
        goto L71
    L58:
        if (r59.has("myUserID") != true) goto L64;
        JsonElement r93 = r59.get("myUserID");
        if (r93 == null) goto L62;
        String r94 = r93.getAsString();
    L63:
        r61.f = r94;
        goto L64
    L62:
        r94 = null;
        goto L63
    L50:
        if (r59.has("clientType") != true) goto L56;
        JsonElement r95 = r59.get("clientType");
        if (r95 == null) goto L54;
        int r96 = r95.getAsInt();
    L55:
        r61.e = r96;
        goto L56
    L54:
        r96 = 4;
        goto L55
    L42:
        if (r59.has("liveCoreExtInfo") != true) goto L48;
        JsonElement r97 = r59.get("liveCoreExtInfo");
        if (r97 == null) goto L46;
        String r98 = r97.getAsString();
    L47:
        r61.d = r98;
        goto L48
    L46:
        r98 = null;
        goto L47
    L34:
        if (r59.has("rtcExtInfo") != true) goto L40;
        JsonElement r99 = r59.get("rtcExtInfo");
        if (r99 == null) goto L38;
        String r100 = r99.getAsString();
    L39:
        r61.c = r100;
        goto L40
    L38:
        r100 = null;
        goto L39
    L26:
        if (r59.has("playMode") != true) goto L32;
        JsonElement r101 = r59.get("playMode");
        if (r101 == null) goto L30;
        int r102 = r101.getAsInt();
    L31:
        r61.b = r102;
        goto L32
    L30:
        r102 = 3;
        goto L31
    L18:
        if (r59.has("channelID") != true) goto L24;
        JsonElement r103 = r59.get("channelID");
        if (r103 == null) goto L22;
        String r104 = r103.getAsString();
    L23:
        r61.a = r104;
        goto L24
    L22:
        r104 = null;
        goto L23
    L14:
        r59 = null;
        goto L15
    }

    public final void g(my.c r7) {
        int r0 = q.b;
        JsonObject r8 = r7.b;
        q r1 = new q();
        if (r8 == null) goto L7;
        JsonElement r2 = r8.get("method");
        if (r2 == null) goto L7;
        r2.getAsString();
    L7:
        if (r8 != null) goto L9;
    L31:
        r r9 = r1.a;
        if (r9 != null) goto L34;
        return;
    L34:
        LiveLinkWrapper r3 = this.a;
        if (r3 == null) goto L58;
        String r4 = r9.b;
        if (r4 == null) goto L50;
        sk0.c r5 = r3.c();
        if (r5 == null) goto L44;
        sk0.a r6 = r5.b;
        if (r6 == null) goto L44;
        r6.h(r4);
    L44:
        if (r3.u.v4() == false) goto L50;
        ei6.a r11 = r3.d;
        if (r11 == null) goto L50;
        si6.b r12 = r11.b();
        if (r12 == null) goto L50;
        r12.f(r4);
    L50:
        String r13 = r9.a;
        if (r13 == null) goto L59;
        ei6.a r14 = r3.d;
        if (r14 == null) goto L60;
        si6.b r15 = r14.b();
        if (r15 == null) goto L61;
        r15.c(r13);
        return;
    L61:
        return;
    L60:
        return;
    L59:
        return;
    L58:
        return;
    L9:
        if (r8.has("params") != true) goto L31;
        JsonElement r16 = r8.get("params");
        String r17 = null;
        if (r16 == null) goto L13;
        JsonObject r18 = r16.getAsJsonObject();
    L14:
        r r19 = new r();
        if (r18 != null) goto L17;
    L23:
        if (r18 != null) goto L25;
    L30:
        r1.a = r19;
        goto L31
    L25:
        if (r18.has("liveCoreExtInfo") != true) goto L30;
        JsonElement r21 = r18.get("liveCoreExtInfo");
        if (r21 == null) goto L29;
        r17 = r21.getAsString();
    L29:
        r19.b = r17;
        goto L30
    L17:
        if (r18.has("rtcExtInfo") != true) goto L23;
        JsonElement r22 = r18.get("rtcExtInfo");
        if (r22 == null) goto L21;
        String r23 = r22.getAsString();
    L22:
        r19.a = r23;
        goto L23
    L21:
        r23 = null;
        goto L22
    L13:
        r18 = null;
        goto L14
    }

    @Override // iy.e
    public final void b(my.c r25, final com.bytedance.android.live.liveinteract.jsbridge.method.k r26) {
        Intrinsics.checkNotNullParameter(r25, "updateStatus");
        Intrinsics.checkNotNullParameter(r26, "updateCallback");
        int r3 = f.a[r25.getType().ordinal()];
        if (r3 == 1) goto L551;
        int r7 = 2;
        if (r3 != 2) goto L7;
        JsonObject r4 = r25.b;
        if (r4 == null) goto L40;
        JsonElement r5 = r4.get("method");
        if (r5 == null) goto L40;
        String r6 = r5.getAsString();
    L41:
        if (r6 != null) goto L44;
    L10:
        boolean r8 = false;
    L586:
        if (r8 == true) goto L597;
        r26.a(1, "jsb invoke success", null);
        return;
    L597:
        return;
    L44:
        switch(r6.hashCode()) {
            case -1851386976: goto L516;
            case -1623986264: goto L512;
            case -1435540660: goto L471;
            case -1244367026: goto L466;
            case -951617032: goto L461;
            case -220562414: goto L445;
            case -18149800: goto L369;
            case 320565143: goto L364;
            case 345788232: goto L359;
            case 547180466: goto L343;
            case 793669692: goto L311;
            case 1150460648: goto L275;
            case 1218637773: goto L255;
            case 1349781152: goto L60;
            case 1515663759: goto L58;
            case 1751075789: goto L56;
            case 1986380653: goto L53;
            case 2036486484: goto L50;
            case 2081857682: goto L47;
            default: goto L10;
        };
    L58:
        r6.equals("cleanUpLiveCore");
        goto L10
    L516:
        r8 = false;
        if (r6.equals("setRuntimeParameters") == false) goto L586;
        int r9 = ny.f.b;
        JsonObject r0 = r25.b;
        ny.f r11 = new ny.f();
        if (r0 == null) goto L523;
        JsonElement r12 = r0.get("method");
        if (r12 == null) goto L523;
        r12.getAsString();
    L523:
        if (r0 != null) goto L525;
    L534:
        ny.g r1 = r11.a;
        if (r1 == null) goto L586;
        LiveLinkWrapper r13 = this.a;
        if (r13 == null) goto L586;
        if (r1.a == null) goto L586;
        ei6.a r14 = r13.d;
        if (r14 == null) goto L586;
        si6.b r15 = r14.b();
        if (r15 == null) goto L586;
        JsonObject r2 = r1.a;
        if (r2 == null) goto L549;
        String r16 = r2.toString();
    L550:
        r15.r(r16);
        goto L586
    L549:
        r16 = null;
        goto L550
    L525:
        if (r0.has("params") != true) goto L534;
        JsonElement r17 = r0.get("params");
        if (r17 == null) goto L529;
        JsonObject r18 = r17.getAsJsonObject();
    L530:
        ny.g r19 = new ny.g();
        if (r18 == null) goto L533;
        r19.a = r18;
    L533:
        r11.a = r19;
        goto L534
    L529:
        r18 = null;
        goto L530
    L47:
        if (r6.equals("setupLiveLinkService") == false) goto L10;
        e(r25);
        goto L10
    L50:
        if (r6.equals("updateMediaExtInfo") == false) goto L10;
        g(r25);
        goto L10
    L53:
        if (r6.equals("stopVideoCapture") == false) goto L10;
        f();
        goto L10
    L56:
        if (r6.equals("muteAllRemoteVideoStream") == false) goto L10;
        d(r25);
        goto L10
    L60:
        if (r6.equals("updateMixedStreamInfo") == false) goto L10;
        int r21 = s.b;
        JsonObject r22 = r25.b;
        s r23 = new s();
        if (r22 == null) goto L66;
        JsonElement r24 = r22.get("method");
        if (r24 == null) goto L66;
        r24.getAsString();
    L66:
        if (r22 != null) goto L68;
    L239:
        t r27 = r23.a;
        if (r27 == null) goto L10;
        LiveLinkWrapper r28 = this.a;
        if (r28 == null) goto L249;
        r28.k = r27;
        ei6.a r29 = r28.d;
        if (r29 == null) goto L249;
        vi6.a r31 = r29.v();
        if (r31 == null) goto L249;
        r31.f();
    L249:
        h r32 = this.c;
        t r33 = r23.a;
        LiveLinkWrapper r34 = this.a;
        if (r34 == null) goto L252;
        ei6.a r35 = r34.d;
    L253:
        r32.o4(r33, r35);
        goto L10
    L252:
        r35 = null;
        goto L253
    L68:
        if (r22.has("params") != true) goto L239;
        JsonElement r36 = r22.get("params");
        if (r36 == null) goto L72;
        JsonObject r37 = r36.getAsJsonObject();
    L73:
        t r38 = new t();
        if (r37 == null) goto L83;
        if (r37.has("canvas") != true) goto L83;
        JsonElement r39 = r37.get("canvas");
        if (r39 == null) goto L80;
        JsonObject r41 = r39.getAsJsonObject();
    L81:
        int r110 = ny.c.d;
        r38.a = ny.c.a.a(r41);
        goto L83
    L80:
        r41 = null;
    L83:
        if (r37 != null) goto L85;
    L149:
        if (r37 != null) goto L151;
    L238:
        r23.a = r38;
        goto L239
    L151:
        if (r37.has("regions") != true) goto L238;
        JsonElement r42 = r37.get("regions");
        if (r42 == null) goto L155;
        JsonArray r43 = r42.getAsJsonArray();
    L156:
        if (r43 == null) goto L238;
        ArrayList r44 = new ArrayList();
        int r45 = r43.size();
        int r46 = 0;
    L158:
        if (r46 >= r45) goto L237;
        JsonElement r111 = r43.get(r46);
        if (r111 == null) goto L162;
        JsonObject r112 = r111.getAsJsonObject();
    L163:
        if (r112 == null) goto L236;
        n r113 = new n();
        JsonElement r114 = r112.get("x");
        if (r114 == null) goto L167;
        double r115 = r114.getAsDouble();
    L168:
        r113.a = r115;
        JsonElement r116 = r112.get("y");
        if (r116 == null) goto L171;
        double r117 = r116.getAsDouble();
    L172:
        r113.b = r117;
        JsonElement r118 = r112.get("z");
        if (r118 == null) goto L175;
        double r119 = r118.getAsDouble();
    L176:
        r113.c = r119;
        JsonElement r120 = r112.get("xInContent");
        if (r120 == null) goto L179;
        double r121 = r120.getAsDouble();
    L180:
        r113.d = r121;
        JsonElement r122 = r112.get("yInContent");
        if (r122 == null) goto L183;
        double r123 = r122.getAsDouble();
    L184:
        r113.e = r123;
        JsonElement r124 = r112.get("wInContent");
        if (r124 == null) goto L187;
        double r125 = r124.getAsDouble();
    L188:
        r113.f = r125;
        JsonElement r126 = r112.get("hInContent");
        if (r126 == null) goto L191;
        double r127 = r126.getAsDouble();
    L192:
        r113.g = r127;
        JsonElement r128 = r112.get("width");
        if (r128 == null) goto L195;
        double r129 = r128.getAsDouble();
    L196:
        r113.h = r129;
        JsonElement r130 = r112.get("height");
        if (r130 == null) goto L199;
        double r131 = r130.getAsDouble();
    L200:
        r113.i = r131;
        JsonElement r132 = r112.get(LiveDegradeFpsAnimator.ALPHA);
        if (r132 == null) goto L203;
        float r133 = (float) r132.getAsDouble();
    L204:
        r113.j = r133;
        JsonElement r134 = r112.get("isLocal");
        if (r134 == null) goto L207;
        r134.getAsBoolean();
    L207:
        JsonElement r135 = r112.get("linkType");
        if (r135 == null) goto L210;
        int r136 = r135.getAsInt();
    L211:
        r113.k = r136;
        JsonElement r137 = r112.get("renderMode");
        if (r137 == null) goto L214;
        int r138 = r137.getAsInt();
    L215:
        r113.l = r138;
        JsonElement r139 = r112.get("linkmicID");
        if (r139 == null) goto L218;
        String r140 = r139.getAsString();
    L219:
        r113.m = r140;
        JsonElement r141 = r112.get("channelID");
        if (r141 == null) goto L222;
        String r142 = r141.getAsString();
    L223:
        r113.n = r142;
        JsonElement r143 = r112.get("streamInde");
        if (r143 == null) goto L226;
        r143.getAsInt();
    L226:
        JsonElement r144 = r112.get("isFromRoomEx");
        if (r144 == null) goto L229;
        r144.getAsBoolean();
    L229:
        JsonElement r145 = r112.get("isFromRoomEx2");
        if (r145 == null) goto L232;
        r145.getAsBoolean();
    L232:
        JsonElement r146 = r112.get("superResolutionMode");
        if (r146 == null) goto L235;
        r146.getAsInt();
    L235:
        r44.add(r113);
        goto L236
    L222:
        r142 = null;
        goto L223
    L218:
        r140 = null;
        goto L219
    L214:
        r138 = 0;
        goto L215
    L210:
        r136 = 0;
        goto L211
    L203:
        r133 = 1.0f;
        goto L204
    L199:
        r131 = 0.0d;
        goto L200
    L195:
        r129 = 0.0d;
        goto L196
    L191:
        r127 = 0.0d;
        goto L192
    L187:
        r125 = 0.0d;
        goto L188
    L183:
        r123 = 0.0d;
        goto L184
    L179:
        r121 = 0.0d;
        goto L180
    L175:
        r119 = 0.0d;
        goto L176
    L171:
        r117 = 0.0d;
        goto L172
    L167:
        r115 = 0.0d;
    L236:
        r46 = r46 + 1;
        goto L158
    L162:
        r112 = null;
        goto L163
    L237:
        r38.d = r44;
        goto L238
    L155:
        r43 = null;
        goto L156
    L85:
        if (r37.has("appData") != true) goto L149;
        JsonElement r147 = r37.get("appData");
        if (r147 == null) goto L89;
        JsonObject r148 = r147.getAsJsonObject();
    L90:
        ny.b r149 = new ny.b();
        if (r148 == null) goto L95;
        JsonElement r150 = r148.get("uiLayout");
        if (r150 == null) goto L95;
        int r151 = r150.getAsInt();
    L96:
        r149.a = r151;
        if (r148 == null) goto L101;
        JsonElement r152 = r148.get("scene");
        if (r152 == null) goto L101;
        int r153 = r152.getAsInt();
    L102:
        r149.b = r153;
        if (r148 == null) goto L107;
        JsonElement r154 = r148.get("functionType");
        if (r154 == null) goto L107;
        String r155 = r154.getAsString();
    L108:
        r149.c = r155;
        if (r148 != null) goto L111;
    L117:
        if (r148 != null) goto L119;
    L148:
        r38.b = r149;
        r38.c = r148;
        goto L149
    L119:
        if (r148.has("grids") != true) goto L148;
        JsonElement r47 = r148.get("grids");
        if (r47 == null) goto L123;
        JsonArray r48 = r47.getAsJsonArray();
    L124:
        if (r48 == null) goto L148;
        ArrayList r156 = new ArrayList();
        int r157 = r48.size();
        int r158 = 0;
    L126:
        if (r158 >= r157) goto L147;
        JsonElement r159 = r48.get(r158);
        if (r159 == null) goto L130;
        JsonObject r160 = r159.getAsJsonObject();
    L131:
        if (r160 == null) goto L146;
        ny.d r49 = new ny.d();
        JsonElement r161 = r160.get("linkmicID");
        if (r161 == null) goto L135;
        r161.getAsString();
    L135:
        JsonElement r51 = r160.get("talking");
        if (r51 == null) goto L138;
        r51.getAsInt();
    L138:
        JsonElement r52 = r160.get("type");
        if (r52 == null) goto L141;
        int r53 = r52.getAsInt();
    L142:
        r49.a = r53;
        JsonElement r54 = r160.get("p");
        if (r54 == null) goto L145;
        r54.getAsInt();
    L145:
        r156.add(r49);
        goto L146
    L141:
        r53 = 0;
    L146:
        r158 = r158 + 1;
        goto L126
    L130:
        r160 = null;
        goto L131
    L147:
        r149.e = r156;
        goto L148
    L123:
        r48 = null;
        goto L124
    L111:
        if (r148.has("canvas") != true) goto L117;
        JsonElement r55 = r148.get("canvas");
        if (r55 == null) goto L115;
        JsonObject r56 = r55.getAsJsonObject();
    L116:
        int r162 = ny.c.d;
        r149.d = ny.c.a.a(r56);
        goto L117
    L115:
        r56 = null;
    L107:
        r155 = null;
    L101:
        r153 = 0;
    L95:
        r151 = 0;
        goto L96
    L89:
        r148 = null;
        goto L90
    L72:
        r37 = null;
        goto L73
    L255:
        if (r6.equals("startVideoCapture") == false) goto L10;
        LiveLinkWrapper r57 = this.a;
        if (r57 == null) goto L10;
        Intrinsics.checkNotNullParameter("Jsb invoke", "reason");
        LinkMonitor.a(r57.a, "startVideoCapture", "[reason] Jsb invoke", null, null, true, 56);
        ec6.a r58 = r57.d();
        if (r58 == null) goto L263;
        sk0.c r59 = r58.r();
        if (r59 == null) goto L263;
        com.bytedance.android.live.livelink.platformapi.avclient.video.a r61 = r59.d;
    L264:
        if (r61 == null) goto L266;
        Integer r62 = Integer.valueOf(r61.h());
    L267:
        if (r62 != null) goto L270;
    L272:
        if (r61 == null) goto L10;
        r61.d("Jsb invoke");
        goto L10
    L270:
        if (r62.intValue() != 0) goto L272;
        r61.g(r57.u.g());
        goto L272
    L266:
        r62 = null;
    L263:
        r61 = null;
        goto L264
    L275:
        if (r6.equals("muteAllRemoteAudioStream") == false) goto L10;
        int r63 = ny.h.b;
        JsonObject r64 = r25.b;
        ny.h r65 = new ny.h();
        if (r64 == null) goto L281;
        JsonElement r66 = r64.get("method");
        if (r66 == null) goto L281;
        r66.getAsString();
    L281:
        if (r64 != null) goto L283;
    L300:
        ny.i r67 = r65.a;
        if (r67 == null) goto L10;
        LiveLinkWrapper r68 = this.a;
        if (r68 == null) goto L10;
        String r69 = bj6.a.b(r68.d);
        boolean r71 = r67.a;
        String r72 = r67.b;
        ei6.a r73 = r68.d;
        if (r73 == null) goto L10;
        ri6.b r74 = r73.r();
        if (r74 == null) goto L10;
        r74.p(r69, r71, r72);
        goto L10
    L283:
        if (r64.has("params") != true) goto L300;
        JsonElement r75 = r64.get("params");
        if (r75 == null) goto L287;
        JsonObject r76 = r75.getAsJsonObject();
    L288:
        ny.i r77 = new ny.i();
        if (r76 == null) goto L299;
        JsonElement r78 = r76.get("mute");
        if (r78 == null) goto L293;
        boolean r79 = r78.getAsBoolean();
    L294:
        r77.a = r79;
        JsonElement r81 = r76.get("reason");
        if (r81 == null) goto L297;
        String r82 = r81.getAsString();
    L298:
        r77.b = r82;
        goto L299
    L297:
        r82 = null;
        goto L298
    L293:
        r79 = false;
    L299:
        r65.a = r77;
        goto L300
    L287:
        r76 = null;
        goto L288
    L311:
        if (r6.equals("overturnVideoCapture") == false) goto L10;
        LiveLinkWrapper r83 = this.a;
        if (r83 == null) goto L10;
        ec6.a r84 = r83.d();
        if (r84 == null) goto L321;
        sk0.c r85 = r84.r();
        if (r85 == null) goto L321;
        com.bytedance.android.live.livelink.platformapi.avclient.video.a r86 = r85.d;
        if (r86 == null) goto L321;
        Integer r87 = Integer.valueOf(r86.h());
    L322:
        if (r87 != null) goto L325;
    L327:
        boolean r88 = false;
    L329:
        if (i.g() == false) goto L334;
        if (r88 == true) goto L333;
        r7 = 1;
    L333:
        com.bytedance.android.livesdk.sharedpref.d.m(r7);
        int r89 = com.bytedance.android.livesdk.sharedpref.d.c();
    L335:
        LinkMonitor.a(r83.a, "overturnVideoCapture，currentCaptureDevice " + r87 + ", chooseDevice " + r89, null, null, null, false, 124);
        ec6.a r91 = r83.d();
        if (r91 == null) goto L10;
        sk0.c r92 = r91.r();
        if (r92 == null) goto L10;
        com.bytedance.android.live.livelink.platformapi.avclient.video.a r93 = r92.d;
        if (r93 == null) goto L10;
        r93.g(r89);
        goto L10
    L334:
        r89 = 1;
        goto L335
    L325:
        if (r87.intValue() != 1) goto L327;
        r88 = true;
    L321:
        r87 = null;
        goto L322
    L343:
        if (r6.equals("stopAudioCapture") == false) goto L10;
        LiveLinkWrapper r94 = this.a;
        if (r94 == null) goto L10;
        Intrinsics.checkNotNullParameter("Jsb invoke", "reason");
        LinkMonitor.a(r94.a, "stopAudioCapture", "[reason] Jsb invoke", null, null, true, 56);
        ec6.a r95 = r94.d();
        if (r95 == null) goto L351;
        sk0.c r96 = r95.r();
        if (r96 == null) goto L351;
        tk0.a r97 = r96.c;
    L352:
        if (r97 != null) goto L354;
    L356:
        if (r97 == null) goto L10;
        r97.c(true, "Jsb invoke");
        goto L10
    L354:
        if (r97.b() == true) goto L356;
        r97.f("Jsb invoke");
    L351:
        r97 = null;
        goto L352
    L359:
        if (r6.equals("startTalkingReport") == false) goto L10;
        LiveLinkWrapper r98 = this.a;
        if (r98 == null) goto L10;
        Intrinsics.checkNotNullParameter("Jsb invoke", "string");
        LinkMonitor.a(r98.a, "startTalkingReport reason: ", "Jsb invoke", null, null, false, 120);
        r98.t = true;
        goto L10
    L364:
        if (r6.equals("pauseStreamPlayer") == false) goto L10;
        LiveLinkWrapper r99 = this.a;
        if (r99 == null) goto L10;
        Intrinsics.checkNotNullParameter("Jsb invoke", "reason");
        LinkMonitor.a(r99.a, "pauseStreamPlayer", "[reason] Jsb invoke", null, null, true, 56);
        r99.u.x4();
        goto L10
    L369:
        if (r6.equals("startInteractStream") == false) goto L10;
        LiveLinkWrapper r100 = this.a;
        if (r100 == null) goto L10;
        ei6.a r101 = r100.d;
        if (r101 == null) goto L375;
        si6.b r102 = r101.b();
    L376:
        if (r102 == null) goto L378;
        r102.o(r102.m(), true);
    L378:
        LinkMonitor.a(r100.a, "setUserVisibility", "[source] Lynx JSB isVisible true rtcClient " + r100.d, null, null, true, 56);
        if (r100.g().e == false) goto L381;
    L443:
        LinkMonitor.a(r100.a, "startRtcEngine", "rtc client is started or starting , ignore", null, null, false, 120);
        goto L10
    L381:
        if (r100.g().c == true) goto L443;
        LinkMonitor.a(r100.a, "startRtcEngine", "[source] Lynx JSB needPushStream true isUserVisible true needSubscribeAudio true needSubscribeVideo true", null, null, true, 56);
        if (r100.g().e == false) goto L386;
        LinkMonitor.a(r100.a, "engine is in start state", null, null, null, false, 124);
        goto L10
    L386:
        i97.a r103 = i97.a.a;
        LinkMonitor.d = System.currentTimeMillis();
        com.bytedance.android.live.anchormodelink.livelink.d r104 = new com.bytedance.android.live.anchormodelink.livelink.d();
        LinkMonitor.a(r100.a, "startRtcEngine", "needPushStream true isUserVisible true needSubscribeRemoteAudio true needSubscribeRemoteVideo true[source] Lynx JSB", null, null, false, 120);
        ei6.a r105 = r100.d;
        if (r105 == null) goto L10;
        KmpEnv r106 = KmpEnv.a;
        if (v.a() == false) goto L394;
        if (i.h().c4() == false) goto L394;
        LinkMonitor.a(r100.a, "mock rtc start failed", null, null, null, false, 124);
        r100.h().H(r105, -1, -12303, new Exception("mock rtc start failed"));
    L394:
        if (r100.g().e == false) goto L397;
        LinkMonitor.a(r100.a, "rtc engine is on skip!", null, null, null, false, 124);
        goto L10
    L397:
        if (r100.g().c == false) goto L399;
        LinkMonitor.a(r100.a, "rtc engine is starting skip", null, null, null, false, 124);
        goto L10
    L399:
        fi6.a r107 = r105.g();
        if (r107 == null) goto L402;
        String r108 = r107.v;
    L403:
        if (r108 != null) goto L405;
    L408:
        boolean r109 = true;
    L409:
        if (r109 != true) goto L411;
        LinkMonitor.a(r100.a, "rtc ext info is null or blank", null, null, LinkMonitor.LogLevel.ERROR, false, 108);
        r100.h().H(r105, -1, -12303, new Exception("rtc ext info is null or blank"));
        goto L10
    L411:
        r100.g().c = true;
        r100.g().b(false, "startRtcEngine");
        r100.g.clear();
        r100.m = System.currentTimeMillis();
        InteractLinkFullLinkMonitor.c0();
        my.a r163 = r100.v;     // Catch: Throwable -> L438
        if (r163 == null) goto L419;
        String r164 = r163.c;     // Catch: Throwable -> L438
        if (r164 == null) goto L419;
        fi6.a r165 = r105.g();     // Catch: Throwable -> L438
        if (r165 == null) goto L419;
        r165.k0 = r164;     // Catch: Throwable -> L438
    L419:
        si6.b r166 = r105.b();     // Catch: Throwable -> L438
        if (r166 == null) goto L426;
        si6.b r167 = r105.b();     // Catch: Throwable -> L438
        if (r167 == null) goto L424;
        String r168 = r167.m();     // Catch: Throwable -> L438
    L425:
        si6.a.a(r166, String.valueOf(r168), true, 12);     // Catch: Throwable -> L438
        goto L426
    L424:
        r168 = null;
    L426:
        Disposable r169 = r100.i;     // Catch: Throwable -> L438
        if (r169 == null) goto L429;
        r169.dispose();     // Catch: Throwable -> L438
    L429:
        Disposable r170 = r100.h;     // Catch: Throwable -> L438
        if (r170 == null) goto L432;
        r170.dispose();     // Catch: Throwable -> L438
    L432:
        com.bytedance.revenue.platform.api.core.rx.l r171 = com.bytedance.revenue.platform.api.core.rx.l.a;     // Catch: Throwable -> L438
        long r172 = i.l() * ((long) 1000);     // Catch: Throwable -> L438
        int r173 = com.bytedance.revenue.platform.api.core.rx.p.a;     // Catch: Throwable -> L438
        Disposable r174 = Observable.timer(r172, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.anchormodelink.livelink.a(r100, r104));     // Catch: Throwable -> L438
        com.bytedance.revenue.platform.api.core.rx.f.a(r174, r100.j);     // Catch: Throwable -> L438
        r100.h = r174;     // Catch: Throwable -> L438
        ei6.a r175 = r100.d;     // Catch: Throwable -> L438
        if (r175 == null) goto L10;
        ri6.b r176 = r175.r();     // Catch: Throwable -> L438
        if (r176 == null) goto L10;
        r176.t1();     // Catch: Throwable -> L438
        Unit r177 = Unit.INSTANCE;     // Catch: Throwable -> L438
    L438:
        th = move-exception;
        LinkMonitor.a(r100.a, "start rtc crash " + th + " stackTrace=" + ExceptionsKt.stackTraceToString(th), null, null, LinkMonitor.LogLevel.ERROR, false, 108);
        Disposable r178 = r100.h;
        if (r178 == null) goto L442;
        r178.dispose();
    L442:
        r100.g().c = false;
        r100.h().H(r100.d, -1, -12304, new Exception(th));
        Unit r179 = Unit.INSTANCE;
        goto L10
    L405:
        if (StringsKt.isBlank(r108) == true) goto L408;
        r109 = false;
        goto L409
    L402:
        r108 = null;
        goto L403
    L375:
        r102 = null;
        goto L376
    L445:
        if (r6.equals("startAudioCapture") == false) goto L10;
        LiveLinkWrapper r180 = this.a;
        if (r180 == null) goto L10;
        Intrinsics.checkNotNullParameter("Jsb invoke", "reason");
        LinkMonitor.a(r180.a, "startAudioCapture", "[reason] Jsb invoke", null, null, true, 56);
        ec6.a r181 = r180.d();
        if (r181 == null) goto L453;
        sk0.c r182 = r181.r();
        if (r182 == null) goto L453;
        tk0.a r183 = r182.c;
    L454:
        if (r183 != null) goto L456;
    L458:
        if (r183 == null) goto L10;
        r183.c(false, "Jsb invoke");
        goto L10
    L456:
        if (r183.b() == true) goto L458;
        r183.f("Jsb invoke");
    L453:
        r183 = null;
        goto L454
    L461:
        if (r6.equals("stopInteractStream") == false) goto L10;
        LiveLinkWrapper r184 = this.a;
        if (r184 == null) goto L10;
        r184.k("Lynx JSB");
        goto L10
    L466:
        if (r6.equals("resumeStreamPlayer") == false) goto L10;
        LiveLinkWrapper r185 = this.a;
        if (r185 == null) goto L10;
        Intrinsics.checkNotNullParameter("Jsb invoke", "reason");
        LinkMonitor.a(r185.a, "resumeStreamPlayer", "[reason] Jsb invoke", null, null, true, 56);
        r185.u.p4();
        goto L10
    L471:
        if (r6.equals("publishVideoStream") == false) goto L10;
        int r186 = ny.l.b;
        JsonObject r187 = r25.b;
        ny.l r188 = new ny.l();
        if (r187 == null) goto L477;
        JsonElement r189 = r187.get("method");
        if (r189 == null) goto L477;
        r189.getAsString();
    L477:
        if (r187 != null) goto L479;
    L496:
        m r190 = r188.a;
        if (r190 == null) goto L10;
        LiveLinkWrapper r191 = this.a;
        if (r191 == null) goto L10;
        boolean r192 = r190.a;
        String r193 = r190.b;
        if (r193 != null) goto L504;
        r193 = "";
    L504:
        LinkMonitor.a(r191.a, "publishVideoStream", "[reason] ".concat(r193), null, null, true, 56);
        ei6.a r194 = r191.d;
        if (r194 == null) goto L10;
        xi6.c r195 = r194.t();
        if (r195 == null) goto L10;
        com.bytedance.live.livelink.kmp.impl.core.video.b r196 = r195.f();
        if (r196 == null) goto L10;
        r196.e(!r192);
        goto L10
    L479:
        if (r187.has("params") != true) goto L496;
        JsonElement r197 = r187.get("params");
        if (r197 == null) goto L483;
        JsonObject r198 = r197.getAsJsonObject();
    L484:
        m r199 = new m();
        if (r198 == null) goto L495;
        JsonElement r200 = r198.get("publish");
        if (r200 == null) goto L489;
        boolean r201 = r200.getAsBoolean();
    L490:
        r199.a = r201;
        JsonElement r202 = r198.get("reason");
        if (r202 == null) goto L493;
        String r203 = r202.getAsString();
    L494:
        r199.b = r203;
        goto L495
    L493:
        r203 = null;
        goto L494
    L489:
        r201 = false;
    L495:
        r188.a = r199;
        goto L496
    L483:
        r198 = null;
        goto L484
    L512:
        if (r6.equals("stopTalkingReport") == false) goto L10;
        LiveLinkWrapper r204 = this.a;
        if (r204 == null) goto L10;
        Intrinsics.checkNotNullParameter("Jsb invoke", "string");
        LinkMonitor.a(r204.a, "stopTalkingReport reason: ", "Jsb invoke", null, null, false, 120);
        r8 = false;
        r204.t = false;
    L40:
        r6 = null;
        goto L41
    L7:
        if (r3 != 3) goto L9;
        int r205 = ny.e.d;
        JsonObject r206 = r25.b;
        ny.e r207 = new ny.e();
        if (r206 == null) goto L29;
        JsonElement r208 = r206.get("startTitle");
        if (r208 == null) goto L17;
        String r209 = r208.getAsString();
    L18:
        r207.a = r209;
        JsonElement r210 = r206.get("otherTitle");
        if (r210 == null) goto L21;
        String r211 = r210.getAsString();
    L22:
        r207.b = r211;
        JsonElement r212 = r206.get("disableCancel");
        if (r212 == null) goto L25;
        boolean r213 = r212.getAsBoolean();
    L26:
        r207.c = r213;
        JsonElement r214 = r206.get("source");
        if (r214 == null) goto L29;
        r214.getAsString();
        goto L29
    L25:
        r213 = false;
        goto L26
    L21:
        r211 = null;
        goto L22
    L17:
        r209 = null;
    L29:
        LiveLinkWrapper r215 = this.a;
        if (r215 == null) goto L32;
        ec6.a r216 = r215.c;
    L33:
        this.c.z4(r207, r216, new LiveLinkHandler$handleLinkmicBeautyPanel$1(this, r26), new LiveLinkHandler$handleLinkmicBeautyPanel$2(this, r26));
    L34:
        r8 = true;
        goto L586
    L32:
        r216 = null;
        goto L33
    L9:
        if (r3 != 4) goto L10;
        this.c.n4(new LiveLinkHandler$handleCloseVideoChorus$1(this, r26), new LiveLinkHandler$handleCloseVideoChorus$2(this, r26));
        goto L34
    L551:
        r8 = false;
        JsonObject r217 = r25.b;
        if (r217 == null) goto L556;
        JsonElement r218 = r217.get("key");
        if (r218 == null) goto L556;
        String r219 = r218.getAsString();
    L557:
        JsonObject r220 = r25.b;
        if (r220 == null) goto L560;
        JsonElement r221 = r220.get("data");
    L561:
        JsonObject r222 = r25.b;
        if (r222 == null) goto L566;
        JsonElement r223 = r222.get("repeat");
        if (r223 == null) goto L566;
        int r1100 = r223.getAsInt();
    L567:
        JsonObject r224 = r25.b;
        if (r224 == null) goto L572;
        JsonElement r225 = r224.get("keyFrame");
        if (r225 == null) goto L572;
        boolean r1101 = r225.getAsBoolean();
    L573:
        JsonObject r226 = r25.b;
        if (r226 == null) goto L578;
        JsonElement r227 = r226.get("covered");
        if (r227 == null) goto L578;
        boolean r1102 = r227.getAsBoolean();
    L579:
        LiveLinkWrapper r228 = this.a;
        if (r228 == null) goto L586;
        ec6.a r229 = r228.d();
        if (r229 == null) goto L586;
        sk0.c r230 = r229.r();
        if (r230 == null) goto L586;
        r230.f(r219, r221, r1100, r1101, r1102);
    L578:
        r1102 = false;
    L572:
        r1101 = false;
    L566:
        r1100 = -1;
        goto L567
    L560:
        r221 = null;
    L556:
        r219 = null;
        goto L557
    }
}
