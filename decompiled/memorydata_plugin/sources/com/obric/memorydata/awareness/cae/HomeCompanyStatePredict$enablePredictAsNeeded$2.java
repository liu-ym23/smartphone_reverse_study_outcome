package com.obric.memorydata.awareness.cae;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "available", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.awareness.cae.HomeCompanyStatePredict$enablePredictAsNeeded$2", f = "HomeCompanyStatePredict.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class HomeCompanyStatePredict$enablePredictAsNeeded$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ f this$0;

    HomeCompanyStatePredict$enablePredictAsNeeded$2(f r3, Continuation<? super HomeCompanyStatePredict$enablePredictAsNeeded$2> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        HomeCompanyStatePredict$enablePredictAsNeeded$2 r0 = new HomeCompanyStatePredict$enablePredictAsNeeded$2(this.this$0, r5);
        r0.Z$0 = ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Boolean r3, Continuation<? super Unit> r4) {
        return invoke(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(boolean r3, Continuation<? super Unit> r4) {
        Continuation<?> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return ((HomeCompanyStatePredict$enablePredictAsNeeded$2) ZeusTransformUtils.preCheckCast(create(Boolean.valueOf(r3), r5), HomeCompanyStatePredict$enablePredictAsNeeded$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r2);
        boolean r3 = this.Z$0;
        f r1 = this.this$0;
        if (r3 == false) goto L7;
        String r4 = "位置基线恢复完成";
    L8:
        f.b(r1, r4);
        return Unit.INSTANCE;
    L7:
        r4 = "位置基线恢复中";
        goto L8
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
