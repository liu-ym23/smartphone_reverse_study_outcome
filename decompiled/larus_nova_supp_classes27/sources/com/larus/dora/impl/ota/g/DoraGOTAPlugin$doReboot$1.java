package com.larus.dora.impl.ota.g;

import com.larus.dora.impl.core.DoraAdapterExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.g.DoraGOTAPlugin$doReboot$1", f = "DoraGOTAPlugin.kt", i = {0}, l = {315}, m = "invokeSuspend", n = {"i"}, s = {"I$0"})
final class DoraGOTAPlugin$doReboot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int label;

    public DoraGOTAPlugin$doReboot$1(Continuation<? super DoraGOTAPlugin$doReboot$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraGOTAPlugin$doReboot$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0053 -> B:17:0x0056). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$0;
        ResultKt.throwOnFailure(r7);
        DoraGOTAPlugin$doReboot$1 r8 = this;
    L17:
        r2 = r2 + 1;
    L10:
        if (r2 >= 3) goto L19;
        int r3 = DoraAdapterExtKt.g(kj4.a.g());
        g49.d.d("DoraGOTAPlugin", "doReboot ret=" + r3 + ", retry " + r2);
        if (r3 == 0) goto L19;
        r8.I$0 = r2;
        r8.label = 1;
        if (DelayKt.delay(100, r8) != r0) goto L17;
        return r0;
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        r8 = this;
        r2 = 0;
        goto L10
    }
}
