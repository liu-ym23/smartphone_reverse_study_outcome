package com.obric.assistant.special_input.instruction;

import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/assistant/special_input/instruction/PanelInstructionItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.instruction.PanelInstructionLoader$loadMemoryRecommendItems$2", f = "PanelInstructionLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PanelInstructionLoader$loadMemoryRecommendItems$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PanelInstructionItem>>, Object> {
    final /* synthetic */ int $limit;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PanelInstructionLoader this$0;

    public PanelInstructionLoader$loadMemoryRecommendItems$2(int r1, PanelInstructionLoader r2, Continuation<? super PanelInstructionLoader$loadMemoryRecommendItems$2> r3) {
        this.$limit = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        PanelInstructionLoader$loadMemoryRecommendItems$2 r0 = new PanelInstructionLoader$loadMemoryRecommendItems$2(this.$limit, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<PanelInstructionItem>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L32;
        ResultKt.throwOnFailure(r6);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        int r8 = this.$limit;
        PanelInstructionLoader r0 = this.this$0;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L22
        IAgentAppIntentIDL r2 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));     // Catch: Throwable -> L22
        if (r2 == null) goto L8;
        List r9 = r2.getComplexTaskPanelInfoFromPC(r8);     // Catch: Throwable -> L22
    L9:
        if (r9 != null) goto L11;
        r9 = CollectionsKt.emptyList();     // Catch: Throwable -> L22
    L11:
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L22
        Iterator r10 = r9.iterator();     // Catch: Throwable -> L22
    L13:
        if (r10.hasNext() == false) goto L20;
        String r4 = (String) r10.next();     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L22
        Lazy<Gson> r5 = PanelInstructionLoader.i;     // Catch: Throwable -> L22
        r0.getClass();     // Catch: Throwable -> L22
        e r11 = PanelInstructionLoader.g(r4);     // Catch: Throwable -> L22
        if (r11 == null) goto L17;
        PanelInstructionItem r12 = PanelInstructionLoader.f(r11, PanelInstructionType.RECOMMEND_MEMORY);     // Catch: Throwable -> L22
    L18:
        if (r12 == null) goto L13;
        r3.add(r12);     // Catch: Throwable -> L22
        goto L13
    L17:
        r12 = null;
        goto L18
    L20:
        Object r13 = Result.constructor-impl(r3);     // Catch: Throwable -> L22
    L24:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L27;
        FLogger.a.e("PanelInstructionLoader", "loadMemoryRecommendItems failed: " + r14.getMessage());
    L27:
        List r15 = CollectionsKt.emptyList();
        if (Result.isFailure-impl(r13) == true) goto L30;
        return r13;
    L30:
        return r15;
    L8:
        r9 = null;
    L22:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L32:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
