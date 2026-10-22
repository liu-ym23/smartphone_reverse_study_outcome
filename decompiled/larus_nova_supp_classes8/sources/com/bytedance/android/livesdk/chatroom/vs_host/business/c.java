package com.bytedance.android.livesdk.chatroom.vs_host.business;

import com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.CastStreamTimeShiftContext;
import com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.LiveByteCastUIManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements com.bytedance.android.livesdk.chatroom.progressbar.b {
    public final CastStreamTimeShiftContext a;

    public final com.bytedance.live.datacontext.m<Long> a() {
        return this.a.getCurrentDisplayTime();
    }

    public final com.bytedance.live.datacontext.m<Boolean> b() {
        return this.a.isCastPlaying();
    }

    public final com.bytedance.live.datacontext.m<mf1.b> c() {
        return this.a.getAtLatest();
    }

    public final com.bytedance.live.datacontext.m<Boolean> d() {
        return this.a.isSupportStreamTimeShift();
    }

    public final com.bytedance.live.datacontext.m<Long> getCurrentTime() {
        return this.a.getCurrentTime();
    }

    public final com.bytedance.live.datacontext.m<Long> getTotalTime() {
        return this.a.getTotalTime();
    }

    public c() {
        String r0 = LiveByteCastUIManager.a;
        this.a = LiveByteCastUIManager.g;
    }
}
