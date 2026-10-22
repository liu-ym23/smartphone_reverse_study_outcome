package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p<T> implements Observer {
    public final /* synthetic */ GuestLinkMainPageDialogForAudience a;

    public p(GuestLinkMainPageDialogForAudience r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        String r4 = (String) r3;
        if (r4 == null) goto L12;
        GuestLinkMainPageDialogForAudience r0 = this.a;
        int r1 = GuestLinkMainPageDialogForAudience.S;
        r0.getClass();
        LiveSeiUtil.i.getClass();     // Catch: Exception -> L7
        String r5 = JSONObjectProtectorUtils.getString(LiveSeiUtil.c(r4), "infos");     // Catch: Exception -> L7
        Gson r2 = com.bytedance.android.annie.api.data.subscribe.d.a;     // Catch: Exception -> L7
        r0.ga0((ArrayList) com.bytedance.android.annie.api.data.subscribe.d.a(r5, new ArrayList().getClass()));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        ALogger.e("GuestLinkMainPageDialogForAudience", "onSeiUpdate error: " + e.getMessage());
        return;
    }
}
