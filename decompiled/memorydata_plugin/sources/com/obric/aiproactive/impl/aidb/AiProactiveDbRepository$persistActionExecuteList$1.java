package com.obric.aiproactive.impl.aidb;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.aidb.AiProactiveDbRepository", f = "AiProactiveDbRepository.kt", i = {0, 0, 0, 0, 0}, l = {TypedValues.Custom.TYPE_STRING}, m = "persistActionExecuteList", n = {"this", "row", "nextCardStatus", "nextActionExecuteList", "updated"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0"})
final class AiProactiveDbRepository$persistActionExecuteList$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    AiProactiveDbRepository$persistActionExecuteList$1(d r3, Continuation<? super AiProactiveDbRepository$persistActionExecuteList$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        return d.a(this.this$0, null, null, 0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
