package org.msgpack.core;

import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes7.dex */
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

        public static final boolean isFixInt(byte r1) {
            int r2 = r1 & 255;
            if (r2 > 127) goto L5;
        L8:
            return true;
        L5:
            if (r2 >= 224) goto L8;
            return false;
        }

        public static final boolean isFixStr(byte r1) {
            if ((r1 & NEGFIXINT_PREFIX) != (-96)) goto L5;
            return true;
        L5:
            return false;
        }

        public static final boolean isFixedArray(byte r1) {
            if ((r1 & (-16)) != (-112)) goto L5;
            return true;
        L5:
            return false;
        }

        public static final boolean isFixedMap(byte r1) {
            if ((r1 & (-16)) != (-128)) goto L5;
            return true;
        L5:
            return false;
        }

        public static final boolean isFixedRaw(byte r1) {
            if ((r1 & NEGFIXINT_PREFIX) != (-96)) goto L5;
            return true;
        L5:
            return false;
        }

        public static final boolean isNegFixInt(byte r1) {
            if ((r1 & NEGFIXINT_PREFIX) != (-32)) goto L5;
            return true;
        L5:
            return false;
        }

        public static final boolean isPosFixInt(byte r0) {
            if ((r0 & (-128)) != 0) goto L5;
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

        private PackerConfig(PackerConfig r2) {
            this.smallStringOptimizationThreshold = 512;
            this.bufferFlushThreshold = 8192;
            this.bufferSize = 8192;
            this.str8FormatSupport = true;
            this.smallStringOptimizationThreshold = r2.smallStringOptimizationThreshold;
            this.bufferFlushThreshold = r2.bufferFlushThreshold;
            this.bufferSize = r2.bufferSize;
            this.str8FormatSupport = r2.str8FormatSupport;
        }

        public /* bridge */ /* synthetic */ Object clone() {
            return m3207clone();
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public PackerConfig m3207clone() {
            return new PackerConfig(this);
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, PackerConfig.class) == true) goto L5;
            return false;
        L5:
            PackerConfig r5 = (PackerConfig) ZeusTransformUtils.preCheckCast(r4, PackerConfig.class, "com.obric.memorydata.plugin");
            if (this.smallStringOptimizationThreshold == r5.smallStringOptimizationThreshold) goto L8;
            return false;
        L8:
            if (this.bufferFlushThreshold == r5.bufferFlushThreshold) goto L10;
            return false;
        L10:
            if (this.bufferSize == r5.bufferSize) goto L12;
            return false;
        L12:
            if (this.str8FormatSupport != r5.str8FormatSupport) goto L18;
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

        public MessagePacker newPacker(OutputStream r3) {
            return newPacker(new OutputStreamBufferOutput(r3, this.bufferSize));
        }

        public MessagePacker newPacker(WritableByteChannel r3) {
            return newPacker(new ChannelBufferOutput((WritableByteChannel) ZeusTransformUtils.wrapperContextForParams(r3, WritableByteChannel.class, "com.obric.memorydata.plugin"), this.bufferSize));
        }

        public MessagePacker newPacker(MessageBufferOutput r3) {
            return new MessagePacker((MessageBufferOutput) ZeusTransformUtils.wrapperContextForParams(r3, MessageBufferOutput.class, "com.obric.memorydata.plugin"), this);
        }

        public PackerConfig withBufferFlushThreshold(int r1) {
            PackerConfig r0 = m3207clone();
            r0.bufferFlushThreshold = r1;
            return r0;
        }

        public PackerConfig withBufferSize(int r1) {
            PackerConfig r0 = m3207clone();
            r0.bufferSize = r1;
            return r0;
        }

        public PackerConfig withSmallStringOptimizationThreshold(int r1) {
            PackerConfig r0 = m3207clone();
            r0.smallStringOptimizationThreshold = r1;
            return r0;
        }

        public PackerConfig withStr8FormatSupport(boolean r1) {
            PackerConfig r0 = m3207clone();
            r0.str8FormatSupport = r1;
            return r0;
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
            this.actionOnMalformedString = CodingErrorAction.REPLACE;
            this.actionOnUnmappableString = CodingErrorAction.REPLACE;
            this.stringSizeLimit = Integer.MAX_VALUE;
            this.bufferSize = 8192;
            this.stringDecoderBufferSize = 8192;
        }

        private UnpackerConfig(UnpackerConfig r2) {
            this.allowReadingStringAsBinary = true;
            this.allowReadingBinaryAsString = true;
            this.actionOnMalformedString = CodingErrorAction.REPLACE;
            this.actionOnUnmappableString = CodingErrorAction.REPLACE;
            this.stringSizeLimit = Integer.MAX_VALUE;
            this.bufferSize = 8192;
            this.stringDecoderBufferSize = 8192;
            this.allowReadingStringAsBinary = r2.allowReadingStringAsBinary;
            this.allowReadingBinaryAsString = r2.allowReadingBinaryAsString;
            this.actionOnMalformedString = r2.actionOnMalformedString;
            this.actionOnUnmappableString = r2.actionOnUnmappableString;
            this.stringSizeLimit = r2.stringSizeLimit;
            this.bufferSize = r2.bufferSize;
        }

        public /* bridge */ /* synthetic */ Object clone() {
            return m3208clone();
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public UnpackerConfig m3208clone() {
            return new UnpackerConfig(this);
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, UnpackerConfig.class) == true) goto L5;
            return false;
        L5:
            UnpackerConfig r5 = (UnpackerConfig) ZeusTransformUtils.preCheckCast(r4, UnpackerConfig.class, "com.obric.memorydata.plugin");
            if (this.allowReadingStringAsBinary == r5.allowReadingStringAsBinary) goto L8;
            return false;
        L8:
            if (this.allowReadingBinaryAsString == r5.allowReadingBinaryAsString) goto L10;
            return false;
        L10:
            if (this.actionOnMalformedString == r5.actionOnMalformedString) goto L12;
            return false;
        L12:
            if (this.actionOnUnmappableString == r5.actionOnUnmappableString) goto L14;
            return false;
        L14:
            if (this.stringSizeLimit == r5.stringSizeLimit) goto L16;
            return false;
        L16:
            if (this.stringDecoderBufferSize == r5.stringDecoderBufferSize) goto L18;
            return false;
        L18:
            if (this.bufferSize != r5.bufferSize) goto L27;
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
            int r0 = (((this.allowReadingStringAsBinary ? 1 : 0) * 31) + (this.allowReadingBinaryAsString ? 1 : 0)) * 31;
            CodingErrorAction r1 = this.actionOnMalformedString;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            CodingErrorAction r5 = this.actionOnUnmappableString;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            return ((((((r4 + r2) * 31) + this.stringSizeLimit) * 31) + this.bufferSize) * 31) + this.stringDecoderBufferSize;
        L5:
            r3 = 0;
            goto L6
        }

        public MessageUnpacker newUnpacker(InputStream r3) {
            return newUnpacker(new InputStreamBufferInput(r3, this.bufferSize));
        }

        public MessageUnpacker newUnpacker(ByteBuffer r2) {
            return newUnpacker(new ByteBufferInput(r2));
        }

        public MessageUnpacker newUnpacker(ReadableByteChannel r3) {
            return newUnpacker(new ChannelBufferInput((ReadableByteChannel) ZeusTransformUtils.wrapperContextForParams(r3, ReadableByteChannel.class, "com.obric.memorydata.plugin"), this.bufferSize));
        }

        public MessageUnpacker newUnpacker(MessageBufferInput r3) {
            return new MessageUnpacker((MessageBufferInput) ZeusTransformUtils.wrapperContextForParams(r3, MessageBufferInput.class, "com.obric.memorydata.plugin"), this);
        }

        public MessageUnpacker newUnpacker(byte[] r2) {
            return newUnpacker(new ArrayBufferInput(r2));
        }

        public MessageUnpacker newUnpacker(byte[] r2, int r3, int r4) {
            return newUnpacker(new ArrayBufferInput(r2, r3, r4));
        }

        public UnpackerConfig withActionOnMalformedString(CodingErrorAction r1) {
            UnpackerConfig r0 = m3208clone();
            r0.actionOnMalformedString = r1;
            return r0;
        }

        public UnpackerConfig withActionOnUnmappableString(CodingErrorAction r1) {
            UnpackerConfig r0 = m3208clone();
            r0.actionOnUnmappableString = r1;
            return r0;
        }

        public UnpackerConfig withAllowReadingBinaryAsString(boolean r1) {
            UnpackerConfig r0 = m3208clone();
            r0.allowReadingBinaryAsString = r1;
            return r0;
        }

        public UnpackerConfig withAllowReadingStringAsBinary(boolean r1) {
            UnpackerConfig r0 = m3208clone();
            r0.allowReadingStringAsBinary = r1;
            return r0;
        }

        public UnpackerConfig withBufferSize(int r1) {
            UnpackerConfig r0 = m3208clone();
            r0.bufferSize = r1;
            return r0;
        }

        public UnpackerConfig withStringDecoderBufferSize(int r1) {
            UnpackerConfig r0 = m3208clone();
            r0.stringDecoderBufferSize = r1;
            return r0;
        }

        public UnpackerConfig withStringSizeLimit(int r1) {
            UnpackerConfig r0 = m3208clone();
            r0.stringSizeLimit = r1;
            return r0;
        }
    }

    static {
        UTF8 = Charset.forName(RpcUtils.CHARSET_UTF8);
        DEFAULT_PACKER_CONFIG = new PackerConfig();
        DEFAULT_UNPACKER_CONFIG = new UnpackerConfig();
    }

    private MessagePack() {
    }

    public static MessageBufferPacker newDefaultBufferPacker() {
        return DEFAULT_PACKER_CONFIG.newBufferPacker();
    }

    public static MessagePacker newDefaultPacker(OutputStream r1) {
        return DEFAULT_PACKER_CONFIG.newPacker(r1);
    }

    public static MessagePacker newDefaultPacker(WritableByteChannel r2) {
        WritableByteChannel r3 = (WritableByteChannel) ZeusTransformUtils.wrapperContextForParams(r2, WritableByteChannel.class, "com.obric.memorydata.plugin");
        return DEFAULT_PACKER_CONFIG.newPacker(r3);
    }

    public static MessagePacker newDefaultPacker(MessageBufferOutput r2) {
        MessageBufferOutput r3 = (MessageBufferOutput) ZeusTransformUtils.wrapperContextForParams(r2, MessageBufferOutput.class, "com.obric.memorydata.plugin");
        return DEFAULT_PACKER_CONFIG.newPacker(r3);
    }

    public static MessageUnpacker newDefaultUnpacker(InputStream r1) {
        return DEFAULT_UNPACKER_CONFIG.newUnpacker(r1);
    }

    public static MessageUnpacker newDefaultUnpacker(ByteBuffer r1) {
        return DEFAULT_UNPACKER_CONFIG.newUnpacker(r1);
    }

    public static MessageUnpacker newDefaultUnpacker(ReadableByteChannel r2) {
        ReadableByteChannel r3 = (ReadableByteChannel) ZeusTransformUtils.wrapperContextForParams(r2, ReadableByteChannel.class, "com.obric.memorydata.plugin");
        return DEFAULT_UNPACKER_CONFIG.newUnpacker(r3);
    }

    public static MessageUnpacker newDefaultUnpacker(MessageBufferInput r2) {
        MessageBufferInput r3 = (MessageBufferInput) ZeusTransformUtils.wrapperContextForParams(r2, MessageBufferInput.class, "com.obric.memorydata.plugin");
        return DEFAULT_UNPACKER_CONFIG.newUnpacker(r3);
    }

    public static MessageUnpacker newDefaultUnpacker(byte[] r1) {
        return DEFAULT_UNPACKER_CONFIG.newUnpacker(r1);
    }

    public static MessageUnpacker newDefaultUnpacker(byte[] r1, int r2, int r3) {
        return DEFAULT_UNPACKER_CONFIG.newUnpacker(r1, r2, r3);
    }
}
