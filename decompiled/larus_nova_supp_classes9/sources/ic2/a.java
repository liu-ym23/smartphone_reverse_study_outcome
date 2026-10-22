package ic2;

import android.view.Surface;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class a implements VideoEngineListener {
    public a() {
    }

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

    public final void onPrepared(TTVideoEngine r1) {
    }

    public final /* synthetic */ void onRefreshSurface(TTVideoEngine r1) {
        VideoEngineListener.-CC.$default$onRefreshSurface(this, r1);
    }

    public final void onRenderStart(TTVideoEngine r1) {
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
}
