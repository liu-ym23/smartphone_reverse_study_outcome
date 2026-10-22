package pla;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g extends TouchDelegate {
    public final List<TouchDelegate> a;

    public g(View r3) {
        Rect r0 = new Rect();
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r0, "emptyRect");
        super(r0, r3);
        this.a = new ArrayList();
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        float r0 = r7.getX();
        float r1 = r7.getY();
        Iterator<T> r2 = this.a.iterator();
    L3:
        boolean r4 = false;
    L5:
        if (r2.hasNext() == false) goto L10;
        TouchDelegate r5 = (TouchDelegate) r2.next();
        r7.setLocation(r0, r1);
        if (r5.onTouchEvent(r7) == true) goto L9;
        if (r4 == false) goto L3;
    L9:
        r4 = true;
        goto L5
    L10:
        return r4;
    }
}
