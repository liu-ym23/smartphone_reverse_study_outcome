package com.larus.contextwindow.impl.component;

import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class g implements Function2 {
    public /* synthetic */ g() {
    }

    public final Object invoke(Object r2, Object r3) {
        int r0 = ContextWindowEntryFeature.z;
        return Boolean.valueOf(Intrinsics.areEqual((BotModel) r2, (BotModel) r3));
    }
}
