package com.bytedance.android.live.platformplayer.utils;

import android.os.CountDownTimer;
import com.bytedance.android.live.core.utils.f2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e extends CountDownTimer {
    @Override // android.os.CountDownTimer
    public final void onTick(long r1) {
    }

    public e() {
        super(6000, 6000);
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        if (((Boolean) com.bytedance.android.live.core.setting.b.a.getValue()).booleanValue() == false) goto L6;
        f2.b(2131922918, 0);
        com.bytedance.android.livesdk.chatroom.helper.h.a(3);
        return;
    }
}
