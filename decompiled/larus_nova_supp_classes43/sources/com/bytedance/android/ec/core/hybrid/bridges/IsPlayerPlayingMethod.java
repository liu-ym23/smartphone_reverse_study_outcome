package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/IsPlayerPlayingMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IsPlayerPlayingMethod extends ECBaseBridgeMethod {
    public final String getName() {
        return "mallPlayerIsPlaying";
    }

    public IsPlayerPlayingMethod() {
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        JSONObject r12 = new JSONObject();
        boolean r1 = true;
        r12.put("code", 1);
        boolean r0 = ECServiceManager.a;
        s83.d r13 = ((s83.g) ECServiceManager.c(s83.g.class)).N();
        if (r13 != null) goto L5;
    L7:
        r1 = false;
    L8:
        r12.put("isPlaying", r1);
        Unit r14 = Unit.INSTANCE;
        r11.a(r12);
        return;
    L5:
        if (r13.isPlaying() != true) goto L7;
        goto L7
    }
}
