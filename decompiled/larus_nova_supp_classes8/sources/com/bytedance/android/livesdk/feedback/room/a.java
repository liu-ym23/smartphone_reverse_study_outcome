package com.bytedance.android.livesdk.feedback.room;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface a {
    k<Long> getOnRoomBackgroundEvent();

    k<Long> getOnRoomForegroundEvent();

    n<? extends ILiveRoomPlayFragment.LiveRoomListener> getRoomListener();

    m<? extends Boolean> isHideViewsOnClearScreen();

    void notifyOnBackground(long r1);

    void notifyOnForeground(long r1);

    void updateRoomListener(ILiveRoomPlayFragment.LiveRoomListener r1);
}
