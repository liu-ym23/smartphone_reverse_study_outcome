package com.larus.bmhome.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class y implements View.OnClickListener {
    public final /* synthetic */ ChatInputReply a;

    public /* synthetic */ y(ChatInputReply r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.b.invoke();
    }
}
