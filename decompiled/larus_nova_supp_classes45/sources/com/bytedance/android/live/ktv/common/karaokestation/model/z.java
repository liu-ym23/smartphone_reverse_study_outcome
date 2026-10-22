package com.bytedance.android.live.ktv.common.karaokestation.model;

import android.text.TextUtils;
import com.bytedance.android.live.ktv.common.model.api.o0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z {
    public static final y update(y r2, o0 r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$update");
        Intrinsics.checkNotNullParameter(r3, "playlistLabel");
        String r0 = r3.c();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r2.c = r0;
        if (r3.f() == true) goto L5;
    L7:
        String r1 = r3.a();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r2.d = r1;
        r2.e = r3.b();
        r2.f.getClass();
        r2.g = r3.e();
        return r2;
    L5:
        if (TextUtils.isEmpty(r3.c()) == false) goto L7;
        String r4 = r3.a();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r2.c = r4;
        goto L7
    }
}
