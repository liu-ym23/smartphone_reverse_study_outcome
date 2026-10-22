package s28;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public a() {
    }

    public static void a(Rect r3, View r4) {
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
        r3.set(r6.leftMargin, r6.topMargin, r6.rightMargin, r6.bottomMargin);
        return;
    L5:
        r3.set(0, 0, 0, 0);
    }
}
