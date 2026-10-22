package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes7.dex */
public class ASN1StreamParser {
    private final InputStream _in;
    private final int _limit;
    private final byte[][] tmpBuffers;

    ASN1StreamParser(InputStream r1, int r2, byte[][] r3) {
        this._in = r1;
        this._limit = r2;
        this.tmpBuffers = r3;
    }

    private void set00Check(boolean r3) {
        if (ZeusTransformUtils.instanceOf(this._in, IndefiniteLengthInputStream.class) == false) goto L6;
        ((IndefiniteLengthInputStream) ZeusTransformUtils.preCheckCast(this._in, IndefiniteLengthInputStream.class, "com.obric.memorydata.plugin")).setEofOn00(r3);
        return;
    }

    ASN1Encodable implParseObject(int r9) {
        boolean r0 = false;
        set00Check(false);
        int r1 = ASN1InputStream.readTagNumber(this._in, r9);
        InputStream r2 = this._in;
        int r3 = this._limit;
        if (r1 != 3) goto L5;
    L14:
        boolean r5 = true;
    L15:
        int r4 = ASN1InputStream.readLength(r2, r3, r5);
        if (r4 < 0) goto L18;
        DefiniteLengthInputStream r6 = new DefiniteLengthInputStream(this._in, r4, this._limit);
        if ((r9 & 224) == 0) goto L33;
        ASN1StreamParser r7 = new ASN1StreamParser(r6, r6.getLimit(), this.tmpBuffers);
        int r8 = r9 & 192;
        if (r8 == 0) goto L45;
        if ((r9 & 32) == 0) goto L39;
        r0 = true;
    L39:
        if (64 != r8) goto L43;
        return (DLApplicationSpecific) ZeusTransformUtils.preCheckCast(r7.loadTaggedDL(r8, r1, r0), DLApplicationSpecific.class, "com.obric.memorydata.plugin");
    L43:
        return new DLTaggedObjectParser(r8, r1, r0, r7);
    L45:
        return r7.parseImplicitConstructedDL(r1);
    L33:
        return parseImplicitPrimitive(r1, r6);
    L18:
        if ((r9 & 32) == 0) goto L29;
        ASN1StreamParser r10 = new ASN1StreamParser(new IndefiniteLengthInputStream(this._in, this._limit), this._limit, this.tmpBuffers);
        int r11 = r9 & 192;
        if (r11 == 0) goto L27;
        if (64 != r11) goto L25;
        return new BERApplicationSpecificParser(r1, r10);
    L25:
        return new BERTaggedObjectParser(r11, r1, r10);
    L27:
        return r10.parseImplicitConstructedIL(r1);
    L29:
        throw new IOException("indefinite-length primitive encoding encountered");
    L5:
        if (r1 == 4) goto L14;
        if (r1 == 16) goto L14;
        if (r1 == 17) goto L14;
        if (r1 == 8) goto L14;
        r5 = false;
        goto L15
    }

    ASN1Primitive loadTaggedDL(int r2, int r3, boolean r4) {
        if (r4 == true) goto L6;
        return ASN1TaggedObject.createPrimitive(r2, r3, ((DefiniteLengthInputStream) ZeusTransformUtils.preCheckCast(this._in, DefiniteLengthInputStream.class, "com.obric.memorydata.plugin")).toByteArray());
    L6:
        return ASN1TaggedObject.createConstructedDL(r2, r3, readVector());
    }

    ASN1Primitive loadTaggedIL(int r1, int r2) {
        return ASN1TaggedObject.createConstructedIL(r1, r2, readVector());
    }

    ASN1Encodable parseImplicitConstructedDL(int r3) {
        if (r3 == 3) goto L23;
        if (r3 == 4) goto L21;
        if (r3 == 8) goto L19;
        if (r3 == 16) goto L17;
        if (r3 != 17) goto L15;
        return new DLSetParser(this);
    L15:
        throw new ASN1Exception("unknown DL object encountered: 0x" + Integer.toHexString(r3));
    L17:
        return new DLSequenceParser(this);
    L19:
        return new DERExternalParser(this);
    L21:
        return new BEROctetStringParser(this);
    L23:
        return new BERBitStringParser(this);
    }

    ASN1Encodable parseImplicitConstructedIL(int r3) {
        if (r3 == 3) goto L23;
        if (r3 == 4) goto L21;
        if (r3 == 8) goto L19;
        if (r3 == 16) goto L17;
        if (r3 != 17) goto L15;
        return new BERSetParser(this);
    L15:
        throw new ASN1Exception("unknown BER object encountered: 0x" + Integer.toHexString(r3));
    L17:
        return new BERSequenceParser(this);
    L19:
        return new DERExternalParser(this);
    L21:
        return new BEROctetStringParser(this);
    L23:
        return new BERBitStringParser(this);
    }

    ASN1Encodable parseImplicitPrimitive(int r2, DefiniteLengthInputStream r3) {
        if (r2 == 3) goto L26;
        if (r2 == 4) goto L24;
        if (r2 == 8) goto L22;
        if (r2 == 16) goto L20;
        if (r2 == 17) goto L18;
        return ASN1InputStream.createPrimitiveDERObject(r2, r3, this.tmpBuffers);
    L14:
        e = move-exception;
        throw new ASN1Exception("corrupted stream detected", e);
    L18:
        throw new ASN1Exception("sequences must use constructed encoding (see X.690 8.9.1/8.10.1)");
    L20:
        throw new ASN1Exception("sets must use constructed encoding (see X.690 8.11.1/8.12.1)");
    L22:
        throw new ASN1Exception("externals must use constructed encoding (see X.690 8.18)");
    L24:
        return new DEROctetStringParser(r3);
    L26:
        return new DLBitStringParser(r3);
    }

    public ASN1Encodable readObject() {
        int r0 = this._in.read();
        if (r0 >= 0) goto L7;
        return null;
    L7:
        return implParseObject(r0);
    }

    ASN1EncodableVector readVector() {
        int r0 = this._in.read();
        if (r0 < 0) goto L5;
        ASN1EncodableVector r1 = new ASN1EncodableVector();
    L7:
        ASN1Encodable r2 = implParseObject(r0);
        if (ZeusTransformUtils.instanceOf(r2, InMemoryRepresentable.class) == false) goto L10;
        ASN1Primitive r3 = ((InMemoryRepresentable) ZeusTransformUtils.preCheckCast(r2, InMemoryRepresentable.class, "com.obric.memorydata.plugin")).getLoadedObject();
    L11:
        r1.add(r3);
        r0 = this._in.read();
        if (r0 >= 0) goto L7;
        return r1;
    L10:
        r3 = r2.toASN1Primitive();
        goto L11
    L5:
        return new ASN1EncodableVector(0);
    }
}
