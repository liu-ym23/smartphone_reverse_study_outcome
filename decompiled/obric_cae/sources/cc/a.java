package cc;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements View.OnTouchListener {
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r8, MotionEvent r10) {
        int r11 = r10.getAction();
        if (r11 != 0) goto L5;
        float r12 = 0.5f;
    L11:
        r8.setAlpha(r12);
        return false;
    L5:
        if (r11 != 1) goto L7;
    L9:
        r12 = 1.0f;
        goto L11
    L7:
        if (r11 == 3) goto L9;
        return false;
    }
}
