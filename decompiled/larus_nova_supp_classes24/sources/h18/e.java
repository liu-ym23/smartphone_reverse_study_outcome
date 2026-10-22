package h18;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Typeface a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        TypedArray r0 = r3.obtainStyledAttributes(0, new int[]{R.attr.textSize, R.attr.typeface, R.attr.textStyle, R.attr.textColor, R.attr.textColorHint, R.attr.textColorLink, R.attr.shadowColor, R.attr.shadowDx, R.attr.shadowDy, R.attr.shadowRadius, R.attr.fontFamily, R.attr.textFontWeight, 2130970118, 2130970129, 2130974497, 2130974532});
        int r1 = r0.getResourceId(10, 0);
        if (r1 > 0) goto L12;
        Typeface r4 = Typeface.DEFAULT;
    L8:
        if (r4 != null) goto L10;
        r4 = Typeface.DEFAULT;
    L10:
        r0.recycle();
        return r4;
    L12:
        r4 = ResourcesCompat.getFont(r3, r1);     // Catch: Resources.NotFoundException -> L6
    L6:
        r4 = Typeface.DEFAULT;
        goto L8
    }

    public static Typeface b(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return Typeface.create(a(r1), r2);
    }
}
