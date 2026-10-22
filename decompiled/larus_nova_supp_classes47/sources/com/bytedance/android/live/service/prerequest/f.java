package com.bytedance.android.live.service.prerequest;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.UserProfileDataResp;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ b a;

    public f(b r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        FollowPair r4 = (FollowPair) r3;
        b r0 = this.a;
        Map<String, BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra>> r1 = r0.b;
        m r2 = r0.h.getRoom();
        if (r2 == null) goto L7;
        IRoom r5 = (IRoom) r2.getValue();
        if (r5 == null) goto L7;
        String r6 = r5.getOwnerUserIdString();
    L8:
        BaseResponse r7 = (BaseResponse) ((LinkedHashMap) r1).get(r6);
        if (r7 == null) goto L23;
        UserProfileDataResp r8 = (UserProfileDataResp) r7.data;
        if (r8 == null) goto L24;
        NewProfileUser r9 = r8.profileUser;
        if (r9 == null) goto L26;
        if (r4 == null) goto L25;
        int r10 = r4.followStatus;
        if (r10 == 0) goto L19;
    L21:
        r9.setFollowStatus(r10);
        return;
    L19:
        if (r9.isFollowed() == false) goto L21;
        r10 = 3;
        goto L21
    L25:
        return;
    L26:
        return;
    L24:
        return;
    L23:
        return;
    L7:
        r6 = null;
        goto L8
    }
}
