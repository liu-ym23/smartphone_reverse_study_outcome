package com.larus.camera.impl.ui.component.result.general;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "isInDrawingMode", "isInCropMode"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultSuggestedActionComponent$onViewCreated$8", f = "ResultSuggestedActionComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultSuggestedActionComponent$onViewCreated$8 extends SuspendLambda implements Function3<Boolean, Boolean, Continuation<? super Pair<? extends Boolean, ? extends Boolean>>, Object> {
    /* synthetic */ boolean Z$0;
    /* synthetic */ boolean Z$1;
    int label;

    public ResultSuggestedActionComponent$onViewCreated$8(Continuation<? super ResultSuggestedActionComponent$onViewCreated$8> r2) {
        super(3, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke(((Boolean) r1).booleanValue(), ((Boolean) r2).booleanValue(), (Continuation) r3);
    }

    public final Object invoke(boolean r2, boolean r3, Continuation<? super Pair<Boolean, Boolean>> r4) {
        ResultSuggestedActionComponent$onViewCreated$8 r0 = new ResultSuggestedActionComponent$onViewCreated$8(r4);
        r0.Z$0 = r2;
        r0.Z$1 = r3;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        boolean r4 = this.Z$0;
        boolean r0 = this.Z$1;
        return new Pair(Boxing.boxBoolean(r4), Boxing.boxBoolean(r0));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
