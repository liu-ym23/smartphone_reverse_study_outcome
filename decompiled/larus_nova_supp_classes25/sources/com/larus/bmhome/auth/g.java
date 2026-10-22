package com.larus.bmhome.auth;

import com.google.gson.Gson;
import com.larus.platform.service.AccountService;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class g implements Function1 {
    public final /* synthetic */ long a;
    public final /* synthetic */ AuthViewModel b;

    public /* synthetic */ g(long r1, AuthViewModel r3) {
        this.a = r1;
        this.b = r3;
    }

    public final Object invoke(Object r15) {
        long r0 = this.a;
        AuthViewModel r2 = this.b;
        g1 r16 = (g1) r15;
        AtomicBoolean r3 = AuthViewModel.A;
        Intrinsics.checkNotNullParameter(r16, "snapshot");
        if (r0 != r2.e.a) goto L89;
        Gson r1 = z0.a;
        Intrinsics.checkNotNullParameter(r16, "snapshot");
        boolean r4 = false;
        if (Intrinsics.areEqual(r16.a, z0.b()) == true) goto L7;
    L9:
        boolean r5 = false;
    L10:
        if (r5 == false) goto L89;
        h0 r6 = r16.c;
        c1 r7 = (c1) r2.r.getValue();
        if (r7 == null) goto L15;
        h0 r8 = (h0) r7.d;
    L16:
        if (r8 != null) goto L18;
        boolean r9 = true;
    L19:
        if (r9 == false) goto L21;
        h0 r10 = r6;
    L22:
        e0 r11 = r16.d;
        c1 r12 = (c1) r2.s.getValue();
        if (r12 == null) goto L25;
        e0 r13 = (e0) r12.d;
    L26:
        if (r13 != null) goto L28;
        boolean r14 = true;
    L29:
        if (r14 == false) goto L31;
        e0 r17 = r11;
    L32:
        j0 r18 = r16.e;
        c1 r19 = (c1) r2.t.getValue();
        if (r19 == null) goto L35;
        j0 r20 = (j0) r19.d;
    L36:
        if (r20 != null) goto L38;
        boolean r21 = true;
    L39:
        if (r21 == false) goto L41;
        j0 r110 = r18;
    L42:
        b r22 = r16.f;
        c1 r23 = (c1) r2.u.getValue();
        if (r23 == null) goto L45;
        b r24 = (b) r23.d;
    L46:
        if (r24 != null) goto L48;
        r4 = true;
    L48:
        if (r4 == false) goto L50;
        b r111 = r22;
    L51:
        String r25 = r16.a;
        boolean r26 = r16.b;
        Intrinsics.checkNotNullParameter(r25, "userId");
        g1 r112 = new g1(r25, r26, r10, r17, r110, r111);
        Intrinsics.checkNotNullParameter(r112, "snapshot");
        h0 r27 = r112.c;
        if (r27 == null) goto L54;
        z0.l = r27;
    L54:
        e0 r28 = r112.d;
        if (r28 == null) goto L57;
        z0.m = r28;
    L57:
        j0 r29 = r112.e;
        if (r29 == null) goto L60;
        z0.n = r29;
    L60:
        b r30 = r112.f;
        if (r30 == null) goto L63;
        z0.o = r30;
    L63:
        h0 r31 = r112.c;
        if (r31 == null) goto L69;
        c1 r32 = (c1) r2.r.getValue();
        if (r32 == null) goto L69;
        r2.r.setValue(c1.a(r32, 0, null, r31, null, true, 23));
    L69:
        e0 r33 = r112.d;
        if (r33 == null) goto L75;
        c1 r34 = (c1) r2.s.getValue();
        if (r34 == null) goto L75;
        r2.s.setValue(c1.a(r34, 0, null, r33, null, true, 23));
    L75:
        j0 r35 = r112.e;
        if (r35 == null) goto L81;
        c1 r36 = (c1) r2.t.getValue();
        if (r36 == null) goto L81;
        r2.t.setValue(c1.a(r36, 0, null, r35, null, true, 23));
    L81:
        b r37 = r112.f;
        if (r37 == null) goto L90;
        c1 r38 = (c1) r2.u.getValue();
        if (r38 == null) goto L90;
        r2.u.setValue(c1.a(r38, 0, null, r37, null, true, 23));
    L90:
        return Unit.INSTANCE;
    L50:
        r111 = null;
        goto L51
    L45:
        r24 = null;
        goto L46
    L41:
        r110 = null;
        goto L42
    L38:
        r21 = false;
        goto L39
    L35:
        r20 = null;
        goto L36
    L31:
        r17 = null;
        goto L32
    L28:
        r14 = false;
        goto L29
    L25:
        r13 = null;
        goto L26
    L21:
        r10 = null;
        goto L22
    L18:
        r9 = false;
        goto L19
    L15:
        r8 = null;
        goto L16
    L7:
        if (r16.b != AccountService.a.isLogin().booleanValue()) goto L9;
        r5 = true;
    L89:
        return Unit.INSTANCE;
    }
}
