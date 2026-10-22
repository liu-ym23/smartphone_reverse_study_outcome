package com.bytedance.android.live.room.navi.userinfo_p.flipper.core;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final BaseTabFlipper.LayoutParams a(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$flipperLp");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof BaseTabFlipper.LayoutParams) == true) goto L6;
        r2 = null;
    L6:
        return (BaseTabFlipper.LayoutParams) r2;
    }

    public static final w91.e b(View r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$flipperTabData");
        BaseTabFlipper.LayoutParams r3 = a(r2);
        Object r0 = null;
        if (r3 == null) goto L5;
        Object r4 = r3.b;
    L7:
        if ((r4 instanceof w91.e) == false) goto L11;
        r0 = r4;
    L11:
        return (w91.e) r0;
    L5:
        r4 = null;
        goto L7
    }

    public static final w91.e c(w91.f r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$flipperTabData");
        BaseTabFlipper.LayoutParams r3 = a(r2.a());
        Object r0 = null;
        if (r3 == null) goto L5;
        Object r4 = r3.b;
    L7:
        if ((r4 instanceof w91.e) == false) goto L11;
        r0 = r4;
    L11:
        return (w91.e) r0;
    L5:
        r4 = null;
        goto L7
    }

    public static final <T> T d(List<? extends T> r2, int r3) {
        if (r2 == null) goto L9;
        if (r3 >= 0) goto L6;
        return null;
    L6:
        if (r3 < r2.size()) goto L8;
        return null;
    L8:
        return (T) ListProtector.get(r2, r3);
    L9:
        return null;
    }

    public static final void e(w91.f r1, CharSequence r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$setText");
        View r3 = r1.a().findViewById(2131390378);
        if ((r3 instanceof TextView) == true) goto L5;
        r3 = null;
    L5:
        TextView r4 = (TextView) r3;
        if (r4 == null) goto L9;
        r4.setText(r2);
        return;
    }
}
