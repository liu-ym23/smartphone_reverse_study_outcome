package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.common.utility.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g2 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(View r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        int r0 = UtilityKotlinExtentionsKt.i(38);
        UIUtils.setLayoutParams(r1, r0, r0);
    }

    public static boolean b(Boolean r4) {
        if (r4 == null) goto L4;
        boolean r5 = r4.booleanValue();
    L13:
        return !r5;
    L4:
        IRoomContextService r6 = jc1.k.f(IRoomContextService.class);
        if (r6 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.o r7 = IRoomContextService.a.a(r6, null, 0, 3);
        if (r7 == null) goto L11;
        Boolean r8 = r7.isAnchor();
        if (r8 == null) goto L11;
        r5 = r8.booleanValue();
    L11:
        r5 = false;
        goto L13
    }
}
