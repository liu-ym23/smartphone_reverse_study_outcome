package com.ss.ugc.effectplatform.bridge.network;

import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends InputStream {
    public final ByteReadStream a;

    @Override // java.io.InputStream
    public final int read() {
        return this.a.read();
    }

    public c(ByteReadStream r1) {
        this.a = r1;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r2, int r3, int r4) {
        return this.a.read(r2, r3, r4);
    }
}
