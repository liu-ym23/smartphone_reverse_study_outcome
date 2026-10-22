package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ RedPacketHybridService a;
    public final /* synthetic */ zy0.c b;

    public r(RedPacketHybridService r1, zy0.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r9) {
        List r10 = (List) r9;
        if (this.a.c().isShowing() == false) goto L35;
        List r0 = r10;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L22;
        com.bytedance.android.livesdk.chatroom.model.n1.e r3 = (com.bytedance.android.livesdk.chatroom.model.n1.e) r2.next();
        Iterator<T> r4 = ((List) this.a.d.k.e.d).iterator();
    L8:
        o0 r5 = null;
        if (r4.hasNext() == false) goto L13;
        T r6 = r4.next();
        if (Intrinsics.areEqual(((RedPacket) r6).getState().getInfo().d, r3.getBoxIdStr()) == false) goto L8;
    L14:
        RedPacket r7 = r6;
        this.a.e.h(r3.getBoxIdStr());
        if (r7 == null) goto L21;
        RedPacketState r8 = r7.getState();
        if (r8 == null) goto L21;
        n0 r12 = r8.getInfo();
        if (r12 == null) goto L21;
        r5 = x0.g(r12, "", r3, RedPacketDialogShowFrom.RECEIVE);
    L21:
        r1.add(r5);
        goto L6
    L13:
        r6 = (T) null;
        goto L14
    L22:
        JSONObject r13 = new JSONObject();
        r13.put("eventName", "RedEnvelopeReceiveResult");
        r13.put("receiveResults", GsonProtectorUtils.toJson(GsonHelper.get(), r1));
        xy0.a<?> r14 = this.b.g();
        if (r14 == null) goto L25;
        r14.sendJsEvent("H5_webcastNotification", r13);
    L25:
        int r15 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("RedPacketHybridService", "send js event, receiveResults: " + GsonProtectorUtils.toJson(GsonHelper.get(), r10));
        return;
    }
}
