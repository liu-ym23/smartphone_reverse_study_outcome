package com.bytedance.android.livesdk.interactivity.textmessage.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.message.model.i7;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends com.bytedance.android.livesdk.interactivity.api.entity.f<i7> implements o {
    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        return null;
    }

    public j(i7 r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        super(r2, 0);
    }

    @Override // com.bytedance.android.livesdk.interactivity.textmessage.model.o
    public final boolean b(IBaseUser r1, ReportObject r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "user");
        Intrinsics.checkNotNullParameter(r2, "report");
        J("text_user");
        UserProfileEvent r4 = new UserProfileEvent(r1);
        r4.setExtraFollowParams(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PROFILE_PUBLIC_SCREEN));
        r4.setClickUserPosition("anchor_public_screen_helper_ai_msg_user");
        xs2.b.a().post(r4);
        return true;
    }
}
