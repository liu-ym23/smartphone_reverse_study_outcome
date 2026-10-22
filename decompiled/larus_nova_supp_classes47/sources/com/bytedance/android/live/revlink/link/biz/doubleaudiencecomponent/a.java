package com.bytedance.android.live.revlink.link.biz.doubleaudiencecomponent;

import com.bytedance.android.live.revlink.impl.utils.v;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ DoubleAudiencePKComponent a;

    public a(DoubleAudiencePKComponent r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Integer r4 = (Integer) r3;
        this.a.getClass();
        DoubleAudiencePKComponent.b(true);
        DoubleAudiencePKComponent r0 = this.a;
        r0.d = true;
        v r5 = r0.e;
        r5.getClass();
        r5.b("delay_sync_done", new JSONObject());
    }
}
