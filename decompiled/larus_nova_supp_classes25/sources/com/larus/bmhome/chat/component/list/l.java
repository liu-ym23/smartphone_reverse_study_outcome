package com.larus.bmhome.chat.component.list;

import android.view.View;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.view.screenmenu.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import taa.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class l implements Function0 {
    public final /* synthetic */ ChatListComponent a;
    public final /* synthetic */ LarusPageChatBinding b;

    public /* synthetic */ l(ChatListComponent r1, LarusPageChatBinding r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        ChatListComponent r0 = this.a;
        LarusPageChatBinding r1 = this.b;
        int r2 = ChatListComponent.W3;
        r0.a4();
        if (com.larus.utils.o0.d(r0.f1().t()) == false) goto L5;
        r1.n.setMiddleLoad(false);
    L5:
        View r3 = r1.n.getFocusedChild();
        if (r3 == null) goto L8;
        r3.clearFocus();
    L8:
        d r4 = d.a;
        d.b(r1.n);
        ICoreInputAbility r5 = r0.T4();
        if (r5 == null) goto L11;
        r5.Ba();
    L11:
        a r6 = (a) r0.f3.getValue();
        if (r6 == null) goto L15;
        r6.Ba();
    L15:
        return Unit.INSTANCE;
    }
}
