package ia2;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements View.OnTouchListener {
    public final /* synthetic */ GestureDetector a;

    public d(GestureDetector r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r1, MotionEvent r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        return this.a.onTouchEvent(r2);
    }
}
