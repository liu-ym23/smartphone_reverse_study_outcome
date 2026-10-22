package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m<T> implements Consumer {
    public final /* synthetic */ k.b a;

    public m(k.b r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        List<k.a> r7 = (List) r6;
        Iterator<k.a> r0 = r7.iterator();
    L3:
        boolean r1 = true;
    L5:
        if (r0.hasNext() == false) goto L14;
        k.a r2 = r0.next();
        if (r2.c == (-1)) goto L8;
        if (r1 == false) goto L13;
        if (r2.e == true) goto L3;
    L13:
        r1 = false;
        goto L5
    L8:
        this.a.a(r7);
        return;
    L14:
        this.a.b(r1);
        this.a.onResult(r7);
    }
}
