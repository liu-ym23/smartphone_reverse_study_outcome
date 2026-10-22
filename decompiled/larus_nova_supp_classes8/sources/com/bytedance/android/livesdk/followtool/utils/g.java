package com.bytedance.android.livesdk.followtool.utils;

import android.util.Log;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ Room a;

    public g(Room r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        ALogger.e("XTFollowSyncUtils", "tryShowStockOfFollowDialog error, roomId = " + this.a.getRoomId() + ", " + Log.getStackTraceString((Throwable) r4));
    }
}
