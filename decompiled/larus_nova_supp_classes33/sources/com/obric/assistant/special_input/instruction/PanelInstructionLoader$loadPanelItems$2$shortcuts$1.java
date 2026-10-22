package com.obric.assistant.special_input.instruction;

import com.google.gson.Gson;
import com.obric.assistant.ComplexTaskCaseFromPCConfig;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/assistant/special_input/instruction/PanelInstructionItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.instruction.PanelInstructionLoader$loadPanelItems$2$shortcuts$1", f = "PanelInstructionLoader.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
public final class PanelInstructionLoader$loadPanelItems$2$shortcuts$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PanelInstructionItem>>, Object> {
    final /* synthetic */ ComplexTaskCaseFromPCConfig $config;
    int label;
    final /* synthetic */ PanelInstructionLoader this$0;

    public PanelInstructionLoader$loadPanelItems$2$shortcuts$1(PanelInstructionLoader r1, ComplexTaskCaseFromPCConfig r2, Continuation<? super PanelInstructionLoader$loadPanelItems$2$shortcuts$1> r3) {
        this.this$0 = r1;
        this.$config = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PanelInstructionLoader$loadPanelItems$2$shortcuts$1(this.this$0, this.$config, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<PanelInstructionItem>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L14:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        PanelInstructionLoader r7 = this.this$0;
        int r2 = this.$config.getShortcutLimitCount();
        this.label = 1;
        Lazy<Gson> r3 = PanelInstructionLoader.i;
        r7.getClass();
        if (r2 > 0) goto L11;
        r6 = CollectionsKt.emptyList();
    L12:
        if (r6 != r0) goto L14;
        return r0;
    L11:
        r6 = BuildersKt.withContext(Dispatchers.getIO(), new PanelInstructionLoader$loadShortcutItems$2(r2, r7, null), this);
        goto L12
    }
}
