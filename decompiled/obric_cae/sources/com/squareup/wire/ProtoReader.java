package com.squareup.wire;

import com.sdk.bwdl.StateMachine.BWDLCommandBuilder;
import defpackage.a;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import jf.f;
import jf.g;

/* JADX INFO: loaded from: classes2.dex */
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
    private final f source;
    private int state;
    private int tag;

    public ProtoReader(f r8) {
        this.pos = 0;
        this.limit = Long.MAX_VALUE;
        this.state = 2;
        this.tag = -1;
        this.pushedLimit = -1;
        this.source = r8;
    }

    private void afterPackableScalar(int r8) {
        if (this.state != r8) goto L5;
    L4:
        this.state = 6;
        return;
    L5:
        long r10 = this.pos;
        long r11 = this.limit;
        if (r10 > r11) goto L13;
        if (r10 != r11) goto L10;
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
        long r8 = this.limit - this.pos;
        this.source.L(r8);
        this.state = 6;
        this.pos = this.limit;
        this.limit = this.pushedLimit;
        this.pushedLimit = -1;
        return r8;
    L7:
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.state);
    }

    private int internalReadVarint32() {
        this.source.L(1);
        this.pos++;
        byte r8 = this.source.readByte();
        if (r8 < 0) goto L5;
        return r8;
    L5:
        int r10 = r8 & 127;
        this.source.L(1);
        this.pos++;
        byte r11 = this.source.readByte();
        if (r11 < 0) goto L9;
        int r12 = r11 << 7;
    L30:
        return r12 | r10;
    L9:
        r10 = r10 | ((r11 & 127) << 7);
        this.source.L(1);
        this.pos++;
        byte r13 = this.source.readByte();
        if (r13 < 0) goto L12;
        r12 = r13 << 14;
        goto L30
    L12:
        r10 = r10 | ((r13 & 127) << 14);
        this.source.L(1);
        this.pos++;
        byte r14 = this.source.readByte();
        if (r14 < 0) goto L15;
        r12 = r14 << BWDLCommandBuilder.CHANNEL_CONFIG_REQ;
        goto L30
    L15:
        int r15 = r10 | ((r14 & 127) << 21);
        this.source.L(1);
        this.pos++;
        byte r16 = this.source.readByte();
        int r17 = r15 | (r16 << 28);
        if (r16 >= 0) goto L27;
        int r18 = 0;
    L19:
        if (r18 >= 5) goto L25;
        this.source.L(1);
        this.pos++;
        if (this.source.readByte() >= 0) goto L22;
        r18 = r18 + 1;
        goto L19
    L22:
        return r17;
    L25:
        throw new ProtocolException("Malformed VARINT");
    L27:
        return r17;
    }

    private void skipGroup(int r8) {
    L3:
        if (this.pos >= this.limit) goto L34;
        if (this.source.U() == true) goto L34;
        int r10 = internalReadVarint32();
        if (r10 == 0) goto L32;
        int r11 = r10 >> 3;
        int r12 = r10 & 7;
        if (r12 != 0) goto L11;
        this.state = 0;
        readVarint64();
        goto L3
    L11:
        if (r12 != 1) goto L13;
        this.state = 1;
        readFixed64();
        goto L3
    L13:
        if (r12 != 2) goto L15;
        long r13 = internalReadVarint32();
        this.pos += r13;
        this.source.skip(r13);
        goto L3
    L15:
        if (r12 != 3) goto L17;
        skipGroup(r11);
        goto L3
    L17:
        if (r12 == 4) goto L23;
        if (r12 != 5) goto L22;
        this.state = 5;
        readFixed32();
        goto L3
    L22:
        throw new ProtocolException(a.d("Unexpected field encoding: ", r12));
    L23:
        if (r11 != r8) goto L26;
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
        int r8 = this.recursionDepth + 1;
        this.recursionDepth = r8;
        if (r8 > 65) goto L9;
        long r10 = this.pushedLimit;
        this.pushedLimit = -1;
        this.state = 6;
        return r10;
    L9:
        throw new IOException("Wire recursion limit exceeded");
    L11:
        throw new IllegalStateException("Unexpected call to beginMessage()");
    }

    public void endMessage(long r8) {
        if (this.state != 6) goto L19;
        int r10 = this.recursionDepth - 1;
        this.recursionDepth = r10;
        if (r10 < 0) goto L17;
        if (this.pushedLimit != (-1)) goto L17;
        if (this.pos == this.limit) goto L14;
        if (r10 == 0) goto L14;
        throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
    L14:
        this.limit = r8;
        return;
    L17:
        throw new IllegalStateException("No corresponding call to beginMessage()");
    L19:
        throw new IllegalStateException("Unexpected call to endMessage()");
    }

    public int nextTag() {
        int r8 = this.state;
        if (r8 != 7) goto L7;
        this.state = 2;
        return this.tag;
    L7:
        if (r8 != 6) goto L55;
    L9:
        if (this.pos >= this.limit) goto L52;
        if (this.source.U() == true) goto L63;
        int r10 = internalReadVarint32();
        if (r10 == 0) goto L51;
        int r11 = r10 >> 3;
        this.tag = r11;
        int r12 = r10 & 7;
        if (r12 == 0) goto L48;
        if (r12 == 1) goto L46;
        if (r12 == 2) goto L32;
        if (r12 != 3) goto L22;
        skipGroup(r11);
        goto L9
    L22:
        if (r12 == 4) goto L30;
        if (r12 != 5) goto L28;
        this.nextFieldEncoding = FieldEncoding.FIXED32;
        this.state = 5;
        return r11;
    L28:
        throw new ProtocolException(a.d("Unexpected field encoding: ", r12));
    L30:
        throw new ProtocolException("Unexpected end group");
    L32:
        this.nextFieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        this.state = 2;
        int r13 = internalReadVarint32();
        if (r13 < 0) goto L45;
        if (this.pushedLimit != (-1)) goto L43;
        long r14 = this.limit;
        this.pushedLimit = r14;
        long r15 = this.pos + ((long) r13);
        this.limit = r15;
        if (r15 > r14) goto L41;
        return this.tag;
    L41:
        throw new EOFException();
    L43:
        throw new IllegalStateException();
    L45:
        throw new ProtocolException(a.d("Negative length: ", r13));
    L46:
        this.nextFieldEncoding = FieldEncoding.FIXED64;
        this.state = 1;
        return r11;
    L48:
        this.nextFieldEncoding = FieldEncoding.VARINT;
        this.state = 0;
        return r11;
    L51:
        throw new ProtocolException("Unexpected tag 0");
    L63:
        return -1;
    L52:
        return -1;
    L55:
        throw new IllegalStateException("Unexpected call to nextTag()");
    }

    public FieldEncoding peekFieldEncoding() {
        return this.nextFieldEncoding;
    }

    public g readBytes() {
        long r8 = beforeLengthDelimitedScalar();
        this.source.L(r8);
        return this.source.Q(r8);
    }

    public int readFixed32() {
        int r8 = this.state;
        if (r8 != 5) goto L5;
    L9:
        this.source.L(4);
        this.pos += 4;
        int r10 = this.source.i0();
        afterPackableScalar(5);
        return r10;
    L5:
        if (r8 == 2) goto L9;
        throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.state);
    }

    public long readFixed64() {
        int r8 = this.state;
        if (r8 != 1) goto L5;
    L9:
        this.source.L(8);
        this.pos += 8;
        long r10 = this.source.F();
        afterPackableScalar(1);
        return r10;
    L5:
        if (r8 == 2) goto L9;
        throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.state);
    }

    public String readString() {
        long r8 = beforeLengthDelimitedScalar();
        this.source.L(r8);
        return this.source.P(r8);
    }

    public int readVarint32() {
        int r8 = this.state;
        if (r8 != 0) goto L5;
    L9:
        int r10 = internalReadVarint32();
        afterPackableScalar(0);
        return r10;
    L5:
        if (r8 == 2) goto L9;
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
    }

    public long readVarint64() {
        int r8 = this.state;
        if (r8 != 0) goto L5;
    L9:
        long r10 = 0;
        int r11 = 0;
    L11:
        if (r11 >= 64) goto L18;
        this.source.L(1);
        this.pos++;
        byte r12 = this.source.readByte();
        r10 = r10 | (((long) (r12 & 127)) << r11);
        if ((r12 & 128) == 0) goto L14;
        r11 = r11 + 7;
        goto L11
    L14:
        afterPackableScalar(0);
        return r10;
    L18:
        throw new ProtocolException("WireInput encountered a malformed varint");
    L5:
        if (r8 == 2) goto L9;
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
    }

    public void skip() {
        int r8 = this.state;
        if (r8 != 0) goto L5;
        readVarint64();
        return;
    L5:
        if (r8 != 1) goto L7;
        readFixed64();
        return;
    L7:
        if (r8 != 2) goto L9;
        long r10 = beforeLengthDelimitedScalar();
        this.source.skip(r10);
        return;
    L9:
        if (r8 != 5) goto L12;
        readFixed32();
        return;
    L12:
        throw new IllegalStateException("Unexpected call to skip()");
    }
}
