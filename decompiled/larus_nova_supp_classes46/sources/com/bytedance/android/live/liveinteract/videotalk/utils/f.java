package com.bytedance.android.live.liveinteract.videotalk.utils;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(IRoom r3) {
        if (r3 == null) goto L7;
        Map r4 = r3.getAnchorABMap();
        if (r4 == null) goto L7;
        String r5 = (String) r4.get("guest_honor_show");
    L8:
        if (r5 == null) goto L16;
        if (r5.length() <= 0) goto L12;
        boolean r1 = true;
    L13:
        if (r1 != true) goto L16;
        return Intrinsics.areEqual(r5, "2");
    L12:
        r1 = false;
    L16:
        return ((Boolean) vm2.d.L.getValue(null, vm2.d.a[35])).booleanValue();
    L7:
        r5 = null;
        goto L8
    }
}
