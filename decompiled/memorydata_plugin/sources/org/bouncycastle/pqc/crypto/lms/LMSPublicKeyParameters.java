package org.bouncycastle.pqc.crypto.lms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes7.dex */
public class LMSPublicKeyParameters extends LMSKeyParameters {
    private final byte[] I;
    private final byte[] T1;
    private final LMOtsParameters lmOtsType;
    private final LMSigParameters parameterSet;

    public LMSPublicKeyParameters(LMSigParameters r2, LMOtsParameters r3, byte[] r4, byte[] r5) {
        super(false);
        this.parameterSet = r2;
        this.lmOtsType = r3;
        this.I = Arrays.clone(r5);
        this.T1 = Arrays.clone(r4);
    }

    public static LMSPublicKeyParameters getInstance(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, LMSPublicKeyParameters.class) == false) goto L7;
        return (LMSPublicKeyParameters) ZeusTransformUtils.preCheckCast(r6, LMSPublicKeyParameters.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r6, DataInputStream.class) == false) goto L11;
        LMSigParameters r0 = LMSigParameters.getParametersForType(((DataInputStream) ZeusTransformUtils.preCheckCast(r6, DataInputStream.class, "com.obric.memorydata.plugin")).readInt());
        LMOtsParameters r1 = LMOtsParameters.getParametersForType(((DataInputStream) ZeusTransformUtils.preCheckCast(r6, DataInputStream.class, "com.obric.memorydata.plugin")).readInt());
        byte[] r2 = new byte[16];
        ((DataInputStream) ZeusTransformUtils.preCheckCast(r6, DataInputStream.class, "com.obric.memorydata.plugin")).readFully(r2);
        byte[] r4 = new byte[r0.getM()];
        ((DataInputStream) ZeusTransformUtils.preCheckCast(r6, DataInputStream.class, "com.obric.memorydata.plugin")).readFully(r4);
        return new LMSPublicKeyParameters(r0, r1, r4, r2);
    L11:
        if ((r6 instanceof byte[]) == false) goto L24;
        DataInputStream r3 = null;
        DataInputStream r5 = new DataInputStream(new ByteArrayInputStream((byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(r6, byte[].class, "com.obric.memorydata.plugin"), byte[].class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L19
        LMSPublicKeyParameters r7 = getInstance(r5);     // Catch: Throwable -> L17
        r5.close();
        return r7;
    L17:
        th = th;
        r3 = r5;
    L20:
        if (r3 == null) goto L22;
        r3.close();
    L22:
        throw th;
    L19:
        th = th;
        goto L20
    L24:
        if (ZeusTransformUtils.instanceOf(r6, InputStream.class) == false) goto L28;
        return getInstance(Streams.readAll((InputStream) ZeusTransformUtils.preCheckCast(r6, InputStream.class, "com.obric.memorydata.plugin")));
    L28:
        throw new IllegalArgumentException("cannot parse " + r6);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L21:
        return false;
    L8:
        if (getClass() != r4.getClass()) goto L21;
        LMSPublicKeyParameters r5 = (LMSPublicKeyParameters) ZeusTransformUtils.preCheckCast(r4, LMSPublicKeyParameters.class, "com.obric.memorydata.plugin");
        if (this.parameterSet.equals(r5.parameterSet) == true) goto L14;
        return false;
    L14:
        if (this.lmOtsType.equals(r5.lmOtsType) == true) goto L17;
        return false;
    L17:
        if (Arrays.areEqual(this.I, r5.I) == true) goto L20;
        return false;
    L20:
        return Arrays.areEqual(this.T1, r5.T1);
    }

    @Override // org.bouncycastle.pqc.crypto.lms.LMSKeyParameters, org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        return toByteArray();
    }

    public int hashCode() {
        return (((((this.parameterSet.hashCode() * 31) + this.lmOtsType.hashCode()) * 31) + Arrays.hashCode(this.I)) * 31) + Arrays.hashCode(this.T1);
    }

    byte[] toByteArray() {
        return Composer.compose().u32str(this.parameterSet.getType()).u32str(this.lmOtsType.getType()).bytes(this.I).bytes(this.T1).build();
    }
}
