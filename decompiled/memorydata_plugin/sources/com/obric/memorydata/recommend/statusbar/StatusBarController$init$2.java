package com.obric.memorydata.recommend.statusbar;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "enabled", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.recommend.statusbar.StatusBarController$init$2", f = "StatusBarController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class StatusBarController$init$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;

    StatusBarController$init$2(Continuation<? super StatusBarController$init$2> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        StatusBarController$init$2 r4 = new StatusBarController$init$2((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        r4.Z$0 = ((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        return (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Boolean r3, Continuation<? super Unit> r4) {
        return invoke(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(boolean r3, Continuation<? super Unit> r4) {
        Continuation<?> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return ((StatusBarController$init$2) ZeusTransformUtils.preCheckCast(create(Boolean.valueOf(r3), r5), StatusBarController$init$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r3);
        boolean r2 = this.Z$0;
        a r4 = a.f12632a;
        a.a(r2);
        if (r2 == false) goto L7;
        a.a(a.f12632a, ((Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.recommend.feature.a.f12505a.b().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue());
    L9:
        return Unit.INSTANCE;
    L7:
        a.a(a.f12632a);
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
