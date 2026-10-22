package com.bytedance.android.livesdk.gift.platform.business.effect.player;

import android.content.Context;
import android.view.Surface;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livesdk.downloader.GiftResourceManagerFactory;
import com.bytedance.android.livesdk.gift.configmodel.b0;
import com.bytedance.android.livesdk.gift.platform.core.c0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.i2;
import com.bytedance.android.livesdkapi.depend.live.gift.SuperResolutionModel;
import com.ss.android.ugc.aweme.live.alphaplayer.model.VideoInfo;
import com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer;
import com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineListener;
import com.ss.ttvideoengine.utils.Error;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t extends AbsPlayer<t> {
    public TTVideoEngine g;
    public b h;
    public long i;
    public Disposable j;
    public s k;
    public SuperResolutionModel l;
    public boolean m;
    public final b0 n;
    public final a o;

    public class a implements VideoEngineListener {
        public final /* synthetic */ t a;

        public final void onBufferingUpdate(TTVideoEngine r1, int r2) {
        }

        public final /* synthetic */ void onFirstAVSyncFrame(TTVideoEngine r1) {
            VideoEngineListener.-CC.$default$onFirstAVSyncFrame(this, r1);
        }

        public final void onLoadStateChanged(TTVideoEngine r1, int r2) {
        }

        public final void onPlaybackStateChanged(TTVideoEngine r1, int r2) {
        }

        public final void onPrepare(TTVideoEngine r1) {
        }

        public final /* synthetic */ void onRefreshSurface(TTVideoEngine r1) {
            VideoEngineListener.-CC.$default$onRefreshSurface(this, r1);
        }

        public final /* synthetic */ int onSetSurface(TTVideoEngine r1, VideoSurface r2, Surface r3) {
            return VideoEngineListener.-CC.$default$onSetSurface(this, r1, r2, r3);
        }

        public final /* synthetic */ void onSilenceDetected(TTVideoEngine r1) {
            VideoEngineListener.-CC.$default$onSilenceDetected(this, r1);
        }

        public final void onStreamChanged(TTVideoEngine r1, int r2) {
        }

        public final /* synthetic */ void onVideoSecondFrame(TTVideoEngine r1) {
            VideoEngineListener.-CC.$default$onVideoSecondFrame(this, r1);
        }

        public final void onVideoSizeChanged(TTVideoEngine r1, int r2, int r3) {
        }

        public final void onVideoStatusException(int r1) {
        }

        public a(t r1) {
            this.a = r1;
        }

        public final void onCompletion(TTVideoEngine r11) {
            SuperResolutionModel r0 = this.a.l;
            if (r0 != null) goto L5;
        L10:
            jy0.b.e("TTEnginePlayer", "openSR is false", null);
            SuperResolutionModel r13 = this.a.l;
            if (r13 == null) goto L13;
            c0.s(r13.getEffectId(), 0, "not open sr", false, false, true);
        L13:
            t r14 = this.a;
            IMediaPlayer.OnCompletionListener r1 = ((AbsPlayer) r14).c;
            if (r1 == null) goto L17;
            r1.a(((AbsPlayer) r14).a);
            return;
        L17:
            return;
        L5:
            if (r0.getOpenSR() == false) goto L10;
            if (this.a.g.isplaybackUsedSR() == true) goto L9;
            int r15 = r11.getIntOption(660);
            jy0.b.b("TTEnginePlayer", "super resource is not use SR,openSR is true and reason is " + r15, null);
            c0.s(this.a.l.getEffectId(), r15, "open sr failed", true, false, false);
            this.a.l.setResultCode(r15);
            goto L13
        L9:
            jy0.b.e("TTEnginePlayer", "super resource use SR,openSR is true", null);
            c0.s(this.a.l.getEffectId(), 0, "open sr success", true, true, true);
            goto L13
        }

        public final void onError(Error r5) {
            t r0 = this.a;
            IMediaPlayer.OnErrorListener r1 = ((AbsPlayer) r0).e;
            if (r1 == null) goto L6;
            r1.a(((AbsPlayer) r0).a, r5.code, r5.internalCode, r5.description);
            return;
        }

        public final void onPrepared(TTVideoEngine r2) {
            t r3 = this.a;
            IMediaPlayer.OnPreparedListener r0 = ((AbsPlayer) r3).d;
            if (r0 == null) goto L6;
            r0.a(((AbsPlayer) r3).a);
            return;
        }

        public final void onRenderStart(TTVideoEngine r2) {
            t r3 = this.a;
            IMediaPlayer.OnFirstFrameListener r0 = ((AbsPlayer) r3).f;
            if (r0 == null) goto L6;
            r0.a(((AbsPlayer) r3).a);
            return;
        }
    }

    public final void a() {
    }

    public final String c() {
        return "TTEnginePlayerImpl";
    }

    public final void reset() {
    }

    public final void b() throws Exception {
        jy0.b.a("Alpha-TTEngine", "initMediaPlayer() called");
        LivePluginSPIManager r0 = LivePluginSPIManager.e;
        s r1 = new s(this);
        this.k = r1;
        r0.getClass();
        LivePluginSPIManager.d(r1);
        this.g = new TTVideoEngine(((AbsPlayer) this).b, 0);
        this.h = new b();
        if (this.g.isSystemPlayer() == true) goto L23;
        this.g.setIntOption(4, 1);
        if (this.n.disableAudioHardDecode == true) goto L7;
        this.g.setIntOption(216, 1);
    L7:
        this.g.setIntOption(415, 1);
        ReadOnlyProperty r2 = com.bytedance.android.livesdk.gift.platform.business.effect.a.c;
        KProperty[] r3 = com.bytedance.android.livesdk.gift.platform.business.effect.a.a;
        if (((Boolean) r2.getValue(null, r3[1])).booleanValue() == false) goto L10;
        this.g.setIntOption(199, 1);
    L10:
        this.g.setIntOption(610, 0);
        this.g.setTag("live_gift_player");
        ((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.M.getValue(null, r3[37])).booleanValue();
        this.g.setListener(this.o);
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.e().disableSRInit == true) goto L18;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.b.e.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.b.a[3])).booleanValue() == false) goto L15;
    L16:
        this.g.asyncInitSR(false);
        this.g.ignoreSRResolutionLimit(true);
        this.g.dynamicControlSR(true);
        this.g.setSRInitConfig(((Number) com.bytedance.android.livesdk.gift.platform.business.effect.a.g.getValue(null, r3[5])).intValue(), GiftResourceManagerFactory.a().a().a(), "super", "super");
        this.g.openTextureSR(true, false);
        goto L18
    L15:
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.i().b() == true) goto L16;
    L18:
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.h() != 1) goto L20;
        this.g.setIntOption(7, 1);
        jy0.b.a("PlayerType", "PlayerType HARDCODE");
        return;
    L20:
        jy0.b.a("PlayerType", "PlayerType SOFT DECODE");
        return;
    L23:
        throw new Exception("create ttVideoEngine failure");
    }

    public final int getCurrentPosition() {
        return this.g.getCurrentPlaybackTime();
    }

    public final VideoInfo getVideoInfo() throws Exception {
        return new VideoInfo(this.g.getVideoWidth(), this.g.getVideoHeight(), this.g.getDuration());
    }

    public final void pause() {
        jy0.b.a("Alpha-TTEngine", "pause() called with player : [" + this.g + "]");
        this.g.pause();
    }

    public final void prepareAsync() {
        jy0.b.a("Alpha-TTEngine", "prepareAsync() called with player : [" + this.g + "]");
        ((AbsPlayer) this).d.a(this);
    }

    public final void release() {
        jy0.b.a("Alpha-TTEngine", "release() called with player : [" + this.g + "]");
        s r0 = this.k;
        if (r0 == null) goto L5;
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.e(r0);
    L5:
        this.g.release();
    }

    public final void start() {
        jy0.b.a("Alpha-TTEngine", "start() called with player : [" + this.g + "]");
        this.g.play();
    }

    public final void stop() {
        jy0.b.a("Alpha-TTEngine", "stop() called with player : [" + this.g + "]");
        this.g.stop();
    }

    public t(Context r2) {
        super(r2);
        this.m = true;
        this.o = new a(this);
        ((AbsPlayer) this).b = r2;
        this.n = com.bytedance.android.livesdk.gift.platform.business.effect.a.e();
    }

    public static d0 h(t r1) {
        r1.getClass();
        com.bytedance.android.livesdk.revenue.room.a r2 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.room.b.class).x2();
        if (r2 != null) goto L5;
    L9:
        com.bytedance.android.livesdk.revenue.pushstream.a r3 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.interact.d.class).getAudioTalkService().n();
        if (r3 != null) goto L15;
        return null;
    L15:
        return r3.A();
    L5:
        if (((Boolean) r2.isAnchor().getValue()).booleanValue() == false) goto L9;
        com.bytedance.android.livesdk.revenue.pushstream.a r4 = (com.bytedance.android.livesdk.revenue.pushstream.a) r2.getLiveStream().getValue();
        if (r4 == null) goto L9;
        return r4.A();
    }

    public final void setDataSource(String r9) throws IOException {
        jy0.b.a("Alpha-TTEngine", "setDataSource() called with player : [" + this.g + "]");
        this.g.setLocalURL(r9);
        this.g.setAudioProcessor(this.h);
        long r2 = this.i;
        if (r2 == 0) goto L8;
        TTVideoEngine r4 = this.g;
        if (r4 == null) goto L8;
        r4.setLongOption(440, r2);
        this.g.setIntOption(430, 2);
    L8:
        if (com.bytedance.android.livesdk.gift.platform.core.h.j().d() == false) goto L18;
        KProperty[] r3 = com.bytedance.android.livesdk.gift.platform.core.utils.s.a;
        i12.e r5 = i12.o.b();
        if (r5 == null) goto L12;
        Object r6 = com.bytedance.android.scope.m.e.d(r5, i2.class);
    L13:
        i2 r7 = (i2) r6;
        if (r7 == null) goto L16;
        Boolean r8 = Boolean.valueOf(r7.c());
    L24:
        if (r8.booleanValue() == true) goto L26;
    L28:
        boolean r10 = false;
    L29:
        this.g.setIsMute(!r10);
        if (r10 == true) goto L32;
    L41:
        boolean r1 = !com.bytedance.android.livesdk.gift.platform.business.effect.a.e().disableTextureRenderer;
        SuperResolutionModel r11 = this.l;
        if (r11 != null) goto L44;
        this.g.openTextureSR(r1, false);
        return;
    L44:
        if (r11.getOpenSR() == false) goto L57;
        this.g.openTextureSR(true, true);
        if (this.l.getVideoWidth() <= 0) goto L51;
        if (this.l.getVideoHeight() <= 0) goto L51;
        this.g.setSrMaxTexureSize(this.l.getVideoWidth() * 2, this.l.getVideoHeight() * 2);
    L58:
        jy0.b.e("TTEnginePlayer", "dataPath is " + r9 + "and isOpenSR is " + this.l.getOpenSR(), null);
        return;
    L51:
        if (this.l.getVideoHeight() <= 0) goto L54;
        jy0.b.e("TTEnginePlayer", "dataPath is " + r9 + "and width is 0, height is" + this.l.getVideoHeight(), null);
        this.g.setSrMaxTexureSize(2880, this.l.getVideoHeight() * 2);
        goto L58
    L54:
        if (this.l.getVideoWidth() <= 0) goto L56;
        jy0.b.e("TTEnginePlayer", "dataPath is " + r9 + "and width is " + this.l.getVideoWidth() + "height is 0", null);
        this.g.setSrMaxTexureSize(this.l.getVideoWidth() * 2, 2880);
        goto L58
    L56:
        jy0.b.e("TTEnginePlayer", "dataPath is " + r9 + "and width is 0, height is 0", null);
        this.g.setSrMaxTexureSize(2880, 2880);
        goto L58
    L57:
        this.g.openTextureSR(r1, false);
        goto L58
    L32:
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.h.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.a[6])).booleanValue() == true) goto L34;
        jy0.b.d("Alpha-TTEngine", "setGiftPlayVolumeBaseOnStreamDB: returned by setting \"live_gift_sound_volume_dynamic_adjust\" not enable");
        goto L41
    L34:
        final or2.j r13 = com.bytedance.android.live.revenue.core.util.e.a(or2.e.class).getCurrentClient();
        if (r13 != null) goto L37;
        jy0.b.d("Alpha-TTEngine", "setGiftPlayVolumeBaseOnStreamDB: returned by LiveRoomPlayer.getCurrentClient() = null");
        goto L41
    L37:
        Disposable r14 = this.j;
        if (r14 == null) goto L40;
        r14.dispose();
    L40:
        this.j = Single.create(new p(this, r13)).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new q(this), new r());
        goto L41
    L26:
        if (this.m == false) goto L28;
        r10 = true;
        goto L29
    L16:
        r8 = Boolean.TRUE;
        goto L24
    L12:
        r6 = null;
        goto L13
    L18:
        if (com.bytedance.android.livesdk.gift.util.b.b() != null) goto L20;
    L22:
        r8 = Boolean.TRUE;
        goto L24
    L20:
        if (com.bytedance.android.livesdk.gift.util.b.b().getEffectAudioSwitch().getValue() == null) goto L22;
        r8 = (Boolean) com.bytedance.android.livesdk.gift.util.b.b().getEffectAudioSwitch().getValue();
        goto L24
    }

    public final void setLooping(boolean r2) {
        this.g.setLooping(r2);
    }

    public final void setSurface(Surface r3) {
        jy0.b.a("Alpha-TTEngine", "setSurface() called with player : [" + this.g + "]");
        this.g.setSurface(r3);
    }
}
