package com.bytedance.ai.widget.contianer;

import com.bytedance.ai.model.objects.Widget;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.contianer.AppletWidgetContainer$bindData$5", f = "AppletWidgetContainer.kt", i = {}, l = {580}, m = "invokeSuspend", n = {}, s = {})
final class AppletWidgetContainer$bindData$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppletWidgetContainer f3002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Widget f3003c;
    public final /* synthetic */ com.bytedance.ai.widget.cache.b d;

    public AppletWidgetContainer$bindData$5(AppletWidgetContainer r5, Widget r10, com.bytedance.ai.widget.cache.b r11, Continuation r12) {
        this.f3002b = r5;
        this.f3003c = r10;
        this.d = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new AppletWidgetContainer$bindData$5(this.f3002b, this.f3003c, this.d, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((AppletWidgetContainer$bindData$5) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f3001a;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        AppletWidgetContainer r12 = this.f3002b;
        Widget r13 = this.f3003c;
        com.bytedance.ai.widget.cache.b r14 = this.d;
        this.f3001a = 1;
        if (r12.q(r13, r14, this) != r10) goto L12;
        return r10;
    }
}
