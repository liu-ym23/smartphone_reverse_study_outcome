package com.bytedance.android.livesdk.interactivity.textmessage.model;

import android.text.Spannable;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.entity.SpannableType;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends com.bytedance.android.livesdk.interactivity.api.entity.f<com.bytedance.android.live.base.model.message.o> {
    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Spannable f() {
        com.bytedance.android.livesdk.message.model.l.a r0 = this.b.J();
        if (r0 == null) goto L6;
        String r1 = r0.a();
        if (r1 == null) goto L6;
    L7:
        SpannableType r2 = SpannableType.NORMAL;
        int r3 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
        return i0.b(r1, i0.a(2131107646));
    L6:
        r1 = BuildConfig.FLAVOR;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final tb2.d w() {
        tb2.d r0 = new tb2.d();
        com.bytedance.android.livesdk.message.model.l.a r1 = this.b.J();
        if (r1 == null) goto L6;
        String r2 = r1.a();
        if (r2 == null) goto L6;
    L7:
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(r2));
        return r0;
    L6:
        r2 = BuildConfig.FLAVOR;
        goto L7
    }

    public a(com.bytedance.android.live.base.model.message.o r2, MessageSceneType r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "sceneType");
        super(r2, r3);
    }
}
