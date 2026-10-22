package com.bytedance.awemeopen.infra.base.net.mime;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends q64.d {
    public final ByteArrayOutputStream a;

    @Override // q64.d
    public final String a() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    @Override // q64.d
    public final String b() {
        return null;
    }

    @Override // q64.d
    public final long c() {
        return this.a.size();
    }

    public b() {
        this.a = new ByteArrayOutputStream();
    }

    @Override // q64.d
    public final void d(OutputStream r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, "output");
        r2.write(this.a.toByteArray());
    }
}
