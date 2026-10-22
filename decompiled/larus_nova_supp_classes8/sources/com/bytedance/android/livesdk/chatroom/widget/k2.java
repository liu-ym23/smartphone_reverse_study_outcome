package com.bytedance.android.livesdk.chatroom.widget;

import android.view.View;
import com.bytedance.android.live.base.model.user.BorderInfo;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdkapi.depend.model.live.abs.IVSCompatRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k2 implements View.OnClickListener {
    public final /* synthetic */ VSAnchorInfoWidget a;

    public k2(VSAnchorInfoWidget r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        long r0 = System.currentTimeMillis();
        VSAnchorInfoWidget r7 = this.a;
        if ((r0 - r7.p) >= 1000) goto L5;
        return;
    L5:
        r7.p = System.currentTimeMillis();
        IVSCompatRoom r8 = com.bytedance.android.live.core.utils.z.q(((Widget) this.a).dataCenter);
        if (r8 == null) goto L15;
        User r9 = r8.getOwner();
        if (r9 == null) goto L16;
        xs2.b r1 = xs2.b.a();
        UserProfileEvent r2 = new UserProfileEvent(r9);
        r2.setClickUserPosition("live_open_top_left_anchor");
        r2.mSource = "anchor_profile";
        BorderInfo r10 = r9.getBorder();
        if (r10 == null) goto L12;
        String r11 = r10.getDressId();
    L13:
        r2.wearId = r11;
        r2.setReportType("data_card_anchor");
        r2.setExtraFollowParams(com.bytedance.android.livesdk.user.j.b(LiveFollowScene.VS_USER_PROFILE));
        Unit r12 = Unit.INSTANCE;
        r1.post(r2);
        return;
    L12:
        r11 = null;
        goto L13
    L16:
        return;
    }
}
