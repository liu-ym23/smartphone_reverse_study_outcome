package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ RedPacketHybridService a;
    public final /* synthetic */ zy0.c b;

    public s(RedPacketHybridService r1, zy0.b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r5) {
        String r6 = (String) r5;
        if (this.a.c().isShowing() == false) goto L26;
        Iterator<T> r0 = ((List) this.a.d.k.e.d).iterator();
    L5:
        o0 r2 = null;
        if (r0.hasNext() == false) goto L10;
        T r1 = r0.next();
        if (Intrinsics.areEqual(((RedPacket) r1).getState().getInfo().d, r6) == false) goto L5;
    L11:
        RedPacket r3 = r1;
        if (r3 == null) goto L18;
        RedPacketState r4 = r3.getState();
        if (r4 == null) goto L18;
        n0 r7 = r4.getInfo();
        if (r7 == null) goto L18;
        r2 = x0.g(r7, "", null, RedPacketDialogShowFrom.RECEIVE);
    L18:
        JSONObject r8 = new JSONObject();
        r8.put("eventName", "RedEnvelopeUnAwardResult");
        r8.put("unAwardPackets", GsonProtectorUtils.toJson(GsonHelper.get(), CollectionsKt.listOf(r2)));
        xy0.a<?> r9 = this.b.g();
        if (r9 == null) goto L21;
        r9.sendJsEvent("H5_webcastNotification", r8);
    L21:
        this.a.e.h(r6);
        int r10 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.e("RedPacketHybridService", "send js event, unawards: " + GsonProtectorUtils.toJson(GsonHelper.get(), CollectionsKt.listOf(r2)));
        return;
    L10:
        r1 = (T) null;
        goto L11
    }
}
