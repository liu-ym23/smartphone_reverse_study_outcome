package com.bytedance.android.livesdk.floatview;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.customview.widget.ViewDragHelper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.resolution.AudienceVideoResolutionManager;
import com.bytedance.android.livesdk.chatroom.ui.AudioWaveView;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.config.bx;
import com.bytedance.android.livesdk.config.jf;
import com.bytedance.android.livesdk.config.t9;
import com.bytedance.android.livesdk.config.zw;
import com.bytedance.android.livesdk.floatview.mob.VideoFloatWindowLogger;
import com.bytedance.android.livesdk.utils.a6;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdk.utils.w5;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerFrameLayout;
import com.bytedance.android.livesdkapi.depend.model.FloatWindowBusinessLine;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.FloatFeedViewHandler;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.model.ListenLiveStatus;
import com.bytedance.android.livesdkapi.model.LiveFloatWindowStatus;
import com.bytedance.android.livesdkapi.player.LivePlayerStreamTypeUtils;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.livesdkapi.resolution.IResolutionService;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerConfig;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.LiveRequest;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.IBizAbilityHandler;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.LiveBizWindowAbilityCenter;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowLayoutAbility;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowLogAbility;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowWidgetAbility;
import com.bytedance.android.livesdkapi.view.ILivePlayerView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class VideoFloatWindowView extends FrameLayout implements f, a6.b, FloatFeedViewHandler.IFloatFeedContext, IBizAbilityHandler {
    public FrameLayout.LayoutParams A;
    public boolean B;
    public com.bytedance.android.livesdk.floatview.b C;
    public final c D;
    public final b E;
    public Map<Integer, View> a;
    public e b;
    public Disposable c;
    public Disposable d;
    public Disposable e;
    public int f;
    public final boolean g;
    public Room h;
    public LivePlayerView i;
    public int j;
    public int k;
    public InnerContextEntity l;
    public final int m;
    public com.bytedance.android.livesdk.floatview.mob.b n;
    public a6 o;
    public long p;
    public final long q;
    public boolean r;
    public boolean s;
    public Boolean t;
    public String u;
    public final Lazy v;
    public final List<String> w;
    public LiveBizWindowAbilityCenter x;
    public View y;
    public FrameLayout.LayoutParams z;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ VideoFloatWindowView a;

        public b(VideoFloatWindowView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Boolean r5 = (Boolean) r4;
            ALogger.i("VideoFloatWindowView", "BackGround Observer receive notify");
            Room r0 = this.a.h;
            if (r0 == null) goto L25;
            ILivePlayerClient r1 = null;
            if (VrUtils.x(r0) == false) goto L15;
            LivePlayerView r2 = this.a.getMLivePlayerView$livesdk_saasRelease();
            if (r2 == null) goto L11;
            ILivePlayerClient r3 = r2.getClient();
            if (r3 == null) goto L11;
            r3.onForeground();
        L11:
            StringBuilder r6 = new StringBuilder("this is vr room, client is ");
            LivePlayerView r7 = this.a.getMLivePlayerView$livesdk_saasRelease();
            if (r7 == null) goto L14;
            r1 = r7.getClient();
        L14:
            r6.append(r1);
            ALogger.i("VideoFloatWindowView", r6.toString());
            return;
        L15:
            LivePlayerView r8 = this.a.getMLivePlayerView$livesdk_saasRelease();
            if (r8 == null) goto L20;
            ILivePlayerClient r9 = r8.getClient();
            if (r9 == null) goto L20;
            r9.onBackground();
        L20:
            StringBuilder r10 = new StringBuilder("this is normal room, client is ");
            LivePlayerView r11 = this.a.getMLivePlayerView$livesdk_saasRelease();
            if (r11 == null) goto L23;
            r1 = r11.getClient();
        L23:
            r10.append(r1);
            ALogger.i("VideoFloatWindowView", r10.toString());
            return;
        }
    }

    public static final class c implements ILivePlayerView.PlayerCallback {
        public final /* synthetic */ VideoFloatWindowView a;

        public static final class a implements Runnable {
            public final /* synthetic */ c a;

            public a(c r1) {
                this.a = r1;
            }

            public final void a() {
                Rect r0 = new Rect();
                ((FrameLayout) this.a.a.a(2131372939)).getGlobalVisibleRect(r0);
                VideoFloatWindowView r1 = this.a.a;
                e r3 = r1.b;
                if (r3 == null) goto L5;
                r3.onShow(r0.left, r0.top, ((FrameLayout) r1.a(2131372939)).getMeasuredWidth(), ((FrameLayout) this.a.a.a(2131372939)).getMeasuredHeight());
            L5:
                ALogger.i("VideoFloatWindowView", "onShow --- x: " + r0.left + ", y: " + r0.top + ", width: " + ((FrameLayout) this.a.a.a(2131372939)).getMeasuredWidth() + ", height: " + ((FrameLayout) this.a.a.a(2131372939)).getMeasuredHeight());
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final void onBufferingEnd() {
        }

        public final void onBufferingStart() {
        }

        public final void onInteractSeiUpdate(Object r1) {
        }

        public final void onPlayComplete() {
            VideoFloatWindowView.f(this.a);
        }

        public final void onPlayDisplayed() {
            ((FrameLayout) this.a.a(2131372902)).setVisibility(0);
            Room r0 = this.a.h;
            if (r0 != null) goto L5;
        L7:
            ALogger.i("VideoFloatWindowView", "onfirstframe: view become visible");
            VideoFloatWindowView r1 = this.a;
            com.bytedance.android.livesdk.floatview.mob.b r2 = r1.n;
            if (r2 == null) goto L10;
            r2.j(true, r1.h, r1.getContainContext());
        L10:
            String r4 = null;
            RoomContext r3 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r3 != null) goto L13;
            return;
        L13:
            if (r3.getFloatWindowRevisitParam() == null) goto L24;
            Lazy r5 = VideoFloatWindowLogger.a;
            VideoFloatWindowLogger r6 = VideoFloatWindowLogger.a.a();
            InnerContextEntity r7 = this.a.l;
            if (r7 == null) goto L21;
            InnerContextEntity.InnerFloatExtra r8 = r7.getEnterExtra();
            if (r8 == null) goto L21;
            FloatWindowBusinessLine r9 = r8.getBusinessLine();
            if (r9 == null) goto L21;
            r4 = r9.getValue();
        L21:
            r6.getClass();
            VideoFloatWindowLogger.g(r4);
            return;
        L24:
            return;
        L5:
            if (r0.getStreamType() == LiveMode.AUDIO) goto L7;
            this.a.a(2131372922).setVisibility(8);
            goto L7
        }

        public final void onRoomFinish() {
            this.a.k();
        }

        public c(VideoFloatWindowView r1) {
            this.a = r1;
        }

        public final void onError(String r1) {
            VideoFloatWindowView.f(this.a);
        }

        public final void onMute(boolean r3) {
            this.a.a(2131372953).setSelected(r3);
            ALogger.i("VideoFloatWindowView", "onMute: " + r3);
        }

        public final void onVideoSizeChanged(int r5, int r6) {
            boolean r0 = false;
            if (r5 >= r6) goto L5;
            boolean r2 = true;
        L7:
            if (VrUtils.d(VideoFloatWindowView.c(this.a)) == false) goto L19;
            DataCenter r3 = VideoFloatWindowView.c(this.a);
            if (r3 != null) goto L11;
        L13:
            DataCenter r4 = VideoFloatWindowView.c(this.a);
            if (r4 != null) goto L16;
        L17:
            if (r2 == false) goto L19;
        L18:
            r0 = true;
            goto L19
        L16:
            if (com.bytedance.android.live.core.utils.z.m(r4, true) == true) goto L19;
        L11:
            if (com.bytedance.android.live.core.utils.z.m(r3, true) != true) goto L13;
            if (r2 == false) goto L18;
        L19:
            if (r0 == false) goto L21;
            VideoFloatWindowView r1 = this.a;
            r1.j = r6;
            r1.k = r5;
        L22:
            this.a.m();
            ((FrameLayout) this.a.a(2131372939)).post(new a(this));
            return;
        L21:
            VideoFloatWindowView r7 = this.a;
            r7.j = r5;
            r7.k = r6;
            goto L22
        L5:
            r2 = false;
            goto L7
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ VideoFloatWindowView a;

        public d(VideoFloatWindowView r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            h1 r9 = (h1) r8;
            VideoFloatWindowView r0 = this.a;
            r0.getClass();
            Long r4 = null;
            if (r9.a != 7) goto L16;
            IRoom r1 = r9.c;
            if (r1 == null) goto L7;
            Long r2 = Long.valueOf(r1.getId());
        L8:
            Room r3 = r0.h;
            if (r3 == null) goto L11;
            Long r5 = Long.valueOf(r3.id);
        L13:
            if (Intrinsics.areEqual(r2, r5) == false) goto L16;
            ALogger.i("VideoFloatWindowView", "on receive show end dialog event, type: " + r0.m);
            r0.D.onRoomFinish();
            goto L16
        L11:
            r5 = null;
            goto L13
        L7:
            r2 = null;
        L16:
            if (r9.a != 66) goto L29;
            IRoom r6 = r9.c;
            if (r6 == null) goto L20;
            Long r7 = Long.valueOf(r6.getId());
        L21:
            Room r10 = r0.h;
            if (r10 == null) goto L25;
            r4 = Long.valueOf(r10.id);
        L25:
            if (Intrinsics.areEqual(r7, r4) == false) goto L29;
            ALogger.i("VideoFloatWindowView", "on action change to paid room, type: " + r0.m);
            r0.D.onRoomFinish();
            if (r9.c.isPaidSubscribeRoom() == false) goto L29;
            f2.b(2131922927, 0);
            goto L29
        L20:
            r7 = null;
        L29:
            int r11 = r9.a;
            if (r11 == 20) goto L34;
            if (r11 == 45) goto L34;
            return;
        L34:
            if (r0.m != 0) goto L41;
            ALogger.i("VideoFloatWindowView", "on kick out, show end view");
            LivePlayerView r12 = r0.i;
            if (r12 == null) goto L38;
            r12.stop();
        L38:
            r0.k();
            return;
        }
    }

    static {
    }

    private final int getOptimizeConfig() {
        return ((Number) this.v.getValue()).intValue();
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void e() {
        this.r = true;
        LivePlayerView r0 = this.i;
        if (r0 == null) goto L5;
        r0.stop();
    L5:
        ALogger.i("VideoFloatWindowView", "pausePullStream");
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void g() {
        this.r = false;
        if (this.h == null) goto L9;
        LiveRequest r0 = i();
        if (r0 == null) goto L9;
        LivePlayerView r1 = this.i;
        if (r1 == null) goto L9;
        r1.start(r0);
    L9:
        ALogger.i("VideoFloatWindowView", "resumePullStream");
    }

    public final int getFloatContentRootViewRadius() {
        return 8;
    }

    public MessageHub getMessageHub() {
        return null;
    }

    public final boolean isFeedEnable() {
        return false;
    }

    public final void l() {
        short[] r0 = {100, 500, 5000, -5000, -500, -100, 0};
        AudioWaveView r2 = (AudioWaveView) a(2131372921);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r0, "data");
        r2.c = r0;
        ((AudioWaveView) a(2131372921)).b();
        ((AudioWaveView) a(2131372921)).setClickable(false);
    }

    public final void onScreenOn() {
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void onStart() {
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void reset() {
        this.h = null;
    }

    private final DataCenter getMDataCenter() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.j r1 = r0.getDataCenter2();
        if (r1 != null) goto L7;
        return null;
    L7:
        return (DataCenter) r1.getValue();
    L8:
        return null;
    }

    public final void adjustIconLayout() {
        if (this.m == 1) goto L5;
        return;
    L5:
        this.A = (FrameLayout.LayoutParams) a(2131372937).getLayoutParams();
        this.z = (FrameLayout.LayoutParams) a(2131372953).getLayoutParams();
        LiveBizWindowAbilityCenter r3 = this.x;
        if (r3 == null) goto L16;
        AbsLiveBizWindowLayoutAbility r4 = r3.getCurLayoutAbility();
        if (r4 == null) goto L17;
        FrameLayout.LayoutParams r5 = r4.getCloseBtnLayoutParams(this.A);
        if (r5 == null) goto L12;
        a(2131372937).setLayoutParams(r5);
        this.B = true;
        ALogger.i("VideoFloatWindowView", "biz window platform: {" + r4.getBizTag() + "} close icon layout changed");
    L12:
        FrameLayout.LayoutParams r0 = r4.getMuteBtnLayoutParams(this.z);
        if (r0 == null) goto L18;
        a(2131372953).setLayoutParams(r0);
        this.B = true;
        ALogger.i("VideoFloatWindowView", "biz window platform: {" + r4.getBizTag() + "} mute icon layout changed");
        return;
    L18:
        return;
    L17:
        return;
    }

    public IRenderView getRenderView() {
        LivePlayerView r0 = this.i;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRenderView();
    }

    public final LiveRequest i() {
        InnerContextEntity r0 = this.l;
        boolean r1 = false;
        if (r0 == null) goto L9;
        InnerContextEntity.InnerFloatExtra r2 = r0.getEnterExtra();
        if (r2 == null) goto L9;
        if (r2.getMute() != true) goto L9;
        boolean r3 = true;
    L10:
        this.t = Boolean.valueOf(r3);
        ALogger.i("VideoFloatWindowView", "enterExtra.mute is " + r3);
        InnerContextEntity r4 = this.l;
        PlayerResolution.PickResult r5 = null;
        if (r4 == null) goto L15;
        InnerContextEntity.InnerFloatExtra r6 = r4.getEnterExtra();
        if (r6 == null) goto L15;
        String r7 = r6.getResolution();
    L16:
        if (r7 != null) goto L18;
    L21:
        boolean r8 = true;
    L22:
        String r9 = "";
        if (r8 == false) goto L37;
        Room r10 = this.h;
        if (r10 != null) goto L27;
    L36:
        r7 = "";
        goto L37
    L27:
        if (this.m != 1) goto L29;
        String r11 = "inner_float_window_resolution";
    L30:
        IResolutionService r12 = jc1.k.f(IResolutionService.class);
        if (r12 == null) goto L33;
        r5 = r12.getWindowDefaultResolutionSdkKey(r10, r11);
    L33:
        if (r5 == null) goto L36;
        r7 = r5.getResultSdkKey();
        if (r7 != null) goto L37;
    L29:
        r11 = "float_window_resolution";
    L37:
        LiveRequest.Builder r13 = new LiveRequest.Builder();
        Room r14 = this.h;
        if (r14 == null) goto L43;
        String r15 = r14.getMultiStreamData();
        if (r15 == null) goto L43;
        r9 = r15;
    L43:
        LiveRequest.Builder r16 = r13.streamData(r9).resolution(r7);
        LivePlayerStreamTypeUtils r17 = LivePlayerStreamTypeUtils.INSTANCE;
        Room r18 = this.h;
        if (r18 == null) goto L47;
        LiveMode r19 = r18.getStreamType();
        if (r19 == null) goto L47;
    L48:
        LiveRequest.Builder r20 = r16.streamType(r17.mapLiveModeToStreamType(r19));
        InnerContextEntity r21 = this.l;
        if (r21 == null) goto L56;
        InnerContextEntity.InnerFloatExtra r22 = r21.getEnterExtra();
        if (r22 == null) goto L56;
        if (r22.getInBackGroud() != true) goto L56;
        r1 = true;
    L56:
        return com.bytedance.android.livesdk.performance.a.a(r20.inBackground(r1).preview(true).mute(r3).enableAdaptiveGrading(t9.a.getValue().getEnableFloatWindow())).build();
    L47:
        r19 = LiveMode.VIDEO;
        goto L48
    L18:
        if (StringsKt.isBlank(r7) == true) goto L21;
        r8 = false;
    L15:
        r7 = null;
    L9:
        r3 = false;
        goto L10
    }

    public final void j() {
        Room r0 = this.h;
        if (r0 == null) goto L16;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, r0.getRoomId(), 1);
        if (r1 == null) goto L16;
        com.bytedance.live.datacontext.m r2 = r1.getFloatWindowStatus();
        if (r2 == null) goto L16;
        LiveFloatWindowStatus r3 = new LiveFloatWindowStatus();
        r3.setShow(false);
        LivePlayerView r4 = this.i;
        if (r4 == null) goto L13;
        LivePlayerConfig r5 = r4.getConfig();
        if (r5 == null) goto L13;
        ILivePlayerScene r6 = r5.getScene();
    L14:
        r3.setScene(r6);
        Unit r7 = Unit.INSTANCE;
        r2.setValue(r3);
    L13:
        r6 = null;
    L16:
        if (this.m != 1) goto L40;
        String r8 = this.u;
        int r9 = AudienceVideoResolutionManager.a;
        Intrinsics.checkNotNullParameter(r8, "oldRoomResolution");
        if (Intrinsics.areEqual(r8, "") == true) goto L40;
        int r10 = AudienceVideoResolutionManager.a;
        Lazy r11 = AudienceVideoResolutionManager.m;
        if (((Number) r11.getValue()).intValue() < 0) goto L40;
        ILivePlayerClient r12 = LivePlatformPlayerManager.f();
        if (r12 == null) goto L25;
        String r13 = r12.getCurrentResolution();
    L27:
        if ((!Intrinsics.areEqual(r13, r8)) == true) goto L29;
    L36:
        Disposable r14 = AudienceVideoResolutionManager.n;
        if (r14 == null) goto L39;
        r14.dispose();
    L39:
        AudienceVideoResolutionManager.n = Observable.interval(700, 3000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.chatroom.resolution.d(r8));
        goto L40
    L29:
        if (((Number) r11.getValue()).intValue() != 0) goto L33;
        ILivePlayerClient r15 = LivePlatformPlayerManager.f();
        if (r15 == null) goto L36;
        r15.switchResolution(r8, "share_player_resume", null);
        goto L36
    L33:
        ILivePlayerClient r16 = LivePlatformPlayerManager.f();
        if (r16 == null) goto L36;
        r16.smoothSwitchResolution(r8, 2, true);
        goto L36
    L25:
        r13 = null;
    L40:
        this.u = "";
        LivePlayerView r17 = this.i;
        if (r17 == null) goto L43;
        r17.release();
    L43:
        ALogger.i("VideoFloatWindowView", "release player");
    }

    public final void k() {
        com.bytedance.android.livesdk.floatview.mob.b r0 = this.n;
        if (r0 == null) goto L5;
        r0.g(this.h, getContainContext());
    L5:
        ViewGroup.LayoutParams r1 = ((TextView) a(2131372948)).getLayoutParams();
        ViewGroup.LayoutParams r3 = ((TextView) a(2131372945)).getLayoutParams();
        ViewGroup.LayoutParams r6 = null;
        if (((FrameLayout) a(2131372939)).getLayoutParams().width < ((FrameLayout) a(2131372939)).getLayoutParams().height) goto L35;
        if ((r1 instanceof RelativeLayout.LayoutParams) == true) goto L10;
        ViewGroup.LayoutParams r4 = null;
    L11:
        RelativeLayout.LayoutParams r5 = (RelativeLayout.LayoutParams) r4;
        if (r5 == null) goto L14;
        r5.topMargin = (int) UIUtils.dip2Px(getContext(), 20.0f);
    L14:
        Room r7 = this.h;
        if (r7 == null) goto L17;
        LiveMode r8 = r7.getStreamType();
    L19:
        if (r8 != LiveMode.AUDIO) goto L27;
        r3.width = (int) UIUtils.dip2Px(getContext(), 86.0f);
        if ((r3 instanceof RelativeLayout.LayoutParams) == false) goto L24;
        r6 = r3;
    L24:
        RelativeLayout.LayoutParams r9 = (RelativeLayout.LayoutParams) r6;
        if (r9 == null) goto L49;
        r9.bottomMargin = (int) UIUtils.dip2Px(getContext(), 12.0f);
    L49:
        if (this.m != 1) goto L51;
        ((TextView) a(2131372945)).setText(s1.B(2131916670));
    L52:
        int r10 = com.bytedance.android.livesdk.floatview.mob.b.o;
        if (com.bytedance.android.livesdk.floatview.mob.b.a.a(this.h) == false) goto L55;
        ((TextView) a(2131372945)).setVisibility(8);
    L56:
        ((TextView) a(2131372948)).setLayoutParams(r1);
        ((TextView) a(2131372945)).setLayoutParams(r3);
        ((RelativeLayout) a(2131372949)).setVisibility(0);
        a(2131372922).setVisibility(0);
        ((RelativeLayout) a(2131372965)).setVisibility(8);
        ((AudioWaveView) a(2131372921)).setVisibility(8);
        ((LinearLayout) a(2131372920)).setVisibility(8);
        a(2131372953).setVisibility(8);
        this.c = du2.a.b(0, 1, TimeUnit.SECONDS).take(6).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new u(this));
        this.u = "";
        j();
        return;
    L55:
        ((TextView) a(2131372945)).setVisibility(0);
        goto L56
    L51:
        ((TextView) a(2131372945)).setText(s1.B(2131916668));
        goto L52
    L27:
        r3.width = (int) UIUtils.dip2Px(getContext(), 100.0f);
        if ((r3 instanceof RelativeLayout.LayoutParams) == false) goto L31;
        r6 = r3;
    L31:
        RelativeLayout.LayoutParams r11 = (RelativeLayout.LayoutParams) r6;
        if (r11 == null) goto L49;
        r11.bottomMargin = (int) UIUtils.dip2Px(getContext(), 17.0f);
        goto L49
    L17:
        r8 = null;
        goto L19
    L10:
        r4 = r1;
        goto L11
    L35:
        if ((r3 instanceof RelativeLayout.LayoutParams) == true) goto L37;
        ViewGroup.LayoutParams r12 = null;
    L38:
        RelativeLayout.LayoutParams r13 = (RelativeLayout.LayoutParams) r12;
        if (r13 == null) goto L41;
        r13.bottomMargin = (int) UIUtils.dip2Px(getContext(), 16.0f);
    L41:
        r3.width = (int) UIUtils.dip2Px(getContext(), 93.0f);
        if ((r1 instanceof RelativeLayout.LayoutParams) == false) goto L45;
        r6 = r1;
    L45:
        RelativeLayout.LayoutParams r14 = (RelativeLayout.LayoutParams) r6;
        if (r14 == null) goto L49;
        r14.topMargin = (int) UIUtils.dip2Px(getContext(), 73.0f);
        goto L49
    L37:
        r12 = r3;
        goto L38
    }

    public final void m() {
        Room r1 = this.h;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.getStreamType() == LiveMode.AUDIO) goto L131;
        int r2 = this.k;
        int r7 = this.j;
        float r3 = r2 / r7;
        if (r7 <= r2) goto L13;
        if (this.m != 1) goto L11;
        float r4 = UIUtils.dip2Px(getContext(), 210.0f);
    L15:
        int r5 = (int) r4;
    L17:
        int r6 = (int) (r5 * r3);
        if (this.m != 1) goto L130;
        List<String> r8 = this.w;
        InnerContextEntity r9 = this.l;
        if (r9 == null) goto L22;
        String r10 = r9.getRequestPage();
    L24:
        if (CollectionsKt.contains(r8, r10) == true) goto L32;
        InnerContextEntity r11 = this.l;
        if (r11 == null) goto L32;
        InnerContextEntity.InnerFloatExtra r12 = r11.getEnterExtra();
        if (r12 == null) goto L32;
        if (r12.getEnableExtParams() == false) goto L130;
    L32:
        InnerContextEntity r13 = this.l;
        if (r13 == null) goto L35;
        String r14 = r13.getRequestPage();
    L36:
        int r15 = 0;
        if (Intrinsics.areEqual(r14, "gamecp_game_detail") == true) goto L56;
        InnerContextEntity r16 = this.l;
        if (r16 == null) goto L45;
        InnerContextEntity.InnerFloatExtra r17 = r16.getEnterExtra();
        if (r17 == null) goto L45;
        if (r17.getEnableExtParams() == true) goto L56;
    L45:
        IStrategyService r18 = jc1.k.f(IStrategyService.class);
        if (r18 == null) goto L61;
        LiveData r19 = IStrategyService.a.a(r18, "inner_window_strategy", new LinkedHashMap(), false, 12);
        if (r19 == null) goto L61;
        Map r20 = (Map) r19.getValue();
        if (r20 == null) goto L61;
        InnerContextEntity r110 = this.l;
        if (r110 == null) goto L54;
        String r111 = r110.getRequestPage();
    L55:
        Map r21 = (Map) r20.get(r111);
    L62:
        if (r21 != null) goto L64;
    L129:
        ViewGroup.LayoutParams r22 = ((FrameLayout) a(2131372939)).getLayoutParams();
        r22.width = r5;
        r22.height = r6;
        ViewGroup.LayoutParams r23 = r22;
    L132:
        ViewGroup.LayoutParams r24 = r23;
        if (this.m != 1) goto L146;
        LiveBizWindowAbilityCenter r25 = this.x;
        r24 = r23;
        if (r25 == null) goto L146;
        AbsLiveBizWindowLayoutAbility r26 = r25.getCurLayoutAbility();
        r24 = r23;
        if (r26 == null) goto L146;
        int r27 = this.j;
        int r28 = this.k;
        if ((r23 instanceof RelativeLayout.LayoutParams) == true) goto L141;
        ViewGroup.LayoutParams r112 = null;
    L142:
        RelativeLayout.LayoutParams r29 = r26.getBizWindowLayoutParams(r27, r28, (RelativeLayout.LayoutParams) r112);
        ViewGroup.LayoutParams r30 = r23;
        if (r29 == null) goto L145;
        r30 = r29;
    L145:
        ALogger.i("VideoFloatWindowView", "biz window platform: {" + r26.getBizTag() + "} float container layout changed");
        r24 = r30;
        goto L146
    L141:
        r112 = r23;
    L146:
        ((FrameLayout) a(2131372939)).setLayoutParams(r24);
        e r31 = this.b;
        if (r31 == null) goto L151;
        r31.a(r5, r6);
        return;
    L151:
        return;
    L64:
        if (r21.isEmpty() == true) goto L129;
        String r113 = (String) r21.get("position_type");
        if (r113 == null) goto L69;
        r15 = CastIntegerProtector.parseInt(r113);
    L69:
        String r114 = (String) r21.get("margin");
        if (r114 == null) goto L72;
        float r115 = CastFloatProtector.parseFloat(r114);
    L73:
        String r116 = (String) r21.get("logic_right_margin");
        if (r116 == null) goto L76;
        float r117 = CastFloatProtector.parseFloat(r116);
    L77:
        ViewGroup.LayoutParams r118 = ((FrameLayout) a(2131372939)).getLayoutParams();
        if (r118 == null) goto L128;
        int r119 = ((RelativeLayout.LayoutParams) r118).bottomMargin;
        ViewGroup.LayoutParams r120 = ((FrameLayout) a(2131372939)).getLayoutParams();
        if (r120 == null) goto L126;
        int r121 = ((RelativeLayout.LayoutParams) r120).rightMargin;
        String r122 = (String) r21.get("ratio");
        if (r122 == null) goto L84;
        double r123 = CastDoubleProtector.parseDouble(r122);
    L85:
        String r32 = (String) r21.get("horizontal_live_max_height");
        if (r32 == null) goto L88;
        Integer r33 = Integer.valueOf((int) UIUtils.dip2Px(getContext(), CastFloatProtector.parseFloat(r32)));
    L89:
        int r124 = (int) (((double) r5) * r123);
        int r34 = (int) (((double) r6) * r123);
        if (r33 != null) goto L92;
    L97:
        RelativeLayout.LayoutParams r35 = new RelativeLayout.LayoutParams(-2, -2);
        r35.width = r124;
        r35.height = r34;
        if (r15 != 0) goto L100;
        r35.addRule(11);
        r35.addRule(12);
        if (r115 == (-1.0f)) goto L121;
        r119 = (int) UIUtils.dip2Px(getContext(), r115);
    L121:
        r35.bottomMargin = r119;
        if (r117 == (-1.0f)) goto L124;
        r121 = (int) UIUtils.dip2Px(getContext(), r117);
    L124:
        r35.rightMargin = r121;
        r23 = r35;
        goto L132
    L100:
        if (r15 != 1) goto L102;
        r35.addRule(11);
        r35.addRule(12);
        r35.bottomMargin = (s1.w() / 2) - (r35.height / 2);
        r23 = r35;
        goto L132
    L102:
        if (r15 != 2) goto L104;
        r35.addRule(9);
        r35.addRule(12);
        r35.bottomMargin = (s1.w() / 2) - (r35.height / 2);
        r23 = r35;
        goto L132
    L104:
        if (r15 == 3) goto L112;
        r23 = r35;
        if (r15 != 4) goto L132;
        r35.addRule(9);
        r35.addRule(12);
        if (r115 == (-1.0f)) goto L111;
        r119 = (int) UIUtils.dip2Px(getContext(), r115);
    L111:
        r35.bottomMargin = r119;
        r23 = r35;
        goto L132
    L112:
        r35.addRule(11);
        r35.addRule(12);
        if (r115 == (-1.0f)) goto L115;
        r119 = (int) UIUtils.dip2Px(getContext(), r115);
    L115:
        r35.bottomMargin = r119;
        r23 = r35;
        goto L132
    L92:
        if (r33.intValue() <= 0) goto L97;
        if (r5 <= r6) goto L97;
        if (r34 <= r33.intValue()) goto L97;
        r124 = (int) ((r124 / r34) * r33.intValue());
        r34 = r33.intValue();
        goto L97
    L88:
        r33 = null;
        goto L89
    L84:
        r123 = 1.0d;
        goto L85
    L126:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L128:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L76:
        r117 = -1.0f;
        goto L77
    L72:
        r115 = -1.0f;
        goto L73
    L54:
        r111 = null;
    L61:
        r21 = null;
    L56:
        InnerContextEntity r36 = this.l;
        if (r36 == null) goto L61;
        InnerContextEntity.InnerFloatExtra r37 = r36.getEnterExtra();
        if (r37 == null) goto L61;
        r21 = r37.getExtParams();
        goto L62
    L35:
        r14 = null;
        goto L36
    L22:
        r10 = null;
    L130:
        ViewGroup.LayoutParams r38 = ((FrameLayout) a(2131372939)).getLayoutParams();
        r38.width = r5;
        r38.height = r6;
        r23 = r38;
        goto L132
    L11:
        r5 = (Math.min(UIUtils.getScreenWidth(getContext()), UIUtils.getScreenHeight(getContext())) * 3) / 5;
        goto L17
    L13:
        if (this.m != 1) goto L16;
        r4 = UIUtils.dip2Px(getContext(), 110.0f);
        goto L15
    L16:
        r5 = Math.min(UIUtils.getScreenWidth(getContext()), UIUtils.getScreenHeight(getContext())) / 3;
        goto L17
    L131:
        r5 = (int) UIUtils.dip2Px(getContext(), 110.0f);
        ViewGroup.LayoutParams r39 = ((FrameLayout) a(2131372939)).getLayoutParams();
        r39.width = r5;
        r39.height = r5;
        Unit r40 = Unit.INSTANCE;
        r6 = r5;
        r23 = r39;
        goto L132
    }

    public final boolean n() {
        Room r0 = this.h;
        if (r0 == null) goto L8;
        if (r0.isCompoundScene() != true) goto L8;
        return false;
    L8:
        if (this.m == 0) goto L10;
    L12:
        InnerContextEntity r1 = this.l;
        if (r1 == null) goto L19;
        InnerContextEntity.InnerFloatExtra r2 = r1.getEnterExtra();
        if (r2 == null) goto L19;
        if (r2.getForceNotSharedLiveClient() != true) goto L19;
        return false;
    L19:
        Room r3 = this.h;
        if (r3 == null) goto L31;
        long r4 = r3.getRoomId();
        ListenLiveStatus r5 = null;
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, r4, 1);
        if (r6 == null) goto L26;
        com.bytedance.live.datacontext.m r7 = r6.getListenLiveStatus();
        if (r7 == null) goto L26;
        r5 = (ListenLiveStatus) r7.getValue();
    L26:
        if (r5 == null) goto L31;
        if (r5.isOpen() != true) goto L31;
        return false;
    L31:
        return bx.a.getValue().b();
    L10:
        if (zw.a.getValue().booleanValue() == false) goto L12;
        return false;
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void onPause() {
        com.bytedance.android.livesdk.floatview.mob.b r0 = this.n;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a == (-1)) goto L10;
        r0.c = SystemClock.elapsedRealtime();
        return;
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void onResume() {
        com.bytedance.android.livesdk.floatview.mob.b r0 = this.n;
        if (r0 == null) goto L6;
        r0.n();
        return;
    }

    public final void onScreenOff() {
        com.bytedance.android.livesdk.floatview.mob.b r0 = this.n;
        if (r0 != null) goto L5;
    L8:
        AudienceVideoResolutionManager.p(true, true, this.i);
        return;
    L5:
        if (r0.a == (-1)) goto L8;
        r0.c = SystemClock.elapsedRealtime();
        goto L8
    }

    public final void onUserPresent() {
        com.bytedance.android.livesdk.floatview.mob.b r0 = this.n;
        if (r0 == null) goto L5;
        r0.n();
    L5:
        LivePlayerView r1 = this.i;
        if (r1 == null) goto L12;
        ILivePlayerClient r2 = r1.getClient();
        if (r2 == null) goto L12;
        if (r2.isPlaying() == true) goto L12;
        g();
    L12:
        AudienceVideoResolutionManager.p(false, true, this.i);
    }

    public final void resumeIconLayout() {
        if (this.m == 1) goto L6;
        return;
    L6:
        if (this.B == true) goto L9;
        ALogger.i("VideoFloatWindowView", "biz window platform: icon layout not changed, no need resume");
        return;
    L9:
        a(2131372937).setLayoutParams(this.A);
        a(2131372953).setLayoutParams(this.z);
        LiveBizWindowAbilityCenter r0 = this.x;
        if (r0 == null) goto L17;
        AbsLiveBizWindowLayoutAbility r1 = r0.getCurLayoutAbility();
        if (r1 == null) goto L18;
        String r2 = r1.getBizTag();
        if (r2 == null) goto L19;
        ALogger.i("VideoFloatWindowView", "biz window platform: {" + r2 + "}} icon layout resumed");
        return;
    L19:
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void stop() {
        ALogger.i("LinkService", "--------- VideoFloatWindowView#stop");
        ALogger.i("VideoFloatWindowView", "stop");
        com.bytedance.android.livesdk.floatview.b r1 = this.C;
        if (r1 == null) goto L28;
        Animator r5 = r1.c;
        if (r5 != null) goto L7;
    L11:
        j r6 = r1.a;
        if (r6 == null) goto L14;
        a1.m(r1.e, r6.a);
        a1.o(r1.e, r6.b);
        a1.n(r1.e, r6.c);
        a1.l(r1.e, r6.d);
    L14:
        r1.a = null;
        j r7 = r1.b;
        if (r7 == null) goto L19;
        RoundCornerFrameLayout r8 = r1.d.getFloatContentRootView();
        if (r8 == null) goto L19;
        a1.m(r8, r7.a);
        a1.o(r8, r7.b);
        a1.n(r8, r7.c);
        a1.l(r8, r7.d);
        int r9 = UtilityKotlinExtentionsKt.i(r1.d.getFloatContentRootViewRadius());
        r8.J(r9, r9, r9, r9);
    L19:
        r1.b = null;
        r1.c = null;
        FrameLayout r10 = r1.d.getFloatEdge();
        if (r10 == null) goto L22;
        r10.setVisibility(0);
    L22:
        View r11 = r1.d.getCloseView();
        if (r11 == null) goto L25;
        r11.setVisibility(0);
    L25:
        View r2 = r1.d.getMuteView();
        if (r2 == null) goto L28;
        r2.setVisibility(0);
        goto L28
    L7:
        if (r5.isRunning() != true) goto L11;
        Animator r12 = r1.c;
        if (r12 == null) goto L11;
        r12.cancel();
    L28:
        this.C = null;
        LivePlayerView r3 = this.i;
        if (r3 == null) goto L33;
        ILivePlayerClient r4 = r3.getClient();
        if (r4 == null) goto L33;
        Boolean r13 = Boolean.valueOf(r4.isMute());
    L34:
        this.t = r13;
        InnerContextEntity r14 = this.l;
        if (r14 == null) goto L56;
        InnerContextEntity.InnerFloatExtra r15 = r14.getEnterExtra();
        if (r15 == null) goto L56;
        if (r15.getEnableExtParams() != true) goto L56;
        InnerContextEntity r16 = this.l;
        if (r16 == null) goto L45;
        InnerContextEntity.InnerFloatExtra r17 = r16.getEnterExtra();
        if (r17 == null) goto L45;
        HashMap r18 = r17.getExtParams();
    L46:
        if (r18 == null) goto L48;
        String r19 = (String) r18.get("next_show_use_default_mute_config_scene");
    L50:
        if (Intrinsics.areEqual(r19, "more_live") == false) goto L56;
        InnerContextEntity r20 = this.l;
        if (r20 == null) goto L56;
        InnerContextEntity.InnerFloatExtra r21 = r20.getEnterExtra();
        if (r21 == null) goto L56;
        r21.setMute(true);
        goto L56
    L48:
        r19 = null;
    L45:
        r18 = null;
    L56:
        this.s = false;
        Disposable r22 = this.c;
        if (r22 == null) goto L59;
        r22.dispose();
    L59:
        this.c = null;
        Disposable r23 = this.d;
        if (r23 == null) goto L62;
        r23.dispose();
    L62:
        this.d = null;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L68
        a6 r25 = this.o;     // Catch: Throwable -> L68
        if (r25 == null) goto L66;
        r25.a();     // Catch: Throwable -> L68
    L66:
        this.o = null;     // Catch: Throwable -> L68
        Object r26 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L68
    L71:
        if (Result.exceptionOrNull-impl(r26) == null) goto L73;
        ALogger.i("VideoFloatWindowView", "Current window type:" + this.m);
    L73:
        Disposable r27 = this.e;
        if (r27 == null) goto L76;
        r27.dispose();
    L76:
        this.e = null;
        j();
        LivePlayerView r28 = this.i;
        if (r28 == null) goto L89;
        r28.setVisibility(8);
        LivePlayerView r29 = this.i;
        if (r29 == null) goto L82;
        ViewParent r30 = r29.getParent();
    L84:
        if ((r30 instanceof ViewGroup) == true) goto L86;
        r30 = null;
    L86:
        ViewGroup r31 = (ViewGroup) r30;
        if (r31 == null) goto L89;
        r31.removeView(this.i);
        goto L89
    L82:
        r30 = null;
    L89:
        LivePlayerView r32 = this.i;
        if (r32 == null) goto L98;
        ILivePlayerClient r33 = r32.getClient();
        if (r33 == null) goto L98;
        IRoomEventHub r34 = r33.getEventHub();
        if (r34 == null) goto L98;
        MutableLiveData r35 = r34.getBackgroundHandlerRunning();
        if (r35 == null) goto L98;
        r35.removeObserver(this.E);
    L98:
        setMLivePlayerView$livesdk_saasRelease(null);
        this.r = false;
        ((LinearLayout) a(2131372920)).setVisibility(8);
        ((RelativeLayout) a(2131372965)).setVisibility(0);
        ((AudioWaveView) a(2131372921)).setVisibility(8);
        ((RelativeLayout) a(2131372949)).setVisibility(8);
        a(2131372953).setVisibility(0);
        a(2131372953).setSelected(false);
        ((FrameLayout) a(2131372902)).setVisibility(8);
        ((AudioWaveView) a(2131372921)).c();
        com.bytedance.android.livesdk.floatview.mob.b r36 = this.n;
        if (r36 == null) goto L101;
        r36.f(this.h, getContainContext());
    L101:
        com.bytedance.android.livesdk.floatview.mob.b r37 = this.n;
        if (r37 == null) goto L104;
        r37.h(getContainContext(), this.h);
    L104:
        com.bytedance.android.livesdk.floatview.mob.b r38 = this.n;
        if (r38 == null) goto L108;
        r38.a = -1;
        r38.b = -1;
        r38.c = -1;
        r38.d = 0;
        r38.m = null;
    L108:
        if (this.m == 1) goto L110;
    L123:
        resumeIconLayout();
        this.k = 0;
        this.j = 0;
        this.h = null;
        return;
    L110:
        if (this.y == null) goto L123;
        if (((FrameLayout) a(2131372926)).getChildCount() > 0) goto L115;
    L117:
        LiveBizWindowAbilityCenter r39 = this.x;
        if (r39 == null) goto L122;
        AbsLiveBizWindowWidgetAbility r40 = r39.getCurWidgetAbility();
        if (r40 == null) goto L122;
        r40.onDetach();
        ALogger.i("VideoFloatWindowView", "biz window platform: {" + r40.getBizTag() + "} interaction view detach");
    L122:
        ((FrameLayout) a(2131372926)).removeView(this.y);
        this.y = null;
        goto L123
    L115:
        if ((true ^ Intrinsics.areEqual(((FrameLayout) a(2131372926)).getChildAt(0), this.y)) == false) goto L117;
    L68:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
    L33:
        r13 = null;
        goto L34
    }

    public final View getCloseView() {
        return a(2131372937);
    }

    public ViewGroup getContainer() {
        return (ViewGroup) a(2131372951);
    }

    public final DragRelativeLayout getDragLayoutView() {
        return (DragRelativeLayout) a(2131372943);
    }

    public final RoundCornerFrameLayout getFloatContentRootView() {
        return a(2131372940);
    }

    public final FrameLayout getFloatEdge() {
        return (FrameLayout) a(2131372902);
    }

    public final View getMuteView() {
        return a(2131372953);
    }

    public long getShowDelay() {
        return FloatFeedViewHandler.IFloatFeedContext.DefaultImpls.getShowDelay(this);
    }

    public FrameLayout getVideoContainer() {
        return (FrameLayout) a(2131372939);
    }

    public LiveBizWindowAbilityCenter getBizAbilityCenter() {
        return this.x;
    }

    public InnerContextEntity getContainContext() {
        return this.l;
    }

    public final Room getCurRoomData() {
        return this.h;
    }

    public com.bytedance.android.livesdk.floatview.mob.b getFloatWindowLogger() {
        return this.n;
    }

    public final LivePlayerView getMLivePlayerView$livesdk_saasRelease() {
        return this.i;
    }

    public Room getRoom() {
        return this.h;
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final boolean isPaused() {
        return this.r;
    }

    public static final /* synthetic */ DataCenter c(VideoFloatWindowView r0) {
        return r0.getMDataCenter();
    }

    public static final /* synthetic */ int d(VideoFloatWindowView r0) {
        return r0.getOptimizeConfig();
    }

    public static final void f(VideoFloatWindowView r5) {
        r5.getClass();
        Room r0 = jc1.k.n(IRoomService.class).getCurrentRoomFromRoomContext();
        Long r1 = null;
        if (r0 == null) goto L5;
        Long r2 = Long.valueOf(r0.id);
    L6:
        Room r3 = r5.h;
        if (r3 == null) goto L10;
        r1 = Long.valueOf(r3.id);
    L10:
        if (Intrinsics.areEqual(r2, r1) == false) goto L13;
        return;
    L13:
        if ((System.currentTimeMillis() - r5.p) < r5.q) goto L18;
        r5.p = System.currentTimeMillis();
        w5.a();
        return;
    L18:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final View a(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
        e r0 = this.b;
        if (r0 == null) goto L6;
        r0.onConfigurationChanged(r2);
    L6:
        if (this.g == true) goto L8;
        return;
    L8:
        if (this.f == FoldScreenUtils.a()) goto L12;
        this.f = FoldScreenUtils.a();
        m();
        return;
    }

    public void setBizAbilityCenter(LiveBizWindowAbilityCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "abilityCenter");
        this.x = r2;
        com.bytedance.android.livesdk.floatview.mob.b r0 = this.n;
        if (r0 == null) goto L9;
        if (r2 == null) goto L6;
        AbsLiveBizWindowLogAbility r3 = r2.getCurLogAbility();
    L7:
        r0.g = r3;
        return;
    L6:
        r3 = null;
        goto L7
    }

    public void setContainContext(InnerContextEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.l = r2;
        com.bytedance.android.livesdk.floatview.mob.b r0 = this.n;
        if (r0 == null) goto L14;
        InnerContextEntity.InnerFloatExtra r3 = r2.getEnterExtra();
        if (r3 == null) goto L9;
        FloatWindowBusinessLine r4 = r3.getBusinessLine();
        if (r4 == null) goto L9;
        String r5 = r4.getValue();
    L10:
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        r0.j = r5;
        return;
    L9:
        r5 = null;
        goto L10
    }

    public void setFloatViewListener(e r1) {
        this.b = r1;
    }

    public final void setMLivePlayerView$livesdk_saasRelease(LivePlayerView r1) {
        this.i = r1;
    }

    public VideoFloatWindowView(Context r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6);
        this.a = new LinkedHashMap();
        this.f = FoldScreenUtils.a();
        this.g = FoldScreenUtils.f();
        this.m = 1;
        UIUtils.dip2Px(getContext(), 13.0f);
        this.q = 5000;
        this.t = Boolean.FALSE;
        this.u = "";
        this.v = LazyKt.lazy(VideoFloatWindowView$optimizeConfig$2.INSTANCE);
        this.w = CollectionsKt.mutableListOf(new String[]{"ecom_product_detail", "gamecp_game_detail", "store_page", "com.ss.android.ugc.aweme.trade.goods.view.GoodsDetailDialogFragment"});
        this.D = new c(this);
        this.E = new b(this);
        this.m = r7;
        LayoutInflater.from(getContext()).inflate(2131566015, this);
        AbstractDraweeController r1 = Fresco.newDraweeControllerBuilder().setUri(UriProtector.parse("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/big_party_radio_effect.webp")).setAutoPlayAnimations(true).build();
        a(2131372955).setController(r1);
        a(2131372937).setOnClickListener(new v(this));
        a(2131372937).setContentDescription("关闭，按钮");
        a(2131372953).setOnClickListener(new w(this));
        a(2131372953).setContentDescription("静音/取消静音,按钮");
        ((TextView) a(2131372945)).setOnClickListener(new x(this));
        if (r7 != 1) goto L5;
        ((FrameLayout) a(2131372939)).setOnClickListener(new y(this));
    L5:
        DragRelativeLayout r2 = (DragRelativeLayout) a(2131372943);
        if (r7 != 1) goto L8;
        boolean r3 = true;
    L9:
        r2.d = r3;
        if (r7 != 1) goto L12;
        String r8 = "business";
    L13:
        this.n = new com.bytedance.android.livesdk.floatview.mob.b(r7, r8, "", null);
        DragRelativeLayout r9 = (DragRelativeLayout) a(2131372943);
        ViewDragHelper.Callback r10 = new VideoFloatWindowView$initData$1(this);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "callback");
        r9.e = r10;
        return;
    L12:
        r8 = "content";
        goto L13
    L8:
        r3 = false;
        goto L9
    }

    public static final void b(VideoFloatWindowView r4, ILivePlayerClient r5) {
        if (VrUtils.w(r4.getMDataCenter()) == false) goto L15;
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        int r1 = 1;
        if (VrUtils.C(null) == false) goto L13;
        if (r6 == null) goto L13;
        com.bytedance.live.datacontext.m r7 = r6.getVrSensorOpened();
        if (r7 == null) goto L13;
        if (((Boolean) r7.getValue()).booleanValue() != true) goto L13;
        r1 = 0;
    L13:
        r5.setGyroStatusInitial(r1);
        return;
    }

    @Override // com.bytedance.android.livesdk.floatview.f
    public final void h(Room r8, boolean r9) {
        if (IRoom.Companion.isValid(r8) == true) goto L6;
        ALogger.i("VideoFloatWindowView", "room is not valid, return");
        return;
    L6:
        Room r10 = this.h;
        if (r10 == null) goto L18;
        long r1 = r10.id;
        if (r8 == null) goto L18;
        if (r1 != r8.id) goto L18;
        if (r10.getStreamType() == LiveMode.AUDIO) goto L15;
        return;
    L15:
        if (r10.getWithLinkMic() == false) goto L124;
        l();
        return;
    L124:
        return;
    L18:
        ALogger.i("VideoFloatWindowView", "ready to start");
        this.h = r8;
        this.r = false;
        Disposable r2 = this.e;
        if (r2 == null) goto L21;
        r2.dispose();
    L21:
        this.e = xs2.b.a().b(h1.class).subscribe(new d(this));
        if (this.m == 0) goto L24;
    L26:
        IStrategyService r3 = jc1.k.f(IStrategyService.class);
        if (r3 == null) goto L33;
        LiveData r4 = IStrategyService.a.a(r3, "lock_screen_resolution_data", new LinkedHashMap(), false, 12);
        if (r4 == null) goto L33;
        Map r5 = (Map) r4.getValue();
        if (r5 == null) goto L33;
        String r6 = (String) r5.get("inner_enable");
    L35:
        if (Intrinsics.areEqual(r6, "1") == false) goto L42;
        if (this.m != 1) goto L42;
        if (this.o != null) goto L42;
        a6 r7 = new a6(getContext());
        this.o = r7;
        r7.b(this);
    L42:
        if (this.m == 1) goto L44;
    L46:
        xs2.b.a().post(new h1(32));
        ALogger.i("LinkService", "--------- VideoFloatWindowView#startPlayer");
        ViewGroup.LayoutParams r11 = ((FrameLayout) a(2131372939)).getLayoutParams();
        r11.width = 1;
        r11.height = 1;
        ((FrameLayout) a(2131372939)).post(new i0(this));
        w5.a();
        adjustIconLayout();
        if (this.m != 1) goto L58;
        LiveBizWindowAbilityCenter r12 = this.x;
        if (r12 == null) goto L58;
        AbsLiveBizWindowWidgetAbility r13 = r12.getCurWidgetAbility();
        if (r13 == null) goto L58;
        View r14 = r13.getBizInteractView(getContext(), a(2131372940).getWidth(), a(2131372940).getHeight());
        if (r14 == null) goto L58;
        if (((FrameLayout) a(2131372926)).indexOfChild(r14) >= 0) goto L58;
        this.y = r14;
        ((FrameLayout) a(2131372926)).addView(r14);
        r13.onAttach();
        ALogger.i("VideoFloatWindowView", "biz window platform: {" + r13.getBizTag() + "} interaction view attach");
    L58:
        View r0 = a(2131372953);
        InnerContextEntity r15 = this.l;
        if (r15 == null) goto L65;
        InnerContextEntity.InnerFloatExtra r16 = r15.getEnterExtra();
        if (r16 == null) goto L65;
        if (r16.getMute() != true) goto L65;
        boolean r17 = true;
    L66:
        r0.setSelected(r17);
        Room r18 = this.h;
        if (r18 == null) goto L69;
        LiveMode r19 = r18.getStreamType();
    L71:
        if (r19 != LiveMode.AUDIO) goto L98;
        a(2131372922).setVisibility(0);
        Room r20 = this.h;
        if (r20 != null) goto L75;
    L77:
        ((LinearLayout) a(2131372920)).setVisibility(0);
        ((AudioWaveView) a(2131372921)).setVisibility(8);
        ImageView r21 = (ImageView) a(2131372916);
        if (r8 == null) goto L82;
        User r22 = r8.getOwner();
        if (r22 == null) goto L82;
        ImageModel r23 = r22.getAvatarThumb();
    L83:
        com.bytedance.android.livesdk.chatroom.utils.a1.v(r21, r23, 2131250965);
        TextView r24 = (TextView) a(2131372917);
        if (r8 == null) goto L88;
        User r25 = r8.getOwner();
        if (r25 == null) goto L88;
        String r26 = r25.getNickName();
    L89:
        r24.setText(r26);
    L90:
        HSImageView r27 = a(2131372922);
        com.bytedance.android.livesdk.model.k r28 = jf.a.getValue();
        Room r29 = this.h;
        if (r29 == null) goto L96;
        IUser r30 = r29.author();
        if (r30 == null) goto L96;
        String r31 = r30.getIdString();
        if (r31 == null) goto L96;
    L97:
        ImageLoader.bindImage(r27, com.bytedance.android.livesdk.model.k.b(r28, r31));
    L111:
        e r32 = this.b;
        if (r32 == null) goto L114;
        r32.onShow();
    L114:
        this.s = true;
        com.bytedance.android.livesdk.floatview.mob.b r33 = this.n;
        if (r33 == null) goto L117;
        r33.a = SystemClock.elapsedRealtime();
    L117:
        com.bytedance.android.livesdk.floatview.mob.b r34 = this.n;
        if (r34 == null) goto L125;
        InnerContextEntity r35 = getContainContext();
        Room r36 = this.h;
        int r37 = com.bytedance.android.livesdk.floatview.mob.b.o;
        if (com.bytedance.android.livesdk.floatview.mob.b.a.a(r36) == false) goto L126;
        r34.e("live_show", r35, r36, null);
        return;
    L126:
        return;
    L125:
        return;
    L96:
        r31 = "0";
    L88:
        r26 = null;
    L82:
        r23 = null;
        goto L83
    L75:
        if (r20.getWithLinkMic() != true) goto L77;
        ((LinearLayout) a(2131372920)).setVisibility(8);
        ((AudioWaveView) a(2131372921)).setVisibility(0);
        l();
        goto L90
    L98:
        a(2131372922).setVisibility(8);
        float r38 = UIUtils.getScreenWidth(getContext()) / UIUtils.getScreenHeight(getContext());
        if (r8 == null) goto L105;
        User r39 = r8.getOwner();
        if (r39 == null) goto L105;
        ImageModel r40 = r39.getAvatarThumb();
        if (r40 == null) goto L105;
        List r41 = r40.getUrls();
    L107:
        if (Lists.notEmpty(r41) == false) goto L109;
        ImageLoader.bindImage(a(2131372922), new ImageModel(null, r41), new l3(2, r38, null));
    L110:
        ((AudioWaveView) a(2131372921)).setVisibility(8);
        goto L111
    L109:
        ImageLoader.bindImage(a(2131372922), "res://" + getContext().getPackageName() + "/2131251156", new l3(5, r38, null));
    L105:
        r41 = null;
        goto L107
    L69:
        r19 = null;
    L65:
        r17 = false;
        goto L66
    L44:
        if (this.d != null) goto L46;
        this.d = du2.a.d(2000, TimeUnit.MILLISECONDS).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g0(this), h0.a);
    L33:
        r6 = null;
        goto L35
    L24:
        if (this.o != null) goto L26;
        a6 r42 = new a6(getContext());
        this.o = r42;
        r42.b(this);
        goto L26
    }
}
