package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadErrorCode;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager$buildUploadCallback$1$onError$1", f = "MmMinutesFileUploadSessionManager.kt", i = {3}, l = {1486, 1490, 1493, 2297}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
public final class MmMinutesFileUploadSessionManager$buildUploadCallback$1$onError$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $code;
    final /* synthetic */ String $message;
    final /* synthetic */ String $taskId;
    final /* synthetic */ String $uploadTaskId;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ MmMinutesFileUploadSessionManager this$0;

    public MmMinutesFileUploadSessionManager$buildUploadCallback$1$onError$1(MmMinutesFileUploadSessionManager r1, String r2, String r3, int r4, String r5, Continuation<? super MmMinutesFileUploadSessionManager$buildUploadCallback$1$onError$1> r6) {
        this.this$0 = r1;
        this.$taskId = r2;
        this.$uploadTaskId = r3;
        this.$code = r4;
        this.$message = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MmMinutesFileUploadSessionManager$buildUploadCallback$1$onError$1(this.this$0, this.$taskId, this.$uploadTaskId, this.$code, this.$message, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r12 = true;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L11;
        if (r1 != 4) goto L10;
        String r2 = (String) this.L$4;
        String r3 = (String) this.L$3;
        MmMinutesFileUploadSessionManager r4 = (MmMinutesFileUploadSessionManager) this.L$2;
        String r5 = (String) this.L$1;
        kotlinx.coroutines.sync.a r6 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r14);
    L59:
    L56:
        th = move-exception;
        r6.unlock(null);
        throw th;
    L38:
        if (r5.length() > 0) goto L41;
        r12 = false;
    L41:
        if (r12 == false) goto L45;
        MmMinutesFileUploadSessionManager.e r7 = r4.p.get(r3);     // Catch: Throwable -> L56
        if (r7 == null) goto L45;
        Intrinsics.checkNotNullParameter(r5, "uploadTaskId");     // Catch: Throwable -> L56
        r7.l.remove(r5);     // Catch: Throwable -> L56
    L45:
        MmMinutesFileUploadSessionManager.e r8 = r4.p.get(r3);     // Catch: Throwable -> L56
        if (r8 == null) goto L50;
        CompletableDeferred<Unit> r9 = r8.r;     // Catch: Throwable -> L56
        if (r9 == null) goto L50;
        Boxing.boxBoolean(r9.completeExceptionally(new RuntimeException(r2)));     // Catch: Throwable -> L56
    L50:
        MmMinutesFileUploadSessionManager.e r10 = r4.p.get(r3);     // Catch: Throwable -> L56
        if (r10 == null) goto L53;
        r10.r = null;     // Catch: Throwable -> L56
    L53:
        r4.w();     // Catch: Throwable -> L56
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L56
        r6.unlock(null);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r14);
    L33:
        r4 = this.this$0;
        r6 = r4.g;
        r5 = this.$uploadTaskId;
        r3 = this.$taskId;
        String r13 = this.$message;
        this.L$0 = r6;
        this.L$1 = r5;
        this.L$2 = r4;
        this.L$3 = r3;
        this.L$4 = r13;
        this.label = 4;
        if (r6.a(null, this) != r0) goto L36;
        return r0;
    L36:
        r2 = r13;
        goto L59
    L12:
        ResultKt.throwOnFailure(r14);
        Object r15 = r14;
    L27:
        if (((Boolean) r15).booleanValue() == true) goto L29;
    L30:
        MmMinutesFileUploadSessionManager r16 = this.this$0;
        String r17 = this.$taskId;
        MmMinutesFileUploadErrorCode r18 = MmMinutesFileUploadErrorCode.DRIVE_PUSH_CALLBACK_ERROR;
        String r19 = this.$message;
        Integer r20 = Boxing.boxInt(this.$code);
        this.label = 3;
        if (MmMinutesFileUploadSessionManager.P(r16, r17, r18, r19, null, r20, null, this, 40) != r0) goto L33;
        return r0;
    L29:
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r14);
        Object r21 = r14;
    L18:
        if (((Boolean) r21).booleanValue() == false) goto L21;
        lvb.a.e(this.this$0.d, "uploadCallback.onError: skip stale callback. taskId=" + this.$taskId + ", uploadTaskId=" + this.$uploadTaskId);
        return Unit.INSTANCE;
    L21:
        MmMinutesFileUploadSessionManager r22 = this.this$0;
        Set<String> r23 = MmMinutesFileUploadSessionManager.u;
        if (r22.E() == true) goto L30;
        MmMinutesFileUploadSessionManager r24 = this.this$0;
        String r25 = this.$taskId;
        String r26 = this.$uploadTaskId;
        int r27 = this.$code;
        String r28 = this.$message;
        this.label = 2;
        r15 = MmMinutesFileUploadSessionManager.e(r24, r25, r26, r27, r28, this);
        if (r15 != r0) goto L27;
        return r0;
    L14:
        ResultKt.throwOnFailure(r14);
        MmMinutesFileUploadSessionManager r29 = this.this$0;
        String r30 = this.$taskId;
        String r31 = this.$uploadTaskId;
        this.label = 1;
        r21 = MmMinutesFileUploadSessionManager.d(r29, r30, r31, this);
        if (r21 != r0) goto L18;
        return r0;
    }
}
