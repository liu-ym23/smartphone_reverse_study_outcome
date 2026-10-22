package com.ss.android.lark.flow.feed.cell.chat.chatdismiss;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ FlowChatDismissBottomSheet a;

    public a(FlowChatDismissBottomSheet r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.a("click_mask");
    }
}
