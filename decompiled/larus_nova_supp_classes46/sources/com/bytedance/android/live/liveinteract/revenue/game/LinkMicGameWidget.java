package com.bytedance.android.live.liveinteract.revenue.game;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayExternalContext;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayGuestType;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget;
import com.bytedance.android.live.liveinteract.plantform.api.LinkProfitApi;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.revenue.game.linker.GameRtcRoomController;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.live.liveinteract.videotalk.utils.b0;
import com.bytedance.android.live.liveinteract.wrds.LinkWRDSHelper;
import com.bytedance.android.live.network.response.EnterRoomInfoResult;
import com.bytedance.android.livesdk.chatroom.model.interact.k0;
import com.bytedance.android.livesdk.chatroom.model.interact.p2;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.message.model.rm;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.wrds.LinkMicRoomDataSyncModel;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import hh1.t0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import sh0.z;
import uf2.m1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/game/LinkMicGameWidget;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/playmode/AbsPlayModeWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lvlc/l;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkMicGameWidget extends AbsPlayModeWidget implements Observer<KVData>, vlc.l {
    public static final /* synthetic */ int w = 0;
    public vlc.d a;
    public com.bytedance.android.live.liveinteract.revenue.game.e b;
    public com.bytedance.android.live.liveinteract.revenue.game.a c;
    public si0.b d;
    public ni0.a e;
    public boolean f;
    public boolean g;
    public GameRtcRoomController h;
    public Disposable i;
    public boolean j;
    public com.bytedance.android.live.broadcastgame.api.xplay.f k;
    public long l;
    public Disposable m;
    public long n;
    public Disposable o;
    public final CompositeDisposable p;
    public final Handler q;
    public o r;
    public final b s;
    public boolean t;
    public final d u;
    public final c v;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ LinkMicGameWidget a;

        public b(LinkMicGameWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LinkMicGameWidget r0 = this.a;     // Catch: Throwable -> L4
            int r1 = LinkMicGameWidget.w;     // Catch: Throwable -> L4
            r0.Bq(true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements g10.a {
        public final /* synthetic */ LinkMicGameWidget a;

        public static final class a implements com.bytedance.android.live.broadcastgame.api.xplay.h {
            public final /* synthetic */ c a;

            public final void onDestroyView() {
                qi0.d r0 = qi0.d.a;
                LinkMicGameWidget r1 = this.a.a;
                int r2 = LinkMicGameWidget.w;
                com.bytedance.android.live.liveinteract.utils.n.a.a(r0, r1.isAnchor(), "camera_display_on_destroy_view", null, 12);
                si0.b r3 = this.a.a.d;
                if (r3 == null) goto L6;
                r3.d();
                return;
            }

            public a(c r1) {
                this.a = r1;
            }

            public final void b(ViewGroup r6) {
                Intrinsics.checkNotNullParameter(r6, "parentView");
                qi0.d r0 = qi0.d.a;
                LinkMicGameWidget r1 = this.a.a;
                int r2 = LinkMicGameWidget.w;
                com.bytedance.android.live.liveinteract.utils.n.a.a(r0, r1.isAnchor(), "camera_display_on_create_view", null, 12);
                si0.b r3 = this.a.a.d;
                if (r3 == null) goto L6;
                r3.a(r6);
                return;
            }
        }

        public final boolean isEnable() {
            if (((Boolean) vm2.d.v3.getValue(null, vm2.d.a[227(0xe3, float:3.18E-43)])).booleanValue() == false) goto L8;
            int r0 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.a;
            if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(TalkRoomLogUtils.o) == false) goto L8;
            ALogger.i("LinkMicGameWidget", "disable XplayCameraDisplayProvider, cause: broadcast game");
            return false;
        L8:
            LinkMicGameWidget r1 = this.a;
            long r3 = r1.n;
            if (r3 != 16) goto L11;
        L19:
            ALogger.i("LinkMicGameWidget", "disable XplayCameraDisplayProvider, cause: uiLayout not support");
            return false;
        L11:
            if (r3 == 65) goto L19;
            if (r1.isAnchor() == true) goto L17;
            ALogger.i("LinkMicGameWidget", "disable XplayCameraDisplayProvider, cause: guest not support");
            return false;
        L17:
            ALogger.i("LinkMicGameWidget", "enable XplayCameraDisplayProvider");
            return true;
        }

        public c(LinkMicGameWidget r1) {
            this.a = r1;
        }

        public final com.bytedance.android.live.broadcastgame.api.xplay.h e(com.bytedance.android.live.broadcastgame.api.xplay.f r2) {
            Intrinsics.checkNotNullParameter(r2, "instance");
            return new a(this);
        }
    }

    public static final class d implements g10.d {
        public final /* synthetic */ LinkMicGameWidget a;

        public d(LinkMicGameWidget r1) {
            this.a = r1;
        }

        public final void a(com.bytedance.android.live.broadcastgame.api.xplay.f r3) {
            Intrinsics.checkNotNullParameter(r3, "instance");
            Intrinsics.checkNotNullParameter(r3, "instance");
            LinkMicGameWidget.xq(this.a, r3, false);
        }

        public final void d(com.bytedance.android.live.broadcastgame.api.xplay.f r6) {
            Intrinsics.checkNotNullParameter(r6, "instance");
            Intrinsics.checkNotNullParameter(r6, "instance");
            LinkMicGameWidget r7 = this.a;
            int r0 = LinkMicGameWidget.w;
            r7.getClass();
            ALogger.i("LinkMicGameWidget", "onInstanceDestroy");
            com.bytedance.android.live.liveinteract.utils.n.a.a(qi0.d.a, r7.isAnchor(), "xplay_instance_destroy", null, 12);
            r7.Bq(false);
            r7.k = null;
            Disposable r1 = r7.o;
            if (r1 == null) goto L5;
            r1.dispose();
        L5:
            r7.o = null;
            MainThreadPostUtils.d(r7.s);
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            ALogger.i("LinkMicGameWidget", "update clearScreen: " + r4);
            xs2.b.a().post(new com.bytedance.android.livesdk.event.d(r4.booleanValue()));
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ LinkMicGameWidget a;

        public f(LinkMicGameWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            d10.e r5 = (d10.e) r4;
            ALogger.i("LinkMicGameWidget", "received MultiLinkGameStartEvent: " + r5.a);
            LinkMicGameWidget r0 = this.a;
            long r1 = r5.a;
            int r6 = LinkMicGameWidget.w;
            r0.Aq(r1);
        }
    }

    public static final class g<T> implements Consumer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final void accept(Object r3) {
            ALogger.e("LinkMicGameWidget", "received MultiLinkGameStartEvent", (Throwable) r3);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ LinkMicGameWidget a;

        public h(LinkMicGameWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            IRoomLinkMicSyncData r8 = (IRoomLinkMicSyncData) r7;
            boolean r9 = qi0.e.d();
            if (r9 == this.a.f) goto L5;
            ALogger.i("LinkMicGameWidget", "update isInAnchorLinkPlayMode: " + r9);
            this.a.f = r9;
            boolean r0 = qi0.e.b();
            com.bytedance.android.live.broadcastgame.api.xplay.n.b.updateEnableAudioFrame(r0);
            ALogger.i("LinkMicGameWidget", "update isInAnchorLinkPlayMode: " + r9 + ", enableAudioFrame: " + r0);
        L5:
            boolean r1 = qi0.e.e();
            LinkMicGameWidget r3 = this.a;
            if (r1 == r3.g) goto L9;
            r3.g = r1;
            boolean r4 = qi0.e.b();
            com.bytedance.android.live.broadcastgame.api.xplay.n.b.updateEnableAudioFrame(r4);
            ALogger.i("LinkMicGameWidget", "update isInServerMerge: " + r1 + ", enableAudioFrame: " + r4);
        L9:
            if (r9 == false) goto L15;
            com.bytedance.live.datacontext.j r10 = com.bytedance.android.live.liveinteract.api.utils.m.e(this.a).J();
            if (r10 == null) goto L21;
            LivePlayModeLogContext r11 = (LivePlayModeLogContext) r10.getValue();
            if (r11 == null) goto L22;
            r11.addPlayMode(38);
            return;
        L22:
            return;
        L21:
            return;
        L15:
            com.bytedance.live.datacontext.j r12 = com.bytedance.android.live.liveinteract.api.utils.m.e(this.a).J();
            if (r12 == null) goto L24;
            LivePlayModeLogContext r13 = (LivePlayModeLogContext) r12.getValue();
            if (r13 == null) goto L25;
            r13.removePlayMode(38);
            return;
        L25:
            return;
        }
    }

    static {
    }

    @Override // xh0.b
    public final ArrayList<xh0.f> getIncompatibleSourceList() {
        return null;
    }

    @Override // xh0.b
    public final void tryStartPlayMode(HashMap<String, Object> r1) {
    }

    @Override // xh0.b
    public final void tryStopPlayMode(HashMap<String, Object> r1) {
    }

    @Override // xh0.b
    public final xh0.h getPlayModeInfo() {
        return new xh0.h(31, s1.B(2131916747));
    }

    public final IRoom getRoom() {
        return a0.n(((Widget) this).dataCenter);
    }

    public final boolean isAnchor() {
        return a0.d(((Widget) this).dataCenter, false);
    }

    @Override // xh0.b
    public final boolean isOpen() {
        com.bytedance.android.live.liveinteract.revenue.game.e r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.a != true) goto L7;
        return true;
    }

    public LinkMicGameWidget() {
        this.f = qi0.e.d();
        this.g = qi0.e.e();
        this.p = new CompositeDisposable();
        this.q = new Handler(Looper.getMainLooper());
        this.s = new b(this);
        this.u = new d(this);
        this.v = new c(this);
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        ALogger.i("LinkMicGameWidget", "onCreate");
        if (isAnchor() == false) goto L5;
        com.bytedance.android.live.broadcastgame.api.xplay.n.b.a();
    L5:
        vlc.d r1 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager");
        this.a = r1;
        if (r1 == null) goto L8;
        r1.addMessageListener(MessageType.UPDATE_GAME_SCORE_MESSAGE.getIntType(), this);
    L8:
        Pair r2 = com.bytedance.live.datacontext.d.a(LinkMicGameWidget$initDataContext$pair$1.INSTANCE);
        LinkMicGameContext r3 = (LinkMicGameContext) r2.getFirst();
        r3.getWidget().d(this);
        com.bytedance.live.datacontext.b.a(r3, com.bytedance.android.live.liveinteract.revenue.game.d.class);
        this.p.add((Disposable) r2.getSecond());
        ((Widget) this).dataCenter.observe("data_linkmic_game_state", this);
        ((Widget) this).dataCenter.observe("data_hide_screen", this);
        getStore().d(sh0.a0.b, new com.bytedance.android.live.liveinteract.revenue.game.h()).d(z.b, new i(this));
        this.c = new com.bytedance.android.live.liveinteract.revenue.game.a(((Widget) this).context, getStore(), ((Widget) this).dataCenter, isAnchor());
        if (isAnchor() == false) goto L11;
        si0.b r4 = new si0.c(((Widget) this).context, getStore(), ((Widget) this).dataCenter, this);
    L12:
        this.d = r4;
        r4.onCreate();
        Disposable r5 = null;
        if (isAnchor() == true) goto L57;
        z5 r6 = getRoom().getLinkerDetail();
        if (r6 == null) goto L56;
        List r7 = r6.getPlayModes();
        if (r7 == null) goto L56;
        if (r7.contains(Long.valueOf(31)) != true) goto L56;
        this.l = System.currentTimeMillis();
        if (isAnchor() == true) goto L34;
        DataCenter r8 = ((Widget) this).dataCenter;
        if (r8 == null) goto L25;
        EnterRoomInfoResult r9 = (EnterRoomInfoResult) r8.get("data_room_enter_info", null);
    L26:
        if (r9 == null) goto L30;
        p2 r10 = r9.getLinkmicPlayModeInfo();
        if (r10 == null) goto L30;
        k0 r11 = r10.getLinkMicGameInfo();
    L31:
        onPreEnterConsume(r9);
        if (r11 == null) goto L34;
        ALogger.i("LinkMicGameWidget", "[preEnterRoom] has got linkMicGameInfo from enter info, no need to fetch again");
    L30:
        r11 = null;
        goto L31
    L25:
        r9 = null;
    L34:
        int r12 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r13 = ((Widget) this).dataCenter;
        IRoom r14 = getRoom();
        if (r14 == null) goto L37;
        Long r15 = Long.valueOf(r14.getId());
    L38:
        MultiSceneEnterRoomStatisticsUtils r16 = MultiSceneEnterRoomStatisticsUtils.a.a(r13, Long.valueOf(r15.longValue()));
        if (r16 == null) goto L41;
        r16.k(31, false);
    L41:
        DataCenter r17 = ((Widget) this).dataCenter;
        IRoom r18 = getRoom();
        if (r18 == null) goto L44;
        Long r19 = Long.valueOf(r18.getId());
    L45:
        MultiSceneEnterRoomStatisticsUtils r20 = MultiSceneEnterRoomStatisticsUtils.a.a(r17, Long.valueOf(r19.longValue()));
        if (r20 == null) goto L48;
        r20.l(31, false);
    L48:
        DataCenter r21 = ((Widget) this).dataCenter;
        IRoom r22 = getRoom();
        if (r22 == null) goto L51;
        Long r23 = Long.valueOf(r22.getId());
    L52:
        MultiSceneEnterRoomStatisticsUtils r24 = MultiSceneEnterRoomStatisticsUtils.a.a(r21, Long.valueOf(r23.longValue()));
        if (r24 == null) goto L55;
        r24.j(null);
    L55:
        ALogger.i("LinkMicGameWidget", "[preEnterRoom] [fetchGameInfo] try fetch");
        setMGetPlayModeInfoDisposable(((LinkProfitApi) com.bytedance.android.live.network.c.b().e(LinkProfitApi.class)).getPlayModeInfo(getRoom().getId(), true).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.live.liveinteract.revenue.game.f(this), com.bytedance.android.live.liveinteract.revenue.game.g.a));
        goto L57
    L51:
        r23 = null;
        goto L52
    L44:
        r19 = null;
        goto L45
    L37:
        r15 = null;
    L56:
        removePreGetEnterInfoObserver();
    L57:
        com.bytedance.android.live.liveinteract.revenue.game.e r25 = (com.bytedance.android.live.liveinteract.revenue.game.e) ((Widget) this).dataCenter.get("data_linkmic_game_state", null);
        if (r25 == null) goto L60;
        this.b = r25;
        yq(r25);
    L60:
        com.bytedance.android.live.broadcastgame.api.xplay.n r26 = com.bytedance.android.live.broadcastgame.api.xplay.n.b;
        r26.h(this.u);
        r26.h(this.v);
        IGameDataService r27 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r27 == null) goto L67;
        com.bytedance.live.datacontext.m r28 = r27.getClearScreen();
        if (r28 == null) goto L67;
        Observable r29 = r28.a();
        if (r29 == null) goto L67;
        r5 = r29.subscribe(e.a);
    L67:
        this.i = r5;
        this.m = xs2.b.a().c(d10.e.class).subscribe(new f(this), g.a);
        LinkMicRoomDataSyncModel r30 = LinkWRDSHelper.b();
        if (r30 == null) goto L77;
        dc2.c r31 = r30.getTalkRoomListUserInfoPb();
        if (r31 == null) goto L77;
        Observable r32 = r31.d;
        if (r32 == null) goto L77;
        Disposable r33 = r32.subscribe(new h(this));
        if (r33 == null) goto L77;
        this.p.add(r33);
    L77:
        if (isAnchor() == false) goto L79;
        GameRtcRoomController r34 = new com.bytedance.android.live.liveinteract.revenue.game.linker.a(this);
    L80:
        this.h = r34;
        r34.attach();
        ALogger.i("LinkMicGameWidget", "initXplayState");
        if (isAnchor() == false) goto L87;
        com.bytedance.android.live.broadcastgame.api.xplay.f r35 = r26.n();
        cg6.a r36 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r36 == null) goto L87;
        vb6.g r37 = r36.O5();
        if (r37 == null) goto L87;
        r37.X0(new j(this, r35), false);
    L87:
        com.bytedance.android.livesdk.sharedpref.e r38 = b6.y;
        Pair r39 = (Pair) r38.getValue();
        int r40 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.a;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d((String) r39.getFirst()) == false) goto L97;
        String r41 = "sslocal://webcast_open_danmu_game?app_id=" + ((String) r39.getFirst()) + "&action_type=open_game";
        IBaseLiveActionHandler r42 = jc1.k.f(IBaseLiveActionHandler.class);
        if (r42 == null) goto L92;
        r42.handle(((Widget) this).context, r41);
    L92:
        com.bytedance.android.livesdk.sharedpref.f.d(r38, new Pair("", ""));
        IInteractService r43 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r43 == null) goto L97;
        com.bytedance.android.live.liveinteract.utils.n r44 = r43.getLinkMicGameTraceUtils();
        if (r44 == null) goto L97;
        r44.a(true, "broadcast_open_game_really_open", 0, " multiLinkGameId=" + ((String) r39.getFirst()) + ", multiLinkGameName=" + ((String) r39.getSecond()));
    L97:
        ALogger.i("LinkMicGameWidget", "initGroupLiveGame");
        DataCenter r45 = ((Widget) this).dataCenter;
        ni0.a r0 = new ni0.a(r45);
        this.e = r0;
        ALogger.i("GroupLiveGameController", "onCreate, GroupLiveGameContext=" + com.bytedance.android.live.liveinteract.revenue.game.c.d);
        if (qi0.e.c() == true) goto L100;
        return;
    L100:
        if (je0.d.D() == true) goto L114;
        if (r45 == null) goto L115;
        Room r46 = com.bytedance.android.live.core.utils.z.o(r45);
        if (r46 != null) goto L105;
        return;
    L105:
        if (r46.isPrivatePlay() != true) goto L117;
        ALogger.i("GroupLiveGameController", "startDetectOnlineTask");
        long r47 = r0.c;
        if (r47 <= 0) goto L110;
        r0.h = Observable.interval(r47, r47, TimeUnit.MILLISECONDS).take(Long.MAX_VALUE).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ni0.b(r0), ni0.c.a, ni0.d.a);
    L110:
        if (r0.d == false) goto L118;
        hd0.c.f().c(r0.b);
        return;
    L118:
        return;
    L117:
        return;
    L115:
        return;
    L114:
        return;
    L79:
        r34 = new com.bytedance.android.live.liveinteract.revenue.game.linker.b(this);
        goto L80
    L11:
        r4 = new si0.d(((Widget) this).context, getStore(), ((Widget) this).dataCenter);
        goto L12
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget, com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        super.onDestroy();
        ALogger.i("LinkMicGameWidget", "onDestroy");
        if (this.j == false) goto L19;
        this.j = false;
        IGameDataService r2 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r2 == null) goto L11;
        com.bytedance.live.datacontext.m r3 = r2.getClearScreen();
        if (r3 == null) goto L11;
        boolean r4 = true;
        if (((Boolean) r3.getValue()).booleanValue() != true) goto L11;
    L12:
        if (r4 == false) goto L19;
        ALogger.d("LinkMicGameWidget", "resetCleanMode");
        IGameDataService r0 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r0 == null) goto L18;
        com.bytedance.live.datacontext.m r1 = r0.getClearScreen();
        if (r1 == null) goto L18;
        r1.setValue(Boolean.FALSE);
    L18:
        xs2.b.a().post(new com.bytedance.android.livesdk.event.d(false));
    L11:
        r4 = false;
    L19:
        o r5 = this.r;
        if (r5 == null) goto L22;
        this.q.removeCallbacks(r5);
        this.r = null;
    L22:
        ((Widget) this).dataCenter.removeObserver(this);
        com.bytedance.android.live.liveinteract.revenue.game.a r6 = this.c;
        if (r6 == null) goto L28;
        com.bytedance.android.live.liveinteract.revenue.game.e r7 = r6.a;
        if (r7 == null) goto L27;
        r7.i = 3;
    L27:
        r6.a(false);
    L28:
        si0.b r8 = this.d;
        if (r8 == null) goto L31;
        r8.onDestroy();
    L31:
        GameRtcRoomController r9 = this.h;
        if (r9 == null) goto L34;
        r9.detach();
    L34:
        this.b = null;
        ne0.c r10 = getStore();
        if (r10 == null) goto L37;
        r10.onDestory();
    L37:
        Disposable r11 = this.i;
        if (r11 == null) goto L40;
        r11.dispose();
    L40:
        Disposable r12 = this.o;
        if (r12 == null) goto L43;
        r12.dispose();
    L43:
        Disposable r13 = this.m;
        if (r13 == null) goto L46;
        r13.dispose();
    L46:
        com.bytedance.android.live.broadcastgame.api.xplay.n r14 = com.bytedance.android.live.broadcastgame.api.xplay.n.b;
        r14.f(this.u);
        r14.m(XplayScene.Video);
        r14.f(this.v);
        r14.d();
        r14.g();
        MainThreadPostUtils.d(this.s);
        this.p.dispose();
        ((Widget) this).dataCenter.put("data_linkmic_game_switch", Boolean.FALSE);
        ni0.a r15 = this.e;
        if (r15 == null) goto L58;
        ALogger.i("GroupLiveGameController", "onDestroy");
        if (je0.d.D() == false) goto L51;
        String r16 = com.bytedance.android.live.liveinteract.revenue.game.c.a;
    L51:
        com.bytedance.android.live.liveinteract.revenue.game.c.a = null;
        com.bytedance.android.live.liveinteract.revenue.game.c.b = null;
        com.bytedance.android.live.liveinteract.revenue.game.c.c = null;
        ((LinkedHashMap) ni0.e.c).clear();
        r15.f.d(ToolbarButton.INTERACT_PLAY_FOR_GROUP_LIVE_GAME, r15.g);
        Disposable r17 = r15.h;
        if (r17 == null) goto L55;
        ALogger.i("GroupLiveGameController", "stopDetectOnlineTask");
        r17.dispose();
    L55:
        if (r15.d == false) goto L59;
        hd0.c.f().e(r15.b);
        return;
    L59:
        return;
    }

    public final void Aq(long r3) {
        ALogger.i("LinkMicGameWidget", "update targetUiLayout: " + r3);
        LinkMicGameContext r0 = LinkMicGameContext.Companion.getContext();
        if (r0 == null) goto L5;
        r0.setTargetUiLayout(r3);
    L5:
        this.n = r3;
    }

    public final void Bq(boolean r24) {
        String r1 = "updateXplayState, isXplayRunning: " + r24 + ", isFromInit: " + this.t;
        ALogger.i("LinkMicGameWidget", r1);
        com.bytedance.android.live.liveinteract.utils.n.a.a(qi0.d.a, isAnchor(), "updateXplayState", r1, 4);
        tf0.o r2 = b0.e();
        if (r2 == null) goto L5;
        ViewGroup r3 = r2.getFirstSeatVHShadowContainer();
    L6:
        tf0.o r4 = b0.e();
        if (r4 == null) goto L9;
        ViewGroup r5 = r4.getFirstSeatVHShadowFloatContainer();
    L10:
        boolean r11 = false;
        if (isAnchor() == false) goto L41;
        com.bytedance.android.live.liveinteract.plantform.base.a.g0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.a r6 = com.bytedance.android.live.liveinteract.plantform.base.a.C0047a.a();
        if (r6 == null) goto L15;
        hg6.g r7 = r6.R1();
    L17:
        if (this.j == true) goto L20;
        if (r24 == false) goto L20;
        f2.c(s1.B(2131920821), 0);
    L20:
        XplayExternalContext r8 = XplayExternalContext.Companion.getContext();
        if (r8 == null) goto L25;
        com.bytedance.live.datacontext.n r9 = r8.getInteractPlayContainer();
        if (r9 == null) goto L25;
        ViewGroup r10 = (ViewGroup) r9.getValue();
    L26:
        si0.b r12 = this.d;
        if (r12 == null) goto L30;
        r12.c(new si0.b.a(r24, r3, r5, r10, r7), this.k);
    L30:
        if (this.t == false) goto L58;
        if (r24 == false) goto L58;
        com.bytedance.android.live.broadcastgame.api.xplay.f r13 = this.k;
        if (r13 == null) goto L37;
        com.bytedance.android.live.broadcastgame.api.xplay.d r14 = (com.bytedance.android.live.broadcastgame.api.xplay.d) r13.getService(com.bytedance.android.live.broadcastgame.api.xplay.d.class);
        if (r14 == null) goto L37;
        Boolean r15 = r14.g();
    L39:
        if (Intrinsics.areEqual(r15, Boolean.TRUE) == false) goto L58;
        com.bytedance.android.live.liveinteract.utils.l.a.a(qi0.a.j, LinkMonitorData.XplayShowAndFirstFrameSuccess, null, null, 0, null, null, null, null, null, 510);
    L37:
        r15 = null;
    L58:
        this.j = r24;
        if (LinkMicGameContext.Companion.c() == true) goto L65;
        ALogger.i("LinkMicGameWidget", "tryAutoChangeCleanScreenStatus return, cause: disable XplayFloatWindow");
        IGameDataService r16 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r16 == null) goto L109;
        com.bytedance.live.datacontext.m r17 = r16.getClearScreen();
        if (r17 == null) goto L109;
        r17.setValue(Boolean.FALSE);
    L109:
        GameRtcRoomController r18 = this.h;
        if (r18 == null) goto L113;
        r18.a(r24);
        return;
    L113:
        return;
    L65:
        IGameDataService r19 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r19 == null) goto L72;
        com.bytedance.live.datacontext.m r20 = r19.getClearScreen();
        if (r20 == null) goto L72;
        if (((Boolean) r20.getValue()).booleanValue() != true) goto L72;
        boolean r21 = true;
    L73:
        ALogger.i("LinkMicGameWidget", "tryAutoChangeCleanScreenStatus, isXplayRunning: " + r24 + ", isCleanMode: " + r21 + ", isFromInit: " + this.t);
        if (r24 == true) goto L76;
        IGameDataService r22 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r22 == null) goto L103;
        com.bytedance.live.datacontext.m r23 = r22.getClearScreen();
        if (r23 == null) goto L103;
        if (((Boolean) r23.getValue()).booleanValue() != true) goto L103;
        r11 = true;
    L103:
        if (r11 == false) goto L109;
        ALogger.i("LinkMicGameWidget", "tryAutoChangeCleanScreenStatus, close clearScreen");
        IGameDataService r25 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r25 == null) goto L109;
        com.bytedance.live.datacontext.m r26 = r25.getClearScreen();
        if (r26 == null) goto L109;
        r26.setValue(Boolean.FALSE);
        goto L109
    L76:
        if (this.t == false) goto L78;
        ALogger.i("LinkMicGameWidget", "tryAutoChangeCleanScreenStatus return, cause: mIsFromInit is true");
        xs2.b.a().post(new com.bytedance.android.livesdk.event.d(r21));
        goto L109
    L78:
        rs1.a r27 = (rs1.a) vm2.d.x1.getValue(null, vm2.d.a[125(0x7d, float:1.75E-43)]);
        if (isAnchor() == false) goto L88;
        if (r27 == null) goto L109;
        if (r27.c() != true) goto L109;
        ALogger.i("LinkMicGameWidget", "tryAutoChangeCleanScreenStatus, open clearScreen");
        IGameDataService r28 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r28 == null) goto L109;
        com.bytedance.live.datacontext.m r29 = r28.getClearScreen();
        if (r29 == null) goto L109;
        r29.setValue(Boolean.TRUE);
        goto L109
    L88:
        if (r27 == null) goto L109;
        if (r27.d() != true) goto L109;
        ALogger.i("LinkMicGameWidget", "tryAutoChangeCleanScreenStatus, open clearScreen");
        IGameDataService r30 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r30 == null) goto L109;
        com.bytedance.live.datacontext.m r31 = r30.getClearScreen();
        if (r31 == null) goto L109;
        r31.setValue(Boolean.TRUE);
    L72:
        r21 = false;
    L25:
        r10 = null;
        goto L26
    L15:
        r7 = null;
        goto L17
    L41:
        if (r24 == false) goto L49;
        com.bytedance.android.live.broadcastgame.api.xplay.f r32 = this.k;
        if (r32 == null) goto L45;
        XplayGuestType r33 = r32.a();
    L47:
        if (r33 == XplayGuestType.SILENCE) goto L49;
        f2.c(s1.B(2131920853), 0);
        goto L49
    L45:
        r33 = null;
    L49:
        XplayExternalContext r34 = XplayExternalContext.Companion.getContext();
        if (r34 == null) goto L54;
        com.bytedance.live.datacontext.n r35 = r34.getInteractPlayContainer();
        if (r35 == null) goto L54;
        ViewGroup r36 = (ViewGroup) r35.getValue();
    L55:
        si0.b r110 = this.d;
        if (r110 == null) goto L58;
        r110.c(new si0.b.a(r24, r3, r5, r36, null), this.k);
    L54:
        r36 = null;
        goto L55
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        String r0 = null;
        if (r6 == null) goto L5;
        String r1 = r6.getKey();
    L7:
        if (Intrinsics.areEqual(r1, "data_linkmic_game_state") == false) goto L22;
        com.bytedance.android.live.liveinteract.revenue.game.e r7 = (com.bytedance.android.live.liveinteract.revenue.game.e) r6.getData();
        if (r7 == null) goto L45;
        com.bytedance.android.live.liveinteract.revenue.game.e r2 = this.b;
        if (r2 != null) goto L14;
    L21:
        this.b = r7;
        yq(r7);
        return;
    L14:
        if (r2.a != true) goto L21;
        if (r7.a == true) goto L21;
        r7.h = r2.h;
        LinkMicGameContext r3 = LinkMicGameContext.Companion.getContext();
        if (r3 == null) goto L20;
        r3.setGameScores(null);
    L20:
        getStore().d0(ti0.a.b, null);
        goto L21
    L45:
        return;
    L22:
        if (r6 == null) goto L25;
        r0 = r6.getKey();
    L25:
        if (Intrinsics.areEqual(r0, "data_hide_screen") == true) goto L27;
        return;
    L27:
        if (this.j == true) goto L29;
        return;
    L29:
        if (isAnchor() == true) goto L42;
        Boolean r8 = (Boolean) r6.getData();
        if (r8 == null) goto L46;
        boolean r9 = r8.booleanValue();
        IGameDataService r4 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r4 == null) goto L43;
        com.bytedance.live.datacontext.m r10 = r4.getClearScreen();
        if (r10 == null) goto L44;
        r10.setValue(Boolean.valueOf(r9));
        return;
    L44:
        return;
    L43:
        return;
    L46:
        return;
    L42:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void onMessage(tlc.d r5) {
        if ((r5 instanceof rm) == false) goto L29;
        StringBuilder r0 = new StringBuilder("onMessage getGameOpenInfo :");
        r0.append(this.b);
        r0.append(" message.appId:");
        rm r6 = (rm) r5;
        r0.append(r6.appId);
        r0.append(" message.gameStatus:");
        r0.append(r6.gameStatus);
        ALogger.i("LinkMicGameWidget", r0.toString());
        com.bytedance.android.live.liveinteract.revenue.game.e r1 = this.b;
        if (r1 != null) goto L7;
    L9:
        int r2 = r6.gameStatus;
        int r3 = rm.a;
        if (r2 != 2) goto L15;
        o r7 = this.r;
        if (r7 == null) goto L14;
        this.q.removeCallbacks(r7);
        this.r = null;
    L14:
        o r8 = new o(this);
        this.r = r8;
        Handler r4 = this.q;
        Intrinsics.checkNotNull(r8);
        r4.postDelayed(r8, 60000);
        return;
    L15:
        if (r2 != 1) goto L21;
        List r9 = r6.gameScores;
        if (r9 == null) goto L21;
        if (r9.isEmpty() != true) goto L21;
        return;
    L21:
        o r10 = this.r;
        if (r10 == null) goto L24;
        this.q.removeCallbacks(r10);
        this.r = null;
    L24:
        LinkMicGameContext r11 = LinkMicGameContext.Companion.getContext();
        if (r11 == null) goto L27;
        r11.setGameScores(r6.gameScores);
    L27:
        getStore().d0(ti0.a.b, r6.gameScores);
        return;
    L7:
        if ((!Intrinsics.areEqual(r1.b, r6.appId)) == false) goto L9;
        return;
    }

    public final void yq(com.bytedance.android.live.liveinteract.revenue.game.e r7) {
        if (Intrinsics.areEqual(r7.c, "danmu") == false) goto L68;
        ALogger.i("LinkMicGameWidget", "dispenseGameState: " + r7);
        Aq(r7.h);
        if (isAnchor() == false) goto L7;
        com.bytedance.android.live.liveinteract.utils.n.a.a(qi0.d.a, isAnchor(), "dispenseGameState", "dispenseGameState: " + r7, 4);
    L7:
        com.bytedance.android.live.liveinteract.revenue.game.a r0 = this.c;
        if (r0 == null) goto L10;
        Intrinsics.checkNotNullParameter(r7, "state");
        r0.a = r7;
        ne0.c r1 = r0.d;
        int r3 = ti0.e.a;
        r1.b("linkmic_game_state", r7);
        r0.a(r7.a);
    L10:
        si0.b r2 = this.d;
        if (r2 == null) goto L14;
        r2.b(r7.a);
    L14:
        if (r7.a == false) goto L24;
        vlc.d r4 = this.a;
        if ((r4 instanceof xlc.a) == true) goto L18;
        r4 = null;
    L18:
        xlc.a r5 = (xlc.a) r4;
        if (r5 == null) goto L21;
        tlc.d r6 = r5.u(MessageType.UPDATE_GAME_SCORE_MESSAGE.getIntType());
    L22:
        ALogger.i("LinkMicGameWidget", "dispenseGameState lastWrdsData: " + r6);
        onMessage(r6);
        goto L24
    L21:
        r6 = null;
    L24:
        if (hd0.c.f().h() == false) goto L40;
        rj0.l.n2.getClass();
        rj0.l r8 = rj0.l.a.a();
        if (r8 == null) goto L40;
        uf2.z.a r9 = r8.c3(tc0.c.h().f());
        if (r9 == null) goto L40;
        m1.b r10 = r9.Y();
        com.bytedance.android.live.liveinteract.revenue.game.e r11 = this.b;
        if (r11 == null) goto L32;
        boolean r12 = r11.a;
    L32:
        if (r10 == null) goto L34;
        r10.g();
    L34:
        r9.b();
        StringBuilder r13 = new StringBuilder("updateAnchorLayer, mode: ");
        if (r10 == null) goto L37;
        Integer r14 = Integer.valueOf(r10.getMode());
    L38:
        r13.append(r14);
        ALogger.i("LinkMicGameWidget", r13.toString());
        goto L40
    L37:
        r14 = null;
    L40:
        if (isAnchor() == true) goto L50;
        if (((Boolean) vm2.d.A3.getValue(null, vm2.d.a[232(0xe8, float:3.25E-43)])).booleanValue() == false) goto L50;
        ALogger.i("LinkMicGameWidget", "updateLinkWindowLayoutConfig");
        if (rj0.l.n2 == null) goto L50;
        rj0.l r15 = rj0.l.a.a();
        if (r15 == null) goto L50;
        r15.se();
    L50:
        if (r7.a == true) goto L55;
        GameRtcRoomController r16 = this.h;
        if (r16 == null) goto L55;
        r16.k();
    L55:
        if (r7.a == false) goto L61;
        com.bytedance.live.datacontext.j r17 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).J();
        if (r17 == null) goto L66;
        LivePlayModeLogContext r18 = (LivePlayModeLogContext) r17.getValue();
        if (r18 == null) goto L66;
        r18.addPlayMode(31);
    L66:
        ((Widget) this).dataCenter.put("data_linkmic_game_switch", Boolean.valueOf(r7.a));
        return;
    L61:
        com.bytedance.live.datacontext.j r19 = com.bytedance.android.live.liveinteract.api.utils.m.e(this).J();
        if (r19 == null) goto L66;
        LivePlayModeLogContext r20 = (LivePlayModeLogContext) r19.getValue();
        if (r20 == null) goto L66;
        r20.removePlayMode(31);
        goto L66
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.AbsPlayModeWidget
    public final void onPreGetEnterInfo(EnterRoomInfoResult r5, boolean r6) {
        if (r5 == null) goto L7;
        p2 r1 = r5.getLinkmicPlayModeInfo();
        if (r1 == null) goto L7;
        k0 r2 = r1.getLinkMicGameInfo();
    L8:
        if (r2 != null) goto L10;
        return;
    L10:
        if (r6 == false) goto L12;
        ALogger.i("PlayMode_PreEnter_Listen", "onAsyncGetEnterInfo--弹幕玩法命中预加载异步到达");
    L13:
        onPreGetEnterInfoUniversal(31);
        zq(r2, "onPreGetEnterInfo isAsync=" + r6);
        p2 r7 = r5.getLinkmicPlayModeInfo();
        if (r7 == null) goto L18;
        r7.setLinkMicGameInfo(null);
        return;
    L18:
        return;
    L12:
        ALogger.i("PlayMode_PreEnter_Listen", "onAsyncGetEnterInfo--弹幕玩法命中预加载提前到达");
    L7:
        r2 = null;
        goto L8
    }

    public final void zq(k0 r14, String r15) {
        ALogger.i("LinkMicGameWidget", "onFetchGameInfo, duration: " + (System.currentTimeMillis() - this.l) + ", source: " + r15);
        String r3 = r14.getGameId();
        String r4 = r14.getGameCategory();
        Integer r5 = Integer.valueOf(r14.getRunningType());
        Integer r6 = Integer.valueOf(r14.getPublicStreamType());
        Room r0 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getCurrentRoom();
        if (r0 == null) goto L7;
        z5 r1 = r0.getLinkerDetail();
        if (r1 == null) goto L7;
        int r2 = r1.getUiLayout();
    L8:
        com.bytedance.android.live.liveinteract.revenue.game.e r16 = new com.bytedance.android.live.liveinteract.revenue.game.e(true, r3, r4, r5, r6, null, null, r2, 0);
        this.b = r16;
        yq(r16);
        if (v.a() == false) goto L11;
        f2.i(((Widget) this).context, "【Debug】获取到弹幕玩法进房信息\ngameId: " + r14.getGameId(), 0);
    L11:
        int r17 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r18 = ((Widget) this).dataCenter;
        IRoom r19 = getRoom();
        if (r19 == null) goto L14;
        Long r110 = Long.valueOf(r19.getId());
    L15:
        MultiSceneEnterRoomStatisticsUtils r111 = MultiSceneEnterRoomStatisticsUtils.a.a(r18, Long.valueOf(r110.longValue()));
        if (r111 == null) goto L19;
        r111.i(null);
        return;
    L19:
        return;
    L14:
        r110 = null;
    L7:
        r2 = 0;
        goto L8
    }

    public static final void xq(LinkMicGameWidget r22, com.bytedance.android.live.broadcastgame.api.xplay.f r23, boolean r24) {
        r22.t = r24;
        r22.k = r23;
        boolean r4 = false;
        if (r22.isAnchor() == false) goto L21;
        if (r24 == true) goto L21;
        cg6.a r3 = r22.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r3 == null) goto L11;
        hg6.g r5 = r3.getRtcManager();
        if (r5 == null) goto L11;
        if (r5.isEngineOn() == true) goto L21;
    L11:
        ALogger.i("LinkMicGameWidget", "onXplayInstanceCreate -> joinChannel");
        cg6.a r6 = r22.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r6 == null) goto L16;
        com.bytedance.live.bizlink.impl.platform.manager.a r7 = r6.A0();
        if (r7 == null) goto L16;
        r7.g();
    L16:
        cg6.a r8 = r22.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r8 == null) goto L21;
        vb6.g r9 = r8.O5();
        if (r9 == null) goto L21;
        r9.X0(new k(r22, r23), false);
    L21:
        tf0.o r1 = b0.e();
        if (r1 == null) goto L26;
        t0 r2 = r1.C();
        if (r2 == null) goto L26;
        int r10 = r2.a();
    L28:
        if (r22.isAnchor() == true) goto L30;
    L32:
        boolean r11 = false;
    L33:
        String r12 = "onInstanceCreate, isFromInit: " + r24 + ", currentUiLayout: " + r10 + ", targetUiLayout: " + r22.n + ", needSwitchLayout: " + r11 + ", delay: " + vm2.d.R();
        ALogger.i("LinkMicGameWidget", r12);
        com.bytedance.android.live.liveinteract.utils.n.a.a(qi0.d.a, r22.isAnchor(), "xplay_instance_create", r12, 4);
        qi0.a r13 = qi0.a.j;
        com.bytedance.android.live.liveinteract.utils.l.a.a(r13, LinkMonitorData.XplayInstanceCreate, null, null, 0, null, null, null, null, null, 510);
        n r14 = new n(r22, r24);
        if (r11 == false) goto L63;
        Disposable r15 = r22.o;
        if (r15 == null) goto L38;
        r15.dispose();
    L38:
        com.bytedance.live.datacontext.m r16 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r16 == null) goto L45;
        IRoom r17 = (IRoom) r16.getValue();
        if (r17 == null) goto L45;
        if (r17.isLiveTypeAudio() != true) goto L45;
        r4 = true;
    L45:
        if (r4 == false) goto L53;
        com.bytedance.live.datacontext.j r18 = com.bytedance.android.live.liveinteract.api.utils.m.e(r22).s();
        if (r18 == null) goto L60;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r19 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r18.getValue();
        if (r19 == null) goto L60;
        BehaviorSubject r20 = r19.a();
        if (r20 == null) goto L60;
        Disposable r21 = r20.subscribe(new l(r22, r10, r14));
    L61:
        r22.o = r21;
        return;
    L60:
        r21 = null;
        goto L61
    L53:
        com.bytedance.live.datacontext.j r25 = com.bytedance.android.live.liveinteract.api.utils.m.e(r22).getVideoTalkRoomSubScene();
        if (r25 == null) goto L60;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r26 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r25.getValue();
        if (r26 == null) goto L60;
        BehaviorSubject r27 = r26.d();
        if (r27 == null) goto L60;
        r21 = r27.subscribe(new m(r22, r10, r14));
        goto L61
    L63:
        if (r22.isAnchor() == false) goto L65;
        com.bytedance.android.live.liveinteract.utils.l.a.a(r13, LinkMonitorData.CheckSwitchUiLayoutSuccess, null, null, 0, null, null, null, null, null, 510);
    L65:
        MainThreadPostUtils.c(r14, vm2.d.R());
        return;
    L30:
        if (r10 == r22.n) goto L32;
        r11 = true;
    L26:
        r10 = 0;
        goto L28
    }

    public static final void wq(LinkMicGameWidget r11, int r12, int r13, Runnable r14) {
        r11.getClass();
        String r15 = "afterSwitchUiLayoutObservable, currentUiLayout: " + r12 + ", targetUiLayout: " + r11.n + ", switchUiLayout: " + r13;
        ALogger.i("LinkMicGameWidget", r15);
        com.bytedance.android.live.liveinteract.utils.n.a.a(qi0.d.a, r11.isAnchor(), "switch_ui_layout", r15, 4);
        Integer r16 = Integer.valueOf(r13);
        int r17 = qi0.e.a;
        if (r16 != null) goto L6;
    L7:
        if (r16 != null) goto L10;
    L11:
        if (r16 != null) goto L14;
    L16:
        boolean r18 = false;
    L18:
        if (r18 == true) goto L20;
        return;
    L20:
        if (r11.isAnchor() == false) goto L22;
        com.bytedance.android.live.liveinteract.utils.l.a.a(qi0.a.j, LinkMonitorData.CheckSwitchUiLayoutSuccess, null, null, 0, null, null, null, null, null, 510);
    L22:
        Disposable r19 = r11.o;
        if (r19 == null) goto L25;
        r19.dispose();
    L25:
        r11.o = null;
        MainThreadPostUtils.c(r14, vm2.d.R());
        return;
    L14:
        if (r16.intValue() != 65) goto L16;
    L17:
        r18 = true;
        goto L18
    L10:
        if (r16.intValue() == 16) goto L17;
    L6:
        if (r16.intValue() == 15) goto L17;
        goto L7
    }
}
