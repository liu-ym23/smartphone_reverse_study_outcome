package com.bytedance.android.livesdk.floatview.inner;

import android.content.Context;
import android.content.res.Configuration;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.platformplayer.effect.VrEffectDownloader;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.message.model.ControlMessage;
import com.bytedance.android.livesdk.message.model.MemberMessage;
import com.bytedance.android.livesdk.utils.a6;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdk.utils.r5;
import com.bytedance.android.livesdk.utils.w5;
import com.bytedance.android.livesdk.utils.z4;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.message.PaidLiveTypeModifyData;
import com.bytedance.android.livesdkapi.depend.message.WebcastPaidLiveTypeModifyMessage;
import com.bytedance.android.livesdkapi.depend.message.wrds.IPreviewSyncDataType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.android.livesdkapi.floatview.InnerFloatViewTAG;
import com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.model.LiveFloatWindowStatus;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.config.setting.LiveVr6DofEffectConfig;
import com.bytedance.android.livesdkapi.player.LivePlayerStreamTypeUtils;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.livesdkapi.resolution.IResolutionService;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.android.livesdkapi.roomplayer.VideoEffectInitConfigBuilder;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k extends FrameLayout implements MessageHub, com.bytedance.android.livesdk.floatview.f, vlc.l, a6.b {
    public View a;
    public FrameLayout b;
    public RelativeLayout c;
    public FrameLayout d;
    public FrameLayout e;
    public LivePlayerView f;
    public ILivePlayerClient g;
    public long h;
    public HSImageView i;
    public View j;
    public RelativeLayout k;
    public TextView l;
    public TextView m;
    public RelativeLayout n;
    public FrameLayout o;
    public final String p;
    public Room q;
    public boolean r;
    public boolean s;
    public a6 t;
    public com.ss.ugc.live.sdk.msg.d u;
    public com.bytedance.android.livesdk.floatview.e v;
    public final com.bytedance.android.livesdk.floatview.mob.b w;
    public Disposable x;
    public final n y;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ WebcastPaidLiveTypeModifyMessage a;
        public final /* synthetic */ k b;

        public b(WebcastPaidLiveTypeModifyMessage r1, k r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.livesdk.floatview.e r0 = this.b.v;     // Catch: Throwable -> L13
            if (r0 == null) goto L5;
            r0.b();     // Catch: Throwable -> L13
        L5:
            PaidLiveTypeModifyData r1 = this.a.paidLiveModifyData;     // Catch: Throwable -> L13
            if (r1 == null) goto L16;
            PrivilegeInfo r2 = r1.data;     // Catch: Throwable -> L13
            if (r2 != null) goto L10;
            return;
        L10:
            if (r2.paidLiveType != 101) goto L21;
            f2.b(2131922927, 0);     // Catch: Throwable -> L13
            return;
        L21:
            return;
        L16:
            return;
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }
    }

    static {
    }

    public k() {
        throw null;
    }

    public final void addWRDSListener(IPreviewSyncDataType r1, OnWRDSDataUpdateListener r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void e() {
        this.s = true;
        LivePlayerView r0 = this.f;
        if (r0 == null) goto L6;
        r0.stop();
        return;
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void g() {
        this.s = false;
        Room r0 = this.q;
        if (r0 == null) goto L8;
        LivePlayerView r1 = this.f;
        if (r1 == null) goto L9;
        r1.start(l(r0));
        return;
    L9:
        return;
    }

    public /* bridge */ /* synthetic */ InnerContextEntity getContainContext() {
        return null;
    }

    public final <T extends tlc.d> T getLatestWRDSMessage(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "messageMethod");
        return null;
    }

    public /* bridge */ /* synthetic */ FrameLayout getVideoContainer() {
        return null;
    }

    public final void onScreenOff() {
    }

    public final void onScreenOn() {
    }

    public final void removeWRDSListener(IPreviewSyncDataType r2, OnWRDSDataUpdateListener r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "listener");
    }

    public void setContainContext(InnerContextEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void onPause() {
        com.bytedance.android.livesdk.floatview.mob.b r0 = this.w;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a == (-1)) goto L10;
        r0.c = SystemClock.elapsedRealtime();
        return;
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void onResume() {
        com.bytedance.android.livesdk.floatview.mob.b r0 = this.w;
        if (r0 == null) goto L6;
        r0.n();
        return;
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void onStart() {
        com.bytedance.android.livesdk.floatview.mob.b r0 = this.w;
        if (r0 == null) goto L6;
        r0.a = SystemClock.elapsedRealtime();
        return;
    }

    public final void p() {
        LivePlayerView r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.release();
        ILivePlayerScene r1 = null;
        setMLivePlayerView(null);
        this.g = null;
        ALogger.i("VideoWatchingInnerFloatWindowView", "release player");
        Room r2 = this.q;
        if (r2 == null) goto L18;
        RoomContext r3 = RoomContext.a.c(RoomContext.Companion, null, r2.getRoomId(), 1);
        if (r3 == null) goto L19;
        com.bytedance.live.datacontext.m r4 = r3.getFloatWindowStatus();
        if (r4 == null) goto L20;
        LiveFloatWindowStatus r5 = new LiveFloatWindowStatus();
        r5.setShow(false);
        LivePlayerView r6 = this.f;
        if (r6 == null) goto L16;
        LivePlayerConfig r7 = r6.getConfig();
        if (r7 == null) goto L16;
        r1 = r7.getScene();
    L16:
        r5.setScene(r1);
        Unit r8 = Unit.INSTANCE;
        r4.setValue(r5);
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void q() {
        com.bytedance.android.livesdk.floatview.mob.b r0 = this.w;
        if (r0 == null) goto L5;
        Room r1 = this.q;
        int r2 = com.bytedance.android.livesdk.floatview.mob.b.o;
        r0.g(r1, null);
    L5:
        HSImageView r3 = this.i;
        if (r3 == null) goto L8;
        r3.setVisibility(0);
    L8:
        View r4 = this.j;
        if (r4 == null) goto L11;
        r4.setVisibility(0);
    L11:
        RelativeLayout r5 = this.k;
        if (r5 == null) goto L14;
        r5.setVisibility(0);
    L14:
        LivePlayerView r6 = this.f;
        if (r6 == null) goto L17;
        r6.release();
    L17:
        this.x = du2.a.b(0, 1, TimeUnit.SECONDS).take(6).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new l(this));
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void stop() {
        ALogger.i("VideoWatchingInnerFloatWindowView", "ready to stop");
        com.bytedance.android.livesdk.floatview.mob.b r0 = this.w;
        if (r0 == null) goto L5;
        Room r2 = this.q;
        int r3 = com.bytedance.android.livesdk.floatview.mob.b.o;
        r0.f(r2, null);
    L5:
        reset();
        a6 r1 = this.t;
        if (r1 == null) goto L8;
        r1.a();
    L8:
        this.t = null;
    }

    private final View getRootLayout() {
        return LayoutInflater.from(getContext()).inflate(2131565325, this);
    }

    public final void onUserPresent() {
        if (getVisibility() != 0) goto L12;
        LivePlayerView r0 = this.f;
        if (r0 == null) goto L13;
        ILivePlayerClient r1 = r0.getClient();
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.isPlaying() == true) goto L15;
        g();
        return;
    L15:
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void reset() {
        p();
        this.q = null;
        this.s = false;
        com.bytedance.android.livesdk.floatview.mob.b r1 = this.w;
        if (r1 == null) goto L5;
        r1.a = -1;
        r1.b = -1;
        r1.c = -1;
        r1.d = 0;
        r1.m = null;
    L5:
        Disposable r2 = this.x;
        if (r2 == null) goto L8;
        r2.dispose();
    L8:
        this.x = null;
        com.ss.ugc.live.sdk.msg.d r3 = this.u;
        if (r3 == null) goto L11;
        r3.removeMessageListener(this);
    L11:
        com.ss.ugc.live.sdk.msg.d r4 = this.u;
        if (r4 == null) goto L14;
        r4.release();
    L14:
        this.u = null;
        ALogger.i("VideoWatchingInnerFloatWindowView", "remove message listener");
    }

    public com.bytedance.android.livesdk.floatview.mob.b getFloatWindowLogger() {
        return this.w;
    }

    public final LivePlayerView getMLivePlayerView() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final boolean isPaused() {
        return this.s;
    }

    public static final void i(k r5) {
        r5.getClass();
        Room r0 = jc1.k.n(IRoomService.class).getCurrentRoomFromRoomContext();
        Long r1 = null;
        if (r0 == null) goto L5;
        Long r2 = Long.valueOf(r0.id);
    L6:
        Room r3 = r5.q;
        if (r3 == null) goto L10;
        r1 = Long.valueOf(r3.id);
    L10:
        if (Intrinsics.areEqual(r2, r1) == false) goto L12;
        return;
    L12:
        if ((System.currentTimeMillis() - r5.h) < 5000) goto L17;
        r5.h = System.currentTimeMillis();
        w5.a();
        return;
    L17:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final LiveRequest l(Room r4) {
        IResolutionService r0 = jc1.k.f(IResolutionService.class);
        if (r0 == null) goto L8;
        PlayerResolution.PickResult r1 = r0.getWindowDefaultResolutionSdkKey(r4, "inner_float_window_resolution");
        if (r1 == null) goto L8;
        String r2 = r1.getResultSdkKey();
        if (r2 == null) goto L8;
    L9:
        LiveRequest r5 = new LiveRequest.Builder().streamData(r4.getMultiStreamData()).resolution(r2).streamType(LivePlayerStreamTypeUtils.INSTANCE.mapLiveModeToStreamType(r4.getStreamType())).preview(true).mute(true).build();
        ILivePlayerClient r3 = this.g;
        Intrinsics.checkNotNullParameter(r5, "liveRequest");
        if (LiveVr6DofEffectConfig.INSTANCE.getDisable() == true) goto L20;
        if (r3 == null) goto L20;
        com.bytedance.android.live.platformplayer.service.a r6 = jc1.k.f(com.bytedance.android.live.platformplayer.service.a.class);
        if (r6 == null) goto L18;
        VrEffectDownloader r7 = r6.T0();
        if (r7 == null) goto L18;
        VideoEffectInitConfigBuilder r8 = r7.f(r3);
    L19:
        r5.setVrEffectConfigBuilder(r8);
    L18:
        r8 = null;
    L20:
        return r5;
    L8:
        r2 = r4.getMultiStreamDefaultQualitySdkKey();
        goto L9
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        com.bytedance.android.livesdk.floatview.e r0 = this.v;
        if (r0 == null) goto L6;
        r0.onConfigurationChanged(r2);
        return;
    }

    public final void onMessage(tlc.d r7) {
        boolean r0 = r7 instanceof ControlMessage;
        if (r0 == false) goto L11;
        if (r0 == true) goto L6;
        r7 = null;
    L6:
        ControlMessage r8 = (ControlMessage) r7;
        if (r8 != null) goto L9;
        return;
    L9:
        if (r8.getAction() != 3) goto L36;
        ALogger.i("VideoWatchingInnerFloatWindowView", "receive live end message");
        q();
        return;
    L36:
        return;
    L11:
        boolean r1 = r7 instanceof WebcastPaidLiveTypeModifyMessage;
        if (r1 == false) goto L25;
        if (r1 == true) goto L15;
        r7 = null;
    L15:
        WebcastPaidLiveTypeModifyMessage r9 = (WebcastPaidLiveTypeModifyMessage) r7;
        if (r9 == null) goto L38;
        PaidLiveTypeModifyData r2 = r9.paidLiveModifyData;
        if (r2 != null) goto L20;
    L21:
        if (r2 != null) goto L23;
        return;
    L23:
        if (r2.operatorType != 1) goto L40;
    L24:
        q();
        MainThreadPostUtils.b(new b(r9, this));
        return;
    L40:
        return;
    L20:
        if (r2.operatorType == 2) goto L24;
    L38:
        return;
    L25:
        boolean r3 = r7 instanceof MemberMessage;
        if (r3 == false) goto L42;
        if (r3 == true) goto L29;
        r7 = null;
    L29:
        MemberMessage r10 = (MemberMessage) r7;
        if (r10 != null) goto L32;
        return;
    L32:
        if (r10.getAction() != 11) goto L44;
        ALogger.i("VideoWatchingInnerFloatWindowView", "receive kick out message");
        q();
        return;
    L44:
        return;
    }

    public void setFloatViewListener(com.bytedance.android.livesdk.floatview.e r1) {
        this.v = r1;
    }

    public final void setMLivePlayerView(LivePlayerView r1) {
        this.f = r1;
    }

    public final void addMessageListener(String r2, vlc.l r3) {
        Intrinsics.checkNotNullParameter(r2, "method");
        Intrinsics.checkNotNullParameter(r3, "listener");
        com.ss.ugc.live.sdk.msg.d r0 = this.u;
        if (r0 == null) goto L6;
        r0.addMessageListener(r2, r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void h(final Room r17, boolean r18) {
        if (IRoom.Companion.isValid(r17) == true) goto L6;
        ALogger.i("VideoWatchingInnerFloatWindowView", "room is not valid, return");
        return;
    L6:
        if (r17 != null) goto L8;
        return;
    L8:
        Room r2 = this.q;
        if (r2 != null) goto L11;
    L13:
        ALogger.i("VideoWatchingInnerFloatWindowView", "ready to start");
        this.s = false;
        Context r4 = s1.getContext();
        long r6 = r17.id;
        boolean r10 = r17.isMediaRoom();
        boolean r11 = r17.isMergeVSRoom();
        String r8 = r17.getOwnerUserIdString();
        n0.d();
        com.ss.ugc.live.sdk.msg.d r5 = z4.a(r4, new r5(r6, r8, false, r10, r11, "", null, false));
        this.u = r5;
        r5.addMessageListener(MessageType.CONTROL.getIntType(), this);
        com.ss.ugc.live.sdk.msg.d r7 = this.u;
        if (r7 == null) goto L16;
        r7.addMessageListener(MessageType.PAID_LIVE_TYPE_MODIFY_MESSAGE.getIntType(), this);
    L16:
        com.ss.ugc.live.sdk.msg.d r9 = this.u;
        if (r9 == null) goto L19;
        r9.addMessageListener(MessageType.MEMBER.getIntType(), this);
    L19:
        com.ss.ugc.live.sdk.msg.d r12 = this.u;
        if (r12 == null) goto L22;
        r12.startMessage();
    L22:
        ALogger.i("VideoWatchingInnerFloatWindowView", "add message listener");
        if (this.t != null) goto L25;
        a6 r13 = new a6(getContext());
        this.t = r13;
        r13.b(this);
    L25:
        this.q = r17;
        this.r = r18;
        p();
        FrameLayout r14 = this.d;
        ILivePlayerScene r15 = null;
        if (r14 == null) goto L71;
        Context r16 = getContext();
        LivePlayerView r19 = this.f;
        if (r19 == null) goto L35;
        r19.setVisibility(8);
        ViewParent r110 = r19.getParent();
        if ((r110 instanceof ViewGroup) == true) goto L32;
        r110 = null;
    L32:
        ViewGroup r111 = (ViewGroup) r110;
        if (r111 == null) goto L35;
        r111.removeView(r19);
    L35:
        LivePlayerConfig.Companion r112 = LivePlayerConfig.Companion;
        com.bytedance.android.livesdk.floatview.f.N0.getClass();
        setMLivePlayerView(new LivePlayerView(r16, r112.buildWith(com.bytedance.android.livesdk.floatview.f.a.c, r17.getIdStr())));
        ALogger.i("VideoWatchingInnerFloatWindowView", "create new LivePlayerView");
        LivePlayerView r20 = this.f;
        if (r20 == null) goto L38;
        ILivePlayerClient r21 = r20.getClient();
    L39:
        this.g = r21;
        FrameLayout.LayoutParams r22 = new FrameLayout.LayoutParams(-1, -1);
        r22.gravity = 17;
        LivePlayerView r23 = this.f;
        if (r23 == null) goto L42;
        r23.setLayoutParams(r22);
    L42:
        LivePlayerView r24 = this.f;
        if (r24 == null) goto L47;
        IRenderView r25 = r24.getRenderView();
        if (r25 == null) goto L47;
        r25.setLayoutParams(r22);
    L47:
        LivePlayerView r26 = this.f;
        if (r26 == null) goto L50;
        r26.setVisibility(0);
    L50:
        LivePlayerView r27 = this.f;
        if (r27 == null) goto L54;
        r27.setScaleType(2);
    L54:
        if (r14.indexOfChild(this.f) >= 0) goto L67;
        LivePlayerView r28 = this.f;
        if (r28 == null) goto L63;
        r28.setVisibility(8);
        ViewParent r29 = r28.getParent();
        if ((r29 instanceof ViewGroup) == true) goto L60;
        r29 = null;
    L60:
        ViewGroup r30 = (ViewGroup) r29;
        if (r30 == null) goto L63;
        r30.removeView(r28);
    L63:
        LivePlayerView r31 = this.f;
        if (r31 == null) goto L66;
        r31.setVisibility(0);
    L66:
        r14.addView(this.f);
    L67:
        LiveRequest r3 = l(r17);
        ILivePlayerClient r32 = this.g;
        if (r32 == null) goto L70;
        r32.stream(r3, new VideoWatchingInnerFloatWindowView$startPlayer$$inlined$let$lambda$1(this, r17));
    L70:
        ALogger.i("VideoWatchingInnerFloatWindowView", "start player");
        goto L71
    L38:
        r21 = null;
    L71:
        float r33 = UIUtils.getScreenWidth(getContext()) / UIUtils.getScreenHeight(getContext());
        User r1 = r17.getOwner();
        if (r1 == null) goto L76;
        ImageModel r34 = r1.getAvatarThumb();
        if (r34 == null) goto L76;
        List r35 = r34.getUrls();
    L78:
        if (Lists.notEmpty(r35) == false) goto L80;
        ImageLoader.bindImage(this.i, new ImageModel(null, r35), new l3(2, r33, null));
    L81:
        Room r36 = this.q;
        if (r36 == null) goto L94;
        RoomContext r37 = RoomContext.a.c(RoomContext.Companion, null, r36.getRoomId(), 1);
        if (r37 == null) goto L95;
        com.bytedance.live.datacontext.m r38 = r37.getFloatWindowStatus();
        if (r38 == null) goto L96;
        LiveFloatWindowStatus r39 = new LiveFloatWindowStatus();
        r39.setShow(true);
        LivePlayerView r40 = this.f;
        if (r40 == null) goto L92;
        LivePlayerConfig r41 = r40.getConfig();
        if (r41 == null) goto L92;
        r15 = r41.getScene();
    L92:
        r39.setScene(r15);
        Unit r42 = Unit.INSTANCE;
        r38.setValue(r39);
        return;
    L96:
        return;
    L95:
        return;
    L94:
        return;
    L80:
        ImageLoader.bindImage(this.i, "res://" + getContext().getPackageName() + "/2131251156", new l3(5, r33, null));
    L76:
        r35 = null;
        goto L78
    L11:
        if (r2.id != r17.id) goto L13;
    }

    public final void removeMessageListener(String r2, vlc.l r3) {
        Intrinsics.checkNotNullParameter(r2, "method");
        Intrinsics.checkNotNullParameter(r3, "listener");
        com.ss.ugc.live.sdk.msg.d r0 = this.u;
        if (r0 == null) goto L6;
        r0.removeMessageListener(r2, r3);
        return;
    }

    public final void addMessageListener(int r2, vlc.l r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        com.ss.ugc.live.sdk.msg.d r0 = this.u;
        if (r0 == null) goto L6;
        r0.addMessageListener(r2, r3);
        return;
    }

    public final void removeMessageListener(int r2, vlc.l r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        com.ss.ugc.live.sdk.msg.d r0 = this.u;
        if (r0 == null) goto L6;
        r0.removeMessageListener(r2, r3);
        return;
    }

    public k(Context r3, String r4, HashMap r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "tag");
        Intrinsics.checkNotNullParameter(r5, "mobParams");
        Intrinsics.checkNotNullParameter("content", "initialPage");
        super(r3);
        new LinkedHashMap();
        this.p = InnerFloatViewTAG.TAG_VIDEO_PREVIEW.getTag();
        this.y = new n(this);
        this.p = r4;
        View r6 = getRootLayout();
        this.a = r6;
        if (r6 == null) goto L9;
        this.e = (FrameLayout) r6.findViewById(2131372944);
        this.i = r6.findViewById(2131372941);
        this.j = r6.findViewById(2131372942);
        this.k = (RelativeLayout) r6.findViewById(2131372949);
        this.l = (TextView) r6.findViewById(2131372946);
        this.b = (FrameLayout) r6.findViewById(2131372939);
        this.d = (FrameLayout) r6.findViewById(2131372961);
        this.c = (RelativeLayout) r6.findViewById(2131372938);
        this.m = (TextView) r6.findViewById(2131379208);
        this.n = (RelativeLayout) r6.findViewById(2131379205);
        this.o = (FrameLayout) r6.findViewById(2131372951);
        RelativeLayout r7 = this.c;
        if (r7 == null) goto L9;
        r7.setOnClickListener(new m(this));
    L9:
        if (Intrinsics.areEqual(r4, InnerFloatViewTAG.TAG_LOTTERY_PREVIEW.getTag()) == false) goto L11;
        String r8 = "lottery";
    L12:
        this.w = new com.bytedance.android.livesdk.floatview.mob.b(1, "content", r8, r5);
        return;
    L11:
        r8 = "";
        goto L12
    }
}
