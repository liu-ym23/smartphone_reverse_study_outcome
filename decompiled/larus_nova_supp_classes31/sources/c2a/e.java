package c2a;

import android.view.Surface;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.home.impl.sdk.s;
import com.larus.im.bean.message.Message;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.o0;
import com.larus.media.v;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.texturerender.VideoSurface;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineCallback;
import com.ss.ttvideoengine.utils.Error;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import lk9.g;
import tx9.c1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public static TTVideoEngine a;
    public static final a b = null;
    public static String c;
    public static Message d;
    public static String e;
    public static final com.larus.media.model.a f = null;

    public static final class a implements VideoEngineCallback {
        public a() {
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

        public final void onCompletion(TTVideoEngine r3) {
            FLogger r4 = FLogger.a;
            TTVideoEngine r0 = e.a;
            r4.i("AudioUrlPlayer", "onCompletion");
            AudioServiceDelegate.a.r0().n(PlayStateEnum.PLAY_STATE_STOPPED);
            e.b("auto_end");
            TTVideoEngine r5 = e.a;
            if (r5 == null) goto L5;
            r5.release();
        L5:
            e.a = null;
            e.a();
        }

        public final void onError(Error r4) {
            FLogger r0 = FLogger.a;
            TTVideoEngine r1 = e.a;
            StringBuilder r2 = new StringBuilder("onError ");
            if (r4 == null) goto L5;
            Integer r5 = Integer.valueOf(r4.code);
        L6:
            r2.append(r5);
            r0.i("AudioUrlPlayer", r2.toString());
            AudioServiceDelegate.a.r0().n(PlayStateEnum.PLAY_STATE_STOPPED);
            e.b("interrupt");
            TTVideoEngine r6 = e.a;
            if (r6 == null) goto L9;
            r6.release();
        L9:
            e.a = null;
            e.a();
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class b implements v {
        public b() {
        }

        public final boolean b(g r2) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            return false;
        }

        public final void e(g r3) {
            Intrinsics.checkNotNullParameter(r3, "applicant");
            v.a.d(r3);
            FLogger r4 = FLogger.a;
            TTVideoEngine r0 = e.a;
            r4.i("AudioUrlPlayer", "onMediaInterrupted");
            TTVideoEngine r5 = e.a;
            if (r5 == null) goto L5;
            r5.release();
        L5:
            e.a = null;
            e.a();
            zh8.a.a.getReceiver().c().r6(null);
            AudioServiceDelegate.a.r0().n(PlayStateEnum.PLAY_STATE_STOPPED);
            e.b("interrupt");
        }

        public final void f(MediaResourceManager.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
        }

        public final void a(g r2, float r3) {
            Intrinsics.checkNotNullParameter(r2, "applicant");
            v.a.f(r2, r3);
        }

        public final void d(g r1, g r2) {
            v.a.c(r1, r2);
        }

        public final void g(g r1, float r2) {
            v.a.g(r1, r2);
        }

        public final void i(g r2, g r3) {
            Intrinsics.checkNotNullParameter(r2, "current");
            Intrinsics.checkNotNullParameter(r3, "applicant");
            v.a.e(r2, r3);
            FLogger r4 = FLogger.a;
            TTVideoEngine r5 = e.a;
            r4.i("AudioUrlPlayer", "onMediaPaused");
            TTVideoEngine r6 = e.a;
            if (r6 == null) goto L6;
            r6.pause();
            return;
        }

        public final MediaOccupyStrategy c(g r1, g r2, int r3) {
            return v.a.a(this, r1, r2, r3);
        }

        public final MediaOccupyStrategy h(g r2, g r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "current");
            Intrinsics.checkNotNullParameter(r3, "applicant");
            Map r5 = o0.a;
            boolean r6 = false;
            if (o0.c("IM_TTS", r3.getScene()) == false) goto L19;
            TTVideoEngine r7 = e.a;
            if (Intrinsics.areEqual(r3.getScene(), "dora") == false) goto L16;
            IFlowSdkDepend r8 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r8 == null) goto L13;
            s r9 = r8.s0();
            if (r9 == null) goto L13;
            if (r9.L() != true) goto L13;
            boolean r10 = true;
        L14:
            if (r10 == false) goto L16;
            boolean r11 = true;
        L17:
            if (r11 == false) goto L19;
            r6 = true;
        L13:
            r10 = false;
        L16:
            r11 = false;
        L19:
            if (r6 == false) goto L22;
            return MediaOccupyStrategy.PAUSE;
        L22:
            return MediaOccupyStrategy.INTERRUPT;
        }
    }

    public static void a() {
        c = null;
        d = null;
    }

    static {
        b = new a();
        f = new com.larus.media.model.a(null, "IM_TTS", false, 0, 2, false, 0, false, false, 0, false, new b(), 2021);
    }

    public static void b(String r19) {
        Message r0 = d;
        if (r0 == null) goto L5;
        String r1 = r0.getMessageId();
    L6:
        c1.a(r1, null, null, null, null, null, e, r19, null, null, null, null, null, null, "1", null, null, 114494);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
