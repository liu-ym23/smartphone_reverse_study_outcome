package org.bouncycastle.pqc.crypto.lms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes7.dex */
public class Composer {
    private final ByteArrayOutputStream bos;

    private Composer() {
        this.bos = new ByteArrayOutputStream();
    }

    public static Composer compose() {
        return new Composer();
    }

    public Composer bool(boolean r2) {
        this.bos.write(r2 ? 1 : 0);
        return this;
    }

    public byte[] build() {
        return this.bos.toByteArray();
    }

    public Composer bytes(Encodable r3) {
        Encodable r4 = (Encodable) ZeusTransformUtils.wrapperContextForParams(r3, Encodable.class, "com.obric.memorydata.plugin");
        this.bos.write(r4.getEncoded());     // Catch: Exception -> L5
        return this;
    L5:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    public Composer bytes(byte[] r2) {
        this.bos.write(r2);     // Catch: Exception -> L4
        return this;
    L4:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    public Composer bytes(byte[][] r5) {
        int r0 = r5.length;     // Catch: Exception -> L7
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        byte[] r2 = r5[r1];     // Catch: Exception -> L7
        this.bos.write(r2);     // Catch: Exception -> L7
        r1 = r1 + 1;
        goto L3
    L6:
        return this;
    L7:
        e = move-exception;
        throw new RuntimeException(e.getMessage(), e);
    }

    public Composer padUntil(int r2, int r3) {
    L3:
        if (this.bos.size() >= r3) goto L5;
        this.bos.write(r2);
        goto L3
    L5:
        return this;
    }

    public Composer u16str(int r3) {
        int r4 = r3 & 65535;
        this.bos.write((byte) (r4 >>> 8));
        this.bos.write((byte) r4);
        return this;
    }

    public Composer u32str(int r3) {
        this.bos.write((byte) (r3 >>> 24));
        this.bos.write((byte) (r3 >>> 16));
        this.bos.write((byte) (r3 >>> 8));
        this.bos.write((byte) r3);
        return this;
    }

    public Composer u64str(long r3) {
        u32str((int) (r3 >>> 32));
        u32str((int) r3);
        return this;
    }
}
