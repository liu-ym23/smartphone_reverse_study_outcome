package com.bytedance.ai.utils;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.utils.CoroutineDebouncer$debounce$2", f = "CoroutineDebouncer.kt", i = {}, l = {33, 34}, m = "invokeSuspend", n = {}, s = {})
final class CoroutineDebouncer$debounce$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f2839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function2 f2840c;
    public final /* synthetic */ Integer d;

    public CoroutineDebouncer$debounce$2(a r5, Function2 r10, Integer r11, Continuation r12) {
        this.f2839b = r5;
        this.f2840c = r10;
        this.d = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new CoroutineDebouncer$debounce$2(this.f2839b, this.f2840c, this.d, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((CoroutineDebouncer$debounce$2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f2838a;
        if (r11 == 0) goto L10;
        if (r11 == 1) goto L9;
        if (r11 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L13:
        Function2 r12 = this.f2840c;
        Integer r13 = this.d;
        this.f2838a = 2;
        if (r12.mo2invoke(r13, this) != r5) goto L17;
    L15:
        return r5;
    L10:
        ResultKt.throwOnFailure(r10);
        long r14 = this.f2839b.f2843a;
        this.f2838a = 1;
        if (DelayKt.delay(r14, this) != r5) goto L13;
        goto L13
    }
}
