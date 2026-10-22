package n3;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class g extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final i f11195g;

    public g(boolean r10, i r11) {
        this.f11184a = r10;
        this.f11195g = r11;
        ByteBuffer r12 = ByteBuffer.allocate(4);
        if (r10 == false) goto L5;
        ByteOrder r13 = ByteOrder.BIG_ENDIAN;
    L6:
        r12.order(r13);
        r11.l(r12, 16);
        this.f11185b = r11.r(r12, 28);
        this.f11186c = r11.r(r12, 32);
        this.f11187d = r11.l(r12, 42);
        this.f11188e = r11.l(r12, 44);
        this.f11189f = r11.l(r12, 46);
        r11.l(r12, 48);
        r11.l(r12, 50);
        return;
    L5:
        r13 = ByteOrder.LITTLE_ENDIAN;
        goto L6
    }

    @Override // n3.d
    public c a(long r10, int r11) {
        return new a(this.f11195g, this, r10, r11);
    }

    @Override // n3.d
    public e b(long r10) {
        return new j(this.f11195g, this, r10);
    }

    @Override // n3.d
    public f c(int r10) {
        return new l(this.f11195g, this, r10);
    }
}
