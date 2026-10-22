package com.bytedance.android.livesdk.interactivity.service.richcontent;

import ak6.b;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class LiveRichContentEngine {
    public static final Lazy a = null;

    public static b a() {
        return (b) a.getValue();
    }

    static {
        a = LazyKt.lazy(LiveRichContentEngine$richContentEngine$2.INSTANCE);
    }
}
