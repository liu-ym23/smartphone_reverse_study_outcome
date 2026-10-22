package com.bytedance.android.live.platformplayer.utils;

import android.os.CountDownTimer;
import com.bytedance.android.live.core.utils.f2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends CountDownTimer {
    @Override // android.os.CountDownTimer
    public final void onTick(long r1) {
    }

    public d() {
        super(3000, 3000);
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        if (((Boolean) com.bytedance.android.live.core.setting.b.a.getValue()).booleanValue() == false) goto L6;
        f2.b(2131922917, 0);
        com.bytedance.android.livesdk.chatroom.helper.h.a(2);
        return;
    }
}
