package com.larus.dora.impl.serviceimpl;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import zj4.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.serviceimpl.HealthService$syncBehaviorAwareToggle$2", f = "HealthService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class HealthService$syncBehaviorAwareToggle$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ boolean $isEnabled;
    int label;
    final /* synthetic */ HealthService this$0;

    public HealthService$syncBehaviorAwareToggle$2(boolean r1, HealthService r2, Continuation<? super HealthService$syncBehaviorAwareToggle$2> r3) {
        this.$isEnabled = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new HealthService$syncBehaviorAwareToggle$2(this.$isEnabled, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r7);
        boolean r8 = this.$isEnabled;
        HealthService r1 = this.this$0;     // Catch: Throwable -> L9
        int r2 = HealthService.d;     // Catch: Throwable -> L9
        r1.getClass();     // Catch: Throwable -> L9
        a r3 = HealthService.h();     // Catch: Throwable -> L9
        if (r3 == null) goto L11;
        int r4 = r3.a(r8 ? 1 : 0);     // Catch: Throwable -> L9
    L12:
        if (r4 != 0) goto L14;
        boolean r5 = true;
    L15:
        FLogger.a.i("HealthService", "syncBehaviorAwareToggle: isEnabled=" + this.$isEnabled + ", toggleValue=" + (r8 ? 1 : 0) + ", ret=" + r4 + ", isSuccess=" + r5);
        return Boxing.boxBoolean(r5);
    L14:
        r5 = false;
    L11:
        r4 = -1;
    L9:
        th = move-exception;
        FLogger.a.e("HealthService", "syncBehaviorAwareToggle failed", th);
        goto L11
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
