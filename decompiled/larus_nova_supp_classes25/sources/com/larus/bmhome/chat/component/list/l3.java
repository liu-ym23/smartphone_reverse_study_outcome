package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.component.bottom.floating.BottomFloatingButtonAction;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import s1a.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class l3 implements Runnable {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ l3(ChatListComponent r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatListComponent r0 = this.a;
        int r1 = ChatListComponent.W3;
        if (a.c(r0).isDetached() == true) goto L37;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(r0, r0).isRemoving() == true) goto L42;
        boolean r2 = r0.IS();
        if (r2 == true) goto L11;
    L12:
        boolean r3 = false;
    L14:
        if (r3 == false) goto L16;
        r2 = false;
    L16:
        FLogger r4 = FLogger.a;
        String r5 = r0.n;
        StringBuilder r6 = new StringBuilder("updateFastButton hashcode=");
        LarusPageChatBinding r7 = r0.h4();
        if (r7 == null) goto L19;
        ChatMessageList r8 = r7.n;
    L20:
        if (r8 == null) goto L22;
        int r9 = r8.hashCode();
    L23:
        r6.append(r9);
        r6.append(" fastButtonLastShow=");
        r6.append(r0.v);
        r6.append(" finalShow=");
        r6.append(r2);
        r4.d(r5, r6.toString());
        if (r0.v == false) goto L29;
        ld8.n r10 = r0.d5();
        if (r10 == null) goto L28;
        r10.Dm(r2);
    L28:
        r0.v = false;
        return;
    L29:
        if (r2 == false) goto L33;
        ld8.n r11 = r0.d5();
        if (r11 == null) goto L39;
        r11.Ib(BottomFloatingButtonAction.SCROLL_UP, false);
        return;
    L39:
        return;
    L33:
        ld8.n r12 = r0.d5();
        if (r12 == null) goto L41;
        r12.m60(BottomFloatingButtonAction.SCROLL_DOWN);
        return;
    L41:
        return;
    L22:
        r9 = 0;
        goto L23
    L19:
        r8 = null;
        goto L20
    L11:
        if (r0.X6() == false) goto L12;
        r0.w7("fast_button_update");
        r3 = true;
        goto L14
    L42:
        return;
    }
}
