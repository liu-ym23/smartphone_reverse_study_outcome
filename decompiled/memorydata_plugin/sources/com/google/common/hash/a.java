package com.google.common.hash;

import com.google.common.base.n;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
abstract class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f4725a;

    a() {
        this.f4725a = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
    }

    private g update(int r3) {
        update(this.f4725a.array(), 0, r3);     // Catch: Throwable -> L5
        i.a(this.f4725a);
        return this;
    L5:
        th = move-exception;
        i.a(this.f4725a);
        throw th;
    }

    @Override // com.google.common.hash.g
    public g a(byte r1) {
        update(r1);
        return this;
    }

    @Override // com.google.common.hash.c
    public g a(char r2) {
        this.f4725a.putChar(r2);
        return update(2);
    }

    @Override // com.google.common.hash.c, com.google.common.hash.g
    public g a(int r2) {
        this.f4725a.putInt(r2);
        return update(4);
    }

    @Override // com.google.common.hash.c, com.google.common.hash.g
    public g a(long r2) {
        this.f4725a.putLong(r2);
        return update(8);
    }

    @Override // com.google.common.hash.c, com.google.common.hash.g
    public g a(ByteBuffer r1) {
        update(r1);
        return this;
    }

    @Override // com.google.common.hash.c, com.google.common.hash.g
    public g a(byte[] r1) {
        n.a(r1);
        update(r1);
        return this;
    }

    @Override // com.google.common.hash.c, com.google.common.hash.g
    public g a(byte[] r3, int r4, int r5) {
        n.a(r4, r4 + r5, r3.length);
        update(r3, r4, r5);
        return this;
    }

    @Override // com.google.common.hash.c, com.google.common.hash.g, com.google.common.hash.k
    public /* synthetic */ k b(int r1) {
        return a(r1);
    }

    @Override // com.google.common.hash.c, com.google.common.hash.g, com.google.common.hash.k
    public /* synthetic */ k b(long r1) {
        return a(r1);
    }

    @Override // com.google.common.hash.c, com.google.common.hash.g, com.google.common.hash.k
    public /* synthetic */ k b(byte[] r1) {
        return a(r1);
    }

    public abstract void update(byte r1);

    public void update(ByteBuffer r4) {
        if (r4.hasArray() == false) goto L5;
        update(r4.array(), r4.arrayOffset() + r4.position(), r4.remaining());
        i.b(r4, r4.limit());
        return;
    L5:
        int r0 = r4.remaining();
    L6:
        if (r0 <= 0) goto L10;
        update(r4.get());
        r0 = r0 - 1;
        goto L6
    }

    public void update(byte[] r3) {
        update(r3, 0, r3.length);
    }

    public void update(byte[] r3, int r4, int r5) {
        int r0 = r4;
    L4:
        if (r0 >= (r4 + r5)) goto L6;
        update(r3[r0]);
        r0 = r0 + 1;
        goto L4
    }
}
