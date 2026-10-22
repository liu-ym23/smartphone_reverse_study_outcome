package com.larus.bmhome.chat.component.receive;

import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.view.ChatConstraintLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k0 implements com.larus.bmhome.chat.component.cvs.y.a<wc9.e> {
    public final /* synthetic */ ChatReceiveServiceComponent a;

    public k0(ChatReceiveServiceComponent r1) {
        this.a = r1;
    }

    public final void c(Object r3) {
        wc9.e r4 = (wc9.e) r3;
        Intrinsics.checkNotNullParameter(r4, "new");
        if (r4.a.length() != 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == true) goto L19;
        ChatReceiveServiceComponent r6 = this.a;
        int r0 = ChatReceiveServiceComponent.x;
        gd8.f r7 = r6.Y2();
        if (r7 == null) goto L16;
        LarusPageChatBinding r8 = r7.e();
        if (r8 == null) goto L17;
        ChatConstraintLayout r9 = r8.a;
        if (r9 == null) goto L18;
        final ChatReceiveServiceComponent r1 = this.a;
        r9.post(new j0(r1));
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L19:
        return;
    L5:
        r5 = false;
        goto L6
    }
}
