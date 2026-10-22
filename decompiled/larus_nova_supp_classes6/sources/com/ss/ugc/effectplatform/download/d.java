package com.ss.ugc.effectplatform.download;

import bytekn.foundation.io.file.b;
import com.ss.ugc.effectplatform.bridge.network.ByteReadStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class d extends b {
    public final ByteReadStream b;

    public final void close() {
        this.b.close();
    }

    public d(ByteReadStream r1) {
        this.b = r1;
    }

    public final int a(byte[] r3, int r4) {
        return this.b.read(r3, 0, r4);
    }
}
