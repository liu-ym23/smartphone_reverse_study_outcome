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
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/larus/camera/impl/widget/title/ResultTitleRightIconState;", "params", "Lcom/larus/camera/impl/ui/component/result/general/ResultTitleComponent$TitleRightIconParams;", "inMarkSelectMode", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultTitleComponent$resultTitleRightIconStateFlow$5", f = "ResultTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ResultTitleComponent$resultTitleRightIconStateFlow$5 extends SuspendLambda implements Function3<ResultTitleComponent.b, Boolean, Continuation<? super ay8.a>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ ResultTitleComponent this$0;

    public ResultTitleComponent$resultTitleRightIconStateFlow$5(ResultTitleComponent r1, Continuation<? super ResultTitleComponent$resultTitleRightIconStateFlow$5> r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public final Object invoke(ResultTitleComponent.b r3, boolean r4, Continuation<? super ay8.a> r5) {
        ResultTitleComponent$resultTitleRightIconStateFlow$5 r0 = new ResultTitleComponent$resultTitleRightIconStateFlow$5(this.this$0, r5);
        r0.L$0 = r3;
        r0.Z$0 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((ResultTitleComponent.b) r1, ((Boolean) r2).booleanValue(), (Continuation) r3);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r8);
        ResultTitleComponent.b r9 = (ResultTitleComponent.b) this.L$0;
        boolean r6 = this.Z$0;
        ResultTitleComponent r0 = this.this$0;
        Boolean r1 = r9.a;
        boolean r2 = r9.b;
        boolean r3 = r9.c;
        n r4 = r9.d;
        boolean r5 = r9.e;
        int r10 = ResultTitleComponent.s;
        return r0.y(r1, r2, r3, r4, r5, r6);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
