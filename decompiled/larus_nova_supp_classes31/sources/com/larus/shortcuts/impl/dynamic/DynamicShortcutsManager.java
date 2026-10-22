package com.larus.shortcuts.impl.dynamic;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Build;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.HomeService;
import com.larus.platform.service.AccountService;
import com.larus.shortcuts.impl.ShortcutCommonUtil;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class DynamicShortcutsManager {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a() {
        FLogger.a.e("DynamicShortcutsManager", "clear shortcut");
        if (Build.VERSION.SDK_INT < 25) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new DynamicShortcutsManager$clearShortcuts$1(null), 3, null);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static ShortcutInfo b(tw9.a r5) {
        if (r5.f() != null) goto L8;
        if (r5.a != null) goto L8;
        return null;
    L8:
        if (r5.d() != null) goto L10;
    L24:
        return null;
    L10:
        if (r5.c() == null) goto L24;
        if (r5.g() == null) goto L24;
        AppHost.Companion r0 = AppHost.a;
        Context r2 = r0.getApplication().getApplicationContext();
        HomeService r3 = HomeService.a;
        Intrinsics.checkNotNull(r2);
        String r4 = r3.A(r2);
        if (r4 != null) goto L17;
        return null;
    L17:
        ShortcutInfo.Builder r1 = new ShortcutInfo.Builder(r2, r5.b()).setActivity(new ComponentName(r2.getPackageName(), r4));
        String r6 = r5.d();
        Intrinsics.checkNotNull(r6);
        ShortcutInfo.Builder r7 = r1.setShortLabel(r6);
        String r8 = r5.c();
        Intrinsics.checkNotNull(r8);
        ShortcutInfo.Builder r9 = r7.setLongLabel(r8).setRank(r5.e());
        Integer r10 = r5.f();
        if (r10 == null) goto L21;
        int r11 = r10.intValue();
        Icon r12 = Icon.createWithResource(r0.getApplication(), r11);
        if (r12 == null) goto L21;
    L22:
        ShortcutInfo.Builder r13 = r9.setIcon(r12);
        int r14 = ShortcutCommonUtil.a;
        String r15 = r5.g();
        Intrinsics.checkNotNull(r15);
        return r13.setIntent(ShortcutCommonUtil.b(r15)).build();
    L21:
        r12 = Icon.createWithBitmap(r5.a);
        goto L22
    }

    public static void c(List r5) {
        if (AccountService.a.isLogin().booleanValue() == true) goto L6;
        FLogger.a.i("DynamicShortcutsManager", "real set up shortcut error, no login");
        return;
    L6:
        FLogger r0 = FLogger.a;
        StringBuilder r2 = new StringBuilder("real set up shortcut, count = ");
        ArrayList r3 = (ArrayList) r5;
        r2.append(r3.size());
        r0.i("DynamicShortcutsManager", r2.toString());
        if (r3.size() != 0) goto L16;
        a();
        return;
    L16:
        ShortcutManager r1 = (ShortcutManager) AppHost.a.getApplication().getApplicationContext().getSystemService("shortcut");     // Catch: Exception -> L12
        if (r1 == null) goto L18;
        r1.setDynamicShortcuts(r5);     // Catch: Exception -> L12
        return;
    L18:
        return;
    L12:
        e = move-exception;
        FLogger.a.e("DynamicShortcutsManager", "setup shortcut exception: " + e.getMessage());
    }
}
