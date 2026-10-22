package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n implements rj0.a {
    public final /* synthetic */ LinkPKAudienceInteractDynamicEmojiDialog a;
    public final /* synthetic */ m00.g b;

    @Override // rj0.a
    public final boolean a() {
        return true;
    }

    @Override // rj0.a
    public final boolean b() {
        return false;
    }

    @Override // rj0.a
    public final void c() {
    }

    @Override // rj0.a
    public final String getCancelText() {
        return "";
    }

    @Override // rj0.a
    public final vc0.a getSurfaceView() {
        m00.g r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return new vc0.a(r0);
    }

    @Override // rj0.a
    public final void onCancel() {
        m00.g r0 = this.b;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.a.z5(1, true);
    }

    @Override // rj0.a
    public final void onConfirm() {
        m00.g r0 = this.b;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.a.z5(1, true);
    }

    @Override // rj0.a
    public final String getConfirmText() {
        return s1.B(2131920806);
    }

    public n(LinkPKAudienceInteractDynamicEmojiDialog r1, m00.g r2) {
        this.a = r1;
        this.b = r2;
    }
}
