package com.bytedance.android.live.profit.taskcenter.preload;

import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ long c;
    public final /* synthetic */ String d;

    public g(d r1, JSONObject r2, long r3, String r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    public final void accept(Object r7) {
        Long r8 = (Long) r7;
        wp2.g r9 = new wp2.g(this.b, new d.b(new WeakReference(this.a), this.c, this.d));
        vh6.c.b(rq2.a.class).yc(r9);
    }
}
