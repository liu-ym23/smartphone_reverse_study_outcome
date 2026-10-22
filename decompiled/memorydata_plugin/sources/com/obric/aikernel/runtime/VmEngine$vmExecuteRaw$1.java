package com.obric.aikernel.runtime;

import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.runtime.VmEngine", f = "VmEngine.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4}, l = {90, 101, 135, 186, 215}, m = "vmExecuteRaw", n = {"this", "pkg", TrackerImpl.PARAMS, "event", "pkgWrapper", "callback", "vmExecuteController", "preExecuteStatus", "this", "pkg", TrackerImpl.PARAMS, "event", "pkgWrapper", "callback", "vmExecuteController", "sessionLifeCycle", "this", "pkg", TrackerImpl.PARAMS, "event", "pkgWrapper", "callback", "vmExecuteController", "sessionLifeCycle", "inrWatchDog", "this", "pkg", TrackerImpl.PARAMS, "event", "pkgWrapper", "callback", "vmExecuteController", "inrWatchDog", "contextExtra", "vmStartTs", "executionStarted", "vmExecuteNotifyStarted", "this", "pkg", TrackerImpl.PARAMS, "event", "pkgWrapper", "callback", "inrWatchDog", "ret"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "J$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"})
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
    Object L$8;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ e this$0;

    VmEngine$vmExecuteRaw$1(e r3, Continuation<? super VmEngine$vmExecuteRaw$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        return e.a(this.this$0, null, null, null, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
