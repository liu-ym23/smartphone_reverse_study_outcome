package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ASN1Util {
    public static String getTagText(int r2, int r3) {
        if (r2 != 64) goto L5;
        StringBuilder r4 = new StringBuilder();
        String r0 = "[APPLICATION ";
    L10:
        return r4.append(r0).append(r3).append("]").toString();
    L5:
        if (r2 != 128) goto L7;
        r4 = new StringBuilder();
        r0 = "[CONTEXT ";
        goto L10
    L7:
        if (r2 == 192) goto L11;
        r4 = new StringBuilder();
        r0 = "[UNIVERSAL ";
        goto L10
    L11:
        r4 = new StringBuilder();
        r0 = "[PRIVATE ";
        goto L10
    }

    public static String getTagText(ASN1TaggedObject r1) {
        return getTagText(r1.getTagClass(), r1.getTagNo());
    }
}
