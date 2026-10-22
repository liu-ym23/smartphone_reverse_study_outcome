package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils;

import com.bytedance.android.livesdk.config.p11;
import com.bytedance.android.livesdk.config.q11;
import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class LiveBgPlayUtil {
    public static final Lazy a = null;
    public static boolean b;

    static {
        Lazy r0 = LazyKt.lazy(LiveBgPlayUtil$keva$2.INSTANCE);
        a = r0;
        b = ((Keva) r0.getValue()).getBoolean("key_keep_playing_switch_config", true);
    }

    public static q11 a() {
        return p11.a.getValue();
    }
}
