package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadErrorCode;
import com.ss.android.lark.picker.base.view.ItemViewType;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager$updateToErrorAsync$1", f = "MmMinutesFileUploadSessionManager.kt", i = {}, l = {1854}, m = "invokeSuspend", n = {}, s = {})
final class MmMinutesFileUploadSessionManager$updateToErrorAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MmMinutesFileUploadErrorCode $code;
    final /* synthetic */ String $msg;
    final /* synthetic */ Throwable $raw;
    final /* synthetic */ String $taskId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmMinutesFileUploadSessionManager this$0;

    public MmMinutesFileUploadSessionManager$updateToErrorAsync$1(MmMinutesFileUploadSessionManager r1, String r2, MmMinutesFileUploadErrorCode r3, String r4, Throwable r5, Continuation<? super MmMinutesFileUploadSessionManager$updateToErrorAsync$1> r6) {
        this.this$0 = r1;
        this.$taskId = r2;
        this.$code = r3;
        this.$msg = r4;
        this.$raw = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        MmMinutesFileUploadSessionManager$updateToErrorAsync$1 r7 = new MmMinutesFileUploadSessionManager$updateToErrorAsync$1(this.this$0, this.$taskId, this.$code, this.$msg, this.$raw, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L15
    L13:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L18:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r13);
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        MmMinutesFileUploadSessionManager r3 = this.this$0;
        String r4 = this.$taskId;
        MmMinutesFileUploadErrorCode r5 = this.$code;
        String r6 = this.$msg;
        Throwable r7 = this.$raw;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        if (MmMinutesFileUploadSessionManager.P(r3, r4, r5, r6, r7, null, null, this, 48) != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }
}
