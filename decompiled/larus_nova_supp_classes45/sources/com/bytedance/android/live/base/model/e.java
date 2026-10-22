package com.bytedance.android.live.base.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public static final FlexImageModel a(d r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$toImageModel");
        FlexImageModel r0 = new FlexImageModel();
        r0.setUrls(r3.getUrlList());
        r0.setUri(r3.getUri());
        r0.topBorderHeight = r3.getTopBorderHeight();
        return r0;
    }
}
