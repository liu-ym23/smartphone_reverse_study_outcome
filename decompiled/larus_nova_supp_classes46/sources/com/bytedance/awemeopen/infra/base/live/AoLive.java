package com.bytedance.awemeopen.infra.base.live;

import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import com.bytedance.awemeopen.servicesapi.livepreview.AoLiveService;
import j64.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import n64.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class AoLive {
    public static AoLiveService a;
    public static final Lazy b = null;

    static {
        b = LazyKt.lazy(AoLive$hostService$2.INSTANCE);
    }

    public static boolean b() {
        if (a != null) goto L5;
        a = (AoLiveService) a.a(AoLiveService.class);
    L5:
        AoLiveService r0 = a;
        if (r0 == null) goto L8;
        boolean r1 = r0.supportLive();
    L9:
        if (r1 == true) goto L13;
        AoHostService r2 = (AoHostService) b.getValue();
        if (r2 == null) goto L13;
        r2.J1();
    L13:
        return r1;
    L8:
        r1 = false;
        goto L9
    }

    public static c a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "rawData");
        AoLiveService r2 = a;
        if (r2 == null) goto L7;
        c r3 = r2.F0();
        if (r3 == null) goto L7;
        return r3;
    L7:
        return new c();
    }
}
