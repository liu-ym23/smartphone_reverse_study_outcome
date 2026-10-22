package com.bytedance.android.live.room.navi.userinfo_p.utils;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final String a;
    public final DataCenter b;
    public final IRoom c;

    public c(DataCenter r2, IRoom r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.b = r2;
        this.c = r3;
        this.a = "UserInfoFollowLogUtil";
    }
}
