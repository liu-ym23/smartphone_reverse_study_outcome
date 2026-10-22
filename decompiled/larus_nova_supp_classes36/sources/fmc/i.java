package fmc;

import com.ss.ugc.live.sdk.msg.data.SdkMessage;
import com.ss.ugc.live.sdk.msg.data.SdkResponse;
import com.ss.ugc.live.sdk.msg.network.HttpException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i extends com.ss.ugc.live.sdk.msg.utils.task.a<com.ss.ugc.live.sdk.msg.network.f, com.ss.ugc.live.sdk.msg.data.a> {
    public final com.ss.ugc.live.sdk.msg.network.i c;
    public final com.ss.ugc.live.sdk.msg.dispatch.f d;
    public final boolean e;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.ugc.live.sdk.msg.utils.task.a
    public final void c(com.ss.ugc.live.sdk.msg.network.f r19) {
        com.ss.ugc.live.sdk.msg.network.f r0 = r19;
        Intrinsics.checkNotNullParameter(r0, "params");
        long r2 = System.currentTimeMillis();
        com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, Exception> r1 = this.c.a(r0);
    L14:
        th = move-exception;
        if ((th instanceof Exception) == false) goto L64;
        int r4 = com.ss.ugc.live.sdk.msg.utils.g.a;
        com.ss.ugc.live.sdk.msg.utils.g r5 = com.ss.ugc.live.sdk.msg.utils.g.a.a(th);
    L66:
    L57:
        th = move-exception;
        if ((th instanceof Exception) == false) goto L63;
        int r3 = com.ss.ugc.live.sdk.msg.utils.g.a;
        com.ss.ugc.live.sdk.msg.utils.g r6 = com.ss.ugc.live.sdk.msg.utils.g.a.a(th);
    L61:
        b(r6);
        return;
    L63:
        throw th;
    L19:
        if ((r5 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L53;
        Pair r7 = (Pair) ((com.ss.ugc.live.sdk.msg.utils.g.c) r5).b;     // Catch: Throwable -> L57
        long r8 = System.currentTimeMillis();     // Catch: Throwable -> L57
        com.ss.ugc.live.sdk.msg.network.g r9 = (com.ss.ugc.live.sdk.msg.network.g) r7.getFirst();     // Catch: Throwable -> L57
        SdkResponse r10 = (SdkResponse) r7.getSecond();     // Catch: Throwable -> L57
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L57
        List<SdkMessage> r12 = r10.messages;     // Catch: Throwable -> L57
        boolean r13 = true;
        if (r12 != null) goto L23;
    L26:
        boolean r14 = true;
    L27:
        if (r14 == true) goto L51;
        long r15 = System.currentTimeMillis();     // Catch: Throwable -> L57
        Iterator<T> r16 = r10.messages.iterator();     // Catch: Throwable -> L57
    L30:
        if (r16.hasNext() == false) goto L47;
        SdkMessage r17 = (SdkMessage) r16.next();     // Catch: Throwable -> L57
        Long r18 = r10.now;     // Catch: Throwable -> L57
        if (r18 == null) goto L34;
        long r110 = r18.longValue();     // Catch: Throwable -> L57
    L35:
        Long r111 = com.ss.ugc.live.sdk.msg.utils.c.e(r9.c);     // Catch: Throwable -> L57
        if (r111 == null) goto L38;
        r110 = r111.longValue();     // Catch: Throwable -> L57
    L38:
        r17.timestamp = r110;     // Catch: Throwable -> L57
        r17.fromHttp = r13;     // Catch: Throwable -> L57
        tlc.d r112 = this.d.a(r17);     // Catch: Throwable -> L57
        if (r112 == null) goto L45;
        r112.setMessageMethod(r17.method);     // Catch: Throwable -> L57
        r112.setHttpSendTime(r2);     // Catch: Throwable -> L57
        r112.setReceiveTime(r8);     // Catch: Throwable -> L57
        r112.setIsFromFirstRequest(this.e);     // Catch: Throwable -> L57
        if ((r112 instanceof xlc.b) == false) goto L44;
        ((xlc.b) r112).setWRDSMessage(r17.need_wrds_store.booleanValue());     // Catch: Throwable -> L57
        ((xlc.b) r112).setWRDSVersion(r17.wrds_version.longValue());     // Catch: Throwable -> L57
        ((xlc.b) r112).setWRDSSubKey(r17.wrds_sub_key);     // Catch: Throwable -> L57
    L44:
        r11.add(r112);     // Catch: Throwable -> L57
    L46:
        r15 = r15;
        r13 = true;
        goto L30
    L45:
        r15 = r15;
        goto L46
    L34:
        r110 = System.currentTimeMillis();     // Catch: Throwable -> L57
        goto L35
    L47:
        long r113 = r15;
        long r20 = System.currentTimeMillis();     // Catch: Throwable -> L57
        Iterator r21 = r11.iterator();     // Catch: Throwable -> L57
    L49:
        if (r21.hasNext() == false) goto L51;
        tlc.d r22 = (tlc.d) r21.next();     // Catch: Throwable -> L57
        long r23 = r113;
        r22.setDecodeStartTime(r23);     // Catch: Throwable -> L57
        r22.setDecodeEndTime(r20);     // Catch: Throwable -> L57
        r113 = r23;
    L51:
        com.ss.ugc.live.sdk.msg.data.a r24 = new com.ss.ugc.live.sdk.msg.data.a(r10, r11);     // Catch: Throwable -> L57
        r24.a = r9;     // Catch: Throwable -> L57
        r24.c = this.e;     // Catch: Throwable -> L57
        r6 = new com.ss.ugc.live.sdk.msg.utils.g.c(r24);     // Catch: Throwable -> L57
        goto L61
    L23:
        if (r12.isEmpty() == true) goto L26;
        r14 = false;
        goto L27
    L53:
        if ((r5 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L56;
        r6 = new com.ss.ugc.live.sdk.msg.utils.g.b(((com.ss.ugc.live.sdk.msg.utils.g.b) r5).b);     // Catch: Throwable -> L57
        goto L61
    L56:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L57
    L64:
        throw th;
    L4:
        if ((r1 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L10;
        com.ss.ugc.live.sdk.msg.network.g r25 = (com.ss.ugc.live.sdk.msg.network.g) ((com.ss.ugc.live.sdk.msg.utils.g.c) r1).b;     // Catch: Throwable -> L14
        if (r25.a() == false) goto L8;
        SdkResponse r26 = (SdkResponse) SdkResponse.ADAPTER.decode(r25.d);     // Catch: Throwable -> L14
        int r27 = com.ss.ugc.live.sdk.msg.utils.g.a;     // Catch: Throwable -> L14
        r5 = new com.ss.ugc.live.sdk.msg.utils.g.c(TuplesKt.to(r25, r26));     // Catch: Throwable -> L14
        goto L66
    L8:
        int r28 = com.ss.ugc.live.sdk.msg.utils.g.a;     // Catch: Throwable -> L14
        r5 = com.ss.ugc.live.sdk.msg.utils.g.a.a(new HttpException(r25.a, com.ss.ugc.live.sdk.msg.utils.c.c(r25)));     // Catch: Throwable -> L14
        goto L66
    L10:
        if ((r1 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L13;
        r5 = new com.ss.ugc.live.sdk.msg.utils.g.b(((com.ss.ugc.live.sdk.msg.utils.g.b) r1).b);     // Catch: Throwable -> L14
        goto L66
    L13:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L14
    }

    public i(j r2, com.ss.ugc.live.sdk.msg.network.i r3, com.ss.ugc.live.sdk.msg.dispatch.f r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "httpClient");
        Intrinsics.checkNotNullParameter(r4, "messageDecoder");
        super(r2);
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
