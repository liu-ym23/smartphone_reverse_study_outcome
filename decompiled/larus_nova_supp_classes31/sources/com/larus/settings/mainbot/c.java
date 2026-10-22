package com.larus.settings.mainbot;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class c implements Function1 {
    public /* synthetic */ c() {
    }

    public final Object invoke(Object r2) {
        IMainBotSettings r3 = (IMainBotSettings) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return Boolean.valueOf(r3.enableCreateMarkdownOnMain());
    }
}
