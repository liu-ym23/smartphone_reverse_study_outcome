package com.bytedance.android.livesdk.gamecp;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.IGameCPPreviewService;
import com.bytedance.android.live.broadcast.api.framework.common.LiveRoomStateUpdateEvent;
import com.bytedance.android.live.broadcast.api.framework.common.LiveRoomStateUpdateIntent;
import com.bytedance.android.live.broadcast.api.framework.common.LiveRoomStatesAndAVResourceUtils;
import com.bytedance.android.live.broadcast.api.framework.service.ILiveRoomStatusService;
import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.verify.api.ZhimaVerifyApi;
import com.bytedance.android.live.core.verify.fragment.CommonVerifyFragment;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.UserType;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.platformplayer.model.LivePanelType;
import com.bytedance.android.live.pushstream.IPushStreamService;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.room.api.panel.PanelName;
import com.bytedance.android.live.room.api.screenrotation.api.IScreenRotateService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostLiveAd;
import com.bytedance.android.livehostapi.business.depend.ILiveFaceCertCallback;
import com.bytedance.android.livehostapi.business.depend.LiveCertResult;
import com.bytedance.android.livehostapi.business.depend.LiveCertStatus;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveAdLandingPageDialogFragment;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.model.o0;
import com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenLogUtils;
import com.bytedance.android.livesdk.config.fq0;
import com.bytedance.android.livesdk.config.gq0;
import com.bytedance.android.livesdk.config.x71;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig;
import com.bytedance.android.livesdk.module.RoomService;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.gamecp.AnchorFloatBallDownloadData;
import com.bytedance.android.livesdkapi.depend.model.gamecp.AnchorFloatBallGamePromoteNoticeData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.service.ICurrentInteractionUiAction;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.service.ILiveUxTracer;
import com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService;
import com.bytedance.android.livesdkapi.service.gamecp.IAiService;
import com.bytedance.android.livesdkapi.service.gamecp.IGamecpDependService;
import com.bytedance.android.livesdkapi.service.gamecp.IHybridService;
import com.bytedance.android.livesdkapi.service.gamecp.ILiveFloatViewService;
import com.bytedance.android.livesdkapi.service.gamecp.ILiveIMService;
import com.bytedance.android.livesdkapi.service.gamecp.ILiveMiniGamePlayService;
import com.bytedance.android.livesdkapi.service.gamecp.ILiveMonitorService;
import com.bytedance.android.livesdkapi.service.gamecp.ILiveMultiLinkService;
import com.bytedance.android.livesdkapi.service.gamecp.ILiveRoomLandScapeService;
import com.bytedance.android.livesdkapi.service.gamecp.ILiveScreenPermissionProxy;
import com.bytedance.android.livesdkapi.service.gamecp.OnVerifyResultListenerProxy;
import com.bytedance.android.livesdkapi.service.gamecp.OrientationType;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import zg1.k1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class GamecpDependService implements IGamecpDependService {
    public x a;
    public AiService b;
    public a0 c;
    public f0 d;
    public b0 e;
    public c0 f;
    public d0 g;
    public e0 h;
    public int i;
    public ILiveScreenPermissionProxy j;

    public static final class a<T> implements ObservableOnSubscribe {
        public final /* synthetic */ int a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gamecp.GamecpDependService$a$a, reason: collision with other inner class name */
        public static final class C0352a implements vlc.l {
            public final /* synthetic */ a a;
            public final /* synthetic */ ObservableEmitter b;

            public C0352a(a r1, ObservableEmitter r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void onMessage(tlc.d r3) {
                JSONObject r4 = tv5.a.a(GsonHelper.get(), r3);
                r4.put("intType", this.a.a);
                this.b.onNext(r4.toString());
            }
        }

        public a(int r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<String> r6) {
            Intrinsics.checkNotNullParameter(r6, "emitter");
            RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r0 == null) goto L10;
            com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
            if (r1 == null) goto L11;
            vlc.d r2 = (vlc.d) r1.getValue();
            if (r2 == null) goto L12;
            r2.addMessageListener(this.a, new C0352a(this, r6));
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public static final class b implements com.bytedance.android.live.core.verify.utils.a.g {
        public final /* synthetic */ ILiveService.OnWalletVerifyCallBack a;

        public b(ILiveService.OnWalletVerifyCallBack r1) {
            this.a = r1;
        }

        public final void onVerify(boolean r2, Map<String, ? extends Object> r3) {
            ILiveService.OnWalletVerifyCallBack r0 = this.a;
            if (r0 == null) goto L6;
            r0.onVerify(r2, r3);
            return;
        }
    }

    public static final class c implements com.bytedance.android.live.core.verify.utils.a.f {
        public final /* synthetic */ Map a;

        public c(Map r1) {
            this.a = r1;
        }

        public final Observable<Response<w80.a>> a(Map<String, String> r3) {
            LinkedHashMap r0 = new LinkedHashMap();
            r0.putAll(r3);
            Map r4 = this.a;
            if (r4 == null) goto L6;
            r0.putAll(r4);
        L6:
            return ((ZhimaVerifyApi) com.bytedance.android.live.network.c.b().e(ZhimaVerifyApi.class)).getCertificationCommonSubmit(r0);
        }
    }

    public static final class d implements ILiveFaceCertCallback {
        public final /* synthetic */ v80.f a;
        public final /* synthetic */ OnVerifyResultListenerProxy b;

        public final void onVerifyResult(LiveCertResult r6) {
            StringBuilder r0 = new StringBuilder("Verified result， isFaceOnly: ");
            r0.append(this.a.d);
            r0.append(", errorCode = ");
            Integer r1 = null;
            if (r6 == null) goto L5;
            Integer r2 = Integer.valueOf(r6.getErrorCode());
        L6:
            r0.append(r2);
            r0.append(", status = ");
            if (r6 == null) goto L11;
            LiveCertStatus r3 = r6.getStatus();
            if (r3 == null) goto L11;
            r1 = Integer.valueOf(r3.getCertStatus());
        L11:
            r0.append(r1);
            ALogger.i("GameCP_RealName_Auth", r0.toString());
            if (this.a.d == false) goto L22;
            if (r6 != null) goto L15;
        L19:
            OnVerifyResultListenerProxy r7 = this.b;
            if (r7 == null) goto L36;
            r7.onVerifyResult(1);
            return;
        L36:
            return;
        L15:
            if (r6.getErrorCode() != 0) goto L19;
            f2.c(s1.B(2131915630), 0);
            OnVerifyResultListenerProxy r8 = this.b;
            if (r8 == null) goto L34;
            r8.onVerifyResult(3);
            return;
        L34:
            return;
        L22:
            if (r6 == null) goto L38;
            LiveCertStatus r9 = r6.getStatus();
            if (r9 != null) goto L26;
            return;
        L26:
            if (r9.getCertStatus() != 1) goto L30;
            f2.c(s1.B(2131915630), 0);
            OnVerifyResultListenerProxy r10 = this.b;
            if (r10 == null) goto L40;
            r10.onVerifyResult(3);
            return;
        L40:
            return;
        L30:
            OnVerifyResultListenerProxy r11 = this.b;
            if (r11 == null) goto L42;
            r11.onVerifyResult(1);
            return;
        L42:
            return;
        L38:
            return;
        L5:
            r2 = null;
            goto L6
        }

        public d(v80.f r1, OnVerifyResultListenerProxy r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public GamecpDependService() {
    }

    public final Map<String, Object> getAdLogExtra() {
        LinkedHashMap r0 = new LinkedHashMap();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L33
        String r2 = am2.n.f().d;     // Catch: Throwable -> L33
        if (r2 != null) goto L6;
        r2 = "natural";
    L6:
        r0.put("isOtherChannel", r2);     // Catch: Throwable -> L33
        String r3 = am2.n.f().a();     // Catch: Throwable -> L33
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r0.put("adId", r3);     // Catch: Throwable -> L33
        r0.put("logExtra", am2.n.f().d());     // Catch: Throwable -> L33
        if (am2.n.f().c().length() <= 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L31;
        r0.put("creativeId", Long.valueOf(CastLongProtector.parseLong(am2.n.f().c())));     // Catch: Throwable -> L33
        long r5 = 0;
        String r6 = null;
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);     // Catch: Throwable -> L33
        if (r7 == null) goto L21;
        com.bytedance.live.datacontext.m r8 = r7.getRoom();     // Catch: Throwable -> L33
        if (r8 == null) goto L21;
        Room r9 = (Room) r8.getValue();     // Catch: Throwable -> L33
        if (r9 == null) goto L21;
        r6 = String.valueOf(r9.id);     // Catch: Throwable -> L33
    L21:
        ILiveDouPlusService r10 = jc1.k.n(ILiveDouPlusService.class);     // Catch: Throwable -> L33
        if (r6 == null) goto L24;
        r5 = CastLongProtector.parseLong(r6);     // Catch: Throwable -> L33
    L24:
        UrlModel r11 = r10.getEnterRoomClickTrackUrlList(r5);     // Catch: Throwable -> L33
        if (r11 == null) goto L31;
        List r12 = r11.getUrlList();     // Catch: Throwable -> L33
        if (r12 == null) goto L31;
        if ((!r12.isEmpty()) != true) goto L31;
        r0.put("clickTrackUrlList", new JSONArray(r11.getUrlList()));     // Catch: Throwable -> L33
    L31:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L35:
        return r0;
    L12:
        r4 = false;
    L33:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L35
    }

    public final IAiService getAiService() {
        if (this.b != null) goto L5;
        this.b = new AiService();
    L5:
        AiService r0 = this.b;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public final int getCurrentScene() {
        return Integer.valueOf(jc1.k.n(IInteractService.class).getCurrentScene()).intValue();
    }

    public final String getEventLiveType() {
        LiveMode r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.i r1 = r0.getLiveMode();
        if (r1 == null) goto L7;
        LiveMode r2 = (LiveMode) r1.getValue();
    L8:
        if (r2 != null) goto L15;
        IRoomService r3 = jc1.k.f(IRoomService.class);
        if (r3 == null) goto L14;
        Room r5 = r3.getCurrentRoom();
        if (r5 == null) goto L14;
        r4 = r5.getStreamType();
    L14:
        r2 = r4;
    L15:
        int r6 = h1.a;
        return i1.a(r2);
    L7:
        r2 = null;
        goto L8
    }

    public final String getFunctionType() {
        com.bytedance.android.livesdk.chatroom.helper.c.a.getClass();
        int r0 = jc1.k.n(IInteractService.class).getCurrentScene();
        if (r0 != 4) goto L5;
        return SourceType.DEFAULT;
    L5:
        if (r0 != 5) goto L7;
        return "radio";
    L7:
        if (r0 == 12) goto L12;
        switch(r0) {
            case 8: goto L16;
            case 9: goto L11;
            case 10: goto L10;
            default: goto L9;
        };
    L9:
        return "";
    L10:
        return "watch";
    L11:
        return "ktv";
    L16:
        return "radio";
    L12:
        return "party";
    }

    public final Long getGameCategoryId() {
        IBroadcastService r0 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r0 == null) goto L7;
        IGameCPPreviewService r1 = r0.getGameCPPreviewService();
        if (r1 == null) goto L7;
        return r1.getCategoryId();
    L7:
        return null;
    }

    public final String getGamePromoteSceneSub() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.j r1 = r0.getPreviewSourceParam();
        if (r1 == null) goto L10;
        PreviewSourceParam r2 = (PreviewSourceParam) r1.getValue();
        if (r2 == null) goto L10;
        String r3 = r2.getGamePromoteSceneSub();
        if (r3 == null) goto L10;
        return r3;
    L10:
        return "";
    }

    public final IHybridService getHybridService() {
        if (this.a != null) goto L5;
        this.a = new x();
    L5:
        x r0 = this.a;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public final String getIfClearModeValueWithClick() {
        ClearScreenLogUtils.a.getClass();
        return ClearScreenLogUtils.Companion.a();
    }

    public final String getIfClearModeValueWithIntroCardShow() {
        ClearScreenLogUtils.a.getClass();
        return ClearScreenLogUtils.Companion.b();
    }

    public final ILiveFloatViewService getLiveFloatViewService() {
        if (this.c != null) goto L6;
        this.c = new a0();
    L6:
        return this.c;
    }

    public final ILiveIMService getLiveIMService() {
        if (this.e != null) goto L6;
        this.e = new b0();
    L6:
        return this.e;
    }

    public final ILiveMiniGamePlayService getLiveMiniGamePlayService() {
        if (this.f != null) goto L6;
        this.f = new c0();
    L6:
        return this.f;
    }

    public final ILiveMonitorService getLiveMonitorService() {
        if (this.g != null) goto L6;
        this.g = new d0();
    L6:
        return this.g;
    }

    public final ILiveMultiLinkService getLiveMultiLinkService() {
        if (this.h != null) goto L6;
        this.h = new e0();
    L6:
        return this.h;
    }

    public final ILiveRoomLandScapeService getLiveRoomLandScapeService() {
        if (this.d != null) goto L6;
        this.d = new f0();
    L6:
        return this.d;
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
        int r4 = com.bytedance.android.livesdk.gamecp.d.a[r1.ordinal()];
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
        IBroadcastService r0 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r0 == null) goto L7;
        IGameCPPreviewService r1 = r0.getGameCPPreviewService();
        if (r1 == null) goto L7;
        LiveMode r2 = r1.getPreviewLiveMode();
    L8:
        int r3 = h1.a;
        return i1.a(r2);
    L7:
        r2 = null;
        goto L8
    }

    public final boolean hasFullWatchRight() {
        DataCenter r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.n r1 = r0.getDataCenter();
        if (r1 == null) goto L8;
        r4 = (DataCenter) r1.getValue();
    L8:
        return com.bytedance.android.livesdk.vscore_api.paidlive.c.a.b(com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(r4), PaidSceneEnum.PAID_ROOM, 2);
    }

    public final boolean hasToolbarShow() {
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j r1 = r0.getCompactTbLoader();
        if (r1 == null) goto L7;
        r4 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.m) r1.getValue();
    L7:
        if (r4 != null) goto L9;
        return false;
    L9:
        return r4.isComponentShowing(5);
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

    public final void pauseLive() {
        gq0 r0 = gq0.a;
        if (((x71) r0.getValue()).b() == true) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (fq0.a.getValue().booleanValue() == false) goto L21;
        IPushStreamService r2 = jc1.k.f(IPushStreamService.class);
        if (r2 == null) goto L21;
        com.bytedance.android.live.pushstream.d r3 = r2.getPushLiveStream();
        if (r3 == null) goto L21;
        uf2.d0 r4 = r3.getLiveCore();
        if (r4 == null) goto L21;
        uf2.d0.a r5 = r4.getBuilder();
        if (r5 == null) goto L21;
        if (r5.g() != 4) goto L21;
        boolean r6 = true;
    L22:
        ILiveRoomStatusService r7 = (ILiveRoomStatusService) va1.b.a.a.a(ILiveRoomStatusService.class);
        if (LiveRoomStatesAndAVResourceUtils.c() == false) goto L30;
        if (r7 == null) goto L30;
        if (r7.requestRoomStateUpdate(new zz.b(LiveRoomStateUpdateIntent.PAUSE, LiveRoomStateUpdateEvent.User, "GamecpDependService.pauseLive", "GamecpDependService", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("event_name", "LiveGameEvent")}))) == false) goto L38;
        if (r1 == false) goto L39;
        if (r6 == true) goto L40;
        xs2.b.a().b(zg1.h1.class).subscribe(new e(this));
        this.i = 0;
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L30:
        if (r1 == false) goto L33;
        if (r6 == true) goto L33;
        xs2.b.a().post(new zg1.h1(75));
    L34:
        if (r1 == false) goto L42;
        if (r6 == true) goto L43;
        xs2.b.a().b(zg1.h1.class).subscribe(new e(this));
        this.i = 0;
        return;
    L43:
        return;
    L42:
        return;
    L33:
        xs2.b.a().post(new zg1.h1(30));
    L21:
        r6 = false;
        goto L22
    L5:
        if (Build.VERSION.SDK_INT < ((x71) r0.getValue()).a()) goto L7;
        r1 = true;
        goto L9
    }

    public final boolean userNameIsProtected() {
        kz.a r0 = kz.b.a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.a() != true) goto L7;
        return true;
    }

    public final String getLiveSdkVersion() {
        return String.valueOf(com.bytedance.android.livesdk.paas.c.b());
    }

    public final boolean isLivePlayerClientMute() {
        ILiveFloatViewService r0 = getLiveFloatViewService();
        if (r0 != null) goto L5;
    L10:
        ILivePlayerClient r1 = LivePlatformPlayerManager.f();
        if (r1 != null) goto L13;
        return false;
    L13:
        return r1.isMute();
    L5:
        if (r0.isFloatViewShowing() != true) goto L10;
        ILiveVideoFloatWindowService r2 = jc1.k.f(ILiveVideoFloatWindowService.class);
        if (r2 != null) goto L9;
        return false;
    L9:
        return r2.isFloatWindowMute();
    }

    public final void muteLivePlayerClient() {
        ILiveFloatViewService r0 = getLiveFloatViewService();
        if (r0 != null) goto L5;
    L9:
        ILivePlayerClient r1 = LivePlatformPlayerManager.f();
        if (r1 == null) goto L12;
        r1.mute("GamecpDependService.muteLivePlayerClient");
    L12:
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r2 == null) goto L16;
        r2.setAutoUnmute(false);
        return;
    L16:
        return;
    L5:
        if (((a0) r0).isFloatViewShowing() != true) goto L9;
        ILiveVideoFloatWindowService r3 = jc1.k.f(ILiveVideoFloatWindowService.class);
        if (r3 == null) goto L12;
        r3.toggleLiveAudio(true);
        goto L12
    }

    public final void unMuteLivePlayerClient() {
        ILiveFloatViewService r0 = getLiveFloatViewService();
        if (r0 != null) goto L5;
    L9:
        ILivePlayerClient r1 = LivePlatformPlayerManager.f();
        if (r1 == null) goto L12;
        r1.unmute("GamecpDependService.unMuteLivePlayerClient");
    L12:
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r2 == null) goto L16;
        r2.setAutoUnmute(true);
        return;
    L16:
        return;
    L5:
        if (((a0) r0).isFloatViewShowing() != true) goto L9;
        ILiveVideoFloatWindowService r3 = jc1.k.f(ILiveVideoFloatWindowService.class);
        if (r3 == null) goto L12;
        r3.toggleLiveAudio(false);
        goto L12
    }

    public final void gamePrivacyMonitorEnsureRelease() {
        e00.b.a();
    }

    public final long getStartRoomTime() {
        return in1.b.b;
    }

    public final void forceUpdateOrientation(int r4) {
        boolean r0 = !e5.n();
        if (r0 == false) goto L5;
    L6:
        if (r0 == false) goto L9;
        if (r4 != 1) goto L9;
        return;
    L9:
        if (r4 != 1) goto L11;
        com.bytedance.android.live.room.api.screenrotation.rotate.f.b r5 = com.bytedance.android.live.room.api.screenrotation.rotate.f.b.a;
    L12:
        IScreenRotateService r1 = jc1.k.f(IScreenRotateService.class);
        if (r1 == null) goto L19;
        com.bytedance.android.live.room.api.screenrotation.rotate.e r2 = r1.rotation();
        if (r2 == null) goto L20;
        r2.b(r5, AnonymousClass1.INSTANCE);
        return;
    L20:
        return;
    L19:
        return;
    L11:
        r5 = com.bytedance.android.live.room.api.screenrotation.rotate.f.a.a;
        goto L12
    L5:
        if (r4 != 2) goto L6;
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

    public final void insertLivePublishMessage(String r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.livesdk.interactivity.api.publicscreen.m.a(null);
        if (r0 == null) goto L8;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r1 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.l) r0.getValue();
        if (r1 == null) goto L9;
        int r2 = com.bytedance.android.livesdk.interactivity.api.publicscreen.s.k;
        r1.insertMessage(com.bytedance.android.livesdk.interactivity.api.publicscreen.s.b.b(PublicScreenConfig.MessageModelType.ROOM_MESSAGE, r10, null, false, false, null, 508));
        return;
    L9:
        return;
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

    public final void onEvent(zg1.h1 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        int r3 = r2.a;
        if (r3 != 76) goto L8;
        ILiveScreenPermissionProxy r4 = this.j;
        if (r4 == null) goto L13;
        r4.onGranted();
        return;
    L13:
        return;
    L8:
        if (r3 != 77) goto L15;
        this.i = 0;
        ILiveScreenPermissionProxy r5 = this.j;
        if (r5 == null) goto L16;
        r5.onCancel();
        return;
    L16:
        return;
    }

    public final void resumeLive(ILiveScreenPermissionProxy r13) {
        Intrinsics.checkNotNullParameter(r13, "callback");
        gq0 r0 = gq0.a;
        if (((x71) r0.getValue()).b() == true) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (fq0.a.getValue().booleanValue() == false) goto L21;
        IPushStreamService r2 = jc1.k.f(IPushStreamService.class);
        if (r2 == null) goto L21;
        com.bytedance.android.live.pushstream.d r3 = r2.getPushLiveStream();
        if (r3 == null) goto L21;
        uf2.d0 r4 = r3.A();
        if (r4 == null) goto L21;
        uf2.d0.a r5 = r4.getBuilder();
        if (r5 == null) goto L21;
        if (r5.g() != 4) goto L21;
        boolean r6 = true;
    L22:
        if (r1 == false) goto L28;
        if (r6 == true) goto L28;
        int r7 = this.i + 1;
        this.i = r7;
        if (r7 <= 1) goto L27;
        return;
    L27:
        this.j = r13;
    L28:
        ILiveRoomStatusService r8 = (ILiveRoomStatusService) va1.b.a.a.a(ILiveRoomStatusService.class);
        if (LiveRoomStatesAndAVResourceUtils.c() == false) goto L38;
        if (r8 == null) goto L38;
        if (r8.requestRoomStateUpdate(new zz.b(LiveRoomStateUpdateIntent.RESUME, LiveRoomStateUpdateEvent.User, "GamecpDependService.resumeLive", "GamecpDependService", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("event_name", "BroadcastPauseGameEvent")}))) == false) goto L55;
        if (r1 == false) goto L35;
        if (r6 == true) goto L35;
        return;
    L35:
        this.j = r13;
        if (r13 == null) goto L57;
        r13.onGranted();
        return;
    L57:
        return;
    L55:
        return;
    L38:
        if (r1 == false) goto L48;
        if (r6 == true) goto L48;
        com.bytedance.live.datacontext.n r9 = null;
        RoomContext r10 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r10 == null) goto L43;
        r9 = r10.getDataCenter();
    L43:
        zg1.m r11 = new zg1.m();
        r11.a = 7;
        if (r9 == null) goto L49;
        DataCenter r12 = (DataCenter) r9.getValue();
        if (r12 == null) goto L49;
        r12.put("data_broadcast_pause_state", r11);
    L49:
        if (r1 == false) goto L51;
        if (r6 == true) goto L51;
        return;
    L51:
        this.j = r13;
        if (r13 == null) goto L60;
        r13.onGranted();
        return;
    L60:
        return;
    L48:
        xs2.b.a().post(new zg1.h1(31));
    L21:
        r6 = false;
        goto L22
    L5:
        if (Build.VERSION.SDK_INT < ((x71) r0.getValue()).a()) goto L7;
        r1 = true;
        goto L9
    }

    public final void setGameDetailCameraOperation(boolean r3) {
        IBroadcastService r0 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r0 == null) goto L8;
        IGameCPPreviewService r1 = r0.getGameCPPreviewService();
        if (r1 == null) goto L9;
        r1.setGameDetailCameraOperation(r3);
        return;
    L9:
        return;
    }

    public final void setLiveLogData(HashMap<String, String> r12) {
        Intrinsics.checkNotNullParameter(r12, "map");
        com.bytedance.android.livesdk.log.filter.o r0 = com.bytedance.android.livesdk.log.u.l().c(am2.f.class);
        String r1 = r12.get("enter_from");
        String r2 = null;
        boolean r3 = true;
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
    L72:
        if (r0 == null) goto L75;
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
    L75:
        return;
    L65:
        if (r13.length() > 0) goto L68;
        r3 = false;
    L68:
        if (r3 == false) goto L70;
        r2 = r13;
    L70:
        if (r2 == null) goto L72;
        r5 = r2;
        goto L72
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

    public final void setOrientation(int r2) {
        if (r2 != OrientationType.INSTANCE.getHORIZONTAL()) goto L5;
        HorizontalPlayEvent r3 = new HorizontalPlayEvent(2);
    L6:
        r3.rotationType = 0;
        xs2.b.a().post(r3);
        return;
    L5:
        r3 = new HorizontalPlayEvent(1);
        goto L6
    }

    public final void setPromoteInstanceId(String r3) {
        Intrinsics.checkNotNullParameter(r3, "id");
        com.bytedance.android.livesdk.log.u.l().c(am2.f.class).getMap().put("promote_instance_id", r3);
    }

    public final <T> Observable<T> shareFlavorObservable(Observable<T> r2) {
        xo2.d r3 = (xo2.d) com.bytedance.android.livesdk.service.l.d().b().a(xo2.d.class);
        if (r3 != null) goto L5;
        return null;
    L5:
        return r3.share();
    }

    public final void showInteractionAndEnterRoom(String r2) {
        Intrinsics.checkNotNullParameter(r2, "roomId");
        ILiveService r0 = jc1.k.f(ILiveService.class);
        if (r0 == null) goto L8;
        ICurrentInteractionUiAction r1 = r0.getCurrentInteractionUiAction();
        if (r1 == null) goto L9;
        r1.showInteractionAndEnterRoom(r2);
        return;
    L9:
        return;
    }

    public final void showUserPanel(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        UserProfileEvent r0 = new UserProfileEvent(r2);
        xs2.b.a().post(r0);
    }

    public final Observable<String> subscribeLiveMessage(int r2) {
        return Observable.create(new a(r2));
    }

    public final UserType tryGetTargetUserType(long r2) {
        UserType r3 = jc1.k.n(IInteractService.class).tryGetTargetUserType(String.valueOf(r2));
        if (r3 == null) goto L5;
        return r3;
    L5:
        return UserType.UNKNOWN;
    }

    public final Fragment createCommonVerifyFragment(Context r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bundle");
        CommonVerifyFragment r4 = new CommonVerifyFragment();
        r4.setArguments(r3);
        return r4;
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

    public final String getProtectedName(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "nickName");
        Intrinsics.checkNotNullParameter(r3, "userId");
        kz.a r0 = kz.b.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getProtectedName(r2, r3);
    }

    public final long getTimeStamp(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "milestone");
        ILiveUxTracer r0 = jc1.k.f(ILiveUxTracer.class);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getTimeStamp(r2, r3);
    }

    public final boolean handle(Context r2, Uri r3) {
        ILiveActionHandler r0 = jc1.k.n(RoomService.class).actionHandler();
        if (r0 == null) goto L5;
        Boolean r4 = Boolean.valueOf(r0.handle(r2, r3));
    L7:
        return r4.booleanValue();
    L5:
        r4 = null;
        goto L7
    }

    public final void logV3NoPrefix(String r3, Map<String, String> r4) {
        com.bytedance.android.livesdk.log.u.l().h(r3, r4, new Object[0]);
    }

    public final void notifyLiveLoginEvent(boolean r2, IUser r3) {
        k1 r0 = new k1();
        r0.a = r2;
        if (r3 == null) goto L5;
        r0.b = r3;
    L5:
        xs2.b.a().post(r0);
    }

    public final Spannable parseText2Spannable(Text r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "defaultContent");
        return sb2.a.h(r2, r3, false);
    }

    public final void putFunctionTypeToLogMap(Map<String, String> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        com.bytedance.android.livesdk.chatroom.helper.c.a.getClass();
        com.bytedance.android.livesdk.chatroom.helper.c.a.a(r2, r3);
    }

    public final boolean shouldRegisterAnimationListener(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "uniqueKey");
        Intrinsics.checkNotNullParameter(r5, LiveEndPageData.TAG_NAME);
        IAnimationScheduler.M0.getClass();
        if (IAnimationScheduler.Companion.b() == true) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r5, ILiveRoomControllerProvider.ProviderSource.PREVIEW.name()) == false) goto L11;
        RoomContext.Companion.getClass();
        RoomContext r6 = RoomContext.a.b(null, r4);
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

    public final void toolbarMoveToFold(boolean r5, int r6) {
        o0 r0 = new o0();
        r0.b = r6;
        r0.a = r5;
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r7 == null) goto L8;
        com.bytedance.live.datacontext.m r8 = r7.getInFold();
        if (r8 == null) goto L9;
        r8.setValue(r0);
        return;
    L9:
        return;
    }

    public final void updatePlayData(String r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "playId");
        RoomContext.a r0 = RoomContext.Companion;
        RoomContext r5 = RoomContext.a.c(r0, null, 0, 3);
        if (r5 == null) goto L7;
        com.bytedance.live.datacontext.m r6 = r5.getPlayId();
        if (r6 == null) goto L7;
        r6.setValue(r7);
    L7:
        RoomContext r9 = RoomContext.a.c(r0, null, 0, 3);
        if (r9 == null) goto L13;
        com.bytedance.live.datacontext.m r10 = r9.getTeamStatus();
        if (r10 == null) goto L14;
        r10.setValue(String.valueOf(r8));
        return;
    L14:
        return;
    }

    public final boolean handle(Context r2, String r3) {
        ILiveActionHandler r0 = jc1.k.n(RoomService.class).actionHandler();
        if (r0 == null) goto L5;
        Boolean r4 = Boolean.valueOf(r0.handle(r2, r3));
    L7:
        return r4.booleanValue();
    L5:
        r4 = null;
        goto L7
    }

    public final void dataMapping(String r1, String r2, Map<String, String> r3) {
        Map r4 = com.bytedance.android.livesdk.log.e0.a;
    }

    public final void fullDialogHoverStateChange(int r6, int r7, int r8) {
        int r0 = ux1.a.a;
        switch(r6) {
            case 1: goto L10;
            case 2: goto L10;
            case 3: goto L10;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L10;
            default: goto L16;
        };
    L5:
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L16;
        int r2 = com.bytedance.android.live.room.api.panel.d.a;
        com.bytedance.android.live.room.api.panel.c r3 = com.bytedance.android.live.room.api.panel.d.a(r1);
        if (r3 == null) goto L16;
        r3.notifyPanelClose(PanelName.GameCp, new ux1.a.C0421a(r7, r8));
        goto L16
    L10:
        RoomContext r4 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r4 == null) goto L16;
        int r5 = com.bytedance.android.live.room.api.panel.d.a;
        com.bytedance.android.live.room.api.panel.c r9 = com.bytedance.android.live.room.api.panel.d.a(r4);
        if (r9 == null) goto L16;
        r9.notifyPanelOpen(PanelName.GameCp, new ux1.a.C0421a(r7, r8));
    L16:
        if (r6 != 1) goto L18;
    L27:
        com.bytedance.android.live.platformplayer.service.b r10 = jc1.k.f(com.bytedance.android.live.platformplayer.service.b.class);
        if (r10 == null) goto L33;
        ds0.b r11 = new ds0.b();
        r11.a(LivePanelType.GAME_DETAIL);
        r11.c = r7;
        Intrinsics.checkNotNullParameter("open", "<set-?>");
        r11.b = "open";
        Unit r12 = Unit.INSTANCE;
        r10.w1(r11);
        return;
    L33:
        return;
    L18:
        if (r6 != 4) goto L20;
    L24:
        com.bytedance.android.live.platformplayer.service.b r13 = jc1.k.f(com.bytedance.android.live.platformplayer.service.b.class);
        if (r13 == null) goto L31;
        ds0.b r14 = new ds0.b();
        r14.a(LivePanelType.GAME_DETAIL);
        r14.c = r7;
        Intrinsics.checkNotNullParameter("close", "<set-?>");
        r14.b = "close";
        Unit r15 = Unit.INSTANCE;
        r13.w1(r14);
        return;
    L31:
        return;
    L20:
        if (r6 == 5) goto L24;
        if (r6 == 6) goto L27;
    }

    public final Map<String, Object> getPreviewTrackParams(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "roomId");
        Intrinsics.checkNotNullParameter(r3, "uniqueKey");
        Intrinsics.checkNotNullParameter(r4, "source");
        RoomContext.Companion.getClass();
        RoomContext r5 = RoomContext.a.b(null, r3);
        if (r5 == null) goto L9;
        com.bytedance.live.datacontext.m r6 = r5.getPreviewTrackParams();
        if (r6 == null) goto L9;
        Map<String, Object> r7 = (Map) r6.getValue();
        if (r7 == null) goto L9;
        return r7;
    L9:
        return new HashMap();
    }

    public final boolean handleWithCallback(Context r2, Uri r3, DialogInterface.OnDismissListener r4) {
        ILiveActionHandler r0 = jc1.k.n(RoomService.class).actionHandler();
        if (r0 == null) goto L5;
        Boolean r5 = Boolean.valueOf(r0.handleWithCallback(r2, r3, r4));
    L7:
        return r5.booleanValue();
    L5:
        r5 = null;
        goto L7
    }

    public final void showLiveAdLandingPage(Context r2, Bundle r3, FragmentManager r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "arguments");
        Intrinsics.checkNotNullParameter(r4, "fragmentManager");
        IHostLiveAd r0 = jc1.k.f(IHostLiveAd.class);
        if (r0 == null) goto L5;
        ILiveAdLandingPageDialogFragment r5 = r0.getLiveAdLandingPageDialogFragment(r2, r3, r4);
    L6:
        if (r5 == null) goto L9;
        r5.show();
        return;
    L9:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void updateTeamApplyMsg(String r7, boolean r8, long r9) {
        Intrinsics.checkNotNullParameter(r7, LiveEndPageData.TAG_NAME);
        RoomContext.a r0 = RoomContext.Companion;
        RoomContext r5 = RoomContext.a.c(r0, null, 0, 3);
        if (r5 == null) goto L7;
        com.bytedance.live.datacontext.m r6 = r5.getTeamApplyNickName();
        if (r6 == null) goto L7;
        r6.setValue(r7);
    L7:
        RoomContext r10 = RoomContext.a.c(r0, null, 0, 3);
        if (r10 == null) goto L10;
        r10.setTeamApplyNotify(r8);
    L10:
        RoomContext r11 = RoomContext.a.c(r0, null, 0, 3);
        if (r11 == null) goto L16;
        com.bytedance.live.datacontext.m r12 = r11.getTeamApplyUserId();
        if (r12 == null) goto L17;
        r12.setValue(String.valueOf(r9));
        return;
    L17:
        return;
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

    public final <T> T getLiveSettingValue(String r8, Type r9, T r10, T r11, Boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r9, "type");
        if (r12 == null) goto L5;
        boolean r6 = r12.booleanValue();
    L7:
        return (T) SettingUtil.getValue("key_ttlive_sdk_setting", r8, r9, r10, r11, r6);
    L5:
        r6 = false;
        goto L7
    }

    public final void sendLiveAdLog(String r11, String r12, Long r13, JSONObject r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r11, "label");
        Intrinsics.checkNotNullParameter(r12, "refer");
        Intrinsics.checkNotNullParameter(r14, "adExtraData");
        int r3 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.c.a;
        Intrinsics.checkNotNullParameter(r11, "label");
        Intrinsics.checkNotNullParameter(r12, "refer");
        Intrinsics.checkNotNullParameter(r14, "adExtraData");
        am2.n r0 = am2.n.f();
        boolean r4 = false;
        if (r0.g() == false) goto L5;
    L13:
        String r2 = r0.c();
        String r1 = r0.d();
        if (r2 != null) goto L16;
    L19:
        boolean r5 = true;
    L20:
        if (r5 == true) goto L52;
        HashMap r6 = new HashMap();
        r6.put("value", r2);
        r6.put("log_extra", r1);
        r14.putOpt("icon_type", "game_promote");
        if (r15 == false) goto L26;
        r14.putOpt("live_time", Long.valueOf(System.currentTimeMillis() - (-1)));
    L26:
        if (r13 != null) goto L28;
    L36:
        String r7 = "live_ad";
    L37:
        ILiveDouPlusService r8 = jc1.k.n(ILiveDouPlusService.class);
        HashMap r9 = new HashMap();
        r9.put("refer", r12);
        r9.put("ad_extra_data", r14.toString());
        if (r6.isEmpty() == true) goto L41;
        r9.putAll(r6);
    L41:
        r8.logEvent(true, r7, r11, r9);
        if (Intrinsics.areEqual(r11, "click") == false) goto L50;
        if (r13 == null) goto L51;
        long r16 = CastLongProtector.parseLong(r2);     // Catch: Exception -> L46
        UrlModel r17 = jc1.k.n(ILiveDouPlusService.class).getEnterRoomClickTrackUrlList(r13.longValue());     // Catch: Exception -> L46
        jc1.k.n(ILiveDouPlusService.class).sendThirdTrack("click", r17, Long.valueOf(r16), r1);     // Catch: Exception -> L46
        return;
    L53:
        return;
    L51:
        return;
    L50:
        return;
    L28:
        if (com.bytedance.android.livesdk.chatroom.c0.b().isFirstRoom(r13.longValue()) == true) goto L36;
        if (TextUtils.equals(r11, "click") == true) goto L32;
    L34:
        if (r4 == false) goto L36;
        r7 = "draw_ad";
        goto L37
    L32:
        if (TextUtils.equals(r12, "icon") == false) goto L34;
        r4 = true;
        goto L34
    L52:
        return;
    L16:
        if (r2.length() == 0) goto L19;
        r5 = false;
        goto L20
    L5:
        if (r0.h() == true) goto L13;
        if (TextUtils.isEmpty(r0.d) == false) goto L9;
    L11:
        boolean r10 = false;
    L12:
        if (r10 == true) goto L13;
        return;
    L9:
        if (TextUtils.equals("game_ad", r0.d) == false) goto L11;
        r10 = true;
        goto L12
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

    public final void verifyV3(Context r6, String r7, String r8, boolean r9, OnVerifyResultListenerProxy r10) {
        Intrinsics.checkNotNullParameter(r7, "scene");
        Intrinsics.checkNotNullParameter(r8, "flow");
        ALogger.i("GameCP_RealName_Auth", "start certification with authentication 3.0， scene：" + r7 + ", flow: " + r8);
        y80.b r2 = y80.c.a();
        v80.f r3 = new v80.f();
        Intrinsics.checkNotNullParameter(r7, "scene");
        r3.c.put("scene", r7);
        Intrinsics.checkNotNullParameter(r8, "flow");
        r3.c.put("flow", r8);
        r3.d = r9;
        ((v80.h) r3).a = r6;
        d r11 = new d(r3, r10);
        Intrinsics.checkNotNullParameter(r11, "callback");
        r3.b = r11;
        if (r2 == null) goto L8;
        y80.a r12 = r2.a;
        if (r12 == null) goto L9;
        r12.a(r3.getContext(), r3);
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

    public final void verify(Activity r9, String r10, String r11, Bundle r12, ILiveService.OnWalletVerifyCallBack r13, Map<String, String> r14, boolean r15) {
        if (TextUtils.isEmpty(r11) == false) goto L9;
        IUserService r0 = jc1.k.f(IUserService.class);
        if (r0 == null) goto L9;
        if (r0.user().isLogin() == false) goto L9;
        r11 = r0.user().a(r0.user().n());
    L9:
        com.bytedance.android.live.core.verify.utils.a.p(r9, null, r10, r11, r12, new b(r13), new c(r14), r15);
    }

    public final void sendLiveAdLogForSaas(String r6, String r7, String r8, String r9, String r10, String r11, String r12, Map<String, String> r13) {
        Intrinsics.checkNotNullParameter(r6, "event");
        Intrinsics.checkNotNullParameter(r7, "label");
        Intrinsics.checkNotNullParameter(r8, "refer");
        Intrinsics.checkNotNullParameter(r12, "logExtra");
        Intrinsics.checkNotNullParameter(r13, "adExtraData");
        int r4 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.c.a;
        Intrinsics.checkNotNullParameter(SourceType.ANCHOR, "event");
        Intrinsics.checkNotNullParameter(r7, "label");
        Intrinsics.checkNotNullParameter(r8, "refer");
        Intrinsics.checkNotNullParameter(r12, "logExtra");
        Intrinsics.checkNotNullParameter(r13, "adExtraData");
        ILiveDouPlusService r14 = jc1.k.n(ILiveDouPlusService.class);
        HashMap r0 = new HashMap();
        r0.put("refer", r8);
        r0.put("value", r10);
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        r0.put("creativeId", r11);
        r0.put("groupId", r9);
        r0.put("log_extra", r12);
        r0.put("ad_extra_data", r13.toString());
        r14.logEvent(true, SourceType.ANCHOR, r7, r0);
    }
}
