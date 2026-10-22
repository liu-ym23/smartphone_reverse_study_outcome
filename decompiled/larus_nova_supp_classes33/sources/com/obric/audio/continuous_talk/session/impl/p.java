package com.obric.audio.continuous_talk.session.impl;

import com.larus.bmhome.chat.model.repo.ISettingRepoService;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class p {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new o());
    }

    public static ISettingRepoService a() {
        return (ISettingRepoService) a.getValue();
    }

    public static boolean b(Integer r4, Integer r5) {
        if (r4 != null) goto L4;
    L8:
        boolean r0 = false;
    L9:
        FLogger.a.i("ObricContTalkUtils", "isDoraVuiWakeup vuiId=" + r4 + ", wakeupId=" + r5 + ", result=" + r0);
        return r0;
    L4:
        if (r4.intValue() == 0) goto L8;
        if (Intrinsics.areEqual(r4, r5) == true) goto L8;
        r0 = true;
        goto L9
    }
}
