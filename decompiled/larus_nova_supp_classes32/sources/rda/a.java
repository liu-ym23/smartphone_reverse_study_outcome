package rda;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.lynx.textra.PlatformFontCaps;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static NovaTitleBarEx b(OFloatingTitleBar r6) {
        if (r6 == null) goto L9;
        FrameLayout r0 = (FrameLayout) r6.findViewById(2131388812);
        ViewParent r1 = r0.getParent();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r2 = (ViewGroup) r1;
        int r3 = r2.indexOfChild(r0);
        r2.removeViewInLayout(r0);
        r6.R(false);
        r6.setBackgroundColor(c.a(2130970531, r6.getContext(), 2131102535));
        ViewGroup.LayoutParams r7 = r0.getLayoutParams();
        NovaTitleBarEx r4 = new NovaTitleBarEx(r0.getContext());
        if (r7 == null) goto L6;
        r2.addView(r4, r3, r7);
    L7:
        return r4;
    L6:
        r2.addView(r4, r3);
        goto L7
    L9:
        throw new IllegalArgumentException("oTitle must not be null".toString());
    }

    public static void a(OCardListItem r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "item");
        float r0 = i5.q();
        if (r14 == 0) goto L6;
        if (r14 == 3) goto L6;
        boolean r4 = true;
    L7:
        GradientDrawable r5 = null;
        if (r14 != 0) goto L10;
        float[] r15 = {r0, r0, r0, r0, r0, r0, r0, r0};
    L16:
        r13.o(r4);
        Drawable r1 = r13.getCardContainer().getBackground();
        if ((r1 instanceof GradientDrawable) == false) goto L19;
        r5 = (GradientDrawable) r1;
    L19:
        if (r5 == null) goto L22;
        if (r15 == null) goto L22;
        r5.setCornerRadii(r15);
    L22:
        r13.getCardContainer().setPadding(i5.Y(), i5.Y(), i5.Y(), i5.Y());
        r13.getTitleView().setTypeface(Typeface.create(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0), 500, false));
        return;
    L10:
        if (r14 == 1) goto L14;
        if (r14 == 3) goto L13;
        r15 = null;
        goto L16
    L13:
        r15 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r0, r0, r0, r0};
        goto L16
    L14:
        r15 = new float[]{r0, r0, r0, r0, 0.0f, 0.0f, 0.0f, 0.0f};
    L6:
        r4 = false;
        goto L7
    }
}
