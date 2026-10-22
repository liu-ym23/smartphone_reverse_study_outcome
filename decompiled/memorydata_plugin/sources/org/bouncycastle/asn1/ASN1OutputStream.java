package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes7.dex */
public class ASN1OutputStream {
    private OutputStream os;

    ASN1OutputStream(OutputStream r1) {
        this.os = r1;
    }

    public static ASN1OutputStream create(OutputStream r1) {
        return new ASN1OutputStream(r1);
    }

    public static ASN1OutputStream create(OutputStream r1, String r2) {
        if (r2.equals("DER") == false) goto L7;
        return new DEROutputStream(r1);
    L7:
        if (r2.equals("DL") == false) goto L11;
        return new DLOutputStream(r1);
    L11:
        return new ASN1OutputStream(r1);
    }

    static int getLengthOfDL(int r1) {
        if (r1 >= 128) goto L6;
        return 1;
    L6:
        int r0 = 2;
    L7:
        r1 = r1 >>> 8;
        if (r1 == 0) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        return r0;
    }

    static int getLengthOfEncodingDL(boolean r1, int r2) {
        int r0 = getLengthOfDL(r2);
        return ((r1 ? 1 : 0) + r0) + r2;
    }

    static int getLengthOfIdentifier(int r1) {
        if (r1 >= 31) goto L6;
        return 1;
    L6:
        int r0 = 2;
    L7:
        r1 = r1 >>> 7;
        if (r1 == 0) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        return r0;
    }

    void flushInternal() {
    }

    DEROutputStream getDERSubStream() {
        return new DEROutputStream(this.os);
    }

    DLOutputStream getDLSubStream() {
        return new DLOutputStream(this.os);
    }

    final void write(int r1) {
        this.os.write(r1);
    }

    final void write(byte[] r1, int r2, int r3) {
        this.os.write(r1, r2, r3);
    }

    final void writeDL(int r4) {
        if (r4 >= 128) goto L5;
        write(r4);
        return;
    L5:
        int r0 = 5;
        byte[] r1 = new byte[5];
    L6:
        r0 = r0 - 1;
        r1[r0] = (byte) r4;
        r4 = r4 >>> 8;
        if (r4 != 0) goto L6;
        int r5 = 5 - r0;
        int r2 = r0 - 1;
        r1[r2] = (byte) (r5 | 128);
        write(r1, r2, r5 + 1);
    }

    void writeElements(ASN1Encodable[] r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5[r1].toASN1Primitive().encode(this, true);
        r1 = r1 + 1;
        goto L3
    }

    final void writeEncodingDL(boolean r1, int r2, byte r3) {
        writeIdentifier(r1, r2);
        writeDL(1);
        write(r3);
    }

    final void writeEncodingDL(boolean r1, int r2, byte r3, byte[] r4, int r5, int r6) {
        writeIdentifier(r1, r2);
        writeDL(r6 + 1);
        write(r3);
        write(r4, r5, r6);
    }

    final void writeEncodingDL(boolean r1, int r2, byte[] r3) {
        writeIdentifier(r1, r2);
        writeDL(r3.length);
        write(r3, 0, r3.length);
    }

    final void writeEncodingDL(boolean r1, int r2, byte[] r3, int r4, int r5) {
        writeIdentifier(r1, r2);
        writeDL(r5);
        write(r3, r4, r5);
    }

    final void writeEncodingDL(boolean r1, int r2, byte[] r3, int r4, int r5, byte r6) {
        writeIdentifier(r1, r2);
        writeDL(r5 + 1);
        write(r3, r4, r5);
        write(r6);
    }

    final void writeEncodingIL(boolean r1, int r2, ASN1Encodable[] r3) {
        writeIdentifier(r1, r2);
        write(128);
        writeElements(r3);
        write(0);
        write(0);
    }

    final void writeIdentifier(boolean r1, int r2) {
        if (r1 == false) goto L5;
        write(r2);
        return;
    }

    final void writeIdentifier(boolean r4, int r5, int r6) {
        if (r4 == true) goto L5;
        return;
    L5:
        if (r6 >= 31) goto L7;
        write(r5 | r6);
        return;
    L7:
        byte[] r0 = new byte[6];
        int r1 = 5;
        r0[5] = (byte) (r6 & 127);
    L9:
        if (r6 <= 127) goto L11;
        r6 = r6 >>> 7;
        r1 = r1 - 1;
        r0[r1] = (byte) ((r6 & 127) | 128);
        goto L9
    L11:
        int r2 = r1 - 1;
        r0[r2] = (byte) (31 | r5);
        write(r0, r2, 6 - r2);
    }

    public final void writeObject(ASN1Encodable r3) {
        ASN1Encodable r4 = (ASN1Encodable) ZeusTransformUtils.wrapperContextForParams(r3, ASN1Encodable.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        writePrimitive(r4.toASN1Primitive(), true);
        flushInternal();
        return;
    L7:
        throw new IOException("null object detected");
    }

    public final void writeObject(ASN1Primitive r2) {
        if (r2 == null) goto L6;
        writePrimitive(r2, true);
        flushInternal();
        return;
    L6:
        throw new IOException("null object detected");
    }

    void writePrimitive(ASN1Primitive r1, boolean r2) {
        r1.encode(this, r2);
    }

    void writePrimitives(ASN1Primitive[] r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5[r1].encode(this, true);
        r1 = r1 + 1;
        goto L3
    }
}
