package com.bytedance.android.live.liveinteract.plantform.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f0 {
    public static final String a(IMessageBoardInfo r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$getMsgBoardContent");
        String r2 = r1.getContent();
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2;
    }
}
