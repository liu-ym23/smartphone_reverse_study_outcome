package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

/* JADX INFO: loaded from: classes7.dex */
public class ASN1InputStream extends FilterInputStream {
    private final boolean lazyEvaluate;
    private final int limit;
    private final byte[][] tmpBuffers;

    public ASN1InputStream(InputStream r2) {
        this(r2, StreamUtil.findLimit(r2));
    }

    public ASN1InputStream(InputStream r2, int r3) {
        this(r2, r3, false);
    }

    public ASN1InputStream(InputStream r2, int r3, boolean r4) {
        this(r2, r3, r4, new byte[11][]);
    }

    private ASN1InputStream(InputStream r1, int r2, boolean r3, byte[][] r4) {
        super(r1);
        this.limit = r2;
        this.lazyEvaluate = r3;
        this.tmpBuffers = r4;
    }

    public ASN1InputStream(InputStream r2, boolean r3) {
        this(r2, StreamUtil.findLimit(r2), r3);
    }

    public ASN1InputStream(byte[] r2) {
        this(new ByteArrayInputStream(r2), r2.length);
    }

    public ASN1InputStream(byte[] r2, boolean r3) {
        this(new ByteArrayInputStream(r2), r2.length, r3);
    }

    static ASN1Primitive createPrimitiveDERObject(int r1, DefiniteLengthInputStream r2, byte[][] r3) {
        switch(r1) {
            case 1: goto L49;
            case 2: goto L47;
            case 3: goto L45;
            case 4: goto L43;
            case 5: goto L41;
            case 6: goto L39;
            case 7: goto L37;
            case 8: goto L5;
            case 9: goto L5;
            case 10: goto L35;
            case 11: goto L5;
            case 12: goto L33;
            case 13: goto L31;
            case 14: goto L5;
            case 15: goto L5;
            case 16: goto L5;
            case 17: goto L5;
            case 18: goto L29;
            case 19: goto L27;
            case 20: goto L25;
            case 21: goto L23;
            case 22: goto L21;
            case 23: goto L19;
            case 24: goto L17;
            case 25: goto L15;
            case 26: goto L13;
            case 27: goto L11;
            case 28: goto L9;
            case 29: goto L5;
            case 30: goto L7;
            default: goto L5;
        };
    L5:
        throw new IOException("unknown tag " + r1 + " encountered");
    L7:
        return ASN1BMPString.createPrimitive(getBMPCharBuffer(r2));
    L9:
        return ASN1UniversalString.createPrimitive(r2.toByteArray());
    L11:
        return ASN1GeneralString.createPrimitive(r2.toByteArray());
    L13:
        return ASN1VisibleString.createPrimitive(r2.toByteArray());
    L15:
        return ASN1GraphicString.createPrimitive(r2.toByteArray());
    L17:
        return ASN1GeneralizedTime.createPrimitive(r2.toByteArray());
    L19:
        return ASN1UTCTime.createPrimitive(r2.toByteArray());
    L21:
        return ASN1IA5String.createPrimitive(r2.toByteArray());
    L23:
        return ASN1VideotexString.createPrimitive(r2.toByteArray());
    L25:
        return ASN1T61String.createPrimitive(r2.toByteArray());
    L27:
        return ASN1PrintableString.createPrimitive(r2.toByteArray());
    L29:
        return ASN1NumericString.createPrimitive(r2.toByteArray());
    L31:
        return ASN1RelativeOID.createPrimitive(r2.toByteArray(), false);
    L33:
        return ASN1UTF8String.createPrimitive(r2.toByteArray());
    L35:
        return ASN1Enumerated.createPrimitive(getBuffer(r2, r3), true);
    L37:
        return ASN1ObjectDescriptor.createPrimitive(r2.toByteArray());
    L39:
        return ASN1ObjectIdentifier.createPrimitive(getBuffer(r2, r3), true);
    L41:
        return ASN1Null.createPrimitive(r2.toByteArray());
    L43:
        return ASN1OctetString.createPrimitive(r2.toByteArray());
    L45:
        return ASN1BitString.createPrimitive(r2.toByteArray());
    L47:
        return ASN1Integer.createPrimitive(r2.toByteArray());
    L49:
        return ASN1Boolean.createPrimitive(getBuffer(r2, r3));
    }

    private static char[] getBMPCharBuffer(DefiniteLengthInputStream r10) {
        int r0 = r10.getRemaining();
        if ((r0 & 1) != 0) goto L28;
        int r1 = r0 / 2;
        char[] r2 = new char[r1];
        byte[] r4 = new byte[8];
        int r5 = 0;
        int r6 = 0;
    L6:
        if (r0 < 8) goto L12;
        if (Streams.readFully(r10, r4, 0, 8) != 8) goto L11;
        r2[r6] = (char) ((r4[0] << 8) | (r4[1] & 255));
        r2[r6 + 1] = (char) ((r4[2] << 8) | (r4[3] & 255));
        r2[r6 + 2] = (char) ((r4[4] << 8) | (r4[5] & 255));
        r2[r6 + 3] = (char) ((r4[6] << 8) | (r4[7] & 255));
        r6 = r6 + 4;
        r0 = r0 - 8;
        goto L6
    L11:
        throw new EOFException("EOF encountered in middle of BMPString");
    L12:
        if (r0 <= 0) goto L22;
        if (Streams.readFully(r10, r4, 0, r0) != r0) goto L20;
    L15:
        int r7 = r5 + 1;
        int r8 = r7 + 1;
        int r9 = r6 + 1;
        r2[r6] = (char) ((r4[r5] << 8) | (r4[r7] & 255));
        if (r8 >= r0) goto L17;
        r5 = r8;
        r6 = r9;
        goto L15
    L17:
        r6 = r9;
        goto L22
    L20:
        throw new EOFException("EOF encountered in middle of BMPString");
    L22:
        if (r10.getRemaining() != 0) goto L26;
        if (r1 != r6) goto L26;
        return r2;
    L26:
        throw new IllegalStateException();
    L28:
        throw new IOException("malformed BMPString encoding encountered");
    }

    private static byte[] getBuffer(DefiniteLengthInputStream r2, byte[][] r3) {
        int r0 = r2.getRemaining();
        if (r0 >= r3.length) goto L5;
        byte[] r1 = r3[r0];
        if (r1 != null) goto L9;
        r1 = new byte[r0];
        r3[r0] = r1;
    L9:
        r2.readAllIntoByteArray(r1);
        return r1;
    L5:
        return r2.toByteArray();
    }

    static int readLength(InputStream r5, int r6, boolean r7) {
        int r0 = r5.read();
        if ((r0 >>> 7) != 0) goto L6;
        return r0;
    L6:
        if (128 != r0) goto L9;
        return -1;
    L9:
        if (r0 < 0) goto L32;
        if (255 == r0) goto L30;
        int r1 = r0 & 127;
        int r2 = 0;
        int r3 = 0;
    L13:
        int r4 = r5.read();
        if (r4 < 0) goto L28;
        if ((r2 >>> 23) != 0) goto L26;
        r2 = (r2 << 8) + r4;
        r3 = r3 + 1;
        if (r3 < r1) goto L13;
        if (r2 < r6) goto L24;
        if (r7 == true) goto L24;
        throw new IOException("corrupted stream - out of bounds length found: " + r2 + " >= " + r6);
    L24:
        return r2;
    L26:
        throw new IOException("long form definite-length more than 31 bits");
    L28:
        throw new EOFException("EOF found reading length");
    L30:
        throw new IOException("invalid long form definite-length 0xFF");
    L32:
        throw new EOFException("EOF found when length expected");
    }

    static int readTagNumber(InputStream r4, int r5) {
        int r6 = r5 & 31;
        if (r6 != 31) goto L27;
        int r7 = r4.read();
        if (r7 >= 31) goto L11;
        if (r7 >= 0) goto L10;
        throw new EOFException("EOF found inside tag value.");
    L10:
        throw new IOException("corrupted stream - high tag number < 31 found");
    L11:
        int r0 = r7 & 127;
        if (r0 == 0) goto L26;
    L14:
        if ((r7 & 128) == 0) goto L31;
        if ((r0 >>> 24) != 0) goto L23;
        int r8 = r0 << 7;
        int r1 = r4.read();
        if (r1 < 0) goto L21;
        r0 = r8 | (r1 & 127);
        r7 = r1;
        goto L14
    L21:
        throw new EOFException("EOF found inside tag value.");
    L23:
        throw new IOException("Tag number more than 31 bits");
    L31:
        return r0;
    L26:
        throw new IOException("corrupted stream - invalid high tag number found");
    L27:
        return r6;
    }

    ASN1BitString buildConstructedBitString(ASN1EncodableVector r6) {
        int r5 = r6.size();
        ASN1BitString[] r0 = new ASN1BitString[r5];
        int r1 = 0;
    L3:
        if (r1 == r5) goto L10;
        ASN1Encodable r2 = r6.get(r1);
        if (ZeusTransformUtils.instanceOf(r2, ASN1BitString.class) == false) goto L8;
        r0[r1] = (ASN1BitString) ZeusTransformUtils.preCheckCast(r2, ASN1BitString.class, "com.obric.memorydata.plugin");
        r1 = r1 + 1;
        goto L3
    L8:
        throw new ASN1Exception("unknown object encountered in constructed BIT STRING: " + r2.getClass());
    L10:
        return new BERBitString(r0);
    }

    ASN1OctetString buildConstructedOctetString(ASN1EncodableVector r6) {
        int r5 = r6.size();
        ASN1OctetString[] r0 = new ASN1OctetString[r5];
        int r1 = 0;
    L3:
        if (r1 == r5) goto L10;
        ASN1Encodable r2 = r6.get(r1);
        if (ZeusTransformUtils.instanceOf(r2, ASN1OctetString.class) == false) goto L8;
        r0[r1] = (ASN1OctetString) ZeusTransformUtils.preCheckCast(r2, ASN1OctetString.class, "com.obric.memorydata.plugin");
        r1 = r1 + 1;
        goto L3
    L8:
        throw new ASN1Exception("unknown object encountered in constructed OCTET STRING: " + r2.getClass());
    L10:
        return new BEROctetString(r0);
    }

    public ASN1Primitive buildObject(int r3, int r4, int r5) {
        DefiniteLengthInputStream r0 = new DefiniteLengthInputStream(this, r5, this.limit);
        if ((r3 & 224) == 0) goto L5;
        int r6 = r3 & 192;
        boolean r1 = true;
        if (r6 == 0) goto L15;
        if ((r3 & 32) != 0) goto L13;
        r1 = false;
    L13:
        return readTaggedObjectDL(r6, r4, r1, r0);
    L15:
        if (r4 == 3) goto L43;
        if (r4 == 4) goto L41;
        if (r4 == 8) goto L39;
        if (r4 == 16) goto L29;
        if (r4 != 17) goto L27;
        return DLFactory.createSet(readVector(r0));
    L27:
        throw new IOException("unknown tag " + r4 + " encountered");
    L29:
        if (r0.getRemaining() >= 1) goto L33;
        return DLFactory.EMPTY_SEQUENCE;
    L33:
        if (this.lazyEvaluate == false) goto L37;
        return new LazyEncodedSequence(r0.toByteArray());
    L37:
        return DLFactory.createSequence(readVector(r0));
    L39:
        return DLFactory.createSequence(readVector(r0)).toASN1External();
    L41:
        return buildConstructedOctetString(readVector(r0));
    L43:
        return buildConstructedBitString(readVector(r0));
    L5:
        return createPrimitiveDERObject(r4, r0, this.tmpBuffers);
    }

    int getLimit() {
        return this.limit;
    }

    public int readLength() {
        return readLength(this, this.limit, false);
    }

    public ASN1Primitive readObject() {
        int r0 = read();
        if (r0 > 0) goto L9;
        if (r0 == 0) goto L8;
        return null;
    L8:
        throw new IOException("unexpected end-of-contents marker");
    L9:
        int r1 = readTagNumber(this, r0);
        int r2 = readLength();
        if (r2 < 0) goto L17;
        return buildObject(r0, r1, r2);
    L13:
        e = move-exception;
        throw new ASN1Exception("corrupted stream detected", e);
    L17:
        if ((r0 & 32) == 0) goto L45;
        ASN1StreamParser r3 = new ASN1StreamParser(new IndefiniteLengthInputStream(this, this.limit), this.limit, this.tmpBuffers);
        int r5 = r0 & 192;
        if (r5 == 0) goto L23;
        return r3.loadTaggedIL(r5, r1);
    L23:
        if (r1 == 3) goto L43;
        if (r1 == 4) goto L41;
        if (r1 == 8) goto L39;
        if (r1 == 16) goto L37;
        if (r1 != 17) goto L35;
        return BERSetParser.parse(r3);
    L35:
        throw new IOException("unknown BER object encountered");
    L37:
        return BERSequenceParser.parse(r3);
    L39:
        return DERExternalParser.parse(r3);
    L41:
        return BEROctetStringParser.parse(r3);
    L43:
        return BERBitStringParser.parse(r3);
    L45:
        throw new IOException("indefinite-length primitive encoding encountered");
    }

    ASN1Primitive readTaggedObjectDL(int r1, int r2, boolean r3, DefiniteLengthInputStream r4) {
        if (r3 == true) goto L6;
        return ASN1TaggedObject.createPrimitive(r1, r2, r4.toByteArray());
    L6:
        return ASN1TaggedObject.createConstructedDL(r1, r2, readVector(r4));
    }

    ASN1EncodableVector readVector() {
        ASN1Primitive r0 = readObject();
        if (r0 == null) goto L5;
        ASN1EncodableVector r1 = new ASN1EncodableVector();
    L7:
        r1.add(r0);
        r0 = readObject();
        if (r0 != null) goto L7;
        return r1;
    L5:
        return new ASN1EncodableVector(0);
    }

    ASN1EncodableVector readVector(DefiniteLengthInputStream r4) {
        int r0 = r4.getRemaining();
        if (r0 >= 1) goto L7;
        return new ASN1EncodableVector(0);
    L7:
        return new ASN1InputStream(r4, r0, this.lazyEvaluate, this.tmpBuffers).readVector();
    }
}
