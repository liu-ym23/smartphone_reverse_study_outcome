package com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter;

import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ FrequentChatListAdapter a;
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c b;

    public b(FrequentChatListAdapter r1, com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if ((r3 instanceof TextView) == true) goto L5;
        r3 = null;
    L5:
        TextView r4 = (TextView) r3;
        if (r4 == null) goto L12;
        CharSequence r5 = r4.getText();
        if (r5 == null) goto L13;
        this.a.b.k(r5, this.b);
        return;
    L13:
        return;
    }
}
