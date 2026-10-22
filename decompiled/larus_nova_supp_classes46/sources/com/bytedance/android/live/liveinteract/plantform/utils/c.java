package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.core.log.ALogger;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements q {
    public final com.bytedance.android.live.pushstream.d a;

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.q
    public final void onClose() {
    }

    public c(com.bytedance.android.live.pushstream.d r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.q
    public final void a(String r9, JSONObject r10) {
        if (this.a != null) goto L5;
        ALogger.e("SeiStreamInfoSender", "livestream is null");
    L5:
        com.bytedance.android.live.pushstream.d r2 = this.a;
        if (r2 == null) goto L9;
        r2.c1(r9, r10, 1, false, false);
        return;
    }
}
