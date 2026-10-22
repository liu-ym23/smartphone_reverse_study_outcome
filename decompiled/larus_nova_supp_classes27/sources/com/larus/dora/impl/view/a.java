package com.larus.dora.impl.view;

import android.view.Surface;
import android.widget.FrameLayout;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineCallback;
import com.ss.ttvideoengine.utils.Error;
import g49.d;
import java.util.Map;
import q69.e;
import q69.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a implements VideoEngineCallback {
    public final /* synthetic */ DoraMovieView a;

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

    public final /* synthetic */ void onCurrentPlaybackTimeUpdate(TTVideoEngine r1, int r2) {
        VideoEngineCallback.-CC.$default$onCurrentPlaybackTimeUpdate(this, r1, r2);
    }

    public final /* synthetic */ void onError(Error r1) {
        VideoEngineCallback.-CC.$default$onError(this, r1);
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

    public final /* synthetic */ void onPlaybackStateChanged(TTVideoEngine r1, int r2) {
        VideoEngineCallback.-CC.$default$onPlaybackStateChanged(this, r1, r2);
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

    public final /* synthetic */ void onVideoStatusException(int r1) {
        VideoEngineCallback.-CC.$default$onVideoStatusException(this, r1);
    }

    public final /* synthetic */ void onVideoStreamBitrateChanged(Resolution r1, int r2) {
        VideoEngineCallback.-CC.$default$onVideoStreamBitrateChanged(this, r1, r2);
    }

    public final /* synthetic */ void onVideoURLRouteFailed(Error r1, String r2) {
        VideoEngineCallback.-CC.$default$onVideoURLRouteFailed(this, r1, r2);
    }

    public a(DoraMovieView r1) {
        this.a = r1;
    }

    public final void onCompletion(TTVideoEngine r1) {
        VideoEngineCallback.-CC.$default$onCompletion(this, r1);
        DoraMovieView.c r2 = this.a.p;
        if (r2 == null) goto L6;
        r2.a();
        return;
    }

    public final void onFirstAVSyncFrame(TTVideoEngine r2) {
        VideoEngineCallback.-CC.$default$onFirstAVSyncFrame(this, r2);
        DoraMovieView r3 = this.a;
        if (r3.j != null) goto L5;
        return;
    L5:
        if (r3.m.booleanValue() == false) goto L9;
        DoraMovieView r4 = this.a;
        r4.m = Boolean.FALSE;
        r4.f.post(new f(this));
        return;
    }

    public final void onPrepare(TTVideoEngine r1) {
        VideoEngineCallback.-CC.$default$onPrepare(this, r1);
    }

    public final void onPrepared(TTVideoEngine r4) {
        VideoEngineCallback.-CC.$default$onPrepared(this, r4);
        DoraMovieView r5 = this.a;
        int r0 = r5.g;
        if (r0 <= 0) goto L9;
        TTVideoEngine r1 = r5.a;
        if (r1 == null) goto L7;
        r1.seekTo(r0, null);
    L7:
        r5.q.sendEmptyMessage(1000);
        this.a.g = 0;
    L11:
        DoraMovieView.e r6 = this.a.i;
        if (r6 == null) goto L15;
        r6.onStart();
        return;
    L15:
        return;
    L9:
        if (r5.l.booleanValue() == true) goto L11;
        this.a.e();
        goto L11
    }

    public final void onVideoSizeChanged(TTVideoEngine r12, int r13, int r14) {
        VideoEngineCallback.-CC.$default$onVideoSizeChanged(this, r12, r13, r14);
        DoraMovieView r15 = this.a;
        r15.d = r13;
        r15.e = r14;
        int r16 = r15.getWidth();
        int r17 = this.a.getHeight();
        int r0 = r15.d;
        if (r0 == 0) goto L13;
        int r1 = r15.e;
        if (r1 == 0) goto L14;
        float r2 = r0 / r1;
        float r3 = r16;
        float r4 = r17;
        float r5 = r3 / r4;
        FrameLayout.LayoutParams r6 = (FrameLayout.LayoutParams) r15.f.getLayoutParams();
        if (r2 <= r5) goto L10;
        int r18 = (int) (r3 / r2);
        r6.width = r16;
        r6.height = r18;
        d.a("AdjustAspectRatio", "adjust height, , the viewWidth is : " + r15.getWidth() + ", the videoWidth is : " + r15.d + ", the viewHight is : " + r15.getHeight() + ", the videoheight is : " + r15.e + ", newWidth: " + r16 + ", newHeight: " + r18);
    L11:
        r6.gravity = 17;
        r15.f.setLayoutParams(r6);
        r15.f.setOutlineProvider(new e(r15));
        r15.f.setClipToOutline(true);
        return;
    L10:
        int r110 = (int) (r4 * r2);
        r6.width = r110;
        r6.height = r17;
        d.a("AdjustAspectRatio", "adjust width , the viewWidth is : " + r15.getWidth() + ", the videoWidth is : " + r15.d + ", the viewHight is : " + r15.getHeight() + ", the videoheight is : " + r15.e + ", newWidth: " + r110 + ", newHeight: " + r17);
        goto L11
    L14:
        return;
    }
}
