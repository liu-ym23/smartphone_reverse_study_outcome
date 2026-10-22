package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftClientAIIntegratedService implements com.bytedance.android.scope.o {
    public boolean a;
    public final Lazy b;

    public static final class a {
    }

    public static final class b implements wp2.l {
        public b() {
        }
    }

    static {
    }

    public final void onStart() {
        if (((com.bytedance.android.livesdk.gift.configmodel.d2) this.b.getValue()).a() == false) goto L5;
    L6:
        this.a = true;
        vh6.c.b(rq2.a.class).r2(new b());
        return;
    L5:
        if (((com.bytedance.android.livesdk.gift.configmodel.d2) this.b.getValue()).c() == true) goto L6;
    }

    public final void onStop() {
        if (this.a == true) goto L5;
        return;
    L5:
        vh6.c.b(rq2.a.class).removeGiftAssetDownloadCallback();
    }

    public GiftClientAIIntegratedService(e1 r2) {
        Intrinsics.checkNotNullParameter(r2, "giftListService");
        this.b = LazyKt.lazy(GiftClientAIIntegratedService$liveGiftListPreloadConfig$2.INSTANCE);
    }
}
