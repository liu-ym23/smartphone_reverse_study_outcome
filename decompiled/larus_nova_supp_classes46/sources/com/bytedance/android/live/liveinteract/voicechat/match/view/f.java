package com.bytedance.android.live.liveinteract.voicechat.match.view;

import android.view.View;
import com.bytedance.android.live.liveinteract.voicechat.match.logger.ChatMatchFailReason;
import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ ChatMatchDialog a;

    public f(ChatMatchDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        ChatMatchViewModel r6 = this.a.h;
        if (r6 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual((Boolean) r6.getMatchingState().getValue(), Boolean.TRUE) == false) goto L9;
        gk0.a r0 = this.a.m;
        if (r0 == null) goto L9;
        gk0.a.C0214a r1 = gk0.a.b;
        Integer r2 = (Integer) r6.getMatchType().getValue();
        Boolean r3 = (Boolean) r6.getRematch().getValue();
        r1.getClass();
        r0.b(gk0.a.C0214a.b(r2, r3).getValue(), ChatMatchFailReason.CANCEL.getValue());
    L9:
        r6.release();
        this.a.U90();
    }
}
