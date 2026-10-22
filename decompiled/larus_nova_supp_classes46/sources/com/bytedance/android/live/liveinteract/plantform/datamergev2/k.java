package com.bytedance.android.live.liveinteract.plantform.datamergev2;

import com.bytedance.android.live.core.utils.z0;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.config.ob0;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k implements OnWRDSDataUpdateListener {
    public ylc.c a;
    public final /* synthetic */ i b;

    public final ylc.c getDataSyncListener() {
        return this.a;
    }

    public k(i r1) {
        this.b = r1;
    }

    public final void setDataSyncListener(ylc.c r1) {
        this.a = r1;
    }

    public final void onWRDSDataUpdate(String r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "syncKey");
        if (((Boolean) ob0.a.getValue()).booleanValue() == true) goto L5;
    L7:
        List<ILinkPlayerInfoBridge> r0 = null;
        if ((r5 instanceof IRoomLinkMicSyncData) == true) goto L10;
        r5 = null;
    L10:
        IRoomLinkMicSyncData r6 = (IRoomLinkMicSyncData) r5;
        if (r6 == null) goto L39;
        this.b.g(r6.getMLinkUsers(), r6.getClientUIInfo());
        Iterator r7 = ((ArrayList) this.b.a).iterator();
    L14:
        if (r7.hasNext() == false) goto L16;
        ((com.bytedance.android.live.liveinteract.plantform.base.i.d) r7.next()).e(r6.getLockedPositions());
        goto L14
    L16:
        Map r8 = r6.getLinkerContentMap();
        if (r8 == null) goto L29;
        Map.Entry r9 = z0.a(r8);
        if (r9 == null) goto L29;
        g2 r10 = (g2) r9.getValue();
        if (r10 == null) goto L29;
        List r11 = r10.getLinkedUsers();
        if (r11 == null) goto L29;
        List r12 = r11;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r13 = r12.iterator();
    L26:
        if (r13.hasNext() == false) goto L28;
        r1.add(je0.d.d0((com.bytedance.android.livesdk.link.model.bridge.k) r13.next(), true));
        goto L26
    L28:
        r0 = CollectionsKt.toMutableList(r1);
    L29:
        if (r0 == null) goto L34;
        Iterator<T> r14 = r0.iterator();
    L32:
        if (r14.hasNext() == false) goto L34;
        ILinkPlayerInfoBridge r2 = (ILinkPlayerInfoBridge) r14.next();
        int r3 = tc0.e.a;
        tc0.e.b(r2, r6.getLinkerContentMap());
    L34:
        this.b.h(r0, r6.getLinkerContentMap(), r6.getClientUIInfo());
        return;
    L39:
        return;
    L5:
        if (this.b.f.getRoom().isOfficialChannelRoom() == false) goto L7;
    }
}
