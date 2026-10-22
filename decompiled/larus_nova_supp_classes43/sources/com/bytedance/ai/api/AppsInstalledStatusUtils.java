package com.bytedance.ai.api;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AppsInstalledStatusUtils {
    public static boolean a;
    public static boolean b;

    static {
    }

    public static void a(String r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, "callback");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AppsInstalledStatusUtils$getPackageInfo$1(r10, r11, null), 3, null);
    }
}
