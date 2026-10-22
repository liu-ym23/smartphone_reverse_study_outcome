package com.bytedance.android.live.base.model.message;

import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v3 {
    public static final IPublicAreaCommon a(tlc.d r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$publicAreaCommon");
        if ((r2 instanceof u3) == true) goto L5;
        r2 = null;
    L5:
        u3 r3 = (u3) r2;
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.getOrInitPublicAreaCommon();
    }
}
