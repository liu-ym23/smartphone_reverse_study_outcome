package com.bytedance.android.ec.core.utils;

import com.bytedance.android.ec.host.api.info.IECHostDeviceInfoService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class EComFoldDeviceInfoInjector implements com.bytedance.android.ec.sdk.helper.u {
    public static final Lazy a = null;
    public static final EComFoldDeviceInfoInjector b = null;

    public EComFoldDeviceInfoInjector() {
    }

    static {
        b = new EComFoldDeviceInfoInjector();
        a = LazyKt.lazy(EComFoldDeviceInfoInjector$deviceInfoService$2.INSTANCE);
    }

    public final void a(String r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r11, "params");
        Lazy r12 = a;
        IECHostDeviceInfoService r0 = (IECHostDeviceInfoService) r12.getValue();
        Integer r1 = null;
        if (r0 == null) goto L5;
        Integer r13 = r0.getFoldType();
    L6:
        r11.put("ecom_fold_type", r13);
        IECHostDeviceInfoService r14 = (IECHostDeviceInfoService) r12.getValue();
        if (r14 == null) goto L9;
        r1 = r14.getFoldStatus();
    L9:
        r11.put("ecom_fold_status", r1);
        return;
    L5:
        r13 = null;
        goto L6
    }
}
