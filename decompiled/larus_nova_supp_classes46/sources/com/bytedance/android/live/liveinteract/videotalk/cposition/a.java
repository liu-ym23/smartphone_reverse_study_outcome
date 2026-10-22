package com.bytedance.android.live.liveinteract.videotalk.cposition;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ CPositionWidget a;

    public a(CPositionWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Iterator<T> r5 = ((List) r4).iterator();
    L3:
        Long r1 = null;
        if (r5.hasNext() == false) goto L8;
        T r0 = r5.next();
        if (((ILinkPlayerInfoBridge) r0).isEnlarged() == false) goto L3;
    L9:
        ILinkPlayerInfoBridge r2 = (ILinkPlayerInfoBridge) r0;
        m r6 = com.bytedance.android.live.liveinteract.api.utils.m.j(this.a).getRoom();
        if (r6 == null) goto L14;
        IRoom r7 = (IRoom) r6.getValue();
        if (r7 == null) goto L14;
        r1 = Long.valueOf(r7.getId());
    L14:
        if (r2 == null) goto L23;
        if (r1 == null) goto L24;
        CPositionWidget r8 = this.a;
        if (r8.e == true) goto L25;
        r8.wq(r1.longValue());
        this.a.e = true;
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L8:
        r0 = null;
        goto L9
    }
}
