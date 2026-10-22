package com.bytedance.awemeopen.infra.plugs.settings.update;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.monitor.AoMonitor;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.awemeopen.infra.plugs.settings.AoSettings$mSettingsUpdater$2;
import com.bytedance.awemeopen.infra.plugs.settings.SettingsModel;
import com.bytedance.awemeopen.infra.plugs.settings.dao.AoSettingsDao;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class AoAppSettingsUpdater {
    public final Context a;
    public final String b;
    public final AoSettingsDao c;
    public final a d;
    public final String e;
    public final Lazy f;
    public final Lazy g;

    public interface a {
        void a(SettingsModel r1);
    }

    public final void c(final String r2) {
        AoPool.a(new AoAppSettingsUpdater$clearMockSettings$1(this, r2));
    }

    public final void d(final String r2, final JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        AoPool.a(new AoAppSettingsUpdater$setMockSettings$1(this, r2, r3));
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Context r9, AoAppSettingsUpdater$mUpdateReceiver$2.AnonymousClass1 r10, IntentFilter r11) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L40:
    L34:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.registerReceiver(r10, r11, 4);
        return;
    L39:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L23;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r11) == false) goto L23;
        int r1 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r10, r11, 4, null, null, 3, r9).result;     // Catch: Exception -> L34
        if (r1 != 1) goto L13;
        r9.registerReceiver(r10, r11, 4);     // Catch: Exception -> L34
        return;
    L13:
        if (r1 != 2) goto L15;
        new Intent();     // Catch: Exception -> L34
        return;
    L15:
        if (r1 == 3) goto L41;
        r9.registerReceiver(r10, r11, 4);     // Catch: Exception -> L34
        return;
    L41:
        return;
    L23:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L27;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L34
        r9.registerReceiver(r10, r11, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L34
        return;
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L29;
    L32:
        r9.registerReceiver(r10, r11, 4);     // Catch: Exception -> L34
        return;
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r11) == false) goto L32;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L34
        ContextCompat.registerReceiver(r9, r10, r11, null, ReceiverRegisterLancet.sProxyHandler, 4);     // Catch: Exception -> L34
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void b(Context r8, AoAppSettingsUpdater$mUpdateReceiver$2.AnonymousClass1 r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L22;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8).result;     // Catch: Exception -> L33
        if (r0 != 1) goto L12;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L12:
        if (r0 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r0 == 3) goto L40;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }

    public final void e(final Function0<? extends Map<String, String>> r5, final boolean r6, final String r7) {
        Intrinsics.checkNotNullParameter(r5, "paramsFetcher");
        Intrinsics.checkNotNullParameter(r7, "from");
        AoLogger.g(this.e, new Object[]{"start update", Boolean.valueOf(r6), r7});
        AoPool.a(new AoAppSettingsUpdater$updateSettings$1(this, r5, r6, r7));
    }

    public AoAppSettingsUpdater(Context r2, String r3, AoSettingsDao r4, AoSettings$mSettingsUpdater$2.a r5) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "mBdpAppId");
        Intrinsics.checkNotNullParameter(r4, "mBdpSettingsDao");
        Intrinsics.checkNotNullParameter(r5, "mUpdateCallback");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = "AoAppSettingsUpdater_" + r3;
        this.f = LazyKt.lazy(AoAppSettingsUpdater$mMainSettingsProvider$2.INSTANCE);
        Lazy r6 = LazyKt.lazy(new AoAppSettingsUpdater$mUpdateReceiver$2(this));
        this.g = r6;
    L9:
        th = move-exception;
        AoLogger.c(this.e, new Object[]{"register settings receiver", th});
        AoMonitor.d();
        return;
    L5:
        if (Build.VERSION.SDK_INT < 34) goto L7;
        a(r2, (AoAppSettingsUpdater$mUpdateReceiver$2.AnonymousClass1) r6.getValue(), new IntentFilter("com.bytedance.openaweme.settings.update"));     // Catch: Throwable -> L9
    L12:
        return;
    L7:
        b(r2, (AoAppSettingsUpdater$mUpdateReceiver$2.AnonymousClass1) r6.getValue(), new IntentFilter("com.bytedance.openaweme.settings.update"));     // Catch: Throwable -> L9
        goto L12
    }
}
