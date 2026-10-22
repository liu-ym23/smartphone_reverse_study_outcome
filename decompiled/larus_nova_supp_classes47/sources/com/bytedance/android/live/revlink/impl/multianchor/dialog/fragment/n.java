package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "nickName");
        if (r3.length() > 4) goto L5;
        return r3;
    L5:
        return r3.substring(0, 3) + "...";
    }
}
