package ms.bd.c;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class f {
    public static LinkedHashMap a(ByteBuffer r12) {
        if (r12.order() != ByteOrder.LITTLE_ENDIAN) goto L51;
        int r0 = r12.capacity() - 24;
        if (r0 < 8) goto L49;
        r12.capacity();
        if (r0 > r12.capacity()) goto L47;
        int r4 = r12.limit();
        int r5 = r12.position();
        r12.position(0);     // Catch: Throwable -> L43
        r12.limit(r0);     // Catch: Throwable -> L43
        r12.position(8);     // Catch: Throwable -> L43
        ByteBuffer r1 = r12.slice();     // Catch: Throwable -> L43
        r1.order(r12.order());     // Catch: Throwable -> L43
        r12.position(0);
        r12.limit(r4);
        r12.position(r5);
        LinkedHashMap r13 = new LinkedHashMap();
    L12:
        if (r1.hasRemaining() == false) goto L42;
        if (r1.remaining() < 8) goto L41;
        long r6 = r1.getLong();
        if (r6 < 4) goto L39;
        if (r6 > 2147483647L) goto L39;
        int r7 = (int) r6;
        int r8 = r1.position() + r7;
        if (r7 > r1.remaining()) goto L37;
        Integer r9 = Integer.valueOf(r1.getInt());
        int r10 = r7 - 4;
        if (r10 < 0) goto L35;
        int r11 = r1.limit();
        int r14 = r1.position();
        int r15 = r10 + r14;
        if (r15 < r14) goto L33;
        if (r15 > r11) goto L33;
        r1.limit(r15);
        ByteBuffer r16 = r1.slice();     // Catch: Throwable -> L29
        r16.order(r1.order());     // Catch: Throwable -> L29
        r1.position(r15);     // Catch: Throwable -> L29
        r1.limit(r11);
        r13.put(r9, r16);
        r1.position(r8);
    L29:
        th = move-exception;
        r1.limit(r11);
        throw th;
    L33:
        throw new BufferUnderflowException();
    L35:
        throw new IllegalArgumentException((String) p2.a(16777217, 0, 0, "82142c", new byte[]{123}));
    L37:
        throw new e((String) p2.a(16777217, 0, 0, "8e0ff5", new byte[]{113}));
    L39:
        throw new e((String) p2.a(16777217, 0, 0, "797128", new byte[]{113}));
    L41:
        throw new e((String) p2.a(16777217, 0, 0, "6d1bb9", new byte[]{113}));
    L42:
        return r13;
    L43:
        th = move-exception;
        r12.position(0);
        r12.limit(r4);
        r12.position(r5);
        throw th;
    L47:
        throw new IllegalArgumentException((String) p2.a(16777217, 0, 0, "eee3fe", new byte[]{33}));
    L49:
        throw new IllegalArgumentException((String) p2.a(16777217, 0, 0, "bb94a0", new byte[]{39}));
    L51:
        throw new IllegalArgumentException((String) p2.a(16777217, 0, 0, "8333fb", new byte[]{120}));
    }

    public static d b(FileChannel r14) {
        long r0 = r14.size();
        if (r0 < 22) goto L38;
        long r1 = r0 - 22;
        long r3 = Math.min(r1, 65535);
        int r6 = 0;
    L5:
        long r7 = r6;
        if (r7 > r3) goto L36;
        long r8 = r1 - r7;
        ByteBuffer r10 = ByteBuffer.allocate(4);
        r14.position(r8);
        r14.read(r10);
        ByteOrder r11 = ByteOrder.LITTLE_ENDIAN;
        r10.order(r11);
        if (r10.getInt(0) != 101010256) goto L34;
        ByteBuffer r12 = ByteBuffer.allocate(2);
        r14.position(r8 + 20);
        r14.read(r12);
        r12.order(r11);
        short r9 = r12.getShort(0);
        if (r9 != r6) goto L34;
        ByteBuffer r2 = ByteBuffer.allocate(4);
        r2.order(r11);
        r14.position((r14.size() - ((long) r9)) - 6);
        r14.read(r2);
        long r4 = r2.getInt(0);
        if (r4 < 32) goto L33;
        r14.position(r4 - 24);
        ByteBuffer r5 = ByteBuffer.allocate(24);
        r14.read(r5);
        r5.order(r11);
        if (r5.getLong(8) == 2334950737559900225L) goto L16;
    L30:
        return null;
    L16:
        if (r5.getLong(16) != 3617552046287187010L) goto L30;
        long r13 = r5.getLong(0);
        if (r13 < r5.capacity()) goto L30;
        if (r13 > 2147483639) goto L30;
        int r15 = (int) (8 + r13);
        long r16 = r4 - ((long) r15);
        if (r16 < 0) goto L30;
        r14.position(r16);
        ByteBuffer r17 = ByteBuffer.allocate(r15);
        r14.read(r17);
        r17.order(r11);
        if (r17.getLong(0) != r13) goto L30;
        return new d(r17, Long.valueOf(r16));
    L33:
        throw new e((String) p2.a(16777217, 0, 0, "150726", new byte[]{121}));
    L34:
        r6 = r6 + 1;
        goto L5
    L36:
        throw new IOException((String) p2.a(16777217, 0, 0, "255618", new byte[]{114, 103}));
    L38:
        throw new IOException((String) p2.a(16777217, 0, 0, "f72618", new byte[]{38, 100}));
    }
}
