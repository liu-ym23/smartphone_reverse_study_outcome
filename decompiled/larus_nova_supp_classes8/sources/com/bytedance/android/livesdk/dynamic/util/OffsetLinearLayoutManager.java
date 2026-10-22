package com.bytedance.android.livesdk.dynamic.util;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/dynamic/util/OffsetLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OffsetLinearLayoutManager extends LinearLayoutManager {
    public final HashMap<Integer, Integer> a;

    public OffsetLinearLayoutManager(FragmentActivity r1) {
        super(r1);
        this.a = new HashMap();
    }

    public final int computeVerticalScrollOffset(RecyclerView.State r7) {
        Intrinsics.checkNotNullParameter(r7, "state");
        int r0 = 0;
        if (getChildCount() != 0) goto L16;
        return 0;
    L16:
        int r8 = findFirstVisibleItemPosition();     // Catch: Exception -> L15
        View r1 = findViewByPosition(r8);     // Catch: Exception -> L15
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r2 >= r8) goto L11;
        Integer r4 = this.a.get(Integer.valueOf(r2));     // Catch: Exception -> L15
        if (r4 != null) goto L10;
        r4 = 0;     // Catch: Exception -> L15
    L10:
        r3 = r3 + r4.intValue();     // Catch: Exception -> L15
        r2 = r2 + 1;     // Catch: Exception -> L15
        goto L6
    L11:
        if (r1 == null) goto L14;
        r0 = r1.getTop();     // Catch: Exception -> L15
    L14:
        return r3 - r0;
    L21:
        return 0;
    }

    public final void onLayoutCompleted(RecyclerView.State r5) {
        super.onLayoutCompleted(r5);
        int r6 = findFirstVisibleItemPosition();
        int r0 = findLastVisibleItemPosition();
        if (r6 < 0) goto L11;
        if (r0 < 0) goto L15;
        if (r0 < r6) goto L16;
    L6:
        if (r6 >= r0) goto L17;
        View r1 = getChildAt(r6);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r6), Integer.valueOf(r1.getHeight()));
    L10:
        r6 = r6 + 1;
        goto L6
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }
}
