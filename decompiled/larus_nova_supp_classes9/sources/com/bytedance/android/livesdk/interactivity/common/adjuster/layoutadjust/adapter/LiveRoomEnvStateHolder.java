package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter;

import com.bytedance.android.live.cloudgrouplive.model.CloudGroupLivePipelineStatus;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.profit.scoreboard.j;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.viewmodel.f;
import com.bytedance.android.livesdk.config.rl0;
import com.bytedance.android.livesdk.interactivity.InteractivityContextKt;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.android.livesdk.interactivity.api.o;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.g;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.settings.config.y;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.model.i0;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.MultiTabManagerImpl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBasisData;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerGameExtraRenderController;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerMultiRenderController;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.n;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import e92.m;
import gd0.v;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nm1.r;
import r52.y3;
import zg1.a0;
import zg1.f1;
import zg1.f3;
import zg1.p1;
import zg1.u1;
import zg1.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/adjuster/layoutadjust/adapter/LiveRoomEnvStateHolder;", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/common/adjuster/layoutadjust/e;", "Lcom/bytedance/android/livesdk/interactivity/common/adjuster/layoutadjust/d;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Ls42/a;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRoomEnvStateHolder implements com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.e, com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.d, Observer<KVData>, s42.a {
    public String A;
    public final List<Disposable> B;
    public int C;
    public final Lazy D;
    public final LiveRoomEnvStateHolder$extraRenderShowObserver$1 E;
    public final LiveRoomEnvStateHolder$extraRenderBottomChangeObserver$1 F;
    public final DataCenter G;
    public final RoomContext H;
    public final g I;
    public final boolean a;
    public int b;
    public boolean c;
    public int d;
    public boolean e;
    public boolean f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;
    public j.a m;
    public fa0.b n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    public int u;
    public boolean v;
    public boolean w;
    public int x;
    public boolean y;
    public int z;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ LiveRoomEnvStateHolder a;

        public a(LiveRoomEnvStateHolder r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.m = (j.a) r2;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ DataCenter a;

        public b(DataCenter r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            j.a r6 = (j.a) r5;
            LayerEventDispatcher r7 = o70.c.a(Integer.valueOf(this.a.hashCode()));
            if (r7 == null) goto L6;
            r7.b(new o42.c(true, false, "scoreboard"));
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LiveRoomEnvStateHolder a;

        public c(LiveRoomEnvStateHolder r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.n = (fa0.b) r2;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ DataCenter a;

        public d(DataCenter r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            fa0.b r6 = (fa0.b) r5;
            LayerEventDispatcher r7 = o70.c.a(Integer.valueOf(this.a.hashCode()));
            if (r7 == null) goto L6;
            r7.b(new o42.c(true, false, "group_container"));
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ LiveRoomEnvStateHolder a;

        public e(LiveRoomEnvStateHolder r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            if (r3 == null) goto L8;
            Integer r4 = (Integer) sh6.c.b(r3);
            if (r4 == null) goto L9;
            this.a.b = r4.intValue();
            return;
        L9:
            return;
        }
    }

    public final boolean O() {
        Integer r1 = (Integer) this.G.get("data_link_state", 0);     // Catch: Exception -> L10
        if (r1.intValue() <= 2) goto L13;
        if (r1.intValue() == 512) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L15:
        return false;
    }

    public final boolean e0() {
        int r1 = 0;
        r1 = ((Number) this.G.get("data_link_state", 0)).intValue();     // Catch: Exception -> L8
        if (k.n(ILinkServiceExternal.class).getControlServiceExternal().V() == false) goto L7;
        r1 = 4;
    L7:
        return v.a(r1, 4);
    }

    public final boolean B() {
        h r0 = i.a(this.H, this.G);
        if (r0 == null) goto L14;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.b> r1 = r0.getBarrageContext();
        if (r1 == null) goto L15;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r2 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.b) r1.getValue();
        if (r2 != null) goto L9;
        return false;
    L9:
        if (((Boolean) r2.isCarnivalStarted().getValue()).booleanValue() == true) goto L11;
        return false;
    L11:
        if (((Boolean) r2.isDanmakuVisible().getValue()).booleanValue() == true) goto L13;
        return false;
    L13:
        return true;
    L15:
        return false;
    L14:
        return false;
    }

    public final boolean C() {
        if (((CloudGroupLivePipelineStatus) this.G.get("data_cloud_group_live_pipeline_status", CloudGroupLivePipelineStatus.END)) != CloudGroupLivePipelineStatus.START) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean E() {
        Boolean r0 = (Boolean) this.G.get("data_common_casting_show");
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public final boolean I() {
        a0 r0 = (a0) this.G.get("cmd_equal_talkroom_state_change", new a0(1));
        if (r0 != null) goto L5;
    L13:
        IInteractService r1 = k.f(IInteractService.class);
        if (r1 != null) goto L16;
    L18:
        return false;
    L16:
        if (r1.currentUILayoutNeedAdjustCommentHeight(this.G) != true) goto L18;
        return true;
    L5:
        if (r0.a != 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L13;
        return true;
    L7:
        r3 = false;
        goto L8
    }

    public final boolean J() {
        Room r0 = z.o(this.G);
        RoomContext r1 = this.H;
        if (r0 == null) goto L14;
        if (r1 == null) goto L15;
        LiveMode r2 = r0.getStreamType();
        if (r2 != LiveMode.SCREEN_RECORD) goto L10;
    L11:
        return true;
    L10:
        if (r2 == LiveMode.THIRD_PARTY) goto L11;
        return false;
    L15:
        return false;
    L14:
        return false;
    }

    public final boolean K() {
        fa0.b r0 = this.n;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.a == true) goto L7;
        return false;
    L7:
        if (r0.b == true) goto L9;
        return false;
    L9:
        return true;
    }

    public final boolean R() {
        Object r2 = null;
        Object r0 = this.G.get("data_is_score_open", null);
        if ((r0 instanceof Boolean) == false) goto L7;
        r2 = r0;
    L7:
        return Intrinsics.areEqual((Boolean) r2, Boolean.TRUE);
    }

    public final boolean S() {
        RoomSpecificSceneTypeInfo r0 = z.o(this.G).getSceneTypeInfo();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isLandscapeVerticalRoom() != 1) goto L7;
        return true;
    }

    public final boolean U() {
        int r0 = this.r;
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 != 2) goto L7;
        return true;
    L7:
        if (r0 == 3) goto L13;
        return false;
    L13:
        return true;
    }

    public final boolean Y() {
        IInteractService r0 = k.f(IInteractService.class);
        if (r0 == null) goto L9;
        iy.g r1 = r0.getDynamicCenterService(this.G);
        if (r1 == null) goto L9;
        if (r1.getCurrentScene() != 20) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean a0() {
        f r0 = (f) this.H.getVoiceTalkRoomSubScene().getValue();
        if (r0 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r1 = r0.t();
        if (r1 == null) goto L17;
        if (r1.a != 9) goto L17;
        f r2 = (f) this.H.getVoiceTalkRoomSubScene().getValue();
        if (r2 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r3 = r2.t();
        if (r3 == null) goto L17;
        if (r3.b != 0) goto L17;
        if (this.a == false) goto L17;
        return true;
    L17:
        return false;
    }

    public final boolean b0() {
        if (((i0) this.G.get("paid_live_show_share_ticket_panel", new i0(0))).b != true) goto L6;
        return true;
    L6:
        return false;
    }

    public final boolean c0() {
        return com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(this.G).x1();
    }

    @Override // s42.a
    public final void e() {
        Iterator<T> r0 = this.B.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Disposable) r0.next()).dispose();
        goto L4
    L6:
        ILivePlayerClient r1 = j(this.G);
        if (r1 == null) goto L9;
        ILivePlayerExtraRenderController.EventHub r2 = r1.extraRenderController().eventHub();
        r2.getExtraRenderIsShow().removeObserver(this.E);
        r2.getExtraViewBottom().removeObserver(this.F);
        ILivePlayerGameExtraRenderController.EventHub r3 = r1.gameExtraRenderController().eventHub();
        r3.getExtraRenderIsShow().removeObserver(this.E);
        r3.getExtraViewBottom().removeObserver(this.F);
        ILivePlayerMultiRenderController.EventHub r4 = r1.multiRenderController().eventHub();
        r4.getMultiRenderIsShow().removeObserver(this.E);
        r4.getMultiRenderBottom().removeObserver(this.F);
    L9:
        ((ArrayList) this.B).clear();
    }

    public final boolean f0() {
        j.a r0 = this.m;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.a == true) goto L7;
        return false;
    L7:
        if (r0.b == true) goto L9;
        return false;
    L9:
        return true;
    }

    public final int g() {
        boolean r2 = true;
        a0 r0 = (a0) this.G.get("cmd_equal_talkroom_state_change", new a0(1));
        if (r0 != null) goto L5;
    L16:
        return 0;
    L5:
        if (r0.a == 0) goto L7;
    L9:
        r2 = false;
    L10:
        if (r2 == true) goto L13;
        r0 = null;
    L13:
        if (r0 == null) goto L16;
        return r0.b;
    L7:
        if (r0.b <= 0) goto L9;
        goto L9
    }

    public final boolean g0() {
        IInteractService r0 = k.f(IInteractService.class);
        if (r0 == null) goto L7;
        com.bytedance.android.live.liveinteract.revenue.fight.b r1 = r0.teamFightService();
        if (r1 == null) goto L7;
        return r1.isTeamFightShowing();
    L7:
        return false;
    }

    public final boolean i0() {
        IInteractService r0 = k.f(IInteractService.class);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isVideoChorus() != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.d
    public final boolean isAnchor() {
        return z.e(this.G, false);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.e
    public final boolean isMediaRoom() {
        return z.o(this.G).isMediaRoom();
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.e
    public final boolean isVSRoom() {
        return this.H.isVSRoom();
    }

    public final boolean j0() {
        if (z.c(this.G) != LiveMode.VIDEO) goto L5;
        return true;
    L5:
        return false;
    }

    public final int k() {
        IInteractService r0 = k.f(IInteractService.class);
        if (r0 == null) goto L7;
        iy.g r1 = r0.getDynamicCenterService(this.G);
        if (r1 == null) goto L7;
        return r1.Ti();
    L7:
        return -1;
    }

    public final boolean k0() {
        Integer r3 = null;
        if (m.g(this.G) == true) goto L29;
        MiddlewareRoomContext r0 = o3.c(this.G);
        if (r0 == null) goto L9;
        n r1 = r0.isRoomVisible();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
    L11:
        if (Intrinsics.areEqual(r2, Boolean.FALSE) == false) goto L29;
        if (MultiLinkLoadWidgetUtils.h() == false) goto L29;
        IRoom r4 = com.bytedance.android.live.core.utils.a0.o(this.G);
        IInteractService r5 = k.f(IInteractService.class);
        if (r5 == null) goto L17;
        int r6 = r5.getScene(this.G);
    L18:
        if (r4 != null) goto L20;
        return false;
    L20:
        if (r4.isLiveTypeAudio() == false) goto L22;
        return false;
    L22:
        if (r6 != 8) goto L24;
    L27:
        return true;
    L24:
        if (r6 == 12) goto L27;
        if (r6 == 16) goto L27;
        return false;
    L17:
        r6 = 0;
    L9:
        r2 = null;
    L29:
        Object r7 = this.G.get("data_link_state", null);
        if ((r7 instanceof Integer) == true) goto L32;
        r7 = null;
    L32:
        Integer r8 = (Integer) r7;
        if (r8 != null) goto L35;
    L37:
        if (r3 == null) goto L43;
        return true;
    L43:
        return false;
    L35:
        if (v.a(r8.intValue(), 32) == false) goto L37;
        r3 = r8;
        goto L37
    }

    public final int l() {
        fa0.b r0 = this.n;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.c;
    }

    public final boolean l0() {
        return z.o(this.G).isVirtualLive;
    }

    public final int m() {
        IInteractService r0 = k.f(IInteractService.class);
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getCurrentScene();
    }

    public final boolean m0() {
        IRoomBasisData r0 = z.o(this.G).getBasisRoomData();
        Boolean r4 = null;
        if (r0 != null) goto L13;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L11;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L11;
        Room r3 = (Room) r2.getValue();
        if (r3 == null) goto L11;
        r0 = r3.getBasisRoomData();
    L11:
        r0 = null;
    L13:
        if (m.g(this.G) == true) goto L42;
        MiddlewareRoomContext r5 = o3.c(this.G);
        if (r5 == null) goto L19;
        n r6 = r5.isRoomVisible();
        if (r6 == null) goto L19;
        Boolean r7 = (Boolean) r6.getValue();
    L21:
        if (Intrinsics.areEqual(r7, Boolean.FALSE) == false) goto L42;
        if (MultiLinkLoadWidgetUtils.h() == false) goto L42;
        IInteractService r8 = k.f(IInteractService.class);
        if (r8 == null) goto L27;
        Integer r9 = Integer.valueOf(r8.getUiLayout(this.G));
    L28:
        if (r0 == null) goto L31;
        r4 = r0.isCustomizeAudioRoom();
    L31:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L36;
        if (r9 == null) goto L36;
        if (r9.intValue() != 25) goto L36;
    L40:
        return true;
    L36:
        if (r9 != null) goto L39;
        return false;
    L39:
        if (r9.intValue() == 29) goto L40;
        return false;
    L27:
        r9 = null;
    L19:
        r7 = null;
    L42:
        if (r0 == null) goto L44;
        Boolean r10 = r0.isCustomizeAudioRoom();
    L46:
        if (Intrinsics.areEqual(r10, Boolean.TRUE) == false) goto L57;
        RoomContext r11 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r11 == null) goto L57;
        com.bytedance.live.datacontext.j r13 = r11.getVoiceTalkRoomSubScene();
        if (r13 == null) goto L57;
        f r14 = (f) r13.getValue();
        if (r14 == null) goto L57;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r15 = r14.t();
        if (r15 == null) goto L57;
        if (r15.b != 25) goto L57;
    L67:
        return true;
    L57:
        RoomContext r16 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r16 == null) goto L71;
        com.bytedance.live.datacontext.j r17 = r16.getVoiceTalkRoomSubScene();
        if (r17 == null) goto L72;
        f r18 = (f) r17.getValue();
        if (r18 == null) goto L73;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r19 = r18.t();
        if (r19 != null) goto L66;
        return false;
    L66:
        if (r19.b == 29) goto L67;
        return false;
    L73:
        return false;
    L72:
        return false;
    L71:
        return false;
    L44:
        r10 = null;
        goto L46
    }

    public final int n() {
        return s1.f(100.0f) + ((int) (((double) s1.y()) * 0.1d));
    }

    public final boolean n0() {
        return z.o(this.G).getWithLinkMic();
    }

    public final int o0() {
        com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j.c.d("get ktv right margin : " + this.b);
        return this.b;
    }

    public final int p() {
        j.a r0 = this.m;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.c;
    }

    public final int p0() {
        Integer r2 = null;
        Object r0 = this.G.get("data_bottom_right_state", null);
        if ((r0 instanceof f3) == true) goto L5;
        r0 = null;
    L5:
        f3 r1 = (f3) r0;
        if (r1 != null) goto L8;
    L18:
        if (r2 != null) goto L20;
        return 0;
    L20:
        return r2.intValue();
    L8:
        if (r1.a == true) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == true) goto L16;
        r1 = null;
    L16:
        if (r1 == null) goto L18;
        r2 = Integer.valueOf(r1.b);
        goto L18
    L10:
        if (r1.b <= 0) goto L12;
        r3 = true;
        goto L13
    }

    public final int r0() {
        return ((Number) this.G.get("data_common_talk_room_match_screen", -1)).intValue();
    }

    public final boolean s() {
        return ((Boolean) this.H.getAnchorPlayingVideo().getValue()).booleanValue();
    }

    public final boolean u() {
        return ((Boolean) this.G.get("data_live_app_widget_guide_show", Boolean.FALSE)).booleanValue();
    }

    public final boolean x() {
        if (((LiveMode) this.G.get("data_live_mode", LiveMode.VIDEO)) != LiveMode.AUDIO) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean y() {
        return this.I.xa();
    }

    public final boolean z() {
        DataCenter r0 = this.G;
        if (r0 == null) goto L11;
        Object r2 = null;
        Object r1 = r0.get("data_feedback_bottom_right_card_show", null);
        if ((r1 instanceof Boolean) == false) goto L8;
        r2 = r1;
    L8:
        Boolean r3 = (Boolean) r2;
        if (r3 == null) goto L11;
        return r3.booleanValue();
    L11:
        return false;
    }

    public final boolean F() {
        if (MultiLinkLoadWidgetUtils.h() == false) goto L10;
        IInteractService r0 = k.f(IInteractService.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        if (r0.getUiLayout(this.G) != 16) goto L17;
        return true;
    L17:
        return false;
    L10:
        IInteractService r1 = k.f(IInteractService.class);
        if (r1 != null) goto L13;
        return false;
    L13:
        if (r1.getCurUILayout() != 16) goto L19;
        return true;
    L19:
        return false;
    }

    public final boolean H() {
        if (MultiLinkLoadWidgetUtils.h() == false) goto L7;
        IInteractService r0 = k.f(IInteractService.class);
        if (r0 == null) goto L10;
        Integer r1 = Integer.valueOf(r0.getUiLayout(this.G));
    L11:
        if (r1 != null) goto L14;
    L15:
        if (r1 != null) goto L18;
    L19:
        if (r1 != null) goto L22;
    L24:
        return false;
    L22:
        if (r1.intValue() != 65) goto L24;
    L25:
        return true;
    L18:
        if (r1.intValue() == 15) goto L25;
    L14:
        if (r1.intValue() == 16) goto L25;
    L10:
        r1 = null;
        goto L11
    L7:
        IInteractService r2 = k.f(IInteractService.class);
        if (r2 == null) goto L10;
        r1 = Integer.valueOf(r2.getCurUILayout());
        goto L11
    }

    public final boolean L() {
        if (MultiLinkLoadWidgetUtils.h() == false) goto L10;
        IInteractService r0 = k.f(IInteractService.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        if (r0.getUiLayout(this.G) != 65) goto L17;
        return true;
    L17:
        return false;
    L10:
        IInteractService r1 = k.f(IInteractService.class);
        if (r1 != null) goto L13;
        return false;
    L13:
        if (r1.getCurUILayout() != 65) goto L19;
        return true;
    L19:
        return false;
    }

    public final boolean V() {
        r r0 = pm1.f.o();
        if (r0 == null) goto L7;
        r0.a();
        if (MultiTabManagerImpl.e.h(this.G) != true) goto L7;
        return true;
    L7:
        return false;
    }

    public final boolean d0() {
        o32.b r0 = o.a();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.isPinContainerShown();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean h0() {
        r r0 = pm1.f.o();
        if (r0 == null) goto L7;
        r0.a();
        if (MultiTabManagerImpl.e.h(this.G) != true) goto L7;
        return true;
    L7:
        return false;
    }

    public final int i() {
        o32.b r0 = o.a();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Integer> r1 = r0.getAnnouncementBottom();
        if (r1 == null) goto L9;
        Integer r2 = (Integer) r1.getValue();
        if (r2 == null) goto L9;
        return r2.intValue();
    L9:
        return 0;
    }

    public final int o() {
        o32.b r0 = o.a();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Integer> r1 = r0.getPinContainerBottom();
        if (r1 == null) goto L9;
        Integer r2 = (Integer) r1.getValue();
        if (r2 == null) goto L9;
        return r2.intValue();
    L9:
        return 0;
    }

    public final boolean q() {
        if (MultiLinkLoadWidgetUtils.h() == false) goto L10;
        IInteractService r0 = k.f(IInteractService.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        if (r0.getUiLayout(this.G) != 30) goto L17;
        return true;
    L17:
        return false;
    L10:
        IInteractService r1 = k.f(IInteractService.class);
        if (r1 != null) goto L13;
        return false;
    L13:
        if (r1.getCurUILayout() != 30) goto L19;
        return true;
    L19:
        return false;
    }

    public final boolean t() {
        o32.b r0 = o.a();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.isAnnouncementShown();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean v() {
        if (MultiLinkLoadWidgetUtils.h() == false) goto L10;
        IInteractService r0 = k.f(IInteractService.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        if (r0.getUiLayout(this.G) != 28) goto L17;
        return true;
    L17:
        return false;
    L10:
        IInteractService r1 = k.f(IInteractService.class);
        if (r1 != null) goto L13;
        return false;
    L13:
        if (r1.getCurUILayout() != 28) goto L19;
        return true;
    L19:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.d
    public final boolean c() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.d
    public final int f() {
        return this.g;
    }

    @Override // s42.a
    public final void W(DataCenter r6) {
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        n<Integer> r0 = ((IKtvService) k.n(IKtvService.class)).ktvCardState();
        Disposable r1 = null;
        if (r0 == null) goto L15;
        Integer r2 = (Integer) r0.getValue();
        if (r2 == null) goto L15;
        if (r2.intValue() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == true) goto L13;
        r2 = null;
    L13:
        if (r2 == null) goto L15;
        this.b = r2.intValue();
        goto L15
    L9:
        r3 = false;
    L15:
        if (r0 == null) goto L19;
        Observable r4 = r0.a();
        if (r4 == null) goto L19;
        r1 = r4.subscribe(new e(this));
    L19:
        if (r1 == null) goto L21;
        ((ArrayList) this.B).add(r1);
    L21:
        ILivePlayerClient r5 = j(r6);
        if (r5 != null) goto L24;
    L27:
        boolean r7 = com.bytedance.android.live.revenue.core.util.h.a;
        j r8 = com.bytedance.android.live.revenue.core.util.h.e(j.class);
        if (r8 == null) goto L30;
        ((ArrayList) this.B).add(r8.l5(((Long) r6.get("data_room_id", 0L)).longValue()).doOnNext(new a(this)).subscribe(new b(r6)));
    L30:
        fa0.c r9 = com.bytedance.android.live.revenue.core.util.h.e(fa0.c.class);
        if (r9 == null) goto L34;
        ((ArrayList) this.B).add(r9.I4().doOnNext(new c(this)).subscribe(new d(r6)));
        return;
    L34:
        return;
    L24:
        if (((Boolean) this.D.getValue()).booleanValue() == false) goto L26;
        ILivePlayerExtraRenderController.EventHub r10 = r5.extraRenderController().eventHub();
        r10.getExtraRenderIsShow().observe(r5.getLifecycleOwner(), this.E);
        r10.getExtraViewBottom().observe(r5.getLifecycleOwner(), this.F);
        ILivePlayerGameExtraRenderController.EventHub r11 = r5.gameExtraRenderController().eventHub();
        r11.getExtraRenderIsShow().observe(r5.getLifecycleOwner(), this.E);
        r11.getExtraViewBottom().observe(r5.getLifecycleOwner(), this.F);
        ILivePlayerMultiRenderController.EventHub r13 = r5.multiRenderController().eventHub();
        r13.getMultiRenderIsShow().observe(r5.getLifecycleOwner(), this.E);
        r13.getMultiRenderBottom().observe(r5.getLifecycleOwner(), this.F);
        goto L27
    L26:
        ILivePlayerExtraRenderController.EventHub r14 = r5.extraRenderController().eventHub();
        r14.getExtraRenderIsShow().observeForever(this.E);
        r14.getExtraViewBottom().observeForever(this.F);
        ILivePlayerGameExtraRenderController.EventHub r15 = r5.gameExtraRenderController().eventHub();
        r15.getExtraRenderIsShow().observeForever(this.E);
        r15.getExtraViewBottom().observeForever(this.F);
        ILivePlayerMultiRenderController.EventHub r16 = r5.multiRenderController().eventHub();
        r16.getMultiRenderIsShow().observeForever(this.E);
        r16.getMultiRenderBottom().observeForever(this.F);
        goto L27
    }

    public final ILivePlayerClient j(DataCenter r3) {
        if (((Boolean) this.D.getValue()).booleanValue() == false) goto L6;
        return LivePlatformPlayerManager.a(((Long) r3.get("data_room_id", 0L)).longValue(), false);
    L6:
        return LivePlatformPlayerManager.f();
    }

    public final void onChanged(Object r10) {
        KVData r11 = (KVData) r10;
        if (r11 == null) goto L256;
        String r0 = r11.getKey();
        Object r2 = null;
        switch(r0.hashCode()) {
            case -1595752242: goto L185;
            case -1540323875: goto L163;
            case -1518101862: goto L154;
            case -1478222429: goto L145;
            case -1381247050: goto L135;
            case -1131769173: goto L126;
            case -1130046128: goto L117;
            case -1091008631: goto L95;
            case -547104593: goto L86;
            case -96741143: goto L77;
            case 694542470: goto L60;
            case 760150158: goto L43;
            case 938990556: goto L34;
            case 1390578228: goto L27;
            case 2035962867: goto L18;
            case 2147375792: goto L9;
            default: goto L257;
        };
    L257:
        return;
    L9:
        if (r0.equals("data_live_welfare_component_show") == false) goto L194;
        Object r13 = r11.getData();
        if ((r13 instanceof Boolean) == false) goto L14;
        r2 = r13;
    L14:
        Boolean r3 = (Boolean) r2;
        if (r3 == null) goto L195;
        this.j = r3.booleanValue();
        return;
    L195:
        return;
    L194:
        return;
    L18:
        if (r0.equals("data_live_bottom_right_card_show") == false) goto L197;
        Object r14 = r11.getData();
        if ((r14 instanceof f1) == false) goto L23;
        r2 = r14;
    L23:
        f1 r4 = (f1) r2;
        if (r4 == null) goto L198;
        this.k = r4.a;
        this.l = r4.b;
        return;
    L198:
        return;
    L197:
        return;
    L27:
        if (r0.equals("cmd_link_multi_to_pk_event") == false) goto L200;
        this.o = false;
        InteractionWidgetsPosContext r15 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, this.G, 0, 2);
        if (r15 == null) goto L201;
        com.bytedance.live.datacontext.m r16 = r15.getMultiPkGiftTrayPos();
        if (r16 == null) goto L202;
        r16.setValue(new ok1.a(-10086, 1));
        return;
    L202:
        return;
    L201:
        return;
    L200:
        return;
    L34:
        if (r0.equals("cmd_live_request_text_message_height_change") == false) goto L204;
        Object r17 = r11.getData();
        if ((r17 instanceof Integer) == false) goto L39;
        r2 = r17;
    L39:
        Integer r5 = (Integer) r2;
        if (r5 == null) goto L205;
        this.C = r5.intValue();
        return;
    L205:
        return;
    L204:
        return;
    L43:
        if (r0.equals("cmd_video_chorus_state_change") == false) goto L207;
        Object r18 = r11.getData();
        if ((r18 instanceof Boolean) == false) goto L48;
        r2 = r18;
    L48:
        Boolean r6 = (Boolean) r2;
        if (r6 != null) goto L51;
        return;
    L51:
        if (r6.booleanValue() != true) goto L53;
        return;
    L53:
        if (((Boolean) y3.a.getValue()).booleanValue() == false) goto L210;
        InteractionWidgetsPosContext r19 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, this.G, 0, 2);
        if (r19 == null) goto L211;
        com.bytedance.live.datacontext.m r110 = r19.getVideoChorusGiftTrayPos();
        if (r110 == null) goto L212;
        r110.setValue(new ok1.a(-10086, 1));
        return;
    L212:
        return;
    L211:
        return;
    L210:
        return;
    L207:
        return;
    L60:
        if (r0.equals("cmd_equal_talkroom_state_change") == false) goto L214;
        Object r111 = r11.getData();
        if ((r111 instanceof a0) == false) goto L65;
        r2 = r111;
    L65:
        a0 r7 = (a0) r2;
        if (r7 != null) goto L68;
        return;
    L68:
        if (r7.a == 1) goto L70;
        return;
    L70:
        if (((Boolean) rl0.a.getValue()).booleanValue() == false) goto L217;
        InteractionWidgetsPosContext r112 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, this.G, 0, 2);
        if (r112 == null) goto L218;
        com.bytedance.live.datacontext.m r113 = r112.getEqualVideoTalkGiftTrayPos();
        if (r113 == null) goto L219;
        r113.setValue(new ok1.a(-10086, 1));
        return;
    L219:
        return;
    L218:
        return;
    L217:
        return;
    L214:
        return;
    L77:
        if (r0.equals("cmd_multi_room_pk_state_change") == false) goto L221;
        Object r114 = r11.getData();
        if ((r114 instanceof Boolean) == false) goto L82;
        r2 = r114;
    L82:
        Boolean r8 = (Boolean) r2;
        if (r8 == null) goto L222;
        r8.booleanValue();
        return;
    L222:
        return;
    L221:
        return;
    L86:
        if (r0.equals("cmd_ugc_linked_room_state_change") == false) goto L224;
        Object r115 = r11.getData();
        if ((r115 instanceof p1) == false) goto L91;
        r2 = r115;
    L91:
        p1 r9 = (p1) r2;
        if (r9 == null) goto L225;
        this.w = r9.a;
        this.x = r9.b;
        return;
    L225:
        return;
    L224:
        return;
    L95:
        if (r0.equals("cmd_multi_state_change") == false) goto L227;
        Object r116 = r11.getData();
        if ((r116 instanceof u1) == false) goto L100;
        r2 = r116;
    L100:
        u1 r20 = (u1) r2;
        if (r20 == null) goto L228;
        int r117 = r20.f;
        if (r117 != 1) goto L105;
        boolean r1 = true;
    L106:
        this.o = r1;
        this.p = r20.g + r20.a;
        this.q = r20.i;
        this.r = r20.k;
        this.s = r20.l;
        if (r117 == 2) goto L109;
    L115:
        this.t = false;
        return;
    L109:
        if (((Boolean) rl0.a.getValue()).booleanValue() == false) goto L115;
        InteractionWidgetsPosContext r118 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, this.G, 0, 2);
        if (r118 == null) goto L115;
        com.bytedance.live.datacontext.m r119 = r118.getMultiPkGiftTrayPos();
        if (r119 == null) goto L115;
        r119.setValue(new ok1.a(-10086, 1));
        goto L115
    L105:
        r1 = false;
        goto L106
    L228:
        return;
    L227:
        return;
    L117:
        if (r0.equals("cmd_interact_player_view_change") == false) goto L230;
        Object r120 = r11.getData();
        if ((r120 instanceof kd0.a) == false) goto L122;
        r2 = r120;
    L122:
        kd0.a r21 = (kd0.a) r2;
        if (r21 == null) goto L231;
        this.c = r21.a;
        this.d = r21.b;
        return;
    L231:
        return;
    L230:
        return;
    L126:
        if (r0.equals("data_bottom_card_container_show") == false) goto L233;
        Object r121 = r11.getData();
        if ((r121 instanceof com.bytedance.android.livesdk.event.e) == false) goto L131;
        r2 = r121;
    L131:
        com.bytedance.android.livesdk.event.e r23 = (com.bytedance.android.livesdk.event.e) r2;
        if (r23 == null) goto L234;
        this.f = r23.a;
        this.g = r23.b;
        return;
    L234:
        return;
    L233:
        return;
    L135:
        if (r0.equals("data_promotion_right_card_container_show") == false) goto L236;
        Object r122 = r11.getData();
        if ((r122 instanceof Boolean) == true) goto L139;
        r122 = null;
    L139:
        Boolean r123 = (Boolean) r122;
        if (r123 == null) goto L237;
        final boolean r124 = r123.booleanValue();
        this.e = r124;
        RoomContext r24 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r24 == null) goto L238;
        InteractivityContextKt.a(r24, new LiveRoomEnvStateHolder$onChanged$2$1(r124));
        return;
    L238:
        return;
    L237:
        return;
    L236:
        return;
    L145:
        if (r0.equals("data_live_picture_presentation_show") == false) goto L240;
        Object r125 = r11.getData();
        if ((r125 instanceof Boolean) == false) goto L150;
        r2 = r125;
    L150:
        Boolean r25 = (Boolean) r2;
        if (r25 == null) goto L241;
        this.y = r25.booleanValue();
        return;
    L241:
        return;
    L240:
        return;
    L154:
        if (r0.equals("data_live_interactive_component_show") == false) goto L243;
        Object r126 = r11.getData();
        if ((r126 instanceof Boolean) == false) goto L159;
        r2 = r126;
    L159:
        Boolean r26 = (Boolean) r2;
        if (r26 == null) goto L244;
        this.i = r26.booleanValue();
        return;
    L244:
        return;
    L243:
        return;
    L163:
        if (r0.equals("cmd_pk_state_change") == false) goto L246;
        Object r127 = r11.getData();
        if ((r127 instanceof z0) == true) goto L167;
        r127 = null;
    L167:
        z0 r128 = (z0) r127;
        if (r128 == null) goto L247;
        int r27 = r128.a;
        if (r27 != 0) goto L172;
        this.t = true;
        this.u = r128.d;
        this.v = r128.e;
        return;
    L172:
        if (r27 != 1) goto L249;
        Object r129 = r128.b;
        if ((r129 instanceof Boolean) == false) goto L178;
        r2 = r129;
    L178:
        if ((!Intrinsics.areEqual((Boolean) r2, Boolean.TRUE)) == false) goto L250;
        this.t = false;
        this.u = 0;
        this.v = false;
        InteractionWidgetsPosContext r130 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, this.G, 0, 2);
        if (r130 == null) goto L251;
        com.bytedance.live.datacontext.m r131 = r130.getRevenuePkGiftTrayPos();
        if (r131 == null) goto L252;
        r131.setValue(new ok1.a(-10086, 1));
        return;
    L252:
        return;
    L251:
        return;
    L250:
        return;
    L249:
        return;
    L247:
        return;
    L246:
        return;
    L185:
        if (r0.equals("data_paid_live_ticket_card_show") == false) goto L254;
        Object r132 = r11.getData();
        if ((r132 instanceof Boolean) == false) goto L190;
        r2 = r132;
    L190:
        Boolean r28 = (Boolean) r2;
        if (r28 == null) goto L255;
        this.h = r28.booleanValue();
        return;
    L255:
        return;
    L254:
        return;
    }

    public final void q0(int r3) {
        this.G.put("data_voice_chat_public_screen_height", Integer.valueOf(r3));
    }

    /* JADX WARN: Type inference failed for: r9v7, types: [com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder$extraRenderShowObserver$1] */
    /* JADX WARN: Type inference failed for: r9v8, types: [com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder$extraRenderBottomChangeObserver$1] */
    public LiveRoomEnvStateHolder(DataCenter r7, RoomContext r8, g r9) {
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        Intrinsics.checkNotNullParameter(r8, "roomDataContext");
        Intrinsics.checkNotNullParameter(r9, "pageUIAdapter");
        this.G = r7;
        this.H = r8;
        this.I = r9;
        this.a = vm2.h.Q();
        this.A = "default";
        this.B = new ArrayList();
        this.C = -10086;
        this.D = LazyKt.lazy(LiveRoomEnvStateHolder$liveMemLeakExtraRender$2.INSTANCE);
        this.E = new LiveRoomEnvStateHolder$extraRenderShowObserver$1(this);
        this.F = new LiveRoomEnvStateHolder$extraRenderBottomChangeObserver$1(this);
        r7.observe("cmd_interact_player_view_change", this, true).observe("data_promotion_right_card_container_show", this, true).observe("data_bottom_card_container_show", this, true).observe("cmd_live_request_text_message_height_change", this, true).observe("data_paid_live_ticket_card_show", this, true).observe("cmd_multi_room_pk_state_change", this, true).observe("cmd_link_multi_to_pk_event", this, true).observe("cmd_pk_state_change", this, true).observe("data_live_welfare_component_show", this, true).observe("data_live_bottom_right_card_show", this, true).observe("cmd_ugc_linked_room_state_change", this, true).observe("data_live_picture_presentation_show", this).observeForever("data_live_interactive_component_show", this, true).observeForever("cmd_multi_state_change", this, true).observeForever("cmd_equal_talkroom_state_change", this);
        Boolean r10 = Boolean.FALSE;
        this.i = ((Boolean) r7.get("data_live_interactive_component_show", r10)).booleanValue();
        this.j = ((Boolean) r7.get("data_live_welfare_component_show", r10)).booleanValue();
        this.k = ((f1) r7.get("data_live_bottom_right_card_show", new f1(false, 0))).a;
        this.l = ((f1) r7.get("data_live_bottom_right_card_show", new f1(false, 0))).b;
        com.bytedance.android.livesdk.event.e r11 = (com.bytedance.android.livesdk.event.e) r7.get("data_bottom_card_container_show", new com.bytedance.android.livesdk.event.e(false, 0));
        this.f = r11.a;
        this.g = r11.b;
        if (((y) PublicScreenABHelper.l.getValue()).a() == true) goto L5;
        return;
    L5:
        if (FoldScreenUtils.f() == true) goto L9;
        r8.getDynamicStrategy().c(new AnonymousClass1(this));
        return;
    }
}
