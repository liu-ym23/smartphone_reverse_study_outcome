package z7;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class l extends f {
    public l(i r8, d r10) {
        ByteBuffer r11 = ByteBuffer.allocate(4);
        if (r10.f14281a == false) goto L5;
        ByteOrder r12 = ByteOrder.BIG_ENDIAN;
    L6:
        r11.order(r12);
        this.f14291a = r8.n(r11, (r10.f14283c + ((long) (0 * r10.f14286f))) + 28);
        return;
    L5:
        r12 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
