package com.obric.memorydata.recommend.useraction.recommend;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.recommend.useraction.recommend.RecommendManager$init$2", f = "RecommendManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RecommendManager$init$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;

    RecommendManager$init$2(Continuation<? super RecommendManager$init$2> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        RecommendManager$init$2 r4 = new RecommendManager$init$2((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        r4.Z$0 = ((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        return (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Boolean r3, Continuation<? super Unit> r4) {
        return invoke(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(boolean r3, Continuation<? super Unit> r4) {
        Continuation<?> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return ((RecommendManager$init$2) ZeusTransformUtils.preCheckCast(create(Boolean.valueOf(r3), r5), RecommendManager$init$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r9);
        boolean r8 = this.Z$0;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RecommendManager", "screenObservationMemoryEnabled change " + r8, false, 4, null);
        b.f12763a.a(b.a(b.f12763a));
        b r10 = b.f12763a;
        boolean r0 = true;
        if (r8 == false) goto L7;
    L10:
        b.a(r10, r0);
        return Unit.INSTANCE;
    L7:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(com.obric.memorydata.recommend.screenshotupload.b.f12542a.b(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L10;
        r0 = false;
        goto L10
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
