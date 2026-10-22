package com.larus.cache;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public class g$a extends ByteArrayOutputStream {
    public final /* synthetic */ g a;

    @Override // java.io.ByteArrayOutputStream
    public final String toString() {
        int r0 = ((ByteArrayOutputStream) this).count;
        if (r0 > 0) goto L5;
    L12:
        return new String(((ByteArrayOutputStream) this).buf, 0, r0, this.a.b.name());
    L9:
        e = move-exception;
        throw new AssertionError(e);
    L5:
        if (((ByteArrayOutputStream) this).buf[r0 - 1] != 13) goto L12;
        r0 = r0 - 1;
        goto L12
    }

    public g$a(g r1, int r2) {
        this.a = r1;
        super(r2);
    }
}
