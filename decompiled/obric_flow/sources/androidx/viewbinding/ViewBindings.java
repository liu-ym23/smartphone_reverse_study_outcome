package androidx.viewbinding;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class ViewBindings {
    private ViewBindings() {
    }

    @Nullable
    public static <T extends View> T findChildViewById(View r5, @IdRes int r10) {
        if ((r5 instanceof ViewGroup) == true) goto L5;
        return null;
    L5:
        ViewGroup r11 = (ViewGroup) r5;
        int r12 = r11.getChildCount();
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L11;
        T r14 = (T) r11.getChildAt(r13).findViewById(r10);
        if (r14 != null) goto L9;
        r13 = r13 + 1;
        goto L6
    L9:
        return r14;
    L11:
        return null;
    }
}
