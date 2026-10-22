package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements k {
    public b() {
    }

    public j hashBytes(byte[] r5) {
        return hashBytes(r5, 0, r5.length);
    }

    public j hashInt(int r5) {
        return newHasher(4).putInt(r5).c();
    }

    public j hashLong(long r5) {
        return newHasher(8).putLong(r5).c();
    }

    @Override // com.google.common.hash.k
    public <T> j hashObject(T r5, Funnel<? super T> r10) {
        com.lynx.tasm.utils.d r11 = (com.lynx.tasm.utils.d) newHasher();
        r11.getClass();
        r10.funnel(r5, r11);
        return r11.c();
    }

    public j hashString(CharSequence r5, Charset r10) {
        return newHasher().f(r5, r10).c();
    }

    public j hashUnencodedChars(CharSequence r5) {
        com.lynx.tasm.utils.d r10 = (com.lynx.tasm.utils.d) newHasher(r5.length() * 2);
        r10.getClass();
        int r11 = r5.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        r10.v(r5.charAt(r12));
        r12 = r12 + 1;
        goto L3
    L6:
        return r10.c();
    }

    public l newHasher(int r5) {
        if (r5 < 0) goto L4;
        boolean r10 = true;
    L5:
        com.google.common.base.b0.d(r5, "expectedInputSize must be >= 0 but was %s", r10);
        return newHasher();
    L4:
        r10 = false;
        goto L5
    }

    public j hashBytes(byte[] r5, int r10, int r11) {
        com.google.common.base.b0.p(r10, r10 + r11, r5.length);
        return newHasher(r11).d(r5, r10, r11).c();
    }

    public j hashBytes(ByteBuffer r5) {
        return newHasher(r5.remaining()).e(r5).c();
    }
}
