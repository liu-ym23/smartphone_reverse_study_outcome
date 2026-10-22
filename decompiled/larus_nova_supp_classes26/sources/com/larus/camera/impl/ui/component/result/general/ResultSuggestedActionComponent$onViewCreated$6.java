package com.larus.camera.impl.ui.component.result.general;

import com.larus.common_ui.view.SuggestedActionBar;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "dimmed", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultSuggestedActionComponent$onViewCreated$6", f = "ResultSuggestedActionComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultSuggestedActionComponent$onViewCreated$6 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ ResultSuggestedActionComponent this$0;

    public ResultSuggestedActionComponent$onViewCreated$6(ResultSuggestedActionComponent r1, Continuation<? super ResultSuggestedActionComponent$onViewCreated$6> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ResultSuggestedActionComponent$onViewCreated$6 r0 = new ResultSuggestedActionComponent$onViewCreated$6(this.this$0, r4);
        r0.Z$0 = ((Boolean) r3).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r3);
        boolean r4 = this.Z$0;
        ResultSuggestedActionComponent r0 = this.this$0;
        int r1 = ResultSuggestedActionComponent.w;
        SuggestedActionBar r2 = r0.t();
        if (r4 == false) goto L7;
        float r5 = 0.0f;
    L8:
        r2.setAlpha(r5);
        return Unit.INSTANCE;
    L7:
        r5 = 1.0f;
        goto L8
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
