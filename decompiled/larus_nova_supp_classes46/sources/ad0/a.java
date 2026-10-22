package ad0;

import android.content.Context;
import android.view.Surface;
import com.ss.android.ugc.aweme.live.alphaplayer.model.VideoInfo;
import com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer;
import com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineListener;
import com.ss.ttvideoengine.utils.Error;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends AbsPlayer<a> {
    public TTVideoEngine g;
    public final C0000a h;

    /* JADX INFO: renamed from: ad0.a$a, reason: collision with other inner class name */
    public class C0000a implements VideoEngineListener {
        public final /* synthetic */ a a;

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

        public C0000a(a r1) {
            this.a = r1;
        }

        public final void onCompletion(TTVideoEngine r2) {
            a r3 = this.a;
            IMediaPlayer.OnCompletionListener r0 = ((AbsPlayer) r3).c;
            if (r0 == null) goto L6;
            r0.a(((AbsPlayer) r3).a);
            return;
        }

        public final void onError(Error r5) {
            a r0 = this.a;
            IMediaPlayer.OnErrorListener r1 = ((AbsPlayer) r0).e;
            if (r1 == null) goto L6;
            r1.a(((AbsPlayer) r0).a, r5.code, r5.internalCode, r5.description);
            return;
        }

        public final void onPrepared(TTVideoEngine r2) {
            a r3 = this.a;
            IMediaPlayer.OnPreparedListener r0 = ((AbsPlayer) r3).d;
            if (r0 == null) goto L6;
            r0.a(((AbsPlayer) r3).a);
            return;
        }

        public final void onRenderStart(TTVideoEngine r2) {
            a r3 = this.a;
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
        TTVideoEngine r0 = new TTVideoEngine(((AbsPlayer) this).b, 0);
        this.g = r0;
        if (r0.isSystemPlayer() == true) goto L7;
        this.g.setIntOption(4, 4);
        this.g.setIntOption(3, 1);
        this.g.setListener(this.h);
        this.g.setIntOption(7, 1);
        return;
    L7:
        throw new Exception("create ttVideoEngine failure");
    }

    public final int getCurrentPosition() {
        return this.g.getCurrentPlaybackTime();
    }

    public final VideoInfo getVideoInfo() throws Exception {
        return new VideoInfo(this.g.getVideoWidth(), this.g.getVideoHeight(), this.g.getDuration());
    }

    public final void pause() {
        this.g.pause();
    }

    public final void prepareAsync() {
        ((AbsPlayer) this).d.a(this);
    }

    public final void release() {
        this.g.release();
    }

    public final void start() {
        this.g.play();
    }

    public final void stop() {
        this.g.stop();
    }

    public a(Context r2) {
        super(r2);
        this.h = new C0000a(this);
        ((AbsPlayer) this).b = r2;
    }

    public final void setDataSource(String r2) throws IOException {
        this.g.setLocalURL(r2);
    }

    public final void setLooping(boolean r2) {
        this.g.setLooping(r2);
    }

    public final void setSurface(Surface r2) {
        this.g.setSurface(r2);
    }
}
