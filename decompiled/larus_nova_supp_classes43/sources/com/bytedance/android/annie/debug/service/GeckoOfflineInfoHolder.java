package com.bytedance.android.annie.debug.service;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class GeckoOfflineInfoHolder {
    public static final Lazy<GeckoOfflineInfoHolder> b = null;
    public final Lazy a;

    public static final class a {
    }

    static {
        b = LazyKt.lazy(GeckoOfflineInfoHolder$Companion$instance$2.INSTANCE);
    }

    public GeckoOfflineInfoHolder() {
        this.a = LazyKt.lazy(GeckoOfflineInfoHolder$offlineStates$2.INSTANCE);
    }

    public static String a(String r10) {
        List r11 = StringsKt.split$default(r10, new String[]{"?"}, false, 0, 6, null);
        if ((!r11.isEmpty()) == true) goto L7;
        return null;
    L7:
        return (String) ListProtector.get(r11, 0);
    }
}
