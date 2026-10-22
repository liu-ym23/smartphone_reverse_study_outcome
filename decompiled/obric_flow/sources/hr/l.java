package hr;

import com.obric.oui.constraintlayout.core.widgets.analyzer.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class l extends f {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public f[] f17462u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public int f17463v0;

    public l() {
        this.f17462u0 = new f[4];
        this.f17463v0 = 0;
    }

    public final void S(f r5) {
        if (r5 == this) goto L10;
        if (r5 == null) goto L11;
        int r10 = this.f17463v0 + 1;
        f[] r11 = this.f17462u0;
        if (r10 <= r11.length) goto L8;
        this.f17462u0 = (f[]) Arrays.copyOf(r11, r11.length * 2);
    L8:
        f[] r12 = this.f17462u0;
        int r13 = this.f17463v0;
        r12[r13] = r5;
        this.f17463v0 = r13 + 1;
        return;
    L11:
        return;
    }

    public final void T(int r10, q r11, ArrayList r12) {
        int r5 = 0;
        int r13 = 0;
    L4:
        if (r13 >= this.f17463v0) goto L11;
        f r14 = this.f17462u0[r13];
        ArrayList r15 = r11.f12588a;
        if (r15.contains(r14) == true) goto L9;
        r15.add(r14);
    L9:
        r13 = r13 + 1;
    L11:
        if (r5 >= this.f17463v0) goto L13;
        com.obric.oui.constraintlayout.core.widgets.analyzer.i.b(this.f17462u0[r5], r10, r12, r11);
        r5 = r5 + 1;
        goto L11
    }

    public void U() {
    }

    @Override // hr.f
    public void g(f r5, HashMap r10) {
        super.g(r5, r10);
        l r11 = (l) r5;
        int r12 = 0;
        this.f17463v0 = 0;
        int r13 = r11.f17463v0;
    L3:
        if (r12 >= r13) goto L5;
        S((f) r10.get(r11.f17462u0[r12]));
        r12 = r12 + 1;
        goto L3
    }
}
