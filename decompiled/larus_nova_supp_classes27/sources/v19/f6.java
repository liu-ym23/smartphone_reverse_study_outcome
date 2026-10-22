package v19;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f6 {
    public static final f6 a = null;

    static {
        a = new f6();
    }

    public f6() {
    }

    public static int a(RecyclerView r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "recyclerView");
        GridLayoutManager r0 = r9.getLayoutManager();
        if ((r0 instanceof GridLayoutManager) == false) goto L9;
        View r1 = r0.findViewByPosition(r10);
        if (r1 != null) goto L7;
        FLogger.a.w("RecyclerViewDistanceHelper", "[calculateGridLayoutItemBottomDistance] Item view not found at position: " + r10);
    L19:
        return -1;
    L7:
        int r11 = r9.getHeight();
        int r2 = r1.getBottom();
        int r3 = r11 - r2;
        FLogger.a.i("RecyclerViewDistanceHelper", "[calculateGridLayoutItemBottomDistance] Position: " + r10 + ", RecyclerView height: " + r11 + ", Item bottom: " + r2 + ", Distance from bottom: " + r3);
        return r3;
    L9:
        if ((r0 instanceof LinearLayoutManager) == false) goto L14;
        View r4 = ((LinearLayoutManager) r0).findViewByPosition(r10);
        if (r4 != null) goto L13;
        FLogger.a.w("RecyclerViewDistanceHelper", "[calculateLinearLayoutItemBottomDistance] Item view not found at position: " + r10);
        goto L19
    L13:
        int r12 = r9.getHeight();
        int r5 = r4.getBottom();
        int r6 = r12 - r5;
        FLogger.a.i("RecyclerViewDistanceHelper", "[calculateLinearLayoutItemBottomDistance] Position: " + r10 + ", RecyclerView height: " + r12 + ", Item bottom: " + r5 + ", Distance from bottom: " + r6);
        return r6;
    L14:
        FLogger r13 = FLogger.a;
        StringBuilder r14 = new StringBuilder("[calculateItemBottomDistanceFromRecyclerViewBottom] Unsupported layout manager: ");
        if (r0 == null) goto L17;
        String r7 = r0.getClass().getSimpleName();
    L18:
        r14.append(r7);
        r13.w("RecyclerViewDistanceHelper", r14.toString());
        goto L19
    L17:
        r7 = null;
        goto L18
    }
}
