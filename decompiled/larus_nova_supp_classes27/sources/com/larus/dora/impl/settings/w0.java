package com.larus.dora.impl.settings;

import com.bytedance.news.common.settings.SettingsManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class w0 implements Function0 {
    public /* synthetic */ w0() {
    }

    public final Object invoke() {
        return ((IDoraSettings) SettingsManager.obtain(IDoraSettings.class)).doraLynxPageConfig();
    }
}
