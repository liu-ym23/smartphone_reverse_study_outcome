package com.bytedance.ai.resource.security;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class d implements Function1 {
    public /* synthetic */ d() {
    }

    public final Object invoke(Object r10) {
        String r11 = (String) r10;
        Intrinsics.checkNotNullParameter(r11, "it");
        return r11.getBytes(Charsets.UTF_8);
    }
}
