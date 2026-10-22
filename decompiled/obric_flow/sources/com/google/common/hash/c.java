package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends com.lynx.tasm.utils.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f9276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9278c;

    public c(int r5) {
        if ((r5 % r5) != 0) goto L5;
        boolean r10 = true;
    L6:
        com.google.common.base.b0.i(r10);
        this.f9276a = ByteBuffer.allocate(r5 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f9277b = r5;
        this.f9278c = r5;
        return;
    L5:
        r10 = false;
        goto L6
    }

    public final void A() {
        ByteBuffer r5 = this.f9276a;
        r5.flip();
    L4:
        if (r5.remaining() < this.f9278c) goto L6;
        C(r5);
        goto L4
    L6:
        r5.compact();
    }

    public final void B() {
        if (this.f9276a.remaining() >= 8) goto L6;
        A();
        return;
    }

    public abstract void C(ByteBuffer r5);

    public abstract void D(ByteBuffer r5);

    public final void E(ByteBuffer r5) {
        int r10 = r5.remaining();
        ByteBuffer r11 = this.f9276a;
        if (r10 > r11.remaining()) goto L6;
        r11.put(r5);
        B();
        return;
    L6:
        int r12 = this.f9277b - r11.position();
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L9;
        r11.put(r5.get());
        r13 = r13 + 1;
        goto L7
    L9:
        A();
    L11:
        if (r5.remaining() < this.f9278c) goto L13;
        C(r5);
        goto L11
    L13:
        r11.put(r5);
    }

    @Override // com.google.common.hash.l
    public final j c() {
        A();
        ByteBuffer r5 = this.f9276a;
        r5.flip();
        if (r5.remaining() <= 0) goto L6;
        D(r5);
        r5.position(r5.limit());
    L6:
        return z();
    }

    @Override // com.google.common.hash.l
    public final l d(byte[] r5, int r10, int r11) {
        E(ByteBuffer.wrap(r5, r10, r11).order(ByteOrder.LITTLE_ENDIAN));
        return this;
    }

    @Override // com.google.common.hash.l
    public final l e(ByteBuffer r5) {
        ByteOrder r10 = r5.order();
        r5.order(ByteOrder.LITTLE_ENDIAN);     // Catch: Throwable -> L6
        E(r5);     // Catch: Throwable -> L6
        r5.order(r10);
        return this;
    L6:
        th = move-exception;
        r5.order(r10);
        throw th;
    }

    @Override // com.google.common.hash.z
    public final /* bridge */ /* synthetic */ z putInt(int r5) {
        putInt(r5);
        return this;
    }

    @Override // com.google.common.hash.z
    public final /* bridge */ /* synthetic */ z putLong(long r5) {
        putLong(r5);
        return this;
    }

    @Override // com.lynx.tasm.utils.d
    public final l v(char r5) {
        this.f9276a.putChar(r5);
        B();
        return this;
    }

    public abstract j z();

    @Override // com.google.common.hash.l, com.google.common.hash.z
    public final l putInt(int r5) {
        this.f9276a.putInt(r5);
        B();
        return this;
    }

    @Override // com.google.common.hash.l, com.google.common.hash.z
    public final l putLong(long r5) {
        this.f9276a.putLong(r5);
        B();
        return this;
    }
}
