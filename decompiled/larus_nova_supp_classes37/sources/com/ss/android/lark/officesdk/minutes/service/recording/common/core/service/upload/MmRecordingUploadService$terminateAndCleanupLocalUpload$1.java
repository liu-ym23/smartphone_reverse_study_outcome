package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadService$terminateAndCleanupLocalUpload$1", f = "MmRecordingUploadService.kt", i = {}, l = {250}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingUploadService$terminateAndCleanupLocalUpload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TerminateReason $reason;
    final /* synthetic */ MmRecordingUploadTask $task;
    int label;
    final /* synthetic */ MmRecordingUploadService this$0;

    public MmRecordingUploadService$terminateAndCleanupLocalUpload$1(MmRecordingUploadService r1, MmRecordingUploadTask r2, TerminateReason r3, Continuation<? super MmRecordingUploadService$terminateAndCleanupLocalUpload$1> r4) {
        this.this$0 = r1;
        this.$task = r2;
        this.$reason = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmRecordingUploadService$terminateAndCleanupLocalUpload$1(this.this$0, this.$task, this.$reason, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a] */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a$n] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession] */
    public final Object invokeSuspend(Object r5) {
        ?? r0 = "[terminateAndCleanupLocalUpload] cleanup failed, reason:";
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L11;
        if (r2 != 1) goto L10;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L7
    L15:
        MmRecordingSession r6 = this.this$0.a;
        r0 = new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(this.$reason);
        ?? r3 = r0;
        ?? r7 = r6;
    L16:
        r7.u(r3);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r5);
        MmRecordingUploadService r8 = this.this$0;     // Catch: Throwable -> L7
        String r4 = this.$task.c;     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        if (MmRecordingUploadService.a(r8, r4, this) != r1) goto L15;
        return r1;
    L7:
        th = move-exception;
        lvb.a.b(this.this$0.c, r0 + this.$reason + ", error:" + th);     // Catch: Throwable -> L21
        MmRecordingSession r9 = this.this$0.a;
        r3 = new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(this.$reason);
        r7 = r9;
    L21:
        th = move-exception;
        this.this$0.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(this.$reason));
        throw th;
    }
}
