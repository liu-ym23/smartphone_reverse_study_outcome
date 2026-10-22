package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils;

import com.bytedance.android.livesdk.config.setting.w;
import com.bytedance.android.livesdk.config.wu0;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public final boolean a;
    public final List<String> b;

    public c() {
        Boolean r0 = w.a.b();
        if (r0 == null) goto L5;
        boolean r1 = r0.booleanValue();
    L6:
        this.a = r1;
        this.b = (List) wu0.a.getValue();
        return;
    L5:
        r1 = false;
        goto L6
    }
}
