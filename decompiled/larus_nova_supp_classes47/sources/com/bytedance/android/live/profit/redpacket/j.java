package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.o1;
import com.bytedance.android.livesdk.chatroom.model.p1;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T, R> implements Function {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
    }

    public final Object apply(Object r13) {
        ExtraResponse r14 = (ExtraResponse) r13;
        Intrinsics.checkNotNullParameter(r14, "resp");
        p1 r0 = ((o1) r14.data).castToOrNull(p1.class);
        String r1 = "";
        if (r0 == null) goto L85;
        p1.c r2 = r0.getExpandAward();
        if (r2 == null) goto L85;
        p1.a r3 = r2.getCaijingVoucher();
        if (r3 == null) goto L85;
        List r4 = r3.getVoucherList();
        if (r4 == null) goto L85;
        if ((!r4.isEmpty()) != true) goto L85;
        int r5 = h.a;
        p1 r15 = ((o1) r14.data).castTo(p1.class);
        com.bytedance.android.live.revenue.common.u0 r6 = x0.d();
        com.bytedance.android.live.revenue.common.u0 r7 = x0.e();
        com.bytedance.android.live.revenue.common.u0 r8 = com.bytedance.android.live.revenue.common.u0.f;
        p1.c r9 = r15.getExpandAward();
        if (r9 == null) goto L33;
        p1.a r10 = r9.getCaijingVoucher();
        if (r10 == null) goto L33;
        List r12 = r10.getVoucherList();
        if (r12 == null) goto L33;
        Iterator<T> r16 = r12.iterator();
        if (r16.hasNext() == true) goto L21;
        T r17 = null;
    L30:
        p1.d r18 = (p1.d) r17;
        if (r18 == null) goto L33;
        long r19 = r18.getExpireTime();
    L34:
        com.bytedance.android.live.revenue.common.u0 r20 = com.bytedance.android.live.revenue.common.u0.a.a(r19);
        p1.c r22 = r15.getExpandAward();
        if (r22 == null) goto L42;
        p1.a r23 = r22.getCaijingVoucher();
        if (r23 == null) goto L42;
        String r24 = r23.getVoucherName();
        if (r24 == null) goto L42;
        String r25 = r24;
    L43:
        py.k r26 = r15.getImage();
        com.bytedance.android.live.revenue.common.u0 r27 = r6.c(r20.b(r7));
        p1.c r28 = r15.getExpandAward();
        if (r28 == null) goto L50;
        p1.a r29 = r28.getCaijingVoucher();
        if (r29 == null) goto L50;
        List r30 = r29.getVoucherList();
        if (r30 == null) goto L50;
        r30.size();
    L50:
        String r32 = r15.getDressId();
        if (r32 != null) goto L53;
        String r110 = "";
    L54:
        p1.c r111 = r15.getExpandAward();
        if (r111 == null) goto L82;
        p1.a r112 = r111.getCaijingVoucher();
        if (r112 == null) goto L82;
        List r113 = r112.getVoucherList();
        if (r113 == null) goto L82;
        ArrayList r33 = new ArrayList();
        Iterator<T> r114 = r113.iterator();
    L62:
        if (r114.hasNext() == false) goto L81;
        p1.d r34 = (p1.d) r114.next();
        if (r34 == null) goto L78;
        String r35 = r34.getFaceValue();
        if (r35 != null) goto L68;
        r35 = "";
    L68:
        String r36 = r34.getUnit();
        if (r36 != null) goto L71;
        r36 = "";
    L71:
        String r115 = r34.getTitle();
        if (r115 != null) goto L74;
        r115 = "";
    L74:
        String r37 = r34.getSubTitle();
        if (r37 != null) goto L77;
        r37 = "";
    L77:
        m1 r38 = new m1(r35, r36, r115, r37);
    L79:
        if (r38 == null) goto L62;
        r33.add(r38);
        goto L62
    L78:
        r38 = null;
        goto L79
    L81:
        List r116 = r33;
    L116:
        return new RedPacketRushResult.b(r25, r26, r27, r110, r116);
    L82:
        r116 = CollectionsKt.emptyList();
        goto L116
    L53:
        r110 = r32;
    L42:
        r25 = "";
        goto L43
    L21:
        r17 = r16.next();
        if (r16.hasNext() == false) goto L30;
        long r39 = ((p1.d) r17).getExpireTime();
    L25:
        T r40 = r16.next();
        long r42 = ((p1.d) r40).getExpireTime();
        if (r39 <= r42) goto L29;
        r17 = r40;
        r39 = r42;
    L29:
        if (r16.hasNext() == true) goto L25;
    L33:
        r19 = 0;
    L85:
        if (((o1) r14.data).getExpired() == false) goto L88;
        return RedPacketRushResult.c.a;
    L88:
        if (((o1) r14.data).getSucceed() == false) goto L101;
        int r43 = h.a;
        o1 r117 = (o1) r14.data;
        p1 r44 = r117.castToOrNull(p1.class);
        int r45 = (int) r117.getDiamondCount();
        r117.getBoxType();
        String r46 = r117.getGiftName();
        if (r46 != null) goto L92;
        String r47 = "";
    L93:
        py.k r48 = r117.getImage();
        long r49 = r117.getGiftId();
        o1.b r50 = r117.getGiftGuide();
        if (r44 == null) goto L99;
        String r118 = r44.getDressId();
        if (r118 == null) goto L99;
        String r52 = r118;
    L118:
        return new RedPacketRushResult.e(r45, r47, r48, r49, r50, r52);
    L99:
        r52 = "";
        goto L118
    L92:
        r47 = r46;
        goto L93
    L101:
        p1 r119 = ((o1) r14.data).castToOrNull(p1.class);
        if (r119 == null) goto L108;
        String r120 = r119.getDressId();
        if (r120 == null) goto L108;
        r1 = r120;
    L108:
        return new RedPacketRushResult.d(r1);
    }
}
