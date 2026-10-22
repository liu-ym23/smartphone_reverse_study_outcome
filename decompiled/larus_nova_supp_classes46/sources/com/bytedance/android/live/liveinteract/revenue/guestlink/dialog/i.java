package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Observer {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final void onChanged(Object r2) {
        if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L6;
        ALogger.i("GuestLinkMainPageDialogForAudience", "registerPlayerEvent firstFrame");
        return;
    }
}
