package com.larus.bmhome.double_post.utils;

import com.larus.bmhome.utils.z1;
import com.larus.platform.model.chat.ChatAwemeFeedConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static boolean a;
    public static final Lazy b = null;
    public static final Lazy c = null;

    static {
        b = LazyKt.lazy(new a());
        c = LazyKt.lazy(new b());
    }

    public static int a() {
        Lazy r0 = b;
        if (((ChatAwemeFeedConfig) r0.getValue()).canEntryAwemeFeed() == true) goto L5;
        return 0;
    L5:
        if (((ChatAwemeFeedConfig) r0.getValue()).getShouldFullyDisplay() == true) goto L16;
        Lazy r1 = c;
        if (((Number) r1.getValue()).floatValue() > 0.0f) goto L10;
        return 0;
    L10:
        if (((Number) r1.getValue()).floatValue() >= 2.0f) goto L15;
        Lazy r2 = z1.a;
        int r3 = z1.i(0);
        Lazy r4 = com.larus.bmhome.video.b.a;
        return (int) (((int) ((((((r3 - (com.larus.bmhome.video.b.b(false) * 6)) / ((Number) com.larus.bmhome.video.b.a().getSecond()).intValue()) * 1.15f) + i5.Z()) + i5.Q()) + i5.n0())) * (2 - ((Number) r1.getValue()).floatValue()));
    L15:
        return 0;
    L16:
        return 0;
    }
}
