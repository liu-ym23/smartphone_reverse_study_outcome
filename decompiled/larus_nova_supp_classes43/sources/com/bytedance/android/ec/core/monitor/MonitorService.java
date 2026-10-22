package com.bytedance.android.ec.core.monitor;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.apt.IECAPTService;
import com.bytedance.android.ec.core.vmsdk.JsWorkerWrapper;
import com.bytedance.android.ec.core.vmsdk.VmSdkSetting;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class MonitorService implements o {
    public static final WeakHashMap<Context, Unit> a = null;

    public static final class a {
    }

    public MonitorService() {
    }

    static {
        a = new WeakHashMap();
    }

    @Override // com.bytedance.android.ec.core.monitor.o
    public final void b(Context r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter("live", "moduleName");
        Intrinsics.checkNotNullParameter("live", "scriptMethod");
        Intrinsics.checkNotNullParameter(r11, "params");
        c(r10, "live", "live", r11, r12, VmSdkSetting.a().g());
    }

    @Override // com.bytedance.android.ec.core.monitor.o
    public final void a(Context r10, String r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "scene");
        Intrinsics.checkNotNullParameter(r12, "params");
        c(r10, r11, r11, r12, r13, r14);
    }

    @Override // com.bytedance.android.ec.core.monitor.o
    public final void c(Context r10, String r11, String r12, String r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "scene");
        Intrinsics.checkNotNullParameter(r12, "scriptMethod");
        Intrinsics.checkNotNullParameter(r13, "params");
        if (ECAppInfoService.e.isLocalTest() == false) goto L5;
    L6:
        ih.a.d.getClass();
        AtomicBoolean r0 = ih.a.c;
        if (r0.compareAndSet(false, true) == false) goto L13;
        int r16 = ECSdk.a;
        IECAPTService r17 = (IECAPTService) ECSdk.a(IECAPTService.class);
        if (r17 == null) goto L11;
        r17.registerPlugin(ih.a.b);
        goto L13
    L11:
        r0.set(false);
    L13:
        if (r11.length() != 0) goto L15;
        boolean r1 = true;
    L16:
        if (r1 == false) goto L19;
        return;
    L19:
        if (r15 != null) goto L21;
        r15 = VmSdkSetting.a().g();
    L21:
        if (r15 == null) goto L41;
        int r18 = ECSdk.a;
        com.bytedance.android.ec.core.vmsdk.a r19 = (com.bytedance.android.ec.core.vmsdk.a) ECSdk.a(com.bytedance.android.ec.core.vmsdk.a.class);
        if (r19 == null) goto L41;
        JsWorkerWrapper r110 = r19.b(r10, new com.bytedance.android.ec.core.vmsdk.b(r15, r11, false, 508));
        if (r110 == null) goto L41;
        Intrinsics.checkNotNullParameter("__MonitorJsStartTime__ = new Date().getTime();", "script");
        if (r110.d("script", "__MonitorJsStartTime__ = new Date().getTime();") == true) goto L30;
        r110.a("__MonitorJsStartTime__ = new Date().getTime();");
    L30:
        String r20 = "app." + r12;
        String[] r21 = new String[2];
        r21[0] = r13;
        if (cg4.a.a(r14) == true) goto L34;
        r14 = null;
    L34:
        if (r14 != null) goto L36;
        r14 = "";
    L36:
        r21[1] = r14;
        r110.b(r20, r21);
        String r22 = "app.sendLogV3('livesdk_check_param_time', {duration: (new Date().getTime()) - __MonitorJsStartTime__, scene: '" + r11 + "', action: 1})";
        Intrinsics.checkNotNullParameter(r22, "script");
        if (r110.d("script", r22) == true) goto L41;
        r110.a(r22);
    L41:
        if (a.containsKey(r10) == true) goto L48;
        Looper r23 = Looper.getMainLooper();
        MonitorService$monitorParams$runnable$1 r24 = new MonitorService$monitorParams$runnable$1(r10);
        if ((!Intrinsics.areEqual(r23, Looper.myLooper())) == false) goto L45;
        new Handler(r23).post(r24);
        return;
    L45:
        r24.run();
        return;
    L48:
        return;
    L15:
        r1 = false;
        goto L16
    L5:
        if (ECSettingKeys.l() == true) goto L6;
    }
}
