package n3;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class l extends f {
    public l(i r10, d r11, int r12) {
        ByteBuffer r13 = ByteBuffer.allocate(4);
        if (r11.f11184a == false) goto L5;
        ByteOrder r14 = ByteOrder.BIG_ENDIAN;
    L6:
        r13.order(r14);
        this.f11194a = r10.r(r13, (r11.f11186c + ((long) (r12 * r11.f11189f))) + 28);
        return;
    L5:
        r14 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
