package com.larus.vesdk.impl;

import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.vesdk.impl.VeSDKInitStateManager$startVeInitAsync$2", f = "VeSDKInitStateManager.kt", i = {0}, l = {130}, m = "invokeSuspend", n = {"startTime"}, s = {"J$0"})
final class VeSDKInitStateManager$startVeInitAsync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $initBlock;
    final /* synthetic */ long $timeoutMs;
    long J$0;
    int label;

    /* JADX INFO: renamed from: com.larus.vesdk.impl.VeSDKInitStateManager$startVeInitAsync$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.vesdk.impl.VeSDKInitStateManager$startVeInitAsync$2$1", f = "VeSDKInitStateManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $initBlock;
        int label;

        public AnonymousClass1(Function0<Unit> r1, Continuation<? super AnonymousClass1> r2) {
            this.$initBlock = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$initBlock, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.$initBlock.invoke();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public VeSDKInitStateManager$startVeInitAsync$2(long r1, Function0<Unit> r3, Continuation<? super VeSDKInitStateManager$startVeInitAsync$2> r4) {
        this.$timeoutMs = r1;
        this.$initBlock = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new VeSDKInitStateManager$startVeInitAsync$2(this.$timeoutMs, this.$initBlock, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 != 1) goto L11;
        long r3 = this.J$0;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L8 TimeoutCancellationException -> L26
    L17:
        long r10 = System.currentTimeMillis() - r3;     // Catch: Exception -> L8 TimeoutCancellationException -> L26
        VeSDKInitStateManager.a.getClass();     // Catch: Exception -> L8 TimeoutCancellationException -> L26
        VeSDKInitStateManager.a();     // Catch: Exception -> L8 TimeoutCancellationException -> L26
        FLogger.a.i("VeSDKInitStateManager", "startVeInitAsync: initialization completed successfully, duration=" + r10 + "ms");     // Catch: Exception -> L8 TimeoutCancellationException -> L26
        VeSDKInitStateManager.b(r10, true, null, "async");     // Catch: Exception -> L8 TimeoutCancellationException -> L26
    L25:
        return Unit.INSTANCE;
    L8:
        e = e;
        long r11 = r3;
    L21:
        long r0 = System.currentTimeMillis() - r11;
        FLogger r4 = FLogger.a;
        r4.e("VeSDKInitStateManager", "startVeInitAsync: initialization failed, duration=" + r0 + "ms, error=" + e);
        VeSDKInitStateManager.a.getClass();
        VeSDKInitStateManager.c.set(VeSDKInitStateManager.InitState.TIMEOUT);
        VeSDKInitStateManager.d.countDown();
        r4.e("VeSDKInitStateManager", "markTimeout: state changed to TIMEOUT");
        VeSDKInitStateManager.b(r0, false, e.getMessage(), "async");
    L23:
        long r12 = System.currentTimeMillis() - r3;
        FLogger r16 = FLogger.a;
        r16.e("VeSDKInitStateManager", "startVeInitAsync: initialization timeout after " + r12 + "ms, timeout=" + this.$timeoutMs + "ms");
        VeSDKInitStateManager.a.getClass();
        VeSDKInitStateManager.c.set(VeSDKInitStateManager.InitState.TIMEOUT);
        VeSDKInitStateManager.d.countDown();
        r16.e("VeSDKInitStateManager", "markTimeout: state changed to TIMEOUT");
        VeSDKInitStateManager.b(r12, false, "timeout", "async");
        goto L25
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r15);
        r11 = System.currentTimeMillis();
        long r13 = this.$timeoutMs;     // Catch: Exception -> L20 TimeoutCancellationException -> L22
        AnonymousClass1 r17 = new AnonymousClass1(this.$initBlock, null);     // Catch: Exception -> L20 TimeoutCancellationException -> L22
        this.J$0 = r11;     // Catch: Exception -> L20 TimeoutCancellationException -> L22
        this.label = 1;     // Catch: Exception -> L20 TimeoutCancellationException -> L22
        if (TimeoutKt.b(r13, r17, this) != r1) goto L16;
        return r1;
    L16:
        r3 = r11;
        goto L17
    L20:
        e = e;
    L22:
        r3 = r11;
        goto L23
    }
}
