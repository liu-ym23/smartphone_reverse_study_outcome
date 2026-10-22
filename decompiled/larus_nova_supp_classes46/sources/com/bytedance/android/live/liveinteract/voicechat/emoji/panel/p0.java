package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p0 extends g {
    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        return 2131251832;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        return s1.B(2131921134);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final boolean l() {
        Integer r0 = je0.d.h();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.intValue() != 30) goto L13;
        Boolean r1 = (Boolean) com.bytedance.android.livesdk.sharedpref.c.E0.getValue();
        Long r2 = (Long) com.bytedance.android.livesdk.sharedpref.c.F0.getValue();
        if (r1.booleanValue() == false) goto L10;
        return false;
    L10:
        if ((System.currentTimeMillis() - r2.longValue()) > (-1702967296)) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    public p0(q0 r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        super(r2);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        this.e.T();
        Integer r3 = je0.d.h();
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.intValue() != 30) goto L9;
        com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.c.E0;
        Boolean r0 = Boolean.TRUE;
        r4.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r4, r0);
        return;
    }
}
