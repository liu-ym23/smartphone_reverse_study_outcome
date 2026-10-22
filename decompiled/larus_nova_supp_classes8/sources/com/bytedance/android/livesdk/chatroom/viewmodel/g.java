package com.bytedance.android.livesdk.chatroom.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g {
    public static final boolean a(f r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isAudioTalk");
        if (r1.t().a != 5) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean b(f r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isKtvRoom");
        if (r1.t().a != 9) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean c(f r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$isShortVideo");
        if (r1.t().a != 10) goto L5;
        return true;
    L5:
        return false;
    }
}
