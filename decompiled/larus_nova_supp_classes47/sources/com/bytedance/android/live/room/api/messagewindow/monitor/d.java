package com.bytedance.android.live.room.api.messagewindow.monitor;

import com.bytedance.android.live.room.api.messagewindow.service.IMiddlewareMsgWindowService;
import jc1.k;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    @JvmStatic
    public static final i a() {
        IMiddlewareMsgWindowService r0 = (IMiddlewareMsgWindowService) k.f(IMiddlewareMsgWindowService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.cardMonitor();
    }

    static {
    }

    @JvmStatic
    public static final f b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "nodeName");
        return new f(r1);
    }
}
