package com.bytedance.android.livesdk.interactivity.like;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ d a;

    public j(d r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Response r4 = (Response) r3;
        ALogger.i("DiggHandler", "digg success, room id: " + this.a.d + ", target uid " + this.a.e + "; current diggCount: " + this.a.b);
    }
}
