package com.bytedance.android.live.liveinteract.feed;

import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.bgComponent.theme.VideoThemeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d0 extends com.bytedance.android.live.liveinteract.videotalk.ui.theme.a {
    @Override // com.bytedance.android.live.liveinteract.videotalk.ui.theme.a
    public final boolean q() {
        return je0.d.i0(((com.bytedance.android.live.ui.c) this).m, true);
    }

    public d0(boolean r11, HSImageView r12, HSImageView r13, VideoThemeView r14, com.bytedance.android.live.ui.a r15, int r16) {
        if ((r16 & 2) == 0) goto L5;
        HSImageView r4 = null;
    L7:
        if ((r16 & 4) == 0) goto L9;
        HSImageView r5 = null;
    L11:
        if ((r16 & 8) == 0) goto L13;
        VideoThemeView r6 = null;
    L15:
        if ((r16 & 64) == 0) goto L17;
        com.bytedance.android.live.ui.a r9 = null;
    L18:
        super(r11, r4, r5, r6, null, null, r9);
        return;
    L17:
        r9 = r15;
        goto L18
    L13:
        r6 = r14;
        goto L15
    L9:
        r5 = r13;
        goto L11
    L5:
        r4 = r12;
        goto L7
    }
}
