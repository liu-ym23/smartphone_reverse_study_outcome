package com.bytedance.android.live.revlink.impl.pk.utils;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(IRoom r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        com.bytedance.android.live.revlink.impl.settings.live.b r4 = com.bytedance.android.live.revlink.impl.settings.live.b.p;
        r4.getClass();
        return ((Boolean) com.bytedance.android.live.revlink.impl.settings.live.b.f.getValue(r4, com.bytedance.android.live.revlink.impl.settings.live.b.a[4])).booleanValue();
    }
}
