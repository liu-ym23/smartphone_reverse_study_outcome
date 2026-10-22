package org.bouncycastle.pqc.crypto.lms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes7.dex */
public class HSSPublicKeyParameters extends LMSKeyParameters {
    private final int l;
    private final LMSPublicKeyParameters lmsPublicKey;

    public HSSPublicKeyParameters(int r2, LMSPublicKeyParameters r3) {
        super(false);
        this.l = r2;
        this.lmsPublicKey = r3;
    }

    public static HSSPublicKeyParameters getInstance(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, HSSPublicKeyParameters.class) == false) goto L7;
        return (HSSPublicKeyParameters) ZeusTransformUtils.preCheckCast(r5, HSSPublicKeyParameters.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r5, DataInputStream.class) == false) goto L11;
        return new HSSPublicKeyParameters(((DataInputStream) ZeusTransformUtils.preCheckCast(r5, DataInputStream.class, "com.obric.memorydata.plugin")).readInt(), LMSPublicKeyParameters.getInstance(r5));
    L11:
        if ((r5 instanceof byte[]) == false) goto L24;
        DataInputStream r1 = null;
        DataInputStream r2 = new DataInputStream(new ByteArrayInputStream((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r5, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L19
        HSSPublicKeyParameters r6 = getInstance(r2);     // Catch: Throwable -> L17
        r2.close();
        return r6;
    L17:
        th = th;
        r1 = r2;
    L20:
        if (r1 == null) goto L22;
        r1.close();
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
    L15:
        return false;
    L8:
        if (getClass() != r4.getClass()) goto L15;
        HSSPublicKeyParameters r5 = (HSSPublicKeyParameters) ZeusTransformUtils.preCheckCast(r4, HSSPublicKeyParameters.class, "com.obric.memorydata.plugin");
        if (this.l == r5.l) goto L14;
        return false;
    L14:
        return this.lmsPublicKey.equals(r5.lmsPublicKey);
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSKeyParameters, org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        return Composer.compose().u32str(this.l).bytes(this.lmsPublicKey.getEncoded()).build();
    }

    public int getL() {
        return this.l;
    }

    public LMSPublicKeyParameters getLMSPublicKey() {
        return this.lmsPublicKey;
    }

    public int hashCode() {
        return (this.l * 31) + this.lmsPublicKey.hashCode();
    }
}
