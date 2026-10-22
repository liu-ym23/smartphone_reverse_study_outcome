package com.ss.ugc.effectplatform.cache.disklrucache;

import bytekn.foundation.io.file.ContentEncoding;
import bytekn.foundation.io.file.g;
import com.ss.ugc.effectplatform.extension.ByteArrayExKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f implements g {
    public static final byte f = 13;
    public static final byte g = 10;
    public byte[] a;
    public int b;
    public int c;
    public final bytekn.foundation.io.file.b d;
    public final ContentEncoding e;

    public static final class a {
    }

    public static final class b extends bytekn.foundation.io.file.a {
        public final /* synthetic */ f c;

        public final String toString() {
            int r0 = ((bytekn.foundation.io.file.a) this).b;
            if (r0 > 0) goto L5;
        L12:
            return ByteArrayExKt.b(((bytekn.foundation.io.file.a) this).a, 0, r0, this.c.e);
        L9:
            e = move-exception;
            throw new AssertionError(e);
        L5:
            if (((bytekn.foundation.io.file.a) this).a[r0 - 1] != f.f) goto L12;
            r0 = r0 - 1;
            goto L12
        }

        public b(int r1, f r2) {
            this.c = r2;
            super(r1);
        }
    }

    static {
        f = (byte) 13;
        g = (byte) 10;
    }

    public final boolean a() {
        byte[] r0 = this.a;
        if (r0 == null) goto L10;
        int r1 = this.d.a(r0, r0.length);
        if (r1 > 0) goto L7;
        return false;
    L7:
        this.b = 0;
        this.c = r1;
        return true;
    L10:
        throw new Exception("buf is null!");
    }

    public final String b() {
        byte[] r0 = this.a;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0 != null) goto L7;
        return "";
    L7:
        if (this.b >= this.c) goto L9;
    L11:
        int r2 = this.b;
        int r3 = this.c;
    L12:
        byte r4 = g;
        if (r2 >= r3) goto L25;
        if (r0[r2] == r4) goto L16;
        r2 = r2 + 1;
        goto L12
    L16:
        int r1 = this.b;
        if (r2 == r1) goto L21;
        int r5 = r2 - 1;
        if (r0[r5] != f) goto L21;
    L22:
        String r6 = ByteArrayExKt.b(r0, r1, r5 - r1, this.e);
        this.b = r2 + 1;
        return r6;
    L21:
        r5 = r2;
        goto L22
    L25:
        b r7 = new b((this.c - this.b) + 80, this);
    L26:
        int r8 = this.b;
        r7.a(r0, r8, this.c - r8);
        this.c = -1;
        if (a() == false) goto L28;
        int r9 = this.b;
        int r10 = this.c;
    L30:
        if (r9 >= r10) goto L26;
        if (r0[r9] == r4) goto L33;
        r9 = r9 + 1;
        goto L30
    L33:
        int r11 = this.b;
        if (r9 == r11) goto L36;
        r7.a(r0, r11, r9 - r11);
    L36:
        this.b = r9 + 1;
        return r7.toString();
    L28:
        return null;
    L9:
        if (a() == true) goto L11;
        return null;
    }

    public final void close() {
        this.d.close();
        this.a = null;
    }

    public f(bytekn.foundation.io.file.b r1, ContentEncoding r2) {
        this.d = r1;
        this.e = r2;
        if (r2 != ContentEncoding.Ascii) goto L7;
        this.a = new byte[8192];
        return;
    L7:
        throw new IllegalArgumentException("Unsupported encoding!");
    }
}
