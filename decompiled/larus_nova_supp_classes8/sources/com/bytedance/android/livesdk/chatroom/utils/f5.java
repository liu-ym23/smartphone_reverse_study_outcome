package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.config.mw0;
import com.bytedance.android.livesdk.utils.LiveInflateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f5 {
    public static final int a = 0;

    static {
        a = mw0.a.getValue().intValue();
    }

    public static void a() {
        IHostBusiness r0 = jc1.k.f(IHostBusiness.class);
        if (r0 != null) goto L5;
        return;
    L5:
        Lazy r1 = LiveInflateUtil.a;
        ArrayList r2 = new ArrayList();
        r2.addAll(jc1.k.n(IInteractService.class).getAllNitaInfos(false));
        Iterator r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r0.clearPreloadViews(((zo2.a) r3.next()).getTag(), null);
        goto L7
    }
}
