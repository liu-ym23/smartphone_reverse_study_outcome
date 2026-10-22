package com.bytedance.android.live.revenue.platform.hybrid.api.shareview;

import com.bytedance.android.livesdk.gift.platform.core.scope.service.t0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class e {
    public final String a;

    public static final class a extends e {
        public final com.bytedance.ies.web.jsbridge2.f.b b;

        public a() {
            t0.a r0 = t0.a.a;
            Intrinsics.checkNotNullParameter("revenue.requestStickerEffectStatus", "name");
            Intrinsics.checkNotNullParameter(r0, "method");
            this.b = r0;
        }
    }

    public static final class b extends e {
    }

    public e() {
        this.a = "revenue.requestStickerEffectStatus";
    }
}
