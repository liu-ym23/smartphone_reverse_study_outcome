package com.bytedance.android.live.revlink.impl.multianchor.utils;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revlink.impl.global.LinkFakeGlobalService;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b0 {
    public final com.bytedance.android.live.revlink.impl.global.c a;

    public final com.bytedance.android.live.revlink.impl.mergepk.pkmulti.b a() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Q1();
    }

    public final com.bytedance.android.live.revlink.impl.mergepk.pkbase.e b() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Ig();
    }

    public final long c() {
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r0 = b();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getPkId();
    }

    public final PlayMode d() {
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r0 = b();
        if (r0 == null) goto L7;
        LiveData<PlayMode> r1 = r0.getTeamMode();
        if (r1 == null) goto L7;
        return (PlayMode) r1.getValue();
    L7:
        return null;
    }

    public final PkBaseStateMachine.c e() {
        if (a() == null) goto L11;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r0 = b();
        if (r0 == null) goto L9;
        PkBaseStateMachine.c r1 = r0.getCurPKBaseState();
        if (r1 == null) goto L9;
        return r1;
    L9:
        return PkBaseStateMachine.c.a.d;
    L11:
        return PkBaseStateMachine.c.a.d;
    }

    public b0(LinkFakeGlobalService r1) {
        this.a = r1;
    }
}
