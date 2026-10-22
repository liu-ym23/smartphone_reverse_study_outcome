package com.bytedance.android.livesdk.gift.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v3 {
    public static final boolean a(u3 r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isValid");
        if (r1.getPostEffectSource() == 0) goto L9;
        py.l r2 = r1.getPostEffectImg();
        if (r2 == null) goto L9;
        if ((!r2.getUrls().isEmpty()) != true) goto L9;
        return true;
    L9:
        return false;
    }
}
