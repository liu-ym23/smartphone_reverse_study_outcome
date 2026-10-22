package com.bytedance.android.ec.core.debug;

import android.content.Context;
import cl.b;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.abtest.d;
import com.bytedance.android.ec.core.address.t;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.o;
import com.bytedance.android.ec.core.vmsdk.JsWorkerWrapper;
import com.bytedance.android.ec.core.vmsdk.VmSdkSetting;
import com.bytedance.android.ec.sdk.ECSdk;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016JC\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u001a\"\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/core/debug/ECCoreDebugService;", "Lcl/b;", "", "getSettingClassName", "getExperimentsClassName", "Landroid/content/Context;", "context", "scene", "params", "contextProvider", "scriptPath", "", "monitor", "", "getVmSdkResourcesConfig", "key", "subscriber", "registerJsEventSubscriber", "unregisterJsEventSubscriber", a.KEY_SCHEMA, "openSchema", "Lcl/a;", "getAddressSDKProxy", "script", "workerName", "funcName", "", "executeJsFunction", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCoreDebugService implements b {
    public ECCoreDebugService() {
    }

    public String getExperimentsClassName() {
        return d.class.getCanonicalName();
    }

    public String getSettingClassName() {
        return ECSettingKeys.class.getCanonicalName();
    }

    public Object getVmSdkResourcesConfig() {
        return VmSdkSetting.a();
    }

    public cl.a getAddressSDKProxy() {
        return t.a;
    }

    public void openSchema(Context r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, a.KEY_SCHEMA);
        ECLiveHybridUtil.k(r10, r11, false, false, false, null, 252);
    }

    public void registerJsEventSubscriber(String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "subscriber");
        if ((r11 instanceof j) == true) goto L5;
        r11 = null;
    L5:
        j r12 = (j) r11;
        if (r12 == null) goto L9;
        ECLiveHybridUtil.m(r10, r12);
        return;
    }

    public void unregisterJsEventSubscriber(String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "subscriber");
        if ((r11 instanceof j) == true) goto L5;
        r11 = null;
    L5:
        j r12 = (j) r11;
        if (r12 == null) goto L9;
        ECLiveHybridUtil.p(r10, r12);
        return;
    }

    public void executeJsFunction(Context r10, String r11, String r12, String r13, String... r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "script");
        Intrinsics.checkNotNullParameter(r12, "workerName");
        Intrinsics.checkNotNullParameter(r13, "funcName");
        Intrinsics.checkNotNullParameter(r14, "params");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        int r1 = ECSdk.a;     // Catch: Throwable -> L11
        com.bytedance.android.ec.core.vmsdk.a r15 = (com.bytedance.android.ec.core.vmsdk.a) ECSdk.a(com.bytedance.android.ec.core.vmsdk.a.class);     // Catch: Throwable -> L11
        if (r15 == null) goto L8;
        JsWorkerWrapper r16 = r15.b(r10, new com.bytedance.android.ec.core.vmsdk.b(r11, r12, false, 508));     // Catch: Throwable -> L11
        if (r16 == null) goto L8;
        r16.b(r13, (String[]) Arrays.copyOf(r14, r14.length));     // Catch: Throwable -> L11
    L9:
        Result.constructor-impl(r16);     // Catch: Throwable -> L11
        return;
    L8:
        r16 = null;
    L11:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public void monitor(Context r10, String r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "scene");
        Intrinsics.checkNotNullParameter(r12, "params");
        int r0 = ECSdk.a;
        o r1 = (o) ECSdk.a(o.class);
        if (r1 == null) goto L6;
        r1.a(r10, r11, r12, r13, r14);
        return;
    }
}
