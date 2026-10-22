package com.obric.aikernel.res.update;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.UpdateTask", f = "UpdateTask.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {721}, m = "doDownload", n = {"this", "cfg", "modelDownloadTasks", "downloadTasks", "destination$iv$iv", "distConfig", "task"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7"})
final class UpdateTask$doDownload$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UpdateTask this$0;

    UpdateTask$doDownload$1(UpdateTask r10, Continuation<? super UpdateTask$doDownload$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return UpdateTask.d(this.this$0, this);
    }
}
