package ea;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import g.d;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f7210a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f7211b = null;

    static {
        f7210a = new int[]{R.attr.theme, com.obric.cae.R.attr.theme};
        f7211b = new int[]{com.obric.cae.R.attr.materialThemeOverlay};
    }

    public static Context a(Context r8, AttributeSet r10, int r11, int r12) {
        TypedArray r13 = r8.obtainStyledAttributes(r10, f7211b, r11, r12);
        int r14 = r13.getResourceId(0, 0);
        r13.recycle();
        if ((r8 instanceof d) == true) goto L5;
    L7:
        boolean r15 = false;
    L8:
        if (r14 == 0) goto L18;
        if (r15 == true) goto L18;
        d r16 = new d(r8, r14);
        TypedArray r17 = r8.obtainStyledAttributes(r10, f7210a);
        int r18 = r17.getResourceId(0, 0);
        int r19 = r17.getResourceId(1, 0);
        r17.recycle();
        if (r18 != 0) goto L15;
        r18 = r19;
    L15:
        if (r18 == 0) goto L17;
        r16.getTheme().applyStyle(r18, true);
    L17:
        return r16;
    L18:
        return r8;
    L5:
        if (((d) r8).f7438a != r14) goto L7;
        r15 = true;
        goto L8
    }
}
