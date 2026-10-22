package com.obric.memorydata.memory.island.obric;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.island.obric.IslandSessionUtils$Companion", f = "IslandSessionUtils.kt", i = {0, 0, 0}, l = {1883, 1887, 1887}, m = "autoDismiss", n = {"$this$withLock_u24default$iv", "actualOwner$iv", "delayMs"}, s = {"L$0", "L$1", "J$0"})
final class IslandSessionUtils$Companion$autoDismiss$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IslandSessionUtils.Companion this$0;

    IslandSessionUtils$Companion$autoDismiss$1(IslandSessionUtils.Companion r3, Continuation<? super IslandSessionUtils$Companion$autoDismiss$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
