package zsc;

import org.commonmark.node.Text;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class n extends i {
    @Override // zsc.i
    public final char d() {
        return '[';
    }

    @Override // zsc.i
    public uvc.b b() {
        int r2 = this.d;
        this.d = r2 + 1;
        Text r6 = f("[");
        k r7 = this.a;
        org.commonmark.internal.e r8 = new org.commonmark.internal.e(r6, r2, ((j) r7).j, ((j) r7).i, false);
        j r9 = (j) r7;
        org.commonmark.internal.e r0 = r9.j;
        if (r0 == null) goto L5;
        r0.g = true;
    L5:
        r9.j = r8;
        return r6;
    }

    public n() {
    }
}
