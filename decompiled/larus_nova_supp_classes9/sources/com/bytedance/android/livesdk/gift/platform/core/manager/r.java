package com.bytedance.android.livesdk.gift.platform.core.manager;

import com.bytedance.android.livesdk.gift.model.w1;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r implements Action {
    public static final r a = null;

    static {
        a = new r();
    }

    public r() {
    }

    public final void run() {
        GiftManagerKt.z.getClass();
        ArrayList r0 = new ArrayList();
        List r1 = GiftManagerKt.t();
        if (r1 == null) goto L10;
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        w1 r3 = (w1) r2.next();
        if (r3.getDisplay() == false) goto L6;
        r0.addAll(r3.getGifts());
    L10:
        ArrayList r4 = new ArrayList(r0);
        com.bytedance.android.livesdk.gift.platform.core.utils.f.e(r4, false, null);
        GiftManagerKt.h(r4);
        GiftManagerKt.g(r4);
        com.bytedance.android.livesdk.gift.util.d.b(r4, 2);
    }
}
