package com.bytedance.android.live.liveinteract.plantform.core;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class l0 implements uf0.a {
    public l0() {
    }

    @Override // uf0.a
    public final void Ba(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    @Override // uf0.a
    public final void Ff(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    @Override // uf0.a
    public final void If() {
    }

    @Override // uf0.a
    public final void L2(String r1, Throwable r2) {
    }

    @Override // uf0.b
    public final void b2(com.bytedance.android.live.network.response.e<com.bytedance.android.livesdk.link.model.bridge.i0> r2) {
        Intrinsics.checkNotNullParameter(r2, "response");
    }

    @Override // uf0.a
    public void e6(String r1, IBaseUser r2, com.bytedance.android.livesdk.chatroom.interact.model.v r3) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r3, "result");
    }

    @Override // uf0.a
    public final void eo(z0 r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }

    @Override // uf0.a
    public final void k5(String r1, Throwable r2) {
    }

    @Override // uf0.a
    public void l(String r1, Throwable r2) {
    }

    @Override // uf0.b
    public final void l0(Throwable r1) {
    }

    @Override // uf0.b
    public final void m0(Throwable r1) {
    }

    @Override // uf0.a
    public void onPermitSuccess(String r1) {
    }

    @Override // uf0.b
    public final void u0() {
    }

    @Override // uf0.a
    public final void vf(ILinkMicGuideMessageBridge r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
    }
}
