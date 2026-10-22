package com.larus.bmhome.chat.component.cvs;

import androidx.lifecycle.Observer;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class j implements Observer {
    public final /* synthetic */ ChatConversationComponent a;

    public /* synthetic */ j(ChatConversationComponent r1) {
        this.a = r1;
    }

    public final void onChanged(Object r11) {
        ChatConversationComponent r0 = this.a;
        e r12 = (e) r11;
        int r1 = ChatConversationComponent.r;
        String r2 = r0.Y1();
        if (r12 == null) goto L5;
        String r13 = r12.a;
    L6:
        if (r13 != null) goto L8;
        r13 = "";
    L8:
        String r3 = r13;
        boolean r14 = r0.F2().getState().getConversationIsNull();
        e0 r4 = (e0) AuthModelDelegate.b.e().getValue();
        boolean r5 = true;
        if (r4 != null) goto L11;
    L13:
        boolean r6 = false;
    L14:
        FLogger.a.i("ChatConversationComponent", "mainBotConversationInfo change " + r3 + ", " + r2 + ", launchSucceeded=" + r6 + ", currentConversationUnavailable=" + r14);
        if (r6 == false) goto L20;
        if (r14 == false) goto L20;
        if (Intrinsics.areEqual(r3, r2) == false) goto L20;
        boolean r15 = true;
    L22:
        if (r2.length() <= 0) goto L24;
        boolean r7 = true;
    L25:
        if (r7 == true) goto L27;
        return;
    L27:
        if (r3.length() > 0) goto L30;
        r5 = false;
    L30:
        if (r5 == true) goto L32;
        return;
    L32:
        if (Intrinsics.areEqual(r3, r2) == false) goto L34;
        if (r15 == true) goto L34;
        return;
    L34:
        ChatConversationVM.handleConversationIdInit$default(r0.F2(), r3, null, null, false, null, 30, null);
        return;
    L24:
        r7 = false;
    L20:
        r15 = false;
        goto L22
    L11:
        if (r4.b != 2) goto L13;
        r6 = true;
        goto L14
    L5:
        r13 = null;
        goto L6
    }
}
