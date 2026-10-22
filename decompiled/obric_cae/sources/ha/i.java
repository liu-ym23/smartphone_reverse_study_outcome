package ha;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes.dex */
public final class i extends c0<AtomicLongArray> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f7967a;

    public i(c0 r8) {
        this.f7967a = r8;
    }

    @Override // ha.c0
    public final AtomicLongArray a(pa.a r8) {
        ArrayList r10 = new ArrayList();
        r8.a();
    L4:
        if (r8.B() == false) goto L6;
        r10.add(Long.valueOf(((Number) this.f7967a.a(r8)).longValue()));
        goto L4
    L6:
        r8.r();
        int r11 = r10.size();
        AtomicLongArray r12 = new AtomicLongArray(r11);
        int r13 = 0;
    L7:
        if (r13 >= r11) goto L9;
        r12.set(r13, ((Long) r10.get(r13)).longValue());
        r13 = r13 + 1;
        goto L7
    L9:
        return r12;
    }

    @Override // ha.c0
    public final void b(pa.c r8, AtomicLongArray r10) {
        AtomicLongArray r11 = r10;
        r8.i();
        int r12 = r11.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        Long r14 = Long.valueOf(r11.get(r13));
        this.f7967a.b(r8, r14);
        r13 = r13 + 1;
        goto L3
    L5:
        r8.r();
    }
}
