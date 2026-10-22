package com.larus.settings.performance;

import com.bytedance.news.common.settings.SettingsUpdateListener;
import com.bytedance.news.common.settings.api.SettingsData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class d implements SettingsUpdateListener {
    public /* synthetic */ d() {
    }

    public final void onSettingsUpdate(SettingsData r5) {
        e r6 = e.a;
        r6.getClass();
        SystemBatteryRecorderConfig r0 = e.b();
        e.c.setValue(r6, e.b[0], r0);
    }
}
