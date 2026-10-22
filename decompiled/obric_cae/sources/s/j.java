package s;

import java.util.ArrayList;
import t.o;

/* JADX INFO: loaded from: classes.dex */
public class j extends e implements i {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public e[] f11931s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f11932t0;

    public j() {
        this.f11931s0 = new e[4];
        this.f11932t0 = 0;
    }

    public final void Q(int r8, o r10, ArrayList r11) {
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r13 >= this.f11932t0) goto L11;
        e r14 = this.f11931s0[r13];
        ArrayList<e> r15 = r10.f12188a;
        if (r15.contains(r14) == true) goto L9;
        r15.add(r14);
    L9:
        r13 = r13 + 1;
    L11:
        if (r12 >= this.f11932t0) goto L13;
        t.i.a(this.f11931s0[r12], r8, r11, r10);
        r12 = r12 + 1;
        goto L11
    }

    @Override // s.i
    public void a() {
    }
}
