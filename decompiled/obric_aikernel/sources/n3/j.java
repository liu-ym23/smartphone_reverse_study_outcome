package n3;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class j extends e {
    public j(i r10, d r11, long r12) {
        ByteBuffer r13 = ByteBuffer.allocate(4);
        if (r11.f11184a == false) goto L5;
        ByteOrder r14 = ByteOrder.BIG_ENDIAN;
    L6:
        r13.order(r14);
        long r15 = r11.f11185b + (r12 * ((long) r11.f11187d));
        this.f11190a = r10.r(r13, r15);
        this.f11191b = r10.r(r13, 4 + r15);
        this.f11192c = r10.r(r13, 8 + r15);
        this.f11193d = r10.r(r13, r15 + 20);
        return;
    L5:
        r14 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
