package qla;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a implements View.OnTouchListener {
    public a() {
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r2, MotionEvent r3) {
        int r4 = r3.getAction();
        if (r4 != 0) goto L5;
        r2.setAlpha(0.5f);
        return false;
    L5:
        if (r4 != 1) goto L7;
    L9:
        r2.setAlpha(1.0f);
        return false;
    L7:
        if (r4 == 3) goto L9;
        return false;
    }
}
