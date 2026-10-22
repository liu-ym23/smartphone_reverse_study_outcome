package org.bouncycastle.crypto.io;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FilterInputStream;
import java.io.InputStream;
import org.bouncycastle.crypto.Mac;

/* JADX INFO: loaded from: classes7.dex */
public class MacInputStream extends FilterInputStream {
    protected Mac mac;

    public MacInputStream(InputStream r3, Mac r4) {
        Mac r5 = (Mac) ZeusTransformUtils.wrapperContextForParams(r4, Mac.class, "com.obric.memorydata.plugin");
        super(r3);
        this.mac = r5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int r0 = this.in.read();
        if (r0 < 0) goto L5;
        this.mac.update((byte) r0);
    L5:
        return r0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r2, int r3, int r4) {
        int r5 = this.in.read(r2, r3, r4);
        if (r5 < 0) goto L5;
        this.mac.update(r2, r3, r5);
    L5:
        return r5;
    }
}
