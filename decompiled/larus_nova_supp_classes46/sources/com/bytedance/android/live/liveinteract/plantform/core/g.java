package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g {
    public static void a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "from");
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    public static void b(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "rtcRoomId");
        Intrinsics.checkNotNullParameter(r2, "interactId");
    }

    public static void c(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "rtcRoomId");
        Intrinsics.checkNotNullParameter(r2, "interactId");
    }

    public static void d(dg2.e r1, dg2.e[] r2) {
        Intrinsics.checkNotNullParameter(r1, "localQuality");
        Intrinsics.checkNotNullParameter(r2, "remoteQualities");
    }
}
