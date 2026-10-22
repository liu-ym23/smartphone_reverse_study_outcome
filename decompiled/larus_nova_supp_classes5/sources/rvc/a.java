package rvc;

import org.commonmark.ext.gfm.strikethrough.Strikethrough;
import org.commonmark.internal.f;
import org.commonmark.node.Text;
import uvc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a implements xvc.a {
    public a() {
    }

    @Override // xvc.a
    public final int a() {
        return 2;
    }

    @Override // xvc.a
    public final char b() {
        return '~';
    }

    @Override // xvc.a
    public final char c() {
        return '~';
    }

    @Override // xvc.a
    public final int d(f r2, f r3) {
        if (r2.g >= 2) goto L5;
        return 0;
    L5:
        if (r3.g < 2) goto L9;
        return 2;
    L9:
        return 0;
    }

    @Override // xvc.a
    public final void e(Text r3, Text r4, int r5) {
        Strikethrough r6 = new Strikethrough();
        b r0 = r3.e;
    L3:
        if (r0 == null) goto L6;
        if (r0 == r4) goto L6;
        b r1 = r0.e;
        r6.b(r0);
        r0 = r1;
    L6:
        r3.d(r6);
    }
}
