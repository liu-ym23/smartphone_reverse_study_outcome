package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y {
    public static void a(int r1) {
        Context r0 = s1.getContext();
        if (r0 == null) goto L7;
        b(r0.getString(r1), 0);
        return;
    }

    public static void b(final String r2, final int r3) {
        if (Looper.getMainLooper() == Looper.myLooper()) goto L6;
        UtilityKotlinExtentionsKt.g(new x(r2, r3));
        return;
    L6:
        Context r0 = s1.getContext();
        if (r0 != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r2) == false) goto L12;
        return;
    L12:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.x().centerToast(r0, r2, r3) == true) goto L16;
        Toast r4 = Toast.makeText(r0, r2, r3);
        r4.setGravity(17, 0, 0);
        r4.show();
        return;
    }
}
