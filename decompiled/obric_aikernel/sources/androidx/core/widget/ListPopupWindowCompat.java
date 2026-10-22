package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.ListPopupWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class ListPopupWindowCompat {

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static View.OnTouchListener createDragToOpenListener(ListPopupWindow r10, View r11) {
            return r10.createDragToOpenListener(r11);
        }
    }

    private ListPopupWindowCompat() {
    }

    @Nullable
    public static View.OnTouchListener createDragToOpenListener(@NonNull ListPopupWindow r10, @NonNull View r11) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return null;
    L5:
        return Api19Impl.createDragToOpenListener(r10, r11);
    }

    @Deprecated
    public static View.OnTouchListener createDragToOpenListener(Object r10, View r11) {
        return createDragToOpenListener((ListPopupWindow) r10, r11);
    }
}
