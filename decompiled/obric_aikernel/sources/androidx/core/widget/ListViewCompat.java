package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.ListView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class ListViewCompat {

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static boolean canScrollList(ListView r10, int r11) {
            return r10.canScrollList(r11);
        }

        @DoNotInline
        static void scrollListBy(ListView r10, int r11) {
            r10.scrollListBy(r11);
        }
    }

    private ListViewCompat() {
    }

    public static boolean canScrollList(@NonNull ListView r10, int r11) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        int r12 = r10.getChildCount();
        if (r12 != 0) goto L9;
        return false;
    L9:
        int r13 = r10.getFirstVisiblePosition();
        if (r11 <= 0) goto L17;
        int r14 = r10.getChildAt(r12 - 1).getBottom();
        if ((r13 + r12) < r10.getCount()) goto L16;
        if (r14 > (r10.getHeight() - r10.getListPaddingBottom())) goto L16;
        return false;
    L16:
        return true;
    L17:
        int r15 = r10.getChildAt(0).getTop();
        if (r13 > 0) goto L22;
        if (r15 < r10.getListPaddingTop()) goto L22;
        return false;
    L22:
        return true;
    L5:
        return Api19Impl.canScrollList(r10, r11);
    }

    public static void scrollListBy(@NonNull ListView r10, int r11) {
        if (Build.VERSION.SDK_INT < 19) goto L5;
        Api19Impl.scrollListBy(r10, r11);
        return;
    L5:
        int r12 = r10.getFirstVisiblePosition();
        if (r12 != (-1)) goto L8;
        return;
    L8:
        View r13 = r10.getChildAt(0);
        if (r13 != null) goto L11;
        return;
    L11:
        r10.setSelectionFromTop(r12, r13.getTop() - r11);
    }
}
