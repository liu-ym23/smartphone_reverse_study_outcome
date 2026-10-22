package yb8;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.internal.Intrinsics;
import v19.h;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final SimpleDraweeView a(ConstraintLayout r5, GenericDraweeView r6) {
        int r0 = r5.indexOfChild(r6);
        ConstraintLayout.LayoutParams r1 = r6.getLayoutParams();
        if ((r1 instanceof ConstraintLayout.LayoutParams) == false) goto L5;
        ConstraintLayout.LayoutParams r2 = r1;
    L6:
        int r3 = r6.getVisibility();
        r5.removeView(r6);
        SimpleDraweeView r4 = new SimpleDraweeView(r5.getContext());
        r4.setId(r6.getId());
        if (r2 == null) goto L17;
        int r7 = ((ViewGroup.MarginLayoutParams) r2).width;
        if (r7 <= 0) goto L11;
        if (r7 == (-2)) goto L11;
    L12:
        int r8 = ((ViewGroup.MarginLayoutParams) r2).height;
        if (r8 <= 0) goto L15;
        if (r8 == (-2)) goto L15;
    L16:
        r4.setLayoutParams(r2);
    L15:
        ((ViewGroup.MarginLayoutParams) r2).height = i5.Q();
    L11:
        ((ViewGroup.MarginLayoutParams) r2).width = i5.Q();
    L17:
        r4.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(i5.c()));
        r4.setVisibility(r3);
        r5.addView(r4, r0);
        return r4;
    L5:
        r2 = null;
        goto L6
    }

    public static final String b(String r4, String r5) {
        boolean r0 = false;
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L19;
        if (r5 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L19;
        return null;
    L13:
        if (r5.length() == 0) goto L16;
        r3 = false;
    L19:
        boolean r6 = h.a;
        if (h.a(null) == false) goto L28;
        if (r5 != null) goto L23;
    L24:
        r0 = true;
    L25:
        if (r0 == true) goto L28;
        r4 = r5;
        goto L28
    L23:
        if (r5.length() != 0) goto L25;
    L28:
        return r4;
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    public static final void c(TextView r2, boolean r3) {
        ViewGroup.LayoutParams r0 = r2.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams r1 = (ConstraintLayout.LayoutParams) r0;
        if (r3 == false) goto L5;
        r1.setMarginStart(i5.q());
        r1.setMarginEnd(0);
    L6:
        r2.setLayoutParams(r1);
        return;
    L5:
        r1.setMarginStart(0);
        r1.setMarginEnd(0);
        goto L6
    }
}
