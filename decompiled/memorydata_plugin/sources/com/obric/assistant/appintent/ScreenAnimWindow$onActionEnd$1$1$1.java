package com.obric.assistant.appintent;

import android.view.View;
import android.view.WindowManager;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.appintent.ScreenAnimWindow$onActionEnd$1$1$1", f = "ScreenAnimWindow.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ScreenAnimWindow$onActionEnd$1$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ b this$0;

    ScreenAnimWindow$onActionEnd$1$1$1(b r3, Continuation<? super ScreenAnimWindow$onActionEnd$1$1$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ScreenAnimWindow$onActionEnd$1$1$1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ScreenAnimWindow$onActionEnd$1$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ScreenAnimWindow$onActionEnd$1$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r5);
        RunLog r6 = RunLog.INSTANCE;
        String r0 = b.c();
        Intrinsics.checkNotNullExpressionValue(r0, "access$getTAG$cp(...)");
        r6.debug(r0, "onActionEnd, onHideAnimEnd");
        CommonProcessingView r7 = b.a(this.this$0);
        boolean r1 = true;
        if (r7 != null) goto L7;
    L9:
        r1 = false;
    L10:
        if (r1 == false) goto L14;
        RunLog r8 = RunLog.INSTANCE;
        String r2 = b.c();
        Intrinsics.checkNotNullExpressionValue(r2, "access$getTAG$cp(...)");
        r8.debug(r2, "onActionEnd, removeView");
        WindowManager r9 = b.b(this.this$0);
        if (r9 == null) goto L14;
        r9.removeView((View) ZeusTransformUtils.preCheckCast(b.a(this.this$0), View.class, "com.obric.memorydata.plugin"));
    L14:
        b.a(this.this$0, null);
        b.c(this.this$0).set(false);
        return Unit.INSTANCE;
    L7:
        if (r7.isAttachedToWindow() != true) goto L9;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
