package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(long r3, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "receiverID");
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        return false;
    L12:
        return !Intrinsics.areEqual((String) ((HashMap) com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.v.b.getValue(null, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter.v.a[0])).get(String.valueOf(r3) + r5), r6);
    L5:
        if (r6.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
