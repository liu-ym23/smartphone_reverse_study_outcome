package com.obric.aee;

import android.os.Bundle;
import com.obric.aee.impl.EngineBridge;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.l;
import y6.b;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aee.ExecutionEngine$runPackageStreamingAsFlow$1", f = "ExecutionEngine.kt", i = {0}, l = {156, 165}, m = "invokeSuspend", n = {"$this$callbackFlow"}, s = {"L$0"})
final class ExecutionEngine$runPackageStreamingAsFlow$1 extends SuspendLambda implements Function2<l<? super Bundle>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $args;
    final /* synthetic */ Bundle $context;
    final /* synthetic */ String $event;
    final /* synthetic */ b $pack;
    private /* synthetic */ Object L$0;
    int label;

    ExecutionEngine$runPackageStreamingAsFlow$1(String r10, b r11, Bundle r12, Bundle r13, Continuation<? super ExecutionEngine$runPackageStreamingAsFlow$1> r14) {
        this.$event = r10;
        this.$pack = r11;
        this.$args = r12;
        this.$context = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ExecutionEngine$runPackageStreamingAsFlow$1 r12 = new ExecutionEngine$runPackageStreamingAsFlow$1(this.$event, this.$pack, this.$args, this.$context, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l<? super Bundle> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l<? super Bundle> r10, Continuation<? super Unit> r11) {
        return ((ExecutionEngine$runPackageStreamingAsFlow$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.channels.n] */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.channels.l] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r11 = this.label;
        if (r11 == 0) goto L12;
        if (r11 == 1) goto L9;
        if (r11 != 2) goto L8;
        ResultKt.throwOnFailure(r13);
    L25:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        l r12 = (l) this.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L19
        r11 = r12;
    L26:
    L21:
        AnonymousClass2 r14 = AnonymousClass2.INSTANCE;
        this.L$0 = null;
        this.label = 2;
        if (ProduceKt.a(r11, r14, this) != r10) goto L25;
        return r10;
    L12:
        ResultKt.throwOnFailure(r13);
        final l r15 = (l) this.L$0;
        if (StringsKt.startsWith$default(this.$event, '_', false, 2, null) == false) goto L16;
        r15.w(new IllegalArgumentException("event start with _ is reserved."));
        return Unit.INSTANCE;
    L16:
        EngineBridge r16 = EngineBridge.INSTANCE;     // Catch: Throwable -> L19
        b r17 = this.$pack;     // Catch: Throwable -> L19
        Bundle r18 = this.$args;     // Catch: Throwable -> L19
        String r19 = this.$event;     // Catch: Throwable -> L19
        Bundle r20 = this.$context;     // Catch: Throwable -> L19
        Function2<Bundle, Boolean, Unit> r110 = new AnonymousClass1(r15);     // Catch: Throwable -> L19
        this.L$0 = r15;     // Catch: Throwable -> L19
        this.label = 1;     // Catch: Throwable -> L19
        r11 = r15;
        if (r16.runPackageSteaming(r17, r18, r19, r20, r110, this) != r10) goto L26;
        return r10;
    L19:
        th = move-exception;
        r11.w(th);
        goto L21
    }
}
