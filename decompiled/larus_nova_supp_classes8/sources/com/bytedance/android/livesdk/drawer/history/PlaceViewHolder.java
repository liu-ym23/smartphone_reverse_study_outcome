package com.bytedance.android.livesdk.drawer.history;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/history/PlaceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlaceViewHolder extends RecyclerView.ViewHolder {
    public final TextView a;

    public PlaceViewHolder(View r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "itemView");
        super(r3);
        if (r4 == false) goto L9;
        ConstraintLayout.LayoutParams r5 = ((TextView) r3.findViewById(2131382392)).getLayoutParams();
        if (r5 == null) goto L8;
        int r1 = s1.f(0.0f);
        ((ViewGroup.MarginLayoutParams) r5).leftMargin = r1;
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L9:
        this.a = (TextView) r3.findViewById(2131382392);
    }
}
