package com.ss.ugc.live.sdk.msg.unify;

import com.ss.android.lark.lynxkit.xbridge.XBridgeLynxModule;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWUplinkPacket;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k {
    public long a;
    public final UMGWUplinkPacket b;
    public final Runnable c;

    public k(UMGWUplinkPacket r2, c r3, h r4) {
        Intrinsics.checkNotNullParameter(r2, "uplinkPacket");
        Intrinsics.checkNotNullParameter(r3, XBridgeLynxModule.NAME);
        this.b = r2;
        this.c = r4;
    }
}
