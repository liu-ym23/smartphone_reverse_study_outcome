package s;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class m extends e {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public ArrayList<e> f11940s0;

    public m() {
        this.f11940s0 = new ArrayList();
    }

    @Override // s.e
    public void C() {
        this.f11940s0.clear();
        super.C();
    }

    @Override // s.e
    public final void F(p.c r8) {
        super.F(r8);
        int r10 = this.f11940s0.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.f11940s0.get(r11).F(r8);
        r11 = r11 + 1;
        goto L3
    }

    public void Q() {
        ArrayList<e> r8 = this.f11940s0;
        if (r8 != null) goto L5;
        return;
    L5:
        int r10 = r8.size();
        int r11 = 0;
    L6:
        if (r11 >= r10) goto L11;
        e r12 = this.f11940s0.get(r11);
        if ((r12 instanceof m) == false) goto L10;
        ((m) r12).Q();
    L10:
        r11 = r11 + 1;
        goto L6
    }
}
