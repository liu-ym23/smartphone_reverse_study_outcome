package com.bytedance.android.live.liveinteract.revenue.guestlink;

import com.bytedance.android.live.base.model.message.guestlink.k;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ GuestLinkWidget a;

    public g(GuestLinkWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        List r4 = ((com.bytedance.android.live.base.model.message.guestlink.a) r3).getLinkedUsers();
        if (r4 == null) goto L13;
        List r5 = r4;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L14;
        IBaseUser r1 = ((k) r6.next()).getUser();
        if (r1 == null) goto L11;
        String r2 = r1.getIdString();
        if (r2 == null) goto L11;
    L12:
        r0.add(r2);
    L11:
        r2 = "";
    L14:
        ((Widget) this.a).dataCenter.put("data_guest_link_changed_list", r0);
        return;
    L13:
        r0 = null;
        goto L14
    }
}
