package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.livesdk.config.w50;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements rj0.a {
    public final /* synthetic */ b a;
    public final /* synthetic */ m00.g b;

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
    public final String getConfirmText() {
        return "";
    }

    @Override // rj0.a
    public final String getCancelText() {
        if (((Boolean) w50.a.getValue()).booleanValue() == true) goto L7;
        return "";
    L7:
        return s1.B(2131917565);
    }

    @Override // rj0.a
    public final vc0.a getSurfaceView() {
        m00.g r0 = this.b;
        if (r0 == null) goto L7;
        com.bytedance.android.live.pushstream.d r1 = r0.getLiveStream();
        if (r1 == null) goto L7;
        r1.f1("pk audience open beauty dialog", new uv0.a(LiveRequestSourceRole.Business, "BasePkInteractGuestWidget.getSurfaceView", null));
    L7:
        m00.g r2 = this.b;
        if (r2 != null) goto L10;
        return null;
    L10:
        return new vc0.a(r2);
    }

    @Override // rj0.a
    public final void onCancel() {
        m00.g r0 = this.b;
        if (r0 == null) goto L6;
        r0.release();
    L6:
        if (((Boolean) w50.a.getValue()).booleanValue() == false) goto L11;
        dl0.m.B(dl0.m.a, "check_link_permission_cancel");
        b r1 = this.a;
        q r2 = r1.a.b;
        if (r2 == null) goto L12;
        q.b(r2, 2, r1.c, r1.d, r1.e, r1.f);
        return;
    L12:
        return;
    }

    @Override // rj0.a
    public final void onConfirm() {
        b r0 = this.a;
        BasePkInteractGuestWidget r1 = r0.a;
        r1.k = "invite";
        q r3 = r1.b;
        if (r3 == null) goto L5;
        q.b(r3, r0.b, r0.c, r0.d, r0.e, r0.f);
    L5:
        dl0.m.B(dl0.m.a, "check_link_permission_success");
        m00.g r2 = this.b;
        if (r2 == null) goto L9;
        r2.release();
        return;
    }

    public a(b r1, m00.g r2) {
        this.a = r1;
        this.b = r2;
    }
}
