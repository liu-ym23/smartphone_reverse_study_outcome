package kotlinx.coroutines;

import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public final class q1 extends m1 {
    public final /* synthetic */ int e;
    public final kotlinx.coroutines.selects.g f;
    public final /* synthetic */ r1 g;

    public /* synthetic */ q1(r1 r5, kotlinx.coroutines.selects.g r10, int r11) {
        this.e = r11;
        this.g = r5;
        this.f = r10;
    }

    @Override // kotlinx.coroutines.m1
    public final boolean i() {
        switch(this.e) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        return false;
    }

    @Override // kotlinx.coroutines.m1
    public final void j(Throwable r5) {
        switch(this.e) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        r1 r10 = this.g;
        Unit r11 = Unit.INSTANCE;
        this.f.e(r10, r11);
        return;
    L6:
        r1 r12 = this.g;
        r12.getClass();
        Object r13 = r1.f18988a.get(r12);
        if ((r13 instanceof v) == true) goto L10;
        r13 = j0.k(r13);
    L10:
        this.f.e(r12, r13);
    }
}
