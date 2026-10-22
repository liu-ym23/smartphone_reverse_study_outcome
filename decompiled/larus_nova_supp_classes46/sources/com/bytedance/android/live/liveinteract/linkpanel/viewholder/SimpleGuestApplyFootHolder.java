package com.bytedance.android.live.liveinteract.linkpanel.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/viewholder/SimpleGuestApplyFootHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SimpleGuestApplyFootHolder extends RecyclerView.ViewHolder {
    public SimpleGuestApplyFootHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    public final void T3(int r2) {
        ViewGroup.LayoutParams r0 = ((RecyclerView.ViewHolder) this).itemView.getLayoutParams();
        if (r0 == null) goto L6;
        r0.height = r2;
        ((RecyclerView.ViewHolder) this).itemView.setLayoutParams(r0);
        return;
    }
}
