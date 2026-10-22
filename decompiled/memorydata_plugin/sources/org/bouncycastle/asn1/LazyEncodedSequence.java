package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
class LazyEncodedSequence extends ASN1Sequence {
    private byte[] encoded;

    LazyEncodedSequence(byte[] r2) {
        Objects.requireNonNull(r2, "'encoded' cannot be null");
        this.encoded = r2;
    }

    private synchronized void force() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.encoded == null) goto L11;
        ASN1InputStream r0 = new ASN1InputStream(this.encoded, true);     // Catch: Throwable -> L13
        ASN1EncodableVector r1 = r0.readVector();     // Catch: IOException -> L8 Throwable -> L13
        r0.close();     // Catch: IOException -> L8 Throwable -> L13
        this.elements = r1.takeElements();     // Catch: IOException -> L8 Throwable -> L13
        this.encoded = null;     // Catch: IOException -> L8 Throwable -> L13
    L8:
        e = move-exception;
        throw new ASN1ParsingException("malformed ASN.1: " + e, e);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
    }

    private synchronized byte[] getContents() {
        monitor-enter(this);
        byte[] r0 = this.encoded;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    void encode(ASN1OutputStream r2, boolean r3) {
        byte[] r0 = getContents();
        if (r0 == null) goto L6;
        r2.writeEncodingDL(r3, 48, r0);
        return;
    L6:
        super.toDLObject().encode(r2, r3);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    int encodedLength(boolean r2) {
        byte[] r0 = getContents();
        if (r0 == null) goto L7;
        return ASN1OutputStream.getLengthOfEncodingDL(r2, r0.length);
    L7:
        return super.toDLObject().encodedLength(r2);
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence
    public ASN1Encodable getObjectAt(int r1) {
        force();
        return super.getObjectAt(r1);
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence
    public Enumeration getObjects() {
        byte[] r0 = getContents();
        if (r0 == null) goto L7;
        return new LazyConstructionEnumeration(r0);
    L7:
        return super.getObjects();
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence, org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        force();
        return super.hashCode();
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence, java.lang.Iterable
    public Iterator<ASN1Encodable> iterator() {
        force();
        return super.iterator();
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence
    public int size() {
        force();
        return super.size();
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence
    ASN1BitString toASN1BitString() {
        return ((ASN1Sequence) ZeusTransformUtils.preCheckCast(toDLObject(), ASN1Sequence.class, "com.obric.memorydata.plugin")).toASN1BitString();
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence
    ASN1External toASN1External() {
        return ((ASN1Sequence) ZeusTransformUtils.preCheckCast(toDLObject(), ASN1Sequence.class, "com.obric.memorydata.plugin")).toASN1External();
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence
    ASN1OctetString toASN1OctetString() {
        return ((ASN1Sequence) ZeusTransformUtils.preCheckCast(toDLObject(), ASN1Sequence.class, "com.obric.memorydata.plugin")).toASN1OctetString();
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence
    ASN1Set toASN1Set() {
        return ((ASN1Sequence) ZeusTransformUtils.preCheckCast(toDLObject(), ASN1Sequence.class, "com.obric.memorydata.plugin")).toASN1Set();
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence
    ASN1Encodable[] toArrayInternal() {
        force();
        return super.toArrayInternal();
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence, org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDERObject() {
        force();
        return super.toDERObject();
    }

    @Override // org.bouncycastle.asn1.ASN1Sequence, org.bouncycastle.asn1.ASN1Primitive
    ASN1Primitive toDLObject() {
        force();
        return super.toDLObject();
    }
}
