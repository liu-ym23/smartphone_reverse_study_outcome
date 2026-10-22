package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.core.cps.CyberProtectionInjector;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECSafeDynamicEventMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSafeDynamicEventMethod extends ECBaseBridgeMethod {
    public final String e;

    public static final class a {
    }

    static {
    }

    public ECSafeDynamicEventMethod() {
        this.e = "getECTrackParam";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        String r12 = r10.optString("event_name");     // Catch: Throwable -> L17
        if (r12 != null) goto L6;
    L9:
        boolean r13 = true;
    L10:
        if (r13 == true) goto L15;
        boolean r14 = CyberProtectionInjector.a;     // Catch: Throwable -> L17
        String r15 = CyberProtectionInjector.c(r12);     // Catch: Throwable -> L17
        if (r15 == null) goto L15;
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L17
        r16.put("code", 0);     // Catch: Throwable -> L17
        r16.put("data", r15);     // Catch: Throwable -> L17
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L17
        r11.onSuccess(r16);     // Catch: Throwable -> L17
        return;
    L15:
        JSONObject r18 = new JSONObject();     // Catch: Throwable -> L17
        r18.put("code", 1);     // Catch: Throwable -> L17
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L17
        r11.onSuccess(r18);     // Catch: Throwable -> L17
        return;
    L6:
        if (StringsKt.isBlank(r12) == true) goto L9;
        r13 = false;
    L17:
        JSONObject r20 = new JSONObject();
        r20.put("code", 1);
        Unit r0 = Unit.INSTANCE;
        r11.onSuccess(r20);
    }
}
