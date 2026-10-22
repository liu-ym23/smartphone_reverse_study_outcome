package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes7.dex */
final class ASN1UniversalTypes {
    static ASN1UniversalType get(int r0) {
        switch(r0) {
            case 1: goto L54;
            case 2: goto L52;
            case 3: goto L50;
            case 4: goto L48;
            case 5: goto L46;
            case 6: goto L44;
            case 7: goto L42;
            case 8: goto L40;
            case 9: goto L3;
            case 10: goto L38;
            case 11: goto L3;
            case 12: goto L36;
            case 13: goto L34;
            case 14: goto L3;
            case 15: goto L3;
            case 16: goto L32;
            case 17: goto L30;
            case 18: goto L28;
            case 19: goto L26;
            case 20: goto L24;
            case 21: goto L22;
            case 22: goto L20;
            case 23: goto L18;
            case 24: goto L16;
            case 25: goto L14;
            case 26: goto L12;
            case 27: goto L10;
            case 28: goto L8;
            case 29: goto L3;
            case 30: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return ASN1BMPString.TYPE;
    L8:
        return ASN1UniversalString.TYPE;
    L10:
        return ASN1GeneralString.TYPE;
    L12:
        return ASN1VisibleString.TYPE;
    L14:
        return ASN1GraphicString.TYPE;
    L16:
        return ASN1GeneralizedTime.TYPE;
    L18:
        return ASN1UTCTime.TYPE;
    L20:
        return ASN1IA5String.TYPE;
    L22:
        return ASN1VideotexString.TYPE;
    L24:
        return ASN1T61String.TYPE;
    L26:
        return ASN1PrintableString.TYPE;
    L28:
        return ASN1NumericString.TYPE;
    L30:
        return ASN1Set.TYPE;
    L32:
        return ASN1Sequence.TYPE;
    L34:
        return ASN1RelativeOID.TYPE;
    L36:
        return ASN1UTF8String.TYPE;
    L38:
        return ASN1Enumerated.TYPE;
    L40:
        return ASN1External.TYPE;
    L42:
        return ASN1ObjectDescriptor.TYPE;
    L44:
        return ASN1ObjectIdentifier.TYPE;
    L46:
        return ASN1Null.TYPE;
    L48:
        return ASN1OctetString.TYPE;
    L50:
        return ASN1BitString.TYPE;
    L52:
        return ASN1Integer.TYPE;
    L54:
        return ASN1Boolean.TYPE;
    }
}
