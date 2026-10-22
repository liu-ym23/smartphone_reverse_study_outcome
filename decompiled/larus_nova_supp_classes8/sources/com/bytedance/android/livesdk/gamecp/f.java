package com.bytedance.android.livesdk.gamecp;

import com.bytedance.android.livehostapi.platform.IHostAction;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements IHostAction.IMConversationCallback {
    public final /* synthetic */ yv.a.a a;

    public f(com.bytedance.android.gamecp.business.gamedetail.component.fansgroup.c.a r1) {
        this.a = r1;
    }

    public final void onFailure(JSONObject r2) {
        yv.a.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.onFailure(r2);
        return;
    }

    public final void onSuccess(JSONObject r2) {
        yv.a.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.onFailure(r2);
        return;
    }
}
