package j0;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f8388a;

    public static class a {
        public static ViewPropertyAnimator a(ViewPropertyAnimator r8, ValueAnimator.AnimatorUpdateListener r10) {
            return r8.setUpdateListener(r10);
        }
    }

    public h0(View r8) {
        this.f8388a = new WeakReference(r8);
    }

    public final void a(float r8) {
        View r10 = this.f8388a.get();
        if (r10 == null) goto L6;
        r10.animate().alpha(r8);
        return;
    }

    public final void b() {
        View r8 = this.f8388a.get();
        if (r8 == null) goto L6;
        r8.animate().cancel();
        return;
    }

    public final void c(long r8) {
        View r10 = this.f8388a.get();
        if (r10 == null) goto L6;
        r10.animate().setDuration(r8);
        return;
    }

    public final void d(i0 r8) {
        View r10 = this.f8388a.get();
        if (r10 == null) goto L8;
        if (r8 == null) goto L6;
        r10.animate().setListener(new g0(r8, r10));
        return;
    L6:
        r10.animate().setListener(null);
        return;
    }

    public final void e(float r8) {
        View r10 = this.f8388a.get();
        if (r10 == null) goto L6;
        r10.animate().translationY(r8);
        return;
    }
}
