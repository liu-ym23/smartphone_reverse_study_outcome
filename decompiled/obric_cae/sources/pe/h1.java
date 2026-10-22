package pe;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public class h1 extends j1 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f10016m;

    public h1(e1 r8) {
        boolean r10 = true;
        super(true);
        y(r8);
        AtomicReferenceFieldUpdater r11 = j1.f10021b;
        k r12 = (k) r11.get(this);
        if ((r12 instanceof l) == false) goto L5;
        l r13 = (l) r12;
    L6:
        if (r13 == null) goto L16;
    L7:
        j1 r14 = r13.n();
        if (r14.q() == true) goto L17;
        k r15 = (k) r11.get(r14);
        if ((r15 instanceof l) == false) goto L13;
        r13 = (l) r15;
    L14:
        if (r13 == null) goto L16;
    L13:
        r13 = null;
    L17:
        this.f10016m = r10;
        return;
    L16:
        r10 = false;
        goto L17
    L5:
        r13 = null;
        goto L6
    }

    @Override // pe.j1
    public final boolean q() {
        return this.f10016m;
    }

    @Override // pe.j1
    public final boolean r() {
        return true;
    }
}
