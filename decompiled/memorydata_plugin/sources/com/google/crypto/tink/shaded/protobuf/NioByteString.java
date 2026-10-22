package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class NioByteString extends ByteString.LeafByteString {
    private final ByteBuffer buffer;

    NioByteString(ByteBuffer r2) {
        ab.a(r2, "buffer");
        this.buffer = r2.slice().order(ByteOrder.nativeOrder());
    }

    static /* synthetic */ ByteBuffer access$000(NioByteString r0) {
        return r0.buffer;
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    private ByteBuffer slice(int r3, int r4) {
        if (r3 < this.buffer.position()) goto L10;
        if (r4 > this.buffer.limit()) goto L10;
        if (r3 > r4) goto L10;
        ByteBuffer r0 = this.buffer.slice();
        ad.b(r0, r3 - this.buffer.position());
        ad.a(r0, r4 - this.buffer.position());
        return r0;
    L10:
        throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", new Object[]{Integer.valueOf(r3), Integer.valueOf(r4)}));
    }

    private Object writeReplace() {
        return ByteString.copyFrom(this.buffer.slice());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        return Collections.singletonList(asReadOnlyByteBuffer());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public byte byteAt(int r1) {
        return this.buffer.get(r1);
    L7:
        e = move-exception;
        throw e;
    L4:
        e = move-exception;
        throw new ArrayIndexOutOfBoundsException(e.getMessage());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public void copyTo(ByteBuffer r1) {
        r1.put(this.buffer.slice());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public void copyToInternal(byte[] r1, int r2, int r3, int r4) {
        ByteBuffer r0 = this.buffer.slice();
        ad.b(r0, r2);
        r0.get(r1, r3, r4);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r8, ByteString.class) == true) goto L8;
        return false;
    L8:
        ByteString r2 = (ByteString) ZeusTransformUtils.preCheckCast(r8, ByteString.class, "com.obric.memorydata.plugin");
        if (size() == r2.size()) goto L12;
        return false;
    L12:
        if (size() != 0) goto L15;
        return true;
    L15:
        if (ZeusTransformUtils.instanceOf(r8, NioByteString.class) == false) goto L20;
        ByteBuffer r7 = this.buffer;
        ByteBuffer r9 = ((NioByteString) ZeusTransformUtils.preCheckCast(r8, NioByteString.class, "com.obric.memorydata.plugin")).buffer;
    L18:
        return r7.equals(r9);
    L20:
        if (ZeusTransformUtils.instanceOf(r8, RopeByteString.class) == true) goto L22;
        r7 = this.buffer;
        r9 = r2.asReadOnlyByteBuffer();
        goto L18
    L22:
        return r8.equals(this);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LeafByteString
    boolean equalsRange(ByteString r2, int r3, int r4) {
        return substring(0, r4).equals(r2.substring(r3, r4 + r3));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public byte internalByteAt(int r1) {
        return byteAt(r1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public boolean isValidUtf8() {
        return Utf8.a(this.buffer);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public k newCodedInput() {
        return k.a(this.buffer, true);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public InputStream newInput() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public int partialHash(int r3, int r4, int r5) {
        int r0 = r4;
    L4:
        if (r0 >= (r4 + r5)) goto L6;
        r3 = (r3 * 31) + this.buffer.get(r0);
        r0 = r0 + 1;
        goto L4
    L6:
        return r3;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public int partialIsValidUtf8(int r1, int r2, int r3) {
        return Utf8.a(r1, this.buffer, r2, r3 + r2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public int size() {
        return this.buffer.remaining();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public ByteString substring(int r1, int r2) {
        return new NioByteString(slice(r1, r2));
    L7:
        e = move-exception;
        throw e;
    L4:
        e = move-exception;
        throw new ArrayIndexOutOfBoundsException(e.getMessage());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public String toStringInternal(Charset r4) {
        if (this.buffer.hasArray() == false) goto L5;
        byte[] r0 = this.buffer.array();
        int r1 = this.buffer.arrayOffset() + this.buffer.position();
        int r3 = this.buffer.remaining();
    L7:
        return new String(r0, r1, r3, r4);
    L5:
        r0 = toByteArray();
        r1 = 0;
        r3 = r0.length;
        goto L7
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    void writeTo(j r1) {
        r1.a(this.buffer.slice());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    public void writeTo(OutputStream r1) {
        r1.write(toByteArray());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString
    void writeToInternal(OutputStream r3, int r4, int r5) {
        if (this.buffer.hasArray() == false) goto L6;
        int r0 = (this.buffer.arrayOffset() + this.buffer.position()) + r4;
        r3.write(this.buffer.array(), r0, r5);
        return;
    L6:
        i.a(slice(r4, r5 + r4), r3);
    }
}
