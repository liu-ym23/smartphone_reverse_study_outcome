package com.larus.bmhome.chat.component.showcase;

import android.view.View;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.utils.logger.FLogger;
import ic8.n;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class w implements y.a<e> {
    public final /* synthetic */ ChatPlaybackComponent a;

    public w(ChatPlaybackComponent r1) {
        this.a = r1;
    }

    public final void c(Object r4) {
        e r5 = (e) r4;
        Intrinsics.checkNotNullParameter(r5, "new");
        FLogger.a.d("ChatPlaybackComponent", "observeConversationChanged, onChange, new=" + r5);
        if (n.d(r5) == false) goto L12;
        ChatPlaybackComponent r6 = this.a;
        if (r6.u == true) goto L13;
        r6.u = true;
        View r0 = r6.o;
        if (r0 == null) goto L14;
        r6.Y2(r0);
        return;
    L14:
        return;
    L13:
        return;
    }
}
