package com.bytedance.android.live.liveinteract.radio.impl;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcast.dialog.theme.VoiceLiveThemeAdapter;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.c4;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.aimv.LiveLinkmicAIMVContext;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.j;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.bgComponent.theme.VideoThemeView;
import com.bytedance.android.live.liveinteract.bgComponent.theme.VoiceLiveThemeManageDialog;
import com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.AudioLiveThemeReporter;
import com.bytedance.android.live.liveinteract.bgComponent.theme.util.MultiLinkThemePerfHelper;
import com.bytedance.android.live.liveinteract.customizestream.CustomizeStreamContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.live.liveinteract.radio.RadioDarkMaskView;
import com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.a1;
import com.bytedance.android.live.liveinteract.utils.t0;
import com.bytedance.android.live.liveinteract.utils.w0;
import com.bytedance.android.live.liveinteract.view.RadioTextBoardView;
import com.bytedance.android.live.liveinteract.voicechat.radio.RadioStageContainerWidget;
import com.bytedance.android.live.liveinteract.voicechat.subtitle.LinkmicSubtitleBusinessContext;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.live.room.IMiddlewareLiveSDKService;
import com.bytedance.android.live.ui.ClipImageView;
import com.bytedance.android.live.ui.q;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.presenter.RadioViewPresenter;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.ui.framework.LoadState;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.pb0;
import com.bytedance.android.livesdk.config.y0;
import com.bytedance.android.livesdk.message.model.ok;
import com.bytedance.android.livesdk.message.model.qb;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.k2;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paidlive.model.PaidSceneContext;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeKt;
import com.bytedance.android.livesdkapi.model.RadioSpeakingUpdateTimeConfig;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.JsonObject;
import com.lynx.tasm.LynxView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vlc.l;
import vm2.h;
import zg1.h1;
import zg1.i1;
import zg1.p2;
import zh0.a0;
import zh0.b0;
import zh0.d0;
import zh0.e0;
import zh0.g0;
import zh0.h0;
import zh0.i;
import zh0.j0;
import zh0.k0;
import zh0.l0;
import zh0.n;
import zh0.o;
import zh0.p;
import zh0.r;
import zh0.s;
import zh0.t;
import zh0.v;
import zh0.w;
import zh0.x;
import zh0.y;
import zh0.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class RadioWidget extends LiveRecyclableWidget implements yh0.b, RadioViewPresenter.IView, x00.d, a1, View.OnClickListener, md0.a.c, l, yh0.c {
    public static final /* synthetic */ int H0 = 0;
    public com.bytedance.android.live.liveinteract.bgComponent.theme.util.c A;
    public com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.a B;
    public MultiLinkThemePerfHelper C;
    public View D;
    public np2.a E;
    public q F;
    public IVoiceLiveTheme G;
    public int H;
    public d I;
    public final CompositeDisposable J;
    public final com.bytedance.android.livesdk.a K;
    public final SparseArray<Boolean> L;
    public InteractLiveCorePermissionGuarantor M;
    public boolean N;
    public vlc.d O;
    public final j P;
    public boolean Q;
    public Disposable R;
    public RadioStageContainerWidget S;
    public boolean T;
    public Disposable U;
    public boolean V;
    public boolean W;
    public zh0.c X;
    public final a Y;
    public final zh0.e Z;
    public int a;
    public IRoom b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public ih0.b g;
    public RadioViewPresenter h;
    public com.bytedance.android.live.room.g i;
    public ClipImageView j;
    public ClipImageView k;
    public boolean k0;
    public View l;
    public ImageView m;
    public RadioDarkMaskView n;
    public boolean o;
    public VideoThemeView p;
    public boolean p0;
    public HSImageView q;
    public ImageView r;
    public HSImageView s;
    public ConstraintLayout t;
    public View u;
    public boolean v;
    public RadioTextBoardView w;
    public qb x;
    public x00.b y;
    public x00.c z;

    public class a implements InteractLiveCorePermissionGuarantor.a {
        @Override // com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor.a
        public final void b(boolean r1) {
        }

        public a() {
        }

        @Override // com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor.a
        public final void a(boolean r5) {
            if (r5 == false) goto L12;
            if (m.i() != null) goto L7;
            return;
        L7:
            if (m.i().getLiveStream() != null) goto L9;
            return;
        L9:
            if (m.i().getLiveStream().getValue() == null) goto L21;
            ((com.bytedance.android.live.pushstream.d) m.i().getLiveStream().getValue()).Q0(true, "radio background pause", new uv0.a(LiveRequestSourceRole.Business, "RadioWidget.onTargetPageShow.pause", null));
            return;
        L21:
            return;
        L12:
            if (m.i() != null) goto L14;
            return;
        L14:
            if (m.i().getLiveStream() != null) goto L16;
            return;
        L16:
            if (m.i().getLiveStream().getValue() == null) goto L25;
            ((com.bytedance.android.live.pushstream.d) m.i().getLiveStream().getValue()).Q0(false, "radio background resume", new uv0.a(LiveRequestSourceRole.Business, "RadioWidget.onTargetPageShow.resume", null));
            return;
        }
    }

    public class b implements js0.a {
        public final /* synthetic */ RadioWidget a;

        public b(RadioWidget r1) {
            this.a = r1;
        }

        @Override // js0.a
        public final void onFail(String r3) {
            Lazy r4 = MultiLinkLoadWidgetUtils.a;
            MultiLinkLoadWidgetUtils.n(((Widget) this.a).dataCenter, "RadioWidget", "load live_broadcast_plugin failed");
            f2.c("插件加载失败", 0);
        }
    }

    public class c implements js0.b {
        public final /* synthetic */ RadioWidget a;

        public c(RadioWidget r1) {
            this.a = r1;
        }

        @Override // js0.b
        public final void onSuccess(String r3) {
            RadioWidget r4 = this.a;
            if (r4.p0 == false) goto L5;
            return;
        L5:
            r4.p0 = true;
            DataCenter r0 = ((Widget) r4).dataCenter;
            if (r0 == null) goto L8;
            r4.Nq();
            return;
        L8:
            MultiLinkLoadWidgetUtils.n(r0, "RadioWidget", "load live_broadcast_plugin success, but datacenter null");
        }
    }

    public class d implements LivePluginSPIManager.a {
        public final /* synthetic */ RadioWidget a;

        @Override // com.bytedance.android.live.plugin_api.LivePluginSPIManager.a
        public final void afterReady() {
            RadioWidget r0 = this.a;
            if (r0.p0 == false) goto L5;
            return;
        L5:
            r0.p0 = true;
            if (((Widget) r0).dataCenter == null) goto L8;
            r0.Nq();
            return;
        L8:
            MultiLinkLoadWidgetUtils.o("RadioWidget", "load live_broadcast_plugin success, but datacenter null");
        }

        public d(RadioWidget r1) {
            this.a = r1;
        }
    }

    public class e {
        public e() {
        }
    }

    public class f implements Observer<KVData> {
        public final /* synthetic */ RadioWidget a;

        public f(RadioWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            KVData r5 = (KVData) r4;
            RadioWidget r0 = this.a;
            View r1 = ((Widget) r0).contentView;
            if (r0.isViewValid() == false) goto L15;
            if (r5 == null) goto L16;
            if (r1 == null) goto L18;
            String r2 = r5.getKey();
            r2.getClass();
            if (r2.equals("cmd_ktv_luanch") == true) goto L11;
            return;
        L11:
            if (((Boolean) r5.getData()).booleanValue() == false) goto L13;
            r1.setVisibility(8);
            return;
        L13:
            r1.setVisibility(0);
            return;
        L18:
            return;
        L16:
            return;
        }
    }

    public class g implements Consumer<Boolean> {
        public final /* synthetic */ RadioWidget a;

        public g(RadioWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) throws Exception {
            if (((Boolean) r2).booleanValue() == true) goto L13;
            com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.a r3 = this.a.B;
            if (r3 == null) goto L7;
            r3.a(null);
            this.a.B.n();
        L7:
            RadioWidget r4 = this.a;
            IVoiceLiveTheme r0 = r4.G;
            if (r0 == null) goto L19;
            q r5 = r4.F;
            if (r5 == null) goto L20;
            r5.c(r0);
            return;
        L20:
            return;
        L19:
            return;
        L13:
            if (this.a.G.getImageType() != 3) goto L17;
            List r6 = com.bytedance.android.live.liveinteract.aimv.b.a();
            this.a.B.a(r6);
            com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.a r7 = this.a.B;
            if (r7 == null) goto L22;
            r7.k();
            return;
        L22:
            return;
        L17:
            RadioWidget r8 = this.a;
            r8.F.d(r8.G);
        }
    }

    public final void Gq() {
        this.d = true;
        int r0 = w0.a;
        if (w0.d(this.b) == true) goto L5;
        this.u.setVisibility(8);
    L6:
        np2.a r1 = this.E;
        if (r1 == null) goto L10;
        r1.g();
    L10:
        if (h.h0().a() == false) goto L16;
        ViewGroup r2 = ((Widget) this).containerView;
        if (r2 == null) goto L17;
        r2.post(new p(this));
        return;
    L17:
        return;
    L16:
        return;
    L5:
        Qq(false);
        goto L6
    }

    public final void Iq() {
        this.d = false;
        IRoom r1 = this.b;
        if (r1 != null) goto L5;
    L15:
        int r2 = w0.a;
        if (w0.d(this.b) == true) goto L18;
        this.u.setVisibility(0);
    L19:
        np2.a r0 = this.E;
        if (r0 == null) goto L23;
        r0.f(this.G);
    L23:
        if (h.h0().a() == false) goto L29;
        ViewGroup r3 = ((Widget) this).containerView;
        if (r3 == null) goto L30;
        r3.post(new zh0.f(this));
        return;
    L30:
        return;
    L29:
        return;
    L18:
        Qq(true);
        goto L19
    L5:
        if (r1.getBasisRoomData() == null) goto L15;
        if (this.b.getBasisRoomData().isCustomizeAudioRoom().booleanValue() == false) goto L15;
        int r4 = w0.a;
        if (w0.d(this.b) == true) goto L11;
        this.u.setVisibility(8);
    L12:
        np2.a r5 = this.E;
        if (r5 == null) goto L23;
        r5.g();
        goto L23
    L11:
        Qq(false);
        goto L12
    }

    public final void Mc(IBaseUser r1, boolean r2) {
    }

    public final void O6(List<ILinkPlayerInfoBridge> r1) {
    }

    public final void Wk(String r1, boolean r2) {
    }

    public final void f9(String r1, boolean r2) {
    }

    public final int getLayoutId() {
        return 2131567755;
    }

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    public final String getSpm() {
        return "a100.a100.a256";
    }

    @Override // md0.a.InterfaceC0236a
    public final boolean isVersionSupported(int r1, int r2) {
        return false;
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    @Override // md0.a.c
    public final void onAudioMvControllerUpdate(String r1) {
    }

    @Override // md0.a.InterfaceC0236a
    public final /* synthetic */ void onBusinessAppSeiUpdate(JSONObject r1) {
    }

    @Override // md0.a.InterfaceC0236a
    public final void onSeiUpdated(SeiAppData r1) {
    }

    @Override // md0.a.c
    public final void onSpeechRecognitionSeiUpdate(String r1) {
    }

    @Override // md0.a.c
    public final /* synthetic */ void onSpeechRhythm(String r1) {
    }

    @Override // md0.a.c
    public final void onVideoStateSeiUpdate(ld0.a r1) {
    }

    public final boolean Cq() {
        if (this.b.getLinkerDetail() == null) goto L16;
        List r0 = this.b.getLinkerDetail().getFeatureList();
        if (r0 == null) goto L11;
        if (r0.isEmpty() == true) goto L11;
        if (r0.contains(1L) == false) goto L11;
    L15:
        return true;
    L11:
        if (this.b.getLinkerDetail() != null) goto L13;
        return false;
    L13:
        if (this.b.getLinkerDetail().getUiLayout() == 28) goto L15;
        return false;
    L16:
        return false;
    }

    public final boolean Eq() {
        IRoom r0 = this.b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return TextUtils.equals(r0.getLivePlatformSource(), "activity_auto_create");
    }

    public final boolean Fq() {
        IRoom r0 = this.b;
        if (r0 != null) goto L5;
    L15:
        return false;
    L5:
        if (r0.isLiveTypeAudio() == false) goto L15;
        if (this.b.getLinkMap() == null) goto L15;
        if (this.b.getLinkMap().containsKey(String.valueOf(9)) == false) goto L15;
        if (this.b.getLinkerDetail() == null) goto L15;
        if (this.b.getLinkerDetail().getUiLayout() != 61) goto L15;
        return true;
    }

    public final void Nq() {
        RadioViewPresenter r1 = new RadioViewPresenter();
        this.h = r1;
        r1.g0(this);
        int r2 = w0.a;
        if (w0.d(this.b) == true) goto L5;
        this.t.setVisibility(0);
        this.r.setVisibility(4);
    L6:
        this.U = Observable.interval(((RadioSpeakingUpdateTimeConfig) c4.a.getValue()).getSendDynamicInterval(), TimeUnit.MILLISECONDS).subscribe(new l0(this));
        if (m.i() != null) goto L9;
    L13:
        Rq();
        Kq();
        if (((Widget) this).dataCenter != null) goto L16;
    L22:
        this.b = (IRoom) ((Widget) this).dataCenter.get("data_room");
        final boolean r3 = MultiLinkLoadWidgetUtils.g();
        if (r3 == true) goto L33;
        IRoom r5 = this.b;
        if (r5 == null) goto L33;
        if (r5.getVoiceLiveTheme() == null) goto L33;
        if (this.b.getVoiceLiveTheme().isRealTimeChorusTheme() == false) goto L33;
        if (vm2.c.k() == false) goto L33;
        this.b.getVoiceLiveTheme().setBgType(100);
    L33:
        x00.c.a r6 = x00.c.a;
        if (this.b.getLinkInitResult() != null) goto L36;
        this.b.getLinkMap().containsKey("0");
    L36:
        r6.getClass();
        this.c = ((Boolean) ((Widget) this).dataCenter.get("data_is_anchor")).booleanValue();
        int r7 = s1.f(136.0f);
        if (w0.d(this.b) == false) goto L39;
        Pq();
    L43:
        ALogger.i("[FM]RadioWidget", "call initThemeBackground");
        boolean r8 = MultiLinkLoadWidgetUtils.g();
        this.z = ((IInteractService) k.f(IInteractService.class)).getThemeManager(this.c, ((Widget) this).dataCenter);
        if (this.b.getBackground() == null) goto L55;
        LiveLinkmicAIMVContext r4 = LiveLinkmicAIMVContext.getContext();
        if (r4 != null) goto L48;
    L50:
        boolean r9 = false;
    L51:
        if (r9 == true) goto L54;
        if (r8 == true) goto L54;
        ImageUtil.loadImage(this.j, this.b.getBackground(), 2131248875);
    L54:
        ALogger.i("[FM]RadioWidget", "onLoad. use mRoom#background");
    L215:
        Yq();
        yq();
        com.bytedance.android.livesdk.a r10 = this.K;
        if (r10 == null) goto L219;
        Function2 r11 = new v(this);
        Intrinsics.checkNotNullParameter(r11, "cb");
        r10.a = r11;
    L219:
        if (r3 == true) goto L221;
        ((Widget) this).dataCenter.observeForever("cmd_interact_audio", this.Z, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.h.c).observeForever("cmd_interact_real_time_chorus", this.Z).observeForever("cmd_team_fight_shown_state_change", this.Z).observeForever("cmd_voice_chat_room_show_background", this.Z).observeForever("data_show_player", this.Z).observeForever("data_hamlet_avatar_status", this.Z).observeForever("cmd_ktv_luanch", new f(this));
        int r12 = 0;
        ((Widget) this).dataCenter.put("cmd_live_radio", new jd0.g(false));
    L223:
        if (this.c == false) goto L225;
    L255:
        L7(h1.class, new w(this));
        L7(i1.class, new x(this));
        if (r3 == true) goto L259;
        L7(gd0.a.class, new y(this));
    L259:
        if (this.h.g == true) goto L261;
    L269:
        u r13 = m.d();
        if (r3 == true) goto L279;
        if (r13 == null) goto L279;
        if (r13.s() == null) goto L279;
        if (r13.s().getValue() == null) goto L279;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) r13.s().getValue()).a() == null) goto L279;
        this.J.add(((com.bytedance.android.livesdk.chatroom.viewmodel.f) r13.s().getValue()).a().subscribe(new a0(this)));
    L279:
        ((IInteractService) k.f(IInteractService.class)).addBusinessDegradeStrategy(this.K);
        if (vm2.d.y() == true) goto L282;
    L290:
        this.S = new RadioStageContainerWidget((ViewGroup) ((Widget) this).contentView.findViewById(2131383589), new k0(this), this.g);
        enableSubWidgetManager();
        ((Widget) this).subWidgetManager.load(this.S);
        LiveLinkmicAIMVContext r14 = LiveLinkmicAIMVContext.Companion.getContext();
        if (r14 == null) goto L295;
        if (r3 == true) goto L295;
        this.J.add(r14.isPlaying().a().subscribe(new g(this)));
    L295:
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.b(getComponentContext()) == false) goto L305;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.c(getComponentContext(), yh0.c.class, this);
        if (this.k0 == false) goto L306;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r15 = com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.a(getComponentContext());
        if (r15 != null) goto L301;
        return;
    L301:
        if (((LoadState) r15.getLoadState().a).getValue() < LoadState.P1_BEGIN.getValue()) goto L303;
        MainThreadPostUtils.b(new zh0.g(this));
        return;
    L303:
        this.R = com.bytedance.android.livesdk.chatroom.ui.framework.b.c(r15.getLoadState(), new zh0.h(this));
        return;
    L306:
        return;
    L305:
        return;
    L282:
        if (vm2.d.x() == false) goto L290;
        if (m.d() == null) goto L290;
        if (m.d().s() == null) goto L290;
        if (m.d().s().getValue() == null) goto L290;
        this.J.add(((com.bytedance.android.livesdk.chatroom.viewmodel.f) m.d().s().getValue()).a().subscribe(new b0(this, r3)));
        goto L290
    L261:
        if (m.d() == null) goto L269;
        if (m.d().I1() == null) goto L269;
        if (this.c == true) goto L267;
    L268:
        this.J.add(m.d().I1().a().subscribe(new z(this)));
        goto L269
    L267:
        if (((Boolean) vm2.d.w6.getValue(null, vm2.d.a[384(0x180, float:5.38E-43)])).booleanValue() == false) goto L269;
    L225:
        if (w0.d(this.b) == true) goto L227;
        this.r.setVisibility(r12);
    L229:
        if (this.b.getWithLinkMic() == true) goto L231;
    L233:
        boolean r16 = false;
    L234:
        if (r16 == true) goto L246;
        IRoom r17 = this.b;
        if (r17.isLiveTypeAudio() == true) goto L238;
    L240:
        boolean r18 = false;
    L241:
        if (r18 == true) goto L246;
        if (Fq() == true) goto L246;
        boolean r19 = false;
    L247:
        if (r19 == false) goto L249;
        Gq();
        Jq(false, "switch to voice chat on init");
    L251:
        if (Fq() == false) goto L255;
        DataCenter r20 = ((Widget) this).dataCenter;
        if (r20 == null) goto L255;
        r20.put("cmd_voice_chat_room_show_background", new p2("real time chorus force recover"));
        goto L255
    L249:
        Iq();
        goto L251
    L238:
        if (r17.getLinkMap().containsKey(String.valueOf(16)) == false) goto L240;
        r18 = true;
    L246:
        r19 = true;
        goto L247
    L231:
        if (this.b.isLiveTypeAudio() == false) goto L233;
        r16 = true;
        goto L234
    L227:
        Qq(true);
        goto L229
    L221:
        r12 = 0;
        goto L223
    L48:
        if (((Boolean) r4.isPlaying().getValue()).booleanValue() == false) goto L50;
        r9 = true;
        goto L51
    L55:
        int r21 = t0.a;
        t0.a("RadioWidget", "[ThemePreLoad]roomId=" + this.b.getId() + "RadioWidget#initVoiceLiveTheme begin load background, theme=" + this.b.getVoiceLiveTheme());
        boolean r22 = MultiLinkLoadWidgetUtils.g();
        if (r22 == true) goto L58;
        this.B = new com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.a(this.c, this.j, this.k, this.p, this.q, this.m, new d0(this));
    L58:
        IRoom r23 = this.b;
        if (r23 != null) goto L61;
    L63:
        boolean r24 = false;
    L64:
        q.a r25 = new q.a();
        AudioLiveThemeReporter.a r26 = AudioLiveThemeReporter.Companion;
        boolean r27 = this.c;
        r26.getClass();
        AudioLiveThemeReporter.access$setAnchor$p((AudioLiveThemeReporter) AudioLiveThemeReporter.access$getReporter$cp().getValue(), r27);
        AudioLiveThemeReporter r28 = (AudioLiveThemeReporter) AudioLiveThemeReporter.access$getReporter$cp().getValue();
        Intrinsics.checkNotNullParameter(r28, "callback");
        r25.c = r28;
        if (w0.d(this.b) == true) goto L67;
        np2.a r29 = new np2.a(this.s, r24);
        this.E = r29;
        Intrinsics.checkNotNullParameter(r29, "element");
        r25.b = r29;
        r25.e = null;
    L67:
        if (r22 == true) goto L69;
        com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.a r30 = this.B;
        e0 r31 = new e0(this);
        Intrinsics.checkNotNullParameter(r30, "element");
        r25.a = r30;
        r25.d = r31;
    L69:
        this.F = r25.a();
        if (r22 == false) goto L72;
    L156:
        x00.c r110 = this.z;
        if (r110 == null) goto L160;
        r110.j(this, new r(this), 2);
        this.z.j(this, new s(this), 1);
        this.z.j(this, new t(this), 100);
        this.z.j(this, new zh0.u(this), 5);
    L160:
        ALogger.d("RadioWidget", "init voice live theme " + this.G);
        if (this.c == false) goto L166;
        if (this.G != null) goto L181;
        this.G = com.bytedance.android.livesdk.model.k.a();
    L181:
        if (this.F != null) goto L183;
    L185:
        if (r22 == true) goto L188;
        this.m.setVisibility(8);
    L188:
        if (this.c == false) goto L190;
    L204:
        ((Widget) this).dataCenter.observe("data_room_audio_chat_ui_layout", new g0(this));
        ((Widget) this).dataCenter.observe("data_audio_background_load", new h0(this));
        if (m.d() != null) goto L207;
    L211:
        MultiLinkThemePerfHelper r32 = new MultiLinkThemePerfHelper();
        this.C = r32;
        com.bytedance.android.live.ui.l r33 = this.E;
        Intrinsics.checkNotNullParameter("multilink_radio_base_degrade", "key");
        r32.a.put("multilink_radio_base_degrade", r33);
        if (r8 == true) goto L214;
        MultiLinkThemePerfHelper r34 = this.C;
        com.bytedance.android.live.ui.l r35 = this.B;
        r34.getClass();
        Intrinsics.checkNotNullParameter("multilink_dynamic_bg", "key");
        r34.a.put("multilink_dynamic_bg", r35);
    L214:
        this.C.a();
        ALogger.i("[FM]RadioWidget", "onLoad. use LiveTheme");
        goto L215
    L207:
        if (m.d().s() == null) goto L211;
        if (m.d().s().getValue() == null) goto L211;
        this.J.add(((com.bytedance.android.livesdk.chatroom.viewmodel.f) m.d().s().getValue()).a().subscribe(new zh0.j(this), new zh0.k()));
        goto L211
    L190:
        if (this.b.getLinkMap().containsKey("5") == false) goto L204;
        if (this.b.getLinkMap().size() != 1) goto L204;
        if (vm2.d.q0() == null) goto L204;
        if (vm2.d.q0().isOpenSmoothViewMock() == false) goto L204;
        if (r22 == true) goto L204;
        com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.a r36 = this.B;
        if (r36 == null) goto L201;
        r36.r(false, "init");
    L201:
        this.o = true;
        RadioDarkMaskView r37 = this.n;
        if (r37 == null) goto L204;
        r37.setVisibility(8);
        goto L204
    L183:
        if (Wq() == false) goto L185;
        this.F.c(this.G);
        goto L188
    L166:
        if (this.b.getLinkMap() == null) goto L178;
        if (this.b.getLinkMap() == null) goto L181;
        if (this.b.getLinkMap().containsKey("5") == true) goto L178;
        if (this.b.getLinkMap().containsKey("0") == true) goto L178;
        if (this.b.getLinkMap().containsKey("16") == true) goto L178;
        if (this.b.getLinkMap().size() != 0) goto L181;
    L178:
        if (this.G != null) goto L181;
        this.G = com.bytedance.android.livesdk.model.k.a();
        goto L181
    L72:
        if (this.c == true) goto L74;
    L109:
        x00.c r111 = this.z;
        if (r111 == null) goto L155;
        r111.b();
        if (this.b.getLinkMap() == null) goto L133;
        if (this.b.getLinkMap() == null) goto L136;
        if (this.b.getLinkMap().containsKey("5") == true) goto L133;
        if (this.b.getLinkMap().containsKey("0") == true) goto L133;
        if (this.b.getLinkMap().containsKey("16") == true) goto L133;
        if (((Boolean) h.V4.getValue(null, h.a[306(0x132, float:4.29E-43)])).booleanValue() == true) goto L124;
    L128:
        boolean r112 = false;
    L129:
        if (r112 == true) goto L133;
        if (this.b.getLinkMap().size() != 0) goto L136;
    L124:
        if (this.b.getLinkMap() == null) goto L128;
        if (this.b.getLinkMap().containsKey("1") == false) goto L128;
        r112 = true;
    L136:
        if (vm2.d.X().isAudienceEnable() == false) goto L147;
        if (this.b.getLinkMap() == null) goto L147;
        if (this.b.getLinkMap().containsKey("9") == false) goto L147;
        if (this.b.getVoiceLiveTheme() == null) goto L147;
        if (this.b.getVoiceLiveTheme().getBgType() != 1) goto L147;
        this.z.c(this.b.getVoiceLiveTheme(), 1);
    L147:
        if (this.b.getLinkMap() == null) goto L155;
        if (this.b.getLinkMap().containsKey("9") == false) goto L155;
        if (this.b.getVoiceLiveTheme() == null) goto L155;
        if (this.b.getVoiceLiveTheme().getBgType() != 100) goto L155;
        this.z.c(this.b.getVoiceLiveTheme(), 100);
    L133:
        if (IVoiceLiveThemeKt.isValid(this.b.getVoiceLiveTheme()) == false) goto L136;
        this.G = this.b.getVoiceLiveTheme();
        this.z.c(this.b.getVoiceLiveTheme(), this.G.getBgType());
    L155:
        ar(this.G);
        goto L156
    L74:
        if (this.z == null) goto L109;
        FragmentActivity r113 = ((Widget) this).context;
        FragmentManager r114 = r113.getSupportFragmentManager();
        String r115 = LiveCommonConstants.IInteractionFragment_TAG;
        k2 r116 = k.f(IMiddlewareLiveSDKService.class).createImagePicker((Activity) ((Widget) this).context, r114.findFragmentByTag("AbsInteractionFragment"), "radio_cover", ((Widget) this).dataCenter, 9, 16, 720, 1280, new j0(this, r113), null, "");
        this.i = r116;
        r116.o = new zh0.l(this);
        this.z.b();
        if (Eq() == true) goto L90;
        int r117 = this.b.getLinkMicScene();
        if (r117 == 0) goto L88;
        if (r117 != 5) goto L81;
        this.G = this.z.q(2);
        goto L90
    L81:
        if (r117 != 9) goto L90;
        if (Bq() == false) goto L86;
        this.G = this.z.q(100);
        goto L90
    L86:
        this.G = this.z.q(1);
        goto L90
    L88:
        this.G = this.z.q(5);
    L90:
        if (this.b.getLinkMap() == null) goto L102;
        if (this.b.getLinkMap() != null) goto L94;
    L104:
        x00.c r118 = this.z;
        if (r118 == null) goto L108;
        r118.p(this, new zh0.m(this), 2);
        this.z.p(this, new n(this), 1);
        this.z.p(this, new o(this), 100);
        this.z.p(this, new zh0.q(this), 5);
    L108:
        this.A = new com.bytedance.android.live.liveinteract.bgComponent.theme.util.c(this, new i(this));
        y3.f(((Widget) this).dataCenter).k(ToolbarButton.VOICE_LIVE_THEME, this.A);
        ALogger.i("[FM]RadioWidget", "initVoiceLiveTheme.start.");
        goto L155
    L94:
        if (this.b.getLinkMap().containsKey("5") == true) goto L102;
        if (this.b.getLinkMap().containsKey("0") == true) goto L102;
        if (this.b.getLinkMap().containsKey("16") == true) goto L102;
        if (this.b.getLinkMap().size() != 0) goto L104;
    L102:
        if (IVoiceLiveThemeKt.isValid(this.b.getVoiceLiveTheme()) == false) goto L104;
        this.G = this.b.getVoiceLiveTheme();
        this.z.c(this.b.getVoiceLiveTheme(), this.G.getBgType());
        goto L104
    L61:
        if (r23.getBackground() != null) goto L63;
        r24 = true;
        goto L64
    L39:
        if (this.b.getOwner() == null) goto L41;
        com.bytedance.android.livesdk.chatroom.utils.a1.w(this.r, this.b.getOwner().getAvatarMedium(), r7, r7);
    L41:
        this.r.setOnClickListener(this);
        goto L43
    L16:
        if (h.e() == false) goto L22;
        xlc.a r38 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        this.O = r38;
        if (r38 == null) goto L22;
        if ((r38 instanceof xlc.a) == false) goto L22;
        r38.y(MessageType.ROOM_TEXT_BG_MESSAGE.getIntType(), this);
        goto L22
    L9:
        if (m.i().getLiveStream() == null) goto L13;
        if (m.i().getLiveStream().getValue() == null) goto L13;
        com.bytedance.android.live.pushstream.d r39 = (com.bytedance.android.live.pushstream.d) m.i().getLiveStream().getValue();
        this.X = new zh0.c(r39);
        r39.f(new e());
        goto L13
    L5:
        Qq(false);
        goto L6
    }

    public final void Pq() {
        JsonObject r0 = new JsonObject();
        r0.addProperty("type", "avatar_position");
        JsonObject r1 = new JsonObject();
        if (this.c == false) goto L5;
    L8:
        int r2 = -((int) s1.G(StatusBarUtil.getStatusBarHeight(s1.getContext())));
    L9:
        r1.addProperty("top_offset", Integer.valueOf(r2));
        r0.add("data", r1);
        ih0.b r3 = this.g;
        if (r3 == null) goto L13;
        r3.Dk("radio", "radio_event", r0, false);
        return;
    L13:
        return;
    L5:
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L8;
        r2 = 0;
        goto L9
    }

    public final void Rq() {
        JsonObject r0 = new JsonObject();
        r0.addProperty("type", "scene");
        JsonObject r1 = new JsonObject();
        if (m.d() != null) goto L5;
    L11:
        int r3 = 0;
    L13:
        if (this.c == false) goto L22;
        zh0.c r5 = this.X;
        if (r5 == null) goto L22;
        if (r3 == 0) goto L19;
        r5.a();
        goto L22
    L19:
        if (r5.c == null) goto L22;
        r5.a();
        r5.b = Observable.interval(r5.a, TimeUnit.MILLISECONDS).subscribe(new zh0.d(r5));
    L22:
        r1.addProperty("scene", Integer.valueOf(r3));
        r0.add("data", r1);
        ih0.b r2 = this.g;
        if (r2 == null) goto L25;
        r2.Dk("radio", "radio_event", r0, false);
    L25:
        Sq(this.T, "");
        return;
    L5:
        if (m.d().s() == null) goto L11;
        if (m.d().s().getValue() == null) goto L11;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) m.d().s().getValue()).t() == null) goto L11;
        r3 = ((com.bytedance.android.livesdk.chatroom.viewmodel.f) m.d().s().getValue()).t().a;
        goto L13
    }

    public final boolean Wq() {
        IVoiceLiveTheme r0 = this.G;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L13;
        if (vm2.c.k() == false) goto L13;
        return true;
    L13:
        if (this.b.getLinkMap() == null) goto L17;
        if (this.b.getLinkMap().containsKey("9") == false) goto L17;
    L18:
        return false;
    L17:
        if (Aq() == 9) goto L18;
        if (this.b.getLinkMap() == null) goto L25;
        if (this.b.getLinkMap().containsKey("16") == false) goto L25;
        return false;
    L25:
        if (Cq() == false) goto L27;
        return false;
    L27:
        return true;
    L5:
        if (r0.isRealTimeChorusTheme() == false) goto L7;
        r1 = true;
        goto L8
    }

    public final void Yq() {
        IRoom r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getBasisRoomData() != null) goto L7;
        return;
    L7:
        if (this.b.getBasisRoomData().isCustomizeAudioRoom().booleanValue() == false) goto L27;
        q r1 = this.F;
        if (r1 == null) goto L11;
        r1.d(this.G);
    L11:
        np2.a r2 = this.E;
        if (r2 == null) goto L14;
        r2.g();
    L14:
        this.B = null;
        this.E = null;
        this.F = null;
        MultiLinkThemePerfHelper r3 = this.C;
        if (r3 == null) goto L28;
        Function1<? super Map<String, com.bytedance.android.live.liveinteract.plantform.performance.d0>, Unit> r4 = r3.b;
        if (r4 == null) goto L23;
        IInteractService r5 = (IInteractService) k.f(IInteractService.class);
        if (r5 == null) goto L23;
        com.bytedance.android.live.liveinteract.plantform.performance.a r6 = r5.getMultiLinkPerfAbilityManager(false);
        if (r6 == null) goto L23;
        r6.d(r4);
    L23:
        r3.b = null;
        this.C = null;
        return;
    L28:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.utils.a1
    public final void bq() {
        if (this.y != null) goto L5;
        x00.b r0 = ((IInteractService) k.n(IInteractService.class)).createVoiceLiveThemeDialog(((Widget) this).context, false, this.i, zq(), ((Widget) this).dataCenter);
        this.y = r0;
        VoiceLiveThemeManageDialog r1 = (VoiceLiveThemeManageDialog) r0;
        r1.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) r1.d).add(this);
    L5:
        x00.b r2 = this.y;
        int r3 = zq();
        VoiceLiveThemeManageDialog r4 = (VoiceLiveThemeManageDialog) r2;
        r4.h = r3;
        VoiceLiveThemeAdapter r5 = r4.b;
        if (r5 == null) goto L8;
        r5.g = r3;
    L8:
        this.y.show();
    }

    public final String getNitaTag() {
        return VerticalNitaInflate.Tag.MultiLinkRadioWidgetView.name();
    }

    public final void onLiveEnd() {
        if (this.c == true) goto L9;
        IVoiceLiveTheme r0 = this.G;
        if (r0 == null) goto L7;
        r0.setChangeByAnchor(true);
    L7:
        AudioLiveThemeReporter.Companion.getClass();
        AudioLiveThemeReporter.access$setAnchor$p((AudioLiveThemeReporter) AudioLiveThemeReporter.access$getReporter$cp().getValue(), false);
        ((AudioLiveThemeReporter) AudioLiveThemeReporter.access$getReporter$cp().getValue()).onThemeEnd(this.G);
        return;
    }

    public final void onStart() {
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "RadioWidget", "call onStart");
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStart();
        if (MultiLinkLoadWidgetUtils.g() == false) goto L5;
        return;
    L5:
        if (vm2.e.a() == true) goto L7;
    L14:
        com.bytedance.android.livesdk.chatroom.utils.g0.e(1);
        return;
    L7:
        if ((getContext() instanceof FragmentActivity) == false) goto L14;
        if (this.N == true) goto L14;
        if (this.M != null) goto L13;
        this.M = new InteractLiveCorePermissionGuarantor();
        this.M.j(this.Y);
    L13:
        this.M.i((FragmentActivity) getContext());
        this.N = true;
        goto L14
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [zh0.e] */
    public RadioWidget() {
        this.a = -1;
        this.o = false;
        this.v = true;
        this.x = null;
        this.H = 0;
        this.J = new CompositeDisposable();
        this.K = new com.bytedance.android.livesdk.a(new y0.a(0));
        this.L = new SparseArray();
        this.N = false;
        this.P = new j(this, this);
        this.Q = false;
        this.S = null;
        this.T = false;
        this.V = false;
        this.W = false;
        this.X = null;
        this.Y = new a();
        this.Z = new zh0.e(this);
        this.k0 = false;
        this.p0 = false;
    }

    public final int Aq() {
        if (m.d() != null) goto L5;
    L9:
        return 0;
    L5:
        if (m.d().s() == null) goto L9;
        if (m.d().s().getValue() == null) goto L9;
        return ((com.bytedance.android.livesdk.chatroom.viewmodel.f) m.d().s().getValue()).t().a;
    }

    public final boolean Bq() {
        if (m.d() != null) goto L5;
        return false;
    L5:
        if (m.d().s() != null) goto L7;
        return false;
    L7:
        if (m.d().s().getValue() != null) goto L9;
        return false;
    L9:
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) m.d().s().getValue()).t() == null) goto L19;
        int r0 = ((com.bytedance.android.livesdk.chatroom.viewmodel.f) m.d().s().getValue()).t().a;
        int r2 = ((com.bytedance.android.livesdk.chatroom.viewmodel.f) m.d().s().getValue()).t().b;
        if (r0 == 9) goto L13;
        return false;
    L13:
        if (r2 != 61) goto L21;
        return true;
    L21:
        return false;
    L19:
        return false;
    }

    public final void Kq() {
        if (m.d() != null) goto L5;
    L11:
        int r2 = 0;
        int r3 = 0;
    L12:
        nh0.f r1 = new nh0.f("linkmic", new nh0.e(r2, r3, Collections.emptyList(), -1, -1, Collections.emptyList(), null, Collections.emptyList()), null, null, null, null, null, false);
        ((Widget) this).dataCenter.put("data_multi_lick_dynamic_event_change", r1);
        return;
    L5:
        if (m.d().s() == null) goto L11;
        if (m.d().s().getValue() == null) goto L11;
        if (((com.bytedance.android.livesdk.chatroom.viewmodel.f) m.d().s().getValue()).t() == null) goto L11;
        int r0 = ((com.bytedance.android.livesdk.chatroom.viewmodel.f) m.d().s().getValue()).t().a;
        r2 = r0;
        r3 = ((com.bytedance.android.livesdk.chatroom.viewmodel.f) m.d().s().getValue()).t().b;
        goto L12
    }

    public final void onDestroy() {
        super.onDestroy();
        if (MultiLinkLoadWidgetUtils.g() == false) goto L5;
    L11:
        d r0 = this.I;
        if (r0 == null) goto L14;
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.e(r0);
    L14:
        vlc.d r1 = this.O;
        if (r1 == null) goto L17;
        r1.removeMessageListener(this);
    L17:
        this.Q = false;
        if (InteractionWidgetsPosContext.getShared(((Widget) this).dataCenter, 0) == null) goto L20;
        InteractionWidgetsPosContext.getShared(((Widget) this).dataCenter, 0).getAudioTalkRadioBottomOffset().setValue(0);
    L20:
        RadioStageContainerWidget r2 = this.S;
        if (r2 == null) goto L26;
        WidgetManager r3 = ((Widget) this).subWidgetManager;
        if (r3 == null) goto L26;
        r3.unload(r2);
        this.S = null;
    L26:
        if (this.c == false) goto L30;
        zh0.c r4 = this.X;
        if (r4 == null) goto L30;
        r4.a();
    L30:
        Disposable r5 = this.R;
        if (r5 != null) goto L33;
    L35:
        Disposable r6 = this.U;
        if (r6 != null) goto L38;
        return;
    L38:
        if (r6.isDisposed() == true) goto L42;
        this.U.dispose();
        this.U = null;
        return;
    L42:
        return;
    L33:
        if (r5.isDisposed() == true) goto L35;
        this.R.dispose();
        this.R = null;
        goto L35
    L5:
        if (vm2.e.a() == true) goto L7;
    L10:
        com.bytedance.android.livesdk.chatroom.utils.g0.a();
        goto L11
    L7:
        if (this.M != null) goto L9;
        this.M = new InteractLiveCorePermissionGuarantor();
        this.M.j(this.Y);
    L9:
        this.M.e();
        this.N = false;
        goto L10
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        this.w.f = -1;
    }

    public final void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        this.h.detachView();
        np2.a r0 = this.E;
        if (r0 == null) goto L5;
        r0.g();
    L5:
        ((Widget) this).dataCenter.removeObserver("cmd_interact_audio", this.Z);
        ((Widget) this).dataCenter.removeObserver("cmd_interact_real_time_chorus", this.Z);
        ((Widget) this).dataCenter.removeObserver("cmd_voice_chat_room_show_background", this.Z);
        CompositeDisposable r1 = this.J;
        if (r1 == null) goto L9;
        r1.clear();
    L9:
        if (this.c == false) goto L16;
        x00.b r2 = this.y;
        if (r2 == null) goto L16;
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) ((VoiceLiveThemeManageDialog) r2).d).remove(this);
        if (this.y.isShowing() == false) goto L15;
        this.y.dismiss();
    L15:
        this.y = null;
    L16:
        k.f(IPerformanceManager.class).onModuleStop("audio_animated_bg");
        if (this.A == null) goto L19;
        y3.f(((Widget) this).dataCenter).d(ToolbarButton.VOICE_LIVE_THEME, this.A);
    L19:
        q r3 = this.F;
        if (r3 == null) goto L22;
        r3.d(this.G);
    L22:
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.d(getComponentContext(), yh0.c.class);
        this.k0 = false;
        MultiLinkThemePerfHelper r4 = this.C;
        if (r4 == null) goto L33;
        Function1<? super Map<String, com.bytedance.android.live.liveinteract.plantform.performance.d0>, Unit> r5 = r4.b;
        if (r5 == null) goto L31;
        IInteractService r6 = (IInteractService) k.f(IInteractService.class);
        if (r6 == null) goto L31;
        com.bytedance.android.live.liveinteract.plantform.performance.a r7 = r6.getMultiLinkPerfAbilityManager(false);
        if (r7 == null) goto L31;
        r7.d(r5);
    L31:
        r4.b = null;
        this.C = null;
        return;
    }

    public final void yq() {
        if (MultiLinkLoadWidgetUtils.g() == false) goto L5;
        return;
    L5:
        Object r0 = ((Widget) this).dataCenter.get("data_show_player");
        int r1 = ((Integer) ((Widget) this).dataCenter.get("feed_live_enter_ui_layout", 0)).intValue();
        if ((r0 instanceof Boolean) == true) goto L8;
        return;
    L8:
        if (r1 != 28) goto L12;
        xq(((Boolean) r0).booleanValue());
        return;
    }

    public final int zq() {
        if (m.d() != null) goto L5;
    L25:
        return 5;
    L5:
        if (m.d().s() == null) goto L25;
        if (m.d().s().getValue() == null) goto L25;
        int r0 = ((com.bytedance.android.livesdk.chatroom.viewmodel.f) m.d().s().getValue()).t().a;
        if (r0 != 5) goto L15;
        if (this.H != 29) goto L13;
        return 5;
    L13:
        return 2;
    L15:
        if (r0 != 9) goto L23;
        if (Bq() == false) goto L20;
        return 100;
    L20:
        return 1;
    L23:
        if (r0 != 16) goto L25;
        return 2;
    }

    static {
    }

    @Override // yh0.b, yh0.c
    public final com.bytedance.android.live.ui.c Y0() {
        return this.B;
    }

    @Override // yh0.b, yh0.c
    public final View c() {
        return this.l;
    }

    public final Lifecycle getLifecycleCompat() {
        return ((Widget) this).lifecycleRegistry;
    }

    @Override // yh0.b, yh0.c
    public final boolean isPickingImage() {
        return this.e;
    }

    @Override // yh0.b, yh0.c
    public final View j() {
        return this.D;
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
    }

    public final void onStop() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStop();
    }

    @Override // yh0.b, yh0.c
    public final void F4(boolean r3) {
        ih0.b r0 = this.g;
        if (r0 != null) goto L5;
    L13:
        Qq(r3);
        return;
    L5:
        if (r0.tb() == null) goto L13;
        LynxView r1 = this.g.tb().getHybridView();
        if ((r1 instanceof LynxView) == false) goto L13;
        View r2 = r1.findViewByName("radio_controller");
        if (r2 == null) goto L13;
        if (r3 == false) goto L12;
        r2.setVisibility(0);
        goto L13
    L12:
        r2.setVisibility(4);
        goto L13
    }

    public final void Mh(IVoiceLiveTheme r3) {
        if (this.z == null) goto L8;
        if (r3 == null) goto L9;
        r3.setFromPush(true);
        this.z.c(r3, r3.getBgType());
        this.z.l(r3.getBgType());
        return;
    L9:
        return;
    }

    public final void Qq(boolean r5) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("type", "avatar_visible");
        JsonObject r1 = new JsonObject();
        r1.addProperty("visible", Boolean.valueOf(r5));
        r0.add("data", r1);
        ih0.b r6 = this.g;
        if (r6 == null) goto L6;
        r6.Dk("radio", "radio_event", r0, false);
        return;
    }

    public final void Tq(boolean r5) {
        int r0 = w0.a;
        if (w0.d(this.b) == true) goto L5;
        return;
    L5:
        JsonObject r1 = new JsonObject();
        r1.addProperty("type", "radio_text_container");
        JsonObject r2 = new JsonObject();
        r2.addProperty("state", Boolean.valueOf(r5));
        r1.add("data", r2);
        ih0.b r6 = this.g;
        if (r6 == null) goto L9;
        r6.Dk("radio", "radio_event", r1, false);
        return;
    }

    public final void ar(IVoiceLiveTheme r3) {
        if (MultiLinkLoadWidgetUtils.g() == false) goto L6;
        return;
    L6:
        if (this.o == false) goto L8;
        return;
    L8:
        if (this.n == null) goto L24;
        if (r3 != null) goto L12;
    L20:
        this.n.setVisibility(8);
        return;
    L12:
        if (r3.getBgType() == 5) goto L16;
        if (r3.getBgType() != 2) goto L20;
    L16:
        if (r3.isUgcImage() == false) goto L20;
        if (vm2.d.s0() == false) goto L20;
        this.n.setVisibility(0);
        return;
    }

    public final void i10(IVoiceLiveTheme r3) {
        if (this.z == null) goto L6;
        r3.setFromPush(true);
        this.z.c(r3, r3.getBgType());
        ALogger.i("[FM]RadioWidget", "onAudienceThemeChanged.theme:" + r3);
        return;
    }

    @Override // md0.a.c
    public final void onAudioSubtitleUpdate(String r3) {
        if (this.a == 0) goto L5;
        return;
    L5:
        if (this.H != 0) goto L11;
        LinkmicSubtitleBusinessContext.a r0 = LinkmicSubtitleBusinessContext.Companion;
        if (r0.b() == null) goto L12;
        r0.b().sd(r3);
        return;
    L12:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        if (r5.getId() == 2131383588) goto L5;
        return;
    L5:
        if (this.d == false) goto L7;
        ((Widget) this).dataCenter.put("cmd_open_interact_manage_dialog_by_anchor", Boolean.TRUE);
    L7:
        IBaseUser r6 = this.b.getOwner();
        if (r6 != null) goto L10;
        return;
    L10:
        if (r6.getIdString().equals(k.f(IMiddlewareUserService.class).user().n()) == false) goto L12;
        String r0 = "oneself";
    L13:
        HashMap r1 = new HashMap();
        r1.put("user_id", r6.getIdString());
        r1.put("user_type", r0);
        if (((Integer) ((ge1.a) hd0.c.f()).b).intValue() != 2) goto L16;
        String r7 = "1";
    L17:
        r1.put("is_user_guest", r7);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_seat_head_click", r1, new Object[]{am2.x.class, IRoom.class});
        return;
    L16:
        r7 = "0";
        goto L17
    L12:
        r0 = "anchor";
        goto L13
    }

    public final void onConfigurationChanged(Configuration r2) {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r2);
        if (FoldScreenUtils.f() == false) goto L5;
    L6:
        ViewGroup r3 = ((Widget) this).containerView;
        if (r3 == null) goto L12;
        r3.post(new p(this));
        return;
    L12:
        return;
    L5:
        if (PadConfigUtils.a() == true) goto L6;
    }

    public final void onInit(Object... r3) {
        Lazy r4 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "RadioWidget", "call onInit");
        this.D = ((Widget) this).contentView.findViewById(2131387772);
        this.l = ((Widget) this).contentView.findViewById(2131383599);
        this.j = ((Widget) this).contentView.findViewById(2131383590);
        this.k = ((Widget) this).contentView.findViewById(2131383587);
        this.p = (VideoThemeView) ((Widget) this).contentView.findViewById(2131383617);
        this.q = ((Widget) this).contentView.findViewById(2131383597);
        this.r = (ImageView) ((Widget) this).contentView.findViewById(2131383588);
        this.t = ((Widget) this).contentView.findViewById(2131363704);
        this.s = ((Widget) this).contentView.findViewById(2131383605);
        this.u = ((Widget) this).contentView.findViewById(2131362578);
        this.m = (ImageView) ((Widget) this).contentView.findViewById(2131383592);
        this.n = (RadioDarkMaskView) ((Widget) this).contentView.findViewById(2131383596);
        this.w = (RadioTextBoardView) ((Widget) this).containerView.findViewById(2131383612);
        if (h.e() == false) goto L6;
        ((ViewGroup) ((Widget) this).containerView.findViewById(2131383589)).setClipChildren(true);
    L6:
        if (((Boolean) pb0.a.getValue()).booleanValue() == true) goto L8;
        return;
    L8:
        if (m.i() != null) goto L10;
        return;
    L10:
        if (m.i().isAnchor().booleanValue() == false) goto L12;
        return;
    L12:
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L18;
        ((ViewGroup.MarginLayoutParams) this.u.getLayoutParams()).topMargin += StatusBarUtil.getStatusBarHeight(s1.getContext());
        return;
    }

    public final void onLoad(Object... r4) {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        Lazy r5 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "RadioWidget", "call onLoad");
        LivePluginSPIManager.e.getClass();
        boolean r6 = LivePluginSPIManager.b();
        this.g = ((IInteractService) k.f(IInteractService.class)).dynamicService(((Widget) this).dataCenter);
        if (r6 == true) goto L5;
        Nq();
        return;
    L5:
        LivePluginSPIManager.a().addOnSuccess(new c(this)).addOnFail(new b(this)).syncCallbackIfReady(true).callbackOnMainThread().requireByUser("RadioWidget");
        d r7 = new d(this);
        this.I = r7;
        LivePluginSPIManager.d(r7);
    }

    public final void onMessage(tlc.d r13) {
        ALogger.i("RadioWidget", "onMessage: " + r13.getIntType());
        if ((r13 instanceof qb) == true) goto L5;
        return;
    L5:
        if (h.e() == false) goto L44;
        qb r14 = (qb) r13;
        if (this.a == 0) goto L15;
        if (r14.getPlaceholder() == 1) goto L11;
    L13:
        this.x = null;
        return;
    L11:
        if (r14.getTextBg() == null) goto L13;
        this.x = r14;
        return;
    L15:
        if (r14.getPlaceholder() != 1) goto L33;
        if (r14.getTextBg() == null) goto L33;
        if (this.w.getVisibility() != 8) goto L28;
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L28;
        if (InteractionWidgetsPosContext.getShared(r1, 0) == null) goto L28;
        int r2 = s1.j(2131168508);
        if (h.g() == false) goto L27;
        r2 = s1.j(2131168509);
    L27:
        InteractionWidgetsPosContext.getShared(((Widget) this).dataCenter, 0).getAudioTalkRadioBottomOffset().setValue(Integer.valueOf(r2));
        ((Widget) this).dataCenter.put("cmd_live_audio_room_request_text_message_height_change", new o42.c(false, true, "RadioWidget show"));
    L28:
        this.w.setVisibility(0);
        Tq(true);
        RadioTextBoardView r0 = this.w;
        com.bytedance.android.live.liveinteract.view.c.a r3 = com.bytedance.android.live.liveinteract.view.c.f;
        ok r15 = r14.getTextBg();
        r3.getClass();
        r0.T5(com.bytedance.android.live.liveinteract.view.c.a.a(r15));
        Zq(s1.j(2131168506), s1.j(2131168501));
        if (this.Q == true) goto L49;
        this.Q = true;
        HashMap r16 = new HashMap();
        r16.put("voice_mode", "head");
        r16.put("action_type", "play");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_live_text_show_play", r16, new Object[]{IRoom.class});
        return;
    L49:
        return;
    L33:
        if (this.w.getVisibility() != 0) goto L39;
        DataCenter r17 = ((Widget) this).dataCenter;
        if (r17 == null) goto L39;
        if (InteractionWidgetsPosContext.getShared(r17, 0) == null) goto L39;
        InteractionWidgetsPosContext.getShared(((Widget) this).dataCenter, 0).getAudioTalkRadioBottomOffset().setValue(0);
        ((Widget) this).dataCenter.put("cmd_live_audio_room_request_text_message_height_change", new o42.c(false, true, "RadioWidget gone"));
    L39:
        Tq(false);
        RadioTextBoardView r18 = this.w;
        r18.S5();
        r18.g = null;
        this.w.setVisibility(8);
        if (this.T == true) goto L48;
        Zq(s1.j(2131168503), s1.j(2131168500));
        return;
    L48:
        return;
    }

    @Override // md0.a.c
    public final void onRadioSeiUpdate(JSONObject r3) {
        JSONObject r4 = JSONObjectProtectorUtils.getJSONObject(r3, "radio_sei");     // Catch: Exception -> L7
        if (r4.has("speaking") == false) goto L10;
        this.W = r4.optBoolean("speaking");     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    @Override // md0.a.c
    public final void onRadioTextSeiUpdate(JSONObject r3) {
        ALogger.d("RadioWidget", "onRadioTextSeiUpdate: " + r3);
        ConstraintLayout r0 = this.w;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getVisibility() != 0) goto L9;
        this.w.R5(r3);
        return;
    }

    @Override // yh0.b, yh0.c
    public final void onSei(String r3) {
        if (h.e() == true) goto L7;
        int r0 = com.bytedance.android.live.liveinteract.voicechat.radio.e.a;
        if (com.bytedance.android.live.liveinteract.voicechat.radio.e.d(this.c) == true) goto L7;
        boolean r1 = true;
    L9:
        if (((Widget) this).isViewValid == false) goto L18;
        if (r1 == false) goto L13;
        return;
    L13:
        if (this.a != 0) goto L15;
    L16:
        this.P.d(r3);
        return;
    L15:
        if (je0.d.P() == true) goto L16;
        return;
    L18:
        return;
    L7:
        r1 = false;
        goto L9
    }

    @Override // yh0.b
    public final void p3(IRoom r8) {
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "RadioWidget", "call updateRoomAfterEnter");
        this.b = r8;
        ALogger.i("[FM]RadioWidget", "call updateThemeBackgroundAfterEnterRoom");
        if (MultiLinkLoadWidgetUtils.g() == false) goto L5;
        Yq();
        return;
    L5:
        boolean r2 = true;
        if (this.b.getBackground() == null) goto L16;
        LiveLinkmicAIMVContext r9 = LiveLinkmicAIMVContext.getContext();
        if (r9 != null) goto L10;
    L12:
        r2 = false;
    L13:
        if (r2 == true) goto L15;
        ImageUtil.loadImage(this.j, this.b.getBackground(), 2131248875);
    L15:
        ALogger.i("[FM]RadioWidget", "onLoad. use mRoom#background");
    L73:
        Yq();
        yq();
        return;
    L10:
        if (((Boolean) r9.isPlaying().getValue()).booleanValue() == false) goto L12;
    L16:
        x00.c r10 = this.z;
        if (r10 == null) goto L53;
        r10.b();
        if (this.b.getLinkMap() == null) goto L31;
        if (this.b.getLinkMap() == null) goto L34;
        if (this.b.getLinkMap().containsKey("5") == true) goto L31;
        if (this.b.getLinkMap().containsKey("0") == true) goto L31;
        if (this.b.getLinkMap().containsKey("16") == true) goto L31;
        if (this.b.getLinkMap().size() == 0) goto L31;
    L34:
        if (vm2.d.X().isAudienceEnable() == false) goto L45;
        if (this.b.getLinkMap() == null) goto L45;
        if (this.b.getLinkMap().containsKey("9") == false) goto L45;
        if (this.b.getVoiceLiveTheme() == null) goto L45;
        if (this.b.getVoiceLiveTheme().getBgType() != 1) goto L45;
        this.z.c(this.b.getVoiceLiveTheme(), 1);
    L45:
        if (this.b.getLinkMap() == null) goto L53;
        if (this.b.getLinkMap().containsKey("9") == false) goto L53;
        if (this.b.getVoiceLiveTheme() == null) goto L53;
        if (this.b.getVoiceLiveTheme().getBgType() != 100) goto L53;
        this.z.c(this.b.getVoiceLiveTheme(), 100);
    L31:
        if (IVoiceLiveThemeKt.isValid(this.b.getVoiceLiveTheme()) == false) goto L34;
        this.G = this.b.getVoiceLiveTheme();
        this.z.c(this.b.getVoiceLiveTheme(), this.G.getBgType());
    L53:
        ar(this.G);
        ALogger.d("RadioWidget", "updateThemeBackgroundAfterEnterRoom voice live theme " + this.G);
        if (this.b.getLinkMap() == null) goto L66;
        if (this.b.getLinkMap() == null) goto L69;
        if (this.b.getLinkMap().containsKey("5") == true) goto L66;
        if (this.b.getLinkMap().containsKey("0") == true) goto L66;
        if (this.b.getLinkMap().containsKey("16") == true) goto L66;
        if (this.b.getLinkMap().size() == 0) goto L66;
    L69:
        if (this.F == null) goto L73;
        if (Wq() == false) goto L73;
        this.F.a(this.G);
    L66:
        if (this.G != null) goto L69;
        this.G = com.bytedance.android.livesdk.model.k.a();
        goto L69
    }

    public final void xq(boolean r9) {
        if (MultiLinkLoadWidgetUtils.g() == false) goto L5;
        return;
    L5:
        ViewGroup r0 = ((Widget) this).containerView;
        if (r0 != null) goto L8;
        return;
    L8:
        int r1 = ((Integer) ((Widget) this).dataCenter.get("data_link_state", 0)).intValue();
        boolean r2 = gd0.v.a(r1, 4);
        boolean r3 = gd0.v.a(r1, 64);
        PaidSceneContext r4 = com.bytedance.android.livesdk.vscore_api.paidlive.scope.g.d(((Widget) this).dataCenter).u1(PaidSceneEnum.PAID_ROOM);
        if (r4 == null) goto L11;
        com.bytedance.android.livesdk.vscore_api.paidlive.l r5 = (com.bytedance.android.livesdk.vscore_api.paidlive.l) r4.getCurrentState().getValue();
        r5.getClass();
        boolean r6 = r5 instanceof com.bytedance.android.livesdk.vscore_api.paidlive.l.e;
    L12:
        Object r7 = null;
        boolean r8 = ((Boolean) vm2.d.I6.getValue(null, vm2.d.a[396(0x18c, float:5.55E-43)])).booleanValue();
        if (r9 == true) goto L21;
        if (r8 == false) goto L21;
        if (r2 == true) goto L21;
        if (r6 == true) goto L21;
        if (r3 == true) goto L21;
        UIUtils.setViewVisibility(r0, 0);
        return;
    L21:
        if (r0.getVisibility() != 8) goto L23;
        return;
    L23:
        DataCenter r10 = ((Widget) this).dataCenter;
        if (r10 == null) goto L28;
        r7 = r10.get("data_hamlet_avatar_status");
    L28:
        if ((r7 instanceof Boolean) == false) goto L30;
        boolean r11 = ((Boolean) r7).booleanValue();
    L31:
        if (r11 == false) goto L34;
        UIUtils.setViewVisibility(r0, 8);
        return;
    L34:
        return;
    L30:
        r11 = Cq();
        goto L31
    L11:
        r6 = false;
        goto L12
    }

    public static void Jq(boolean r3, String r4) {
        HashMap r0 = new HashMap();
        r0.put("event_name", "voice_live_anchor_container_show_status");
        r0.put("view_bg_reason", r4);
        if (r3 == false) goto L5;
        String r5 = "show";
    L6:
        r0.put("view_bg_status", r5);
        com.bytedance.android.livesdk.log.b0.o().b("ttlive_link", r0);
        return;
    L5:
        r5 = "hide";
        goto L6
    }

    public final <T> void L7(Class<T> r2, Consumer<T> r3) {
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r3);
    }

    public final void Lq(IVoiceLiveTheme r7, int r8) {
        if (this.c == true) goto L5;
    L10:
        if (r7 != null) goto L13;
        return;
    L13:
        if (r8 == zq()) goto L16;
        return;
    L16:
        if (r8 != 5) goto L18;
        boolean r2 = true;
    L19:
        if (r2 == true) goto L21;
    L38:
        q r3 = this.F;
        if (r3 == null) goto L47;
        if (r8 == 1) goto L42;
        r3.a(r7);
        goto L47
    L42:
        IVoiceLiveTheme r4 = this.G;
        if (r4 == null) goto L45;
        r4.setChangeByAnchor(true);
    L45:
        this.F.d(this.G);
    L47:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L49;
        return;
    L49:
        if (r8 == 1) goto L87;
        if (r8 == 2) goto L69;
        if (r8 == 5) goto L69;
        if (r8 == 100) goto L57;
        return;
    L57:
        if (IVoiceLiveThemeKt.isValid(r7) == true) goto L59;
        return;
    L59:
        IVoiceLiveTheme r9 = this.G;
        if (r9 != null) goto L62;
    L64:
        this.G = r7;
        if (this.c == true) goto L67;
        return;
    L67:
        if (Eq() == false) goto L103;
        this.z.m(this.b.getRoomId(), r7, 100);
        return;
    L103:
        return;
    L62:
        if (IVoiceLiveThemeKt.isSourceEqual(r9, r7) == false) goto L64;
        return;
    L69:
        IVoiceLiveTheme r10 = this.G;
        if (r10 == null) goto L79;
        if (r10.getBgStatus() != 3) goto L79;
        if (TextUtils.isEmpty(r7.getImageUri()) == true) goto L79;
        if (TextUtils.equals(r7.getImageUri(), this.G.getImageUri()) == false) goto L79;
        return;
    L79:
        if (this.G != null) goto L81;
    L85:
        this.G = r7;
        ar(r7);
        return;
    L81:
        if (TextUtils.isEmpty(r7.getLocalPath()) == true) goto L85;
        if (TextUtils.equals(r7.getLocalPath(), this.G.getLocalPath()) == false) goto L85;
        return;
    L87:
        if (IVoiceLiveThemeKt.isValid(r7) == true) goto L89;
        return;
    L89:
        IVoiceLiveTheme r11 = this.G;
        if (r11 != null) goto L92;
    L94:
        this.G = r7;
        if (this.c == true) goto L97;
        return;
    L97:
        if (this.z != null) goto L99;
        return;
    L99:
        if (Eq() == false) goto L108;
        this.z.m(this.b.getRoomId(), r7, 1);
        return;
    L108:
        return;
    L92:
        if (IVoiceLiveThemeKt.isSourceEqual(r11, r7) == false) goto L94;
        return;
    L21:
        if (this.l == null) goto L38;
        if (this.p == null) goto L38;
        ViewGroup r5 = (ViewGroup) ((Widget) this).contentView.findViewById(2131383589);
        if (r5 == null) goto L38;
        int r6 = r5.indexOfChild(this.p);
        if (r6 == (-1)) goto L38;
        r5.removeView(this.p);
        this.p.c();
        VideoThemeView r12 = new VideoThemeView(r5.getContext());
        r12.setId(2131383617);
        r12.setLayoutParams(this.p.getLayoutParams());
        r12.setVisibility(this.p.getVisibility());
        r5.addView(r12, r6);
        com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.a r13 = this.B;
        if (r13 == null) goto L37;
        Intrinsics.checkNotNullParameter(r12, "newVideoThemeView");
        com.bytedance.android.live.ui.o r14 = ((com.bytedance.android.live.ui.c) r13).q;
        if (r14 == null) goto L33;
        r14.c();
    L33:
        com.bytedance.android.live.ui.o r15 = ((com.bytedance.android.live.ui.c) r13).q;
        if (r15 == null) goto L36;
        r15.hide();
    L36:
        ((com.bytedance.android.live.ui.c) r13).q = r12;
    L37:
        this.p = r12;
        goto L38
    L18:
        r2 = false;
        goto L19
    L5:
        if (this.L.get(r8) != null) goto L7;
    L8:
        this.L.put(r8, Boolean.TRUE);
        return;
    L7:
        if (this.L.get(r8).booleanValue() == true) goto L10;
        goto L8
    }

    public final void Mq(ArrayList<IVoiceLiveTheme> r1, int r2) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (r2 != 1) goto L7;
    L13:
        x00.b r3 = this.y;
        if (r3 == null) goto L17;
        ((VoiceLiveThemeManageDialog) r3).M0();
        return;
    L17:
        return;
    L7:
        if (r2 == 2) goto L13;
        if (r2 == 5) goto L13;
        if (r2 == 100) goto L13;
    }

    public final void Sq(boolean r4, String r5) {
        JsonObject r0 = new JsonObject();
        r0.addProperty("type", "radio_stage");
        JsonObject r1 = new JsonObject();
        r1.addProperty("state", Boolean.valueOf(r4));
        int r2 = 108;
        if (((Boolean) pb0.a.getValue()).booleanValue() == true) goto L5;
    L7:
        r1.addProperty("avatar_bottom", Integer.valueOf((r2 + 120) - 19));
        r1.addProperty("screen_width", Float.valueOf(s1.G(s1.y())));
        r1.addProperty("screen_height", Float.valueOf(s1.G(s1.w())));
        if (r5.equals("subtitle") == false) goto L10;
        r1.addProperty("subtitle_state", "1");
    L10:
        r0.add("data", r1);
        ih0.b r6 = this.g;
        if (r6 == null) goto L14;
        r6.Dk("radio", "radio_event", r0, false);
        return;
    L14:
        return;
    L5:
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L7;
        r2 = 108 + ((int) s1.G(StatusBarUtil.getStatusBarHeight(s1.getContext())));
        goto L7
    }

    public final void Zq(int r3, int r4) {
        if (h.g() == true) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r0 = this.t.getLayoutParams();
        if (r0 == null) goto L8;
        r0.width = r3;
        r0.height = r3;
        this.t.setLayoutParams(r0);
    L8:
        int r1 = w0.a;
        if (w0.d(this.b) == true) goto L16;
        ViewGroup.LayoutParams r2 = this.s.getLayoutParams();
        if (r2 == null) goto L13;
        r2.width = r3;
        r2.height = r3;
        this.s.setLayoutParams(r2);
    L13:
        ViewGroup.LayoutParams r5 = this.r.getLayoutParams();
        if (r5 == null) goto L18;
        r5.width = r4;
        r5.height = r4;
        this.r.setLayoutParams(r5);
        return;
    L18:
        return;
    L16:
        Pq();
    }

    @Override // yh0.b, yh0.c
    public final void k(String r3, ye1.a r4) {
        if (h.e() == true) goto L7;
        int r0 = com.bytedance.android.live.liveinteract.voicechat.radio.e.a;
        if (com.bytedance.android.live.liveinteract.voicechat.radio.e.d(this.c) == true) goto L7;
        boolean r1 = true;
    L9:
        if (((Widget) this).isViewValid == false) goto L14;
        if (r1 == true) goto L15;
        this.P.e(r3, r4);
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r1 = false;
        goto L9
    }

    public final void lj(IVoiceLiveTheme r3, IVoiceLiveTheme r4) {
        if (this.c == false) goto L6;
        ALogger.i("[FM]RadioWidget", "onThemeRealSelected.preTheme:" + r3.getImageUri() + ",curTheme:" + r4.getImageUri());
        return;
    }

    public static boolean wq(RadioWidget r4, IVoiceLiveTheme r5, com.bytedance.android.live.ui.l r6) {
        r4.getClass();
        LiveLinkmicAIMVContext r0 = LiveLinkmicAIMVContext.getContext();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L19;
        if (r5 != null) goto L11;
    L15:
        com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.a r7 = r4.B;
        if (r7 == null) goto L18;
        r7.k();
    L18:
        r6.a(com.bytedance.android.live.liveinteract.aimv.b.a());
        goto L19
    L11:
        if (r5.getImageType() == 3) goto L15;
        q r8 = r4.F;
        if (r8 == null) goto L38;
        r8.d(r4.G);
    L38:
        return true;
    L19:
        CustomizeStreamContext.a r9 = CustomizeStreamContext.Companion;
        if (r9.getContext() != null) goto L22;
    L28:
        int r10 = zh0.a.a;
        com.bytedance.android.live.liveinteract.plantform.base.g r11 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r11 == null) goto L33;
        com.bytedance.android.live.ui.c r12 = r11.y4();
        if (r12 == null) goto L33;
        IVoiceLiveTheme r13 = r12.h;
    L34:
        if (r5 == r13) goto L36;
        return false;
    L36:
        if (vm2.d.S0() == false) goto L41;
        ALogger.i("RadioWidget", "theme not changed");
        goto L38
    L41:
        return false;
    L33:
        r13 = null;
        goto L34
    L22:
        if (r9.getContext().getNeedHideAudioBg() == null) goto L28;
        if (r9.getContext().getNeedHideAudioBg().getValue() == null) goto L28;
        if (((Boolean) r9.getContext().getNeedHideAudioBg().getValue()).booleanValue() == false) goto L28;
    L5:
        if (((Boolean) r0.isPlaying().getValue()).booleanValue() == false) goto L7;
        r1 = true;
        goto L8
    }

    @Override // yh0.b, yh0.c
    public final void onActivityResult(int r3, int r4, Intent r5) {
        if (this.i != null) goto L5;
        return;
    L5:
        if (vm2.d.M() != true) goto L7;
        this.i.r(r3, r4, r5);
        return;
    L7:
        this.i.q(r3, r4, r5);
    }
}
