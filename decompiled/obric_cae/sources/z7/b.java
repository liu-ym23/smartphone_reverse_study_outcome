package z7;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class b extends c {
    public b(i r8, d r10, long r11, int r12) {
        ByteBuffer r13 = ByteBuffer.allocate(8);
        if (r10.f14281a == false) goto L5;
        ByteOrder r14 = ByteOrder.BIG_ENDIAN;
    L6:
        r13.order(r14);
        long r15 = r11 + ((long) (r12 * 16));
        r8.i(r13, r15, 8);
        this.f14279a = r13.getLong();
        r8.i(r13, r15 + 8, 8);
        this.f14280b = r13.getLong();
        return;
    L5:
        r14 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
