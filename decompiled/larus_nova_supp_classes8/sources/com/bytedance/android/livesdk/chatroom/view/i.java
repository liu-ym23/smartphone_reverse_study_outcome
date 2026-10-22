package com.bytedance.android.livesdk.chatroom.view;

import android.content.Context;
import com.ss.ttvideoengine.TTVideoEngine;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements nic.f {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final TTVideoEngine b(Context r1, tic.a r2, nic.e r3) {
        TTVideoEngine r4 = new TTVideoEngine(r1, 0);
        r4.setIntOption(17, 1);
        r4.setIntOption(160, 1);
        return r4;
    }
}
