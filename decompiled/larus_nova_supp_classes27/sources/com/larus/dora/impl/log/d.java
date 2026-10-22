package com.larus.dora.impl.log;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kj4.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class d implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ int d;

    public /* synthetic */ d(int r1, int r2, long r3, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    public final Object invoke() {
        final int r7 = this.a;
        final int r8 = this.b;
        final long r9 = this.c;
        final int r11 = this.d;
        AtomicBoolean r1 = DoraLogManager.q;
        boolean r2 = r1.get();
        DoraLogManager r12 = DoraLogManager.a;
        ?? r15 = 3;
        if (DoraLogManager.l() == false) goto L13;
        boolean r3 = r1.get();
        if (DoraLogManager.m == false) goto L7;
        ?? r13 = 2;
    L9:
        if (DoraLogManager.l == true) goto L12;
        r15 = r13;
    L12:
        p.d(r15, 0);
        r12.B(false);
        a.g().m(r7);
        DoraLogManager.t(r12, false, "getLogData interrupt(isOta " + DoraLogManager.m + ", isQuery " + DoraLogManager.l + ", isBusy " + r2 + ')', DoraLogManager.e, 0, 24);
        return Unit.INSTANCE;
    L7:
        r13 = r3;
        goto L9
    L13:
        DoraLogManager.p = DoraLogManager.o.schedule(new g(r7, r8, r9, r11), 10000, TimeUnit.MILLISECONDS);
        mj4.f r4 = a.g().c;
        r4.getClass();
        ArrayList r5 = new ArrayList();
        pk4.n.d(r5, new byte[][]{new byte[]{2, 8, (byte) r7, (byte) r8}, pk4.n.l(r9), pk4.n.k(r11)});
        r4.d.g(4, 7, pk4.n.w(r5));
        String r6 = p.b;
        int r10 = (int) DoraLogManager.b;
        p.f = r8;
        p.g = r10;
        return Unit.INSTANCE;
    }
}
