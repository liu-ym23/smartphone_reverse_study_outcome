package com.larus.xbridge.custom;

import android.os.SystemClock;
import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.xbridge.custom.BizUtilAuthorizationMethod$handle$1", f = "BizUtilAuthorizationMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BizUtilAuthorizationMethod$handle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IvyBridgeMethod.a $callback;
    final /* synthetic */ cx7.d $params;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ s0 this$0;

    public BizUtilAuthorizationMethod$handle$1(s0 r1, IvyBridgeMethod.a r2, cx7.d r3, Continuation<? super BizUtilAuthorizationMethod$handle$1> r4) {
        this.this$0 = r1;
        this.$callback = r2;
        this.$params = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        BizUtilAuthorizationMethod$handle$1 r0 = new BizUtilAuthorizationMethod$handle$1(this.this$0, this.$callback, this.$params, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r12);
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        long r0 = SystemClock.elapsedRealtime();
        FLogger.a.i("BizUtilAuthorization", "handle async started, method=" + this.this$0.b);
        s0 r14 = this.this$0;
        cx7.d r2 = this.$params;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L7
        Object r15 = Result.constructor-impl(r14.f(r2));     // Catch: Throwable -> L7
    L9:
        s0 r3 = this.this$0;
        Throwable r5 = Result.exceptionOrNull-impl(r15);
        if (r5 == null) goto L13;
        FLogger.a.e("BizUtilAuthorization", "handle failed, method=" + r3.b + ", duration=" + (SystemClock.elapsedRealtime() - r0) + "ms", r5);
    L13:
        if (Result.exceptionOrNull-impl(r15) == null) goto L16;
        r15 = MapsKt.emptyMap();
    L16:
        Map r16 = (Map) r15;
        FLogger.a.i("BizUtilAuthorization", "handle success, method=" + this.this$0.b + ", resultSize=" + r16.size() + ", duration=" + (SystemClock.elapsedRealtime() - r0) + "ms");
        bx7.c.d(this.this$0, this.$callback, MapsKt.toMutableMap(r16));
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
