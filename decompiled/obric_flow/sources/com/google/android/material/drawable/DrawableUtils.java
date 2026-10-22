package com.google.android.material.drawable;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.ColorStateListDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import androidx.core.graphics.drawable.DrawableCompat;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class DrawableUtils {
    public static final int INTRINSIC_SIZE = -1;
    private static final int UNSPECIFIED_HEIGHT = -1;
    private static final int UNSPECIFIED_WIDTH = -1;

    @RequiresApi(21)
    public static class OutlineCompatL {
        private OutlineCompatL() {
        }

        @DoNotInline
        public static void setConvexPath(@NonNull Outline r5, @NonNull Path r10) {
            r5.setConvexPath(r10);
        }
    }

    @RequiresApi(30)
    public static class OutlineCompatR {
        private OutlineCompatR() {
        }

        @DoNotInline
        public static void setPath(@NonNull Outline r5, @NonNull Path r10) {
            r5.setPath(r10);
        }
    }

    private DrawableUtils() {
    }

    @Nullable
    public static Drawable compositeTwoLayeredDrawable(@Nullable Drawable r5, @Nullable Drawable r10) {
        return compositeTwoLayeredDrawable(r5, r10, -1, -1);
    }

    @Nullable
    public static Drawable createTintableDrawableIfNeeded(@Nullable Drawable r5, @Nullable ColorStateList r10, @Nullable PorterDuff.Mode r11) {
        return createTintableMutatedDrawableIfNeeded(r5, r10, r11, false);
    }

    @Nullable
    public static Drawable createTintableMutatedDrawableIfNeeded(@Nullable Drawable r5, @Nullable ColorStateList r10, @Nullable PorterDuff.Mode r11) {
        return createTintableMutatedDrawableIfNeeded(r5, r10, r11, false);
    }

    @NonNull
    public static int[] getCheckedState(@NonNull int[] r5) {
        int r10 = 0;
    L4:
        if (r10 >= r5.length) goto L12;
        int r11 = r5[r10];
        if (r11 == 16842912) goto L7;
        if (r11 == 0) goto L9;
        r10 = r10 + 1;
        goto L4
    L9:
        int[] r12 = (int[]) r5.clone();
        r12[r10] = 16842912;
        return r12;
    L7:
        return r5;
    L12:
        int[] r13 = Arrays.copyOf(r5, r5.length + 1);
        r13[r5.length] = 16842912;
        return r13;
    }

    @Nullable
    public static ColorStateList getColorStateListOrNull(@Nullable Drawable r5) {
        if ((r5 instanceof ColorDrawable) == false) goto L7;
        return ColorStateList.valueOf(((ColorDrawable) r5).getColor());
    L7:
        if ((r5 instanceof ColorStateListDrawable) == true) goto L9;
        return null;
    L9:
        return ((ColorStateListDrawable) r5).getColorStateList();
    }

    private static int getTopLayerIntrinsicHeight(@NonNull Drawable r5, @NonNull Drawable r10) {
        int r11 = r10.getIntrinsicHeight();
        if (r11 == (-1)) goto L6;
        return r11;
    L6:
        return r5.getIntrinsicHeight();
    }

    private static int getTopLayerIntrinsicWidth(@NonNull Drawable r5, @NonNull Drawable r10) {
        int r11 = r10.getIntrinsicWidth();
        if (r11 == (-1)) goto L6;
        return r11;
    L6:
        return r5.getIntrinsicWidth();
    }

    @NonNull
    public static int[] getUncheckedState(@NonNull int[] r10) {
        int[] r5 = new int[r10.length];
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L8;
        int r14 = r10[r12];
        if (r14 == 16842912) goto L7;
        r5[r13] = r14;
        r13 = r13 + 1;
    L7:
        r12 = r12 + 1;
        goto L3
    L8:
        return r5;
    }

    @NonNull
    public static AttributeSet parseDrawableXml(@NonNull Context r5, @XmlRes int r10, @NonNull CharSequence r11) {
        XmlResourceParser r12 = r5.getResources().getXml(r10);     // Catch: Throwable -> L12
    L3:
        int r13 = r12.next();     // Catch: Throwable -> L12
        if (r13 == 2) goto L7;
        if (r13 != 1) goto L3;
    L7:
        if (r13 != 2) goto L17;
        if (TextUtils.equals(r12.getName(), r11) == false) goto L15;
        return Xml.asAttributeSet(r12);
    L15:
        throw new XmlPullParserException("Must have a <" + r11 + "> start tag");     // Catch: Throwable -> L12
    L17:
        throw new XmlPullParserException("No start tag found");     // Catch: Throwable -> L12
    L12:
        e = move-exception;
        Resources.NotFoundException r14 = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(r10));
        r14.initCause(e);
        throw r14;
    }

    public static void setOutlineToPath(@NonNull Outline r5, @NonNull Path r10) {
        OutlineCompatR.setPath(r5, r10);
    }

    @TargetApi(21)
    public static void setRippleDrawableRadius(@Nullable RippleDrawable r5, int r10) {
        r5.setRadius(r10);
    }

    public static void setTint(@NonNull Drawable r5, @ColorInt int r10) {
        if (r10 == 0) goto L4;
        boolean r11 = true;
    L5:
        if (r11 == false) goto L7;
        DrawableCompat.setTint(r5, r10);
        return;
    L7:
        DrawableCompat.setTintList(r5, null);
        return;
    L4:
        r11 = false;
        goto L5
    }

    @Nullable
    public static PorterDuffColorFilter updateTintFilter(@NonNull Drawable r5, @Nullable ColorStateList r10, @Nullable PorterDuff.Mode r11) {
        if (r10 == null) goto L7;
        if (r11 != null) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(r10.getColorForState(r5.getState(), 0), r11);
    L7:
        return null;
    }

    @Nullable
    public static Drawable compositeTwoLayeredDrawable(@Nullable Drawable r5, @Nullable Drawable r10, @Px int r11, @Px int r12) {
        if (r5 != null) goto L4;
        return r10;
    L4:
        if (r10 != null) goto L7;
        return r5;
    L7:
        if (r11 != (-1)) goto L9;
        r11 = getTopLayerIntrinsicWidth(r5, r10);
    L9:
        if (r12 != (-1)) goto L12;
        r12 = getTopLayerIntrinsicHeight(r5, r10);
    L12:
        if (r11 <= r5.getIntrinsicWidth()) goto L14;
    L16:
        float r13 = r11 / r12;
        if (r13 < (r5.getIntrinsicWidth() / r5.getIntrinsicHeight())) goto L19;
        int r14 = r5.getIntrinsicWidth();
        r12 = (int) (r14 / r13);
        r11 = r14;
    L20:
        LayerDrawable r15 = new LayerDrawable(new Drawable[]{r5, r10});
        r15.setLayerSize(1, r11, r12);
        r15.setLayerGravity(1, 17);
        return r15;
    L19:
        r12 = r5.getIntrinsicHeight();
        r11 = (int) (r13 * r12);
        goto L20
    L14:
        if (r12 > r5.getIntrinsicHeight()) goto L16;
        goto L16
    }

    @Nullable
    private static Drawable createTintableMutatedDrawableIfNeeded(@Nullable Drawable r5, @Nullable ColorStateList r10, @Nullable PorterDuff.Mode r11, boolean r12) {
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r10 == null) goto L9;
        r5 = DrawableCompat.wrap(r5).mutate();
        if (r11 == null) goto L11;
        DrawableCompat.setTintMode(r5, r11);
    L11:
        return r5;
    L9:
        if (r12 == false) goto L11;
        r5.mutate();
        goto L11
    }
}
