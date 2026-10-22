package com.larus.dora.impl.bridge;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/larus/dora/impl/bridge/DoraDeviceSettingsSnapshot;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.bridge.DoraDeviceGetCurrentMethod$loadDeviceSettings$cachedSnapshot$1", f = "DoraDeviceGetCurrentMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraDeviceGetCurrentMethod$loadDeviceSettings$cachedSnapshot$1 extends SuspendLambda implements Function1<Continuation<? super n>, Object> {
    int label;

    public DoraDeviceGetCurrentMethod$loadDeviceSettings$cachedSnapshot$1(Continuation<? super DoraDeviceGetCurrentMethod$loadDeviceSettings$cachedSnapshot$1> r2) {
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r2) {
        return new DoraDeviceGetCurrentMethod$loadDeviceSettings$cachedSnapshot$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super n> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        return null;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
