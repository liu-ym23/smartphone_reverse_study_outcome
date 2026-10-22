package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.livesdk.message.model.ReplyType;
import hh1.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements rj0.a {
    public final /* synthetic */ e a;

    @Override // rj0.a
    public final boolean a() {
        return false;
    }

    @Override // rj0.a
    public final boolean b() {
        return true;
    }

    @Override // rj0.a
    public final void c() {
    }

    @Override // rj0.a
    public final String getCancelText() {
        return "";
    }

    @Override // rj0.a
    public final String getConfirmText() {
        return "";
    }

    @Override // rj0.a
    public final vc0.a getSurfaceView() {
        v0 r0 = this.a.a.ga("", false);
        if (r0 == null) goto L9;
        com.bytedance.android.live.pushstream.d r2 = r0.getLiveStream();
        if (r2 == null) goto L8;
        r2.f1("pk audience open beauty dialog", new uv0.a(LiveRequestSourceRole.Business, "BasePkInteractGuestWidget.getSurfaceView", null));
    L8:
        return new vc0.a(r0);
    L9:
        return null;
    }

    @Override // rj0.a
    public final void onCancel() {
        e r0 = this.a;
        q r2 = r0.a.b;
        if (r2 == null) goto L6;
        long r3 = r0.c;
        String r5 = r0.d;
        int r6 = ReplyType.Reject.ordinal();
        e r1 = this.a;
        r2.g(r3, r5, r6, r1.b, r1.a.xq());
        return;
    }

    @Override // rj0.a
    public final void onConfirm() {
        BasePkInteractGuestWidget r0 = this.a.a;
        r0.j = System.currentTimeMillis();
        BasePkInteractGuestWidget r1 = this.a.a;
        r1.i = System.currentTimeMillis();
        e r2 = this.a;
        BasePkInteractGuestWidget r3 = r2.a;
        r3.k = "invite";
        q r4 = r3.b;
        if (r4 == null) goto L5;
        r4.g(r2.c, r2.d, r2.e, r2.b, r3.xq());
    L5:
        dl0.m.B(dl0.m.a, "check_link_permission_success");
    }

    public d(e r1) {
        this.a = r1;
    }
}
