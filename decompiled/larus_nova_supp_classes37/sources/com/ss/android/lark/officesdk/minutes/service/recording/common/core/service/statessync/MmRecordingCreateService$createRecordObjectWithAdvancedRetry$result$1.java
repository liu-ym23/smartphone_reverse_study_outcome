package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoBizInfo;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.request.http.MmCreateAudioRequest;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.exception.MmCreateRecordingException;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingCreateService$createRecordObjectWithAdvancedRetry$result$1", f = "MmRecordingCreateService.kt", i = {0, 1, 2, 2}, l = {164, 173, 247}, m = "invokeSuspend", n = {"currentRetryTimes", "currentRetryTimes", "lastCreateException", "currentRetryTimes"}, s = {"I$0", "I$0", "L$0", "I$0"})
public final class MmRecordingCreateService$createRecordObjectWithAdvancedRetry$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Function0<MmCreateAudioRequest.CreateMinutesStatus> $createAudioStatus;
    final /* synthetic */ DoubaoBizInfo $doubaoBizInfo;
    final /* synthetic */ int $maxRetryTimes;
    final /* synthetic */ String $meetingId;
    final /* synthetic */ String $recordingId;
    final /* synthetic */ MmRecordingSource $source;
    final /* synthetic */ boolean $useRecordingApi;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ MmRecordingCreateService this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingCreateService$createRecordObjectWithAdvancedRetry$result$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingCreateService$createRecordObjectWithAdvancedRetry$result$1$1", f = "MmRecordingCreateService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {
        /* synthetic */ boolean Z$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            AnonymousClass1 r0 = new AnonymousClass1(r3);
            r0.Z$0 = ((Boolean) r2).booleanValue();
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
        }

        public final Object invoke(boolean r1, Continuation<? super Boolean> r2) {
            return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return Boxing.boxBoolean(this.Z$0);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmRecordingCreateService$createRecordObjectWithAdvancedRetry$result$1(MmRecordingCreateService r1, int r2, String r3, Function0<? extends MmCreateAudioRequest.CreateMinutesStatus> r4, DoubaoBizInfo r5, MmRecordingSource r6, String r7, boolean r8, Continuation<? super MmRecordingCreateService$createRecordObjectWithAdvancedRetry$result$1> r9) {
        this.this$0 = r1;
        this.$maxRetryTimes = r2;
        this.$meetingId = r3;
        this.$createAudioStatus = r4;
        this.$doubaoBizInfo = r5;
        this.$source = r6;
        this.$recordingId = r7;
        this.$useRecordingApi = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new MmRecordingCreateService$createRecordObjectWithAdvancedRetry$result$1(this.this$0, this.$maxRetryTimes, this.$meetingId, this.$createAudioStatus, this.$doubaoBizInfo, this.$source, this.$recordingId, this.$useRecordingApi, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x01d0 -> B:13:0x006c). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        int r3 = this.I$0;
        Throwable r8 = (Throwable) this.L$0;
        ResultKt.throwOnFailure(r19);
        MmRecordingCreateService$createRecordObjectWithAdvancedRetry$result$1 r9 = this;
    L14:
        if (r3 < r9.$maxRetryTimes) goto L16;
        lvb.a.b(r9.this$0.d, "Create minutesToken failed after " + r9.$maxRetryTimes + " retries");
        if (r8 != null) goto L106;
        r8 = new MmCreateRecordingException.MmRecordingOtherException(-1, "Create minutesToken failed after " + r9.$maxRetryTimes + " retries");
    L106:
        MmRecordingCreateService.b(r9.this$0, "create_minutes_token_exhausted", r8);
        Result.Companion r4 = Result.Companion;
        Object r5 = Result.constructor-impl(ResultKt.createFailure(r8));
        if (r9.$useRecordingApi == false) goto L111;
        MmRecordingCreateService.a r6 = r9.this$0.c;
        if (r6 == null) goto L114;
        r6.b(r5);
    L114:
        r9.this$0.g = null;
        return null;
    L111:
        MmRecordingCreateService.a r7 = r9.this$0.c;
        if (r7 == null) goto L114;
        r7.a(r5);
        goto L114
    L16:
        if (((Boolean) r9.this$0.i.getValue()).booleanValue() == true) goto L20;
        lvb.a.e(r9.this$0.d, "Pausing create minutesToken: network is unavailable");
        StateFlowImpl r10 = r9.this$0.i;
        AnonymousClass1 r11 = new AnonymousClass1(null);
        r9.L$0 = null;
        r9.I$0 = r3;
        r9.label = 1;
        if (kotlinx.coroutines.flow.e.t(r10, r11, r9) != r1) goto L20;
        return r1;
    L20:
        MmRecordingCreateService$createRecordObjectWithAdvancedRetry$result$1 r15 = r9;
    L21:
        lvb.a.e(r15.this$0.d, "Attempting to create minutesToken, retry times: " + r3);
        MmRecordingCreateService r12 = r15.this$0;
        MmMockAwareRequestService r13 = r12.a.M();
        String r14 = r15.$meetingId;
        Function0<MmCreateAudioRequest.CreateMinutesStatus> r16 = r15.$createAudioStatus;
        if (r16 == null) goto L24;
        MmCreateAudioRequest.CreateMinutesStatus r17 = (MmCreateAudioRequest.CreateMinutesStatus) r16.invoke();
    L25:
        DoubaoBizInfo r18 = r15.$doubaoBizInfo;
        MmRecordingSource r110 = r15.$source;
        String r111 = r15.$recordingId;
        boolean r20 = r15.$useRecordingApi;
        r15.L$0 = null;
        r15.I$0 = r3;
        r15.label = 2;
        MmRecordingCreateService$createRecordObjectWithAdvancedRetry$result$1 r112 = r15;
        Object r21 = MmRecordingCreateService.a(r12, r13, r14, r17, r18, r110, r111, r20, r112);
        if (r21 != r1) goto L28;
        return r1;
    L28:
        r9 = r112;
    L29:
        Throwable r22 = Result.exceptionOrNull-impl(r21);
        if (Result.isSuccess-impl(r21) == true) goto L32;
    L79:
        Throwable r113 = Result.exceptionOrNull-impl(r21);
        if ((r113 instanceof MmCreateRecordingException.MmRecordingNoQuotaException) == false) goto L82;
    L90:
        lvb.a.b(r9.this$0.d, "Create minutesToken failed, error: " + Result.exceptionOrNull-impl(r21));
        MmRecordingCreateService.b(r9.this$0, "create_minutes_token_non_retryable", Result.exceptionOrNull-impl(r21));
        Throwable r23 = Result.exceptionOrNull-impl(r21);
        if (r23 != null) goto L93;
        r23 = new Throwable("unknown exception");
    L93:
        Object r24 = Result.constructor-impl(ResultKt.createFailure(r23));
        if (r9.$useRecordingApi == false) goto L98;
        MmRecordingCreateService.a r25 = r9.this$0.c;
        if (r25 == null) goto L101;
        r25.b(r24);
    L101:
        r9.this$0.g = null;
        return null;
    L98:
        MmRecordingCreateService.a r26 = r9.this$0.c;
        if (r26 == null) goto L101;
        r26.a(r24);
        goto L101
    L82:
        if ((r113 instanceof MmCreateRecordingException.MmRecordingCreateFailedException) == true) goto L90;
        if ((r113 instanceof MmCreateRecordingException.MmRecordingOccupiedException) == true) goto L90;
        r3 = r3 + 1;
        lvb.a.e(r9.this$0.d, "Create minutesToken failed, retrying in " + r9.this$0.b + "ms, retry times: " + r3);
        long r114 = r9.this$0.b;
        r9.L$0 = r22;
        r9.I$0 = r3;
        r9.label = 3;
        if (DelayKt.delay(r114, r9) != r1) goto L89;
        return r1;
    L89:
        r8 = r22;
        goto L14
    L32:
        if (Result.isFailure-impl(r21) == false) goto L34;
        Object r115 = null;
    L35:
        MmCreateAudioResponse r116 = (MmCreateAudioResponse) r115;
        boolean r117 = r9.$useRecordingApi;
        if (r117 == false) goto L56;
        if (r116 == null) goto L45;
        String r118 = r116.getRecordingId();
        if (r118 == null) goto L45;
        if ((!StringsKt.isBlank(r118)) == true) goto L44;
        r118 = null;
    L44:
        if (r118 == null) goto L45;
    L61:
        if (r116 == null) goto L79;
        if (r118.length() <= 0) goto L65;
        boolean r119 = true;
    L66:
        if (r119 == false) goto L79;
        if (r117 == false) goto L69;
        r116.setRecordingId(r118);
    L69:
        lvb.a.e(r9.this$0.d, "Create recording succeeded, source=" + r9.$source + ", id=" + r118);
        if (r117 == false) goto L74;
        MmRecordingCreateService.a r27 = r9.this$0.c;
        if (r27 == null) goto L77;
        r27.b(Result.constructor-impl(r116));
    L77:
        r9.this$0.g = null;
        return r118;
    L74:
        MmRecordingCreateService.a r28 = r9.this$0.c;
        if (r28 == null) goto L77;
        r28.a(Result.constructor-impl(r116));
        goto L77
    L65:
        r119 = false;
    L45:
        r118 = r9.$recordingId;
        if ((!StringsKt.isBlank(r118)) == true) goto L49;
        r118 = null;
    L49:
        if (r118 != null) goto L61;
        DoubaoBizInfo r120 = r9.$doubaoBizInfo;
        if (r120 == null) goto L53;
        r118 = r120.getRecordingId();
    L54:
        if (r118 != null) goto L61;
    L60:
        r118 = "";
        goto L61
    L53:
        r118 = null;
        goto L54
    L56:
        if (r116 == null) goto L58;
        r118 = r116.getObjectToken();
    L59:
        if (r118 != null) goto L61;
    L58:
        r118 = null;
        goto L59
    L34:
        r115 = r21;
        goto L35
    L24:
        r17 = null;
        goto L25
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r3 = this.I$0;
        ResultKt.throwOnFailure(r19);
        r21 = ((Result) r19).unbox-impl();
        r9 = this;
        goto L29
    L11:
        r3 = this.I$0;
        ResultKt.throwOnFailure(r19);
        r15 = this;
        goto L21
    L12:
        ResultKt.throwOnFailure(r19);
        lvb.a.e(this.this$0.d, "Starting create minutesToken, max retry times: " + this.$maxRetryTimes + ", interval: " + this.this$0.b + "ms");
        r9 = this;
        r8 = null;
        r3 = 0;
        goto L14
    }
}
