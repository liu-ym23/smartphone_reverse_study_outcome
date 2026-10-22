package com.bytedance.android.live.liveinteract.linkpanel.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class ListSpaceItemBinder extends me.drakeet.multitype.b<p, ViewHolder> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/list/ListSpaceItemBinder$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }
    }

    public ListSpaceItemBinder() {
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        ViewHolder r4 = (ViewHolder) r2;
        p r5 = (p) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "data");
        ViewGroup.LayoutParams r0 = ((RecyclerView.ViewHolder) r4).itemView.getLayoutParams();
        if (r0 == null) goto L6;
        r0.height = r5.a;
        ((RecyclerView.ViewHolder) r4).itemView.setLayoutParams(r0);
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new ViewHolder(r4.inflate(2131566221, r5, false));
    }
}
