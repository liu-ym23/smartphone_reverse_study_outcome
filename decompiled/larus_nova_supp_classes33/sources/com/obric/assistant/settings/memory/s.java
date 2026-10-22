package com.obric.assistant.settings.memory;

import com.larus.platform.api.g1;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class s implements g1.c {
    public final /* synthetic */ ObricPersonalContextSettingFragment a;

    public final void onGoSettingsDialogDismiss(boolean r1) {
    }

    public final void onGoSettingsDialogShow() {
    }

    public final void onSettingPageReturn() {
    }

    public s(ObricPersonalContextSettingFragment r1) {
        this.a = r1;
    }

    public final void onResult(boolean r1, List<String> r2, List<String> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "grantedList");
        Intrinsics.checkNotNullParameter(r3, "deniedList");
        if (r1 == false) goto L5;
    L8:
        FLogger.a.i("ObricPersonalContextSettingFragment", "only granted one: " + r2);
    L9:
        ObricPersonalContextSettingFragment r5 = this.a;
        int r6 = ObricPersonalContextSettingFragment.l;
        r5.V90().refresh();
        return;
    L5:
        if ((!r2.isEmpty()) == false) goto L9;
        if (r2.size() != 1) goto L9;
        goto L8
    }
}
