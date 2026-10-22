package com.obric.assistant.special_input.instruction;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.api.IObricNetworkService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
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
import kotlinx.coroutines.CoroutineScope;
import vea.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/assistant/network/api/bean/OperationInstruction;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.instruction.PanelInstructionLoader$loadOperationInstructions$2", f = "PanelInstructionLoader.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
final class PanelInstructionLoader$loadOperationInstructions$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends q>>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public PanelInstructionLoader$loadOperationInstructions$2(Continuation<? super PanelInstructionLoader$loadOperationInstructions$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        PanelInstructionLoader$loadOperationInstructions$2 r0 = new PanelInstructionLoader$loadOperationInstructions$2(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<q>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L21
    L15:
        List r6 = (List) r5;     // Catch: Throwable -> L21
    L17:
        if (r6 != null) goto L19;
        r6 = CollectionsKt.emptyList();     // Catch: Throwable -> L21
    L19:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L21
    L23:
        Throwable r2 = Result.exceptionOrNull-impl(r7);
        if (r2 == null) goto L26;
        FLogger.a.e("PanelInstructionLoader", "loadOperationInstructions failed: " + r2.getMessage());
    L26:
        List r3 = CollectionsKt.emptyList();
        if (Result.isFailure-impl(r7) == true) goto L29;
        return r7;
    L29:
        return r3;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L21
        IObricNetworkService r10 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);     // Catch: Throwable -> L21
        if (r10 == null) goto L16;
        this.label = 1;     // Catch: Throwable -> L21
        r5 = r10.getOperationInstructions(this);     // Catch: Throwable -> L21
        if (r5 != r0) goto L15;
        return r0;
    L16:
        r6 = null;
    L21:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }
}
