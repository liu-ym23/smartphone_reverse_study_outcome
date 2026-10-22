package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.PopupMenu;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class PopupMenuCompat {

    static class Api19Impl {
        private Api19Impl() {
        }

        static View.OnTouchListener getDragToOpenListener(PopupMenu r0) {
            return r0.getDragToOpenListener();
        }
    }

    private PopupMenuCompat() {
    }

    public static View.OnTouchListener getDragToOpenListener(Object r2) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return null;
    L5:
        return Api19Impl.getDragToOpenListener((PopupMenu) ZeusTransformUtils.preCheckCast(r2, PopupMenu.class, "com.obric.memorydata.plugin"));
    }
}
