package z7;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class g extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f14292g;

    public g(boolean r8, i r10) {
        this.f14281a = r8;
        this.f14292g = r10;
        ByteBuffer r11 = ByteBuffer.allocate(4);
        if (r8 == false) goto L5;
        ByteOrder r12 = ByteOrder.BIG_ENDIAN;
    L6:
        r11.order(r12);
        r10.k(r11, 16);
        this.f14282b = r10.n(r11, 28);
        this.f14283c = r10.n(r11, 32);
        this.f14284d = r10.k(r11, 42);
        this.f14285e = r10.k(r11, 44);
        this.f14286f = r10.k(r11, 46);
        r10.k(r11, 48);
        r10.k(r11, 50);
        return;
    L5:
        r12 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }

    @Override // z7.d
    public final c a(int r8, long r10) {
        return new a(this.f14292g, this, r10, r8);
    }

    @Override // z7.d
    public final e b(long r8) {
        return new j(this.f14292g, this, r8);
    }

    @Override // z7.d
    public final f c() {
        return new l(this.f14292g, this);
    }
}
