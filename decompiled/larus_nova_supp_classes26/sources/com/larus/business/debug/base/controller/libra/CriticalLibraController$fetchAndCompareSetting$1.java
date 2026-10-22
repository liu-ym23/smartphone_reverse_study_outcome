package com.larus.business.debug.base.controller.libra;

import com.bytedance.common.utility.NetworkClient;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import ft9.g;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.debug.base.controller.libra.CriticalLibraController$fetchAndCompareSetting$1", f = "CriticalLibraController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CriticalLibraController$fetchAndCompareSetting$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $callback;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public CriticalLibraController$fetchAndCompareSetting$1(Function1<? super String, Unit> r1, Continuation<? super CriticalLibraController$fetchAndCompareSetting$1> r2) {
        this.$callback = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CriticalLibraController$fetchAndCompareSetting$1(this.$callback, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r8);
        String r9 = d.a;
        StringBuilder r10 = new StringBuilder();
        String r0 = g.a;
        r10.append(g.a);
        r10.append("?app=1");
        r10.append("&aid=" + AppHost.a.getAppId());
        r10.append("&default=1");
        String r11 = NetworkClient.getDefault().post(r10.toString(), new byte[1], false, "application/json", true);     // Catch: Throwable -> L7
    L9:
        Function1<String, Unit> r1 = this.$callback;
        if (r1 == null) goto L13;
        r1.invoke(r11);
    L13:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        FLogger.a.e("CriticalLibraController", "executeSettingPost error: " + th);
        r11 = null;
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
