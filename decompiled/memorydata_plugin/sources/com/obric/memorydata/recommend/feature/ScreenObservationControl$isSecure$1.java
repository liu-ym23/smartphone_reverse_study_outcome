package com.obric.memorydata.recommend.feature;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "windowSecure", "appSecure"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.recommend.feature.ScreenObservationControl$isSecure$1", f = "ScreenObservationControl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ScreenObservationControl$isSecure$1 extends SuspendLambda implements Function3<Boolean, Boolean, Continuation<? super Boolean>, Object> {
    /* synthetic */ boolean Z$0;
    /* synthetic */ boolean Z$1;
    int label;

    ScreenObservationControl$isSecure$1(Continuation<? super ScreenObservationControl$isSecure$1> r3) {
        super(3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(Boolean r3, Boolean r4, Continuation<? super Boolean> r5) {
        return invoke(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(boolean r2, boolean r3, Continuation<? super Boolean> r4) {
        ScreenObservationControl$isSecure$1 r5 = new ScreenObservationControl$isSecure$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
        r5.Z$0 = r2;
        r5.Z$1 = r3;
        return r5.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        boolean r3 = this.Z$0;
        return Boxing.boxBoolean(this.Z$1 | r3);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
