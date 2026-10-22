package com.google.common.hash;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 extends c {
    public final int d;
    public final int e;
    public long f;
    public long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f9272h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f9273i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f9274j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f9275k;

    public a0(int r5, int r10, long r11, long r12) {
        super(8);
        this.f9274j = 0;
        this.f9275k = 0;
        this.d = r5;
        this.e = r10;
        this.f = 8317987319222330741L ^ r11;
        this.g = 7237128888997146477L ^ r12;
        this.f9272h = 7816392313619706465L ^ r11;
        this.f9273i = 8387220255154660723L ^ r12;
    }

    @Override // com.google.common.hash.c
    public final void C(ByteBuffer r5) {
        this.f9274j += 8;
        long r10 = r5.getLong();
        this.f9273i ^= r10;
        F(this.d);
        this.f = r10 ^ this.f;
    }

    @Override // com.google.common.hash.c
    public final void D(ByteBuffer r10) {
        this.f9274j += (long) r10.remaining();
        int r5 = 0;
    L4:
        if (r10.hasRemaining() == false) goto L6;
        this.f9275k ^= (((long) r10.get()) & 255) << r5;
        r5 = r5 + 8;
        goto L4
    }

    public final void F(int r10) {
        int r5 = 0;
    L3:
        if (r5 >= r10) goto L5;
        long r11 = this.f;
        long r12 = this.g;
        this.f = r11 + r12;
        this.f9272h += this.f9273i;
        this.g = Long.rotateLeft(r12, 13);
        long r13 = Long.rotateLeft(this.f9273i, 16);
        long r14 = this.g;
        long r15 = this.f;
        this.g = r14 ^ r15;
        this.f9273i = r13 ^ this.f9272h;
        long r16 = Long.rotateLeft(r15, 32);
        long r17 = this.f9272h;
        long r18 = this.g;
        this.f9272h = r17 + r18;
        this.f = r16 + this.f9273i;
        this.g = Long.rotateLeft(r18, 17);
        long r19 = Long.rotateLeft(this.f9273i, 21);
        long r20 = this.g;
        long r21 = this.f9272h;
        this.g = r20 ^ r21;
        this.f9273i = r19 ^ this.f;
        this.f9272h = Long.rotateLeft(r21, 32);
        r5 = r5 + 1;
        goto L3
    }

    @Override // com.google.common.hash.c
    public final j z() {
        long r5 = this.f9275k ^ (this.f9274j << 56);
        this.f9275k = r5;
        this.f9273i ^= r5;
        F(this.d);
        this.f = r5 ^ this.f;
        this.f9272h ^= 255;
        F(this.e);
        return j.fromLong(((this.f ^ this.g) ^ this.f9272h) ^ this.f9273i);
    }
}
