package r5;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f12688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f12689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private TimeInterpolator f12690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f12691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f12692e;

    public i(long r10, long r11) {
        this.f12688a = 0;
        this.f12689b = 300;
        this.f12690c = null;
        this.f12691d = 0;
        this.f12692e = 1;
        this.f12688a = r10;
        this.f12689b = r11;
    }

    public i(long r10, long r11, @NonNull TimeInterpolator r12) {
        this.f12688a = 0;
        this.f12689b = 300;
        this.f12690c = null;
        this.f12691d = 0;
        this.f12692e = 1;
        this.f12688a = r10;
        this.f12689b = r11;
        this.f12690c = r12;
    }

    @NonNull
    static i b(@NonNull ValueAnimator r10) {
        i r11 = new i(r10.getStartDelay(), r10.getDuration(), f(r10));
        r11.f12691d = r10.getRepeatCount();
        r11.f12692e = r10.getRepeatMode();
        return r11;
    }

    private static TimeInterpolator f(@NonNull ValueAnimator r10) {
        TimeInterpolator r11 = r10.getInterpolator();
        if ((r11 instanceof AccelerateDecelerateInterpolator) == true) goto L15;
        if (r11 == null) goto L15;
        if ((r11 instanceof AccelerateInterpolator) == false) goto L11;
        return a.f12675c;
    L11:
        if ((r11 instanceof DecelerateInterpolator) == true) goto L13;
        return r11;
    L13:
        return a.f12676d;
    L15:
        return a.f12674b;
    }

    public void a(@NonNull Animator r10) {
        r10.setStartDelay(c());
        r10.setDuration(d());
        r10.setInterpolator(e());
        if ((r10 instanceof ValueAnimator) == false) goto L6;
        ValueAnimator r11 = (ValueAnimator) r10;
        r11.setRepeatCount(g());
        r11.setRepeatMode(h());
        return;
    }

    public long c() {
        return this.f12688a;
    }

    public long d() {
        return this.f12689b;
    }

    @Nullable
    public TimeInterpolator e() {
        TimeInterpolator r10 = this.f12690c;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return a.f12674b;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof i) == true) goto L8;
        return false;
    L8:
        i r11 = (i) r10;
        if (c() == r11.c()) goto L12;
        return false;
    L12:
        if (d() == r11.d()) goto L15;
        return false;
    L15:
        if (g() == r11.g()) goto L18;
        return false;
    L18:
        if (h() == r11.h()) goto L21;
        return false;
    L21:
        return e().getClass().equals(r11.e().getClass());
    }

    public int g() {
        return this.f12691d;
    }

    public int h() {
        return this.f12692e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    @NonNull
    public String toString() {
        return '\n' + i.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }
}
