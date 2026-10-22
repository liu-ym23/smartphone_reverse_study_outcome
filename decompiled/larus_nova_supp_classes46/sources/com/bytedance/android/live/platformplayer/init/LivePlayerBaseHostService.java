package com.bytedance.android.live.platformplayer.init;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class LivePlayerBaseHostService {
    public final String a;
    public final Lazy b;
    public final Lazy c;

    public LivePlayerBaseHostService() {
        this.a = "ttliveplayer_";
        this.b = LazyKt.lazy(LivePlayerBaseHostService$alog$2.INSTANCE);
        this.c = LazyKt.lazy(LivePlayerBaseHostService$network$2.INSTANCE);
    }
}
