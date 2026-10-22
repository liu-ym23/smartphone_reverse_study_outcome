package com.squareup.wire;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class ProtoReader {
    private static final int FIELD_ENCODING_MASK = 7;
    private static final int RECURSION_LIMIT = 65;
    private static final int STATE_END_GROUP = 4;
    private static final int STATE_FIXED32 = 5;
    private static final int STATE_FIXED64 = 1;
    private static final int STATE_LENGTH_DELIMITED = 2;
    private static final int STATE_PACKED_TAG = 7;
    private static final int STATE_START_GROUP = 3;
    private static final int STATE_TAG = 6;
    private static final int STATE_VARINT = 0;
    static final int TAG_FIELD_ENCODING_BITS = 3;
    private long limit;
    private FieldEncoding nextFieldEncoding;
    private long pos;
    private long pushedLimit;
    private int recursionDepth;
    private final BufferedSource source;
    private int state;
    private int tag;

    public ProtoReader(BufferedSource r3) {
        BufferedSource r4 = (BufferedSource) ZeusTransformUtils.wrapperContextForParams(r3, BufferedSource.class, "com.obric.memorydata.plugin");
        this.pos = 0;
        this.limit = Long.MAX_VALUE;
        this.state = 2;
        this.tag = -1;
        this.pushedLimit = -1;
        this.source = r4;
    }

    private void afterPackableScalar(int r7) {
        if (this.state != r7) goto L5;
    L4:
        this.state = 6;
        return;
    L5:
        long r2 = this.pos;
        long r4 = this.limit;
        if (r2 > r4) goto L13;
        if (r2 != r4) goto L10;
        this.limit = this.pushedLimit;
        this.pushedLimit = -1;
        goto L4
    L10:
        this.state = 7;
        return;
    L13:
        throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
    }

    private long beforeLengthDelimitedScalar() {
        if (this.state != 2) goto L7;
        long r0 = this.limit - this.pos;
        this.source.require(r0);
        this.state = 6;
        this.pos = this.limit;
        this.limit = this.pushedLimit;
        this.pushedLimit = -1;
        return r0;
    L7:
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.state);
    }

    private void copyTag(ProtoWriter r2, int r3) {
        ProtoAdapter<?> r0 = peekFieldEncoding().rawProtoAdapter();
        r0.encodeWithTag(r2, r3, r0.decode(this));     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new AssertionError(e);
    }

    private int internalReadVarint32() {
        this.source.require(1);
        this.pos++;
        byte r0 = this.source.readByte();
        if (r0 < 0) goto L5;
        return r0;
    L5:
        int r1 = r0 & ByteCompanionObject.MAX_VALUE;
        this.source.require(1);
        this.pos++;
        byte r3 = this.source.readByte();
        if (r3 < 0) goto L9;
        int r6 = r3 << 7;
    L30:
        return r6 | r1;
    L9:
        r1 = r1 | ((r3 & ByteCompanionObject.MAX_VALUE) << 7);
        this.source.require(1);
        this.pos++;
        byte r4 = this.source.readByte();
        if (r4 < 0) goto L12;
        r6 = r4 << 14;
        goto L30
    L12:
        r1 = r1 | ((r4 & ByteCompanionObject.MAX_VALUE) << 14);
        this.source.require(1);
        this.pos++;
        byte r5 = this.source.readByte();
        if (r5 < 0) goto L15;
        r6 = r5 << 21;
        goto L30
    L15:
        int r2 = r1 | ((r5 & ByteCompanionObject.MAX_VALUE) << 21);
        this.source.require(1);
        this.pos++;
        byte r7 = this.source.readByte();
        int r8 = r2 | (r7 << 28);
        if (r7 >= 0) goto L27;
        int r9 = 0;
    L19:
        if (r9 >= 5) goto L25;
        this.source.require(1);
        this.pos++;
        if (this.source.readByte() >= 0) goto L22;
        r9 = r9 + 1;
        goto L19
    L22:
        return r8;
    L25:
        throw new ProtocolException("Malformed VARINT");
    L27:
        return r8;
    }

    private void skipGroup(int r6) {
    L3:
        if (this.pos >= this.limit) goto L34;
        if (this.source.exhausted() == true) goto L34;
        int r0 = internalReadVarint32();
        if (r0 == 0) goto L32;
        int r1 = r0 >> 3;
        int r2 = r0 & 7;
        if (r2 != 0) goto L11;
        this.state = 0;
        readVarint64();
        goto L3
    L11:
        if (r2 != 1) goto L13;
        this.state = 1;
        readFixed64();
        goto L3
    L13:
        if (r2 != 2) goto L15;
        long r3 = internalReadVarint32();
        this.pos += r3;
        this.source.skip(r3);
        goto L3
    L15:
        if (r2 != 3) goto L17;
        skipGroup(r1);
        goto L3
    L17:
        if (r2 == 4) goto L23;
        if (r2 != 5) goto L22;
        this.state = 5;
        readFixed32();
        goto L3
    L22:
        throw new ProtocolException("Unexpected field encoding: " + r2);
    L23:
        if (r1 != r6) goto L26;
        return;
    L26:
        throw new ProtocolException("Unexpected end group");
    L32:
        throw new ProtocolException("Unexpected tag 0");
    L34:
        throw new EOFException();
    }

    public long beginMessage() {
        if (this.state != 2) goto L11;
        int r0 = this.recursionDepth + 1;
        this.recursionDepth = r0;
        if (r0 > 65) goto L9;
        long r1 = this.pushedLimit;
        this.pushedLimit = -1;
        this.state = 6;
        return r1;
    L9:
        throw new IOException("Wire recursion limit exceeded");
    L11:
        throw new IllegalStateException("Unexpected call to beginMessage()");
    }

    public void endMessage(long r6) {
        if (this.state != 6) goto L19;
        int r0 = this.recursionDepth - 1;
        this.recursionDepth = r0;
        if (r0 < 0) goto L17;
        if (this.pushedLimit != (-1)) goto L17;
        if (this.pos == this.limit) goto L14;
        if (r0 == 0) goto L14;
        throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
    L14:
        this.limit = r6;
        return;
    L17:
        throw new IllegalStateException("No corresponding call to beginMessage()");
    L19:
        throw new IllegalStateException("Unexpected call to endMessage()");
    }

    public ByteString forEachTag(TagHandler r8) {
        TagHandler r9 = (TagHandler) ZeusTransformUtils.wrapperContextForParams(r8, TagHandler.class, "com.obric.memorydata.plugin");
        long r0 = beginMessage();
        Buffer r2 = null;
        ProtoWriter r3 = null;
    L3:
        int r4 = nextTag();
        if (r4 == (-1)) goto L11;
        if (r9.decodeMessage(r4) != TagHandler.UNKNOWN_TAG) goto L3;
        if (r2 != null) goto L10;
        r2 = new Buffer();
        r3 = new ProtoWriter(r2);
    L10:
        copyTag(r3, r4);
        goto L3
    L11:
        endMessage(r0);
        if (r2 == null) goto L15;
        return r2.readByteString();
    L15:
        return ByteString.EMPTY;
    }

    public int nextTag() {
        int r0 = this.state;
        if (r0 != 7) goto L8;
        this.state = 2;
    L6:
        return this.tag;
    L8:
        if (r0 != 6) goto L53;
    L10:
        if (this.pos >= this.limit) goto L50;
        if (this.source.exhausted() == true) goto L61;
        int r1 = internalReadVarint32();
        if (r1 == 0) goto L49;
        int r2 = r1 >> 3;
        this.tag = r2;
        int r3 = r1 & 7;
        if (r3 == 0) goto L47;
        if (r3 == 1) goto L46;
        if (r3 == 2) goto L32;
        if (r3 != 3) goto L23;
        skipGroup(r2);
        goto L10
    L23:
        if (r3 == 4) goto L30;
        if (r3 != 5) goto L28;
        this.nextFieldEncoding = FieldEncoding.FIXED32;
        this.state = 5;
        goto L6
    L28:
        throw new ProtocolException("Unexpected field encoding: " + r3);
    L30:
        throw new ProtocolException("Unexpected end group");
    L32:
        this.nextFieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        this.state = 2;
        int r4 = internalReadVarint32();
        if (r4 < 0) goto L45;
        if (this.pushedLimit != (-1)) goto L43;
        long r5 = this.limit;
        this.pushedLimit = r5;
        long r6 = this.pos + ((long) r4);
        this.limit = r6;
        if (r6 > r5) goto L41;
        return this.tag;
    L41:
        throw new EOFException();
    L43:
        throw new IllegalStateException();
    L45:
        throw new ProtocolException("Negative length: " + r4);
    L46:
        this.nextFieldEncoding = FieldEncoding.FIXED64;
        this.state = 1;
        goto L6
    L47:
        this.nextFieldEncoding = FieldEncoding.VARINT;
        this.state = 0;
        goto L6
    L49:
        throw new ProtocolException("Unexpected tag 0");
    L61:
        return -1;
    L50:
        return -1;
    L53:
        throw new IllegalStateException("Unexpected call to nextTag()");
    }

    public FieldEncoding peekFieldEncoding() {
        return this.nextFieldEncoding;
    }

    public ByteString readBytes() {
        long r0 = beforeLengthDelimitedScalar();
        this.source.require(r0);
        return this.source.readByteString(r0);
    }

    public int readFixed32() {
        int r0 = this.state;
        if (r0 != 5) goto L5;
    L9:
        this.source.require(4);
        this.pos += 4;
        int r1 = this.source.readIntLe();
        afterPackableScalar(5);
        return r1;
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.state);
    }

    public long readFixed64() {
        int r0 = this.state;
        if (r0 != 1) goto L5;
    L9:
        this.source.require(8);
        this.pos += 8;
        long r2 = this.source.readLongLe();
        afterPackableScalar(1);
        return r2;
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.state);
    }

    public String readString() {
        long r0 = beforeLengthDelimitedScalar();
        this.source.require(r0);
        return this.source.readUtf8(r0);
    }

    public int readVarint32() {
        int r0 = this.state;
        if (r0 != 0) goto L5;
    L9:
        int r1 = internalReadVarint32();
        afterPackableScalar(0);
        return r1;
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
    }

    public long readVarint64() {
        int r0 = this.state;
        if (r0 != 0) goto L5;
    L9:
        long r1 = 0;
        int r3 = 0;
    L11:
        if (r3 >= 64) goto L18;
        this.source.require(1);
        this.pos++;
        byte r4 = this.source.readByte();
        r1 = r1 | (((long) (r4 & ByteCompanionObject.MAX_VALUE)) << r3);
        if ((r4 & 128) == 0) goto L14;
        r3 = r3 + 7;
        goto L11
    L14:
        afterPackableScalar(0);
        return r1;
    L18:
        throw new ProtocolException("WireInput encountered a malformed varint");
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
    }

    public void skip() {
        int r0 = this.state;
        if (r0 != 0) goto L5;
        readVarint64();
        return;
    L5:
        if (r0 != 1) goto L7;
        readFixed64();
        return;
    L7:
        if (r0 != 2) goto L9;
        long r1 = beforeLengthDelimitedScalar();
        this.source.skip(r1);
        return;
    L9:
        if (r0 != 5) goto L12;
        readFixed32();
        return;
    L12:
        throw new IllegalStateException("Unexpected call to skip()");
    }
}
