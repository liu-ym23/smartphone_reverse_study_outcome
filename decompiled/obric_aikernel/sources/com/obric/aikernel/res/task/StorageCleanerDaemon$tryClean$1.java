package com.obric.aikernel.res.task;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.task.StorageCleanerDaemon", f = "StorageCleanerDaemon.kt", i = {0, 0, 0}, l = {68, 73}, m = "tryClean", n = {"this", "it", "curTime"}, s = {"L$0", "L$1", "J$0"})
final class StorageCleanerDaemon$tryClean$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StorageCleanerDaemon this$0;

    StorageCleanerDaemon$tryClean$1(StorageCleanerDaemon r10, Continuation<? super StorageCleanerDaemon$tryClean$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return StorageCleanerDaemon.d(this.this$0, this);
    }
}
