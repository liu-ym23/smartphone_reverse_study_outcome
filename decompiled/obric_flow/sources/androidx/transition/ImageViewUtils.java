package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.widget.ImageView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
class ImageViewUtils {
    private static Field sDrawMatrixField = null;
    private static boolean sDrawMatrixFieldFetched = false;
    private static boolean sTryHiddenAnimateTransform = true;

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static void animateTransform(ImageView r5, Matrix r10) {
            r5.animateTransform(r10);
        }
    }

    private ImageViewUtils() {
    }

    public static void animateTransform(@NonNull ImageView r5, @Nullable Matrix r10) {
        Api29Impl.animateTransform(r5, r10);
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    private static void fetchDrawMatrixField() {
        if (sDrawMatrixFieldFetched == false) goto L9;
        return;
    L9:
        Field r5 = ImageView.class.getDeclaredField("mDrawMatrix");     // Catch: NoSuchFieldException -> L8
        sDrawMatrixField = r5;     // Catch: NoSuchFieldException -> L8
        r5.setAccessible(true);     // Catch: NoSuchFieldException -> L8
    L6:
        sDrawMatrixFieldFetched = true;
    }

    @RequiresApi(21)
    @SuppressLint({"NewApi"})
    private static void hiddenAnimateTransform(@NonNull ImageView r5, @Nullable Matrix r10) {
        if (sTryHiddenAnimateTransform == false) goto L10;
        Api29Impl.animateTransform(r5, r10);     // Catch: NoSuchMethodError -> L6
        return;
    L6:
        sTryHiddenAnimateTransform = false;
        return;
    }
}
