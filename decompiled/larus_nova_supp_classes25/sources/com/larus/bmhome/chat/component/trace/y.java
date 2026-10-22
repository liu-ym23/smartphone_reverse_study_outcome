package com.larus.bmhome.chat.component.trace;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.api.WidgetRenderDelegate;
import com.larus.ui.arch.component.internal.attach.a;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class y implements com.larus.bmhome.chat.component.cvs.y.a<e> {
    public final /* synthetic */ ChatTraceComponent a;

    public y(ChatTraceComponent r1) {
        this.a = r1;
    }

    public final void c(Object r4) {
        e r5 = (e) r4;
        Intrinsics.checkNotNullParameter(r5, "new");
        ChatTraceComponent r0 = this.a;
        int r1 = ChatTraceComponent.L;
        r0.getClass();
        WidgetRenderDelegate r2 = WidgetRenderDelegate.a;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Fragment r3 = a.b(r0, r0);
        String r6 = r5.a;
        String r7 = r5.B;
        if (r7 != null) goto L5;
        r7 = "";
    L5:
        r2.p(r3, r6, r7);
    }
}
