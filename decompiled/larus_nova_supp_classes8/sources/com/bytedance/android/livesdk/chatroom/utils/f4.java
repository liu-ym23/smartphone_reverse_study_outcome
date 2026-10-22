package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdk.message.model.if;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f4 implements vlc.l {
    public tlc.d a;

    public f4() {
    }

    public final void onMessage(tlc.d r3) {
        if ((r3 instanceof if) == true) goto L5;
        return;
    L5:
        if (((if) r3).mScene != 14) goto L9;
        this.a = r3;
        return;
    }
}
