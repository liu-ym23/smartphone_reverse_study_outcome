package com.obric.aikernel.res.downloader;

import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.downloader.DownloadController$cancel$2", f = "DownloadController.kt", i = {}, l = {370}, m = "invokeSuspend", n = {}, s = {})
final class DownloadController$cancel$2 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<DownloadTask> $shouldCancelTasks;
    Object L$0;
    int label;

    DownloadController$cancel$2(List<DownloadTask> r10, Continuation<? super DownloadController$cancel$2> r11) {
        this.$shouldCancelTasks = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new DownloadController$cancel$2(this.$shouldCancelTasks, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((DownloadController$cancel$2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        Iterator r13 = (Iterator) this.L$0;
        ResultKt.throwOnFailure(r10);
    L10:
        if (r13.hasNext() == false) goto L15;
        DownloadTask r14 = (DownloadTask) r13.next();
        this.L$0 = r13;
        this.label = 1;
        if (r14.l(this) != r11) goto L10;
        return r11;
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        r13 = this.$shouldCancelTasks.iterator();
        goto L10
    }
}
