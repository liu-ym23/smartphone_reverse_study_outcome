package com.larus.xbridge.custom;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.larus.camera.api.IFlowCamera;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class x0 extends XCoreBridgeMethod {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "biz.util.scan";
    }

    public x0() {
    }

    public final void f(final XBridgeMethod.Callback r6) {
        g66.c r0 = getContextProviderFactory();
        final FragmentActivity r1 = null;
        if (r0 == null) goto L5;
        Context r2 = (Context) r0.c(Context.class);
    L6:
        if (r2 == null) goto L9;
        Activity r3 = com.bytedance.ies.xbridge.utils.f.a.getActivity(r2);
        if (r3 == null) goto L9;
    L11:
        if ((r3 instanceof FragmentActivity) == false) goto L13;
        r1 = (FragmentActivity) r3;
    L13:
        if (r1 != null) goto L15;
    L38:
        e(r6, "activity unavailable");
        return;
    L15:
        if (r1.isFinishing() == false) goto L17;
    L19:
        boolean r4 = false;
    L20:
        if (r4 == false) goto L38;
        final IFlowCamera r5 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r5 != null) goto L27;
        e(r6, "camera service unavailable");
        return;
    L27:
        if (r5.s(true, new u0(this, r6), new v0(this, r6)) == true) goto L40;
        e(r6, "scanCode is running");
        return;
    L40:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L32
        r1.runOnUiThread(new w0(this, r1, r5));     // Catch: Throwable -> L32
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L32
    L34:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L42;
        FLogger.a.e("BizUtilScanMethod", "dispatch scan failed", r9);
        r5.h("scanCode failed");
        return;
    L42:
        return;
    L32:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    L17:
        if (r1.isDestroyed() == true) goto L19;
        r4 = true;
    L9:
        r3 = AppHost.a.a().getCurrentActivity();
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public final void e(XBridgeMethod.Callback r8, String r9) {
        XCoreBridgeMethod.onFailure$default(this, r8, 0, r9, null, 8, null);
    }

    public final void handle(XReadableMap r3, XBridgeMethod.Callback r4, XBridgePlatformType r5) {
        Intrinsics.checkNotNullParameter(r3, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "type");
        FLogger.a.i("BizUtilScanMethod", "handle scan request, platform=" + r5);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L5
        f(r4);     // Catch: Throwable -> L5
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L16;
        FLogger.a.e("BizUtilScanMethod", "scan request failed", r8);
        String r9 = r8.getMessage();
        if (r9 != null) goto L12;
        r9 = "scanCode failed";
    L12:
        e(r4, r9);
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
