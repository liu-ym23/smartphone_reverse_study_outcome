package com.obric.memorydata.memory.llm;

import com.obric.memorydata.dc.PageContextResult;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import kotlinx.coroutines.ar;
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.llm.PageContextMemoryCoordinator$bind$1", f = "PageContextMemoryCoordinator.kt", i = {}, l = {31, 39}, m = "invokeSuspend", n = {}, s = {})
final class PageContextMemoryCoordinator$bind$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.obric.memorydata.dc.a $handle;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ String $sourcePackageName;
    Object L$0;
    int label;

    PageContextMemoryCoordinator$bind$1(com.obric.memorydata.dc.a r3, String r4, String r5, Continuation<? super PageContextMemoryCoordinator$bind$1> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$handle = r3;
        this.$sourcePackageName = r4;
        this.$sessionId = r5;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new PageContextMemoryCoordinator$bind$1(this.$handle, this.$sourcePackageName, this.$sessionId, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((PageContextMemoryCoordinator$bind$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PageContextMemoryCoordinator$bind$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r9);
    L25:
        h.a().remove(this.$sessionId);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        h r2 = (h) ZeusTransformUtils.preCheckCast(this.L$0, h.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L18
    L16:
        com.obric.memorydata.dc.d r10 = r2.a((PageContextResult) ZeusTransformUtils.preCheckCast(r9, PageContextResult.class, "com.obric.memorydata.plugin"), this.$sourcePackageName);     // Catch: Throwable -> L18
    L20:
        if (r10 == null) goto L22;
        ((Map) ZeusTransformUtils.preCheckCast(h.a(), Map.class, "com.obric.memorydata.plugin")).put(this.$sessionId, r10);
    L22:
        Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = null;
        this.label = 2;
        if (au.a(60000, r11) != r0) goto L25;
        return r0;
    L12:
        ResultKt.throwOnFailure(r9);
        r2 = h.f10289a;     // Catch: Throwable -> L18
        ar<PageContextResult> r12 = this.$handle.a();     // Catch: Throwable -> L18
        Continuation<? super PageContextResult> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        this.L$0 = r2;     // Catch: Throwable -> L18
        this.label = 1;     // Catch: Throwable -> L18
        r9 = r12.a(r6);     // Catch: Throwable -> L18
        if (r9 != r0) goto L16;
        return r0;
    L18:
        th = move-exception;
        RunLog.INSTANCE.error("PageContextMemoryCoordinator", "await page context failed, sessionId: " + this.$sessionId, th);
        r10 = null;
        goto L20
    }
}
