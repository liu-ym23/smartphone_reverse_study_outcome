package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class PopupWindowCompat {
    private static final String TAG = "PopupWindowCompatApi21";
    private static Method sGetWindowLayoutTypeMethod;
    private static boolean sGetWindowLayoutTypeMethodAttempted;
    private static Field sOverlapAnchorField;
    private static boolean sOverlapAnchorFieldAttempted;
    private static Method sSetWindowLayoutTypeMethod;
    private static boolean sSetWindowLayoutTypeMethodAttempted;

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static boolean getOverlapAnchor(PopupWindow r5) {
            return r5.getOverlapAnchor();
        }

        @DoNotInline
        public static int getWindowLayoutType(PopupWindow r5) {
            return r5.getWindowLayoutType();
        }

        @DoNotInline
        public static void setOverlapAnchor(PopupWindow r5, boolean r10) {
            r5.setOverlapAnchor(r10);
        }

        @DoNotInline
        public static void setWindowLayoutType(PopupWindow r5, int r10) {
            r5.setWindowLayoutType(r10);
        }
    }

    private PopupWindowCompat() {
    }

    public static boolean getOverlapAnchor(@NonNull PopupWindow r5) {
        return Api23Impl.getOverlapAnchor(r5);
    }

    public static int getWindowLayoutType(@NonNull PopupWindow r5) {
        return Api23Impl.getWindowLayoutType(r5);
    }

    public static void setOverlapAnchor(@NonNull PopupWindow r5, boolean r10) {
        Api23Impl.setOverlapAnchor(r5, r10);
    }

    public static void setWindowLayoutType(@NonNull PopupWindow r5, int r10) {
        Api23Impl.setWindowLayoutType(r5, r10);
    }

    public static void showAsDropDown(@NonNull PopupWindow r5, @NonNull View r10, int r11, int r12, int r13) {
        r5.showAsDropDown(r10, r11, r12, r13);
    }
}
