package okio;

import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UByte;
import kotlin.UShort;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0093\u0001B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0000H\u0016J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0000H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\u0000J$\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\fJ \u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0000H\u0016J\b\u0010!\u001a\u00020\u0000H\u0016J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020\u0012H\u0016J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\fH\u0087\u0002¢\u0006\u0002\b+J\u0015\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\fH\u0007¢\u0006\u0002\b-J\b\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001dH\u0002J\u000e\u00102\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00103\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00104\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u0010\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)H\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\fH\u0016J \u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\fH\u0016J\u0010\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\u0010\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001dH\u0016J\u0018\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020#H\u0016J\u0006\u0010?\u001a\u00020\u001dJ\b\u0010@\u001a\u00020\u0019H\u0016J\b\u0010A\u001a\u00020\u0001H\u0016J\u0018\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J(\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020GH\u0016J \u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010H\u001a\u00020\f2\u0006\u0010E\u001a\u00020IH\u0016J\u0012\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010M\u001a\u00020)H\u0016J\b\u0010N\u001a\u00020GH\u0016J\u0010\u0010N\u001a\u00020G2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010O\u001a\u00020\u001dH\u0016J\u0010\u0010O\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010P\u001a\u00020\fH\u0016J\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=J\u0016\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\fJ \u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010S\u001a\u00020#H\u0002J\u0010\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020GH\u0016J\u0018\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010U\u001a\u00020\fH\u0016J\b\u0010V\u001a\u00020/H\u0016J\b\u0010W\u001a\u00020/H\u0016J\b\u0010X\u001a\u00020\fH\u0016J\b\u0010Y\u001a\u00020\fH\u0016J\b\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020[H\u0016J\u0010\u0010]\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J\u0018\u0010]\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010^\u001a\u00020_H\u0016J\u0012\u0010`\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010a\u001a\u00020\u001fH\u0016J\u0010\u0010a\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010b\u001a\u00020/H\u0016J\n\u0010c\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010d\u001a\u00020\u001fH\u0016J\u0010\u0010d\u001a\u00020\u001f2\u0006\u0010e\u001a\u00020\fH\u0016J\u0010\u0010f\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010g\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010h\u001a\u00020/2\u0006\u0010i\u001a\u00020jH\u0016J'\u0010h\u001a\u0004\u0018\u0001Hk\"\b\b\u0000\u0010k*\u00020%2\f\u0010i\u001a\b\u0012\u0004\u0012\u0002Hk0lH\u0016¢\u0006\u0002\u0010mJ\u0006\u0010n\u001a\u00020\u001dJ\u0006\u0010o\u001a\u00020\u001dJ\u0006\u0010p\u001a\u00020\u001dJ\r\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0002\bqJ\u0010\u0010r\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0006\u0010s\u001a\u00020\u001dJ\u000e\u0010s\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020/J\b\u0010t\u001a\u00020uH\u0016J\b\u0010v\u001a\u00020\u001fH\u0016J\u0015\u0010w\u001a\u00020\n2\u0006\u0010x\u001a\u00020/H\u0000¢\u0006\u0002\byJ\u0010\u0010z\u001a\u00020/2\u0006\u0010{\u001a\u00020FH\u0016J\u0010\u0010z\u001a\u00020\u00002\u0006\u0010{\u001a\u00020GH\u0016J \u0010z\u001a\u00020\u00002\u0006\u0010{\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010z\u001a\u00020\u00122\u0006\u0010{\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010z\u001a\u00020\u00002\u0006\u0010|\u001a\u00020\u001dH\u0016J \u0010z\u001a\u00020\u00002\u0006\u0010|\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010z\u001a\u00020\u00002\u0006\u0010{\u001a\u00020}2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010~\u001a\u00020\f2\u0006\u0010{\u001a\u00020}H\u0016J\u0010\u0010\u007f\u001a\u00020\u00002\u0006\u00106\u001a\u00020/H\u0016J\u0012\u0010\u0080\u0001\u001a\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0082\u0001\u001a\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0083\u0001\u001a\u00020\u00002\u0007\u0010\u0084\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0085\u0001\u001a\u00020\u00002\u0007\u0010\u0084\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0086\u0001\u001a\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0087\u0001\u001a\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0088\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020/H\u0016J\u0012\u0010\u008a\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020/H\u0016J\u001a\u0010\u008b\u0001\u001a\u00020\u00002\u0007\u0010\u008c\u0001\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J,\u0010\u008b\u0001\u001a\u00020\u00002\u0007\u0010\u008c\u0001\u001a\u00020\u001f2\u0007\u0010\u008d\u0001\u001a\u00020/2\u0007\u0010\u008e\u0001\u001a\u00020/2\u0006\u0010^\u001a\u00020_H\u0016J\u001b\u0010\u008f\u0001\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0012\u0010\u0090\u0001\u001a\u00020\u00002\u0007\u0010\u008c\u0001\u001a\u00020\u001fH\u0016J$\u0010\u0090\u0001\u001a\u00020\u00002\u0007\u0010\u008c\u0001\u001a\u00020\u001f2\u0007\u0010\u008d\u0001\u001a\u00020/2\u0007\u0010\u008e\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0091\u0001\u001a\u00020\u00002\u0007\u0010\u0092\u0001\u001a\u00020/H\u0016R\u0014\u0010\u0006\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0094\u0001"}, d2 = {"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "()V", "buffer", "getBuffer", "()Lokio/Buffer;", "head", "Lokio/Segment;", "<set-?>", "", "size", "()J", "setSize$okio", "(J)V", "clear", "", "clone", "close", "completeSegmentByteCount", "copy", "copyTo", "out", "Ljava/io/OutputStream;", "offset", "byteCount", "digest", "Lokio/ByteString;", "algorithm", "", "emit", "emitCompleteSegments", "equals", "", IInteractionStateService.WAKE_UP_SOURCE_OTHER, "", "exhausted", "flush", "get", "", "pos", "getByte", "index", "-deprecated_getByte", "hashCode", "", "hmac", "key", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "b", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", DBDefinition.MD5, "outputStream", "peek", "rangeEquals", "bytesOffset", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readAndWriteUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFrom", "input", "forever", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "charset", "Ljava/nio/charset/Charset;", "readUnsafe", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "T", "Lokio/TypedOptions;", "(Lokio/TypedOptions;)Ljava/lang/Object;", "sha1", "sha256", "sha512", "-deprecated_size", "skip", "snapshot", "timeout", "Lokio/Timeout;", "toString", "writableSegment", "minimumCapacity", "writableSegment$okio", "write", "source", "byteString", "Lokio/Source;", "writeAll", "writeByte", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", "string", "beginIndex", "endIndex", "writeTo", "writeUtf8", "writeUtf8CodePoint", "codePoint", "UnsafeCursor", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    public g0 head;
    private long size;

    public static final class a implements Closeable {
        public Buffer a;
        public boolean b;
        public g0 c;
        public long d;
        public byte[] e;
        public int f;
        public int g;

        public final int a() {
            long r0 = this.d;
            Buffer r2 = this.a;
            Intrinsics.checkNotNull(r2);
            if (r0 == r2.size()) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L14;
            long r3 = this.d;
            if (r3 != (-1)) goto L10;
            long r4 = 0;
        L12:
            return b(r4);
        L10:
            r4 = r3 + ((long) (this.g - this.f));
            goto L12
        L14:
            throw new IllegalStateException("no more bytes".toString());
        L5:
            r1 = false;
            goto L6
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            if (this.a == null) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.a = null;
            this.c = null;
            this.d = -1;
            this.e = null;
            this.f = -1;
            this.g = -1;
            return;
        L10:
            throw new IllegalStateException("not attached to a buffer".toString());
        L5:
            r0 = false;
            goto L6
        }

        public a() {
            this.d = -1;
            this.f = -1;
            this.g = -1;
        }

        public final int b(long r18) {
            Buffer r3 = this.a;
            if (r3 == null) goto L42;
            if (r18 < (-1)) goto L40;
            if (r18 > r3.size()) goto L40;
            if (r18 != (-1)) goto L10;
        L37:
            this.c = null;
            this.d = r18;
            this.e = null;
            this.f = -1;
            this.g = -1;
            return -1;
        L10:
            if (r18 == r3.size()) goto L37;
            long r4 = r3.size();
            g0 r6 = r3.head;
            g0 r7 = this.c;
            long r8 = 0;
            if (r7 == null) goto L18;
            long r10 = this.d;
            int r12 = this.f;
            Intrinsics.checkNotNull(r7);
            long r11 = r10 - ((long) (r12 - r7.b));
            if (r11 <= r18) goto L17;
            g0 r9 = this.c;
            r4 = r11;
        L20:
            if ((r4 - r18) <= (r18 - r8)) goto L25;
        L21:
            Intrinsics.checkNotNull(r6);
            long r5 = ((long) (r6.c - r6.b)) + r8;
            if (r18 < r5) goto L29;
            r6 = r6.f;
            r8 = r5;
        L29:
            if (this.b == false) goto L36;
            Intrinsics.checkNotNull(r6);
            if (r6.d == false) goto L36;
            byte[] r13 = r6.a;
            g0 r14 = new g0(Arrays.copyOf(r13, r13.length), r6.b, r6.c, false, true);
            if (r3.head != r6) goto L35;
            r3.head = r14;
        L35:
            r6.b(r14);
            g0 r15 = r14.g;
            Intrinsics.checkNotNull(r15);
            r15.a();
            r6 = r14;
        L36:
            this.c = r6;
            this.d = r18;
            Intrinsics.checkNotNull(r6);
            this.e = r6.a;
            int r16 = r6.b + ((int) (r18 - r8));
            this.f = r16;
            int r1 = r6.c;
            this.g = r1;
            return r1 - r16;
        L25:
            if (r4 <= r18) goto L27;
            Intrinsics.checkNotNull(r9);
            r9 = r9.g;
            Intrinsics.checkNotNull(r9);
            r4 = r4 - ((long) (r9.c - r9.b));
            goto L25
        L27:
            r8 = r4;
            r6 = r9;
            goto L29
        L17:
            r8 = r11;
            r9 = r6;
            r6 = this.c;
            goto L20
        L18:
            r9 = r6;
        L40:
            throw new ArrayIndexOutOfBoundsException("offset=" + r18 + " > size=" + r3.size());
        L42:
            throw new IllegalStateException("not attached to a buffer".toString());
        }
    }

    public Buffer() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer buffer() {
        return this;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, okio.Sink
    public void close() {
    }

    public final Buffer copyTo(OutputStream r10) throws IOException {
        Intrinsics.checkNotNullParameter(r10, "out");
        return copyTo$default(this, r10, 0, 0, 6, null);
    }

    public final Buffer copyTo(OutputStream r10, long r11) throws IOException {
        Intrinsics.checkNotNullParameter(r10, "out");
        return copyTo$default(this, r10, r11, 0, 4, null);
    }

    @Override // okio.BufferedSink
    public Buffer emit() {
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer getBuffer() {
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final a readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, null, 1, null);
    }

    public final a readUnsafe() {
        return readUnsafe$default(this, null, 1, null);
    }

    public final Buffer writeTo(OutputStream r8) throws IOException {
        Intrinsics.checkNotNullParameter(r8, "out");
        return writeTo$default(this, r8, 0, 2, null);
    }

    public final Buffer copy() {
        Buffer r0 = new Buffer();
        if (size() == 0) goto L9;
        g0 r1 = this.head;
        Intrinsics.checkNotNull(r1);
        g0 r2 = r1.c();
        r0.head = r2;
        r2.g = r2;
        r2.f = r2;
        g0 r3 = r1.f;
    L6:
        if (r3 == r1) goto L8;
        g0 r4 = r2.g;
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNull(r3);
        r4.b(r3.c());
        r3 = r3.f;
        goto L6
    L8:
        r0.setSize$okio(size());
    L9:
        return r0;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        if (this.size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        g0 r0 = this.head;
        if (r0 != null) goto L5;
        return 0;
    L5:
        int r1 = 1;
    L6:
        int r2 = r0.b;
        int r3 = r0.c;
    L7:
        if (r2 >= r3) goto L9;
        r1 = (r1 * 31) + r0.a[r2];
        r2 = r2 + 1;
        goto L7
    L9:
        r0 = r0.f;
        Intrinsics.checkNotNull(r0);
        if (r0 != this.head) goto L6;
        return r1;
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new b(this);
    }

    public final ByteString md5() {
        return digest("MD5");
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new c(this);
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return Okio.buffer(new c0(this));
    }

    @Override // okio.BufferedSource
    public long readDecimalLong() throws EOFException {
        if (size() == 0) goto L56;
        int r1 = 0;
        long r8 = 0;
        long r6 = -7;
        boolean r2 = false;
        boolean r5 = false;
    L5:
        g0 r10 = this.head;
        Intrinsics.checkNotNull(r10);
        byte[] r11 = r10.a;
        int r12 = r10.b;
        int r13 = r10.c;
    L6:
        if (r12 >= r13) goto L29;
        byte r15 = r11[r12];
        if (r15 < 48) goto L24;
        if (r15 > 57) goto L24;
        int r14 = 48 - r15;
        if (r8 < (-922337203685477580L)) goto L18;
        if (r8 == (-922337203685477580L)) goto L15;
    L17:
        r8 = (r8 * 10) + ((long) r14);
    L27:
        r12 = r12 + 1;
        r1 = r1 + 1;
        goto L6
    L15:
        if (r14 >= r6) goto L17;
    L18:
        Buffer r3 = new Buffer().writeDecimalLong(r8).writeByte(r15);
        if (r2 == true) goto L22;
        r3.readByte();
    L22:
        throw new NumberFormatException("Number too large: " + r3.readUtf8());
    L24:
        if (r15 != 45) goto L28;
        if (r1 != 0) goto L28;
        r6 = r6 - 1;
        r2 = true;
    L28:
        r5 = true;
    L29:
        if (r12 != r13) goto L31;
        this.head = r10.a();
        h0.a(r10);
    L32:
        if (r5 == true) goto L37;
        if (this.head != null) goto L5;
    L37:
        setSize$okio(size() - ((long) r1));
        if (r2 == false) goto L40;
        int r16 = 2;
    L41:
        if (r1 < r16) goto L43;
        if (r2 == false) goto L54;
        return r8;
    L54:
        return -r8;
    L43:
        if (size() == 0) goto L50;
        if (r2 == false) goto L46;
        String r4 = "Expected a digit";
    L48:
        throw new NumberFormatException(r4 + " but was 0x" + b.e(getByte(0)));
    L46:
        r4 = "Expected a digit or '-'";
        goto L48
    L50:
        throw new EOFException();
    L40:
        r16 = 1;
        goto L41
    L31:
        r10.b = r12;
        goto L32
    L56:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        return readString(this.size, Charsets.UTF_8);
    }

    @Override // okio.BufferedSource
    public String readUtf8Line() throws EOFException {
        long r0 = indexOf((byte) 10);
        if (r0 == (-1)) goto L6;
        return okio.internal.a.b(this, r0);
    L6:
        if (size() != 0) goto L11;
        return null;
    L11:
        return readUtf8(size());
    }

    public final ByteString sha1() {
        return digest("SHA-1");
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    public final void clear() {
        skip(size());
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return m539clone();
    }

    public final long completeSegmentByteCount() {
        long r0 = size();
        if (r0 == 0) goto L12;
        g0 r2 = this.head;
        Intrinsics.checkNotNull(r2);
        g0 r3 = r2.g;
        Intrinsics.checkNotNull(r3);
        int r4 = r3.c;
        if (r4 >= 8192) goto L11;
        if (r3.e == false) goto L11;
        r0 = r0 - ((long) (r4 - r3.b));
    L11:
        return r0;
    L12:
        return 0;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink emit() {
        return emit();
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink emitCompleteSegments() {
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSource
    public byte readByte() throws EOFException {
        if (size() == 0) goto L10;
        g0 r0 = this.head;
        Intrinsics.checkNotNull(r0);
        int r1 = r0.b;
        int r2 = r0.c;
        int r4 = r1 + 1;
        byte r3 = r0.a[r1];
        setSize$okio(size() - 1);
        if (r4 != r2) goto L7;
        this.head = r0.a();
        h0.a(r0);
    L8:
        return r3;
    L7:
        r0.b = r4;
        goto L8
    L10:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        return readByteArray(size());
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        return readByteString(size());
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() throws EOFException {
        if (size() == 0) goto L41;
        int r0 = 0;
        long r4 = 0;
        boolean r1 = false;
    L5:
        g0 r6 = this.head;
        Intrinsics.checkNotNull(r6);
        byte[] r7 = r6.a;
        int r8 = r6.b;
        int r9 = r6.c;
    L6:
        if (r8 >= r9) goto L32;
        byte r10 = r7[r8];
        if (r10 < 48) goto L13;
        if (r10 > 57) goto L13;
        int r11 = r10 - 48;
    L24:
        if (((-1152921504606846976L) & r4) != 0) goto L27;
        r4 = (r4 << 4) | ((long) r11);
        r8 = r8 + 1;
        r0 = r0 + 1;
        goto L6
    L27:
        throw new NumberFormatException("Number too large: " + new Buffer().writeHexadecimalUnsignedLong(r4).writeByte(r10).readUtf8());
    L13:
        if (r10 < 97) goto L19;
        if (r10 > 102) goto L19;
        int r12 = r10 - 97;
    L17:
        r11 = r12 + 10;
    L19:
        if (r10 < 65) goto L28;
        if (r10 > 70) goto L28;
        r12 = r10 - 65;
    L28:
        if (r0 == 0) goto L31;
        r1 = true;
        goto L32
    L31:
        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + b.e(r10));
    L32:
        if (r8 != r9) goto L34;
        this.head = r6.a();
        h0.a(r6);
    L35:
        if (r1 == true) goto L38;
        if (this.head != null) goto L5;
    L38:
        setSize$okio(size() - ((long) r0));
        return r4;
    L34:
        r6.b = r8;
        goto L35
    L41:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int readInt() throws EOFException {
        if (size() < 4) goto L14;
        g0 r0 = this.head;
        Intrinsics.checkNotNull(r0);
        int r1 = r0.b;
        int r4 = r0.c;
        if ((r4 - r1) < 4) goto L15;
        byte[] r5 = r0.a;
        int r6 = r1 + 1;
        int r7 = r6 + 1;
        int r2 = ((r5[r1] & UByte.MAX_VALUE) << 24) | ((r5[r6] & UByte.MAX_VALUE) << 16);
        int r8 = r7 + 1;
        int r3 = r2 | ((r5[r7] & UByte.MAX_VALUE) << 8);
        int r9 = r8 + 1;
        int r10 = r3 | (r5[r8] & UByte.MAX_VALUE);
        setSize$okio(size() - 4);
        if (r9 != r4) goto L10;
        this.head = r0.a();
        h0.a(r0);
    L12:
        return r10;
    L10:
        r0.b = r9;
        goto L12
    L15:
        return ((((readByte() & UByte.MAX_VALUE) << 24) | ((readByte() & UByte.MAX_VALUE) << 16)) | ((readByte() & UByte.MAX_VALUE) << 8)) | (readByte() & UByte.MAX_VALUE);
    L14:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int readIntLe() throws EOFException {
        int r0 = readInt();
        a r1 = b.a;
        int r2 = ((((-16777216) & r0) >>> 24) | ((16711680 & r0) >>> 8)) | ((65280 & r0) << 8);
        return ((r0 & KotlinVersion.MAX_COMPONENT_VALUE) << 24) | r2;
    }

    @Override // okio.BufferedSource
    public long readLong() throws EOFException {
        if (size() < 8) goto L14;
        g0 r0 = this.head;
        Intrinsics.checkNotNull(r0);
        int r1 = r0.b;
        int r4 = r0.c;
        if ((r4 - r1) < 8) goto L15;
        byte[] r5 = r0.a;
        int r6 = r1 + 1;
        long r8 = (((long) r5[r1]) & 255) << 56;
        int r2 = r6 + 1;
        long r9 = r8 | ((((long) r5[r6]) & 255) << 48);
        int r7 = r2 + 1;
        long r10 = r9 | ((((long) r5[r2]) & 255) << 40);
        int r3 = r7 + 1;
        long r11 = ((((long) r5[r7]) & 255) << 32) | r10;
        int r12 = r3 + 1;
        long r13 = r11 | ((((long) r5[r3]) & 255) << 24);
        int r14 = r12 + 1;
        long r15 = r13 | ((((long) r5[r12]) & 255) << 16);
        int r16 = r14 + 1;
        long r17 = r15 | ((((long) r5[r14]) & 255) << 8);
        int r18 = r16 + 1;
        long r19 = r17 | (((long) r5[r16]) & 255);
        setSize$okio(size() - 8);
        if (r18 != r4) goto L10;
        this.head = r0.a();
        h0.a(r0);
    L12:
        return r19;
    L10:
        r0.b = r18;
        goto L12
    L15:
        return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
    L14:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public long readLongLe() throws EOFException {
        return b.d(readLong());
    }

    @Override // okio.BufferedSource
    public short readShort() throws EOFException {
        if (size() < 2) goto L14;
        g0 r0 = this.head;
        Intrinsics.checkNotNull(r0);
        int r1 = r0.b;
        int r4 = r0.c;
        if ((r4 - r1) < 2) goto L15;
        byte[] r5 = r0.a;
        int r6 = r1 + 1;
        int r7 = r6 + 1;
        int r2 = ((r5[r1] & UByte.MAX_VALUE) << 8) | (r5[r6] & UByte.MAX_VALUE);
        setSize$okio(size() - 2);
        if (r7 != r4) goto L10;
        this.head = r0.a();
        h0.a(r0);
    L12:
        return (short) r2;
    L10:
        r0.b = r7;
        goto L12
    L15:
        return (short) (((readByte() & UByte.MAX_VALUE) << 8) | (readByte() & UByte.MAX_VALUE));
    L14:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public short readShortLe() throws EOFException {
        short r0 = readShort();
        a r1 = b.a;
        int r2 = r0 & UShort.MAX_VALUE;
        int r3 = (65280 & r2) >>> 8;
        return (short) (((r2 & KotlinVersion.MAX_COMPONENT_VALUE) << 8) | r3);
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        if (size() == 0) goto L42;
        byte r0 = getByte(0);
        boolean r2 = false;
        if ((r0 & ByteCompanionObject.MIN_VALUE) != 0) goto L8;
        int r1 = r0 & ByteCompanionObject.MAX_VALUE;
        int r6 = 1;
        int r7 = 0;
    L16:
        long r10 = r6;
        if (size() < r10) goto L38;
        int r3 = 1;
    L19:
        if (r3 >= r6) goto L24;
        long r8 = r3;
        byte r12 = getByte(r8);
        if ((r12 & 192) != 128) goto L23;
        r1 = (r1 << 6) | (r12 & 63);
        r3 = r3 + 1;
        goto L19
    L23:
        skip(r8);
        return 65533;
    L24:
        skip(r10);
        if (r1 <= 1114111) goto L28;
        return 65533;
    L28:
        if (55296 <= r1) goto L30;
    L32:
        if (r2 == true) goto L48;
        if (r1 >= r7) goto L46;
        return 65533;
    L46:
        return r1;
    L48:
        return 65533;
    L30:
        if (r1 >= 57344) goto L32;
        r2 = true;
        goto L32
    L38:
        throw new EOFException("size < " + r6 + ": " + size() + " (to read code point prefixed 0x" + b.e(r0) + ')');
    L8:
        if ((r0 & 224) != 192) goto L11;
        r1 = r0 & 31;
        r6 = 2;
        r7 = 128;
        goto L16
    L11:
        if ((r0 & 240) != 224) goto L14;
        r1 = r0 & 15;
        r6 = 3;
        r7 = 2048;
        goto L16
    L14:
        if ((r0 & 248) != 240) goto L39;
        r1 = r0 & 7;
        r6 = 4;
        r7 = 65536;
        goto L16
    L39:
        skip(1);
        return 65533;
    L42:
        throw new EOFException();
    }

    public final ByteString snapshot() {
        if (size() > 2147483647L) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return snapshot((int) size());
    L10:
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    L5:
        r0 = false;
        goto L6
    }

    public String toString() {
        return snapshot().toString();
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(LongCompanionObject.MAX_VALUE);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final long m538deprecated_size() {
        return this.size;
    }

    public final long size() {
        return this.size;
    }

    @Override // okio.Source, okio.Sink
    public j0 timeout() {
        return j0.d;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public Buffer m539clone() {
        return copy();
    }

    private final ByteString digest(String r6) {
        MessageDigest r7 = MessageDigest.getInstance(r6);
        g0 r0 = this.head;
        if (r0 == null) goto L8;
        byte[] r1 = r0.a;
        int r2 = r0.b;
        r7.update(r1, r2, r0.c - r2);
        g0 r3 = r0.f;
        Intrinsics.checkNotNull(r3);
    L5:
        if (r3 == r0) goto L8;
        byte[] r4 = r3.a;
        int r5 = r3.b;
        r7.update(r4, r5, r3.c - r5);
        r3 = r3.f;
        Intrinsics.checkNotNull(r3);
    L8:
        return new ByteString(r7.digest());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m537deprecated_getByte(long r1) {
        return getByte(r1);
    }

    public boolean equals(Object r19) {
        if (this != r19) goto L6;
        return true;
    L6:
        if ((r19 instanceof Buffer) == true) goto L8;
    L7:
        return false;
    L8:
        Buffer r1 = (Buffer) r19;
        if (size() != r1.size()) goto L7;
        if (size() == 0) goto L38;
        g0 r3 = this.head;
        Intrinsics.checkNotNull(r3);
        g0 r2 = r1.head;
        Intrinsics.checkNotNull(r2);
        int r5 = r3.b;
        int r6 = r2.b;
        long r9 = 0;
    L16:
        if (r9 >= size()) goto L39;
        long r11 = Math.min(r3.c - r5, r2.c - r6);
        long r13 = 0;
    L19:
        if (r13 >= r11) goto L25;
        int r16 = r5 + 1;
        int r17 = r6 + 1;
        if (r3.a[r5] != r2.a[r6]) goto L7;
        r13 = r13 + 1;
        r5 = r16;
        r6 = r17;
        goto L19
    L25:
        if (r5 != r3.c) goto L28;
        r3 = r3.f;
        Intrinsics.checkNotNull(r3);
        r5 = r3.b;
    L28:
        if (r6 != r2.c) goto L30;
        r2 = r2.f;
        Intrinsics.checkNotNull(r2);
        r6 = r2.b;
    L30:
        r9 = r9 + r11;
        goto L16
    L39:
        return true;
    L38:
        return true;
    }

    public final byte getByte(long r7) {
        b.b(size(), r7, 1);
        g0 r0 = this.head;
        if (r0 != null) goto L5;
        Intrinsics.checkNotNull(null);
        throw null;
    L5:
        if ((size() - r7) >= r7) goto L11;
        long r1 = size();
    L8:
        if (r1 <= r7) goto L10;
        r0 = r0.g;
        Intrinsics.checkNotNull(r0);
        r1 = r1 - ((long) (r0.c - r0.b));
        goto L8
    L10:
        Intrinsics.checkNotNull(r0);
        return r0.a[(int) ((((long) r0.b) + r7) - r1)];
    L11:
        long r2 = 0;
    L12:
        long r3 = ((long) (r0.c - r0.b)) + r2;
        if (r3 > r7) goto L15;
        r0 = r0.f;
        Intrinsics.checkNotNull(r0);
        r2 = r3;
        goto L12
    L15:
        Intrinsics.checkNotNull(r0);
        return r0.a[(int) ((((long) r0.b) + r7) - r2)];
    }

    public final ByteString hmacSha1(ByteString r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return hmac("HmacSHA1", r2);
    }

    public final ByteString hmacSha256(ByteString r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return hmac("HmacSHA256", r2);
    }

    public final ByteString hmacSha512(ByteString r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return hmac("HmacSHA512", r2);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r7) {
        return indexOf(r7, 0, LongCompanionObject.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString r3) {
        Intrinsics.checkNotNullParameter(r3, "targetBytes");
        return indexOfElement(r3, 0);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer r7) throws IOException {
        Intrinsics.checkNotNullParameter(r7, "sink");
        g0 r0 = this.head;
        if (r0 != null) goto L6;
        return -1;
    L6:
        int r1 = Math.min(r7.remaining(), r0.c - r0.b);
        r7.put(r0.a, r0.b, r1);
        int r8 = r0.b + r1;
        r0.b = r8;
        this.size -= (long) r1;
        if (r8 != r0.c) goto L9;
        this.head = r0.a();
        h0.a(r0);
    L9:
        return r1;
    }

    @Override // okio.BufferedSource
    public long readAll(Sink r6) throws IOException {
        Intrinsics.checkNotNullParameter(r6, "sink");
        long r0 = size();
        if (r0 <= 0) goto L5;
        r6.write(this, r0);
    L5:
        return r0;
    }

    public final a readAndWriteUnsafe(a r3) {
        Intrinsics.checkNotNullParameter(r3, "unsafeCursor");
        byte[] r1 = okio.internal.a.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r3, "unsafeCursor");
        a r2 = b.a;
        Intrinsics.checkNotNullParameter(r3, "unsafeCursor");
        if (r3 != b.a) goto L6;
        r3 = new a();
    L6:
        if (r3.a != null) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L13;
        r3.a = this;
        r3.b = true;
        return r3;
    L13:
        throw new IllegalStateException("already attached to a buffer".toString());
    L8:
        r0 = false;
        goto L9
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long r4) throws EOFException {
        if (r4 >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L16;
        if (size() < r4) goto L14;
        byte[] r5 = new byte[(int) r4];
        readFully(r5);
        return r5;
    L14:
        throw new EOFException();
    L16:
        throw new IllegalArgumentException(("byteCount: " + r4).toString());
    L5:
        if (r4 > 2147483647L) goto L7;
        r0 = true;
        goto L8
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long r4) throws EOFException {
        if (r4 >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L19;
        if (size() < r4) goto L17;
        if (r4 < 4096) goto L15;
        ByteString r1 = snapshot((int) r4);
        skip(r4);
        return r1;
    L15:
        return new ByteString(readByteArray(r4));
    L17:
        throw new EOFException();
    L19:
        throw new IllegalArgumentException(("byteCount: " + r4).toString());
    L5:
        if (r4 > 2147483647L) goto L7;
        r0 = true;
        goto L8
    }

    public final Buffer readFrom(InputStream r4) throws IOException {
        Intrinsics.checkNotNullParameter(r4, "input");
        readFrom(r4, LongCompanionObject.MAX_VALUE, true);
        return this;
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] r4) throws EOFException {
        Intrinsics.checkNotNullParameter(r4, "sink");
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L10;
        int r1 = read(r4, r0, r4.length - r0);
        if (r1 == (-1)) goto L9;
        r0 = r0 + r1;
        goto L4
    L9:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public String readString(Charset r3) {
        Intrinsics.checkNotNullParameter(r3, "charset");
        return readString(this.size, r3);
    }

    public final a readUnsafe(a r3) {
        Intrinsics.checkNotNullParameter(r3, "unsafeCursor");
        byte[] r1 = okio.internal.a.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r3, "unsafeCursor");
        a r2 = b.a;
        Intrinsics.checkNotNullParameter(r3, "unsafeCursor");
        if (r3 != b.a) goto L6;
        r3 = new a();
    L6:
        if (r3.a != null) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L13;
        r3.a = this;
        r3.b = false;
        return r3;
    L13:
        throw new IllegalStateException("already attached to a buffer".toString());
    L8:
        r0 = false;
        goto L9
    }

    @Override // okio.BufferedSource
    public String readUtf8(long r2) throws EOFException {
        return readString(r2, Charsets.UTF_8);
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long r11) throws EOFException {
        if (r11 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L25;
        long r2 = LongCompanionObject.MAX_VALUE;
        if (r11 == LongCompanionObject.MAX_VALUE) goto L11;
        r2 = r11 + 1;
    L11:
        long r4 = indexOf((byte) 10, 0, r2);
        if (r4 == (-1)) goto L15;
        return okio.internal.a.b(this, r4);
    L15:
        if (r2 < size()) goto L17;
    L22:
        Buffer r6 = new Buffer();
        copyTo(r6, 0, Math.min(32, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), r11) + " content=" + r6.readByteString().hex() + 8230);
    L17:
        if (getByte(r2 - 1) != 13) goto L22;
        if (getByte(r2) != 10) goto L22;
        return okio.internal.a.b(this, r2);
    L25:
        throw new IllegalArgumentException(("limit < 0: " + r11).toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public boolean request(long r4) {
        if (this.size < r4) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // okio.BufferedSource
    public void require(long r4) throws EOFException {
        if (this.size < r4) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public int select(z r2) {
        Intrinsics.checkNotNullParameter(r2, "options");
        byte[] r3 = okio.internal.a.a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(null, "options");
        if (this.head != null) goto L6;
        return -1;
    L6:
        throw null;
    }

    public final void setSize$okio(long r1) {
        this.size = r1;
    }

    @Override // okio.BufferedSource
    public void skip(long r8) throws EOFException {
    L3:
        if (r8 <= 0) goto L11;
        g0 r0 = this.head;
        if (r0 == null) goto L10;
        int r2 = (int) Math.min(r8, r0.c - r0.b);
        long r5 = r2;
        setSize$okio(size() - r5);
        r8 = r8 - r5;
        int r1 = r0.b + r2;
        r0.b = r1;
        if (r1 != r0.c) goto L3;
        this.head = r0.a();
        h0.a(r0);
        goto L3
    L10:
        throw new EOFException();
    }

    public final ByteString snapshot(int r9) {
        if (r9 == 0) goto L19;
        b.b(size(), 0, r9);
        g0 r0 = this.head;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
    L5:
        if (r2 >= r9) goto L11;
        Intrinsics.checkNotNull(r0);
        int r4 = r0.c;
        int r5 = r0.b;
        if (r4 == r5) goto L10;
        r2 = r2 + (r4 - r5);
        r3 = r3 + 1;
        r0 = r0.f;
        goto L5
    L10:
        throw new AssertionError("s.limit == s.pos");
    L11:
        byte[][] r6 = new byte[r3][];
        int[] r7 = new int[r3 * 2];
        g0 r8 = this.head;
        int r10 = 0;
    L12:
        if (r1 >= r9) goto L15;
        Intrinsics.checkNotNull(r8);
        r6[r10] = r8.a;
        r1 = r1 + (r8.c - r8.b);
        r7[r10] = Math.min(r1, r9);
        r7[r10 + r3] = r8.b;
        r8.d = true;
        r10 = r10 + 1;
        r8 = r8.f;
        goto L12
    L15:
        return new SegmentedByteString(r6, r7);
    L19:
        return ByteString.EMPTY;
    }

    public final g0 writableSegment$okio(int r4) {
        boolean r1 = true;
        if (r4 < 1) goto L6;
        if (r4 > 8192) goto L6;
    L7:
        if (r1 == false) goto L20;
        g0 r2 = this.head;
        if (r2 != null) goto L11;
        g0 r5 = h0.b();
        this.head = r5;
        r5.g = r5;
        r5.f = r5;
        return r5;
    L11:
        Intrinsics.checkNotNull(r2);
        g0 r3 = r2.g;
        Intrinsics.checkNotNull(r3);
        if ((r3.c + r4) <= 8192) goto L14;
    L17:
        g0 r6 = h0.b();
        r3.b(r6);
        return r6;
    L14:
        if (r3.e == false) goto L17;
        return r3;
    L20:
        throw new IllegalArgumentException("unexpected capacity".toString());
    L6:
        r1 = false;
        goto L7
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer r7) throws IOException {
        Intrinsics.checkNotNullParameter(r7, "source");
        int r0 = r7.remaining();
        int r1 = r0;
    L3:
        if (r1 <= 0) goto L5;
        g0 r2 = writableSegment$okio(1);
        int r3 = Math.min(r1, 8192 - r2.c);
        r7.get(r2.a, r2.c, r3);
        r1 = r1 - r3;
        r2.c += r3;
        goto L3
    L5:
        this.size += (long) r0;
        return r0;
    }

    @Override // okio.BufferedSink
    public long writeAll(Source r8) throws IOException {
        Intrinsics.checkNotNullParameter(r8, "source");
        long r0 = 0;
    L3:
        long r2 = r8.read(this, 8192);
        if (r2 == (-1)) goto L6;
        r0 = r0 + r2;
        goto L3
    L6:
        return r0;
    }

    @Override // okio.BufferedSink
    public Buffer writeByte(int r5) {
        g0 r0 = writableSegment$okio(1);
        byte[] r1 = r0.a;
        int r2 = r0.c;
        r0.c = r2 + 1;
        r1[r2] = (byte) r5;
        setSize$okio(size() + 1);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeDecimalLong(long r13) {
        if (r13 == 0) goto L78;
        int r3 = 1;
        if (r13 >= 0) goto L11;
        r13 = -r13;
        if (r13 < 0) goto L79;
        boolean r2 = true;
    L13:
        if (r13 >= 100000000) goto L37;
        if (r13 >= 10000) goto L27;
        if (r13 >= 100) goto L23;
        if (r13 < 10) goto L67;
        r3 = 2;
    L67:
        if (r2 == false) goto L69;
        r3 = r3 + 1;
    L69:
        g0 r4 = writableSegment$okio(r3);
        byte[] r5 = r4.a;
        int r7 = r4.c + r3;
    L71:
        if (r13 == 0) goto L73;
        long r8 = 10;
        r7 = r7 - 1;
        r5[r7] = okio.internal.a.a[(int) (r13 % r8)];
        r13 = r13 / r8;
        goto L71
    L73:
        if (r2 == false) goto L75;
        r5[r7 - 1] = 45;
    L75:
        r4.c += r3;
        setSize$okio(size() + ((long) r3));
        return this;
    L23:
        if (r13 >= 1000) goto L25;
        r3 = 3;
        goto L67
    L25:
        r3 = 4;
        goto L67
    L27:
        if (r13 >= 1000000) goto L33;
        if (r13 >= 100000) goto L31;
        r3 = 5;
        goto L67
    L31:
        r3 = 6;
        goto L67
    L33:
        if (r13 >= 10000000) goto L35;
        r3 = 7;
        goto L67
    L35:
        r3 = 8;
        goto L67
    L37:
        if (r13 >= 1000000000000L) goto L49;
        if (r13 >= 10000000000L) goto L45;
        if (r13 >= 1000000000) goto L43;
        r3 = 9;
        goto L67
    L43:
        r3 = 10;
        goto L67
    L45:
        if (r13 >= 100000000000L) goto L47;
        r3 = 11;
        goto L67
    L47:
        r3 = 12;
        goto L67
    L49:
        if (r13 >= 1000000000000000L) goto L58;
        if (r13 >= 10000000000000L) goto L54;
        r3 = 13;
        goto L67
    L54:
        if (r13 >= 100000000000000L) goto L56;
        r3 = 14;
        goto L67
    L56:
        r3 = 15;
        goto L67
    L58:
        if (r13 >= 100000000000000000L) goto L64;
        if (r13 >= 10000000000000000L) goto L62;
        r3 = 16;
        goto L67
    L62:
        r3 = 17;
        goto L67
    L64:
        if (r13 >= 1000000000000000000L) goto L66;
        r3 = 18;
        goto L67
    L66:
        r3 = 19;
        goto L67
    L79:
        return writeUtf8("-9223372036854775808");
    L11:
        r2 = false;
        goto L13
    L78:
        return writeByte(48);
    }

    @Override // okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long r13) {
        if (r13 == 0) goto L11;
        long r1 = (r13 >>> 1) | r13;
        long r2 = r1 | (r1 >>> 2);
        long r3 = r2 | (r2 >>> 4);
        long r4 = r3 | (r3 >>> 8);
        long r5 = r4 | (r4 >>> 16);
        long r6 = r5 | (r5 >>> 32);
        long r7 = r6 - ((r6 >>> 1) & 6148914691236517205L);
        long r8 = ((r7 >>> 2) & 3689348814741910323L) + (r7 & 3689348814741910323L);
        long r9 = ((r8 >>> 4) + r8) & 1085102592571150095L;
        long r10 = r9 + (r9 >>> 8);
        long r11 = r10 + (r10 >>> 16);
        int r12 = (int) ((((r11 & 63) + ((r11 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        g0 r14 = writableSegment$okio(r12);
        byte[] r15 = r14.a;
        int r16 = r14.c;
        int r17 = (r16 + r12) - 1;
    L6:
        if (r17 < r16) goto L8;
        r15[r17] = okio.internal.a.a[(int) (15 & r13)];
        r13 = r13 >>> 4;
        r17 = r17 - 1;
        goto L6
    L8:
        r14.c += r12;
        setSize$okio(size() + ((long) r12));
        return this;
    L11:
        return writeByte(48);
    }

    @Override // okio.BufferedSink
    public Buffer writeInt(int r6) {
        g0 r0 = writableSegment$okio(4);
        byte[] r1 = r0.a;
        int r2 = r0.c;
        int r3 = r2 + 1;
        r1[r2] = (byte) ((r6 >>> 24) & KotlinVersion.MAX_COMPONENT_VALUE);
        int r4 = r3 + 1;
        r1[r3] = (byte) ((r6 >>> 16) & KotlinVersion.MAX_COMPONENT_VALUE);
        int r5 = r4 + 1;
        r1[r4] = (byte) ((r6 >>> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
        r1[r5] = (byte) (r6 & KotlinVersion.MAX_COMPONENT_VALUE);
        r0.c = r5 + 1;
        setSize$okio(size() + 4);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeIntLe(int r3) {
        a r0 = b.a;
        int r1 = ((((-16777216) & r3) >>> 24) | ((16711680 & r3) >>> 8)) | ((65280 & r3) << 8);
        return writeInt(((r3 & KotlinVersion.MAX_COMPONENT_VALUE) << 24) | r1);
    }

    @Override // okio.BufferedSink
    public Buffer writeLong(long r10) {
        g0 r1 = writableSegment$okio(8);
        byte[] r2 = r1.a;
        int r3 = r1.c;
        int r4 = r3 + 1;
        r2[r3] = (byte) ((r10 >>> 56) & 255);
        int r5 = r4 + 1;
        r2[r4] = (byte) ((r10 >>> 48) & 255);
        int r6 = r5 + 1;
        r2[r5] = (byte) ((r10 >>> 40) & 255);
        int r7 = r6 + 1;
        r2[r6] = (byte) ((r10 >>> 32) & 255);
        int r8 = r7 + 1;
        r2[r7] = (byte) ((r10 >>> 24) & 255);
        int r9 = r8 + 1;
        r2[r8] = (byte) ((r10 >>> 16) & 255);
        int r11 = r9 + 1;
        r2[r9] = (byte) ((r10 >>> 8) & 255);
        r2[r11] = (byte) (r10 & 255);
        r1.c = r11 + 1;
        setSize$okio(size() + 8);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeLongLe(long r1) {
        return writeLong(b.d(r1));
    }

    @Override // okio.BufferedSink
    public Buffer writeShort(int r6) {
        g0 r0 = writableSegment$okio(2);
        byte[] r1 = r0.a;
        int r2 = r0.c;
        int r3 = r2 + 1;
        r1[r2] = (byte) ((r6 >>> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
        r1[r3] = (byte) (r6 & KotlinVersion.MAX_COMPONENT_VALUE);
        r0.c = r3 + 1;
        setSize$okio(size() + 2);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeShortLe(int r2) {
        a r0 = b.a;
        int r3 = ((short) r2) & UShort.MAX_VALUE;
        int r1 = (65280 & r3) >>> 8;
        return writeShort((short) (((r3 & KotlinVersion.MAX_COMPONENT_VALUE) << 8) | r1));
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String r3) {
        Intrinsics.checkNotNullParameter(r3, "string");
        return writeUtf8(r3, 0, r3.length());
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8CodePoint(int r9) {
        if (r9 >= 128) goto L6;
        writeByte(r9);
    L21:
        return this;
    L6:
        if (r9 >= 2048) goto L8;
        g0 r3 = writableSegment$okio(2);
        byte[] r4 = r3.a;
        int r5 = r3.c;
        r4[r5] = (byte) ((r9 >> 6) | 192);
        r4[r5 + 1] = (byte) ((r9 & 63) | 128);
        r3.c = r5 + 2;
        setSize$okio(size() + 2);
        goto L21
    L8:
        boolean r6 = false;
        if (55296 <= r9) goto L11;
    L13:
        if (r6 == false) goto L16;
        writeByte(63);
        goto L21
    L16:
        if (r9 >= 65536) goto L19;
        g0 r7 = writableSegment$okio(3);
        byte[] r8 = r7.a;
        int r10 = r7.c;
        r8[r10] = (byte) ((r9 >> 12) | 224);
        r8[r10 + 1] = (byte) (((r9 >> 6) & 63) | 128);
        r8[r10 + 2] = (byte) ((r9 & 63) | 128);
        r7.c = r10 + 3;
        setSize$okio(size() + 3);
        goto L21
    L19:
        if (r9 > 1114111) goto L23;
        g0 r11 = writableSegment$okio(4);
        byte[] r12 = r11.a;
        int r13 = r11.c;
        r12[r13] = (byte) ((r9 >> 18) | 240);
        r12[r13 + 1] = (byte) (((r9 >> 12) & 63) | 128);
        r12[r13 + 2] = (byte) (((r9 >> 6) & 63) | 128);
        r12[r13 + 3] = (byte) ((r9 & 63) | 128);
        r11.c = r13 + 4;
        setSize$okio(size() + 4);
        goto L21
    L23:
        throw new IllegalArgumentException("Unexpected code point: 0x" + b.f(r9));
    L11:
        if (r9 >= 57344) goto L13;
        r6 = true;
        goto L13
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString r3) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "bytes");
        return indexOf(r3, 0);
    }

    @Override // okio.BufferedSource
    public int read(byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "sink");
        return read(r3, 0, r3.length);
    }

    @Override // okio.BufferedSource
    public <T> T select(k0<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "options");
        throw null;
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString r3) {
        Intrinsics.checkNotNullParameter(r3, "byteString");
        r3.write$okio(this, 0, r3.size());
        return this;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeByte(int r1) {
        return writeByte(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeDecimalLong(long r1) {
        return writeDecimalLong(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeHexadecimalUnsignedLong(long r1) {
        return writeHexadecimalUnsignedLong(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeInt(int r1) {
        return writeInt(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeIntLe(int r1) {
        return writeIntLe(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeLong(long r1) {
        return writeLong(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeLongLe(long r1) {
        return writeLongLe(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeShort(int r1) {
        return writeShort(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeShortLe(int r1) {
        return writeShortLe(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeUtf8(String r1) {
        return writeUtf8(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeUtf8CodePoint(int r1) {
        return writeUtf8CodePoint(r1);
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        return write(r3, 0, r3.length);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(ByteString r1) {
        return write(r1);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(byte[] r1) {
        return write(r1);
    }

    private final ByteString hmac(String r5, ByteString r6) {
        Mac r0 = Mac.getInstance(r5);     // Catch: InvalidKeyException -> L9
        r0.init(new SecretKeySpec(r6.internalArray$okio(), r5));     // Catch: InvalidKeyException -> L9
        g0 r7 = this.head;     // Catch: InvalidKeyException -> L9
        if (r7 == null) goto L7;
        byte[] r8 = r7.a;     // Catch: InvalidKeyException -> L9
        int r1 = r7.b;     // Catch: InvalidKeyException -> L9
        r0.update(r8, r1, r7.c - r1);     // Catch: InvalidKeyException -> L9
        g0 r9 = r7.f;     // Catch: InvalidKeyException -> L9
        Intrinsics.checkNotNull(r9);     // Catch: InvalidKeyException -> L9
    L5:
        if (r9 == r7) goto L7;
        byte[] r2 = r9.a;     // Catch: InvalidKeyException -> L9
        int r3 = r9.b;     // Catch: InvalidKeyException -> L9
        r0.update(r2, r3, r9.c - r3);     // Catch: InvalidKeyException -> L9
        r9 = r9.f;     // Catch: InvalidKeyException -> L9
        Intrinsics.checkNotNull(r9);     // Catch: InvalidKeyException -> L9
    L7:
        return new ByteString(r0.doFinal());
    L9:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public final Buffer copyTo(Buffer r9, long r10) {
        Intrinsics.checkNotNullParameter(r9, "out");
        return copyTo(r9, r10, this.size - r10);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString r17, long r18) throws IOException {
        long r0 = r18;
        Intrinsics.checkNotNullParameter(r17, "bytes");
        boolean r4 = true;
        if (r17.size() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L53;
        long r6 = 0;
        if (r0 >= 0) goto L11;
        r4 = false;
    L11:
        if (r4 == false) goto L51;
        g0 r5 = this.head;
        if (r5 != null) goto L16;
    L48:
        return -1;
    L16:
        if ((size() - r0) >= r0) goto L33;
        r6 = size();
    L19:
        if (r6 <= r0) goto L21;
        r5 = r5.g;
        Intrinsics.checkNotNull(r5);
        r6 = r6 - ((long) (r5.c - r5.b));
        goto L19
    L21:
        byte[] r8 = r17.internalArray$okio();
        byte r7 = r8[0];
        int r3 = r17.size();
        long r12 = (size() - ((long) r3)) + 1;
    L23:
        if (r6 >= r12) goto L48;
        byte[] r9 = r5.a;
        int r11 = (int) Math.min(r5.c, (((long) r5.b) + r12) - r6);
        int r1 = (int) ((((long) r5.b) + r0) - r6);
    L25:
        if (r1 >= r11) goto L32;
        if (r9[r1] != r7) goto L31;
        if (okio.internal.a.a(r5, r1 + 1, r8, r3) == false) goto L31;
    L66:
        return ((long) (r1 - r5.b)) + r6;
    L31:
        r1 = r1 + 1;
        goto L25
    L32:
        r6 = r6 + ((long) (r5.c - r5.b));
        r5 = r5.f;
        Intrinsics.checkNotNull(r5);
        r0 = r6;
    L33:
        long r10 = ((long) (r5.c - r5.b)) + r6;
        if (r10 > r0) goto L36;
        r5 = r5.f;
        Intrinsics.checkNotNull(r5);
        r6 = r10;
        goto L33
    L36:
        byte[] r13 = r17.internalArray$okio();
        byte r14 = r13[0];
        int r15 = r17.size();
        long r16 = (size() - ((long) r15)) + 1;
    L38:
        if (r6 >= r16) goto L48;
        byte[] r19 = r5.a;
        int r110 = (int) Math.min(r5.c, (((long) r5.b) + r16) - r6);
        r1 = (int) ((((long) r5.b) + r0) - r6);
    L40:
        if (r1 >= r110) goto L47;
        if (r19[r1] != r14) goto L46;
        if (okio.internal.a.a(r5, r1 + 1, r13, r15) == true) goto L66;
    L46:
        r1 = r1 + 1;
        goto L40
    L47:
        r6 = r6 + ((long) (r5.c - r5.b));
        r5 = r5.f;
        Intrinsics.checkNotNull(r5);
        r0 = r6;
        goto L38
    L51:
        throw new IllegalArgumentException(("fromIndex < 0: " + r0).toString());
    L53:
        throw new IllegalArgumentException("bytes is empty".toString());
    L5:
        r2 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString r12, long r13) {
        Intrinsics.checkNotNullParameter(r12, "targetBytes");
        long r2 = 0;
        if (r13 < 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L75;
        g0 r5 = this.head;
        if (r5 != null) goto L11;
        return -1;
    L11:
        if ((size() - r13) >= r13) goto L42;
        r2 = size();
    L14:
        if (r2 <= r13) goto L17;
        r5 = r5.g;
        Intrinsics.checkNotNull(r5);
        r2 = r2 - ((long) (r5.c - r5.b));
        goto L14
    L17:
        if (r12.size() != 2) goto L29;
        byte r0 = r12.getByte(0);
        byte r14 = r12.getByte(1);
    L20:
        if (r2 >= size()) goto L95;
        byte[] r1 = r5.a;
        int r15 = (int) ((((long) r5.b) + r13) - r2);
        int r16 = r5.c;
    L22:
        if (r15 >= r16) goto L28;
        byte r7 = r1[r15];
        if (r7 == r0) goto L57;
        if (r7 == r14) goto L57;
        r15 = r15 + 1;
    L57:
        int r17 = r5.b;
    L73:
        return ((long) (r15 - r17)) + r2;
    L28:
        r2 = r2 + ((long) (r5.c - r5.b));
        r5 = r5.f;
        Intrinsics.checkNotNull(r5);
        r13 = r2;
        goto L20
    L95:
        return -1;
    L29:
        byte[] r18 = r12.internalArray$okio();
    L31:
        if (r2 >= size()) goto L96;
        byte[] r3 = r5.a;
        r15 = (int) ((((long) r5.b) + r13) - r2);
        int r19 = r5.c;
    L33:
        if (r15 >= r19) goto L41;
        byte r8 = r3[r15];
        int r9 = r18.length;
        int r10 = 0;
    L35:
        if (r10 >= r9) goto L40;
        if (r8 == r18[r10]) goto L69;
        r10 = r10 + 1;
    L69:
        r17 = r5.b;
        goto L73
    L40:
        r15 = r15 + 1;
        goto L33
    L41:
        r2 = r2 + ((long) (r5.c - r5.b));
        r5 = r5.f;
        Intrinsics.checkNotNull(r5);
        r13 = r2;
        goto L31
    L96:
        return -1;
    L42:
        long r11 = ((long) (r5.c - r5.b)) + r2;
        if (r11 > r13) goto L46;
        r5 = r5.f;
        Intrinsics.checkNotNull(r5);
        r2 = r11;
        goto L42
    L46:
        if (r12.size() != 2) goto L60;
        byte r6 = r12.getByte(0);
        byte r110 = r12.getByte(1);
    L49:
        if (r2 >= size()) goto L97;
        byte[] r20 = r5.a;
        r15 = (int) ((((long) r5.b) + r13) - r2);
        int r111 = r5.c;
    L51:
        if (r15 >= r111) goto L59;
        byte r21 = r20[r15];
        if (r21 == r6) goto L57;
        if (r21 == r110) goto L57;
        r15 = r15 + 1;
        goto L51
    L59:
        r2 = r2 + ((long) (r5.c - r5.b));
        r5 = r5.f;
        Intrinsics.checkNotNull(r5);
        r13 = r2;
        goto L49
    L97:
        return -1;
    L60:
        byte[] r112 = r12.internalArray$okio();
    L62:
        if (r2 >= size()) goto L98;
        byte[] r22 = r5.a;
        r15 = (int) ((((long) r5.b) + r13) - r2);
        int r113 = r5.c;
    L64:
        if (r15 >= r113) goto L72;
        byte r23 = r22[r15];
        int r24 = r112.length;
        int r25 = 0;
    L66:
        if (r25 >= r24) goto L71;
        if (r23 == r112[r25]) goto L69;
        r25 = r25 + 1;
        goto L66
    L71:
        r15 = r15 + 1;
        goto L64
    L72:
        r2 = r2 + ((long) (r5.c - r5.b));
        r5 = r5.f;
        Intrinsics.checkNotNull(r5);
        r13 = r2;
        goto L62
    L98:
        return -1;
    L75:
        throw new IllegalArgumentException(("fromIndex < 0: " + r13).toString());
    L5:
        r4 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long r8, ByteString r10) {
        Intrinsics.checkNotNullParameter(r10, "bytes");
        return rangeEquals(r8, r10, 0, r10.size());
    }

    @Override // okio.Source
    public long read(Buffer r6, long r7) {
        Intrinsics.checkNotNullParameter(r6, "sink");
        if (r7 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L16;
        if (size() != 0) goto L11;
        return -1;
    L11:
        if (r7 <= size()) goto L13;
        r7 = size();
    L13:
        r6.write(this, r7);
        return r7;
    L16:
        throw new IllegalArgumentException(("byteCount < 0: " + r7).toString());
    L5:
        r2 = false;
        goto L6
    }

    public final Buffer readFrom(InputStream r5, long r6) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "input");
        if (r6 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        readFrom(r5, r6, false);
        return this;
    L10:
        throw new IllegalArgumentException(("byteCount < 0: " + r6).toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer r4, long r5) throws EOFException {
        Intrinsics.checkNotNullParameter(r4, "sink");
        if (size() < r5) goto L6;
        r4.write(this, r5);
        return;
    L6:
        r4.write(this, size());
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public String readString(long r8, Charset r10) throws EOFException {
        Intrinsics.checkNotNullParameter(r10, "charset");
        if (r8 >= 0) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L25;
        if (this.size < r8) goto L23;
        if (r8 != 0) goto L14;
        return "";
    L14:
        g0 r1 = this.head;
        Intrinsics.checkNotNull(r1);
        int r2 = r1.b;
        if ((((long) r2) + r8) > r1.c) goto L17;
        int r4 = (int) r8;
        String r3 = new String(r1.a, r2, r4, r10);
        int r11 = r1.b + r4;
        r1.b = r11;
        this.size -= r8;
        if (r11 != r1.c) goto L21;
        this.head = r1.a();
        h0.a(r1);
    L21:
        return r3;
    L17:
        return new String(readByteArray(r8), r10);
    L23:
        throw new EOFException();
    L25:
        throw new IllegalArgumentException(("byteCount: " + r8).toString());
    L5:
        if (r8 > 2147483647L) goto L7;
        r0 = true;
        goto L8
    }

    @Override // okio.Sink
    public void write(Buffer r13, long r14) {
        Intrinsics.checkNotNullParameter(r13, "source");
        if (r13 == this) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L64;
        b.b(r13.size(), 0, r14);
    L9:
        if (r14 <= 0) goto L73;
        g0 r3 = r13.head;
        Intrinsics.checkNotNull(r3);
        int r4 = r3.c;
        g0 r5 = r13.head;
        Intrinsics.checkNotNull(r5);
        if (r14 >= (r4 - r5.b)) goto L40;
        g0 r6 = this.head;
        if (r6 == null) goto L15;
        Intrinsics.checkNotNull(r6);
        g0 r7 = r6.g;
    L16:
        if (r7 != null) goto L18;
    L26:
        g0 r8 = r13.head;
        Intrinsics.checkNotNull(r8);
        int r9 = (int) r14;
        r8.getClass();
        if (r9 > 0) goto L29;
    L31:
        boolean r10 = false;
    L32:
        if (r10 == false) goto L39;
        if (r9 < 1024) goto L36;
        g0 r11 = r8.c();
    L37:
        r11.c = r11.b + r9;
        r8.b += r9;
        g0 r12 = r8.g;
        Intrinsics.checkNotNull(r12);
        r12.b(r11);
        r13.head = r11;
        goto L40
    L36:
        r11 = h0.b();
        byte[] r15 = r8.a;
        byte[] r16 = r11.a;
        int r17 = r8.b;
        ArraysKt.copyInto$default(r15, r16, 0, r17, r17 + r9, 2, null);
        goto L37
    L39:
        throw new IllegalArgumentException("byteCount out of range".toString());
    L29:
        if (r9 > (r8.c - r8.b)) goto L31;
        r10 = true;
        goto L32
    L18:
        if (r7.e == false) goto L26;
        long r18 = ((long) r7.c) + r14;
        if (r7.d == false) goto L22;
        int r19 = 0;
    L24:
        if ((r18 - ((long) r19)) > 8192) goto L26;
        g0 r0 = r13.head;
        Intrinsics.checkNotNull(r0);
        r0.d(r7, (int) r14);
        r13.setSize$okio(r13.size() - r14);
        setSize$okio(size() + r14);
        return;
    L22:
        r19 = r7.b;
        goto L24
    L15:
        r7 = null;
    L40:
        g0 r20 = r13.head;
        Intrinsics.checkNotNull(r20);
        long r21 = r20.c - r20.b;
        r13.head = r20.a();
        g0 r22 = this.head;
        if (r22 != null) goto L43;
        this.head = r20;
        r20.g = r20;
        r20.f = r20;
    L59:
        r13.setSize$okio(r13.size() - r21);
        setSize$okio(size() + r21);
        r14 = r14 - r21;
        goto L9
    L43:
        Intrinsics.checkNotNull(r22);
        g0 r23 = r22.g;
        Intrinsics.checkNotNull(r23);
        r23.b(r20);
        g0 r24 = r20.g;
        if (r24 == r20) goto L46;
        boolean r25 = true;
    L47:
        if (r25 == false) goto L61;
        Intrinsics.checkNotNull(r24);
        if (r24.e == false) goto L59;
        int r26 = r20.c - r20.b;
        g0 r27 = r20.g;
        Intrinsics.checkNotNull(r27);
        int r28 = 8192 - r27.c;
        g0 r29 = r20.g;
        Intrinsics.checkNotNull(r29);
        if (r29.d == false) goto L54;
        int r30 = 0;
    L56:
        if (r26 > (r28 + r30)) goto L59;
        g0 r31 = r20.g;
        Intrinsics.checkNotNull(r31);
        r20.d(r31, r26);
        r20.a();
        h0.a(r20);
        goto L59
    L54:
        g0 r32 = r20.g;
        Intrinsics.checkNotNull(r32);
        r30 = r32.b;
        goto L56
    L61:
        throw new IllegalStateException("cannot compact".toString());
    L46:
        r25 = false;
        goto L47
    L73:
        return;
    L64:
        throw new IllegalArgumentException("source == this".toString());
    L5:
        r2 = false;
        goto L6
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String r3, Charset r4) {
        Intrinsics.checkNotNullParameter(r3, "string");
        Intrinsics.checkNotNullParameter(r4, "charset");
        return writeString(r3, 0, r3.length(), r4);
    }

    public final Buffer writeTo(OutputStream r8, long r9) throws IOException {
        Intrinsics.checkNotNullParameter(r8, "out");
        b.b(this.size, 0, r9);
        g0 r0 = this.head;
    L4:
        if (r9 <= 0) goto L8;
        Intrinsics.checkNotNull(r0);
        int r2 = (int) Math.min(r9, r0.c - r0.b);
        r8.write(r0.a, r0.b, r2);
        int r1 = r0.b + r2;
        r0.b = r1;
        long r5 = r2;
        this.size -= r5;
        r9 = r9 - r5;
        if (r1 != r0.c) goto L4;
        g0 r3 = r0.a();
        this.head = r3;
        h0.a(r0);
        r0 = r3;
        goto L4
    L8:
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r7, long r8) {
        return indexOf(r7, r8, LongCompanionObject.MAX_VALUE);
    }

    @Override // okio.BufferedSink
    public Buffer write(Source r6, long r7) throws IOException {
        Intrinsics.checkNotNullParameter(r6, "source");
    L4:
        if (r7 <= 0) goto L10;
        long r0 = r6.read(this, r7);
        if (r0 == (-1)) goto L9;
        r7 = r7 - r0;
        goto L4
    L9:
        throw new EOFException();
    L10:
        return this;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeString(String r1, Charset r2) {
        return writeString(r1, r2);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(Source r1, long r2) {
        return write(r1, r2);
    }

    private final void readFrom(InputStream r5, long r6, boolean r8) throws IOException {
    L3:
        if (r6 > 0) goto L7;
        if (r8 == true) goto L7;
        return;
    L7:
        g0 r0 = writableSegment$okio(1);
        int r1 = r5.read(r0.a, r0.c, (int) Math.min(r6, 8192 - r0.c));
        if (r1 == (-1)) goto L10;
        r0.c += r1;
        long r2 = r1;
        this.size += r2;
        r6 = r6 - r2;
        goto L3
    L10:
        if (r0.b != r0.c) goto L12;
        this.head = r0.a();
        h0.a(r0);
    L12:
        if (r8 == false) goto L15;
        return;
    L15:
        throw new EOFException();
    }

    public final Buffer copyTo(Buffer r8, long r9, long r11) {
        Intrinsics.checkNotNullParameter(r8, "out");
        b.b(size(), r9, r11);
        if (r11 == 0) goto L16;
        r8.setSize$okio(r8.size() + r11);
        g0 r2 = this.head;
    L6:
        Intrinsics.checkNotNull(r2);
        long r3 = r2.c - r2.b;
        if (r9 < r3) goto L10;
        r9 = r9 - r3;
        r2 = r2.f;
    L10:
        if (r11 <= 0) goto L16;
        Intrinsics.checkNotNull(r2);
        g0 r4 = r2.c();
        int r5 = r4.b + ((int) r9);
        r4.b = r5;
        r4.c = Math.min(r5 + ((int) r11), r4.c);
        g0 r10 = r8.head;
        if (r10 != null) goto L14;
        r4.g = r4;
        r4.f = r4;
        r8.head = r4;
    L15:
        r11 = r11 - ((long) (r4.c - r4.b));
        r2 = r2.f;
        r9 = 0;
        goto L10
    L14:
        Intrinsics.checkNotNull(r10);
        g0 r12 = r10.g;
        Intrinsics.checkNotNull(r12);
        r12.b(r4);
    L16:
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte r11, long r12, long r14) {
        boolean r0 = false;
        long r1 = 0;
        if (0 <= r12) goto L5;
    L7:
        if (r0 == false) goto L46;
        if (r14 <= size()) goto L12;
        r14 = size();
    L12:
        if (r12 == r14) goto L55;
        g0 r2 = this.head;
        if (r2 != null) goto L18;
        return -1;
    L18:
        if ((size() - r12) >= r12) goto L32;
        r1 = size();
    L21:
        if (r1 <= r12) goto L24;
        r2 = r2.g;
        Intrinsics.checkNotNull(r2);
        r1 = r1 - ((long) (r2.c - r2.b));
    L24:
        if (r1 >= r14) goto L57;
        byte[] r5 = r2.a;
        int r7 = (int) Math.min(r2.c, (((long) r2.b) + r14) - r1);
        int r13 = (int) ((((long) r2.b) + r12) - r1);
    L26:
        if (r13 >= r7) goto L31;
        if (r5[r13] == r11) goto L44;
        r13 = r13 + 1;
    L44:
        return ((long) (r13 - r2.b)) + r1;
    L31:
        r1 = r1 + ((long) (r2.c - r2.b));
        r2 = r2.f;
        Intrinsics.checkNotNull(r2);
        r12 = r1;
        goto L24
    L57:
        return -1;
    L32:
        long r6 = ((long) (r2.c - r2.b)) + r1;
        if (r6 > r12) goto L36;
        r2 = r2.f;
        Intrinsics.checkNotNull(r2);
        r1 = r6;
    L36:
        if (r1 >= r14) goto L58;
        byte[] r8 = r2.a;
        int r9 = (int) Math.min(r2.c, (((long) r2.b) + r14) - r1);
        r13 = (int) ((((long) r2.b) + r12) - r1);
    L38:
        if (r13 >= r9) goto L43;
        if (r8[r13] == r11) goto L44;
        r13 = r13 + 1;
        goto L38
    L43:
        r1 = r1 + ((long) (r2.c - r2.b));
        r2 = r2.f;
        Intrinsics.checkNotNull(r2);
        r12 = r1;
        goto L36
    L58:
        return -1;
    L55:
        return -1;
    L46:
        throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + r12 + " toIndex=" + r14).toString());
    L5:
        if (r12 > r14) goto L7;
        r0 = true;
        goto L7
    }

    @Override // okio.BufferedSource
    public int read(byte[] r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "sink");
        b.b(r8.length, r9, r10);
        g0 r0 = this.head;
        if (r0 != null) goto L5;
        return -1;
    L5:
        int r11 = Math.min(r10, r0.c - r0.b);
        byte[] r1 = r0.a;
        int r2 = r0.b;
        ArraysKt.copyInto(r1, r8, r9, r2, r2 + r11);
        r0.b += r11;
        setSize$okio(size() - ((long) r11));
        if (r0.b != r0.c) goto L9;
        this.head = r0.a();
        h0.a(r0);
    L9:
        return r11;
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "source");
        long r7 = r12;
        b.b(r10.length, r11, r7);
        int r13 = r12 + r11;
    L3:
        if (r11 >= r13) goto L5;
        g0 r0 = writableSegment$okio(1);
        int r1 = Math.min(r13 - r11, 8192 - r0.c);
        int r4 = r11 + r1;
        ArraysKt.copyInto(r10, r0.a, r0.c, r11, r4);
        r0.c += r1;
        r11 = r4;
        goto L3
    L5:
        setSize$okio(size() + r7);
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r12, "string");
        if (r13 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L58;
        if (r14 < r13) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L56;
        if (r14 > r12.length()) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L54;
    L16:
        if (r13 >= r14) goto L52;
        char r5 = r12.charAt(r13);
        if (r5 < 128) goto L19;
        if (r5 < 2048) goto L28;
        if (r5 < 55296) goto L51;
        if (r5 > 57343) goto L51;
        int r6 = r13 + 1;
        if (r6 >= r14) goto L38;
        char r7 = r12.charAt(r6);
    L40:
        if (r5 > 56319) goto L50;
        if (56320 <= r7) goto L44;
    L46:
        boolean r8 = false;
    L47:
        if (r8 == false) goto L50;
        int r9 = (((r5 & 1023) << 10) | (r7 & 1023)) + 65536;
        g0 r10 = writableSegment$okio(4);
        byte[] r11 = r10.a;
        int r15 = r10.c;
        r11[r15] = (byte) ((r9 >> 18) | 240);
        r11[r15 + 1] = (byte) (((r9 >> 12) & 63) | 128);
        r11[r15 + 2] = (byte) (((r9 >> 6) & 63) | 128);
        r11[r15 + 3] = (byte) ((r9 & 63) | 128);
        r10.c = r15 + 4;
        setSize$okio(size() + 4);
        r13 = r13 + 2;
        goto L16
    L44:
        if (r7 >= 57344) goto L46;
        r8 = true;
    L50:
        writeByte(63);
        r13 = r6;
        goto L16
    L38:
        r7 = 0;
    L51:
        g0 r16 = writableSegment$okio(3);
        byte[] r17 = r16.a;
        int r18 = r16.c;
        r17[r18] = (byte) ((r5 >> '\f') | 224);
        r17[r18 + 1] = (byte) ((63 & (r5 >> 6)) | 128);
        r17[r18 + 2] = (byte) ((r5 & '?') | 128);
        r16.c = r18 + 3;
        setSize$okio(size() + 3);
    L29:
        r13 = r13 + 1;
        goto L16
    L28:
        g0 r19 = writableSegment$okio(2);
        byte[] r20 = r19.a;
        int r21 = r19.c;
        r20[r21] = (byte) ((r5 >> 6) | 192);
        r20[r21 + 1] = (byte) ((r5 & '?') | 128);
        r19.c = r21 + 2;
        setSize$okio(size() + 2);
        goto L29
    L19:
        g0 r22 = writableSegment$okio(1);
        byte[] r23 = r22.a;
        int r24 = r22.c - r13;
        int r25 = Math.min(r14, 8192 - r24);
        int r26 = r13 + 1;
        r23[r13 + r24] = (byte) r5;
    L20:
        r13 = r26;
        if (r13 >= r25) goto L25;
        char r27 = r12.charAt(r13);
        if (r27 >= 128) goto L25;
        r26 = r13 + 1;
        r23[r13 + r24] = (byte) r27;
    L25:
        int r28 = r22.c;
        int r29 = (r24 + r13) - r28;
        r22.c = r28 + r29;
        setSize$okio(size() + ((long) r29));
        goto L16
    L52:
        return this;
    L54:
        throw new IllegalArgumentException(("endIndex > string.length: " + r14 + " > " + r12.length()).toString());
    L14:
        r4 = false;
        goto L15
    L56:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r14 + " < " + r13).toString());
    L9:
        r3 = false;
        goto L10
    L58:
        throw new IllegalArgumentException(("beginIndex < 0: " + r13).toString());
    L5:
        r2 = false;
        goto L6
    }

    public final Buffer copyTo(OutputStream r9, long r10, long r12) throws IOException {
        Intrinsics.checkNotNullParameter(r9, "out");
        b.b(this.size, r10, r12);
        if (r12 != 0) goto L5;
        return this;
    L5:
        g0 r2 = this.head;
    L6:
        Intrinsics.checkNotNull(r2);
        int r3 = r2.c;
        int r4 = r2.b;
        if (r10 < (r3 - r4)) goto L10;
        r10 = r10 - ((long) (r3 - r4));
        r2 = r2.f;
    L10:
        if (r12 <= 0) goto L12;
        Intrinsics.checkNotNull(r2);
        int r11 = (int) (((long) r2.b) + r10);
        int r13 = (int) Math.min(r2.c - r11, r12);
        r9.write(r2.a, r11, r13);
        r12 = r12 - ((long) r13);
        r2 = r2.f;
        r10 = 0;
        goto L10
    L12:
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "byteString");
        r2.write$okio(this, r3, r4);
        return this;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeUtf8(String r1, int r2, int r3) {
        return writeUtf8(r1, r2, r3);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(ByteString r1, int r2, int r3) {
        return write(r1, r2, r3);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(byte[] r1, int r2, int r3) {
        return write(r1, r2, r3);
    }

    public static /* synthetic */ a readAndWriteUnsafe$default(Buffer r0, a r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = b.a;
    L6:
        return r0.readAndWriteUnsafe(r1);
    }

    public static /* synthetic */ a readUnsafe$default(Buffer r0, a r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = b.a;
    L6:
        return r0.readUnsafe(r1);
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long r7, ByteString r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "bytes");
        if (r7 < 0) goto L21;
        if (r10 < 0) goto L22;
        if (r11 >= 0) goto L7;
        return false;
    L7:
        if ((size() - r7) >= r11) goto L9;
        return false;
    L9:
        if ((r9.size() - r10) < r11) goto L25;
        int r0 = 0;
    L12:
        if (r0 >= r11) goto L17;
        if (getByte(((long) r0) + r7) != r9.getByte(r10 + r0)) goto L26;
        r0 = r0 + 1;
        goto L12
    L26:
        return false;
    L17:
        return true;
    L25:
        return false;
    L22:
        return false;
    L21:
        return false;
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String r4, int r5, int r6, Charset r7) {
        Intrinsics.checkNotNullParameter(r4, "string");
        Intrinsics.checkNotNullParameter(r7, "charset");
        boolean r0 = true;
        if (r5 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L27;
        if (r6 < r5) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L25;
        if (r6 <= r4.length()) goto L15;
        r0 = false;
    L15:
        if (r0 == false) goto L23;
        if (Intrinsics.areEqual(r7, Charsets.UTF_8) == true) goto L19;
        byte[] r8 = r4.substring(r5, r6).getBytes(r7);
        return write(r8, 0, r8.length);
    L19:
        return writeUtf8(r4, r5, r6);
    L23:
        throw new IllegalArgumentException(("endIndex > string.length: " + r6 + " > " + r4.length()).toString());
    L25:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r6 + " < " + r5).toString());
    L9:
        r3 = false;
        goto L10
    L27:
        throw new IllegalArgumentException(("beginIndex < 0: " + r5).toString());
    L5:
        r2 = false;
        goto L6
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeString(String r1, int r2, int r3, Charset r4) {
        return writeString(r1, r2, r3, r4);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer r0, Buffer r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return r0.copyTo(r1, r2);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer r0, OutputStream r1, long r2, int r4, Object r5) throws IOException {
        if ((r4 & 2) == 0) goto L6;
        r2 = r0.size;
    L6:
        return r0.writeTo(r1, r2);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer r6, OutputStream r7, long r8, long r10, int r12, Object r13) throws IOException {
        if ((r12 & 2) == 0) goto L5;
        r8 = 0;
    L5:
        long r2 = r8;
        if ((r12 & 4) == 0) goto L9;
        r10 = r6.size - r2;
    L9:
        return r6.copyTo(r7, r2, r10);
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer r6, Buffer r7, long r8, long r10, int r12, Object r13) {
        if ((r12 & 2) == 0) goto L6;
        r8 = 0;
    L6:
        return r6.copyTo(r7, r8, r10);
    }
}
