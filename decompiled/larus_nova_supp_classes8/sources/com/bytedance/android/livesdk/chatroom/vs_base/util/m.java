package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Context r1) {
        if (r1 == null) goto L7;
        Resources r2 = r1.getResources();
        if (r2 == null) goto L7;
        Configuration r3 = r2.getConfiguration();
        if (r3 == null) goto L7;
    L14:
        if (r3 != null) goto L17;
        return false;
    L17:
        if (FoldScreenUtils.c(r3) != 0) goto L20;
        return true;
    L20:
        return false;
    L7:
        Context r4 = s1.getContext();
        if (r4 == null) goto L12;
        Resources r5 = r4.getResources();
        if (r5 == null) goto L12;
        r3 = r5.getConfiguration();
    L12:
        r3 = null;
        goto L14
    }

    public static boolean b(Configuration r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        if (FoldScreenUtils.c(r1) != 0) goto L9;
        return true;
    L9:
        return false;
    }
}
