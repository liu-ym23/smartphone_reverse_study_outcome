package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.revenue.common.ToastUtil;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f0<T> implements Consumer {
    public final /* synthetic */ RedPacketIconModel a;

    public f0(RedPacketIconModel r1) {
        this.a = r1;
    }

    public final void accept(Object r12) {
        List r13 = (List) r12;
        if (this.a.u.c().isShowing() == false) goto L5;
        return;
    L5:
        if ((!r13.isEmpty()) == false) goto L91;
        List r0 = r13;
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r0.iterator();
    L7:
        int r5 = 0;
        if (r3.hasNext() == false) goto L32;
        T r4 = r3.next();
        com.bytedance.android.livesdk.chatroom.model.n1.e r6 = (com.bytedance.android.livesdk.chatroom.model.n1.e) r4;
        if (r6.getSucceed() == true) goto L28;
        com.bytedance.android.livesdk.chatroom.model.n1.d r7 = r6.getExpandAward();
        if (r7 == null) goto L19;
        com.bytedance.android.livesdk.chatroom.model.n1.c r8 = r7.getCaijingVoucher();
        if (r8 == null) goto L19;
        List r9 = r8.getVoucherList();
        if (r9 == null) goto L19;
        if ((!r9.isEmpty()) == true) goto L28;
    L19:
        com.bytedance.android.livesdk.chatroom.model.n1.d r10 = r6.getExpandAward();
        if (r10 == null) goto L29;
        String r14 = r10.getExtraAward();
        if (r14 == null) goto L29;
        if (r14.length() <= 0) goto L26;
        boolean r15 = true;
    L27:
        if (r15 != true) goto L29;
    L26:
        r15 = false;
    L29:
        if (r5 == 0) goto L7;
        r2.add(r4);
    L28:
        r5 = 1;
        goto L29
    L32:
        if (r2.isEmpty() == false) goto L68;
        ToastUtil.a(2131922030, 0);
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r16 = r0.iterator();
    L35:
        if (r16.hasNext() == false) goto L37;
        r1.add(((com.bytedance.android.livesdk.chatroom.model.n1.e) r16.next()).getBoxIdStr());
        goto L35
    L37:
        Iterable r17 = (Iterable) this.a.v.e.d;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator<T> r19 = r17.iterator();
    L39:
        if (r19.hasNext() == false) goto L41;
        r18.add(((RedPacket) r19.next()).getState().getInfo());
        goto L39
    L41:
        ArrayList r20 = new ArrayList();
        Iterator r22 = r18.iterator();
    L43:
        if (r22.hasNext() == false) goto L47;
        Object r23 = r22.next();
        if (r1.contains(((n0) r23).d) == false) goto L43;
        r20.add(r23);
        goto L43
    L47:
        ArrayList r24 = new ArrayList();
        ArrayList r25 = new ArrayList();
        if (r13 == null) goto L60;
        Iterator<T> r26 = r13.iterator();
    L51:
        if (r26.hasNext() == false) goto L60;
        com.bytedance.android.livesdk.chatroom.model.n1.e r27 = (com.bytedance.android.livesdk.chatroom.model.n1.e) r26.next();
        r24.add(String.valueOf(r27.getBoxId()));
        com.bytedance.android.livesdk.chatroom.model.n1.d r28 = r27.getExpandAward();
        if (r28 == null) goto L58;
        com.bytedance.android.livesdk.chatroom.model.n1.c r29 = r28.getCaijingVoucher();
        if (r29 == null) goto L58;
        String r30 = r29.getActivityId();
        if (r30 == null) goto L58;
    L59:
        r25.add(o.b(r30, r27.getBoxType()));
    L58:
        r30 = "";
    L60:
        ArrayList r32 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator r33 = r20.iterator();
    L62:
        if (r33.hasNext() == false) goto L64;
        n0 r34 = (n0) r33.next();
        r32.add(o.f(r34.s, r34.l));
        goto L62
    L64:
        String r35 = r24.toString();
        String r36 = r25.toString();
        if (r13 == null) goto L67;
        r5 = r13.size();
    L67:
        o.d(r35, r36, String.valueOf(r5), r32.toString());
        int r110 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("RedPacketIconModel", "on receive, no award red packet");
    L69:
        Iterator<T> r111 = r0.iterator();
    L71:
        if (r111.hasNext() == false) goto L92;
        this.a.v.h(((com.bytedance.android.livesdk.chatroom.model.n1.e) r111.next()).getBoxIdStr());
        goto L71
    L92:
        return;
    L68:
        this.a.i(null, r2, RedPacketDialogShowFrom.RECEIVE);
        int r112 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("RedPacketIconModel", "on receive, awardList: " + r2 + ", show rush dialog");
        goto L69
    }
}
