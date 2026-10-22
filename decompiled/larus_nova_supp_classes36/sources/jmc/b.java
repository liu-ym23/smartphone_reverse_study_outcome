package jmc;

import com.ss.ugc.live.sdk.msg.network.HttpException;
import com.ss.ugc.live.sdk.msg.network.f;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWDownlinkPacket;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWEventData;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWFetchResponse;
import com.ss.ugc.live.sdk.msg.utils.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends com.ss.ugc.live.sdk.msg.utils.task.a<f, hmc.a> {
    public final kmc.a c;
    public final com.ss.ugc.live.sdk.msg.unify.network.a d;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.ugc.live.sdk.msg.utils.task.a
    public final void c(f r17) {
        f r0 = r17;
        Intrinsics.checkNotNullParameter(r0, "params");
        System.currentTimeMillis();
        g<com.ss.ugc.live.sdk.msg.network.g, Exception> r1 = this.d.a(r0);
        long r2 = 0;
    L19:
        th = th;
        long r4 = 0;
    L22:
        if ((th instanceof Exception) == false) goto L57;
        int r6 = g.a;
        g r7 = g.a.a(th);
    L62:
    L50:
        th = move-exception;
        if ((th instanceof Exception) == false) goto L56;
        int r3 = g.a;
        g r5 = g.a.a(th);
    L54:
        b(r5);
        return;
    L56:
        throw th;
    L25:
        if ((r7 instanceof g.c) == false) goto L46;
        com.ss.ugc.live.sdk.msg.network.g r8 = (com.ss.ugc.live.sdk.msg.network.g) ((g.c) r7).b;     // Catch: Throwable -> L50
        UMGWFetchResponse r9 = (UMGWFetchResponse) r8.e;     // Catch: Throwable -> L50
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L50
        List<UMGWDownlinkPacket> r11 = r9.business_data;     // Catch: Throwable -> L50
        if (r11 == null) goto L44;
        List<UMGWDownlinkPacket> r12 = r11;     // Catch: Throwable -> L50
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));     // Catch: Throwable -> L50
        Iterator<T> r14 = r12.iterator();     // Catch: Throwable -> L50
    L30:
        if (r14.hasNext() == false) goto L44;
        UMGWDownlinkPacket r15 = (UMGWDownlinkPacket) r14.next();     // Catch: Throwable -> L50
        UMGWEventData r16 = r15.event_data;     // Catch: Throwable -> L50
        if (r16 == null) goto L43;
        if (r4 <= r2) goto L36;
        long r18 = r4;
    L60:
        imc.e r19 = this.c.a(r16.token.longValue());     // Catch: Throwable -> L58
        if (r19 == null) goto L41;
        com.ss.ugc.live.sdk.msg.unify.business.d r20 = r19.a(r16, false, r18);     // Catch: Throwable -> L58
    L42:
        hmc.b r21 = new hmc.b(r20, r15);     // Catch: Throwable -> L50
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L50
        r10.add(r21);     // Catch: Throwable -> L50
    L41:
        r20 = null;
        goto L42
    L36:
        r18 = System.currentTimeMillis();     // Catch: Throwable -> L50
    L43:
        r13.add(Unit.INSTANCE);     // Catch: Throwable -> L50
        r2 = 0;
    L44:
        r5 = new g.c(new hmc.a(r8, r9, r10));     // Catch: Throwable -> L50
        goto L54
    L46:
        if ((r7 instanceof g.b) == false) goto L49;
        r5 = new g.b(((g.b) r7).b);     // Catch: Throwable -> L50
        goto L54
    L49:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L50
    L57:
        throw th;
    L4:
        if ((r1 instanceof g.c) == false) goto L14;
        com.ss.ugc.live.sdk.msg.network.g r23 = (com.ss.ugc.live.sdk.msg.network.g) ((g.c) r1).b;     // Catch: Throwable -> L19
        if (r23.a() == false) goto L12;
        r23.e = (UMGWFetchResponse) UMGWFetchResponse.ADAPTER.decode(r23.d);     // Catch: Throwable -> L19
        r4 = System.currentTimeMillis();     // Catch: Throwable -> L19
        int r24 = g.a;     // Catch: Throwable -> L10
        r7 = new g.c(r23);     // Catch: Throwable -> L10
    L10:
        th = th;
        goto L22
    L12:
        int r25 = g.a;     // Catch: Throwable -> L19
        r7 = g.a.a(new HttpException(r23.a, com.ss.ugc.live.sdk.msg.utils.c.c(r23)));     // Catch: Throwable -> L19
    L16:
        r4 = 0;
        goto L62
    L14:
        if ((r1 instanceof g.b) == false) goto L18;
        r7 = new g.b(((g.b) r1).b);     // Catch: Throwable -> L19
        goto L16
    L18:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L19
    }

    public b(com.ss.ugc.live.sdk.msg.unify.b r2, com.ss.ugc.live.sdk.msg.unify.network.a r3) {
        Intrinsics.checkNotNullParameter(r2, "payloadDecodeProvider");
        Intrinsics.checkNotNullParameter(r3, "httpClient");
        super(a.a);
        this.c = r2;
        this.d = r3;
    }
}
