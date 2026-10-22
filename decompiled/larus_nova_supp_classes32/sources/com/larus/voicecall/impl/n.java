package com.larus.voicecall.impl;

import com.larus.platform.api.g1;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n implements g1.c {
    public final /* synthetic */ Function2<Boolean, Boolean, Unit> a;

    public final void onGoSettingsDialogDismiss(boolean r1) {
    }

    public final void onGoSettingsDialogShow() {
    }

    public final void onSettingPageReturn() {
    }

    public n(com.larus.voicecall.impl.component.core.d0 r1) {
        this.a = r1;
    }

    public final void onResult(boolean r2, List<String> r3, List<String> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "grantedList");
        Intrinsics.checkNotNullParameter(r4, "deniedList");
        this.a.invoke(Boolean.valueOf(r2), Boolean.valueOf(r5));
    }
}
