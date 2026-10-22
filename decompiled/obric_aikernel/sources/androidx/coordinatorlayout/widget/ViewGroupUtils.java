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

    public static void getDescendantRect(ViewGroup r10, View r11, Rect r12) {
        r12.set(0, 0, r11.getWidth(), r11.getHeight());
        offsetDescendantRect(r10, r11, r12);
    }

    private static void offsetDescendantMatrix(ViewParent r10, View r11, Matrix r12) {
        Object r13 = r11.getParent();
        if ((r13 instanceof View) == false) goto L6;
        if (r13 == r10) goto L6;
        View r14 = (View) r13;
        offsetDescendantMatrix(r10, r14, r12);
        r12.preTranslate(-r14.getScrollX(), -r14.getScrollY());
    L6:
        r12.preTranslate(r11.getLeft(), r11.getTop());
        if (r11.getMatrix().isIdentity() == true) goto L10;
        r12.preConcat(r11.getMatrix());
        return;
    }

    static void offsetDescendantRect(ViewGroup r10, View r11, Rect r12) {
        ThreadLocal<Matrix> r13 = sMatrix;
        Matrix r14 = r13.get();
        if (r14 != null) goto L5;
        r14 = new Matrix();
        r13.set(r14);
    L6:
        offsetDescendantMatrix(r10, r11, r14);
        ThreadLocal<RectF> r15 = sRectF;
        RectF r16 = r15.get();
        if (r16 != null) goto L9;
        r16 = new RectF();
        r15.set(r16);
    L9:
        r16.set(r12);
        r14.mapRect(r16);
        r12.set((int) (r16.left + 0.5f), (int) (r16.top + 0.5f), (int) (r16.right + 0.5f), (int) (r16.bottom + 0.5f));
        return;
    L5:
        r14.reset();
        goto L6
    }
}
