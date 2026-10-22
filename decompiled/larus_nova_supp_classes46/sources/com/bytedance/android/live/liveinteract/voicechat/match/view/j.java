package com.bytedance.android.live.liveinteract.voicechat.match.view;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.voicechat.match.logger.JumpType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ ChatMatchDialog a;

    public j(ChatMatchDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ALogger.i("ChatMatchDialog", "user jump.");
        ek0.c r3 = this.a.s;
        if (r3 == null) goto L6;
        ek0.c.a(r3, JumpType.CLICK.getValue());
        return;
    }
}
