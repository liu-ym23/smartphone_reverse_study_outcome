package com.obric.assistant.feedback.upload;

import com.obric.assistant.feedback.upload.bean.ReportUploadTask;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.feedback.upload.ReportUploadManager$triggerUpload$1", f = "ReportUploadManager.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
final class ReportUploadManager$triggerUpload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ ReportUploadTask $data;
    int label;

    public ReportUploadManager$triggerUpload$1(ReportUploadTask r1, Continuation<? super ReportUploadManager$triggerUpload$1> r2) {
        this.$data = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ReportUploadManager$triggerUpload$1(this.$data, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        d r5 = d.a;
        ReportUploadWorker r6 = (ReportUploadWorker) d.c.getValue();
        ReportUploadTask r2 = this.$data;
        this.label = 1;
        r4 = r6.d(r2, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
