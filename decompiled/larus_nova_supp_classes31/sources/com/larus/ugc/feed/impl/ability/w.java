package com.larus.ugc.feed.impl.ability;

import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.larus.ugc.feed.api.model.UserCreationTrackParamsKmp;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class w {
    public static final UserCreationKmp a(UserCreationKmp r41, int r42) {
        UserCreationTrackParamsKmp r0 = r41.getClientTrackParams();
        if (r0 != null) goto L6;
        r0 = new UserCreationTrackParamsKmp(null, null, null, null, null, null, null, 127, null);
    L6:
        return UserCreationKmp.copy$default(r41, null, 0, null, null, null, null, null, null, null, null, null, null, null, UserCreationTrackParamsKmp.copy$default(r0, null, null, Integer.valueOf(r42), null, null, null, null, 123, null), null, null, null, 122879, null);
    }
}
