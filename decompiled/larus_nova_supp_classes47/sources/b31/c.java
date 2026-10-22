package b31;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.revlink.impl.multianchor.constants.GravityDef;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final int a(GravityDef r1) {
        Intrinsics.checkNotNullParameter(r1, "gravityDef");
        switch(b.a[r1.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        return 0;
    L7:
        return 51;
    L8:
        return 5;
    L9:
        return 3;
    L10:
        return 1;
    L11:
        return 80;
    L12:
        return 48;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public static final void b(View r3, a r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "layoutData");
        ViewGroup.LayoutParams r1 = r3.getLayoutParams();
        if ((r1 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r1 = null;
    L5:
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r1;
        if (r2 != null) goto L8;
        return;
    L8:
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r4, "layoutData");
        if (r2.width == r4.a) goto L11;
    L21:
        boolean r0 = false;
    L22:
        if (r0 == false) goto L24;
        return;
    L24:
        r2.width = r4.a;
        r2.height = r4.b;
        r2.leftMargin = r4.d;
        r2.rightMargin = r4.e;
        r2.topMargin = r4.c;
        r2.gravity = a(r4.f);
        r3.setLayoutParams(r2);
        return;
    L11:
        if (r2.height != r4.b) goto L21;
        if (r2.leftMargin != r4.d) goto L21;
        if (r2.rightMargin != r4.e) goto L21;
        if (r2.topMargin != r4.c) goto L21;
        if (r2.gravity != a(r4.f)) goto L21;
        r0 = true;
        goto L22
    }
}
