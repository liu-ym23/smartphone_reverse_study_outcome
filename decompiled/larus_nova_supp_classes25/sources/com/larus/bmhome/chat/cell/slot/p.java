package com.larus.bmhome.chat.cell.slot;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.larus.bmhome.chat.layout.widget.ChatRetryWithText;
import com.larus.im.bean.message.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ com.larus.bmhome.chat.layout.item.i a;
    public final /* synthetic */ ChatRetryWithText b;
    public final /* synthetic */ ViewGroup c;
    public final /* synthetic */ MessageInBoxBottomRetrySlotCell d;
    public final /* synthetic */ Message e;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this.a.getWidth() < this.a.getMaxWidth()) goto L5;
        ChatRetryWithText r0 = this.b;
        final MessageInBoxBottomRetrySlotCell r1 = this.d;
        final Message r2 = this.e;
        r0.c(new o(r1, r2));
    L6:
        this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        return;
    L5:
        this.b.a();
        goto L6
    }

    public p(com.larus.bmhome.chat.layout.item.i r1, ChatRetryWithText r2, ViewGroup r3, MessageInBoxBottomRetrySlotCell r4, Message r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
