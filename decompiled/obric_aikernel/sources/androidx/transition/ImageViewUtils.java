package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
class ImageViewUtils {
    private static Field sDrawMatrixField = null;
    private static boolean sDrawMatrixFieldFetched = false;
    private static boolean sTryHiddenAnimateTransform = true;

    static {
    }

    private ImageViewUtils() {
    }

    static void animateTransform(@NonNull ImageView r10, @Nullable Matrix r11) {
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 29) goto L6;
        r10.animateTransform(r11);
        return;
    L6:
        if (r11 != null) goto L11;
        Drawable r13 = r10.getDrawable();
        if (r13 == null) goto L34;
        r13.setBounds(0, 0, (r10.getWidth() - r10.getPaddingLeft()) - r10.getPaddingRight(), (r10.getHeight() - r10.getPaddingTop()) - r10.getPaddingBottom());
    L25:
        r10.invalidate();
        return;
    L34:
        return;
    L11:
        if (r12 < 21) goto L13;
        hiddenAnimateTransform(r10, r11);
        return;
    L13:
        Drawable r14 = r10.getDrawable();
        if (r14 == null) goto L36;
        r14.setBounds(0, 0, r14.getIntrinsicWidth(), r14.getIntrinsicHeight());
        Matrix r15 = null;
        fetchDrawMatrixField();
        Field r16 = sDrawMatrixField;
        if (r16 != null) goto L29;
    L23:
        if (r15 == null) goto L25;
        r15.set(r11);
        goto L25
    L29:
        Matrix r17 = (Matrix) r16.get(r10);     // Catch: IllegalAccessException -> L28
        if (r17 == null) goto L31;
    L22:
        r15 = r17;
        goto L23
    L31:
        r15 = new Matrix();     // Catch: IllegalAccessException -> L27
        sDrawMatrixField.set(r10, r15);     // Catch: IllegalAccessException -> L28
        goto L23
    }

    private static void fetchDrawMatrixField() {
        if (sDrawMatrixFieldFetched == false) goto L9;
        return;
    L9:
        Field r10 = ImageView.class.getDeclaredField("mDrawMatrix");     // Catch: NoSuchFieldException -> L8
        sDrawMatrixField = r10;     // Catch: NoSuchFieldException -> L8
        r10.setAccessible(true);     // Catch: NoSuchFieldException -> L8
    L6:
        sDrawMatrixFieldFetched = true;
    }

    @RequiresApi(21)
    @SuppressLint({"NewApi"})
    private static void hiddenAnimateTransform(@NonNull ImageView r10, @Nullable Matrix r11) {
        if (sTryHiddenAnimateTransform == false) goto L10;
        r10.animateTransform(r11);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenAnimateTransform = false;
        return;
    }
}
