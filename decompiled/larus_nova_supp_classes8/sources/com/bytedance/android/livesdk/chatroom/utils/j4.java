package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.config.ct0;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j4 {
    @JvmStatic
    public static final boolean a() {
        if (ct0.a.getValue().booleanValue() == false) goto L16;
        VSDataContext.Companion.getClass();
        VSDataContext r0 = VSDataContext.a.a();
        if (r0 == null) goto L7;
        boolean r1 = ((Boolean) r0.isVSVideo().getValue()).booleanValue();
    L13:
        if (r1 == true) goto L17;
        return true;
    L17:
        return false;
    L7:
        nm1.b r2 = (nm1.b) pm1.h.d.c(nm1.b.class);
        ReplayDataContext r3 = null;
        if (r2 == null) goto L10;
        r3 = r2.d(null);
    L10:
        if (r3 == null) goto L12;
        r1 = true;
        goto L13
    L12:
        r1 = false;
        goto L13
    L16:
        return false;
    }

    static {
    }
}
