package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong;

import android.content.Context;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.view.PositionNameTv;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l {
    public RequestSongMicSeatView a;

    public static final class a {
    }

    static {
    }

    public l() {
    }

    public final void a(Context r14, MicSeatScene r15, int r16, boolean r17, PositionNameTv r18, xg0.a r19) {
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "scene");
        RequestSongMicSeatView r0 = new RequestSongMicSeatView(r14, null, 0, true, 6);
        this.a = r0;
        if (r16 <= 0) goto L5;
        boolean r8 = true;
    L6:
        RequestSongMicSeatView.m(r0, r14, r15, r18, null, r17, true, true, r8, false, r19, 264);
        return;
    L5:
        r8 = false;
        goto L6
    }
}
