package com.bytedance.android.livesdk.interactivity.comment.frequentchat.model;

import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/frequentchat/model/FrequentChatViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FrequentChatViewHolder extends RecyclerView.ViewHolder {
    public final TextView a;
    public final CardView b;
    public final TextView c;
    public final TextView d;
    public final View e;

    public FrequentChatViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.a = (TextView) r2.findViewById(2131367467);
        this.b = r2.findViewById(2131367382);
        this.c = (TextView) r2.findViewById(2131371391);
        this.d = (TextView) r2.findViewById(2131384270);
        this.e = r2.findViewById(2131386986);
    }
}
