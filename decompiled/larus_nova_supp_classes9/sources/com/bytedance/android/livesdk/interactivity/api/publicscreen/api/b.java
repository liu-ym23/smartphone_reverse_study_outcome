package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.AudienceMsgOptPanel")
public final class b extends a implements vh7.h {
    public b(am3.g r5) {
        this.itemList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L9;
        if (r2 != 1) goto L7;
        this.itemList.add(e0.a(r5));
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r0);
        this.itemList.isEmpty();
    }
}
