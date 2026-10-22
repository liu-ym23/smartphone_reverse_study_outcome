package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class x0 {

    public static final class a<T, R> implements Function {
        public final /* synthetic */ long a;

        public a(long r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            Long r6 = (Long) r5;
            Intrinsics.checkNotNullParameter(r6, "it");
            return Long.valueOf(this.a - r6.longValue());
        }
    }

    public static final com.bytedance.android.live.revenue.common.u0 d() {
        com.bytedance.android.live.revenue.common.u0 r0 = com.bytedance.android.live.revenue.common.u0.f;
        return com.bytedance.android.live.revenue.common.t0.b();
    }

    public static final com.bytedance.android.live.revenue.common.u0 e() {
        Intrinsics.checkNotNullParameter(com.bytedance.android.live.revenue.common.u0.l, "$this$ntp");
        return new com.bytedance.android.live.revenue.common.u0(vh6.c.b(vr2.e.class).w4());
    }

    public static final com.bytedance.android.live.revenue.common.u0 a(n0 r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$calcWaitTime");
        com.bytedance.android.live.revenue.common.u0 r5 = r4.f.c(r4.g).b(e());
        com.bytedance.android.live.revenue.common.u0 r0 = com.bytedance.android.live.revenue.common.u0.f;
        return new com.bytedance.android.live.revenue.common.u0((long) ((Number) RangesKt.coerceIn(Double.valueOf(r5.a), Double.valueOf(com.bytedance.android.live.revenue.common.u0.f.a), null)).doubleValue());
    }

    public static final Observable<Long> b(n0 r9) {
        Intrinsics.checkNotNullParameter(r9, "info");
        com.bytedance.android.live.revenue.common.u0 r10 = a(r9);
        long r0 = r10.a / com.bytedance.android.live.revenue.common.u0.b;
        com.bytedance.android.live.revenue.common.u0 r2 = com.bytedance.android.live.revenue.common.u0.g;
        Intrinsics.checkNotNullParameter(r2, "rhs");
        long r3 = r10.a % r2.a;
        com.bytedance.android.live.core.utils.rxutils.j.a r12 = com.bytedance.android.live.core.utils.rxutils.j.a;
        return RxUtilKt.h(com.bytedance.android.live.core.utils.rxutils.j.a(0, 1, TimeUnit.SECONDS).delay(r3, TimeUnit.MILLISECONDS).take(1 + r0).map(new a(r0)));
    }

    public static final py.k c(n0 r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$censorSenderAvatar");
        if (r3.p == false) goto L15;
        Intrinsics.checkNotNullParameter(r3, "$this$riskyAvatarThumbImageModel");
        String r0 = r3.j.getWebcastUid();
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L13;
        String r4 = r3.j.getIdString();
    L14:
        String r5 = (String) ListProtector.get((List) i1.d.getValue(null, i1.a[2]), Math.abs(r4.hashCode() % 10));
        py.k r2 = vh7.f.c(py.k.class);
        r2.setUri(r5);
        r2.setUrls(CollectionsKt.listOf(com.bytedance.android.live.revenue.common.v0.a(r5)));
        return r2;
    L13:
        r4 = "";
        goto L14
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L11
    L15:
        py.k r6 = r3.j.getAvatarThumbKt();
        if (r6 == null) goto L18;
        return r6;
    L18:
        return qy.a.c();
    }

    public static final String f(py.k r1) {
        if (r1 == null) goto L12;
        List r2 = r1.getUrls();
        if (r2 == null) goto L12;
        if ((!r2.isEmpty()) == true) goto L9;
        r2 = null;
    L9:
        if (r2 == null) goto L12;
        String r3 = (String) ListProtector.get(r2, 0);
        if (r3 == null) goto L12;
        return r3;
    L12:
        return "";
    }

    public static final RedPacketImageType getType(py.k r4) {
        if (r4 == null) goto L15;
        String r5 = r4.getUri();
        if (r5 == null) goto L15;
        if (StringsKt.endsWith$default(r5, "png", false, 2, null) == false) goto L10;
        return RedPacketImageType.PNG;
    L10:
        if (StringsKt.endsWith$default(r5, "webp", false, 2, null) == false) goto L13;
        return RedPacketImageType.WEBP;
    L13:
        return RedPacketImageType.UNKNOWN;
    L15:
        return RedPacketImageType.UNKNOWN;
    }

    public static final com.bytedance.android.live.profit.redpacket.a h(m r8) {
        Intrinsics.checkNotNullParameter(r8, "description");
        String r2 = r8.b;
        py.k r1 = r8.a;
        if (r1 == null) goto L5;
        String r3 = f(r1);
    L7:
        return new com.bytedance.android.live.profit.redpacket.a(r2, r3, r8.c, r8.d);
    L5:
        r3 = "";
        goto L7
    }

    public static o0 g(n0 r26, String r27, com.bytedance.android.livesdk.chatroom.model.n1.e r28, RedPacketDialogShowFrom r29) {
        Intrinsics.checkNotNullParameter(r26, "$this$toRedPacketSimplified");
        Intrinsics.checkNotNullParameter(r27, "countDown");
        Intrinsics.checkNotNullParameter(r29, "showFrom");
        String r4 = r26.d.toString();
        int r6 = r26.getType();
        int r5 = r26.b;
        int r7 = r26.m;
        String r2 = r26.j.getIdString();
        if (r2 != null) goto L5;
        String r15 = "";
    L6:
        String r3 = r26.j.getNickName();
        if (r3 != null) goto L9;
        String r16 = "";
    L10:
        String r8 = com.bytedance.android.live.base.model.user.o.a(r26.j);
        if (r8 != null) goto L13;
        String r17 = "";
    L14:
        String r18 = f(r26.j.getAvatarThumbKt());
        int r9 = r26.j.getIdString().hashCode();
        j1 r10 = new j1(r15, r16, r17, r18, com.bytedance.android.live.revenue.common.v0.a((String) ListProtector.get((List) i1.d.getValue(null, i1.a[2]), Math.abs(r9) % 10)), r26.p);
        List<m> r12 = r26.n;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r14 = r12.iterator();
    L16:
        if (r14.hasNext() == false) goto L18;
        r13.add(h((m) r14.next()));
        goto L16
    L18:
        String r19 = r26.q;
        long r110 = r26.l;
        long r111 = r26.g.a;
        long r112 = com.bytedance.android.live.revenue.common.u0.b;
        String r113 = String.valueOf(r111 / r112);
        String r114 = String.valueOf(r26.f.a);
        String r115 = String.valueOf(r26.i.b(r26.h).a / r112);
        String r20 = String.valueOf(r26.h.b(d()).a / r112);
        String r22 = String.valueOf(r26.i.b(d()).a / r112);
        String r23 = String.valueOf(r26.r);
        if (r29 != RedPacketDialogShowFrom.RECEIVE) goto L21;
        String r25 = "true";
    L23:
        if (r29 != RedPacketDialogShowFrom.REWARD) goto L25;
        String r1 = "true";
    L26:
        String r24 = r25;
        String r210 = r1;
        return new o0(r4, r5, r6, r7, r10, r13, r19, r110, r27, r113, r114, r115, r20, r22, r23, r28, r24, r210, "", r26.s);
    L25:
        r1 = "false";
        goto L26
    L21:
        r25 = "false";
        goto L23
    L13:
        r17 = r8;
        goto L14
    L9:
        r16 = r3;
        goto L10
    L5:
        r15 = r2;
        goto L6
    }
}
