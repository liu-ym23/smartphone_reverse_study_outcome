package com.bytedance.android.livesdk.gamecp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.IGameCPPreviewService;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.live.room.api.panel.PanelName;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveAd;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveAdLandingPageDialogFragment;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.o0;
import com.bytedance.android.livesdk.chatroom.paidlive.PaidLiveUtils;
import com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.depend.model.gamecp.AnchorFloatBallDownloadData;
import com.bytedance.android.livesdkapi.depend.model.gamecp.AnchorFloatBallGamePromoteNoticeData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PaidLiveData;
import com.bytedance.android.livesdkapi.depend.model.live.pay.main.IMainPaidLiveData;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.service.ILiveUxTracer;
import com.bytedance.android.livesdkapi.service.gamecp.IGamecpDependService;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p implements bw.i {
    public com.bytedance.android.livesdk.gamecp.impl.i a;
    public com.bytedance.android.livesdk.gamecp.impl.n b;
    public com.bytedance.android.livesdk.gamecp.impl.p c;
    public com.bytedance.android.livesdk.gamecp.impl.o d;
    public com.bytedance.android.livesdk.gamecp.impl.m e;

    public static final class a implements js0.b {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        public final void onSuccess(String r2) {
            Intrinsics.checkNotNullParameter(r2, "track");
            Function1 r3 = this.a;
            if (r3 == null) goto L6;
            Unit r4 = (Unit) r3.invoke(Boolean.TRUE);
            return;
        }
    }

    public static final class b implements js0.a {
        public final /* synthetic */ Function1 a;

        public b(Function1 r1) {
            this.a = r1;
        }

        public final void onFail(String r2) {
            Intrinsics.checkNotNullParameter(r2, "track");
            Function1 r3 = this.a;
            if (r3 == null) goto L6;
            Unit r4 = (Unit) r3.invoke(Boolean.FALSE);
            return;
        }
    }

    public p() {
    }

    public final void B() {
    }

    public final void O(String r2) {
        Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
    }

    public final void Q() {
    }

    public final void getGamePromoteSceneSub() {
    }

    public final void getGameTraceMonitor() {
    }

    public final boolean isPreviewMergeInteract() {
        return false;
    }

    public final void l0() {
    }

    public final void onRoomExit(long r1) {
    }

    public final void p2(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "uniqueKey");
        Intrinsics.checkNotNullParameter(r3, LiveEndPageData.TAG_NAME);
    }

    public final void showInteractionAndEnterRoom(String r2) {
        Intrinsics.checkNotNullParameter(r2, "roomId");
    }

    public final void w0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "playId");
    }

    public final void D() {
        int r0 = bw.v.a;
        HorizontalPlayEvent r1 = new HorizontalPlayEvent(1);
        r1.rotationType = 0;
        xs2.b.a().post(r1);
    }

    public final void M1() {
        o0 r0 = new o0();
        r0.b = 1;
        r0.a = true;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L8;
        com.bytedance.live.datacontext.m r2 = r1.getInFold();
        if (r2 == null) goto L9;
        r2.setValue(r0);
        return;
    L9:
        return;
    }

    public final dw.f e1() {
        if (this.a != null) goto L5;
        this.a = new com.bytedance.android.livesdk.gamecp.impl.i();
    L5:
        com.bytedance.android.livesdk.gamecp.impl.i r0 = this.a;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public final int getCurrentScene() {
        return jc1.k.n(IInteractService.class).getCurrentScene();
    }

    public final String getEventLiveType() {
        IGameCPPreviewService r0 = jc1.k.n(IBroadcastService.class).getGameCPPreviewService();
        if (r0 == null) goto L5;
        LiveMode r1 = r0.getPreviewLiveMode();
    L6:
        int r2 = h1.a;
        return i1.a(r1);
    L5:
        r1 = null;
        goto L6
    }

    public final String getIfClearModeValueWithClick() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m r1 = r0.getCleanMode();
        if (r1 == null) goto L9;
        if (((Number) r1.getValue()).intValue() != 2) goto L9;
        return "2";
    L9:
        return "0";
    }

    public final String getIfClearModeValueWithIntroCardShow() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m r1 = r0.getCleanMode();
        if (r1 == null) goto L9;
        if (((Number) r1.getValue()).intValue() != 2) goto L9;
        return "2";
    L9:
        return "0";
    }

    public final dw.g getLiveFloatViewService() {
        if (this.e != null) goto L6;
        this.e = new com.bytedance.android.livesdk.gamecp.impl.m();
    L6:
        return this.e;
    }

    public final dw.j getLiveMiniGamePlayService() {
        if (this.d != null) goto L6;
        this.d = new com.bytedance.android.livesdk.gamecp.impl.o();
    L6:
        return this.d;
    }

    public final dw.k getLiveRoomLandScapeService() {
        if (this.c != null) goto L6;
        this.c = new com.bytedance.android.livesdk.gamecp.impl.p();
    L6:
        return this.c;
    }

    public final String getLiveSdkVersion() {
        return String.valueOf(4210);
    }

    public final Map<String, Object> getLiveSettingMap() {
        v60.a r0 = v60.a.a;
        return v60.a.c();
    }

    public final String getLiveTypeForH5() {
        LiveMode r1 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m r2 = r0.getRoom();
        if (r2 == null) goto L7;
        Room r3 = (Room) r2.getValue();
    L8:
        if (r3 == null) goto L10;
        r1 = r3.getStreamType();
    L10:
        if (r1 == null) goto L23;
        int r4 = o.a[r1.ordinal()];
        if (r4 == 1) goto L23;
        if (r4 == 2) goto L22;
        if (r4 != 3) goto L18;
        return "screen_record";
    L18:
        if (r4 != 4) goto L23;
        return "third_party";
    L22:
        return DataType.AUDIO;
    L23:
        return DataType.VIDEO;
    L7:
        r3 = null;
        goto L8
    }

    public final String getPreviewEventLiveType() {
        IGameCPPreviewService r0 = jc1.k.n(IBroadcastService.class).getGameCPPreviewService();
        if (r0 == null) goto L5;
        LiveMode r1 = r0.getPreviewLiveMode();
    L6:
        int r2 = h1.a;
        return i1.a(r1);
    L5:
        r1 = null;
        goto L6
    }

    public final com.bytedance.android.gamecp.host_api.model.Room getRoomData() {
        RoomContext.Companion.getClass();
        Room r0 = null;
        if (RoomContext.a.a(null, 0) == null) goto L10;
        RoomContext r1 = RoomContext.a.a(null, 0);
        if (r1 == null) goto L10;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L10;
        r0 = (Room) r2.getValue();
    L10:
        return com.bytedance.android.livesdk.gamecp.utils.b.b(r0);
    }

    public final long getTimeStamp() {
        Intrinsics.checkNotNullParameter("enter_room", "scene");
        Intrinsics.checkNotNullParameter("start", "milestone");
        ILiveUxTracer r0 = jc1.k.f(ILiveUxTracer.class);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getTimeStamp("enter_room", "start");
    }

    public final boolean hasFullWatchRight() {
        Room r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L7;
        r4 = (Room) r1.getValue();
    L7:
        Lazy r2 = PaidLiveUtils.a;
        if (r4 != null) goto L11;
        return true;
    L11:
        if (r4.isPaidLive() == false) goto L24;
        PaidLiveData r3 = r4.getPaidLiveData();
        if (r3 != null) goto L15;
    L16:
        if (r3 == null) goto L22;
        IMainPaidLiveData r5 = r3.castToOrNull(IMainPaidLiveData.class);
        if (r5 == null) goto L22;
        if (r5.getDelivery() != 1) goto L22;
        return true;
    L22:
        return false;
    L15:
        if (r3.viewRight == 0) goto L22;
    L24:
        return true;
    }

    public final boolean isAnchor() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.i r1 = r0.isAnchor();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        return r2.booleanValue();
    L9:
        return false;
    }

    public final boolean isEqualOnVoice() {
        Room r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L8;
        r4 = (Room) r1.getValue();
    L8:
        return com.bytedance.android.livesdk.chatroom.interact.model.d0.h(r4);
    }

    public final dw.i z2() {
        if (this.b != null) goto L6;
        this.b = new com.bytedance.android.livesdk.gamecp.impl.n();
    L6:
        return this.b;
    }

    public final boolean e() {
        if (TTLiveServiceMiddleware.getLiveService() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isLivePlayerClientMute() {
        ILivePlayerClient r0 = LivePlatformPlayerManager.f();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isMute();
    }

    public final void muteLivePlayerClient() {
        ILivePlayerClient r0 = LivePlatformPlayerManager.f();
        if (r0 == null) goto L6;
        r0.mute();
        return;
    }

    public final void pauseLive() {
        xs2.b.a().post(new zg1.h1(30));
    }

    public final void unMuteLivePlayerClient() {
        ILivePlayerClient r0 = LivePlatformPlayerManager.f();
        if (r0 == null) goto L6;
        r0.unmute();
        return;
    }

    public final void gamePrivacyMonitorEnsureRelease() {
        e00.b.a();
    }

    public final long getStartRoomTime() {
        return in1.b.b;
    }

    public final void R0(bw.s r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        xs2.b.a().post(new zg1.h1(31));
    }

    public final com.bytedance.android.gamecp.host_api.model.Room getRoomDataByUniqueKey(String r8) {
        Intrinsics.checkNotNullParameter(r8, "uniqueKey");
        Room r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L17
        RoomContext.Companion.getClass();     // Catch: Throwable -> L17
        RoomContext r2 = RoomContext.a.b(null, r8);     // Catch: Throwable -> L17
        if (r2 == null) goto L7;
        Room r9 = (Room) r2.getRoom().getValue();     // Catch: Throwable -> L17
    L6:
        r0 = r9;
    L15:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L20:
        return com.bytedance.android.livesdk.gamecp.utils.b.b(r0);
    L7:
        int r3 = StringsKt.indexOf$default(r8, "_", 0, false, 6, null);     // Catch: Throwable -> L17
        if (r3 <= 0) goto L15;
        RoomContext r10 = RoomContext.a.a(null, CastLongProtector.parseLong(r8.substring(0, r3)));     // Catch: Throwable -> L17
        if (r10 == null) goto L12;
        com.bytedance.live.datacontext.m r11 = r10.getRoom();     // Catch: Throwable -> L17
    L13:
        if (r11 == null) goto L15;
        r9 = (Room) r11.getValue();     // Catch: Throwable -> L17
        goto L6
    L12:
        r11 = null;
    L17:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }

    public final boolean hideToolbar(boolean r2) {
        if (r2 == false) goto L4;
    L7:
        y3.l().i(ToolbarButton.GAME_PROMOTE_AUDIENCE.extended());
        return true;
    L4:
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L7;
        return false;
    }

    public final boolean isNewLandscape(String r5) {
        Intrinsics.checkNotNullParameter(r5, "roomId");
        Room r3 = null;
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, CastLongProtector.parseLong(r5), 1);
        if (r6 == null) goto L8;
        com.bytedance.live.datacontext.m r7 = r6.getRoom();
        if (r7 == null) goto L8;
        r3 = (Room) r7.getValue();
    L8:
        return com.bytedance.android.livesdk.utils.landscape.d.b(r3);
    }

    public final void setLiveLogData(HashMap<String, String> r12) {
        Intrinsics.checkNotNullParameter(r12, "map");
        com.bytedance.android.livesdk.log.filter.o r0 = com.bytedance.android.livesdk.log.u.l().c(am2.f.class);
        String r1 = r12.get("enter_from");
        boolean r2 = false;
        String r3 = null;
        String r5 = "";
        if (r1 != null) goto L5;
    L13:
        r1 = "";
    L14:
        String r6 = r12.get("promote_game_id");
        if (r6 != null) goto L17;
    L25:
        r6 = "";
    L26:
        String r7 = r12.get("promote_game_name");
        if (r7 != null) goto L29;
    L37:
        r7 = "";
    L38:
        String r8 = r12.get("promote_scene");
        if (r8 != null) goto L41;
    L49:
        r8 = "";
    L50:
        String r9 = r12.get("order");
        if (r9 != null) goto L53;
    L61:
        r9 = "";
    L62:
        String r13 = r12.get("label");
        if (r13 != null) goto L65;
    L71:
        if (r0 == null) goto L74;
        am2.f r14 = new am2.f();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r14.a = r1;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r14.b = r6;
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r14.c = r7;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r14.d = r8;
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r14.e = r9;
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r14.f = r5;
        Unit r4 = Unit.INSTANCE;
        r0.setData(r14);
        return;
    L74:
        return;
    L65:
        if (r13.length() <= 0) goto L67;
        r2 = true;
    L67:
        if (r2 == false) goto L69;
        r3 = r13;
    L69:
        if (r3 == null) goto L71;
        r5 = r3;
        goto L71
    L53:
        if (r9.length() <= 0) goto L55;
        boolean r10 = true;
    L56:
        if (r10 == true) goto L59;
        r9 = null;
    L59:
        if (r9 == null) goto L61;
    L55:
        r10 = false;
        goto L56
    L41:
        if (r8.length() <= 0) goto L43;
        boolean r11 = true;
    L44:
        if (r11 == true) goto L47;
        r8 = null;
    L47:
        if (r8 == null) goto L49;
    L43:
        r11 = false;
        goto L44
    L29:
        if (r7.length() <= 0) goto L31;
        boolean r15 = true;
    L32:
        if (r15 == true) goto L35;
        r7 = null;
    L35:
        if (r7 == null) goto L37;
    L31:
        r15 = false;
        goto L32
    L17:
        if (r6.length() <= 0) goto L19;
        boolean r16 = true;
    L20:
        if (r16 == true) goto L23;
        r6 = null;
    L23:
        if (r6 == null) goto L25;
    L19:
        r16 = false;
        goto L20
    L5:
        if (r1.length() <= 0) goto L7;
        boolean r17 = true;
    L8:
        if (r17 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L13;
    L7:
        r17 = false;
        goto L8
    }

    public final void setPromoteInstanceId(String r3) {
        Intrinsics.checkNotNullParameter(r3, "id");
        com.bytedance.android.livesdk.log.filter.o r0 = com.bytedance.android.livesdk.log.u.l().c(am2.f.class);
        if (r0 == null) goto L8;
        Map r1 = r0.getMap();
        if (r1 == null) goto L9;
        r1.put("promote_instance_id", r3);
        return;
    L9:
        return;
    }

    public final void u1(Function1<? super Boolean, Unit> r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        LivePluginSPIManager.e.getClass();     // Catch: Throwable -> L7
        if (LivePluginSPIManager.b() == false) goto L5;
        LivePluginSPIManager.a().addOnSuccess(new a(r3)).addOnFail(new b(r3));     // Catch: Throwable -> L7
    L5:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final <T> T getLiveSettingsValue(String r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        ILiveService r0 = TTLiveService.getLiveService();
        if (r0 == null) goto L9;
        T r4 = (T) r0.getLiveSettingValue(r2, r3);
        if (r4 != null) goto L8;
        return r3;
    L8:
        return r4;
    L9:
        return r3;
    }

    public final void putFunctionTypeToLogMap(Map<String, String> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        com.bytedance.android.live.liveinteract.api.utils.a.a.getClass();
        com.bytedance.android.live.liveinteract.api.utils.a.a.b(r2, r3);
    }

    public final boolean shouldRegisterAnimationListener(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "uniqueKey");
        Intrinsics.checkNotNullParameter(r5, LiveEndPageData.TAG_NAME);
        IAnimationScheduler.M0.getClass();
        if (IAnimationScheduler.Companion.b() == true) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r5, ILiveRoomControllerProvider.ProviderSource.PREVIEW.name()) == false) goto L11;
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        Objects.toString(r6);
        if (r6 == null) goto L16;
        com.bytedance.live.datacontext.m r7 = r6.getRegisterAnim();
        if (r7 == null) goto L16;
        r7.setValue(Boolean.TRUE);
    L16:
        return true;
    L11:
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        Objects.toString(r8);
        if (r8 == null) goto L16;
        com.bytedance.live.datacontext.m r9 = r8.getRegisterAnim();
        if (r9 == null) goto L16;
        r9.setValue(Boolean.TRUE);
        goto L16
    }

    public final void fullDialogHoverStateChange(int r5, int r6, int r7) {
        int r0 = com.bytedance.android.livesdk.gamecp.utils.a.a;
        switch(r5) {
            case 1: goto L10;
            case 2: goto L10;
            case 3: goto L10;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L10;
            default: goto L21;
        };
    L5:
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r8 == null) goto L16;
        int r1 = com.bytedance.android.live.room.api.panel.d.a;
        com.bytedance.android.live.room.api.panel.c r9 = com.bytedance.android.live.room.api.panel.d.a(r8);
        if (r9 == null) goto L17;
        r9.notifyPanelClose(PanelName.GameCp, new com.bytedance.android.livesdk.gamecp.utils.a.C0357a(r6, r7));
        return;
    L17:
        return;
    L16:
        return;
    L10:
        RoomContext r10 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r10 == null) goto L19;
        int r2 = com.bytedance.android.live.room.api.panel.d.a;
        com.bytedance.android.live.room.api.panel.c r11 = com.bytedance.android.live.room.api.panel.d.a(r10);
        if (r11 == null) goto L20;
        r11.notifyPanelOpen(PanelName.GameCp, new com.bytedance.android.livesdk.gamecp.utils.a.C0357a(r6, r7));
        return;
    L20:
        return;
    L19:
        return;
    }

    public final Map<String, Object> getPreviewTrackParams(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "roomId");
        Intrinsics.checkNotNullParameter(r3, "uniqueKey");
        Intrinsics.checkNotNullParameter(r4, "source");
        return new HashMap();
    }

    public final void showLiveAdLandingPage(Context r2, Bundle r3, FragmentManager r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "arguments");
        Intrinsics.checkNotNullParameter(r4, "fm");
        IHostLiveAd r0 = TTLiveSDK.hostService().hostLiveAd();
        if (r0 == null) goto L8;
        ILiveAdLandingPageDialogFragment r5 = r0.getLiveAdLandingPageDialogFragment(r2, r3, r4);
        if (r5 == null) goto L9;
        r5.show();
        return;
    L9:
        return;
    }

    public final Object A(String r2, Type r3, Object r4, Boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "type");
        if (r5 == null) goto L5;
        boolean r6 = r5.booleanValue();
    L7:
        return SettingUtil.getValue("key_ttlive_sdk_setting", r2, r3, r4, r6);
    L5:
        r6 = false;
        goto L7
    }

    public final Object dataCenterOperate(boolean r6, String r7, Object r8, Object r9) {
        Intrinsics.checkNotNullParameter(r7, "key");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L5;
        com.bytedance.live.datacontext.n r1 = r0.getDataCenter();
    L6:
        if (r6 == false) goto L12;
        if (r1 == null) goto L11;
        DataCenter r10 = (DataCenter) r1.getValue();
        if (r10 == null) goto L11;
        r10.put(r7, r8);
    L11:
        return null;
    L12:
        if (r1 == null) goto L17;
        DataCenter r11 = (DataCenter) r1.getValue();
        if (r11 != null) goto L16;
        return null;
    L16:
        return r11.get(r7, r9);
    L17:
        return null;
    L5:
        r1 = null;
        goto L6
    }

    public final void B0(Activity r9, String r10, Bundle r11, lu.h r12, Map r13) {
        IGamecpDependService r0 = jc1.k.f(IGamecpDependService.class);
        if (r0 == null) goto L6;
        r0.verify(r9, "recharge", r10, r11, new q(r12), r13, false);
        return;
    }

    public final void s2(Activity r8, String r9, String r10, boolean r11, com.bytedance.android.gamecp.business.props.r r12) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        Intrinsics.checkNotNullParameter(r10, "flow");
        IGamecpDependService r1 = jc1.k.f(IGamecpDependService.class);
        if (r1 == null) goto L6;
        r1.verifyV3(r8, r9, r10, r11, new r(r12));
        return;
    }

    public final void updateAnchorFloatBallDownloadData(int r9, boolean r10, int r11, boolean r12, boolean r13) {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.m r1 = r0.getAnchorFloatBallDownloadData();
        if (r1 == null) goto L9;
        r1.setValue(new AnchorFloatBallDownloadData(r9, r10, r11, r12, r13));
        return;
    L9:
        return;
    }

    public final void showAnchorFloatBallGamePromoteNotice(Integer r12, String r13, String r14, String r15, String r16, long r17, String r19) {
        Intrinsics.checkNotNullParameter(r13, "promoteText");
        Intrinsics.checkNotNullParameter(r14, "introduceText");
        Intrinsics.checkNotNullParameter(r15, "gameIcon");
        Intrinsics.checkNotNullParameter(r16, "gameName");
        Intrinsics.checkNotNullParameter(r19, "gameId");
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.n r1 = r0.getAnchorFloatBallGamePromoteNoticeData();
        if (r1 == null) goto L9;
        r1.setValue(new AnchorFloatBallGamePromoteNoticeData(r13, r14, r15, r16, r17, r19, r12));
        return;
    L9:
        return;
    }
}
