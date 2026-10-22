package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.message.n5;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.GameDataReportHelper;
import com.bytedance.android.live.broadcastgame.api.interactgame.GameLaunchSource;
import com.bytedance.android.live.broadcastgame.channel.ContinuousTimeTicker;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class AnchorGameMessageChannel implements c0 {
    public static final /* synthetic */ int n = 0;
    public final com.bytedance.android.live.broadcastgame.i0 a;
    public final d0 b;
    public final Lazy c;
    public boolean d;
    public final q e;
    public final com.bytedance.android.live.pushstream.d f;
    public final com.bytedance.android.live.broadcastgame.opengame.f g;
    public final String h;
    public final String i;
    public final long j;
    public final com.bytedance.android.live.broadcastgame.api.model.r k;
    public final com.bytedance.android.live.broadcastgame.opengame.runtime.q l;
    public final /* synthetic */ i20.a m;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AnchorGameMessageChannel a;
        public final /* synthetic */ Function3 b;

        public b(AnchorGameMessageChannel r1, Function3 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r9) {
            int r11 = ((com.bytedance.android.live.broadcastgame.j0) r9).a;
            if (r11 != 0) goto L5;
            AnchorGameMessageChannel r12 = this.a;
            final Function3 r0 = this.b;
            r12.getClass();
            UtilityKotlinExtentionsKt.s(0, false, false, new AnchorGameMessageChannel$onLaunchSuccess$1(r0), 7);
            return;
        L5:
            AnchorGameMessageChannel r1 = this.a;
            Function3 r2 = this.b;
            if (r11 != 2) goto L8;
            boolean r13 = true;
        L9:
            Boolean r14 = Boolean.valueOf(r13);
            r1.getClass();
            UtilityKotlinExtentionsKt.s(0, false, false, new AnchorGameMessageChannel$onLaunchFail$1(r2, null, r14), 7);
            return;
        L8:
            r13 = false;
            goto L9
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ AnchorGameMessageChannel a;
        public final /* synthetic */ f0 b;
        public final /* synthetic */ Function3 c;

        public c(AnchorGameMessageChannel r1, f0 r2, Function3 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r22) {
            final Throwable r1 = (Throwable) r22;
            int r2 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("AnchorGameMessageChannel", new Object[]{"send app/start fail, error: ", r1});
            String r7 = null;
            if ((r1 instanceof CustomApiServerException) == true) goto L5;
            Throwable r3 = null;
        L6:
            CustomApiServerException r4 = (CustomApiServerException) r3;
            if (r4 != null) goto L59;
            AnchorGameMessageChannel r5 = this.a;
            Function3 r6 = this.c;
            Boolean r8 = Boolean.FALSE;
            r5.getClass();
            UtilityKotlinExtentionsKt.s(0, false, false, new AnchorGameMessageChannel$onLaunchFail$1(r6, null, r8), 7);
            return;
        L59:
            JsonElement r9 = GsonHelper.parser().parse(r4.getExtra());     // Catch: Exception -> L33
            if (r9 == null) goto L17;
            JsonObject r11 = r9.getAsJsonObject();     // Catch: Exception -> L33
            if (r11 == null) goto L17;
            JsonElement r12 = r11.get("control_content_msg");     // Catch: Exception -> L33
            if (r12 == null) goto L17;
            String r13 = r12.getAsString();     // Catch: Exception -> L33
            if (r13 == null) goto L17;
        L18:
            JsonObject r14 = GsonHelper.parser().parse(r13).getAsJsonObject();     // Catch: Exception -> L33
            final com.bytedance.android.livesdk.wrds.interact.a.b r15 = (com.bytedance.android.livesdk.wrds.interact.a.b) GsonHelper.get().fromJson(r14, com.bytedance.android.livesdk.wrds.interact.a.b.class);     // Catch: Exception -> L33
            r15.a = null;     // Catch: Exception -> L33
            JsonElement r16 = r14.get("toast_msg");     // Catch: Exception -> L33
            if (r16 == null) goto L21;
            String r17 = r16.getAsString();     // Catch: Exception -> L33
        L22:
            String r18 = ((BootInfoService) this.a.l.mo311getContext().o(BootInfoService.class)).e();     // Catch: Exception -> L33
            com.bytedance.android.live.broadcastgame.opengame.t r19 = this.a.l.mo311getContext().m;     // Catch: Exception -> L33
            int r110 = GameDataReportHelper.a;     // Catch: Exception -> L33
            RoomContext r111 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);     // Catch: Exception -> L33
            if (r111 == null) goto L27;
            com.bytedance.live.datacontext.n r112 = r111.getDataCenter();     // Catch: Exception -> L33
            if (r112 == null) goto L27;
            DataCenter r113 = (DataCenter) r112.getValue();     // Catch: Exception -> L33
        L27:
            com.bytedance.android.live.broadcastgame.api.model.r r114 = this.a.k;     // Catch: Exception -> L33
            if (r114 == null) goto L30;
            String r115 = r114.q();     // Catch: Exception -> L33
        L31:
            GameDataReportHelper.f(String.valueOf(r115), String.valueOf(r19.h), r15.a(), r18, true);     // Catch: Exception -> L33
            UtilityKotlinExtentionsKt.s(0, false, false, new AnchorGameMessageChannel$sendOpenEntranceMessage$2$$special$$inlined$let$lambda$1(r15, this, r1), 7);     // Catch: Exception -> L33
        L44:
            r7 = r17;
        L46:
            if (r4.getErrorCode() == 4014047) goto L48;
            AnchorGameMessageChannel r21 = this.a;
            Function3 r23 = this.c;
            Boolean r24 = Boolean.FALSE;
            r21.getClass();
            UtilityKotlinExtentionsKt.s(0, false, false, new AnchorGameMessageChannel$onLaunchFail$1(r23, r7, r24), 7);
            return;
        L48:
            JsonElement r25 = GsonProtectorUtils.parse(GsonHelper.parser(), r4.getExtra());
            if (r25 == null) goto L55;
            JsonObject r26 = r25.getAsJsonObject();
            if (r26 == null) goto L55;
            JsonElement r27 = r26.get("shark_code");
            if (r27 == null) goto L55;
            int r28 = r27.getAsInt();
        L56:
            int r29 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("AnchorGameMessageChannel", new Object[]{"hit risk logic", ", show verify code dialog, sharkCode: ", Integer.valueOf(r28)});
            AnchorGameMessageChannel r31 = this.a;
            f0 r32 = this.b;
            Function3 r33 = this.c;
            r31.getClass();
            Logger.d("showCaptcha", "showVerifyCodeDialog, errorCode=" + r28);
            TTLiveSDK.hostService().verify().showCaptcha(jc1.k.n(IHostApp.class).getCurrentActivity(), r28, new e(r31, r32, r33));
            return;
        L55:
            r28 = 0;
            goto L56
        L30:
            r115 = null;
            goto L31
        L21:
            r17 = null;
        L17:
            r13 = "";
        L33:
            String r34 = r4.getPrompt();
            if (r34 != null) goto L36;
        L43:
            r17 = s1.B(2131920880);
            goto L44
        L36:
            if (r34.length() <= 0) goto L38;
            boolean r35 = true;
        L39:
            if (r35 == false) goto L41;
            r7 = r34;
        L41:
            if (r7 == null) goto L43;
        L38:
            r35 = false;
            goto L39
        L5:
            r3 = r1;
            goto L6
        }
    }

    static {
    }

    public final void b() {
        this.m.b();
        this.a.d();
        this.g.b();
        this.d = true;
        UtilityKotlinExtentionsKt.s(n5.DEFAULT_SHOW_DURATION, false, false, new AnchorGameMessageChannel$onDestroy$1(this), 6);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.message.c0
    public final <T extends com.bytedance.android.live.broadcastgame.v> Observable<T> a(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "messageType");
        return this.a.f(r2);
    }

    public final void c(f0 r4, Function3<? super Boolean, ? super String, ? super Boolean, Unit> r5) {
        Observable<com.bytedance.android.live.broadcastgame.j0> r0 = this.a.e(r4);
        if (r0 == null) goto L8;
        Disposable r6 = r0.subscribe(new b(this, r5), new c(this, r4, r5));
        if (r6 == null) goto L9;
        Intrinsics.checkNotNullParameter(r6, "$this$autoDispose");
        this.m.a(r6);
        return;
    L9:
        return;
    }

    public final void d(long r6, final Integer r8) {
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r0 = AnchorGameContext.a.a();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.m<GameLaunchSource> r1 = r0.getOpenGameLaunchSource();
        if (r1 == null) goto L11;
        GameLaunchSource r2 = (GameLaunchSource) r1.getValue();
        if (r2 == null) goto L11;
        if (r2.getSource() != GameLaunchSource.GamePromote.getSource()) goto L11;
        return;
    L11:
        final JSONObject r3 = new JSONObject();
        r3.put(OpenPlatformBaseDebugger.APP_ID, this.h);
        r3.put("id", r6);
        ((ContinuousTimeTicker) this.c.getValue()).a(1000, new AnchorGameMessageChannel$sendSeiHeartBeatMessage$1(this, r3, r8));
    }

    public AnchorGameMessageChannel(com.bytedance.android.live.pushstream.d r14, com.bytedance.android.live.broadcastgame.opengame.f r15, String r16, String r17, long r18, com.bytedance.android.live.broadcastgame.api.model.r r21, com.bytedance.android.live.broadcastgame.opengame.runtime.q r22) {
        Intrinsics.checkNotNullParameter(r14, "liveStream");
        Intrinsics.checkNotNullParameter(r15, "gameIMManager");
        Intrinsics.checkNotNullParameter(r16, "appId");
        Intrinsics.checkNotNullParameter(r17, "appVersion");
        Intrinsics.checkNotNullParameter(r22, "pluginRuntime");
        this.m = new i20.a();
        this.f = r14;
        this.g = r15;
        this.h = r16;
        this.i = r17;
        this.j = r18;
        this.k = r21;
        this.l = r22;
        com.bytedance.android.live.broadcastgame.i0 r1 = new com.bytedance.android.live.broadcastgame.i0();
        this.a = r1;
        this.b = new d0();
        this.c = LazyKt.lazy(AnchorGameMessageChannel$heartBeatSeiSender$2.INSTANCE);
        q r5 = new q();
        this.e = r5;
        int r6 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("AnchorGameMessageChannel", new Object[]{"init AnchorGameMessageChannel"});
        vlc.d r2 = r15.a(true);
        vlc.d r11 = null;
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r7 == null) goto L7;
        com.bytedance.live.datacontext.n r8 = r7.getDataCenter();
        if (r8 == null) goto L7;
        DataCenter r12 = (DataCenter) r8.getValue();
    L8:
        if (r12 == null) goto L10;
        r11 = (vlc.d) r12.get("data_message_manager", null);
    L10:
        vlc.d r9 = r11;
        r1.c(f0.class, new h0());
        r1.c(com.bytedance.android.live.broadcastgame.opengame.message.a.class, new d());
        r1.c(y.class, new a0());
        r1.b(f.class, new h(r2));
        r1.b(u.class, new v(r2));
        r1.b(o.class, new p(r2));
        r1.b(r.class, new s(r2));
        r1.b(j0.class, new k0(r2));
        r1.a(r5);
        if (r12 == null) goto L14;
        if (r9 == null) goto L14;
        r1.b(com.bytedance.android.live.broadcastgame.v.class, new l0(r9, r18, true, r12));
    L14:
        r1.b(i0.a.class, new i0(r9));
        return;
    L7:
        r12 = null;
        goto L8
    }
}
