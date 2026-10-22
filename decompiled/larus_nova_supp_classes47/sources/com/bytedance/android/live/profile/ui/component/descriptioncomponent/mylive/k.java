package com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive;

import io.reactivex.functions.Action;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k implements Action {
    public final /* synthetic */ com.bytedance.android.livesdk.dsl.recyclerview.c a;

    public k(com.bytedance.android.livesdk.dsl.recyclerview.c r1) {
        this.a = r1;
    }

    public final void run() {
        Iterator r0 = this.a.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((yt1.k) r0.next()).release();
        goto L4
    }
}
