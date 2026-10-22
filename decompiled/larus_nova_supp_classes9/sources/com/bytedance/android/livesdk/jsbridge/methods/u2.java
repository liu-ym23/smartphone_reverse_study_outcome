package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.livesdk.dislike.NotificationSettingBottomDialog;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u2 implements NotificationSettingBottomDialog.b {
    public final /* synthetic */ CallContext a;

    public final void onFailure() {
    }

    public u2(CallContext r1) {
        this.a = r1;
    }

    public final void onSuccess(String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "anchorId");
        JSONObject r4 = new JSONObject();
        r4.put("status", r3);     // Catch: Throwable -> L5
        this.a.b("H5_setLiveNotificationStatus", r4);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Logger.e(th.getMessage());
    }
}
