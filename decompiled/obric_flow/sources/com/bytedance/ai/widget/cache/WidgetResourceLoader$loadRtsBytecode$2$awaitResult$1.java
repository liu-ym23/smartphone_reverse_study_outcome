package com.bytedance.ai.widget.cache;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.r;
import kotlinx.coroutines.s;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.cache.WidgetResourceLoader$loadRtsBytecode$2$awaitResult$1", f = "WidgetResourceLoader.kt", i = {}, l = {316}, m = "invokeSuspend", n = {}, s = {})
final class WidgetResourceLoader$loadRtsBytecode$2$awaitResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f2947b;

    public WidgetResourceLoader$loadRtsBytecode$2$awaitResult$1(r r5, Continuation r10) {
        this.f2947b = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new WidgetResourceLoader$loadRtsBytecode$2$awaitResult$1(this.f2947b, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super byte[]> r10) {
        r r11 = this.f2947b;
        return new WidgetResourceLoader$loadRtsBytecode$2$awaitResult$1(r11, r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f2946a;
        if (r11 == 0) goto L9;
        if (r11 != 1) goto L8;
        ResultKt.throwOnFailure(r5);
        return r5;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        r r12 = this.f2947b;
        this.f2946a = 1;
        Object r13 = ((s) r12).d(this);
        if (r13 != r10) goto L12;
        return r10;
    L12:
        return r13;
    }
}
