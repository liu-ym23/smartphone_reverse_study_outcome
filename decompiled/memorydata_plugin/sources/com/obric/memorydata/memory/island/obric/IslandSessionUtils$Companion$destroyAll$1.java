package com.obric.memorydata.memory.island.obric;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.island.obric.IslandSessionUtils$Companion", f = "IslandSessionUtils.kt", i = {0, 0}, l = {1883, 1888, 1888}, m = "destroyAll", n = {"$this$withLock_u24default$iv", "actualOwner$iv"}, s = {"L$0", "L$1"})
final class IslandSessionUtils$Companion$destroyAll$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IslandSessionUtils.Companion this$0;

    IslandSessionUtils$Companion$destroyAll$1(IslandSessionUtils.Companion r3, Continuation<? super IslandSessionUtils$Companion$destroyAll$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
