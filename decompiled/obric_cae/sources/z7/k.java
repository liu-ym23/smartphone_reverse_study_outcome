package z7;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class k extends e {
    public k(i r8, d r10, long r11) {
        ByteBuffer r12 = ByteBuffer.allocate(8);
        if (r10.f14281a == false) goto L5;
        ByteOrder r13 = ByteOrder.BIG_ENDIAN;
    L6:
        r12.order(r13);
        long r14 = r10.f14282b;
        long r15 = (r11 * ((long) r10.f14284d)) + r14;
        this.f14287a = r8.n(r12, r15);
        r8.i(r12, 8 + r15, 8);
        this.f14288b = r12.getLong();
        r8.i(r12, 16 + r15, 8);
        this.f14289c = r12.getLong();
        r8.i(r12, r15 + 40, 8);
        this.f14290d = r12.getLong();
        return;
    L5:
        r13 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
