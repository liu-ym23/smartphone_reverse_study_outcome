package com.bytedance.android.livesdk.gift.platform.core.manager;

import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e<T> implements Consumer {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    public final void accept(Object r3) {
        boolean r0 = GiftEffectManager.a;
        boolean r4 = ((tq2.d) r3).a;
        GiftEffectManager.d = r4;
        if (r4 == false) goto L10;
        WeakReference<DataCenter> r5 = GiftEffectManager.b;
        if (r5 == null) goto L11;
        DataCenter r6 = r5.get();
        if (r6 == null) goto L12;
        r6.put("cmd_clear_gift_message", new Object());
        return;
    L12:
        return;
    L11:
        return;
    }
}
