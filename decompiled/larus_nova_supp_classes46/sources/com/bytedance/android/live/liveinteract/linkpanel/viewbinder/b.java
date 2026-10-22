package com.bytedance.android.live.liveinteract.linkpanel.viewbinder;

import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ IBaseUser a;

    public b(IBaseUser r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        xs2.b.a().post(new UserProfileEvent(this.a).setClickUserPosition("pk_linked_audience").setReportSource("audience_audio").setReportType("data_card_linked_audience"));
    }
}
