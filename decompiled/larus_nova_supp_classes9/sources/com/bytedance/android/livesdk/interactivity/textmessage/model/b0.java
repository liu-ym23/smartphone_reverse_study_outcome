package com.bytedance.android.livesdk.interactivity.textmessage.model;

import com.bytedance.android.live.base.model.message.b4;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.bdlocation.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b0 extends com.bytedance.android.livesdk.interactivity.api.entity.f<b4> {
    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final tb2.d w() {
        tb2.d r0 = new tb2.d();
        if (this.b.g() == null) goto L5;
        String r1 = this.b.g();
    L6:
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(r1));
        return r0;
    L5:
        r1 = BuildConfig.FLAVOR;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        return this.b.getUser();
    }

    public b0(b4 r2) {
        super(r2, 7);
    }
}
