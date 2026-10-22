package qa;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public abstract class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f10252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f10253b;

    public c1() {
        this.f10253b = null;
    }

    public final byte[] a() {
        byte[] r8 = b((byte[]) this.f10253b);
        c1 r10 = (c1) this.f10252a;
        if (r10 == null) goto L6;
        r10.f10253b = r8;
        return r10.a();
    L6:
        return r8;
    }

    public abstract byte[] b(byte[] r8);

    public void c(byte[] r8) {
    }

    public c1(int r8) {
        ByteBuffer r10 = ByteBuffer.allocate(r8);
        this.f10253b = r10;
        r10.order(ByteOrder.LITTLE_ENDIAN);
        this.f10252a = new p1((ByteBuffer) this.f10253b);
    }

    public c1(c1 r8) {
        this.f10253b = null;
        this.f10252a = r8;
    }
}
