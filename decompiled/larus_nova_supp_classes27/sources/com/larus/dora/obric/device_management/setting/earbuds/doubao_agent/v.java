package com.larus.dora.obric.device_management.setting.earbuds.doubao_agent;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class v extends ViewOutlineProvider {
    public final /* synthetic */ DoraObricEarbudsDoubaoAgentSettingsFragment.a a;

    public v(DoraObricEarbudsDoubaoAgentSettingsFragment.a r1) {
        this.a = r1;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r8, Outline r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "outline");
        r9.setRoundRect(0, 0, r8.getWidth(), r8.getHeight(), this.a.a);
    }
}
