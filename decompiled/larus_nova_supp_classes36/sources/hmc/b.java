package hmc;

import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWCustomData;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWDownlinkPacket;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWEventData;
import com.ss.ugc.live.sdk.msg.utils.c;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tlc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public f a;
    public final Object b;
    public final UMGWDownlinkPacket c;

    public final String a() {
        UMGWDownlinkPacket r0 = this.c;
        int r1 = c.a;
        if (r0 == null) goto L22;
        UMGWEventData r2 = r0.event_data;
        if (r2 == null) goto L23;
        List<UMGWCustomData> r3 = r2.params;
        if (r3 == null) goto L24;
        Iterator<T> r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        Object r5 = r4.next();
        if (StringsKt.equals("biz_log_id", ((UMGWCustomData) r5).key, true) == false) goto L10;
    L15:
        UMGWCustomData r6 = (UMGWCustomData) r5;
        if (r6 != null) goto L18;
        return null;
    L18:
        return r6.value;
    L14:
        r5 = null;
        goto L15
    L24:
        return null;
    L23:
        return null;
    L22:
        return null;
    }

    public b(Object r2, UMGWDownlinkPacket r3) {
        Intrinsics.checkNotNullParameter(r3, "downlinkPacket");
        this.b = r2;
        this.c = r3;
    }
}
