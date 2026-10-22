package org.bouncycastle.pqc.crypto.lms;

/* JADX INFO: loaded from: classes7.dex */
class LMS {
    public static LMSPrivateKeyParameters generateKeys(LMSigParameters r9, LMOtsParameters r10, int r11, byte[] r12, byte[] r13) {
        if (r13 == null) goto L8;
        if (r13.length < r9.getM()) goto L8;
        return new LMSPrivateKeyParameters(r9, r10, r11, r12, 1 << r9.getH(), r13);
    L8:
        throw new IllegalArgumentException("root seed is less than " + r9.getM());
    }

    public static LMSSignature generateSign(LMSContext r4) {
        LMOtsSignature r0 = LM_OTS.lm_ots_generate_signature(r4.getPrivateKey(), r4.getQ(), r4.getC());
        return new LMSSignature(r4.getPrivateKey().getQ(), r0, r4.getSigParams(), r4.getPath());
    }

    public static LMSSignature generateSign(LMSPrivateKeyParameters r2, byte[] r3) {
        LMSContext r4 = r2.generateLMSContext();
        r4.update(r3, 0, r3.length);
        return generateSign(r4);
    }
}
