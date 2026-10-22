package com.ss.ugc.live.sdk.msg.unify;

import com.ss.android.lark.lynxkit.xbridge.XBridgeLynxModule;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWUplinkPacket;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l {
    public final LinkedHashMap<Long, k> a;

    public l() {
        this.a = new LinkedHashMap();
    }

    public final void a(UMGWUplinkPacket r4, c r5, h r6) {
        Intrinsics.checkNotNullParameter(r4, "uplinkPacket");
        Intrinsics.checkNotNullParameter(r5, XBridgeLynxModule.NAME);
        LinkedHashMap<Long, k> r0 = this.a;
        Long r1 = r4.unique_id;
        k r2 = new k(r4, r5, r6);
        r2.a = System.currentTimeMillis();
        Unit r7 = Unit.INSTANCE;
        r0.put(r1, r2);
    }
}
