package com.bytedance.android.live.liveinteract.utils;

import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i1 {
    public static final /* synthetic */ int a = 0;

    public i1() {
    }

    static {
    }

    public static void a(HSImageView r4) {
        Intrinsics.checkNotNullParameter(r4, "icon");
        boolean r2 = false;
        wm2.a r0 = (wm2.a) vm2.a.b.getValue(null, vm2.a.a[0]);
        if (r0 == null) goto L11;
        String r1 = r0.a();
        if (r1 == null) goto L11;
        if (r1.length() <= 0) goto L9;
        r2 = true;
    L9:
        if (r2 != true) goto L11;
        String r3 = LiveCommonConstants.assembleTosObjectUrl(r1);
    L13:
        if (TextUtils.isEmpty(r3) == true) goto L15;
        com.bytedance.android.livesdk.chatroom.utils.a1.o(r4, qy.a.a(r3), ImageView.ScaleType.FIT_CENTER);
        return;
    L15:
        r4.setImageResource(2131252207);
        return;
    L11:
        r3 = "";
        goto L13
    }
}
