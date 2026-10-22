package x81;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.room.incentiveinfo.IncentiveInfoLayout;
import com.bytedance.android.live.room.view.InterceptFrameLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import u81.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final IncentiveInfoLayout.LayoutParams a(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$incentiveLp");
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof IncentiveInfoLayout.LayoutParams) == true) goto L6;
        r2 = null;
    L6:
        return (IncentiveInfoLayout.LayoutParams) r2;
    }

    public static final InterceptFrameLayout b(View r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$interceptFrameLayout");
        if ((r1 instanceof InterceptFrameLayout) == true) goto L6;
        r1 = null;
    L6:
        return (InterceptFrameLayout) r1;
    }

    public static final w81.a c(d r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$itemData");
        IncentiveInfoLayout.LayoutParams r3 = a(r2.a());
        Object r0 = null;
        if (r3 == null) goto L5;
        Object r4 = r3.b;
    L7:
        if ((r4 instanceof w81.a) == false) goto L11;
        r0 = r4;
    L11:
        return (w81.a) r0;
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
}
