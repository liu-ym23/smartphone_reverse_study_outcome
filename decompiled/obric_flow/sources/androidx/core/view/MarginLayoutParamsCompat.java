package androidx.core.view;

import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class MarginLayoutParamsCompat {
    private MarginLayoutParamsCompat() {
    }

    @Deprecated
    public static int getLayoutDirection(@NonNull ViewGroup.MarginLayoutParams r5) {
        int r10 = r5.getLayoutDirection();
        if (r10 != 0) goto L5;
        return r10;
    L5:
        if (r10 == 1) goto L9;
        return 0;
    L9:
        return r10;
    }

    @Deprecated
    public static int getMarginEnd(@NonNull ViewGroup.MarginLayoutParams r5) {
        return r5.getMarginEnd();
    }

    @Deprecated
    public static int getMarginStart(@NonNull ViewGroup.MarginLayoutParams r5) {
        return r5.getMarginStart();
    }

    @Deprecated
    public static boolean isMarginRelative(@NonNull ViewGroup.MarginLayoutParams r5) {
        return r5.isMarginRelative();
    }

    @Deprecated
    public static void resolveLayoutDirection(@NonNull ViewGroup.MarginLayoutParams r5, int r10) {
        r5.resolveLayoutDirection(r10);
    }

    @Deprecated
    public static void setLayoutDirection(@NonNull ViewGroup.MarginLayoutParams r5, int r10) {
        r5.setLayoutDirection(r10);
    }

    @Deprecated
    public static void setMarginEnd(@NonNull ViewGroup.MarginLayoutParams r5, int r10) {
        r5.setMarginEnd(r10);
    }

    @Deprecated
    public static void setMarginStart(@NonNull ViewGroup.MarginLayoutParams r5, int r10) {
        r5.setMarginStart(r10);
    }
}
