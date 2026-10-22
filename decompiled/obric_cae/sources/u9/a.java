package u9;

import android.view.ViewTreeObserver;
import com.google.android.material.floatingactionbutton.d;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f12522a;

    public a(d r8) {
        this.f12522a = r8;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        d r8 = this.f12522a;
        float r10 = r8.f4793q.getRotation();
        if (r8.f4786j == r10) goto L7;
        r8.f4786j = r10;
        r8.m();
        return true;
    L7:
        return true;
    }
}
