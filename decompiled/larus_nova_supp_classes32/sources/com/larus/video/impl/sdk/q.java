package com.larus.video.impl.sdk;

import android.view.Surface;
import com.larus.platform.api.k4;
import com.larus.platform.api.n0;
import com.larus.utils.logger.FLogger;
import com.larus.video.impl.sdk.eventlog.MediaEventLogReporter;
import com.larus.video.impl.sdk.eventlog.PlayUploadStatus;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineCallback;
import com.ss.ttvideoengine.VideoEngineStateListener;
import com.ss.ttvideoengine.utils.Error;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q implements VideoEngineCallback, VideoEngineStateListener {
    public final TTVideoEngine a;
    public n0 b;
    public final int c;
    public k4 d;
    public boolean e;

    public static final class a {
    }

    static {
    }

    public final /* synthetic */ void onPlayUrlChanged(int r1, String r2, String r3) {
        VideoEngineCallback.-CC.$default$onPlayUrlChanged(this, r1, r2, r3);
    }

    public final /* synthetic */ void onSilenceDetected(TTVideoEngine r1) {
        VideoEngineCallback.-CC.$default$onSilenceDetected(this, r1);
    }

    public final String getEncryptedLocalTime() {
        String r0 = VideoEngineCallback.-CC.$default$getEncryptedLocalTime(this);
        FLogger.a.d("flow_video_engine", "#" + hashCode() + ".getEncryptedLocalTime(engine#" + this.c + ", " + r0 + ')');
        return r0;
    }

    public q(TTVideoEngine r4) {
        Intrinsics.checkNotNullParameter(r4, "engine");
        this.a = r4;
        this.b = null;
        r r0 = r.a;
        Intrinsics.checkNotNullParameter(this, "listener");
        Object r1 = r.c;
        monitor-enter(r1);
        LinkedList<VideoEngineStateListener> r2 = r.e;     // Catch: Throwable -> L13
        if (r2 == null) goto L7;
        r2.add(this);     // Catch: Throwable -> L13
    L7:
        LinkedList<WeakReference<VideoEngineStateListener>> r3 = r.d;     // Catch: Throwable -> L13
        if (r3 == null) goto L10;
        r3.add(new WeakReference(this));     // Catch: Throwable -> L13
    L10:
        monitor-exit(r1);
        this.c = r4.hashCode();
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void onAVBadInterlaced(Map<Object, Object> r1) {
        VideoEngineCallback.-CC.$default$onAVBadInterlaced(this, r1);
    }

    public final void onBufferEnd(int r4) {
        VideoEngineCallback.-CC.$default$onBufferEnd(this, r4);
        FLogger.a.d("flow_video_engine", "#" + hashCode() + ".onBufferEnd(engine#" + this.c + ", " + r4 + ')');
    }

    public final void onCompletion(TTVideoEngine r3) {
        VideoEngineCallback.-CC.$default$onCompletion(this, r3);
        n0 r4 = this.b;
        if (r4 == null) goto L5;
        r4.onCompletion();
    L5:
        FLogger.a.d("flow_video_engine", "#" + hashCode() + ".onCompletion(engine#" + this.c + ')');
    }

    public final void onEnginePlay(TTVideoEngine r3) {
        if (Intrinsics.areEqual(r3, this.a) == false) goto L9;
        this.e = true;
        n0 r4 = this.b;
        if (r4 == null) goto L7;
        r4.onPrepare();
    L7:
        MediaEventLogReporter r5 = MediaEventLogReporter.a;
        MediaEventLogReporter.b(this.d, PlayUploadStatus.PLAY);
        FLogger.a.d("flow_video_engine", "#" + hashCode() + ".onEnginePlay(engine#" + this.c + ')');
        return;
    }

    public final void onEngineStop(TTVideoEngine r4) {
        if (Intrinsics.areEqual(r4, this.a) == false) goto L12;
        this.e = false;
        FLogger.a.d("flow_video_engine", "#" + hashCode() + ".onEngineStop(engine#" + this.c + ')');
        r r5 = r.a;     // Catch: Exception -> L7
        r.a(this);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        FLogger.a.e("flow_video_engine", "removeEngineStateListener exception", e);
        return;
    }

    public final void onError(Error r6) {
        VideoEngineCallback.-CC.$default$onError(this, r6);
        this.e = false;
        n0 r0 = this.b;
        Integer r1 = null;
        if (r0 == null) goto L11;
        if (r6 == null) goto L6;
        Integer r2 = Integer.valueOf(r6.code);
    L7:
        if (r6 == null) goto L9;
        Integer r3 = Integer.valueOf(r6.internalCode);
    L10:
        r0.a(r2, r3);
        goto L11
    L9:
        r3 = null;
        goto L10
    L6:
        r2 = null;
    L11:
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("#");
        r5.append(hashCode());
        r5.append(".onError(engine#");
        r5.append(this.c);
        r5.append(", ");
        if (r6 == null) goto L14;
        Integer r7 = Integer.valueOf(r6.code);
    L15:
        r5.append(r7);
        r5.append(", ");
        if (r6 == null) goto L18;
        r1 = Integer.valueOf(r6.internalCode);
    L18:
        r5.append(r1);
        r5.append(')');
        r4.i("flow_video_engine", r5.toString());
        return;
    L14:
        r7 = null;
        goto L15
    }

    public final void onFirstAVSyncFrame(TTVideoEngine r3) {
        VideoEngineCallback.-CC.$default$onFirstAVSyncFrame(this, r3);
        FLogger.a.d("flow_video_engine", "#" + hashCode() + ".onFirstAVSyncFrame(engine#" + this.c + ')');
    }

    public final void onInfoIdChanged(int r4) {
        VideoEngineCallback.-CC.$default$onInfoIdChanged(this, r4);
        FLogger.a.d("flow_video_engine", "#" + hashCode() + ".onInfoIdChanged(engine#" + this.c + ", " + r4 + ')');
    }

    public final void onPrepare(TTVideoEngine r5) {
        VideoEngineCallback.-CC.$default$onPrepare(this, r5);
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("#");
        r1.append(hashCode());
        r1.append(".onPrepare(engine#");
        r1.append(this.c);
        r1.append("), playbackState:");
        Integer r2 = null;
        if (r5 == null) goto L5;
        Integer r3 = Integer.valueOf(r5.getPlaybackState());
    L6:
        r1.append(r3);
        r1.append(", loadState:");
        if (r5 == null) goto L9;
        r2 = Integer.valueOf(r5.getLoadState());
    L9:
        r1.append(r2);
        r0.d("flow_video_engine", r1.toString());
        if (this.e == false) goto L13;
        this.e = false;
        return;
    L13:
        n0 r6 = this.b;
        if (r6 == null) goto L17;
        r6.onPrepare();
        return;
    L17:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void onPrepared(TTVideoEngine r5) {
        VideoEngineCallback.-CC.$default$onPrepared(this, r5);
        n0 r0 = this.b;
        if (r0 == null) goto L5;
        r0.onPrepared();
    L5:
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("#");
        r2.append(hashCode());
        r2.append(".onPrepared(engine#");
        r2.append(this.c);
        r2.append("), playbackState:");
        Integer r3 = null;
        if (r5 == null) goto L8;
        Integer r4 = Integer.valueOf(r5.getPlaybackState());
    L9:
        r2.append(r4);
        r2.append(", loadState:");
        if (r5 == null) goto L12;
        Integer r6 = Integer.valueOf(r5.getLoadState());
    L13:
        r2.append(r6);
        r1.d("flow_video_engine", r2.toString());
        n0 r7 = this.b;
        if (r7 == null) goto L22;
        if (r5 == null) goto L17;
        Integer r8 = Integer.valueOf(r5.getVideoWidth());
    L18:
        if (r5 == null) goto L20;
        r3 = Integer.valueOf(r5.getVideoHeight());
    L20:
        r7.b(r8, r3);
        return;
    L17:
        r8 = null;
        goto L18
    L22:
        return;
    L12:
        r6 = null;
        goto L13
    L8:
        r4 = null;
        goto L9
    }

    public final void onReadyForDisplay(TTVideoEngine r3) {
        VideoEngineCallback.-CC.$default$onReadyForDisplay(this, r3);
        FLogger.a.d("flow_video_engine", "#" + hashCode() + ".onReadyForDisplay(engine#" + this.c + ')');
    }

    public final void onRefreshSurface(TTVideoEngine r3) {
        VideoEngineCallback.-CC.$default$onRefreshSurface(this, r3);
        FLogger.a.d("flow_video_engine", "#" + hashCode() + ".onRefreshSurface(engine#" + this.c + ')');
    }

    public final void onRenderStart(TTVideoEngine r3) {
        VideoEngineCallback.-CC.$default$onRenderStart(this, r3);
        n0 r4 = this.b;
        if (r4 == null) goto L5;
        r4.onRenderStart();
    L5:
        FLogger.a.d("flow_video_engine", "#" + hashCode() + ".onRenderStart(engine#" + this.c + ')');
    }

    public final void onVideoSecondFrame(TTVideoEngine r3) {
        VideoEngineCallback.-CC.$default$onVideoSecondFrame(this, r3);
        FLogger.a.d("flow_video_engine", "#" + hashCode() + ".onVideoSecondFrame(engine#" + this.c + ')');
    }

    public final void onVideoStatusException(int r4) {
        VideoEngineCallback.-CC.$default$onVideoStatusException(this, r4);
        n0 r0 = this.b;
        if (r0 == null) goto L5;
        r0.onVideoStatusException(r4);
    L5:
        FLogger.a.i("flow_video_engine", "#" + hashCode() + ".onVideoStatusException(engine#" + this.c + ", " + r4 + ')');
    }

    public final void onABRPredictBitrate(int r1, int r2) {
        VideoEngineCallback.-CC.$default$onABRPredictBitrate(this, r1, r2);
    }

    public final void onBufferingUpdate(TTVideoEngine r1, int r2) {
        VideoEngineCallback.-CC.$default$onBufferingUpdate(this, r1, r2);
    }

    public final void onCurrentPlaybackTimeUpdate(TTVideoEngine r1, int r2) {
        VideoEngineCallback.-CC.$default$onCurrentPlaybackTimeUpdate(this, r1, r2);
    }

    public final void onFrameDraw(int r1, Map<Object, Object> r2) {
        VideoEngineCallback.-CC.$default$onFrameDraw(this, r1, r2);
    }

    public final void onLoadStateChanged(TTVideoEngine r3, int r4) {
        VideoEngineCallback.-CC.$default$onLoadStateChanged(this, r3, r4);
        n0 r5 = this.b;
        if (r5 == null) goto L5;
        r5.d(r4);
    L5:
        FLogger.a.d("flow_video_engine", "#" + hashCode() + ".onLoadStateChanged(engine#" + this.c + ", " + r4 + ')');
    }

    public final void onPlaybackStateChanged(TTVideoEngine r3, int r4) {
        VideoEngineCallback.-CC.$default$onPlaybackStateChanged(this, r3, r4);
        this.e = false;
        n0 r5 = this.b;
        if (r5 == null) goto L5;
        r5.c(r4);
    L5:
        FLogger.a.d("flow_video_engine", "#" + hashCode() + ".onPlaybackStateChanged(engine#" + this.c + ", " + r4 + ')');
        if (r4 != 0) goto L8;
    L13:
        PlayUploadStatus r6 = PlayUploadStatus.STOP;
    L14:
        MediaEventLogReporter r7 = MediaEventLogReporter.a;
        MediaEventLogReporter.b(this.d, r6);
        return;
    L8:
        if (r4 != 1) goto L10;
        r6 = PlayUploadStatus.PLAY;
        goto L14
    L10:
        if (r4 == 3) goto L13;
        r6 = PlayUploadStatus.PAUSE;
        goto L14
    }

    public final void onSARChanged(int r4, int r5) {
        VideoEngineCallback.-CC.$default$onSARChanged(this, r4, r5);
        FLogger.a.d("flow_video_engine", "#" + hashCode() + ".onSARChanged(engine#" + this.c + ", " + r4 + ", " + r5 + ')');
    }

    public final void onStreamChanged(TTVideoEngine r3, int r4) {
        VideoEngineCallback.-CC.$default$onStreamChanged(this, r3, r4);
        FLogger.a.d("flow_video_engine", "#" + hashCode() + ".onStreamChanged(engine#" + this.c + ", " + r4 + ')');
    }

    public final void onVideoStreamBitrateChanged(Resolution r4, int r5) {
        VideoEngineCallback.-CC.$default$onVideoStreamBitrateChanged(this, r4, r5);
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("#");
        r1.append(hashCode());
        r1.append(".onVideoStreamBitrateChanged(engine#");
        r1.append(this.c);
        r1.append(", ");
        if (r4 == null) goto L5;
        String r6 = r4.name();
    L6:
        r1.append(r6);
        r1.append(", ");
        r1.append(r5);
        r1.append(')');
        r0.d("flow_video_engine", r1.toString());
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void onVideoURLRouteFailed(Error r4, String r5) {
        VideoEngineCallback.-CC.$default$onVideoURLRouteFailed(this, r4, r5);
        FLogger.a.d("flow_video_engine", "#" + hashCode() + ".onVideoURLRouteFailed(engine#" + this.c + ", " + r4 + ", " + r5 + ')');
    }

    public final void onBufferStart(int r4, int r5, int r6) {
        VideoEngineCallback.-CC.$default$onBufferStart(this, r4, r5, r6);
        FLogger.a.d("flow_video_engine", "#" + hashCode() + ".onBufferStart(engine#" + this.c + ", " + r4 + ", " + r5 + ", " + r6 + ')');
    }

    public final int onSetSurface(TTVideoEngine r4, VideoSurface r5, Surface r6) {
        FLogger.a.d("flow_video_engine", "#" + hashCode() + ".onSetSurface(engine#" + this.c + ", videoSurface, surface)");
        return VideoEngineCallback.-CC.$default$onSetSurface(this, r4, r5, r6);
    }

    public final void onVideoSizeChanged(TTVideoEngine r3, int r4, int r5) {
        VideoEngineCallback.-CC.$default$onVideoSizeChanged(this, r3, r4, r5);
        n0 r6 = this.b;
        if (r6 == null) goto L5;
        r6.b(Integer.valueOf(r4), Integer.valueOf(r5));
    L5:
        FLogger.a.d("flow_video_engine", "#" + hashCode() + ".onVideoSizeChanged(engine#" + this.c + ", " + r4 + ", " + r5 + ')');
    }

    public final void onFrameAboutToBeRendered(TTVideoEngine r3, int r4, long r5, long r7, Map<Integer, String> r9) {
        VideoEngineCallback.-CC.$default$onFrameAboutToBeRendered(this, r3, r4, r5, r7, r9);
        FLogger.a.d("flow_video_engine", "#" + hashCode() + ".onFrameAboutToBeRendered(engine#" + this.c + ", " + r4 + ", " + r5 + ", " + r7 + ", " + r9 + ')');
    }
}
