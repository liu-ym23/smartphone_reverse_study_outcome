package n4a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class n1 {
    public final p1 a;
    public final ByteBuffer b;

    public n1(int r2) {
        ByteBuffer r3 = ByteBuffer.allocate(r2);
        this.b = r3;
        r3.order(ByteOrder.LITTLE_ENDIAN);
        this.a = new p1(r3);
    }
}
