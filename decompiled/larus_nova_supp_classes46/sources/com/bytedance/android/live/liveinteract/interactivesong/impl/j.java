package com.bytedance.android.live.liveinteract.interactivesong.impl;

import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ InteractiveSongWidget a;

    public j(InteractiveSongWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        SubscriberJsEvent r4 = (SubscriberJsEvent) r3;
        String r0 = this.a.u;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L18;
        InteractiveSongWidget r2 = this.a;
        Map r5 = r4.getParams();
        if (r5 == null) goto L15;
        Object r6 = r5.get("user_type");
        if (r6 == null) goto L15;
        String r7 = r6.toString();
    L16:
        r2.u = r7;
        return;
    L15:
        r7 = null;
        goto L16
    L18:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
