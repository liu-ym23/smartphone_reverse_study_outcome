package com.larus.voicecall.impl;

import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new a());
    }

    public static boolean a() {
        return ((Keva) a.getValue()).getBoolean("is_full_screen_call", false);
    }
}
