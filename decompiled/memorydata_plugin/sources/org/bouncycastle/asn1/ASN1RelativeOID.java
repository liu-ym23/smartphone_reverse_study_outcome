package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public class ASN1RelativeOID extends ASN1Primitive {
    static final ASN1UniversalType TYPE = null;
    private byte[] contents;
    private final String identifier;

    static {
        final Class<ASN1RelativeOID> r1 = ASN1RelativeOID.class;
        final int r2 = 13;
        TYPE = new AnonymousClass1(r1, r2);
    }

    private ASN1RelativeOID(byte[] r17, boolean r18) {
        byte[] r1 = r17;
        StringBuffer r2 = new StringBuffer();
        boolean r3 = true;
        long r9 = 0;
        int r8 = 0;
        BigInteger r11 = null;
    L4:
        if (r8 == r1.length) goto L24;
        int r12 = r1[r8] & 255;
        if (r9 > 72057594037927808L) goto L14;
        long r10 = r9 + ((long) (r12 & 127));
        if ((r12 & 128) != 0) goto L13;
        if (r3 == false) goto L11;
        r3 = false;
    L12:
        r2.append(r10);
        r9 = 0;
    L23:
        r8 = r8 + 1;
        goto L4
    L11:
        r2.append('.');
        goto L12
    L13:
        r9 = r10 << 7;
        goto L23
    L14:
        if (r11 != null) goto L16;
        r11 = BigInteger.valueOf(r9);
    L16:
        BigInteger r4 = r11.or(BigInteger.valueOf(r12 & 127));
        if ((r12 & 128) != 0) goto L22;
        if (r3 == false) goto L20;
        r3 = false;
    L21:
        r2.append(r4);
        r9 = 0;
        r11 = null;
        goto L23
    L20:
        r2.append('.');
        goto L21
    L22:
        r11 = r4.shiftLeft(7);
        goto L23
    L24:
        this.identifier = r2.toString();
        if (r18 == false) goto L27;
        r1 = Arrays.clone(r17);
    L27:
        this.contents = r1;
    }

    static ASN1RelativeOID createPrimitive(byte[] r1, boolean r2) {
        return new ASN1RelativeOID(r1, r2);
    }

    private void doOutput(ByteArrayOutputStream r4) {
        OIDTokenizer r0 = new OIDTokenizer(this.identifier);
    L4:
        if (r0.hasMoreTokens() == false) goto L9;
        String r3 = r0.nextToken();
        if (r3.length() <= 18) goto L7;
        writeField(r4, new BigInteger(r3));
        goto L4
    L7:
        writeField(r4, Long.parseLong(r3));
        goto L4
    }

    private synchronized byte[] getContents() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.contents != null) goto L6;
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: Throwable -> L9
        doOutput(r0);     // Catch: Throwable -> L9
        this.contents = r0.toByteArray();     // Catch: Throwable -> L9
    L6:
        byte[] r1 = this.contents;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r1;
    }

    static boolean isValidIdentifier(String r7, int r8) {
        int r0 = r7.length();
    L3:
        int r2 = 0;
    L4:
        r0 = r0 - 1;
        if (r0 < r8) goto L18;
        char r5 = r7.charAt(r0);
        if (r5 == '.') goto L8;
        if ('0' > r5) goto L17;
        if (r5 > '9') goto L17;
        r2 = r2 + 1;
    L17:
        return false;
    L8:
        if (r2 == 0) goto L12;
        if (r2 <= 1) goto L3;
        if (r7.charAt(r0 + 1) != '0') goto L3;
    L12:
        return false;
    L18:
        if (r2 == 0) goto L24;
        if (r2 > 1) goto L21;
    L23:
        return true;
    L21:
        if (r7.charAt(r0 + 1) != '0') goto L23;
    L24:
        return false;
    }

    static void writeField(ByteArrayOutputStream r5, long r6) {
        byte[] r0 = new byte[9];
        int r2 = 8;
        r0[8] = (byte) (((int) r6) & 127);
    L4:
        if (r6 < 128) goto L6;
        r6 = r6 >> 7;
        r2 = r2 - 1;
        r0[r2] = (byte) (((int) r6) | 128);
        goto L4
    L6:
        r5.write(r0, r2, 9 - r2);
    }

    static void writeField(ByteArrayOutputStream r7, BigInteger r8) {
        int r0 = (r8.bitLength() + 6) / 7;
        if (r0 != 0) goto L5;
        r7.write(0);
        return;
    L5:
        byte[] r3 = new byte[r0];
        int r4 = r0 - 1;
        int r5 = r4;
    L6:
        if (r5 < 0) goto L8;
        r3[r5] = (byte) (r8.intValue() | 128);
        r8 = r8.shiftRight(7);
        r5 = r5 - 1;
        goto L6
    L8:
        r3[r4] = (byte) (r3[r4] & ByteCompanionObject.MAX_VALUE);
        r7.write(r3, 0, r0);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean asn1Equals(ASN1Primitive r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, ASN1RelativeOID.class) == true) goto L10;
        return false;
    L10:
        ASN1RelativeOID r4 = (ASN1RelativeOID) ZeusTransformUtils.preCheckCast(r3, ASN1RelativeOID.class, "com.obric.memorydata.plugin");
        return this.identifier.equals(r4.identifier);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream r2, boolean r3) {
        r2.writeEncodingDL(r3, 13, getContents());
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean r1) {
        return ASN1OutputStream.getLengthOfEncodingDL(r1, getContents().length);
    }

    public String getId() {
        return this.identifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return this.identifier.hashCode();
    }

    public String toString() {
        return getId();
    }
}
