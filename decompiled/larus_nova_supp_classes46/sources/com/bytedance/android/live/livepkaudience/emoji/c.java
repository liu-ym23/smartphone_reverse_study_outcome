package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static final int a(com.bytedance.android.live.livepkaudience.base.i r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$getAppLogLinkCnt");
        CopyOnWriteArrayList<LinkPlayerInfo> r6 = r5.c;
        ArrayList r0 = new ArrayList();
        Iterator<LinkPlayerInfo> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L18;
        LinkPlayerInfo r1 = r7.next();
        LinkPlayerInfo r2 = r1;
        IBaseUser r3 = r2.getUser();
        if (r3 == null) goto L8;
        String r4 = r3.getIdString();
    L9:
        boolean r8 = true;
        if ((!Intrinsics.areEqual(r4, dl0.n.d())) == true) goto L12;
    L14:
        r8 = false;
    L15:
        if (r8 == false) goto L4;
        r0.add(r1);
        goto L4
    L12:
        if (r2.getRoleType() == 1) goto L14;
    L8:
        r4 = null;
        goto L9
    L18:
        return r0.size();
    }
}
