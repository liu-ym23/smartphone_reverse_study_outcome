package com.obric.memorydata.aikernelcore;

import com.obric.aikernel.res.update.UpdateResult;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.awareness.api.IAwarenessManager;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.aikernelcore.PapayaManager$updateAllPackageInfo$1", f = "PapayaManager.kt", i = {}, l = {225}, m = "invokeSuspend", n = {}, s = {})
final class PapayaManager$updateAllPackageInfo$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;

    PapayaManager$updateAllPackageInfo$1(Continuation<? super PapayaManager$updateAllPackageInfo$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new PapayaManager$updateAllPackageInfo$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((PapayaManager$updateAllPackageInfo$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PapayaManager$updateAllPackageInfo$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(r11, Map.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("PapayaManager", "update all return " + r10);
        h.f8481a.c();
        h r12 = h.f8481a;
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator r3 = r10.entrySet().iterator();
    L13:
        if (r3.hasNext() == false) goto L17;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((UpdateResult) ZeusTransformUtils.preCheckCast(r4.getValue(), UpdateResult.class, "com.obric.memorydata.plugin")).getSuccess() == false) goto L13;
        r2.put(r4.getKey(), r4.getValue());
        goto L13
    L17:
        h.a(r12, ((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin")).keySet());
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r10.values(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, Collection.class) == true) goto L20;
    L22:
        Iterator r14 = r13.iterator();
    L24:
        if (r14.hasNext() == false) goto L21;
        if (((UpdateResult) ZeusTransformUtils.preCheckCast(r14.next(), UpdateResult.class, "com.obric.memorydata.plugin")).getSuccess() == true) goto L24;
        boolean r15 = false;
    L28:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PapayaManager", "updateAllPackageInfo success = " + r15, false, 4, null);
        IAwarenessManager.a.a((IAwarenessManager) ZeusTransformUtils.preCheckCast(AwarenessManager.INSTANCE, IAwarenessManager.class, "com.obric.memorydata.plugin"), false, 1, null);
        return Unit.INSTANCE;
    L21:
        r15 = true;
        goto L28
    L20:
        if (((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L22;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        MemoryScriptEngineEnv r16 = MemoryScriptEngineEnv.INSTANCE;
        Continuation<? super Map<String, UpdateResult>> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r11 = r16.updateAll(r5);
        if (r11 != r0) goto L11;
        return r0;
    }
}
