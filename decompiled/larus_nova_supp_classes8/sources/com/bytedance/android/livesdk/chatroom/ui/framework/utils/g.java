package com.bytedance.android.livesdk.chatroom.ui.framework.utils;

import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.livesdk.config.kc0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(boolean r4) {
        boolean r0 = MultiLinkLoadWidgetUtils.f();
        kc0 r1 = kc0.a;
        boolean r2 = r1.getValue().isLoadBeforeP0();
        boolean r3 = r1.getValue().isLoadAfterP0();
        if (r4 == false) goto L9;
        if (r0 == false) goto L9;
        if (r2 == false) goto L9;
        return 0;
    L9:
        if (r4 == false) goto L13;
        if (r0 == false) goto L13;
        if (r3 == false) goto L13;
        return 1;
    L13:
        if (r4 == true) goto L17;
        if (r0 == false) goto L17;
        if (r2 == false) goto L17;
        return 1;
    L17:
        if (r4 == true) goto L22;
        if (r0 == false) goto L24;
        if (r3 == false) goto L25;
        return 2;
    L25:
        return 3;
    L24:
        return 3;
    L22:
        return 3;
    }
}
