package com.ss.android.lark.image.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImageFGUtils {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    static {
        a = LazyKt.lazy(ImageFGUtils$supportHeif$2.INSTANCE);
        b = LazyKt.lazy(ImageFGUtils$releaseHeifPixelBufferAfterCopy$2.INSTANCE);
        c = LazyKt.lazy(ImageFGUtils$enableRenderEffectBlur$2.INSTANCE);
    }
}
