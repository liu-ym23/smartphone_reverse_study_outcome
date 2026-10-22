package com.bytedance.android.livesdk.interactivity.textmessage.model;

import android.text.Spannable;
import com.bytedance.android.live.base.model.message.n0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.entity.SpannableType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f extends com.bytedance.android.livesdk.interactivity.api.entity.f<n0> {
    public final boolean G;

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Spannable f() {
        String r0 = this.b.getActionString(this.G);
        SpannableType r1 = SpannableType.NORMAL;
        int r2 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
        return i0.b(r0, i0.a(2131107646));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final tb2.d w() {
        tb2.d r0 = new tb2.d();
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(this.b.getActionString(this.G)));
        return r0;
    }

    public f(n0 r2, boolean r3) {
        super(r2, 0);
        this.G = r3;
    }
}
