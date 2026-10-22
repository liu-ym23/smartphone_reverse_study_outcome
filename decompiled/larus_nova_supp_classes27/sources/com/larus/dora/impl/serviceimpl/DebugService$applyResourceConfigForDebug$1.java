package com.larus.dora.impl.serviceimpl;

import android.os.Handler;
import com.larus.dora.impl.resource.d0;
import com.larus.dora.impl.resource.f;
import com.larus.dora.impl.resource.g;
import com.larus.platform.service.AccountService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.serviceimpl.DebugService$applyResourceConfigForDebug$1", f = "DebugService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DebugService$applyResourceConfigForDebug$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<t39.p, Unit> $callback;
    final /* synthetic */ String $config;
    int label;
    final /* synthetic */ h this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public DebugService$applyResourceConfigForDebug$1(h r1, String r2, Function1<? super t39.p, Unit> r3, Continuation<? super DebugService$applyResourceConfigForDebug$1> r4) {
        this.this$0 = r1;
        this.$config = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DebugService$applyResourceConfigForDebug$1(this.this$0, this.$config, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r4);
        String r5 = AccountService.a.getUserId();
        if ((!StringsKt.isBlank(r5)) == true) goto L8;
        r5 = null;
    L8:
        if (r5 != null) goto L11;
        Handler r6 = this.this$0.e;
        final Function1<t39.p, Unit> r0 = this.$callback;
        r6.post(new i(r0));
        return Unit.INSTANCE;
    L11:
        f r7 = f.a;
        String r1 = this.$config;
        r7.getClass();
        g r8 = f.a(r1);
        if (r8 != null) goto L14;
    L18:
        Handler r9 = this.this$0.e;
        final Function1<t39.p, Unit> r2 = this.$callback;
        r9.post(new j(r2));
        return Unit.INSTANCE;
    L14:
        if ((!r8.b.isEmpty()) == true) goto L18;
        final t39.p r10 = ((d0) this.this$0.d.getValue()).n(r8);
        Handler r3 = this.this$0.e;
        final Function1<t39.p, Unit> r11 = this.$callback;
        r3.post(new k(r11, r10));
        return Unit.INSTANCE;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
