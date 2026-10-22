package com.larus.dora.impl.ota.network;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.common.apphost.AppHost;
import g49.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.network.DoraOTANetworkHelper$postToCheckNetworkNotAvailable$1", f = "DoraOTANetworkHelper.kt", i = {0}, l = {127}, m = "invokeSuspend", n = {"i"}, s = {"I$0"})
final class DoraOTANetworkHelper$postToCheckNetworkNotAvailable$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    int I$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public DoraOTANetworkHelper$postToCheckNetworkNotAvailable$1(Function1<? super Boolean, Unit> r1, Continuation<? super DoraOTANetworkHelper$postToCheckNetworkNotAvailable$1> r2) {
        this.$callback = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraOTANetworkHelper$postToCheckNetworkNotAvailable$1(this.$callback, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x002f -> B:14:0x0032). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$0;
        ResultKt.throwOnFailure(r8);
        DoraOTANetworkHelper$postToCheckNetworkNotAvailable$1 r9 = this;
    L14:
        AppHost.Companion r5 = AppHost.a;
        if (NetworkUtils.isNetworkAvailable(r5.getApplication()) == true) goto L17;
        d.d("DoraOTANetworkHelper", "postToCheckNetworkNotAvailable: network not connected");
    L22:
        r2 = r2 + 1;
    L10:
        if (r2 >= 5) goto L23;
        r9.I$0 = r2;
        r9.label = 1;
        if (DelayKt.delay(200, r9) != r0) goto L14;
        return r0;
    L23:
        d.d("DoraOTANetworkHelper", "postToCheckNetworkNotAvailable: network not connected final");
        r9.$callback.invoke(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    L17:
        if (NetworkUtils.isWifi(r5.getApplication()) == false) goto L19;
        d.d("DoraOTANetworkHelper", "postToCheckNetworkNotAvailable: wifi connected");
        goto L22
    L19:
        d.d("DoraOTANetworkHelper", "postToCheckNetworkNotAvailable: wifi not connected, other network");
        r9.$callback.invoke(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        r9 = this;
        r2 = 0;
        goto L10
    }
}
