package fmc;

import com.ss.ugc.live.sdk.msg.data.SdkMessage;
import com.ss.ugc.live.sdk.msg.data.SdkResponse;
import com.ss.ugc.live.sdk.msg.network.HttpException;
import com.ss.ugc.live.sdk.msg.task.HistoryHttpException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g extends com.ss.ugc.live.sdk.msg.utils.task.a<com.ss.ugc.live.sdk.msg.network.f, com.ss.ugc.live.sdk.msg.data.b> {
    public final com.ss.ugc.live.sdk.msg.network.i c;
    public final com.ss.ugc.live.sdk.msg.dispatch.f d;
    public final vlc.i e;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.ugc.live.sdk.msg.utils.task.a
    public final void c(com.ss.ugc.live.sdk.msg.network.f r15) {
        com.ss.ugc.live.sdk.msg.network.f r16 = r15;
        Intrinsics.checkNotNullParameter(r16, "params");
        long r0 = System.currentTimeMillis();
        com.ss.ugc.live.sdk.msg.utils.g<com.ss.ugc.live.sdk.msg.network.g, Exception> r17 = this.c.a(r16);
    L14:
        th = move-exception;
        if ((th instanceof Exception) == false) goto L66;
        int r2 = com.ss.ugc.live.sdk.msg.utils.g.a;
        com.ss.ugc.live.sdk.msg.utils.g r3 = com.ss.ugc.live.sdk.msg.utils.g.a.a(th);
    L67:
    L51:
        th = move-exception;
        if ((th instanceof Exception) == false) goto L65;
        int r1 = com.ss.ugc.live.sdk.msg.utils.g.a;
        com.ss.ugc.live.sdk.msg.utils.g r18 = com.ss.ugc.live.sdk.msg.utils.g.a.a(th);
    L56:
        if ((r18 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L59;
        com.ss.ugc.live.sdk.msg.utils.g r4 = new com.ss.ugc.live.sdk.msg.utils.g.c(((com.ss.ugc.live.sdk.msg.utils.g.c) r18).b);
    L61:
        b(r4);
        return;
    L59:
        if ((r18 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L64;
        Exception r19 = (Exception) ((com.ss.ugc.live.sdk.msg.utils.g.b) r18).b;
        r4 = new com.ss.ugc.live.sdk.msg.utils.g.b(new HistoryHttpException(this.e, r19));
        goto L61
    L64:
        throw new NoWhenBranchMatchedException();
    L65:
        throw th;
    L19:
        if ((r3 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L47;
        Pair r110 = (Pair) ((com.ss.ugc.live.sdk.msg.utils.g.c) r3).b;     // Catch: Throwable -> L51
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L51
        com.ss.ugc.live.sdk.msg.network.g r6 = (com.ss.ugc.live.sdk.msg.network.g) r110.getFirst();     // Catch: Throwable -> L51
        SdkResponse r111 = (SdkResponse) r110.getSecond();     // Catch: Throwable -> L51
        ArrayList r7 = new ArrayList();     // Catch: Throwable -> L51
        List<SdkMessage> r8 = r111.messages;     // Catch: Throwable -> L51
        if (r8 != null) goto L23;
    L26:
        boolean r9 = true;
    L27:
        if (r9 == true) goto L45;
        long r10 = System.currentTimeMillis();     // Catch: Throwable -> L51
        Iterator<T> r11 = r111.messages.iterator();     // Catch: Throwable -> L51
    L30:
        if (r11.hasNext() == false) goto L41;
        SdkMessage r12 = (SdkMessage) r11.next();     // Catch: Throwable -> L51
        Long r13 = r111.now;     // Catch: Throwable -> L51
        if (r13 == null) goto L34;
        long r14 = r13.longValue();     // Catch: Throwable -> L51
    L35:
        Long r112 = com.ss.ugc.live.sdk.msg.utils.c.e(r6.c);     // Catch: Throwable -> L51
        if (r112 == null) goto L38;
        r14 = r112.longValue();     // Catch: Throwable -> L51
    L38:
        r12.timestamp = r14;     // Catch: Throwable -> L51
        r12.fromHttp = true;     // Catch: Throwable -> L51
        tlc.d r113 = this.d.a(r12);     // Catch: Throwable -> L51
        if (r113 == null) goto L30;
        r113.setMessageMethod(r12.method);     // Catch: Throwable -> L51
        r113.setHttpSendTime(r0);     // Catch: Throwable -> L51
        r113.setReceiveTime(r5);     // Catch: Throwable -> L51
        r7.add(r113);     // Catch: Throwable -> L51
        goto L30
    L34:
        r14 = System.currentTimeMillis();     // Catch: Throwable -> L51
        goto L35
    L41:
        long r20 = System.currentTimeMillis();     // Catch: Throwable -> L51
        Iterator r21 = r7.iterator();     // Catch: Throwable -> L51
    L43:
        if (r21.hasNext() == false) goto L45;
        tlc.d r22 = (tlc.d) r21.next();     // Catch: Throwable -> L51
        r22.setDecodeStartTime(r10);     // Catch: Throwable -> L51
        r22.setDecodeEndTime(r20);     // Catch: Throwable -> L51
    L45:
        com.ss.ugc.live.sdk.msg.data.b r23 = new com.ss.ugc.live.sdk.msg.data.b(r111, r7, this.e);     // Catch: Throwable -> L51
        r23.a = r6;     // Catch: Throwable -> L51
        r18 = new com.ss.ugc.live.sdk.msg.utils.g.c(r23);     // Catch: Throwable -> L51
        goto L56
    L23:
        if (r8.isEmpty() == true) goto L26;
        r9 = false;
        goto L27
    L47:
        if ((r3 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L50;
        r18 = new com.ss.ugc.live.sdk.msg.utils.g.b(((com.ss.ugc.live.sdk.msg.utils.g.b) r3).b);     // Catch: Throwable -> L51
        goto L56
    L50:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L51
    L66:
        throw th;
    L4:
        if ((r17 instanceof com.ss.ugc.live.sdk.msg.utils.g.c) == false) goto L10;
        com.ss.ugc.live.sdk.msg.network.g r114 = (com.ss.ugc.live.sdk.msg.network.g) ((com.ss.ugc.live.sdk.msg.utils.g.c) r17).b;     // Catch: Throwable -> L14
        if (r114.a() == false) goto L8;
        SdkResponse r24 = (SdkResponse) SdkResponse.ADAPTER.decode(r114.d);     // Catch: Throwable -> L14
        int r25 = com.ss.ugc.live.sdk.msg.utils.g.a;     // Catch: Throwable -> L14
        r3 = new com.ss.ugc.live.sdk.msg.utils.g.c(TuplesKt.to(r114, r24));     // Catch: Throwable -> L14
        goto L67
    L8:
        int r26 = com.ss.ugc.live.sdk.msg.utils.g.a;     // Catch: Throwable -> L14
        r3 = com.ss.ugc.live.sdk.msg.utils.g.a.a(new HttpException(r114.a, com.ss.ugc.live.sdk.msg.utils.c.c(r114)));     // Catch: Throwable -> L14
        goto L67
    L10:
        if ((r17 instanceof com.ss.ugc.live.sdk.msg.utils.g.b) == false) goto L13;
        r3 = new com.ss.ugc.live.sdk.msg.utils.g.b(((com.ss.ugc.live.sdk.msg.utils.g.b) r17).b);     // Catch: Throwable -> L14
        goto L67
    L13:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L14
    }

    public g(d r2, com.ss.ugc.live.sdk.msg.network.i r3, com.ss.ugc.live.sdk.msg.dispatch.f r4, vlc.i r5) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "httpClient");
        Intrinsics.checkNotNullParameter(r4, "messageDecoder");
        Intrinsics.checkNotNullParameter(r5, "listener");
        super(r2);
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
