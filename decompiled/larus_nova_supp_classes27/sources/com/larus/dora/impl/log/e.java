package com.larus.dora.impl.log;

import android.util.Log;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import java.util.ArrayList;
import java.util.concurrent.ScheduledFuture;
import kj4.a;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;
import t39.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class e implements Function0 {
    public final /* synthetic */ byte a;
    public final /* synthetic */ byte b;
    public final /* synthetic */ long c;
    public final /* synthetic */ byte[] d;

    public /* synthetic */ e(byte r1, byte r2, long r3, byte[] r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    public final Object invoke() {
        byte r2 = this.a;
        byte r3 = this.b;
        long r4 = this.c;
        byte[] r0 = this.d;
        DoraLogManager.u = 0;
        ScheduledFuture r7 = DoraLogManager.p;
        if (r7 == null) goto L6;
        r7.cancel(true);
    L6:
        if (r0 != null) goto L8;
    L10:
        boolean r9 = false;
    L12:
        if (r9 == true) goto L18;
        StringBuilder r10 = new StringBuilder("bufSize ");
        if (r0 == null) goto L16;
        Integer r12 = Integer.valueOf(r0.length);
    L17:
        r10.append(r12);
        r10.append(" != LOG_PACKET_SIZE");
        g49.d.b("DoraLogManager", r10.toString());
        goto L18
    L16:
        r12 = null;
    L18:
        int r11 = DoraLogManager.x;
        DoraLogManager r13 = DoraLogManager.a;
        if (r11 != 0) goto L30;
        if (DoraLogManager.t == false) goto L25;
        u r1 = DoraLogManager.n;
        if (r1 == null) goto L28;
        r1.b();
    L28:
        r13.v(r2);
        return Unit.INSTANCE;
    L25:
        u r5 = DoraLogManager.f;
        if (r5 == null) goto L28;
        r5.b();
        goto L28
    L30:
        if (r3 != 4) goto L37;
        if (r0 == null) goto L36;
        PolarisFileWrapper r6 = DoraLogManager.k;
        if (r6 == null) goto L35;
        FilesKt.appendBytes(r6, r0);
    L35:
        r4 = r4 + ((long) r0.length);
    L36:
        DoraLogManager.b = r4;
        r13.A(r2, 3, r4);
        g49.d.d("DoraLogManager", "save log, earbudsSide: " + r2 + ", type: 3, " + DoraLogManager.b + '/' + DoraLogManager.x);
        r3 = 3;
    L81:
        DoraLogManager r8 = DoraLogManager.a;
        DoraLogManager r14 = DoraLogManager.a;
        if (DoraLogManager.t == false) goto L86;
        u r15 = DoraLogManager.n;
        if (r15 == null) goto L89;
        r15.b();
    L89:
        long r16 = DoraLogManager.b;
        if (r16 >= DoraLogManager.x) goto L92;
        DoraLogManager.o(r2, r3, r16, 512);
    L98:
        return Unit.INSTANCE;
    L92:
        g49.d.d("DoraLogManager", "clearLog earbudsSide " + r2 + " type " + r3);
        mj4.f r17 = a.g().c;
        r17.getClass();
        ArrayList r18 = new ArrayList();
        byte[] r20 = {0, 0, 0};
        r20[r3 - 1] = 1;
        pk4.n.d(r18, new byte[][]{new byte[]{3, 4, r2}, r20});
        int r21 = r17.d.i(4, 7, pk4.n.w(r18));
        if (r21 == 0) goto L95;
        g49.d.b("DoraLogManager", "clearLog failed, earbuds_side " + r2 + ", ret " + r21);
        p.b(1, r2, r3);
    L96:
        r13.v(r2);
        goto L98
    L95:
        g49.d.d("DoraLogManager", "clearLog success, earbuds_side " + r2 + ", ret " + r21);
        p.b(0, r2, r3);
        DoraLogManager.b = 0;
        r13.A(r2, r3, 0);
        goto L96
    L86:
        u r22 = DoraLogManager.f;
        if (r22 == null) goto L89;
        r22.b();
        goto L89
    L37:
        if (r0 != null) goto L101;
    L42:
        DoraDevice r23 = DoraAdapterExtKt.h(a.g());
        if (r23 != null) goto L45;
    L47:
        boolean r24 = false;
    L48:
        if (r24 == false) goto L50;
    L52:
        boolean r25 = false;
    L53:
        if (r25 == false) goto L55;
        DoraLogManager.o(r2, r3, r4, 512);
        return Unit.INSTANCE;
    L55:
        long r26 = DoraLogManager.b;
        int r27 = 0;
    L57:
        if ((((long) 18) + r26) >= r4) goto L80;
        byte[] r110 = DoraLogManager.j;     // Catch: ArrayIndexOutOfBoundsException -> L74
        if (r110[r27] == 90) goto L61;
        r26 = r26 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L74
        r27 = r27 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L74
        goto L57
    L61:
        int r111 = (r110[(r27 + 18) - 1] & 255) + 18;     // Catch: ArrayIndexOutOfBoundsException -> L74
        int r28 = r27 + r111;     // Catch: ArrayIndexOutOfBoundsException -> L74
        if (r28 > r110.length) goto L80;
        DoraLogManager$a r30 = DoraLogManager.y(ArraysKt.sliceArray(r110, RangesKt.until(r27, r28)));     // Catch: ArrayIndexOutOfBoundsException -> L74
        if (r30 == null) goto L77;
        String r112 = DoraLogManager.m(r30, r3, r2);     // Catch: ArrayIndexOutOfBoundsException -> L74
        PolarisFileWrapper r113 = DoraLogManager.k;     // Catch: ArrayIndexOutOfBoundsException -> L74
        if (r113 == null) goto L70;
        FilesKt.appendText$default(r113, r112 + '\n', null, 2, null);     // Catch: ArrayIndexOutOfBoundsException -> L74
    L70:
        r26 = r26 + ((long) r111);     // Catch: ArrayIndexOutOfBoundsException -> L74
        if (r3 != 2) goto L77;
        DoraBuryPointManager.a.B(r30.b, r30.c, r30.d, r30.f);     // Catch: ArrayIndexOutOfBoundsException -> L74
    L77:
        r27 = r28;
    L74:
        e = move-exception;
        g49.d.c("DoraLogManager", "parseLogFromCache Exception", e);
    L80:
        DoraLogManager.b = r4;
        g49.d.d("DoraLogManager", "save log, earbudsSide: " + r2 + ", type: " + r3 + ", " + DoraLogManager.b + '/' + DoraLogManager.x);
        r13.A(r2, r3, DoraLogManager.b);
        DoraLogManager.j = new byte[0];
        goto L81
    L50:
        if (DoraLogManager.j.length >= 4096) goto L52;
        r25 = true;
        goto L53
    L45:
        if (o59.a.x(r23) != true) goto L47;
        r24 = true;
        goto L48
    L101:
        DoraLogManager.j = ArraysKt.plus(DoraLogManager.j, r0);     // Catch: OutOfMemoryError -> L40
        r4 = r4 + ((long) r0.length);
    L40:
        e = move-exception;
        g49.d.b("DoraLogManager", Log.getStackTraceString(e));
        DoraLogManager.j = new byte[0];
        goto L42
    L8:
        if (r0.length != 512) goto L10;
        r9 = true;
        goto L12
    }
}
