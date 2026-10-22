package nqc;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static void a(ByteBuffer r1) {
        if (r1.order() != ByteOrder.LITTLE_ENDIAN) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }

    public static Pair<ByteBuffer, Long> b(RandomAccessFile r10, int r11) throws IOException {
        if (r11 < 0) goto L25;
        if (r11 > 65535) goto L25;
        long r1 = r10.length();
        if (r1 >= 22) goto L8;
        return null;
    L8:
        ByteBuffer r12 = ByteBuffer.allocate(((int) Math.min(r11, r1 - 22)) + 22);
        r12.order(ByteOrder.LITTLE_ENDIAN);
        long r2 = r1 - ((long) r12.capacity());
        r10.seek(r2);
        r10.readFully(r12.array(), r12.arrayOffset(), r12.capacity());
        a(r12);
        int r13 = r12.capacity();
        if (r13 < 22) goto L19;
        int r14 = r13 - 22;
        int r4 = Math.min(r14, 65535);
        int r6 = 0;
    L12:
        if (r6 > r4) goto L19;
        int r7 = r14 - r6;
        if (r12.getInt(r7) != 101010256) goto L18;
        if ((r12.getShort(r7 + 20) & UShort.MAX_VALUE) != r6) goto L18;
    L20:
        if (r7 != (-1)) goto L22;
        return null;
    L22:
        r12.position(r7);
        ByteBuffer r15 = r12.slice();
        r15.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(r15, Long.valueOf(r2 + ((long) r7)));
    L18:
        r6 = r6 + 1;
    L19:
        r7 = -1;
    L25:
        throw new IllegalArgumentException("maxCommentSize: " + r11);
    }
}
