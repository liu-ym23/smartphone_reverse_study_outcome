package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k<T> implements Consumer {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        Intrinsics.checkNotNullParameter(r4, "e");
        int r0 = VideoTalkRoomApplyCancelDialog.e;
        ALogger.e("VideoTalkRoomApplyCancelDialog", "LinkAudienceApi#getUserWaitingRankPosition()失败", r4);
    }
}
