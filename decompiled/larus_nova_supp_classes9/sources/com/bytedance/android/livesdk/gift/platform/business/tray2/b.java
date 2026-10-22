package com.bytedance.android.livesdk.gift.platform.business.tray2;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ Ref.FloatRef a;

    public b(Ref.FloatRef r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        com.bytedance.android.livesdk.revenue.service.interactivity.a r4 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.interactivity.a.class);
        if (r4 == null) goto L6;
        r4.oe(this.a.element);
        return;
    }
}
