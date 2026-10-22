package com.bytedance.android.live.liveinteract.videotalk.emoji;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b0 implements rj0.a {
    public final /* synthetic */ VideoShowMode a;

    @Override // rj0.a
    public final boolean a() {
        return false;
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
    public final void onConfirm() {
    }

    @Override // rj0.a
    public final vc0.a getSurfaceView() {
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 == null) goto L7;
        m00.g r1 = r0.hh();
        if (r1 == null) goto L7;
        return new vc0.a(r1);
    L7:
        return null;
    }

    @Override // rj0.a
    public final void onCancel() {
        DigitAvatarContext r0 = DigitAvatarContext.Companion.getContext();
        if (r0 == null) goto L6;
        DigitAvatarContext.setVideoShowMode$default(r0, this.a, null, 2, null);
        return;
    }

    @Override // rj0.a
    public final String getConfirmText() {
        return s1.B(2131920806);
    }

    public b0(VideoShowMode r1) {
        this.a = r1;
    }
}
