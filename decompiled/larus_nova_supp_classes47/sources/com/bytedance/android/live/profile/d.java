package com.bytedance.android.live.profile;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profile.monitor.EventType;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.p000enum.ProfileMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements DialogInterface.OnKeyListener {
    public final /* synthetic */ NewLiveProfileDialogFragment a;

    public d(NewLiveProfileDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r5, int r6, KeyEvent r7) {
        StringBuilder r0 = new StringBuilder("dialog: ");
        ProfileMode r1 = null;
        if (r5 == null) goto L5;
        String r8 = r5.toString();
    L6:
        r0.append(r8);
        r0.append(", keyCode: ");
        r0.append(r6);
        r0.append(", event: ");
        if (r7 == null) goto L9;
        String r9 = r7.toString();
    L10:
        r0.append(r9);
        ALogger.i(NewProfileInfoViewModel.TAG, r0.toString());
        boolean r2 = false;
        if (r6 != 4) goto L38;
        if (r7 != null) goto L14;
        return false;
    L14:
        if (r7.getAction() != 1) goto L40;
        ALogger.i(NewProfileInfoViewModel.TAG, "keyCode is back");
        ProfileMonitor r10 = this.a.q;
        if (r10 == null) goto L18;
        r10.g(EventType.ClickBackCode);
    L18:
        NewLiveProfileDialogFragment r12 = this.a;
        com.bytedance.android.live.profile.seeselftransition.a r13 = r12.n;
        if (r13 == null) goto L27;
        com.bytedance.android.live.profile.model.c r3 = r12.i;
        if (r3 == null) goto L23;
        ProfileMode r4 = r3.h;
    L25:
        if (r4 == ProfileMode.NONE) goto L27;
        r2 = true;
        goto L27
    L23:
        r4 = null;
    L27:
        if (r2 == false) goto L35;
        if (r13 == null) goto L36;
        com.bytedance.android.live.profile.model.c r14 = r12.i;
        if (r14 == null) goto L32;
        r1 = r14.h;
    L32:
        if (r1 != null) goto L34;
        r1 = ProfileMode.NEVER;
    L34:
        r13.a(r1, r12);
    L36:
        return true;
    L35:
        r12.T90().prepareExit();
        goto L36
    L40:
        return false;
    L38:
        return false;
    L9:
        r9 = null;
        goto L10
    L5:
        r8 = null;
        goto L6
    }
}
