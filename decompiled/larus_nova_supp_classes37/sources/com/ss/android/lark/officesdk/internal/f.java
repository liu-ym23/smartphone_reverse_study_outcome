package com.ss.android.lark.officesdk.internal;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.IUserManager;
import com.ss.android.lark.officesdk.api.api.OfficeSDKGlobalApi;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKRuntime;
import com.ss.android.lark.officesdk.api.init.OfficeSDKInitConfig;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponent;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponentManager;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalEntryPoint;
import com.ss.android.lark.officesdk.container.S2OGEntryPoint;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.statistics.Statistics;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.EntryPointAccessors;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f implements com.ss.android.lark.officesdk.internal.a {
    public final AtomicBoolean a;
    public OfficeSDKInitConfig b;
    public OfficeSDKGlobalComponentManager c;
    public OfficeSDKGlobalComponent d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.officesdk.internal.a
    public final IUserManager getUserManager() {
        if (this.a.get() == true) goto L6;
        Log.w("OfficeSDKInternalImpl", "getUserManager: OfficeSDK not initialized");
        return null;
    L6:
        OfficeSDKGlobalComponent r0 = this.d;
        if (r0 != null) goto L9;
        return null;
    L9:
        return ((OfficeSDKGlobalEntryPoint) EntryPoints.get(r0, OfficeSDKGlobalEntryPoint.class)).getUserManager();
    }

    public f() {
        this.a = new AtomicBoolean(false);
    }

    @Override // com.ss.android.lark.officesdk.internal.a
    public final void a(OfficeSDKInitConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "initConfig");
        this.b = r2;
        OfficeSDKManager.setInitConfig$officesdk_core_release(r2);
        Log.i("OfficeSDKInternalImpl", "setInitConfig done");
    }

    @Override // com.ss.android.lark.officesdk.internal.a
    public final void b(IOfficeSDKRuntime r8) {
        Intrinsics.checkNotNullParameter(r8, "runtime");
        boolean r1 = this.a.compareAndSet(false, true);
        if (r1 == true) goto L45;
        Log.i("OfficeSDKInternalImpl", "OfficeSDK already initialized, skip core init but will trigger callback");
    L45:
    L40:
        e = move-exception;
        Log.e("OfficeSDKInternalImpl", "OfficeSDK init failed", e);
        if (r1 == false) goto L46;
        this.a.set(false);
        return;
    L46:
        return;
    L6:
        if (this.b != null) goto L9;
        Log.e("OfficeSDKInternalImpl", "OfficeSDK init failed: initConfig not set");     // Catch: Exception -> L40
        return;
    L9:
        StringBuilder r4 = new StringBuilder("OfficeSDK init start, appName=");     // Catch: Exception -> L40
        OfficeSDKInitConfig r0 = this.b;     // Catch: Exception -> L40
        IOfficeSDKLifeCycle r6 = null;
        if (r0 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("initConfig");     // Catch: Exception -> L40
        r0 = null;
    L13:
        r4.append(r0.getAppName());     // Catch: Exception -> L40
        Log.i("OfficeSDKInternalImpl", r4.toString());     // Catch: Exception -> L40
        if (r1 == false) goto L26;
        OfficeSDKInitConfig r2 = this.b;     // Catch: Exception -> L40
        if (r2 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("initConfig");     // Catch: Exception -> L40
        r2 = null;
    L18:
        OfficeSDKGlobalComponentManager r3 = ((S2OGEntryPoint) EntryPointAccessors.fromApplication(r2.getContext(), S2OGEntryPoint.class)).getOfficeSDKGlobalComponentManager();     // Catch: Exception -> L40
        this.c = r3;     // Catch: Exception -> L40
        if (r3 == null) goto L21;
        OfficeSDKGlobalComponent r5 = (OfficeSDKGlobalComponent) r3.generatedComponent();     // Catch: Exception -> L40
    L22:
        this.d = r5;     // Catch: Exception -> L40
        if (r5 == null) goto L25;
        OfficeSDKManager.setGlobalComponent$officesdk_core_release(r5);     // Catch: Exception -> L40
    L25:
        Log.i("OfficeSDKInternalImpl", "Global component initialized");     // Catch: Exception -> L40
        goto L26
    L21:
        r5 = null;
    L26:
        OfficeSDKGlobalComponent r7 = this.d;     // Catch: Exception -> L40
        if (r7 == null) goto L29;
        OfficeSDKGlobalApi r9 = ((OfficeSDKGlobalEntryPoint) EntryPoints.get(r7, OfficeSDKGlobalEntryPoint.class)).getOfficeSDKGlobalApi();     // Catch: Exception -> L40
    L30:
        if (r9 == null) goto L37;
        Log.i("OfficeSDKInternalImpl", "OfficeSDK init ready");     // Catch: Exception -> L40
        OfficeSDKGlobalComponent r10 = this.d;     // Catch: Exception -> L40
        if (r10 == null) goto L34;
        r6 = ((OfficeSDKGlobalEntryPoint) EntryPoints.get(r10, OfficeSDKGlobalEntryPoint.class)).getOfficeSDKLifeCycle();     // Catch: Exception -> L40
    L34:
        if (r6 == null) goto L36;
        r6.onInitReady(r8, r9);     // Catch: Exception -> L40
    L36:
        OfficeSDKManager.dispatchPendingUserComponentReady$officesdk_core_release();     // Catch: Exception -> L40
        HashMap<String, b> r11 = g.a;     // Catch: Exception -> L40
        Statistics.sendEvent("officesdk_init");     // Catch: Exception -> L40
    L38:
        Log.i("OfficeSDKInternalImpl", "OfficeSDK init success");     // Catch: Exception -> L40
        return;
    L37:
        Log.e("OfficeSDKInternalImpl", "OfficeSDK init failed: globalApi is null");     // Catch: Exception -> L40
        goto L38
    L29:
        r9 = null;
        goto L30
    }
}
