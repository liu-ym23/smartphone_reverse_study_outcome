package com.bytedance.android.livesdk.chatroom.ui.framework.widget.room;

import com.bytedance.android.livesdk.chatroom.model.EnterRoomExtra;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l implements Runnable {
    public final /* synthetic */ RoomManageWidget a;
    public final /* synthetic */ vlc.d b;
    public final /* synthetic */ EnterRoomExtra c;

    public l(RoomManageWidget r1, vlc.d r2, EnterRoomExtra r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        this.b.j(this.c.memberMessage, true);
        ((Widget) this.a).dataCenter.put("data_member_message", this.c.memberMessage);
        ((Widget) this.a).dataCenter.put("data_is_need_to_filter_self_enter_msg", Boolean.TRUE);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
