package com.bytedance.android.livesdk.chatroom.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class PlayLayoutSeiCache {
    public final Lazy a;
    public int b;

    public PlayLayoutSeiCache() {
        this.a = LazyKt.lazy(PlayLayoutSeiCache$cacheSeiMap$2.INSTANCE);
    }
}
