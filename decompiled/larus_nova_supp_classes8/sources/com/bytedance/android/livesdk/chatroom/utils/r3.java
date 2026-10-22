package com.bytedance.android.livesdk.chatroom.utils;

import android.view.View;
import com.bytedance.android.livehostapi.business.IBcmSearchTrack;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r3 {
    static {
    }

    @JvmStatic
    public static final void a(View r1, String r2, String r3, String r4) {
        IBcmSearchTrack r0 = jc1.k.f(IBcmSearchTrack.class);
        if (r0 == null) goto L6;
        r0.appendSearchParams(r1, r2, r3, r4);
        return;
    }
}
