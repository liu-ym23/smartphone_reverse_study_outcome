package com.bytedance.android.livesdk.interactivity.medialink.intercomment;

import com.bytedance.android.livesdk.log.filter.v;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements v {
    public static final c a = null;

    public c() {
    }

    public final void Rd() {
    }

    public final void onRemove() {
    }

    static {
        a = new c();
    }

    public final void L9(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        if (Intrinsics.areEqual(r2, "livesdk_audience_live_message") == false) goto L12;
        b r4 = MediaInteractCommentDataContext.Companion.a();
        if (r4 == null) goto L9;
        int r0 = 1;
        if (r4.a0() != true) goto L9;
    L10:
        r3.put("is_comment_interflow", String.valueOf(r0));
        return;
    L9:
        r0 = 0;
        goto L10
    }
}
