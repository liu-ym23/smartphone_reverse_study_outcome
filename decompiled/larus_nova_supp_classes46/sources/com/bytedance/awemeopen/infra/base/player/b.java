package com.bytedance.awemeopen.infra.base.player;

import com.bytedance.awemeopen.servicesapi.player.AoPlayerService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(d r3) {
        Intrinsics.checkNotNullParameter(r3, "aoPlayerInitConfig");
        int r0 = j64.b.a;
        AoPlayerService r1 = j64.b.a(AoPlayerService.class);
        Intrinsics.checkNotNullParameter(r3.a, "<set-?>");
        Intrinsics.checkNotNullParameter(r3.b, "<set-?>");
        Intrinsics.checkNotNullParameter(r3.c, "<set-?>");
        Intrinsics.checkNotNullParameter(r3.d, "<set-?>");
        r1.L0();
    }
}
