package com.obric.memorydata.memory.ui.automemory.create;

import com.obric.memorydata.database.dao.MemoryRuleDao;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCollectionAiTaskQueue$updateRule$2", f = "AutoMemoryCollectionAiTaskQueue.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AutoMemoryCollectionAiTaskQueue$updateRule$2 extends SuspendLambda implements Function2<al, Continuation<? super Integer>, Object> {
    final /* synthetic */ String $appPackages;
    final /* synthetic */ String $content;
    final /* synthetic */ long $ruleId;
    final /* synthetic */ String $title;
    int label;

    AutoMemoryCollectionAiTaskQueue$updateRule$2(long r3, String r5, String r6, String r7, Continuation<? super AutoMemoryCollectionAiTaskQueue$updateRule$2> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.$ruleId = r3;
        this.$title = r5;
        this.$content = r6;
        this.$appPackages = r7;
        super(2, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AutoMemoryCollectionAiTaskQueue$updateRule$2(this.$ruleId, this.$title, this.$content, this.$appPackages, r7), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Integer> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Integer> r4) {
        return ((AutoMemoryCollectionAiTaskQueue$updateRule$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AutoMemoryCollectionAiTaskQueue$updateRule$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        return Boxing.boxInt(MemoryRuleDao.DefaultImpls.updateMyCollection$default(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao(), this.$ruleId, this.$title, this.$content, this.$appPackages, false, 16, null));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
