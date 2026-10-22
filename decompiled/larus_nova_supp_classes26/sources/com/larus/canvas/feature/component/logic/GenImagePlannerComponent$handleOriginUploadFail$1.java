package com.larus.canvas.feature.component.logic;

import android.content.Context;
import com.bytedance.common.utility.NetworkUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$handleOriginUploadFail$1", f = "GenImagePlannerComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GenImagePlannerComponent$handleOriginUploadFail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GenImagePlannerComponent this$0;

    public GenImagePlannerComponent$handleOriginUploadFail$1(GenImagePlannerComponent r1, Continuation<? super GenImagePlannerComponent$handleOriginUploadFail$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new GenImagePlannerComponent$handleOriginUploadFail$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r2);
        if (NetworkUtils.isNetworkAvailable(this.this$0.getContext()) == true) goto L7;
        t19.s r3 = t19.s.a;
        Context r0 = this.this$0.getContext();
        r3.getClass();
        t19.s.s(r0, 2131908080);
    L9:
        return Unit.INSTANCE;
    L7:
        t19.s r4 = t19.s.a;
        Context r1 = this.this$0.getContext();
        r4.getClass();
        t19.s.s(r1, 2131907666);
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
