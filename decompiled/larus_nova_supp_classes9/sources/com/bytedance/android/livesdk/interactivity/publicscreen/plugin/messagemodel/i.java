package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.messagemodel;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.message.m1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ PSInteractivityShareMessageViewHolder a;
    public final /* synthetic */ m1 b;

    public i(PSInteractivityShareMessageViewHolder r1, m1 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        PSInteractivityShareMessageViewHolder r4 = this.a;
        r4.o.invoke(this.b, ((RecyclerView.ViewHolder) r4).itemView.getContext());
    }
}
