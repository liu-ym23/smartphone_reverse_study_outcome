package com.bytedance.android.livesdk.interactivity.textmessage.model;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.message.model.l8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.message.Text;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p extends com.bytedance.android.livesdk.interactivity.api.entity.f<l8> {
    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final tb2.d w() {
        com.bytedance.android.livesdk.message.model.g0 r0 = this.b.getAudienceOrderSongChatContent();
        if (r0 == null) goto L5;
        IRoomContextService r1 = jc1.k.f(IRoomContextService.class);
        if (r0.displayUserRole == false) goto L21;
        IBaseUser r2 = r0.userInfo;
        if (r2 == null) goto L21;
        String r3 = r2.getNickName();
        if (r0.userInfo.getUserAttrExt() != null) goto L13;
    L15:
        if (r1 != null) goto L17;
    L19:
        r0.userInfo.setNickName(r3);
        goto L21
    L17:
        if (TextUtils.equals(r0.userInfo.getIdString(), ((IRoom) r1.getRoomDataContext(null, 0).getRoom().getValue()).getOwnerUserIdString()) == false) goto L19;
        r3 = r3 + s1.B(2131920338);
        goto L19
    L13:
        if (r0.userInfo.getUserAttrExt().isAdmin() == false) goto L15;
        r3 = r3 + s1.B(2131920337);
    L21:
        if (r0.displayText == null) goto L27;
        if (r0.userInfo == null) goto L27;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        com.bytedance.android.livesdk.interactivity.service.textrender.core.x r4 = com.bytedance.android.livesdk.interactivity.service.textrender.core.r.b;
        Text r5 = r0.displayText;
        yb2.a r6 = j();
        Intrinsics.checkNotNullParameter(r5, "text");
        tb2.d r7 = com.bytedance.android.livesdk.interactivity.service.textrender.core.r.a(r5, r6);
        r7.e(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(" "));
        IBaseUser r8 = r0.userInfo;
        Intrinsics.checkNotNullParameter(r8, "userInfo");
        Intrinsics.checkNotNullParameter(r8, "userInfo");
        r7.e(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(r8, null, false, false));
        return r7;
    L27:
        return new tb2.d();
    L5:
        return new tb2.d();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        if (this.b.getAudienceOrderSongChatContent() != null) goto L7;
        return null;
    L7:
        return this.b.getAudienceOrderSongChatContent().userInfo;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final yb2.a j() {
        yb2.a r0 = super.j();
        r0.d = 0;
        return r0;
    }

    public p(l8 r2) {
        super(r2, 0);
    }
}
