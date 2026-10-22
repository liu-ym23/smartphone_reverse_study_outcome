package com.google.common.hash;

import java.util.zip.Checksum;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Checksum f9289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ChecksumHashFunction f9290c;

    public i(ChecksumHashFunction r5, Checksum r10) {
        this.f9290c = r5;
        r10.getClass();
        this.f9289b = r10;
    }

    @Override // com.google.common.hash.a
    public final void C(byte[] r5, int r10, int r11) {
        this.f9289b.update(r5, r10, r11);
    }

    @Override // com.google.common.hash.l
    public final j c() {
        long r5 = this.f9289b.getValue();
        if (ChecksumHashFunction.access$100(this.f9290c) != 32) goto L7;
        return j.fromInt((int) r5);
    L7:
        return j.fromLong(r5);
    }

    @Override // com.google.common.hash.a
    public final void z(byte r5) {
        this.f9289b.update(r5);
    }
}
