package com.larus.voicecall.impl.util;

import com.larus.common.apphost.AppHost;
import com.larus.im.internal.audio.u;
import com.larus.im.internal.d;
import com.larus.im.internal.utils.x;
import com.larus.platform.api.IAudioAutoTestPlatform;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import gd9.o;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q0 {
    public static final void a() {
        AppHost.Companion r0 = AppHost.a;
        if (r0.isTestChannel() == false) goto L5;
    L8:
        String r1 = new SimpleDateFormat("yyyy_MMdd_HH_mm_ss").format(new Date());
        IAudioAutoTestPlatform r2 = (IAudioAutoTestPlatform) ServiceManager.get().getService(IAudioAutoTestPlatform.class);
        if (r2 == null) goto L11;
        Intrinsics.checkNotNull(r1);
        r2.a();
    L11:
        int r3 = com.larus.im.a.a;
        o r4 = d.a;
        u.c.getClass();
        x r5 = x.a;
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNullParameter(r1, "timestamp");
        x.b = r1;
        FLogger.a.d("RealtimeCall", "setCurrentEnterRoomTimestamp: " + r1);
        return;
    L5:
        if (Intrinsics.areEqual(r0.getBuildChannel(), "auto_test") == true) goto L8;
        if (c78.a.a == true) goto L8;
    }
}
