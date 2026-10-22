package com.larus.bmhome.chat.component.showcase;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f implements View.OnClickListener {
    public final /* synthetic */ ChatCaseMessageComponent a;

    public /* synthetic */ f(ChatCaseMessageComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ChatCaseMessageComponent r3 = this.a;
        int r0 = ChatCaseMessageComponent.z;
        if (((Boolean) r3.x.getValue()).booleanValue() == false) goto L7;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        com.larus.bmhome.a0 r4 = com.larus.bmhome.b0.a(com.larus.ui.arch.component.internal.attach.a.b(r3, r3));
        if (r4 == null) goto L11;
        r4.cs();
        return;
    L11:
        return;
    L7:
        gd8.f r5 = (gd8.f) r3.t.getValue();
        if (r5 == null) goto L13;
        r5.N9("click_back_button");
        return;
    }
}
