package com.bytedance.android.live.broadcastgame.opengame;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface i {

    public interface a {
        void a(Throwable r1);

        void onInitSuccess();
    }

    void initDebug(Context r1, DataCenter r2, ViewGroup r3, com.bytedance.android.live.broadcastgame.api.openplatform.b r4, Map<String, ? extends Object> r5, a r6);

    void releaseDebug();

    void stopDebug();
}
