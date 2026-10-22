package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s<T> implements Consumer {
    public static final s a = null;

    static {
        a = new s();
    }

    public s() {
    }

    public final void accept(Object r7) {
        com.bytedance.android.livesdk.gift.platform.core.b0 r0 = com.bytedance.android.livesdk.gift.platform.core.b0.a;
        String r8 = ((Throwable) r7).getMessage();
        if (r8 != null) goto L5;
        r8 = "response is empty";
    L5:
        JSONObject r1 = new JSONObject();
        j01.d.b(r1, "error_msg", r8);
        com.bytedance.android.livesdk.gift.platform.core.b0.c(r0, com.bytedance.android.livesdk.gift.platform.core.utils.z.b("ttlive_group_live_list_sync_failed"), r1, 1);
        j01.d.b(r1, "duration", 0L);
        com.bytedance.android.livesdk.gift.platform.core.b0.c(r0, com.bytedance.android.livesdk.gift.platform.core.utils.z.a("ttlive_group_live_list_sync_failed"), r1, 1);
    }
}
