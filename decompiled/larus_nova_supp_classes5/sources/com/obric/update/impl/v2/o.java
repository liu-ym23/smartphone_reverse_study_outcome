package com.obric.update.impl.v2;

import com.obric.update.impl.v2.gateway.PluginInstallGateway;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class o {
    public final com.obric.update.impl.v2.gateway.f a;
    public final com.obric.update.impl.v2.gateway.b b;
    public final com.obric.update.impl.v2.gateway.a c;
    public final com.obric.update.impl.v2.gateway.c d;
    public final PluginInstallGateway e;
    public final com.obric.update.impl.v2.gateway.d f;

    public o() {
        com.obric.update.impl.v2.gateway.f r0 = new com.obric.update.impl.v2.gateway.f();
        com.obric.update.impl.v2.gateway.b r1 = new com.obric.update.impl.v2.gateway.b();
        com.obric.update.impl.v2.gateway.a r2 = new com.obric.update.impl.v2.gateway.a();
        com.obric.update.impl.v2.gateway.c r3 = new com.obric.update.impl.v2.gateway.c();
        PluginInstallGateway r4 = new PluginInstallGateway();
        com.obric.update.impl.v2.gateway.d r5 = new com.obric.update.impl.v2.gateway.d();
        Intrinsics.checkNotNullParameter(r0, "sdk");
        Intrinsics.checkNotNullParameter(r1, "apkInstall");
        Intrinsics.checkNotNullParameter(r2, "account");
        Intrinsics.checkNotNullParameter(r3, "network");
        Intrinsics.checkNotNullParameter(r4, "plugin");
        Intrinsics.checkNotNullParameter(r5, "setting");
        this.a = r0;
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
    }
}
