package com.obric.assistant.performance;

import android.app.ActivityManager;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class e implements Function0 {
    public /* synthetic */ e() {
    }

    public final Object invoke() {
        Object r0 = AppHost.a.getApplication().getSystemService("activity");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.ActivityManager");
        return (ActivityManager) r0;
    }
}
