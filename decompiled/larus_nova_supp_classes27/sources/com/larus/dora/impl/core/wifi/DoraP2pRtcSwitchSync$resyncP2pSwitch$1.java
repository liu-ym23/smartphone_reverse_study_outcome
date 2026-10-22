package com.larus.dora.impl.core.wifi;

import g49.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.wifi.DoraP2pRtcSwitchSync$resyncP2pSwitch$1", f = "DoraP2pRtcSwitchSync.kt", i = {0}, l = {133}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
public final class DoraP2pRtcSwitchSync$resyncP2pSwitch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reason;
    Object L$0;
    Object L$1;
    int label;

    public DoraP2pRtcSwitchSync$resyncP2pSwitch$1(String r1, Continuation<? super DoraP2pRtcSwitchSync$resyncP2pSwitch$1> r2) {
        this.$reason = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraP2pRtcSwitchSync$resyncP2pSwitch$1(this.$reason, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        boolean r5 = true;
        if (r3 == 0) goto L8;
        if (r3 != 1) goto L7;
        String r4 = (String) this.L$1;
        a r6 = (a) this.L$0;
        ResultKt.throwOnFailure(r12);
    L44:
        Object r13 = DoraP2pRtcSwitchSync.b;     // Catch: Throwable -> L40
        monitor-enter(r13);     // Catch: Throwable -> L40
        DoraWifiLinkWrapper.a.getClass();     // Catch: Throwable -> L37
        boolean r7 = DoraP2pRtcSwitchSync.c(DoraWifiLinkWrapper.j());     // Catch: Throwable -> L37
        Boolean r8 = DoraP2pRtcSwitchSync.d;     // Catch: Throwable -> L37
        if (r7 == false) goto L17;
        boolean r9 = true;
    L19:
        if (Intrinsics.areEqual(r8, Boxing.boxBoolean(r9)) == false) goto L29;
        StringBuilder r10 = new StringBuilder("resyncP2pSwitch skip: reason=");     // Catch: Throwable -> L37
        r10.append(r4);     // Catch: Throwable -> L37
        r10.append(", unchanged=");     // Catch: Throwable -> L37
        if (r7 == true) goto L24;
        r5 = false;
    L24:
        r10.append(r5);     // Catch: Throwable -> L37
        d.d("DoraP2pRtcSwitchSync", r10.toString());     // Catch: Throwable -> L37
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L37
        monitor-exit(r13);     // Catch: Throwable -> L40
        r6.unlock(null);
        return r0;
    L29:
        int r1 = DoraP2pRtcSwitchSync.g(r7, Boxing.boxLong(1200));     // Catch: Throwable -> L37
        StringBuilder r11 = new StringBuilder("resyncP2pSwitch: reason=");     // Catch: Throwable -> L37
        r11.append(r4);     // Catch: Throwable -> L37
        r11.append(", enabled=");     // Catch: Throwable -> L37
        if (r7 == true) goto L33;
        r5 = false;
    L33:
        r11.append(r5);     // Catch: Throwable -> L37
        r11.append(", ret=");     // Catch: Throwable -> L37
        r11.append(r1);     // Catch: Throwable -> L37
        d.d("DoraP2pRtcSwitchSync", r11.toString());     // Catch: Throwable -> L37
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L37
        monitor-exit(r13);     // Catch: Throwable -> L40
        r6.unlock(null);
        return Unit.INSTANCE;
    L17:
        r9 = false;
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        r6.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        r6 = DoraP2pRtcSwitchSync.c;
        String r15 = this.$reason;
        this.L$0 = r6;
        this.L$1 = r15;
        this.label = 1;
        if (r6.a(null, this) != r2) goto L11;
        return r2;
    L11:
        r4 = r15;
        goto L44
    }
}
