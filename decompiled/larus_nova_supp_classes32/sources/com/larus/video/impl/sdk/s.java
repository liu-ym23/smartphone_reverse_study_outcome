package com.larus.video.impl.sdk;

import android.view.Surface;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineCallback;
import com.ss.ttvideoengine.utils.Error;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s implements VideoEngineCallback {
    public rx9.k a;

    public s() {
    }

    public final /* synthetic */ String getEncryptedLocalTime() {
        return VideoEngineCallback.-CC.$default$getEncryptedLocalTime(this);
    }

    public final /* synthetic */ void onABRPredictBitrate(int r1, int r2) {
        VideoEngineCallback.-CC.$default$onABRPredictBitrate(this, r1, r2);
    }

    public final /* synthetic */ void onAVBadInterlaced(Map r1) {
        VideoEngineCallback.-CC.$default$onAVBadInterlaced(this, r1);
    }

    public final /* synthetic */ void onBufferEnd(int r1) {
        VideoEngineCallback.-CC.$default$onBufferEnd(this, r1);
    }

    public final /* synthetic */ void onBufferStart(int r1, int r2, int r3) {
        VideoEngineCallback.-CC.$default$onBufferStart(this, r1, r2, r3);
    }

    public final /* synthetic */ void onBufferingUpdate(TTVideoEngine r1, int r2) {
        VideoEngineCallback.-CC.$default$onBufferingUpdate(this, r1, r2);
    }

    public final /* synthetic */ void onCompletion(TTVideoEngine r1) {
        VideoEngineCallback.-CC.$default$onCompletion(this, r1);
    }

    public final /* synthetic */ void onCurrentPlaybackTimeUpdate(TTVideoEngine r1, int r2) {
        VideoEngineCallback.-CC.$default$onCurrentPlaybackTimeUpdate(this, r1, r2);
    }

    public final /* synthetic */ void onError(Error r1) {
        VideoEngineCallback.-CC.$default$onError(this, r1);
    }

    public final /* synthetic */ void onFirstAVSyncFrame(TTVideoEngine r1) {
        VideoEngineCallback.-CC.$default$onFirstAVSyncFrame(this, r1);
    }

    public final /* synthetic */ void onFrameAboutToBeRendered(TTVideoEngine r1, int r2, long r3, long r5, Map r7) {
        VideoEngineCallback.-CC.$default$onFrameAboutToBeRendered(this, r1, r2, r3, r5, r7);
    }

    public final /* synthetic */ void onFrameDraw(int r1, Map r2) {
        VideoEngineCallback.-CC.$default$onFrameDraw(this, r1, r2);
    }

    public final /* synthetic */ void onInfoIdChanged(int r1) {
        VideoEngineCallback.-CC.$default$onInfoIdChanged(this, r1);
    }

    public final /* synthetic */ void onLoadStateChanged(TTVideoEngine r1, int r2) {
        VideoEngineCallback.-CC.$default$onLoadStateChanged(this, r1, r2);
    }

    public final /* synthetic */ void onPlayUrlChanged(int r1, String r2, String r3) {
        VideoEngineCallback.-CC.$default$onPlayUrlChanged(this, r1, r2, r3);
    }

    public final /* synthetic */ void onPrepare(TTVideoEngine r1) {
        VideoEngineCallback.-CC.$default$onPrepare(this, r1);
    }

    public final /* synthetic */ void onPrepared(TTVideoEngine r1) {
        VideoEngineCallback.-CC.$default$onPrepared(this, r1);
    }

    public final /* synthetic */ void onReadyForDisplay(TTVideoEngine r1) {
        VideoEngineCallback.-CC.$default$onReadyForDisplay(this, r1);
    }

    public final /* synthetic */ void onRefreshSurface(TTVideoEngine r1) {
        VideoEngineCallback.-CC.$default$onRefreshSurface(this, r1);
    }

    public final /* synthetic */ void onRenderStart(TTVideoEngine r1) {
        VideoEngineCallback.-CC.$default$onRenderStart(this, r1);
    }

    public final /* synthetic */ void onSARChanged(int r1, int r2) {
        VideoEngineCallback.-CC.$default$onSARChanged(this, r1, r2);
    }

    public final /* synthetic */ int onSetSurface(TTVideoEngine r1, VideoSurface r2, Surface r3) {
        return VideoEngineCallback.-CC.$default$onSetSurface(this, r1, r2, r3);
    }

    public final /* synthetic */ void onSilenceDetected(TTVideoEngine r1) {
        VideoEngineCallback.-CC.$default$onSilenceDetected(this, r1);
    }

    public final /* synthetic */ void onStreamChanged(TTVideoEngine r1, int r2) {
        VideoEngineCallback.-CC.$default$onStreamChanged(this, r1, r2);
    }

    public final /* synthetic */ void onVideoSecondFrame(TTVideoEngine r1) {
        VideoEngineCallback.-CC.$default$onVideoSecondFrame(this, r1);
    }

    public final /* synthetic */ void onVideoSizeChanged(TTVideoEngine r1, int r2, int r3) {
        VideoEngineCallback.-CC.$default$onVideoSizeChanged(this, r1, r2, r3);
    }

    public final /* synthetic */ void onVideoStatusException(int r1) {
        VideoEngineCallback.-CC.$default$onVideoStatusException(this, r1);
    }

    public final /* synthetic */ void onVideoStreamBitrateChanged(Resolution r1, int r2) {
        VideoEngineCallback.-CC.$default$onVideoStreamBitrateChanged(this, r1, r2);
    }

    public final /* synthetic */ void onVideoURLRouteFailed(Error r1, String r2) {
        VideoEngineCallback.-CC.$default$onVideoURLRouteFailed(this, r1, r2);
    }

    public final void onPlaybackStateChanged(TTVideoEngine r2, int r3) {
        if (r3 != 0) goto L5;
    L15:
        rx9.k r4 = this.a;
        if (r4 == null) goto L18;
        r4.a();
    L18:
        this.a = null;
        return;
    L5:
        if (r3 != 1) goto L7;
        rx9.k r5 = this.a;
        if (r5 == null) goto L14;
        r5.a();
    L14:
        this.a = null;
        rx9.k r6 = new rx9.k("tt_video_engine");
        r6.b();
        this.a = r6;
        return;
    L7:
        if (r3 == 2) goto L15;
        if (r3 == 4) goto L15;
    }
}
