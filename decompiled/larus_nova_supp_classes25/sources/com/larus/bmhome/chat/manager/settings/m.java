package com.larus.bmhome.chat.manager.settings;

import com.larus.common_ui.dialog.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m implements p0 {
    public final /* synthetic */ SettingOptionViewModel a;

    public final void confirm() {
        this.a.togglePersonalizedRecommendEnable(false);
    }

    public m(SettingOptionViewModel r1) {
        this.a = r1;
    }
}
