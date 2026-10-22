package com.bytedance.awemeopen.infra.base.player;

import com.bytedance.awemeopen.infra.base.debug.AoDebug;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public d() {
        AoDebug.b();
        String r0 = AoEnv.b();
        String r1 = AoEnv.a().getHostAppName();
        String r2 = AoEnv.f();
        Intrinsics.checkNotNullParameter(r0, "appChannel");
        Intrinsics.checkNotNullParameter(r1, "appName");
        Intrinsics.checkNotNullParameter(r2, "appVersion");
        Intrinsics.checkNotNullParameter("", "ttSDKLicensePath");
        this.a = r0;
        this.b = r1;
        this.c = r2;
        this.d = "";
    }
}
