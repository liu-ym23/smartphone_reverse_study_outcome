package com.bytedance.ai.bridge.method.authorize;

import com.byted.mgl.merge.service.api.share.BdpShareBaseInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final a a = null;
    public static final Map<String, UUID> b = null;

    public a() {
    }

    static {
        a = new a();
        b = new LinkedHashMap();
    }

    public final synchronized boolean a(String r10, UUID r11) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "appletId");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r11, BdpShareBaseInfo.CHANNEL_TOKEN);     // Catch: Throwable -> L12
        Map<String, UUID> r0 = b;     // Catch: Throwable -> L12
        if (Intrinsics.areEqual(((LinkedHashMap) r0).get(r10), r11) == true) goto L8;
        monitor-exit(this);
        return false;
    L8:
        r0.remove(r10);     // Catch: Throwable -> L12
        monitor-exit(this);
        return true;
    L12:
        th = move-exception;
        throw th;
    }
}
