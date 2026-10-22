package com.larus.dora.impl.core;

import com.bytedance.dora.device.DoraDevice;
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
import sk4.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraProtocol$requestProtocolInfo$1", f = "DoraProtocol.kt", i = {0}, l = {66}, m = "invokeSuspend", n = {"i"}, s = {"I$0"})
final class DoraProtocol$requestProtocolInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    int I$0;
    int label;

    public DoraProtocol$requestProtocolInfo$1(DoraDevice r1, Continuation<? super DoraProtocol$requestProtocolInfo$1> r2) {
        this.$device = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraProtocol$requestProtocolInfo$1(this.$device, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0075 -> B:21:0x0078). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$0;
        ResultKt.throwOnFailure(r7);
        DoraProtocol$requestProtocolInfo$1 r8 = this;
    L21:
        r2 = r2 + 1;
    L10:
        if (r2 >= 11) goto L23;
        e r3 = kj4.a.g().requestProtocolInfo();
        g49.d.d("DoraProtocol", "requestProtocolInfo: protocol=" + r3 + ", retry " + r2);
        if (r3 == null) goto L18;
        e r4 = o0.a;
        o0.a = r3;
        e r5 = o0.a;
        DoraDevice r9 = r8.$device;
        if (r9 == null) goto L16;
        String r10 = r9.sn;
    L17:
        o0.h(r10, r3);
        kj4.a.g().b.p = DoraAdapterExtKt.w(kj4.a.g());
        goto L23
    L16:
        r10 = null;
        goto L17
    L18:
        r8.I$0 = r2;
        r8.label = 1;
        if (DelayKt.delay(600, r8) != r0) goto L21;
        return r0;
    L23:
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
