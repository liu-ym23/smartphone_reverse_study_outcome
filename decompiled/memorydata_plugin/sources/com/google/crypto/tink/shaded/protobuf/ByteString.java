package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ByteString implements Serializable, Iterable<Byte> {
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY = null;
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    private static final int UNSIGNED_BYTE_MASK = 255;
    private static final Comparator<ByteString> UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = null;
    private static final c byteArrayCopier = null;
    private static final long serialVersionUID = 1;
    private int hash;

    private static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        BoundedByteString(byte[] r2, int r3, int r4) {
            super(r2);
            checkRange(r3, r3 + r4, r2.length);
            this.bytesOffset = r3;
            this.bytesLength = r4;
        }

        private void readObject(ObjectInputStream r1) {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        public byte byteAt(int r2) {
            checkIndex(r2, size());
            return this.bytes[this.bytesOffset + r2];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        public void copyToInternal(byte[] r2, int r3, int r4, int r5) {
            System.arraycopy(this.bytes, getOffsetIntoBytes() + r3, r2, r4, r5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString
        public int getOffsetIntoBytes() {
            return this.bytesOffset;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        byte internalByteAt(int r2) {
            return this.bytes[this.bytesOffset + r2];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LiteralByteString, com.google.crypto.tink.shaded.protobuf.ByteString
        public int size() {
            return this.bytesLength;
        }

        Object writeReplace() {
            return ByteString.wrap(toByteArray());
        }
    }

    static abstract class LeafByteString extends ByteString {
        private static final long serialVersionUID = 1;

        LeafByteString() {
        }

        abstract boolean equalsRange(ByteString r1, int r2, int r3);

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final int getTreeDepth() {
            return 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final boolean isBalanced() {
            return true;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        void writeToReverse(j r1) {
            writeTo(r1);
        }
    }

    private static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        LiteralByteString(byte[] r1) {
            Objects.requireNonNull(r1);
            this.bytes = r1;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public byte byteAt(int r1) {
            return this.bytes[r1];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final void copyTo(ByteBuffer r3) {
            r3.put(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public void copyToInternal(byte[] r1, int r2, int r3, int r4) {
            System.arraycopy(this.bytes, r2, r1, r3, r4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final boolean equals(Object r7) {
            if (r7 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, ByteString.class) == true) goto L9;
            return false;
        L9:
            if (size() == ((ByteString) ZeusTransformUtils.preCheckCast(r7, ByteString.class, "com.obric.memorydata.plugin")).size()) goto L12;
            return false;
        L12:
            if (size() != 0) goto L15;
            return true;
        L15:
            if (ZeusTransformUtils.instanceOf(r7, LiteralByteString.class) == false) goto L24;
            LiteralByteString r1 = (LiteralByteString) ZeusTransformUtils.preCheckCast(r7, LiteralByteString.class, "com.obric.memorydata.plugin");
            int r2 = peekCachedHashCode();
            int r3 = r1.peekCachedHashCode();
            if (r2 == 0) goto L22;
            if (r3 == 0) goto L22;
            if (r2 == r3) goto L22;
            return false;
        L22:
            return equalsRange((LiteralByteString) ZeusTransformUtils.preCheckCast(r7, LiteralByteString.class, "com.obric.memorydata.plugin"), 0, size());
        L24:
            return r7.equals(this);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LeafByteString
        final boolean equalsRange(ByteString r5, int r6, int r7) {
            if (r7 > r5.size()) goto L21;
            int r1 = r6 + r7;
            if (r1 > r5.size()) goto L19;
            if (ZeusTransformUtils.instanceOf(r5, LiteralByteString.class) == false) goto L17;
            LiteralByteString r8 = (LiteralByteString) ZeusTransformUtils.preCheckCast(r5, LiteralByteString.class, "com.obric.memorydata.plugin");
            byte[] r0 = this.bytes;
            byte[] r2 = r8.bytes;
            int r3 = getOffsetIntoBytes() + r7;
            int r4 = getOffsetIntoBytes();
            int r9 = r8.getOffsetIntoBytes() + r6;
        L9:
            if (r4 >= r3) goto L14;
            if (r0[r4] != r2[r9]) goto L12;
            r4 = r4 + 1;
            r9 = r9 + 1;
            goto L9
        L12:
            return false;
        L14:
            return true;
        L17:
            return r5.substring(r6, r1).equals(substring(0, r7));
        L19:
            throw new IllegalArgumentException("Ran off end of other: " + r6 + ", " + r7 + ", " + r5.size());
        L21:
            throw new IllegalArgumentException("Length too large: " + r7 + size());
        }

        public int getOffsetIntoBytes() {
            return 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        byte internalByteAt(int r1) {
            return this.bytes[r1];
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final boolean isValidUtf8() {
            int r0 = getOffsetIntoBytes();
            return Utf8.a(this.bytes, r0, size() + r0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final k newCodedInput() {
            return k.a(this.bytes, getOffsetIntoBytes(), size(), true);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final InputStream newInput() {
            return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final int partialHash(int r2, int r3, int r4) {
            return ab.a(r2, this.bytes, getOffsetIntoBytes() + r3, r4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final int partialIsValidUtf8(int r2, int r3, int r4) {
            int r0 = getOffsetIntoBytes() + r3;
            return Utf8.a(r2, this.bytes, r0, r4 + r0);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public int size() {
            return this.bytes.length;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final ByteString substring(int r3, int r4) {
            int r5 = checkRange(r3, r4, size());
            if (r5 != 0) goto L7;
            return ByteString.EMPTY;
        L7:
            return new BoundedByteString(this.bytes, getOffsetIntoBytes() + r3, r5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final String toStringInternal(Charset r4) {
            return new String(this.bytes, getOffsetIntoBytes(), size(), r4);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        final void writeTo(j r3) {
            r3.a(this.bytes, getOffsetIntoBytes(), size());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        public final void writeTo(OutputStream r1) {
            r1.write(toByteArray());
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString
        final void writeToInternal(OutputStream r2, int r3, int r4) {
            r2.write(this.bytes, getOffsetIntoBytes() + r3, r4);
        }
    }

    static abstract class a implements d {
        a() {
        }

        public final Byte b() {
            return Byte.valueOf(a());
        }

        @Override // java.util.Iterator
        public /* synthetic */ Byte next() {
            return b();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private static final class b implements c {
        private b() {
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.c
        public byte[] a(byte[] r1, int r2, int r3) {
            return Arrays.copyOfRange(r1, r2, r3 + r2);
        }
    }

    private interface c {
        byte[] a(byte[] r1, int r2, int r3);
    }

    public interface d extends Iterator<Byte> {
        byte a();
    }

    static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CodedOutputStream f4898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f4899b;

        private e(int r1) {
            byte[] r2 = new byte[r1];
            this.f4899b = r2;
            this.f4898a = CodedOutputStream.a(r2);
        }

        /* synthetic */ e(int r1, AnonymousClass1 r2) {
            this(r1);
        }

        public ByteString a() {
            this.f4898a.d();
            return new LiteralByteString(this.f4899b);
        }

        public CodedOutputStream b() {
            return this.f4898a;
        }
    }

    public static final class f extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final byte[] f4900a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f4901b;
        private final ArrayList<ByteString> c;
        private int d;
        private byte[] e;
        private int f;

        static {
            f4900a = new byte[0];
        }

        f(int r2) {
            if (r2 < 0) goto L7;
            this.f4901b = r2;
            this.c = new ArrayList();
            this.e = new byte[r2];
            return;
        L7:
            throw new IllegalArgumentException("Buffer size < 0");
        }

        private void a(int r4) {
            this.c.add(new LiteralByteString(this.e));
            int r0 = this.d + this.e.length;
            this.d = r0;
            this.e = new byte[Math.max(this.f4901b, Math.max(r4, r0 >>> 1))];
            this.f = 0;
        }

        public synchronized int a() {
            monitor-enter(this);
            int r0 = this.d + this.f;
            monitor-exit(this);
            return r0;
        L7:
            th = move-exception;
            throw th;
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(a())});
        }

        @Override // java.io.OutputStream
        public synchronized void write(int r4) {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.f != this.e.length) goto L6;
            a(1);     // Catch: Throwable -> L9
        L6:
            byte[] r0 = this.e;     // Catch: Throwable -> L9
            int r1 = this.f;     // Catch: Throwable -> L9
            this.f = r1 + 1;     // Catch: Throwable -> L9
            r0[r1] = (byte) r4;     // Catch: Throwable -> L9
            monitor-exit(this);
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] r4, int r5, int r6) {
            monitor-enter(this);
            byte[] r0 = this.e;     // Catch: Throwable -> L9
            int r1 = r0.length;     // Catch: Throwable -> L9
            int r2 = this.f;     // Catch: Throwable -> L9
            if (r6 > (r1 - r2)) goto L6;
            System.arraycopy(r4, r5, r0, r2, r6);     // Catch: Throwable -> L9
            this.f += r6;     // Catch: Throwable -> L9
        L7:
            monitor-exit(this);
            return;
        L6:
            int r3 = r0.length - r2;     // Catch: Throwable -> L9
            System.arraycopy(r4, r5, r0, r2, r3);     // Catch: Throwable -> L9
            int r7 = r6 - r3;     // Catch: Throwable -> L9
            a(r7);     // Catch: Throwable -> L9
            System.arraycopy(r4, r5 + r3, this.e, 0, r7);     // Catch: Throwable -> L9
            this.f = r7;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }
    }

    private static final class g implements c {
        private g() {
        }

        /* synthetic */ g(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ByteString.c
        public byte[] a(byte[] r2, int r3, int r4) {
            byte[] r1 = new byte[r4];
            System.arraycopy(r2, r3, r1, 0, r4);
            return r1;
        }
    }

    static {
        EMPTY = new LiteralByteString(ab.d);
        AnonymousClass1 r1 = null;
        if (com.google.crypto.tink.shaded.protobuf.d.a() == false) goto L5;
        c r0 = new g(r1);
    L6:
        byteArrayCopier = r0;
        UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = new AnonymousClass2();
        return;
    L5:
        r0 = new b(r1);
        goto L6
    }

    ByteString() {
        this.hash = 0;
    }

    static /* synthetic */ int access$200(byte r0) {
        return toInt(r0);
    }

    private static ByteString balancedConcat(Iterator<ByteString> r2, int r3) {
        Iterator r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        if (r3 < 1) goto L9;
        if (r3 == 1) goto L10;
        int r0 = r3 >>> 1;
        return balancedConcat(r4, r0).concat(balancedConcat(r4, r3 - r0));
    L10:
        return (ByteString) ZeusTransformUtils.preCheckCast(r4.next(), ByteString.class, "com.obric.memorydata.plugin");
    L9:
        throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(r3)}));
    }

    static void checkIndex(int r3, int r4) {
        if (((r4 - (r3 + 1)) | r3) >= 0) goto L9;
        if (r3 >= 0) goto L8;
        throw new ArrayIndexOutOfBoundsException("Index < 0: " + r3);
    L8:
        throw new ArrayIndexOutOfBoundsException("Index > length: " + r3 + ", " + r4);
    }

    static int checkRange(int r3, int r4, int r5) {
        int r0 = r4 - r3;
        if ((((r3 | r4) | r0) | (r5 - r4)) >= 0) goto L12;
        if (r3 < 0) goto L11;
        if (r4 >= r3) goto L9;
        throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + r3 + ", " + r4);
    L9:
        throw new IndexOutOfBoundsException("End index: " + r4 + " >= " + r5);
    L11:
        throw new IndexOutOfBoundsException("Beginning index: " + r3 + " < 0");
    L12:
        return r0;
    }

    public static ByteString copyFrom(Iterable<ByteString> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L8;
        int r0 = 0;
        Iterator r1 = r4.iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        r1.next();
        r0 = r0 + 1;
    L9:
        if (r0 != 0) goto L13;
        return EMPTY;
    L13:
        return balancedConcat(r4.iterator(), r0);
    L8:
        r0 = ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).size();
        goto L9
    }

    public static ByteString copyFrom(String r1, String r2) {
        return new LiteralByteString(r1.getBytes(r2));
    }

    public static ByteString copyFrom(String r1, Charset r2) {
        return new LiteralByteString(r1.getBytes(r2));
    }

    public static ByteString copyFrom(ByteBuffer r1) {
        return copyFrom(r1, r1.remaining());
    }

    public static ByteString copyFrom(ByteBuffer r2, int r3) {
        checkRange(0, r3, r2.remaining());
        byte[] r4 = new byte[r3];
        r2.get(r4);
        return new LiteralByteString(r4);
    }

    public static ByteString copyFrom(byte[] r2) {
        return copyFrom(r2, 0, r2.length);
    }

    public static ByteString copyFrom(byte[] r2, int r3, int r4) {
        checkRange(r3, r3 + r4, r2.length);
        return new LiteralByteString(byteArrayCopier.a(r2, r3, r4));
    }

    public static ByteString copyFromUtf8(String r2) {
        return new LiteralByteString(r2.getBytes(ab.f4938b));
    }

    public static final ByteString empty() {
        return EMPTY;
    }

    private static int extractHexDigit(String r3, int r4) {
        int r0 = hexDigit(r3.charAt(r4));
        if (r0 == (-1)) goto L6;
        return r0;
    L6:
        throw new NumberFormatException("Invalid hexString " + r3 + " must only contain [0-9a-fA-F] but contained " + r3.charAt(r4) + " at index " + r4);
    }

    public static ByteString fromHex(String r5) {
        if ((r5.length() % 2) != 0) goto L10;
        int r0 = r5.length() / 2;
        byte[] r1 = new byte[r0];
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L8;
        int r3 = r2 * 2;
        r1[r2] = (byte) (extractHexDigit(r5, r3 + 1) | (extractHexDigit(r5, r3) << 4));
        r2 = r2 + 1;
        goto L5
    L8:
        return new LiteralByteString(r1);
    L10:
        throw new NumberFormatException("Invalid hexString " + r5 + " of length " + r5.length() + " must be even.");
    }

    private static int hexDigit(char r2) {
        if (r2 >= '0') goto L5;
    L8:
        char r0 = 'A';
        if (r2 >= 'A') goto L11;
    L14:
        r0 = 'a';
        if (r2 >= 'a') goto L17;
        return -1;
    L17:
        if (r2 <= 'f') goto L13;
        return -1;
    L13:
        return (r2 - r0) + 10;
    L11:
        if (r2 > 'F') goto L14;
    L5:
        if (r2 > '9') goto L8;
        return r2 - '0';
    }

    static e newCodedBuilder(int r2) {
        return new e(r2, null);
    }

    public static f newOutput() {
        return new f(128);
    }

    public static f newOutput(int r1) {
        return new f(r1);
    }

    private static ByteString readChunk(InputStream r5, int r6) {
        byte[] r0 = new byte[r6];
        int r2 = 0;
    L3:
        if (r2 >= r6) goto L8;
        int r3 = r5.read(r0, r2, r6 - r2);
        if (r3 == (-1)) goto L8;
        r2 = r2 + r3;
    L8:
        if (r2 != 0) goto L12;
        return null;
    L12:
        return copyFrom(r0, 0, r2);
    }

    public static ByteString readFrom(InputStream r2) {
        return readFrom(r2, 256, 8192);
    }

    public static ByteString readFrom(InputStream r0, int r1) {
        return readFrom(r0, r1, r1);
    }

    public static ByteString readFrom(InputStream r2, int r3, int r4) {
        ArrayList r0 = new ArrayList();
    L3:
        ByteString r1 = readChunk(r2, r3);
        if (r1 == null) goto L6;
        r0.add(r1);
        r3 = Math.min(r3 * 2, r4);
        goto L3
    L6:
        return copyFrom(r0);
    }

    private static int toInt(byte r0) {
        return r0 & 255;
    }

    private String truncateAndEscapeForDisplay() {
        if (size() > 50) goto L6;
        return bs.a(this);
    L6:
        return bs.a(substring(0, 47)) + "...";
    }

    public static Comparator<ByteString> unsignedLexicographicalComparator() {
        return UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    }

    static ByteString wrap(ByteBuffer r3) {
        if (r3.hasArray() == false) goto L7;
        int r0 = r3.arrayOffset();
        return wrap(r3.array(), r0 + r3.position(), r3.remaining());
    L7:
        return new NioByteString(r3);
    }

    static ByteString wrap(byte[] r1) {
        return new LiteralByteString(r1);
    }

    static ByteString wrap(byte[] r1, int r2, int r3) {
        return new BoundedByteString(r1, r2, r3);
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int r1);

    public final ByteString concat(ByteString r4) {
        if ((Integer.MAX_VALUE - size()) < r4.size()) goto L7;
        return RopeByteString.concatenate(this, r4);
    L7:
        throw new IllegalArgumentException("ByteString would be too long: " + size() + Marker.ANY_NON_NULL_MARKER + r4.size());
    }

    public abstract void copyTo(ByteBuffer r1);

    public void copyTo(byte[] r3, int r4) {
        copyTo(r3, 0, r4, size());
    }

    @Deprecated
    public final void copyTo(byte[] r3, int r4, int r5, int r6) {
        checkRange(r4, r4 + r6, size());
        checkRange(r5, r5 + r6, r3.length);
        if (r6 <= 0) goto L6;
        copyToInternal(r3, r4, r5, r6);
        return;
    }

    public abstract void copyToInternal(byte[] r1, int r2, int r3, int r4);

    public final boolean endsWith(ByteString r3) {
        if (size() >= r3.size()) goto L5;
    L7:
        return false;
    L5:
        if (substring(size() - r3.size()).equals(r3) == false) goto L7;
        return true;
    }

    public abstract boolean equals(Object r1);

    public abstract int getTreeDepth();

    public final int hashCode() {
        int r0 = this.hash;
        if (r0 != 0) goto L8;
        int r1 = size();
        r0 = partialHash(r1, 0, r1);
        if (r0 != 0) goto L7;
        r0 = 1;
    L7:
        this.hash = r0;
    L8:
        return r0;
    }

    abstract byte internalByteAt(int r1);

    public abstract boolean isBalanced();

    public final boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public abstract boolean isValidUtf8();

    @Override // java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator2() {
        return iterator();
    }

    public abstract k newCodedInput();

    public abstract InputStream newInput();

    public abstract int partialHash(int r1, int r2, int r3);

    public abstract int partialIsValidUtf8(int r1, int r2, int r3);

    public final int peekCachedHashCode() {
        return this.hash;
    }

    public abstract int size();

    public final boolean startsWith(ByteString r4) {
        if (size() >= r4.size()) goto L5;
        return false;
    L5:
        if (substring(0, r4.size()).equals(r4) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final ByteString substring(int r2) {
        return substring(r2, size());
    }

    public abstract ByteString substring(int r1, int r2);

    public final byte[] toByteArray() {
        int r0 = size();
        if (r0 == 0) goto L5;
        byte[] r1 = new byte[r0];
        copyToInternal(r1, 0, 0, r0);
        return r1;
    L5:
        return ab.d;
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), truncateAndEscapeForDisplay()});
    }

    public final String toString(String r2) {
        return toString(Charset.forName(r2));
    L4:
        e = move-exception;
        UnsupportedEncodingException r0 = new UnsupportedEncodingException(r2);
        r0.initCause(e);
        throw r0;
    }

    public final String toString(Charset r2) {
        if (size() != 0) goto L6;
        return "";
    L6:
        return toStringInternal(r2);
    }

    public abstract String toStringInternal(Charset r1);

    public final String toStringUtf8() {
        return toString(ab.f4938b);
    }

    abstract void writeTo(j r1);

    public abstract void writeTo(OutputStream r1);

    final void writeTo(OutputStream r3, int r4, int r5) {
        checkRange(r4, r4 + r5, size());
        if (r5 <= 0) goto L6;
        writeToInternal(r3, r4, r5);
        return;
    }

    abstract void writeToInternal(OutputStream r1, int r2, int r3);

    abstract void writeToReverse(j r1);
}
