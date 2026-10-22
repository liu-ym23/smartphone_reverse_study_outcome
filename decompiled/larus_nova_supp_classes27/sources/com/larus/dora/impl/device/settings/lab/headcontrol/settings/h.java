package com.larus.dora.impl.device.settings.lab.headcontrol.settings;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.common_ui.dialog.p0;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h implements p0 {
    public final /* synthetic */ HeadControlSettingsFragment a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        HeadControlSettingsFragment r0 = this.a;
        if (r0.h == true) goto L7;
        r0.h = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0.getViewLifecycleOwner()), null, null, new HeadControlSettingsFragment$syncBehaviorAwareThenRefresh$1(r0, null), 3, null);
        return;
    }

    public h(HeadControlSettingsFragment r1) {
        this.a = r1;
    }
}
