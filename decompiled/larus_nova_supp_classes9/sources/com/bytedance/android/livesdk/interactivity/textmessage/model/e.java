package com.bytedance.android.livesdk.interactivity.textmessage.model;

import android.text.Spannable;
import com.bytedance.android.live.base.model.message.l0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.entity.SpannableType;
import com.bytedance.bdlocation.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends com.bytedance.android.livesdk.interactivity.api.entity.f<l0> {
    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Spannable g() {
        return sb2.a.h(this.b.getBaseMessage().getDisplayText(), BuildConfig.FLAVOR, false);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final int k() {
        SpannableType r0 = SpannableType.NORMAL;
        int r1 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
        return i0.a(2131107651);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Spannable f() {
        return g();
    }

    public e(l0 r2) {
        super(r2, 0);
    }
}
