package com.bytedance.android.livesdk.interactivity.textmessage.model;

import android.text.Spannable;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.interactivity.api.entity.SpannableType;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdkapi.depend.live.MessageSceneType;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l extends com.bytedance.android.livesdk.interactivity.api.entity.f<kc2.b> {
    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final Spannable f() {
        String r0 = ((kc2.b) this.b).c;
        String r6 = e();
        if (TextUtils.isEmpty(r0) == true) goto L5;
        r0 = r0 + " ";
    L5:
        String r3 = r0;
        IBaseUser r1 = ((kc2.b) this.b).a;
        SpannableType r2 = SpannableType.GAME;
        return i0.c(r1, " ", r3, com.bytedance.android.livesdk.interactivity.textmessage.utils.h.b(r2, this.e, this.i), com.bytedance.android.livesdk.interactivity.textmessage.utils.h.a(r2, this.e), r6);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final int k() {
        return com.bytedance.android.livesdk.interactivity.textmessage.utils.h.a(SpannableType.DISPLAY_TEXT, this.e);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final int r() {
        return com.bytedance.android.livesdk.interactivity.textmessage.utils.h.b(SpannableType.DISPLAY_TEXT, this.e, this.i);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final tb2.d w() {
        tb2.d r0 = new tb2.d();
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(((kc2.b) this.b).a, null, false, this.e));
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(" "));
        r0.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(((kc2.b) this.b).c));
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        return ((kc2.b) this.b).a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final boolean E(g52.c r2) {
        if (x() != null) goto L6;
        return false;
    L6:
        UserProfileEvent r3 = new UserProfileEvent(x());
        r3.setReportType("data_card_sendgiftinfo");
        r3.setClickUserPosition("personal_profile");
        r3.setExtraFollowParams(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PROFILE_PUBLIC_SCREEN));
        xs2.b.a().post(r3);
        J("default_user");
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final void i(HashMap<String, String> r3) {
        r3.put("gift_id", String.valueOf(((kc2.b) this.b).b));
    }

    public l(kc2.b r2, MessageSceneType r3) {
        super(r2, r3, 0);
    }
}
