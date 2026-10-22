package com.lark.kmp.rustclient.internal;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.lark.kmp.rustclient.internal.RustBarrier$notifyBarrierObservers$1", f = "RustBarrier.kt", i = {0, 1, 1}, l = {109, 96}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "iterator"}, s = {"L$0", "L$0", "L$1"})
final class RustBarrier$notifyBarrierObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $currentState;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    final /* synthetic */ RustBarrier this$0;

    public RustBarrier$notifyBarrierObservers$1(RustBarrier r1, boolean r2, Continuation<? super RustBarrier$notifyBarrierObservers$1> r3) {
        this.this$0 = r1;
        this.$currentState = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RustBarrier$notifyBarrierObservers$1(this.this$0, this.$currentState, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 != 2) goto L10;
        boolean r2 = this.Z$0;
        Iterator<WeakReference<com.lark.kmp.rustclient.barrier.b>> r5 = (Iterator) this.L$1;
        kotlinx.coroutines.sync.a r6 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L31
    L18:
        if (r5.hasNext() == false) goto L28;
        com.lark.kmp.rustclient.barrier.b r10 = r5.next().get();     // Catch: Throwable -> L31
        if (r10 != null) goto L21;
        r5.remove();     // Catch: Throwable -> L31
        goto L18
    L21:
        if (r2 == false) goto L23;
        boolean r7 = true;
    L24:
        this.L$0 = r6;     // Catch: Throwable -> L31
        this.L$1 = r5;     // Catch: Throwable -> L31
        this.Z$0 = r2;     // Catch: Throwable -> L31
        this.label = 2;     // Catch: Throwable -> L31
        if (r10.a(r7, this) != r0) goto L18;
        return r0;
    L23:
        r7 = false;
        goto L24
    L28:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L31
        r6.unlock(null);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        r2 = this.Z$0;
        RustBarrier r8 = (RustBarrier) this.L$1;
        r6 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r9);
    L16:
        r5 = r8.f.iterator();     // Catch: Throwable -> L31
        goto L18
    L12:
        ResultKt.throwOnFailure(r9);
        r8 = this.this$0;
        kotlinx.coroutines.sync.a r12 = r8.e;
        r2 = this.$currentState;
        this.L$0 = r12;
        this.L$1 = r8;
        this.Z$0 = r2;
        this.label = 1;
        if (r12.a(null, this) != r0) goto L15;
        return r0;
    L15:
        r6 = r12;
    L31:
        th = move-exception;
        r6.unlock(null);
        throw th;
    }
}
