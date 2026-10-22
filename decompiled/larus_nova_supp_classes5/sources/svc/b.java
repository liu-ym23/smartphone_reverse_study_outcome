package svc;

import org.commonmark.internal.f;
import org.commonmark.node.Emphasis;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class b implements xvc.a {
    public final char a;

    @Override // xvc.a
    public final int a() {
        return 1;
    }

    @Override // xvc.a
    public final char b() {
        return this.a;
    }

    @Override // xvc.a
    public final char c() {
        return this.a;
    }

    public b(char r1) {
        this.a = r1;
    }

    @Override // xvc.a
    public final int d(f r3, f r4) {
        if (r3.d == false) goto L5;
    L6:
        int r0 = r4.h;
        if ((r0 % 3) != 0) goto L9;
    L13:
        if (r3.g >= 2) goto L15;
        return 1;
    L15:
        if (r4.g < 2) goto L19;
        return 2;
    L19:
        return 1;
    L9:
        if (((r3.h + r0) % 3) != 0) goto L13;
        return 0;
    L5:
        if (r4.c == false) goto L13;
        goto L6
    }

    @Override // xvc.a
    public final void e(Text r3, Text r4, int r5) {
        String r0 = String.valueOf(this.a);
        if (r5 != 1) goto L5;
        uvc.b r6 = new Emphasis(r0);
    L6:
        uvc.b r1 = r3.e;
    L7:
        if (r1 == null) goto L10;
        if (r1 == r4) goto L10;
        uvc.b r2 = r1.e;
        r6.b(r1);
        r1 = r2;
    L10:
        r3.d(r6);
        return;
    L5:
        r6 = new StrongEmphasis(r0 + r0);
        goto L6
    }
}
