package n3;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class h extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final i f11196g;

    public h(boolean r10, i r11) {
        this.f11184a = r10;
        this.f11196g = r11;
        ByteBuffer r12 = ByteBuffer.allocate(8);
        if (r10 == false) goto L5;
        ByteOrder r13 = ByteOrder.BIG_ENDIAN;
    L6:
        r12.order(r13);
        r11.l(r12, 16);
        this.f11185b = r11.o(r12, 32);
        this.f11186c = r11.o(r12, 40);
        this.f11187d = r11.l(r12, 54);
        this.f11188e = r11.l(r12, 56);
        this.f11189f = r11.l(r12, 58);
        r11.l(r12, 60);
        r11.l(r12, 62);
        return;
    L5:
        r13 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }

    @Override // n3.d
    public c a(long r10, int r11) {
        return new b(this.f11196g, this, r10, r11);
    }

    @Override // n3.d
    public e b(long r10) {
        return new k(this.f11196g, this, r10);
    }

    @Override // n3.d
    public f c(int r10) {
        return new m(this.f11196g, this, r10);
    }
}
