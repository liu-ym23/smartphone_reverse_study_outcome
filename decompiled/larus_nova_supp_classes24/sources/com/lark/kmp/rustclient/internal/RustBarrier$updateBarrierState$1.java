package com.lark.kmp.rustclient.internal;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.lark.kmp.rustclient.internal.RustBarrier$updateBarrierState$1", f = "RustBarrier.kt", i = {0, 0}, l = {109}, m = "invokeSuspend", n = {"$this$launch", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
public final class RustBarrier$updateBarrierState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Function1<Continuation<? super Unit>, Object>> $cacheCopy;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ RustBarrier this$0;

    public RustBarrier$updateBarrierState$1(RustBarrier r1, List<Function1<Continuation<? super Unit>, Object>> r2, Continuation<? super RustBarrier$updateBarrierState$1> r3) {
        this.this$0 = r1;
        this.$cacheCopy = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        RustBarrier$updateBarrierState$1 r0 = new RustBarrier$updateBarrierState$1(this.this$0, this.$cacheCopy, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        RustBarrier r2 = (RustBarrier) this.L$3;
        List<Function1<Continuation<? super Unit>, Object>> r3 = (List) this.L$2;
        kotlinx.coroutines.sync.a r4 = (kotlinx.coroutines.sync.a) this.L$1;
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r11);
        CoroutineScope r12 = r5;
    L22:
        r3.addAll(r2.d);     // Catch: Throwable -> L19
        ((ArrayList) r2.d).clear();     // Catch: Throwable -> L19
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L19
        r4.unlock(null);
        Iterator<T> r7 = this.$cacheCopy.iterator();
    L15:
        if (r7.hasNext() == false) goto L18;
        CoroutineScope r8 = r12;
        BuildersKt.launch$default(r8, null, null, new RustBarrier$updateBarrierState$1$2$1((Function1) r7.next(), null), 3, null);
        goto L15
    L18:
        return Unit.INSTANCE;
    L19:
        th = move-exception;
        r4.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        RustBarrier r13 = this.this$0;
        kotlinx.coroutines.sync.a r10 = r13.c;
        List<Function1<Continuation<? super Unit>, Object>> r14 = this.$cacheCopy;
        this.L$0 = r9;
        this.L$1 = r10;
        this.L$2 = r14;
        this.L$3 = r13;
        this.label = 1;
        if (r10.a(null, this) != r0) goto L11;
        return r0;
    L11:
        r2 = r13;
        r4 = r10;
        r12 = r9;
        r3 = r14;
        goto L22
    }
}
