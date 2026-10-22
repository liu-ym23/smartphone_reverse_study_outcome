package com.larksuite.component.card.component.text;

import android.view.View;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.context.ICardDependency;
import com.larksuite.component.universe_design.toast.UDToast;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class p implements mcc.k {
    public final /* synthetic */ UniversalCardTextLynxUI a;

    public p(UniversalCardTextLynxUI r1) {
        this.a = r1;
    }

    public final void l(View r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if (r4 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        UDToast.show(r3.getContext(), 2131890317);
        return;
    L12:
        UniversalCardTextLynxUI r1 = this.a;
        int r2 = UniversalCardTextLynxUI.g;
        com.larksuite.component.card.cardcontainer.c r5 = r1.O();
        if (r5 == null) goto L20;
        CardContext r6 = r5.c;
        if (r6 == null) goto L21;
        ICardDependency r7 = r6.getDependency();
        if (r7 == null) goto L22;
        r7.openProfilePage(r3.getContext(), r4, "");
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L5:
        if (r4.length() == 0) goto L8;
        r0 = false;
        goto L9
    }
}
