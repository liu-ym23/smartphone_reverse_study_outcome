package com.ss.android.lark.chatbase.view.post;

import android.view.View;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends OnSingleClickListener {
    public final /* synthetic */ PostChatView a;

    public a(PostChatView r1) {
        this.a = r1;
    }

    public final void onSingleClick(View r1) {
        PostChatView.a r2 = this.a.m;
        if (r2 == null) goto L6;
        r2.onClick();
        return;
    }
}
