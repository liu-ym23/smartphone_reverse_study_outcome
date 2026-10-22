package com.obric.memorydata.memory.ui.automemory.create;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCreateCollectionInfoFragment$onCreateView$$inlined$map$3$2", f = "AutoMemoryCreateCollectionInfoFragment.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
public final class AutoMemoryCreateCollectionInfoFragment$onCreateView$$inlined$map$3$2$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AutoMemoryCreateCollectionInfoFragment.d.AnonymousClass1 this$0;

    public AutoMemoryCreateCollectionInfoFragment$onCreateView$$inlined$map$3$2$1(AutoMemoryCreateCollectionInfoFragment.d.AnonymousClass1 r3, Continuation r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
