package com.bytedance.android.live.revlink.impl.multianchor.connect;

import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ i a;
    public final /* synthetic */ List b;

    public j(i r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r9) {
        Long r10 = (Long) r9;
        i11.b r12 = this.a.a();
        if (r12 == null) goto L43;
        List<com.bytedance.android.livesdk.link.model.p> r13 = r12.a();
        if (r13 == null) goto L46;
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = this.b.iterator();
    L8:
        com.bytedance.android.live.revlink.impl.multianchor.utils.d r3 = null;
        T r4 = null;
        if (r1.hasNext() == false) goto L28;
        com.bytedance.android.livesdk.link.model.p r2 = (com.bytedance.android.livesdk.link.model.p) r1.next();
        Iterator<T> r5 = r13.iterator();
    L12:
        if (r5.hasNext() == false) goto L25;
        T r6 = r5.next();
        IBaseUser r7 = ((com.bytedance.android.livesdk.link.model.p) r6).getUser();
        if (r7 == null) goto L16;
        String r8 = iz.a.a(r7);
    L17:
        IBaseUser r14 = r2.getUser();
        if (r14 == null) goto L20;
        String r15 = iz.a.a(r14);
    L22:
        if (Intrinsics.areEqual(r8, r15) == false) goto L12;
        r4 = r6;
        goto L25
    L20:
        r15 = null;
        goto L22
    L16:
        r8 = null;
    L25:
        if (((com.bytedance.android.livesdk.link.model.p) r4) == null) goto L8;
        r0.add(r2);
        goto L8
    L28:
        if ((!r0.isEmpty()) == false) goto L44;
        com.bytedance.android.live.revlink.impl.global.c r16 = this.a.c;
        if (r16 == null) goto L32;
        r3 = r16.of();
    L32:
        if (r3 == null) goto L45;
        String r17 = i11.a.c(r0);
        Intrinsics.checkNotNullParameter(r17, "stillWaitingList");
        LinkedHashMap r18 = new LinkedHashMap();
        r18.put("still_waiting_list", r17);
        r3.c("abnormal_waiting_list_state", r18);
        return;
    L45:
        return;
    L44:
        return;
    L46:
        return;
    }
}
