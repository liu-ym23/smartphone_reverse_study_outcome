package com.bytedance.android.live.liveinteract.interact.audience.fragment;

import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ IBaseUser a;
    public final /* synthetic */ l b;
    public final /* synthetic */ ILinkPlayerInfoBridge c;

    public n(IBaseUser r1, l r2, ILinkPlayerInfoBridge r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (this.b.getType() == 0) goto L5;
    L8:
        xs2.b.a().post(new UserProfileEvent(this.a).setClickUserPosition("pk_linked_audience").setReportSource("audience_audio").setReportType("data_card_linked_audience"));
        return;
    L5:
        if (this.c.isAnonymous() == false) goto L8;
        ALogger.i("ttlive_interact_audience_item_binder", "click on the anonymous user avatar for apply , do not pull up the profile card");
        f2.c(s1.B(2131918948), 0);
    }
}
