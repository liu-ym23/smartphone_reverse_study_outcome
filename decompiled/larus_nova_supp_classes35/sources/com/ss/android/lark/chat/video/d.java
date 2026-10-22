package com.ss.android.lark.chat.video;

import com.ss.android.lark.player.player.v;
import com.ss.android.lark.player.widget.VideoView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements h.f {
    public final /* synthetic */ InnerVideoPreviewFragment a;

    public d(InnerVideoPreviewFragment r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chat.video.h.f
    public final void onPlay() {
        InnerVideoPreviewFragment r0 = this.a;
        VideoView r1 = r0.h;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.e() == false) goto L9;
        r1.h();
        v r2 = r1.a;
        if (r2.f() == false) goto L12;
        r2.a.h();
        return;
    L12:
        return;
    L9:
        r0.S90(false);
    }
}
