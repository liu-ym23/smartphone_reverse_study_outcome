package com.bytedance.android.livesdk.followtool.utils;

import com.bytedance.android.livesdk.followtool.api.UserSettingApi;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e<T, R> implements Function {
    public final /* synthetic */ Room a;

    public e(Room r1) {
        this.a = r1;
    }

    public final Object apply(Object r3) {
        Boolean r4 = (Boolean) r3;
        return ((UserSettingApi) com.bytedance.android.live.network.c.b().e(UserSettingApi.class)).getUserStockOfFollowRelations(this.a.getRoomId());
    }
}
