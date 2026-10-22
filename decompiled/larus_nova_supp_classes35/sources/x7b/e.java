package x7b;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import v7b.x;
import w7b.f;
import w7b.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public final List<f> a;
    public int b;
    public int c;
    public f d;
    public int e;

    public final int m() {
        int r0 = 0;
    L3:
        char r1 = j();
        if (r1 == ' ') goto L7;
        switch(r1) {
            case 9: goto L7;
            case 10: goto L7;
            case 11: goto L7;
            case 12: goto L7;
            case 13: goto L7;
            default: goto L6;
        };
    L6:
        return r0;
    L7:
        r0 = r0 + 1;
        g();
        goto L3
    }

    public final boolean d() {
        if (this.c >= this.e) goto L6;
        return true;
    L6:
        if (this.b < (this.a.size() - 1)) goto L10;
        return false;
    L10:
        return true;
    }

    public final void g() {
        int r0 = this.c + 1;
        this.c = r0;
        if (r0 <= this.e) goto L10;
        int r1 = this.b + 1;
        this.b = r1;
        if (r1 >= this.a.size()) goto L7;
        f r2 = (f) ListProtector.get(this.a, this.b);
        this.d = r2;
        this.e = r2.a.length();
    L8:
        this.c = 0;
        return;
    L7:
        f r3 = new f(BuildConfig.FLAVOR, null);
        this.d = r3;
        this.e = r3.a.length();
        goto L8
    }

    public final char j() {
        int r0 = this.c;
        if (r0 >= this.e) goto L7;
        return this.d.a.charAt(r0);
    L7:
        if (this.b >= (this.a.size() - 1)) goto L10;
        return '\n';
    L10:
        return 0;
    }

    public final d k() {
        return new d(this.b, this.c);
    }

    public e(List r4) {
        this.d = new f(BuildConfig.FLAVOR, null);
        this.e = 0;
        this.a = r4;
        this.b = 0;
        this.c = 0;
        ArrayList r5 = (ArrayList) r4;
        if (r5.isEmpty() == true) goto L6;
        a(0, 0);
        f r6 = (f) ListProtector.get(r5, 0);
        this.d = r6;
        this.e = r6.a.length();
        return;
    }

    public final int b(char r3) {
        int r0 = 0;
    L3:
        char r1 = j();
        if (r1 == 0) goto L5;
        if (r1 == r3) goto L8;
        r0 = r0 + 1;
        g();
        goto L3
    L8:
        return r0;
    L5:
        return -1;
    }

    public final int e(a8b.a r4) {
        int r0 = 0;
    L3:
        char r1 = j();
        if (r4.a.get(r1) == false) goto L6;
        r0 = r0 + 1;
        g();
        goto L3
    L6:
        return r0;
    }

    public final int f(char r3) {
        int r0 = 0;
    L4:
        if (j() != r3) goto L6;
        r0 = r0 + 1;
        g();
        goto L4
    L6:
        return r0;
    }

    public final boolean h(char r2) {
        if (j() != r2) goto L6;
        g();
        return true;
    L6:
        return false;
    }

    public final boolean i(String r5) {
        int r0 = this.c;
        if (r0 < this.e) goto L5;
    L15:
        return false;
    L5:
        if ((r0 + r5.length()) > this.e) goto L15;
        int r1 = 0;
    L8:
        if (r1 >= r5.length()) goto L13;
        if (this.d.a.charAt(this.c + r1) != r5.charAt(r1)) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        return false;
    L13:
        this.c += r5.length();
        return true;
    }

    public final void l(d r3) {
        a(r3.a, r3.b);
        int r0 = r3.a;
        this.b = r0;
        this.c = r3.b;
        f r4 = (f) ListProtector.get(this.a, r0);
        this.d = r4;
        this.e = r4.a.length();
    }

    public final void a(int r4, int r5) {
        if (r4 < 0) goto L13;
        if (r4 >= this.a.size()) goto L13;
        f r6 = (f) ListProtector.get(this.a, r4);
        if (r5 < 0) goto L11;
        if (r5 > r6.a.length()) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("Index " + r5 + " out of range, line length: " + r6.a.length());
    L13:
        throw new IllegalArgumentException("Line index " + r4 + " out of range, number of lines: " + this.a.size());
    }

    public final g c(d r5, d r6) {
        int r0 = r5.a;
        if (r0 != r6.a) goto L10;
        f r1 = (f) ListProtector.get(this.a, r0);
        CharSequence r7 = r1.a.subSequence(r5.b, r6.b);
        x r2 = r1.b;
        if (r2 == null) goto L7;
        x r3 = new x(r2.a, r2.b + r5.b, r7.length());
    L8:
        f r8 = new f(r7, r3);
        g r9 = new g();
        ((ArrayList) r9.a).add(r8);
        return r9;
    L7:
        r3 = null;
        goto L8
    L10:
        g r4 = new g();
        f r10 = (f) ListProtector.get(this.a, r5.a);
        f r11 = r10.a(r5.b, r10.a.length());
        ((ArrayList) r4.a).add(r11);
        int r12 = r5.a;
    L11:
        r12 = r12 + 1;
        int r13 = r6.a;
        if (r12 >= r13) goto L14;
        f r14 = (f) ListProtector.get(this.a, r12);
        ((ArrayList) r4.a).add(r14);
        goto L11
    L14:
        f r15 = ((f) ListProtector.get(this.a, r13)).a(0, r6.b);
        ((ArrayList) r4.a).add(r15);
        return r4;
    }
}
