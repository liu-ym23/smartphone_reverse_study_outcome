package com.bytedance.android.live.liveinteract.linkpanel.list;

import android.view.View;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ BaseTalkGuestSearchViewHolder a;
    public final /* synthetic */ HashMap b;

    public e(BaseTalkGuestSearchViewHolder r1, HashMap r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        j0.l().sendLog("livesdk_invitation_search_click", this.b, new Object[]{IRoom.class});
        v r6 = this.a.a;
        if (r6 == null) goto L6;
        r6.a();
        return;
    }
}
