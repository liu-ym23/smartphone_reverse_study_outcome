package r6a;

import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ScrollingView;
import androidx.viewpager.widget.ViewPager;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements Interpolator {
    public static final float b = 0.0f;
    public static final float c = 0.0f;
    public static final float d = 0.0f;
    public final int a;

    static {
        Resources r0 = Resources.getSystem();
        b = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density;
        float r1 = 1.0f / g(1.0f);
        c = r1;
        d = 1.0f - (r1 * g(1.0f));
    }

    public b(int r1) {
        this.a = r1;
    }

    public static int c(float r1) {
        return (int) ((r1 * b) + 0.5f);
    }

    public static boolean d(View r3) {
        if ((r3 instanceof AbsListView) == false) goto L5;
    L14:
        boolean r0 = true;
    L15:
        if (r0 == false) goto L17;
    L20:
        return true;
    L17:
        if ((r3 instanceof ViewPager) == true) goto L20;
        if ((r3 instanceof NestedScrollingParent) == true) goto L20;
        return false;
    L5:
        if ((r3 instanceof ScrollView) == true) goto L14;
        if ((r3 instanceof ScrollingView) == true) goto L14;
        if ((r3 instanceof WebView) == true) goto L14;
        if ((r3 instanceof NestedScrollingChild) == true) goto L14;
        r0 = false;
        goto L15
    }

    public static int f(View r3) {
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (r0 != null) goto L5;
        r0 = new ViewGroup.LayoutParams(-1, -2);
    L5:
        int r1 = ViewGroup.getChildMeasureSpec(0, 0, r0.width);
        int r2 = r0.height;
        if (r2 <= 0) goto L8;
        int r4 = View.MeasureSpec.makeMeasureSpec(r2, 1073741824);
    L9:
        r3.measure(r1, r4);
        return r3.getMeasuredHeight();
    L8:
        r4 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L9
    }

    public static float g(float r3) {
        float r4 = r3 * 8.0f;
        if (r4 >= 1.0f) goto L6;
        return r4 - (1.0f - ((float) Math.exp(-r4)));
    L6:
        return 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - r4))) * 0.63212055f);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r3) {
        if (this.a != 1) goto L6;
        float r4 = 1.0f - r3;
        return 1.0f - (r4 * r4);
    L6:
        float r0 = c * g(r3);
        if (r0 > 0.0f) goto L9;
        return r0;
    L9:
        return r0 + d;
    }

    public static boolean b(View r6, PointF r7) {
        if (r6.canScrollVertically(-1) == false) goto L8;
        if (r6.getVisibility() != 0) goto L8;
        return false;
    L8:
        if ((r6 instanceof ViewGroup) == false) goto L22;
        if (r7 == null) goto L27;
        ViewGroup r8 = (ViewGroup) r6;
        int r0 = r8.getChildCount();
        PointF r2 = new PointF();
    L11:
        if (r0 <= 0) goto L28;
        r0 = r0 - 1;
        View r3 = r8.getChildAt(r0);
        if (e(r8, r3, r7.x, r7.y, r2) == false) goto L11;
        if ("fixed".equals(r3.getTag()) == false) goto L17;
    L21:
        return false;
    L17:
        if ("fixed-bottom".equals(r3.getTag()) == true) goto L21;
        r7.offset(r2.x, r2.y);
        boolean r9 = b(r3, r7);
        r7.offset(-r2.x, -r2.y);
        return r9;
    L28:
        return true;
    L27:
        return true;
    L22:
        return true;
    }

    public static boolean a(View r8, PointF r9, boolean r10) {
        if (r8.canScrollVertically(1) == false) goto L8;
        if (r8.getVisibility() != 0) goto L8;
        return false;
    L8:
        if ((r8 instanceof ViewGroup) == false) goto L36;
        if (r9 == null) goto L36;
        if ((r8 instanceof AbsListView) == false) goto L13;
    L22:
        boolean r1 = true;
    L23:
        if (r1 == true) goto L36;
        ViewGroup r2 = (ViewGroup) r8;
        int r3 = r2.getChildCount();
        PointF r4 = new PointF();
    L25:
        if (r3 <= 0) goto L36;
        r3 = r3 - 1;
        View r5 = r2.getChildAt(r3);
        if (e(r2, r5, r9.x, r9.y, r4) == false) goto L25;
        if ("fixed".equals(r5.getTag()) == false) goto L31;
    L35:
        return false;
    L31:
        if ("fixed-top".equals(r5.getTag()) == true) goto L35;
        r9.offset(r4.x, r4.y);
        boolean r11 = a(r5, r9, r10);
        r9.offset(-r4.x, -r4.y);
        return r11;
    L13:
        if ((r8 instanceof ScrollView) == true) goto L22;
        if ((r8 instanceof ScrollingView) == true) goto L22;
        if ((r8 instanceof WebView) == true) goto L22;
        if ((r8 instanceof NestedScrollingChild) == true) goto L22;
        r1 = false;
    L36:
        if (r10 == false) goto L38;
        return true;
    L38:
        if (r8.canScrollVertically(-1) == true) goto L46;
        return false;
    L46:
        return true;
    }

    public static boolean e(View r6, View r7, float r8, float r9, PointF r10) {
        if (r7.getVisibility() == 0) goto L5;
        return false;
    L5:
        float[] r0 = {r8, r9};
        r0[0] = (r6.getScrollX() - r7.getLeft()) + r8;
        float r3 = r0[1] + (r6.getScrollY() - r7.getTop());
        r0[1] = r3;
        float r11 = r0[0];
        if (r11 >= 0.0f) goto L8;
    L14:
        boolean r12 = false;
    L15:
        if (r12 == false) goto L17;
        r10.set(r0[0] - r8, r0[1] - r9);
    L17:
        return r12;
    L8:
        if (r3 < 0.0f) goto L14;
        if (r11 >= r7.getWidth()) goto L14;
        if (r0[1] >= r7.getHeight()) goto L14;
        r12 = true;
        goto L15
    }
}
