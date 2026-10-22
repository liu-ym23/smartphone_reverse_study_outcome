package com.bytedance.android.live.livepkaudience.emoji.panel;

import am2.x;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends g {
    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final int c() {
        return 2131251737;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final String d() {
        return s1.B(2131919247);
    }

    public a(f r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        super(r2);
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final void e(View r5) {
        Intrinsics.checkNotNullParameter(r5, "v");
        this.a.w5();
        HashMap r6 = new HashMap();
        int r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        el0.j.j(r6, Integer.valueOf(r0));
        el0.j.o(r6);
        el0.j.l(r6, r0);
        r6.put("click_source", "emoji_panel");
        u.l().sendLog("livesdk_guest_connection_user_beauty_click", r6, new Object[]{Room.class, x.class});
    }
}
