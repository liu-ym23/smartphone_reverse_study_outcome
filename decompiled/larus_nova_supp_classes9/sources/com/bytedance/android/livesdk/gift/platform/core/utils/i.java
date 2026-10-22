package com.bytedance.android.livesdk.gift.platform.core.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i {
    public static final String a(DataCenter r4) {
        gq2.b r0 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).Qc();
        int r1 = 0;
        if (r4 == null) goto L7;
        r0.b();
        Integer r5 = (Integer) r4.get("data_link_state", 0);
        if (r5 == null) goto L7;
        r1 = r5.intValue();
    L9:
        return vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).changeMode2String(r1);
    L7:
        r0.b();
        goto L9
    }

    public static final List b(List r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return null;
    L10:
        ArrayList r1 = new ArrayList();
        Iterator r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L15;
        r1.add(Integer.valueOf((int) ((e3) r4.next()).getPluginId()));
        goto L12
    L15:
        return r1;
    L4:
        if (r3.isEmpty() == true) goto L7;
        r0 = false;
        goto L8
    }

    public static final String c(String r3) {
        yz0.k r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 == null) goto L8;
        IRoom r1 = r0.getRoom();
        if (r1 == null) goto L8;
        String r2 = r1.getAnchorId();
        if (r2 == null) goto L8;
    L10:
        if (Intrinsics.areEqual(r3, r2) == true) goto L25;
        if (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.d() == ReceiverType.Anchor) goto L25;
        if (d(r3, 4) == false) goto L18;
        return String.valueOf(3);
    L18:
        if (d(r3, 2) == false) goto L21;
        return String.valueOf(4);
    L21:
        if (d(r3, 1024) == false) goto L29;
        return String.valueOf(1);
    L29:
        return String.valueOf(1);
    L25:
        return String.valueOf(2);
    L8:
        r2 = BuildConfig.FLAVOR;
        goto L10
    }

    public static final boolean d(String r3, int r4) {
        i12.e r0 = i12.o.b();
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, GiftReceiverRepoService.class);
    L6:
        GiftReceiverRepoService r2 = (GiftReceiverRepoService) r1;
        if (r2 == null) goto L10;
        List<IBaseUser> r5 = r2.o(r4).a;
        if (r5 == null) goto L10;
    L11:
        Iterator<IBaseUser> r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(r6.next().getIdString(), r3) == false) goto L13;
        return true;
    L18:
        return false;
    L10:
        r5 = CollectionsKt.emptyList();
        goto L11
    L5:
        r1 = null;
        goto L6
    }
}
