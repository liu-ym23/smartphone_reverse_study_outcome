package com.larus.bmhome.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class y2 {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new x2());
    }

    public static boolean a() {
        return ((com.larus.platform.model.chat.g0) a.getValue()).a();
    }
}
