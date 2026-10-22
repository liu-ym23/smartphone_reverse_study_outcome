package com.larus.profile.impl.view;

import android.content.Context;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b0 {
    static {
    }

    public static void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Object r0 = xp9.o.a;
        if ((r0 instanceof OfficeSDKUserApi) == false) goto L5;
        OfficeSDKUserApi r1 = (OfficeSDKUserApi) r0;
    L6:
        if (r1 == null) goto L11;
        ktb.a r3 = r1.getService(ktb.a.class);
        if (r3 == null) goto L12;
        r3.F1(r2, new mtb.l());
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
