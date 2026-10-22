package m9;

import com.bytedance.crash.entity.Header;
import com.bytedance.crash.n;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends e {
    @Override // m9.e
    public final z8.c a(int r5, z8.c r10) {
        z8.c r11 = super.a(r5, r10);
        if (r5 != 0) goto L5;
        Header r12 = Header.a();
        r12.b(n.d().u());
        mh.e.g(r12.f4029a, "header", r11.f23416a);
        r11.f23417b = r12;
        io.reactivex.internal.observers.h.c(r11, r12, this.f20050a);
        return r11;
    L5:
        if (r5 != 1) goto L7;
        Header r13 = r11.o();
        r13.j();
        r13.k();
        return r11;
    L7:
        if (r5 == 2) goto L9;
        return r11;
    L9:
        Header.addRuntimeHeader(r11.o().f4029a);
        return r11;
    }
}
