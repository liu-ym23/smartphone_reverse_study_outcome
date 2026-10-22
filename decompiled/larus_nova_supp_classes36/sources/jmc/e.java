package jmc;

import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWDownlinkPacket;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWEventData;
import com.ss.ugc.live.sdk.msg.utils.g;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import tlc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e extends com.ss.ugc.live.sdk.msg.utils.task.a<f, hmc.b> {
    public final kmc.a c;

    public e(com.ss.ugc.live.sdk.msg.unify.b r2) {
        Intrinsics.checkNotNullParameter(r2, "payloadDecodeProvider");
        super(d.a);
        this.c = r2;
    }

    @Override // com.ss.ugc.live.sdk.msg.utils.task.a
    public final void c(f r9) {
        f r10 = r9;
        Intrinsics.checkNotNullParameter(r10, "params");
        long r0 = System.currentTimeMillis();
        UMGWDownlinkPacket r2 = (UMGWDownlinkPacket) UMGWDownlinkPacket.ADAPTER.decode(r10.e);
        UMGWEventData r3 = r2.event_data;
        com.ss.ugc.live.sdk.msg.unify.business.d r4 = null;
        if (r3 == null) goto L5;
        ByteString r5 = r3.payload;
    L6:
        if (r5 != null) goto L8;
    L12:
        hmc.b r1 = new hmc.b(r4, r2);
        r1.a = r10;
        int r11 = g.a;
        b(new g.c(r1));
        return;
    L8:
        if (r3.payload.size() <= 0) goto L12;
        imc.e r6 = this.c.a(r3.token.longValue());
        if (r6 == null) goto L12;
        r4 = r6.a(r3, true, r0);
        goto L12
    L5:
        r5 = null;
        goto L6
    }
}
