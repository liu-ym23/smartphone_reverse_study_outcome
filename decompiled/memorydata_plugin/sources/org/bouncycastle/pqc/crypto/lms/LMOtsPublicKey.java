package org.bouncycastle.pqc.crypto.lms;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes7.dex */
class LMOtsPublicKey implements Encodable {
    private final byte[] I;
    private final byte[] K;
    private final LMOtsParameters parameter;
    private final int q;

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L26:
        return false;
    L8:
        if (getClass() != r4.getClass()) goto L26;
        LMOtsPublicKey r5 = (LMOtsPublicKey) ZeusTransformUtils.preCheckCast(r4, LMOtsPublicKey.class, "com.obric.memorydata.plugin");
        if (this.q == r5.q) goto L13;
        return false;
    L13:
        LMOtsParameters r1 = this.parameter;
        if (r1 == null) goto L19;
        if (r1.equals(r5.parameter) == true) goto L22;
    L20:
        return false;
    L22:
        if (Arrays.equals(this.I, r5.I) == true) goto L25;
        return false;
    L25:
        return Arrays.equals(this.K, r5.K);
    L19:
        if (r5.parameter == null) goto L22;
        goto L20
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        return Composer.compose().u32str(this.parameter.getType()).bytes(this.I).u32str(this.q).bytes(this.K).build();
    }

    public int hashCode() {
        LMOtsParameters r0 = this.parameter;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (((((r1 * 31) + Arrays.hashCode(this.I)) * 31) + this.q) * 31) + Arrays.hashCode(this.K);
    L5:
        r1 = 0;
        goto L7
    }
}
