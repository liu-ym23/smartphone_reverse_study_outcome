package com.larus.canvas.feature.component.instruction.model;

import com.larus.canvas.feature.api.CanvasApi;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/canvas/feature/api/InstructionTabFetchResponse;", "Lcom/larus/canvas/feature/api/CanvasApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.instruction.model.InstructionTabViewModel$fetchRemoteInstructionTabList$1$response$1", f = "InstructionTabViewModel.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
public final class InstructionTabViewModel$fetchRemoteInstructionTabList$1$response$1 extends SuspendLambda implements Function2<CanvasApi, Continuation<? super BizResponse<gy8.b>>, Object> {
    final /* synthetic */ int $canvasType;
    private /* synthetic */ Object L$0;
    int label;

    public InstructionTabViewModel$fetchRemoteInstructionTabList$1$response$1(int r1, Continuation<? super InstructionTabViewModel$fetchRemoteInstructionTabList$1$response$1> r2) {
        this.$canvasType = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        InstructionTabViewModel$fetchRemoteInstructionTabList$1$response$1 r0 = new InstructionTabViewModel$fetchRemoteInstructionTabList$1$response$1(this.$canvasType, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(CanvasApi r1, Continuation<? super BizResponse<gy8.b>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CanvasApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CanvasApi r6 = (CanvasApi) this.L$0;
        gy8.a r2 = new gy8.a(Boxing.boxInt(this.$canvasType));
        this.label = 1;
        r5 = r6.fetchInstructionTab(r2, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
