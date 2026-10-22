package com.larus.bmhome.chat.manager.settings;

import com.larus.bmhome.view.item.ItemTextToggle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n implements com.larus.common_ui.dialog.u {
    public final /* synthetic */ ItemTextToggle a;
    public final /* synthetic */ SettingOptionViewModel b;

    public final void cancel() {
        this.a.getToggleView().setChecked(this.b.isPersonalizedRecommendEnable());
    }

    public n(ItemTextToggle r1, SettingOptionViewModel r2) {
        this.a = r1;
        this.b = r2;
    }
}
