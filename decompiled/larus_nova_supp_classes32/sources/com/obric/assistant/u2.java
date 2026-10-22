package com.obric.assistant;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class u2 implements Function0 {
    public final /* synthetic */ ObricSettingsServiceImpl a;

    public /* synthetic */ u2(ObricSettingsServiceImpl r1) {
        this.a = r1;
    }

    public final Object invoke() {
        return this.a.c.getObricAutoIncreaseDelayedTimeConfig();
    }
}
