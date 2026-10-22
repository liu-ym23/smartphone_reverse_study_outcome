package com.bytedance.android.livesdk.interactivity.api.quickcomment;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements am3.c<g> {
    public h() {
    }

    public final Object decode(am3.g r6) throws Exception {
        g r0 = new g();
        r0.supportComments = new ArrayList();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L13;
        switch(r3) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        r0.fastChatSwitch = am3.h.a(r6);
        goto L3
    L8:
        r0.backgroundColor = am3.h.c(r6);
        goto L3
    L9:
        r0.commentTips = am3.h.c(r6);
        goto L3
    L10:
        r0.supportComments.add(am3.h.c(r6));
        goto L3
    L11:
        r0.fixCommentToast = am3.h.c(r6);
        goto L3
    L12:
        r0.commentType = r6.i();
        goto L3
    L6:
        am3.h.e(r6);
        goto L3
    L13:
        r6.d(r1);
        return r0;
    }
}
