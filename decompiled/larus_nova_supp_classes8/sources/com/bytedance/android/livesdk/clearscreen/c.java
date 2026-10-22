package com.bytedance.android.livesdk.clearscreen;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.ies.utility.SharedPrefHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements com.bytedance.android.livesdk.utils.condition.base.e {
    public final /* synthetic */ Context a;

    public final boolean a() {
        if (SharedPrefHelper.b(this.a).h(ClearGuideManager.c, 0) != 0) goto L12;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.m r1 = r0.isCleanMode();
        if (r1 == null) goto L10;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L10;
        return false;
    L10:
        return true;
    L12:
        return false;
    }

    public final boolean b() {
        SharedPrefHelper r0 = SharedPrefHelper.b(this.a);
        com.bytedance.android.livesdk.utils.condition.base.e r1 = ClearGuideManager.a;
        if (r0.h(ClearGuideManager.c, 0) != 0) goto L6;
        return true;
    L6:
        return false;
    }

    public c(Context r1) {
        this.a = r1;
    }
}
