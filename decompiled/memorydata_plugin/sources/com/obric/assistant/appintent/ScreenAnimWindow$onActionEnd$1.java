package com.obric.assistant.appintent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.appintent.ScreenAnimWindow$onActionEnd$1", f = "ScreenAnimWindow.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ScreenAnimWindow$onActionEnd$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ b this$0;

    ScreenAnimWindow$onActionEnd$1(b r3, Continuation<? super ScreenAnimWindow$onActionEnd$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    private static final Unit invokeSuspend$lambda$0(b r6) {
        i.a(am.a(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ScreenAnimWindow$onActionEnd$1$1$1(r6, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$AVCLyXRqGP2-NDwWd2ndBu_foM4, reason: not valid java name */
    public static /* synthetic */ Unit m368lambda$AVCLyXRqGP2NDwWd2ndBu_foM4(b r0) {
        return invokeSuspend$lambda$0(r0);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ScreenAnimWindow$onActionEnd$1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ScreenAnimWindow$onActionEnd$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ScreenAnimWindow$onActionEnd$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r2);
        CommonProcessingView r3 = b.a(this.this$0);
        if (r3 == null) goto L8;
        final b r1 = this.this$0;
        r3.a(new $$Lambda$ScreenAnimWindow$onActionEnd$1$AVCLyXRqGP2NDwWd2ndBu_foM4(r1));
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
