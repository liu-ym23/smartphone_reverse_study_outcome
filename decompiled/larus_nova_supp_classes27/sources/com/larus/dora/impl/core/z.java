package com.larus.dora.impl.core;

import android.os.SystemClock;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.dora.impl.DoraBuryPointManager;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class z {
    public static final z a = null;
    public static final CoroutineScope b = null;

    public z() {
    }

    static {
        a = new z();
        b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    @JvmStatic
    public static final void c(int r8) {
        if (l0.c != 0) goto L5;
        return;
    L5:
        DoraBuryPointManager.a.L("d_keepalive_service", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", 2), TuplesKt.to("reason", Integer.valueOf(r8)), TuplesKt.to("duration", Long.valueOf(SystemClock.elapsedRealtime() - l0.c))}));
    }

    public static void d(long r3) {
        DoraBuryPointManager.a.L("d_device_found", MapsKt.mapOf(TuplesKt.to("duration", Long.valueOf(SystemClock.elapsedRealtime() - r3))));
    }

    public static void b(int r4, int r5) {
        DoraBuryPointManager r0 = DoraBuryPointManager.a;
        Pair[] r1 = new Pair[3];
        r1[0] = TuplesKt.to("step", "end");
        r1[1] = TuplesKt.to("retry_times", Integer.valueOf(r4));
        if (r5 != 0) goto L5;
        String r6 = FlowDoraConnectReason.SUCCESS;
    L6:
        r1[2] = TuplesKt.to("fail_reason", r6);
        DoraBuryPointManager.J(r0, "dm_send_bind_cmd", MapsKt.mapOf(r1), false, 12);
        return;
    L5:
        r6 = "cmd_error(" + r5 + ')';
        goto L6
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0096 -> B:23:0x0099). Please report as a decompilation issue!!! */
    public static final Object a(z r7, kj4.a r8, String r9, Function1 r10, Continuation r11) {
        r7.getClass();
        if ((r11 instanceof DoraCoreTracker$stateWithRetry$1) == false) goto L7;
        DoraCoreTracker$stateWithRetry$1 r0 = (DoraCoreTracker$stateWithRetry$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        int r14 = r0.I$0;
        byte r15 = r0.B$0;
        r10 = (Function1) r0.L$2;
        String r3 = (String) r0.L$1;
        kj4.a r4 = (kj4.a) r0.L$0;
        ResultKt.throwOnFailure(r12);
        kj4.a r16 = r4;
        byte r5 = r15;
        r9 = r3;
    L23:
        r14 = r14 + 1;
    L16:
        if (r14 >= 3) goto L24;
        r5 = ((Number) r10.invoke(r16)).byteValue();
        g49.d.d("DoraCoreTracker", "stateWithRetry: i=" + r14 + ' ' + r9 + '=' + r5);
        if (r5 != (-1)) goto L24;
        r0.L$0 = r16;
        r0.L$1 = r9;
        r0.L$2 = r10;
        r0.B$0 = r5;
        r0.I$0 = r14;
        r0.label = 1;
        if (DelayKt.delay(200, r0) != r13) goto L23;
        return r13;
    L24:
        if (r5 == 0) goto L28;
        if (r5 == 1) goto L27;
        String r17 = "none";
    L30:
        return r17;
    L27:
        r17 = "on";
        goto L30
    L28:
        r17 = "off";
        goto L30
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        r16 = r8;
        r14 = 0;
        r5 = -1;
    L7:
        r0 = new DoraCoreTracker$stateWithRetry$1(r7, r11);
        goto L8
    }
}
