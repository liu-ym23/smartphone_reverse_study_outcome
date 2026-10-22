package com.lynx.clay.embedding.engine.plugins.video;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.obric.aivoice.core.data.NameKeys;
import fna.g;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class VideoEngineMPImpl implements com.lynx.clay.embedding.engine.plugins.video.a {
    public final com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC0040a a;
    public c b;
    public String c;
    public boolean d;
    public boolean e;
    public boolean f;
    public double g;
    public int h;
    public final b i;

    public static final enum MediaPlayerState extends Enum<MediaPlayerState> {
        public static final MediaPlayerState ERROR = null;
        public static final MediaPlayerState IDLE = null;
        public static final MediaPlayerState INITIALIZED = null;
        public static final MediaPlayerState PAUSED = null;
        public static final MediaPlayerState PLAYBACK_COMPLETED = null;
        public static final MediaPlayerState PREPARED = null;
        public static final MediaPlayerState PREPARING = null;
        public static final MediaPlayerState STARTED = null;
        public static final MediaPlayerState STOPPED = null;
        public static final /* synthetic */ MediaPlayerState[] a = null;

        static {
            MediaPlayerState r0 = new MediaPlayerState("ERROR", 0);
            ERROR = r0;
            MediaPlayerState r1 = new MediaPlayerState("IDLE", 1);
            IDLE = r1;
            MediaPlayerState r3 = new MediaPlayerState("INITIALIZED", 2);
            INITIALIZED = r3;
            MediaPlayerState r5 = new MediaPlayerState("PREPARING", 3);
            PREPARING = r5;
            MediaPlayerState r7 = new MediaPlayerState("PREPARED", 4);
            PREPARED = r7;
            MediaPlayerState r9 = new MediaPlayerState("STARTED", 5);
            STARTED = r9;
            MediaPlayerState r11 = new MediaPlayerState("PAUSED", 6);
            PAUSED = r11;
            MediaPlayerState r13 = new MediaPlayerState("STOPPED", 7);
            STOPPED = r13;
            MediaPlayerState r15 = new MediaPlayerState("PLAYBACK_COMPLETED", 8);
            PLAYBACK_COMPLETED = r15;
            a = new MediaPlayerState[]{r0, r1, r3, r5, r7, r9, r11, r13, r15};
        }

        public static MediaPlayerState[] values() {
            return (MediaPlayerState[]) a.clone();
        }

        public static MediaPlayerState valueOf(String r1) {
            return (MediaPlayerState) r27.a.a(MediaPlayerState.class, r1);
        }

        public MediaPlayerState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum PendingAction extends Enum<PendingAction> {
        public static final PendingAction NONE = null;
        public static final PendingAction PAUSE = null;
        public static final PendingAction PLAY = null;
        public static final PendingAction STOP = null;
        public static final /* synthetic */ PendingAction[] a = null;

        static {
            PendingAction r0 = new PendingAction("NONE", 0);
            NONE = r0;
            PendingAction r1 = new PendingAction("PLAY", 1);
            PLAY = r1;
            PendingAction r3 = new PendingAction("PAUSE", 2);
            PAUSE = r3;
            PendingAction r5 = new PendingAction("STOP", 3);
            STOP = r5;
            a = new PendingAction[]{r0, r1, r3, r5};
        }

        public static PendingAction[] values() {
            return (PendingAction[]) a.clone();
        }

        public static PendingAction valueOf(String r1) {
            return (PendingAction) r27.a.a(PendingAction.class, r1);
        }

        public PendingAction(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[MediaPlayerState.values().length];
            b = r0;
            r0[MediaPlayerState.ERROR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L32:
            b[MediaPlayerState.PREPARING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L38:
            b[MediaPlayerState.PREPARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L54:
            b[MediaPlayerState.STARTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L34:
            b[MediaPlayerState.PAUSED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L40:
            b[MediaPlayerState.PLAYBACK_COMPLETED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L44:
            b[MediaPlayerState.STOPPED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L48:
            b[MediaPlayerState.IDLE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L27
        L14:
            int[] r4 = new int[PendingAction.values().length];
            a = r4;
            r4[PendingAction.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L42:
            a[PendingAction.PLAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L46:
            a[PendingAction.PAUSE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L36:
            a[PendingAction.STOP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
            return;
        }
    }

    public class b {
        public MediaPlayer a;
        public final a b;
        public MediaPlayerState c;
        public PendingAction d;
        public int e;
        public boolean f;
        public int g;
        public final /* synthetic */ VideoEngineMPImpl h;

        public class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnSeekCompleteListener {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer r3) {
                c5a.c.d(6, "VideoEngineMPImpl", "onCompletion");
                b r4 = this.a;
                r4.c = MediaPlayerState.PLAYBACK_COMPLETED;
                r4.h.a.onEnded();
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer r5) {
                c5a.c.d(6, "VideoEngineMPImpl", "onPrepared");
                b r0 = this.a;
                r0.c = MediaPlayerState.PREPARED;
                if (r0.e < 0) goto L5;
                c5a.c.d(6, "VideoEngineMPImpl", "do pending: seek " + this.a.e);
                r5.seekTo(this.a.e);
                this.a.e = -1;
            L5:
                int r1 = a.a[this.a.d.ordinal()];
                if (r1 != 2) goto L8;
                c5a.c.d(6, "VideoEngineMPImpl", "do pending: play");
                if (g.d() == true) goto L29;
                r5.start();
            L30:
                this.a.h.a.onPlay();
                this.a.c = MediaPlayerState.STARTED;
            L31:
                b r2 = this.a;
                r2.d = PendingAction.NONE;
                r2.h.a.onPrepared(r5.getDuration());
                this.a.h.a.onCanPlay();
                return;
            L29:
                r5.start();
                gna.a.c(r5.hashCode());
                goto L30
            L8:
                if (r1 != 3) goto L10;
                c5a.c.d(6, "VideoEngineMPImpl", "do pending: pause");
                if (g.d() == true) goto L20;
                r5.start();
            L22:
                if (g.d() == true) goto L24;
                r5.pause();
            L25:
                this.a.h.a.onPause();
                this.a.c = MediaPlayerState.PAUSED;
                goto L31
            L24:
                r5.pause();
                gna.a.a(r5.hashCode());
                goto L25
            L20:
                r5.start();
                gna.a.c(r5.hashCode());
                goto L22
            L10:
                if (r1 != 4) goto L31;
                c5a.c.d(6, "VideoEngineMPImpl", "do pending: stop");
                if (g.d() == true) goto L15;
                r5.stop();
            L16:
                this.a.c = MediaPlayerState.STOPPED;
                goto L31
            L15:
                r5.stop();
                gna.a.a(r5.hashCode());
                goto L16
            }

            @Override // android.media.MediaPlayer.OnSeekCompleteListener
            public final void onSeekComplete(MediaPlayer r3) {
                c5a.c.d(6, "VideoEngineMPImpl", "onSeekComplete");
            }

            @Override // android.media.MediaPlayer.OnBufferingUpdateListener
            public final void onBufferingUpdate(MediaPlayer r3, int r4) {
                c5a.c.d(6, "VideoEngineMPImpl", "onBufferingUpdate percent=" + r4);
                this.a.h.a.onBufferingChange(r4);
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer r3, int r4, int r5) {
                c5a.c.d(6, "VideoEngineMPImpl", "onError what=" + r4 + ", extra=" + r5);
                b r6 = this.a;
                r6.c = MediaPlayerState.ERROR;
                VideoEngineMPImpl r7 = r6.h;
                com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC0040a r8 = r7.a;
                r7.getClass();
                if (r4 != (-1010)) goto L5;
                String r9 = "MediaPlayer is unsupported.";
            L23:
                r8.onError(r4, r9, this.a.h.c);
                return true;
            L5:
                if (r4 != (-1007)) goto L7;
                r9 = "MediaPlayer malformed error.";
                goto L23
            L7:
                if (r4 != (-1004)) goto L9;
                r9 = "MediaPlayer io error";
                goto L23
            L9:
                if (r4 == (-110)) goto L19;
                if (r4 != 1) goto L12;
                r9 = "MediaPlayer has a unspecified error.";
                goto L23
            L12:
                if (r4 != 100) goto L14;
                r9 = "MediaPlayer server died.";
                goto L23
            L14:
                if (r4 == 200) goto L16;
                r9 = NameKeys.UnloadStrategy_No_Strategy;
                goto L23
            L16:
                r9 = "MediaPlayer is not valid for progressive playback.";
                goto L23
            L19:
                r9 = "Media Player is time out when playing media.";
                goto L23
            }

            @Override // android.media.MediaPlayer.OnInfoListener
            public final boolean onInfo(MediaPlayer r2, int r3, int r4) {
                if (r3 != 1) goto L5;
                c5a.c.d(6, "VideoEngineMPImpl", "onInfo UNKNOWN");
                return false;
            L5:
                if (r3 == 3) goto L15;
                switch(r3) {
                    case 700: goto L14;
                    case 701: goto L13;
                    case 702: goto L12;
                    default: goto L7;
                };
            L7:
                switch(r3) {
                    case 800: goto L11;
                    case 801: goto L10;
                    case 802: goto L9;
                    default: goto L26;
                };
            L9:
                c5a.c.d(6, "VideoEngineMPImpl", "onInfo Metadata update");
                return false;
            L10:
                c5a.c.d(6, "VideoEngineMPImpl", "onInfo Not seekable");
                return false;
            L11:
                c5a.c.d(6, "VideoEngineMPImpl", "onInfo Bad interleaving");
                return false;
            L26:
                return false;
            L12:
                c5a.c.d(6, "VideoEngineMPImpl", "onInfo Buffering end");
                this.a.h.a.onPlaying();
                return false;
            L13:
                c5a.c.d(6, "VideoEngineMPImpl", "onInfo Buffering start");
                this.a.h.a.onWaiting();
                return false;
            L14:
                c5a.c.d(6, "VideoEngineMPImpl", "onInfo Video track lagging");
                return false;
            L15:
                c5a.c.d(6, "VideoEngineMPImpl", "onInfo Rendering start");
                return false;
            }

            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public final void onVideoSizeChanged(MediaPlayer r3, int r4, int r5) {
                c5a.c.d(6, "VideoEngineMPImpl", "onVideoSizeChanged width=" + r4 + ", height=" + r5);
                this.a.h.a.onVideoSizeChanged(r4, r5);
            }
        }

        public final void c() {
            if (this.a != null) goto L8;
            MediaPlayer r0 = new MediaPlayer();
            this.a = r0;
            r0.setOnBufferingUpdateListener(this.b);
            this.a.setOnInfoListener(this.b);
            this.a.setOnPreparedListener(this.b);
            this.a.setOnVideoSizeChangedListener(this.b);
            this.a.setOnErrorListener(this.b);
            this.a.setOnCompletionListener(this.b);
            this.a.setOnSeekCompleteListener(this.b);
            c r1 = this.h.b;
            if (r1 == null) goto L7;
            r1.a(this.a);
        L7:
            this.c = MediaPlayerState.IDLE;
        L8:
            MediaPlayerState r2 = this.c;
            MediaPlayerState r3 = MediaPlayerState.IDLE;
            if (r2 == r3) goto L11;
            this.a.reset();
            this.c = r3;
        L11:
            d();
            this.a.setDataSource(this.h.c);     // Catch: IOException -> L25
            this.c = MediaPlayerState.INITIALIZED;     // Catch: IOException -> L25
            this.a.prepareAsync();
            VideoEngineMPImpl r4 = this.h;
            if (r4.d == true) goto L16;
        L18:
            int r5 = r4.h;
            if (r5 > 0) goto L21;
        L23:
            this.c = MediaPlayerState.PREPARING;
            return;
        L21:
            if (this.e != (-1)) goto L23;
            this.e = r5;
            goto L23
        L16:
            if (this.d != PendingAction.NONE) goto L18;
            this.d = PendingAction.PLAY;
        L25:
            e = move-exception;
            e.printStackTrace();
            this.c = MediaPlayerState.ERROR;
            VideoEngineMPImpl r6 = this.h;
            r6.a.onError(-1, NameKeys.UnloadStrategy_No_Strategy, r6.c);
        }

        public final void d() {
            MediaPlayer r0 = this.a;
            if (r0 == null) goto L10;
            VideoEngineMPImpl r1 = this.h;
            if (r1.e == false) goto L7;
            float r2 = 0.0f;
        L8:
            r0.setVolume(r2, r2);
            this.a.setLooping(this.h.f);
            return;
        L7:
            r2 = (float) r1.g;
            goto L8
        }

        public b(VideoEngineMPImpl r2) {
            this.h = r2;
            this.b = new a(this);
            this.c = MediaPlayerState.IDLE;
            this.d = PendingAction.NONE;
            this.e = -1;
            this.f = false;
            this.g = -1;
        }

        public static void a(MediaPlayer r1) {
            if (g.d() == true) goto L6;
            r1.pause();
            return;
        L6:
            r1.pause();
            gna.a.a(r1.hashCode());
        }

        public static void b(MediaPlayer r1) {
            if (g.d() == true) goto L6;
            r1.start();
            return;
        L6:
            r1.start();
            gna.a.c(r1.hashCode());
        }
    }

    public interface c {
        void a(MediaPlayer r1);

        void dispose();
    }

    public class d implements c {
        public final Surface a;
        public MediaPlayer b;

        @Override // com.lynx.clay.embedding.engine.plugins.video.VideoEngineMPImpl.c
        public final void dispose() {
            MediaPlayer r0 = this.b;
            if (r0 == null) goto L6;
            r0.setSurface(null);
            this.b = null;
            return;
        }

        public d(Surface r1) {
            this.a = r1;
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.VideoEngineMPImpl.c
        public final void a(MediaPlayer r2) {
            this.b = r2;
            r2.setSurface(this.a);
        }
    }

    public class e implements c {
        public final SurfaceHolder a;
        public MediaPlayer b;
        public boolean c;
        public final a d;

        public class a implements SurfaceHolder.Callback {
            public final /* synthetic */ e a;

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceChanged(SurfaceHolder r1, int r2, int r3, int r4) {
            }

            public a(e r1) {
                this.a = r1;
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceCreated(SurfaceHolder r3) {
                e r0 = this.a;
                r0.c = true;
                MediaPlayer r1 = r0.b;
                if (r1 == null) goto L6;
                r1.setDisplay(r3);
                return;
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceDestroyed(SurfaceHolder r2) {
                e r3 = this.a;
                r3.c = false;
                MediaPlayer r4 = r3.b;
                if (r4 == null) goto L6;
                r4.setDisplay(null);
                return;
            }
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.VideoEngineMPImpl.c
        public final void dispose() {
            this.a.removeCallback(this.d);
            MediaPlayer r0 = this.b;
            if (r0 == null) goto L6;
            r0.setDisplay(null);
            this.b = null;
            return;
        }

        public e(SurfaceHolder r2) {
            this.c = false;
            a r0 = new a(this);
            this.d = r0;
            this.a = r2;
            r2.addCallback(r0);
        }

        @Override // com.lynx.clay.embedding.engine.plugins.video.VideoEngineMPImpl.c
        public final void a(MediaPlayer r2) {
            this.b = r2;
            if (this.c == false) goto L6;
            r2.setDisplay(this.a);
            return;
        }
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void a() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final /* synthetic */ void d() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void e() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final /* synthetic */ void f(boolean r1) {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void g() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final /* synthetic */ void i(String r1) {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final /* synthetic */ void j(boolean r1) {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final /* synthetic */ void setSpeed(float r1) {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void c() {
        c r0 = this.b;
        if (r0 == null) goto L6;
        r0.dispose();
        this.b = null;
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void dispose() {
        b r0 = this.i;
        r0.getClass();
        c5a.c.d(6, "VideoEngineMPImpl", "release");
        MediaPlayer r1 = r0.a;
        if (r1 == null) goto L6;
        r1.reset();
        r0.a.release();
        r0.a = null;
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void enterBackground() {
        b r0 = this.i;
        MediaPlayer r1 = r0.a;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isPlaying() == false) goto L9;
        r0.g = r0.a.getCurrentPosition();
        b.a(r0.a);
        r0.c = MediaPlayerState.PAUSED;
        r0.h.a.onPause();
        r0.f = true;
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void enterForeground() {
        b r0 = this.i;
        MediaPlayer r1 = r0.a;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r0.f == true) goto L7;
    L12:
        r0.f = false;
        r0.g = -1;
        return;
    L7:
        if (r0.c != MediaPlayerState.PAUSED) goto L12;
        int r2 = r0.g;
        if (r2 < 0) goto L11;
        r1.seekTo(r2);
    L11:
        b.b(r0.a);
        r0.c = MediaPlayerState.STARTED;
        r0.h.a.onPlay();
        goto L12
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final int getDuration() {
        MediaPlayer r0 = this.i.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getDuration();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final int getPosition() {
        MediaPlayer r0 = this.i.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getCurrentPosition();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void pause() {
        b r0 = this.i;
        r0.getClass();
        c5a.c.d(6, "VideoEngineMPImpl", "pause");
        if (r0.a == null) goto L27;
        int r1 = a.b[r0.c.ordinal()];
        if (r1 != 1) goto L8;
        c5a.c.d(6, "VideoEngineMPImpl", "---- pause: setupEngine");
        r0.c();
        r0.d = PendingAction.PAUSE;
        return;
    L8:
        if (r1 != 2) goto L10;
        c5a.c.d(6, "VideoEngineMPImpl", "---- pause: pending");
        r0.d = PendingAction.PAUSE;
        return;
    L10:
        if (r1 != 3) goto L12;
    L19:
        c5a.c.d(6, "VideoEngineMPImpl", "---- pause: start + pause");
        b.b(r0.a);
        b.a(r0.a);
        r0.h.a.onPause();
        r0.c = MediaPlayerState.PAUSED;
        return;
    L12:
        if (r1 == 4) goto L18;
        if (r1 == 6) goto L19;
        if (r1 != 7) goto L28;
        c5a.c.d(6, "VideoEngineMPImpl", "---- pause: prepare");
        r0.a.prepareAsync();
        r0.c = MediaPlayerState.PREPARING;
        r0.d = PendingAction.PAUSE;
        return;
    L28:
        return;
    L18:
        c5a.c.d(6, "VideoEngineMPImpl", "---- pause: pause");
        b.a(r0.a);
        r0.h.a.onPause();
        r0.c = MediaPlayerState.PAUSED;
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void play() {
        b r0 = this.i;
        r0.getClass();
        c5a.c.d(6, "VideoEngineMPImpl", "start");
        if (r0.a != null) goto L6;
        return;
    L6:
        switch(a.b[r0.c.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L17;
        };
    L8:
        c5a.c.d(6, "VideoEngineMPImpl", "---- start: prepare");
        r0.a.prepareAsync();
        r0.c = MediaPlayerState.PREPARING;
        r0.d = PendingAction.PLAY;
        return;
    L9:
        c5a.c.d(6, "VideoEngineMPImpl", "---- start: start");
        b.b(r0.a);
        r0.c = MediaPlayerState.STARTED;
        r0.h.a.onPlay();
        return;
    L10:
        c5a.c.d(6, "VideoEngineMPImpl", "---- start: pending");
        r0.d = PendingAction.PLAY;
        return;
    L11:
        c5a.c.d(6, "VideoEngineMPImpl", "---- start: setupEngine");
        r0.c();
        r0.d = PendingAction.PLAY;
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void stop() {
        b r0 = this.i;
        r0.getClass();
        c5a.c.d(6, "VideoEngineMPImpl", "stop");
        if (r0.a == null) goto L23;
        int r3 = a.b[r0.c.ordinal()];
        if (r3 != 2) goto L8;
        c5a.c.d(6, "VideoEngineMPImpl", "---- stop: pending");
        r0.d = PendingAction.STOP;
        return;
    L8:
        if (r3 != 3) goto L10;
    L15:
        c5a.c.d(6, "VideoEngineMPImpl", "---- stop: stop");
        MediaPlayer r1 = r0.a;
        if (g.d() == true) goto L18;
        r1.stop();
    L19:
        r0.c = MediaPlayerState.STOPPED;
        return;
    L18:
        r1.stop();
        gna.a.a(r1.hashCode());
        goto L19
    L10:
        if (r3 == 4) goto L15;
        if (r3 == 5) goto L15;
        if (r3 == 6) goto L15;
        return;
    }

    public VideoEngineMPImpl(com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC0040a r3) {
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = 1.0d;
        this.h = -1;
        this.i = new b(this);
        this.a = r3;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void b(boolean r1) {
        this.d = r1;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final View createView(Context r3) {
        c r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
        this.b = null;
    L5:
        SurfaceView r1 = new SurfaceView(r3);
        r1.setZOrderOnTop(false);
        e r4 = new e(r1.getHolder());
        this.b = r4;
        MediaPlayer r2 = this.i.a;
        if (r2 == null) goto L8;
        r4.a(r2);
    L8:
        return r1;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void h(int r1) {
        this.h = r1;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void seekTo(int r6) {
        b r0 = this.i;
        r0.getClass();
        c5a.c.d(6, "VideoEngineMPImpl", "seekTo " + r6);
        if (r0.a != null) goto L6;
        return;
    L6:
        switch(a.b[r0.c.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L17;
        };
    L8:
        c5a.c.d(6, "VideoEngineMPImpl", "---- seekTo: prepare");
        r0.a.prepareAsync();
        r0.c = MediaPlayerState.PREPARING;
        r0.e = r6;
        return;
    L9:
        c5a.c.d(6, "VideoEngineMPImpl", "---- seekTo: seekTo");
        r0.a.seekTo(r6);
        return;
    L10:
        c5a.c.d(6, "VideoEngineMPImpl", "---- seekTo: pending");
        r0.e = r6;
        return;
    L11:
        c5a.c.d(6, "VideoEngineMPImpl", "---- seekTo: setupEngine");
        r0.c();
        r0.e = r6;
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void setLoop(boolean r1) {
        this.f = r1;
        this.i.d();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void setMuted(boolean r1) {
        this.e = r1;
        this.i.d();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void setSrc(String r1) {
        this.c = r1;
        this.i.c();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void setSurface(Surface r2) {
        c r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
        this.b = null;
    L5:
        if (r2 == null) goto L10;
        d r1 = new d(r2);
        this.b = r1;
        MediaPlayer r3 = this.i.a;
        if (r3 == null) goto L11;
        r1.a(r3);
        return;
    L11:
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a
    public final void setVolume(double r1) {
        this.g = r1;
        this.i.d();
    }
}
