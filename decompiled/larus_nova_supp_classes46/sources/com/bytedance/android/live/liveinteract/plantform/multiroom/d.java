package com.bytedance.android.live.liveinteract.plantform.multiroom;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ MultiLinkUIWidget a;

    public d(MultiLinkUIWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        List<? extends tf0.e> r8 = (List) r7;
        Object r0 = CollectionsKt.getOrNull(r8, 0);
        Integer r2 = null;
        if ((r0 instanceof MultiLinkGuestViewBinder.a) == true) goto L5;
        r0 = null;
    L5:
        MultiLinkGuestViewBinder.a r1 = (MultiLinkGuestViewBinder.a) r0;
        MultiLinkUIWidget r3 = this.a;
        r3.getClass();
        int r4 = e.a;
        ih0.b r5 = e.b(((Widget) r3).dataCenter);
        if (r5 == null) goto L8;
        r5.Ll(r8);
    L8:
        com.bytedance.android.live.liveinteract.bgComponent.platform.a r6 = e.c(((Widget) this.a).dataCenter);
        if (r6 == null) goto L11;
        r6.Xe(r8);
    L11:
        this.a.Kq(r8);
        MultiLinkUIWidget r9 = this.a;
        int r10 = r9.hashCode();
        StringBuilder r11 = new StringBuilder("micSeatDataService=");
        a r12 = this.a.Bq();
        if (r12 == null) goto L14;
        Integer r13 = Integer.valueOf(r12.hashCode());
    L15:
        r11.append(r13);
        r11.append(", MultiLinkitemListSize=");
        r11.append(r8.size());
        r11.append(", guest=");
        if (r1 == null) goto L24;
        ch0.e r14 = r1.k;
        if (r14 == null) goto L24;
        ILinkPlayerInfoBridge r15 = r14.a;
        if (r15 == null) goto L24;
        IBaseUser r16 = r15.getUser();
        if (r16 == null) goto L24;
        String r17 = r16.getNickName();
    L25:
        r11.append(r17);
        r11.append(" dynamicService=");
        MultiLinkUIWidget r18 = this.a;
        r18.getClass();
        ih0.b r19 = e.b(((Widget) r18).dataCenter);
        if (r19 == null) goto L28;
        r2 = Integer.valueOf(r19.hashCode());
    L28:
        r11.append(r2);
        r9.Jq("MultiLinkUIWidget#registerWindowListObservable", r10, r11.toString());
        return;
    L24:
        r17 = null;
        goto L25
    L14:
        r13 = null;
        goto L15
    }
}
