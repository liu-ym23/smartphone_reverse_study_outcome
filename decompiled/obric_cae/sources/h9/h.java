package h9;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f7957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f7958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeInterpolator f7959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7961e;

    public h(long r8) {
        this.f7957a = 0;
        this.f7958b = 300;
        this.f7959c = null;
        this.f7960d = 0;
        this.f7961e = 1;
        this.f7957a = r8;
        this.f7958b = 150;
    }

    public final void a(Animator r8) {
        r8.setStartDelay(this.f7957a);
        r8.setDuration(this.f7958b);
        r8.setInterpolator(b());
        if ((r8 instanceof ValueAnimator) == false) goto L6;
        ValueAnimator r10 = (ValueAnimator) r8;
        r10.setRepeatCount(this.f7960d);
        r10.setRepeatMode(this.f7961e);
        return;
    }

    public final TimeInterpolator b() {
        TimeInterpolator r8 = this.f7959c;
        if (r8 == null) goto L6;
        return r8;
    L6:
        return a.f7944b;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof h) == true) goto L8;
        return false;
    L8:
        h r10 = (h) r8;
        long r11 = r10.f7957a;
        if (this.f7957a == r11) goto L12;
        return false;
    L12:
        if (this.f7958b == r10.f7958b) goto L15;
        return false;
    L15:
        if (this.f7960d == r10.f7960d) goto L18;
        return false;
    L18:
        if (this.f7961e == r10.f7961e) goto L21;
        return false;
    L21:
        return b().getClass().equals(r10.b().getClass());
    }

    public final int hashCode() {
        long r8 = this.f7957a;
        int r10 = ((int) (r8 ^ (r8 >>> 32))) * 31;
        long r11 = this.f7958b;
        int r12 = (r10 + ((int) ((r11 >>> 32) ^ r11))) * 31;
        return ((((b().getClass().hashCode() + r12) * 31) + this.f7960d) * 31) + this.f7961e;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("\n");
        r8.append(h.class.getName());
        r8.append('{');
        r8.append(Integer.toHexString(System.identityHashCode(this)));
        r8.append(" delay: ");
        r8.append(this.f7957a);
        r8.append(" duration: ");
        r8.append(this.f7958b);
        r8.append(" interpolator: ");
        r8.append(b().getClass());
        r8.append(" repeatCount: ");
        r8.append(this.f7960d);
        r8.append(" repeatMode: ");
        return android.aimedia.a.h(r8, this.f7961e, "}\n");
    }

    public h(long r8, long r10, TimeInterpolator r11) {
        this.f7957a = 0;
        this.f7958b = 300;
        this.f7959c = null;
        this.f7960d = 0;
        this.f7961e = 1;
        this.f7957a = r8;
        this.f7958b = r10;
        this.f7959c = r11;
    }
}
