package org.msgpack.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes7.dex */
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
            int[] r0 = new int[ValueType.values().length];
            $SwitchMap$org$msgpack$value$ValueType = r0;
            r0[ValueType.NIL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L58
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
            int[] r9 = new int[MessageFormat.values().length];
            $SwitchMap$org$msgpack$core$MessageFormat = r9;
            r9[MessageFormat.POSFIXINT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L67
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

    public MessageUnpacker(MessageBufferInput r3, MessagePack.UnpackerConfig r4) {
        MessageBufferInput r5 = (MessageBufferInput) ZeusTransformUtils.wrapperContextForParams(r3, MessageBufferInput.class, "com.obric.memorydata.plugin");
        this.buffer = EMPTY_BUFFER;
        this.numberBuffer = MessageBuffer.allocate(8);
        this.in = (MessageBufferInput) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r5, "MessageBufferInput is null"), MessageBufferInput.class, "com.obric.memorydata.plugin");
        this.allowReadingStringAsBinary = r4.getAllowReadingStringAsBinary();
        this.allowReadingBinaryAsString = r4.getAllowReadingBinaryAsString();
        this.actionOnMalformedString = r4.getActionOnMalformedString();
        this.actionOnUnmappableString = r4.getActionOnUnmappableString();
        this.stringSizeLimit = r4.getStringSizeLimit();
        this.stringDecoderBufferSize = r4.getStringDecoderBufferSize();
    }

    private String decodeStringFastPath(int r5) {
        if (this.actionOnMalformedString != CodingErrorAction.REPLACE) goto L17;
        if (this.actionOnUnmappableString != CodingErrorAction.REPLACE) goto L17;
        if (this.buffer.hasArray() == false) goto L17;
        String r0 = new String(this.buffer.array(), this.buffer.arrayOffset() + this.position, r5, MessagePack.UTF8);
        this.position += r5;
        return r0;
    L17:
        CharBuffer r1 = this.decoder.decode(this.buffer.sliceAsByteBuffer(this.position, r5));     // Catch: CharacterCodingException -> L14
        this.position += r5;
        return r1.toString();
    L14:
        e = move-exception;
        throw new MessageStringCodingException(e);
    }

    private boolean ensureBuffer() {
    L3:
        if (this.buffer.size() > this.position) goto L8;
        MessageBuffer r0 = this.in.next();
        if (r0 == null) goto L6;
        this.totalReadBytes += (long) this.buffer.size();
        this.buffer = r0;
        this.position = 0;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    private MessageBuffer getNextBuffer() {
        MessageBuffer r0 = this.in.next();
        if (r0 == null) goto L7;
        this.totalReadBytes += (long) this.buffer.size();
        return r0;
    L7:
        throw new MessageInsufficientBufferException();
    }

    private void handleCoderError(CoderResult r3) {
        if (r3.isMalformed() == false) goto L7;
        if (this.actionOnMalformedString != CodingErrorAction.REPORT) goto L7;
    L10:
        r3.throwException();
        return;
    L7:
        if (r3.isUnmappable() == true) goto L9;
        return;
    L9:
        if (this.actionOnUnmappableString == CodingErrorAction.REPORT) goto L10;
    }

    private void nextBuffer() {
        this.buffer = getNextBuffer();
        this.position = 0;
    }

    private static MessageIntegerOverflowException overflowI16(short r2) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(r2));
    }

    private static MessageIntegerOverflowException overflowI32(int r2) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(r2));
    }

    private static MessageIntegerOverflowException overflowI64(long r0) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(r0));
    }

    private static MessageIntegerOverflowException overflowU16(short r2) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(r2 & UShort.MAX_VALUE));
    }

    private static MessageIntegerOverflowException overflowU32(int r4) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(((long) (r4 & Integer.MAX_VALUE)) + 2147483648L));
    }

    private static MessageSizeException overflowU32Size(int r4) {
        return new MessageSizeException(((long) (r4 & Integer.MAX_VALUE)) + 2147483648L);
    }

    private static MessageIntegerOverflowException overflowU64(long r2) {
        return new MessageIntegerOverflowException(BigInteger.valueOf((r2 + Long.MAX_VALUE) + 1).setBit(63));
    }

    private static MessageIntegerOverflowException overflowU8(byte r2) {
        return new MessageIntegerOverflowException(BigInteger.valueOf(r2 & 255));
    }

    private MessageBuffer prepareNumberBuffer(int r6) {
        int r0 = this.buffer.size();
        int r1 = this.position;
        int r2 = r0 - r1;
        if (r2 < r6) goto L7;
        this.nextReadPosition = r1;
        this.position = r1 + r6;
        return this.buffer;
    L7:
        if (r2 <= 0) goto L9;
        this.numberBuffer.putMessageBuffer(0, this.buffer, r1, r2);
        r6 = r6 - r2;
        int r3 = r2 + 0;
    L10:
        nextBuffer();
        int r4 = this.buffer.size();
        if (r4 >= r6) goto L12;
        this.numberBuffer.putMessageBuffer(r3, this.buffer, 0, r4);
        r6 = r6 - r4;
        r3 = r3 + r4;
        goto L10
    L12:
        this.numberBuffer.putMessageBuffer(r3, this.buffer, 0, r6);
        this.position = r6;
        this.nextReadPosition = 0;
        return this.numberBuffer;
    L9:
        r3 = 0;
        goto L10
    }

    private byte readByte() {
        int r0 = this.buffer.size();
        int r1 = this.position;
        if (r0 <= r1) goto L6;
        byte r2 = this.buffer.getByte(r1);
        this.position++;
        return r2;
    L6:
        nextBuffer();
        if (this.buffer.size() <= 0) goto L11;
        byte r3 = this.buffer.getByte(0);
        this.position = 1;
        return r3;
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
        int r0 = readInt();
        if (r0 < 0) goto L6;
        return r0;
    L6:
        throw overflowU32Size(r0);
    }

    private int readNextLength8() {
        return readByte() & 255;
    }

    private short readShort() {
        return prepareNumberBuffer(2).getShort(this.nextReadPosition);
    }

    private void resetDecoder() {
        CharsetDecoder r0 = this.decoder;
        if (r0 != null) goto L5;
        this.decodeBuffer = CharBuffer.allocate(this.stringDecoderBufferSize);
        this.decoder = MessagePack.UTF8.newDecoder().onMalformedInput(this.actionOnMalformedString).onUnmappableCharacter(this.actionOnUnmappableString);
    L6:
        StringBuilder r1 = this.decodeStringBuffer;
        if (r1 != null) goto L9;
        this.decodeStringBuffer = new StringBuilder();
        return;
    L9:
        r1.setLength(0);
        return;
    L5:
        r0.reset();
        goto L6
    }

    private void skipPayload(int r3) {
        if (r3 < 0) goto L9;
    L3:
        int r0 = this.buffer.size();
        int r1 = this.position;
        int r2 = r0 - r1;
        if (r2 >= r3) goto L5;
        this.position = r1 + r2;
        r3 = r3 - r2;
        nextBuffer();
        goto L3
    L5:
        this.position = r1 + r3;
        return;
    L9:
        throw new IllegalArgumentException("payload size must be >= 0: " + r3);
    }

    private int tryReadBinaryHeader(byte r1) {
        switch(r1) {
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

    private int tryReadStringHeader(byte r1) {
        switch(r1) {
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

    private static MessagePackException unexpected(String r5, byte r6) {
        MessageFormat r0 = MessageFormat.valueOf(r6);
        if (r0 == MessageFormat.NEVER_USED) goto L5;
        String r1 = r0.getValueType().name();
        return new MessageTypeException(String.format("Expected %s, but got %s (%02x)", new Object[]{r5, r1.substring(0, 1) + r1.substring(1).toLowerCase(), Byte.valueOf(r6)}));
    L5:
        return new MessageNeverUsedFormatException(String.format("Expected %s, but encountered 0xC1 \"NEVER_USED\" byte", new Object[]{r5}));
    }

    private static MessagePackException unexpectedExtension(String r3, int r4, int r5) {
        return new MessageTypeException(String.format("Expected extension type %s (%d), but got extension type %d", new Object[]{r3, Integer.valueOf(r4), Integer.valueOf(r5)}));
    }

    private static int utf8MultibyteCharacterSize(byte r0) {
        return Integer.numberOfLeadingZeros((~(r0 & 255)) << 24);
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

    public void readPayload(ByteBuffer r4) {
    L2:
        int r0 = r4.remaining();
        int r1 = this.buffer.size();
        int r2 = this.position;
        int r3 = r1 - r2;
        if (r3 >= r0) goto L4;
        this.buffer.getBytes(r2, r3, r4);
        this.position += r3;
        nextBuffer();
        goto L2
    L4:
        this.buffer.getBytes(r2, r0, r4);
        this.position += r0;
    }

    public void readPayload(MessageBuffer r4, int r5, int r6) {
    L2:
        int r0 = this.buffer.size();
        int r1 = this.position;
        int r2 = r0 - r1;
        if (r2 >= r6) goto L4;
        r4.putMessageBuffer(r5, this.buffer, r1, r2);
        r5 = r5 + r2;
        r6 = r6 - r2;
        this.position += r2;
        nextBuffer();
        goto L2
    L4:
        r4.putMessageBuffer(r5, this.buffer, r1, r6);
        this.position += r6;
    }

    public void readPayload(byte[] r3) {
        readPayload(r3, 0, r3.length);
    }

    public void readPayload(byte[] r4, int r5, int r6) {
    L2:
        int r0 = this.buffer.size();
        int r1 = this.position;
        int r2 = r0 - r1;
        if (r2 >= r6) goto L4;
        this.buffer.getBytes(r1, r4, r5, r2);
        r5 = r5 + r2;
        r6 = r6 - r2;
        this.position += r2;
        nextBuffer();
        goto L2
    L4:
        this.buffer.getBytes(r1, r4, r5, r6);
        this.position += r6;
    }

    public byte[] readPayload(int r1) {
        byte[] r2 = new byte[r1];
        readPayload(r2);
        return r2;
    }

    public MessageBuffer readPayloadAsReference(int r3) {
        int r0 = this.buffer.size();
        int r1 = this.position;
        if ((r0 - r1) < r3) goto L6;
        MessageBuffer r2 = this.buffer.slice(r1, r3);
        this.position += r3;
        return r2;
    L6:
        MessageBuffer r4 = MessageBuffer.allocate(r3);
        readPayload(r4, 0, r3);
        return r4;
    }

    public MessageBufferInput reset(MessageBufferInput r4) {
        MessageBufferInput r5 = (MessageBufferInput) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull((MessageBufferInput) ZeusTransformUtils.wrapperContextForParams(r4, MessageBufferInput.class, "com.obric.memorydata.plugin"), "MessageBufferInput is null"), MessageBufferInput.class, "com.obric.memorydata.plugin");
        MessageBufferInput r0 = this.in;
        this.in = r5;
        this.buffer = EMPTY_BUFFER;
        this.position = 0;
        this.totalReadBytes = 0;
        return r0;
    }

    public void skipValue() {
        skipValue(1);
    }

    public void skipValue(int r5) {
    L2:
        if (r5 <= 0) goto L34;
        byte r0 = readByte();
        switch(AnonymousClass1.$SwitchMap$org$msgpack$core$MessageFormat[MessageFormat.valueOf(r0).ordinal()]) {
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
        int r1 = readNextLength32();
    L31:
        int r2 = r1 * 2;
    L32:
        r5 = r5 + r2;
        goto L33
    L9:
        r1 = readNextLength16();
        goto L31
    L10:
        r2 = readNextLength32();
        goto L32
    L11:
        r2 = readNextLength16();
        goto L32
    L12:
        int r3 = readNextLength32();
        skipPayload(1);
    L28:
        skipPayload(r3);
        goto L33
    L13:
        int r4 = readNextLength16();
    L15:
        r3 = r4 + 1;
        goto L28
    L14:
        r4 = readNextLength8();
        goto L15
    L16:
        r3 = 17;
        goto L28
    L17:
        r3 = 9;
        goto L28
    L18:
        r3 = 5;
        goto L28
    L19:
        r3 = 3;
        goto L28
    L20:
        r3 = readNextLength32();
        goto L28
    L21:
        r3 = readNextLength16();
        goto L28
    L22:
        r3 = readNextLength8();
        goto L28
    L23:
        r3 = 8;
        goto L28
    L24:
        r3 = 4;
        goto L28
    L25:
        skipPayload(2);
        goto L33
    L26:
        skipPayload(1);
        goto L33
    L27:
        r3 = r0 & 31;
        goto L28
    L29:
        r2 = r0 & 15;
        goto L32
    L30:
        r1 = r0 & 15;
        goto L31
    L7:
        throw new MessageNeverUsedFormatException("Encountered 0xC1 \"NEVER_USED\" byte");
    L33:
        r5 = r5 - 1;
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
        byte r0 = readByte();
        if (MessagePack.Code.isFixedArray(r0) == false) goto L7;
        return r0 & 15;
    L7:
        if (r0 == (-36)) goto L15;
        if (r0 != (-35)) goto L13;
        return readNextLength32();
    L13:
        throw unexpected("Array", r0);
    L15:
        return readNextLength16();
    }

    public BigInteger unpackBigInteger() {
        byte r0 = readByte();
        if (MessagePack.Code.isFixInt(r0) == true) goto L5;
        switch(r0) {
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
        long r1 = readLong();
        if (r1 >= 0) goto L22;
        return BigInteger.valueOf((r1 + Long.MAX_VALUE) + 1).setBit(63);
    L22:
        return BigInteger.valueOf(r1);
    L23:
        int r4 = readInt();
        if (r4 >= 0) goto L28;
        return BigInteger.valueOf(((long) (r4 & Integer.MAX_VALUE)) + 2147483648L);
    L28:
        return BigInteger.valueOf(r4);
    L8:
        throw unexpected("Integer", r0);
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
        return BigInteger.valueOf(r0);
    }

    public int unpackBinaryHeader() {
        byte r0 = readByte();
        if (MessagePack.Code.isFixedRaw(r0) == true) goto L5;
        int r1 = tryReadBinaryHeader(r0);
        if (r1 < 0) goto L10;
        return r1;
    L10:
        if (this.allowReadingStringAsBinary == false) goto L15;
        int r2 = tryReadStringHeader(r0);
        if (r2 < 0) goto L15;
        return r2;
    L15:
        throw unexpected("Binary", r0);
    L5:
        return r0 & 31;
    }

    public boolean unpackBoolean() {
        byte r1 = readByte();
        if (r1 != (-62)) goto L7;
        return false;
    L7:
        if (r1 != (-61)) goto L11;
        return true;
    L11:
        throw unexpected(TypedValues.Custom.S_BOOLEAN, r1);
    }

    public byte unpackByte() {
        byte r0 = readByte();
        if (MessagePack.Code.isFixInt(r0) == false) goto L6;
        return r0;
    L6:
        switch(r0) {
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
        long r3 = readLong();
        if (r3 < (-128)) goto L16;
        if (r3 > 127) goto L16;
    L14:
        return (byte) r3;
    L16:
        throw overflowI64(r3);
    L17:
        int r7 = readInt();
        if (r7 < (-128)) goto L23;
        if (r7 > 127) goto L23;
        return (byte) r7;
    L23:
        throw overflowI32(r7);
    L24:
        short r8 = readShort();
        if (r8 < (-128)) goto L30;
        if (r8 > 127) goto L30;
        return (byte) r8;
    L30:
        throw overflowI16(r8);
    L33:
        r3 = readLong();
        if (r3 < 0) goto L39;
        if (r3 <= 127) goto L14;
    L39:
        throw overflowU64(r3);
    L40:
        int r9 = readInt();
        if (r9 < 0) goto L46;
        if (r9 > 127) goto L46;
        return (byte) r9;
    L46:
        throw overflowU32(r9);
    L47:
        short r10 = readShort();
        if (r10 < 0) goto L53;
        if (r10 > 127) goto L53;
        return (byte) r10;
    L53:
        throw overflowU16(r10);
    L54:
        byte r11 = readByte();
        if (r11 < 0) goto L58;
        return r11;
    L58:
        throw overflowU8(r11);
    L8:
        throw unexpected("Integer", r0);
    L32:
        return readByte();
    }

    public double unpackDouble() {
        byte r0 = readByte();
        if (r0 == (-54)) goto L11;
        if (r0 != (-53)) goto L9;
        return readDouble();
    L9:
        throw unexpected("Float", r0);
    L11:
        return readFloat();
    }

    public ExtensionTypeHeader unpackExtensionTypeHeader() {
        byte r0 = readByte();
        switch(r0) {
            case -57: goto L25;
            case -56: goto L23;
            case -55: goto L17;
            default: goto L4;
        };
    L4:
        switch(r0) {
            case -44: goto L16;
            case -43: goto L14;
            case -42: goto L12;
            case -41: goto L10;
            case -40: goto L8;
            default: goto L6;
        };
    L6:
        throw unexpected("Ext", r0);
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
        MessageBuffer r1 = prepareNumberBuffer(5);
        int r2 = r1.getInt(this.nextReadPosition);
        if (r2 < 0) goto L22;
        return new ExtensionTypeHeader(r1.getByte(this.nextReadPosition + 4), r2);
    L22:
        throw overflowU32Size(r2);
    L23:
        MessageBuffer r3 = prepareNumberBuffer(3);
        int r4 = r3.getShort(this.nextReadPosition) & UShort.MAX_VALUE;
        return new ExtensionTypeHeader(r3.getByte(this.nextReadPosition + 2), r4);
    L25:
        MessageBuffer r5 = prepareNumberBuffer(2);
        int r6 = r5.getByte(this.nextReadPosition) & 255;
        return new ExtensionTypeHeader(r5.getByte(this.nextReadPosition + 1), r6);
    }

    public float unpackFloat() {
        byte r0 = readByte();
        if (r0 == (-54)) goto L11;
        if (r0 != (-53)) goto L9;
        return (float) readDouble();
    L9:
        throw unexpected("Float", r0);
    L11:
        return readFloat();
    }

    public int unpackInt() {
        byte r0 = readByte();
        if (MessagePack.Code.isFixInt(r0) == false) goto L6;
        return r0;
    L6:
        switch(r0) {
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
        long r3 = readLong();
        if (r3 < (-2147483648L)) goto L16;
        if (r3 > 2147483647L) goto L16;
        return (int) r3;
    L16:
        throw overflowI64(r3);
    L23:
        long r4 = readLong();
        if (r4 < 0) goto L30;
        if (r4 > 2147483647L) goto L30;
        return (int) r4;
    L30:
        throw overflowU64(r4);
    L31:
        int r7 = readInt();
        if (r7 < 0) goto L35;
        return r7;
    L35:
        throw overflowU32(r7);
    L8:
        throw unexpected("Integer", r0);
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
        byte r0 = readByte();
        if (MessagePack.Code.isFixInt(r0) == true) goto L5;
        switch(r0) {
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
        long r1 = readLong();
        if (r1 < 0) goto L21;
        return r1;
    L21:
        throw overflowU64(r1);
    L22:
        int r4 = readInt();
        if (r4 >= 0) goto L27;
        return ((long) (r4 & Integer.MAX_VALUE)) + 2147483648L;
    L27:
        return r4;
    L8:
        throw unexpected("Integer", r0);
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
        return r0;
    }

    public int unpackMapHeader() {
        byte r0 = readByte();
        if (MessagePack.Code.isFixedMap(r0) == false) goto L7;
        return r0 & 15;
    L7:
        if (r0 == (-34)) goto L15;
        if (r0 != (-33)) goto L13;
        return readNextLength32();
    L13:
        throw unexpected("Map", r0);
    L15:
        return readNextLength16();
    }

    public void unpackNil() {
        byte r1 = readByte();
        if (r1 != (-64)) goto L6;
        return;
    L6:
        throw unexpected("Nil", r1);
    }

    public int unpackRawStringHeader() {
        byte r0 = readByte();
        if (MessagePack.Code.isFixedRaw(r0) == true) goto L5;
        int r1 = tryReadStringHeader(r0);
        if (r1 < 0) goto L10;
        return r1;
    L10:
        if (this.allowReadingBinaryAsString == false) goto L15;
        int r2 = tryReadBinaryHeader(r0);
        if (r2 < 0) goto L15;
        return r2;
    L15:
        throw unexpected("String", r0);
    L5:
        return r0 & 31;
    }

    public short unpackShort() {
        byte r0 = readByte();
        if (MessagePack.Code.isFixInt(r0) == false) goto L7;
        return r0;
    L7:
        switch(r0) {
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
        long r3 = readLong();
        if (r3 < (-32768)) goto L18;
        if (r3 > 32767) goto L18;
    L14:
        int r7 = (int) r3;
    L16:
        return (short) r7;
    L18:
        throw overflowI64(r3);
    L19:
        int r8 = readInt();
        if (r8 < (-32768)) goto L25;
        if (r8 > 32767) goto L25;
        return (short) r8;
    L25:
        throw overflowI32(r8);
    L28:
        r7 = readByte();
        goto L16
    L29:
        r3 = readLong();
        if (r3 < 0) goto L35;
        if (r3 <= 32767) goto L14;
    L35:
        throw overflowU64(r3);
    L36:
        int r9 = readInt();
        if (r9 < 0) goto L42;
        if (r9 > 32767) goto L42;
        return (short) r9;
    L42:
        throw overflowU32(r9);
    L43:
        short r10 = readShort();
        if (r10 < 0) goto L47;
        return r10;
    L47:
        throw overflowU16(r10);
    L48:
        r7 = readByte() & 255;
        goto L16
    L9:
        throw unexpected("Integer", r0);
    L27:
        return readShort();
    }

    public String unpackString() {
        int r1 = unpackRawStringHeader();
        if (r1 != 0) goto L7;
        return "";
    L7:
        if (r1 > this.stringSizeLimit) goto L50;
        resetDecoder();
        if ((this.buffer.size() - this.position) >= r1) goto L11;
    L12:
        if (r1 <= 0) goto L45;
        int r2 = this.buffer.size();     // Catch: CharacterCodingException -> L46
        int r4 = this.position;     // Catch: CharacterCodingException -> L46
        int r3 = r2 - r4;     // Catch: CharacterCodingException -> L46
        if (r3 >= r1) goto L15;
        if (r3 == 0) goto L17;
        ByteBuffer r5 = this.buffer.sliceAsByteBuffer(r4, r3);     // Catch: CharacterCodingException -> L46
        int r6 = r5.position();     // Catch: CharacterCodingException -> L46
        this.decodeBuffer.clear();     // Catch: CharacterCodingException -> L46
        CoderResult r7 = this.decoder.decode(r5, this.decodeBuffer, false);     // Catch: CharacterCodingException -> L46
        int r8 = r5.position() - r6;     // Catch: CharacterCodingException -> L46
        this.position += r8;     // Catch: CharacterCodingException -> L46
        r1 = r1 - r8;     // Catch: CharacterCodingException -> L46
        this.decodeStringBuffer.append(this.decodeBuffer.flip());     // Catch: CharacterCodingException -> L46
        if (r7.isError() == false) goto L22;
        handleCoderError(r7);     // Catch: CharacterCodingException -> L46
    L22:
        if (r7.isUnderflow() == false) goto L12;
        if (r8 >= r3) goto L12;
        ByteBuffer r9 = ByteBuffer.allocate(utf8MultibyteCharacterSize(this.buffer.getByte(this.position)));     // Catch: CharacterCodingException -> L46
        MessageBuffer r10 = this.buffer;     // Catch: CharacterCodingException -> L46
        r10.getBytes(this.position, r10.size() - this.position, r9);     // Catch: CharacterCodingException -> L46
    L25:
        nextBuffer();     // Catch: CharacterCodingException -> L46
        int r11 = r9.remaining();     // Catch: CharacterCodingException -> L46
        if (this.buffer.size() >= r11) goto L27;
        MessageBuffer r12 = this.buffer;     // Catch: CharacterCodingException -> L46
        r12.getBytes(0, r12.size(), r9);     // Catch: CharacterCodingException -> L46
        this.position = this.buffer.size();     // Catch: CharacterCodingException -> L46
        goto L25
    L27:
        this.buffer.getBytes(0, r11, r9);     // Catch: CharacterCodingException -> L46
        this.position = r11;     // Catch: CharacterCodingException -> L46
        r9.position(0);     // Catch: CharacterCodingException -> L46
        this.decodeBuffer.clear();     // Catch: CharacterCodingException -> L46
        CoderResult r13 = this.decoder.decode(r9, this.decodeBuffer, false);     // Catch: CharacterCodingException -> L46
        if (r13.isError() == false) goto L31;
        handleCoderError(r13);     // Catch: CharacterCodingException -> L46
    L31:
        if (r13.isOverflow() == false) goto L33;
    L51:
        r13.throwException();     // Catch: Exception -> L40 CharacterCodingException -> L46
        throw new MessageFormatException("Unexpected UTF-8 multibyte sequence");     // Catch: Exception -> L40 CharacterCodingException -> L46
    L40:
        e = move-exception;
        throw new MessageFormatException("Unexpected UTF-8 multibyte sequence", e);     // Catch: CharacterCodingException -> L46
    L33:
        if (r13.isUnderflow() == true) goto L35;
    L36:
        r1 = r1 - r9.limit();     // Catch: CharacterCodingException -> L46
        this.decodeStringBuffer.append(this.decodeBuffer.flip());     // Catch: CharacterCodingException -> L46
        goto L12
    L35:
        if (r9.position() < r9.limit()) goto L51;
    L17:
        nextBuffer();     // Catch: CharacterCodingException -> L46
        goto L12
    L15:
        this.decodeStringBuffer.append(decodeStringFastPath(r1));     // Catch: CharacterCodingException -> L46
    L46:
        e = move-exception;
        throw new MessageStringCodingException(e);
    L45:
        return this.decodeStringBuffer.toString();
    L11:
        return decodeStringFastPath(r1);
    L50:
        throw new MessageSizeException(String.format("cannot unpack a String of size larger than %,d: %,d", new Object[]{Integer.valueOf(this.stringSizeLimit), Integer.valueOf(r1)}), r1);
    }

    public Instant unpackTimestamp() {
        return unpackTimestamp(unpackExtensionTypeHeader());
    }

    public Instant unpackTimestamp(ExtensionTypeHeader r6) {
        if (r6.getType() != (-1)) goto L19;
        int r0 = r6.getLength();
        if (r0 == 4) goto L17;
        if (r0 != 8) goto L9;
        long r5 = readLong();
        return Instant.ofEpochSecond(r5 & 17179869183L, (int) (r5 >>> 34));
    L9:
        if (r0 != 12) goto L13;
        return Instant.ofEpochSecond(readLong(), ((long) readInt()) & 4294967295L);
    L13:
        throw new MessageFormatException(String.format("Timestamp extension type (%d) expects 4, 8, or 12 bytes of payload but got %d bytes", new Object[]{(byte) -1, Integer.valueOf(r6.getLength())}));
    L17:
        return Instant.ofEpochSecond(((long) readInt()) & 4294967295L);
    L19:
        throw unexpectedExtension("Timestamp", -1, r6.getType());
    }

    public ImmutableValue unpackValue() {
        MessageFormat r0 = getNextFormat();
        int r3 = 0;
        switch(AnonymousClass1.$SwitchMap$org$msgpack$value$ValueType[r0.getValueType().ordinal()]) {
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
        ExtensionTypeHeader r1 = unpackExtensionTypeHeader();
        if (r1.getType() == (-1)) goto L11;
        return ValueFactory.newExtension(r1.getType(), readPayload(r1.getLength()));
    L11:
        return ValueFactory.newTimestamp(unpackTimestamp(r1));
    L12:
        int r2 = unpackMapHeader() * 2;
        Value[] r4 = new Value[r2];
    L13:
        if (r3 >= r2) goto L16;
        r4[r3] = unpackValue();
        int r5 = r3 + 1;
        r4[r5] = unpackValue();
        r3 = r5 + 1;
        goto L13
    L16:
        return ValueFactory.newMap(r4, true);
    L17:
        int r6 = unpackArrayHeader();
        Value[] r7 = new Value[r6];
    L18:
        if (r3 >= r6) goto L21;
        r7[r3] = unpackValue();
        r3 = r3 + 1;
        goto L18
    L21:
        return ValueFactory.newArray(r7, true);
    L24:
        int r8 = unpackRawStringHeader();
        if (r8 > this.stringSizeLimit) goto L29;
        return ValueFactory.newString(readPayload(r8), true);
    L29:
        throw new MessageSizeException(String.format("cannot unpack a String of size larger than %,d: %,d", new Object[]{Integer.valueOf(this.stringSizeLimit), Integer.valueOf(r8)}), r8);
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
        if (r0 != MessageFormat.UINT64) goto L37;
        return ValueFactory.newInteger(unpackBigInteger());
    L37:
        return ValueFactory.newInteger(unpackLong());
    L39:
        return ValueFactory.newBoolean(unpackBoolean());
    }

    public Variable unpackValue(Variable r6) {
        MessageFormat r0 = getNextFormat();
        int r3 = 0;
        switch(AnonymousClass1.$SwitchMap$org$msgpack$value$ValueType[r0.getValueType().ordinal()]) {
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
        ExtensionTypeHeader r1 = unpackExtensionTypeHeader();
        if (r1.getType() == (-1)) goto L9;
        r6.setExtensionValue(r1.getType(), readPayload(r1.getLength()));
    L10:
        return r6;
    L9:
        r6.setTimestampValue(unpackTimestamp(r1));
        goto L10
    L11:
        int r2 = unpackMapHeader() * 2;
        Value[] r4 = new Value[r2];
    L12:
        if (r3 >= r2) goto L14;
        r4[r3] = unpackValue();
        int r5 = r3 + 1;
        r4[r5] = unpackValue();
        r3 = r5 + 1;
        goto L12
    L14:
        r6.setMapValue(r4);
        return r6;
    L16:
        int r7 = unpackArrayHeader();
        Value[] r8 = new Value[r7];
    L17:
        if (r3 >= r7) goto L19;
        r8[r3] = unpackValue();
        r3 = r3 + 1;
        goto L17
    L19:
        r6.setArrayValue(r8);
        return r6;
    L21:
        r6.setBinaryValue(readPayload(unpackBinaryHeader()));
        return r6;
    L23:
        int r9 = unpackRawStringHeader();
        if (r9 > this.stringSizeLimit) goto L28;
        r6.setStringValue(readPayload(r9));
        return r6;
    L28:
        throw new MessageSizeException(String.format("cannot unpack a String of size larger than %,d: %,d", new Object[]{Integer.valueOf(this.stringSizeLimit), Integer.valueOf(r9)}), r9);
    L29:
        r6.setFloatValue(unpackDouble());
        return r6;
    L37:
        r6.setBooleanValue(unpackBoolean());
        return r6;
    L39:
        readByte();
        r6.setNilValue();
        return r6;
    L5:
        throw new MessageFormatException("Unknown value type");
    L32:
        if (AnonymousClass1.$SwitchMap$org$msgpack$core$MessageFormat[r0.ordinal()] == 16) goto L35;
        r6.setIntegerValue(unpackLong());
        return r6;
    L35:
        r6.setIntegerValue(unpackBigInteger());
        return r6;
    }
}
