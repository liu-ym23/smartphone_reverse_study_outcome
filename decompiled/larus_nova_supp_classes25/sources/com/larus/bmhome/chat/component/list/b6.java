package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.cell.view.AbstractMessageBoxContainerView;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.view.ChatMessageList;
import dh8.b;
import kotlin.jvm.internal.Intrinsics;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b6 implements com.larus.bmhome.chat.component.cvs.y.a<wc9.e> {
    public final /* synthetic */ ChatListComponent a;

    public b6(ChatListComponent r1) {
        this.a = r1;
    }

    public final void c(Object r6) {
        wc9.e r7 = (wc9.e) r6;
        Intrinsics.checkNotNullParameter(r7, "new");
        if (a.c(this.a).isResumed() == false) goto L20;
        b r0 = b.a;
        StringBuilder r2 = new StringBuilder();
        r2.append(r7.a);
        r2.append(':');
        String r8 = r7.B;
        if (r8 != null) goto L7;
        r8 = "";
    L7:
        r2.append(r8);
        String r9 = r2.toString();
        r0.getClass();
        b.a(r9);
        ChatListComponent r10 = this.a;
        int r1 = ChatListComponent.W3;
        LarusPageChatBinding r11 = r10.h4();
        if (r11 == null) goto L20;
        ChatMessageList r12 = r11.n;
        if (r12 == null) goto L20;
        int r3 = r12.getChildCount();
        int r4 = 0;
    L12:
        if (r4 >= r3) goto L20;
        AbstractMessageBoxContainerView r5 = r12.getChildAt(r4);
        if ((r5 instanceof AbstractMessageBoxContainerView) == false) goto L16;
        AbstractMessageBoxContainerView r13 = r5;
    L17:
        if (r13 == null) goto L19;
        r13.requestLayout();
    L19:
        r4 = r4 + 1;
        goto L12
    L16:
        r13 = null;
    L20:
        ChatListComponent r14 = this.a;
        if (r14.H1 == false) goto L23;
        r14.H1 = false;
        return;
    L23:
        r14.C90();
    }
}
