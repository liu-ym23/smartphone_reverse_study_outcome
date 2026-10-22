package b90;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final int a(RecyclerView.LayoutManager r2) {
        if (r2 != null) goto L6;
        return 0;
    L6:
        if ((r2 instanceof StaggeredGridLayoutManager) == false) goto L11;
        int[] r3 = ((StaggeredGridLayoutManager) r2).findFirstCompletelyVisibleItemPositions(null);
        if (r3 != null) goto L18;
        return 0;
    L18:
        return r3[0];
    L11:
        if ((r2 instanceof GridLayoutManager) == false) goto L14;
        return ((GridLayoutManager) r2).findFirstCompletelyVisibleItemPosition();
    L14:
        if ((r2 instanceof LinearLayoutManager) == true) goto L16;
        return 0;
    L16:
        return ((LinearLayoutManager) r2).findFirstCompletelyVisibleItemPosition();
    }

    @JvmStatic
    public static final int b(RecyclerView.LayoutManager r2) {
        if (r2 != null) goto L6;
        return 0;
    L6:
        if ((r2 instanceof StaggeredGridLayoutManager) == false) goto L11;
        int[] r3 = ((StaggeredGridLayoutManager) r2).findFirstVisibleItemPositions(null);
        if (r3 != null) goto L18;
        return 0;
    L18:
        return r3[0];
    L11:
        if ((r2 instanceof GridLayoutManager) == false) goto L14;
        return ((GridLayoutManager) r2).findFirstVisibleItemPosition();
    L14:
        if ((r2 instanceof LinearLayoutManager) == true) goto L16;
        return 0;
    L16:
        return ((LinearLayoutManager) r2).findFirstVisibleItemPosition();
    }

    @JvmStatic
    public static final void c(RecyclerView.LayoutManager r1, int r2, int r3) {
        if (r1 != null) goto L5;
        return;
    L5:
        if ((r1 instanceof StaggeredGridLayoutManager) == false) goto L8;
        ((StaggeredGridLayoutManager) r1).scrollToPositionWithOffset(r2, r3);
        return;
    L8:
        if ((r1 instanceof GridLayoutManager) == false) goto L11;
        ((GridLayoutManager) r1).scrollToPositionWithOffset(r2, r3);
        return;
    L11:
        if ((r1 instanceof LinearLayoutManager) == false) goto L16;
        ((LinearLayoutManager) r1).scrollToPositionWithOffset(r2, r3);
        return;
    }
}
