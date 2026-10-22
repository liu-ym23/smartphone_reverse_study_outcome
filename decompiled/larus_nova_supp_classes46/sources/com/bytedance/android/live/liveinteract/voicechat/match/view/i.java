package com.bytedance.android.live.liveinteract.voicechat.match.view;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.model.b1;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ ChatMatchDialog a;

    public i(ChatMatchDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        ChatMatchDialog r5 = this.a;
        ChatMatchViewModel r0 = r5.h;
        if (r0 == null) goto L14;
        MutableLiveData<b1> r1 = r0.getMatchData();
        if (r1 == null) goto L15;
        b1 r2 = (b1) r1.getValue();
        if (r2 == null) goto L16;
        IBaseUser r3 = r2.getMatchedUser();
        if (r3 == null) goto L17;
        UserProfileEvent r6 = new UserProfileEvent(r3.getIdString());
        r6.user = r3;
        DataCenter r7 = r5.i;
        if (r7 == null) goto L18;
        r7.put("cmd_show_user_profile", r6);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }
}
