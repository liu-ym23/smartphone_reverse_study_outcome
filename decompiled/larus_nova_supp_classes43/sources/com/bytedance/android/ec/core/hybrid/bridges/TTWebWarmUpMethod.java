package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.host.api.ttwebview.ITTWebWarmUpService;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/TTWebWarmUpMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TTWebWarmUpMethod extends ECBaseBridgeMethod {
    public final String e;

    public static final class a {
    }

    static {
    }

    public TTWebWarmUpMethod() {
        this.e = "warmUpTTWeb";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        int r1 = ECSdk.a;
        IECHostService r12 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r12 == null) goto L5;
        ITTWebWarmUpService r13 = r12.getITTWebWarmUpService();
    L7:
        if (r13 != null) goto L22;
        r11.onFailed(-1, "service is null");
        return;
    L22:
        int r14 = r10.optInt("mode", 0);     // Catch: Exception -> L18
        if (r14 != 1) goto L13;
        r13.warmUpRenderAsync();     // Catch: Exception -> L18
        r11.onSuccess(new JSONObject());     // Catch: Exception -> L18
    L21:
        return;
    L13:
        if (r14 == 2) goto L15;
        r11.onFailed(-1, "mode " + r14 + " is invalid");     // Catch: Exception -> L18
        goto L21
    L15:
        r13.warmUpRenderAndBrowserOnUI();     // Catch: Exception -> L18
        r11.onSuccess(new JSONObject());     // Catch: Exception -> L18
    L18:
        e = move-exception;
        r11.onFailed(-1, "warmup failed on " + e.getMessage());
        return;
    L5:
        r13 = null;
        goto L7
    }
}
