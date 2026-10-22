package qs;

import android.view.View;
import android.view.WindowInsets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f21573a;

    static {
        int r5 = g.e;
    }

    public i(WindowInsets r5) {
        g r10 = new g(this, r5);
        r10.d = null;
        this.f21573a = r10;
    }

    public static i a(View r5, WindowInsets r10) {
        i r11 = new i((WindowInsets) Preconditions.checkNotNull(r10));
        if (r5 != null) goto L5;
    L11:
        return r11;
    L5:
        if (r5.isAttachedToWindow() == false) goto L11;
        int r12 = d.f21569a;
        WindowInsets r13 = r5.getRootWindowInsets();
        i r14 = null;
        if (r13 == null) goto L10;
        r14 = a(null, r13);
        h r15 = r14.f21573a;
        r15.m(r14);
        r5.getRootView();
        r15.d();
    L10:
        h r16 = r11.f21573a;
        r16.m(r14);
        r5.getRootView();
        r16.d();
        goto L11
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L10;
        return false;
    L10:
        return ObjectsCompat.equals(this.f21573a, ((i) r5).f21573a);
    }

    public final int hashCode() {
        h r5 = this.f21573a;
        if (r5 != null) goto L6;
        return 0;
    L6:
        return r5.hashCode();
    }

    public i() {
        this.f21573a = new h(this);
    }
}
