package sy8;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final View a(ViewStub r2, int r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r4, "inflatedView");
        r4.setId(r3);
        ViewParent r5 = r2.getParent();
        if ((r5 instanceof ViewGroup) == false) goto L5;
        ViewGroup r6 = (ViewGroup) r5;
    L6:
        if (r6 != null) goto L8;
        return null;
    L8:
        int r0 = r6.indexOfChild(r2);
        r6.removeViewInLayout(r2);
        ViewGroup.LayoutParams r7 = r2.getLayoutParams();
        if (r7 == null) goto L11;
        r6.addView(r4, r0, r7);
    L12:
        return r4;
    L11:
        r6.addView(r4, r0);
        goto L12
    L5:
        r6 = null;
        goto L6
    }
}
