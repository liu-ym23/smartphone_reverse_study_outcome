package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e0<T> implements Consumer {
    public final /* synthetic */ y a;
    public final /* synthetic */ h1 b;
    public final /* synthetic */ Long c;
    public final /* synthetic */ long d;

    public e0(y r1, h1 r2, Long r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r8) {
        y r0 = this.a;
        h1 r1 = this.b;
        List<? extends com.bytedance.android.livesdk.link.model.bridge.k> r9 = ((IRoomLinkMicSyncData) r8).getMLinkUsers();
        r0.getClass();
        ArrayList r2 = new ArrayList(r0.c);
        int r3 = r1.getMType();
        if (r3 == 6) goto L18;
        if (r3 != 7) goto L7;
        boolean r10 = r0.B(r1, r9);
    L23:
        if (r10 == false) goto L50;
        Iterator r11 = r2.iterator();
    L26:
        Long r4 = null;
        ILinkPlayerInfoBridge r5 = null;
        if (r11.hasNext() == false) goto L39;
        ILinkPlayerInfoBridge r6 = (ILinkPlayerInfoBridge) r11.next();
        Iterator<ILinkPlayerInfoBridge> r7 = r0.c.iterator();
    L30:
        if (r7.hasNext() == false) goto L34;
        ILinkPlayerInfoBridge r12 = r7.next();
        if (y.w(r12, r6) == false) goto L30;
        r5 = r12;
    L34:
        if (r5 != null) goto L26;
        if (r0.h.size() < r0.b) goto L38;
        r0.h.remove(0);
    L38:
        r0.h.add(r6);
        goto L26
    L39:
        ALogger.w(r0.a, "message onOnlineListChanged callback");
        int r13 = MultiSceneEnterRoomStatisticsUtils.u;
        DataCenter r14 = r0.N;
        IRoom r15 = r0.M;
        if (r15 == null) goto L42;
        r4 = Long.valueOf(r15.getId());
    L42:
        MultiSceneEnterRoomStatisticsUtils r16 = MultiSceneEnterRoomStatisticsUtils.a.a(r14, Long.valueOf(r4.longValue()));
        if (r16 == null) goto L45;
        r16.c();
    L45:
        System.currentTimeMillis();
        Iterator r17 = ((ArrayList) r0.n).iterator();
    L47:
        if (r17.hasNext() == false) goto L49;
        com.bytedance.android.live.liveinteract.plantform.base.i.b r18 = (com.bytedance.android.live.liveinteract.plantform.base.i.b) r17.next();
        r18.onOnlineListChanged(r0.c);
        r18.d(r0.c, r0.d);
        goto L47
    L49:
        y.J(r0.c);
        tc0.c r19 = tc0.c.h();
        r19.v = r0.b();
    L50:
        TalkRoomBusinessFullLinkMonitor r20 = TalkRoomBusinessFullLinkMonitor.a;
        h1 r21 = this.b;
        Long r22 = this.c;
        if (r22 == null) goto L53;
        long r23 = r22.longValue();
    L54:
        long r24 = this.d;
        TalkRoomBusinessFullLinkMonitor.WrdsStatusType r25 = TalkRoomBusinessFullLinkMonitor.WrdsStatusType.Success;
        r20.getClass();
        TalkRoomBusinessFullLinkMonitor.A0(r21, r23, r24, r25);
        return;
    L53:
        r23 = 0;
        goto L54
    L7:
        if (r3 != 11) goto L9;
        r10 = r0.C(r1, r9);
        goto L23
    L9:
        if (r3 != 12) goto L11;
        r10 = r0.D(r1, r9);
        goto L23
    L11:
        if (r3 != 41) goto L50;
        r10 = r0.z(r1, r9);
        goto L23
    L18:
        if (je0.d.Y() == false) goto L20;
    L21:
        r0.I(false, "messageLinkUserEnter");
    L22:
        r10 = r0.A(r1, r9);
        goto L23
    L20:
        if (r0.q.booleanValue() == false) goto L22;
        goto L21
    }
}
