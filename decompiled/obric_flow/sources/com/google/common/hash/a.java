package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends com.lynx.tasm.utils.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f9271a;

    public a() {
        this.f9271a = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
    }

    public final void A(int r5) {
        ByteBuffer r10 = this.f9271a;
        C(r10.array(), 0, r5);     // Catch: Throwable -> L6
        r10.clear();
        return;
    L6:
        th = move-exception;
        r10.clear();
        throw th;
    }

    public void B(ByteBuffer r5) {
        if (r5.hasArray() == false) goto L5;
        C(r5.array(), r5.position() + r5.arrayOffset(), r5.remaining());
        r5.position(r5.limit());
        return;
    L5:
        int r10 = r5.remaining();
    L6:
        if (r10 <= 0) goto L10;
        z(r5.get());
        r10 = r10 - 1;
        goto L6
    }

    public abstract void C(byte[] r5, int r10, int r11);

    @Override // com.lynx.tasm.utils.d, com.google.common.hash.z
    public final /* bridge */ /* synthetic */ z a(byte[] r5) {
        u(r5);
        return this;
    }

    @Override // com.google.common.hash.l
    public final l d(byte[] r5, int r10, int r11) {
        com.google.common.base.b0.p(r10, r10 + r11, r5.length);
        C(r5, r10, r11);
        return this;
    }

    @Override // com.google.common.hash.l
    public final l e(ByteBuffer r5) {
        B(r5);
        return this;
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
    public final l u(byte[] r5) {
        r5.getClass();
        C(r5, 0, r5.length);
        return this;
    }

    @Override // com.lynx.tasm.utils.d
    public final l v(char r5) {
        this.f9271a.putChar(r5);
        A(2);
        return this;
    }

    public abstract void z(byte r5);

    @Override // com.google.common.hash.l, com.google.common.hash.z
    public final l putInt(int r5) {
        this.f9271a.putInt(r5);
        A(4);
        return this;
    }

    @Override // com.google.common.hash.l, com.google.common.hash.z
    public final l putLong(long r5) {
        this.f9271a.putLong(r5);
        A(8);
        return this;
    }
}
