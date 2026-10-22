package com.bytedance.android.livesdk.chatroom.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r implements com.bytedance.android.livesdk.log.filter.v {
    public static final com.bytedance.android.livesdk.log.b a = null;
    public static final r b = null;

    public r() {
    }

    public final void Rd() {
    }

    public final void onRemove() {
    }

    static {
        b = new r();
        a = new com.bytedance.android.livesdk.log.b("DislikeParamsInjector", null);
    }

    public final void L9(String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        Intrinsics.checkNotNullParameter(r4, "params");
        if (r3.hashCode() == (-1103263308)) goto L6;
        return;
    L6:
        if (r3.equals("livesdk_dislike") == false) goto L9;
        r4.put("source_page", "native");
        a.a("inject source_page native");
        return;
    }
}
