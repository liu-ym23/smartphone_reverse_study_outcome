package com.larus.dora.impl.ota.g2;

import com.larus.dora.impl.ota.c;
import com.larus.dora.impl.ota.connector.DoraOTAWifiConnector;
import com.larus.dora.impl.ota.g.DoraGOTAPlugin;
import com.larus.dora.impl.ota.g.u;
import g49.d;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.g2.DoraG2OtaTransport$upload$1", f = "G2OtaRuntime.kt", i = {}, l = {933}, m = "invokeSuspend", n = {}, s = {})
final class DoraG2OtaTransport$upload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ p4$a $callback;
    final /* synthetic */ String $filePath;
    final /* synthetic */ Ref.ObjectRef<Job> $job;
    final /* synthetic */ e $key;
    final /* synthetic */ i$b $operation;
    final /* synthetic */ long $operationId;
    final /* synthetic */ String $ownerId;
    final /* synthetic */ e5 $spec;
    int label;
    final /* synthetic */ i this$0;

    public DoraG2OtaTransport$upload$1(i r1, e r2, p4$a r3, String r4, e5 r5, i$b r6, Ref.ObjectRef<Job> r7, long r8, String r10, Continuation<? super DoraG2OtaTransport$upload$1> r11) {
        this.this$0 = r1;
        this.$key = r2;
        this.$callback = r3;
        this.$ownerId = r4;
        this.$spec = r5;
        this.$operation = r6;
        this.$job = r7;
        this.$operationId = r8;
        this.$filePath = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new DoraG2OtaTransport$upload$1(this.this$0, this.$key, this.$callback, this.$ownerId, this.$spec, this.$operation, this.$job, this.$operationId, this.$filePath, r14);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = this.label;
        if (r5 == 0) goto L9;
        if (r5 != 1) goto L8;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L19
        Object r6 = r18;
    L24:
        c r7 = (c) r6;     // Catch: Throwable -> L19
        Object r8 = i.h(this.this$0);     // Catch: Throwable -> L19
        Ref.ObjectRef<Job> r9 = this.$job;     // Catch: Throwable -> L19
        i r10 = this.this$0;     // Catch: Throwable -> L19
        e r11 = this.$key;     // Catch: Throwable -> L19
        p4$a r15 = this.$callback;     // Catch: Throwable -> L19
        String r12 = this.$ownerId;     // Catch: Throwable -> L19
        long r13 = this.$operationId;     // Catch: Throwable -> L19
        String r14 = this.$filePath;     // Catch: Throwable -> L19
        monitor-enter(r8);     // Catch: Throwable -> L19
        Object r16 = r9.element;     // Catch: Throwable -> L35
        if (r16 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("job");     // Catch: Throwable -> L35
        Job r17 = null;
    L31:
        if (r17.isActive() == true) goto L33;
    L51:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L35
        monitor-exit(r8);     // Catch: Throwable -> L19
        ConcurrentHashMap r1 = i.i(this.this$0);
        i$b r2 = this.$operation;
        Object r3 = this.$job.element;
        if (r3 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("job");
        Job r20 = null;
    L57:
        r1.remove(r2, r20);
        return Unit.INSTANCE;
    L56:
        r20 = (Job) r3;
        goto L57
    L33:
        if (r10.k(r11) == true) goto L38;
        r15.b(false, FailureReason.DEVICE_UNBOUND);     // Catch: Throwable -> L35
        DoraOTAWifiConnector r21 = i.f(r10);     // Catch: Throwable -> L35
        String r22 = i.l(r11, r12);     // Catch: Throwable -> L35
        r21.getClass();     // Catch: Throwable -> L35
        DoraOTAWifiConnector.g(r22);     // Catch: Throwable -> L35
        goto L51
    L38:
        if (Intrinsics.areEqual(r7, c.a.a) == false) goto L44;
        FailureReason r23 = r15.a();     // Catch: Throwable -> L35
        if (r23 != null) goto L42;
        i.j(r10, r11, r12, r13, r14, r15);     // Catch: Throwable -> L35
        goto L51
    L42:
        d.e("G2OtaTransport", "upload start blocked owner=" + r12 + " operation=" + r13 + " reason=" + r23);     // Catch: Throwable -> L35
        r15.b(false, r23);     // Catch: Throwable -> L35
        DoraOTAWifiConnector r24 = i.f(r10);     // Catch: Throwable -> L35
        String r25 = i.l(r11, r12);     // Catch: Throwable -> L35
        r24.getClass();     // Catch: Throwable -> L35
        DoraOTAWifiConnector.g(r25);     // Catch: Throwable -> L35
        goto L51
    L44:
        if ((r7 instanceof u.e) == false) goto L46;
        d.d("G2OtaTransport", "upload skipped owner=" + r12 + " operation=" + r13 + " status=" + ((u.e) r7).a);     // Catch: Throwable -> L35
        r15.b(true, FailureReason.NONE);     // Catch: Throwable -> L35
        DoraOTAWifiConnector r26 = i.f(r10);     // Catch: Throwable -> L35
        String r27 = i.l(r11, r12);     // Catch: Throwable -> L35
        r26.getClass();     // Catch: Throwable -> L35
        DoraOTAWifiConnector.g(r27);     // Catch: Throwable -> L35
        goto L51
    L46:
        d.b("G2OtaTransport", "prepare peripheral failed owner=" + r12 + " operation=" + r13 + " reason=" + r7.a());     // Catch: Throwable -> L35
        if (Intrinsics.areEqual(r7, u.c.a) == false) goto L49;
        FailureReason r28 = FailureReason.PERIPHERAL_LOW_BATTERY;     // Catch: Throwable -> L35
    L50:
        r15.b(false, r28);     // Catch: Throwable -> L35
        DoraOTAWifiConnector r30 = i.f(r10);     // Catch: Throwable -> L35
        String r31 = i.l(r11, r12);     // Catch: Throwable -> L35
        r30.getClass();     // Catch: Throwable -> L35
        DoraOTAWifiConnector.g(r31);     // Catch: Throwable -> L35
        goto L51
    L49:
        r28 = FailureReason.TRANSFER_FAILED;     // Catch: Throwable -> L35
        goto L50
    L29:
        r17 = (Job) r16;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r18);
        i r32 = this.this$0;     // Catch: Throwable -> L19
        e r33 = this.$key;     // Catch: Throwable -> L19
        String r110 = i.TAG;     // Catch: Throwable -> L19
        if (r32.k(r33) == true) goto L21;
        this.$callback.b(false, FailureReason.DEVICE_UNBOUND);     // Catch: Throwable -> L19
        DoraOTAWifiConnector r34 = i.f(this.this$0);     // Catch: Throwable -> L19
        i r35 = this.this$0;     // Catch: Throwable -> L19
        e r36 = this.$key;     // Catch: Throwable -> L19
        String r37 = this.$ownerId;     // Catch: Throwable -> L19
        r35.getClass();     // Catch: Throwable -> L19
        String r38 = i.l(r36, r37);     // Catch: Throwable -> L19
        r34.getClass();     // Catch: Throwable -> L19
        DoraOTAWifiConnector.g(r38);     // Catch: Throwable -> L19
        Unit r40 = Unit.INSTANCE;     // Catch: Throwable -> L19
        ConcurrentHashMap r41 = i.i(this.this$0);
        i$b r42 = this.$operation;
        Object r43 = this.$job.element;
        if (r43 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("job");
        Job r44 = null;
    L17:
        r41.remove(r42, r44);
        return r40;
    L16:
        r44 = (Job) r43;
        goto L17
    L21:
        DoraGOTAPlugin r45 = i.g(this.this$0);     // Catch: Throwable -> L19
        e49.a r46 = e4.a(this.$spec);     // Catch: Throwable -> L19
        this.label = 1;     // Catch: Throwable -> L19
        r6 = r45.a(r46, this);     // Catch: Throwable -> L19
        if (r6 != r4) goto L24;
        return r4;
    L19:
        th = move-exception;
        ConcurrentHashMap r47 = i.i(this.this$0);
        i$b r48 = this.$operation;
        Object r50 = this.$job.element;
        if (r50 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("job");
        Job r51 = null;
    L65:
        r47.remove(r48, r51);
        throw th;
    L64:
        r51 = (Job) r50;
        goto L65
    }
}
