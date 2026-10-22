package com.larus.dora.impl.imu;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.network.DoraNetworkApi;
import g49.d;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.imu.DoraImuDataManager$flushPackageData$1", f = "DoraImuDataManager.kt", i = {0}, l = {707}, m = "invokeSuspend", n = {"bodyArray"}, s = {"L$0"})
public final class DoraImuDataManager$flushPackageData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    Object L$0;
    int label;

    public DoraImuDataManager$flushPackageData$1(DoraDevice r1, Continuation<? super DoraImuDataManager$flushPackageData$1> r2) {
        this.$device = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraImuDataManager$flushPackageData$1(this.$device, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r110) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        if (r3 == 0) goto L12;
        if (r3 != 1) goto L11;
        JSONArray r0 = (JSONArray) this.L$0;
        ResultKt.throwOnFailure(r110);     // Catch: Exception -> L8 Throwable -> L67
        Object r4 = ((Result) r110).unbox-impl();     // Catch: Exception -> L8 Throwable -> L67
    L53:
        if (Result.isSuccess-impl(r4) == false) goto L55;
        d.d("DoraImuDataManager", "Package data batch report success: " + r0.length() + " items");     // Catch: Exception -> L8 Throwable -> L67
    L58:
        DoraImuDataManager.i.set(false);
        int r1 = DoraImuDataManager.g.size();
        DoraImuDataManager r5 = DoraImuDataManager.a;
        r5.getClass();
        int r6 = DoraImuDataManager.g();
        if (r1 >= r6) goto L61;
    L63:
        if (r1 < r6) goto L66;
        d.d("DoraImuDataManager", "Queue size " + r1 + " >= max size " + r6 + " but current device is unavailable or not Dora G, stop retry");
    L66:
        return Unit.INSTANCE;
    L61:
        if (DoraImuDataManager.a(r5) == false) goto L63;
        d.d("DoraImuDataManager", "Queue size " + r1 + " >= max size " + r6 + ", trigger again");
        DoraImuDataManager.e();
        goto L66
    L55:
        d.b("DoraImuDataManager", "Package data batch report failed: " + Result.exceptionOrNull-impl(r4) + ", discard the data");     // Catch: Exception -> L8 Throwable -> L67
        goto L58
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r110);
        ConcurrentLinkedQueue<DoraImuDataManager.a> r7 = DoraImuDataManager.g;     // Catch: Throwable -> L67
        if (r7.isEmpty() == false) goto L24;
        d.d("DoraImuDataManager", "Queue is empty, no need to report");     // Catch: Throwable -> L67
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L67
        DoraImuDataManager.i.set(false);
        int r9 = r7.size();
        DoraImuDataManager r10 = DoraImuDataManager.a;
        r10.getClass();
        int r11 = DoraImuDataManager.g();
        if (r9 >= r11) goto L19;
    L21:
        if (r9 < r11) goto L23;
        d.d("DoraImuDataManager", "Queue size " + r9 + " >= max size " + r11 + " but current device is unavailable or not Dora G, stop retry");
    L23:
        return r8;
    L19:
        if (DoraImuDataManager.a(r10) == false) goto L21;
        d.d("DoraImuDataManager", "Queue size " + r9 + " >= max size " + r11 + ", trigger again");
        DoraImuDataManager.e();
        goto L23
    L24:
        String r12 = this.$device.getSerialNumber();     // Catch: Throwable -> L67
        if (r12 != null) goto L27;
        r12 = "";
    L27:
        String r13 = String.valueOf(o59.a.c(this.$device));     // Catch: Throwable -> L67
        DoraImuDataManager.a.getClass();     // Catch: Throwable -> L67
        int r14 = DoraImuDataManager.g();     // Catch: Throwable -> L67
        d.d("DoraImuDataManager", "Start reporting package data, queue size: " + r7.size() + ", max batch size: " + r14 + ", wDid: " + r12 + ", productId: " + r13);     // Catch: Throwable -> L67
        r0 = new JSONArray();     // Catch: Throwable -> L67
        Ref.IntRef r15 = new Ref.IntRef();     // Catch: Throwable -> L67
    L28:
        ConcurrentLinkedQueue<DoraImuDataManager.a> r16 = DoraImuDataManager.g;     // Catch: Throwable -> L67
        if ((!r16.isEmpty()) == false) goto L36;
        if (r15.element >= r14) goto L36;
        DoraImuDataManager.a r17 = r16.poll();     // Catch: Throwable -> L67
        if (r17 == null) goto L28;
        JSONObject r18 = new JSONObject();     // Catch: Throwable -> L67
        int r111 = r14;
        r18.put("key", r17.a);     // Catch: Throwable -> L67
        r18.put("value", r17.b);     // Catch: Throwable -> L67
        r18.put("timestamp", r17.c);     // Catch: Throwable -> L67
        r18.put("primary_timestamp", r17.d);     // Catch: Throwable -> L67
        DoraImuDataManager.c(DoraImuDataManager.a, r17);     // Catch: Throwable -> L67
        r0.put(r18);     // Catch: Throwable -> L67
        int r20 = r15.element;     // Catch: Throwable -> L67
        r15.element = r20 + 1;     // Catch: Throwable -> L67
        Boxing.boxInt(r20);     // Catch: Throwable -> L67
        r12 = r12;
        r13 = r13;
        r14 = r111;
    L36:
        String r112 = r12;
        String r113 = r13;
        if (r0.length() != 0) goto L47;
        d.d("DoraImuDataManager", "No data to report");     // Catch: Throwable -> L67
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L67
        DoraImuDataManager.i.set(false);
        int r22 = r16.size();
        DoraImuDataManager r23 = DoraImuDataManager.a;
        r23.getClass();
        int r24 = DoraImuDataManager.g();
        if (r22 >= r24) goto L42;
    L44:
        if (r22 < r24) goto L46;
        d.d("DoraImuDataManager", "Queue size " + r22 + " >= max size " + r24 + " but current device is unavailable or not Dora G, stop retry");
    L46:
        return r21;
    L42:
        if (DoraImuDataManager.a(r23) == false) goto L44;
        d.d("DoraImuDataManager", "Queue size " + r22 + " >= max size " + r24 + ", trigger again");
        DoraImuDataManager.e();
        goto L46
    L47:
        d.d("DoraImuDataManager", "Current report data amount: " + r0.length());     // Catch: Throwable -> L67
        d.d("DoraImuDataManager", "Report package data batch: " + r0.length() + " items");     // Catch: Exception -> L8 Throwable -> L67
        DoraNetworkApi r25 = DoraNetworkApi.a;     // Catch: Exception -> L8 Throwable -> L67
        this.L$0 = r0;     // Catch: Exception -> L8 Throwable -> L67
        this.label = 1;     // Catch: Exception -> L8 Throwable -> L67
        Object r26 = r25.K(r112, r113, r0, this);     // Catch: Exception -> L8 Throwable -> L67
        if (r26 != r2) goto L51;
        return r2;
    L51:
        r4 = r26;
    L8:
        e = move-exception;
        d.c("DoraImuDataManager", "Package data batch report exception, discard the data", e);     // Catch: Throwable -> L67
    L67:
        th = move-exception;
        DoraImuDataManager.i.set(false);
        int r27 = DoraImuDataManager.g.size();
        DoraImuDataManager r28 = DoraImuDataManager.a;
        r28.getClass();
        int r30 = DoraImuDataManager.g();
        if (r27 >= r30) goto L71;
    L74:
        if (r27 < r30) goto L76;
        d.d("DoraImuDataManager", "Queue size " + r27 + " >= max size " + r30 + " but current device is unavailable or not Dora G, stop retry");
    L76:
        throw th;
    L71:
        if (DoraImuDataManager.a(r28) == false) goto L74;
        d.d("DoraImuDataManager", "Queue size " + r27 + " >= max size " + r30 + ", trigger again");
        DoraImuDataManager.e();
        goto L76
    }
}
