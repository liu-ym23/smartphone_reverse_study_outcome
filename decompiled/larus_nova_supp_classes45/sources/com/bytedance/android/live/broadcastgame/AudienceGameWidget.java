package com.bytedance.android.live.broadcastgame;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.api.AudienceGameContext;
import com.bytedance.android.live.broadcastgame.api.IAudienceGameWidget;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayGuestType;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.widget.GameHonorEffectWidget;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.android.livesdk.config.lb0;
import com.bytedance.android.livesdk.config.mv0;
import com.bytedance.android.livesdk.config.w20;
import com.bytedance.android.livesdk.message.model.eg;
import com.bytedance.android.livesdk.message.model.fg;
import com.bytedance.android.livesdk.message.model.sc;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveUgcPlatformHostInvitationConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/AudienceGameWidget;", "Lcom/bytedance/android/live/broadcastgame/api/IAudienceGameWidget;", "", "Lvlc/l;", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceGameWidget extends IAudienceGameWidget implements vlc.l {
    public com.bytedance.android.live.broadcastgame.api.openplatform.b a;
    public f0 b;
    public vlc.d c;
    public final b d;
    public k0 e;
    public boolean f;
    public boolean g;
    public String h;
    public final boolean i;

    public static final class a {
    }

    public static final class b extends IHostAppMonitorListener.Stub {
        public boolean a;

        public b() {
        }

        public final void appEnterBackground(boolean r1, boolean r2) {
            this.a = r1;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ AudienceGameWidget a;

        public c(AudienceGameWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            KVData r4 = (KVData) r3;
            if (r4 == null) goto L5;
            String r0 = r4.getKey();
        L7:
            if (Intrinsics.areEqual(r0, "data_linkmic_game_switch") == false) goto L10;
            ALogger.i("AAM.AudienceGameWidget", "observe DATA_LINKMIC_GAME_STATE_CHANGE " + ((Boolean) r4.getData()));
            AudienceGameWidget r5 = this.a;
            r5.f = false;
            r5.g = false;
            return;
        L10:
            return;
        L5:
            r0 = null;
            goto L7
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565166;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r1) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        com.bytedance.android.live.broadcastgame.api.openplatform.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.onDestroy();
    L5:
        vlc.d r1 = this.c;
        if (r1 == null) goto L8;
        r1.removeMessageListener(this);
    L8:
        k0 r2 = this.e;
        if (r2 == null) goto L11;
        r2.onDestroy();
    L11:
        this.e = null;
        this.a = null;
    }

    public AudienceGameWidget(boolean r2) {
        this.i = r2;
        b r3 = new b();
        this.d = r3;
        InteractGameService.Companion.getClass();
        i10.f r0 = (i10.f) InteractGameService.access$getDiComponent$cp();
        r0.getClass();
        this.b = (f0) r0.a.d.get();
        IHostApp r1 = jc1.k.f(IHostApp.class);
        if (r1 == null) goto L6;
        r1.registerLiveLifeCycleListener(r3);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r3) {
        enableSubWidgetManager();
        if (this.i == true) goto L5;
        ((Widget) this).subWidgetManager.load(2131381526, new GameHonorEffectWidget());
    L5:
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L8;
        r4.put("data_audience_interact_game", null);
    L8:
        AudienceGameContext.Companion.getClass();
        AudienceGameContext r5 = AudienceGameContext.a.a();
        if (r5 == null) goto L13;
        com.bytedance.live.datacontext.n<com.bytedance.android.live.broadcastgame.api.model.r> r6 = r5.getCurrentGame();
        if (r6 == null) goto L13;
        r6.setValue(null);
    L13:
        vlc.d r7 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager");
        this.c = r7;
        if (r7 == null) goto L16;
        r7.addMessageListener(MessageType.MINI_APP_COMMON_MESSAGE.getIntType(), this);
    L16:
        vlc.d r8 = this.c;
        if (r8 == null) goto L20;
        r8.addMessageListener(MessageType.INTERACT_OPEN_PLATFORM_CONTROL_MESSAGE.getIntType(), this);
    L20:
        if (((Boolean) w20.a.getValue()).booleanValue() == false) goto L22;
        k0 r9 = new com.bytedance.android.live.broadcastgame.a(((Widget) this).context, ((Widget) this).dataCenter);
    L23:
        this.e = r9;
        r9.a(new AnonymousClass1(this));
        ((Widget) this).dataCenter.observe("data_linkmic_game_switch", new c(this));
        return;
    L22:
        r9 = new AudienceMagicBoxBehavior(((Widget) this).context, ((Widget) this).dataCenter);
        goto L23
    }

    public final void onMessage(tlc.d r11) {
        if ((r11 instanceof eg) == false) goto L57;
        ALogger.i("AAM.AudienceGameWidget", "received MiniAppCommonMessage, " + r11);
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L9;
        com.bytedance.android.live.liveinteract.utils.n r1 = r0.getLinkMicGameTraceUtils();
        if (r1 == null) goto L9;
        com.bytedance.android.live.liveinteract.utils.n.a.a(r1, false, "onReceivedMiniAppCommonMessage", "message: " + r11 + ", ", 4);
    L9:
        eg r2 = (eg) r11;
        if (r2.getScene() == 1) goto L17;
        ALogger.i("AAM.AudienceGameWidget", "received MiniAppCommonMessage return, cause: scene is not multiPlayer");
        IInteractService r12 = jc1.k.f(IInteractService.class);
        if (r12 == null) goto L80;
        com.bytedance.android.live.liveinteract.utils.n r13 = r12.getLinkMicGameTraceUtils();
        if (r13 == null) goto L81;
        com.bytedance.android.live.liveinteract.utils.n.a.a(r13, false, "onReceivedMiniAppCommonMessageReturn", "scene is not multiPlayer", 4);
        return;
    L81:
        return;
    L80:
        return;
    L17:
        int r5 = r2.getStatus();
        if (r5 == 1) goto L48;
        if (r5 == 2) goto L42;
        if (r5 == 3) goto L32;
        if (r5 != 4) goto L57;
        this.f = false;
        if (this.g == false) goto L57;
        com.bytedance.android.live.broadcastgame.api.xplay.n r3 = com.bytedance.android.live.broadcastgame.api.xplay.n.b;
        if (r3.l() == false) goto L57;
        if (Intrinsics.areEqual(this.h, r2.G()) == false) goto L57;
        r3.e("MiniAppCommonMessage#STATUS_END_WATCH");
        this.h = null;
        goto L57
    L32:
        this.f = true;
        if (com.bytedance.android.live.broadcastgame.api.xplay.n.b.l() == false) goto L40;
        IInteractService r14 = jc1.k.f(IInteractService.class);
        if (r14 == null) goto L82;
        com.bytedance.android.live.liveinteract.utils.n r15 = r14.getLinkMicGameTraceUtils();
        if (r15 == null) goto L83;
        com.bytedance.android.live.liveinteract.utils.n.a.a(r15, false, "onReceivedMiniAppCommonMessageReturn", "xplay is running", 4);
        return;
    L83:
        return;
    L82:
        return;
    L40:
        wq(r2, true);
        goto L57
    L42:
        if (this.f == false) goto L45;
        wq(r2, true);
        goto L57
    L45:
        if (Intrinsics.areEqual(this.h, r2.G()) == false) goto L57;
        com.bytedance.android.live.broadcastgame.api.xplay.n.b.e("MiniAppCommonMessage#STATUS_END_PLAY");
        this.h = null;
        goto L57
    L48:
        if (this.d.a == false) goto L55;
        ALogger.i("AAM.AudienceGameWidget", "received MiniAppCommonMessage return, cause: isAppBackground true");
        IInteractService r16 = jc1.k.f(IInteractService.class);
        if (r16 == null) goto L84;
        com.bytedance.android.live.liveinteract.utils.n r17 = r16.getLinkMicGameTraceUtils();
        if (r17 == null) goto L85;
        com.bytedance.android.live.liveinteract.utils.n.a.a(r17, false, "onReceivedMiniAppCommonMessageReturn", "isAppBackground true", 4);
        return;
    L85:
        return;
    L84:
        return;
    L55:
        wq(r2, false);
    L57:
        if ((r11 instanceof sc) == false) goto L70;
        List r18 = ((sc) r11).audienceOperationList;
        if (r18 == null) goto L86;
        Iterator r19 = r18.iterator();
    L62:
        if (r19.hasNext() == false) goto L87;
        com.bytedance.android.livesdk.wrds.interact.a.a r4 = (com.bytedance.android.livesdk.wrds.interact.a.a) r19.next();
        final com.bytedance.android.livesdk.wrds.interact.a.b r6 = r4.popBoxContent;
        Integer r7 = r4.a();
        if (r7 == null) goto L62;
        if (r7.intValue() != 1) goto L62;
        if (r6 == null) goto L62;
        UtilityKotlinExtentionsKt.s(0, false, false, new AudienceGameWidget$onMessage$$inlined$forEach$lambda$1(r6, this), 7);
        goto L62
    L87:
        return;
    L86:
        return;
    }

    public final void wq(eg r43, boolean r44) {
        fg r2 = r43.E();
        if (r2 == null) goto L5;
        com.bytedance.android.live.broadcastgame.api.model.u r14 = new com.bytedance.android.live.broadcastgame.api.model.u(r2.interactId, r2.name, r2.iconUrl, r2.rank, r2.groupType, r2.supportiveEntrance, r2.extra);
    L6:
        mv0 r3 = mv0.a;
        if (((LiveUgcPlatformHostInvitationConfig) r3.getValue()).getEnabled() == false) goto L11;
        if (((LiveUgcPlatformHostInvitationConfig) r3.getValue()).getOptimized() == false) goto L11;
    L22:
        com.bytedance.android.live.broadcastgame.api.xplay.n r4 = com.bytedance.android.live.broadcastgame.api.xplay.n.b;
        if (r4.l() == true) goto L25;
    L37:
        IInteractService r5 = jc1.k.f(IInteractService.class);
        if (r5 == null) goto L42;
        com.bytedance.android.live.liveinteract.utils.n r6 = r5.getLinkMicGameTraceUtils();
        if (r6 == null) goto L42;
        com.bytedance.android.live.liveinteract.utils.n.a.a(r6, false, "startXplay", "isWatchMode = " + r44, 4);
    L42:
        IInteractService r7 = jc1.k.f(IInteractService.class);
        if (r7 == null) goto L63;
        com.bytedance.android.live.liveinteract.utils.l r15 = r7.getLinkMicGameFullLinkMonitor();
        if (r15 == null) goto L63;
        LinkMonitorData r16 = LinkMonitorData.InviteDanmuGameMessageReceived;
        if (r14 == null) goto L54;
        com.bytedance.android.live.broadcastgame.api.model.r r8 = r14.c();
        if (r8 == null) goto L54;
        String r9 = r8.b();
        if (r9 == null) goto L54;
        String r17 = r9;
    L55:
        if (r14 == null) goto L57;
        String r18 = r14.name;
    L59:
        if (r44 == false) goto L61;
        XplayGuestType r11 = XplayGuestType.SILENCE;
    L62:
        com.bytedance.android.live.liveinteract.utils.l.a.a(r15, r16, r17, r18, 0, null, null, "first", Integer.valueOf(r11.getGuestType()), null, 312);
        goto L63
    L61:
        r11 = XplayGuestType.DEFAULT;
        goto L62
    L57:
        r18 = null;
    L54:
        r17 = "";
    L63:
        if (r14 == null) goto L77;
        Context r12 = ((Widget) this).context;
        long r28 = com.bytedance.android.live.core.utils.z.o(((Widget) this).dataCenter).getRoomId();
        String r31 = com.bytedance.android.live.core.utils.z.o(((Widget) this).dataCenter).getAnchorId();
        boolean r32 = com.bytedance.android.live.core.utils.z.e(((Widget) this).dataCenter, false);
        String r33 = jc1.k.n(IUserService.class).user().n();
        XplayScene r34 = XplayScene.TalkRoom;
        String r13 = r43.getOpenId();
        if (r13 != null) goto L67;
        String r35 = "";
    L68:
        com.bytedance.android.live.broadcastgame.api.xplay.l r36 = com.bytedance.android.live.broadcastgame.api.xplay.m.a(r14);
        DataCenter r19 = ((Widget) this).dataCenter;
        com.bytedance.android.live.broadcastgame.api.xplay.s r21 = new com.bytedance.android.live.broadcastgame.api.xplay.s(false, false, null, 2047);
        r21.b = true;
        if (r44 == false) goto L71;
        XplayGuestType r22 = XplayGuestType.SILENCE;
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r21.i = r22;
        r21.j = true;
        LinkedHashMap r23 = new LinkedHashMap();
        r23.put("cloud_game_pattern", GamePromoteDataContext.GAME_TYPE_MOBILE);
        r23.put("guest_type", GamePromoteDataContext.GAME_TYPE_MOBILE);
        Unit r24 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r23, "<set-?>");
        r21.c = r23;
    L71:
        Unit r25 = Unit.INSTANCE;
        r4.j(new com.bytedance.android.live.broadcastgame.api.xplay.p(r12, r28, r31, r32, r33, r34, r35, r36, r19, r21, null, !r44, false, 5120));
        this.g = r44;
        this.h = r43.G();
        return;
    L67:
        r35 = r13;
        goto L68
    L77:
        return;
    L25:
        if (this.g == true) goto L37;
        if (r44 == true) goto L37;
        if (Intrinsics.areEqual(r43.G(), this.h) == false) goto L37;
        if (((Boolean) lb0.a.getValue()).booleanValue() == false) goto L37;
        IInteractService r1 = jc1.k.f(IInteractService.class);
        if (r1 == null) goto L75;
        com.bytedance.android.live.liveinteract.utils.n r26 = r1.getLinkMicGameTraceUtils();
        if (r26 == null) goto L76;
        com.bytedance.android.live.liveinteract.utils.n.a.a(r26, false, "onReceivedMiniAppCommonMessageReturn", "interceptDuplicatedMessage", 4);
        return;
    L76:
        return;
    L75:
        return;
    L11:
        if (Intrinsics.areEqual(r43.getExtra(), "anchor_init_success") == true) goto L15;
        if (Intrinsics.areEqual(r43.getExtra(), "guest_linkmic_success") == false) goto L22;
    L15:
        if (r43.getStatus() != 1) goto L22;
        IInteractService r27 = jc1.k.f(IInteractService.class);
        if (r27 == null) goto L73;
        com.bytedance.android.live.liveinteract.utils.n r29 = r27.getLinkMicGameTraceUtils();
        if (r29 == null) goto L74;
        com.bytedance.android.live.liveinteract.utils.n.a.a(r29, false, "onReceivedMiniAppCommonMessageReturn", "live_ugc_platform_host_invitation_enabled false", 4);
        return;
    L74:
        return;
    L73:
        return;
    L5:
        r14 = null;
        goto L6
    }
}
