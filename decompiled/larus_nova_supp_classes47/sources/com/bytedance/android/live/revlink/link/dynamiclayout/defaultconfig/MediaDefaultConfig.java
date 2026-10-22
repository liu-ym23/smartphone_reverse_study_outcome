package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MediaDefaultConfig {
    public static final /* synthetic */ int d = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;

    public static final class a {
    }

    static {
    }

    public MediaDefaultConfig() {
        this.a = LazyKt.lazy(new MediaDefaultConfig$entrance$2(this));
        this.b = LazyKt.lazy(new MediaDefaultConfig$normalConfig$2(this));
        this.c = LazyKt.lazy(new MediaDefaultConfig$enlargeConfig$2(this));
    }
}
