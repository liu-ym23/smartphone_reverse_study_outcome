package com.larus.settings.mainbot;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class f implements Function1 {
    public /* synthetic */ f() {
    }

    public final Object invoke(Object r2) {
        IMainBotSettings r3 = (IMainBotSettings) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return Integer.valueOf(r3.exposedSkillLoadingTime());
    }
}
