package com.obric.aikernel.runtime;

import androidx.core.app.NotificationCompat;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.VmEngine", f = "VmEngine.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {89, 123, 170}, m = "vmExecuteRaw", n = {"this", "pkg", "params", NotificationCompat.CATEGORY_EVENT, "pkgWrapper", "callback", "sessionLifeCycle", "this", "pkg", "params", NotificationCompat.CATEGORY_EVENT, "pkgWrapper", "callback", "sessionLifeCycle", "inrWatchDog", "this", "pkg", "params", NotificationCompat.CATEGORY_EVENT, "pkgWrapper", "callback", "inrWatchDog", "contextExtra", "vmStartTs", "executionStarted", "vmExecuteNotifyStarted"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0", "I$0", "I$1"})
final class VmEngine$vmExecuteRaw$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VmEngine this$0;

    VmEngine$vmExecuteRaw$1(VmEngine r10, Continuation<? super VmEngine$vmExecuteRaw$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return VmEngine.f(this.this$0, null, null, null, null, null, this);
    }
}
