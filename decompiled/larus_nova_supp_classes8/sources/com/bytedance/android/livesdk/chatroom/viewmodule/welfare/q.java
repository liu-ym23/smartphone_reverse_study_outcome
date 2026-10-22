package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q implements lm3.c.a {
    public final /* synthetic */ WelfareAnchorServiceWidget b;

    public q(WelfareAnchorServiceWidget r1) {
        this.b = r1;
    }

    public final void onAction(lm3.d r13) {
        WelfareAnchorServiceWidget r14 = this.b;
        RoomContext r0 = r14.getDataContext();
        if (r0 == null) goto L7;
        r14.b.add(((IWelfareApi) r14.a.getValue()).operateWelfareProject(3, ((Room) r0.getRoom().getValue()).id, ((Room) r0.getRoom().getValue()).getOwnerUserIdString(), r14.c, r14.d).compose(RxUtil.rxSchedulerHelper()).subscribe(new m(r14), n.a));
        return;
    }
}
