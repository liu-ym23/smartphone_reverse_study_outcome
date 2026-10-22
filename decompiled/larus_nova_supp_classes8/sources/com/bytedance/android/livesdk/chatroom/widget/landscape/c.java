package com.bytedance.android.livesdk.chatroom.widget.landscape;

import com.bytedance.android.livesdk.chatroom.model.PadOrientation;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ LandscapeQuickRecordWidget a;

    public c(LandscapeQuickRecordWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        sh6.b r4 = (sh6.b) r3;
        LandscapeQuickRecordWidget r0 = this.a;
        if (r4 == null) goto L5;
        PadOrientation r5 = (PadOrientation) sh6.c.b(r4);
    L7:
        if (r5 == PadOrientation.LANDSCAPE) goto L9;
        boolean r6 = true;
    L10:
        boolean r1 = LandscapeQuickRecordWidget.j;
        r0.xq(r6);
        return;
    L9:
        r6 = false;
        goto L10
    L5:
        r5 = null;
        goto L7
    }
}
