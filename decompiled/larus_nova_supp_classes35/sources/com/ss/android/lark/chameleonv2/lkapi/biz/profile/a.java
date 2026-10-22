package com.ss.android.lark.chameleonv2.lkapi.biz.profile;

import com.ss.android.lark.im.sdk.service.h;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a<T> implements RxScheduledExecutor.Producer {
    public final /* synthetic */ BizProfile a;
    public final /* synthetic */ IBizProfile$OpenProfileRequest b;

    public a(BizProfile r1, IBizProfile$OpenProfileRequest r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object produce() {
        h r0 = (h) this.a.a.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.ue(this.b.getUserId());
    }
}
