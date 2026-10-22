package com.obric.assistant;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class t2 implements Function0 {
    public final /* synthetic */ ObricSettingsServiceImpl a;

    public /* synthetic */ t2(ObricSettingsServiceImpl r1) {
        this.a = r1;
    }

    public final Object invoke() {
        return Integer.valueOf(this.a.c.getObricWakeupSoundConfigWhite());
    }
}
