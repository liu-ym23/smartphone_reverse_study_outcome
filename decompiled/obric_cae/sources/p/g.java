package p;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class g extends p.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h[] f9889f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h[] f9890g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f9891h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f9892i;

    public class a implements Comparator<h> {
        @Override // java.util.Comparator
        public final int compare(h r8, h r10) {
            return r8.f9896b - r10.f9896b;
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h f9893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f9894b;

        public b(g r8) {
            this.f9894b = r8;
        }

        public final String toString() {
            String r8 = "[ ";
            if (this.f9893a == null) goto L8;
            int r10 = 0;
        L6:
            if (r10 >= 9) goto L8;
            StringBuilder r11 = android.aimedia.a.j(r8);
            r11.append(this.f9893a.f9902r[r10]);
            r11.append(" ");
            r8 = r11.toString();
            r10 = r10 + 1;
        L8:
            StringBuilder r12 = android.aimedia.a.k(r8, "] ");
            r12.append(this.f9893a);
            return r12.toString();
        }
    }

    public g(c r8) {
        super(r8);
        this.f9889f = new h[128];
        this.f9890g = new h[128];
        this.f9891h = 0;
        this.f9892i = new b(this);
    }

    @Override // p.b, p.d.a
    public final h a(boolean[] r12) {
        int r8 = -1;
        int r10 = 0;
    L4:
        if (r10 >= this.f9891h) goto L33;
        h[] r11 = this.f9889f;
        h r13 = r11[r10];
        if (r12[r13.f9896b] == true) goto L32;
        b r14 = this.f9892i;
        r14.f9893a = r13;
        boolean r15 = true;
        int r16 = 8;
        if (r8 != (-1)) goto L21;
    L10:
        if (r16 < 0) goto L18;
        float r17 = r14.f9893a.f9902r[r16];
        if (r17 > 0.0f) goto L18;
        if (r17 < 0.0f) goto L19;
        r16 = r16 - 1;
    L19:
        if (r15 == false) goto L32;
    L31:
        r8 = r10;
    L18:
        r15 = false;
        goto L19
    L21:
        h r18 = r11[r8];
    L22:
        if (r16 < 0) goto L29;
        float r19 = r18.f9902r[r16];
        float r20 = r14.f9893a.f9902r[r16];
        if (r20 != r19) goto L27;
        r16 = r16 - 1;
        goto L22
    L27:
        if (r20 >= r19) goto L29;
    L30:
        if (r15 == false) goto L32;
    L29:
        r15 = false;
    L32:
        r10 = r10 + 1;
        goto L4
    L33:
        if (r8 != (-1)) goto L37;
        return null;
    L37:
        return this.f9889f[r8];
    }

    @Override // p.b
    public final boolean e() {
        if (this.f9891h != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // p.b
    public final void i(d r19, p.b r20, boolean r21) {
        h r8 = r20.f9861a;
        if (r8 != null) goto L5;
        return;
    L5:
        p.b.a r10 = r20.f9864d;
        int r11 = r10.g();
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L33;
        h r13 = r10.a(r12);
        float r14 = r10.h(r12);
        b r15 = this.f9892i;
        r15.f9893a = r13;
        boolean r16 = r13.f9895a;
        float[] r17 = r8.f9902r;
        if (r16 == false) goto L19;
        int r18 = 0;
        boolean r110 = true;
    L10:
        if (r18 >= 9) goto L16;
        float[] r22 = r15.f9893a.f9902r;
        float r111 = (r17[r18] * r14) + r22[r18];
        r22[r18] = r111;
        if (Math.abs(r111) >= 1.0E-4f) goto L14;
        r15.f9893a.f9902r[r18] = 0.0f;
    L15:
        r18 = r18 + 1;
        goto L10
    L14:
        r110 = false;
        goto L15
    L16:
        if (r110 == false) goto L18;
        r15.f9894b.k(r15.f9893a);
    L18:
        boolean r112 = false;
    L30:
        if (r112 == false) goto L32;
        j(r13);
    L32:
        this.f9862b = (r20.f9862b * r14) + this.f9862b;
        r12 = r12 + 1;
        goto L6
    L19:
        int r23 = 0;
    L20:
        if (r23 >= 9) goto L29;
        float r113 = r17[r23];
        if (r113 == 0.0f) goto L27;
        float r114 = r113 * r14;
        if (Math.abs(r114) >= 1.0E-4f) goto L26;
        r114 = 0.0f;
    L26:
        r15.f9893a.f9902r[r23] = r114;
    L28:
        r23 = r23 + 1;
        goto L20
    L27:
        r15.f9893a.f9902r[r23] = 0.0f;
        goto L28
    L29:
        r112 = true;
        goto L30
    L33:
        k(r8);
    }

    public final void j(h r8) {
        int r10 = this.f9891h + 1;
        h[] r11 = this.f9889f;
        if (r10 <= r11.length) goto L5;
        h[] r12 = (h[]) Arrays.copyOf(r11, r11.length * 2);
        this.f9889f = r12;
        this.f9890g = (h[]) Arrays.copyOf(r12, r12.length * 2);
    L5:
        h[] r13 = this.f9889f;
        int r14 = this.f9891h;
        r13[r14] = r8;
        int r15 = r14 + 1;
        this.f9891h = r15;
        if (r15 > 1) goto L8;
    L17:
        r8.f9895a = true;
        r8.a(this);
        return;
    L8:
        if (r13[r15 - 1].f9896b <= r8.f9896b) goto L17;
        int r16 = 0;
        int r17 = 0;
    L10:
        int r18 = this.f9891h;
        if (r17 >= r18) goto L13;
        this.f9890g[r17] = this.f9889f[r17];
        r17 = r17 + 1;
        goto L10
    L13:
        Arrays.sort(this.f9890g, 0, r18, new a());
    L15:
        if (r16 >= this.f9891h) goto L17;
        this.f9889f[r16] = this.f9890g[r16];
        r16 = r16 + 1;
        goto L15
    }

    public final void k(h r8) {
        int r10 = 0;
    L4:
        if (r10 >= this.f9891h) goto L13;
        if (this.f9889f[r10] == r8) goto L7;
        r10 = r10 + 1;
    L7:
        int r11 = this.f9891h;
        if (r10 >= (r11 - 1)) goto L10;
        h[] r12 = this.f9889f;
        int r13 = r10 + 1;
        r12[r10] = r12[r13];
        r10 = r13;
        goto L7
    L10:
        this.f9891h = r11 - 1;
        r8.f9895a = false;
        return;
    }

    @Override // p.b
    public final String toString() {
        String r8 = " goal -> (" + this.f9862b + ") : ";
        int r10 = 0;
    L4:
        if (r10 >= this.f9891h) goto L6;
        h r11 = this.f9889f[r10];
        b r12 = this.f9892i;
        r12.f9893a = r11;
        r8 = r8 + r12 + " ";
        r10 = r10 + 1;
        goto L4
    L6:
        return r8;
    }
}
