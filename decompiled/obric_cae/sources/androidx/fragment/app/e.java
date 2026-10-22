package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f1949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f1950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k.a f1951c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f1952a;

        public a(e r8) {
            this.f1952a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e r8 = this.f1952a;
            r8.f1949a.endViewTransition(r8.f1950b);
            r8.f1951c.a();
        }
    }

    public e(View r8, ViewGroup r10, k.a r11) {
        this.f1949a = r10;
        this.f1950b = r8;
        this.f1951c = r11;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r8) {
        a r10 = new a(this);
        this.f1949a.post(r10);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r8) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r8) {
    }
}
