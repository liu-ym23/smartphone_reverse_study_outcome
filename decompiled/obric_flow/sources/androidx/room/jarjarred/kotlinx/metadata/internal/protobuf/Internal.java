package androidx.room.jarjarred.kotlinx.metadata.internal.protobuf;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Internal {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final byte[] EMPTY_BYTE_ARRAY = null;
    public static final ByteBuffer EMPTY_BYTE_BUFFER = null;

    public interface EnumLite {
        int getNumber();
    }

    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int r5);
    }

    static {
        byte[] r5 = new byte[0];
        EMPTY_BYTE_ARRAY = r5;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(r5);
    }

    public Internal() {
    }

    public static byte[] byteArrayDefaultValue(String r5) {
        return r5.getBytes("ISO-8859-1");
    L4:
        e = move-exception;
        throw new IllegalStateException("Java VM does not support a standard character set.", e);
    }

    public static ByteBuffer byteBufferDefaultValue(String r5) {
        return ByteBuffer.wrap(byteArrayDefaultValue(r5));
    }

    public static ByteString bytesDefaultValue(String r5) {
        return ByteString.copyFrom(r5.getBytes("ISO-8859-1"));
    L4:
        e = move-exception;
        throw new IllegalStateException("Java VM does not support a standard character set.", e);
    }

    public static ByteBuffer copyByteBuffer(ByteBuffer r5) {
        ByteBuffer r10 = r5.duplicate();
        r10.clear();
        ByteBuffer r11 = ByteBuffer.allocate(r10.capacity());
        r11.put(r10);
        r11.clear();
        return r11;
    }

    public static boolean equals(List<byte[]> r5, List<byte[]> r10) {
        if (r5.size() == r10.size()) goto L5;
        return false;
    L5:
        int r11 = 0;
    L7:
        if (r11 >= r5.size()) goto L12;
        if (Arrays.equals(r5.get(r11), r10.get(r11)) == false) goto L10;
        r11 = r11 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static boolean equalsByteBuffer(ByteBuffer r5, ByteBuffer r10) {
        if (r5.capacity() == r10.capacity()) goto L7;
        return false;
    L7:
        return r5.duplicate().clear().equals(r10.duplicate().clear());
    }

    public static int hashBoolean(boolean r5) {
        if (r5 == false) goto L4;
        return 1231;
    L4:
        return 1237;
    }

    public static int hashCode(List<byte[]> r5) {
        Iterator<byte[]> r10 = r5.iterator();
        int r11 = 1;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = (r11 * 31) + hashCode(r10.next());
        goto L4
    L6:
        return r11;
    }

    public static int hashCodeByteBuffer(List<ByteBuffer> r5) {
        Iterator<ByteBuffer> r10 = r5.iterator();
        int r11 = 1;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = (r11 * 31) + hashCodeByteBuffer(r10.next());
        goto L4
    L6:
        return r11;
    }

    public static int hashEnum(EnumLite r5) {
        return r5.getNumber();
    }

    public static int hashEnumList(List<? extends EnumLite> r5) {
        Iterator<? extends EnumLite> r10 = r5.iterator();
        int r11 = 1;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = (r11 * 31) + hashEnum(r10.next());
        goto L4
    L6:
        return r11;
    }

    public static int hashLong(long r5) {
        return (int) (r5 ^ (r5 >>> 32));
    }

    public static boolean isValidUtf8(ByteString r5) {
        return r5.isValidUtf8();
    }

    public static String stringDefaultValue(String r5) {
        return new String(r5.getBytes("ISO-8859-1"), "UTF-8");
    L4:
        e = move-exception;
        throw new IllegalStateException("Java VM does not support a standard character set.", e);
    }

    public static byte[] toByteArray(String r5) {
        return r5.getBytes("UTF-8");
    L4:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported?", e);
    }

    public static String toStringUtf8(byte[] r5) {
        return new String(r5, "UTF-8");
    L4:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported?", e);
    }

    public static boolean isValidUtf8(byte[] r5) {
        return Utf8.isValidUtf8(r5);
    }

    public static boolean equalsByteBuffer(List<ByteBuffer> r5, List<ByteBuffer> r10) {
        if (r5.size() == r10.size()) goto L5;
        return false;
    L5:
        int r11 = 0;
    L7:
        if (r11 >= r5.size()) goto L12;
        if (equalsByteBuffer(r5.get(r11), r10.get(r11)) == false) goto L10;
        r11 = r11 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static int hashCode(byte[] r5) {
        return LiteralByteString.hashCode(r5);
    }

    public static int hashCodeByteBuffer(ByteBuffer r10) {
        if (r10.hasArray() == false) goto L9;
        int r11 = LiteralByteString.hashCode(r10.capacity(), r10.array(), r10.arrayOffset(), r10.capacity());
        if (r11 != 0) goto L8;
        return 1;
    L8:
        return r11;
    L9:
        int r5 = 4096;
        if (r10.capacity() > 4096) goto L13;
        r5 = r10.capacity();
    L13:
        byte[] r12 = new byte[r5];
        ByteBuffer r13 = r10.duplicate();
        r13.clear();
        int r14 = r10.capacity();
    L15:
        if (r13.remaining() <= 0) goto L21;
        if (r13.remaining() > r5) goto L19;
        int r15 = r13.remaining();
    L20:
        r13.get(r12, 0, r15);
        r14 = LiteralByteString.hashCode(r14, r12, 0, r15);
        goto L15
    L19:
        r15 = r5;
        goto L20
    L21:
        if (r14 != 0) goto L24;
        return 1;
    L24:
        return r14;
    }
}
