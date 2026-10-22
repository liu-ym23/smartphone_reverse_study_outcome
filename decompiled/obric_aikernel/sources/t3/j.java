package t3;

import com.bytedance.memory.shrink.BaseType;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12950a = null;

        static {
            int[] r10 = new int[BaseType.values().length];
            f12950a = r10;
            r10[BaseType.OBJECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f12950a[BaseType.BOOLEAN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f12950a[BaseType.CHAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f12950a[BaseType.FLOAT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f12950a[BaseType.DOUBLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f12950a[BaseType.BYTE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f12950a[BaseType.SHORT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f12950a[BaseType.INT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f12950a[BaseType.LONG.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    public static int a(InputStream r10) {
        int r11 = r10.read();
        int r12 = r10.read();
        int r13 = r10.read();
        int r14 = r10.read();
        if ((((r11 | r12) | r13) | r14) < 0) goto L7;
        return (((r11 << 24) + (r12 << 16)) + (r13 << 8)) + r14;
    L7:
        throw new EOFException();
    }

    public static long b(InputStream r10) {
        byte[] r11 = new byte[8];
        d(r10, r11, 0, 8);
        return (((((((((long) r11[0]) << 56) + (((long) (r11[1] & 255)) << 48)) + (((long) (r11[2] & 255)) << 40)) + (((long) (r11[3] & 255)) << 32)) + (((long) (r11[4] & 255)) << 24)) + ((long) ((r11[5] & 255) << 16))) + ((long) ((r11[6] & 255) << 8))) + ((long) (r11[7] & 255));
    }

    public static short c(InputStream r10) {
        int r11 = r10.read();
        int r12 = r10.read();
        if ((r11 | r12) < 0) goto L7;
        return (short) (r12 | (r11 << 8));
    L7:
        throw new EOFException();
    }

    public static void d(InputStream r10, byte[] r11, int r12, long r13) {
        int r14 = 0;
    L3:
        long r15 = r14;
        if (r15 >= r13) goto L10;
        int r16 = r10.read(r11, r14, (int) (r13 - r15));
        if (r16 < 0) goto L9;
        r14 = r14 + r16;
        goto L3
    L9:
        throw new EOFException();
    }

    public static f e(InputStream r10, int r11) {
        byte[] r12 = new byte[r11];
        d(r10, r12, 0, r11);
        return new f(r12);
    }

    public static String f(InputStream r10) {
        StringBuilder r11 = new StringBuilder();
        int r12 = r10.read();
        int r13 = 0;
    L3:
        if (r12 == 0) goto L10;
        r11.append((char) r12);
        r13 = r13 + 1;
        if (r13 > 2048) goto L8;
        r12 = r10.read();
        goto L3
    L8:
        throw new IOException("Bad string data which causes result to be too long.");
    L10:
        return r11.toString();
    }

    public static String g(InputStream r10, long r11) {
        byte[] r12 = new byte[(int) r11];
        d(r10, r12, 0, r11);
        return new String(r12, Charset.forName("UTF-8"));
    }

    public static Object h(InputStream r10, BaseType r11, int r12) {
        switch(a.f12950a[r11.ordinal()]) {
            case 1: goto L27;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return Long.valueOf(b(r10));
    L9:
        return Integer.valueOf(a(r10));
    L11:
        return Short.valueOf(c(r10));
    L13:
        return Byte.valueOf((byte) r10.read());
    L15:
        return Double.valueOf(Double.longBitsToDouble(b(r10)));
    L17:
        return Float.valueOf(Float.intBitsToFloat(a(r10)));
    L19:
        return Character.valueOf((char) c(r10));
    L21:
        if (r10.read() == 0) goto L23;
        boolean r13 = true;
    L25:
        return Boolean.valueOf(r13);
    L23:
        r13 = false;
        goto L25
    L27:
        return e(r10, r12);
    }

    public static void i(InputStream r10, long r11) {
        long r12 = 0;
    L4:
        if (r12 >= r11) goto L10;
        long r13 = r10.skip(r11 - r12);
        if (r13 < 0) goto L9;
        r12 = r12 + r13;
        goto L4
    L9:
        throw new EOFException();
    }

    public static void j(OutputStream r10, long r11) {
        byte[] r12 = new byte[4096];
        int r13 = 0;
    L4:
        if (r13 >= (r11 >> 12)) goto L6;
        r10.write(r12);
        r13 = r13 + 1;
        goto L4
    L6:
        r10.write(r12, 0, (int) (r11 & 4095));
    }

    public static void k(OutputStream r10, int r11) {
        r10.write((r11 >>> 24) & 255);
        r10.write((r11 >>> 16) & 255);
        r10.write((r11 >>> 8) & 255);
        r10.write(r11 & 255);
    }

    public static void l(OutputStream r10, long r11) {
        r10.write(new byte[]{(byte) (r11 >>> 56), (byte) (r11 >>> 48), (byte) (r11 >>> 40), (byte) (r11 >>> 32), (byte) (r11 >>> 24), (byte) (r11 >>> 16), (byte) (r11 >>> 8), (byte) r11}, 0, 8);
    }

    public static void m(OutputStream r10, int r11) {
        r10.write((r11 >>> 8) & 255);
        r10.write(r11 & 255);
    }

    public static void n(OutputStream r10, Object r11) {
        if (r11 == null) goto L54;
        if ((r11 instanceof f) == false) goto L7;
        o(r10, (f) r11);
        return;
    L7:
        if ((r11 instanceof Boolean) == false) goto L9;
    L51:
        r10.write(0);
        return;
    L9:
        if (Boolean.TYPE.isAssignableFrom(r11.getClass()) == true) goto L51;
        if ((r11 instanceof Character) == false) goto L14;
    L50:
        m(r10, 0);
        return;
    L14:
        if (Character.TYPE.isAssignableFrom(r11.getClass()) == true) goto L50;
        if ((r11 instanceof Float) == false) goto L19;
    L49:
        k(r10, 0);
        return;
    L19:
        if (Float.TYPE.isAssignableFrom(r11.getClass()) == true) goto L49;
        if ((r11 instanceof Double) == false) goto L24;
    L48:
        l(r10, 0);
        return;
    L24:
        if (Double.TYPE.isAssignableFrom(r11.getClass()) == true) goto L48;
        if ((r11 instanceof Byte) == true) goto L51;
        if (Byte.TYPE.isAssignableFrom(r11.getClass()) == true) goto L51;
        if ((r11 instanceof Short) == true) goto L50;
        if (Short.TYPE.isAssignableFrom(r11.getClass()) == true) goto L50;
        if ((r11 instanceof Integer) == true) goto L49;
        if (Integer.TYPE.isAssignableFrom(r11.getClass()) == true) goto L49;
        if ((r11 instanceof Long) == true) goto L48;
        if (Long.TYPE.isAssignableFrom(r11.getClass()) == true) goto L48;
        throw new IllegalArgumentException("bad value type: " + r11.getClass().getName());
    L54:
        throw new IllegalArgumentException("value is null.");
    }

    public static void o(OutputStream r10, f r11) {
        r10.write(r11.a());
    }

    public static void p(OutputStream r10, String r11) {
        byte[] r12 = r11.getBytes(Charset.forName("UTF-8"));
        r10.write(r12, 0, r12.length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void q(OutputStream r10, Object r11) {
        if (r11 == null) goto L62;
        if ((r11 instanceof f) == false) goto L7;
        o(r10, (f) r11);
        return;
    L7:
        if ((r11 instanceof Boolean) == false) goto L9;
    L58:
        int r12 = ((Boolean) r11).booleanValue();
    L59:
        r10.write(r12);
        return;
    L9:
        if (Boolean.TYPE.isAssignableFrom(r11.getClass()) == true) goto L58;
        if ((r11 instanceof Character) == false) goto L14;
    L56:
        short r13 = ((Character) r11).charValue();
    L57:
        m(r10, r13);
        return;
    L14:
        if (Character.TYPE.isAssignableFrom(r11.getClass()) == true) goto L56;
        if ((r11 instanceof Float) == false) goto L19;
    L54:
        int r14 = Float.floatToRawIntBits(((Float) r11).floatValue());
    L55:
        k(r10, r14);
        return;
    L19:
        if (Float.TYPE.isAssignableFrom(r11.getClass()) == true) goto L54;
        if ((r11 instanceof Double) == false) goto L24;
    L52:
        long r15 = Double.doubleToRawLongBits(((Double) r11).doubleValue());
    L53:
        l(r10, r15);
        return;
    L24:
        if (Double.TYPE.isAssignableFrom(r11.getClass()) == true) goto L52;
        if ((r11 instanceof Byte) == false) goto L29;
    L51:
        r12 = ((Byte) r11).byteValue();
        goto L59
    L29:
        if (Byte.TYPE.isAssignableFrom(r11.getClass()) == true) goto L51;
        if ((r11 instanceof Short) == false) goto L34;
    L50:
        r13 = ((Short) r11).shortValue();
        goto L57
    L34:
        if (Short.TYPE.isAssignableFrom(r11.getClass()) == true) goto L50;
        if ((r11 instanceof Integer) == false) goto L39;
    L49:
        r14 = ((Integer) r11).intValue();
        goto L55
    L39:
        if (Integer.TYPE.isAssignableFrom(r11.getClass()) == true) goto L49;
        if ((r11 instanceof Long) == false) goto L44;
    L48:
        r15 = ((Long) r11).longValue();
        goto L53
    L44:
        if (Long.TYPE.isAssignableFrom(r11.getClass()) == true) goto L48;
        throw new IllegalArgumentException("bad value type: " + r11.getClass().getName());
    L62:
        throw new IllegalArgumentException("value is null.");
    }
}
