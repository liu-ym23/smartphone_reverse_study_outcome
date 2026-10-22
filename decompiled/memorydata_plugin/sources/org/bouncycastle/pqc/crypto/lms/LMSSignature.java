package org.bouncycastle.pqc.crypto.lms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Arrays;
import org.bouncycastle.util.Encodable;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes7.dex */
class LMSSignature implements Encodable {
    private final LMOtsSignature otsSignature;
    private final LMSigParameters parameter;
    private final int q;
    private final byte[][] y;

    public LMSSignature(int r1, LMOtsSignature r2, LMSigParameters r3, byte[][] r4) {
        this.q = r1;
        this.otsSignature = r2;
        this.parameter = r3;
        this.y = r4;
    }

    public static LMSSignature getInstance(Object r9) {
        if (ZeusTransformUtils.instanceOf(r9, LMSSignature.class) == false) goto L7;
        return (LMSSignature) ZeusTransformUtils.preCheckCast(r9, LMSSignature.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r9, DataInputStream.class) == false) goto L14;
        int r0 = ((DataInputStream) ZeusTransformUtils.preCheckCast(r9, DataInputStream.class, "com.obric.memorydata.plugin")).readInt();
        LMOtsSignature r1 = LMOtsSignature.getInstance(r9);
        LMSigParameters r2 = LMSigParameters.getParametersForType(((DataInputStream) ZeusTransformUtils.preCheckCast(r9, DataInputStream.class, "com.obric.memorydata.plugin")).readInt());
        int r4 = r2.getH();
        byte[][] r5 = new byte[r4][];
        int r6 = 0;
    L9:
        if (r6 >= r4) goto L12;
        r5[r6] = new byte[r2.getM()];
        ((DataInputStream) ZeusTransformUtils.preCheckCast(r9, DataInputStream.class, "com.obric.memorydata.plugin")).readFully(r5[r6]);
        r6 = r6 + 1;
        goto L9
    L12:
        return new LMSSignature(r0, r1, r2, r5);
    L14:
        if ((r9 instanceof byte[]) == false) goto L27;
        DataInputStream r3 = null;
        DataInputStream r7 = new DataInputStream(new ByteArrayInputStream((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r9, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L22
        LMSSignature r10 = getInstance(r7);     // Catch: Throwable -> L20
        r7.close();
        return r10;
    L20:
        th = th;
        r3 = r7;
    L23:
        if (r3 == null) goto L25;
        r3.close();
    L25:
        throw th;
    L22:
        th = th;
        goto L23
    L27:
        if (ZeusTransformUtils.instanceOf(r9, InputStream.class) == false) goto L31;
        return getInstance(Streams.readAll((InputStream) ZeusTransformUtils.preCheckCast(r9, InputStream.class, "com.obric.memorydata.plugin")));
    L31:
        throw new IllegalArgumentException("cannot parse " + r9);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L31:
        return false;
    L8:
        if (getClass() != r4.getClass()) goto L31;
        LMSSignature r5 = (LMSSignature) ZeusTransformUtils.preCheckCast(r4, LMSSignature.class, "com.obric.memorydata.plugin");
        if (this.q == r5.q) goto L13;
        return false;
    L13:
        LMOtsSignature r1 = this.otsSignature;
        if (r1 == null) goto L19;
        if (r1.equals(r5.otsSignature) == false) goto L20;
    L21:
        LMSigParameters r2 = this.parameter;
        if (r2 == null) goto L27;
        if (r2.equals(r5.parameter) == true) goto L30;
    L28:
        return false;
    L30:
        return Arrays.deepEquals(this.y, r5.y);
    L27:
        if (r5.parameter == null) goto L30;
    L20:
        return false;
    L19:
        if (r5.otsSignature == null) goto L21;
        goto L20
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        return Composer.compose().u32str(this.q).bytes(this.otsSignature.getEncoded()).u32str(this.parameter.getType()).bytes(this.y).build();
    }

    public int hashCode() {
        int r0 = this.q * 31;
        LMOtsSignature r1 = this.otsSignature;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        LMSigParameters r5 = this.parameter;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return ((r4 + r2) * 31) + Arrays.deepHashCode(this.y);
    L5:
        r3 = 0;
        goto L6
    }
}
