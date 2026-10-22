package com.ctc.wstx.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public final class ad extends ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f3466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final com.ctc.wstx.util.h[] f3467b;
    final a[] c;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.ctc.wstx.util.h f3468a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final a f3469b;

        public a(com.ctc.wstx.util.h r1, a r2) {
            this.f3468a = r1;
            this.f3469b = r2;
        }

        public com.ctc.wstx.util.h a() {
            return this.f3468a;
        }

        public a b() {
            return this.f3469b;
        }
    }

    public ad(boolean r10, com.ctc.wstx.util.h[] r11) {
        this.f3466a = r10;
        int r12 = r11.length;
        int r1 = 8;
    L3:
        if (r1 >= (((r12 + 7) >> 3) + r12)) goto L5;
        r1 = r1 + r1;
        goto L3
    L5:
        this.f3467b = new com.ctc.wstx.util.h[r1];
        int r0 = r1 - 1;
        int r2 = 0;
        a[] r4 = null;
    L6:
        if (r2 >= r12) goto L16;
        com.ctc.wstx.util.h r5 = r11[r2];
        int r6 = r5.hashCode() & r0;
        com.ctc.wstx.util.h[] r7 = this.f3467b;
        if (r7[r6] != null) goto L10;
        r7[r6] = r5;
    L15:
        r2 = r2 + 1;
        goto L6
    L10:
        int r8 = r6 >> 2;
        if (r4 != null) goto L13;
        r4 = new a[r1 >> 2];
        a r9 = null;
    L14:
        r4[r8] = new a(r5, r9);
        goto L15
    L13:
        r9 = r4[r8];
        goto L14
    L16:
        this.c = r4;
    }

    @Override // com.ctc.wstx.d.ah
    public void a(StringBuilder r6, String r7) {
        TreeSet r0 = new TreeSet();
        int r2 = 0;
    L3:
        com.ctc.wstx.util.h[] r3 = this.f3467b;
        if (r2 >= r3.length) goto L10;
        com.ctc.wstx.util.h r4 = r3[r2];
        if (r4 == null) goto L8;
        r0.add(r4);
    L8:
        r2 = r2 + 1;
        goto L3
    L10:
        if (this.c == null) goto L18;
        int r5 = 0;
    L13:
        if (r5 >= (this.f3467b.length >> 2)) goto L18;
        a r8 = this.c[r5];
    L15:
        if (r8 == null) goto L17;
        r0.add(r8.a());
        r8 = r8.b();
        goto L15
    L17:
        r5 = r5 + 1;
    L18:
        Iterator r9 = r0.iterator();
        boolean r1 = true;
    L20:
        if (r9.hasNext() == false) goto L25;
        if (r1 == false) goto L23;
        r1 = false;
    L24:
        r6.append(((com.ctc.wstx.util.h) ZeusTransformUtils.preCheckCast(r9.next(), com.ctc.wstx.util.h.class, "com.obric.memorydata.plugin")).toString());
        goto L20
    L23:
        r6.append(r7);
        goto L24
    }

    @Override // com.ctc.wstx.d.ah
    public boolean a() {
        return true;
    }

    @Override // com.ctc.wstx.d.ah
    public boolean a(com.ctc.wstx.util.h r5) {
        com.ctc.wstx.util.h[] r0 = this.f3467b;
        int r1 = r5.hashCode() & (r0.length - 1);
        com.ctc.wstx.util.h r2 = r0[r1];
        if (r2 != null) goto L5;
    L7:
        a[] r4 = this.c;
        if (r4 == null) goto L15;
        a r6 = r4[r1 >> 2];
    L10:
        if (r6 == null) goto L19;
        if (r6.a().equals(r5) == true) goto L13;
        r6 = r6.b();
        goto L10
    L13:
        return true;
    L19:
        return false;
    L15:
        return false;
    L5:
        if (r2.equals(r5) == false) goto L7;
        return true;
    }
}
