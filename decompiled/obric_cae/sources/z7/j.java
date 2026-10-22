package z7;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class j extends e {
    public j(i r8, d r10, long r11) {
        ByteBuffer r12 = ByteBuffer.allocate(4);
        if (r10.f14281a == false) goto L5;
        ByteOrder r13 = ByteOrder.BIG_ENDIAN;
    L6:
        r12.order(r13);
        long r14 = r10.f14282b;
        long r15 = (r11 * ((long) r10.f14284d)) + r14;
        this.f14287a = r8.n(r12, r15);
        this.f14288b = r8.n(r12, 4 + r15);
        this.f14289c = r8.n(r12, 8 + r15);
        this.f14290d = r8.n(r12, r15 + 20);
        return;
    L5:
        r13 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
