package lib;

import android.view.MotionEvent;
import android.view.View;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements View.OnTouchListener {
    public final /* synthetic */ KeyboardFunctionEditText a;

    public k(KeyboardFunctionEditText r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r5, MotionEvent r6) {
        if (this.a.canScrollVertically(1) == false) goto L5;
    L6:
        r5.getParent().requestDisallowInterceptTouchEvent(true);
        if (r6.getAction() != 1) goto L9;
        r5.getParent().requestDisallowInterceptTouchEvent(false);
    L9:
        return false;
    L5:
        if (this.a.canScrollVertically(-1) == false) goto L9;
        goto L6
    }
}
