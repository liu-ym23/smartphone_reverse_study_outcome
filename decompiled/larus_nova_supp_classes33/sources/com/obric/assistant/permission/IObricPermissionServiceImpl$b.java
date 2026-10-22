package com.obric.assistant.permission;

import com.larus.platform.api.g1;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class IObricPermissionServiceImpl$b implements g1.c {
    public final /* synthetic */ IObricPermissionService$a a;

    public final void onGoSettingsDialogDismiss(boolean r1) {
    }

    public final void onGoSettingsDialogShow() {
    }

    public final void onSettingPageReturn() {
    }

    public IObricPermissionServiceImpl$b(IObricPermissionService$a r1) {
        this.a = r1;
    }

    public final void onResult(boolean r2, List<String> r3, List<String> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "grantedList");
        Intrinsics.checkNotNullParameter(r4, "deniedList");
        this.a.a(false, r2, r3, r4);
    }
}
