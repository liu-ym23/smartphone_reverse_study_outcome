package d2a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class h implements j {
    public final Animator a;
    public long b;
    public Interpolator c;
    public final e d;
    public final e e;
    public final e f;
    public final e g;
    public final ObjectAnimator h;

    public h(int r3) {
        this.a = null;
        this.b = 100;
        e r4 = g.a;
        this.d = r4;
        this.e = r4;
        this.f = r4;
        this.g = r4;
        this.h = new ObjectAnimator();
    }

    @Override // d2a.j
    public final void b(Interpolator r1) {
        this.c = r1;
    }

    @Override // d2a.j
    public final void setDuration(long r1) {
        this.b = r1;
    }
}
