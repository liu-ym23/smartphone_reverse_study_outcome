package com.larus.vesdk.impl;

import android.app.Application;
import com.bef.effectsdk.ResourceFinder;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.c4;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.effectmanager.DownloadableModelConfig;
import com.ss.android.ugc.effectmanager.DownloadableModelSupport;
import com.ss.android.vesdk.VESDK;
import com.ss.ugc.effectplatform.algorithm.AlgorithmModelResourceFinder;
import com.ss.ugc.effectplatform.algorithm.AlgorithmResourceManager;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    public static final class a implements ResourceFinder {
        public final /* synthetic */ AlgorithmModelResourceFinder a;

        public final void release(long r1) {
        }

        public a(AlgorithmModelResourceFinder r1) {
            this.a = r1;
        }

        public final long createNativeResourceFinder(long r1) {
            return this.a.getNativeResourceFinder();
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.vesdk.impl.a, java.lang.Object] */
    public static void a(final Integer r11) {
        VeSDKInitStateManager r1 = VeSDKInitStateManager.a;
        ?? r2 = new com.larus.vesdk.impl.a(r11);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "initBlock");
        if (((Boolean) VeSDKInitStateManager.f.getValue()).booleanValue() == false) goto L22;
        AtomicReference<VeSDKInitStateManager.InitState> r12 = VeSDKInitStateManager.c;
        VeSDKInitStateManager.InitState r6 = r12.get();
        if (r6 != VeSDKInitStateManager.InitState.UNINITIALIZED) goto L7;
    L9:
        VeSDKInitStateManager.InitState r7 = VeSDKInitStateManager.InitState.INITIALIZING;
    L11:
        if (r12.compareAndSet(r6, r7) == true) goto L12;
        if (r12.get() == r6) goto L11;
        boolean r13 = false;
    L16:
        if (r13 == true) goto L19;
    L18:
        r6 = null;
    L19:
        if (r6 != null) goto L33;
        FLogger.a.e("VeSDKInitStateManager", "checkInit has been called, current state=" + VeSDKInitStateManager.c.get());
        return;
    L33:
        VeSDKInitStateManager.b.set(true);
        long r8 = System.currentTimeMillis();
        r2.invoke();     // Catch: Exception -> L36
        VeSDKInitStateManager.b(System.currentTimeMillis() - r8, true, null, "sync");     // Catch: Exception -> L36
        VeSDKInitStateManager.a();     // Catch: Exception -> L36
        return;
    L36:
        e = move-exception;
        VeSDKInitStateManager.b(System.currentTimeMillis() - r8, false, e.getMessage(), "sync");
        if (r6 == null) goto L55;
        AtomicReference<VeSDKInitStateManager.InitState> r14 = VeSDKInitStateManager.c;
        VeSDKInitStateManager.InitState r0 = VeSDKInitStateManager.InitState.INITIALIZING;
    L41:
        if (r14.compareAndSet(r0, r6) == true) goto L57;
        if (r14.get() == r0) goto L41;
        return;
    L57:
        return;
    L55:
        return;
    L12:
        r13 = true;
        goto L16
    L7:
        if (r6 == VeSDKInitStateManager.InitState.TIMEOUT) goto L9;
    L22:
        if (VeSDKInitStateManager.b.getAndSet(true) == false) goto L32;
        VeSDKInitStateManager.InitState r15 = VeSDKInitStateManager.c.get();
        if (r15 != VeSDKInitStateManager.InitState.UNINITIALIZED) goto L26;
    L29:
        boolean r16 = true;
    L30:
        if (r16 == true) goto L32;
        FLogger.a.e("VeSDKInitStateManager", "checkInit has been called");
        return;
    L26:
        if (r15 == VeSDKInitStateManager.InitState.TIMEOUT) goto L29;
        r16 = false;
    L32:
        r6 = null;
        goto L33
    }

    public static void b(Integer r7) {
        long r0 = System.currentTimeMillis();
        FLogger r2 = FLogger.a;
        r2.i("VeSDKHelper", "init ve sdk start");
        AppHost.Companion r4 = AppHost.a;
        boolean r5 = r4.isDebug();
        VESDK.registerLogger(new f(r5), r5);
        if (r5 == false) goto L6;
    L13:
        byte r8 = 31;
    L36:
        VESDK.setLogLevel(r8);
        VESDK.setApplogReportToBusiness(true);
        VESDK.applogRegister(new c());
        VESDK.setSDKMonitorEnable(false);
        Application r9 = r4.getApplication();
        c4.a.getClass();
        VESDK.init(r9, c4.a.a());
        if (AlgorithmResourceManager.Companion.isInitialized() == false) goto L44;
    L42:
        VESDK.setEffectResourceFinder(new a(AlgorithmResourceManager.Companion.getInstance().getResourceFinder()));
        long r6 = System.currentTimeMillis() - r0;
        FLogger.a.i("VeSDKHelper", "init ve sdk, costTime:" + r6);
        return;
    L44:
        DownloadableModelConfig.ModelFileEnv r10 = com.larus.vesdk.impl.effectplatform.f.a;     // Catch: IllegalStateException -> L40
        DownloadableModelSupport.initialize((DownloadableModelConfig) com.larus.vesdk.impl.effectplatform.f.f.getValue());     // Catch: IllegalStateException -> L40
    L40:
        e = move-exception;
        System.out.println("VeSDKHelper: AlgorithmResourceManager already initialized, ignore: " + e);
        goto L42
    L6:
        if (z2.a.enableVeCameraLogOpt() == false) goto L9;
        if (r7 != null) goto L9;
        r2.i("VeSDKHelper", "enableVeCameraLogOpt is true, log level is info");
    L23:
        r8 = 7;
    L9:
        if (r7 != null) goto L12;
    L14:
        if (r7 != null) goto L17;
    L19:
        if (r7 == null) goto L25;
        if (r7.intValue() == 2) goto L23;
    L25:
        if (r7 != null) goto L28;
    L30:
        if (r7 != null) goto L33;
    L35:
        r8 = 3;
        goto L36
    L33:
        if (r7.intValue() != 4) goto L35;
        r8 = 1;
        goto L36
    L28:
        if (r7.intValue() != 3) goto L30;
    L17:
        if (r7.intValue() != 1) goto L19;
        r8 = 15;
        goto L36
    L12:
        if (r7.intValue() != 0) goto L14;
        goto L13
    }
}
