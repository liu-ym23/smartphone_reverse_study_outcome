package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class i0 extends g0 {
    public final h0 c;

    @Override // com.lark.wire.g0
    public final boolean b() {
        return this.c.a();
    }

    @Override // com.lark.wire.g0
    public final long c() {
        return this.c.h();
    }

    @Override // com.lark.wire.g0
    public final int e() {
        return this.c.nextTag();
    }

    @Override // com.lark.wire.g0
    public final ByteString f() {
        return this.c.f();
    }

    @Override // com.lark.wire.g0
    public final int g() {
        return this.c.d();
    }

    @Override // com.lark.wire.g0
    public final long h() {
        return this.c.g();
    }

    @Override // com.lark.wire.g0
    public final String i() {
        return this.c.e();
    }

    @Override // com.lark.wire.g0
    public final int k() {
        return this.c.c();
    }

    @Override // com.lark.wire.g0
    public final long l() {
        return this.c.l();
    }

    @Override // com.lark.wire.g0
    public final void m() {
        this.c.b();
    }

    public i0(h0 r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        super(new Buffer());
        this.c = r2;
    }

    @Override // com.lark.wire.g0
    public final ByteString d(long r2) {
        return this.c.k((int) r2);
    }

    @Override // com.lark.wire.g0
    public final void j(int r2) {
        this.c.m(r2);
    }

    @Override // com.lark.wire.g0
    public final void a(int r2, FieldEncoding r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "fieldEncoding");
        this.c.j(r2, r3, r4);
    }
}
