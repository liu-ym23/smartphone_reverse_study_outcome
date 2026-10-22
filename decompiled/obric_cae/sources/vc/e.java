package vc;

import android.view.View;
import j0.h0;
import j0.w;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f12838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12841d;

    public e(View r8) {
        this.f12838a = r8;
    }

    public final void a() {
        int r8 = this.f12841d;
        View r10 = this.f12838a;
        int r11 = r8 - (r10.getTop() - this.f12839b);
        WeakHashMap<View, h0> r12 = w.f8437a;
        r10.offsetTopAndBottom(r11);
        r10.offsetLeftAndRight(0 - (r10.getLeft() - this.f12840c));
    }
}
