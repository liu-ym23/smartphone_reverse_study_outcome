package com.lynx.clay.embedding.engine.plugins.audio;

import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.canvas.camera.CameraSize;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import com.ss.ttvideoengine.SeekCompletionListener;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineSimpleCallback;
import com.ss.ttvideoengine.utils.Error;
import java.util.TimerTask;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements AudioPlayer.a {
    public TTVideoEngine a;
    public AudioPlayer b;
    public final int c;
    public final Handler d;
    public final PthreadTimer e;
    public final a f;
    public C0037b g;
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;
    public String l;

    public class a implements Runnable {
        public final /* synthetic */ b a;

        @Override // java.lang.Runnable
        public final void run() {
            b r0 = this.a;     // Catch: Throwable -> L8
            AudioPlayer r1 = r0.b;     // Catch: Throwable -> L8
            if (r1 == null) goto L11;
            TTVideoEngine r2 = r0.a;     // Catch: Throwable -> L8
            if (r2 == null) goto L15;
            r1.onTimeUpdate(r2.getCurrentPlaybackTime(), this.a.b.getCurrentSrcID());     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }

        public a(b r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.lynx.clay.embedding.engine.plugins.audio.b$b, reason: collision with other inner class name */
    public class C0037b extends TimerTask {
        public final /* synthetic */ b a;

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            b r0 = this.a;     // Catch: Throwable -> L6
            if (r0.i == false) goto L9;
            r0.d.post(r0.f);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public C0037b(b r1) {
            this.a = r1;
        }
    }

    public class c extends VideoEngineSimpleCallback {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        public final void onCompletion(TTVideoEngine r3) {
            c5a.c.d(6, "AudioPlayerTTImpl", "engine onCompletion");
            AudioPlayer r4 = this.a.b;
            r4.onFinished(r4.getCurrentSrcID());
        }

        public final void onError(Error r4) {
            c5a.c.d(6, "AudioPlayerTTImpl", "engine onError - code: " + r4.code);
            AudioPlayer r0 = this.a.b;
            r0.onError(r4.code, r4.description, r0.getCurrentSrcID());
        }

        public final void onPrepared(TTVideoEngine r3) {
            c5a.c.d(6, "AudioPlayerTTImpl", "engine onPrepared");
            AudioPlayer r4 = this.a.b;
            r4.onPrepared(r4.getCurrentSrcID());
        }

        public final void onLoadStateChanged(TTVideoEngine r3, int r4) {
            c5a.c.d(6, "AudioPlayerTTImpl", "engine onLoadStateChanged " + r4);
            if (r4 != 0) goto L5;
            String r5 = "unknown";
        L12:
            AudioPlayer r0 = this.a.b;
            r0.onLoadingStateChanged(r4, r5, r0.getCurrentSrcID());
            return;
        L5:
            if (r4 != 1) goto L7;
            r5 = "playable";
            goto L12
        L7:
            if (r4 == 2) goto L9;
            r5 = "error";
            goto L12
        L9:
            r5 = "stalled";
            goto L12
        }

        public final void onPlaybackStateChanged(TTVideoEngine r3, int r4) {
            c5a.c.d(6, "AudioPlayerTTImpl", "engine onPlaybackStateChanged " + r4);
            b r5 = this.a;
            if (r4 != 1) goto L5;
            boolean r1 = true;
        L6:
            r5.i = r1;
            if (r4 == 0) goto L14;
            if (r4 != 1) goto L10;
            String r0 = "playing";
        L15:
            AudioPlayer r6 = r5.b;
            r6.onPlaybackStateChanged(r4, r0, r6.getCurrentSrcID());
            return;
        L10:
            if (r4 == 2) goto L12;
            r0 = "error";
            goto L15
        L12:
            r0 = "paused";
            goto L15
        L14:
            r0 = "stopped";
            goto L15
        L5:
            r1 = false;
            goto L6
        }
    }

    public class d implements SeekCompletionListener {
        public final /* synthetic */ b a;

        public d(b r1) {
            this.a = r1;
        }

        public final void onCompletion(boolean r2) {
            AudioPlayer r3 = this.a.b;
            r3.onSeek(r3.getCurrentSrcID());
        }
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void e() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void f() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final int b() {
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getIntOption(60);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final int d() {
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getIntOption(61);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void dispose() {
        C0037b r0 = this.g;
        if (r0 == null) goto L5;
        r0.cancel();
        this.g = null;
    L5:
        TTVideoEngine r1 = this.a;
        if (r1 == null) goto L11;
        r1.setVideoEngineSimpleCallback(null);
        if (this.a.getPlaybackState() != 1) goto L10;
        this.a.stop();
    L10:
        this.a.releaseAsync();
        this.a = null;
    L11:
        this.b = null;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void enterBackground() {
        if (this.k == false) goto L6;
        return;
    L6:
        if (this.a.getPlaybackState() != 1) goto L8;
        boolean r0 = true;
    L9:
        this.j = r0;
        if (r0 == false) goto L14;
        this.a.pause();
        C0037b r1 = this.g;
        if (r1 == null) goto L14;
        r1.cancel();
        this.g = null;
    L14:
        this.k = true;
        return;
    L8:
        r0 = false;
        goto L9
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void enterForeground() {
        if (this.k == true) goto L6;
        return;
    L6:
        if (this.j == false) goto L8;
        this.a.play();
        h();
    L8:
        this.k = false;
    }

    public final void g() {
        if (this.a == null) goto L5;
        return;
    L5:
        if (this.b == null) goto L10;
        TTVideoEngine r0 = new TTVideoEngine(this.b.getFlutterView().getContext().getApplicationContext(), this.c);
        this.a = r0;
        r0.setVideoEngineSimpleCallback(new c(this));
        this.a.setIntOption(160, 1);
        this.a.setIntOption(CameraSize.mediumWidth, 1);
        this.a.setIntOption(402, 1);
        this.a.setIntOption(27, 1);
        this.a.setIntOption(416, 0);
        this.a.setIntOption(314, 1);
        this.a.setIntOption(28, 6);
        this.a.setIntOption(18, 1);
        this.a.setIntOption(415, 1);
        this.a.setIntOption(0, 300);
        this.a.setIntOption(CameraSize.mediumWidth, 1);
        this.a.setLooping(this.b.isLoop());
        this.a.setIsMute(this.b.isMute());
        this.a.setVolume(this.b.getVolume(), this.b.getVolume());
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final int getCurrentTime() {
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getCurrentPlaybackTime();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final int getDuration() {
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getDuration();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final int getPlaybackState() {
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getPlaybackState();
    }

    public final void h() {
        C0037b r0 = this.g;
        if (r0 == null) goto L5;
        r0.cancel();
        this.g = null;
    L5:
        C0037b r2 = new C0037b(this);
        this.g = r2;
        this.e.schedule(r2, 0, this.h);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void pause() {
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.pause();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void play() {
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.play();
        this.a.seekTo(0, null);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void prepare() {
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.prepare();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void resume() {
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.play();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void stop() {
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.stop();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void a(int r3) {
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.seekTo(r3, new d(this));
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void c(boolean r2) {
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setIsMute(r2);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void setInterval(int r4) {
        c5a.c.d(6, "AudioPlayerTTImpl", "setInterval - " + r4);
        C0037b r0 = this.g;
        if (r0 == null) goto L6;
        r0.cancel();
        this.g = null;
    L6:
        if (r4 >= 15) goto L8;
        r4 = 15;
    L8:
        this.h = r4;
        h();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void setLoop(boolean r2) {
        TTVideoEngine r0 = this.a;
        if (r0 == null) goto L6;
        r0.setLooping(r2);
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void setSrc(String r3) {
        g();
        AudioPlayer r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.a != null) goto L8;
        return;
    L8:
        if (r0.isRemoteUrl(r3) == false) goto L10;
        this.a.setDirectURL(r3);
    L12:
        if (this.b.isAutoplay() == false) goto L16;
        this.a.play();
        return;
    L16:
        return;
    L10:
        this.a.setLocalURL(r3);
        goto L12
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void setVid(String r3) {
        this.l = r3;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isEmpty() == true) goto L25;
        g();
        if (this.b != null) goto L10;
        return;
    L10:
        if (this.a == null) goto L26;
        String r4 = this.l;
        if (r4 == null) goto L19;
        if (r4.isEmpty() == true) goto L19;
        this.a.setIntOption(21, 1);
        this.a.setVideoID(this.l);
    L19:
        if (this.b.isAutoplay() == false) goto L24;
        this.a.play();
        return;
    L24:
        return;
    L26:
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.audio.AudioPlayer.a
    public final void setVolume(float r2) {
        TTVideoEngine r0 = this.a;
        if (r0 == null) goto L6;
        r0.setVolume(r2, r2);
        return;
    }

    public b(AudioPlayer r3, String r4) {
        this.e = new PthreadTimer("AudioPlayerTTImpl");
        this.f = new a(this);
        this.h = 500;
        this.i = false;
        this.j = false;
        this.k = false;
        this.b = r3;
        if (r4.equals("light") == false) goto L5;
        this.c = 2;
    L6:
        this.d = new Handler(this.b.getFlutterView().getContext().getMainLooper());
        h();
        return;
    L5:
        this.c = 0;
        goto L6
    }
}
