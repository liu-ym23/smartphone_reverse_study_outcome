package com.bytedance.android.annie.util;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class RomUtils {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(RomUtils$isMiui$2.INSTANCE);
        b = LazyKt.lazy(RomUtils$isFlyme$2.INSTANCE);
    }
}
