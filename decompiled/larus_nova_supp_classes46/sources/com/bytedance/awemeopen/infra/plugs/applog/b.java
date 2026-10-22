package com.bytedance.awemeopen.infra.plugs.applog;

import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends q64.d {
    public final byte[] a;
    public final String b;
    public final String c;

    @Override // q64.d
    public final long c() {
        return this.a.length;
    }

    public final String toString() {
        return "ByteArrayRequestBody(bytes=" + this.a.length + ", fileName=" + this.b + ", realContentType='" + this.c + "')";
    }

    @Override // q64.d
    public final String a() {
        return this.c;
    }

    @Override // q64.d
    public final String b() {
        return this.b;
    }

    public b(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "bytes");
        this.a = r2;
        this.b = null;
        this.c = "application/unknown";
    }

    @Override // q64.d
    public final void d(OutputStream r2) {
        Intrinsics.checkNotNullParameter(r2, "output");
        r2.write(this.a);
    }
}
