package com.bytedance.android.live.liveinteract.voicechat.match.view;

import android.view.View;
import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ ChatMatchDialog a;

    public g(ChatMatchDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        ChatMatchViewModel r5 = this.a.h;
        if (r5 == null) goto L8;
        r5.release();
        this.a.U90();
        gk0.a r0 = this.a.m;
        if (r0 == null) goto L8;
        gk0.a.C0214a r1 = gk0.a.b;
        Integer r2 = (Integer) r5.getMatchType().getValue();
        Boolean r6 = (Boolean) r5.getRematch().getValue();
        r1.getClass();
        r0.a(gk0.a.C0214a.b(r2, r6).getValue(), "cancel_play");
    L8:
        if (Intrinsics.areEqual(ChatMatchWidget.o, "apply_panel") == false) goto L13;
        this.a.U90();
        DataCenter r7 = this.a.i;
        if (r7 == null) goto L14;
        r7.put("cmd_show_guest_apply_dialog", Boolean.TRUE);
        return;
    L14:
        return;
    }
}
