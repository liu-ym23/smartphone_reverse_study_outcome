package org.msgpack.core;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import org.msgpack.core.buffer.ArrayBufferInput;
import org.msgpack.core.buffer.ByteBufferInput;
import org.msgpack.core.buffer.ChannelBufferInput;
import org.msgpack.core.buffer.ChannelBufferOutput;
import org.msgpack.core.buffer.InputStreamBufferInput;
import org.msgpack.core.buffer.MessageBufferInput;
import org.msgpack.core.buffer.MessageBufferOutput;
import org.msgpack.core.buffer.OutputStreamBufferOutput;

/* JADX INFO: loaded from: classes3.dex */
public class MessagePack {
    public static final PackerConfig DEFAULT_PACKER_CONFIG = null;
    public static final UnpackerConfig DEFAULT_UNPACKER_CONFIG = null;
    public static final Charset UTF8 = null;

    public static final class Code {
        public static final byte ARRAY16 = -36;
        public static final byte ARRAY32 = -35;
        public static final byte BIN16 = -59;
        public static final byte BIN32 = -58;
        public static final byte BIN8 = -60;
        public static final byte EXT16 = -56;
        public static final byte EXT32 = -55;
        public static final byte EXT8 = -57;
        public static final byte EXT_TIMESTAMP = -1;
        public static final byte FALSE = -62;
        public static final byte FIXARRAY_PREFIX = -112;
        public static final byte FIXEXT1 = -44;
        public static final byte FIXEXT16 = -40;
        public static final byte FIXEXT2 = -43;
        public static final byte FIXEXT4 = -42;
        public static final byte FIXEXT8 = -41;
        public static final byte FIXMAP_PREFIX = -128;
        public static final byte FIXSTR_PREFIX = -96;
        public static final byte FLOAT32 = -54;
        public static final byte FLOAT64 = -53;
        public static final byte INT16 = -47;
        public static final byte INT32 = -46;
        public static final byte INT64 = -45;
        public static final byte INT8 = -48;
        public static final byte MAP16 = -34;
        public static final byte MAP32 = -33;
        public static final byte NEGFIXINT_PREFIX = -32;
        public static final byte NEVER_USED = -63;
        public static final byte NIL = -64;
        public static final byte POSFIXINT_MASK = -128;
        public static final byte STR16 = -38;
        public static final byte STR32 = -37;
        public static final byte STR8 = -39;
        public static final byte TRUE = -61;
        public static final byte UINT16 = -51;
        public static final byte UINT32 = -50;
        public static final byte UINT64 = -49;
        public static final byte UINT8 = -52;

        public Code() {
        }

        public static final boolean isFixInt(byte r10) {
            int r11 = r10 & 255;
            if (r11 > 127) goto L5;
        L8:
            return true;
        L5:
            if (r11 >= 224) goto L8;
            return false;
        }

        public static final boolean isFixStr(byte r10) {
            if ((r10 & NEGFIXINT_PREFIX) != (-96)) goto L5;
            return true;
        L5:
            return false;
        }

        public static final boolean isFixedArray(byte r10) {
            if ((r10 & (-16)) != (-112)) goto L5;
            return true;
        L5:
            return false;
        }

        public static final boolean isFixedMap(byte r10) {
            if ((r10 & (-16)) != (-128)) goto L5;
            return true;
        L5:
            return false;
        }

        public static final boolean isFixedRaw(byte r10) {
            if ((r10 & NEGFIXINT_PREFIX) != (-96)) goto L5;
            return true;
        L5:
            return false;
        }

        public static final boolean isNegFixInt(byte r10) {
            if ((r10 & NEGFIXINT_PREFIX) != (-32)) goto L5;
            return true;
        L5:
            return false;
        }

        public static final boolean isPosFixInt(byte r10) {
            if ((r10 & (-128)) != 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static class PackerConfig implements Cloneable {
        private int bufferFlushThreshold;
        private int bufferSize;
        private int smallStringOptimizationThreshold;
        private boolean str8FormatSupport;

        public PackerConfig() {
            this.smallStringOptimizationThreshold = 512;
            this.bufferFlushThreshold = 8192;
            this.bufferSize = 8192;
            this.str8FormatSupport = true;
        }

        private PackerConfig(PackerConfig r10) {
            this.smallStringOptimizationThreshold = 512;
            this.bufferFlushThreshold = 8192;
            this.bufferSize = 8192;
            this.str8FormatSupport = true;
            this.smallStringOptimizationThreshold = r10.smallStringOptimizationThreshold;
            this.bufferFlushThreshold = r10.bufferFlushThreshold;
            this.bufferSize = r10.bufferSize;
            this.str8FormatSupport = r10.str8FormatSupport;
        }

        public /* bridge */ /* synthetic */ Object clone() {
            return m1553clone();
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public PackerConfig m1553clone() {
            return new PackerConfig(this);
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof PackerConfig) == true) goto L5;
            return false;
        L5:
            PackerConfig r11 = (PackerConfig) r10;
            if (this.smallStringOptimizationThreshold == r11.smallStringOptimizationThreshold) goto L8;
            return false;
        L8:
            if (this.bufferFlushThreshold == r11.bufferFlushThreshold) goto L10;
            return false;
        L10:
            if (this.bufferSize == r11.bufferSize) goto L12;
            return false;
        L12:
            if (this.str8FormatSupport != r11.str8FormatSupport) goto L18;
            return true;
        L18:
            return false;
        }

        public int getBufferFlushThreshold() {
            return this.bufferFlushThreshold;
        }

        public int getBufferSize() {
            return this.bufferSize;
        }

        public int getSmallStringOptimizationThreshold() {
            return this.smallStringOptimizationThreshold;
        }

        public int hashCode() {
            return (((((this.smallStringOptimizationThreshold * 31) + this.bufferFlushThreshold) * 31) + this.bufferSize) * 31) + (this.str8FormatSupport ? 1 : 0);
        }

        public boolean isStr8FormatSupport() {
            return this.str8FormatSupport;
        }

        public MessageBufferPacker newBufferPacker() {
            return new MessageBufferPacker(this);
        }

        public MessagePacker newPacker(OutputStream r10) {
            return newPacker(new OutputStreamBufferOutput(r10, this.bufferSize));
        }

        public MessagePacker newPacker(WritableByteChannel r10) {
            return newPacker(new ChannelBufferOutput(r10, this.bufferSize));
        }

        public MessagePacker newPacker(MessageBufferOutput r10) {
            return new MessagePacker(r10, this);
        }

        public PackerConfig withBufferFlushThreshold(int r10) {
            PackerConfig r11 = m1553clone();
            r11.bufferFlushThreshold = r10;
            return r11;
        }

        public PackerConfig withBufferSize(int r10) {
            PackerConfig r11 = m1553clone();
            r11.bufferSize = r10;
            return r11;
        }

        public PackerConfig withSmallStringOptimizationThreshold(int r10) {
            PackerConfig r11 = m1553clone();
            r11.smallStringOptimizationThreshold = r10;
            return r11;
        }

        public PackerConfig withStr8FormatSupport(boolean r10) {
            PackerConfig r11 = m1553clone();
            r11.str8FormatSupport = r10;
            return r11;
        }
    }

    public static class UnpackerConfig implements Cloneable {
        private CodingErrorAction actionOnMalformedString;
        private CodingErrorAction actionOnUnmappableString;
        private boolean allowReadingBinaryAsString;
        private boolean allowReadingStringAsBinary;
        private int bufferSize;
        private int stringDecoderBufferSize;
        private int stringSizeLimit;

        public UnpackerConfig() {
            this.allowReadingStringAsBinary = true;
            this.allowReadingBinaryAsString = true;
            CodingErrorAction r10 = CodingErrorAction.REPLACE;
            this.actionOnMalformedString = r10;
            this.actionOnUnmappableString = r10;
            this.stringSizeLimit = Integer.MAX_VALUE;
            this.bufferSize = 8192;
            this.stringDecoderBufferSize = 8192;
        }

        private UnpackerConfig(UnpackerConfig r10) {
            this.allowReadingStringAsBinary = true;
            this.allowReadingBinaryAsString = true;
            CodingErrorAction r11 = CodingErrorAction.REPLACE;
            this.actionOnMalformedString = r11;
            this.actionOnUnmappableString = r11;
            this.stringSizeLimit = Integer.MAX_VALUE;
            this.bufferSize = 8192;
            this.stringDecoderBufferSize = 8192;
            this.allowReadingStringAsBinary = r10.allowReadingStringAsBinary;
            this.allowReadingBinaryAsString = r10.allowReadingBinaryAsString;
            this.actionOnMalformedString = r10.actionOnMalformedString;
            this.actionOnUnmappableString = r10.actionOnUnmappableString;
            this.stringSizeLimit = r10.stringSizeLimit;
            this.bufferSize = r10.bufferSize;
        }

        public /* bridge */ /* synthetic */ Object clone() {
            return m1554clone();
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public UnpackerConfig m1554clone() {
            return new UnpackerConfig(this);
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof UnpackerConfig) == true) goto L5;
            return false;
        L5:
            UnpackerConfig r11 = (UnpackerConfig) r10;
            if (this.allowReadingStringAsBinary == r11.allowReadingStringAsBinary) goto L8;
            return false;
        L8:
            if (this.allowReadingBinaryAsString == r11.allowReadingBinaryAsString) goto L10;
            return false;
        L10:
            if (this.actionOnMalformedString == r11.actionOnMalformedString) goto L12;
            return false;
        L12:
            if (this.actionOnUnmappableString == r11.actionOnUnmappableString) goto L14;
            return false;
        L14:
            if (this.stringSizeLimit == r11.stringSizeLimit) goto L16;
            return false;
        L16:
            if (this.stringDecoderBufferSize == r11.stringDecoderBufferSize) goto L18;
            return false;
        L18:
            if (this.bufferSize != r11.bufferSize) goto L27;
            return true;
        L27:
            return false;
        }

        public CodingErrorAction getActionOnMalformedString() {
            return this.actionOnMalformedString;
        }

        public CodingErrorAction getActionOnUnmappableString() {
            return this.actionOnUnmappableString;
        }

        public boolean getAllowReadingBinaryAsString() {
            return this.allowReadingBinaryAsString;
        }

        public boolean getAllowReadingStringAsBinary() {
            return this.allowReadingStringAsBinary;
        }

        public int getBufferSize() {
            return this.bufferSize;
        }

        public int getStringDecoderBufferSize() {
            return this.stringDecoderBufferSize;
        }

        public int getStringSizeLimit() {
            return this.stringSizeLimit;
        }

        public int hashCode() {
            int r10 = (((this.allowReadingStringAsBinary ? 1 : 0) * 31) + (this.allowReadingBinaryAsString ? 1 : 0)) * 31;
            CodingErrorAction r11 = this.actionOnMalformedString;
            int r12 = 0;
            if (r11 == null) goto L5;
            int r13 = r11.hashCode();
        L6:
            int r14 = (r10 + r13) * 31;
            CodingErrorAction r15 = this.actionOnUnmappableString;
            if (r15 == null) goto L10;
            r12 = r15.hashCode();
        L10:
            return ((((((r14 + r12) * 31) + this.stringSizeLimit) * 31) + this.bufferSize) * 31) + this.stringDecoderBufferSize;
        L5:
            r13 = 0;
            goto L6
        }

        public MessageUnpacker newUnpacker(InputStream r10) {
            return newUnpacker(new InputStreamBufferInput(r10, this.bufferSize));
        }

        public MessageUnpacker newUnpacker(ByteBuffer r10) {
            return newUnpacker(new ByteBufferInput(r10));
        }

        public MessageUnpacker newUnpacker(ReadableByteChannel r10) {
            return newUnpacker(new ChannelBufferInput(r10, this.bufferSize));
        }

        public MessageUnpacker newUnpacker(MessageBufferInput r10) {
            return new MessageUnpacker(r10, this);
        }

        public MessageUnpacker newUnpacker(byte[] r10) {
            return newUnpacker(new ArrayBufferInput(r10));
        }

        public MessageUnpacker newUnpacker(byte[] r10, int r11, int r12) {
            return newUnpacker(new ArrayBufferInput(r10, r11, r12));
        }

        public UnpackerConfig withActionOnMalformedString(CodingErrorAction r10) {
            UnpackerConfig r11 = m1554clone();
            r11.actionOnMalformedString = r10;
            return r11;
        }

        public UnpackerConfig withActionOnUnmappableString(CodingErrorAction r10) {
            UnpackerConfig r11 = m1554clone();
            r11.actionOnUnmappableString = r10;
            return r11;
        }

        public UnpackerConfig withAllowReadingBinaryAsString(boolean r10) {
            UnpackerConfig r11 = m1554clone();
            r11.allowReadingBinaryAsString = r10;
            return r11;
        }

        public UnpackerConfig withAllowReadingStringAsBinary(boolean r10) {
            UnpackerConfig r11 = m1554clone();
            r11.allowReadingStringAsBinary = r10;
            return r11;
        }

        public UnpackerConfig withBufferSize(int r10) {
            UnpackerConfig r11 = m1554clone();
            r11.bufferSize = r10;
            return r11;
        }

        public UnpackerConfig withStringDecoderBufferSize(int r10) {
            UnpackerConfig r11 = m1554clone();
            r11.stringDecoderBufferSize = r10;
            return r11;
        }

        public UnpackerConfig withStringSizeLimit(int r10) {
            UnpackerConfig r11 = m1554clone();
            r11.stringSizeLimit = r10;
            return r11;
        }
    }

    static {
        UTF8 = Charset.forName("UTF-8");
        DEFAULT_PACKER_CONFIG = new PackerConfig();
        DEFAULT_UNPACKER_CONFIG = new UnpackerConfig();
    }

    private MessagePack() {
    }

    public static MessageBufferPacker newDefaultBufferPacker() {
        return DEFAULT_PACKER_CONFIG.newBufferPacker();
    }

    public static MessagePacker newDefaultPacker(OutputStream r10) {
        return DEFAULT_PACKER_CONFIG.newPacker(r10);
    }

    public static MessagePacker newDefaultPacker(WritableByteChannel r10) {
        return DEFAULT_PACKER_CONFIG.newPacker(r10);
    }

    public static MessagePacker newDefaultPacker(MessageBufferOutput r10) {
        return DEFAULT_PACKER_CONFIG.newPacker(r10);
    }

    public static MessageUnpacker newDefaultUnpacker(InputStream r10) {
        return DEFAULT_UNPACKER_CONFIG.newUnpacker(r10);
    }

    public static MessageUnpacker newDefaultUnpacker(ByteBuffer r10) {
        return DEFAULT_UNPACKER_CONFIG.newUnpacker(r10);
    }

    public static MessageUnpacker newDefaultUnpacker(ReadableByteChannel r10) {
        return DEFAULT_UNPACKER_CONFIG.newUnpacker(r10);
    }

    public static MessageUnpacker newDefaultUnpacker(MessageBufferInput r10) {
        return DEFAULT_UNPACKER_CONFIG.newUnpacker(r10);
    }

    public static MessageUnpacker newDefaultUnpacker(byte[] r10) {
        return DEFAULT_UNPACKER_CONFIG.newUnpacker(r10);
    }

    public static MessageUnpacker newDefaultUnpacker(byte[] r10, int r11, int r12) {
        return DEFAULT_UNPACKER_CONFIG.newUnpacker(r10, r11, r12);
    }
}
