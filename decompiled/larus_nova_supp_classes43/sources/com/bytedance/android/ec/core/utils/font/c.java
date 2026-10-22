package com.bytedance.android.ec.core.utils.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements e {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // com.bytedance.android.ec.core.utils.font.e
    public final Typeface a(Context r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return com.bytedance.android.ec.sdk.helper.d.b.getIECHostUIService().a(r10, "DouyinSansBold.otf");
    }
}
