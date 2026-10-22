package com.larus.bmhome.auth;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d implements Function0 {
    public final /* synthetic */ AuthViewModel a;
    public final /* synthetic */ Set b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ String d;

    public /* synthetic */ d(AuthViewModel r1, Set r2, boolean r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke() {
        AuthViewModel r0 = this.a;
        Set r1 = this.b;
        boolean r2 = this.c;
        String r3 = this.d;
        AtomicBoolean r4 = AuthViewModel.A;
        r0.U();
        if (r1.contains(LaunchBiz.FULL) == false) goto L6;
        r1 = AuthViewModel.C;
    L6:
        if (r2 == false) goto L22;
        Set r5 = SetsKt.minus(r1, LaunchBiz.CORE);
        Set r6 = r5;
        Set r7 = r0.v;
        if ((r6 instanceof Collection) == true) goto L10;
    L12:
        Iterator r8 = r6.iterator();
    L14:
        if (r8.hasNext() == false) goto L18;
        if (r7.contains((LaunchBiz) r8.next()) == false) goto L14;
        boolean r9 = true;
    L19:
        if (r9 == false) goto L21;
        r0.M(r0.m);
    L21:
        r0.V(r5, "force request from:" + r3);
    L18:
        r9 = false;
        goto L19
    L10:
        if (r6.isEmpty() == false) goto L12;
    L22:
        r0.a0(r3, r1, r2, r0.e0(r3, r1, false));
        return Unit.INSTANCE;
    }
}
