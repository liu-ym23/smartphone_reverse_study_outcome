package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import android.app.Activity;
import android.os.SystemClock;
import com.bytedance.lark.oggopus_rust_android.OggOpusCodecError;
import com.bytedance.lark.oggopus_rust_android.OggOpusEncoder;
import com.bytedance.lark.oggopus_rust_android.OggOpusEncoderInputInfo;
import com.google.gson.Gson;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.officesdk.api.init.IDeviceInfoProvider;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.rtc.RecordingRtcOperation;
import com.ss.android.lark.officesdk.minutes.api.recording.common.external_audio.ExternalAudioSourceMode;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmRecordGeneralConfig;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.configs.MmRecordingRemoteAudioSetting;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.MmRecordingAudioCaptureMode;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.MmRtcInitInfo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.MmRtcWrapper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.MmAIInterpretationRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.MmStandaloneAIInterpretationRootRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.i;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.l;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import com.ss.android.lark.pb.minutes.v1.MinutesRecordingStartResponse;
import com.ss.android.lark.pb.videochat.Bandwidth;
import com.ss.android.lark.pb.videochat.GetAdminSettingsResponse;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.e0;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.h;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.g;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingAudioService {
    public static final /* synthetic */ int G = 0;
    public volatile long A;
    public volatile String B;
    public final Lazy C;
    public Job D;
    public final ConcurrentHashMap<RecordingRtcOperation, Long> E;
    public MmExternalAudioCapturePipeline F;
    public final MmRecordingSession a;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a b;
    public final MmRecordingAudioCaptureMode c;
    public final sub.b d;
    public final String e;
    public final f f;
    public final CoroutineScope g;
    public final CoroutineScope h;
    public final Lazy i;
    public final Channel<ovb.a> j;
    public final StateFlowImpl k;
    public final b1 l;
    public final StateFlowImpl m;
    public final b1 n;
    public long o;
    public long p;
    public boolean q;
    public long r;
    public boolean s;
    public volatile com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.a t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final MmRtcWrapper x;
    public volatile MmRtcInitInfo y;
    public volatile boolean z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmRecordingAudioCaptureMode.values().length];
            r0[MmRecordingAudioCaptureMode.EXTERNAL_AUDIO_SOURCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MmRecordingAudioCaptureMode.RTC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements nub.c {
        public final /* synthetic */ MmRecordingAudioService a;

        public c(MmRecordingAudioService r1) {
            this.a = r1;
        }

        @Override // nub.c
        public final void a(nub.d r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            MmRecordingAudioService.a(this.a, r2);
        }
    }

    static {
    }

    public final MmRecordingAudioPersistent d() {
        return (MmRecordingAudioPersistent) this.u.getValue();
    }

    public final void h() {
        if (this.c != MmRecordingAudioCaptureMode.EXTERNAL_AUDIO_SOURCE) goto L15;
        MmExternalAudioCapturePipeline r0 = this.F;
        if (r0 == null) goto L7;
        r0.g();
    L7:
        ExternalAudioSourceMode r1 = null;
        this.F = null;
        this.k.setValue(0);
        sub.b r2 = this.d;
        if (r2 == null) goto L11;
        r1 = r2.b();
    L11:
        if (r1 != ExternalAudioSourceMode.ENCODED_PUSH) goto L13;
        this.x.k(false);
    L14:
        lvb.a.e(this.e, "[stopAudioCaptureForEnd] external audio source mode");
    L16:
        this.x.h();
        this.x.d();
        return;
    L13:
        this.x.l(false);
        goto L14
    L15:
        this.x.p();
        lvb.a.e(this.e, "[stopAudioCaptureForEnd] rtc capture mode");
        goto L16
    }

    public final void k() {
        this.D = BuildersKt.launch$default(this.h, (CoroutineDispatcher) this.i.getValue(), null, new MmRecordingAudioService$rtcPreload$1(this, null), 2, null);
    }

    public final boolean l() {
        MmRecordingRemoteAudioSetting r0 = this.b.getSettingsService().b;
        String r1 = this.e;
        StringBuilder r2 = new StringBuilder("[audioFormat][captureStart] traceId=");
        r2.append(this.a.c);
        r2.append(", recordingId=");
        r2.append(this.a.e());
        r2.append(", captureMode=");
        MmRecordingAudioCaptureMode r3 = this.c;
        MmRecordingAudioCaptureMode r4 = MmRecordingAudioCaptureMode.EXTERNAL_AUDIO_SOURCE;
        if (r3 != r4) goto L5;
        String r5 = PickerReporterConstants.VALUE.CLICK.EXTERNAL;
    L6:
        r2.append(r5);
        r2.append(", formatId=");
        r2.append(System.identityHashCode(this.f));
        r2.append(", sampleRate=");
        r2.append(this.f.a);
        r2.append(", channelCount=");
        r2.append(this.f.b);
        r2.append(", currentSampleRate=");
        r2.append(r0.getMmAudioSampleRate());
        r2.append(", currentChannelCount=");
        r2.append(r0.getMmAudioChannel());
        lvb.a.e(r1, r2.toString());
        boolean r6 = true;
        if (this.c != r4) goto L60;
        MmExternalAudioCapturePipeline r7 = this.F;
        boolean r8 = false;
        if (r7 != null) goto L47;
        lvb.a.e(this.e, "[startAudioCapture] creating external audio source capture");
        f r10 = this.f;
        sub.b r9 = this.d;
        if (r9 != null) goto L13;
        r9 = new com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.a();
    L13:
        MmExternalAudioCapturePipeline r11 = new MmExternalAudioCapturePipeline(r10, r9, new MmRecordingAudioService$startAudioCapture$1(this), new MmRecordingAudioService$startAudioCapture$2(this.x), new MmRecordingAudioService$startAudioCapture$3(this));
        this.F = r11;
        lvb.a.e("MmExternalAudioCapturePipeline", "[encoded audio][startCapture] source=" + r11.b.getClass().getSimpleName() + ", mode=" + r11.b.b() + ", formatId=" + System.identityHashCode(r11.a) + ", sampleRate=" + r11.e() + ", channel=" + r11.b());
        sub.b.C0190b r12 = r11.b.d(new sub.b.a(r11.e(), r11.b()));
        if (r12.a == true) goto L16;
        lvb.a.b("MmExternalAudioCapturePipeline", "Failed to init ExternalAudioSource: " + r12.c);
        qvb.a r13 = qvb.a.a;
        qvb.a.b(null, "local_capture_init_failed:" + r12.c, r11.b.getClass().getSimpleName(), null, 9);
    L43:
        lvb.a.e(this.e, "[startAudioCapture] external audio source mode, init success=" + r8);
        if (r8 == true) goto L46;
        this.F = null;
        q(this, "capture", "failed", "local_capture_return", null, i(RecordingRtcOperation.CAPTURE), 40);
    L46:
        return r8;
    L16:
        int r14 = MmExternalAudioCapturePipeline.b.a[r11.b.b().ordinal()];
        if (r14 == 1) goto L34;
        if (r14 != 2) goto L20;
        r11.b.a();
        sub.b.c r15 = r11.b.startCapture();
        if (r15.a == true) goto L33;
        lvb.a.b("MmExternalAudioCapturePipeline", "Failed to start PCM push ExternalAudioSource: " + r15.b);
        r11.b.a();
        r11.b.close();
    L40:
        r6 = false;
    L42:
        r8 = r6;
        goto L43
    L33:
        r11.i = false;
        lvb.a.e("MmExternalAudioCapturePipeline", "PCM push ExternalAudioSource started successfully");
        goto L42
    L20:
        if (r14 != 3) goto L22;
        r11.b.c();
        sub.b.c r16 = r11.b.startCapture();
        if (r16.a == true) goto L29;
        lvb.a.b("MmExternalAudioCapturePipeline", "Failed to start encoded push ExternalAudioSource: " + r16.b);
        r11.b.c();
        r11.b.close();
        goto L40
    L29:
        r11.i = false;
        lvb.a.e("MmExternalAudioCapturePipeline", "[encoded audio][startEncodedPushCapture] ExternalAudioSource started successfully");
        goto L42
    L22:
        if (r14 != 4) goto L25;
        lvb.a.b("MmExternalAudioCapturePipeline", "Encoded pull ExternalAudioSource is not supported");
        r11.b.close();
        goto L40
    L25:
        throw new NoWhenBranchMatchedException();
    L34:
        int r17 = r12.b;
        r11.w = r17;
        if (r17 > 0) goto L37;
        lvb.a.b("MmExternalAudioCapturePipeline", "Invalid bufferSize from ExternalAudioSource: " + r11.w);
        qvb.a r18 = qvb.a.a;
        qvb.a.b(null, "local_capture_init_failed:invalid_buffer_size", r11.b.getClass().getSimpleName(), null, 9);
        r11.b.close();
        goto L40
    L37:
        r11.w = Math.max(r17 * 2, 4096);
        sub.b.c r19 = r11.b.startCapture();
        if (r19.a == true) goto L41;
        lvb.a.b("MmExternalAudioCapturePipeline", "Failed to start ExternalAudioSource: " + r19.b);
        qvb.a r20 = qvb.a.a;
        qvb.a.b(null, "local_capture_start_failed:" + r19.b, r11.b.getClass().getSimpleName(), null, 9);
        r11.b.close();
        goto L40
    L41:
        r11.i = false;
        lvb.a.e("MmExternalAudioCapturePipeline", "ExternalAudioSource started successfully, sampleRate=" + r11.e() + ", bufferSize=" + r11.w + ", rtcFrameSamples=" + r11.d() + ", rtcFrameBytes=" + r11.c());
        r11.f = BuildersKt.launch$default(r11.h, null, null, new MmExternalAudioCapturePipeline$startCaptureLoop$1(r11, null), 3, null);
        goto L42
    L47:
        lvb.a.e("MmExternalAudioCapturePipeline", "resumeCapture");
        sub.b.c r21 = r7.b.startCapture();     // Catch: Exception -> L53
        if (r21.a == true) goto L51;
        lvb.a.b("MmExternalAudioCapturePipeline", "Failed to resume ExternalAudioSource: " + r21.b);     // Catch: Exception -> L53
        qvb.a r22 = qvb.a.a;     // Catch: Exception -> L53
        qvb.a.b(null, "local_capture_resume_failed:" + r21.b, r7.b.getClass().getSimpleName(), null, 9);     // Catch: Exception -> L53
    L62:
    L58:
        lvb.a.e(this.e, "[startAudioCapture] external audio source mode, resume success");
        return true;
    L51:
        r7.i = false;     // Catch: Exception -> L53
        r7.j = false;     // Catch: Exception -> L53
        r7.k = false;     // Catch: Exception -> L53
        lvb.a.e("MmExternalAudioCapturePipeline", "resumeCapture success");     // Catch: Exception -> L53
    L53:
        e = move-exception;
        lvb.a.b("MmExternalAudioCapturePipeline", "Error resuming ExternalAudioSource: " + e);
        qvb.a r23 = qvb.a.a;
        String r24 = e.getMessage();
        if (r24 != null) goto L57;
        r24 = "";
    L57:
        qvb.a.b(null, "local_capture_resume_failed:".concat(r24), e.getClass().getSimpleName(), null, 9);
        goto L58
    L60:
        this.x.o(new MmRecordingAudioService$startAudioCapture$4(this));
        return true;
    L5:
        r5 = "rtc";
        goto L6
    }

    public final void m() {
        if (this.c != MmRecordingAudioCaptureMode.EXTERNAL_AUDIO_SOURCE) goto L18;
        MmExternalAudioCapturePipeline r0 = this.F;
        if (r0 == null) goto L17;
        lvb.a.e("MmExternalAudioCapturePipeline", "pauseCapture");
        r0.i = true;
        r0.j = false;
        Object r2 = r0.m;
        monitor-enter(r2);
        r0.r = new byte[0];     // Catch: Throwable -> L14
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r2);
        r0.b.pause();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        lvb.a.b("MmExternalAudioCapturePipeline", "Error pausing ExternalAudioSource: " + e);
    L14:
        th = move-exception;
        throw th;
    L17:
        this.k.setValue(0);
        lvb.a.e(this.e, "[stopAudioCapture] external audio source mode");
        return;
    L18:
        this.x.p();
    }

    public final String e() {
        VFSFile r0 = d().f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAbsolutePath();
    }

    public final Object c(Continuation<? super Unit> r12) {
        final j r0 = new j(IntrinsicsKt.intercepted(r12), 1);
        r0.C();
        sub.b r1 = this.d;
        if (r1 == null) goto L5;
        ExternalAudioSourceMode r2 = r1.b();
    L7:
        if (r2 != ExternalAudioSourceMode.ENCODED_PUSH) goto L17;
        MmRecordingEncodedAudioProcessor r3 = (MmRecordingEncodedAudioProcessor) this.w.getValue();
        Function0<Unit> r4 = new MmRecordingAudioService$flushRemainingData$2$1(r0);
        Object r5 = r3.f.trySend-JP2dKIU(new MmRecordingEncodedAudioProcessor.a(r4));
        g.c r6 = g.b;
        if ((r5 instanceof g.c) == false) goto L18;
        lvb.a.b(r3.c, "flushRemainingData failed to send flush signal");
        qvb.a r7 = qvb.a.a;
        Throwable r8 = g.a(r5);
        if (r8 == null) goto L13;
        String r9 = r8.getClass().getSimpleName();
    L14:
        if (r9 != null) goto L16;
        r9 = "";
    L16:
        qvb.a.b(null, "encoded_channel_flush_failed", r9, null, 9);
        r4.invoke();
        goto L18
    L13:
        r9 = null;
    L18:
        Object r10 = r0.B();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        DebugProbesKt.probeCoroutineSuspended(r12);
    L22:
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        return r10;
    L25:
        return Unit.INSTANCE;
    L17:
        MmRecordingAudioProcessor r11 = (MmRecordingAudioProcessor) this.v.getValue();
        BuildersKt.launch$default((CoroutineScope) r11.f.getValue(), null, null, new MmRecordingAudioProcessor$flushRemainingData$1(r11, new MmRecordingAudioService$flushRemainingData$2$2(r0), null), 3, null);
        goto L18
    L5:
        r2 = null;
        goto L7
    }

    public final Long i(RecordingRtcOperation r5) {
        Long r6 = this.E.remove(r5);
        if (r6 == null) goto L6;
        long r0 = r6.longValue();
        return Long.valueOf(RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - r0, 0));
    L6:
        return null;
    }

    public final Object j(Continuation<? super Result<Boolean>> r7) {
        if ((r7 instanceof MmRecordingAudioService$resumeRtcTransmission$1) == false) goto L7;
        MmRecordingAudioService$resumeRtcTransmission$1 r1 = (MmRecordingAudioService$resumeRtcTransmission$1) r7;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r8 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L16;
        if (r4 != 1) goto L15;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.a r5 = (com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.a) r1.L$1;
        MmRecordingAudioService r6 = (MmRecordingAudioService) r1.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L50
    L24:
        if (((Boolean) r8).booleanValue() == false) goto L47;
        sub.b r9 = r6.d;     // Catch: Throwable -> L50
        if (r9 == null) goto L28;
        ExternalAudioSourceMode r10 = r9.b();     // Catch: Throwable -> L50
    L30:
        if (r10 != ExternalAudioSourceMode.ENCODED_PUSH) goto L32;
        boolean r11 = true;
    L33:
        if (r11 == false) goto L35;
        r6.x.p();     // Catch: Throwable -> L50
        r6.x.k(true);     // Catch: Throwable -> L50
    L35:
        r6.x.g(r5);     // Catch: Throwable -> L50
        if (r11 == true) goto L38;
        r6.x.l(true);     // Catch: Throwable -> L50
    L38:
        String r12 = r6.a.w.a;     // Catch: Throwable -> L50
        if ((!StringsKt.isBlank(r12)) == false) goto L45;
        nub.a r13 = r6.b.t(r12);     // Catch: Throwable -> L50
        MmExternalAudioCapturePipeline r14 = r6.F;     // Catch: Throwable -> L50
        if (r14 == null) goto L43;
        r14.f(r13);     // Catch: Throwable -> L50
    L43:
        lvb.a.e(r6.e, "[resumeRtcTransmission] success, meetingId=" + r12);     // Catch: Throwable -> L50
        Object r15 = Result.constructor-impl(Boxing.boxBoolean(true));     // Catch: Throwable -> L50
    L52:
        Throwable r0 = Result.exceptionOrNull-impl(r15);
        if (r0 == null) goto L55;
        lvb.a.b(this.e, "[resumeRtcTransmission] failed: " + r0);
    L55:
        return r15;
    L45:
        throw new IllegalStateException("meetingId is empty".toString());     // Catch: Throwable -> L50
    L32:
        r11 = false;
        goto L33
    L28:
        r10 = null;
        goto L30
    L47:
        throw new IllegalStateException("RTC SDK init failed".toString());     // Catch: Throwable -> L50
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r8);
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L50
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.a r17 = this.t;     // Catch: Throwable -> L50
        if (r17 == null) goto L49;
        MmRtcInitInfo r18 = r17.b;     // Catch: Throwable -> L50
        r1.L$0 = this;     // Catch: Throwable -> L50
        r1.L$1 = r17;     // Catch: Throwable -> L50
        r1.label = 1;     // Catch: Throwable -> L50
        Object r19 = g(r18, "reinitialize", r1);     // Catch: Throwable -> L50
        if (r19 != r3) goto L22;
        return r3;
    L22:
        r5 = r17;
        r8 = r19;
        r6 = this;
        goto L24
    L49:
        throw new IllegalStateException("rtcData is null".toString());     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r1 = new MmRecordingAudioService$resumeRtcTransmission$1(this, r7);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(MmRecordingAudioService r10, nub.d r11) {
        r10.getClass();
        if ((r11 instanceof nub.d.c) == false) goto L6;
        lvb.a.e(r10.e, "[joinChannel] Success");
        return;
    L6:
        if ((r11 instanceof nub.d.a) == false) goto L8;
        String r0 = r10.e;
        StringBuilder r1 = new StringBuilder("rtc error, code=");
        nub.d.a r12 = (nub.d.a) r11;
        r1.append(r12.a);
        lvb.a.b(r0, r1.toString());
        o(r10, "rtc", Integer.valueOf(r12.a), "rtc_error_callback", null, 8);
        return;
    L8:
        String r2 = "";
        Object r3 = null;
        if ((r11 instanceof nub.d.h) == false) goto L21;
        nub.d.h r13 = (nub.d.h) r11;
        String r4 = r13.a.getValue();
        String r6 = r13.c;
        String r5 = r2;
        if (r13.a != RecordingRtcOperation.INIT) goto L13;
        r5 = r10.B;
    L13:
        String r7 = r5;
        if (Intrinsics.areEqual(r13.c, "engine_state") == false) goto L16;
    L19:
        r10.p(r4, "failed", r6, r7, r3, Integer.valueOf(r13.b));
        return;
    L16:
        if (Intrinsics.areEqual(r13.c, "invalid_parameter") == true) goto L19;
        r3 = r10.i(r13.a);
        goto L19
    L21:
        if ((r11 instanceof nub.d.g) == false) goto L27;
        nub.d.g r14 = (nub.d.g) r11;
        r10.E.put(r14.a, Long.valueOf(SystemClock.elapsedRealtime()));
        String r8 = r14.a.getValue();
        String r9 = r2;
        if (r14.a != RecordingRtcOperation.INIT) goto L25;
        r9 = r10.B;
    L25:
        q(r10, r8, "rtc_api_called", "rtc_service", r9, null, 48);
        return;
    L27:
        if ((r11 instanceof nub.d.n) == false) goto L30;
        BuildersKt.launch$default(r10.g, null, null, new MmRecordingAudioService$handleRtcEvent$1(r10, null), 3, null);
        return;
    L30:
        if ((r11 instanceof nub.d.f) == false) goto L32;
        BuildersKt.launch$default(r10.g, null, null, new MmRecordingAudioService$handleRtcEvent$2(r10, r11, null), 3, null);
        return;
    L32:
        int r15 = 0;
        if ((r11 instanceof nub.d.C0169d) == false) goto L41;
        oub.a r16 = ((nub.d.C0169d) r11).a;
        if (r16 == null) goto L37;
        r15 = r16.c;
    L37:
        lvb.a.a(r10.e, "LocalAudioVolumeIndication: " + r15);
        if (((Number) r10.k.getValue()).intValue() == r15) goto L110;
        r10.k.setValue(Integer.valueOf(r15));
        return;
    L110:
        return;
    L41:
        if ((r11 instanceof nub.d.i) == false) goto L61;
        byte[] r17 = ((nub.d.i) r11).a;
        if (r17 != null) goto L45;
        return;
    L45:
        if (r10.c == MmRecordingAudioCaptureMode.EXTERNAL_AUDIO_SOURCE) goto L47;
    L59:
        BuildersKt.launch$default((CoroutineScope) ((MmRecordingAudioProcessor) r10.v.getValue()).f.getValue(), null, null, new MmRecordingAudioService$handleRtcEvent$3(r10, r17, null), 3, null);
        return;
    L47:
        if (r17.length < 2) goto L57;
        double r18 = 0.0d;
        int r19 = 0;
        int r20 = 0;
    L50:
        int r21 = r19 + 1;
        if (r21 >= r17.length) goto L53;
        double r22 = ((double) ((short) ((r17[r21] << 8) | (r17[r19] & 255)))) / 32767.0d;
        r18 = r18 + (r22 * r22);
        r20 = r20 + 1;
        r19 = r19 + 2;
        goto L50
    L53:
        if (r20 == 0) goto L57;
        r15 = RangesKt.coerceIn((int) ((Math.sqrt(r18 / ((double) r20)) * 2.5d) * ((double) 255)), 0, 255);
    L57:
        if (((Number) r10.k.getValue()).intValue() == r15) goto L59;
        r10.k.setValue(Integer.valueOf(r15));
        goto L59
    L61:
        if ((r11 instanceof nub.d.e) == false) goto L64;
        BuildersKt.launch$default(r10.g, null, null, new MmRecordingAudioService$handleRtcEvent$4(r10, r11, null), 3, null);
        return;
    L64:
        if ((r11 instanceof nub.d.k) == false) goto L83;
        long r23 = System.currentTimeMillis();
        if ((r23 - r10.r) < 300000) goto L115;
        r10.r = r23;
        Set<String> r110 = qvb.b.a;
        nub.d.k r111 = (nub.d.k) r11;
        float r112 = r111.b;
        float r24 = r111.c;
        float r113 = r111.d;
        yub.d r25 = yub.d.a;     // Catch: Exception -> L80
        Activity r26 = com.ss.android.lark.appcontext.applifecycle2.api.a.a();     // Catch: Exception -> L80
        Set<String> r27 = qvb.b.a;     // Catch: Exception -> L80
        if (r26 == null) goto L71;
        String r28 = r26.getClass().getName();     // Catch: Exception -> L80
    L72:
        boolean r29 = CollectionsKt.contains(r27, r28);     // Catch: Exception -> L80
        MmRecordingCommonParam r30 = qvb.b.c;     // Catch: Exception -> L80
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r31 = new com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d();     // Catch: Exception -> L80
        r31.e("action_name", "recording_perf_usage");     // Catch: Exception -> L80
        float r32 = 100;
        r31.e("app_cpu_usage", String.valueOf((int) (r112 * r32)));     // Catch: Exception -> L80
        r31.e("system_cpu_usage", String.valueOf((int) (r24 * r32)));     // Catch: Exception -> L80
        r31.e("total_memory_usage", String.valueOf((int) r113));     // Catch: Exception -> L80
        MmRecordingSource r114 = r30.getSource();     // Catch: Exception -> L80
        if (r114 == null) goto L75;
        r3 = r114.getValue();     // Catch: Exception -> L80
    L75:
        if (r3 != null) goto L77;
        String r33 = r2;
    L78:
        r31.e("source", r33);     // Catch: Exception -> L80
        r31.e("conversation_id", qvb.b.d);     // Catch: Exception -> L80
        r31.e("message_id", qvb.b.e);     // Catch: Exception -> L80
        r31.e("is_recording_page", String.valueOf(r29));     // Catch: Exception -> L80
        r31.f(r30.asRecordingDevTrackerParams().a());     // Catch: Exception -> L80
        JSONObject r115 = r31.a();     // Catch: Exception -> L80
        lvb.a.e("MmRecordingPerfTracker", "[trackRecordingPerfUsage] params=" + r115);     // Catch: Exception -> L80
        int r116 = com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.n;     // Catch: Exception -> L80
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.a.b(r115);     // Catch: Exception -> L80
        return;
    L77:
        r33 = r3;
        goto L78
    L71:
        r28 = null;
    L80:
        e = move-exception;
        lvb.a.b("MmRecordingPerfTracker", "[trackRecordingPerfUsage] failed, error=" + e);
        return;
    L115:
        return;
    L83:
        if ((r11 instanceof nub.d.j) == false) goto L117;
        MmRecordingSession r34 = r10.a;
        if (r34.a != RecordingSessionType.SOFTWARE_RECORDING) goto L93;
        MmRecordingRepo r35 = r34.f();
        if (r35 == null) goto L93;
        MmAIInterpretationRepo r36 = r35.q();
        if (r36 == null) goto L93;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a r37 = r36.n();
        if (r37 == null) goto L93;
        r37.i(((nub.d.j) r11).a);
    L93:
        MmStandaloneAIInterpretationRootRepo r117 = r10.a.h();
        if (r117 == null) goto L118;
        MmStandaloneAIInterpretationRepo r118 = r117.a();
        if (r118 == null) goto L119;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.a r119 = r118.t();
        if (r119 == null) goto L120;
        r119.i(((nub.d.j) r11).a);
        return;
    L120:
        return;
    L119:
        return;
    L118:
        return;
    }

    public final Object f(MinutesRecordingStartResponse r6, Continuation<? super Result<Boolean>> r7) {
        if ((r7 instanceof MmRecordingAudioService$initRtc$1) == false) goto L7;
        MmRecordingAudioService$initRtc$1 r0 = (MmRecordingAudioService$initRtc$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L18:
        return ((Result) r8).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        CoroutineDispatcher r9 = (CoroutineDispatcher) this.i.getValue();
        MmRecordingAudioService$initRtc$2 r4 = new MmRecordingAudioService$initRtc$2(this, r6, null);
        r0.label = 1;
        r8 = BuildersKt.withContext(r9, r4, r0);
        if (r8 != r2) goto L18;
        return r2;
    L7:
        r0 = new MmRecordingAudioService$initRtc$1(this, r7);
        goto L8
    }

    public final Object r(MinutesRecordingStartResponse r17, Continuation<? super Result<Boolean>> r18) {
        MinutesRecordingStartResponse r0 = r17;
        if ((r18 instanceof MmRecordingAudioService$updateRtcConfig$1) == false) goto L7;
        MmRecordingAudioService$updateRtcConfig$1 r4 = (MmRecordingAudioService$updateRtcConfig$1) r18;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r2 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        boolean r8 = false;
        if (r7 == 0) goto L16;
        if (r7 != 1) goto L15;
        r0 = (MinutesRecordingStartResponse) r4.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L69
    L52:
        lvb.a.e(this.e, "updateRtcConfig: RTC SDK initialized");     // Catch: Throwable -> L69
        sub.b r3 = this.d;     // Catch: Throwable -> L69
        if (r3 == null) goto L55;
        ExternalAudioSourceMode r9 = r3.b();     // Catch: Throwable -> L69
    L57:
        if (r9 != ExternalAudioSourceMode.ENCODED_PUSH) goto L59;
        r8 = true;
    L59:
        if (r8 == false) goto L61;
        this.x.p();     // Catch: Throwable -> L69
        this.x.k(true);     // Catch: Throwable -> L69
        lvb.a.e(this.e, "updateRtcConfig: encoded external audio device mode enabled before join");     // Catch: Throwable -> L69
    L61:
        this.x.g(this.t);     // Catch: Throwable -> L69
        lvb.a.e(this.e, "updateRtcConfig: joined RTC room");     // Catch: Throwable -> L69
        if (r8 == true) goto L64;
        this.x.l(true);     // Catch: Throwable -> L69
        lvb.a.e(this.e, "updateRtcConfig: external audio device mode enabled");     // Catch: Throwable -> L69
    L64:
        String r1 = r0.session_id;     // Catch: Throwable -> L69
        com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r10 = this.b;     // Catch: Throwable -> L69
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L69
        nub.a r11 = r10.t(r1);     // Catch: Throwable -> L69
        MmExternalAudioCapturePipeline r12 = this.F;     // Catch: Throwable -> L69
        if (r12 == null) goto L67;
        r12.f(r11);     // Catch: Throwable -> L69
    L67:
        lvb.a.e(this.e, "updateRtcConfig: local capture connected to RTC, meetingId=" + r1);     // Catch: Throwable -> L69
        return Result.constructor-impl(Boxing.boxBoolean(true));
    L55:
        r9 = null;
        goto L57
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r2);
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L69
        lvb.a.e(this.e, "updateRtcConfig: initializing RTC for external audio input");     // Catch: Throwable -> L69
        Gson r14 = e0.a;     // Catch: Throwable -> L69
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.b r15 = (com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.b) e0.a(r0.rtc_info, com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.b.class);     // Catch: Throwable -> L69
        if (r15 != null) goto L22;
        return Result.constructor-impl(ResultKt.createFailure(new Throwable("rtc_info is null")));
    L22:
        if (this.b.y().isFeishuBrand() == true) goto L33;
        GetAdminSettingsResponse r16 = this.b.E().e;     // Catch: Throwable -> L69
        if (r16 == null) goto L30;
        List<String> r19 = r16.mspeed_up_nodes;     // Catch: Throwable -> L69
        if (r19 == null) goto L30;
        if (r19.contains("china") != true) goto L30;
        boolean r20 = true;
    L31:
        if (r20 == false) goto L33;
        boolean r110 = true;
    L35:
        if (this.b.y().isChinaMainlandGeo() == true) goto L37;
        boolean r21 = true;
    L38:
        int r111 = (int) r0.vendor_type.longValue();     // Catch: Throwable -> L69
        String r112 = r0.rtc_app_id;     // Catch: Throwable -> L69
        String r113 = r0.business_id;     // Catch: Throwable -> L69
        if (r113 != null) goto L41;
        r113 = "";
    L41:
        String r114 = r113;
        if (r21 == false) goto L44;
        boolean r22 = true;
    L45:
        MmRtcInitInfo r115 = new MmRtcInitInfo(r111, r112, r114, r110, r22);     // Catch: Throwable -> L69
        GetAdminSettingsResponse r116 = this.b.E().e;     // Catch: Throwable -> L69
        if (r116 == null) goto L48;
        Bandwidth r117 = r116.mbandwidth;     // Catch: Throwable -> L69
    L49:
        this.t = new com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.a(r15, r115, r117);     // Catch: Throwable -> L69
        r4.L$0 = r0;     // Catch: Throwable -> L69
        r4.label = 1;     // Catch: Throwable -> L69
        if (g(r115, "direct", r4) != r6) goto L52;
        return r6;
    L48:
        r117 = null;
        goto L49
    L44:
        r22 = false;
        goto L45
    L37:
        r21 = false;
    L30:
        r20 = false;
    L33:
        r110 = false;
    L69:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r4 = new MmRecordingAudioService$updateRtcConfig$1(this, r18);
        goto L8
    }

    public final boolean b(String r23, MmRecordingSource r24, boolean r25) {
        Intrinsics.checkNotNullParameter(r23, "meetingId");
        MmRecordingAudioPersistent r3 = d();
        String r5 = this.b.getCurrentUserId();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "userId");
        Intrinsics.checkNotNullParameter(r23, "meetingId");
        if (r25 == false) goto L5;
        boolean r9 = true;
    L10:
        MmRecordingRemoteAudioSetting r0 = r3.a.getSettingsService().b;
        lvb.a.e(r3.c, "[audioFormat][persistentInit] meetingId=" + r23 + ", keepFullFile=" + r9 + ", formatId=" + System.identityHashCode(r3.b) + ", sampleRate=" + r3.b.a + ", channelCount=" + r3.b.b + ", currentSampleRate=" + r0.getMmAudioSampleRate() + ", currentChannelCount=" + r0.getMmAudioChannel());
        File r1 = r3.e;
        if (r1 != null) goto L13;
    L15:
        boolean r2 = false;
    L16:
        if (r2 == true) goto L94;
        MmRecordFileHelper.a.getClass();
        VFSFile r4 = MmRecordFileHelper.f(r5, r23);
        if (r4.mkdirs() == false) goto L21;
    L23:
        r3.g = new com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.b(r23);
        r3.e = r4;
        if (r9 == true) goto L98;
        OggOpusEncoder r6 = r3.h;
        if (r6 == null) goto L43;
        r6.finish();
    L43:
        r3.h = null;
    L44:
        VFSFile r7 = null;
    L45:
        r3.f = r7;
        if (r9 == false) goto L91;
        if (r7 == null) goto L49;
        String r8 = r7.getAbsolutePath();
    L50:
        if (r8 != null) goto L52;
    L55:
        boolean r10 = true;
    L56:
        if (r10 == true) goto L91;
        OggOpusEncoder r11 = r3.h;
        if (r11 == null) goto L60;
        r11.finish();
    L60:
        f r12 = r3.b;
        long r13 = r12.a;
        long r14 = r12.b;
        if (r14 != 1) goto L63;
        String r21 = null;
    L64:
        String r15 = r3.c;
        StringBuilder r16 = new StringBuilder("[audioFormat][fullEncoderCreate] formatId=");
        r16.append(System.identityHashCode(r3.b));
        r16.append(", sampleRate=");
        r16.append(r13);
        r16.append(", channelCount=");
        r16.append(r14);
        r16.append(", encodeConfigId=");
        if (r21 != null) goto L67;
        String r17 = "default";
    L68:
        r16.append(r17);
        lvb.a.e(r15, r16.toString());
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L71
        Object r19 = Result.constructor-impl(OggOpusEncoder.Companion.new(new OggOpusEncoderInputInfo(r13, r14), 60, r8, r21));     // Catch: Throwable -> L71
    L73:
        OggOpusCodecError r20 = Result.exceptionOrNull-impl(r19);
        if (r20 == null) goto L84;
        if ((r20 instanceof OggOpusCodecError) == false) goto L78;
        StringBuilder r22 = new StringBuilder(" (code=");
        OggOpusCodecError r110 = r20;
        r22.append(r110.getCode());
        r22.append(", msg=");
        r22.append(r110.getMessage());
        r22.append(')');
        String r26 = r22.toString();
    L79:
        lvb.a.b(r3.c, "newFullFileEncoder failed: " + r20 + r26);
        String r27 = r20.getClass().getSimpleName();
        String r28 = r20.getMessage();
        if (r28 != null) goto L82;
        r28 = "";
    L82:
        MmRecordingAudioPersistent.f("full_audio_encoder_create_failed", r27, r28);
        goto L84
    L78:
        r26 = "";
    L84:
        if (Result.isFailure-impl(r19) == false) goto L86;
        Object r111 = null;
    L87:
        OggOpusEncoder r112 = (OggOpusEncoder) r111;
        r3.h = r112;
        if (r112 != null) goto L91;
        lvb.a.b(r3.c, "checkAndInitAudioDir failed: new full file encoder failed, fullPath=" + r8 + ", meetingId=" + r23);
        MmRecordingAudioPersistent.f("full_audio_encoder_create_failed", "encoder_null", "");
    L90:
        return false;
    L86:
        r111 = r19;
    L71:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L73
    L67:
        r17 = r21;
        goto L68
    L63:
        r21 = "minutes_stereo";
        goto L64
    L52:
        if (StringsKt.isBlank(r8) == true) goto L55;
        r10 = false;
        goto L56
    L49:
        r8 = null;
    L91:
        lvb.a.e(r3.c, "checkAndInitAudioDir");
        MmRecordFileHelper.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "userId");
        h r30 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.a;
        Intrinsics.checkNotNullParameter(r5, "userId");
        Intrinsics.checkNotNullParameter("MinutesRecordings", "directoryName");
        VFSFile r31 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.a(r5, "MinutesRecordings");
        MmRecordGeneralConfig r32 = r3.a.getSettingsService().h;
        com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.b r33 = r3.g;
        if (r33 == null) goto L94;
        String r34 = r31.getAbsolutePath();
        long r35 = r32.getAudioFileCacheMaxAgeDays();
        long r113 = r32.getAudioFileCacheThresholdMb();
        Intrinsics.checkNotNullParameter(r34, "directoryPath");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new d(r33, r34, r35, r113));
        goto L94
    L98:
        File r36 = MmRecordingAudioPersistent.e(r5, r23);     // Catch: Throwable -> L30
        if (r36.mkdirs() == false) goto L28;
    L32:
        h r114 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.a;     // Catch: Throwable -> L30
        r7 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.b(r36, System.currentTimeMillis() + ".ogg");     // Catch: Throwable -> L30
        if (r7.exists() == true) goto L45;
        r7.createNewFile();     // Catch: Throwable -> L30
        goto L45
    L28:
        if (r36.exists() == true) goto L32;
        lvb.a.b(r3.c, "make fullDir failed");     // Catch: Throwable -> L30
        MmRecordingAudioPersistent.f("full_audio_file_create_failed", "make_full_dir_failed", "");     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        lvb.a.c(r3.c, "make full audio file failed: " + th);
        String r37 = th.getClass().getSimpleName();
        String r38 = th.getMessage();
        if (r38 != null) goto L39;
        r38 = "";
    L39:
        MmRecordingAudioPersistent.f("full_audio_file_create_failed", r37, r38);
        goto L44
    L21:
        if (r4.exists() == true) goto L23;
        lvb.a.b(r3.c, "make partDir failed");
        qvb.a.b(null, "audio_part_dir_create_failed", "private_meeting_part_dir", null, 9);
    L94:
        return true;
    L13:
        if (r1.exists() != true) goto L15;
        r2 = true;
        goto L16
    L5:
        pub.a r39 = (pub.a) OfficeSDKManager.getHostGlobalService(pub.a.class);
        if (r39 == null) goto L8;
        boolean r40 = r39.F(r24);
    L9:
        r9 = r40;
        goto L10
    L8:
        r40 = false;
        goto L9
    }

    public final Object g(MmRtcInitInfo r7, String r8, Continuation<? super Boolean> r9) {
        if ((r9 instanceof MmRecordingAudioService$initRtcInternal$1) == false) goto L7;
        MmRecordingAudioService$initRtcInternal$1 r0 = (MmRecordingAudioService$initRtcInternal$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r10);
    L22:
        boolean r11 = ((Boolean) r10).booleanValue();
        long r12 = SystemClock.elapsedRealtime() - this.A;
        lvb.a.e(this.e, "[initRtc] finished, success=" + r11 + ", cost=" + r12 + "ms");
        return Boxing.boxBoolean(r11);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        this.A = SystemClock.elapsedRealtime();
        this.B = r8;
        lvb.a.e(this.e, "[initRtc], envType:" + this.b.y().envType());
        c r13 = new c(this);
        MmRtcWrapper r14 = this.x;
        IDeviceInfoProvider r4 = OfficeSDKManager.getDeviceInfoProvider();
        if (r4 == null) goto L18;
        String r5 = r4.getDeviceId();
        if (r5 == null) goto L18;
    L19:
        r0.label = 1;
        r10 = r14.f(r13, r7, r5, r0);
        if (r10 != r2) goto L22;
        return r2;
    L18:
        r5 = "";
    L7:
        r0 = new MmRecordingAudioService$initRtcInternal$1(this, r9);
        goto L8
    }

    public final Object n(String r9, String r10, Continuation<? super Boolean> r11) {
        MmRecordingAudioPersistent r4 = d();
        String r1 = this.b.getCurrentUserId();
        r4.getClass();
        if (StringsKt.isBlank(r9) == false) goto L5;
    L10:
        lvb.a.e(r4.c, "[switchPartDirToMeetingId] skip, fromSessionKey=" + r9 + ", toMeetingId=" + r10);
        return Boxing.boxBoolean(true);
    L5:
        if (StringsKt.isBlank(r10) == true) goto L10;
        if (Intrinsics.areEqual(r9, r10) == true) goto L10;
        return BuildersKt.withContext(r4.d, new MmRecordingAudioPersistent$switchPartDirToMeetingId$2(r1, r9, r10, r4, null), r11);
    }

    public MmRecordingAudioService(MmRecordingSession r7, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r8, MmRecordingAudioCaptureMode r9, sub.b r10) {
        Intrinsics.checkNotNullParameter(r7, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r8, "userComponentContext");
        Intrinsics.checkNotNullParameter(r9, "audioCaptureMode");
        this.a = r7;
        this.b = r8;
        this.c = r9;
        this.d = r10;
        String r11 = "RecordingAudioService_" + hashCode();
        this.e = r11;
        int r1 = f.c;
        Intrinsics.checkNotNullParameter(r8, "userComponentContext");
        MmRecordingRemoteAudioSetting r0 = r8.getSettingsService().b;
        int r2 = r0.getMmAudioSampleRate();
        int r3 = r0.getMmAudioChannel();
        f r4 = new f(r2, r3);
        this.f = r4;
        MmRecordingRemoteAudioSetting r5 = r8.getSettingsService().b;
        StringBuilder r6 = new StringBuilder("[audioFormat][snapshot] traceId=");
        r6.append(r7.c);
        r6.append(", sessionType=");
        r6.append(r7.a);
        r6.append(", captureMode=");
        if (r9 != MmRecordingAudioCaptureMode.EXTERNAL_AUDIO_SOURCE) goto L5;
        String r12 = PickerReporterConstants.VALUE.CLICK.EXTERNAL;
    L6:
        r6.append(r12);
        r6.append(", formatId=");
        r6.append(System.identityHashCode(r4));
        r6.append(", sampleRate=");
        r6.append(r2);
        r6.append(", channelCount=");
        r6.append(r3);
        r6.append(", currentSampleRate=");
        r6.append(r5.getMmAudioSampleRate());
        r6.append(", currentChannelCount=");
        r6.append(r5.getMmAudioChannel());
        lvb.a.e(r11, r6.toString());
        this.g = CoroutineScopeKt.MainScope();
        this.h = CoroutineScopeKt.CoroutineScope(MMCoroutines.a().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.i = LazyKt.lazy(MmRecordingAudioService$preloadEngineDispatcher$2.INSTANCE);
        this.j = ChannelKt.Channel$default(-2, null, null, 6, null);
        StateFlowImpl r13 = j1.a(0);
        this.k = r13;
        this.l = kotlinx.coroutines.flow.e.b(r13);
        StateFlowImpl r14 = j1.a(0L);
        this.m = r14;
        this.n = kotlinx.coroutines.flow.e.b(r14);
        this.p = -1;
        this.s = true;
        this.u = LazyKt.lazy(new MmRecordingAudioService$filePersistent$2(this));
        this.v = LazyKt.lazy(new MmRecordingAudioService$audioDataProcessor$2(this));
        this.w = LazyKt.lazy(new MmRecordingAudioService$encodedAudioProcessor$2(this));
        this.x = new MmRtcWrapper(r8, r4);
        this.B = "";
        this.C = LazyKt.lazy(new MmRecordingAudioService$rtcPreloadCache$2(this));
        this.E = new ConcurrentHashMap();
        return;
    L5:
        r12 = "rtc";
        goto L6
    }

    public static void o(MmRecordingAudioService r10, String r11, Integer r12, String r13, String r14, int r15) {
        if ((r15 & 2) == 0) goto L5;
        r12 = null;
    L5:
        Integer r2 = r12;
        if ((r15 & 8) == 0) goto L8;
        r14 = "";
    L8:
        l r0 = r10.a.b();
        l.i(r0, r11, r2, r13, null, null, null, null, r14, 2032);
    }

    public final void p(String r20, String r21, String r22, String r23, Long r24, Integer r25) {
        l r5 = this.a.b();
        MmRecordingAudioCaptureMode r6 = this.c;
        int r7 = b.a[r6.ordinal()];
        if (r7 != 1) goto L5;
        String r8 = "local_external";
    L10:
        r5.getClass();
        Intrinsics.checkNotNullParameter(r20, "stage");
        Intrinsics.checkNotNullParameter(r21, "stageStatus");
        Intrinsics.checkNotNullParameter(r8, "captureMode");
        Intrinsics.checkNotNullParameter(r22, "resultSource");
        Intrinsics.checkNotNullParameter(r23, "initMode");
        i r15 = r5.b;
        MmRecordingSession r14 = r5.a;
        String r13 = r5.c();
        long r9 = r5.d;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r14, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r20, "stage");
        Intrinsics.checkNotNullParameter(r21, "stageStatus");
        Intrinsics.checkNotNullParameter(r8, "captureMode");
        Intrinsics.checkNotNullParameter(r22, "resultSource");
        Intrinsics.checkNotNullParameter(r23, "initMode");
        Intrinsics.checkNotNullParameter(r13, "latestStateName");
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d r10 = i.a(r15, r14, "recording_rtc_stage", r13, r9);
        r10.e("rtc_stage", r20);
        r10.e("stage_status", r21);
        r10.e("capture_mode", r8);
        r10.e("result_source", r22);
        if (r23.length() <= 0) goto L13;
        boolean r11 = true;
    L14:
        if (r11 == false) goto L16;
        r10.e("init_mode", r23);
    L16:
        if (r24 == null) goto L18;
        r10.c("latency_ms", r24.longValue());
    L18:
        if (r25 == null) goto L22;
        int r1 = r25.intValue();
        r10.b("result_code", r1);
        if (Intrinsics.areEqual(r21, "failed") == false) goto L22;
        r10.b(UniContext.KEY_OF_ERROR_CODE, r1);
    L22:
        r15.b(r10.a());
        return;
    L13:
        r11 = false;
        goto L14
    L5:
        if (r7 != 2) goto L8;
        r8 = "rtc";
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ void q(MmRecordingAudioService r7, String r8, String r9, String r10, String r11, Long r12, int r13) {
        if ((r13 & 8) == 0) goto L5;
        r11 = "";
    L5:
        String r4 = r11;
        if ((r13 & 16) == 0) goto L8;
        r12 = null;
    L8:
        r7.p(r8, r9, r10, r4, r12, null);
    }
}
