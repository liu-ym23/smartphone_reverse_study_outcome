package com.ss.android.lark.imagewidget;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImageWidgetFG {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(ImageWidgetFG$enableBigScreenCompat$2.INSTANCE);
    }

    public static final boolean a() {
        return ((Boolean) a.getValue()).booleanValue();
    }
}
