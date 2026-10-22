package com.bytedance.android.live.broadcastgame.opengame.view;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.model.h0;
import com.bytedance.android.live.broadcastgame.api.model.p0;
import com.bytedance.android.live.broadcastgame.api.openplatform.OpenPlatformMonitorUtils;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.xplay.q1;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.nc1;
import com.bytedance.android.livesdk.config.rd0;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.Gson;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import zg1.a3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i {
    public static final /* synthetic */ int j = 0;
    public final CompositeDisposable a;
    public HybridDialog b;
    public boolean c;
    public e d;
    public final Context e;
    public final DataCenter f;
    public final com.bytedance.android.live.broadcastgame.api.model.u g;
    public final com.bytedance.android.live.broadcastgame.api.openplatform.b h;
    public final /* synthetic */ i20.a i;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ i a;
        public final /* synthetic */ HybridDialog b;

        public b(i r1, HybridDialog r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r9) {
            sh6.b r11 = (sh6.b) r9;
            h0.c r0 = (h0.c) sh6.c.b(r11);
            if ((r0 instanceof h0.e) == false) goto L20;
            i r1 = this.a;
            Object r12 = sh6.c.b(r11);
            if (r12 == null) goto L18;
            h0.e r13 = (h0.e) r12;
            HybridDialog r2 = this.b;
            r1.getClass();
            com.bytedance.android.livesdk.log.b0 r5 = com.bytedance.android.livesdk.log.b0.o();
            String r6 = r1.g.name + " onLaunchSucceed: appStart" + r13.c + "  bootconfig" + r13.b + " metadownload" + r13.a;
            r5.getClass();
            com.bytedance.android.live.core.log.g.a("InteractivePlayStartIntroLynxDialog", r6);
            if (r13.c == false) goto L16;
            r1.c = true;
            r1.f.put("cmd_live_toolbarmore_dialog_dismiss", Boolean.TRUE);
            i.c(r2, 100, "");
            HybridDialog r14 = r1.b;
            if (r14 == null) goto L16;
            r14.dismiss();     // Catch: Exception -> L12
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r15 = DialogFragmentLancet.sLastShowStack;
            if (r15 == null) goto L16;
            com.bytedance.crash.d.d(r15, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        L16:
            r1.a.dispose();
            return;
        L18:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.api.model.OpenGameLaunchResult.LaunchSuccess");
        L20:
            if ((r0 instanceof h0.a) == false) goto L38;
            i r3 = this.a;
            Object r16 = sh6.c.b(r11);
            if (r16 == null) goto L32;
            HybridDialog r4 = this.b;
            r3.getClass();
            com.bytedance.android.livesdk.log.b0 r7 = com.bytedance.android.livesdk.log.b0.o();
            String r8 = r3.g.name + " onLaunchFailed";
            r7.getClass();
            com.bytedance.android.live.core.log.g.a("InteractivePlayStartIntroLynxDialog", r8);
            i.c(r4, -1, ((h0.a) r16).a);
            r3.a.dispose();
            HybridDialog r17 = r3.b;
            if (r17 == null) goto L39;
            r17.dismiss();     // Catch: Exception -> L27
            return;
        L27:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r18 = DialogFragmentLancet.sLastShowStack;
            if (r18 == null) goto L40;
            com.bytedance.crash.d.d(r18, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L40:
            return;
        L39:
            return;
        L32:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.api.model.OpenGameLaunchResult.LaunchFail");
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ i a;
        public final /* synthetic */ HybridDialog b;

        public c(i r1, HybridDialog r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            i r0 = this.a;
            h0.b r6 = (h0.b) sh6.c.b((sh6.b) r5);
            if (r6 == null) goto L5;
            int r7 = r6.a;
        L6:
            HybridDialog r1 = this.b;
            r0.getClass();
            com.bytedance.android.livesdk.log.b0 r2 = com.bytedance.android.livesdk.log.b0.o();
            String r3 = r0.g.name + " onMetaDownloadProgress " + r7;
            r2.getClass();
            com.bytedance.android.live.core.log.g.a("InteractivePlayStartIntroLynxDialog", r3);
            i.c(r1, r7, "");
            return;
        L5:
            r7 = 0;
            goto L6
        }
    }

    static {
    }

    public static String a() {
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r0 = AnchorGameContext.a.a();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<String> r1 = r0.getClickIconSource();
        if (r1 == null) goto L7;
        String r2 = (String) r1.getValue();
    L8:
        if (r2 == null) goto L26;
        int r3 = r2.hashCode();
        if (r3 == (-1768820280)) goto L24;
        if (r3 == (-1659249440)) goto L21;
        if (r3 != (-906336856)) goto L26;
        if (r2.equals("search") == false) goto L26;
        return "function_panel_search";
    L21:
        if (r2.equals("use_recently") == false) goto L26;
        return "function_panel_recently";
    L24:
        if (r2.equals("game_tab") == false) goto L26;
        return "function_panel_barrage";
    L26:
        return "";
    L7:
        r2 = null;
        goto L8
    }

    public final Context getContext() {
        return this.e;
    }

    public final void b(HybridDialog r5) {
        InteractGameContext.Companion r0 = InteractGameContext.Companion;
        InteractGameContext r1 = r0.getContext();
        if (r1 == null) goto L13;
        com.bytedance.live.datacontext.n<h0.c> r2 = r1.getOpenGameLaunchResult();
        if (r2 == null) goto L13;
        Observable r3 = r2.a();
        if (r3 == null) goto L13;
        Observable r4 = r3.observeOn(AndroidSchedulers.mainThread());
        if (r4 == null) goto L13;
        Disposable r6 = r4.subscribe(new b(this, r5));
        if (r6 == null) goto L13;
        Intrinsics.checkNotNullParameter(r6, "$this$autoDispose");
        this.i.a(r6);
    L13:
        InteractGameContext r7 = r0.getContext();
        if (r7 == null) goto L25;
        com.bytedance.live.datacontext.n<h0.b> r8 = r7.getOpenGameLaunchProgress();
        if (r8 == null) goto L26;
        Observable r9 = r8.a();
        if (r9 == null) goto L27;
        Observable r11 = r9.observeOn(AndroidSchedulers.mainThread());
        if (r11 == null) goto L28;
        Disposable r12 = r11.subscribe(new c(this, r5));
        if (r12 == null) goto L29;
        Intrinsics.checkNotNullParameter(r12, "$this$autoDispose");
        this.i.a(r12);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    }

    public final void d(com.bytedance.android.live.broadcastgame.opengame.s.b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "authCallback");
        e(InteractivePlayStartIntroLynxDialog$show$1.INSTANCE, r2);
    }

    public final void e(Function0 r14, com.bytedance.android.live.broadcastgame.opengame.s.b.a r15) {
        this.d = r15;
        OpenPlatformMonitorUtils r0 = OpenPlatformMonitorUtils.c;
        com.bytedance.android.live.broadcastgame.api.model.u r3 = this.g;
        HybridDialog r6 = null;
        com.bytedance.android.live.broadcastgame.api.openplatform.e r4 = new com.bytedance.android.live.broadcastgame.api.openplatform.e(com.bytedance.android.live.core.utils.z.o(this.f), null, 14);
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r4, "launchParam");
        OpenPlatformMonitorUtils.b(r0, "ttlive_open_platform_intro_show", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r3, r4, 112).c();
        String r1 = (String) rd0.a.getValue();
        if (TextUtils.isEmpty(r1) == false) goto L184;
        r14.invoke();
        if (r15 == null) goto L190;
        r15.onError("uri is empty");
        return;
    L190:
        return;
    L184:
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);     // Catch: Exception -> L174
        String r5 = "";
        if (r2 == null) goto L19;
        com.bytedance.live.datacontext.m r7 = r2.getRoom();     // Catch: Exception -> L174
        if (r7 == null) goto L19;
        Room r8 = (Room) r7.getValue();     // Catch: Exception -> L174
        if (r8 == null) goto L19;
        User r9 = r8.getOwner();     // Catch: Exception -> L174
        if (r9 == null) goto L19;
        String r11 = r9.getCastSecUid();     // Catch: Exception -> L174
        if (r11 == null) goto L19;
    L20:
        u6 r12 = new u6(r1);     // Catch: Exception -> L174
        u6 r13 = r12.d(LiveSlardarConstants.EXTRA_KEY_URL);     // Catch: Exception -> L174
        r13.b("name", this.g.name);     // Catch: Exception -> L174
        com.bytedance.android.live.broadcastgame.api.model.r r16 = this.g.c();     // Catch: Exception -> L174
        if (r16 == null) goto L24;
        String r17 = r16.i();     // Catch: Exception -> L174
        if (r17 == null) goto L24;
    L25:
        r13.b("desc", r17);     // Catch: Exception -> L174
        r13.b("icon", GsonHelper.get().toJson(this.g.iconUrl));     // Catch: Exception -> L174
        com.bytedance.android.live.broadcastgame.api.model.r r18 = this.g.c();     // Catch: Exception -> L174
        if (r18 == null) goto L29;
        String r19 = r18.c();     // Catch: Exception -> L174
        if (r19 == null) goto L29;
    L30:
        r13.b("app_version", r19);     // Catch: Exception -> L174
        com.bytedance.android.live.broadcastgame.api.model.r r21 = this.g.c();     // Catch: Exception -> L174
        if (r21 == null) goto L34;
        String r22 = r21.b();     // Catch: Exception -> L174
        if (r22 == null) goto L34;
    L35:
        r13.b(OpenPlatformBaseDebugger.APP_ID, r22);     // Catch: Exception -> L174
        com.bytedance.android.live.broadcastgame.api.model.r r23 = this.g.c();     // Catch: Exception -> L174
        if (r23 == null) goto L38;
        Long r24 = Long.valueOf(r23.p());     // Catch: Exception -> L174
    L39:
        r13.b("game_id", String.valueOf(r24));     // Catch: Exception -> L174
        com.bytedance.android.live.broadcastgame.api.model.r r25 = this.g.c();     // Catch: Exception -> L174
        if (r25 == null) goto L43;
        String r26 = r25.K();     // Catch: Exception -> L174
        if (r26 == null) goto L43;
    L44:
        r13.b("text_intro", r26);     // Catch: Exception -> L174
        Gson r27 = GsonHelper.get();     // Catch: Exception -> L174
        com.bytedance.android.live.broadcastgame.api.model.r r28 = this.g.c();     // Catch: Exception -> L174
        if (r28 == null) goto L47;
        List<com.bytedance.android.live.broadcastgame.api.model.b0> r29 = r28.w();     // Catch: Exception -> L174
    L48:
        String r31 = r27.toJson(r29);     // Catch: Exception -> L174
        if (r31 != null) goto L51;
        r31 = "";
    L51:
        r13.b("media_intro", r31);     // Catch: Exception -> L174
        com.bytedance.android.live.broadcastgame.api.model.r r32 = this.g.c();     // Catch: Exception -> L174
        if (r32 == null) goto L55;
        String r33 = r32.j();     // Catch: Exception -> L174
        if (r33 == null) goto L55;
    L56:
        r13.b("developer", r33);     // Catch: Exception -> L174
        com.bytedance.android.live.broadcastgame.api.model.r r34 = this.g.c();     // Catch: Exception -> L174
        if (r34 == null) goto L60;
        String r35 = r34.a();     // Catch: Exception -> L174
        if (r35 == null) goto L60;
    L61:
        r13.b("anchor_ratio_v2", r35);     // Catch: Exception -> L174
        com.bytedance.android.live.broadcastgame.api.model.r r36 = this.g.c();     // Catch: Exception -> L174
        if (r36 == null) goto L64;
        Integer r37 = Integer.valueOf(r36.g());     // Catch: Exception -> L174
    L65:
        r13.b("business_type", String.valueOf(r37));     // Catch: Exception -> L174
        com.bytedance.android.live.broadcastgame.api.model.r r38 = this.g.c();     // Catch: Exception -> L174
        String r39 = "0";
        String r41 = GamePromoteDataContext.GAME_TYPE_MINI;
        if (r38 == null) goto L74;
        com.bytedance.android.live.broadcastgame.api.model.d r42 = r38.h();     // Catch: Exception -> L174
        if (r42 == null) goto L74;
        if (r42.a() == false) goto L73;
        String r43 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L75:
        r13.b("screencast_config", r43);     // Catch: Exception -> L174
        com.bytedance.android.live.broadcastgame.api.model.r r44 = this.g.c();     // Catch: Exception -> L174
        if (r44 == null) goto L83;
        p0 r45 = r44.F();     // Catch: Exception -> L174
        if (r45 == null) goto L83;
        if (r45.a() == false) goto L82;
        String r46 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L84:
        r13.b("single_screencast_config", r46);     // Catch: Exception -> L174
        Gson r47 = GsonHelper.get();     // Catch: Exception -> L174
        com.bytedance.android.live.broadcastgame.api.model.r r110 = this.g.c();     // Catch: Exception -> L174
        if (r110 == null) goto L87;
        List<String> r111 = r110.D();     // Catch: Exception -> L174
    L88:
        String r48 = r47.toJson(r111);     // Catch: Exception -> L174
        if (r48 != null) goto L91;
        r48 = "";
    L91:
        r13.b("sensitivity_tip", r48);     // Catch: Exception -> L174
        com.bytedance.android.live.broadcastgame.api.model.r r49 = this.g.c();     // Catch: Exception -> L174
        if (r49 == null) goto L95;
        String r51 = r49.m();     // Catch: Exception -> L174
    L96:
        boolean r112 = false;
        if (r51 != null) goto L182;
    L113:
        r13.b("game_card_extra", r39);     // Catch: Exception -> L174
        r13.b("scene", String.valueOf(com.bytedance.android.live.broadcastgame.api.interactgame.j.a()));     // Catch: Exception -> L174
        r13.b("social_scene", String.valueOf(jc1.k.n(IInteractService.class).getCurrentScene()));     // Catch: Exception -> L174
        com.bytedance.android.live.broadcastgame.api.model.r r52 = this.g.c();     // Catch: Exception -> L174
        if (r52 == null) goto L119;
        com.bytedance.android.live.broadcastgame.api.model.g r53 = r52.n();     // Catch: Exception -> L174
        if (r53 == null) goto L119;
        String r54 = r53.a();     // Catch: Exception -> L174
        if (r54 == null) goto L119;
    L120:
        r13.b("unity_version", r54);     // Catch: Exception -> L174
        int r55 = jc1.k.n(IInteractService.class).getCurrentScene();     // Catch: Exception -> L174
        if (r55 != 8) goto L123;
        r41 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L126:
        r13.b("big_party_scene", r41);     // Catch: Exception -> L174
        List r56 = (List) ((HashMap) com.bytedance.android.livesdk.sharedpref.b.x2.getValue()).get(r11);     // Catch: Exception -> L174
        if (r56 == null) goto L145;
        Iterator r57 = r56.iterator();     // Catch: Exception -> L174
    L130:
        if (r57.hasNext() == false) goto L138;
        Object r58 = r57.next();     // Catch: Exception -> L174
        String r59 = ((nc1) r58).a();     // Catch: Exception -> L174
        com.bytedance.android.live.broadcastgame.api.model.r r61 = this.g.c();     // Catch: Exception -> L174
        if (r61 == null) goto L134;
        String r62 = r61.b();     // Catch: Exception -> L174
    L136:
        if (Intrinsics.areEqual(r59, r62) == false) goto L130;
    L139:
        nc1 r63 = (nc1) r58;     // Catch: Exception -> L174
        if (r63 == null) goto L145;
        String r64 = r63.b();     // Catch: Exception -> L174
        if (r64 == null) goto L145;
        r5 = r64;
        goto L145
    L134:
        r62 = null;
        goto L136
    L138:
        r58 = null;
    L145:
        r13.b("cache_app_version", r5);     // Catch: Exception -> L174
        r13.b("is_xplay", m2.b(q1.g(this.g.c())));     // Catch: Exception -> L174
        com.bytedance.android.live.broadcastgame.api.model.r r65 = this.g.c();     // Catch: Exception -> L174
        if (r65 == null) goto L148;
        String r66 = r65.b();     // Catch: Exception -> L174
    L149:
        if (r66 != null) goto L151;
    L153:
        r13.b("is_game_running", m2.b(r112));     // Catch: Exception -> L174
        if (r15 == null) goto L156;
        r13.b("is_record_tool_auth", GamePromoteDataContext.GAME_TYPE_MOBILE);     // Catch: Exception -> L174
    L156:
        String r67 = a();     // Catch: Exception -> L174
        AnchorGameContext.Companion.getClass();     // Catch: Exception -> L174
        AnchorGameContext r68 = AnchorGameContext.a.a();     // Catch: Exception -> L174
        if (r68 == null) goto L169;
        com.bytedance.live.datacontext.n<String> r69 = r68.getLynxDetailExtra();     // Catch: Exception -> L174
        if (r69 == null) goto L169;
        String r71 = (String) r69.getValue();     // Catch: Exception -> L174
        if (r71 == null) goto L169;
        JSONObject r72 = new JSONObject(r71);     // Catch: Exception -> L174
        Iterator<String> r73 = r72.keys();     // Catch: Exception -> L174
    L164:
        if (r73.hasNext() == false) goto L167;
        String r74 = r73.next();     // Catch: Exception -> L174
        r13.b(r74, r72.optString(r74));     // Catch: Exception -> L174
        goto L164
    L167:
        if (Intrinsics.areEqual(r72.optString("select_tab"), GamePromoteDataContext.GAME_TYPE_MOBILE) == false) goto L169;
        r67 = "smallrocker_live_guide";
    L169:
        r13.b("source", r67);     // Catch: Exception -> L174
        String r75 = r13.a("fallback_url");     // Catch: Exception -> L174
        HybridDialog r113 = ((IBrowserService) jc1.k.n(IBrowserService.class)).showHybridDialogWithListener(this.e, r12.c(), new k(r75, r14, r15), new l(this, r15));     // Catch: Exception -> L174
        if (r113 == null) goto L172;
        b(r113);     // Catch: Exception -> L174
        Unit r76 = Unit.INSTANCE;     // Catch: Exception -> L174
        r6 = r113;
    L172:
        this.b = r6;     // Catch: Exception -> L174
        return;
    L151:
        if (InteractGameContext.Companion.h(r66) == false) goto L153;
        r112 = true;
        goto L153
    L148:
        r66 = null;
        goto L149
    L123:
        if (r55 == 12) goto L126;
        r41 = "";
    L119:
        r54 = "";
        goto L120
    L182:
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L112
        int r77 = JSONObjectProtectorUtils.getInt(LiveSeiUtil.c(r51), "default_status");     // Catch: Exception -> L112
        if (r77 != 1) goto L101;
        r39 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L102:
        if (r77 != 1) goto L104;
        boolean r78 = true;
    L180:
        AnchorGameContext.Companion.getClass();     // Catch: Exception -> L179
        AnchorGameContext r114 = AnchorGameContext.a.a();     // Catch: Exception -> L179
        if (r114 == null) goto L110;
        com.bytedance.live.datacontext.m<Boolean> r115 = r114.getOpenGameIntroCardAutoShow();     // Catch: Exception -> L179
        if (r115 == null) goto L110;
        r115.setValue(Boolean.valueOf(r78));     // Catch: Exception -> L179
    L110:
        Unit r79 = Unit.INSTANCE;     // Catch: Exception -> L179
        goto L113
    L104:
        r78 = false;
        goto L180
    L101:
        r39 = GamePromoteDataContext.GAME_TYPE_MINI;
    L112:
        r39 = "";
        goto L113
    L95:
        r51 = null;
        goto L96
    L87:
        r111 = null;
        goto L88
    L82:
        r46 = GamePromoteDataContext.GAME_TYPE_MINI;
    L83:
        r46 = "0";
        goto L84
    L73:
        r43 = GamePromoteDataContext.GAME_TYPE_MINI;
    L74:
        r43 = "0";
        goto L75
    L64:
        r37 = null;
    L60:
        r35 = "";
    L55:
        r33 = "";
        goto L56
    L47:
        r29 = null;
    L43:
        r26 = "";
        goto L44
    L38:
        r24 = null;
    L34:
        r22 = "";
    L29:
        r19 = "";
    L24:
        r17 = "";
    L19:
        r11 = "";
    L174:
        e = move-exception;
        com.bytedance.android.livesdk.log.b0 r81 = com.bytedance.android.livesdk.log.b0.o();
        String r82 = "interactive play lynx start failed, msg:" + e.getMessage() + ", stackTrace: " + e.getStackTrace() + ", cause: " + e.getCause();
        r81.getClass();
        com.bytedance.android.live.core.log.g.c("InteractivePlayStartIntroLynxDialog", r82);
        if (r15 == null) goto L191;
        r15.onError(String.valueOf(e));
        return;
    }

    public static void c(HybridDialog r3, int r4, String r5) {
        JSONObject r0 = new JSONObject();
        r0.put("eventName", "InteractivePlayLaunchProgress");
        r0.put("launch_status", r4);
        if (r5 == null) goto L5;
        r0.put(LiveSlardarConstants.EXTRA_KEY_ERROR_MSG, r5);
    L5:
        r3.sendJsEvent("H5_webcastNotification", r0);
    }

    public i(Context r2, DataCenter r3, com.bytedance.android.live.broadcastgame.api.model.u r4, com.bytedance.android.live.broadcastgame.api.openplatform.b r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "gameItem");
        Intrinsics.checkNotNullParameter(r5, "gameManager");
        this.i = new i20.a();
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        CompositeDisposable r6 = new CompositeDisposable();
        this.a = r6;
        r6.add(xs2.b.a().b(a3.class).subscribe(new j(this)));
    }
}
