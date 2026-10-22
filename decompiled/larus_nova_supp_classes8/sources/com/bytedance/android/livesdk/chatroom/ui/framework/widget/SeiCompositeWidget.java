package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAudienceService;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.framework.LoadState;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.bg1;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.widget.GestureDetectLayout;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.backupsei.LiveBackupSeiExperimentUtils;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerClientContext;
import com.bytedance.android.livesdkapi.roomplayer.SeiToJsonObject;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/SeiCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/t;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SeiCompositeWidget extends MiddlewareRoomWidget implements t {
    public static final /* synthetic */ int v = 0;
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.d b;
    public com.bytedance.android.livesdk.chatroom.ui.framework.a c;
    public ye1.e d;
    public ye1.d e;
    public final boolean f;
    public Integer g;
    public final com.bytedance.android.livesdk.interactivity.api.barrage.data.g h;
    public final com.bytedance.android.livesdk.interactivity.api.settings.config.a i;
    public com.bytedance.android.livesdk.chatroom.utils.i j;
    public int k;
    public x32.a l;
    public gd0.k m;
    public iy.d n;
    public p o;
    public yh0.c p;
    public b00.a q;
    public com.bytedance.android.live.pkaudience.api.c r;
    public com.bytedance.android.livesdk.widget.h0 s;
    public fd2.j t;
    public final CompositeDisposable u;

    public static final class a {
    }

    static {
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    public final iy.d xq() {
        if (this.n != null) goto L6;
        this.n = ho1.a.a(getComponentContext());
    L6:
        return this.n;
    }

    public final p yq() {
        if (this.o != null) goto L6;
        this.o = ho1.a.j(getComponentContext());
    L6:
        return this.o;
    }

    public final gd0.k zq() {
        if (this.m != null) goto L6;
        this.m = ho1.a.k(getComponentContext());
    L6:
        return this.m;
    }

    public SeiCompositeWidget() {
        this.f = bg1.b();
        this.h = new com.bytedance.android.livesdk.interactivity.api.barrage.data.g();
        this.i = (com.bytedance.android.livesdk.interactivity.api.settings.config.a) r52.s.a.getValue();
        this.u = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.a = ho1.a.d(getComponentContext());
        this.b = ho1.a.i(getComponentContext());
        this.c = ho1.a.c(getComponentContext());
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 == null) goto L5;
        boolean r1 = r0.dg();
    L6:
        if (r1 == false) goto L14;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r2 = this.c;
        if (r2 == null) goto L53;
        PropertyOwner r3 = r2.getLoadState();
        if (r3 == null) goto L53;
        Disposable r4 = com.bytedance.android.livesdk.chatroom.ui.framework.b.d(r3, new AnonymousClass1(this));
        if (r4 == null) goto L53;
        RxUtilKt.c(r4, this.u);
    L53:
        h70.b r5 = getComponentContext();
        if (r5 == null) goto L59;
        IAbilityCenter r6 = r5.a();
        if (r6 == null) goto L60;
        r6.registerAbility(t.class, this);
        return;
    L60:
        return;
    L59:
        return;
    L14:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r7 = this.a;
        if (r7 == null) goto L17;
        boolean r8 = r7.V9();
    L18:
        if (r8 == false) goto L46;
        int r9 = com.bytedance.android.livesdk.chatroom.ui.framework.utils.g.a;
        if (fh1.c.b(null, null, 3) == false) goto L27;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r10 = this.a;
        if (r10 == null) goto L24;
        boolean r11 = r10.V9();
    L25:
        if (r11 == false) goto L27;
        boolean r12 = true;
    L28:
        int r13 = com.bytedance.android.livesdk.chatroom.ui.framework.utils.g.a(r12);
        if (r13 == 0) goto L38;
        if (r13 != 1) goto L32;
        final LoadState r14 = LoadState.P0_BEGIN;
    L39:
        final Ref.BooleanRef r15 = new Ref.BooleanRef();
        r15.element = false;
        com.bytedance.android.livesdk.chatroom.ui.framework.a r16 = this.c;
        if (r16 == null) goto L53;
        PropertyOwner r17 = r16.getLoadState();
        if (r17 == null) goto L53;
        Disposable r18 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.p.a(r17, new AnonymousClass2(this, r15, r14));
        if (r18 == null) goto L53;
        RxUtilKt.c(r18, this.u);
        goto L53
    L32:
        if (r13 == 2) goto L36;
        if (r13 == 3) goto L35;
        r14 = LoadState.P1_BEGIN;
        goto L39
    L35:
        r14 = LoadState.P1_BEGIN;
        goto L39
    L36:
        r14 = LoadState.P0_END;
        goto L39
    L38:
        r14 = LoadState.FS_END;
        goto L39
    L24:
        r11 = true;
    L27:
        r12 = false;
        goto L28
    L46:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r19 = this.c;
        if (r19 == null) goto L53;
        PropertyOwner r20 = r19.getLoadState();
        if (r20 == null) goto L53;
        Disposable r21 = com.bytedance.android.livesdk.chatroom.ui.framework.b.b(r20, new AnonymousClass3(this));
        if (r21 == null) goto L53;
        RxUtilKt.c(r21, this.u);
        goto L53
    L17:
        r8 = true;
        goto L18
    L5:
        r1 = false;
        goto L6
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L7;
        IAbilityCenter r1 = r0.a();
        if (r1 == null) goto L7;
        r1.unregisterAbility(t.class);
    L7:
        this.u.dispose();
        if (this.d == null) goto L19;
        int r2 = af1.a.a;
        int r3 = hashCode();
        StringBuilder r4 = new StringBuilder("unbindBackupSeiGuestManager: roomId = ");
        DataCenter r5 = ((Widget) this).dataCenter;
        if (r5 == null) goto L14;
        Room r6 = com.bytedance.android.live.core.utils.z.o(r5);
        if (r6 == null) goto L14;
        Long r7 = Long.valueOf(r6.id);
    L15:
        r4.append(r7);
        af1.a.a("SeiCompositeWidget", r3, r4.toString(), true);
        ye1.e r8 = this.d;
        if (r8 == null) goto L19;
        r8.detach();
    L14:
        r7 = null;
    L19:
        if (this.e == null) goto L29;
        int r9 = af1.a.a;
        int r10 = hashCode();
        StringBuilder r11 = new StringBuilder("unbindBackupSeiAnchorManager: roomId = ");
        DataCenter r12 = ((Widget) this).dataCenter;
        if (r12 == null) goto L25;
        Room r13 = com.bytedance.android.live.core.utils.z.o(r12);
        if (r13 == null) goto L25;
        Long r14 = Long.valueOf(r13.id);
    L26:
        r11.append(r14);
        af1.a.a("SeiCompositeWidget", r10, r11.toString(), true);
        ye1.d r15 = this.e;
        if (r15 == null) goto L29;
        r15.b();
    L25:
        r14 = null;
    L29:
        com.bytedance.android.livesdk.chatroom.utils.i r16 = this.j;
        if (r16 == null) goto L32;
        r16.b();
    L32:
        this.j = null;
        this.a = null;
        this.c = null;
        this.b = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
    }

    public static final void wq(SeiCompositeWidget r8) {
        DataCenter r0 = ((Widget) r8).dataCenter;
        if (r0 == null) goto L16;
        Room r1 = com.bytedance.android.live.core.utils.z.o(r0);
        if (r1 != null) goto L8;
        return;
    L8:
        if (LiveBackupSeiExperimentUtils.INSTANCE.isEnableLiveBackupSei(r1, false) == false) goto L19;
        vlc.d r2 = (vlc.d) ((Widget) r8).dataCenter.get("data_message_manager", null);
        ILivePlayerClient r3 = LivePlatformPlayerManager.f();
        int r4 = af1.a.a;
        af1.a.a("SeiCompositeWidget", r8.hashCode(), "bindBackupSeiGuestManager: roomId = " + r1.getRoomId() + ", client = " + r3 + ", msgManager = " + r2, true);
        if (r3 == null) goto L14;
        if (r2 == null) goto L14;
        ye1.e r5 = ye1.f.a(r1, 0, r3, new a1(r2), new b1(r8));
        r8.d = r5;
        r5.attach();
        return;
    L14:
        af1.a.a("SeiCompositeWidget", r8.hashCode(), "bindBackupSeiGuestManager: failure", true);
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.t
    public final void H3(ByteBuffer r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (n22.a.a() == false) goto L39;
        com.bytedance.android.livesdk.interactivity.api.settings.config.a r0 = this.i;
        if (r0 != null) goto L9;
    L38:
        com.bytedance.android.livesdk.interactivity.api.settings.config.a r1 = this.i;     // Catch: Exception -> L36
        if (r1 == null) goto L25;
        if (r1.enableAsyncHandleSei == false) goto L25;
        if (this.j != null) goto L21;
        this.j = new com.bytedance.android.livesdk.chatroom.utils.i(this.h);     // Catch: Exception -> L36
    L21:
        com.bytedance.android.livesdk.chatroom.utils.i r2 = this.j;     // Catch: Exception -> L36
        if (r2 == null) goto L41;
        r2.a(r4);     // Catch: Exception -> L36
        return;
    L41:
        return;
    L25:
        if (com.bytedance.android.livesdk.interactivity.api.q.b() == null) goto L43;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r5 = com.bytedance.android.livesdk.interactivity.api.q.b();     // Catch: Exception -> L36
        if (r5 == null) goto L44;
        com.bytedance.live.datacontext.m r6 = r5.isInCarnival();     // Catch: Exception -> L36
        if (r6 != null) goto L31;
        return;
    L31:
        if (((Boolean) r6.getValue()).booleanValue() != true) goto L46;
        ILiveWrappedLivePusher.Companion.getClass();     // Catch: Exception -> L36
        ILiveWrappedLivePusher r7 = ILiveWrappedLivePusher.a.b();     // Catch: Exception -> L36
        if (r7 == null) goto L47;
        r7.getZlibCompressUtils();     // Catch: Exception -> L36
        return;
    L47:
        return;
    L46:
        return;
    L44:
        return;
    L43:
        return;
    L36:
        ALogger.e("CARNIVAL_MESSAGE", "parse binary data error");
        return;
    L9:
        if (r0.enableDropFrame.booleanValue() == false) goto L38;
        int r3 = this.k;
        if (r3 >= this.i.dropInterval) goto L13;
        this.k = r3 + 1;
        goto L38
    L13:
        this.k = 0;
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.t
    public final void b0(String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        boolean r1 = true;
        if (r0 != null) goto L7;
    L8:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r2 = this.a;
        if (r2 == null) goto L11;
        boolean r4 = r2.o5();
    L12:
        if (r4 == true) goto L15;
        r1 = false;
    L15:
        if (r1 == false) goto L20;
        p r5 = yq();
        if (r5 == null) goto L21;
        r5.b0(r3);
        return;
    L21:
        return;
    L20:
        return;
    L11:
        r4 = true;
        goto L12
    L7:
        if (r0.V9() == true) goto L15;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.t
    public final void onSei(String r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 == null) goto L7;
        boolean r1 = r0.dg();
    L8:
        x32.a r2 = null;
        if (r1 == false) goto L31;
        if (this.l != null) goto L18;
        h70.b r3 = getComponentContext();
        if (r3 == null) goto L17;
        IAbilityCenter r4 = r3.a();
        if (r4 == null) goto L17;
        r2 = (x32.a) r4.getAbility(x32.a.class);
    L17:
        this.l = r2;
    L18:
        x32.a r5 = this.l;
        if (r5 == null) goto L21;
        r5.onSei(r10);
    L21:
        gd0.k r6 = zq();
        if (r6 == null) goto L24;
        r6.onSei(r10);
    L24:
        iy.d r7 = xq();
        if (r7 == null) goto L27;
        r7.onSei(r10);
    L27:
        p r8 = yq();
        if (r8 == null) goto L210;
        r8.onSei(r10);
        return;
    L210:
        return;
    L31:
        if (this.l != null) goto L39;
        h70.b r9 = getComponentContext();
        if (r9 == null) goto L37;
        IAbilityCenter r11 = r9.a();
        if (r11 == null) goto L37;
        x32.a r12 = (x32.a) r11.getAbility(x32.a.class);
    L38:
        this.l = r12;
    L37:
        r12 = null;
    L39:
        x32.a r13 = this.l;
        if (r13 == null) goto L43;
        r13.onSei(r10);
    L43:
        if (this.q != null) goto L51;
        h70.b r14 = getComponentContext();
        if (r14 == null) goto L49;
        IAbilityCenter r15 = r14.a();
        if (r15 == null) goto L49;
        b00.a r16 = (b00.a) r15.getAbility(b00.a.class);
    L50:
        this.q = r16;
    L49:
        r16 = null;
    L51:
        b00.a r17 = this.q;
        if (r17 == null) goto L54;
        r17.onSei(r10);
    L54:
        LiveBackupSeiExperimentUtils r18 = LiveBackupSeiExperimentUtils.INSTANCE;
        DataCenter r19 = ((Widget) this).dataCenter;
        if (r19 == null) goto L57;
        Room r20 = com.bytedance.android.live.core.utils.z.o(r19);
    L58:
        Intrinsics.checkNotNull(r20);
        if (r18.isEnableLiveBackupSei(r20, false) == true) goto L73;
        gd0.k r21 = zq();
        if (r21 == null) goto L63;
        r21.onSei(r10);
    L63:
        iy.d r22 = xq();
        if (r22 == null) goto L67;
        r22.onSei(r10);
    L67:
        if (this.p != null) goto L69;
        this.p = ho1.a.m(getComponentContext());
    L69:
        yh0.c r23 = this.p;
        if (r23 == null) goto L73;
        r23.onSei(r10);
    L73:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L83;
        MiddlewareRoomContext r24 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r24 == null) goto L79;
        com.bytedance.live.datacontext.n r25 = r24.isRoomVisible();
        if (r25 == null) goto L79;
        Boolean r26 = (Boolean) r25.getValue();
    L81:
        if (Intrinsics.areEqual(r26, Boolean.FALSE) == false) goto L83;
        int r27 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a;
        com.bytedance.android.live.liveinteract.plantform.multiroom.a r28 = com.bytedance.android.live.liveinteract.plantform.multiroom.e.a(((Widget) this).dataCenter);
    L84:
        if (r28 == null) goto L86;
        r28.onSeiUpdate(r10);
    L86:
        p r29 = yq();
        if (r29 == null) goto L90;
        r29.onSei(r10);
    L90:
        if (this.r != null) goto L98;
        h70.b r30 = getComponentContext();
        if (r30 == null) goto L96;
        IAbilityCenter r31 = r30.a();
        if (r31 == null) goto L96;
        com.bytedance.android.live.pkaudience.api.c r32 = (com.bytedance.android.live.pkaudience.api.c) r31.getAbility(com.bytedance.android.live.pkaudience.api.c.class);
    L97:
        this.r = r32;
    L96:
        r32 = null;
    L98:
        com.bytedance.android.live.pkaudience.api.c r33 = this.r;
        if (r33 == null) goto L101;
        r33.onSei(r10);
    L101:
        IInteractGameService r34 = jc1.k.f(IInteractGameService.class);
        if (r34 == null) goto L104;
        r34.onSei(r10);
    L104:
        DataCenter r35 = ((Widget) this).dataCenter;
        if (r35 == null) goto L107;
        Room r36 = com.bytedance.android.live.core.utils.z.o(r35);
    L108:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r37 = this.b;
        if (r37 == null) goto L111;
        GestureDetectLayout r38 = r37.oh();
    L113:
        if ((r38 instanceof GestureDetectLayout) == true) goto L115;
        r38 = null;
    L115:
        if (r36 == null) goto L124;
        if (r38 == null) goto L124;
        if (this.s != null) goto L120;
        this.s = ho1.a.l(getComponentContext());
    L120:
        com.bytedance.android.livesdk.widget.h0 r39 = this.s;
        if (r39 == null) goto L124;
        r39.w7(r10, r38, r36);
    L124:
        if (this.f == true) goto L126;
        IOpenPlatformAudienceService r40 = jc1.k.f(IOpenPlatformAudienceService.class);
        if (r40 == null) goto L133;
        r40.onSei(r10);
    L133:
        com.bytedance.android.livesdk.chatroom.ui.framework.c r41 = this.a;
        if (r41 == null) goto L136;
        boolean r42 = r41.V9();
    L137:
        if (r42 == true) goto L139;
        return;
    L139:
        if (this.t != null) goto L147;
        h70.b r43 = getComponentContext();
        if (r43 == null) goto L145;
        IAbilityCenter r44 = r43.a();
        if (r44 == null) goto L145;
        fd2.j r45 = (fd2.j) r44.getAbility(fd2.j.class);
    L146:
        this.t = r45;
    L145:
        r45 = null;
    L147:
        fd2.j r46 = this.t;
        if (r46 == null) goto L150;
        r46.onSei(r10);
    L150:
        com.bytedance.android.livesdk.chatroom.utils.a0.c.b(r10);
        if (StringsKt.contains$default(r10, "anchor_video_play", false, 2, null) == false) goto L213;
        ALogger.d("VideoPlay", r10);
        ILivePlayerClient r47 = LivePlatformPlayerManager.f();     // Catch: Throwable -> L206
        if (r47 == null) goto L161;
        LivePlayerClientContext r48 = r47.context();     // Catch: Throwable -> L206
        if (r48 == null) goto L161;
        SeiToJsonObject r49 = r48.getCurrentSeiToJsonObject();     // Catch: Throwable -> L206
        if (r49 == null) goto L161;
        JSONObject r50 = r49.getSeiJsonObject();     // Catch: Throwable -> L206
        if (r50 == null) goto L161;
    L162:
        JSONObject r110 = r50.optJSONObject("anchor_video_play");     // Catch: Throwable -> L206
        if (r110 == null) goto L165;
        int r111 = r110.optInt("status");     // Catch: Throwable -> L206
    L166:
        MiddlewareRoomContext r51 = getMiddlewareRoomContext();     // Catch: Throwable -> L206
        if ((r51 instanceof RoomContext) == true) goto L169;
        r51 = null;
    L169:
        RoomContext r52 = (RoomContext) r51;     // Catch: Throwable -> L206
        if (r52 == null) goto L172;
        r2 = r52.getAnchorPlayingVideo();     // Catch: Throwable -> L206
    L172:
        ILivePlayerClient r53 = LivePlatformPlayerManager.f();     // Catch: Throwable -> L206
        if (r53 == null) goto L214;
        IRenderView r54 = r53.getRenderView();     // Catch: Throwable -> L206
        if (r54 == null) goto L215;
        ViewGroup.LayoutParams r55 = r54.getLayoutParams();     // Catch: Throwable -> L206
        if (r55 == null) goto L205;
        FrameLayout.LayoutParams r56 = (FrameLayout.LayoutParams) r55;     // Catch: Throwable -> L206
        if (r111 != 1) goto L183;
        boolean r112 = true;
    L184:
        if (r112 == true) goto L189;
        if (this.g != null) goto L189;
        return;
    L189:
        if (r112 == false) goto L191;
        int r57 = 8388693;
    L194:
        int r58 = r56.gravity;     // Catch: Throwable -> L206
        if (r57 == r58) goto L218;
        if (r58 == 8388693) goto L198;
        this.g = Integer.valueOf(r58);     // Catch: Throwable -> L206
    L198:
        r56.gravity = r57;     // Catch: Throwable -> L206
        r54.setLayoutParams(r56);     // Catch: Throwable -> L206
        if (r2 == null) goto L201;
        r2.setValue(Boolean.valueOf(r112));     // Catch: Throwable -> L206
    L201:
        LayerEventDispatcher r113 = o70.c.a(Integer.valueOf(((Widget) this).dataCenter.hashCode()));     // Catch: Throwable -> L206
        o42.c r59 = new o42.c(true, false, "VideoPlay");     // Catch: Throwable -> L206
        if (r113 == null) goto L219;
        r113.b(r59);     // Catch: Throwable -> L206
        return;
    L219:
        return;
    L218:
        return;
    L191:
        Integer r60 = this.g;     // Catch: Throwable -> L206
        if (r60 == null) goto L217;
        r57 = r60.intValue();     // Catch: Throwable -> L206
        goto L194
    L217:
        return;
    L183:
        r112 = false;
        goto L184
    L205:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");     // Catch: Throwable -> L206
    L215:
        return;
    L214:
        return;
    L165:
        r111 = 0;
    L161:
        r50 = new JSONObject(r10);     // Catch: Throwable -> L206
    L206:
        th = move-exception;
        th.printStackTrace();
        return;
    L213:
        return;
    L136:
        r42 = true;
        goto L137
    L126:
        if (StringsKt.contains$default(r10, "miniapp_anchor_operation_page_sei", false, 2, null) == false) goto L133;
        IOpenPlatformAudienceService r61 = jc1.k.f(IOpenPlatformAudienceService.class);
        if (r61 == null) goto L133;
        r61.onSei(r10);
        goto L133
    L111:
        r38 = null;
        goto L113
    L107:
        r36 = null;
    L79:
        r26 = null;
    L83:
        r28 = null;
        goto L84
    L57:
        r20 = null;
        goto L58
    L7:
        r1 = false;
        goto L8
    }
}
