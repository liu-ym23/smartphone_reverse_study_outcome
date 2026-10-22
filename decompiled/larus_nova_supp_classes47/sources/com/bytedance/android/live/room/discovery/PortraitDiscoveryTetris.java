package com.bytedance.android.live.room.discovery;

import android.view.View;
import com.bytedance.android.live.base.model.message.j5;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.y3;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.tetris.LivePriorityTetris;
import com.bytedance.android.live.core.tetris.layer.core.tetris.priority.JatoOptFrameLayoutVisibilityProxy;
import com.bytedance.android.live.core.tetris.layer.core.tetris.priority.PriorityLinearLayout;
import com.bytedance.android.live.core.tetris.layer.core.tetris.priority.PriorityTetris;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.RoomPermissionContext;
import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.stats.ToolbarLoadTimeStatsVM;
import com.bytedance.android.livesdk.config.gs;
import com.bytedance.android.livesdk.config.kl;
import com.bytedance.android.livesdk.config.l61;
import com.bytedance.android.livesdk.config.ld0;
import com.bytedance.android.livesdk.config.o00;
import com.bytedance.android.livesdk.config.pk0;
import com.bytedance.android.livesdk.config.qk0;
import com.bytedance.android.livesdk.config.uj;
import com.bytedance.android.livesdk.message.model.sg;
import com.bytedance.android.livesdk.message.model.ug;
import com.bytedance.android.livesdk.viewmodel.DrawCleanScreenViewModel;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTogetherLive;
import com.bytedance.android.livesdkapi.depend.model.live.IAnchorTogetherLive;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.OfficialChannelExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.RoomExtra;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;
import com.bytedance.android.livesdkapi.depend.model.live.UnionLiveInfo;
import com.bytedance.common.jato.views.JatoOptFrameLayout;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.q3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u00052\u00020\u0006B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/room/discovery/PortraitDiscoveryTetris;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/LivePriorityTetris;", "Ld90/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lo70/a;", "Lvlc/l;", "Lo70/b;", "event", "", "onEvent", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PortraitDiscoveryTetris extends LivePriorityTetris<d90.a> implements Observer<KVData>, o70.a, vlc.l {
    public static final /* synthetic */ int C = 0;
    public final l61 A;
    public final CompositeDisposable B;
    public final Lazy u;
    public Element<?> v;
    public Disposable w;
    public Element<?> x;
    public Element<?> y;
    public Element<?> z;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ PortraitDiscoveryTetris a;

        public a(PortraitDiscoveryTetris r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            ug r8 = (ug) r7;
            PortraitDiscoveryTetris r0 = this.a;
            int r1 = PortraitDiscoveryTetris.C;
            r0.getClass();
            if (r8 == null) goto L44;
            com.bytedance.android.live.base.model.user.o0.a r2 = com.bytedance.android.live.base.model.user.o0.a;
            Long r3 = Long.valueOf(r8._channelUid);
            String r4 = r8._channelOpenId;
            r2.getClass();
            if (com.bytedance.android.live.base.model.user.q0.a(com.bytedance.android.live.base.model.user.o0.a.g(r3, r4)) == false) goto L34;
            String r5 = r8.showListSchema;
            if (r5 == null) goto L34;
            if (r5.length() <= 0) goto L12;
            boolean r6 = true;
        L13:
            if (r6 != true) goto L34;
            if (r0.v != null) goto L45;
            Element<?> r9 = r0.x;
            if (r9 == null) goto L20;
            r0.H(r9);
        L20:
            r0.x = null;
            Room r10 = r0.f0();
            if (r10 == null) goto L24;
            OfficialChannelExtraInfo r12 = new OfficialChannelExtraInfo();
            r12.setShowListSchema(r8.showListSchema);
            r12.setShowListText(r8.showListText);
            Long r13 = Long.valueOf(r8._channelUid);
            String r14 = r8._channelOpenId;
            r2.getClass();
            r12.setChannelUid(com.bytedance.android.live.base.model.user.o0.a.g(r13, r14));
            Long r15 = Long.valueOf(r8._channelAnchorId);
            String r16 = r8._channelAnchorOpenId;
            r2.getClass();
            r12.setChannelAnchorId(com.bytedance.android.live.base.model.user.o0.a.g(r15, r16));
            r12.setShowListId(r8.showListId);
            r12.setShowListName(r8.showListName);
            r12.setChannelName(r8.channelName);
            Unit r17 = Unit.INSTANCE;
            r10.set_officialChannelExtraInfo(r12);
        L24:
            if (d90.c.f(r0.K()) == false) goto L26;
            return;
        L26:
            if (r0.v != null) goto L40;
            IMicRoomService r18 = (IMicRoomService) jc1.k.f(IMicRoomService.class);
            if (r18 != null) goto L30;
            return;
        L30:
            if (r18.isMicRoom(r0.f0()) == true) goto L32;
        L33:
            r0.x = LivePriorityTetris.b0(r0, r18.getNormalRoomShowListWidget(), new u70.c(950, "NormalRoomShowListWidget"), ((Boolean) kl.a.getValue()).booleanValue(), 8);
            return;
        L32:
            if (d90.c.c(r0.K()) == true) goto L33;
            return;
        L40:
            return;
        L45:
            return;
        L12:
            r6 = false;
        L34:
            Element<?> r19 = r0.x;
            if (r19 == null) goto L37;
            r0.H(r19);
        L37:
            r0.x = null;
            return;
        }
    }

    public final void W() {
    }

    public final Room f0() {
        return (Room) this.u.getValue();
    }

    public final List<Class<? extends o70.b>> Mg() {
        return CollectionsKt.listOf(zg1.m0.class);
    }

    public final void O() {
        LiveMode r1 = null;
        boolean r4 = true;
        if (((Boolean) y3.a.getValue()).booleanValue() == false) goto L23;
        Room r0 = f0();
        if (r0 == null) goto L23;
        RoomExtra r2 = r0.getExtra();
        if (r2 == null) goto L23;
        if (r2.isGroupLiveScene() != true) goto L23;
        RoomContext r3 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r3 == null) goto L23;
        if (r3.isPrivateRoom() != true) goto L23;
        JatoOptFrameLayoutVisibilityProxy r5 = ((PriorityTetris) this).q;
        if ((r5 instanceof JatoOptFrameLayoutVisibilityProxy) == false) goto L20;
        if (r5 == null) goto L19;
        r5.T3(new d80.c());
        goto L20
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.tetris.priority.JatoOptFrameLayoutVisibilityProxy");
    L20:
        JatoOptFrameLayout r6 = ((PriorityTetris) this).q;
        if (r6 == null) goto L23;
        r6.setVisibility(4);
    L23:
        Room r7 = f0();
        if (r7 != null) goto L26;
    L32:
        RoomContext.a r8 = RoomContext.Companion;
        RoomContext r9 = RoomContext.a.c(r8, ((d90.d) K()).h, 0, 2);
        if (r9 == null) goto L39;
        com.bytedance.live.datacontext.n r10 = r9.getDrawCleanScreenViewModel();
        if (r10 == null) goto L39;
        DrawCleanScreenViewModel r12 = (DrawCleanScreenViewModel) r10.getValue();
        if (r12 == null) goto L39;
        r12.changeRoomClear("PortraitDiscoveryTetris");
    L39:
        Boolean r13 = (Boolean) kl.a.getValue();
        g0(r13.booleanValue());
        if (f0() != null) goto L42;
        boolean r14 = false;
    L44:
        if (r14 == false) goto L47;
        LivePriorityTetris.b0(this, LiveSceneWidget.class, new u70.c(999, "LiveSceneWidget"), r13.booleanValue(), 8);
    L47:
        if (com.bytedance.android.livesdk.config.setting.r.a().booleanValue() == false) goto L52;
        if (d90.c.c(K()) == false) goto L52;
    L50:
        Class<? extends LiveRecyclableWidget> r15 = null;
    L58:
        if (r15 == null) goto L60;
        LivePriorityTetris.b0(this, r15, new u70.c(900, "MicRoomWidget"), r13.booleanValue(), 8);
    L60:
        IMicRoomService r16 = (IMicRoomService) jc1.k.f(IMicRoomService.class);
        if (r16 != null) goto L63;
    L66:
        boolean r17 = true;
    L67:
        if (r17 == false) goto L87;
        if (f0() == null) goto L83;
        Integer r18 = (Integer) o00.a.getValue();
        if (r18 == null) goto L83;
        if (r18.intValue() != 1) goto L83;
        Room r19 = f0();
        Intrinsics.checkNotNull(r19);
        if (r19.isMediaRoom() == false) goto L82;
        z70.b r20 = ((h70.b) K()).a;
        if (r20 == null) goto L83;
        ((d90.d) K()).f.getClass();
        if (r20.d(d90.d.a.A2) != true) goto L83;
    L82:
        boolean r22 = true;
    L84:
        if (r22 == false) goto L87;
        LivePriorityTetris.b0(this, LiveHotSpotWidget.class, new u70.c(800, "LiveHotSpotWidget"), r13.booleanValue(), 8);
    L83:
        r22 = false;
    L87:
        if (com.bytedance.android.livesdk.config.setting.r.a().booleanValue() == false) goto L93;
        c0(r13.booleanValue());
        RoomContext r23 = RoomContext.a.c(r8, ((d90.d) K()).h, 0, 2);
        if (r23 == null) goto L93;
        com.bytedance.live.datacontext.j r24 = r23.getMessageManager();
        if (r24 == null) goto L93;
        r24.c(new PortraitDiscoveryTetris$onViewCreated$2(this));
    L93:
        RoomContext r25 = RoomContext.a.c(r8, ((d90.d) K()).h, 0, 2);
        if (r25 == null) goto L98;
        com.bytedance.live.datacontext.j r26 = r25.getMessageManager();
        if (r26 == null) goto L98;
        r26.c(new PortraitDiscoveryTetris$onViewCreated$3(this));
    L98:
        IMicRoomService r27 = (IMicRoomService) jc1.k.f(IMicRoomService.class);
        if (r27 != null) goto L101;
    L104:
        boolean r28 = true;
    L105:
        if (r28 == false) goto L118;
        uj r29 = uj.a;
        if (r29.getValue() != null) goto L109;
    L111:
        boolean r30 = false;
    L112:
        if (r30 == false) goto L118;
        if (d90.c.k(K()) == false) goto L116;
    L117:
        LivePriorityTetris.b0(this, LiveHashtagWidget.class, new u70.c(700, "LiveHashtagWidget"), r13.booleanValue(), 8);
        goto L118
    L116:
        if (d0() == true) goto L118;
    L109:
        if (((ng2.b) r29.getValue()).showChallenge == false) goto L111;
        r30 = true;
    L118:
        Room r32 = f0();
        if (r32 != null) goto L121;
    L131:
        boolean r33 = false;
    L132:
        if (r33 == false) goto L134;
        LivePriorityTetris.b0(this, TopLeftActivityBannerWidget.class, new u70.c(550, "TopLeftActivityBannerWidget"), true, 8);
    L134:
        boolean r34 = d0();
        if (f0() == null) goto L144;
        Room r35 = f0();
        Intrinsics.checkNotNull(r35);
        RoomAuthStatus r36 = r35.getRoomAuthStatus();
        if (r36 != null) goto L140;
    L142:
        Room r37 = f0();
        Intrinsics.checkNotNull(r37);
        if (r37.isMediaRoom() == true) goto L144;
        ((IRoomService) jc1.k.n(IRoomService.class)).isNewFeedStyle(((d90.d) K()).h);
        boolean r38 = true;
    L146:
        av0.a r39 = yt0.c.j();
        if (r39 != null) goto L149;
    L167:
        LivePriorityTetris.b0(this, jc1.k.n(IInteractService.class).getLiveMatrixEntranceWidget(), new u70.c(1500, "LiveMatrixEntranceWidget"), false, 12);
        DataCenter r40 = ((d90.d) K()).h;
        if (r40 == null) goto L174;
        DataCenter r42 = r40.observe("data_keyboard_status", this);
        if (r42 == null) goto L174;
        DataCenter r43 = r42.observe("data_union_room_change", this);
        if (r43 == null) goto L174;
        r43.observe("data_user_in_room", this);
    L174:
        Set r44 = SetsKt.setOf(new u70.a());
        Intrinsics.checkNotNullParameter(r44, "mutexSet");
        PriorityLinearLayout r45 = ((PriorityTetris) this).o;
        if (r45 != null) goto L177;
        Intrinsics.throwUninitializedPropertyAccessException("priorityLayout");
    L177:
        r45.setMutexList(r44);
        if (((Boolean) ld0.a.getValue()).booleanValue() == false) goto L191;
        Room r46 = f0();
        if (r46 == null) goto L183;
        LiveMode r47 = r46.getStreamType();
    L185:
        if (r47 == LiveMode.VIDEO) goto L192;
        Room r48 = f0();
        if (r48 == null) goto L190;
        r1 = r48.getStreamType();
    L190:
        if (r1 != LiveMode.THIRD_PARTY) goto L191;
    L192:
        if (r4 == false) goto L196;
        RoomContext r49 = K().b();
        if (r49 == null) goto L196;
        this.w = dc2.b.a(n3.g(r49), PortraitDiscoveryTetris$onViewCreated$6$roomDataSyncModel$1.INSTANCE).getOfficialChannelShowListSyncData().d.subscribe(new a(this));
    L196:
        this.B.add(xs2.b.a().b(q3.class).subscribe(new n0(this)));
        return;
    L183:
        r47 = null;
    L191:
        r4 = false;
        goto L192
    L149:
        if (r39.enableHourRank() != true) goto L167;
        av0.a r50 = yt0.c.j();
        if (r50 == null) goto L153;
        r50.x8(r38, r34);
    L153:
        if (r34 == true) goto L155;
        if (r38 == false) goto L167;
    L155:
        av0.a r52 = yt0.c.j();
        if (r52 == null) goto L160;
        Class<? extends Widget> r53 = r52.Nh();
        if (r53 == null) goto L160;
        LivePriorityTetris.b0(this, r53, new u70.c(500, "RankWidget"), true, 8);
    L160:
        if (r34 == false) goto L167;
        if (r38 == false) goto L167;
        av0.a r54 = yt0.c.j();
        if (r54 == null) goto L167;
        Class<? extends Widget> r55 = r54.A1();
        if (r55 == null) goto L167;
        LivePriorityTetris.b0(this, r55, new u70.c(499, "VerticalRankEntranceWidget"), false, 12);
        goto L167
    L140:
        if (r36.hourRank != 2) goto L142;
    L144:
        r38 = false;
        goto L146
    L121:
        if (r32.isMediaRoom() == true) goto L131;
        if (r32.getRoomAuthStatus() == null) goto L131;
        RoomAuthStatus r56 = r32.getRoomAuthStatus();
        if (r56 == null) goto L131;
        if (r56.enableBanner() != true) goto L131;
        if (d90.c.f(K()) == true) goto L131;
        r33 = true;
        goto L132
    L101:
        if (r27.isMicRoom(f0()) == false) goto L104;
        r28 = false;
        goto L105
    L63:
        if (r16.isMicRoom(f0()) == false) goto L66;
        r17 = false;
    L52:
        if (d90.c.f(K()) == true) goto L50;
        IMicRoomService r57 = (IMicRoomService) jc1.k.f(IMicRoomService.class);
        if (r57 == null) goto L50;
        if (r57.isMicRoom(f0()) == false) goto L50;
        r15 = r57.getMicRoomAnchorWidget();
        goto L58
    L42:
        Room r58 = f0();
        Intrinsics.checkNotNull(r58);
        r14 = !r58.isMediaRoom();
        goto L44
    L26:
        if (r7.isMediaRoom() != true) goto L32;
        ToolbarLoadTimeStatsVM.a r59 = ToolbarLoadTimeStatsVM.Companion;
        Room r60 = f0();
        r59.getClass();
        if (ToolbarLoadTimeStatsVM.a.d(r60) == true) goto L32;
        if (((Boolean) gs.a.getValue()).booleanValue() == false) goto L32;
        int r62 = ib6.a.a;
        f0();
        View r63 = L();
        CompositeDisposable r64 = this.B;
        Intrinsics.checkNotNullParameter(r63, "tetrisView");
        Intrinsics.checkNotNullParameter(r64, "cd");
        goto L32
    }

    public final boolean Q() {
        return ((Boolean) qk0.a.getValue()).booleanValue();
    }

    public final boolean R() {
        return ((Boolean) pk0.a.getValue()).booleanValue();
    }

    public final boolean T() {
        return this.A.d();
    }

    public final int V() {
        return (int) UtilityKotlinExtentionsKt.h(6.0f);
    }

    public PortraitDiscoveryTetris() {
        this.u = LazyKt.lazy(new PortraitDiscoveryTetris$mRoom$2(this));
        this.A = (l61) LiveInfraSettingKeys.LIVE_ON_MEASURE_OPT_CONFIG.getValue();
        this.B = new CompositeDisposable();
    }

    public final boolean S() {
        if (com.bytedance.android.livesdk.config.setting.r.a().booleanValue() == false) goto L9;
        IMicRoomService r0 = (IMicRoomService) jc1.k.f(IMicRoomService.class);
        if (r0 == null) goto L9;
        if (r0.isMicRoom(f0()) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final int Z() {
        if (Q() == false) goto L7;
        return 3;
    L7:
        if (com.bytedance.android.livesdk.config.setting.r.a().booleanValue() == false) goto L13;
        IMicRoomService r0 = (IMicRoomService) jc1.k.f(IMicRoomService.class);
        if (r0 != null) goto L11;
        return 2;
    L11:
        if (r0.isMicRoom(f0()) != true) goto L16;
        return 1;
    L16:
        return 2;
    L13:
        return 2;
    }

    public final boolean d0() {
        Room r0 = f0();
        if (r0 == null) goto L14;
        RoomAuthStatus r2 = r0.getRoomAuthStatus();
        if (r2 == null) goto L10;
        if (r2.verticalRank != 2) goto L10;
        return false;
    L10:
        if (r0.isMediaRoom() == false) goto L13;
        return false;
    L13:
        return true;
    L14:
        return false;
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris*/.onDestroy();
        Disposable r0 = this.w;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        DataCenter r1 = ((d90.d) K()).h;
        if (r1 == null) goto L8;
        r1.removeObserver(this);
    L8:
        this.B.clear();
    }

    public final void c0(boolean r8) {
        Element<?> r0 = this.x;
        Class<? extends LiveRecyclableWidget> r1 = null;
        if (r0 == null) goto L5;
        H(r0);
        this.x = null;
    L5:
        Element<?> r2 = this.v;
        if (r2 == null) goto L12;
        com.bytedance.android.live.room.x r9 = (com.bytedance.android.live.room.x) r2.f(com.bytedance.android.live.room.x.class);
        if (r9 == null) goto L43;
        r9.Af(f0());
        return;
    L43:
        return;
    L12:
        if (d90.c.f(K()) == true) goto L40;
        IMicRoomService r3 = (IMicRoomService) jc1.k.f(IMicRoomService.class);
        if (r3 == null) goto L40;
        if (r3.isMicRoom(f0()) == false) goto L20;
        if (d90.c.c(K()) == false) goto L40;
    L20:
        if (com.bytedance.android.livesdk.config.setting.r.a().booleanValue() == false) goto L37;
        Room r4 = f0();
        if (r4 == null) goto L26;
        OfficialChannelExtraInfo r5 = r4.getOfficialChannelExtraInfo();
        if (r5 == null) goto L26;
        long r6 = r5.getShowStartTime();
    L28:
        if (r6 <= 0) goto L37;
        Room r7 = f0();
        if (r7 == null) goto L34;
        OfficialChannelExtraInfo r10 = r7.getOfficialChannelExtraInfo();
        if (r10 == null) goto L34;
        String r12 = r10.getShowListSchema();
    L35:
        if (r12 == null) goto L37;
        boolean r13 = true;
    L38:
        if (r13 == false) goto L40;
        r1 = r3.getNormalRoomMicListWidget();
    L34:
        r12 = null;
    L26:
        r6 = 0;
    L37:
        r13 = false;
    L40:
        if (r1 == null) goto L44;
        this.v = LivePriorityTetris.b0(this, r1, new u70.c(950, "NormalRoomMicListWidget"), r8, 8);
        return;
    }

    public final void g0(boolean r6) {
        Room r0 = f0();
        if (r0 != null) goto L5;
    L6:
        Room r1 = f0();
        if (r1 != null) goto L9;
    L11:
        boolean r2 = false;
        if (d90.c.c(K()) == true) goto L17;
        RoomPermissionContext.a r3 = RoomPermissionContext.Companion;
        DataCenter r4 = ((d90.d) K()).h;
        LiveRoomPermission.D.getClass();
        LiveRoomPermission r5 = LiveRoomPermission.A;
        r3.getClass();
        if (RoomPermissionContext.a.e(r4, r5) == true) goto L17;
        int r7 = com.bytedance.android.live.room.utils.c.a;
        boolean r8 = com.bytedance.android.live.room.utils.c.b(f0());
    L28:
        Room r9 = f0();
        if (r9 == null) goto L43;
        RoomOthersData r10 = r9.others;
        if (r10 == null) goto L43;
        IAnchorTogetherLive r12 = r10.getAnchorTogetherLive();
        if (r12 == null) goto L43;
        if (r12.getShowEntrance() != true) goto L43;
        List r13 = r12.getTogetherAnchor();
        if (r13 == null) goto L39;
        int r14 = r13.size();
    L40:
        if (r14 <= 0) goto L43;
        r2 = true;
        goto L43
    L39:
        r14 = 0;
    L43:
        if (r8 == true) goto L45;
        if (r2 == true) goto L58;
        Element<?> r15 = this.y;
        if (r15 == null) goto L69;
        H(r15);
        this.y = null;
        return;
    L69:
        Element<?> r16 = this.z;
        if (r16 == null) goto L80;
        H(r16);
        this.z = null;
        return;
    L80:
        return;
    L58:
        if (this.z == null) goto L63;
        DataCenter r17 = ((d90.d) K()).h;
        if (r17 == null) goto L74;
        r17.put("data_anchor_together_room_change", new Object());
        return;
    L74:
        return;
    L63:
        this.z = LivePriorityTetris.a0(this, new LiveAnchorTogetherWidget(), new u70.c(WebcastRedirectException.UNKNOWN, "AnchorTogetherWidget"), r6);
        Element<?> r18 = this.y;
        if (r18 == null) goto L77;
        H(r18);
        this.y = null;
        return;
    L77:
        return;
    L45:
        if (this.y == null) goto L47;
        return;
    L47:
        IRoomService r19 = (IRoomService) jc1.k.f(IRoomService.class);
        if (r19 == null) goto L52;
        LiveRecyclableWidget r20 = r19.getUnionAnchorInfoWidget(true);
        if (r20 == null) goto L52;
        Element<?> r22 = LivePriorityTetris.a0(this, r20, new u70.c(WebcastRedirectException.UNKNOWN, "UnionLiveWidget"), r6);
    L53:
        this.y = r22;
        Element<?> r23 = this.z;
        if (r23 == null) goto L75;
        H(r23);
        this.z = null;
        return;
    L75:
        return;
    L52:
        r22 = null;
    L17:
        int r24 = com.bytedance.android.live.room.utils.c.a;
        Room r25 = f0();
        if (r25 == null) goto L27;
        UnionLiveInfo r26 = r25.unionLiveInfo;
        if (r26 == null) goto L27;
        List r27 = r26.guestAnchors;
        if (r27 == null) goto L27;
        if ((!r27.isEmpty()) != true) goto L27;
        r8 = true;
    L27:
        r8 = false;
        goto L28
    L9:
        if (r1.isMergeVSRoom() != true) goto L11;
        return;
    L5:
        if (r0.isMediaRoom() != true) goto L6;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L29;
        String r0 = r5.getKey();
        int r1 = r0.hashCode();
        if (r1 == (-1741164106)) goto L26;
        if (r1 == 560852175) goto L23;
        if (r1 == 1060055221) goto L12;
        return;
    L12:
        if (r0.equals("data_keyboard_status") == false) goto L30;
        Boolean r2 = Boolean.TRUE;
        Boolean r6 = (Boolean) r5.getData(r2);
        if (r6 == null) goto L17;
        r2 = r6;
    L17:
        boolean r7 = r2.booleanValue();
        View r3 = L();
        if (r7 == false) goto L20;
        int r8 = 8;
    L21:
        r3.setVisibility(r8);
        return;
    L20:
        r8 = 0;
        goto L21
    L30:
        return;
    L23:
        if (r0.equals("data_union_room_change") == false) goto L32;
    L27:
        g0(((Boolean) kl.a.getValue()).booleanValue());
        return;
    L32:
        return;
    L26:
        if (r0.equals("data_user_in_room") == true) goto L27;
        return;
    }

    public void onEvent(o70.b r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if ((r2 instanceof zg1.m0) == false) goto L11;
        boolean r3 = ((zg1.m0) r2).a;
        JatoOptFrameLayout r0 = ((PriorityTetris) this).q;
        if (r0 == null) goto L12;
        if (r3 == false) goto L8;
        float r4 = 0.0f;
    L9:
        r0.setAlpha(r4);
        return;
    L8:
        r4 = 1.0f;
        goto L9
    L12:
        return;
    }

    public final void onMessage(tlc.d r5) {
        if ((r5 instanceof sg) == false) goto L16;
        sg r6 = (sg) r5;
        String r0 = r6.getScheme();
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.length() <= 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 != true) goto L30;
        Room r2 = f0();
        if (r2 == null) goto L14;
        OfficialChannelExtraInfo r3 = new OfficialChannelExtraInfo();
        r3.setShowListSchema(r6.getScheme());
        r3.setShowStartTime(r6.E());
        Unit r7 = Unit.INSTANCE;
        r2.set_officialChannelExtraInfo(r3);
    L14:
        c0(((Boolean) kl.a.getValue()).booleanValue());
        return;
    L30:
        return;
    L9:
        r1 = false;
        goto L10
    L16:
        if ((r5 instanceof j5) == false) goto L32;
        Room r4 = f0();
        if (r4 == null) goto L27;
        RoomOthersData r8 = r4.others;
        if (r8 == null) goto L27;
        if (r8.getAnchorTogetherLive() != null) goto L24;
        r8.setAnchorTogetherLive(new AnchorTogetherLive());
        Unit r9 = Unit.INSTANCE;
    L24:
        IAnchorTogetherLive r10 = r8.getAnchorTogetherLive();
        if (r10 == null) goto L27;
        j5 r12 = (j5) r5;
        r10.setLiveTogetherStatus(r12.getLiveTogetherStatus());
        r10.setAvatarTitle(r12.getAvatarTitle());
        r10.setSchemaUrl(r12.getSchemaUrl());
        r10.setTogetherAnchor(r12.getTogetherAnchor());
        r10.setEntranceScene(r12.getEntranceScene());
    L27:
        g0(((Boolean) kl.a.getValue()).booleanValue());
        return;
    }
}
