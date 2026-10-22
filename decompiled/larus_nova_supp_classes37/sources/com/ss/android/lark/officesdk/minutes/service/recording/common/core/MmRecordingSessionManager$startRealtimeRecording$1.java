package com.ss.android.lark.officesdk.minutes.service.recording.common.core;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.feature.MmOfficeSdkFeature;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.MmRecordingRoute;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.d;
import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.j;
import iub.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager$startRealtimeRecording$1", f = "MmRecordingSessionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingSessionManager$startRealtimeRecording$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ iub.a<j, MmRecordingError> $callback;
    final /* synthetic */ k $context;
    final /* synthetic */ sub.b $externalAudioSource;
    final /* synthetic */ MmRecordingCommonParam $initialCommonParam;
    final /* synthetic */ String $recordingTraceId;
    final /* synthetic */ RecordingSessionType $sessionType;
    final /* synthetic */ MmRecordingSessionManager.c $startingSnapshot;
    int label;
    final /* synthetic */ MmRecordingSessionManager this$0;

    public static final class a implements iub.a<Pair<? extends MmRecordingSession, ? extends j>, MmRecordingError> {
        public final /* synthetic */ MmRecordingSessionManager a;
        public final /* synthetic */ MmRecordingSessionManager.c b;
        public final /* synthetic */ iub.a<j, MmRecordingError> c;
        public final /* synthetic */ Ref.ObjectRef<CoroutineScope> d;

        @Override // iub.a
        public final void a(MmRecordingError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            MmRecordingSessionManager r0 = this.a;
            CoroutineScope r1 = (CoroutineScope) this.d.element;
            int r2 = MmRecordingSessionManager.I;
            r0.i(r1);
            MmRecordingSessionManager.f(this.a, this.b, true);
            this.c.a(r4);
        }

        @Override // iub.a
        public final void onSuccess(Pair<? extends MmRecordingSession, ? extends j> r11) {
            Pair<? extends MmRecordingSession, ? extends j> r12 = r11;
            Intrinsics.checkNotNullParameter(r12, "data");
            MmRecordingSession r0 = (MmRecordingSession) r12.getFirst();
            j r13 = (j) r12.getSecond();
            String r1 = r13.a;
            this.a.p = r1;
            this.a.e.put(r1, r0);
            MmRecordingSessionManager.f(this.a, this.b, false);
            MmRecordingSessionManager r2 = this.a;
            String r9 = null;
            this.a.k.put(r1, BuildersKt.launch$default(r2.c, null, null, new MmRecordingSessionManager$listenSessionStateChange$1(r0, r2, null), 3, null));
            MmRecordingSessionManager r3 = this.a;
            r3.l.put(r1, r3.q(r0));
            MmRecordingSessionManager r4 = this.a;
            CoroutineScope r5 = r4.d;
            if (r5 == null) goto L5;
            BuildersKt.launch$default(r5, null, null, new MmRecordingSessionManager$listenSessionEvent$1(r0, r4, null), 3, null);
        L5:
            MmRecordingSessionManager r6 = this.a;
            CoroutineScope r7 = r6.d;
            if (r7 == null) goto L8;
            BuildersKt.launch$default(r7, null, null, new MmRecordingSessionManager$listenSessionSubtitle$1(r0, r6, null), 3, null);
        L8:
            MmRecordingSessionManager r8 = this.a;
            CoroutineScope r10 = r8.d;
            if (r10 == null) goto L11;
            BuildersKt.launch$default(r10, null, null, new MmRecordingSessionManager$listenSessionDuration$1(r0, r8, null), 3, null);
        L11:
            MmRecordingSessionManager r14 = this.a;
            CoroutineScope r15 = r14.d;
            if (r15 == null) goto L14;
            BuildersKt.launch$default(r15, null, null, new MmRecordingSessionManager$listenSessionVolume$1(r0, r14, null), 3, null);
        L14:
            com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.b r16 = com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.a;
            MmRecordingCommonParam r17 = r0.j();
            r16.getClass();
            Intrinsics.checkNotNullParameter(r17, "commonParam");
            com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.b.C0038b r18 = r16.a.getAndSet(null);
            if (r18 != null) goto L17;
            lvb.a.h("MmRecordingCreateMetrics", "[trackRealtimeRecordingSuccess] missing start context, recordId=" + r17.getTrackerRecordId());
        L23:
            lvb.a.e(this.a.b, "[startRealtimeRecording] onSuccess, recordingId=" + r1);
            this.c.onSuccess(r13);
            return;
        L17:
            lvb.a.e("MmRecordingCreateMetrics", "[trackRealtimeRecordingSuccess] traceId=" + r17.getRecordingTraceId() + ", recordId=" + r17.getTrackerRecordId());
            d r19 = new d();
            MmRecordingSource r20 = r17.getSource();
            if (r20 == null) goto L20;
            r9 = r20.getValue();
        L20:
            if (r9 != null) goto L22;
            r9 = "";
        L22:
            r19.e("source", r9);
            r19.e("success", "1");
            r19.e("duration", String.valueOf(RangesKt.coerceAtLeast(System.currentTimeMillis() - r18.b, 0)));
            com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.a("minutes_recording_end", r17, r19.a());
            goto L23
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(MmRecordingSessionManager r1, MmRecordingSessionManager.c r2, iub.a<j, ? super MmRecordingError> r3, Ref.ObjectRef<CoroutineScope> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmRecordingSessionManager$startRealtimeRecording$1(MmRecordingSessionManager r1, RecordingSessionType r2, k r3, MmRecordingCommonParam r4, iub.a<j, ? super MmRecordingError> r5, String r6, sub.b r7, MmRecordingSessionManager.c r8, Continuation<? super MmRecordingSessionManager$startRealtimeRecording$1> r9) {
        this.this$0 = r1;
        this.$sessionType = r2;
        this.$context = r3;
        this.$initialCommonParam = r4;
        this.$callback = r5;
        this.$recordingTraceId = r6;
        this.$externalAudioSource = r7;
        this.$startingSnapshot = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new MmRecordingSessionManager$startRealtimeRecording$1(this.this$0, this.$sessionType, this.$context, this.$initialCommonParam, this.$callback, this.$recordingTraceId, this.$externalAudioSource, this.$startingSnapshot, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r26) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L51;
        ResultKt.throwOnFailure(r26);
        Ref.ObjectRef r9 = new Ref.ObjectRef();
        lvb.a.e(this.this$0.b, "[startRealtimeRecording] type=" + this.$sessionType + ", source=" + this.$context.a + ", currentRealtimeSessionId=" + this.this$0.p);     // Catch: Throwable -> L8
        if (this.$sessionType.isRecordingFeatureSession() == false) goto L10;
        d r11 = this.$initialCommonParam.asTrackerParams();     // Catch: Throwable -> L8
        r11.e("click_action", "start_record");     // Catch: Throwable -> L8
        JSONObject r12 = r11.a();     // Catch: Throwable -> L8
        this.this$0.a.N().getClass();     // Catch: Throwable -> L8
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c.h("vc_navigation_minutes_recording_click", r12);     // Catch: Throwable -> L8
    L10:
        RecordingSessionType r13 = this.$sessionType;     // Catch: Throwable -> L8
        if (r13 != RecordingSessionType.SOFTWARE_RECORDING) goto L13;
    L22:
        String r14 = this.this$0.p;     // Catch: Throwable -> L8
        if (this.this$0.e.get(r14) == null) goto L26;
        lvb.a.h(this.this$0.b, "[startRealtimeRecording] already has realtime sessionId=" + r14);     // Catch: Throwable -> L8
        qvb.a r0 = qvb.a.a;     // Catch: Throwable -> L8
        MmRecordingError.AlreadyRecording r1 = MmRecordingError.AlreadyRecording.INSTANCE;     // Catch: Throwable -> L8
        qvb.a.e(Boxing.boxInt(r1.getErrorCode()), "recording_already_exists", r1.getErrorMsg(), null, 8);     // Catch: Throwable -> L8
        this.$callback.a(r1);     // Catch: Throwable -> L8
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L29:
        this.this$0.i((CoroutineScope) r9.element);
        MmRecordingSessionManager.f(this.this$0, this.$startingSnapshot, true);
        return r2;
    L26:
        if (((pvb.a) this.this$0.q.getValue()).a(this.$context, this.$callback) == true) goto L31;
        lvb.a.b(this.this$0.b, "[startRealtimeRecording] precheck failed, type=" + this.$sessionType + ", source=" + this.$context.a);     // Catch: Throwable -> L8
        qvb.a r3 = qvb.a.a;     // Catch: Throwable -> L8
        qvb.a.e(null, "recording_precheck_failed", this.$sessionType.name(), "error", 1);     // Catch: Throwable -> L8
        r2 = Unit.INSTANCE;     // Catch: Throwable -> L8
        goto L29
    L31:
        lvb.a.e(this.this$0.b, "[startRealtimeRecording] type=" + this.$sessionType + ", source=" + this.$context.a);     // Catch: Throwable -> L8
        boolean r4 = this.this$0.a.getFeatureService().h(MmOfficeSdkFeature.RecordingMemoryApiEnabled);     // Catch: Throwable -> L8
        MmRecordingRoute.a r5 = MmRecordingRoute.Companion;     // Catch: Throwable -> L8
        MmRecordingSource r6 = this.$context.a;     // Catch: Throwable -> L8
        if (r4 == false) goto L34;
        boolean r7 = true;
    L35:
        r5.getClass();     // Catch: Throwable -> L8
        MmRecordingRoute r8 = MmRecordingRoute.a.a(r6, r7);     // Catch: Throwable -> L8
        lvb.a.e(this.this$0.b, "[recordingRoute] source=" + this.$context.a + ", memoryApiEnabled=" + r4 + ", initial=" + r8);     // Catch: Throwable -> L8
        MmRecordingSessionManager r10 = this.this$0;     // Catch: Throwable -> L8
        CoroutineScope r15 = r10.d;     // Catch: Throwable -> L8
        if (r15 == null) goto L38;
        CoroutineScopeKt.cancel$default(r15, null, 1, null);     // Catch: Throwable -> L8
    L38:
        CoroutineScope r16 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(JobKt.Job$default(null, 1, null)));     // Catch: Throwable -> L8
        r10.d = r16;     // Catch: Throwable -> L8
        r9.element = r16;     // Catch: Throwable -> L8
        com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r17 = this.this$0.a;     // Catch: Throwable -> L8
        String r18 = this.$recordingTraceId;     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r18);     // Catch: Throwable -> L8
        new MmRecordingSession(this.$sessionType, r17, r18, new a(this.this$0, this.$startingSnapshot, this.$callback, r9), null, this.$context, r8, this.$externalAudioSource, this.$initialCommonParam, 16);     // Catch: Throwable -> L8
    L46:
        return Unit.INSTANCE;
    L34:
        r7 = false;
        goto L35
    L13:
        if (r13 == RecordingSessionType.HARDWARE_RECORDING) goto L22;
        if (r13 == RecordingSessionType.HARDWARE_LIVE_RECORDING) goto L22;
        if (r13 == RecordingSessionType.PRE_MEETING_NATIVE_RECORDING) goto L22;
        if (r13 == RecordingSessionType.STANDALONE_AI_INTERPRETATION) goto L22;
        lvb.a.h(this.this$0.b, "[startRealtimeRecording] failed, not match sessionType");     // Catch: Throwable -> L8
        qvb.a r19 = qvb.a.a;     // Catch: Throwable -> L8
        MmRecordingError.TypeDisMatch r20 = MmRecordingError.TypeDisMatch.INSTANCE;     // Catch: Throwable -> L8
        r19.d(Boxing.boxInt(r20.getErrorCode()), "recording_type_mismatch", r20.getErrorMsg(), "error");     // Catch: Throwable -> L8
        this.$callback.a(r20);     // Catch: Throwable -> L8
        r2 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        lvb.a.b(this.this$0.b, "[startRealtimeRecording] unexpected exception: " + th);     // Catch: Throwable -> L47
        qvb.a r21 = qvb.a.a;     // Catch: Throwable -> L47
        MmRecordingError.InternalError r22 = MmRecordingError.InternalError.INSTANCE;     // Catch: Throwable -> L47
        Integer r23 = Boxing.boxInt(r22.getErrorCode());     // Catch: Throwable -> L47
        String r24 = th.getMessage();     // Catch: Throwable -> L47
        if (r24 != null) goto L43;
        r24 = "";
    L43:
        r21.d(r23, "recording_start_unexpected_exception:".concat(r24), r22.getErrorMsg(), "error");     // Catch: Throwable -> L47
        this.$callback.a(r22);     // Catch: Throwable -> L47
        this.this$0.i((CoroutineScope) r9.element);
        MmRecordingSessionManager.f(this.this$0, this.$startingSnapshot, true);
    L47:
        th = move-exception;
        MmRecordingSessionManager r25 = this.this$0;
        CoroutineScope r27 = (CoroutineScope) r9.element;
        int r28 = MmRecordingSessionManager.I;
        r25.i(r27);
        MmRecordingSessionManager.f(this.this$0, this.$startingSnapshot, true);
        throw th;
    L51:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
