package com.lynx.clay.embedding.engine.plugins.video;

import android.content.Context;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.ss.ttvideoengine.VideoEngineSimpleCallback;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import com.ss.ttvideoengine.utils.Error;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements com.lynx.clay.embedding.engine.plugins.video.a {
    public final Context a;
    public final com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC0040a b;
    public TTVideoEngine c;
    public String d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public String k;
    public boolean l;
    public double m;
    public boolean n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public final a s;
    public final C0041b t;
    public c u;

    public class a extends VideoEngineSimpleCallback {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void onBufferEnd(int r3) {
            c5a.c.c("VideoEngineTTImpl", "onBufferEnd code = " + r3);
            this.a.b.onPlaying();
        }

        public final void onCompletion(TTVideoEngine r2) {
            c5a.c.c("VideoEngineTTImpl", "onCompletion");
            this.a.b.onEnded();
        }

        public final void onError(Error r4) {
            c5a.c.c("VideoEngineTTImpl", "onError error = " + r4);
            b r0 = this.a;
            r0.b.onError(r4.code, r4.description, r0.d);
        }

        public final void onPrepare(TTVideoEngine r2) {
            c5a.c.c("VideoEngineTTImpl", "onPrepare");
        }

        public final void onPrepared(TTVideoEngine r3) {
            c5a.c.c("VideoEngineTTImpl", "onPrepared");
            this.a.b.onPrepared(r3.getDuration());
            b r0 = this.a;
            if (r0.q == false) goto L16;
            r0.q = false;
            int r1 = r0.o;
            if (r1 <= 0) goto L7;
            r3.seekTo(r1, null);
        L7:
            b r2 = this.a;
            if (r2.f == false) goto L10;
        L15:
            r3.play();
            goto L16
        L10:
            if (r2.r == true) goto L15;
            if (r3.isSystemPlayer() == false) goto L16;
            r3.pause();
        L16:
            this.a.b.onCanPlay();
        }

        public final void onReadyForDisplay(TTVideoEngine r2) {
            c5a.c.c("VideoEngineTTImpl", "onReadyForDisplay");
        }

        public final void onRenderStart(TTVideoEngine r2) {
            c5a.c.c("VideoEngineTTImpl", "onRenderStart");
            this.a.b.onFirstFrame();
        }

        public final void onVideoStatusException(int r3) {
            c5a.c.c("VideoEngineTTImpl", "onVideoStatusException status = " + r3);
        }

        public final void onABRPredictBitrate(int r3, int r4) {
            c5a.c.c("VideoEngineTTImpl", "onABRPredictBitrate mediaType = " + r3 + " , bitrate = " + r4);
        }

        public final void onBufferingUpdate(TTVideoEngine r2, int r3) {
            c5a.c.c("VideoEngineTTImpl", "onBufferingUpdate percent = " + r3);
            this.a.b.onBufferingChange(r3);
        }

        public final void onFrameDraw(int r3, Map r4) {
            c5a.c.c("VideoEngineTTImpl", "onFrameDraw frameCount = " + r3 + " , map = " + r4);
        }

        public final void onLoadStateChanged(TTVideoEngine r2, int r3) {
            c5a.c.c("VideoEngineTTImpl", "onLoadStateChanged loadState = " + r3);
        }

        public final void onPlaybackStateChanged(TTVideoEngine r2, int r3) {
            c5a.c.c("VideoEngineTTImpl", "onPlaybackStateChanged playbackState = " + r3);
            if (r3 != 1) goto L5;
            this.a.b.onPlay();
            return;
        L5:
            if (r3 != 2) goto L11;
            this.a.b.onPause();
            return;
        }

        public final void onSARChanged(int r3, int r4) {
            c5a.c.c("VideoEngineTTImpl", "onSARChanged num = " + r3 + " , den = " + r4);
        }

        public final void onStreamChanged(TTVideoEngine r2, int r3) {
            c5a.c.c("VideoEngineTTImpl", "onStreamChanged type = " + r3);
        }

        public final void onVideoStreamBitrateChanged(Resolution r3, int r4) {
            c5a.c.c("VideoEngineTTImpl", "onVideoStreamBitrateChanged resolution = " + r3 + " , bitrate = " + r4);
        }

        public final void onVideoURLRouteFailed(Error r3, String r4) {
            c5a.c.c("VideoEngineTTImpl", "onVideoURLRouteFailed error = " + r3 + " , url = " + r4);
        }

        public final void onBufferStart(int r3, int r4, int r5) {
            c5a.c.c("VideoEngineTTImpl", "onBufferStart reason = " + r3 + " , afterFirstFrame = " + r4 + " , action = " + r5);
            this.a.b.onWaiting();
        }

        public final void onVideoSizeChanged(TTVideoEngine r2, int r3, int r4) {
            c5a.c.c("VideoEngineTTImpl", "onVideoSizeChanged width = " + r3 + " , height = " + r4);
            this.a.b.onVideoSizeChanged(r3, r4);
        }
    }

    /* JADX INFO: renamed from: com.lynx.clay.embedding.engine.plugins.video.b$b, reason: collision with other inner class name */
    public class C0041b implements VideoEngineInfoListener {
        public final /* synthetic */ b a;

        public C0041b(b r1) {
            this.a = r1;
        }

        public final void onVideoEngineInfos(VideoEngineInfos r5) {
            this.a.b.onVideoInfos(r5.getUsingMDLPlayTaskKey(), r5.getUsingMDLHitCacheSize());
        }
    }

    public interface c {
        void a(TTVideoEngine r1);

        void b(TTVideoEngine r1);

        void c();

        void d();

        void dispose();
    }

    public class d implements c {
        public final Surface a;
        public boolean b;
        public final /* synthetic */ b c;

        @Override // com.lynx.clay.embedding.engine.plugins.video.b.c
        public final void c() {
            TTVideoEngine r0 = this.c.c;
            if (r0 != null) goto L5;
        L9:
            this.b = false;
            return;
        L5:
            if (this.b == false) goto L9;
            if (r0.getPlaybackState() != 2) goto L9;
            this.c.c.play();
            goto L9
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.b.c
        public final void d() {
            TTVideoEngine r0 = this.c.c;
            if (r0 != null) goto L5;
        L7:
            this.b = false;
            return;
        L5:
            if (r0.getPlaybackState() != 1) goto L7;
            this.c.c.pause();
            this.b = true;
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.b.c
        public final void dispose() {
            a(this.c.c);
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.b.c
        public final void a(TTVideoEngine r3) {
            if (r3 == null) goto L5;
            r3.setIntOption(654, 0);
            r3.setSurfaceSync(null);
            return;
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.b.c
        public final void b(TTVideoEngine r3) {
            if (r3 == null) goto L5;
            r3.setIntOption(654, 1);
            r3.setSurfaceSync(this.a);
            return;
        }

        public d(b r1, Surface r2) {
            this.c = r1;
            this.b = false;
            this.a = r2;
        }
    }

    public class e implements c {
        public boolean a;
        public int b;
        public boolean c;
        public final SurfaceHolder d;
        public final a e;
        public final /* synthetic */ b f;

        public class a implements SurfaceHolder.Callback {
            public final /* synthetic */ e a;

            public a(e r1) {
                this.a = r1;
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceCreated(SurfaceHolder r3) {
                c5a.c.c("VideoEngineTTImpl", String.format("surfaceCreated createEngineForNewSurface=%b lastPlaying=%b lastPlaybackTime=%d", new Object[]{Boolean.valueOf(this.a.c), Boolean.valueOf(this.a.a), Integer.valueOf(this.a.b)}));
                e r4 = this.a;
                if (r4.c == false) goto L6;
                r4.f.k();
                return;
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceDestroyed(SurfaceHolder r5) {
                boolean r1 = false;
                c5a.c.c("VideoEngineTTImpl", String.format("surfaceDestroyed createEngineForNewSurface=%b lastPlaying=%b lastPlaybackTime=%d", new Object[]{Boolean.valueOf(this.a.c), Boolean.valueOf(this.a.a), Integer.valueOf(this.a.b)}));
                TTVideoEngine r6 = this.a.f.c;
                if (r6 != null) goto L6;
                return;
            L6:
                if (r6.getPlaybackState() != 1) goto L8;
            L11:
                e r7 = this.a;
                r7.b = r7.f.c.getIntOption(52);
            L12:
                e r8 = this.a;
                if (r8.f.c.getPlaybackState() != 1) goto L15;
                r1 = true;
            L15:
                r8.a = r1;
                this.a.f.c.release();
                e r9 = this.a;
                r9.f.c = null;
                r9.c = true;
                return;
            L8:
                if (this.a.f.c.getPlaybackState() == 2) goto L11;
                this.a.b = -1;
                goto L12
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceChanged(SurfaceHolder r2, int r3, int r4, int r5) {
                c5a.c.c("VideoEngineTTImpl", "surfaceChanged width=" + r4 + ", height=" + r5);
                TTVideoEngine r6 = this.a.f.c;
                if (r6 == null) goto L6;
                r6.setSurfaceHolderSync(r2);
                return;
            }
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.b.c
        public final void c() {
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.b.c
        public final void d() {
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.b.c
        public final void dispose() {
            a(this.f.c);
            this.d.removeCallback(this.e);
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.b.c
        public final void a(TTVideoEngine r2) {
            if (r2 == null) goto L5;
            r2.setSurfaceHolderSync(null);
            return;
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.b.c
        public final void b(TTVideoEngine r4) {
            if (r4 == null) goto L12;
            r4.setSurfaceHolderSync(this.d);
            TTVideoEngine r5 = this.f.c;
            if (r5 != null) goto L7;
            return;
        L7:
            if (this.c == false) goto L13;
            this.c = false;
            int r0 = this.b;
            if (r0 == (-1)) goto L14;
            r5.seekTo(r0, new com.lynx.clay.embedding.engine.plugins.video.c(this));
            this.b = -1;
            return;
        L14:
            return;
        L13:
            return;
        }

        public e(b r2, SurfaceHolder r3) {
            this.f = r2;
            this.a = false;
            this.b = -1;
            this.c = false;
            a r4 = new a(this);
            this.e = r4;
            this.d = r3;
            r3.addCallback(r4);
        }
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void a() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void e() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void g() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void c() {
        c r0 = this.u;
        if (r0 == null) goto L6;
        r0.dispose();
        this.u = null;
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void d() {
        if (this.e == false) goto L5;
        k();
        this.e = false;
        return;
    L5:
        l();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void dispose() {
        TTVideoEngine r0 = this.c;
        if (r0 == null) goto L8;
        r0.setVideoEngineSimpleCallback(null);
        if (this.c.getPlaybackState() != 1) goto L7;
        this.c.stop();
    L7:
        this.c.releaseAsync();
        this.c = null;
    L8:
        c r1 = this.u;
        if (r1 == null) goto L12;
        r1.dispose();
        this.u = null;
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void enterBackground() {
        c r0 = this.u;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void enterForeground() {
        c r0 = this.u;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final int getDuration() {
        TTVideoEngine r0 = this.c;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getDuration();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final int getPosition() {
        TTVideoEngine r0 = this.c;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getIntOption(52);
    }

    public final void k() {
        boolean r2 = false;
        TTVideoEngine r5 = this.c;     // Catch: Throwable -> L13
        if (r5 != null) goto L6;
    L11:
        TTVideoEngine r6 = new TTVideoEngine(this.a.getApplicationContext(), 0);     // Catch: Throwable -> L13
        this.c = r6;     // Catch: Throwable -> L13
        r6.isSystemPlayer();     // Catch: Throwable -> L13
    L16:
        if (this.c == null) goto L18;
    L17:
        boolean r4 = true;
    L19:
        if (r4 == false) goto L52;
        this.c.setIntOption(160, this.l ? 1 : 0);
        this.c.setIntOption(21, 1);
        this.c.setIntOption(7, 1);
        this.c.setIntOption(415, 1);
        this.c.setIntOption(42068, 1);
        TTVideoEngine.setIntValue(1163, 1);
        this.c.setVideoEngineSimpleCallback(this.s);
        this.c.setVideoEngineInfoListener(this.t);
        l();
        if (this.c == null) goto L44;
        String r7 = this.d;
        if (r7 != null) goto L26;
    L43:
        this.c.setDirectURL(NameKeys.UnloadStrategy_No_Strategy);
        goto L44
    L26:
        if (r7.isEmpty() == true) goto L43;
        if (this.d.startsWith("{") == true) goto L50;
        String r0 = this.d;
        if (r0.startsWith("http://") == false) goto L37;
    L38:
        r2 = true;
    L39:
        if (r2 == false) goto L41;
        this.c.setDirectUrlUseDataLoader(this.d, this.k);
    L42:
        this.c.prepare();
        goto L44
    L41:
        this.c.setLocalURL(this.d);
        goto L42
    L37:
        if (r0.startsWith("https://") == false) goto L39;
    L50:
        VideoRef r3 = new VideoRef();     // Catch: Throwable -> L32
        r3.extractFields(new JSONObject(this.d));     // Catch: Throwable -> L32
        VideoModel r8 = new VideoModel();     // Catch: Throwable -> L32
        r8.setVideoRef(r3);     // Catch: Throwable -> L32
        this.c.setVideoModel(r8);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        c5a.c.d(6, "VideoEngineTTImpl", "Load VideoModel failed");
        th.printStackTrace();
        this.c.setDirectURL(NameKeys.UnloadStrategy_No_Strategy);
    L44:
        c r1 = this.u;
        if (r1 == null) goto L53;
        r1.b(this.c);
        return;
    L53:
        return;
    L52:
        return;
    L18:
        r4 = false;
        goto L19
    L6:
        if (this.p == true) goto L17;
        r5.setListener(null);     // Catch: Throwable -> L13
        c r9 = this.u;     // Catch: Throwable -> L13
        if (r9 == null) goto L10;
        r9.a(this.c);     // Catch: Throwable -> L13
    L10:
        this.c.release();     // Catch: Throwable -> L13
        this.c = null;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        c5a.c.d(6, "VideoEngineTTImpl", "VideoEngine create " + th.toString());
        this.c = null;
        goto L16
    }

    public final void l() {
        TTVideoEngine r0 = this.c;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.h == false) goto L9;
        r0.setIsMute(this.g);
        this.h = false;
    L9:
        if (this.j == false) goto L12;
        this.c.setLooping(this.i);
        this.j = false;
    L12:
        if (this.n == false) goto L15;
        float r1 = ((float) this.m) * this.c.getMaxVolume();
        this.c.setVolume(r1, r1);
        this.n = false;
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void pause() {
        c5a.c.c("VideoEngineTTImpl", "pause");
        this.r = false;
        TTVideoEngine r0 = this.c;
        if (r0 == null) goto L6;
        r0.pause();
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void play() {
        c5a.c.c("VideoEngineTTImpl", "play");
        this.r = true;
        TTVideoEngine r0 = this.c;
        if (r0 == null) goto L6;
        r0.play();
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void stop() {
        c5a.c.c("VideoEngineTTImpl", "stop");
        this.r = false;
        TTVideoEngine r0 = this.c;
        if (r0 == null) goto L6;
        r0.stop();
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void b(boolean r3) {
        c5a.c.c("VideoEngineTTImpl", "setAutoplay " + r3);
        this.f = r3;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final View createView(Context r3) {
        c r0 = this.u;
        if (r0 == null) goto L5;
        r0.dispose();
        this.u = null;
    L5:
        SurfaceView r1 = new SurfaceView(r3);
        r1.setZOrderOnTop(false);
        e r4 = new e(this, r1.getHolder());
        this.u = r4;
        TTVideoEngine r2 = this.c;
        if (r2 == null) goto L8;
        r4.b(r2);
    L8:
        return r1;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void f(boolean r3) {
        c5a.c.c("VideoEngineTTImpl", "setCache " + r3);
        this.l = r3;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void h(int r3) {
        c5a.c.c("VideoEngineTTImpl", "setInitTime " + r3);
        this.o = r3;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void i(String r3) {
        c5a.c.c("VideoEngineTTImpl", "setPreloadKey " + r3);
        this.k = r3;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void j(boolean r1) {
        this.p = r1;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void seekTo(int r3) {
        c5a.c.c("VideoEngineTTImpl", "seekTo " + r3);
        TTVideoEngine r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getPlaybackState() != 0) goto L7;
        this.c.play();
    L7:
        this.c.seekTo(r3, null);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void setLoop(boolean r3) {
        c5a.c.c("VideoEngineTTImpl", "setLoop " + r3);
        this.i = r3;
        this.j = true;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void setMuted(boolean r3) {
        c5a.c.c("VideoEngineTTImpl", "setMuted " + r3);
        this.g = r3;
        this.h = true;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void setSpeed(float r3) {
        c5a.c.c("VideoEngineTTImpl", "setSpeed " + r3);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void setSrc(String r3) {
        c5a.c.c("VideoEngineTTImpl", "setSrc " + r3);
        if (TextUtils.equals(this.d, r3) == false) goto L5;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == false) goto L14;
        this.q = true;
        this.e = true;
        return;
    L14:
        return;
    L5:
        if (TextUtils.isEmpty(this.d) == true) goto L7;
    L9:
        this.d = r3;
        r4 = true;
        goto L11
    L7:
        if (TextUtils.isEmpty(r3) == false) goto L9;
        goto L9
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void setSurface(Surface r2) {
        c r0 = this.u;
        if (r0 == null) goto L5;
        r0.dispose();
        this.u = null;
    L5:
        if (r2 == null) goto L10;
        d r1 = new d(this, r2);
        this.u = r1;
        TTVideoEngine r3 = this.c;
        if (r3 == null) goto L11;
        r1.b(r3);
        return;
    L11:
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void setVolume(double r3) {
        c5a.c.c("VideoEngineTTImpl", "setVolume " + r3);
        this.m = r3;
        this.n = true;
    }

    public b(Context r5, com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC0040a r6) {
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.l = true;
        this.m = 1.0d;
        this.n = false;
        this.o = -1;
        this.p = true;
        this.q = true;
        this.r = false;
        this.s = new a(this);
        this.t = new C0041b(this);
        this.a = r5;
        this.b = r6;
    }
}
