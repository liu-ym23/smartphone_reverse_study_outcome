package com.bytedance.ai.uiu;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.uiu.UIUContextManager$getTargetPagesUiContext$2$pageContextTasks$1$1", f = "UIUContextManager.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
final class UIUContextManager$getTargetPagesUiContext$2$pageContextTasks$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ai.model.widgets.a f2807b;

    public UIUContextManager$getTargetPagesUiContext$2$pageContextTasks$1$1(com.bytedance.ai.model.widgets.a r5, Continuation r10) {
        this.f2807b = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new UIUContextManager$getTargetPagesUiContext$2$pageContextTasks$1$1(this.f2807b, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super String> r10) {
        com.bytedance.ai.model.widgets.a r11 = this.f2807b;
        return new UIUContextManager$getTargetPagesUiContext$2$pageContextTasks$1$1(r11, r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f2806a;
        if (r11 == 0) goto L9;
        if (r11 != 1) goto L8;
        ResultKt.throwOnFailure(r5);
        return r5;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        com.bytedance.ai.model.widgets.a r12 = this.f2807b;
        this.f2806a = 1;
        Object r13 = c.c(r12, this);
        if (r13 != r10) goto L12;
        return r10;
    L12:
        return r13;
    }
}
