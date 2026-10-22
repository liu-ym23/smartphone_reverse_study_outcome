package com.bytedance.android.livesdk.chatroom.ui.setting;

import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.roommanage.LiveRoomManageAppLogger;
import com.bytedance.android.livesdk.chatroom.utils.b0;
import com.bytedance.android.livesdkapi.depend.prefs.PropertyCache;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k extends mx.l {
    public k() {
        super(s1.B(2131922834), null, b0.b(), false, false, null, 122);
    }

    public final void c(SwitchSettingViewHolder r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r2, "holder");
        ((mx.l) this).l = r3;
        LiveRoomManageAppLogger.d(r3, false);
        PropertyCache.setBoolean(b0.c(), r3);
        b0.h(r3);
        b0.i();
    }
}
