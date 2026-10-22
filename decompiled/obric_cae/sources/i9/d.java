package i9;

import android.view.View;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f8298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8301d;

    public d(View r8) {
        this.f8298a = r8;
    }

    public final void a() {
        int r8 = this.f8301d;
        View r10 = this.f8298a;
        int r11 = r8 - (r10.getTop() - this.f8299b);
        WeakHashMap<View, h0> r12 = w.f8437a;
        r10.offsetTopAndBottom(r11);
        r10.offsetLeftAndRight(0 - (r10.getLeft() - this.f8300c));
    }
}
