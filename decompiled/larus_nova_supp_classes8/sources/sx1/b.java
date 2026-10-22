package sx1;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements View.OnTouchListener {
    public final /* synthetic */ c a;

    public b(c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r2, MotionEvent r3) {
        int r4 = r3.getAction();
        if (r4 != 0) goto L5;
        c r5 = this.a;
        r5.c.setTextColor(r5.getContext().getResources().getColor(2131106797));
        return false;
    L5:
        if (r4 != 1) goto L7;
    L9:
        c r6 = this.a;
        r6.c.setTextColor(r6.getContext().getResources().getColor(2131106796));
        return false;
    L7:
        if (r4 == 3) goto L9;
        return false;
    }
}
