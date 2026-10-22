package wp9;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i {
    public static final Pair<Rect, Rect> b(View r7) {
        if (ViewCompat.isAttachedToWindow(r7) == false) goto L7;
        Rect r0 = new Rect();
        r7.getGlobalVisibleRect(r0);
        int[] r1 = new int[2];
        r7.getLocationOnScreen(r1);
        int r2 = r1[0];
        int r3 = r1[1];
        Rect r4 = new Rect(r2, r3, (int) (r2 + (r7.getWidth() * r7.getScaleX())), (int) (r3 + (r7.getHeight() * r7.getScaleY())));
        int r8 = f.a;
        f.a = r0.width();
        f.b = r0.height();
        return TuplesKt.to(r0, r4);
    L7:
        return TuplesKt.to(null, null);
    }

    public static final void c(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 == true) goto L5;
    L7:
        if (r2 == false) goto L9;
        return;
    L9:
        if (r1.getVisibility() == 8) goto L14;
        r1.setVisibility(8);
        return;
    L14:
        return;
    L5:
        if (r1.getVisibility() == 0) goto L7;
        r1.setVisibility(0);
    }

    public static final String a(Context r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        if (Intrinsics.areEqual(r2, "ai_space_list") == false) goto L5;
        int r4 = 2131905302;
    L6:
        String r5 = r1.getString(r4);
        if (r3 > 1) goto L9;
        return r5;
    L9:
        return r5 + '(' + r3 + ')';
    L5:
        r4 = 2131899719;
        goto L6
    }
}
