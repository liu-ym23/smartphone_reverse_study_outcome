package com.larus.bmhome.chat.component.showcase;

import android.widget.Button;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.platform.model.showcase.Case;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class t implements Function1 {
    public final /* synthetic */ ChatPlaybackComponent a;

    public /* synthetic */ t(ChatPlaybackComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        ChatPlaybackComponent r0 = this.a;
        int r1 = ChatPlaybackComponent.x;
        Intrinsics.checkNotNullParameter((Button) r4, "it");
        r0.n.setValue(Boolean.FALSE);
        u7 r5 = (u7) r0.t.getValue();
        if (r5 == null) goto L5;
        r5.a90();
    L5:
        x r6 = (x) r0.r.getValue();
        String r2 = null;
        if (r6 == null) goto L10;
        Case r7 = r6.mz(false);
        if (r7 == null) goto L10;
        String r8 = r7.getCaseId();
    L11:
        x r3 = (x) r0.r.getValue();
        if (r3 == null) goto L16;
        Case r9 = r3.mz(false);
        if (r9 == null) goto L16;
        r2 = r9.getRequestId();
    L16:
        tx9.w.a("show_result_direct", r2, r8);
        return Unit.INSTANCE;
    L10:
        r8 = null;
        goto L11
    }
}
