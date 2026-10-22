package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* JADX INFO: loaded from: classes.dex */
class AppCompatHintHelper {
    private AppCompatHintHelper() {
    }

    public static InputConnection onCreateInputConnection(InputConnection r5, EditorInfo r10, View r11) {
        if (r5 != null) goto L4;
    L12:
        return r5;
    L4:
        if (r10.hintText != null) goto L12;
        ViewParent r12 = r11.getParent();
    L7:
        if ((r12 instanceof View) == false) goto L12;
        if ((r12 instanceof WithHint) == true) goto L10;
        r12 = r12.getParent();
        goto L7
    L10:
        r10.hintText = ((WithHint) r12).getHint();
        goto L12
    }
}
