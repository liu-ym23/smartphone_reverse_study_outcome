package js1;

import android.view.SurfaceView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.config.zl0;
import com.bytedance.android.livesdk.ktvapi.concert_stage.models.DynamicConcertStatusChangeEventType;
import com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.ConcertStageDataContext;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedNetworkDetectionLinkType;
import com.bytedance.live.datacontext.j;
import com.google.gson.JsonObject;
import dg2.e;
import gd2.f;
import kotlin.jvm.internal.Intrinsics;
import ui6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends vb6.a {
    public final C0396b a;

    public static final class a {
    }

    /* JADX INFO: renamed from: js1.b$b, reason: collision with other inner class name */
    public static final class C0396b extends gd2.a {
        public final /* synthetic */ b a;

        public final void k1() {
            ConcertStageDataContext.a r0 = ConcertStageDataContext.Companion;
            if (r0 == null) goto L19;
            ConcertStageDataContext r1 = r0.getContext();
            if (r1 == null) goto L19;
            j r2 = r1.getLinkComponent();
            if (r2 == null) goto L19;
            js1.a r3 = (js1.a) r2.getValue();
            if (r3 == null) goto L19;
            c r4 = r3.c;
            if (r4 == null) goto L19;
            ei6.a r5 = r4.e.j().Z0();
            if (r5 == null) goto L19;
            d r6 = r5.l();
            if (r6 == null) goto L19;
            mi6.a r7 = r6.b();
            if (r7 == null) goto L19;
            r7.v();
        L19:
            JsonObject r8 = new JsonObject();
            r8.addProperty("sub_type", "chorus");
            r8.addProperty("ntp_time", 0L);
            r8.addProperty("current_time", Long.valueOf(System.currentTimeMillis()));
            b r9 = this.a;
            DynamicConcertStatusChangeEventType r10 = DynamicConcertStatusChangeEventType.onNtpTimeSynchronizationCompleted;
            r9.getClass();
            b.a(r10, r8);
            ALogger.i("ConcertLinkEventManager", "onNtpTimeSynchronizationCompleted, ntp: 0");
        }

        public C0396b(b r1) {
            this.a = r1;
        }

        public final void a(String r4) {
            if (zl0.a.getValue().booleanValue() == true) goto L5;
            return;
        L5:
            ALogger.i("ConcertLinkEventManager", "onFirstRemoteVideoFrameRender, linkId: " + r4);
            JsonObject r0 = new JsonObject();
            r0.addProperty("sub_type", "chorus");
            r0.addProperty("link_id", r4);
            b r1 = this.a;
            DynamicConcertStatusChangeEventType r2 = DynamicConcertStatusChangeEventType.onFirstRemoteVideoFrameDecode;
            r1.getClass();
            b.a(r2, r0);
            xe2.a.b(r4);
        }

        public final void b(String r4) {
            ALogger.i("ConcertLinkEventManager", "onFirstRemoteVideoFrame, linkId: " + r4);
            if (zl0.a.getValue().booleanValue() == false) goto L5;
            return;
        L5:
            JsonObject r0 = new JsonObject();
            r0.addProperty("sub_type", "chorus");
            r0.addProperty("link_id", r4);
            b r1 = this.a;
            DynamicConcertStatusChangeEventType r2 = DynamicConcertStatusChangeEventType.onFirstRemoteVideoFrameDecode;
            r1.getClass();
            b.a(r2, r0);
            xe2.a.b(r4);
        }

        public final void f(String r4) {
            if (zl0.a.getValue().booleanValue() == true) goto L5;
            return;
        L5:
            ALogger.i("ConcertLinkEventManager", "onFirstRemoteVideoFrameRender, linkId: " + r4);
            JsonObject r0 = new JsonObject();
            r0.addProperty("sub_type", "chorus");
            r0.addProperty("link_id", r4);
            b r1 = this.a;
            DynamicConcertStatusChangeEventType r2 = DynamicConcertStatusChangeEventType.onFirstRemoteVideoFrameDecode;
            r1.getClass();
            b.a(r2, r0);
            xe2.a.b(r4);
        }

        public final void Z4(String r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "interactId");
            JsonObject r5 = new JsonObject();
            r5.addProperty("sub_type", "chorus");
            r5.addProperty("audio_device_loop_delay", Integer.valueOf(r4));
            b r6 = this.a;
            DynamicConcertStatusChangeEventType r0 = DynamicConcertStatusChangeEventType.onAudioDeviceLoopDelayUpdate;
            r6.getClass();
            b.a(r0, r5);
        }

        public final void d(String r3, SurfaceView r4) {
            ALogger.i("ConcertLinkEventManager", "onFirstRemoteVideoFrame, linkId: " + r3);
            if (zl0.a.getValue().booleanValue() == false) goto L5;
            return;
        L5:
            JsonObject r5 = new JsonObject();
            r5.addProperty("sub_type", "chorus");
            r5.addProperty("link_id", r3);
            b r0 = this.a;
            DynamicConcertStatusChangeEventType r1 = DynamicConcertStatusChangeEventType.onFirstRemoteVideoFrameDecode;
            r0.getClass();
            b.a(r1, r5);
            xe2.a.b(r3);
        }

        public final void d5(e r3, e[] r4) {
            Intrinsics.checkNotNullParameter(r3, "localQuality");
            Intrinsics.checkNotNullParameter(r4, "remoteQualities");
            JsonObject r5 = new JsonObject();
            r5.addProperty("sub_type", "chorus");
            r5.addProperty("rtt", 0);
            r5.addProperty("fraction_lost", Double.valueOf(0.0d));
            r5.addProperty("tx_quality", 0);
            b r6 = this.a;
            DynamicConcertStatusChangeEventType r0 = DynamicConcertStatusChangeEventType.onNetworkQuality;
            r6.getClass();
            b.a(r0, r5);
        }

        public final void g(String r5, Boolean r6) {
            Intrinsics.checkNotNullParameter(r5, "interactId");
            if (r5.length() != 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L15;
            if (r6 != null) goto L9;
            return;
        L9:
            if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L12;
            return;
        L12:
            if (Intrinsics.areEqual(r5, KtvSettingHelper.p().getAccompanimentRobotPrefix() + je0.d.a()) == false) goto L17;
            JsonObject r2 = new JsonObject();
            r2.addProperty("sub_type", "chorus");
            r2.addProperty("interactId", r5);
            r2.addProperty("mute", r6);
            ALogger.i("ConcertLinkEventManager", "onRemoteAudioMute, interactId: " + r5 + ", mute: " + r6);
            b r7 = this.a;
            DynamicConcertStatusChangeEventType r8 = DynamicConcertStatusChangeEventType.onUserPublishStreamAudio;
            r7.getClass();
            b.a(r8, r2);
            return;
        L17:
            return;
        L15:
            return;
        L5:
            r1 = false;
            goto L6
        }

        public final void x1(LiveWrappedNetworkDetectionLinkType r3, int r4, double r5) {
            Intrinsics.checkNotNullParameter(r3, "type");
            JsonObject r6 = new JsonObject();
            r6.addProperty("sub_type", "chorus");
            r6.addProperty("rtt", Integer.valueOf(r4));
            r6.addProperty("fraction_lost", Double.valueOf(r5));
            b r7 = this.a;
            DynamicConcertStatusChangeEventType r8 = DynamicConcertStatusChangeEventType.onNetworkDetectionResult;
            r7.getClass();
            b.a(r8, r6);
        }
    }

    static {
    }

    public final void H1() {
        a(DynamicConcertStatusChangeEventType.onRtcLinkSuccess, new JsonObject());
    }

    public final void M1() {
        a(DynamicConcertStatusChangeEventType.onRtcLeaveSuccess, new JsonObject());
    }

    public final void Y4() {
        a(DynamicConcertStatusChangeEventType.onRtcAdvanceLinkSuccess, new JsonObject());
    }

    public final void k4() {
        a(DynamicConcertStatusChangeEventType.onRtcLinkSuccessPre, new JsonObject());
    }

    public b() {
        this.a = new C0396b(this);
    }

    public static void a(DynamicConcertStatusChangeEventType r2, JsonObject r3) {
        f r0 = ConcertStageDataContext.Companion.a();
        if (r0 == null) goto L6;
        r0.e(new hd2.b(r2, r3));
        return;
    }

    public final void Zk(long r2, ei6.a r4) {
        Intrinsics.checkNotNullParameter(r4, "client");
        JsonObject r5 = new JsonObject();
        r5.addProperty("duration", Long.valueOf(r2));
        a(DynamicConcertStatusChangeEventType.onRtcInitSuccess, r5);
    }

    public final void u4(long r2, ec6.a r4) {
        Intrinsics.checkNotNullParameter(r4, "client");
        JsonObject r5 = new JsonObject();
        r5.addProperty("duration", Long.valueOf(r2));
        a(DynamicConcertStatusChangeEventType.onLiveClientInitSuccess, r5);
    }
}
