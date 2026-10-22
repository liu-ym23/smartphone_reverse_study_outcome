package com.bytedance.android.live.profile;

import android.view.View;
import com.bytedance.android.live.profile.monitor.EventType;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.p000enum.ProfileMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ NewLiveProfileDialogFragment a;

    public c(NewLiveProfileDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        ProfileMonitor r6 = this.a.q;
        if (r6 == null) goto L5;
        r6.g(EventType.ClickOutside);
    L5:
        NewLiveProfileDialogFragment r7 = this.a;
        com.bytedance.android.live.profile.seeselftransition.a r0 = r7.n;
        ProfileMode r1 = null;
        if (r0 == null) goto L14;
        com.bytedance.android.live.profile.model.c r2 = r7.i;
        if (r2 == null) goto L10;
        ProfileMode r3 = r2.h;
    L12:
        if (r3 == ProfileMode.NONE) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L23;
        if (r0 == null) goto L25;
        com.bytedance.android.live.profile.model.c r8 = r7.i;
        if (r8 == null) goto L20;
        r1 = r8.h;
    L20:
        if (r1 != null) goto L22;
        r1 = ProfileMode.NEVER;
    L22:
        r0.a(r1, r7);
        return;
    L25:
        return;
    L23:
        r7.T90().prepareExit();
        return;
    L10:
        r3 = null;
    L14:
        r4 = false;
        goto L15
    }
}
