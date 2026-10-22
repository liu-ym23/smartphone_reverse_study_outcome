package androidx.coordinatorlayout.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ViewGroupUtils {
    private static final ThreadLocal<Matrix> sMatrix = null;
    private static final ThreadLocal<RectF> sRectF = null;

    static {
        sMatrix = new ThreadLocal();
        sRectF = new ThreadLocal();
    }

    private ViewGroupUtils() {
    }

    public static void getDescendantRect(ViewGroup r5, View r10, Rect r11) {
        r11.set(0, 0, r10.getWidth(), r10.getHeight());
        offsetDescendantRect(r5, r10, r11);
    }

    private static void offsetDescendantMatrix(ViewParent r5, View r10, Matrix r11) {
        Object r12 = r10.getParent();
        if ((r12 instanceof View) == false) goto L6;
        if (r12 == r5) goto L6;
        View r13 = (View) r12;
        offsetDescendantMatrix(r5, r13, r11);
        r11.preTranslate(-r13.getScrollX(), -r13.getScrollY());
    L6:
        r11.preTranslate(r10.getLeft(), r10.getTop());
        if (r10.getMatrix().isIdentity() == true) goto L10;
        r11.preConcat(r10.getMatrix());
        return;
    }

    public static void offsetDescendantRect(ViewGroup r5, View r10, Rect r11) {
        ThreadLocal<Matrix> r12 = sMatrix;
        Matrix r13 = r12.get();
        if (r13 != null) goto L5;
        r13 = new Matrix();
        r12.set(r13);
    L6:
        offsetDescendantMatrix(r5, r10, r13);
        ThreadLocal<RectF> r14 = sRectF;
        RectF r15 = r14.get();
        if (r15 != null) goto L9;
        r15 = new RectF();
        r14.set(r15);
    L9:
        r15.set(r11);
        r13.mapRect(r15);
        r11.set((int) (r15.left + 0.5f), (int) (r15.top + 0.5f), (int) (r15.right + 0.5f), (int) (r15.bottom + 0.5f));
        return;
    L5:
        r13.reset();
        goto L6
    }
}
