package com.bytedance.android.live.service.prerequest;

import com.bytedance.android.live.base.model.user.UserProfileDataResp;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a {
    boolean a(String r1);

    void b(String r1);

    boolean c(IRoom r1, UserProfileEvent r2);

    Pair<BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra>, Integer> d(String r1);

    void e(String r1, BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra> r2);
}
