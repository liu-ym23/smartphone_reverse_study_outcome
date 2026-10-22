package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.end.LiveEndPageData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g4 implements h {
    public static h a;
    public static final g4 b = null;

    public g4() {
    }

    static {
        b = new g4();
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.h
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
        h r0 = a;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.h
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
        h r0 = a;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }
}
