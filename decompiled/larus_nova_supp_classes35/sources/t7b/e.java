package t7b;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collections;
import java.util.List;
import v7b.a0;
import v7b.b0;
import v7b.s;
import v7b.t;
import v7b.x;
import v7b.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class e implements z7b.a {
    public final char a;

    @Override // z7b.a
    public final int a() {
        return 1;
    }

    @Override // z7b.a
    public final char b() {
        return this.a;
    }

    @Override // z7b.a
    public final char c() {
        return this.a;
    }

    public e(char r1) {
        this.a = r1;
    }

    @Override // z7b.a
    public final int d(com.ss.android.lark.commonmark.internal.f r7, com.ss.android.lark.commonmark.internal.f r8) {
        if (r7.e == false) goto L5;
    L6:
        int r0 = r8.c;
        if ((r0 % 3) != 0) goto L9;
    L11:
        int r2 = 2;
        if (r7.c() >= 2) goto L14;
    L16:
        s r1 = new v7b.f(String.valueOf(this.a));
        r2 = 1;
    L17:
        y r3 = new y();
        r3.b(r7.b(r2));
        List<b0> r9 = r7.a;
        b0 r10 = (b0) ListProtector.get(r9, r9.size() - 1);
        t r5 = new t(r10.h, (b0) ListProtector.get(r8.a, 0));
    L19:
        if (r5.hasNext() == false) goto L21;
        s r4 = (s) r5.next();
        r1.e(r4);
        r3.a(r4.j());
        goto L19
    L21:
        r3.b(r8.a(r2));
        List<x> r11 = r3.a;
        if (r11 != null) goto L25;
        r11 = Collections.emptyList();
    L25:
        r1.n(r11);
        r10.k(r1);
        return r2;
    L14:
        if (r8.c() < 2) goto L16;
        r1 = new a0(String.valueOf(this.a) + this.a);
        goto L17
    L9:
        if (((r7.c + r0) % 3) != 0) goto L11;
        return 0;
    L5:
        if (r8.d == false) goto L11;
        goto L6
    }
}
