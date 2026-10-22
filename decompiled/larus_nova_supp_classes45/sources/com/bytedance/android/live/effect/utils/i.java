package com.bytedance.android.live.effect.utils;

import io.reactivex.functions.Consumer;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public i(String r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        HashMap r5 = new HashMap();
        r5.put("live_type", "video_live");
        r5.put("model_name", this.a);
        r5.put("model_id", this.b);
        c.a("livesdk_beauty_model_effective_use", r5, this.c);
    }
}
