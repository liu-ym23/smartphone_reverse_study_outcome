package com.bytedance.android.livesdk.chatroom.vs_host.impl;

import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a0 implements vr1.x, com.bytedance.android.scope.o {
    public a0() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // vr1.x
    public final boolean f() {
        return VrUtils.B();
    }

    @Override // vr1.x
    public final boolean c(DataCenter r1) {
        return VrUtils.c(r1);
    }

    @Override // vr1.x
    public final boolean d(DataCenter r2) {
        return VrUtils.u(r2, true);
    }

    @Override // vr1.x
    public final boolean g(DataCenter r1) {
        return VrUtils.y(r1);
    }

    @Override // vr1.x
    public final boolean isVrCamera(DataCenter r1) {
        return VrUtils.w(r1);
    }

    @Override // vr1.x
    public final boolean a(DataCenter r1, boolean r2) {
        return VrUtils.t(r1, r2);
    }
}
