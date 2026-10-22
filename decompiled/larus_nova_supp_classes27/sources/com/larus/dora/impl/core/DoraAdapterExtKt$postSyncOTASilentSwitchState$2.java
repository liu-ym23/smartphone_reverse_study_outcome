package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import sk4.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraAdapterExtKt$postSyncOTASilentSwitchState$2", f = "DoraAdapterExt.kt", i = {}, l = {1010}, m = "invokeSuspend", n = {}, s = {})
final class DoraAdapterExtKt$postSyncOTASilentSwitchState$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $switchOn;
    final /* synthetic */ kj4.a $this_postSyncOTASilentSwitchState;
    int label;

    public DoraAdapterExtKt$postSyncOTASilentSwitchState$2(kj4.a r1, boolean r2, Continuation<? super DoraAdapterExtKt$postSyncOTASilentSwitchState$2> r3) {
        this.$this_postSyncOTASilentSwitchState = r1;
        this.$switchOn = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraAdapterExtKt$postSyncOTASilentSwitchState$2(this.$this_postSyncOTASilentSwitchState, this.$switchOn, r4);
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
    L12:
        if (((Boolean) r4).booleanValue() == false) goto L27;
        int r5 = -1;
        int r2 = 0;
    L15:
        if (r2 >= 3) goto L20;
        r5 = this.$this_postSyncOTASilentSwitchState.s(this.$switchOn);
        g49.d.d("DoraAdapterExt", "postSyncOTASilentSwitchState: ret=" + r5 + ", retry " + r2);
        if (r5 == 0) goto L20;
        r2 = r2 + 1;
    L20:
        if (r5 != 0) goto L27;
        int r6 = j69.a.a;
        if (this.$switchOn == false) goto L24;
        String r7 = "on";
    L25:
        j69.a.b("silent_ota_switch", MapsKt.mapOf(TuplesKt.to("status", r7)));
        goto L27
    L24:
        r7 = "off";
    L27:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        e r8 = o0.a;
        this.label = 1;
        r4 = o0.f();
        if (r4 != r0) goto L12;
        return r0;
    }
}
