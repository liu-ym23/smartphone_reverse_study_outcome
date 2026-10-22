package com.bytedance.android.livesdk.gift.platform.business.normal.utils;

import com.bytedance.android.livesdk.gift.model.o0;
import kotlin.Lazy;
import kotlin.LazyKt;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftImageFormat {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(GiftImageFormat$giftImageFormatOpt$2.INSTANCE);
        b = LazyKt.lazy(GiftImageFormat$giftImageTemplateOpt$2.INSTANCE);
    }

    public static k a(o0 r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        if (((Boolean) a.getValue()).booleanValue() == false) goto L12;
        if (r1.getTrayBaseWebpImg() == null) goto L12;
        return r1.getTrayBaseWebpImg();
    L12:
        return r1.getTrayBaseImg();
    }
}
