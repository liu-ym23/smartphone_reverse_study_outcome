package com.larus.dora.impl.core;

import com.bytedance.dora.device.DoraDevice;
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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import mj4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraBTOptimizationManager$sendHeartbeatInfo$1", f = "DoraBTOptimizationManager.kt", i = {0}, l = {621}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class DoraBTOptimizationManager$sendHeartbeatInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMs;
    final /* synthetic */ boolean $isForceUpdate;
    private /* synthetic */ Object L$0;
    int label;

    public DoraBTOptimizationManager$sendHeartbeatInfo$1(long r1, boolean r3, Continuation<? super DoraBTOptimizationManager$sendHeartbeatInfo$1> r4) {
        this.$delayMs = r1;
        this.$isForceUpdate = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        DoraBTOptimizationManager$sendHeartbeatInfo$1 r0 = new DoraBTOptimizationManager$sendHeartbeatInfo$1(this.$delayMs, this.$isForceUpdate, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [int] */
    /* JADX WARN: Type inference failed for: r9v6 */
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r14);
    L13:
        if (CoroutineScopeKt.isActive(r2) == false) goto L15;
        DoraBTOptimizationManager r15 = DoraBTOptimizationManager.a;
        DoraDevice r3 = DoraBTOptimizationManager.a().c();
        if (com.larus.dora.impl.util.s.a() == false) goto L25;
        if (r3 != null) goto L20;
    L22:
        boolean r4 = false;
    L23:
        if (r4 == false) goto L25;
        boolean r5 = true;
    L27:
        if (r5 == true) goto L30;
        g49.d.a("DoraBTOptimizationManager", "sendHeartbeatInfo: skip, G optimization unavailable");
        return Unit.INSTANCE;
    L30:
        int r6 = DoraBTOptimizationManager.b();
        if (this.$isForceUpdate == false) goto L33;
    L36:
        int r7 = DoraBTOptimizationManager.m;
        if (DoraBTOptimizationManager.c() != 1) goto L52;
        if (r7 == 2) goto L42;
        if (r7 == 3) goto L42;
        boolean r8 = false;
    L43:
        if (r8 == false) goto L52;
        if (r6 == 2) goto L48;
        if (r6 == 3) goto L48;
        boolean r9 = false;
    L49:
        if (r9 == true) goto L52;
        g49.d.d("DoraBTOptimizationManager", "checkNetworkStatusChange: exit 2.4G on Qualcomm, scheduleStopHeartbeat, lastStatus=" + r7 + ", currentStatus=" + r6);
        r15.e("exit_24g_qcom");
    L48:
        r9 = true;
    L42:
        r8 = true;
    L52:
        if (CoroutineScopeKt.isActive(r2) == false) goto L54;
        kj4.a r16 = DoraBTOptimizationManager.a();
        b0 r10 = DoraBTOptimizationManager.d().b();
        if (r10 == null) goto L58;
        ?? r11 = Intrinsics.areEqual(r10.b(), Boxing.boxBoolean(true));
    L59:
        int r12 = DoraBTOptimizationManager.c();
        b0 r13 = DoraBTOptimizationManager.d().b();
        if (r13 == null) goto L64;
        Integer r17 = r13.c();
        if (r17 == null) goto L64;
        int r18 = r17.intValue();
    L65:
        m0 r20 = DoraBTOptimizationManager.d().c();
        if (r20 == null) goto L68;
        ?? r21 = Intrinsics.areEqual(r20.b(), Boxing.boxBoolean(true));
    L69:
        f r110 = r16.c;
        r110.getClass();
        lk4.a.a r111 = new lk4.a.a();
        r111.a = 1;
        r111.b = new byte[]{(byte) r6, (byte) r12, (byte) r11, (byte) ((r18 >> 8) & 255), (byte) (r18 & 255), (byte) r21};
        int r112 = r110.d.i(1, 49, new lk4.a(r111).a());
        if (r112 != 0) goto L72;
        DoraBTOptimizationManager.m = r6;
    L72:
        g49.d.d("DoraBTOptimizationManager", "sendHeartbeatInfo: settingCfg=" + DoraBTOptimizationManager.d() + ", networkStatus=" + r6 + ", platform=" + DoraBTOptimizationManager.c() + ", , ret=" + r112);
        return Unit.INSTANCE;
    L68:
        r21 = 0;
    L64:
        r18 = 30;
        goto L65
    L58:
        r11 = 0;
        goto L59
    L54:
        return Unit.INSTANCE;
    L33:
        if (DoraBTOptimizationManager.m != r6) goto L36;
        g49.d.d("DoraBTOptimizationManager", "sendHeartbeatInfo: network status not changed (" + r6 + "), skip");
        return Unit.INSTANCE;
    L20:
        if (o59.a.p(r3) != true) goto L22;
        r4 = true;
    L25:
        r5 = false;
        goto L27
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        CoroutineScope r113 = (CoroutineScope) this.L$0;
        long r22 = this.$delayMs;
        this.L$0 = r113;
        this.label = 1;
        if (DelayKt.delay(r22, this) != r0) goto L11;
        return r0;
    L11:
        r2 = r113;
        goto L13
    }
}
