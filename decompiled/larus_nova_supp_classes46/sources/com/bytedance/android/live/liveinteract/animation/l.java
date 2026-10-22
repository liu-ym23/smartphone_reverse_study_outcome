package com.bytedance.android.live.liveinteract.animation;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l {
    public static final ArrayList<String> a(ArrayList<ILinkPlayerInfoBridge> r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$toUserIdList");
        ArrayList<String> r0 = new ArrayList();
        Iterator<ILinkPlayerInfoBridge> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        IBaseUser r1 = r3.next().getUser();
        if (r1 == null) goto L4;
        String r4 = r1.getIdString();
        if (r4 == null) goto L4;
        r0.add(r4);
        goto L4
    L10:
        return r0;
    }
}
