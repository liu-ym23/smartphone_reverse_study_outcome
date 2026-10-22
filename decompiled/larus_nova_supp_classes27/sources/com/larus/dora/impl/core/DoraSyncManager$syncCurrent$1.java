package com.larus.dora.impl.core;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.DoraSimpleDevice;
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
@DebugMetadata(c = "com.larus.dora.impl.core.DoraSyncManager$syncCurrent$1", f = "DoraSyncManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraSyncManager$syncCurrent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $syncEvent;
    int label;

    public DoraSyncManager$syncCurrent$1(String r1, Continuation<? super DoraSyncManager$syncCurrent$1> r2) {
        this.$syncEvent = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraSyncManager$syncCurrent$1(this.$syncEvent, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r3);
        DoraDevice r4 = DoraAdapterExtKt.h(kj4.a.g());
        int r0 = 2;
        if (r4 != null) goto L7;
        com.larus.dora.impl.util.b0.a.getClass();
        DoraSimpleDevice r5 = com.larus.dora.impl.util.b0.l();
        if (r5 == null) goto L19;
        String r6 = r5.getSerialNumber();
        if (r6 == null) goto L19;
        DoraSyncManager.b(r6, 2, this.$syncEvent);
    L19:
        return Unit.INSTANCE;
    L7:
        if (kj4.a.g().getDoraLinkState(r4) != 2) goto L9;
        r0 = 1;
    L9:
        CoroutineScope r1 = DoraSyncManager.a;
        String r7 = r4.getSerialNumber();
        if (r7 != null) goto L12;
        r7 = "";
    L12:
        DoraSyncManager.b(r7, r0, this.$syncEvent);
        goto L19
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
