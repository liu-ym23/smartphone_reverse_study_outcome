package com.bytedance.android.livesdk.gift.platform.format.panel.statemachine;

import com.bytedance.android.livesdk.gift.format.GiftPlayerView;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.p2;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b<T> implements Consumer {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    public final void accept(Object r3) {
        h1 r4 = ((p2) r3).getGift();
        if (r4 == null) goto L10;
        com.bytedance.android.livesdk.gift.format.a r0 = com.bytedance.android.live.revenue.core.util.f.a(com.bytedance.android.livesdk.gift.format.a.class);
        Intrinsics.checkNotNullParameter(r4, "gift");
        WeakReference<GiftPlayerView> r1 = r0.a;
        if (r1 == null) goto L11;
        GiftPlayerView r2 = r1.get();
        if (r2 == null) goto L12;
        r2.a(r4);
        return;
    L12:
        return;
    L11:
        return;
    }
}
