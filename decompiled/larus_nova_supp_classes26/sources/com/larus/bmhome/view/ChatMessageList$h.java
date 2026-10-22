package com.larus.bmhome.view;

import android.view.View;
import android.view.ViewTreeObserver;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ChatMessageList$h implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ ChatMessageList$ChatLayoutManager a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ChatMessageList c;
    public final /* synthetic */ int d;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        View r0 = this.a.findViewByPosition(this.b);
        if (r0 == null) goto L9;
        int r2 = this.d;
        int r3 = this.b;
        ChatMessageList$ChatLayoutManager r4 = this.a;
        int r5 = r2 - r0.getHeight();
        if (r3 != 0) goto L7;
        int r1 = i5.h();
    L8:
        r4.scrollToPositionWithOffset(r3, r5 - r1);
        goto L9
    L7:
        r1 = 0;
    L9:
        this.c.getViewTreeObserver().removeOnPreDrawListener(this);
        return false;
    }

    public ChatMessageList$h(ChatMessageList$ChatLayoutManager r1, int r2, ChatMessageList r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
