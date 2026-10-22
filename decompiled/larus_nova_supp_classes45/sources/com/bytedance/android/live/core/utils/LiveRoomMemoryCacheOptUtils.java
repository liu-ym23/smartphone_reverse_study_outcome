package com.bytedance.android.live.core.utils;

import com.bytedance.android.livesdkapi.model.LiveRoomMemoryOptConfigV2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveRoomMemoryCacheOptUtils {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(LiveRoomMemoryCacheOptUtils$config$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean a() {
        return ((LiveRoomMemoryOptConfigV2) a.getValue()).getEnable();
    }
}
