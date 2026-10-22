package jtb;

import android.content.Context;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements itb.c {
    public b() {
    }

    @Override // itb.c
    public final void V(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        itb.c r0 = (itb.c) OfficeSDKManager.getHostGlobalService(itb.c.class);
        if (r0 == null) goto L6;
        r0.V(r2);
        return;
    }
}
