package com.larus.bmhome.chat.component.title;

import android.view.View;
import com.larus.bmhome.chat.g4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class i0 implements View.OnClickListener {
    public final /* synthetic */ ChatTitleComponent a;

    public /* synthetic */ i0(ChatTitleComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        ChatTitleComponent r0 = this.a;
        int r1 = ChatTitleComponent.P1;
        g4 r2 = r0.e4();
        if (r2 == null) goto L6;
        Intrinsics.checkNotNull(r3);
        r2.j(r3);
        return;
    }
}
