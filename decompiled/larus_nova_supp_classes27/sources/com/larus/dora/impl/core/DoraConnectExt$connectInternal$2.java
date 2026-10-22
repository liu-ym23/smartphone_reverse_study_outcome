package com.larus.dora.impl.core;

import com.bytedance.dora.device.DoraDevice;
import com.larus.account.base.api.ILoginService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraConnectExt$connectInternal$2", f = "DoraConnectExt.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
final class DoraConnectExt$connectInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $tarDevice;
    int label;

    public DoraConnectExt$connectInternal$2(DoraDevice r1, Continuation<? super DoraConnectExt$connectInternal$2> r2) {
        this.$tarDevice = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraConnectExt$connectInternal$2(this.$tarDevice, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        boolean r5 = ((Boolean) r4).booleanValue();
        g49.d.a("DoraConnectExt", "bindBudsAndClearIfNecessaryWithRetry ret " + r5);
        if (r5 == false) goto L15;
        com.larus.dora.impl.util.b0 r6 = com.larus.dora.impl.util.b0.a;
        String r2 = ILoginService.a.getAccountInfo().c;
        String r3 = this.$tarDevice.mac;
        r6.getClass();
        com.larus.dora.impl.util.b0.B(r2, r3);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        kj4.a r7 = kj4.a.g();
        this.label = 1;
        r4 = DoraAdapterExtKt.c(r7, true, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
