package com.bytedance.android.ec.core.hybrid.bridges;

import android.content.Context;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ToastMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToastMethod extends ECBaseBridgeMethod {
    public final String e;

    public static final class a {
    }

    static {
    }

    public ToastMethod() {
        this.e = com.bytedance.android.ec.core.event.a.VALUE_SHOW_TOAST;
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        Context r0 = getContext();
        if (r10.has("text") == true) goto L6;
        r11.onFailed(0, "no params found");
        return;
    L6:
        String r12 = r10.optString("text");
        if (r0 == null) goto L9;
        com.bytedance.android.ec.sdk.helper.i.a.e(r0, r12, false, false);
    L9:
        r11.onSuccess(new JSONObject());
    }
}
