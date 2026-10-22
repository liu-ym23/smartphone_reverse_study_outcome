package com.bytedance.awemeopen.infra.util;

import android.content.Intent;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class a implements AoActivityResultRequest.a {
    public final /* synthetic */ Function3 a;

    public /* synthetic */ a(Function3 r1) {
        this.a = r1;
    }

    public final void a(int r3, int r4, Intent r5) {
        Function3 r0 = this.a;
        Intrinsics.checkNotNullParameter(r0, "$callback");
        r0.invoke(Integer.valueOf(r3), Integer.valueOf(r4), r5);
    }
}
