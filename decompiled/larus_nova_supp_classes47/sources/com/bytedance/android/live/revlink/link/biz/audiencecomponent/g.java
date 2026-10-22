package com.bytedance.android.live.revlink.link.biz.audiencecomponent;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ MultiAudienceSeiComponent a;

    public g(MultiAudienceSeiComponent r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        MultiAudienceSeiComponent r0 = this.a;
        r0.getClass();
        String r1 = com.bytedance.android.live.revlink.link.biz.service.e.a.a(r0);
        jy0.b.b(r1, "", (Throwable) r3);
    }
}
