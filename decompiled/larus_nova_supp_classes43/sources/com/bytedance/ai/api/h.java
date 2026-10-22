package com.bytedance.ai.api;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class h implements Function1 {
    public /* synthetic */ h() {
    }

    public final Object invoke(Object r1) {
        AppsInstalledStatusUtils.a = ((Boolean) r1).booleanValue();
        return Unit.INSTANCE;
    }
}
