package com.loc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class bw extends bt {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static bw f5382b;

    static {
        f5382b = new bw();
    }

    private bw() {
        super(5120);
    }

    private static String a(String r0) {
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0;
    }

    public static bw b() {
        return f5382b;
    }

    public final byte[] a(byte[] r10, byte[] r11, List<? extends ca> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L19;
        return null;
    L19:
        int r2 = r13.size();     // Catch: Throwable -> L16
        if (r2 <= 0) goto L22;
        if (r10 == null) goto L23;
        a();     // Catch: Throwable -> L16
        int r14 = ce.a(this.f5380a, r10);     // Catch: Throwable -> L16
        int[] r3 = new int[r2];     // Catch: Throwable -> L16
        int r4 = 0;
        int r5 = 0;
    L9:
        if (r5 >= r2) goto L11;
        ca r6 = (ca) ZeusTransformUtils.preCheckCast(r13.get(r5), ca.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        r3[r5] = cj.a(this.f5380a, (byte) r6.a(), cj.a(this.f5380a, r6.b()));     // Catch: Throwable -> L16
        r5 = r5 + 1;     // Catch: Throwable -> L16
        goto L9
    L11:
        int r15 = ce.a(this.f5380a, r3);     // Catch: Throwable -> L16
        if (r11 == null) goto L14;
        r4 = ce.b(this.f5380a, r11);     // Catch: Throwable -> L16
    L14:
        this.f5380a.c(ce.a(this.f5380a, r14, r4, r15));     // Catch: Throwable -> L16
        return this.f5380a.c();
    L23:
        return null;
    L22:
        return null;
    L16:
        th = move-exception;
        de.a(th);
        return null;
    }

    public final byte[] c() {
        super.a();
        int r5 = this.f5380a.a(dc.f());     // Catch: Exception -> L5
        int r6 = this.f5380a.a(dc.c());     // Catch: Exception -> L5
        int r8 = this.f5380a.a(dc.i());     // Catch: Exception -> L5
        int r9 = this.f5380a.a(dc.h());     // Catch: Exception -> L5
        int r10 = this.f5380a.a(a(dc.g()));     // Catch: Exception -> L5
        int r11 = this.f5380a.a(a(dc.j()));     // Catch: Exception -> L5
        long r12 = db.a(dc.n());     // Catch: Exception -> L5
        int r14 = this.f5380a.a(dc.l());     // Catch: Exception -> L5
        int r15 = this.f5380a.a(dc.k());     // Catch: Exception -> L5
        int r16 = this.f5380a.a(dc.d());     // Catch: Exception -> L5
        int r17 = this.f5380a.a(dc.e());     // Catch: Exception -> L5
        int r1 = dd.a(this.f5380a, dc.a(), r5, r6, (byte) dc.m(), r8, r9, r10, r11, r12, r14, r15, r16, r17);     // Catch: Exception -> L5
        this.f5380a.c(r1);     // Catch: Exception -> L5
        return this.f5380a.c();
    L5:
        e = move-exception;
        de.a(e);
        return null;
    }
}
