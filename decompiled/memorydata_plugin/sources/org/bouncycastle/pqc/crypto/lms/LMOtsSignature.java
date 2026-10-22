package org.bouncycastle.pqc.crypto.lms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Arrays;
import org.bouncycastle.util.Encodable;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes7.dex */
class LMOtsSignature implements Encodable {
    private final byte[] C;
    private final LMOtsParameters type;
    private final byte[] y;

    public LMOtsSignature(LMOtsParameters r1, byte[] r2, byte[] r3) {
        this.type = r1;
        this.C = r2;
        this.y = r3;
    }

    public static LMOtsSignature getInstance(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, LMOtsSignature.class) == false) goto L7;
        return (LMOtsSignature) ZeusTransformUtils.preCheckCast(r5, LMOtsSignature.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r5, DataInputStream.class) == false) goto L11;
        LMOtsParameters r0 = LMOtsParameters.getParametersForType(((DataInputStream) ZeusTransformUtils.preCheckCast(r5, DataInputStream.class, "com.obric.memorydata.plugin")).readInt());
        byte[] r1 = new byte[r0.getN()];
        ((DataInputStream) ZeusTransformUtils.preCheckCast(r5, DataInputStream.class, "com.obric.memorydata.plugin")).readFully(r1);
        byte[] r2 = new byte[r0.getP() * r0.getN()];
        ((DataInputStream) ZeusTransformUtils.preCheckCast(r5, DataInputStream.class, "com.obric.memorydata.plugin")).readFully(r2);
        return new LMOtsSignature(r0, r1, r2);
    L11:
        if ((r5 instanceof byte[]) == false) goto L24;
        DataInputStream r3 = null;
        DataInputStream r4 = new DataInputStream(new ByteArrayInputStream((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r5, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L19
        LMOtsSignature r6 = getInstance(r4);     // Catch: Throwable -> L17
        r4.close();
        return r6;
    L17:
        th = th;
        r3 = r4;
    L20:
        if (r3 == null) goto L22;
        r3.close();
    L22:
        throw th;
    L19:
        th = th;
        goto L20
    L24:
        if (ZeusTransformUtils.instanceOf(r5, InputStream.class) == false) goto L28;
        return getInstance(Streams.readAll((InputStream) ZeusTransformUtils.preCheckCast(r5, InputStream.class, "com.obric.memorydata.plugin")));
    L28:
        throw new IllegalArgumentException("cannot parse " + r5);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L23:
        return false;
    L8:
        if (getClass() != r4.getClass()) goto L23;
        LMOtsSignature r5 = (LMOtsSignature) ZeusTransformUtils.preCheckCast(r4, LMOtsSignature.class, "com.obric.memorydata.plugin");
        LMOtsParameters r1 = this.type;
        if (r1 == null) goto L16;
        if (r1.equals(r5.type) == true) goto L19;
    L17:
        return false;
    L19:
        if (Arrays.equals(this.C, r5.C) == true) goto L22;
        return false;
    L22:
        return Arrays.equals(this.y, r5.y);
    L16:
        if (r5.type == null) goto L19;
        goto L17
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        return Composer.compose().u32str(this.type.getType()).bytes(this.C).bytes(this.y).build();
    }

    public LMOtsParameters getType() {
        return this.type;
    }

    public int hashCode() {
        LMOtsParameters r0 = this.type;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (((r1 * 31) + Arrays.hashCode(this.C)) * 31) + Arrays.hashCode(this.y);
    L5:
        r1 = 0;
        goto L7
    }
}
