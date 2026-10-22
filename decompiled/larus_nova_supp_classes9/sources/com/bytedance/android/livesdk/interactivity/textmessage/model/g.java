package com.bytedance.android.livesdk.interactivity.textmessage.model;

import android.text.Spannable;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.entity.SpannableType;
import com.bytedance.bdlocation.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends com.bytedance.android.livesdk.interactivity.api.entity.f<com.bytedance.android.live.base.model.message.t> {
    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Spannable f() {
        String r0 = this.b.getBaseMessage().getDescribe();
        SpannableType r1 = SpannableType.NORMAL;
        int r2 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
        return i0.b(r0, i0.a(2131107646));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final tb2.d w() {
        String r0 = this.b.getBaseMessage().getDescribe();
        if (r0 != null) goto L5;
        r0 = BuildConfig.FLAVOR;
    L5:
        tb2.d r1 = new tb2.d();
        r1.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(r0));
        return r1;
    }

    public g(com.bytedance.android.live.base.model.message.t r2) {
        super(r2, 0);
    }
}
