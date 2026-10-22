package com.bytedance.android.livesdk.interactivity.textmessage.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.entity.PublicScreenRichTextUtilsKt;
import com.bytedance.android.livesdk.interactivity.api.entity.SpannableType;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u extends v {
    @Override // com.bytedance.android.livesdk.interactivity.textmessage.model.v, com.bytedance.android.livesdk.interactivity.api.entity.f
    public final int k() {
        return v.K(SpannableType.DISPLAY_TEXT, true, false);
    }

    @Override // com.bytedance.android.livesdk.interactivity.textmessage.model.v, com.bytedance.android.livesdk.interactivity.api.entity.f
    public final int r() {
        SpannableType r0 = SpannableType.NORMAL;
        return L(true);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final tb2.d w() {
        tb2.d r0 = new tb2.d();
        IBaseUser r1 = x();
        int r2 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.a;
        Intrinsics.checkNotNullParameter(r1, "userInfo");
        Intrinsics.checkNotNullParameter(r1, "userInfo");
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(r1, null, false, false));
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(tb2.c.DEFAULT_TEXT));
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(this.b.getActionContent()));
        return r0.a(PublicScreenRichTextUtilsKt.c(this.b.getOrInitPublicAreaCommon(), j()));
    }

    public u(va r1, MessageSceneType r2) {
        super(r1, r2);
    }
}
