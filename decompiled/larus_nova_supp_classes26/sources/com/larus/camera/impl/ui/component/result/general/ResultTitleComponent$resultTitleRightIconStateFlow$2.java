package com.larus.camera.impl.ui.component.result.general;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/larus/camera/impl/ui/component/result/general/ResultTitleComponent$TitleRightIconParams;", "params", "inFreeInputMode", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultTitleComponent$resultTitleRightIconStateFlow$2", f = "ResultTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ResultTitleComponent$resultTitleRightIconStateFlow$2 extends SuspendLambda implements Function3<ResultTitleComponent.b, Boolean, Continuation<? super ResultTitleComponent.b>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    public ResultTitleComponent$resultTitleRightIconStateFlow$2(Continuation<? super ResultTitleComponent$resultTitleRightIconStateFlow$2> r2) {
        super(3, r2);
    }

    public final Object invoke(ResultTitleComponent.b r2, boolean r3, Continuation<? super ResultTitleComponent.b> r4) {
        ResultTitleComponent$resultTitleRightIconStateFlow$2 r0 = new ResultTitleComponent$resultTitleRightIconStateFlow$2(r4);
        r0.L$0 = r2;
        r0.Z$0 = r3;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((ResultTitleComponent.b) r1, ((Boolean) r2).booleanValue(), (Continuation) r3);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        return ResultTitleComponent.b.a((ResultTitleComponent.b) this.L$0, this.Z$0, null, false, 27);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
