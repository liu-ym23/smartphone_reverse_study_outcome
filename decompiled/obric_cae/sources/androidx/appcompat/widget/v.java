package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class v extends g0 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final /* synthetic */ AppCompatSpinner.g f1272t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ AppCompatSpinner f1273u;

    public v(AppCompatSpinner r8, View r10, AppCompatSpinner.g r11) {
        this.f1273u = r8;
        this.f1272t = r11;
        super(r10);
    }

    @Override // androidx.appcompat.widget.g0
    public final h.f b() {
        return this.f1272t;
    }

    @Override // androidx.appcompat.widget.g0
    @SuppressLint({"SyntheticAccessor"})
    public final boolean c() {
        AppCompatSpinner r8 = this.f1273u;
        if (r8.getInternalPopup().isShowing() == true) goto L7;
        int r10 = AppCompatSpinner.c.b(r8);
        int r11 = AppCompatSpinner.c.a(r8);
        r8.f978p.show(r10, r11);
        return true;
    L7:
        return true;
    }
}
