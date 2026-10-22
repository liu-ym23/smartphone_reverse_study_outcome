package com.bytedance.android.live.componentsmarket.impl.components.close;

import am2.x;
import android.view.View;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ RoomCloseWidget a;
    public final /* synthetic */ Map b;

    public c(RoomCloseWidget r1, Map r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        u.l().sendLog("livesdk_leave_icon_click", this.b, new Object[]{IRoom.class, x.class});
        int r0 = b.a;
        new a((d90.a) this.a.K()).onClick(r6);
    }
}
