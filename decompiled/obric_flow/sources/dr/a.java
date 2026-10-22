package dr;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends TouchDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f16703a;

    public a(View r5) {
        Rect r10 = new Rect();
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r10, "emptyRect");
        super(r10, r5);
        this.f16703a = new ArrayList();
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        float r5 = r10.getX();
        float r11 = r10.getY();
        Iterator r12 = this.f16703a.iterator();
    L3:
        boolean r13 = false;
    L5:
        if (r12.hasNext() == false) goto L10;
        TouchDelegate r14 = (TouchDelegate) r12.next();
        r10.setLocation(r5, r11);
        if (r14.onTouchEvent(r10) == true) goto L9;
        if (r13 == false) goto L3;
    L9:
        r13 = true;
        goto L5
    L10:
        return r13;
    }
}
