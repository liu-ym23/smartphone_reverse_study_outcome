package b41;

import android.graphics.RectF;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public boolean a;
    public View b;
    public RectF c;
    public final ViewTreeObserverOnGlobalLayoutListenerC0002a d;
    public final View e;
    public final Function1<RectF, Unit> f;

    /* JADX INFO: renamed from: b41.a$a, reason: collision with other inner class name */
    public static final class ViewTreeObserverOnGlobalLayoutListenerC0002a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ a a;

        public ViewTreeObserverOnGlobalLayoutListenerC0002a(a r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            a r0 = this.a;
            View r1 = r0.b;
            RectF r3 = null;
            if (r1 != null) goto L12;
            RectF r2 = r0.c;
            if (r2 == null) goto L30;
            if (r2 != null) goto L9;
        L11:
            r0.c = null;
            r0.f.invoke(null);
            return;
        L9:
            if (r2.equals(null) != true) goto L11;
            return;
        L30:
            return;
        L12:
            RectF r4 = a.a(r0.e);
            if (r4 == null) goto L19;
            RectF r5 = a.a(r1);
            if (r5 == null) goto L19;
            float r6 = r5.left - r4.left;
            float r7 = r5.top - r4.top;
            r3 = new RectF(r6, r7, r5.width() + r6, r5.height() + r7);
        L19:
            RectF r8 = r0.c;
            if (r8 != null) goto L23;
            if (r3 != null) goto L23;
            return;
        L23:
            if (r8 != null) goto L25;
        L27:
            r0.c = r3;
            r0.f.invoke(r3);
            return;
        L25:
            if (r8.equals(r3) != true) goto L27;
        }
    }

    public static RectF a(View r4) {
        if (ViewCompat.isAttachedToWindow(r4) == true) goto L5;
        return null;
    L5:
        Object r0 = r4.getParent();
        if ((r0 instanceof View) == true) goto L8;
        r0 = null;
    L8:
        View r1 = (View) r0;
        if (r1 != null) goto L11;
        return null;
    L11:
        int[] r2 = new int[2];
        r1.getLocationOnScreen(r2);
        float r3 = r2[0] + r4.getLeft();
        float r5 = r2[1] + r4.getTop();
        return new RectF(r3, r5, r4.getWidth() + r3, r4.getHeight() + r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(View r2, Function1<? super RectF, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "baseline");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.e = r2;
        this.f = r3;
        this.d = new ViewTreeObserverOnGlobalLayoutListenerC0002a(this);
    }
}
