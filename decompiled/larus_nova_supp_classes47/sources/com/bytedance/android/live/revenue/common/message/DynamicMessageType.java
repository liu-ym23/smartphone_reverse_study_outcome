package com.bytedance.android.live.revenue.common.message;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class DynamicMessageType extends yh6.a {
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;

    public DynamicMessageType() {
        this.b = LazyKt.lazy(new DynamicMessageType$LUCKY_BOX$2(this));
        this.c = LazyKt.lazy(new DynamicMessageType$LUCKY_BOX_END$2(this));
        this.d = LazyKt.lazy(new DynamicMessageType$LUCKY_BOX_TEMP_STATUS$2(this));
        this.e = LazyKt.lazy(new DynamicMessageType$LUCKY_BOX_REWARD_MESSAGE$2(this));
    }
}
