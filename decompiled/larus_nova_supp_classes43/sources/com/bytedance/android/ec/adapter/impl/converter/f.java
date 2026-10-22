package com.bytedance.android.ec.adapter.impl.converter;

import com.bytedance.android.livesdkapi.room.handler.IExternalMessageListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f implements IExternalMessageListener {
    public final /* synthetic */ td.a a;

    public f(td.a r1) {
        this.a = r1;
    }

    public final void onMessage(tlc.d r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
        td.a r0 = this.a;
        if ((r10 instanceof ce.a) == false) goto L6;
        ee.a r1 = new ee.b((ce.a) r10);
    L9:
        r0.f(r1, false);
        return;
    L6:
        if ((r10 instanceof com.bytedance.android.ec.adapter.impl.messagev2.a) == false) goto L8;
        r1 = (ee.a) r10;
        goto L9
    L8:
        r1 = null;
        goto L9
    }
}
