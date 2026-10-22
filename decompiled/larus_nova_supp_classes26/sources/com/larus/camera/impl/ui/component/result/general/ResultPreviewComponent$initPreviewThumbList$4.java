package com.larus.camera.impl.ui.component.result.general;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "", "drawingCropPair", "Lkotlin/Pair;", "isSeekbarDragging"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultPreviewComponent$initPreviewThumbList$4", f = "ResultPreviewComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultPreviewComponent$initPreviewThumbList$4 extends SuspendLambda implements Function3<Pair<? extends Boolean, ? extends Boolean>, Boolean, Continuation<? super Triple<? extends Boolean, ? extends Boolean, ? extends Boolean>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    public ResultPreviewComponent$initPreviewThumbList$4(Continuation<? super ResultPreviewComponent$initPreviewThumbList$4> r2) {
        super(3, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((Pair) r1, ((Boolean) r2).booleanValue(), (Continuation) r3);
    }

    public final Object invoke(Pair<Boolean, Boolean> r2, boolean r3, Continuation<? super Triple<Boolean, Boolean, Boolean>> r4) {
        ResultPreviewComponent$initPreviewThumbList$4 r0 = new ResultPreviewComponent$initPreviewThumbList$4(r4);
        r0.L$0 = r2;
        r0.Z$0 = r3;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        Pair r5 = (Pair) this.L$0;
        boolean r0 = this.Z$0;
        return new Triple(r5.getFirst(), r5.getSecond(), Boxing.boxBoolean(r0));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
