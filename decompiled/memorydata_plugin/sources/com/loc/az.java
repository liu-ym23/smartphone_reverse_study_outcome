package com.loc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class az extends bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ByteArrayOutputStream f5342a;

    public az() {
        this.f5342a = new ByteArrayOutputStream();
    }

    public az(bf r1) {
        super(r1);
        this.f5342a = new ByteArrayOutputStream();
    }

    @Override // com.loc.bf
    public final byte[] a(byte[] r2) {
        byte[] r3 = this.f5342a.toByteArray();
        this.f5342a.close();     // Catch: IOException -> L5
    L7:
        this.f5342a = new ByteArrayOutputStream();
        return r3;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // com.loc.bf
    public final void b(byte[] r1) {
        this.f5342a.write(r1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }
}
