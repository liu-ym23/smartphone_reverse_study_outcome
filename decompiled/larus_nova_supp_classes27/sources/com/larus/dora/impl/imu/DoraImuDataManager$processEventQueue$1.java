package com.larus.dora.impl.imu;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.network.DoraNetworkApi;
import g49.d;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.larus.dora.impl.imu.DoraImuDataManager$processEventQueue$1", f = "DoraImuDataManager.kt", i = {0, 0, 0, 0}, l = {389}, m = "invokeSuspend", n = {"wDid", "productId", "queue", "data"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class DoraImuDataManager$processEventQueue$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    final /* synthetic */ String $eventKey;
    final /* synthetic */ AtomicBoolean $processingFlag;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    public DoraImuDataManager$processEventQueue$1(DoraDevice r1, String r2, AtomicBoolean r3, Continuation<? super DoraImuDataManager$processEventQueue$1> r4) {
        this.$device = r1;
        this.$eventKey = r2;
        this.$processingFlag = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraImuDataManager$processEventQueue$1(this.$device, this.$eventKey, this.$processingFlag, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x013a -> B:115:0x0143). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x01c2 -> B:80:0x01dd). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r24) {
        DoraImuDataManager$processEventQueue$1 r1 = this;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        String r4 = ", discard the data";
        String r5 = "Queue still has data after processing, trigger again: ";
        boolean r8 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        DoraImuDataManager.a r0 = (DoraImuDataManager.a) r1.L$3;
        ConcurrentLinkedQueue<DoraImuDataManager.a> r6 = (ConcurrentLinkedQueue) r1.L$2;
        String r10 = (String) r1.L$1;
        String r11 = (String) r1.L$0;
        ResultKt.throwOnFailure(r24);     // Catch: Throwable -> L8 Exception -> L10
        Object r12 = ((Result) r24).unbox-impl();     // Catch: Throwable -> L8 Exception -> L10
        DoraImuDataManager$processEventQueue$1 r13 = r1;
    L115:
        if (Result.isSuccess-impl(r12) == false) goto L55;
        DoraImuDataManager.b(DoraImuDataManager.a, r0);     // Catch: Exception -> L57 Throwable -> L81
        d.d("DoraImuDataManager", "Low frequency event report success: " + r0 + ", remaining queue size: " + (r6.size() - 1));     // Catch: Exception -> L57 Throwable -> L81
    L80:
        String r15 = r10;
        String r14 = r11;
        r8 = true;
    L119:
        if ((r6.isEmpty() ^ r8) == true) goto L117;
    L85:
        String r20 = r5;
        DoraImuDataManager$processEventQueue$1 r7 = r13;
        r7.$processingFlag.set(false);
        ConcurrentLinkedQueue<DoraImuDataManager.a> r9 = DoraImuDataManager.k.get(r7.$eventKey);
        if (r9 != null) goto L88;
    L92:
        if (r9 != null) goto L94;
    L97:
        return Unit.INSTANCE;
    L94:
        if ((!r9.isEmpty()) == false) goto L97;
        d.d("DoraImuDataManager", "Queue still has data but current device is unavailable or not Dora G, stop retry: " + r7.$eventKey);
        goto L97
    L88:
        if ((!r9.isEmpty()) == false) goto L92;
        if (DoraImuDataManager.a(DoraImuDataManager.a) == false) goto L92;
        d.d("DoraImuDataManager", r20 + r7.$eventKey);
        DoraImuDataManager.k(r7.$eventKey);
        goto L97
    L117:
        r0 = r6.poll();     // Catch: Throwable -> L83
        if (r0 == null) goto L85;
        d.d("DoraImuDataManager", "Processing low frequency event: " + r0 + ", queue size: " + r6.size());     // Catch: Throwable -> L83
        DoraImuDataManager.c(DoraImuDataManager.a, r0);     // Catch: Exception -> L76 Throwable -> L83
        DoraNetworkApi r16 = DoraNetworkApi.a;     // Catch: Exception -> L76 Throwable -> L83
    L127:
        String r17 = r0.a;     // Catch: Throwable -> L71 Exception -> L74
        String r18 = r0.b;     // Catch: Throwable -> L71 Exception -> L74
        long r21 = r0.c;     // Catch: Throwable -> L71 Exception -> L74
        String r25 = r4;
        String r22 = r5;
        long r23 = r0.d;     // Catch: Throwable -> L67 Exception -> L69
        r13.L$0 = r14;     // Catch: Throwable -> L63 Exception -> L65
        r13.L$1 = r15;     // Catch: Throwable -> L63 Exception -> L65
        r13.L$2 = r6;     // Catch: Throwable -> L63 Exception -> L65
        r13.L$3 = r0;     // Catch: Throwable -> L63 Exception -> L65
        r13.label = 1;     // Catch: Throwable -> L63 Exception -> L65
        DoraImuDataManager$processEventQueue$1 r26 = r13;
        String r27 = r14;
        String r28 = r15;
        r12 = r16.L(r14, r15, r17, r18, r21, r23, r26);     // Catch: Throwable -> L59 Exception -> L61
        if (r12 != r2) goto L51;
        return r2;
    L51:
        r4 = r25;
        r10 = r28;
        r5 = r22;
        r13 = r26;
        r11 = r27;
        goto L115
    L61:
        Exception e = e;
    L78:
        r4 = r25;
        r10 = r28;
        r5 = r22;
        r13 = r26;
        r11 = r27;
    L79:
        d.c("DoraImuDataManager", "Low frequency event report exception: " + e.getMessage() + r4, e);     // Catch: Throwable -> L81
    L59:
        th = th;
    L73:
        r5 = r22;
        r13 = r26;
    L102:
        r13.$processingFlag.set(false);
        ConcurrentLinkedQueue<DoraImuDataManager.a> r30 = DoraImuDataManager.k.get(r13.$eventKey);
        if (r30 != null) goto L105;
    L110:
        if (r30 != null) goto L112;
    L114:
        throw th;
    L112:
        if ((!r30.isEmpty()) == false) goto L114;
        d.d("DoraImuDataManager", "Queue still has data but current device is unavailable or not Dora G, stop retry: " + r13.$eventKey);
        goto L114
    L105:
        if ((!r30.isEmpty()) == false) goto L110;
        if (DoraImuDataManager.a(DoraImuDataManager.a) == false) goto L110;
        d.d("DoraImuDataManager", r5 + r13.$eventKey);
        DoraImuDataManager.k(r13.$eventKey);
        goto L114
    L65:
        e = e;
    L66:
        r26 = r13;
        r27 = r14;
        r28 = r15;
    L63:
        th = th;
    L68:
        r26 = r13;
        goto L73
    L69:
        e = e;
    L67:
        th = th;
        goto L68
    L74:
        e = e;
        r25 = r4;
        r22 = r5;
    L71:
        th = th;
        r22 = r5;
    L76:
        e = e;
        r25 = r4;
        r22 = r5;
    L83:
        th = th;
        r22 = r5;
    L98:
        th = th;
        r1 = r13;
    L33:
        r13 = r1;
        goto L102
    L55:
        d.b("DoraImuDataManager", "Low frequency event report failed: " + Result.exceptionOrNull-impl(r12) + r4);     // Catch: Exception -> L57 Throwable -> L81
        goto L80
    L57:
        e = e;
    L81:
        th = th;
    L10:
        e = e;
        r13 = r1;
        goto L79
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r24);
        String r31 = r1.$device.getSerialNumber();     // Catch: Throwable -> L100
        if (r31 != null) goto L18;
        r31 = "";
    L18:
        String r110 = String.valueOf(o59.a.c(r1.$device));     // Catch: Throwable -> L100
        ConcurrentHashMap<String, ConcurrentLinkedQueue<DoraImuDataManager.a>> r111 = DoraImuDataManager.k;     // Catch: Throwable -> L100
        ConcurrentLinkedQueue<DoraImuDataManager.a> r112 = r111.get(r1.$eventKey);     // Catch: Throwable -> L100
        if (r112 != null) goto L34;
        d.e("DoraImuDataManager", "Queue not found for event: " + r1.$eventKey);     // Catch: Throwable -> L8
        Unit r32 = Unit.INSTANCE;     // Catch: Throwable -> L8
        r1.$processingFlag.set(false);
        ConcurrentLinkedQueue<DoraImuDataManager.a> r33 = r111.get(r1.$eventKey);
        if (r33 != null) goto L24;
    L28:
        if (r33 != null) goto L30;
    L32:
        return r32;
    L30:
        if ((!r33.isEmpty()) == false) goto L32;
        d.d("DoraImuDataManager", "Queue still has data but current device is unavailable or not Dora G, stop retry: " + r1.$eventKey);
        goto L32
    L24:
        if ((!r33.isEmpty()) == false) goto L28;
        if (DoraImuDataManager.a(DoraImuDataManager.a) == false) goto L28;
        d.d("DoraImuDataManager", "Queue still has data after processing, trigger again: " + r1.$eventKey);
        DoraImuDataManager.k(r1.$eventKey);
        goto L32
    L34:
        r13 = r1;
        r14 = r31;
        r15 = r110;
        r6 = r112;
    L100:
        th = th;
        r13 = this;
    L8:
        th = th;
        goto L33
    }
}
