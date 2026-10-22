package com.larus.bmhome.view;

import android.view.ViewTreeObserver;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ChatMessageList$f implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ ChatMessageList$ChatLayoutManager a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ChatMessageList c;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (this.a.findViewByPosition(this.b) != null) goto L6;
        FLogger.a.i("ChatMessageList", "scrollToPendingUnreadTargetTop preDraw target missing pos=" + this.b);
        return true;
    L6:
        this.c.getViewTreeObserver().removeOnPreDrawListener(this);
        ChatMessageList.t(this.c, this.a, this.b, "preDraw");
        final ChatMessageList r0 = this.c;
        final ChatMessageList$ChatLayoutManager r1 = this.a;
        final int r2 = this.b;
        r0.post(new b1(r0, r1, r2));
        return false;
    }

    public ChatMessageList$f(ChatMessageList$ChatLayoutManager r1, int r2, ChatMessageList r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
