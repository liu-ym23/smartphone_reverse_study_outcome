package com.bytedance.ai.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.utils.LifecycleRegistryExtKt$changeTo$1", f = "LifecycleRegistryExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LifecycleRegistryExtKt$changeTo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Lifecycle.Event $event;
    final /* synthetic */ LifecycleRegistry $this_changeTo;
    int label;

    public LifecycleRegistryExtKt$changeTo$1(Lifecycle.Event r1, LifecycleRegistry r10, Continuation<? super LifecycleRegistryExtKt$changeTo$1> r11) {
        this.$event = r1;
        this.$this_changeTo = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new LifecycleRegistryExtKt$changeTo$1(this.$event, this.$this_changeTo, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r10);
        g r11 = g.a;
        r11.d("LifecycleRegistry", "LifecycleRegistry changeTo " + this.$event);
        if (this.$event != Lifecycle.Event.ON_DESTROY) goto L7;
    L9:
        LifecycleRegistry r12 = this.$this_changeTo;
        Lifecycle.Event r0 = this.$event;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L12
        r12.handleLifecycleEvent(r0);     // Catch: Throwable -> L12
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L18;
        Lifecycle.Event r1 = this.$event;
        g r16 = g.a;
        StringBuilder r17 = new StringBuilder("Unable to handleLifecycleEvent ");
        r17.append(r1);
        r17.append(' ');
        r15.printStackTrace();
        r17.append(Unit.INSTANCE);
        r16.e("LifecycleRegistry", r17.toString());
    L18:
        return Unit.INSTANCE;
    L12:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L7:
        if (this.$this_changeTo.getCurrentState() != Lifecycle.State.DESTROYED) goto L9;
        r11.e("LifecycleRegistry", "Unable to " + this.$event + " current state is " + this.$this_changeTo.getCurrentState());
        goto L18
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
