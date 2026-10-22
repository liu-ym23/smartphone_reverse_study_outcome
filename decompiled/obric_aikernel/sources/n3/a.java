package n3;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class a extends c {
    public a(i r10, d r11, long r12, int r13) {
        ByteBuffer r14 = ByteBuffer.allocate(4);
        if (r11.f11184a == false) goto L5;
        ByteOrder r15 = ByteOrder.BIG_ENDIAN;
    L6:
        r14.order(r15);
        long r16 = r12 + ((long) (r13 * 8));
        this.f11182a = r10.r(r14, r16);
        this.f11183b = r10.r(r14, r16 + 4);
        return;
    L5:
        r15 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }
}
