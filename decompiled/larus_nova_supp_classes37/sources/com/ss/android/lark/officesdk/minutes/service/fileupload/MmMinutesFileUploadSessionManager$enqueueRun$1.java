package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadErrorCode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager$enqueueRun$1", f = "MmMinutesFileUploadSessionManager.kt", i = {0, 0, 2, 3}, l = {2297, 675, 687, 2308}, m = "invokeSuspend", n = {"$this$launchFileUpload", "$this$withLock_u24default$iv", "error", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$0"})
public final class MmMinutesFileUploadSessionManager$enqueueRun$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $taskId;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MmMinutesFileUploadSessionManager this$0;

    public MmMinutesFileUploadSessionManager$enqueueRun$1(MmMinutesFileUploadSessionManager r1, String r2, Continuation<? super MmMinutesFileUploadSessionManager$enqueueRun$1> r3) {
        this.this$0 = r1;
        this.$taskId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MmMinutesFileUploadSessionManager$enqueueRun$1 r0 = new MmMinutesFileUploadSessionManager$enqueueRun$1(this.this$0, this.$taskId, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = this.label;
        boolean r9 = true;
        if (r4 == 0) goto L17;
        if (r4 == 1) goto L16;
        if (r4 == 2) goto L12;
        if (r4 == 3) goto L11;
        if (r4 != 4) goto L10;
        String r0 = (String) this.L$2;
        MmMinutesFileUploadSessionManager r2 = (MmMinutesFileUploadSessionManager) this.L$1;
        kotlinx.coroutines.sync.a r5 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r19);
    L78:
        MmMinutesFileUploadSessionManager.e r1 = r2.p.get(r0);     // Catch: Throwable -> L72
        if (r1 == null) goto L69;
        r1.s = false;     // Catch: Throwable -> L72
    L69:
        r2.w();     // Catch: Throwable -> L72
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L72
        r5.unlock(null);
        lvb.a.e(this.this$0.d, "enqueueRun: finish run. taskId=" + this.$taskId);
        return Unit.INSTANCE;
    L72:
        th = move-exception;
        r5.unlock(null);
        throw th;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        Throwable r7 = (Throwable) this.L$0;
        ResultKt.throwOnFailure(r19);
        Object r8 = r19;
    L54:
        if (((Boolean) r8).booleanValue() == false) goto L56;
        lvb.a.e(this.this$0.d, "[enqueueRun] skip fallback error, task already failed. taskId=" + this.$taskId);
    L62:
        r2 = this.this$0;
        kotlinx.coroutines.sync.a r10 = r2.g;
        String r11 = this.$taskId;
        this.L$0 = r10;
        this.L$1 = r2;
        this.L$2 = r11;
        this.L$3 = null;
        this.label = 4;
        if (r10.a(null, this) != r3) goto L65;
        return r3;
    L65:
        r5 = r10;
        r0 = r11;
        goto L78
    L56:
        lvb.a.b(this.this$0.d, "[enqueueRun] runTask failed, taskId=" + this.$taskId + ", err=" + r7);
        MmMinutesFileUploadSessionManager r12 = this.this$0;
        String r13 = this.$taskId;
        MmMinutesFileUploadErrorCode r14 = MmMinutesFileUploadErrorCode.SOMETHING_WRONG;
        if (r7 == null) goto L60;
        String r15 = r7.getMessage();
        if (r15 == null) goto L60;
    L61:
        r12.getClass();
        r12.r("updateToErrorAsync", new MmMinutesFileUploadSessionManager$updateToErrorAsync$1(r12, r13, r14, r15, null, null));
    L60:
        r15 = "";
        goto L61
    L12:
        ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L14
    L36:
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L40:
        if (Result.isFailure-impl(r16) == false) goto L62;
        r7 = Result.exceptionOrNull-impl(r16);
        if (this.this$0.m == true) goto L44;
    L46:
        r9 = false;
    L47:
        if (r9 == false) goto L50;
        lvb.a.e(this.this$0.d, "enqueueRun: cancelled after release, preserve persisted task. taskId=" + this.$taskId);
        return Unit.INSTANCE;
    L50:
        MmMinutesFileUploadSessionManager r17 = this.this$0;
        String r18 = this.$taskId;
        this.L$0 = r7;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 3;
        r8 = MmMinutesFileUploadSessionManager.c(r17, r18, this);
        if (r8 != r3) goto L54;
        return r3;
    L44:
        if ((r7 instanceof CancellationException) == false) goto L46;
    L16:
        String r20 = (String) this.L$3;
        MmMinutesFileUploadSessionManager r110 = (MmMinutesFileUploadSessionManager) this.L$2;
        kotlinx.coroutines.sync.a r111 = (kotlinx.coroutines.sync.a) this.L$1;
        CoroutineScope r112 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r19);
    L82:
        MmMinutesFileUploadSessionManager.e r113 = r110.p.get(r20);     // Catch: Throwable -> L75
        if (r113 != null) goto L27;
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L75
        r111.unlock(null);
        return r21;
    L27:
        if (r113.s == false) goto L31;
        lvb.a.a(r110.d, "enqueueRun: skip, task already running. taskId=" + r20);     // Catch: Throwable -> L75
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L75
        r111.unlock(null);
        return r22;
    L31:
        r113.s = true;     // Catch: Throwable -> L75
        lvb.a.e(r110.d, "enqueueRun: start run. taskId=" + r20);     // Catch: Throwable -> L75
        MmRecordingSource r23 = r113.a.b;     // Catch: Throwable -> L75
        r111.unlock(null);
        this.this$0.e.b(this.$taskId, r23);
        MmMinutesFileUploadSessionManager r24 = this.this$0;
        String r25 = this.$taskId;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L14
        this.L$0 = null;     // Catch: Throwable -> L14
        this.L$1 = null;     // Catch: Throwable -> L14
        this.L$2 = null;     // Catch: Throwable -> L14
        this.L$3 = null;     // Catch: Throwable -> L14
        this.label = 2;     // Catch: Throwable -> L14
        if (r24.D(r25, this) != r3) goto L36;
        return r3;
    L75:
        th = move-exception;
        r111.unlock(null);
        throw th;
    L17:
        ResultKt.throwOnFailure(r19);
        CoroutineScope r27 = (CoroutineScope) this.L$0;
        r110 = this.this$0;
        r111 = r110.g;
        String r114 = this.$taskId;
        this.L$0 = r27;
        this.L$1 = r111;
        this.L$2 = r110;
        this.L$3 = r114;
        this.label = 1;
        if (r111.a(null, this) != r3) goto L20;
        return r3;
    L20:
        r20 = r114;
    L14:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L40
    }
}
