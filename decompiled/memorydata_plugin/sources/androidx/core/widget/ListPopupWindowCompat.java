package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.ListPopupWindow;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class ListPopupWindowCompat {

    static class Api19Impl {
        private Api19Impl() {
        }

        static View.OnTouchListener createDragToOpenListener(ListPopupWindow r0, View r1) {
            return r0.createDragToOpenListener(r1);
        }
    }

    private ListPopupWindowCompat() {
    }

    public static View.OnTouchListener createDragToOpenListener(ListPopupWindow r2, View r3) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return null;
    L5:
        return Api19Impl.createDragToOpenListener(r2, r3);
    }

    @Deprecated
    public static View.OnTouchListener createDragToOpenListener(Object r2, View r3) {
        return createDragToOpenListener((ListPopupWindow) ZeusTransformUtils.preCheckCast(r2, ListPopupWindow.class, "com.obric.memorydata.plugin"), r3);
    }
}
