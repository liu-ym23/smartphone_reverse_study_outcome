package ke;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Iterable<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9110b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f9111m;

    public a(int r8, int r10, int r11) {
        if (r11 == 0) goto L46;
        if (r11 == Integer.MIN_VALUE) goto L44;
        this.f9109a = r8;
        if (r11 <= 0) goto L23;
        if (r8 >= r10) goto L39;
        int r12 = r10 % r11;
        if (r12 >= 0) goto L14;
        r12 = r12 + r11;
    L14:
        int r13 = r8 % r11;
        if (r13 >= 0) goto L18;
        r13 = r13 + r11;
    L18:
        int r14 = (r12 - r13) % r11;
        if (r14 >= 0) goto L22;
        r14 = r14 + r11;
    L22:
        r10 = r10 - r14;
    L39:
        this.f9110b = r10;
        this.f9111m = r11;
        return;
    L23:
        if (r11 >= 0) goto L42;
        if (r8 <= r10) goto L39;
        int r15 = -r11;
        int r16 = r8 % r15;
        if (r16 >= 0) goto L30;
        r16 = r16 + r15;
    L30:
        int r17 = r10 % r15;
        if (r17 >= 0) goto L34;
        r17 = r17 + r15;
    L34:
        int r18 = (r16 - r17) % r15;
        if (r18 >= 0) goto L38;
        r18 = r18 + r15;
    L38:
        r10 = r10 + r18;
        goto L39
    L42:
        throw new IllegalArgumentException("Step is zero.");
    L44:
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    L46:
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public final b a() {
        int r8 = this.f9111m;
        return new b(this.f9109a, this.f9110b, r8);
    }

    public boolean equals(Object r8) {
        if ((r8 instanceof a) == true) goto L5;
    L15:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        a r10 = (a) r8;
        int r11 = r10.f9109a;
        if (this.f9109a != r11) goto L15;
        if (this.f9110b != r10.f9110b) goto L15;
        if (this.f9111m != r10.f9111m) goto L15;
    L14:
        return true;
    L7:
        if (((a) r8).isEmpty() == true) goto L14;
        goto L8
    }

    public int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        int r8 = ((this.f9109a * 31) + this.f9110b) * 31;
        return this.f9111m + r8;
    }

    public boolean isEmpty() {
        int r8 = this.f9111m;
        int r10 = this.f9110b;
        int r11 = this.f9109a;
        if (r8 <= 0) goto L6;
        if (r11 <= r10) goto L9;
        return true;
    L9:
        return false;
    L6:
        if (r11 >= r10) goto L9;
        return true;
    }

    @Override // java.lang.Iterable
    public final /* bridge */ /* synthetic */ Iterator<Integer> iterator() {
        return a();
    }

    public String toString() {
        int r8 = this.f9110b;
        int r10 = this.f9109a;
        int r11 = this.f9111m;
        if (r11 <= 0) goto L5;
        StringBuilder r12 = new StringBuilder();
        r12.append(r10);
        r12.append("..");
        r12.append(r8);
        r12.append(" step ");
    L6:
        r12.append(r11);
        return r12.toString();
    L5:
        r12 = new StringBuilder();
        r12.append(r10);
        r12.append(" downTo ");
        r12.append(r8);
        r12.append(" step ");
        r11 = -r11;
        goto L6
    }
}
