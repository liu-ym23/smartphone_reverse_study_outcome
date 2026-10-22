package androidx.activity;

import android.window.BackEvent;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f473d;

    public b(BackEvent r8) {
        he.i.f(r8, "backEvent");
        a r10 = a.f469a;
        float r11 = r10.d(r8);
        float r12 = r10.e(r8);
        float r13 = r10.b(r8);
        int r14 = r10.c(r8);
        this.f470a = r11;
        this.f471b = r12;
        this.f472c = r13;
        this.f473d = r14;
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder("BackEventCompat{touchX=");
        r8.append(this.f470a);
        r8.append(", touchY=");
        r8.append(this.f471b);
        r8.append(", progress=");
        r8.append(this.f472c);
        r8.append(", swipeEdge=");
        return android.aimedia.a.f(r8, this.f473d, '}');
    }
}
