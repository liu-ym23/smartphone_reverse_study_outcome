package com.obric.oui.window.listener;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import ga.f;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.obric.oui.window.listener.WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1", f = "WindowConfigChangeListener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Observer $observer;
    final /* synthetic */ LifecycleOwner $owner;
    int label;

    WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1(LifecycleOwner r10, Observer r11, Continuation r12) {
        this.$owner = r10;
        this.$observer = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        return new WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1(this.$owner, this.$observer, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return ((WindowConfigChangeListener$Companion$observeByObserverOnMainThread$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r10);
        NextLiveData<f> r11 = WindowConfigChangeListener.Companion.c(this.$owner);
        if (r11 == null) goto L8;
        r11.observe(this.$owner, this.$observer);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
