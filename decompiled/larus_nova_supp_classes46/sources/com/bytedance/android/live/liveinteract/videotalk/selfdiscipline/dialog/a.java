package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog;

import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final String a(int r4) {
        int r5 = r4 / 60;
        int r0 = r5 % 60;
        int r6 = r5 / 60;
        if (r6 <= 0) goto L10;
        if (r0 <= 0) goto L8;
        return s1.C(2131922416, new Object[]{Integer.valueOf(r6), Integer.valueOf(r0)});
    L8:
        return s1.C(2131922415, new Object[]{Integer.valueOf(r6)});
    L10:
        return s1.C(2131922417, new Object[]{Integer.valueOf(r0)});
    }
}
