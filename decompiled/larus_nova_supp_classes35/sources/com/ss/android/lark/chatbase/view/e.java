package com.ss.android.lark.chatbase.view;

import android.view.View;
import com.ss.android.lark.chat.core.view.TextChatView;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends OnSingleClickListener {
    public final /* synthetic */ TextChatView2 a;

    public e(TextChatView2 r1) {
        this.a = r1;
    }

    public final void onSingleClick(View r1) {
        TextChatView.a r2 = this.a.i;
        if (r2 == null) goto L6;
        r2.onClick();
        return;
    }
}
