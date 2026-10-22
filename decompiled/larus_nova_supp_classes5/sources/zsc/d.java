package zsc;

import org.commonmark.node.Text;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class d extends i {
    @Override // zsc.i
    public final char d() {
        return '!';
    }

    @Override // zsc.i
    public uvc.b b() {
        int r4 = this.d + 1;
        this.d = r4;
        if (c() != '[') goto L9;
        this.d++;
        Text r0 = f("![");
        k r8 = this.a;
        org.commonmark.internal.e r9 = new org.commonmark.internal.e(r0, r4, ((j) r8).j, ((j) r8).i, true);
        j r10 = (j) r8;
        org.commonmark.internal.e r2 = r10.j;
        if (r2 == null) goto L7;
        r2.g = true;
    L7:
        r10.j = r9;
        return r0;
    L9:
        return null;
    }

    public d() {
    }
}
