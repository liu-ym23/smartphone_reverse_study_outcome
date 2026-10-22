package com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ FrequentChatListAdapter a;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c b;

    public d(FrequentChatListAdapter r1, com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.b.u(this.b);
    }
}
