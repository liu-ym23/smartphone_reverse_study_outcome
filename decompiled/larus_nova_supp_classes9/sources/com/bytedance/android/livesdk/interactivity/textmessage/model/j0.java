package com.bytedance.android.livesdk.interactivity.textmessage.model;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.message.model.ac;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j0 extends com.bytedance.android.livesdk.interactivity.api.entity.f<ac> implements o {
    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final boolean G(Context r1) {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final IBaseUser x() {
        return this.b.getUser();
    }

    public j0(ac r2) {
        super(r2, 0);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.entity.f
    public final void i(HashMap<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "extra");
        ac r0 = this.b;
        if (r0 == null) goto L10;
        IPublicAreaCommon r1 = r0.getOrInitPublicAreaCommon();
        if (r1 == null) goto L10;
        Map r2 = r1.getTrackingParams();
        if (r2 == null) goto L10;
        String r4 = (String) r2.get("msg_show_type");
        if (r4 == null) goto L10;
    L11:
        r3.put("msg_show_type", r4);
        return;
    L10:
        r4 = "public_screen_similar_gather";
        goto L11
    }

    @Override // com.bytedance.android.livesdk.interactivity.textmessage.model.o
    public final boolean b(IBaseUser r3, ReportObject r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "report");
        J("text_user");
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, "report");
        UserProfileEvent r6 = new UserProfileEvent(r3);
        r6.setExtraFollowParams(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PROFILE_PUBLIC_SCREEN));
        xs2.b.a().post(r6);
        return true;
    }
}
