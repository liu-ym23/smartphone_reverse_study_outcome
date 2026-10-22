package com.ss.android.lark.player.player;

import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.player.entity.DataSource;
import com.ss.android.lark.statistics.Statistics;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineCallback;
import com.ss.ttvideoengine.utils.Error;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k implements VideoEngineCallback {
    public static final long c = 0;
    public static final long d = 0;
    public final s a;
    public final Handler b;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ k a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;

        public b(k r1, String r2, String r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            Statistics.sendEvent("download_interlaced_video_dev");
            this.a.a.l();
            DataSource r0 = this.a.a.o;
            r0.getShowPreloading().setValue(Boolean.TRUE);
            String r3 = this.b;
            String r4 = this.c;
            long r5 = r0.getSize();
            HashMap<String, String> r9 = r0.getExtra();
            s r1 = this.a.a;
            Intrinsics.checkNotNull(r0);
            LarkPlayerUtils.h(r3, r4, r5, 0, r9, new r(r1, r0, this.d));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final /* synthetic */ String getEncryptedLocalTime() {
        return VideoEngineCallback.-CC.$default$getEncryptedLocalTime(this);
    }

    public final /* synthetic */ void onABRPredictBitrate(int r1, int r2) {
        VideoEngineCallback.-CC.$default$onABRPredictBitrate(this, r1, r2);
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

    public final /* synthetic */ void onPlayUrlChanged(int r1, String r2, String r3) {
        VideoEngineCallback.-CC.$default$onPlayUrlChanged(this, r1, r2, r3);
    }

    public final /* synthetic */ void onPlaybackStateChanged(TTVideoEngine r1, int r2) {
        VideoEngineCallback.-CC.$default$onPlaybackStateChanged(this, r1, r2);
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

    static {
        c = IMPlayerSettings.a().getBadAVDiff();
        d = IMPlayerSettings.a().getBadAVWaitTime();
    }

    public k(s r2) {
        Intrinsics.checkNotNullParameter(r2, "player");
        this.a = r2;
        this.b = new Handler(Looper.getMainLooper());
    }

    public final void onAVBadInterlaced(Map<Object, Object> r11) {
        if (r11 == null) goto L19;
        Object r12 = r11.get("diff");
        if (r12 == null) goto L20;
        s r1 = this.a;
        String r2 = r1.p;
        String r3 = "";
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        String r4 = r1.q;
        if (r4 == null) goto L13;
        r3 = r4;
    L13:
        int r5 = r1.c();
        StringBuilder r6 = new StringBuilder("onAVBadInterlaced, diff: ");
        r6.append(r12);
        r6.append(", BAD_AV_DIFF: ");
        long r7 = c;
        r6.append(r7);
        r6.append(", currentPosition: ");
        r6.append(r5);
        Log.e("LarkVideoEngineCallback", r6.toString());
        Statistics.sendEvent("player_bad_av_dev", new JSONObject().put("diff", ((Long) r12).longValue()));
        if (((Number) r12).longValue() >= r7) goto L17;
        Log.i("LarkVideoEngineCallback", "smaller than bad av threshold");
        return;
    L17:
        this.b.postDelayed(new b(this, r2, r3, r5), d);
        return;
    L20:
        return;
    }

    public final void onLoadStateChanged(TTVideoEngine r1, int r2) {
        if (r2 == 2) goto L6;
        Log.i("LarkVideoEngineCallback", "remove task");
        this.b.removeCallbacksAndMessages(null);
        return;
    }
}
