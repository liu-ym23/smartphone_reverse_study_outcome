package com.obric.assistant;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class d4 implements Function0 {
    public final /* synthetic */ ObricSettingsServiceImpl a;

    public /* synthetic */ d4(ObricSettingsServiceImpl r1) {
        this.a = r1;
    }

    public final Object invoke() {
        return Boolean.valueOf(this.a.c.isReRecordWakeWordGuideEnable());
    }
}
