package com.bytedance.android.live.profit.vip;

import com.bytedance.android.livesdk.chatroom.model.v0;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface e extends dy0.d {
    Single<v0> Ti(long r1, int r3);

    void bn(String r1);

    com.bytedance.live.datacontext.i<Boolean> getCanShowVipSingleBadge();

    com.bytedance.live.datacontext.m<Boolean> getHasNewSubscribeEmoji();

    com.bytedance.live.datacontext.m<? extends h> getSubscribeInfo();

    com.bytedance.live.datacontext.i<Boolean> isAnchor();

    com.bytedance.live.datacontext.m<Boolean> isEmojiPanelShow();

    com.bytedance.live.datacontext.m<Boolean> isFirstTimeOpenEmoji();

    void td(b r1);

    b u1();
}
