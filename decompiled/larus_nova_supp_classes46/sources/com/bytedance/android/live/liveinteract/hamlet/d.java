package com.bytedance.android.live.liveinteract.hamlet;

import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ HamletAvatarWidget a;

    public d(HamletAvatarWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Iterator<T> r4 = ((List) r3).iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        T r0 = r4.next();
        if (((ch0.e) r0).a.isEnlarged() == false) goto L4;
    L9:
        ch0.e r1 = r0;
        if (r1 == null) goto L12;
        boolean r5 = ch0.f.a(r1);
    L13:
        HamletAvatarWidget.yq(this.a, r5);
        return;
    L12:
        r5 = false;
        goto L13
    L8:
        r0 = (T) null;
        goto L9
    }
}
