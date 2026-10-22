package kqb;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final void a(ListView r6) {
        Intrinsics.checkNotNullParameter(r6, "listView");
        ListAdapter r0 = r6.getAdapter();
        if (r0 != null) goto L5;
        return;
    L5:
        IntIterator r1 = RangesKt.until(0, r0.getCount()).iterator();
        int r3 = 0;
    L7:
        if (r1.hasNext() == false) goto L9;
        View r4 = r0.getView(r1.nextInt(), null, r6);
        r4.measure(0, 0);
        r3 = r3 + r4.getMeasuredHeight();
        goto L7
    L9:
        int r2 = r0.getCount();
        ViewGroup.LayoutParams r5 = r6.getLayoutParams();
        r5.height = r3 + (r6.getDividerHeight() * r2);
        r6.setLayoutParams(r5);
    }
}
