package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.welfare.utils.WelfareAppLogger;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s implements hm3.b {
    public final /* synthetic */ WelfareAnchorServiceWidget a;

    public s(WelfareAnchorServiceWidget r1) {
        this.a = r1;
    }

    public final void a(gm3.a r14) {
        Intrinsics.checkNotNullParameter(r14, "item");
        WelfareAnchorServiceWidget r0 = this.a;
        RoomContext r1 = r0.getDataContext();
        if (r1 == null) goto L10;
        long r11 = r14.a;
        if (r11 <= 0) goto L9;
        WelfareAppLogger.f(r11);
        r0.b.add(((IWelfareApi) r0.a.getValue()).operateWelfareProject(2, ((Room) r1.getRoom().getValue()).id, ((Room) r1.getRoom().getValue()).getOwnerUserIdString(), r0.c, r11).compose(RxUtil.rxSchedulerHelper()).subscribe(new o(r0, r14), p.a));
        return;
    L9:
        return;
    }
}
