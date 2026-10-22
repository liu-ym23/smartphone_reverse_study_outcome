package com.bytedance.android.livesdk.interactivity.api.publicscreen.model;

import am3.h;
import com.bytedance.android.livesdk.chatroom.model.n;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements am3.c<b> {
    public g() {
    }

    public final Object decode(am3.g r6) throws Exception {
        b r0 = new b();
        r0.messages = new ArrayList();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L9;
        if (r3 != 1) goto L7;
        r0.messages.add(new n(r6));
        goto L3
    L7:
        h.e(r6);
        goto L3
    L9:
        r6.d(r1);
        return r0;
    }
}
