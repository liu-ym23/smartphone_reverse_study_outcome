package com.bytedance.awemeopen.infra.plugs.ttvideoengine;

import android.view.Surface;
import com.bytedance.awemeopen.servicesapi.log.AoLogService;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineCallback;
import com.ss.ttvideoengine.utils.Error;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements VideoEngineCallback {
    public final /* synthetic */ b a;

    public final /* synthetic */ String getEncryptedLocalTime() {
        return VideoEngineCallback.-CC.$default$getEncryptedLocalTime(this);
    }

    public final /* synthetic */ void onABRPredictBitrate(int r1, int r2) {
        VideoEngineCallback.-CC.$default$onABRPredictBitrate(this, r1, r2);
    }

    public final /* synthetic */ void onAVBadInterlaced(Map r1) {
        VideoEngineCallback.-CC.$default$onAVBadInterlaced(this, r1);
    }

    public final /* synthetic */ void onCurrentPlaybackTimeUpdate(TTVideoEngine r1, int r2) {
        VideoEngineCallback.-CC.$default$onCurrentPlaybackTimeUpdate(this, r1, r2);
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

    public final /* synthetic */ void onReadyForDisplay(TTVideoEngine r1) {
        VideoEngineCallback.-CC.$default$onReadyForDisplay(this, r1);
    }

    public final /* synthetic */ void onRefreshSurface(TTVideoEngine r1) {
        VideoEngineCallback.-CC.$default$onRefreshSurface(this, r1);
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

    public f(b r1) {
        this.a = r1;
    }

    public final void onBufferEnd(int r5) {
        VideoEngineCallback.-CC.$default$onBufferEnd(this, r5);
        b r0 = this.a;
        r64.d r1 = r0.g;
        if (r1 == null) goto L11;
        r64.b r2 = r0.e;
        if (r2 == null) goto L8;
        String r3 = r2.b;
        if (r3 == null) goto L8;
    L9:
        r1.f(r3, false, -1, r5);
        return;
    L8:
        r3 = "";
        goto L9
    }

    public final void onCompletion(TTVideoEngine r5) {
        Intrinsics.checkNotNullParameter(r5, "engine");
        VideoEngineCallback.-CC.$default$onCompletion(this, r5);
        b r0 = this.a;
        r64.d r1 = r0.g;
        if (r1 == null) goto L11;
        r64.b r2 = r0.e;
        if (r2 == null) goto L8;
        String r3 = r2.b;
        if (r3 == null) goto L8;
    L9:
        r64.c r4 = new r64.c();
        r4.a = 1;
        r5.isplaybackUsedSR();
        Unit r6 = Unit.INSTANCE;
        r1.a(r3, r4);
        return;
    L8:
        r3 = "";
        goto L9
    }

    public final void onError(Error r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        VideoEngineCallback.-CC.$default$onError(this, r4);
        if (r4 != null) goto L5;
        Error r0 = "null";
    L6:
        int r1 = j64.b.a;
        j64.b.a(AoLogService.class).e("AoTTVideoEnginePlayer", r0.toString());
        b r2 = this.a;
        r64.d r3 = r2.g;
        if (r3 == null) goto L15;
        r64.b r5 = r2.e;
        if (r5 == null) goto L12;
        String r6 = r5.b;
        if (r6 == null) goto L12;
    L13:
        r3.e(r6, r4.code, r4.description);
        return;
    L12:
        r6 = "";
        goto L13
    L15:
        return;
    L5:
        r0 = r4;
        goto L6
    }

    public final void onPrepare(TTVideoEngine r2) {
        VideoEngineCallback.-CC.$default$onPrepare(this, r2);
        this.a.i = 1;
        b r3 = this.a;
        r64.d r0 = r3.g;
        if (r0 == null) goto L10;
        r64.b r4 = r3.e;
        if (r4 == null) goto L8;
        String r5 = r4.b;
        if (r5 == null) goto L8;
    L9:
        r0.onPlayPrepare(r5);
    L8:
        r5 = "";
    L10:
        g.a("videoEngineCallback onPrepare");
    }

    public final void onPrepared(TTVideoEngine r2) {
        VideoEngineCallback.-CC.$default$onPrepared(this, r2);
        this.a.i = 1;
        g.a("videoEngineCallback onPrepared");
    }

    public final void onRenderStart(TTVideoEngine r5) {
        VideoEngineCallback.-CC.$default$onRenderStart(this, r5);
        if (TTVideoEngine.getCacheFileSize(this.a.f) <= 0) goto L5;
        boolean r6 = true;
    L6:
        g.a("videoEngineCallback onRenderStart: hitVideoCache=" + r6);
        b r0 = this.a;
        r64.d r1 = r0.g;
        if (r1 == null) goto L15;
        r64.b r2 = r0.e;
        if (r2 == null) goto L12;
        String r3 = r2.b;
        if (r3 == null) goto L12;
    L13:
        r1.g(r3, r6, null);
        return;
    L12:
        r3 = "";
        goto L13
    L15:
        return;
    L5:
        r6 = false;
        goto L6
    }

    public final void onBufferingUpdate(TTVideoEngine r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "engine");
        VideoEngineCallback.-CC.$default$onBufferingUpdate(this, r5, r6);
        b r0 = this.a;
        r64.d r1 = r0.g;
        if (r1 == null) goto L11;
        r64.b r2 = r0.e;
        if (r2 == null) goto L8;
        String r3 = r2.b;
        if (r3 == null) goto L8;
    L9:
        r1.d(r3, r5.getDuration() * r6, r6);
        return;
    L8:
        r3 = "";
        goto L9
    }

    public final void onPlaybackStateChanged(TTVideoEngine r4, int r5) {
        VideoEngineCallback.-CC.$default$onPlaybackStateChanged(this, r4, r5);
        b r6 = this.a;
        r64.d r0 = r6.g;
        if (r0 == null) goto L33;
        String r1 = "";
        if (r5 != 0) goto L7;
        r64.b r7 = r6.e;
        if (r7 == null) goto L31;
        String r8 = r7.b;
        if (r8 == null) goto L31;
        r1 = r8;
    L31:
        r0.c(r1);
        return;
    L7:
        if (r5 != 1) goto L9;
        r64.b r9 = r6.e;
        if (r9 == null) goto L24;
        String r10 = r9.b;
        if (r10 == null) goto L24;
        r1 = r10;
    L24:
        r0.onPlaying(r1);
        return;
    L9:
        if (r5 != 2) goto L36;
        r64.b r11 = r6.e;
        if (r11 == null) goto L17;
        String r12 = r11.b;
        if (r12 == null) goto L17;
        r1 = r12;
    L17:
        r0.h(r1);
        return;
    L36:
        return;
    }

    public final void onBufferStart(int r3, int r4, int r5) {
        VideoEngineCallback.-CC.$default$onBufferStart(this, r3, r4, r5);
        b r6 = this.a;
        r64.d r7 = r6.g;
        if (r7 == null) goto L11;
        r64.b r8 = r6.e;
        if (r8 == null) goto L8;
        String r9 = r8.b;
        if (r9 == null) goto L8;
    L9:
        r7.f(r9, true, r5, -1);
        return;
    L8:
        r9 = "";
        goto L9
    }
}
