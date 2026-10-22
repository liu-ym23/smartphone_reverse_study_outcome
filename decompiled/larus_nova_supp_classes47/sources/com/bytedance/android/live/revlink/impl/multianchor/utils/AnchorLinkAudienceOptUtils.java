package com.bytedance.android.live.revlink.impl.multianchor.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class AnchorLinkAudienceOptUtils {
    public final Lazy a;
    public final Lazy b;

    public AnchorLinkAudienceOptUtils() {
        this.a = LazyKt.lazy(AnchorLinkAudienceOptUtils$enterRoomOpt$2.INSTANCE);
        this.b = LazyKt.lazy(AnchorLinkAudienceOptUtils$enterRoomOptConfig$2.INSTANCE);
    }
}
