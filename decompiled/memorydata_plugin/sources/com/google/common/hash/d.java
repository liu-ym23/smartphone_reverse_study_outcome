package com.google.common.hash;

import com.google.common.base.n;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
abstract class d extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f4726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4727b;
    private final int c;

    public d(int r1) {
        this(r1, r1);
    }

    public d(int r3, int r4) {
        if ((r4 % r3) != 0) goto L5;
        boolean r0 = true;
    L6:
        n.a(r0);
        this.f4726a = ByteBuffer.allocate(r4 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f4727b = r4;
        this.c = r3;
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void c() {
        if (this.f4726a.remaining() >= 8) goto L6;
        d();
        return;
    }

    private g d(ByteBuffer r5) {
        if (r5.remaining() > this.f4726a.remaining()) goto L6;
        this.f4726a.put(r5);
        c();
        return this;
    L6:
        int r0 = this.f4727b - this.f4726a.position();
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L9;
        this.f4726a.put(r5.get());
        r1 = r1 + 1;
        goto L7
    L9:
        d();
    L11:
        if (r5.remaining() < this.c) goto L13;
        b(r5);
        goto L11
    L13:
        this.f4726a.put(r5);
        return this;
    }

    private void d() {
        i.b(this.f4726a);
    L4:
        if (this.f4726a.remaining() < this.c) goto L6;
        b(this.f4726a);
        goto L4
    L6:
        this.f4726a.compact();
    }

    @Override // com.google.common.hash.g
    public final HashCode a() {
        d();
        i.b(this.f4726a);
        if (this.f4726a.remaining() <= 0) goto L6;
        c(this.f4726a);
        ByteBuffer r0 = this.f4726a;
        i.b(r0, r0.limit());
    L6:
        return b();
    }

    @Override // com.google.common.hash.g
    public final g a(byte r2) {
        this.f4726a.put(r2);
        c();
        return this;
    }

    @Override // com.google.common.hash.c
    public final g a(char r2) {
        this.f4726a.putChar(r2);
        c();
        return this;
    }

    @Override // com.google.common.hash.c, com.google.common.hash.g
    public final g a(int r2) {
        this.f4726a.putInt(r2);
        c();
        return this;
    }

    @Override // com.google.common.hash.c, com.google.common.hash.g
    public final g a(long r2) {
        this.f4726a.putLong(r2);
        c();
        return this;
    }

    @Override // com.google.common.hash.c, com.google.common.hash.g
    public final g a(ByteBuffer r3) {
        ByteOrder r0 = r3.order();
        r3.order(ByteOrder.LITTLE_ENDIAN);     // Catch: Throwable -> L6
        g r2 = d(r3);     // Catch: Throwable -> L6
        r3.order(r0);
        return r2;
    L6:
        th = move-exception;
        r3.order(r0);
        throw th;
    }

    @Override // com.google.common.hash.c, com.google.common.hash.g
    public final g a(byte[] r1, int r2, int r3) {
        return d(ByteBuffer.wrap(r1, r2, r3).order(ByteOrder.LITTLE_ENDIAN));
    }

    public abstract HashCode b();

    @Override // com.google.common.hash.c, com.google.common.hash.g, com.google.common.hash.k
    public /* synthetic */ k b(int r1) {
        return a(r1);
    }

    @Override // com.google.common.hash.c, com.google.common.hash.g, com.google.common.hash.k
    public /* synthetic */ k b(long r1) {
        return a(r1);
    }

    public abstract void b(ByteBuffer r1);

    public void c(ByteBuffer r3) {
        i.b(r3, r3.limit());
        i.a(r3, this.c + 7);
    L3:
        int r0 = r3.position();
        int r1 = this.c;
        if (r0 >= r1) goto L6;
        r3.putLong(0);
        goto L3
    L6:
        i.a(r3, r1);
        i.b(r3);
        b(r3);
    }
}
