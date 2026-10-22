package com.google.common.hash;

import java.io.Serializable;
import java.util.zip.Checksum;

/* JADX INFO: loaded from: classes2.dex */
final class ChecksumHashFunction extends b implements Serializable {
    private static final long serialVersionUID = 0;
    private final int bits;
    private final o checksumSupplier;
    private final String toString;

    public ChecksumHashFunction(o r5, int r10, String r11) {
        r5.getClass();
        this.checksumSupplier = r5;
        if (r10 != 32) goto L5;
    L8:
        boolean r12 = true;
    L9:
        com.google.common.base.b0.d(r10, "bits (%s) must be either 32 or 64", r12);
        this.bits = r10;
        r11.getClass();
        this.toString = r11;
        return;
    L5:
        if (r10 == 64) goto L8;
        r12 = false;
        goto L9
    }

    public static /* synthetic */ int access$100(ChecksumHashFunction r5) {
        return r5.bits;
    }

    public int bits() {
        return this.bits;
    }

    @Override // com.google.common.hash.k
    public l newHasher() {
        return new i(this, (Checksum) this.checksumSupplier.get());
    }

    public String toString() {
        return this.toString;
    }
}
