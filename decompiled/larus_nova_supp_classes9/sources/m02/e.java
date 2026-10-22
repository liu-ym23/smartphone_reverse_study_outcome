package m02;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public static final int a(LinearLayoutManager r3, RecyclerView r4, int r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "$this$findFirstVisibleItem");
        Intrinsics.checkNotNullParameter(r4, "rvPercentage");
        return b(r3, r4, r5, new IntRange(r3.findFirstVisibleItemPosition(), r3.findLastVisibleItemPosition()), r6);
    }

    public static final int c(LinearLayoutManager r2, RecyclerView r3, int r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "$this$findLastVisibleItem");
        Intrinsics.checkNotNullParameter(r3, "rvPercentage");
        int r0 = r2.findFirstVisibleItemPosition();
        return b(r2, r3, r4, RangesKt.downTo(r2.findLastVisibleItemPosition(), r0), r5);
    }

    public static final int b(LinearLayoutManager r6, RecyclerView r7, int r8, IntProgression r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r6, "layoutManager");
        Intrinsics.checkNotNullParameter(r7, "rvPercentage");
        Intrinsics.checkNotNullParameter(r9, "range");
        Rect r0 = new Rect();
        r7.getGlobalVisibleRect(r0);
        Iterator r11 = r9.iterator();
    L4:
        if (r11.hasNext() == false) goto L21;
        int r13 = ((Number) r11.next()).intValue();
        Rect r1 = new Rect();
        View r2 = r6.findViewByPosition(r13);
        if (r2 == null) goto L4;
        r2.getGlobalVisibleRect(r1);
        int r3 = 100;
        if (r10 == false) goto L12;
        if (r1.height() < ((r2.getHeight() * r8) / 100)) goto L4;
    L12:
        int r4 = r1.bottom;
        int r5 = r0.bottom;
        if (r4 < r5) goto L15;
        int r14 = ((r5 - r1.top) * 100) / r2.getHeight();
    L16:
        if (r14 > 100) goto L19;
        r3 = r14;
    L19:
        if (r3 <= r8) goto L4;
        return r13;
    L15:
        r14 = ((r4 - r0.top) * 100) / r2.getHeight();
        goto L16
    L21:
        return -1;
    }
}
