package bc;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: bc.a$a, reason: collision with other inner class name */
    public static final class RunnableC0035a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f3150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f3151b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ int f3152m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ boolean f3153n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f3154o;

        public RunnableC0035a(View r8, int r10, int r11, boolean r12, ViewGroup r13) {
            this.f3150a = r8;
            this.f3151b = r10;
            this.f3152m = r11;
            this.f3153n = r12;
            this.f3154o = r13;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Rect r8 = new Rect();
            View r10 = this.f3150a;
            r10.getHitRect(r8);
            int r11 = (this.f3151b - r8.width()) / 2;
            int r12 = (this.f3152m - r8.height()) / 2;
            boolean r13 = this.f3153n;
            if (r11 >= 0) goto L6;
            if (r13 == true) goto L6;
            r11 = 0;
        L6:
            if (r12 >= 0) goto L9;
            if (r13 == true) goto L9;
            r12 = 0;
        L9:
            r8.left -= r11;
            r8.top -= r12;
            r8.right += r11;
            r8.bottom += r12;
            this.f3154o.setTouchDelegate(new TouchDelegate(r8, r10));
        }
    }

    public static final void a(View r8, int r10, int r11, boolean r12) {
        i.f(r8, "$this$expandTouchArea");
        if (r8.getParent() == null) goto L9;
        ViewParent r13 = r8.getParent();
        if (r13 == null) goto L8;
        ViewGroup r14 = (ViewGroup) r13;
    L10:
        if (r14 == null) goto L13;
        r14.post(new RunnableC0035a(r8, r10, r11, r12, r14));
        return;
    L13:
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L9:
        r14 = null;
        goto L10
    }

    public static final void b(View r8) {
        i.f(r8, "$this$makeGone");
        r8.setVisibility(8);
    }

    public static final void c(View r8) {
        i.f(r8, "$this$makeVisible");
        r8.setVisibility(0);
    }

    public static final void d(View r8, boolean r10) {
        i.f(r8, "$this$setVisibility");
        if (r10 == false) goto L5;
        c(r8);
        return;
    L5:
        b(r8);
    }
}
