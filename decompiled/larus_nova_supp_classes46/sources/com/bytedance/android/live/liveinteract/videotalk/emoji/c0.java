package com.bytedance.android.live.liveinteract.videotalk.emoji;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c0 implements rj0.a {
    public final /* synthetic */ VideoShowMode a;
    public final /* synthetic */ VideoShowMode b;
    public final /* synthetic */ m00.g c;

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
        m00.g r0 = this.c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return new vc0.a(r0);
    }

    @Override // rj0.a
    public final void onCancel() {
        if (this.b != VideoShowMode.DIGIT_AVATAR) goto L9;
        DigitAvatarContext r0 = DigitAvatarContext.Companion.getContext();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.getRestoreDigitAvatar();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.TRUE);
    L9:
        DigitAvatarContext r2 = DigitAvatarContext.Companion.getContext();
        if (r2 == null) goto L13;
        DigitAvatarContext.setVideoShowMode$default(r2, this.b, null, 2, null);
        return;
    }

    @Override // rj0.a
    public final void onConfirm() {
        DigitAvatarContext r0 = DigitAvatarContext.Companion.getContext();
        if (r0 == null) goto L6;
        DigitAvatarContext.setVideoShowMode$default(r0, this.a, null, 2, null);
        return;
    }

    @Override // rj0.a
    public final String getConfirmText() {
        return s1.B(2131920806);
    }

    public c0(VideoShowMode r1, VideoShowMode r2, m00.g r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
