package com.ss.android.lark.flow.chat.message.block.sharegroup;

import android.view.View;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ Chat a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ View.OnClickListener c;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        e.a(this.a, this.b, false, null);
        View.OnClickListener r0 = this.c;
        if (r0 == null) goto L6;
        r0.onClick(r5);
        return;
    }

    public c(Chat r1, Message r2, FlowShareGroupContentBlock.c r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
