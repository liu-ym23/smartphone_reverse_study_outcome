package com.bytedance.android.live.profile.usecase;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.p000enum.ProfileMode;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a {
    IRoom getLiveRoom();

    NewProfileTrackUseCase getLogUseCase();

    r getNewProfileRequestManager();

    q getPageTypeUseCase();

    ProfileMode getProfileMode();

    ProfileMonitor getProfileMonitor();

    ps0.b getRoom();

    DataCenter getRoomDataCenter();

    IBaseUser getRoomUser();

    NewProfileUser getTargetUser();

    Map<String, String> getTargetUserBizExtra();

    UserProfileEvent getUserProfileEvent();

    boolean isVertical();

    boolean loadUserSuccess();
}
