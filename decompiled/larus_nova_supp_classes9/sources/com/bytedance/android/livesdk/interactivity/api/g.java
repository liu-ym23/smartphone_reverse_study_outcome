package com.bytedance.android.livesdk.interactivity.api;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g {
    public static final f a(RoomContext r2) {
        ViewModel r0 = null;
        if (r2 == null) goto L7;
        com.bytedance.live.datacontext.j r3 = r2.getInteractivityContext();
        if (r3 == null) goto L7;
        ViewModel r4 = (ViewModel) r3.getValue();
    L9:
        if ((r4 instanceof f) == false) goto L13;
        r0 = r4;
    L13:
        return (f) r0;
    L7:
        r4 = null;
        goto L9
    }
}
