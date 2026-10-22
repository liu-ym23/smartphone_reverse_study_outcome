package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends com.lynx.tasm.utils.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f9297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9298c;
    public int d;
    public boolean e;

    @Override // com.lynx.tasm.utils.d, com.google.common.hash.z
    public final /* bridge */ /* synthetic */ l b(CharSequence r5, Charset r10) {
        return f(r5, r10);
    }

    @Override // com.google.common.hash.l
    public final j c() {
        com.google.common.base.b0.t(!this.e);
        this.e = true;
        int r5 = this.f9296a ^ Murmur3_32HashFunction.access$000((int) this.f9297b);
        this.f9296a = r5;
        return Murmur3_32HashFunction.access$600(r5, this.d);
    }

    @Override // com.google.common.hash.l
    public final l d(byte[] r5, int r10, int r11) {
        com.google.common.base.b0.p(r10, r10 + r11, r5.length);
        int r12 = 0;
    L3:
        int r13 = r12 + 4;
        if (r13 > r11) goto L6;
        z(4, Murmur3_32HashFunction.access$200(r5, r12 + r10));
        r12 = r13;
    L6:
        if (r12 >= r11) goto L8;
        z(1, r5[r10 + r12] & UByte.MAX_VALUE);
        r12 = r12 + 1;
        goto L6
    L8:
        return this;
    }

    @Override // com.google.common.hash.l
    public final l e(ByteBuffer r5) {
        ByteOrder r10 = r5.order();
        r5.order(ByteOrder.LITTLE_ENDIAN);
    L4:
        if (r5.remaining() < 4) goto L7;
        putInt(r5.getInt());
    L7:
        if (r5.hasRemaining() == false) goto L9;
        z(1, r5.get() & UByte.MAX_VALUE);
        goto L7
    L9:
        r5.order(r10);
        return this;
    }

    @Override // com.lynx.tasm.utils.d, com.google.common.hash.l
    public final l f(CharSequence r10, Charset r11) {
        if (com.google.common.base.h.f8658a.equals(r11) == false) goto L34;
        int r5 = r10.length();
        int r12 = 0;
    L5:
        int r13 = r12 + 4;
        if (r13 > r5) goto L13;
        char r14 = r10.charAt(r12);
        char r15 = r10.charAt(r12 + 1);
        char r16 = r10.charAt(r12 + 2);
        char r17 = r10.charAt(r12 + 3);
        if (r14 >= 128) goto L13;
        if (r15 >= 128) goto L13;
        if (r16 >= 128) goto L13;
        if (r17 >= 128) goto L13;
        z(4, (((r15 << '\b') | r14) | (r16 << 16)) | (r17 << 24));
        r12 = r13;
    L13:
        if (r12 >= r5) goto L32;
        char r18 = r10.charAt(r12);
        if (r18 >= 128) goto L18;
        z(1, r18);
    L31:
        r12 = r12 + 1;
        goto L13
    L18:
        if (r18 >= 2048) goto L21;
        z(2, Murmur3_32HashFunction.access$300(r18));
        goto L31
    L21:
        if (r18 >= 55296) goto L23;
    L30:
        z(3, Murmur3_32HashFunction.access$400(r18));
        goto L31
    L23:
        if (r18 > 57343) goto L30;
        int r19 = Character.codePointAt(r10, r12);
        if (r19 == r18) goto L27;
        r12 = r12 + 1;
        z(4, Murmur3_32HashFunction.access$500(r19));
        goto L31
    L27:
        u(r10.subSequence(r12, r5).toString().getBytes(r11));
        return this;
    L32:
        return this;
    L34:
        return super.f(r10, r11);
    }

    @Override // com.google.common.hash.l, com.google.common.hash.z
    public final l putInt(int r5) {
        z(4, r5);
        return this;
    }

    @Override // com.google.common.hash.z
    public final /* bridge */ /* synthetic */ z putLong(long r5) {
        putLong(r5);
        return this;
    }

    @Override // com.lynx.tasm.utils.d
    public final l v(char r5) {
        z(2, r5);
        return this;
    }

    public final void z(int r5, long r10) {
        long r11 = this.f9297b;
        int r12 = this.f9298c;
        long r13 = ((r10 & 4294967295L) << r12) | r11;
        this.f9297b = r13;
        int r14 = (r5 * 8) + r12;
        this.f9298c = r14;
        this.d += r5;
        if (r14 < 32) goto L6;
        this.f9296a = Murmur3_32HashFunction.access$100(this.f9296a, Murmur3_32HashFunction.access$000((int) r13));
        this.f9297b >>>= 32;
        this.f9298c -= 32;
        return;
    }

    @Override // com.google.common.hash.z
    public final z putInt(int r5) {
        z(4, r5);
        return this;
    }

    @Override // com.google.common.hash.l, com.google.common.hash.z
    public final l putLong(long r5) {
        z(4, (int) r5);
        z(4, r5 >>> 32);
        return this;
    }
}
