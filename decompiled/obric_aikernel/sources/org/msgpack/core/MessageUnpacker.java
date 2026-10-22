package org.msgpack.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.Closeable;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.time.Instant;
import kotlin.UShort;
import org.msgpack.core.buffer.MessageBuffer;
import org.msgpack.core.buffer.MessageBufferInput;
import org.msgpack.value.ImmutableValue;
import org.msgpack.value.Value;
import org.msgpack.value.ValueFactory;
import org.msgpack.value.ValueType;
import org.msgpack.value.Variable;

/* JADX INFO: loaded from: classes3.dex */
public class MessageUnpacker implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final MessageBuffer EMPTY_BUFFER = null;
    private static final String EMPTY_STRING = "";
    private final CodingErrorAction actionOnMalformedString;
    private final CodingErrorAction actionOnUnmappableString;
    private final boolean allowReadingBinaryAsString;
    private final boolean allowReadingStringAsBinary;
    private MessageBuffer buffer;
    private CharBuffer decodeBuffer;
    private StringBuilder decodeStringBuffer;
    private CharsetDecoder decoder;
    private MessageBufferInput in;
    private int nextReadPosition;
    private final MessageBuffer numberBuffer;
    private int position;
    private final int stringDecoderBufferSize;
    private final int stringSizeLimit;
    private long totalReadBytes;

    /* JADX INFO: renamed from: org.msgpack.core.MessageUnpacker$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$msgpack$core$MessageFormat = null;
        static final /* synthetic */ int[] $SwitchMap$org$msgpack$value$ValueType = null;

        static {
            int[] r10 = new int[ValueType.values().length];
            $SwitchMap$org$msgpack$value$ValueType = r10;
            r10[ValueType.NIL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L58
        L129:
            $SwitchMap$org$msgpack$value$ValueType[ValueType.BOOLEAN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L59
        L157:
            $SwitchMap$org$msgpack$value$ValueType[ValueType.INTEGER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L60
        L167:
            $SwitchMap$org$msgpack$value$ValueType[ValueType.FLOAT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L61
        L175:
            $SwitchMap$org$msgpack$value$ValueType[ValueType.STRING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L62
        L111:
            $SwitchMap$org$msgpack$value$ValueType[ValueType.BINARY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L63
        L113:
            $SwitchMap$org$msgpack$value$ValueType[ValueType.ARRAY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L64
        L143:
            $SwitchMap$org$msgpack$value$ValueType[ValueType.MAP.ordinal()] = 8;     // Catch: NoSuchFieldError -> L65
        L149:
            $SwitchMap$org$msgpack$value$ValueType[ValueType.EXTENSION.ordinal()] = 9;     // Catch: NoSuchFieldError -> L66
        L20:
            int[] r11 = new int[MessageFormat.values().length];
            $SwitchMap$org$msgpack$core$MessageFormat = r11;
            r11[MessageFormat.POSFIXINT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L67
        L187:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.NEGFIXINT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L68
        L123:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.BOOLEAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L69
        L135:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.NIL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L70
        L141:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXMAP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L71
        L155:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXARRAY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L72
        L181:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXSTR.ordinal()] = 7;     // Catch: NoSuchFieldError -> L73
        L191:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.INT8.ordinal()] = 8;     // Catch: NoSuchFieldError -> L74
        L105:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.UINT8.ordinal()] = 9;     // Catch: NoSuchFieldError -> L75
        L133:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.INT16.ordinal()] = 10;     // Catch: NoSuchFieldError -> L76
        L139:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.UINT16.ordinal()] = 11;     // Catch: NoSuchFieldError -> L77
        L165:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.INT32.ordinal()] = 12;     // Catch: NoSuchFieldError -> L78
        L171:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.UINT32.ordinal()] = 13;     // Catch: NoSuchFieldError -> L79
        L109:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FLOAT32.ordinal()] = 14;     // Catch: NoSuchFieldError -> L80
        L117:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.INT64.ordinal()] = 15;     // Catch: NoSuchFieldError -> L81
        L147:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.UINT64.ordinal()] = 16;     // Catch: NoSuchFieldError -> L82
        L153:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FLOAT64.ordinal()] = 17;     // Catch: NoSuchFieldError -> L83
        L179:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.BIN8.ordinal()] = 18;     // Catch: NoSuchFieldError -> L84
        L185:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.STR8.ordinal()] = 19;     // Catch: NoSuchFieldError -> L85
        L121:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.BIN16.ordinal()] = 20;     // Catch: NoSuchFieldError -> L86
        L127:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.STR16.ordinal()] = 21;     // Catch: NoSuchFieldError -> L87
        L159:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.BIN32.ordinal()] = 22;     // Catch: NoSuchFieldError -> L88
        L161:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.STR32.ordinal()] = 23;     // Catch: NoSuchFieldError -> L89
        L189:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXEXT1.ordinal()] = 24;     // Catch: NoSuchFieldError -> L90
        L103:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXEXT2.ordinal()] = 25;     // Catch: NoSuchFieldError -> L91
        L131:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXEXT4.ordinal()] = 26;     // Catch: NoSuchFieldError -> L92
        L137:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXEXT8.ordinal()] = 27;     // Catch: NoSuchFieldError -> L93
        L163:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.FIXEXT16.ordinal()] = 28;     // Catch: NoSuchFieldError -> L94
        L169:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.EXT8.ordinal()] = 29;     // Catch: NoSuchFieldError -> L95
        L107:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.EXT16.ordinal()] = 30;     // Catch: NoSuchFieldError -> L96
        L115:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.EXT32.ordinal()] = 31;     // Catch: NoSuchFieldError -> L97
        L145:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.ARRAY16.ordinal()] = 32;     // Catch: NoSuchFieldError -> L98
        L151:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.ARRAY32.ordinal()] = 33;     // Catch: NoSuchFieldError -> L99
        L177:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.MAP16.ordinal()] = 34;     // Catch: NoSuchFieldError -> L100
        L183:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.MAP32.ordinal()] = 35;     // Catch: NoSuchFieldError -> L101
        L119:
            $SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.NEVER_USED.ordinal()] = 36;     // Catch: NoSuchFieldError -> L102
            return;
        }
    }

    static {
        EMPTY_BUFFER = MessageBuffer.wrap(new byte[0]);
    }

    protected MessageUnpacker(MessageBufferInput r10, MessagePack.UnpackerConfig r11) {
        this.buffer = EMPTY_BUFFER;
        this.numberBuffer = MessageBuffer.allocate(8);
        this.in = (MessageBufferInput) Preconditions.checkNotNull(r10, "MessageBufferInput is null");
        this.allowReadingStringAsBinary = r11.getAllowReadingStringAsBinary();
        this.allowReadingBinaryAsString = r11.getAllowReadingBinaryAsString();
        this.actionOnMalformedString = r11.getActionOnMalformedString();
        this.actionOnUnmappableString = r11.getActionOnUnmappableString();
        this.stringSizeLimit = r11.getStringSizeLimit();
        this.stringDecoderBufferSize = r11.getStringDecoderBufferSize();
    }

    private String decodeStringFastPath(int r10) {
        CodingErrorAction r11 = this.actionOnMalformedString;
        CodingErrorAction r12 = CodingErrorAction.REPLACE;
        if (r11 != r12) goto L17;
        if (this.actionOnUnmappableString != r12) goto L17;
        if (this.buffer.hasArray() == false) goto L17;
        String r13 = new String(this.buffer.array(), this.buffer.arrayOffset() + this.position, r10, MessagePack.UTF8);
        this.position += r10;
        return r13;
    L17:
        CharBuffer r14 = this.decoder.decode(this.buffer.sliceAsByteBuffer(this.position, r10));     // Catch: CharacterCodingException -> L14
        this.position += r10;
        return r14.toString();
    L14:
        e = move-exception;
        throw new MessageStringCodingException(e);
    }

    private boolean ensureBuffer() {
    L3:
        if (this.buffer.size() > this.position) goto L8;
        MessageBuffer r10 = this.in.next();
        if (r10 == null) goto L6;
        this.totalReadBytes += (long) this.buffer.size();
        this.buffer = r10;
        this.position = 0;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    private MessageBuffer getNextBuffer() {
        MessageBuffer r10 = this.in.next();
        if (r10 == null) goto L7;
        this.totalReadBytes += (long) this.buffer.size();
        return r10;
    L7:
        throw new MessageInsufficientBufferException();
    }

    private void handleCoderError(CoderResult r10) {
        if (r10.isMalformed() == false) goto L7;
        if (this.actionOnMalformedString != CodingErrorAction.REPORT) goto L7;
    L10:
        r10.throwException();
        return;
    L7:
        if (r10.isUnmappable() == true) goto L9;
        return;
    L9:
        if (this.actionOnUnmappableString == CodingErrorAction.REPORT) goto L10;
    }

    private void nextBuffer() {
        this.buffer = getNextBuffer();
        this.position = 0;
    }

    private static MessageIntegerOverflowException overflowI16(short r10) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(r10));
    }

    private static MessageIntegerOverflowException overflowI32(int r10) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(r10));
    }

    private static MessageIntegerOverflowException overflowI64(long r10) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(r10));
    }

    private static MessageIntegerOverflowException overflowU16(short r10) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(r10 & UShort.MAX_VALUE));
    }

    private static MessageIntegerOverflowException overflowU32(int r10) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(((long) (r10 & Integer.MAX_VALUE)) + 2147483648L));
    }

    private static MessageSizeException overflowU32Size(int r10) {
        return new MessageSizeException(((long) (r10 & Integer.MAX_VALUE)) + 2147483648L);
    }

    private static MessageIntegerOverflowException overflowU64(long r10) {
        return new MessageIntegerOverflowException(BigInteger.valueOf((r10 + Long.MAX_VALUE) + 1).setBit(63));
    }

    private static MessageIntegerOverflowException overflowU8(byte r10) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(r10 & 255));
    }

    private MessageBuffer prepareNumberBuffer(int r10) {
        int r11 = this.buffer.size();
        int r12 = this.position;
        int r13 = r11 - r12;
        if (r13 < r10) goto L7;
        this.nextReadPosition = r12;
        this.position = r12 + r10;
        return this.buffer;
    L7:
        if (r13 <= 0) goto L9;
        this.numberBuffer.putMessageBuffer(0, this.buffer, r12, r13);
        r10 = r10 - r13;
        int r14 = r13 + 0;
    L10:
        nextBuffer();
        int r15 = this.buffer.size();
        if (r15 >= r10) goto L12;
        this.numberBuffer.putMessageBuffer(r14, this.buffer, 0, r15);
        r10 = r10 - r15;
        r14 = r14 + r15;
        goto L10
    L12:
        this.numberBuffer.putMessageBuffer(r14, this.buffer, 0, r10);
        this.position = r10;
        this.nextReadPosition = 0;
        return this.numberBuffer;
    L9:
        r14 = 0;
        goto L10
    }

    private byte readByte() {
        int r10 = this.buffer.size();
        int r11 = this.position;
        if (r10 <= r11) goto L6;
        byte r12 = this.buffer.getByte(r11);
        this.position++;
        return r12;
    L6:
        nextBuffer();
        if (this.buffer.size() <= 0) goto L11;
        byte r13 = this.buffer.getByte(0);
        this.position = 1;
        return r13;
    L11:
        return readByte();
    }

    private double readDouble() {
        return prepareNumberBuffer(8).getDouble(this.nextReadPosition);
    }

    private float readFloat() {
        return prepareNumberBuffer(4).getFloat(this.nextReadPosition);
    }

    private int readInt() {
        return prepareNumberBuffer(4).getInt(this.nextReadPosition);
    }

    private long readLong() {
        return prepareNumberBuffer(8).getLong(this.nextReadPosition);
    }

    private int readNextLength16() {
        return readShort() & UShort.MAX_VALUE;
    }

    private int readNextLength32() {
        int r10 = readInt();
        if (r10 < 0) goto L6;
        return r10;
    L6:
        throw overflowU32Size(r10);
    }

    private int readNextLength8() {
        return readByte() & 255;
    }

    private short readShort() {
        return prepareNumberBuffer(2).getShort(this.nextReadPosition);
    }

    private void resetDecoder() {
        CharsetDecoder r10 = this.decoder;
        if (r10 != null) goto L5;
        this.decodeBuffer = CharBuffer.allocate(this.stringDecoderBufferSize);
        this.decoder = MessagePack.UTF8.newDecoder().onMalformedInput(this.actionOnMalformedString).onUnmappableCharacter(this.actionOnUnmappableString);
    L6:
        StringBuilder r11 = this.decodeStringBuffer;
        if (r11 != null) goto L9;
        this.decodeStringBuffer = new StringBuilder();
        return;
    L9:
        r11.setLength(0);
        return;
    L5:
        r10.reset();
        goto L6
    }

    private void skipPayload(int r10) {
        if (r10 < 0) goto L9;
    L3:
        int r11 = this.buffer.size();
        int r12 = this.position;
        int r13 = r11 - r12;
        if (r13 >= r10) goto L5;
        this.position = r12 + r13;
        r10 = r10 - r13;
        nextBuffer();
        goto L3
    L5:
        this.position = r12 + r10;
        return;
    L9:
        throw new IllegalArgumentException("payload size must be >= 0: " + r10);
    }

    private int tryReadBinaryHeader(byte r10) {
        switch(r10) {
            case -60: goto L10;
            case -59: goto L8;
            case -58: goto L6;
            default: goto L3;
        };
    L3:
        return -1;
    L6:
        return readNextLength32();
    L8:
        return readNextLength16();
    L10:
        return readNextLength8();
    }

    private int tryReadStringHeader(byte r10) {
        switch(r10) {
            case -39: goto L10;
            case -38: goto L8;
            case -37: goto L6;
            default: goto L3;
        };
    L3:
        return -1;
    L6:
        return readNextLength32();
    L8:
        return readNextLength16();
    L10:
        return readNextLength8();
    }

    private static MessagePackException unexpected(String r10, byte r11) {
        MessageFormat r12 = MessageFormat.valueOf(r11);
        if (r12 == MessageFormat.NEVER_USED) goto L5;
        String r13 = r12.getValueType().name();
        return new MessageTypeException(String.format("Expected %s, but got %s (%02x)", new Object[]{r10, r13.substring(0, 1) + r13.substring(1).toLowerCase(), Byte.valueOf(r11)}));
    L5:
        return new MessageNeverUsedFormatException(String.format("Expected %s, but encountered 0xC1 \"NEVER_USED\" byte", new Object[]{r10}));
    }

    private static MessagePackException unexpectedExtension(String r10, int r11, int r12) {
        return new MessageTypeException(String.format("Expected extension type %s (%d), but got extension type %d", new Object[]{r10, Integer.valueOf(r11), Integer.valueOf(r12)}));
    }

    private static int utf8MultibyteCharacterSize(byte r10) {
        return Integer.numberOfLeadingZeros((~(r10 & 255)) << 24);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.totalReadBytes += (long) this.position;
        this.buffer = EMPTY_BUFFER;
        this.position = 0;
        this.in.close();
    }

    public MessageFormat getNextFormat() {
        if (ensureBuffer() == false) goto L7;
        return MessageFormat.valueOf(this.buffer.getByte(this.position));
    L7:
        throw new MessageInsufficientBufferException();
    }

    public long getTotalReadBytes() {
        return this.totalReadBytes + ((long) this.position);
    }

    public boolean hasNext() {
        return ensureBuffer();
    }

    public void readPayload(ByteBuffer r10) {
    L2:
        int r11 = r10.remaining();
        int r12 = this.buffer.size();
        int r13 = this.position;
        int r14 = r12 - r13;
        if (r14 >= r11) goto L4;
        this.buffer.getBytes(r13, r14, r10);
        this.position += r14;
        nextBuffer();
        goto L2
    L4:
        this.buffer.getBytes(r13, r11, r10);
        this.position += r11;
    }

    public void readPayload(MessageBuffer r10, int r11, int r12) {
    L2:
        int r13 = this.buffer.size();
        int r14 = this.position;
        int r15 = r13 - r14;
        if (r15 >= r12) goto L4;
        r10.putMessageBuffer(r11, this.buffer, r14, r15);
        r11 = r11 + r15;
        r12 = r12 - r15;
        this.position += r15;
        nextBuffer();
        goto L2
    L4:
        r10.putMessageBuffer(r11, this.buffer, r14, r12);
        this.position += r12;
    }

    public void readPayload(byte[] r10) {
        readPayload(r10, 0, r10.length);
    }

    public void readPayload(byte[] r10, int r11, int r12) {
    L2:
        int r13 = this.buffer.size();
        int r14 = this.position;
        int r15 = r13 - r14;
        if (r15 >= r12) goto L4;
        this.buffer.getBytes(r14, r10, r11, r15);
        r11 = r11 + r15;
        r12 = r12 - r15;
        this.position += r15;
        nextBuffer();
        goto L2
    L4:
        this.buffer.getBytes(r14, r10, r11, r12);
        this.position += r12;
    }

    public byte[] readPayload(int r10) {
        byte[] r11 = new byte[r10];
        readPayload(r11);
        return r11;
    }

    public MessageBuffer readPayloadAsReference(int r10) {
        int r11 = this.buffer.size();
        int r12 = this.position;
        if ((r11 - r12) < r10) goto L6;
        MessageBuffer r13 = this.buffer.slice(r12, r10);
        this.position += r10;
        return r13;
    L6:
        MessageBuffer r14 = MessageBuffer.allocate(r10);
        readPayload(r14, 0, r10);
        return r14;
    }

    public MessageBufferInput reset(MessageBufferInput r10) {
        MessageBufferInput r11 = (MessageBufferInput) Preconditions.checkNotNull(r10, "MessageBufferInput is null");
        MessageBufferInput r12 = this.in;
        this.in = r11;
        this.buffer = EMPTY_BUFFER;
        this.position = 0;
        this.totalReadBytes = 0;
        return r12;
    }

    public void skipValue() {
        skipValue(1);
    }

    public void skipValue(int r10) {
    L2:
        if (r10 <= 0) goto L34;
        byte r11 = readByte();
        switch(AnonymousClass1.$SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.valueOf(r11).ordinal()]) {
            case 5: goto L30;
            case 6: goto L29;
            case 7: goto L27;
            case 8: goto L26;
            case 9: goto L26;
            case 10: goto L25;
            case 11: goto L25;
            case 12: goto L24;
            case 13: goto L24;
            case 14: goto L24;
            case 15: goto L23;
            case 16: goto L23;
            case 17: goto L23;
            case 18: goto L22;
            case 19: goto L22;
            case 20: goto L21;
            case 21: goto L21;
            case 22: goto L20;
            case 23: goto L20;
            case 24: goto L25;
            case 25: goto L19;
            case 26: goto L18;
            case 27: goto L17;
            case 28: goto L16;
            case 29: goto L14;
            case 30: goto L13;
            case 31: goto L12;
            case 32: goto L11;
            case 33: goto L10;
            case 34: goto L9;
            case 35: goto L8;
            case 36: goto L7;
            default: goto L33;
        };
    L8:
        int r12 = readNextLength32();
    L31:
        int r13 = r12 * 2;
    L32:
        r10 = r10 + r13;
        goto L33
    L9:
        r12 = readNextLength16();
        goto L31
    L10:
        r13 = readNextLength32();
        goto L32
    L11:
        r13 = readNextLength16();
        goto L32
    L12:
        int r14 = readNextLength32();
        skipPayload(1);
    L28:
        skipPayload(r14);
        goto L33
    L13:
        int r15 = readNextLength16();
    L15:
        r14 = r15 + 1;
        goto L28
    L14:
        r15 = readNextLength8();
        goto L15
    L16:
        r14 = 17;
        goto L28
    L17:
        r14 = 9;
        goto L28
    L18:
        r14 = 5;
        goto L28
    L19:
        r14 = 3;
        goto L28
    L20:
        r14 = readNextLength32();
        goto L28
    L21:
        r14 = readNextLength16();
        goto L28
    L22:
        r14 = readNextLength8();
        goto L28
    L23:
        r14 = 8;
        goto L28
    L24:
        r14 = 4;
        goto L28
    L25:
        skipPayload(2);
        goto L33
    L26:
        skipPayload(1);
        goto L33
    L27:
        r14 = r11 & 31;
        goto L28
    L29:
        r13 = r11 & 15;
        goto L32
    L30:
        r12 = r11 & 15;
        goto L31
    L7:
        throw new MessageNeverUsedFormatException("Encountered 0xC1 \"NEVER_USED\" byte");
    L33:
        r10 = r10 - 1;
        goto L2
    }

    public boolean tryUnpackNil() {
        if (ensureBuffer() == false) goto L11;
        if (this.buffer.getByte(this.position) != (-64)) goto L8;
        readByte();
        return true;
    L8:
        return false;
    L11:
        throw new MessageInsufficientBufferException();
    }

    public int unpackArrayHeader() {
        byte r10 = readByte();
        if (MessagePack.Code.isFixedArray(r10) == false) goto L7;
        return r10 & 15;
    L7:
        if (r10 == (-36)) goto L15;
        if (r10 != (-35)) goto L13;
        return readNextLength32();
    L13:
        throw unexpected("Array", r10);
    L15:
        return readNextLength16();
    }

    public BigInteger unpackBigInteger() {
        byte r10 = readByte();
        if (MessagePack.Code.isFixInt(r10) == true) goto L5;
        switch(r10) {
            case -52: goto L32;
            case -51: goto L30;
            case -50: goto L23;
            case -49: goto L17;
            case -48: goto L16;
            case -47: goto L14;
            case -46: goto L12;
            case -45: goto L10;
            default: goto L8;
        };
    L17:
        long r11 = readLong();
        if (r11 >= 0) goto L22;
        return BigInteger.valueOf((r11 + Long.MAX_VALUE) + 1).setBit(63);
    L22:
        return BigInteger.valueOf(r11);
    L23:
        int r12 = readInt();
        if (r12 >= 0) goto L28;
        return BigInteger.valueOf(((long) (r12 & Integer.MAX_VALUE)) + 2147483648L);
    L28:
        return BigInteger.valueOf(r12);
    L8:
        throw unexpected("Integer", r10);
    L10:
        return BigInteger.valueOf(readLong());
    L12:
        return BigInteger.valueOf(readInt());
    L14:
        return BigInteger.valueOf(readShort());
    L16:
        return BigInteger.valueOf(readByte());
    L30:
        return BigInteger.valueOf(readShort() & UShort.MAX_VALUE);
    L32:
        return BigInteger.valueOf(readByte() & 255);
    L5:
        return BigInteger.valueOf(r10);
    }

    public int unpackBinaryHeader() {
        byte r10 = readByte();
        if (MessagePack.Code.isFixedRaw(r10) == true) goto L5;
        int r11 = tryReadBinaryHeader(r10);
        if (r11 < 0) goto L10;
        return r11;
    L10:
        if (this.allowReadingStringAsBinary == false) goto L15;
        int r12 = tryReadStringHeader(r10);
        if (r12 < 0) goto L15;
        return r12;
    L15:
        throw unexpected("Binary", r10);
    L5:
        return r10 & 31;
    }

    public boolean unpackBoolean() {
        byte r10 = readByte();
        if (r10 != (-62)) goto L7;
        return false;
    L7:
        if (r10 != (-61)) goto L11;
        return true;
    L11:
        throw unexpected(TypedValues.Custom.S_BOOLEAN, r10);
    }

    public byte unpackByte() {
        byte r10 = readByte();
        if (MessagePack.Code.isFixInt(r10) == false) goto L6;
        return r10;
    L6:
        switch(r10) {
            case -52: goto L54;
            case -51: goto L47;
            case -50: goto L40;
            case -49: goto L33;
            case -48: goto L32;
            case -47: goto L24;
            case -46: goto L17;
            case -45: goto L9;
            default: goto L8;
        };
    L9:
        long r11 = readLong();
        if (r11 < (-128)) goto L16;
        if (r11 > 127) goto L16;
    L14:
        return (byte) r11;
    L16:
        throw overflowI64(r11);
    L17:
        int r12 = readInt();
        if (r12 < (-128)) goto L23;
        if (r12 > 127) goto L23;
        return (byte) r12;
    L23:
        throw overflowI32(r12);
    L24:
        short r13 = readShort();
        if (r13 < (-128)) goto L30;
        if (r13 > 127) goto L30;
        return (byte) r13;
    L30:
        throw overflowI16(r13);
    L33:
        r11 = readLong();
        if (r11 < 0) goto L39;
        if (r11 <= 127) goto L14;
    L39:
        throw overflowU64(r11);
    L40:
        int r14 = readInt();
        if (r14 < 0) goto L46;
        if (r14 > 127) goto L46;
        return (byte) r14;
    L46:
        throw overflowU32(r14);
    L47:
        short r15 = readShort();
        if (r15 < 0) goto L53;
        if (r15 > 127) goto L53;
        return (byte) r15;
    L53:
        throw overflowU16(r15);
    L54:
        byte r16 = readByte();
        if (r16 < 0) goto L58;
        return r16;
    L58:
        throw overflowU8(r16);
    L8:
        throw unexpected("Integer", r10);
    L32:
        return readByte();
    }

    public double unpackDouble() {
        byte r10 = readByte();
        if (r10 == (-54)) goto L11;
        if (r10 != (-53)) goto L9;
        return readDouble();
    L9:
        throw unexpected("Float", r10);
    L11:
        return readFloat();
    }

    public ExtensionTypeHeader unpackExtensionTypeHeader() {
        byte r10 = readByte();
        switch(r10) {
            case -57: goto L25;
            case -56: goto L23;
            case -55: goto L17;
            default: goto L4;
        };
    L4:
        switch(r10) {
            case -44: goto L16;
            case -43: goto L14;
            case -42: goto L12;
            case -41: goto L10;
            case -40: goto L8;
            default: goto L6;
        };
    L6:
        throw unexpected("Ext", r10);
    L8:
        return new ExtensionTypeHeader(readByte(), 16);
    L10:
        return new ExtensionTypeHeader(readByte(), 8);
    L12:
        return new ExtensionTypeHeader(readByte(), 4);
    L14:
        return new ExtensionTypeHeader(readByte(), 2);
    L16:
        return new ExtensionTypeHeader(readByte(), 1);
    L17:
        MessageBuffer r11 = prepareNumberBuffer(5);
        int r12 = r11.getInt(this.nextReadPosition);
        if (r12 < 0) goto L22;
        return new ExtensionTypeHeader(r11.getByte(this.nextReadPosition + 4), r12);
    L22:
        throw overflowU32Size(r12);
    L23:
        MessageBuffer r13 = prepareNumberBuffer(3);
        int r14 = r13.getShort(this.nextReadPosition) & UShort.MAX_VALUE;
        return new ExtensionTypeHeader(r13.getByte(this.nextReadPosition + 2), r14);
    L25:
        MessageBuffer r15 = prepareNumberBuffer(2);
        int r16 = r15.getByte(this.nextReadPosition) & 255;
        return new ExtensionTypeHeader(r15.getByte(this.nextReadPosition + 1), r16);
    }

    public float unpackFloat() {
        byte r10 = readByte();
        if (r10 == (-54)) goto L11;
        if (r10 != (-53)) goto L9;
        return (float) readDouble();
    L9:
        throw unexpected("Float", r10);
    L11:
        return readFloat();
    }

    public int unpackInt() {
        byte r10 = readByte();
        if (MessagePack.Code.isFixInt(r10) == false) goto L6;
        return r10;
    L6:
        switch(r10) {
            case -52: goto L39;
            case -51: goto L37;
            case -50: goto L31;
            case -49: goto L23;
            case -48: goto L22;
            case -47: goto L20;
            case -46: goto L18;
            case -45: goto L9;
            default: goto L8;
        };
    L9:
        long r11 = readLong();
        if (r11 < (-2147483648L)) goto L16;
        if (r11 > 2147483647L) goto L16;
        return (int) r11;
    L16:
        throw overflowI64(r11);
    L23:
        long r12 = readLong();
        if (r12 < 0) goto L30;
        if (r12 > 2147483647L) goto L30;
        return (int) r12;
    L30:
        throw overflowU64(r12);
    L31:
        int r13 = readInt();
        if (r13 < 0) goto L35;
        return r13;
    L35:
        throw overflowU32(r13);
    L8:
        throw unexpected("Integer", r10);
    L18:
        return readInt();
    L20:
        return readShort();
    L22:
        return readByte();
    L37:
        return readShort() & UShort.MAX_VALUE;
    L39:
        return readByte() & 255;
    }

    public long unpackLong() {
        byte r10 = readByte();
        if (MessagePack.Code.isFixInt(r10) == true) goto L5;
        switch(r10) {
            case -52: goto L31;
            case -51: goto L29;
            case -50: goto L22;
            case -49: goto L17;
            case -48: goto L16;
            case -47: goto L14;
            case -46: goto L12;
            case -45: goto L10;
            default: goto L8;
        };
    L17:
        long r11 = readLong();
        if (r11 < 0) goto L21;
        return r11;
    L21:
        throw overflowU64(r11);
    L22:
        int r12 = readInt();
        if (r12 >= 0) goto L27;
        return ((long) (r12 & Integer.MAX_VALUE)) + 2147483648L;
    L27:
        return r12;
    L8:
        throw unexpected("Integer", r10);
    L10:
        return readLong();
    L12:
        return readInt();
    L14:
        return readShort();
    L16:
        return readByte();
    L29:
        return readShort() & UShort.MAX_VALUE;
    L31:
        return readByte() & 255;
    L5:
        return r10;
    }

    public int unpackMapHeader() {
        byte r10 = readByte();
        if (MessagePack.Code.isFixedMap(r10) == false) goto L7;
        return r10 & 15;
    L7:
        if (r10 == (-34)) goto L15;
        if (r10 != (-33)) goto L13;
        return readNextLength32();
    L13:
        throw unexpected("Map", r10);
    L15:
        return readNextLength16();
    }

    public void unpackNil() {
        byte r10 = readByte();
        if (r10 != (-64)) goto L6;
        return;
    L6:
        throw unexpected("Nil", r10);
    }

    public int unpackRawStringHeader() {
        byte r10 = readByte();
        if (MessagePack.Code.isFixedRaw(r10) == true) goto L5;
        int r11 = tryReadStringHeader(r10);
        if (r11 < 0) goto L10;
        return r11;
    L10:
        if (this.allowReadingBinaryAsString == false) goto L15;
        int r12 = tryReadBinaryHeader(r10);
        if (r12 < 0) goto L15;
        return r12;
    L15:
        throw unexpected("String", r10);
    L5:
        return r10 & 31;
    }

    public short unpackShort() {
        byte r10 = readByte();
        if (MessagePack.Code.isFixInt(r10) == false) goto L7;
        return r10;
    L7:
        switch(r10) {
            case -52: goto L48;
            case -51: goto L43;
            case -50: goto L36;
            case -49: goto L29;
            case -48: goto L28;
            case -47: goto L27;
            case -46: goto L19;
            case -45: goto L10;
            default: goto L9;
        };
    L10:
        long r11 = readLong();
        if (r11 < (-32768)) goto L18;
        if (r11 > 32767) goto L18;
    L14:
        int r12 = (int) r11;
    L16:
        return (short) r12;
    L18:
        throw overflowI64(r11);
    L19:
        int r13 = readInt();
        if (r13 < (-32768)) goto L25;
        if (r13 > 32767) goto L25;
        return (short) r13;
    L25:
        throw overflowI32(r13);
    L28:
        r12 = readByte();
        goto L16
    L29:
        r11 = readLong();
        if (r11 < 0) goto L35;
        if (r11 <= 32767) goto L14;
    L35:
        throw overflowU64(r11);
    L36:
        int r14 = readInt();
        if (r14 < 0) goto L42;
        if (r14 > 32767) goto L42;
        return (short) r14;
    L42:
        throw overflowU32(r14);
    L43:
        short r15 = readShort();
        if (r15 < 0) goto L47;
        return r15;
    L47:
        throw overflowU16(r15);
    L48:
        r12 = readByte() & 255;
        goto L16
    L9:
        throw unexpected("Integer", r10);
    L27:
        return readShort();
    }

    public String unpackString() {
        int r10 = unpackRawStringHeader();
        if (r10 != 0) goto L7;
        return "";
    L7:
        if (r10 > this.stringSizeLimit) goto L50;
        resetDecoder();
        if ((this.buffer.size() - this.position) >= r10) goto L11;
    L12:
        if (r10 <= 0) goto L45;
        int r11 = this.buffer.size();     // Catch: CharacterCodingException -> L46
        int r12 = this.position;     // Catch: CharacterCodingException -> L46
        int r13 = r11 - r12;     // Catch: CharacterCodingException -> L46
        if (r13 >= r10) goto L15;
        if (r13 == 0) goto L17;
        ByteBuffer r14 = this.buffer.sliceAsByteBuffer(r12, r13);     // Catch: CharacterCodingException -> L46
        int r15 = r14.position();     // Catch: CharacterCodingException -> L46
        this.decodeBuffer.clear();     // Catch: CharacterCodingException -> L46
        CoderResult r16 = this.decoder.decode(r14, this.decodeBuffer, false);     // Catch: CharacterCodingException -> L46
        int r17 = r14.position() - r15;     // Catch: CharacterCodingException -> L46
        this.position += r17;     // Catch: CharacterCodingException -> L46
        r10 = r10 - r17;     // Catch: CharacterCodingException -> L46
        this.decodeStringBuffer.append(this.decodeBuffer.flip());     // Catch: CharacterCodingException -> L46
        if (r16.isError() == false) goto L22;
        handleCoderError(r16);     // Catch: CharacterCodingException -> L46
    L22:
        if (r16.isUnderflow() == false) goto L12;
        if (r17 >= r13) goto L12;
        ByteBuffer r18 = ByteBuffer.allocate(utf8MultibyteCharacterSize(this.buffer.getByte(this.position)));     // Catch: CharacterCodingException -> L46
        MessageBuffer r19 = this.buffer;     // Catch: CharacterCodingException -> L46
        r19.getBytes(this.position, r19.size() - this.position, r18);     // Catch: CharacterCodingException -> L46
    L25:
        nextBuffer();     // Catch: CharacterCodingException -> L46
        int r20 = r18.remaining();     // Catch: CharacterCodingException -> L46
        if (this.buffer.size() >= r20) goto L27;
        MessageBuffer r21 = this.buffer;     // Catch: CharacterCodingException -> L46
        r21.getBytes(0, r21.size(), r18);     // Catch: CharacterCodingException -> L46
        this.position = this.buffer.size();     // Catch: CharacterCodingException -> L46
        goto L25
    L27:
        this.buffer.getBytes(0, r20, r18);     // Catch: CharacterCodingException -> L46
        this.position = r20;     // Catch: CharacterCodingException -> L46
        r18.position(0);     // Catch: CharacterCodingException -> L46
        this.decodeBuffer.clear();     // Catch: CharacterCodingException -> L46
        CoderResult r22 = this.decoder.decode(r18, this.decodeBuffer, false);     // Catch: CharacterCodingException -> L46
        if (r22.isError() == false) goto L31;
        handleCoderError(r22);     // Catch: CharacterCodingException -> L46
    L31:
        if (r22.isOverflow() == false) goto L33;
    L51:
        r22.throwException();     // Catch: Exception -> L40
        throw new MessageFormatException("Unexpected UTF-8 multibyte sequence");     // Catch: Exception -> L40
    L40:
        e = move-exception;
        throw new MessageFormatException("Unexpected UTF-8 multibyte sequence", e);     // Catch: CharacterCodingException -> L46
    L33:
        if (r22.isUnderflow() == true) goto L35;
    L36:
        r10 = r10 - r18.limit();     // Catch: CharacterCodingException -> L46
        this.decodeStringBuffer.append(this.decodeBuffer.flip());     // Catch: CharacterCodingException -> L46
        goto L12
    L35:
        if (r18.position() < r18.limit()) goto L51;
    L17:
        nextBuffer();     // Catch: CharacterCodingException -> L46
        goto L12
    L15:
        this.decodeStringBuffer.append(decodeStringFastPath(r10));     // Catch: CharacterCodingException -> L46
    L46:
        e = move-exception;
        throw new MessageStringCodingException(e);
    L45:
        return this.decodeStringBuffer.toString();
    L11:
        return decodeStringFastPath(r10);
    L50:
        throw new MessageSizeException(String.format("cannot unpack a String of size larger than %,d: %,d", new Object[]{Integer.valueOf(this.stringSizeLimit), Integer.valueOf(r10)}), r10);
    }

    public Instant unpackTimestamp() {
        return unpackTimestamp(unpackExtensionTypeHeader());
    }

    public Instant unpackTimestamp(ExtensionTypeHeader r10) {
        if (r10.getType() != (-1)) goto L19;
        int r11 = r10.getLength();
        if (r11 == 4) goto L17;
        if (r11 != 8) goto L9;
        long r12 = readLong();
        return Instant.ofEpochSecond(r12 & 17179869183L, (int) (r12 >>> 34));
    L9:
        if (r11 != 12) goto L13;
        return Instant.ofEpochSecond(readLong(), ((long) readInt()) & 4294967295L);
    L13:
        throw new MessageFormatException(String.format("Timestamp extension type (%d) expects 4, 8, or 12 bytes of payload but got %d bytes", new Object[]{(byte) -1, Integer.valueOf(r10.getLength())}));
    L17:
        return Instant.ofEpochSecond(((long) readInt()) & 4294967295L);
    L19:
        throw unexpectedExtension("Timestamp", -1, r10.getType());
    }

    public ImmutableValue unpackValue() {
        MessageFormat r10 = getNextFormat();
        int r11 = 0;
        switch(AnonymousClass1.$SwitchMap$org$msgpack$value$ValueType[r10.getValueType().ordinal()]) {
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L33;
            case 4: goto L31;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L17;
            case 8: goto L12;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        ExtensionTypeHeader r12 = unpackExtensionTypeHeader();
        if (r12.getType() == (-1)) goto L11;
        return ValueFactory.newExtension(r12.getType(), readPayload(r12.getLength()));
    L11:
        return ValueFactory.newTimestamp(unpackTimestamp(r12));
    L12:
        int r13 = unpackMapHeader() * 2;
        Value[] r14 = new Value[r13];
    L13:
        if (r11 >= r13) goto L16;
        r14[r11] = unpackValue();
        int r15 = r11 + 1;
        r14[r15] = unpackValue();
        r11 = r15 + 1;
        goto L13
    L16:
        return ValueFactory.newMap(r14, true);
    L17:
        int r16 = unpackArrayHeader();
        Value[] r17 = new Value[r16];
    L18:
        if (r11 >= r16) goto L21;
        r17[r11] = unpackValue();
        r11 = r11 + 1;
        goto L18
    L21:
        return ValueFactory.newArray(r17, true);
    L24:
        int r18 = unpackRawStringHeader();
        if (r18 > this.stringSizeLimit) goto L29;
        return ValueFactory.newString(readPayload(r18), true);
    L29:
        throw new MessageSizeException(String.format("cannot unpack a String of size larger than %,d: %,d", new Object[]{Integer.valueOf(this.stringSizeLimit), Integer.valueOf(r18)}), r18);
    L40:
        readByte();
        return ValueFactory.newNil();
    L5:
        throw new MessageNeverUsedFormatException("Unknown value type");
    L23:
        return ValueFactory.newBinary(readPayload(unpackBinaryHeader()), true);
    L31:
        return ValueFactory.newFloat(unpackDouble());
    L33:
        if (r10 != MessageFormat.UINT64) goto L37;
        return ValueFactory.newInteger(unpackBigInteger());
    L37:
        return ValueFactory.newInteger(unpackLong());
    L39:
        return ValueFactory.newBoolean(unpackBoolean());
    }

    public Variable unpackValue(Variable r10) {
        MessageFormat r11 = getNextFormat();
        int r12 = 0;
        switch(AnonymousClass1.$SwitchMap$org$msgpack$value$ValueType[r11.getValueType().ordinal()]) {
            case 1: goto L39;
            case 2: goto L37;
            case 3: goto L32;
            case 4: goto L29;
            case 5: goto L23;
            case 6: goto L21;
            case 7: goto L16;
            case 8: goto L11;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        ExtensionTypeHeader r13 = unpackExtensionTypeHeader();
        if (r13.getType() == (-1)) goto L9;
        r10.setExtensionValue(r13.getType(), readPayload(r13.getLength()));
    L10:
        return r10;
    L9:
        r10.setTimestampValue(unpackTimestamp(r13));
        goto L10
    L11:
        int r14 = unpackMapHeader() * 2;
        Value[] r15 = new Value[r14];
    L12:
        if (r12 >= r14) goto L14;
        r15[r12] = unpackValue();
        int r16 = r12 + 1;
        r15[r16] = unpackValue();
        r12 = r16 + 1;
        goto L12
    L14:
        r10.setMapValue(r15);
        return r10;
    L16:
        int r17 = unpackArrayHeader();
        Value[] r18 = new Value[r17];
    L17:
        if (r12 >= r17) goto L19;
        r18[r12] = unpackValue();
        r12 = r12 + 1;
        goto L17
    L19:
        r10.setArrayValue(r18);
        return r10;
    L21:
        r10.setBinaryValue(readPayload(unpackBinaryHeader()));
        return r10;
    L23:
        int r19 = unpackRawStringHeader();
        if (r19 > this.stringSizeLimit) goto L28;
        r10.setStringValue(readPayload(r19));
        return r10;
    L28:
        throw new MessageSizeException(String.format("cannot unpack a String of size larger than %,d: %,d", new Object[]{Integer.valueOf(this.stringSizeLimit), Integer.valueOf(r19)}), r19);
    L29:
        r10.setFloatValue(unpackDouble());
        return r10;
    L37:
        r10.setBooleanValue(unpackBoolean());
        return r10;
    L39:
        readByte();
        r10.setNilValue();
        return r10;
    L5:
        throw new MessageFormatException("Unknown value type");
    L32:
        if (AnonymousClass1.$SwitchMap$org$msgpack$core$MessageFormat[r11.ordinal()] == 16) goto L35;
        r10.setIntegerValue(unpackLong());
        return r10;
    L35:
        r10.setIntegerValue(unpackBigInteger());
        return r10;
    }
}
