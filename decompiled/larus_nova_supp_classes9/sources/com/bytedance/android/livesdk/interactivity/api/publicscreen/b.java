package com.bytedance.android.livesdk.interactivity.api.publicscreen;

import com.bytedance.android.livesdk.interactivity.api.barrage.data.ChatCarnivalDataSyncModel;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.GeneralCarnivalDataSyncModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface b {
    com.bytedance.live.datacontext.n<String> getAppData();

    com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.interactivity.api.barrage.data.d> getChatCarnivalMessage();

    com.bytedance.live.datacontext.j<ChatCarnivalDataSyncModel> getChatCarnivalSyncModel();

    com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.barrage.data.g> getContour();

    com.bytedance.live.datacontext.j<o22.d> getDanmakuCarnivalManager();

    com.bytedance.live.datacontext.j<GeneralCarnivalDataSyncModel> getGeneralCarnivalSyncModel();

    com.bytedance.live.datacontext.m<Integer> getWaitDanmakuCountEnum();

    com.bytedance.live.datacontext.m<com.bytedance.android.livesdk.interactivity.api.publicscreen.model.a> getWaitMessageState();

    boolean hasCleared();

    com.bytedance.live.datacontext.m<Boolean> isCarnivalStarted();

    com.bytedance.live.datacontext.m<Boolean> isDanmakuVisible();

    com.bytedance.live.datacontext.m<Boolean> isInCarnival();

    com.bytedance.live.datacontext.m<Boolean> isWarmingUp();
}
