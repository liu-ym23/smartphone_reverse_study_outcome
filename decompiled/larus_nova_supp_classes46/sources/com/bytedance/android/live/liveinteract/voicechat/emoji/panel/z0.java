package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z0 extends g {
    public int f;
    public int g;
    public final String h;

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        int r0 = li0.d.c(this.h);
        if (TeamFightContext.Companion.d() == false) goto L9;
        if (r0 != 1) goto L7;
        return 2131251843;
    L7:
        return 2131251841;
    L9:
        if (r0 != 2) goto L11;
        return 2131251842;
    L11:
        return 2131251844;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        if (li0.d.c(this.h) != 1) goto L6;
        return s1.B(2131915771);
    L6:
        return s1.B(2131915772);
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r7) {
        Intrinsics.checkNotNullParameter(r7, "v");
        if (TeamFightContext.Companion.d() == false) goto L5;
        this.e.e5(this.g, this.f, 0, this.h);
        return;
    L5:
        f2.c(s1.B(2131915773), 0);
    }

    public z0(q0 r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "action");
        Intrinsics.checkNotNullParameter(r4, "userId");
        super(r3);
        this.h = r4;
        this.f = -1;
        int r0 = 2;
        if (li0.d.c(r4) != 1) goto L5;
        int r5 = 2;
    L6:
        this.f = r5;
        if (r4.length() != 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == true) goto L13;
        r0 = 1;
    L13:
        this.g = r0;
        if (TeamFightContext.Companion.d() == false) goto L16;
        int r7 = s1.h(2131106994);
    L17:
        this.d = r7;
        return;
    L16:
        r7 = s1.h(2131106995);
        goto L17
    L9:
        r6 = false;
        goto L10
    L5:
        r5 = 1;
        goto L6
    }
}
