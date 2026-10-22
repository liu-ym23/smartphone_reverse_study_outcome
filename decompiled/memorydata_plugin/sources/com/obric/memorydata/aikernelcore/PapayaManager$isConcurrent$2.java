package com.obric.memorydata.aikernelcore;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.aikernelcore.PapayaManager$isConcurrent$2", f = "PapayaManager.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
final class PapayaManager$isConcurrent$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bizName;
    int label;

    PapayaManager$isConcurrent$2(String r3, Continuation<? super PapayaManager$isConcurrent$2> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$bizName = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new PapayaManager$isConcurrent$2(this.$bizName, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((PapayaManager$isConcurrent$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PapayaManager$isConcurrent$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L7
    L15:
        JsonObject r9 = (JsonObject) ZeusTransformUtils.preCheckCast(r8, JsonObject.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        if (r9 == null) goto L20;
        JsonElement r10 = r9.get("concurrent");     // Catch: Throwable -> L7
        if (r10 == null) goto L20;
        boolean r11 = r10.getAsBoolean();     // Catch: Throwable -> L7
    L21:
        if (r11 == false) goto L23;
        boolean r3 = true;
    L24:
        ((Map) ZeusTransformUtils.preCheckCast(h.d(), Map.class, "com.obric.memorydata.plugin")).put(this.$bizName, Boxing.boxBoolean(r3));     // Catch: Throwable -> L7
        RunLog r4 = RunLog.INSTANCE;     // Catch: Throwable -> L7
        StringBuilder r5 = new StringBuilder().append("package config loaded: ").append(this.$bizName).append(", concurrent=");     // Catch: Throwable -> L7
        if (r11 == true) goto L28;
        r2 = false;
    L28:
        r4.debug("PapayaManager", r5.append(r2).toString());     // Catch: Throwable -> L7
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(h.e(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        String r6 = this.$bizName;     // Catch: Throwable -> L7
        Iterator r13 = r12.iterator();     // Catch: Throwable -> L7
    L29:
        if (r13.hasNext() == false) goto L33;
        ((d) ZeusTransformUtils.preCheckCast(r13.next(), d.class, "com.obric.memorydata.plugin")).a(r6);     // Catch: Throwable -> L7
        goto L29
    L33:
        h.f().remove(this.$bizName);
        return Unit.INSTANCE;
    L23:
        r3 = false;
    L20:
        r11 = false;
        goto L21
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r8);
        MemoryScriptEngineEnv r14 = MemoryScriptEngineEnv.INSTANCE;     // Catch: Throwable -> L7
        String r7 = this.$bizName;     // Catch: Throwable -> L7
        Continuation<? super JsonObject> r15 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        r8 = r14.getPackageCustomConfig(r7, r15);     // Catch: Throwable -> L7
        if (r8 != r0) goto L15;
        return r0;
    L7:
        th = move-exception;
        h.f().remove(this.$bizName);
        throw th;
    }
}
