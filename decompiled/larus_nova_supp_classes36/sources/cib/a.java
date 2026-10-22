package cib;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.ss.android.lark.forseti.widget.MinChildHeightFrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static AppBarLayout a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if ((r3 instanceof AppBarLayout) == false) goto L7;
        return (AppBarLayout) r3;
    L7:
        if ((r3 instanceof ViewGroup) == false) goto L14;
        ViewGroup r4 = (ViewGroup) r3;
        int r0 = r4.getChildCount() - 1;
    L9:
        if ((-1) >= r0) goto L18;
        View r2 = r4.getChildAt(r0);
        Intrinsics.checkNotNull(r2);
        AppBarLayout r5 = a(r2);
        if (r5 != null) goto L12;
        r0 = r0 - 1;
        goto L9
    L12:
        return r5;
    L18:
        return null;
    L14:
        return null;
    }

    public static ViewGroup c(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        if ((r4 instanceof ViewPager) == true) goto L17;
        if ((r4 instanceof ViewPager2) == true) goto L17;
        if ((r4 instanceof ViewGroup) == false) goto L15;
        ViewGroup r5 = (ViewGroup) r4;
        int r0 = r5.getChildCount() - 1;
    L10:
        if ((-1) >= r0) goto L15;
        View r3 = r5.getChildAt(r0);
        Intrinsics.checkNotNull(r3);
        ViewGroup r6 = c(r3);
        if (r6 != null) goto L13;
        r0 = r0 - 1;
        goto L10
    L13:
        return r6;
    L15:
        return null;
    L17:
        if ((r4 instanceof ViewGroup) == true) goto L19;
        return null;
    L19:
        return (ViewGroup) r4;
    }

    public static View b(View r8, float r9, float r10) {
        Intrinsics.checkNotNullParameter(r8, "view");
        if (Intrinsics.areEqual(r8.getClass().getSimpleName(), "TextureMapView") == false) goto L5;
    L55:
        return r8;
    L5:
        if (Intrinsics.areEqual(r8.getClass().getSimpleName(), "MapView") == true) goto L55;
        if ((r8 instanceof ViewGroup) == false) goto L37;
        ViewGroup r0 = (ViewGroup) r8;
        int r2 = r0.getChildCount() - 1;
    L11:
        if ((-1) >= r2) goto L37;
        View r3 = r0.getChildAt(r2);
        Intrinsics.checkNotNull(r3);
        int[] r4 = new int[2];
        r3.getLocationOnScreen(r4);
        boolean r5 = false;
        int r6 = r4[0];
        if (r9 >= r6) goto L15;
    L21:
        boolean r7 = false;
    L22:
        if (r7 == false) goto L35;
        if (r3.getVisibility() != 0) goto L26;
        boolean r11 = true;
    L27:
        if (r11 == false) goto L35;
        View r12 = b(r3, r9, r10);
        if (r12 == null) goto L35;
        if (r12.getVisibility() != 0) goto L33;
        r5 = true;
    L33:
        if (r5 == false) goto L35;
        return r12;
    L26:
        r11 = false;
    L35:
        r2 = r2 - 1;
        goto L11
    L15:
        if (r9 >= (r6 + r3.getWidth())) goto L21;
        int r13 = r4[1];
        if (r10 < r13) goto L21;
        if (r10 >= (r13 + r3.getHeight())) goto L21;
        r7 = true;
    L37:
        if ((r8 instanceof ScrollView) == false) goto L40;
        ((ScrollView) r8).setNestedScrollingEnabled(true);
    L40:
        if (ViewCompat.isNestedScrollingEnabled(r8) == false) goto L42;
        return r8;
    L42:
        CoordinatorLayout.LayoutParams r14 = r8.getLayoutParams();
        if ((r14 instanceof CoordinatorLayout.LayoutParams) == false) goto L45;
        CoordinatorLayout.LayoutParams r15 = r14;
    L46:
        if (r15 == null) goto L48;
        CoordinatorLayout.Behavior r16 = r15.getBehavior();
    L49:
        if (r16 == null) goto L52;
        return r8;
    L52:
        if ((r8 instanceof MinChildHeightFrameLayout) == false) goto L54;
        return r8;
    L54:
        return null;
    L48:
        r16 = null;
        goto L49
    L45:
        r15 = null;
        goto L46
    }
}
