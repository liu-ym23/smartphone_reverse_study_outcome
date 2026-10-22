package kotlinx.metadata.internal.protobuf;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f19163h = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f19165c;
    public final e d;
    public final int e;
    public final int f;
    public int g;

    static {
        ArrayList r5 = new ArrayList();
        int r10 = 1;
        int r11 = 1;
    L3:
        if (r10 <= 0) goto L5;
        int r12 = ai.j0.d(r10, r5, r11, r10);
        r11 = r10;
        r10 = r12;
        goto L3
    L5:
        r5.add(Integer.MAX_VALUE);
        f19163h = new int[r5.size()];
        int r13 = 0;
    L6:
        int[] r14 = f19163h;
        if (r13 >= r14.length) goto L9;
        r14[r13] = ((Integer) r5.get(r13)).intValue();
        r13 = r13 + 1;
        goto L6
    }

    public f0(e r5, e r10) {
        this.g = 0;
        this.f19165c = r5;
        this.d = r10;
        int r11 = r5.size();
        this.e = r11;
        this.f19164b = r10.size() + r11;
        this.f = Math.max(r5.g(), r10.g()) + 1;
    }

    public final boolean equals(Object r13) {
        if (r13 != this) goto L6;
        return true;
    L6:
        if ((r13 instanceof e) == true) goto L8;
        return false;
    L8:
        e r14 = (e) r13;
        int r5 = r14.size();
        int r10 = this.f19164b;
        if (r10 == r5) goto L11;
        return false;
    L11:
        if (r10 != 0) goto L14;
        return true;
    L14:
        if (this.g == 0) goto L20;
        int r11 = r14.n();
        if (r11 == 0) goto L20;
        if (this.g == r11) goto L20;
        return false;
    L20:
        com.google.common.base.k r12 = new com.google.common.base.k(this);
        x r15 = r12.a();
        com.google.common.base.k r16 = new com.google.common.base.k(r14);
        x r17 = r16.a();
        int r18 = 0;
        int r19 = 0;
        int r20 = 0;
    L21:
        int r21 = r15.f19212b.length - r18;
        int r22 = r17.f19212b.length - r19;
        int r110 = Math.min(r21, r22);
        if (r18 != 0) goto L24;
        boolean r111 = r15.r(r17, r19, r110);
    L25:
        if (r111 == false) goto L30;
        r20 = r20 + r110;
        if (r20 >= r10) goto L29;
        if (r110 != r21) goto L35;
        r15 = r12.a();
        r18 = 0;
    L36:
        if (r110 == r22) goto L37;
        r19 = r19 + r110;
        goto L21
    L37:
        r17 = r16.a();
        r19 = 0;
        goto L21
    L35:
        r18 = r18 + r110;
        goto L36
    L29:
        if (r20 != r10) goto L32;
        return true;
    L32:
        throw new IllegalStateException();
    L30:
        return false;
    L24:
        r111 = r17.r(r15, r18, r110);
        goto L25
    }

    @Override // kotlinx.metadata.internal.protobuf.e
    public final void f(byte[] r5, int r10, int r11, int r12) {
        int r13 = r10 + r12;
        e r14 = this.f19165c;
        int r15 = this.e;
        if (r13 > r15) goto L5;
        r14.f(r5, r10, r11, r12);
        return;
    L5:
        e r16 = this.d;
        if (r10 < r15) goto L8;
        r16.f(r5, r10 - r15, r11, r12);
        return;
    L8:
        int r17 = r15 - r10;
        r14.f(r5, r10, r11, r17);
        r16.f(r5, 0, r11 + r17, r12 - r17);
    }

    @Override // kotlinx.metadata.internal.protobuf.e
    public final int g() {
        return this.f;
    }

    @Override // kotlinx.metadata.internal.protobuf.e
    public final boolean h() {
        int r5 = f19163h[this.f];
        if (this.f19164b < r5) goto L5;
        return true;
    L5:
        return false;
    }

    public final int hashCode() {
        int r5 = this.g;
        if (r5 != 0) goto L8;
        int r10 = this.f19164b;
        r5 = l(r10, 0, r10);
        if (r5 != 0) goto L7;
        r5 = 1;
    L7:
        this.g = r5;
    L8:
        return r5;
    }

    @Override // kotlinx.metadata.internal.protobuf.e
    public final boolean i() {
        int r5 = this.e;
        int r10 = this.f19165c.m(0, 0, r5);
        e r11 = this.d;
        if (r11.m(r10, 0, r11.size()) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new d0(this);
    }

    @Override // kotlinx.metadata.internal.protobuf.e
    public final f j() {
        return new f(new e0(this));
    }

    @Override // kotlinx.metadata.internal.protobuf.e
    public final int l(int r5, int r10, int r11) {
        int r12 = r10 + r11;
        e r13 = this.f19165c;
        int r14 = this.e;
        if (r12 <= r14) goto L5;
        e r15 = this.d;
        if (r10 >= r14) goto L9;
        int r16 = r14 - r10;
        return r15.l(r13.l(r5, r10, r16), 0, r11 - r16);
    L9:
        return r15.l(r5, r10 - r14, r11);
    L5:
        return r13.l(r5, r10, r11);
    }

    @Override // kotlinx.metadata.internal.protobuf.e
    public final int m(int r5, int r10, int r11) {
        int r12 = r10 + r11;
        e r13 = this.f19165c;
        int r14 = this.e;
        if (r12 <= r14) goto L5;
        e r15 = this.d;
        if (r10 >= r14) goto L9;
        int r16 = r14 - r10;
        return r15.m(r13.m(r5, r10, r16), 0, r11 - r16);
    L9:
        return r15.m(r5, r10 - r14, r11);
    L5:
        return r13.m(r5, r10, r11);
    }

    @Override // kotlinx.metadata.internal.protobuf.e
    public final int n() {
        return this.g;
    }

    @Override // kotlinx.metadata.internal.protobuf.e
    public final String o() {
        int r5 = this.f19164b;
        if (r5 != 0) goto L5;
        byte[] r10 = t.f19206a;
    L7:
        return new String(r10, "UTF-8");
    L5:
        byte[] r11 = new byte[r5];
        f(r11, 0, 0, r5);
        r10 = r11;
        goto L7
    }

    @Override // kotlinx.metadata.internal.protobuf.e
    public final void q(OutputStream r5, int r10, int r11) {
        int r12 = r10 + r11;
        e r13 = this.f19165c;
        int r14 = this.e;
        if (r12 > r14) goto L5;
        r13.q(r5, r10, r11);
        return;
    L5:
        e r15 = this.d;
        if (r10 < r14) goto L8;
        r15.q(r5, r10 - r14, r11);
        return;
    L8:
        int r16 = r14 - r10;
        r13.q(r5, r10, r16);
        r15.q(r5, 0, r11 - r16);
    }

    @Override // kotlinx.metadata.internal.protobuf.e
    public final int size() {
        return this.f19164b;
    }
}
