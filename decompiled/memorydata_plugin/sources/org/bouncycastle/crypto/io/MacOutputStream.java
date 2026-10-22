package org.bouncycastle.crypto.io;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import org.bouncycastle.crypto.Mac;

/* JADX INFO: loaded from: classes7.dex */
public class MacOutputStream extends OutputStream {
    protected Mac mac;

    public MacOutputStream(Mac r3) {
        this.mac = (Mac) ZeusTransformUtils.wrapperContextForParams(r3, Mac.class, "com.obric.memorydata.plugin");
    }

    @Override // java.io.OutputStream
    public void write(int r1) {
        this.mac.update((byte) r1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r1, int r2, int r3) {
        this.mac.update(r1, r2, r3);
    }
}
