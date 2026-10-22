package ida;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class t {

    public static final class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ boolean a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
        }

        public a(boolean r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            r2.removeOnAttachStateChangeListener(this);
            t.a(r2, this.a);
        }
    }

    public static final void a(View r5, boolean r6) {
        if (r5.getParent() != null) goto L6;
        r5.addOnAttachStateChangeListener(new a(r6));
        return;
    L6:
        int r0 = 0;
        r5.setVisibility(0);
        Object r7 = r5.getParent();
        ViewGroup r2 = null;
        if ((r7 instanceof View) == false) goto L9;
        View r8 = (View) r7;
    L10:
        if (r8 != null) goto L13;
        return;
    L13:
        if (r6 == false) goto L15;
        int r3 = 0;
    L16:
        r8.setVisibility(r3);
        ViewParent r4 = r8.getParent();
        if ((r4 instanceof ViewGroup) == false) goto L19;
        r2 = (ViewGroup) r4;
    L19:
        if (r2 != null) goto L21;
        return;
    L21:
        int r9 = r2.indexOfChild(r8);
        if (r9 <= 0) goto L31;
        View r10 = r2.getChildAt(r9 - 1);
        if (r10 != null) goto L26;
        return;
    L26:
        if (r6 == true) goto L29;
        r0 = 8;
    L29:
        r10.setVisibility(r0);
        return;
    L31:
        return;
    L15:
        r3 = 8;
        goto L16
    L9:
        r8 = null;
        goto L10
    }
}
