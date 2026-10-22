package com.bytedance.android.anniex.lite.flow.web;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final b a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        com.bytedance.android.anniex.lite.flow.base.a r0 = com.bytedance.android.anniex.lite.flow.base.a.a;
        if (r0.a(r10) != null) goto L5;
    L7:
        return null;
    L5:
        if ((r0.a(r10) instanceof b) == false) goto L7;
        Object r11 = r0.a(r10);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.bytedance.android.anniex.lite.flow.web.IAnnieXWebPreloadProvider");
        return (b) r11;
    }
}
