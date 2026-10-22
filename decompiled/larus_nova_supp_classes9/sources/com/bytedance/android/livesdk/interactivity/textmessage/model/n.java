package com.bytedance.android.livesdk.interactivity.textmessage.model;

import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.r2;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.textmessage.render.TextMessageSpanAction;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n extends com.bytedance.android.livesdk.interactivity.api.entity.f<r2> {
    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final tb2.d w() {
        String r0 = " " + this.b.getGuestInviteContent().a().getDefaultPattern().substring(20);
        IBaseUser r1 = ((c5) ListProtector.get(this.b.getGuestInviteContent().a().getPieces(), 1)).getUserValue().getUser();
        IBaseUser r2 = ((c5) ListProtector.get(this.b.getGuestInviteContent().a().getPieces(), 0)).getUserValue().getUser();
        tb2.d r4 = new tb2.d();
        int r5 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.a;
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        r4.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(r2, null, false, false).setClickAction(TextMessageSpanAction.INVITEE_NAME));
        r4.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(" 被 "));
        Intrinsics.checkNotNullParameter(r1, "userInfo");
        Intrinsics.checkNotNullParameter(r1, "userInfo");
        r4.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(r1, null, false, false).setClickAction(TextMessageSpanAction.INVITOR_NAME));
        r4.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(r0));
        return r4;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final int k() {
        return i0.a(2131107651);
    }

    public n(r2 r2) {
        super(r2, 0);
    }
}
