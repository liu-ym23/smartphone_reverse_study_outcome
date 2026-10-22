package com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode;

import com.bytedance.android.live.liveinteract.playmode.IncompatibleTag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static c a(IncompatibleTag r4, xh0.h r5, ArrayList r6) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        Intrinsics.checkNotNullParameter(r5, "info");
        if (r6 != null) goto L5;
        return null;
    L5:
        HashMap r1 = new HashMap();
        Iterator r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L12;
        xh0.f r2 = (xh0.f) r7.next();
        if (r2.a != r4) goto L7;
        r1.put(Integer.valueOf(r2.b), r2.c);
        goto L7
    L12:
        if (r1.size() != 0) goto L15;
        return null;
    L15:
        return new c(r4, r5, r1);
    }
}
