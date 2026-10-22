package com.larus.video.impl.sdk;

import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.account.base.api.IAccountService;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.music.player.VideoEngineMusicPlayerViewImpl;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.VideoEngineState;
import com.larus.platform.api.j4;
import com.larus.platform.api.k0;
import com.larus.platform.api.k4;
import com.larus.platform.api.l4;
import com.larus.platform.api.n0;
import com.larus.platform.api.o0;
import com.larus.platform.api.p0;
import com.larus.platform.constants.media.DataLoaderPreloadPriority;
import com.larus.platform.model.video.business.IVideoFeedProvider;
import com.larus.platform.service.AccountService;
import com.larus.settings.value.as;
import com.larus.settings.value.e10;
import com.larus.settings.value.nd;
import com.larus.settings.value.q4;
import com.larus.settings.value.u5;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.larus.video.impl.TTPlayerInitializer;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.texturerender.VideoSurface;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.PreloaderVideoModelItem;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.TTVideoEngineConfig;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoModel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l2a.u;
import l2a.v;
import l2a.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o implements IVideoController {
    public static final List<o> l = null;
    public String a;
    public float b;
    public String c;
    public final TTVideoEngine d;
    public final HashMap<String, j4> e;
    public boolean f;
    public final q g;
    public final s h;
    public zp9.k i;
    public volatile boolean j;
    public com.larus.platform.api.n k;

    public static final class a {
        public a() {
        }

        public static void a(com.larus.video.impl.sdk.a r6, String r7, long r8, DataLoaderPreloadPriority r10, final k0 r11) {
            Intrinsics.checkNotNullParameter(r10, "priority");
            if (r6 == null) goto L15;
            VideoModel r9 = r6.a;
            if (r9 != null) goto L7;
            r9 = null;
        L7:
            VideoModel r1 = r9;
            if (r1 == null) goto L16;
            FLogger.a.d("VideoViewHolder", "Preload video model ");
            Resolution r12 = Resolution.forString(r7);
            if (r12 != Resolution.Undefine) goto L13;
            r12 = Resolution.Standard;
        L13:
            PreloaderVideoModelItem r13 = new PreloaderVideoModelItem(r1, r12, r8, false);
            r13.setPriorityLevel(r10.getValue());
            r13.setCallBackListener(new m(r11));
            TTVideoEngine.addTask(r13);
            return;
        L16:
            return;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[VideoEngineState.values().length];
            r0[VideoEngineState.LOAD_STATE_STALLED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[VideoEngineState.LOAD_STATE_ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[VideoEngineState.PLAYBACK_STATE_PLAYING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[VideoEngineState.PLAYBACK_STATE_PAUSED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[VideoEngineState.PLAYBACK_STATE_STOPPED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[VideoEngineState.PLAYBACK_STATE_ERROR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public static final class c implements l4 {
        public final /* synthetic */ o a;

        public c(o r1) {
            this.a = r1;
        }

        public final void a(String r1, com.larus.video.impl.sdk.a r2) {
            if (r2 == null) goto L10;
            IVideoModel r3 = r2.a;
            if (r3 != null) goto L6;
            r3 = null;
        L6:
            if (r3 == null) goto L11;
            this.a.d.setVideoModel(r3);
            this.a.d.play();
            return;
        L11:
            return;
        }
    }

    public final void J() {
        this.d.setAsyncInit(false, 0);
    }

    public final synchronized com.larus.platform.api.n a() {
        monitor-enter(this);
        com.larus.platform.api.n r0 = this.k;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final void t() {
        this.a = null;
        HashMap<String, j4> r0 = this.e;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    static {
        new a();
        l = new ArrayList();
    }

    public final void K() {
        this.d.setIntOption(329, 0);
    }

    public final void b() {
        L("pause");
        this.d.pause();
    }

    public final IVideoController.PlayType d() {
        if (this.d.getPlaybackState() != 1) goto L6;
        return IVideoController.PlayType.PLAY;
    L6:
        if (this.g.e == false) goto L9;
        return IVideoController.PlayType.PREPARE;
    L9:
        return IVideoController.PlayType.PAUSE;
    }

    public final int getCurrentPlaybackTime() {
        return this.d.getCurrentPlaybackTime();
    }

    public final String getCurrentResolution() {
        Resolution r0 = this.d.getCurrentResolution();
        if (r0 != null) goto L6;
        r0 = Resolution.Undefine;
    L6:
        return Resolution.toString(r0);
    }

    public final int getWatchedDuration() {
        return this.d.getWatchedDuration();
    }

    public final void l() {
        this.g.b = null;
    }

    public final int n() {
        return this.d.getDuration();
    }

    public final int o() {
        return this.d.getLoadedProgress();
    }

    public final boolean p3() {
        if (this.d.getPlaybackState() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void play() {
        L("play");
        this.d.play();
    }

    public final void release() {
        L("release");
        this.f = true;
        List<o> r0 = l;
        if (((ArrayList) r0).contains(this) == false) goto L11;
        monitor-enter(r0);
        ((ArrayList) r0).remove(this);     // Catch: Throwable -> L8
        monitor-exit(r0);
    L8:
        th = move-exception;
        throw th;
    L11:
        TTVideoEngine r1 = this.d;
        s r2 = this.h;
        rx9.k r3 = r2.a;
        if (r3 == null) goto L14;
        r3.a();
    L14:
        r2.a = null;
        r1.removeVideoEngineCallback(r2);
        this.d.release();     // Catch: ConcurrentModificationException -> L17
        u.a(new g(this));     // Catch: ConcurrentModificationException -> L17
        return;
    L17:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "TTVideoControllerImpl");
        FLogger.a.e("TTVideoControllerImpl", "release exception", e);
    }

    public final void releaseSurface() {
        VideoSurface r0 = this.d.getTextureSurface();
        if (r0 == null) goto L5;
        r0.setIntOption(9, 1);
        r0.updateRenderSurface(null);
        r0.setIntOption(9, 0);
        return;
    L5:
        long r2 = TTVideoEngineConfig.setSurfaceTimeoutForDestroy;
        if (r2 != Long.MIN_VALUE) goto L8;
        r2 = 1000;
    L8:
        this.d.setSurfaceSync(null, r2);
    }

    public final List<String> u() {
        Resolution[] r0 = this.d.supportedResolutionTypes();
        if (r0 == null) goto L5;
        ArrayList r1 = new ArrayList();
        int r2 = r0.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L9;
        r1.add(Resolution.toString(r0[r3]));
        r3 = r3 + 1;
        goto L7
    L9:
        return r1;
    L5:
        return CollectionsKt.emptyList();
    }

    public final boolean v() {
        if (this.d.getLongOption(64) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean z() {
        if (this.d.getIVideoModel() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void stop() {
        L("stop");
        if (this.j == false) goto L17;
        boolean r0 = u.a;
        u.b("TTVideoControllerImpl", "BmfVideoSRHelper, stop use bmf: " + this.d.isplaybackUsedSR() + ", ttVideoEngine:" + this.d.hashCode());
        boolean r1 = this.d.isplaybackUsedSR();
        if (r1 == true) goto L7;
        String r2 = String.valueOf(this.d.getIntOption(660));
        u.b("TTVideoControllerImpl", "BmfVideoSRHelper, not use bmf, reason " + r2);
    L8:
        int r3 = w.a;
        boolean r4 = this.j;
        Intrinsics.checkNotNullParameter(r2, "reason");
        Pair[] r5 = new Pair[4];
        r5[0] = TuplesKt.to("action_type", "play");
        String r6 = "1";
        if (r4 == false) goto L11;
        Object r7 = "1";
    L12:
        r5[1] = TuplesKt.to("need_use_sr", r7);
        if (r1 == true) goto L16;
        r6 = "0";
    L16:
        r5[2] = TuplesKt.to("is_sr_worked", r6);
        r5[3] = TuplesKt.to("sr_worked_not_work_reason", r2);
        com.larus.platform.service.o.a.b("event_video_sr_monitor", com.larus.utils.f.c(r5));
        goto L17
    L11:
        r7 = "0";
        goto L12
    L7:
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L17:
        this.d.stop();
    }

    public final float g() {
        return this.b;
    }

    public final String getBotId() {
        return this.c;
    }

    public final String getMediaId() {
        return this.a;
    }

    public final boolean isReleased() {
        return this.f;
    }

    public o(Integer r6) {
        this.b = 1.0f;
        this.e = new HashMap();
        s r0 = new s();
        this.h = r0;
        if (r6 == null) goto L5;
        TTVideoEngine r3 = TTPlayerInitializer.a;
        TTVideoEngine r7 = TTPlayerInitializer.a(r6.intValue(), true);
    L6:
        r7.addVideoEngineCallback(r0);
        r7.setIntOption(160, 1);
        e10 r4 = e10.a;
        int r5 = l0.a;
        Boolean r8 = Boolean.FALSE;
        if (((Boolean) l0.a(r8, new as())).booleanValue() == false) goto L9;
    L10:
        r7.setIntOption(120, 1);
    L12:
        if (((Boolean) l0.a(r8, new nd())).booleanValue() == false) goto L14;
    L15:
        r7.setIntOption(488, 1);
    L16:
        ((Boolean) l0.a(r8, new u5())).booleanValue();
        if (Intrinsics.areEqual(((qt9.l4) l0.a(new qt9.l4(0), new q4())).a(), Boolean.TRUE) == false) goto L19;
        r7.setIntOption(472, 1);
    L19:
        this.d = r7;
        AccountService.a.E(new j());
        q r1 = new q(r7);
        this.g = r1;
        r7.setVideoEngineCallback(r1);
        r7.setIntOption(160, 1);
        this.k = new com.larus.platform.api.n();
        return;
    L14:
        if (ObricFeatureServiceDelegate.b.c() == false) goto L16;
    L9:
        if (ObricFeatureServiceDelegate.b.c() == false) goto L12;
    L5:
        TTVideoEngine r9 = TTPlayerInitializer.a;
        int r10 = v.a;
        r7 = TTPlayerInitializer.a(0, true);
        goto L6
    }

    public final void C(boolean r2) {
        this.d.setIsMute(r2);
    }

    public final void E(String r1) {
        this.a = r1;
    }

    public final boolean F(String r2) {
        Intrinsics.checkNotNullParameter(r2, "resolutionStr");
        Resolution r3 = Resolution.forString(r2);
        if (r3 != Resolution.Undefine) goto L6;
        return false;
    L6:
        this.d.configResolution(r3);
        return true;
    }

    public final int G(VideoEngineState r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        switch(b.a[r3.ordinal()]) {
            case 1: goto L8;
            case 2: goto L10;
            case 3: goto L7;
            case 4: goto L8;
            case 5: goto L6;
            case 6: goto L10;
            default: goto L5;
        };
    L6:
        return 0;
    L7:
        return 1;
    L8:
        return 2;
    L10:
        return 3;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final synchronized void H(com.larus.platform.api.n r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.PARAMS_KEY);     // Catch: Throwable -> L8
        this.k = r3;     // Catch: Throwable -> L8
        TTVideoEngine r0 = this.d;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        PlaybackParams r1 = new PlaybackParams();     // Catch: Throwable -> L8
        r1.setSpeed(r3.a);     // Catch: Throwable -> L8
        r0.setPlaybackParams(r1);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void I(boolean r2) {
        List<o> r0 = l;
        monitor-enter(r0);
        if (r2 == true) goto L6;
        ((ArrayList) r0).remove(this);     // Catch: Throwable -> L9
    L12:
        monitor-exit(r0);
        return;
    L6:
        if (((ArrayList) r0).contains(this) == true) goto L8;
        ((ArrayList) r0).add(this);     // Catch: Throwable -> L9
        goto L12
    L8:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final void L(String r4) {
        FLogger.a.i("flow_video_engine", "[playback] action=" + r4 + " controller=" + hashCode() + " engine=" + this.d.hashCode() + " released=" + this.f + " state=" + this.d.getPlaybackState() + " loadState=" + this.d.getLoadState());
    }

    public final void c(float r2) {
        this.b = r2;
        this.d.setVolume(r2, r2);
    }

    public final int e(com.larus.video.impl.sdk.a r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r2, "model");
        IVideoModel r3 = r2.a;
        if (r3 != null) goto L5;
        r3 = null;
    L5:
        if (r3 != null) goto L8;
        return 0;
    L8:
        return r3.getVideoRefInt(3);
    }

    public final void h(k4 r2) {
        Intrinsics.checkNotNullParameter(r2, "mediaSceneInfo");
        this.g.d = r2;
    }

    public final void i(int r3) {
        this.d.setIntOption(r3, 0);
    }

    public final void k(String r1) {
        this.c = r1;
    }

    public final void p(n0 r2) {
        Intrinsics.checkNotNullParameter(r2, "videoEnginCallback");
        new WeakReference(r2);
        this.g.b = r2;
    }

    public final void r(String r4) {
        if ((!StringsKt.isBlank(r4)) == true) goto L6;
        r4 = null;
    L6:
        if (r4 == null) goto L15;
        Map r5 = IAccountService.a.u(r4);
        if (r5.isEmpty() == false) goto L11;
        return;
    L11:
        Iterator r6 = r5.entrySet().iterator();
    L13:
        if (r6.hasNext() == false) goto L17;
        Map.Entry r0 = (Map.Entry) r6.next();
        this.d.setCustomHeader((String) r0.getKey(), (String) r0.getValue());
        goto L13
    L17:
        return;
    }

    public final void s(final o0 r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        TTVideoEngine r0 = this.d;
        if (r0 == null) goto L6;
        r0.setVideoEngineInfoListener(new i(r3));
        return;
    }

    public final void setDirectURL(String r2) {
        this.d.setDirectURL(r2);
    }

    public final void setLocalURL(String r2) {
        this.d.setLocalURL(r2);
    }

    public final void setLooping(boolean r2) {
        this.d.setLooping(r2);
    }

    public final void setStartTime(int r2) {
        this.d.setStartTime(r2);
    }

    public final void setSubTag(String r2) {
        Intrinsics.checkNotNullParameter(r2, "subTag");
        this.d.setSubTag(r2);
    }

    public final void setSurface(Surface r2) {
        this.d.setSurface(r2);
    }

    public final void setSurfaceHolder(SurfaceHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        this.d.setSurfaceHolder(r2);
    }

    public final void w(int r3) {
        this.d.setIntOption(255, r3);
    }

    public final void x(String r2) {
        f(r2, new c(this));
    }

    public final void A(int r3, final com.larus.platform.api.l0 r4) {
        this.d.seekTo(r3, new h(r4));
    }

    public final void B(float r6, float r7) {
        float r0 = AudioServiceDelegate.a.b();
        FLogger.a.d("Loudness", "TTVideoEngine[news] set target loudness, loudness = " + r6 + ", peak = " + r7 + ", target = " + r0);
        boolean r1 = true;
        if (r6 != 0.0f) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        return;
    L8:
        if (r7 != 0.0f) goto L10;
        boolean r5 = true;
    L11:
        if (r5 == false) goto L13;
        return;
    L13:
        if (r0 == 0.0f) goto L16;
        r1 = false;
    L16:
        if (r1 == true) goto L21;
        this.d.setFloatOption(345, r6);
        this.d.setFloatOption(346, r7);
        this.d.setFloatOption(344, r0);
        return;
    L21:
        return;
    L10:
        r5 = false;
        goto L11
    L5:
        r4 = false;
        goto L6
    }

    public final void D(VideoEngineMusicPlayerViewImpl.h r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        HashMap<String, j4> r4 = this.e;
        if (r4 == null) goto L6;
        j4 r5 = r4.remove(r3);
        return;
    }

    public final void f(String r2, l4 r3) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L12;
        ThreadPlus.submitRunnable(new k(r2, r3));
        return;
    L12:
        return;
    L4:
        if (StringsKt.isBlank(r2) == true) goto L7;
        r0 = false;
        goto L8
    }

    public final void j(p0 r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "model");
        VideoModel r0 = r6.getImpl();
        if (r0 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r0, this.d.getIVideoModel()) == false) goto L8;
        return;
    L8:
        boolean r3 = true;
        this.d.setIntOption(160, 1);
        this.d.setVideoModel(r0);
        HashMap<String, j4> r1 = this.e;
        if (r1 == null) goto L14;
        Iterator<Map.Entry<String, j4>> r2 = r1.entrySet().iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        r2.next().getValue().a(r6, r7);
    L14:
        float r8 = r0.getVideoRefFloat(224);
        float r9 = r0.getVideoRefFloat(225);
        float r4 = AudioServiceDelegate.a.b();
        FLogger.a.d("Loudness", "TTVideoEngine[" + this.d.getTag() + "] set target loudness, loudness = " + r8 + ", peak = " + r9 + ", target = " + r4);
        if (r8 != 0.0f) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == false) goto L20;
        return;
    L20:
        if (r9 != 0.0f) goto L22;
        boolean r10 = true;
    L23:
        if (r10 == false) goto L25;
        return;
    L25:
        if (r4 == 0.0f) goto L28;
        r3 = false;
    L28:
        if (r3 == true) goto L34;
        this.d.setFloatOption(345, r8);
        this.d.setFloatOption(346, r9);
        this.d.setFloatOption(344, r4);
        return;
    L34:
        return;
    L22:
        r10 = false;
        goto L23
    L17:
        r5 = false;
        goto L18
    }

    public final void q(VideoEngineMusicPlayerViewImpl.h r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        HashMap<String, j4> r0 = this.e;
        if (r0 == null) goto L5;
        j4 r1 = r0.get(r3);
    L6:
        if (r1 != null) goto L11;
        HashMap<String, j4> r4 = this.e;
        if (r4 == null) goto L12;
        j4 r5 = r4.put(r3, r2);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setDirectUrlUseDataLoader(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        this.d.setDirectUrlUseDataLoader(r2, r3);
    }

    public final void y(boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        boolean r0 = u.a;
        u.b("TTVideoControllerImpl", "enableUseSR:" + r3);
        this.j = r3;
        if (r3 == true) goto L5;
        zp9.k r5 = this.i;
        if (r5 == null) goto L22;
        r5.a(false);
        return;
    L22:
        return;
    L5:
        if (this.i != null) goto L13;
        IVideoFeedProvider r6 = (IVideoFeedProvider) ServiceManager.get().getService(IVideoFeedProvider.class);
        if (r6 == null) goto L11;
        zp9.k r7 = r6.f();
        if (r7 == null) goto L11;
        r7.e(this.d);
        r7.b("TTVideoControllerImpl, setEnableUseSR, " + r4 + ',' + r7.hashCode());
    L12:
        this.i = r7;
    L11:
        r7 = null;
    L13:
        zp9.k r8 = this.i;
        if (r8 == null) goto L20;
        r8.a(true);
        return;
    }

    public final void m(com.larus.video.impl.sdk.a r2, String r3, long r4, DataLoaderPreloadPriority r6, k0 r7) {
        Intrinsics.checkNotNullParameter(r6, "priority");
        a.a(r2, r3, r4, r6, r7);
    }
}
