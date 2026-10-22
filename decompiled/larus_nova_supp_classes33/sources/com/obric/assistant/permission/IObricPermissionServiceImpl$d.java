package com.obric.assistant.permission;

import com.larus.permission.api.IPermissionX;
import com.larus.platform.api.g1;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class IObricPermissionServiceImpl$d implements IPermissionX.c {
    public final /* synthetic */ g1.b a;

    public final void a(boolean r1, String r2) {
    }

    public final void b(String r1) {
    }

    public final void onResult(boolean r1, List<String> r2, List<String> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "grantedList");
        Intrinsics.checkNotNullParameter(r3, "deniedList");
    }

    public final void onSettingPageReturn() {
        g1.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onSettingPageReturn();
        return;
    }

    public IObricPermissionServiceImpl$d(g1.b r1) {
        this.a = r1;
    }
}
