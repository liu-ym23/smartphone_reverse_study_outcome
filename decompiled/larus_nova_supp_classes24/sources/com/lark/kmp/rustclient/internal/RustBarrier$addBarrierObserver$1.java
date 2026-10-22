package com.lark.kmp.rustclient.internal;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.lang.ref.WeakReference;
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
@DebugMetadata(c = "com.lark.kmp.rustclient.internal.RustBarrier$addBarrierObserver$1", f = "RustBarrier.kt", i = {0, 1}, l = {109, 45}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
final class RustBarrier$addBarrierObserver$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.lark.kmp.rustclient.barrier.b $observer;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RustBarrier this$0;

    public RustBarrier$addBarrierObserver$1(RustBarrier r1, com.lark.kmp.rustclient.barrier.b r2, Continuation<? super RustBarrier$addBarrierObserver$1> r3) {
        this.this$0 = r1;
        this.$observer = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RustBarrier$addBarrierObserver$1(this.this$0, this.$observer, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L12;
        RustBarrier r2 = (RustBarrier) this.L$2;
        com.lark.kmp.rustclient.barrier.b r3 = (com.lark.kmp.rustclient.barrier.b) this.L$1;
        kotlinx.coroutines.sync.a r4 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L9
    L22:
        r2.f.add(new WeakReference(r3));     // Catch: Throwable -> L9
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r4.unlock(null);
        return Unit.INSTANCE;
    L9:
        th = th;
        kotlinx.coroutines.sync.a r5 = r4;
    L27:
        r5.unlock(null);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        RustBarrier r6 = (RustBarrier) this.L$2;
        com.lark.kmp.rustclient.barrier.b r7 = (com.lark.kmp.rustclient.barrier.b) this.L$1;
        r5 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r8);
        RustBarrier r10 = r6;
        r3 = r7;
    L29:
        boolean r11 = r10.b.c();     // Catch: Throwable -> L26
        this.L$0 = r5;     // Catch: Throwable -> L26
        this.L$1 = r3;     // Catch: Throwable -> L26
        this.L$2 = r10;     // Catch: Throwable -> L26
        this.label = 2;     // Catch: Throwable -> L26
        if (r3.a(r11, this) != r0) goto L21;
        return r0;
    L21:
        r2 = r10;
        r4 = r5;
    L26:
        th = th;
        goto L27
    L14:
        ResultKt.throwOnFailure(r8);
        r10 = this.this$0;
        kotlinx.coroutines.sync.a r12 = r10.e;
        com.lark.kmp.rustclient.barrier.b r13 = this.$observer;
        this.L$0 = r12;
        this.L$1 = r13;
        this.L$2 = r10;
        this.label = 1;
        if (r12.a(null, this) != r0) goto L17;
        return r0;
    L17:
        r5 = r12;
        r3 = r13;
        goto L29
    }
}
