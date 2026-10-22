package com.bytedance.android.live.liveinteract.feed;

import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.bgComponent.theme.VideoThemeView;
import com.bytedance.android.livesdk.config.s11;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends com.bytedance.android.live.ui.c {
    public final int h() {
        if (((s11) vm2.d.w7.getValue(null, vm2.d.a[435(0x1b3, float:6.1E-43)])).audioPlaceHolder == false) goto L5;
        return 0;
    L5:
        return 2131248875;
    }

    public final boolean q() {
        return com.bytedance.android.livesdk.model.k.c(((com.bytedance.android.live.ui.c) this).m);
    }

    public final IVoiceLiveTheme g() {
        return com.bytedance.android.livesdk.model.k.a();
    }

    public a(boolean r10, HSImageView r11, HSImageView r12, VideoThemeView r13, com.bytedance.android.live.ui.a r14) {
        super(r10, true, r11, r12, r13, null, null, r14);
    }
}
