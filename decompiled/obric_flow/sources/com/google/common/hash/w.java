package com.google.common.hash;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class w extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MessageDigest f9294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9295c;
    public boolean d;

    public w(MessageDigest r5, int r10) {
        this.f9294b = r5;
        this.f9295c = r10;
    }

    @Override // com.google.common.hash.a
    public final void B(ByteBuffer r5) {
        com.google.common.base.b0.u(!this.d, "Cannot re-use a Hasher after calling hash() on it");
        this.f9294b.update(r5);
    }

    @Override // com.google.common.hash.a
    public final void C(byte[] r5, int r10, int r11) {
        com.google.common.base.b0.u(!this.d, "Cannot re-use a Hasher after calling hash() on it");
        this.f9294b.update(r5, r10, r11);
    }

    @Override // com.google.common.hash.l
    public final j c() {
        com.google.common.base.b0.u(!this.d, "Cannot re-use a Hasher after calling hash() on it");
        this.d = true;
        MessageDigest r5 = this.f9294b;
        int r10 = r5.getDigestLength();
        int r11 = this.f9295c;
        if (r11 != r10) goto L6;
        return j.fromBytesNoCopy(r5.digest());
    L6:
        return j.fromBytesNoCopy(Arrays.copyOf(r5.digest(), r11));
    }

    @Override // com.google.common.hash.a
    public final void z(byte r5) {
        com.google.common.base.b0.u(!this.d, "Cannot re-use a Hasher after calling hash() on it");
        this.f9294b.update(r5);
    }
}
