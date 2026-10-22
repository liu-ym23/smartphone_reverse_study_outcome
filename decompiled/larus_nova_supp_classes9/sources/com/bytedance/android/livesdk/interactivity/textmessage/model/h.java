package com.bytedance.android.livesdk.interactivity.textmessage.model;

import android.text.Spannable;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.q0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.interactivity.api.entity.SpannableType;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h extends com.bytedance.android.livesdk.interactivity.api.entity.f<q0> {
    public final String K() {
        com.bytedance.live.datacontext.m r0 = jc1.k.f(IRoomContextService.class).getRoomDataContext(null, 0).getRoom();
        if (r0 == null) goto L12;
        if (r0.getValue() == null) goto L12;
        if (((IRoom) r0.getValue()).getOwner() == null) goto L12;
        if (TextUtils.equals(((IRoom) r0.getValue()).getOwner().getIdString(), jc1.k.f(IMiddlewareUserService.class).user().n()) == false) goto L12;
        return this.b.H1();
    L12:
        return this.b.c0();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final int k() {
        SpannableType r0 = SpannableType.NORMAL;
        return i0.a(2131107651);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final int r() {
        SpannableType r0 = SpannableType.NORMAL;
        int r1 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
        com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a(this.i);
        return i0.a(2131107646);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final tb2.d w() {
        tb2.d r0 = new tb2.d();
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(this.b.getUser(), null, false, this.e));
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(" "));
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(K()));
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        return this.b.getUser();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Spannable f() {
        String r2 = K();
        IBaseUser r0 = this.b.getUser();
        SpannableType r3 = SpannableType.NORMAL;
        int r4 = com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a;
        com.bytedance.android.livesdk.interactivity.textmessage.utils.k.a(this.i);
        return i0.c(r0, "：", r2, i0.a(2131107646), i0.a(2131107651), null);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final boolean E(g52.c r2) {
        if (x() != null) goto L6;
        return false;
    L6:
        UserProfileEvent r3 = new UserProfileEvent(x());
        r3.setReportType("data_card_incomeinfo");
        r3.setClickUserPosition("personal_profile");
        r3.setExtraFollowParams(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PROFILE_PUBLIC_SCREEN));
        xs2.b.a().post(r3);
        return true;
    }

    public h(q0 r1, MessageSceneType r2) {
        super(r1, r2);
    }
}
