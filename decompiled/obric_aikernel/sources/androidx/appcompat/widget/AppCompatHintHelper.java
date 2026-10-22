package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* JADX INFO: loaded from: classes.dex */
class AppCompatHintHelper {
    private AppCompatHintHelper() {
    }

    static InputConnection onCreateInputConnection(InputConnection r10, EditorInfo r11, View r12) {
        if (r10 != null) goto L4;
    L12:
        return r10;
    L4:
        if (r11.hintText != null) goto L12;
        ViewParent r13 = r12.getParent();
    L7:
        if ((r13 instanceof View) == false) goto L12;
        if ((r13 instanceof WithHint) == true) goto L10;
        r13 = r13.getParent();
        goto L7
    L10:
        r11.hintText = ((WithHint) r13).getHint();
        goto L12
    }
}
