package org.jsoup.nodes;

/* JADX INFO: loaded from: classes7.dex */
final class k {
    static Document.OutputSettings a(j r1) {
        Document r2 = r1.Z();
        if (r2 != null) goto L7;
        r2 = new Document("");
    L7:
        return r2.j();
    }

    static org.jsoup.parser.e b(j r1) {
        Document r2 = r1.Z();
        if (r2 == null) goto L8;
        if (r2.l() == null) goto L8;
        return r2.l();
    L8:
        return new org.jsoup.parser.e(new org.jsoup.parser.b());
    }
}
