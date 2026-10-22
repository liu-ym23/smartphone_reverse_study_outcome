package com.larus.shortcuts.impl;

import android.content.Intent;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ShortcutCommonUtil {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public ShortcutCommonUtil() {
    }

    public static Intent b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "schema");
        AppHost.Companion r0 = AppHost.a;
        Intent r1 = r0.getApplication().getPackageManager().getLaunchIntentForPackage(r0.getApplication().getPackageName());
        if (r1 != null) goto L5;
        r1 = new Intent();
    L5:
        r1.setAction("android.intent.action.VIEW");
        r1.setPackage(r0.getApplication().getPackageName());
        r1.setData(UriProtector.parse(r3).buildUpon().build());
        r1.setFlags(268468224);
        return r1;
    }

    public static final Object a(String r5, Continuation r6) {
        j r0 = new j(IntrinsicsKt.intercepted(r6), 1);
        r0.C();
        ImageLoaderKt.l(r5, "realtime_call_avatar_utils", new a(r0), null, 52);
        Object r7 = r0.B();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L5:
        return r7;
    }

    public static Object c(tw9.a r3, Continuation r4) {
        Object r5 = BuildersKt.withContext(Dispatchers.getIO(), new ShortcutCommonUtil$downloadImage$2(r3, null), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public static Object d(List r3, Continuation r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ShortcutCommonUtil$downloadImages$2(r3, null), r4);
    }
}
