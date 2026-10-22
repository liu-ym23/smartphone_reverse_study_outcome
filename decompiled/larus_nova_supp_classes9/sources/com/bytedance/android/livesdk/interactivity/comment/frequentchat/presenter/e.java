package com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.FrequentChatViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements View.OnLongClickListener {
    public final /* synthetic */ FrequentChatListAdapter a;
    public final /* synthetic */ FrequentChatViewHolder b;

    public e(FrequentChatListAdapter r1, FrequentChatViewHolder r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r3) {
        if (this.a.getItemCount() > 1) goto L6;
        return false;
    L6:
        this.a.b.O(this.b);
        return true;
    }
}
