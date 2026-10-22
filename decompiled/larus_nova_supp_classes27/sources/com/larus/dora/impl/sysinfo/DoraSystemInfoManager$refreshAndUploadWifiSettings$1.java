package com.larus.dora.impl.sysinfo;

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
@DebugMetadata(c = "com.larus.dora.impl.sysinfo.DoraSystemInfoManager$refreshAndUploadWifiSettings$1", f = "DoraSystemInfoManager.kt", i = {}, l = {299}, m = "invokeSuspend", n = {}, s = {})
public final class DoraSystemInfoManager$refreshAndUploadWifiSettings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DoraSystemInfoManager$refreshAndUploadWifiSettings$1(Continuation<? super DoraSystemInfoManager$refreshAndUploadWifiSettings$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraSystemInfoManager$refreshAndUploadWifiSettings$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r5);     // Catch: Exception -> L15
    L13:
        DoraSystemInfoManager.c();     // Catch: Exception -> L15
    L18:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        g49.d.d("DoraSystemInfoManager", "refreshAndUploadWifiSettings: start");
        DoraSystemInfoManager r6 = DoraSystemInfoManager.a;     // Catch: Exception -> L15
        this.label = 1;     // Catch: Exception -> L15
        if (DoraSystemInfoManager.a(r6, this) != r0) goto L13;
        return r0;
    L15:
        e = move-exception;
        g49.d.c("DoraSystemInfoManager", "refreshAndUploadWifiSettings: failed", e);
        goto L18
    }
}
