package z7;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class h extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f14293g;

    public h(boolean r8, i r10) {
        this.f14281a = r8;
        this.f14293g = r10;
        ByteBuffer r11 = ByteBuffer.allocate(8);
        if (r8 == false) goto L5;
        ByteOrder r12 = ByteOrder.BIG_ENDIAN;
    L6:
        r11.order(r12);
        r10.k(r11, 16);
        r10.i(r11, 32, 8);
        this.f14282b = r11.getLong();
        r10.i(r11, 40, 8);
        this.f14283c = r11.getLong();
        this.f14284d = r10.k(r11, 54);
        this.f14285e = r10.k(r11, 56);
        this.f14286f = r10.k(r11, 58);
        r10.k(r11, 60);
        r10.k(r11, 62);
        return;
    L5:
        r12 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }

    @Override // z7.d
    public final c a(int r8, long r10) {
        return new b(this.f14293g, this, r10, r8);
    }

    @Override // z7.d
    public final e b(long r8) {
        return new k(this.f14293g, this, r8);
    }

    @Override // z7.d
    public final f c() {
        return new m(this.f14293g, this);
    }
}
