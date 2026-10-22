package com.bytedance.android.live.profit.redpacket;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y<T> implements Consumer {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ Ref.IntRef b;
    public final /* synthetic */ zy0.c c;

    public y(JSONObject r1, Ref.IntRef r2, zy0.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        this.a.put("heart_beat", this.b.element);
        this.b.element++;
        xy0.a<?> r5 = this.c.g();
        if (r5 == null) goto L6;
        r5.sendJsEvent("H5_webcastNotification", this.a);
        return;
    }
}
