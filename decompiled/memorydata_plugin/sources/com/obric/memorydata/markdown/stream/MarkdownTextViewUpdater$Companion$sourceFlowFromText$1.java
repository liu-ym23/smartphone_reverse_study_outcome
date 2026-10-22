package com.obric.memorydata.markdown.stream;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.dg;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.markdown.stream.MarkdownTextViewUpdater$Companion$sourceFlowFromText$1", f = "MarkdownTextViewUpdater.kt", i = {0, 1, 2, 2, 3, 3, 4}, l = {136, 137, 141, 141, 142}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$flow", "c", "$this$flow", "c", "$this$flow"}, s = {"L$0", "L$0", "L$0", "L$2", "L$0", "L$2", "L$0"})
final class MarkdownTextViewUpdater$Companion$sourceFlowFromText$1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.j<? super String>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $chunkSize;
    final /* synthetic */ long $delayMs;
    final /* synthetic */ String $text;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    MarkdownTextViewUpdater$Companion$sourceFlowFromText$1(long r3, String r5, int r6, Continuation<? super MarkdownTextViewUpdater$Companion$sourceFlowFromText$1> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$delayMs = r3;
        this.$text = r5;
        this.$chunkSize = r6;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        MarkdownTextViewUpdater$Companion$sourceFlowFromText$1 r11 = new MarkdownTextViewUpdater$Companion$sourceFlowFromText$1(this.$delayMs, this.$text, this.$chunkSize, r7);
        r11.L$0 = r9;
        return (Continuation) ZeusTransformUtils.preCheckCast(r11, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.flow.j<? super String> r3, Continuation<? super Unit> r4) {
        return invoke2((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.flow.j<? super String> r3, Continuation<? super Unit> r4) {
        return ((MarkdownTextViewUpdater$Companion$sourceFlowFromText$1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MarkdownTextViewUpdater$Companion$sourceFlowFromText$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x015c -> B:23:0x00ff). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L14;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L12;
        if (r1 == 4) goto L12;
        if (r1 != 5) goto L11;
        Iterator r2 = (Iterator) ZeusTransformUtils.preCheckCast(this.L$1, Iterator.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);
        kotlinx.coroutines.flow.j r6 = r5;
        Iterator r7 = r2;
    L24:
        if (r7.hasNext() == false) goto L37;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        long r9 = this.$delayMs;
        if (r9 <= 0) goto L30;
        Continuation r16 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r6;
        this.L$1 = r7;
        this.L$2 = r3;
        this.label = 3;
        if (au.a(r9, r16) != r0) goto L33;
        return r0;
    L33:
        Continuation<? super Unit> r17 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r6;
        this.L$1 = r7;
        this.L$2 = null;
        this.label = 5;
        if (r6.emit(r3, r17) != r0) goto L24;
        return r0;
    L30:
        Continuation r18 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r6;
        this.L$1 = r7;
        this.L$2 = r3;
        this.label = 4;
        if (dg.a(r18) != r0) goto L33;
        return r0;
    L37:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        r3 = (String) ZeusTransformUtils.preCheckCast(this.L$2, String.class, "com.obric.memorydata.plugin");
        r7 = (Iterator) ZeusTransformUtils.preCheckCast(this.L$1, Iterator.class, "com.obric.memorydata.plugin");
        r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);
        goto L33
    L13:
        kotlinx.coroutines.flow.j r4 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);
    L22:
        r7 = ((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin")).iterator();
        r6 = r4;
        goto L24
    L14:
        r4 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);
    L19:
        List r19 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");
        CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r110 = (Function2) ZeusTransformUtils.preCheckCast(new MarkdownTextViewUpdater$Companion$sourceFlowFromText$1$chunks$1(r19, this.$chunkSize, null), Function2.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r4;
        this.label = 2;
        r15 = kotlinx.coroutines.i.a(r8, r110, r10);
        if (r15 != r0) goto L22;
        return r0;
    L15:
        ResultKt.throwOnFailure(r15);
        kotlinx.coroutines.flow.j r111 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        CoroutineContext r11 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r12 = (Function2) ZeusTransformUtils.preCheckCast(new MarkdownTextViewUpdater$Companion$sourceFlowFromText$1$tokens$1(this.$text, null), Function2.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r111;
        this.label = 1;
        Object r14 = kotlinx.coroutines.i.a(r11, r12, r13);
        if (r14 != r0) goto L18;
        return r0;
    L18:
        r4 = r111;
        r15 = r14;
        goto L19
    }
}
