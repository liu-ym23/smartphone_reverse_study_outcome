package com.bytedance.android.livesdk.gift.platform.business.effect.player;

import android.content.Context;
import android.view.Surface;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.i2;
import com.bytedance.android.livesdk.revenue.host.RevHostPluginType;
import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.live.alphaplayer.model.VideoInfo;
import com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer;
import com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.player.MediaPlayerClient;
import com.ss.ttm.player.OSPlayerClient;
import com.ss.ttm.player.TTPlayerConfiger;
import java.io.IOException;
import java.lang.reflect.Method;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u extends AbsPlayer<u> {
    public final Context g;
    public o h;
    public final a i;
    public final b j;
    public final c k;
    public final d l;

    public class a implements MediaPlayer.OnPreparedListener {
        public final /* synthetic */ u a;

        public a(u r1) {
            this.a = r1;
        }

        public final void onPrepared(MediaPlayer r2) {
            u r3 = this.a;
            IMediaPlayer.OnPreparedListener r0 = ((AbsPlayer) r3).d;
            if (r0 == null) goto L6;
            r0.a(((AbsPlayer) r3).a);
            return;
        }
    }

    public class b implements MediaPlayer.OnErrorListener {
        public final /* synthetic */ u a;

        public b(u r1) {
            this.a = r1;
        }

        public final boolean onError(MediaPlayer r3, int r4, int r5) {
            u r6 = this.a;
            IMediaPlayer.OnErrorListener r0 = ((AbsPlayer) r6).e;
            if (r0 == null) goto L7;
            r0.a(((AbsPlayer) r6).a, r4, r5, "TTMediaPlayer on error");
            return false;
        L7:
            return false;
        }
    }

    public class c implements MediaPlayer.OnCompletionListener {
        public final /* synthetic */ u a;

        public c(u r1) {
            this.a = r1;
        }

        public final void onCompletion(MediaPlayer r2) {
            u r3 = this.a;
            IMediaPlayer.OnCompletionListener r0 = ((AbsPlayer) r3).c;
            if (r0 == null) goto L6;
            r0.a(((AbsPlayer) r3).a);
            return;
        }
    }

    public class d implements MediaPlayer.OnInfoListener {
        public final /* synthetic */ u a;

        public d(u r1) {
            this.a = r1;
        }

        public final boolean onInfo(MediaPlayer r1, int r2, int r3) {
            if (r2 != 3) goto L9;
            u r4 = this.a;
            IMediaPlayer.OnFirstFrameListener r5 = ((AbsPlayer) r4).f;
            if (r5 == null) goto L10;
            r5.a(((AbsPlayer) r4).a);
            return false;
        L10:
            return false;
        L9:
            return false;
        }
    }

    public final String c() {
        return "TTGiftPlayerImpl";
    }

    public final void a() {
        this.h.setScreenOnWhilePlaying(true);
    }

    public final void b() throws Exception {
        jy0.b.a("Alpha-TTPlayer", "initMediaPlayer() called");
        KmpEnv r0 = KmpEnv.a;
        if (KmpEnv.a() == false) goto L5;
    L9:
        TTPlayerConfiger.setValue(2, false);
        TTPlayerConfiger.setValue(1, true);
        TTPlayerConfiger.setValue(11, true);
        Context r3 = this.g;
        o r4 = new o();
        monitor-enter(o.class);
    L33:
        th = move-exception;
        throw th;
    L12:
        if (TTPlayerConfiger.isOnTTPlayer() == false) goto L26;
        Class r6 = o.a("com.ss.ttm.player.TTPlayerClient");     // Catch: Throwable -> L16
        Method r7 = r6.getDeclaredMethod("create", new Class[]{MediaPlayer.class, Context.class});     // Catch: Throwable -> L16
        r7.setAccessible(true);     // Catch: Throwable -> L16
        r4.a = (MediaPlayerClient) r7.invoke(r6, new Object[]{r4, r3});     // Catch: Throwable -> L16
    L19:
        if (r4.a != null) goto L26;
        Class r8 = o.a("com.ss.ttmplayer.player.TTPlayerClient");     // Catch: Throwable -> L23
        Method r9 = r8.getDeclaredMethod("create", new Class[]{MediaPlayer.class, Context.class});     // Catch: Throwable -> L23
        r9.setAccessible(true);     // Catch: Throwable -> L23
        r4.a = (MediaPlayerClient) r9.invoke(r8, new Object[]{r4, r3});     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L33
        th.toString();     // Catch: Throwable -> L33
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L33
        th.toString();     // Catch: Throwable -> L33
    L26:
        if (r4.a != null) goto L28;
        r4.a = OSPlayerClient.create(r4, r3);     // Catch: Throwable -> L33
    L28:
        monitor-exit(o.class);     // Catch: Throwable -> L33
        this.h = r4;
        r4.setIntOption(36, 1);
        this.h.setOnPreparedListener(this.i);
        this.h.setOnErrorListener(this.j);
        this.h.setOnCompletionListener(this.k);
        this.h.setOnInfoListener(this.l);
        if (com.bytedance.android.livesdk.gift.platform.business.effect.a.h() != 1) goto L42;
        this.h.setIntOption(59, 1);
        return;
    L42:
        return;
    L5:
        if (com.bytedance.android.live.revenue.core.util.e.a(dr2.h.class).r8(RevHostPluginType.Player).b() == true) goto L9;
        throw new IllegalStateException("ttm plugin not installed");
    }

    public final int getCurrentPosition() {
        return this.h.getCurrentPosition();
    }

    public final VideoInfo getVideoInfo() throws Exception {
        return new VideoInfo(this.h.getVideoWidth(), this.h.getVideoHeight(), this.h.getDuration());
    }

    public final boolean isPlaying() {
        return this.h.isPlaying();
    }

    public final void pause() {
        jy0.b.a("Alpha-TTPlayer", "pause() called with player : [" + this.h + "]");
        this.h.pause();
    }

    public final void prepareAsync() {
        jy0.b.a("Alpha-TTPlayer", "prepareAsync() called with player : [" + this.h + "]");
        o r0 = this.h;
        if (com.bytedance.android.livesdk.gift.platform.core.h.j().d() == false) goto L13;
        KProperty[] r1 = com.bytedance.android.livesdk.gift.platform.core.utils.s.a;
        i12.e r2 = i12.o.b();
        if (r2 == null) goto L7;
        Object r3 = com.bytedance.android.scope.m.e.d(r2, i2.class);
    L8:
        i2 r4 = (i2) r3;
        if (r4 == null) goto L11;
        Boolean r5 = Boolean.valueOf(r4.c());
    L18:
        r0.setIsMute(!r5.booleanValue());
        this.h.prepareAsync();
        return;
    L11:
        r5 = Boolean.TRUE;
        goto L18
    L7:
        r3 = null;
        goto L8
    L13:
        if (com.bytedance.android.livesdk.gift.util.b.b() != null) goto L15;
    L17:
        r5 = Boolean.TRUE;
        goto L18
    L15:
        if (com.bytedance.android.livesdk.gift.util.b.b().getEffectAudioSwitch().getValue() == null) goto L17;
        r5 = (Boolean) com.bytedance.android.livesdk.gift.util.b.b().getEffectAudioSwitch().getValue();
        goto L18
    }

    public final void release() {
        jy0.b.a("Alpha-TTPlayer", "release() called with player : [" + this.h + "]");
        this.h.release();
    }

    public final void reset() {
        jy0.b.a("Alpha-TTPlayer", "reset() called with player : [" + this.h + "]");
        this.h.reset();
    }

    public final void start() {
        jy0.b.a("Alpha-TTPlayer", "start() called with player : [" + this.h + "]");
        this.h.start();
    }

    public final void stop() {
        jy0.b.a("Alpha-TTPlayer", "stop() called with player : [" + this.h + "]");
        this.h.stop();
    }

    public u(Context r2) {
        super(r2);
        this.i = new a(this);
        this.j = new b(this);
        this.k = new c(this);
        this.l = new d(this);
        this.g = r2;
    }

    public final void setDataSource(String r3) throws IOException {
        jy0.b.a("Alpha-TTPlayer", "setDataSource() called with player : [" + this.h + "]");
        if (this.h.isPlaying() == false) goto L5;
        this.h.stop();
    L5:
        this.h.reset();
        this.h.setDataSource(this.g, UriProtector.parse(r3));
    }

    public final void setLooping(boolean r2) {
        this.h.setLooping(r2);
    }

    public final void setSurface(Surface r3) {
        jy0.b.a("Alpha-TTPlayer", "setSurface() called with player : [" + this.h + "]");
        this.h.setSurface(r3);
    }
}
