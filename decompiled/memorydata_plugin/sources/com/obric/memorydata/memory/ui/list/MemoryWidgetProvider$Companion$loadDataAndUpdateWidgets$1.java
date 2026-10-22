package com.obric.memorydata.memory.ui.list;

import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryWidgetProvider$Companion$loadDataAndUpdateWidgets$1", f = "MemoryWidgetProvider.kt", i = {}, l = {178, 181}, m = "invokeSuspend", n = {}, s = {})
final class MemoryWidgetProvider$Companion$loadDataAndUpdateWidgets$1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $msg;
    int label;

    MemoryWidgetProvider$Companion$loadDataAndUpdateWidgets$1(String r3, Continuation<? super MemoryWidgetProvider$Companion$loadDataAndUpdateWidgets$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$msg = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryWidgetProvider$Companion$loadDataAndUpdateWidgets$1(this.$msg, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
        return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
        return ((MemoryWidgetProvider$Companion$loadDataAndUpdateWidgets$1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryWidgetProvider$Companion$loadDataAndUpdateWidgets$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        ResultKt.throwOnFailure(r9);     // Catch: Exception -> L12 CancellationException -> L22
    L24:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r9);     // Catch: Exception -> L12 CancellationException -> L22
    L18:
        RunLog.INSTANCE.debug("MemoryWidgetProvider", "executing loadDataAndUpdateWidgets after debounce: " + this.$msg);     // Catch: Exception -> L12 CancellationException -> L22
        al.a r10 = al.f11186a;     // Catch: Exception -> L12 CancellationException -> L22
        Continuation r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12 CancellationException -> L22
        this.label = 2;     // Catch: Exception -> L12 CancellationException -> L22
        if (al.a.a(r10, r2) != r0) goto L24;
        return r0;
    L14:
        ResultKt.throwOnFailure(r9);
        Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12 CancellationException -> L22
        this.label = 1;     // Catch: Exception -> L12 CancellationException -> L22
        if (kotlinx.coroutines.au.a(500, r11) != r0) goto L18;
        return r0;
    L22:
        RunLog.INSTANCE.debug("MemoryWidgetProvider", "loadDataAndUpdateWidgets cancelled due to newer request: " + this.$msg);
    L12:
        e = move-exception;
        RunLog.INSTANCE.error("MemoryWidgetProvider", "loadDataAndUpdateWidgets failed: " + this.$msg, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L24
    }
}
