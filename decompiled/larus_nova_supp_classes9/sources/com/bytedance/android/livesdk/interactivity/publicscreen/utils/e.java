package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e {
    public int a;

    public static final class a {
    }

    static {
    }

    public e() {
    }

    public final boolean a(PSFirstMessageType r2) {
        Intrinsics.checkNotNullParameter(r2, "messageType");
        int r0 = this.a;
        if ((r2.getStatusCode() & r0) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void b(PSFirstMessageType r3) {
        Intrinsics.checkNotNullParameter(r3, "messageType");
        if (this.a != 0) goto L5;
        ALogger.i("PS_FIRST_MESSAGE", "first message type: " + r3.name());
    L5:
        this.a = r3.getStatusCode() | this.a;
    }
}
