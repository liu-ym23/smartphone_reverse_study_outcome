package com.ss.android.lark.coremd.ext;

import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g {
    public static final void a(j r1, h r2, Function2 r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "contextProvider");
        Intrinsics.checkNotNullParameter(r3, Keys.API_PARAM_KEY_ACTION);
        r3.invoke(r2.a(), r1);
    }
}
