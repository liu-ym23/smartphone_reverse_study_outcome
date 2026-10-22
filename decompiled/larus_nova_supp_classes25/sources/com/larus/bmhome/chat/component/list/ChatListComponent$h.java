package com.larus.bmhome.chat.component.list;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatListComponent$h implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ ChatListComponent a;
    public final /* synthetic */ String b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        if (r0.X6() == true) goto L6;
        this.a.l7();
        return true;
    L6:
        ChatListComponent r2 = this.a;
        String r3 = this.b;
        ChatMessageList r4 = r2.o5();
        boolean r5 = false;
        if (r4 != null) goto L10;
    L29:
        if (r5 == true) goto L35;
        final ChatListComponent r6 = this.a;
        final ChatMessageList r7 = r6.o5();
        if (r7 == null) goto L35;
        r7.postOnAnimation(new g(r6, r7));
    L35:
        return !r5;
    L10:
        if (r2.X6() == false) goto L29;
        LinearLayoutManager r8 = r4.getLayoutManager();
        if ((r8 instanceof LinearLayoutManager) == false) goto L15;
        LinearLayoutManager r9 = r8;
    L16:
        if (r9 != null) goto L18;
        int r10 = r4.B();
    L23:
        if (r10 <= 0) goto L29;
        r2.B++;
        FLogger.a.i(r2.n, "correct pending scroll to bottom before draw, source=" + r3 + " count=" + r2.B + " distance=" + r10);
        r4.scrollBy(0, r10);
        if (r2.B < 3) goto L28;
        r2.a4();
    L28:
        r5 = true;
        goto L29
    L18:
        View r11 = r9.findViewByPosition(0);
        if (r11 == null) goto L21;
        int r12 = r9.getDecoratedBottom(r11) - (r4.getHeight() - r4.getPaddingBottom());
    L22:
        r10 = Math.max(r12, Math.max(r4.B(), 0));
        goto L23
    L21:
        r12 = 0;
        goto L22
    L15:
        r9 = null;
        goto L16
    }

    public ChatListComponent$h(ChatListComponent r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
