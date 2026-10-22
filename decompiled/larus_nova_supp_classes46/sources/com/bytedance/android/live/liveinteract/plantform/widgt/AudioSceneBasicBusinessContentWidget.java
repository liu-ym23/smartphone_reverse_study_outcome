package com.bytedance.android.live.liveinteract.plantform.widgt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.message.n0;
import com.bytedance.android.live.broadcast.dialog.theme.VoiceLiveThemeAdapter;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.bgComponent.theme.VoiceLiveThemeManageDialog;
import com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene.AudioLiveThemeReporter;
import com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.a1;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.live.room.IMiddlewareLiveSDKService;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.chatroom.ui.framework.LoadState;
import com.bytedance.android.livesdk.chatroom.utils.g0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.message.model.gc;
import com.bytedance.android.livesdk.utils.k2;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/widgt/AudioSceneBasicBusinessContentWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lx00/d;", "Lcom/bytedance/android/live/liveinteract/utils/a1;", "Lvlc/l;", "Lcom/bytedance/android/live/liveinteract/c;", "Lgd0/f;", "<init>", "()V", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AudioSceneBasicBusinessContentWidget extends LiveRecyclableWidget implements x00.d, a1, vlc.l, com.bytedance.android.live.liveinteract.c, gd0.f {
    public static final /* synthetic */ int s = 0;
    public com.bytedance.android.live.room.g a;
    public x00.b b;
    public com.bytedance.android.live.liveinteract.bgComponent.theme.util.c c;
    public x00.c d;
    public IRoom e;
    public boolean f;
    public InteractLiveCorePermissionGuarantor g;
    public boolean h;
    public IVoiceLiveTheme i;
    public int j;
    public int k;
    public boolean l;
    public boolean m;
    public final CompositeDisposable n;
    public final SparseBooleanArray o;
    public final e p;
    public boolean q;
    public Disposable r;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.liveinteract.bgComponent.theme.util.c.a {
        public final /* synthetic */ AudioSceneBasicBusinessContentWidget a;

        @Override // com.bytedance.android.live.liveinteract.bgComponent.theme.util.c.a
        public final int getBgType() {
            AudioSceneBasicBusinessContentWidget r0 = this.a;
            int r1 = AudioSceneBasicBusinessContentWidget.s;
            return r0.yq();
        }

        public b(AudioSceneBasicBusinessContentWidget r1) {
            this.a = r1;
        }
    }

    public static final class c implements js0.b {
        public final /* synthetic */ AudioSceneBasicBusinessContentWidget a;

        public c(AudioSceneBasicBusinessContentWidget r1) {
            this.a = r1;
        }

        @Override // js0.b
        public final void onSuccess(String r3) {
            Intrinsics.checkNotNullParameter(r3, "s");
            AudioSceneBasicBusinessContentWidget r4 = this.a;
            DataCenter r0 = ((Widget) r4).dataCenter;
            if (r0 == null) goto L5;
            int r1 = AudioSceneBasicBusinessContentWidget.s;
            r4.Cq();
            return;
        L5:
            MultiLinkLoadWidgetUtils.n(r0, "AudioSceneBasicBusinessContentWidget", "load live_broadcast_plugin success, but datacenter null");
        }
    }

    public static final class d implements js0.a {
        public final /* synthetic */ AudioSceneBasicBusinessContentWidget a;

        public d(AudioSceneBasicBusinessContentWidget r1) {
            this.a = r1;
        }

        @Override // js0.a
        public final void onFail(String r3) {
            Intrinsics.checkNotNullParameter(r3, "s");
            Lazy r4 = MultiLinkLoadWidgetUtils.a;
            MultiLinkLoadWidgetUtils.n(((Widget) this.a).dataCenter, "AudioSceneBasicBusinessContentWidget", "load live_broadcast_plugin failed");
            f2.c("插件加载失败", 0);
        }
    }

    public static final class e implements InteractLiveCorePermissionGuarantor.a {
        public e() {
        }

        @Override // com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor.a
        public final void b(boolean r1) {
        }

        @Override // com.bytedance.android.live.liveinteract.utils.InteractLiveCorePermissionGuarantor.a
        public final void a(boolean r5) {
            if (r5 == false) goto L17;
            if (com.bytedance.android.live.liveinteract.api.utils.m.i().getLiveStream() == null) goto L29;
            com.bytedance.live.datacontext.j r6 = com.bytedance.android.live.liveinteract.api.utils.m.i().getLiveStream();
            if (r6 == null) goto L9;
            com.bytedance.android.live.pushstream.d r7 = (com.bytedance.android.live.pushstream.d) r6.getValue();
        L10:
            if (r7 == null) goto L30;
            com.bytedance.live.datacontext.j r8 = com.bytedance.android.live.liveinteract.api.utils.m.i().getLiveStream();
            if (r8 == null) goto L31;
            com.bytedance.android.live.pushstream.d r9 = (com.bytedance.android.live.pushstream.d) r8.getValue();
            if (r9 == null) goto L32;
            r9.Q0(true, "radio background pause", new uv0.a(LiveRequestSourceRole.Business, "AudioSceneBasicBusinessContentWidget.onTargetPageShow.pause", null));
            return;
        L32:
            return;
        L31:
            return;
        L30:
            return;
        L9:
            r7 = null;
            goto L10
        L29:
            return;
        L17:
            if (com.bytedance.android.live.liveinteract.api.utils.m.i().getLiveStream() == null) goto L34;
            com.bytedance.live.datacontext.j r10 = com.bytedance.android.live.liveinteract.api.utils.m.i().getLiveStream();
            if (r10 == null) goto L21;
            com.bytedance.android.live.pushstream.d r11 = (com.bytedance.android.live.pushstream.d) r10.getValue();
        L22:
            if (r11 == null) goto L35;
            com.bytedance.live.datacontext.j r12 = com.bytedance.android.live.liveinteract.api.utils.m.i().getLiveStream();
            if (r12 == null) goto L36;
            com.bytedance.android.live.pushstream.d r13 = (com.bytedance.android.live.pushstream.d) r12.getValue();
            if (r13 == null) goto L37;
            r13.Q0(false, "radio background resume", new uv0.a(LiveRequestSourceRole.Business, "AudioSceneBasicBusinessContentWidget.onTargetPageShow.resume", null));
            return;
        L37:
            return;
        L36:
            return;
        L35:
            return;
        L21:
            r11 = null;
            goto L22
        }
    }

    static {
    }

    public final String getSpm() {
        return "a100.a100.a256";
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        this.q = false;
        if (this.f == false) goto L15;
        x00.b r1 = this.b;
        if (r1 == null) goto L7;
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) ((VoiceLiveThemeManageDialog) r1).d).remove(this);
    L7:
        x00.b r2 = this.b;
        if (r2 != null) goto L10;
    L14:
        this.b = null;
        y3.f(((Widget) this).dataCenter).d(ToolbarButton.VOICE_LIVE_THEME, this.c);
        goto L15
    L10:
        if (r2.isShowing() != true) goto L14;
        x00.b r3 = this.b;
        if (r3 == null) goto L14;
        r3.dismiss();
    L15:
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.d(getComponentContext(), gd0.f.class);
        this.q = false;
    }

    public final void Aq() {
        IRoom r1 = this.e;
        Integer r2 = null;
        if (r1 == null) goto L5;
        py.k r3 = r1.getBackground();
    L6:
        if (r3 == null) goto L8;
        return;
    L8:
        IRoom r4 = this.e;
        if (r4 == null) goto L11;
        Map r5 = r4.getLinkMap();
    L13:
        if (this.f == false) goto L109;
        FragmentActivity r6 = ((Widget) this).context;
        if (r6 == null) goto L108;
        FragmentActivity r7 = r6;
        Fragment r15 = r7.getSupportFragmentManager().findFragmentByTag("AbsInteractionFragment");
        IMiddlewareLiveSDKService r13 = jc1.k.f(IMiddlewareLiveSDKService.class);
        if (r13 == null) goto L23;
        Context r11 = ((Widget) this).context;
        if (r11 == null) goto L22;
        com.bytedance.android.live.room.g r8 = r13.createImagePicker((Activity) r11, r15, "audio_scene_theme", ((Widget) this).dataCenter, 9, 16, 720, 1280, new com.bytedance.android.live.liveinteract.plantform.widgt.a(this, r7), null, "");
    L24:
        this.a = r8;
        if (r8 == null) goto L28;
        ((k2) r8).o = new com.bytedance.android.live.liveinteract.plantform.widgt.b(this);
    L28:
        if (Bq() == true) goto L65;
        IRoom r9 = this.e;
        if (r9 == null) goto L32;
        Integer r10 = Integer.valueOf(r9.getLinkMicScene());
    L33:
        if (r10 != null) goto L36;
    L47:
        if (r10 != null) goto L50;
    L56:
        if (r10 == null) goto L65;
        if (r10.intValue() != 0) goto L65;
        x00.c r12 = this.d;
        if (r12 == null) goto L63;
        IVoiceLiveTheme r14 = r12.q(5);
    L64:
        this.i = r14;
        goto L65
    L63:
        r14 = null;
        goto L64
    L50:
        if (r10.intValue() != 5) goto L56;
        x00.c r16 = this.d;
        if (r16 == null) goto L54;
        IVoiceLiveTheme r17 = r16.q(2);
    L55:
        this.i = r17;
        goto L65
    L54:
        r17 = null;
        goto L55
    L36:
        if (r10.intValue() != 9) goto L47;
        if (zq() == false) goto L42;
        x00.c r18 = this.d;
        if (r18 == null) goto L45;
        IVoiceLiveTheme r19 = r18.q(100);
    L46:
        this.i = r19;
    L45:
        r19 = null;
        goto L46
    L42:
        x00.c r20 = this.d;
        if (r20 == null) goto L45;
        r19 = r20.q(1);
        goto L46
    L32:
        r10 = null;
    L65:
        if (r5 != null) goto L67;
    L74:
        if (r4 == null) goto L76;
        IVoiceLiveTheme r21 = r4.getVoiceLiveTheme();
    L78:
        if (IVoiceLiveThemeKt.isValid(r21) == false) goto L94;
        if (r4 == null) goto L81;
        IVoiceLiveTheme r22 = r4.getVoiceLiveTheme();
    L82:
        this.i = r22;
        if (r4 == null) goto L85;
        IVoiceLiveTheme r23 = r4.getVoiceLiveTheme();
    L86:
        IVoiceLiveTheme r24 = this.i;
        if (r24 == null) goto L89;
        r2 = Integer.valueOf(r24.getBgType());
    L89:
        if (r23 == null) goto L94;
        if (r2 == null) goto L94;
        x00.c r25 = this.d;
        if (r25 == null) goto L94;
        r25.c(r23, r2.intValue());
        goto L94
    L85:
        r23 = null;
        goto L86
    L81:
        r22 = null;
    L94:
        x00.c r26 = this.d;
        if (r26 == null) goto L97;
        r26.p(this, new j(this), 2);
    L97:
        x00.c r27 = this.d;
        if (r27 == null) goto L100;
        r27.p(this, new k(this), 1);
    L100:
        x00.c r28 = this.d;
        if (r28 == null) goto L103;
        r28.p(this, new l(this), 100);
    L103:
        x00.c r29 = this.d;
        if (r29 == null) goto L106;
        r29.p(this, new m(this), 5);
    L106:
        this.c = new com.bytedance.android.live.liveinteract.bgComponent.theme.util.c(this, new b(this));
        y3.f(((Widget) this).dataCenter).k(ToolbarButton.VOICE_LIVE_THEME, this.c);
        ALogger.i("AudioSceneBasicBusinessContentWidget", "initVoiceLiveTheme.start.");
    L165:
        ALogger.d("AudioSceneBasicBusinessContentWidget", "init voice live theme " + this.i);
        if (this.i == null) goto L168;
        return;
    L168:
        if (this.f == false) goto L170;
        this.i = com.bytedance.android.livesdk.model.k.a();
        return;
    L170:
        if (r5 != null) goto L172;
    L179:
        this.i = com.bytedance.android.livesdk.model.k.a();
        return;
    L172:
        if (r5.containsKey("5") == true) goto L179;
        if (r5.containsKey("0") == true) goto L179;
        if (r5.containsKey("16") == true) goto L179;
        if (r5.isEmpty() == true) goto L179;
        return;
    L76:
        r21 = null;
        goto L78
    L67:
        if (r5.containsKey("5") == true) goto L74;
        if (r5.containsKey("0") == true) goto L74;
        if (r5.containsKey("16") == true) goto L74;
        if (r5.isEmpty() == false) goto L94;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L23:
        r8 = null;
        goto L24
    L108:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L109:
        if (r4 == null) goto L132;
        if (r5 == null) goto L132;
        if (r5.containsKey("5") == true) goto L132;
        if (r5.containsKey("0") == true) goto L132;
        if (r5.containsKey("16") == true) goto L132;
        IRoom r30 = this.e;
        if (r30 == null) goto L128;
        Map r31 = r30.getLinkMap();
        if (r31 == null) goto L128;
        if (((Boolean) vm2.h.V4.getValue(null, vm2.h.a[306(0x132, float:4.29E-43)])).booleanValue() == false) goto L128;
        if (r31.containsKey("1") == false) goto L128;
        boolean r32 = true;
    L129:
        if (r32 == true) goto L132;
        if (r5.isEmpty() == true) goto L132;
    L144:
        if (vm2.d.X().isAudienceEnable() == false) goto L155;
        if (r5 == null) goto L155;
        if (r5.containsKey("9") == false) goto L155;
        if (r4.getVoiceLiveTheme() == null) goto L155;
        IVoiceLiveTheme r33 = r4.getVoiceLiveTheme();
        Intrinsics.checkNotNull(r33);
        if (r33.getBgType() != 1) goto L155;
        x00.c r34 = this.d;
        if (r34 == null) goto L155;
        IVoiceLiveTheme r110 = r4.getVoiceLiveTheme();
        Intrinsics.checkNotNull(r110);
        r34.c(r110, 1);
    L155:
        if (r5 == null) goto L165;
        if (r5.containsKey("9") == false) goto L165;
        if (r4.getVoiceLiveTheme() == null) goto L165;
        IVoiceLiveTheme r35 = r4.getVoiceLiveTheme();
        Intrinsics.checkNotNull(r35);
        if (r35.getBgType() != 100) goto L165;
        x00.c r36 = this.d;
        if (r36 == null) goto L165;
        IVoiceLiveTheme r37 = r4.getVoiceLiveTheme();
        Intrinsics.checkNotNull(r37);
        r36.c(r37, 100);
    L128:
        r32 = false;
    L132:
        if (r4 == null) goto L134;
        IVoiceLiveTheme r38 = r4.getVoiceLiveTheme();
    L135:
        IVoiceLiveTheme r111 = this.i;
        if (r111 == null) goto L138;
        r2 = Integer.valueOf(r111.getBgType());
    L138:
        if (r38 == null) goto L144;
        if (r2 == null) goto L144;
        x00.c r112 = this.d;
        if (r112 == null) goto L144;
        r112.c(r38, r2.intValue());
        goto L144
    L134:
        r38 = null;
        goto L135
    L11:
        r5 = null;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    public final boolean Bq() {
        IRoom r0 = this.e;
        if (r0 != null) goto L7;
        return false;
    L7:
        return TextUtils.equals(r0.getLivePlatformSource(), "activity_auto_create");
    }

    public final void Cq() {
        this.e = (IRoom) ((Widget) this).dataCenter.get("data_room");
        Boolean r0 = (Boolean) ((Widget) this).dataCenter.get("data_is_anchor");
        boolean r1 = false;
        if (r0 == null) goto L5;
        boolean r2 = r0.booleanValue();
    L6:
        this.f = r2;
        int r3 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.bgComponent.platform.a r4 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.c(((Widget) this).dataCenter);
        if (r4 == null) goto L9;
        r4.oq();
    L9:
        IRoom r5 = this.e;
        if (r5 != null) goto L12;
    L26:
        IRoom r6 = this.e;
        Disposable r7 = null;
        if (r6 == null) goto L29;
        py.k r8 = r6.getBackground();
    L30:
        if (r8 != null) goto L32;
        r1 = true;
    L32:
        this.m = r1;
        IRoom r9 = this.e;
        if (r9 == null) goto L35;
        py.k r10 = r9.getBackground();
    L36:
        if (r10 != null) goto L57;
        IInteractService r11 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r11 == null) goto L40;
        x00.a r12 = r11.getThemeManager(this.f, ((Widget) this).dataCenter);
    L42:
        if ((r12 instanceof x00.c) == true) goto L44;
        r12 = null;
    L44:
        this.d = (x00.c) r12;
        Aq();
        x00.c r13 = this.d;
        if (r13 == null) goto L57;
        r13.j(this, new f(this), 2);
        x00.c r14 = this.d;
        if (r14 == null) goto L50;
        r14.j(this, new g(this), 1);
    L50:
        x00.c r15 = this.d;
        if (r15 == null) goto L53;
        r15.j(this, new h(this), 100);
    L53:
        x00.c r16 = this.d;
        if (r16 == null) goto L57;
        r16.j(this, new i(this), 5);
        goto L57
    L40:
        r12 = null;
    L57:
        if (com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.b(getComponentContext()) == false) goto L66;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.c(getComponentContext(), gd0.f.class, this);
        if (this.q == false) goto L66;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r17 = com.bytedance.android.livesdk.chatroom.ui.framework.utils.c.a(getComponentContext());
        if (r17 == null) goto L66;
        if (((LoadState) r17.getLoadState().a).getValue() < LoadState.P1_BEGIN.getValue()) goto L65;
        MainThreadPostUtils.b(new o(this));
        goto L66
    L65:
        this.r = com.bytedance.android.livesdk.chatroom.ui.framework.b.c(r17.getLoadState(), new AudioSceneBasicBusinessContentWidget$tryUpdateRoomAfterP1Load$2(this));
    L66:
        com.bytedance.android.livesdk.chatroom.u r18 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r18 == null) goto L75;
        com.bytedance.live.datacontext.j r19 = r18.s();
        if (r19 == null) goto L75;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r20 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r19.getValue();
        if (r20 == null) goto L75;
        BehaviorSubject r21 = r20.a();
        if (r21 == null) goto L75;
        Disposable r22 = r21.subscribe(new com.bytedance.android.live.liveinteract.plantform.widgt.d(this), com.bytedance.android.live.liveinteract.plantform.widgt.e.a);
    L76:
        if (r22 == null) goto L78;
        this.n.add(r22);
    L78:
        DataCenter r23 = ((Widget) this).dataCenter;
        if (r23 == null) goto L81;
        Void r24 = (Void) r23.get("data_message_manager", null);
    L82:
        vlc.d r25 = (vlc.d) r24;
        ALogger.i("AudioSceneBasicBusinessContentWidget", "observeMessage, messageManager=" + r25);
        if (r25 == null) goto L85;
        r25.addMessageListener(MessageType.VOICE_LIVE_THEME_MESSAGE.getIntType(), this);
    L85:
        if (r25 == null) goto L87;
        r25.addMessageListener(MessageType.CONTROL.getIntType(), this);
    L87:
        com.bytedance.android.livesdk.chatroom.u r26 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r26 == null) goto L96;
        com.bytedance.live.datacontext.j r27 = r26.s();
        if (r27 == null) goto L96;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r28 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r27.getValue();
        if (r28 == null) goto L96;
        BehaviorSubject r29 = r28.a();
        if (r29 == null) goto L96;
        r7 = r29.subscribe(new com.bytedance.android.live.liveinteract.plantform.widgt.c(this));
    L96:
        if (r7 == null) goto L99;
        this.n.add(r7);
        return;
    L99:
        return;
    L81:
        r24 = null;
    L75:
        r22 = null;
        goto L76
    L35:
        r10 = null;
        goto L36
    L29:
        r8 = null;
        goto L30
    L12:
        if (r5.getVoiceLiveTheme() == null) goto L26;
        IRoom r30 = this.e;
        if (r30 == null) goto L26;
        IVoiceLiveTheme r31 = r30.getVoiceLiveTheme();
        if (r31 == null) goto L26;
        if (r31.isRealTimeChorusTheme() != true) goto L26;
        if (vm2.c.k() == false) goto L26;
        IRoom r32 = this.e;
        if (r32 == null) goto L26;
        IVoiceLiveTheme r33 = r32.getVoiceLiveTheme();
        if (r33 == null) goto L26;
        r33.setBgType(100);
        goto L26
    L5:
        r2 = false;
        goto L6
    }

    @Override // gd0.f
    public final com.bytedance.android.live.ui.c Y0() {
        int r0 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.bgComponent.platform.a r1 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.c(((Widget) this).dataCenter);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.kb();
    }

    @Override // com.bytedance.android.live.liveinteract.utils.a1
    public final void bq() {
        if (this.b != null) goto L7;
        x00.b r0 = ((IInteractService) jc1.k.n(IInteractService.class)).createVoiceLiveThemeDialog(((Widget) this).context, false, this.a, yq(), ((Widget) this).dataCenter);
        this.b = r0;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) ((VoiceLiveThemeManageDialog) r0).d).add(this);
    L7:
        x00.b r1 = this.b;
        if (r1 == null) goto L12;
        int r2 = yq();
        VoiceLiveThemeManageDialog r3 = (VoiceLiveThemeManageDialog) r1;
        r3.h = r2;
        VoiceLiveThemeAdapter r4 = r3.b;
        if (r4 == null) goto L12;
        r4.g = r2;
    L12:
        x00.b r5 = this.b;
        if (r5 == null) goto L16;
        r5.show();
        return;
    }

    @Override // gd0.f
    public final View c() {
        int r0 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.bgComponent.platform.a r1 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.c(((Widget) this).dataCenter);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.c();
    }

    public AudioSceneBasicBusinessContentWidget() {
        this.j = -1;
        this.n = new CompositeDisposable();
        this.o = new SparseBooleanArray();
        this.p = new e();
    }

    public final void onDestroy() {
        super.onDestroy();
        Disposable r0 = this.r;
        Void r1 = null;
        if (r0 == null) goto L11;
        if (r0.isDisposed() == true) goto L11;
        Disposable r2 = this.r;
        if (r2 == null) goto L9;
        r2.dispose();
    L9:
        this.r = null;
    L11:
        if (vm2.e.a() == true) goto L13;
    L21:
        g0.a();
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L24;
        r1 = (Void) r3.get("data_message_manager", null);
    L24:
        vlc.d r4 = (vlc.d) r1;
        if (r4 == null) goto L27;
        r4.removeMessageListener(this);
    L27:
        this.n.dispose();
        return;
    L13:
        if (this.g != null) goto L17;
        this.g = new InteractLiveCorePermissionGuarantor();
        InteractLiveCorePermissionGuarantor r5 = this.g;
        if (r5 == null) goto L17;
        r5.j(this.p);
    L17:
        InteractLiveCorePermissionGuarantor r6 = this.g;
        if (r6 == null) goto L20;
        r6.e();
    L20:
        this.h = false;
        goto L21
    }

    public final void onStart() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onStart();
        if (vm2.e.a() == true) goto L5;
    L21:
        g0.e(1);
        return;
    L5:
        if ((getContext() instanceof FragmentActivity) == false) goto L21;
        if (this.h == true) goto L21;
        if (this.g != null) goto L13;
        this.g = new InteractLiveCorePermissionGuarantor();
        InteractLiveCorePermissionGuarantor r0 = this.g;
        if (r0 == null) goto L13;
        r0.j(this.p);
    L13:
        InteractLiveCorePermissionGuarantor r1 = this.g;
        if (r1 == null) goto L20;
        Context r2 = getContext();
        if (r2 == null) goto L19;
        r1.i((FragmentActivity) r2);
        goto L20
    L19:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L20:
        this.h = true;
        goto L21
    }

    public final int yq() {
        if (com.bytedance.android.live.liveinteract.api.utils.m.d() != null) goto L5;
    L44:
        return 5;
    L5:
        if (com.bytedance.android.live.liveinteract.api.utils.m.d().s() == null) goto L44;
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().s();
        Integer r2 = null;
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r0.getValue();
    L10:
        if (r1 == null) goto L44;
        com.bytedance.live.datacontext.j r3 = com.bytedance.android.live.liveinteract.api.utils.m.d().s();
        if (r3 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r3.getValue();
        if (r4 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r5 = r4.t();
        if (r5 == null) goto L19;
        r2 = Integer.valueOf(r5.a);
    L19:
        if (r2 != null) goto L22;
    L27:
        if (r2 != null) goto L30;
    L36:
        if (r2 != null) goto L39;
    L41:
        if (r2 == null) goto L44;
        r2.intValue();
        goto L44
    L39:
        if (r2.intValue() != 16) goto L41;
        return 2;
    L30:
        if (r2.intValue() != 9) goto L36;
        if (zq() == false) goto L34;
        return 100;
    L34:
        return 1;
    L22:
        if (r2.intValue() != 5) goto L27;
        if (this.k != 29) goto L26;
        return 5;
    L26:
        return 2;
    L9:
        r1 = null;
        goto L10
    }

    public final boolean zq() {
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.d().s();
        Integer r1 = null;
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r0.getValue();
        if (r2 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r3 = r2.t();
        if (r3 == null) goto L9;
        Integer r4 = Integer.valueOf(r3.a);
    L10:
        com.bytedance.live.datacontext.j r5 = com.bytedance.android.live.liveinteract.api.utils.m.d().s();
        if (r5 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r6 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r5.getValue();
        if (r6 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r7 = r6.t();
        if (r7 == null) goto L17;
        r1 = Integer.valueOf(r7.b);
    L17:
        if (r4 != null) goto L20;
    L26:
        return false;
    L20:
        if (r4.intValue() != 9) goto L26;
        if (r1 == null) goto L26;
        if (r1.intValue() != 61) goto L26;
        return true;
    L9:
        r4 = null;
        goto L10
    }

    @Override // gd0.f
    public final boolean isPickingImage() {
        return this.l;
    }

    public final void onLoad(Object[] r3) {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        Lazy r4 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "AudioSceneBasicBusinessContentWidget", "call onLoad");
        LivePluginSPIManager.e.getClass();
        if (LivePluginSPIManager.b() == true) goto L5;
        Cq();
        return;
    L5:
        LivePluginSPIManager.a().addOnSuccess(new c(this)).addOnFail(new d(this)).syncCallbackIfReady(true).callbackOnMainThread().requireByUser("AudioSceneBasicBusinessContentWidget");
    }

    public final void onMessage(tlc.d r6) {
        ALogger.i("AudioSceneBasicBusinessContentWidget", "onMessage, message=" + r6);
        if (this.m == false) goto L40;
        if ((r6 instanceof gc) == false) goto L40;
        gc r7 = (gc) r6;
        if (r7.getVoiceLiveTheme() != null) goto L9;
    L13:
        IVoiceLiveTheme r0 = r7.getVoiceLiveTheme();
        if (r7.getBgType() != 1) goto L16;
        return;
    L16:
        ALogger.i("AudioSceneBasicBusinessContentWidget", "themeMessage reviewPassed=" + r7.isReviewPassed() + " theme=" + r0);
        if (this.f == true) goto L19;
        if (r0 != null) goto L34;
        return;
    L34:
        if (IVoiceLiveThemeKt.isValid(r0) == false) goto L38;
        r0.setFromPush(true);
        x00.c r8 = this.d;
        if (r8 == null) goto L59;
        r8.c(r0, r0.getBgType());
        return;
    L59:
        return;
    L38:
        ALogger.i("VoiceLiveTheme", r0 + " is invalid");
        return;
    L19:
        if (r7.getToastText() != null) goto L21;
    L26:
        r0.setFromPush(true);
        x00.c r9 = this.d;
        if (r9 == null) goto L29;
        r9.c(r0, r0.getBgType());
    L29:
        x00.c r10 = this.d;
        if (r10 == null) goto L56;
        r10.l(r0.getBgType());
        return;
    L56:
        return;
    L21:
        if (r7.getToastText().length() <= 0) goto L23;
        boolean r1 = true;
    L24:
        if (r1 == false) goto L26;
        f2.c(r7.getToastText(), 0);
        goto L26
    L23:
        r1 = false;
        goto L24
    L9:
        if (r7.getVoiceLiveTheme().isRealTimeChorusTheme() == false) goto L13;
        if (vm2.c.k() == false) goto L13;
        r7.setBgType(100);
        r7.getVoiceLiveTheme().setBgType(100);
    L40:
        if ((r6 instanceof n0) == false) goto L62;
        long r2 = ((n0) r6).getAction();
        if (r2 == 3) goto L46;
        if (r2 == 4) goto L46;
        return;
    L46:
        if (this.f == true) goto L64;
        IVoiceLiveTheme r11 = this.i;
        if (r11 == null) goto L50;
        r11.setChangeByAnchor(true);
    L50:
        int r12 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.bgComponent.platform.a r13 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.c(((Widget) this).dataCenter);
        if (r13 == null) goto L65;
        AudioLiveThemeReporter r14 = r13.Mf();
        if (r14 == null) goto L66;
        r14.onThemeEnd(this.i);
        return;
    L66:
        return;
    L65:
        return;
    L64:
        return;
    }

    public final void p3(IRoom r4) {
        Intrinsics.checkNotNullParameter(r4, PbRequest.SwitchType.ROOM);
        Lazy r0 = MultiLinkLoadWidgetUtils.a;
        MultiLinkLoadWidgetUtils.n(((Widget) this).dataCenter, "AudioSceneBasicBusinessContentWidget", "call updateRoomAfterEnter");
        this.e = r4;
        if (r4 == null) goto L5;
        py.k r5 = r4.getBackground();
    L6:
        if (r5 != null) goto L8;
        boolean r6 = true;
    L9:
        this.m = r6;
        Aq();
        return;
    L8:
        r6 = false;
        goto L9
    L5:
        r5 = null;
        goto L6
    }

    public static final void xq(AudioSceneBasicBusinessContentWidget r0, ArrayList r1) {
        r0.getClass();
        if (r1 == null) goto L10;
        x00.b r2 = r0.b;
        if (r2 == null) goto L9;
        ((VoiceLiveThemeManageDialog) r2).M0();
        return;
    L9:
        return;
    }

    public final void lj(IVoiceLiveTheme r3, IVoiceLiveTheme r4) {
        Intrinsics.checkNotNullParameter(r3, "previousTheme");
        Intrinsics.checkNotNullParameter(r4, "currentTheme");
        if (this.f == false) goto L6;
        ALogger.i("AudioSceneBasicBusinessContentWidget", "onThemeRealSelected.preTheme:" + r3.getImageUri() + ",curTheme:" + r4.getImageUri());
        return;
    }

    public static final void wq(AudioSceneBasicBusinessContentWidget r4, IVoiceLiveTheme r5, int r6) {
        if (r4.f == false) goto L7;
        r4.o.get(r6);
        if (r4.o.get(r6) == true) goto L7;
        r4.o.put(r6, true);
        return;
    L7:
        IRoom r0 = r4.e;
        if (r0 == null) goto L90;
        if (r5 != null) goto L13;
        return;
    L13:
        if (r6 != r4.yq()) goto L92;
        if (r6 == 1) goto L63;
        if (r6 != 2) goto L19;
    L38:
        IVoiceLiveTheme r7 = r4.i;
        String r1 = null;
        if (r7 == null) goto L52;
        if (r7.getBgStatus() != 3) goto L52;
        if (TextUtils.isEmpty(r5.getImageUri()) == true) goto L52;
        String r8 = r5.getImageUri();
        IVoiceLiveTheme r2 = r4.i;
        if (r2 == null) goto L47;
        String r3 = r2.getImageUri();
    L49:
        if (TextUtils.equals(r8, r3) == false) goto L52;
        return;
    L47:
        r3 = null;
    L52:
        if (r4.i != null) goto L54;
    L61:
        r4.i = r5;
        return;
    L54:
        if (TextUtils.isEmpty(r5.getLocalPath()) == true) goto L61;
        String r9 = r5.getLocalPath();
        IVoiceLiveTheme r10 = r4.i;
        if (r10 == null) goto L59;
        r1 = r10.getLocalPath();
    L59:
        if (TextUtils.equals(r9, r1) == false) goto L61;
        return;
    L19:
        if (r6 == 5) goto L38;
        if (r6 == 100) goto L24;
        return;
    L24:
        if (IVoiceLiveThemeKt.isValid(r5) == false) goto L94;
        IVoiceLiveTheme r11 = r4.i;
        if (r11 != null) goto L29;
    L31:
        r4.i = r5;
        if (r4.f == true) goto L34;
        return;
    L34:
        if (r4.Bq() == false) goto L82;
        x00.c r12 = r4.d;
        if (r12 == null) goto L83;
        r12.m(r0.getRoomId(), r5, 100);
        return;
    L83:
        return;
    L82:
        return;
    L29:
        if (IVoiceLiveThemeKt.isSourceEqual(r11, r5) != true) goto L31;
        return;
    L94:
        return;
    L63:
        if (IVoiceLiveThemeKt.isValid(r5) == false) goto L98;
        IVoiceLiveTheme r13 = r4.i;
        if (r13 != null) goto L68;
    L70:
        r4.i = r5;
        if (r4.f == true) goto L73;
        return;
    L73:
        if (r4.d != null) goto L75;
        return;
    L75:
        if (r4.Bq() == false) goto L88;
        x00.c r14 = r4.d;
        if (r14 == null) goto L89;
        r14.m(r0.getRoomId(), r5, 1);
        return;
    L89:
        return;
    L88:
        return;
    L68:
        if (IVoiceLiveThemeKt.isSourceEqual(r13, r5) != true) goto L70;
        return;
    L98:
        return;
    L92:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.c, gd0.f
    public final void onActivityResult(int r3, int r4, Intent r5) {
        if (vm2.d.M() != true) goto L7;
        k2 r0 = this.a;
        if (r0 == null) goto L11;
        r0.r(r3, r4, r5);
        return;
    L11:
        return;
    L7:
        k2 r1 = this.a;
        if (r1 == null) goto L13;
        r1.q(r3, r4, r5);
        return;
    }
}
