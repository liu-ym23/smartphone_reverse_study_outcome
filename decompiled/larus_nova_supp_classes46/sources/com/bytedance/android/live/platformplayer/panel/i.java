package com.bytedance.android.live.platformplayer.panel;

import com.bytedance.android.live.platformplayer.model.LivePanelType;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import zg1.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ o a;

    public i(o r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        i1 r5 = (i1) r4;
        if (r5.b == true) goto L5;
    L7:
        ds0.b r0 = new ds0.b();
        r0.a(LivePanelType.INPUT);
        if (r5.b == false) goto L10;
        String r1 = "open";
    L11:
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r0.b = r1;
        r0.c = r5.a;
        this.a.d.c(r0);
        return;
    L10:
        r1 = "close";
        goto L11
    L5:
        if (r5.a != 0) goto L7;
    }
}
