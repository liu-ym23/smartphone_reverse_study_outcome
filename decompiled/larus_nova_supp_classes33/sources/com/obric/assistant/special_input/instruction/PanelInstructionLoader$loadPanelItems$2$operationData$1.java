package com.obric.assistant.special_input.instruction;

import com.google.gson.Gson;
import com.obric.cae.libs.useraware.ParamPacker;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import vea.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/assistant/network/api/bean/OperationInstruction;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.instruction.PanelInstructionLoader$loadPanelItems$2$operationData$1", f = "PanelInstructionLoader.kt", i = {}, l = {ParamPacker.TOTAL_LENGTH}, m = "invokeSuspend", n = {}, s = {})
public final class PanelInstructionLoader$loadPanelItems$2$operationData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends q>>, Object> {
    int label;
    final /* synthetic */ PanelInstructionLoader this$0;

    public PanelInstructionLoader$loadPanelItems$2$operationData$1(PanelInstructionLoader r1, Continuation<? super PanelInstructionLoader$loadPanelItems$2$operationData$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new PanelInstructionLoader$loadPanelItems$2$operationData$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<q>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        PanelInstructionLoader r5 = this.this$0;
        this.label = 1;
        Lazy<Gson> r2 = PanelInstructionLoader.i;
        r5.getClass();
        r4 = BuildersKt.withContext(Dispatchers.getIO(), new PanelInstructionLoader$loadOperationInstructions$2(null), this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
