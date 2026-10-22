package s08;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends FrameLayout {
    public AbstractC0123a a;
    public AbstractC0123a b;
    public AbstractC0123a c;
    public AbstractC0123a d;

    /* JADX INFO: renamed from: s08.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0123a {

        /* JADX INFO: renamed from: s08.a$a$a, reason: collision with other inner class name */
        public static final class C0124a extends AbstractC0123a {
            public final int a;

            public final String toString() {
                return "DimensionPixelSize(" + this.a + ')';
            }

            public C0124a(int r1) {
                this.a = r1;
            }

            @Override // s08.a.AbstractC0123a
            public final int a(Context r1, int r2) {
                Intrinsics.checkNotNullParameter(r1, "context");
                return this.a;
            }
        }

        /* JADX INFO: renamed from: s08.a$a$b */
        public static final class b extends AbstractC0123a {
            public final float a;

            public final String toString() {
                return "PercentSize(" + this.a + ')';
            }

            public b(float r1) {
                this.a = r1;
            }

            @Override // s08.a.AbstractC0123a
            public final int a(Context r2, int r3) {
                Intrinsics.checkNotNullParameter(r2, "context");
                return (int) (this.a * r3);
            }
        }

        public AbstractC0123a() {
        }

        public abstract int a(Context r1, int r2);
    }

    public final AbstractC0123a getDialogHeight() {
        return this.d;
    }

    public final AbstractC0123a getDialogWidth() {
        return this.c;
    }

    public final AbstractC0123a getMaxHeight() {
        return this.b;
    }

    public final AbstractC0123a getMaxWidth() {
        return this.a;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new AbstractC0123a.C0124a(LKUIToast.DURATION_MAX);
        this.b = new AbstractC0123a.C0124a(LKUIToast.DURATION_MAX);
        this.c = new AbstractC0123a.C0124a(-2);
        this.d = new AbstractC0123a.C0124a(-2);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r3) {
        if (getChildCount() != 1) goto L5;
        return;
    L5:
        super.addView(r3);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        View r1 = getChildAt(0);
        if (r1 == null) goto L5;
        Rect r2 = new Rect();
        r1.getHitRect(r2);
        if (r2.contains((int) r5.getX(), (int) r5.getY()) == false) goto L10;
        return false;
    L10:
        return super.onTouchEvent(r5);
    L5:
        return super.onTouchEvent(r5);
    }

    public final void setDialogHeight(AbstractC0123a r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.d = r2;
        requestLayout();
    }

    public final void setDialogWidth(AbstractC0123a r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.c = r2;
        requestLayout();
    }

    public final void setMaxHeight(AbstractC0123a r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.b = r2;
        requestLayout();
    }

    public final void setMaxWidth(AbstractC0123a r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.a = r2;
        requestLayout();
    }

    @Override // android.view.ViewGroup
    public final void addView(View r3, int r4) {
        if (getChildCount() != 1) goto L5;
        return;
    L5:
        super.addView(r3, r4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r6, int r7) {
        int r0 = View.MeasureSpec.getSize(r6);
        int r8 = a(r6, this.c, this.a, getPaddingLeft() + getPaddingRight());
        int r9 = a(r7, this.d, this.b, getPaddingTop() + getPaddingBottom());
        View r1 = getChildAt(0);
        if (r1 != null) goto L5;
        return;
    L5:
        r1.measure(r8, r9);
        int r10 = this.a.a(getContext(), r0);
        int r11 = (r1.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight();
        if (r1.getMeasuredWidth() >= r10) goto L8;
        r11 = r11 | 16777216;
    L8:
        setMeasuredDimension(r11, (r1.getMeasuredHeight() + getPaddingTop()) + getPaddingBottom());
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r3, ViewGroup.LayoutParams r4) {
        if (getChildCount() != 1) goto L5;
        return;
    L5:
        super.addView(r3, r4);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r3, int r4, int r5) {
        if (getChildCount() != 1) goto L5;
        return;
    L5:
        super.addView(r3, r4, r5);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r3, int r4, ViewGroup.LayoutParams r5) {
        if (getChildCount() != 1) goto L5;
        return;
    L5:
        super.addView(r3, r4, r5);
    }

    public final int a(int r3, AbstractC0123a r4, AbstractC0123a r5, int r6) {
        int r0 = View.MeasureSpec.getSize(r3);
        int r1 = View.MeasureSpec.getMode(r3);
        if (r1 != 0) goto L5;
        return r3;
    L5:
        int r7 = r4.a(getContext(), r0);
        int r8 = r5.a(getContext(), r0);
        int r2 = r0 - r6;
        if (r7 <= 0) goto L10;
        r2 = Math.min(r2, Math.min(r7, r8));
    L8:
        r1 = 1073741824;
    L16:
        return View.MeasureSpec.makeMeasureSpec(r2, r1);
    L10:
        if (r7 != (-2)) goto L13;
        r2 = Math.min(r2, r8);
        r1 = LKBaseResponseModel.DEFAULT_ERROR_CODE;
        goto L16
    L13:
        if (r7 != (-1)) goto L16;
        goto L8
    }
}
