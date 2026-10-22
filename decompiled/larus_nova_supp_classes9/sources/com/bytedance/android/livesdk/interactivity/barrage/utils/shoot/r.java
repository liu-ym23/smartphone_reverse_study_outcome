package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ o a;

    public r(o r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        Iterator<String> r6 = this.a.d.keySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L10;
        String r0 = r6.next();
        StringBuilder r1 = new StringBuilder("self take 2: ");
        q22.a r2 = this.a.d.get(r0);
        if (r2 == null) goto L8;
        String r3 = r2.c;
    L9:
        r1.append(r3);
        Logger.d("GiftDanmakuShooter", r1.toString());
        o r7 = this.a;
        r7.l(r7.d.get(r0));
        goto L4
    L8:
        r3 = null;
        goto L9
    L10:
        this.a.d.clear();
    }
}
