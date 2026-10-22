package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Rect f1115a = null;

    public static class a {
        public static Insets a(Drawable r8) {
            return r8.getOpticalInsets();
        }
    }

    static {
        f1115a = new Rect();
    }

    public static Rect a(Drawable r8) {
        Insets r10 = a.a(r8);
        return new Rect(r10.left, r10.top, r10.right, r10.bottom);
    }

    public static PorterDuff.Mode b(int r8, PorterDuff.Mode r10) {
        if (r8 == 3) goto L21;
        if (r8 == 5) goto L19;
        if (r8 == 9) goto L17;
        switch(r8) {
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            default: goto L9;
        };
    L9:
        return r10;
    L11:
        return PorterDuff.Mode.ADD;
    L13:
        return PorterDuff.Mode.SCREEN;
    L15:
        return PorterDuff.Mode.MULTIPLY;
    L17:
        return PorterDuff.Mode.SRC_ATOP;
    L19:
        return PorterDuff.Mode.SRC_IN;
    L21:
        return PorterDuff.Mode.SRC_OVER;
    }
}
