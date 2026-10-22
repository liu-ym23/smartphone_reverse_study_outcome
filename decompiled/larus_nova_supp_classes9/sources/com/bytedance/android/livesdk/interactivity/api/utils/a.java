package com.bytedance.android.livesdk.interactivity.api.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final boolean a(IBaseUser r1) {
        o0.a r0 = o0.a;
        if (r1 == null) goto L5;
        String r2 = r1.getIdString();
    L6:
        r0.getClass();
        return o0.a.b(r2);
    L5:
        r2 = null;
        goto L6
    }
}
