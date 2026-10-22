package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l extends g {
    public final m f;

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int b() {
        return 1;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final int d() {
        return 0;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final String j() {
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final Object c() {
        return this.f;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g
    public final void k(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        Object r3 = r2.getTag();
        if (r3 == null) goto L9;
        VideoShowMode r4 = (VideoShowMode) r3;
        if (r4 == this.f.b) goto L10;
        this.e.L(this, r4);
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.kmp.live.livelink.api.model.VideoShowMode");
    }

    public l(q0 r2, m r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "extra");
        super(r2);
        this.f = r3;
    }
}
