package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v<T> implements Observer {
    public final /* synthetic */ AnchorLinkUserListFragment a;
    public final /* synthetic */ ArrayList b;

    public v(AnchorLinkUserListFragment r1, ArrayList r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.ViewGroup, androidx.recyclerview.widget.RecyclerView, com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerViewOpt, java.lang.Object] */
    public final void onChanged(Object r6) {
        int r7 = ((Number) r6).intValue();
        ?? r0 = this.a.g;
        if (r0 == 0) goto L13;
        Intrinsics.checkNotNull(r0);
        Integer r1 = r0.p;
        FrameLayout r2 = (FrameLayout) r0.findViewWithTag("RecyclerOptBar");
        if (r2 == null) goto L11;
        RecyclerView.LayoutManager r3 = r0.getLayoutManager();
        if (r3 != null) goto L9;
    L10:
        r0.scrollToPosition(r0.getChildAdapterPosition(r2));
        goto L13
    L9:
        if (r3.isViewPartiallyVisible(r2, true, false) == true) goto L13;
    L11:
        if (r1 == null) goto L13;
        r0.scrollToPosition(r1.intValue());
    L13:
        if (r7 >= 0) goto L15;
        return;
    L15:
        if (r7 >= this.b.size()) goto L19;
        AnchorLinkUserListFragment r4 = this.a;
        r4.L0 = (CharSequence) ListProtector.get(this.b, r7);
        return;
    }
}
