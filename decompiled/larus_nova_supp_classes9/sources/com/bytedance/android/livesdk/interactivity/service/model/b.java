package com.bytedance.android.livesdk.interactivity.service.model;

import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static final boolean a(IRoomAuthStatus r4) {
        if (r4 == null) goto L7;
        c r5 = (c) r4.castToOrNull(c.class);
        if (r5 == null) goto L7;
        long r2 = r5.getEnableAudioComment();
    L9:
        if (r2 != 2) goto L11;
        return true;
    L11:
        return false;
    L7:
        r2 = 2;
        goto L9
    }

    public static final boolean b(IRoomAuthStatus r4) {
        if (r4 == null) goto L6;
        c r5 = (c) r4.castToOrNull(c.class);
        if (r5 == null) goto L6;
        long r0 = r5.getFixedChat();
    L8:
        if (r0 != 1) goto L10;
        return true;
    L10:
        return false;
    L6:
        r0 = 0;
        goto L8
    }
}
